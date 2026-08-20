package com.gremath.curriculum;

public record NzLessonSpec(
        int order,
        String title,
        String strand,
        String contentHtml,
        String practiceKey,
        String wordStrategy,
        String practiceKind
) {
}
