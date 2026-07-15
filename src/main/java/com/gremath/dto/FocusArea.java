package com.gremath.dto;

public class FocusArea {
    private final String lessonTitle;
    private final String topicSlug;
    private final String lessonKey;
    private final int averagePercent;
    private final int attempts;
    private final String guidance;

    public FocusArea(String lessonTitle, String topicSlug, String lessonKey, int averagePercent, int attempts, String guidance) {
        this.lessonTitle = lessonTitle;
        this.topicSlug = topicSlug;
        this.lessonKey = lessonKey;
        this.averagePercent = averagePercent;
        this.attempts = attempts;
        this.guidance = guidance;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public String getTopicSlug() {
        return topicSlug;
    }

    public String getLessonKey() {
        return lessonKey;
    }

    public int getAveragePercent() {
        return averagePercent;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getGuidance() {
        return guidance;
    }

    public String getPracticeHref() {
        if (lessonKey == null || lessonKey.isBlank()) {
            return topicSlug == null ? "/dashboard" : "/topics/" + topicSlug;
        }
        return "/practice/lesson/" + lessonKey;
    }
}
