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
        sb.append(Doc.recap(recap));
        sb.append(Doc.reference("Original LetusLearn teaching organised to the New Zealand Curriculum "
                + "year-by-year teaching sequence on <em>Tāhūrangi</em> (English and Mathematics &amp; Statistics "
                + "Years 0–10, 2025). Official statements stay with the Ministry of Education."));
        return sb.toString();
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
