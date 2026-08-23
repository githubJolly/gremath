package com.gremath.curriculum;

/**
 * Simple SVGs for science and social sciences. Original LetusLearn drawings.
 */
public final class SubjectFigures {

    private SubjectFigures() {
    }

    public static String wrap(String caption, String svg) {
        return MathFigures.wrap(caption, svg);
    }

    public static String fairTest(String caption) {
        String svg = svg(400, 140)
                + box(20, 30, 110, 80, "#dbeafe", "Brand A")
                + box(150, 30, 110, 80, "#dbeafe", "Brand B")
                + box(280, 30, 100, 80, "#fde68a", "Same water")
                + text(200, 20, "Change only the brand", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String foodChain(String caption) {
        String svg = svg(420, 110)
                + box(16, 30, 100, 50, "#bbf7d0", "harakeke")
                + arrow(120, 55, 150, 55)
                + box(154, 30, 90, 50, "#fde68a", "insect")
                + arrow(248, 55, 278, 55)
                + box(282, 30, 120, 50, "#fdba74", "pīwakawaka")
                + text(210, 100, "arrows show energy flow (who eats)", 11, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String statesOfMatter(String caption) {
        String svg = svg(400, 130)
                + dots(40, 40, 3, 3, 10, "#0284c7")
                + text(70, 115, "solid", 12, "#0f172a")
                + dots(170, 30, 3, 4, 16, "#0ea5e9")
                + text(200, 115, "liquid", 12, "#0f172a")
                + dots(300, 24, 4, 4, 22, "#7dd3fc")
                + text(330, 115, "gas", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String forceArrows(String caption) {
        String svg = svg(360, 100)
                + "<rect x='140' y='35' width='80' height='40' rx='8' fill='#fdba74' stroke='#9a3412'/>"
                + "<line x1='40' y1='55' x2='130' y2='55' stroke='#0284c7' stroke-width='4'/>"
                + "<polygon points='130,55 112,48 112,62' fill='#0284c7'/>"
                + text(80, 40, "push", 12, "#0369a1")
                + "<line x1='320' y1='55' x2='230' y2='55' stroke='#ea580c' stroke-width='4'/>"
                + "<polygon points='230,55 248,48 248,62' fill='#ea580c'/>"
                + text(280, 40, "pull", 12, "#c2410c")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String dayNight(String caption) {
        String svg = svg(360, 140)
                + "<circle cx='70' cy='70' r='28' fill='#fbbf24'/>"
                + text(70, 124, "Sun", 12, "#92400e")
                + "<circle cx='240' cy='70' r='40' fill='#38bdf8'/>"
                + "<path d='M 240 30 A 40 40 0 0 1 240 110' fill='#1e3a8a'/>"
                + text(200, 70, "day", 11, "#0f172a")
                + text(278, 70, "night", 11, "#e0f2fe")
                + text(240, 128, "Earth rotates", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String mapKey(String caption) {
        String svg = svg(320, 130)
                + "<rect x='20' y='16' width='280' height='100' rx='10' fill='#fff7ed' stroke='#fdba74'/>"
                + text(160, 36, "Map key", 14, "#9a3412")
                + "<circle cx='50' cy='62' r='8' fill='#16a34a'/>"
                + text(130, 66, "forest", 12, "#0f172a")
                + "<rect x='42' y='86' width='16' height='16' fill='#0284c7'/>"
                + text(130, 98, "lake", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String timeline(String caption) {
        String svg = svg(400, 90)
                + "<line x1='30' y1='45' x2='370' y2='45' stroke='#0f172a' stroke-width='3'/>"
                + "<circle cx='80' cy='45' r='7' fill='#ea580c'/>"
                + text(80, 72, "c. 1250", 11, "#334155")
                + "<circle cx='200' cy='45' r='7' fill='#0284c7'/>"
                + text(200, 72, "1840", 12, "#0f172a")
                + "<circle cx='320' cy='45' r='7' fill='#16a34a'/>"
                + text(320, 72, "today", 11, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String needsWants(String caption) {
        String svg = svg(360, 120)
                + box(24, 24, 140, 72, "#bbf7d0", "Need: food")
                + box(196, 24, 140, 72, "#fde68a", "Want: game")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String civicRules(String caption) {
        String svg = svg(360, 120)
                + box(24, 24, 140, 72, "#dbeafe", "Rights")
                + box(196, 24, 140, 72, "#fde68a", "Duties")
                + text(180, 112, "They travel together", 12, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String storyBook(String caption) {
        String svg = svg(360, 130)
                + "<rect x='70' y='20' width='90' height='90' rx='4' fill='#f97316' stroke='#9a3412'/>"
                + "<rect x='160' y='20' width='90' height='90' rx='4' fill='#fdba74' stroke='#9a3412'/>"
                + text(115, 70, "once", 13, "#fff7ed")
                + text(205, 70, "upon", 13, "#7c2d12")
                + text(180, 124, "a story", 12, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String speechTurn(String caption) {
        String svg = svg(360, 120)
                + "<ellipse cx='110' cy='50' rx='70' ry='32' fill='#dbeafe' stroke='#1d4ed8'/>"
                + text(110, 55, "I think…", 13, "#1e3a8a")
                + "<ellipse cx='250' cy='78' rx='74' ry='28' fill='#bbf7d0' stroke='#166534'/>"
                + text(250, 83, "because…", 13, "#14532d")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String designBrief(String caption) {
        String svg = svg(360, 120)
                + box(20, 20, 100, 70, "#dbeafe", "User")
                + box(130, 20, 100, 70, "#fde68a", "Problem")
                + box(240, 20, 100, 70, "#bbf7d0", "Idea")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String musicNotes(String caption) {
        String svg = svg(360, 110)
                + "<line x1='40' y1='40' x2='320' y2='40' stroke='#334155' stroke-width='2'/>"
                + "<line x1='40' y1='55' x2='320' y2='55' stroke='#334155' stroke-width='2'/>"
                + "<line x1='40' y1='70' x2='320' y2='70' stroke='#334155' stroke-width='2'/>"
                + "<circle cx='90' cy='70' r='10' fill='#0f172a'/>"
                + "<circle cx='160' cy='40' r='10' fill='#0f172a'/>"
                + "<circle cx='240' cy='55' r='10' fill='#0f172a'/>"
                + text(180, 100, "beat  ·  pitch  ·  dynamic", 12, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String hauoraTaha(String caption) {
        String svg = svg(360, 140)
                + "<circle cx='180' cy='64' r='48' fill='#fef3c7' stroke='#d97706'/>"
                + text(180, 58, "hauora", 13, "#92400e")
                + text(80, 30, "tinana", 11, "#166534")
                + text(280, 30, "hinengaro", 11, "#1d4ed8")
                + text(80, 120, "whānau", 11, "#9a3412")
                + text(280, 120, "wairua", 11, "#7c3aed")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String greetingKiaOra(String caption) {
        String svg = svg(360, 110)
                + box(30, 24, 140, 56, "#bbf7d0", "Kia ora")
                + box(190, 24, 140, 56, "#dbeafe", "Tēnā koe")
                + text(180, 100, "hello  ·  one person", 12, "#334155")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String moveSkill(String caption) {
        String svg = svg(360, 110)
                + "<circle cx='70' cy='40' r='12' fill='#fdba74' stroke='#9a3412'/>"
                + "<line x1='70' y1='52' x2='70' y2='80' stroke='#9a3412' stroke-width='3'/>"
                + "<line x1='70' y1='60' x2='50' y2='72' stroke='#9a3412' stroke-width='3'/>"
                + "<line x1='70' y1='60' x2='96' y2='54' stroke='#9a3412' stroke-width='3'/>"
                + "<circle cx='200' cy='55' r='18' fill='#38bdf8' stroke='#0369a1'/>"
                + text(200, 60, "ball", 11, "#0c4a6e")
                + text(300, 60, "eyes ready", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String safetyFlags(String caption) {
        String svg = svg(360, 120)
                + "<rect x='40' y='24' width='14' height='80' fill='#78716c'/>"
                + "<polygon points='54,24 120,40 54,56' fill='#ef4444'/>"
                + "<rect x='200' y='24' width='14' height='80' fill='#78716c'/>"
                + "<polygon points='214,24 280,40 214,56' fill='#ef4444'/>"
                + text(160, 112, "Swim between the flags", 12, "#0f172a")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String plantParts(String caption) {
        String svg = svg(280, 160)
                + "<ellipse cx='140' cy='36' rx='36' ry='16' fill='#86efac' stroke='#166534'/>"
                + text(140, 40, "leaf", 11, "#14532d")
                + "<rect x='132' y='50' width='16' height='54' fill='#15803d'/>"
                + text(190, 80, "stem", 11, "#14532d")
                + "<path d='M 140 104 Q 90 140 70 150' stroke='#a16207' stroke-width='4' fill='none'/>"
                + "<path d='M 140 104 Q 190 140 210 150' stroke='#a16207' stroke-width='4' fill='none'/>"
                + text(140, 156, "roots", 11, "#92400e")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String waterCycle(String caption) {
        String svg = svg(400, 150)
                + "<rect x='20' y='100' width='160' height='30' rx='8' fill='#38bdf8'/>"
                + text(100, 120, "sea", 12, "#0c4a6e")
                + "<path d='M 100 100 Q 140 50 200 40' fill='none' stroke='#0284c7' stroke-width='3'/>"
                + text(168, 56, "evaporate", 11, "#0369a1")
                + "<ellipse cx='250' cy='36' rx='50' ry='18' fill='#cbd5e1'/>"
                + text(250, 40, "cloud", 11, "#334155")
                + "<line x1='300' y1='56' x2='320' y2='92' stroke='#0284c7' stroke-width='3'/>"
                + "<line x1='280' y1='56' x2='300' y2='92' stroke='#0284c7' stroke-width='3'/>"
                + text(340, 80, "rain", 11, "#0369a1")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String circuit(String caption) {
        String svg = svg(360, 120)
                + "<rect x='30' y='40' width='40' height='40' rx='6' fill='#fde68a' stroke='#b45309'/>"
                + text(50, 64, "cell", 11, "#92400e")
                + "<rect x='150' y='36' width='60' height='48' rx='8' fill='#fdba74' stroke='#9a3412'/>"
                + text(180, 64, "lamp", 11, "#7c2d12")
                + "<rect x='280' y='48' width='50' height='24' rx='6' fill='#86efac' stroke='#166534'/>"
                + text(305, 64, "on", 11, "#14532d")
                + "<line x1='70' y1='60' x2='150' y2='60' stroke='#0f172a' stroke-width='3'/>"
                + "<line x1='210' y1='60' x2='280' y2='60' stroke='#0f172a' stroke-width='3'/>"
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String storyMountain(String caption) {
        String svg = svg(400, 140)
                + "<polygon points='40,110 200,24 360,110' fill='#ffedd5' stroke='#c2410c'/>"
                + text(70, 124, "start", 11, "#9a3412")
                + text(200, 18, "problem", 11, "#9a3412")
                + text(330, 124, "end", 11, "#9a3412")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String sentenceParts(String caption) {
        String svg = svg(400, 110)
                + box(20, 28, 110, 50, "#dbeafe", "Who")
                + box(145, 28, 110, 50, "#fde68a", "did what")
                + box(270, 28, 110, 50, "#bbf7d0", "where")
                + "</svg>";
        return wrap(caption, svg);
    }

    public static String identityPlaces(String caption) {
        String svg = svg(360, 120)
                + "<polygon points='80,90 140,28 200,90' fill='#86efac' stroke='#166534'/>"
                + text(140, 110, "maunga", 12, "#14532d")
                + "<path d='M 230 40 Q 270 70 230 90 Q 290 70 320 90' fill='none' stroke='#0284c7' stroke-width='4'/>"
                + text(280, 110, "awa", 12, "#0c4a6e")
                + "</svg>";
        return wrap(caption, svg);
    }

    private static String svg(int w, int h) {
        return "<svg class='math-svg' viewBox='0 0 " + w + " " + h + "' width='" + w + "' height='" + h
                + "' role='img' xmlns='http://www.w3.org/2000/svg'>";
    }

    private static String box(int x, int y, int w, int h, String fill, String label) {
        return "<rect x='" + x + "' y='" + y + "' width='" + w + "' height='" + h
                + "' rx='10' fill='" + fill + "' stroke='#334155'/>"
                + text(x + w / 2.0, y + h / 2.0 + 4, label, 12, "#0f172a");
    }

    private static String arrow(int x1, int y1, int x2, int y2) {
        return "<line x1='" + x1 + "' y1='" + y1 + "' x2='" + x2 + "' y2='" + y2
                + "' stroke='#0f172a' stroke-width='2'/>"
                + "<polygon points='" + x2 + "," + y2 + " " + (x2 - 8) + "," + (y2 - 5) + " " + (x2 - 8) + "," + (y2 + 5)
                + "' fill='#0f172a'/>";
    }

    private static String dots(int x, int y, int rows, int cols, int gap, String fill) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append("<circle cx='").append(x + c * gap).append("' cy='").append(y + r * gap)
                        .append("' r='5' fill='").append(fill).append("'/>");
            }
        }
        return sb.toString();
    }

    private static String text(double x, double y, String value, int size, String fill) {
        return "<text x='" + x + "' y='" + y + "' text-anchor='middle' font-size='" + size
                + "' font-family='Nunito,Segoe UI,sans-serif' fill='" + fill + "' font-weight='700'>"
                + value.replace("&", "&amp;").replace("<", "&lt;") + "</text>";
    }
}
