package com.gremath.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremath.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StripeCheckoutService {
    private static final String STRIPE_API_BASE = "https://api.stripe.com/v1";

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper;
    private final String secretKey;
    private final String webhookSecret;
    private final String appBaseUrl;

    public StripeCheckoutService(ObjectMapper objectMapper,
                                 @Value("${stripe.secret-key:}") String secretKey,
                                 @Value("${stripe.webhook-secret:}") String webhookSecret,
                                 @Value("${app.base-url:http://localhost:8080}") String appBaseUrl) {
        this.objectMapper = objectMapper;
        this.secretKey = secretKey;
        this.webhookSecret = webhookSecret;
        this.appBaseUrl = appBaseUrl;
    }

    public String createCheckoutSession(Student student, String plan) {
        ensureStripeConfigured();
        String normalized = normalizePlan(plan);
        int amountCents = amountCents(normalized);
        String label = planLabel(normalized);

        String successUrl = UriComponentsBuilder.fromHttpUrl(appBaseUrl)
                .path("/billing/success")
                .queryParam("session_id", "{CHECKOUT_SESSION_ID}")
                .build(false)
                .toUriString();
        String cancelUrl = UriComponentsBuilder.fromHttpUrl(appBaseUrl)
                .path("/billing/checkout")
                .queryParam("plan", normalized)
                .queryParam("cancelled", "1")
                .build()
                .toUriString();

        Map<String, String> form = new LinkedHashMap<>();
        form.put("mode", "subscription");
        form.put("success_url", successUrl);
        form.put("cancel_url", cancelUrl);
        form.put("client_reference_id", String.valueOf(student.getId()));
        if (student.getEmail() != null && !student.getEmail().isBlank()) {
            form.put("customer_email", student.getEmail());
        }
        form.put("metadata[studentId]", String.valueOf(student.getId()));
        form.put("metadata[plan]", normalized);
        form.put("line_items[0][quantity]", "1");
        form.put("line_items[0][price_data][currency]", "usd");
        form.put("line_items[0][price_data][unit_amount]", String.valueOf(amountCents));
        form.put("line_items[0][price_data][recurring][interval]", "month");
        form.put("line_items[0][price_data][product_data][name]", label);

        Map<String, Object> response = postForm("/checkout/sessions", form);
        Object checkoutUrl = response.get("url");
        if (checkoutUrl == null || checkoutUrl.toString().isBlank()) {
            throw new IllegalStateException("Stripe did not return a checkout URL.");
        }
        return checkoutUrl.toString();
    }

    public CheckoutSession retrieveCheckoutSession(String sessionId) {
        ensureStripeConfigured();
        Map<String, Object> response = get("/checkout/sessions/" + urlEncodePath(sessionId));
        return toCheckoutSession(response);
    }

    public boolean isValidWebhookSignature(String payload, String signatureHeader) {
        if (webhookSecret == null || webhookSecret.isBlank()) {
            return false;
        }
        if (signatureHeader == null || signatureHeader.isBlank()) {
            return false;
        }

        String timestamp = null;
        String v1 = null;
        for (String part : signatureHeader.split(",")) {
            String[] pieces = part.split("=", 2);
            if (pieces.length != 2) {
                continue;
            }
            if ("t".equals(pieces[0])) {
                timestamp = pieces[1];
            } else if ("v1".equals(pieces[0])) {
                v1 = pieces[1];
            }
        }
        if (timestamp == null || v1 == null) {
            return false;
        }
        long eventTime = Long.parseLong(timestamp);
        if (Math.abs(Instant.now().getEpochSecond() - eventTime) > 300) {
            return false;
        }

        String signedPayload = timestamp + "." + payload;
        String expected = hmacSha256Hex(webhookSecret, signedPayload);
        return MessageDigest.isEqual(expected.getBytes(StandardCharsets.UTF_8), v1.getBytes(StandardCharsets.UTF_8));
    }

    public Map<String, Object> parsePayload(String payload) {
        try {
            return objectMapper.readValue(payload, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid Stripe webhook JSON.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public CheckoutSession sessionFromWebhookEvent(Map<String, Object> event) {
        Object data = event.get("data");
        if (!(data instanceof Map<?, ?> dataMap)) {
            throw new IllegalArgumentException("Stripe event missing data object.");
        }
        Object object = dataMap.get("object");
        if (!(object instanceof Map<?, ?> objectMap)) {
            throw new IllegalArgumentException("Stripe event missing session object.");
        }
        return toCheckoutSession((Map<String, Object>) objectMap);
    }

    public boolean isCheckoutCompletedEvent(Map<String, Object> event) {
        return "checkout.session.completed".equals(event.get("type"));
    }

    private Map<String, Object> postForm(String path, Map<String, String> form) {
        String body = form.entrySet().stream()
                .map(entry -> urlEncode(entry.getKey()) + "=" + urlEncode(entry.getValue()))
                .reduce((left, right) -> left + "&" + right)
                .orElse("");
        HttpRequest request = HttpRequest.newBuilder(URI.create(STRIPE_API_BASE + path))
                .header("Authorization", "Bearer " + secretKey)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return send(request);
    }

    private Map<String, Object> get(String path) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(STRIPE_API_BASE + path))
                .header("Authorization", "Bearer " + secretKey)
                .GET()
                .build();
        return send(request);
    }

    private Map<String, Object> send(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> parsed = objectMapper.readValue(response.body(), new TypeReference<>() {
            });
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                Object error = parsed.get("error");
                throw new IllegalStateException("Stripe request failed: " + error);
            }
            return parsed;
        } catch (IOException e) {
            throw new IllegalStateException("Could not call Stripe.", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Stripe request was interrupted.", e);
        }
    }

    @SuppressWarnings("unchecked")
    private CheckoutSession toCheckoutSession(Map<String, Object> session) {
        String id = stringValue(session.get("id"));
        String paymentStatus = stringValue(session.get("payment_status"));
        String clientReferenceId = stringValue(session.get("client_reference_id"));
        String plan = null;
        Object metadata = session.get("metadata");
        if (metadata instanceof Map<?, ?> metadataMap) {
            plan = stringValue(((Map<String, Object>) metadataMap).get("plan"));
        }
        return new CheckoutSession(id, normalizePlan(plan), paymentStatus, clientReferenceId);
    }

    private void ensureStripeConfigured() {
        if (secretKey == null || secretKey.isBlank()) {
            throw new IllegalStateException("Stripe secret key is not configured. Set STRIPE_SECRET_KEY.");
        }
    }

    private String hmacSha256Hex(String secret, String payload) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] digest = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            StringBuilder out = new StringBuilder();
            for (byte b : digest) {
                out.append(String.format("%02x", b));
            }
            return out.toString();
        } catch (Exception e) {
            throw new IllegalStateException("Could not verify Stripe webhook signature.", e);
        }
    }

    private String normalizePlan(String plan) {
        return "class6-nz".equalsIgnoreCase(plan) ? "class6-nz" : "gre-cat";
    }

    private int amountCents(String plan) {
        return "class6-nz".equals(plan) ? 1000 : 2000;
    }

    private String planLabel(String plan) {
        return "class6-nz".equals(plan) ? "LetusLearn NZ Curriculum Track" : "LetusLearn GRE/CAT Track";
    }

    private String stringValue(Object value) {
        return value == null ? null : value.toString();
    }

    private String urlEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    private String urlEncodePath(String value) {
        return urlEncode(value).replace("+", "%20");
    }

    public record CheckoutSession(String id, String plan, String paymentStatus, String clientReferenceId) {
    }
}

