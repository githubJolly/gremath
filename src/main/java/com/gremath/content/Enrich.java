/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.content;

import com.gremath.content.Doc;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;
import java.util.regex.Pattern;

public final class Enrich {
    private static final String FLOW_MARKER = "Lesson-specific solve flow for ";
    private static final String CONSISTENCY_MARKER = "consistency-pass-v1";
    private static final Pattern DEEP_KEY_BLOCK = Pattern.compile("<div class=\"callout c-key\">.*?Deep-dive checklist for.*?</div>", 32);
    private static final Pattern DEEP_STEP_BLOCK = Pattern.compile("<ol class=\"steps\">.*?Spot the trigger words first\\..*?Do one reverse-check:.*?</ol>", 32);
    private static final Pattern DEEP_TIP_BLOCK = Pattern.compile("<div class=\"callout c-tip\">.*?Exam speed comes from pattern recognition \\+ a fixed solving routine\\..*?</div>", 32);

    private Enrich() {
    }

    public static void lesson(Topic t, int index, String practiceKey, String referenceHtml, String wordStrategy) {
        Lesson l = t.getLessons().get(index);
        String focus = Enrich.cleanTitle(l.getTitle());
        if (referenceHtml != null && !referenceHtml.isBlank()) {
            l.setContent(l.getContent() + referenceHtml);
        }
        l.setPracticeKey(practiceKey);
        l.setWordStrategy(Enrich.strategyForLesson(focus, practiceKey, wordStrategy));
    }

    public static String adaptStrategy(String lessonTitle, String practiceKey, String currentStrategy) {
        String merged = Enrich.strategyForLesson(Enrich.cleanTitle(lessonTitle), practiceKey, currentStrategy);
        return Enrich.trimDuplicateLessonFlow(merged);
    }

    /**
     * Builds a compact strategy block for one specific sheet. The text is derived from the
     * actual questions on that sheet (count, type mix, difficulty mix) and the lesson focus,
     * so it differs from sheet to sheet and from lesson to lesson. The full lesson-level
     * strategy stays on the lesson landing page; it is intentionally not repeated here.
     */
    public static String sheetStrategy(String lessonTitle, String practiceKey, String baseStrategy,
                                       boolean wordSheet, String sheetLabel,
                                       java.util.List<String> difficulties, java.util.List<String> tags) {
        String focus = Enrich.cleanTitle(lessonTitle);
        int easy = 0;
        int medium = 0;
        int hard = 0;
        for (String d : difficulties) {
            if (d == null) {
                continue;
            }
            switch (d.trim().toUpperCase()) {
                case "EASY": {
                    ++easy;
                    break;
                }
                case "HARD": {
                    ++hard;
                    break;
                }
                default: {
                    ++medium;
                }
            }
        }
        java.util.LinkedHashMap<String, Integer> tagCounts = new java.util.LinkedHashMap<String, Integer>();
        for (String t : tags) {
            if (t == null || t.isBlank()) {
                continue;
            }
            tagCounts.merge(t.trim(), 1, Integer::sum);
        }
        int total = difficulties.size();
        int wordLike = tagCounts.getOrDefault("word problem", 0) + tagCounts.getOrDefault("complex word problem", 0);

        StringBuilder mix = new StringBuilder();
        boolean first = true;
        for (java.util.Map.Entry<String, Integer> e : tagCounts.entrySet()) {
            if (!first) {
                mix.append(", ");
            }
            mix.append("<strong>").append(e.getValue()).append("</strong> ").append(e.getKey());
            first = false;
        }

        java.util.List<String> diffParts = new java.util.ArrayList<String>();
        if (easy > 0) {
            diffParts.add(easy + " easy");
        }
        if (medium > 0) {
            diffParts.add(medium + " medium");
        }
        if (hard > 0) {
            diffParts.add(hard + " hard");
        }
        String diff = String.join(", ", diffParts);

        String approach = wordLike * 2 >= total && total > 0
                ? "Most items here are scenarios \u2014 translate each story into one clean equation before you compute."
                : "These are mostly direct drills \u2014 lead with quick pattern recognition and the core relation: <strong>" + Enrich.formulaHint(practiceKey) + "</strong>.";
        String pacing = hard > 0
                ? "Bank time on the easier questions so you can give the " + hard + " hard one" + (hard == 1 ? "" : "s") + " extra thought."
                : "Keep a steady rhythm \u2014 aim for accuracy at speed.";

        String head = "On this <strong>" + (sheetLabel == null || sheetLabel.isBlank() ? "sheet" : sheetLabel)
                + "</strong> for <strong>" + focus + "</strong> you have <strong>" + total + "</strong> question" + (total == 1 ? "" : "s")
                + (mix.length() > 0 ? " (" + mix + ")" : "")
                + (diff.length() > 0 ? ". Difficulty mix: " + diff : "")
                + ". " + approach + " " + pacing;

        return Doc.tip(head)
                + Doc.warn("Common trap here: " + Enrich.trapHint(practiceKey)
                        + ". Need the method? Tap <strong>Show hint</strong> under any question.");
    }

    public static String compactLessonContent(String html) {
        if (html == null || html.isBlank()) {
            return html;
        }
        String out = DEEP_KEY_BLOCK.matcher(html).replaceAll("");
        out = DEEP_STEP_BLOCK.matcher(out).replaceAll("");
        out = DEEP_TIP_BLOCK.matcher(out).replaceAll("");
        return out;
    }

    public static String normalizeLessonContent(String lessonTitle, int orderIndex, String html) {
        if (html == null || html.isBlank()) {
            return html;
        }
        String out = Enrich.compactLessonContent(html).replaceAll("(?s)\\s{2,}", " ").replaceAll(">\\s+<", "><").trim();
        if (out.contains(CONSISTENCY_MARKER)) {
            return out;
        }
        String level = Enrich.levelFor(orderIndex);
        String cleanTitle = Enrich.cleanTitle(lessonTitle);
        String intro = "<!-- consistency-pass-v1 -->" + Doc.recap("Learning level: <strong>" + level + "</strong>. Suggested flow for <strong>" + cleanTitle + "</strong>: read concept \u2192 solve worked examples \u2192 attempt a timed sheet.");
        return intro + out;
    }

    private static String cleanTitle(String title) {
        if (title == null) {
            return "this lesson";
        }
        return title.replaceFirst("^\\d+\\.\\s*", "").trim();
    }

    private static String deepDiveBlock(String focus, String practiceKey) {
        return Doc.key("Deep-dive checklist for <strong>" + focus + "</strong>: identify the data, pick the right model, and check the final answer with units/logic.") + Doc.steps("Spot the trigger words first. For this lesson, the key trigger is: <strong>" + Enrich.triggerHint(practiceKey) + "</strong>.", "Write the minimal setup before calculating (equation, ratio, table, sample space, or formula).", "Solve in small steps and estimate once to ensure the final value is sensible.", "Do one reverse-check: plug the answer back or verify it satisfies the condition in the question.") + Doc.tip("Exam speed comes from pattern recognition + a fixed solving routine. Use the same routine on every sheet.");
    }

    private static String strategyForLesson(String focus, String practiceKey, String baseStrategy) {
        String starter = (baseStrategy == null || baseStrategy.isBlank())
                ? "<p>This strategy is tuned to <strong>" + focus + "</strong>.</p>"
                : baseStrategy;
        if (starter.contains(FLOW_MARKER)) {
            return starter;
        }
        return starter
                + "<p><strong>Lesson-specific solve flow for " + focus + ":</strong></p>"
                + Doc.steps("Recognize the pattern quickly: <strong>" + Enrich.triggerHint(practiceKey) + "</strong>.",
                "Use this core relation first: <strong>" + Enrich.formulaHint(practiceKey) + "</strong>.",
                "Convert story text into symbols/values in one line before computing.",
                "After solving, verify with a quick sanity check (range, sign, units, and context).")
                + Doc.warn("Common trap in this lesson: " + Enrich.trapHint(practiceKey));
    }

    private static String trimDuplicateLessonFlow(String html) {
        int first = html.indexOf(FLOW_MARKER);
        if (first < 0) {
            return html;
        }
        int second = html.indexOf(FLOW_MARKER, first + FLOW_MARKER.length());
        if (second < 0) {
            return html;
        }
        return html.substring(0, second).trim();
    }

    private static String levelFor(int orderIndex) {
        if (orderIndex <= 2) {
            return "Foundation";
        }
        if (orderIndex <= 4) {
            return "Intermediate";
        }
        return "Advanced";
    }

    private static String triggerHint(String practiceKey) {
        if (practiceKey == null) {
            return "identify what is asked and what is given";
        }
        if (practiceKey.startsWith("np-")) {
            return "divisibility/factors/remainders/power-cycle keywords";
        }
        if (practiceKey.startsWith("ratio-")) {
            return "part-to-part or part-to-whole language";
        }
        if (practiceKey.startsWith("avg-")) {
            return "average, total, group merge, or mixture clues";
        }
        if (practiceKey.startsWith("alg-")) {
            return "unknown value statements and equation/inequality clues";
        }
        if (practiceKey.startsWith("geo-")) {
            return "shape, angle, area, perimeter, volume, or coordinate clues";
        }
        if (practiceKey.startsWith("tsd-")) {
            return "distance-speed-time, relative motion, train, or stream clues";
        }
        if (practiceKey.startsWith("cnt-")) {
            return "counting words: arrange, choose, select, committee, order";
        }
        if (practiceKey.startsWith("prob-")) {
            return "chance language: likely, at least one, and/or, given";
        }
        if (practiceKey.startsWith("pli-")) {
            return "money words: CP/SP, percent gain/loss, SI/CI, discount";
        }
        if (practiceKey.startsWith("pct-")) {
            return "percentage change and base-value clues";
        }
        return "key nouns and operation words in the problem statement";
    }

    private static String formulaHint(String practiceKey) {
        if (practiceKey == null) {
            return "translate to one clean equation first";
        }
        if (practiceKey.startsWith("np-")) {
            return "factorization / HCF-LCM / modular remainder relation";
        }
        if (practiceKey.startsWith("ratio-")) {
            return "part value = total \u00f7 (sum of ratio parts)";
        }
        if (practiceKey.startsWith("avg-")) {
            return "total = average \u00d7 count (and alligation for mixtures)";
        }
        if (practiceKey.startsWith("alg-")) {
            return "set up equation(s), isolate variable, and verify";
        }
        if (practiceKey.startsWith("geo-")) {
            return "draw and apply the exact geometric formula once";
        }
        if (practiceKey.startsWith("tsd-")) {
            return "distance = speed \u00d7 time (plus relative speed rules)";
        }
        if (practiceKey.startsWith("cnt-")) {
            return "multiply stages; use nPr/nCr depending on order";
        }
        if (practiceKey.startsWith("prob-")) {
            return "P = favourable/total; complement/AND/OR/conditional as needed";
        }
        if (practiceKey.startsWith("pli-")) {
            return "convert percentages to multipliers before final arithmetic";
        }
        if (practiceKey.startsWith("pct-")) {
            return "new value = base \u00d7 (1 \u00b1 p/100)";
        }
        return "build the shortest correct equation for the given story";
    }

    private static String trapHint(String practiceKey) {
        if (practiceKey == null) {
            return "solving before defining the unknown clearly";
        }
        if (practiceKey.startsWith("np-")) {
            return "mixing up divisibility rules and remainder constraints";
        }
        if (practiceKey.startsWith("ratio-")) {
            return "adding ratio numbers directly to real quantities";
        }
        if (practiceKey.startsWith("avg-")) {
            return "taking simple mean when weighted/equal-distance logic is needed";
        }
        if (practiceKey.startsWith("alg-")) {
            return "sign mistakes while moving terms";
        }
        if (practiceKey.startsWith("geo-")) {
            return "using perimeter formula where area/volume is asked";
        }
        if (practiceKey.startsWith("tsd-")) {
            return "wrong relative-speed operation (add vs subtract)";
        }
        if (practiceKey.startsWith("cnt-")) {
            return "using permutation where combination is required";
        }
        if (practiceKey.startsWith("prob-")) {
            return "forgetting overlap subtraction in OR problems";
        }
        if (practiceKey.startsWith("pli-")) {
            return "taking profit/loss percentage on SP instead of CP";
        }
        if (practiceKey.startsWith("pct-")) {
            return "using old base after the base has changed";
        }
        return "not checking whether the final answer matches the question's unit and context";
    }
}

