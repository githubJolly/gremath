package com.gremath.curriculum;

import com.gremath.content.Doc;

/**
 * Shared layout for detailed NZ Curriculum lessons: goals, explanation, Aotearoa context,
 * method, worked examples, common mistakes, recap, and official alignment.
 */
public final class LessonHtml {

    private LessonHtml() {
    }

    public static String phaseLabel(int year) {
        if (year <= 3) {
            return "Phase 1 · Years 0–3 · Year " + year;
        }
        if (year <= 6) {
            return "Phase 2 · Years 4–6 · Year " + year;
        }
        if (year <= 8) {
            return "Phase 3 · Years 7–8 · Year " + year;
        }
        return "Phase 4 · Years 9–10 · Year " + year;
    }

    public static String bandName(int year) {
        if (year <= 3) {
            return "Junior primary";
        }
        if (year <= 6) {
            return "Upper primary";
        }
        if (year <= 8) {
            return "Intermediate";
        }
        return "Junior secondary";
    }

    public static String teach(String phase, String strand, String[] goals, String meaningHtml,
                               String aotearoa, String[] steps, String ex1Title, String ex1,
                               String ex2Title, String ex2, String tableHtml, String watchOut,
                               String tip, String recap, String vocab) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p class='lesson-phase'><span class='badge badge-class6'>").append(phase)
                .append("</span> <span class='strand-chip'>").append(strand).append("</span></p>");
        sb.append("<div class='learn-goals'><span class='callout-title'>You will learn</span><ul>");
        for (String g : goals) {
            sb.append("<li>").append(g).append("</li>");
        }
        sb.append("</ul></div>");
        sb.append("<h3>What this idea means</h3>");
        sb.append(meaningHtml);
        if (aotearoa != null && !aotearoa.isBlank()) {
            sb.append(Doc.analogy(aotearoa));
        }
        sb.append("<h3>How to work it out</h3>");
        sb.append(Doc.steps(steps));
        if (tableHtml != null && !tableHtml.isBlank()) {
            sb.append(tableHtml);
        }
        sb.append(Doc.example("Worked example · " + ex1Title, ex1));
        sb.append(Doc.example("Worked example · " + ex2Title, ex2));
        sb.append(Doc.warn(watchOut));
        sb.append(Doc.tip(tip));
        if (vocab != null && !vocab.isBlank()) {
            sb.append(Doc.key("<strong>Words to own:</strong> " + vocab));
        }
        sb.append(examAsk(strand));
        sb.append(Doc.recap(recap));
        sb.append(Doc.reference("Original LetusLearn teaching organised to the New Zealand Curriculum "
                + "year-by-year teaching sequence on <em>Tāhūrangi</em> (English and Mathematics &amp; Statistics "
                + "Years 0–10, 2025). Practice items are original and written in the styles used by "
                + "<em>PAT Pāngarau</em> (NZCER), <em>NCEA Numeracy CAA 32406</em> (NZQA), and "
                + "<em>Figure It Out</em> (Ministry of Education) — not copied from those publications."));
        return sb.toString();
    }

    /** Typical item styles from NZ assessments, rewritten as original LetusLearn prompts. */
    public static String examAsk(String strand) {
        String s = strand == null ? "" : strand.toLowerCase();
        String[] items;
        if (s.contains("rational") || s.contains("fraction")) {
            items = new String[]{
                    "PAT-style: match a shaded bar or number line to a fraction, decimal or percent.",
                    "NCEA Numeracy: find a discount, unit price or GST from a shop table, then explain the calculation.",
                    "Figure It Out: share a quantity in a ratio (part:part) and check the parts sum to the whole."
            };
        } else if (s.contains("operation")) {
            items = new String[]{
                    "PAT-style: evaluate a mixed expression (GEMA) or an integer jump on a number line.",
                    "NCEA Numeracy: temperature change, account balance, or elapsed time across midday.",
                    "Figure It Out: multi-step story — estimate first, then compute, then interpret a remainder."
            };
        } else if (s.contains("algebra") || s.contains("taurangi")) {
            items = new String[]{
                    "PAT-style: continue a growing pattern, then write the n-rule and test two terms.",
                    "NCEA Numeracy: form a one-step equation from a ticket + fee story and solve it.",
                    "Figure It Out: plot a table on a grid and say whether the points look linear."
            };
        } else if (s.contains("measure") || s.contains("ine")) {
            items = new String[]{
                    "PAT-style: read a scale or choose cm / m / cm² / cm³ for a labelled diagram.",
                    "NCEA Numeracy: compound area (L-shape), timetable duration, or convert mixed units.",
                    "Figure It Out: estimate first (finger ≈ 1 cm, pace ≈ 1 m), then calculate perimeter or volume."
            };
        } else if (s.contains("geometry") || s.contains("āhuahanga") || s.contains("ahuahanga")) {
            items = new String[]{
                    "PAT-style: classify a triangle or quadrilateral from marked properties, not from how it looks.",
                    "NCEA Numeracy: find a missing angle on a diagram (triangle sum, straight line, or point).",
                    "Figure It Out: describe a reflection, rotation or translation on a grid and name the image."
            };
        } else if (s.contains("statistic") || s.contains("tauanga")) {
            items = new String[]{
                    "PAT-style: read a bar, pictograph or table — including a key where 1 picture = 2.",
                    "NCEA Numeracy: decide if a claim matches the graph; mention sample size or a misleading scale.",
                    "Figure It Out: choose mean, median or mode and say why that average fits the question."
            };
        } else if (s.contains("probab") || s.contains("tūponotanga") || s.contains("tupono")) {
            items = new String[]{
                    "PAT-style: P(event) from a fair spinner, die or bag — favourable ÷ total.",
                    "NCEA Numeracy: experimental relative frequency from a trial table, then compare with theoretical P.",
                    "Figure It Out: list the sample space first; use a complement or a two-stage tree."
            };
        } else if (s.contains("number") || s.contains("tau")) {
            items = new String[]{
                    "PAT-style: expanded form, rounding, or compare two numbers from the left-most place.",
                    "NCEA Numeracy: interpret a large figure (population, distance) or a negative in context.",
                    "Figure It Out: primes, HCF/LCM or a factor tree that feeds a later fraction problem."
            };
        } else {
            items = new String[]{
                    "PAT-style: a short skill item with one clear answer.",
                    "NCEA Numeracy: a real-life table or diagram, then explain your method.",
                    "Figure It Out: a contextual investigation — show working, not only the final number."
            };
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='callout c-exam'><span class='callout-title'>How assessments ask this</span>");
        sb.append("<p>Original LetusLearn items, written in the same <em>kinds</em> of question used in ");
        sb.append("PAT Pāngarau, NCEA Numeracy CAA, and Figure It Out. We do not reproduce those papers.</p><ul>");
        for (String item : items) {
            sb.append("<li>").append(item).append("</li>");
        }
        return sb.append("</ul></div>").toString();
    }

    public static String strategy(String strand, String[] steps, String trap) {
        return "<p>Use this routine on every <strong>" + strand.toLowerCase() + "</strong> task.</p>"
                + Doc.steps(steps)
                + Doc.warn("Common trap: " + trap)
                + Doc.tip("If you are stuck, tap Show hint — it points to the method, not the answer.");
    }

    public static String p(String text) {
        return "<p>" + text + "</p>";
    }

    public static String h4(String title) {
        return "<h4>" + title + "</h4>";
    }

    public static String worked(String title, String html) {
        return Doc.example("Worked example · " + title, html);
    }

    /** Line-by-line method so students can see every inverse step. */
    public static String lines(String... steps) {
        StringBuilder sb = new StringBuilder("<p>");
        for (int i = 0; i < steps.length; i++) {
            if (i > 0) {
                sb.append("<br/>");
            }
            sb.append(steps[i]);
        }
        return sb.append("</p>").toString();
    }

    public static String table(String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder("<table class='lesson-table'><thead><tr>");
        for (String h : headers) {
            sb.append("<th>").append(h).append("</th>");
        }
        sb.append("</tr></thead><tbody>");
        for (String[] row : rows) {
            sb.append("<tr>");
            for (String cell : row) {
                sb.append("<td>").append(cell).append("</td>");
            }
            sb.append("</tr>");
        }
        return sb.append("</tbody></table>").toString();
    }
}
