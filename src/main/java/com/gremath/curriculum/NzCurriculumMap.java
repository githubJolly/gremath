package com.gremath.curriculum;

import java.util.List;

/**
 * NZ Curriculum pathway map aligned to Tāhūrangi learning areas (Years 1–10).
 */
public final class NzCurriculumMap {

    private NzCurriculumMap() {
    }

    public static List<Integer> years() {
        return NzCurriculumCatalog.years();
    }

    public static List<String> subjects() {
        return List.of(
                NzSubject.MATHEMATICS.displayName(),
                NzSubject.ENGLISH.displayName(),
                NzSubject.SCIENCE.displayName(),
                NzSubject.SOCIAL_SCIENCES.displayName(),
                NzSubject.TECHNOLOGY.displayName(),
                NzSubject.THE_ARTS.displayName(),
                NzSubject.HEALTH_PE.displayName(),
                NzSubject.LEARNING_LANGUAGES.displayName()
        );
    }

    public static List<SubjectCard> cardsForYear(int year) {
        return java.util.Arrays.stream(NzSubject.values())
                .map(subject -> card(year, subject))
                .toList();
    }

    private static SubjectCard card(int year, NzSubject subject) {
        String href = NzCurriculumCatalog.topicHref(year, subject);
        int lessons = NzCurriculumCatalog.lessonCount(year, subject);
        boolean featured = NzCurriculumCatalog.isHandcrafted(year, subject);
        return new SubjectCard(
                year,
                subject.displayName(),
                subject.slug(),
                subject.blurb(),
                true,
                href,
                "Open lessons",
                "https://newzealandcurriculum.tahurangi.education.govt.nz/",
                subject.emoji(),
                subject.themeClass(),
                subject.accent(),
                lessons,
                featured
        );
    }

    public record SubjectCard(int year, String subject, String slug, String blurb, boolean available, String href,
                              String cta, String curriculumUrl, String emoji, String themeClass, String accent,
                              int lessonCount, boolean featured) {
    }
}
