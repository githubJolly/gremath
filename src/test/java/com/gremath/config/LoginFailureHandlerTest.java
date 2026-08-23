package com.gremath.config;

import com.gremath.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginFailureHandlerTest {
    private StudentRepository students;
    private LoginFailureHandler handler;

    @BeforeEach
    void setUp() {
        this.students = mock(StudentRepository.class);
        this.handler = new LoginFailureHandler(this.students);
    }

    @Test
    void unknownUsername() {
        when(this.students.existsByUsername("aria")).thenReturn(false);
        assertEquals("unknown", this.handler.classify("aria", "secret", new BadCredentialsException("bad")));
        assertEquals("We could not find an account with that username. Check the spelling, or start a free trial.",
                LoginFailureHandler.messageFor("unknown"));
    }

    @Test
    void wrongPassword() {
        when(this.students.existsByUsername("aria")).thenReturn(true);
        assertEquals("password", this.handler.classify("aria", "nope", new BadCredentialsException("bad")));
        assertEquals("That password is incorrect. Please try again.",
                LoginFailureHandler.messageFor("password"));
    }

    @Test
    void unverifiedEmail() {
        assertEquals("unverified", this.handler.classify("aria", "secret", new DisabledException("disabled")));
    }

    @Test
    void emailUsedInsteadOfUsername() {
        when(this.students.existsByUsername("aria@example.com")).thenReturn(false);
        when(this.students.existsByEmail("aria@example.com")).thenReturn(true);
        assertEquals("used-email", this.handler.classify("aria@example.com", "secret",
                new BadCredentialsException("bad")));
    }

    @Test
    void blankFields() {
        assertEquals("empty-user", this.handler.classify("  ", "secret", new BadCredentialsException("bad")));
        assertEquals("empty-pass", this.handler.classify("aria", "", new BadCredentialsException("bad")));
    }
}
