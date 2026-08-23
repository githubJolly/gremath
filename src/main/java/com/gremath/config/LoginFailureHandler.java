package com.gremath.config;

import com.gremath.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    public static final String LAST_USERNAME = "loginUsername";

    private final StudentRepository studentRepository;

    public LoginFailureHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.isBlank()) {
            request.getSession().setAttribute(LAST_USERNAME, username.trim());
        }
        String reason = classify(username, password, exception);
        response.sendRedirect(request.getContextPath() + "/login?error=" + reason);
    }

    String classify(String username, String password, AuthenticationException exception) {
        if (username == null || username.isBlank()) {
            return "empty-user";
        }
        if (password == null || password.isBlank()) {
            return "empty-pass";
        }
        if (exception instanceof DisabledException) {
            return "unverified";
        }
        String trimmed = username.trim();
        boolean knownUser = this.studentRepository.existsByUsername(trimmed);
        if (!knownUser && trimmed.contains("@") && this.studentRepository.existsByEmail(trimmed)) {
            return "used-email";
        }
        if (!knownUser) {
            return "unknown";
        }
        return "password";
    }

    public static String messageFor(String reason) {
        if (reason == null) {
            return null;
        }
        return switch (reason) {
            case "empty-user" -> "Enter your username.";
            case "empty-pass" -> "Enter your password.";
            case "unverified" ->
                    "Please verify your email before logging in. Check your inbox for the verification link.";
            case "used-email" ->
                    "That looks like an email address. Log in with the username you chose when you signed up.";
            case "unknown" ->
                    "We could not find an account with that username. Check the spelling, or start a free trial.";
            case "password" -> "That password is incorrect. Please try again.";
            case "", "true", "error" ->
                    "We could not log you in. Check your username and password and try again.";
            default -> "We could not log you in. Check your username and password and try again.";
        };
    }
}
