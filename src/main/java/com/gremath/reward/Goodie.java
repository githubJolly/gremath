package com.gremath.reward;

public record Goodie(String id, String name, String kind, String emoji, int rbxCost, int starsNeeded, String blurb) {
    public boolean isTitle() {
        return "title".equals(kind);
    }

    public boolean isPet() {
        return "pet".equals(kind);
    }

    public boolean isHat() {
        return "hat".equals(kind);
    }
}
