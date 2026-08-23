package com.gremath.reward;

/** Pure scoring for stars and in-app Rbx points. Not real Roblox Robux. */
public final class RewardRules {

    private RewardRules() {
    }

    public static int stars(int percentage) {
        int stars = 0;
        if (percentage >= 50) {
            stars++;
        }
        if (percentage >= 80) {
            stars++;
        }
        if (percentage >= 100) {
            stars++;
        }
        return stars;
    }

    public static int rbx(int score, int percentage, int streakDays, boolean firstToday) {
        int points = Math.max(0, score) * 8;
        if (percentage >= 80) {
            points += 20;
        }
        if (percentage >= 100) {
            points += 40;
        }
        if (score > 0 && percentage < 50) {
            points += 6;
        }
        if (firstToday) {
            points += 15;
        }
        points += Math.min(streakDays, 10) * 3;
        return points;
    }

    public static String cheer(int percentage, int streakDays, boolean firstToday) {
        StringBuilder sb = new StringBuilder();
        if (percentage >= 100) {
            sb.append("Perfect sheet! Legendary drop. ");
        } else if (percentage >= 80) {
            sb.append("Pro score — bonus Rbx unlocked. ");
        } else if (percentage >= 50) {
            sb.append("Solid run. Bank those stars. ");
        } else if (percentage > 0) {
            sb.append("You still earned practice Rbx. One more sheet? ");
        } else {
            sb.append("No stars this time — read the explanations and smash the retry. ");
        }
        if (firstToday) {
            sb.append("Daily login bonus +15 Rbx. ");
        }
        if (streakDays >= 2) {
            sb.append(streakDays).append("-day streak is glowing.");
        }
        return sb.toString().trim();
    }
}
