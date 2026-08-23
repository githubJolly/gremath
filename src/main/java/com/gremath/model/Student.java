/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Column
 *  jakarta.persistence.Entity
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String username;
    @Column(nullable=false)
    private String fullName;
    @Column(unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String role = "ROLE_STUDENT";
    @Column(nullable=false, columnDefinition="boolean default false")
    private boolean emailVerified = false;
    @Column(unique=true)
    private String emailVerificationToken;
    private LocalDateTime emailVerificationExpiresAt;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDate greCatSubscribedUntil;
    private LocalDate class6NzSubscribedUntil;
    /** End date of complimentary NZ curriculum trial (inclusive). */
    private LocalDate nzTrialUntil;
    private boolean nzTrialUsed;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int stars = 0;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int rbxPoints = 0;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int streakDays = 0;
    private LocalDate lastPracticeDate;
    @Column(length = 2000)
    private String unlockedGoodies = "";
    private String equippedTitle;
    private String equippedPet;
    private String equippedHat;
    private String parentEmail;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean parentNotifyEnabled = true;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmailVerificationToken() {
        return this.emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public LocalDateTime getEmailVerificationExpiresAt() {
        return this.emailVerificationExpiresAt;
    }

    public void setEmailVerificationExpiresAt(LocalDateTime emailVerificationExpiresAt) {
        this.emailVerificationExpiresAt = emailVerificationExpiresAt;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getGreCatSubscribedUntil() {
        return this.greCatSubscribedUntil;
    }

    public void setGreCatSubscribedUntil(LocalDate greCatSubscribedUntil) {
        this.greCatSubscribedUntil = greCatSubscribedUntil;
    }

    public LocalDate getClass6NzSubscribedUntil() {
        return this.class6NzSubscribedUntil;
    }

    public void setClass6NzSubscribedUntil(LocalDate class6NzSubscribedUntil) {
        this.class6NzSubscribedUntil = class6NzSubscribedUntil;
    }

    public LocalDate getNzTrialUntil() {
        return this.nzTrialUntil;
    }

    public void setNzTrialUntil(LocalDate nzTrialUntil) {
        this.nzTrialUntil = nzTrialUntil;
    }

    public boolean isNzTrialUsed() {
        return this.nzTrialUsed;
    }

    public void setNzTrialUsed(boolean nzTrialUsed) {
        this.nzTrialUsed = nzTrialUsed;
    }

    public boolean hasActiveGreCatSubscription() {
        return this.greCatSubscribedUntil != null && !this.greCatSubscribedUntil.isBefore(LocalDate.now());
    }

    /** Trial is active while today is strictly before the until date (2 full calendar days from signup). */
    public boolean hasActiveNzTrial() {
        return this.nzTrialUntil != null && this.nzTrialUntil.isAfter(LocalDate.now());
    }

    public boolean hasActiveClass6NzSubscription() {
        return (this.class6NzSubscribedUntil != null && !this.class6NzSubscribedUntil.isBefore(LocalDate.now()))
                || this.hasActiveNzTrial();
    }

    public boolean hasPaidNzSubscription() {
        return this.class6NzSubscribedUntil != null && !this.class6NzSubscribedUntil.isBefore(LocalDate.now());
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getRbxPoints() {
        return this.rbxPoints;
    }

    public void setRbxPoints(int rbxPoints) {
        this.rbxPoints = rbxPoints;
    }

    public int getStreakDays() {
        return this.streakDays;
    }

    public void setStreakDays(int streakDays) {
        this.streakDays = streakDays;
    }

    public LocalDate getLastPracticeDate() {
        return this.lastPracticeDate;
    }

    public void setLastPracticeDate(LocalDate lastPracticeDate) {
        this.lastPracticeDate = lastPracticeDate;
    }

    public String getUnlockedGoodies() {
        return this.unlockedGoodies == null ? "" : this.unlockedGoodies;
    }

    public void setUnlockedGoodies(String unlockedGoodies) {
        this.unlockedGoodies = unlockedGoodies;
    }

    public String getEquippedTitle() {
        return this.equippedTitle;
    }

    public void setEquippedTitle(String equippedTitle) {
        this.equippedTitle = equippedTitle;
    }

    public String getEquippedPet() {
        return this.equippedPet;
    }

    public void setEquippedPet(String equippedPet) {
        this.equippedPet = equippedPet;
    }

    public String getEquippedHat() {
        return this.equippedHat;
    }

    public void setEquippedHat(String equippedHat) {
        this.equippedHat = equippedHat;
    }

    public int getRewardLevel() {
        return 1 + this.stars / 8;
    }

    public boolean hasGoodie(String id) {
        if (id == null || getUnlockedGoodies().isBlank()) {
            return false;
        }
        for (String part : getUnlockedGoodies().split(",")) {
            if (id.equals(part.trim())) {
                return true;
            }
        }
        return false;
    }

    public String getParentEmail() {
        return this.parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public boolean isParentNotifyEnabled() {
        return this.parentNotifyEnabled;
    }

    public void setParentNotifyEnabled(boolean parentNotifyEnabled) {
        this.parentNotifyEnabled = parentNotifyEnabled;
    }

    /** Address that should receive progress reports (parent inbox, or the account email). */
    public String progressEmail() {
        if (this.parentEmail != null && !this.parentEmail.isBlank()) {
            return this.parentEmail.trim();
        }
        return this.email;
    }

    public void addGoodie(String id) {
        if (id == null || id.isBlank() || hasGoodie(id)) {
            return;
        }
        String current = getUnlockedGoodies();
        this.unlockedGoodies = current.isBlank() ? id : current + "," + id;
    }
}

