/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.validation.constraints.Email
 *  jakarta.validation.constraints.NotBlank
 *  jakarta.validation.constraints.Size
 */
package com.gremath.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationForm {
    @NotBlank(message="Username is required")
    @Size(min=3, max=30, message="Username must be 3-30 characters")
    private @NotBlank(message="Username is required") @Size(min=3, max=30, message="Username must be 3-30 characters") String username;
    @NotBlank(message="Full name is required")
    private @NotBlank(message="Full name is required") String fullName;
    @NotBlank(message="Email is required")
    @Email(message="Enter a valid email")
    private @NotBlank(message="Email is required") @Email(message="Enter a valid email") String email;
    @NotBlank(message="Password is required")
    @Size(min=6, message="Password must be at least 6 characters")
    private @NotBlank(message="Password is required") @Size(min=6, message="Password must be at least 6 characters") String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

