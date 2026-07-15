package com.gremath.curriculum;

import java.util.List;

/**
 * NZ Curriculum pathway map aligned to Tāhūrangi learning areas (Years 1–10).
 * Links to LetusLearn topics where content exists; other cells are pathway placeholders.
 */
public final class NzCurriculumMap {

    private NzCurriculumMap() {
    }

    public static List<Integer> years() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static List<String> subjects() {
        return List.of(
                "Mathematics and Statistics",
                "English",
                "Science",
                "Social Sciences",
                "Technology",
                "The Arts",
                "Health and Physical Education",
                "Learning Languages"
        );
    }

    public static List<SubjectCard> cardsForYear(int year) {
        return List.of(
                card(year, "Mathematics and Statistics", mathHref(year),
                        "Number, algebra, measurement, geometry, statistics and probability."),
                card(year, "English", englishHref(year),
                        "Reading, writing, oral language and structured literacy foundations."),
                card(year, "Science", scienceHref(year),
                        "Investigating the natural world, living systems, matter and forces."),
                card(year, "Social Sciences", null,
                        "People, places, histories and citizenship contexts."),
                card(year, "Technology", null,
                        "Design, digital technologies and making solutions."),
                card(year, "The Arts", null,
                        "Visual art, music, drama and dance exploration."),
                card(year, "Health and Physical Education", null,
                        "Wellbeing, movement and healthy communities."),
                card(year, "Learning Languages", null,
                        "Additional languages and communication skills.")
        );
    }

    private static SubjectCard card(int year, String subject, String href, String blurb) {
        boolean available = href != null && !href.isBlank();
        return new SubjectCard(year, subject, blurb, available, available ? href : null,
                available ? "Open lessons" : "Coming soon",
                "https://newzealandcurriculum.tahurangi.education.govt.nz/");
    }

    private static String mathHref(int year) {
        if (year == 6) {
            return "/topics/class6-nz-mathematics";
        }
        if (year == 7) {
            return "/topics/class7-nz-mathematics";
        }
        return null;
    }

    private static String englishHref(int year) {
        if (year == 6) {
            return "/topics/class6-nz-english";
        }
        return null;
    }

    private static String scienceHref(int year) {
        if (year == 6) {
            return "/topics/class6-nz-science";
        }
        return null;
    }

    public record SubjectCard(int year, String subject, String blurb, boolean available, String href,
                              String cta, String curriculumUrl) {
    }
}
