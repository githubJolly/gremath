package com.gremath.reward;

public record RewardPayout(int starsEarned, int rbxEarned, int streakDays, String message, String unlockedGoodie,
                           int totalStars, int totalRbx, int level) {
}
