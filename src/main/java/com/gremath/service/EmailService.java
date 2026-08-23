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
                        @Value("${app.mail.from:noreply@letuslearn.it.com}") String fromAddress,
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

                After you verify, parents receive an email each time a practice sheet is finished,
                with the latest score and a progress summary by subject.

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

    public void sendParentProgressEmail(String toEmail, String childName, String latestLine,
                                        String subjectTable, String focusLines, String wellLines,
                                        String dashboardUrl) {
        if (toEmail == null || toEmail.isBlank()) {
            return;
        }
        String name = childName == null || childName.isBlank() ? "your child" : childName;
        String subject = "LetusLearn update: " + name + " just practised";
        String body = """
                Hi,

                %s

                Progress by subject
                -------------------
                %s

                Needs a closer look
                -------------------
                %s

                Going well
                ----------
                %s

                Open the family dashboard:
                %s

                You are receiving this because this email is the parent inbox on the LetusLearn family account.
                """.formatted(latestLine, blank(subjectTable), blank(focusLines), blank(wellLines), dashboardUrl);

        sendPlain(toEmail, subject, body, "parent progress");
    }

    public void sendContactEmail(String name, String replyTo, String message) {
        String who = name == null || name.isBlank() ? "A visitor" : name.trim();
        String subject = "LetusLearn contact form: " + who;
        String body = """
                From: %s
                Reply-to: %s

                %s
                """.formatted(who, replyTo, message);
        sendPlain(fromAddress, subject, body, "contact");
    }

    private void sendPlain(String toEmail, String subject, String body, String kind) {
        JavaMailSender sender = mailSender.getIfAvailable();
        if (sender == null || mailHost == null || mailHost.isBlank()) {
            log.info("SMTP not configured. {} email to {}:\n{}", kind, toEmail, body);
            return;
        }
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromAddress);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            sender.send(message);
            log.info("{} email sent to {}", kind, toEmail);
        } catch (Exception ex) {
            log.error("Failed to send {} email to {}: {}", kind, toEmail, ex.getMessage());
            log.info("{} email body for {}:\n{}", kind, toEmail, body);
        }
    }

    private static String blank(String value) {
        return value == null || value.isBlank() ? "(none yet)" : value;
    }
}
