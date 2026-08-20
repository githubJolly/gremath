package com.gremath.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    private final ObjectProvider<JavaMailSender> mailSender;
    private final String appBaseUrl;
    private final String fromAddress;
    private final String mailHost;

    public EmailService(ObjectProvider<JavaMailSender> mailSender,
                        @Value("${app.base-url:http://localhost:8080}") String appBaseUrl,
                        @Value("${app.mail.from:noreply@gremath.local}") String fromAddress,
                        @Value("${spring.mail.host:}") String mailHost) {
        this.mailSender = mailSender;
        this.appBaseUrl = appBaseUrl;
        this.fromAddress = fromAddress;
        this.mailHost = mailHost;
    }

    public void sendVerificationEmail(String toEmail, String fullName, String token) {
        String verifyUrl = UriComponentsBuilder.fromHttpUrl(appBaseUrl)
                .path("/verify-email")
                .queryParam("token", token)
                .build(true)
                .toUriString();

        String subject = "Verify your LetusLearn email";
        String body = """
                Hi %s,

                Thanks for creating your account. Please verify your email address by opening this link:

                %s

                This link expires in 48 hours.

                If you did not create this account, you can ignore this email.
                """.formatted(fullName == null || fullName.isBlank() ? "there" : fullName, verifyUrl);

        JavaMailSender sender = mailSender.getIfAvailable();
        if (sender == null || mailHost == null || mailHost.isBlank()) {
            log.info("SMTP not configured. Verification email for {} would be sent to {}. Link: {}",
                    fullName, toEmail, verifyUrl);
            return;
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromAddress);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            sender.send(message);
            log.info("Verification email sent to {}", toEmail);
        } catch (Exception ex) {
            log.error("Failed to send verification email to {}: {}", toEmail, ex.getMessage());
            log.info("Verification link for {}: {}", toEmail, verifyUrl);
        }
    }
}
