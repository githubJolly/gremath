package com.gremath.curriculum;

import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.SheetType;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NzCurriculumCatalogTest {

    @Test
    void everyYearAndSubjectHasDetailedLessons() {
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                var lessons = NzCurriculumCatalog.lessons(year, subject);
                assertTrue(lessons.size() >= 6, year + " " + subject + " lesson count");
                for (NzLessonSpec spec : lessons) {
                    assertTrue(spec.contentHtml().length() > 1200,
                            "Thin lesson: Y" + year + " " + subject + " " + spec.title()
                                    + " len=" + spec.contentHtml().length());
                    assertTrue(spec.contentHtml().contains("You will"),
                            "Missing goals: " + spec.title());
                    int examples = count(spec.contentHtml(), "Worked example");
                    assertTrue(examples >= 3,
                            "Need 3+ worked examples: Y" + year + " " + subject + " " + spec.title()
                                    + " has " + examples);
                    int diagrams = count(spec.contentHtml(), "<svg");
                    assertTrue(diagrams >= 2,
                            "Need 2+ illustrations: Y" + year + " " + subject + " " + spec.title()
                                    + " has " + diagrams);
                    assertTrue(spec.practiceKey() != null && !spec.practiceKey().isBlank());
                }
            }
        }
    }

    @Test
    void year1NumberStaysInEarlyPlaceValue() {
        String html = NzCurriculumCatalog.lessons(1, NzSubject.MATHEMATICS).get(0).contentHtml();
        assertTrue(html.toLowerCase().contains("20"));
        assertFalse(html.contains("1,000,000"));
        assertTrue(html.contains("tahi") || html.contains("tekau"));
    }

    @Test
    void year9AlgebraShowsSubstitutionAndEliminationInFull() {
        String html = NzCurriculumCatalog.lessons(9, NzSubject.MATHEMATICS).stream()
                .filter(l -> l.title().toLowerCase().contains("simultaneous")
                        || l.contentHtml().toLowerCase().contains("elimination"))
                .map(NzLessonSpec::contentHtml)
                .findFirst()
                .orElse("");
        String lower = html.toLowerCase();
        assertTrue(html.length() > 3500, "Y9 simultaneous lesson should be detailed, len=" + html.length());
        assertTrue(lower.contains("substitution"), "missing substitution method");
        assertTrue(lower.contains("elimination"), "missing elimination method");
        assertTrue(lower.contains("multiply"), "missing multiply-first elimination");
        assertTrue(html.contains("Check") || lower.contains("check"));
    }

    @Test
    void year7AlgebraShowsTwoStepMethods() {
        String html = NzCurriculumCatalog.lessons(7, NzSubject.MATHEMATICS).stream()
                .filter(l -> l.title().toLowerCase().contains("algebra")
                        || l.title().toLowerCase().contains("equation"))
                .map(NzLessonSpec::contentHtml)
                .findFirst()
                .orElse("");
        String lower = html.toLowerCase();
        assertTrue(html.length() > 3000, "Y7 algebra should be elaborative, len=" + html.length());
        assertTrue(lower.contains("two-step") || lower.contains("subtract 3"));
        assertTrue(lower.contains("check"));
    }

    @Test
    void year8NumberIncludesIntegersAndPrimeFactors() {
        String html = NzCurriculumCatalog.lessons(8, NzSubject.MATHEMATICS).get(0).contentHtml();
        String lower = html.toLowerCase();
        assertTrue(lower.contains("prime") || lower.contains("integer") || lower.contains("exponent"));
    }

    @Test
    void year10MathIncludesTrigOrQuadratic() {
        String all = NzCurriculumCatalog.lessons(10, NzSubject.MATHEMATICS).stream()
                .map(NzLessonSpec::title)
                .reduce("", (a, b) -> a + " " + b)
                .toLowerCase();
        assertTrue(all.contains("trig") || all.contains("quadratic") || all.contains("cylinder"));
    }

    @Test
    void mathsHasEightLessonsExceptWhereSequenced() {
        for (int year : NzCurriculumCatalog.years()) {
            assertEquals(8, NzCurriculumCatalog.lessons(year, NzSubject.MATHEMATICS).size(), "Year " + year + " maths");
        }
    }

    @Test
    void year1AndYear6MathTitlesDiffer() {
        String y1 = NzCurriculumCatalog.lessons(1, NzSubject.MATHEMATICS).get(0).title();
        String y6 = NzCurriculumCatalog.lessons(6, NzSubject.MATHEMATICS).get(0).title();
        assertFalse(y1.equals(y6));
    }

    @Test
    void year7MathLessonsIncludeDiagramsAndExamStyles() {
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(7, NzSubject.MATHEMATICS)) {
            String html = spec.contentHtml();
            assertTrue(html.contains("<svg"), "Missing diagram: " + spec.title());
            assertTrue(html.contains("How assessments ask this"), "Missing exam styles: " + spec.title());
        }
    }

    @Test
    void everyYearMathLessonIncludesADiagram() {
        for (int year : NzCurriculumCatalog.years()) {
            for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, NzSubject.MATHEMATICS)) {
                assertTrue(spec.contentHtml().contains("<svg"),
                        "Year " + year + " " + spec.title() + " needs a diagram");
            }
        }
    }

    @Test
    void practiceSheetHintsAndStemsAreVaried() {
        PracticeRegistry registry = new PracticeRegistry();
        var lp = registry.get("nz-3-mathematics-1");
        com.gremath.practice.SheetService sheets = new com.gremath.practice.SheetService(registry);
        var questions = sheets.buildSheet("nz-3-mathematics-1", SheetType.CONCEPT, 2);
        assertTrue(questions.size() >= 8, "sheet too short: " + questions.size());
        java.util.Set<String> shapes = new java.util.HashSet<>();
        for (var q : questions) {
            shapes.add(com.gremath.practice.SheetService.fingerprint(q.getText()));
        }
        assertTrue(shapes.size() >= Math.min(6, questions.size() - 1),
                "stems too repetitive: " + shapes.size() + " unique of " + questions.size());
        java.util.Set<String> hints = com.gremath.practice.HintBank.newUsedSet();
        java.util.Set<String> seen = new java.util.HashSet<>();
        int uniqueHints = 0;
        for (int i = 0; i < questions.size(); i++) {
            String h = com.gremath.practice.HintBank.pick(lp.getKey(), questions.get(i), i, hints);
            if (seen.add(h)) {
                uniqueHints++;
            }
        }
        assertTrue(uniqueHints >= Math.min(8, questions.size()),
                "hints reused too often: " + uniqueHints + " unique");
    }

    @Test
    void illustratedPracticeQuestionsRenderSvg() {
        PracticeRegistry registry = new PracticeRegistry();
        java.util.Random rng = new java.util.Random(7);
        var q = registry.get("c7nz-geometry").templates(SheetType.CONCEPT).get(0).generate(rng);
        assertTrue(q.getText().contains("<svg"), "Year 7 geometry practice should include a diagram");
    }

    @Test
    void year6And7MathBanksEachHaveAnIllustratedStem() {
        PracticeRegistry registry = new PracticeRegistry();
        java.util.Random rng = new java.util.Random(11);
        String[] keys = {
                "c6nz-place-value", "c6nz-operations", "c6nz-fdp", "c6nz-patterns",
                "c6nz-geometry", "c6nz-measurement", "c6nz-data-chance", "c6nz-probability",
                "c7nz-exponents", "c7nz-primes-hcf", "c7nz-integers", "c7nz-fdp-finance",
                "c7nz-algebra", "c7nz-measurement", "c7nz-geometry", "c7nz-stats-prob"
        };
        for (String key : keys) {
            boolean anySvg = false;
            for (var template : registry.get(key).templates(SheetType.CONCEPT)) {
                if (template.generate(rng).getText().contains("<svg")) {
                    anySvg = true;
                    break;
                }
            }
            assertTrue(anySvg, key + " needs at least one illustrated stem");
        }
    }

    @Test
    void remainingSubjectsHaveDiagramsAndVariedPractice() {
        for (NzSubject subject : new NzSubject[]{
                NzSubject.ENGLISH, NzSubject.TECHNOLOGY, NzSubject.THE_ARTS,
                NzSubject.HEALTH_PE, NzSubject.LEARNING_LANGUAGES}) {
            for (NzLessonSpec spec : NzCurriculumCatalog.lessons(4, subject)) {
                assertTrue(spec.contentHtml().contains("<svg"),
                        "Year 4 " + subject + " " + spec.title() + " needs a diagram");
            }
        }
        PracticeRegistry registry = new PracticeRegistry();
        com.gremath.practice.SheetService sheets = new com.gremath.practice.SheetService(registry);
        for (String key : new String[]{"nz-4-english-2", "nz-5-the-arts-2", "nz-3-health-pe-1", "nz-6-learning-languages-1"}) {
            var questions = sheets.buildSheet(key, SheetType.CONCEPT, 1);
            assertTrue(questions.size() >= 8, key + " too short");
            java.util.Set<String> shapes = new java.util.HashSet<>();
            for (var q : questions) {
                shapes.add(com.gremath.practice.SheetService.fingerprint(q.getText()));
            }
            assertTrue(shapes.size() >= Math.min(6, questions.size() - 1),
                    key + " stems too repetitive: " + shapes.size());
        }
    }

    @Test
    void scienceAndSocialLessonsIncludeDiagrams() {
        for (int year : NzCurriculumCatalog.years()) {
            for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, NzSubject.SCIENCE)) {
                assertTrue(spec.contentHtml().contains("<svg"),
                        "Year " + year + " science " + spec.title() + " needs a diagram");
            }
            for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, NzSubject.SOCIAL_SCIENCES)) {
                assertTrue(spec.contentHtml().contains("<svg"),
                        "Year " + year + " social " + spec.title() + " needs a diagram");
            }
        }
    }

    @Test
    void scienceAndSocialSheetsHaveVariedStemsAndHints() {
        PracticeRegistry registry = new PracticeRegistry();
        com.gremath.practice.SheetService sheets = new com.gremath.practice.SheetService(registry);
        for (String key : new String[]{"nz-4-science-1", "nz-5-social-sciences-2"}) {
            var questions = sheets.buildSheet(key, SheetType.CONCEPT, 2);
            assertTrue(questions.size() >= 8, key + " sheet too short: " + questions.size());
            java.util.Set<String> shapes = new java.util.HashSet<>();
            for (var q : questions) {
                shapes.add(com.gremath.practice.SheetService.fingerprint(q.getText()));
            }
            assertTrue(shapes.size() >= Math.min(6, questions.size() - 1),
                    key + " stems too repetitive: " + shapes.size() + " unique of " + questions.size());
            java.util.Set<String> used = com.gremath.practice.HintBank.newUsedSet();
            java.util.Set<String> seen = new java.util.HashSet<>();
            int uniqueHints = 0;
            for (int i = 0; i < questions.size(); i++) {
                String h = com.gremath.practice.HintBank.pick(key, questions.get(i), i, used);
                if (seen.add(h)) {
                    uniqueHints++;
                }
            }
            assertTrue(uniqueHints >= Math.min(8, questions.size()),
                    key + " hints reused too often: " + uniqueHints + " unique");
        }
    }

    @Test
    void practiceKeysAreRegisteredAndGenerateQuestions() {
        PracticeRegistry registry = new PracticeRegistry();
        Random rng = new Random(42);
        int checked = 0;
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, subject)) {
                    assertTrue(registry.has(spec.practiceKey()),
                            "Missing practice for " + spec.practiceKey() + " / " + spec.title());
                    LessonPractice lp = registry.get(spec.practiceKey());
                    var q = lp.templates(SheetType.CONCEPT).get(0).generate(rng);
                    assertTrue(q.getOptions().size() >= 2);
                    checked++;
                }
            }
        }
        assertTrue(checked >= 10 * 8 * 6);
    }

    private static int count(String haystack, String needle) {
        int n = 0;
        int from = 0;
        while (true) {
            int i = haystack.indexOf(needle, from);
            if (i < 0) {
                return n;
            }
            n++;
            from = i + needle.length();
        }
    }
}
