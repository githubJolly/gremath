package com.gremath.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegistrationFormTest {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void matchingPasswordsAreValid() {
        assertTrue(validator.validate(filled("secret1", "secret1")).isEmpty());
    }

    @Test
    void mismatchedPasswordsAreRejected() {
        var violations = validator.validate(filled("secret1", "secret2"));
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v ->
                "Passwords do not match".equals(v.getMessage())));
    }

    @Test
    void confirmPasswordIsRequired() {
        var violations = validator.validate(filled("secret1", ""));
        assertTrue(violations.stream().anyMatch(v ->
                "Please confirm your password".equals(v.getMessage())));
    }

    private static RegistrationForm filled(String password, String confirmPassword) {
        RegistrationForm form = new RegistrationForm();
        form.setUsername("aria");
        form.setFullName("Aria");
        form.setEmail("aria@example.com");
        form.setPassword(password);
        form.setConfirmPassword(confirmPassword);
        return form;
    }
}
