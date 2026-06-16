/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.content;

import com.gremath.model.Question;
import java.util.ArrayList;
import java.util.List;

public final class Doc {
    private Doc() {
    }

    public static String analogy(String html) {
        return Doc.box("c-analogy", "\ud83c\udf1f Think of it like\u2026", html);
    }

    public static String example(String html) {
        return Doc.box("c-example", "\ud83d\udcdd Worked example", html);
    }

    public static String example(String title, String html) {
        return Doc.box("c-example", "\ud83d\udcdd " + title, html);
    }

    public static String tip(String html) {
        return Doc.box("c-tip", "\u2705 Handy tip", html);
    }

    public static String warn(String html) {
        return Doc.box("c-warn", "\u26a0\ufe0f Watch out", html);
    }

    public static String recap(String html) {
        return Doc.box("c-recap", "\ud83d\udd01 Quick recap", html);
    }

    public static String key(String html) {
        return Doc.box("c-key", "\ud83d\udd11 Remember this", html);
    }

    public static String reference(String html) {
        return Doc.box("c-ref", "\ud83d\udcda From the books", html);
    }

    public static String formula(String html) {
        return "<div class='formula'>" + html + "</div>";
    }

    public static String steps(String ... items) {
        StringBuilder sb = new StringBuilder("<ol class='steps'>");
        for (String item : items) {
            sb.append("<li>").append(item).append("</li>");
        }
        return sb.append("</ol>").toString();
    }

    private static String box(String cssClass, String title, String html) {
        return "<div class='callout " + cssClass + "'><span class='callout-title'>" + title + "</span>" + html + "</div>";
    }

    public static Question q(String text, List<String> options, int correct, String explanation, String difficulty) {
        return new Question(text, new ArrayList<String>(options), correct, explanation, difficulty);
    }
}

