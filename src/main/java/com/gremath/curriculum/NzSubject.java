package com.gremath.curriculum;

import java.util.Arrays;
import java.util.Optional;

/**
 * NZ Curriculum learning areas shown in LetusLearn, with kid-friendly presentation metadata.
 */
public enum NzSubject {
    MATHEMATICS("mathematics", "Mathematics and Statistics", "Number, algebra, measurement, geometry, statistics and probability.",
            "🔢", "math", "#2563EB"),
    ENGLISH("english", "English", "Oral language, reading and writing (structured literacy), then text and language studies in Years 9–10.",
            "📚", "english", "#D97706"),
    SCIENCE("science", "Science", "Nature of science plus living, material, physical, and Planet Earth and beyond — with Aotearoa contexts.",
            "🔬", "science", "#059669"),
    SOCIAL_SCIENCES("social-sciences", "Social Sciences", "People, places, histories and citizenship in Aotearoa New Zealand.",
            "🌏", "social", "#EA580C"),
    TECHNOLOGY("technology", "Technology", "Design, digital technologies and making solutions that help people.",
            "💡", "tech", "#4F46E5"),
    THE_ARTS("the-arts", "The Arts", "Visual art, music, drama and dance exploration.",
            "🎨", "arts", "#DB2777"),
    HEALTH_PE("health-pe", "Health and Physical Education", "Hauora, movement skills and healthy communities.",
            "⚽", "hpe", "#0D9488"),
    LEARNING_LANGUAGES("learning-languages", "Learning Languages", "Te reo Māori and communication skills for additional languages.",
            "🗣️", "languages", "#7C3AED");

    private final String slug;
    private final String displayName;
    private final String blurb;
    private final String emoji;
    private final String themeClass;
    private final String accent;

    NzSubject(String slug, String displayName, String blurb, String emoji, String themeClass, String accent) {
        this.slug = slug;
        this.displayName = displayName;
        this.blurb = blurb;
        this.emoji = emoji;
        this.themeClass = themeClass;
        this.accent = accent;
    }

    public String slug() {
        return slug;
    }

    public String displayName() {
        return displayName;
    }

    public String blurb() {
        return blurb;
    }

    public String emoji() {
        return emoji;
    }

    public String themeClass() {
        return themeClass;
    }

    public String accent() {
        return accent;
    }

    public static Optional<NzSubject> fromSlug(String slug) {
        if (slug == null) {
            return Optional.empty();
        }
        return Arrays.stream(values()).filter(s -> s.slug.equalsIgnoreCase(slug)).findFirst();
    }

    public static Optional<NzSubject> fromDisplayName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return Arrays.stream(values()).filter(s -> s.displayName.equalsIgnoreCase(name)).findFirst();
    }
}
