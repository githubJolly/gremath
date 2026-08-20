package com.gremath.curriculum;

import com.gremath.curriculum.lessons.NzMathLessons;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Complete Years 1–10 × 8 learning-area catalogue. Hand-crafted Class 6 Maths/English/Science
 * and Class 7 Maths keep their existing slugs; every other cell is generated from this map.
 */
public final class NzCurriculumCatalog {

    private NzCurriculumCatalog() {
    }

    public static List<Integer> years() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static boolean isHandcrafted(int year, NzSubject subject) {
        if (year == 6 && (subject == NzSubject.MATHEMATICS || subject == NzSubject.ENGLISH || subject == NzSubject.SCIENCE)) {
            return true;
        }
        return year == 7 && subject == NzSubject.MATHEMATICS;
    }

    public static String topicSlug(int year, NzSubject subject) {
        if (year == 6 && subject == NzSubject.MATHEMATICS) {
            return "class6-nz-mathematics";
        }
        if (year == 6 && subject == NzSubject.ENGLISH) {
            return "class6-nz-english";
        }
        if (year == 6 && subject == NzSubject.SCIENCE) {
            return "class6-nz-science";
        }
        if (year == 7 && subject == NzSubject.MATHEMATICS) {
            return "class7-nz-mathematics";
        }
        return "year" + year + "-" + subject.slug();
    }

    public static String examType(int year) {
        if (year == 6) {
            return "CLASS6_NZ";
        }
        if (year == 7) {
            return "CLASS7_NZ";
        }
        return "NZ_Y" + year;
    }

    public static String topicHref(int year, NzSubject subject) {
        return "/topics/" + topicSlug(year, subject);
    }

    public static int lessonCount(int year, NzSubject subject) {
        return lessons(year, subject).size();
    }

    public static String practiceKey(int year, NzSubject subject, int order) {
        if (subject == NzSubject.MATHEMATICS) {
            return NzMathLessons.practiceKey(year, order);
        }
        return "nz-" + year + "-" + subject.slug() + "-" + order;
    }

    public static Optional<YearSubject> fromTopicSlug(String slug) {
        if (slug == null) {
            return Optional.empty();
        }
        if ("class6-nz-mathematics".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.MATHEMATICS));
        }
        if ("class6-nz-english".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.ENGLISH));
        }
        if ("class6-nz-science".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.SCIENCE));
        }
        if ("class7-nz-mathematics".equals(slug)) {
            return Optional.of(new YearSubject(7, NzSubject.MATHEMATICS));
        }
        if (!slug.startsWith("year")) {
            return Optional.empty();
        }
        int dash = slug.indexOf('-');
        if (dash < 0) {
            return Optional.empty();
        }
        try {
            int year = Integer.parseInt(slug.substring(4, dash));
            return NzSubject.fromSlug(slug.substring(dash + 1)).map(s -> new YearSubject(year, s));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    public static OptionalInt yearFromExamType(String examType) {
        if (examType == null) {
            return OptionalInt.empty();
        }
        if ("CLASS6_NZ".equals(examType)) {
            return OptionalInt.of(6);
        }
        if ("CLASS7_NZ".equals(examType)) {
            return OptionalInt.of(7);
        }
        if (examType.startsWith("NZ_Y")) {
            try {
                return OptionalInt.of(Integer.parseInt(examType.substring(4)));
            } catch (NumberFormatException ex) {
                return OptionalInt.empty();
            }
        }
        return OptionalInt.empty();
    }

    public static List<NzLessonSpec> lessons(int year, NzSubject subject) {
        return switch (subject) {
            case MATHEMATICS -> com.gremath.curriculum.lessons.NzMathLessons.forYear(year);
            case ENGLISH -> com.gremath.curriculum.lessons.NzEnglishLessons.forYear(year);
            case SCIENCE -> com.gremath.curriculum.lessons.NzScienceLessons.forYear(year);
            case SOCIAL_SCIENCES -> com.gremath.curriculum.lessons.NzHumanitiesLessons.social(year);
            case TECHNOLOGY -> com.gremath.curriculum.lessons.NzHumanitiesLessons.technology(year);
            case THE_ARTS -> com.gremath.curriculum.lessons.NzHumanitiesLessons.arts(year);
            case HEALTH_PE -> com.gremath.curriculum.lessons.NzHumanitiesLessons.hpe(year);
            case LEARNING_LANGUAGES -> com.gremath.curriculum.lessons.NzHumanitiesLessons.languages(year);
        };
    }

    public static String topicName(int year, NzSubject subject) {
        return "Year " + year + " " + subject.displayName();
    }

    public static String topicDescription(int year, NzSubject subject) {
        String phase = com.gremath.curriculum.LessonHtml.phaseLabel(year);
        int n = lessonCount(year, subject);
        return "Year " + year + " · " + n + " detailed lessons for " + subject.displayName()
                + " (" + phase + "). Original LetusLearn teaching organised to the New Zealand Curriculum "
                + "year-by-year sequence. " + subject.blurb();
    }

    public record YearSubject(int year, NzSubject subject) {
    }
}
