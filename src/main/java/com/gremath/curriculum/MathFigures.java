package com.gremath.curriculum;

/**
 * Inline SVG diagrams for lessons and practice. Labels are escaped; figures are original
 * LetusLearn drawings (not scans from published papers).
 */
public final class MathFigures {

    private MathFigures() {
    }

    public static String ask(String prompt, String figureHtml) {
        return "<div class='q-stem'><p>" + prompt + "</p>" + figureHtml + "</div>";
    }

    public static String wrap(String caption, String svg) {
        return "<figure class='math-fig'>" + svg
                + "<figcaption class='fig-cap'>" + esc(caption) + "</figcaption></figure>";
    }

    public static String numberLine(int min, int max, Integer mark, String caption) {
        int n = max - min;
        int w = 420;
        int h = 78;
        double left = 28;
        double right = w - 28;
        StringBuilder ticks = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            int val = min + i;
            double x = left + (right - left) * i / n;
            ticks.append(line(x, 34, x, 46, "#334155", 1.6));
            ticks.append(text(x, 66, String.valueOf(val), 12, "#334155"));
            if (mark != null && val == mark) {
                ticks.append("<circle cx='").append(fmt(x)).append("' cy='40' r='7' fill='#ea580c'/>");
            }
        }
        String svg = svgOpen(w, h)
                + line(left, 40, right, 40, "#0f172a", 2.4)
                + poly(right + 8, 40, right - 2, 34, right - 2, 46)
                + ticks
                + svgClose();
        return wrap(caption, svg);
    }

    public static String integerJump(int start, int delta, String caption) {
        int min = Math.min(start, start + delta) - 2;
        int max = Math.max(start, start + delta) + 2;
        int n = max - min;
        int w = 420;
        double left = 28;
        double right = w - 28;
        double x0 = left + (right - left) * (start - min) / n;
        double x1 = left + (right - left) * (start + delta - min) / n;
        StringBuilder ticks = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            int val = min + i;
            double x = left + (right - left) * i / n;
            ticks.append(line(x, 48, x, 60, "#334155", 1.4));
            ticks.append(text(x, 78, String.valueOf(val), 11, "#334155"));
        }
        String svg = svgOpen(w, 92)
                + line(left, 54, right, 54, "#0f172a", 2.2)
                + ticks
                + "<path d='M " + fmt(x0) + " 36 Q " + fmt((x0 + x1) / 2) + " 8 " + fmt(x1)
                + " 36' fill='none' stroke='#ea580c' stroke-width='2.4'/>"
                + "<circle cx='" + fmt(x0) + "' cy='54' r='6' fill='#0284c7'/>"
                + "<circle cx='" + fmt(x1) + "' cy='54' r='6' fill='#ea580c'/>"
                + svgClose();
        return wrap(caption, svg);
    }

    public static String placeValueChart(int thousands, int hundreds, int tens, int ones, String caption) {
        String svg = svgOpen(420, 110)
                + "<rect x='16' y='12' width='388' height='86' rx='10' fill='#fff7ed' stroke='#fdba74'/>"
                + cell(24, 20, 90, 70, "Thousands", String.valueOf(thousands))
                + cell(118, 20, 90, 70, "Hundreds", String.valueOf(hundreds))
                + cell(212, 20, 90, 70, "Tens", String.valueOf(tens))
                + cell(306, 20, 90, 70, "Ones", String.valueOf(ones))
                + svgClose();
        return wrap(caption, svg);
    }

    public static String array(int rows, int cols, String caption) {
        int gap = 8;
        int size = 18;
        int w = cols * (size + gap) + 36;
        int h = rows * (size + gap) + 36;
        StringBuilder dots = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = 22 + c * (size + gap);
                int y = 20 + r * (size + gap);
                dots.append("<rect x='").append(x).append("' y='").append(y)
                        .append("' width='").append(size).append("' height='").append(size)
                        .append("' rx='4' fill='#38bdf8' stroke='#0369a1'/>");
            }
        }
        return wrap(caption, svgOpen(Math.max(w, 160), Math.max(h, 80)) + dots + svgClose());
    }

    public static String fractionBar(int shaded, int parts, String caption) {
        int w = 400;
        int h = 72;
        double left = 20;
        double boxW = 360.0 / parts;
        StringBuilder cells = new StringBuilder();
        for (int i = 0; i < parts; i++) {
            double x = left + i * boxW;
            String fill = i < shaded ? "#fb923c" : "#fff";
            cells.append("<rect x='").append(fmt(x)).append("' y='16' width='").append(fmt(boxW))
                    .append("' height='36' fill='").append(fill).append("' stroke='#9a3412'/>");
        }
        return wrap(caption, svgOpen(w, h) + cells + svgClose());
    }

    public static String fractionCompare(int s1, int p1, int s2, int p2, String c1, String c2, String caption) {
        return wrap(caption, svgOpen(400, 130)
                + barRow(20, 18, 360, s1, p1, c1)
                + barRow(20, 72, 360, s2, p2, c2)
                + svgClose());
    }

    public static String rectangle(int length, int width, String caption) {
        int rw = Math.min(260, 40 + length * 12);
        int rh = Math.min(140, 30 + width * 10);
        int x = (400 - rw) / 2;
        int y = 18;
        String svg = svgOpen(400, rh + 56)
                + "<rect x='" + x + "' y='" + y + "' width='" + rw + "' height='" + rh
                + "' fill='#dbeafe' stroke='#1d4ed8' stroke-width='2.2'/>"
                + text(200, y + rh + 22, length + " cm", 13, "#1e3a8a")
                + text(x - 8, y + rh / 2.0 + 4, width + " cm", 13, "#1e3a8a")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String lShape(int wide, int tall, int cutW, int cutH, String caption) {
        // L made from a wide×tall rectangle minus a cutW×cutH corner at top-right
        int s = 14;
        int x = 40;
        int y = 16;
        int W = wide * s;
        int H = tall * s;
        int cW = cutW * s;
        int cH = cutH * s;
        String path = "M " + x + " " + y
                + " H " + (x + W - cW)
                + " V " + (y + cH)
                + " H " + (x + W)
                + " V " + (y + H)
                + " H " + x
                + " Z";
        String svg = svgOpen(400, H + 48)
                + "<path d='" + path + "' fill='#fde68a' stroke='#b45309' stroke-width='2'/>"
                + text(x + (W - cW) / 2.0, y - 2, (wide - cutW) + " cm", 11, "#92400e")
                + text(x + W + 18, y + cH + (H - cH) / 2.0, cutH + "?", 11, "#92400e")
                + text(x + W / 2.0, y + H + 16, wide + " cm", 12, "#92400e")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String rightTriangle(int base, int height, String hyp, String caption) {
        int x = 50;
        int y = 150;
        int b = Math.min(240, 40 + base * 14);
        int ht = Math.min(110, 30 + height * 10);
        String svg = svgOpen(360, 180)
                + "<polygon points='" + x + "," + y + " " + (x + b) + "," + y + " " + x + "," + (y - ht)
                + "' fill='#e0f2fe' stroke='#0369a1' stroke-width='2'/>"
                + "<rect x='" + x + "' y='" + (y - 14) + "' width='14' height='14' fill='none' stroke='#0f172a'/>"
                + text(x + b / 2.0, y + 18, base + " cm", 12, "#0f172a")
                + text(x - 28, y - ht / 2.0, height + " cm", 12, "#0f172a")
                + (hyp != null ? text(x + b * 0.55, y - ht * 0.55, hyp, 12, "#c2410c") : "")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String triangleAngles(int a, int b, String unknown, String caption) {
        String svg = svgOpen(340, 200)
                + "<polygon points='40,170 300,170 170,28' fill='#fff7ed' stroke='#c2410c' stroke-width='2.2'/>"
                + text(160, 186, a + "°", 13, "#9a3412")
                + text(52, 150, b + "°", 13, "#9a3412")
                + text(188, 58, unknown, 14, "#ea580c")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String anglesOnLine(int known, String caption) {
        int otherGuess = 180 - known;
        String svg = svgOpen(400, 120)
                + line(30, 70, 370, 70, "#0f172a", 3)
                + line(200, 70, 200, 20, "#0284c7", 2.4)
                + text(120, 96, known + "°", 14, "#0f172a")
                + text(250, 50, "?", 16, "#ea580c")
                + text(200, 114, "straight line = 180°  →  other = " + otherGuess + "°", 11, "#64748b")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String circle(int diameter, String caption) {
        String svg = svgOpen(280, 200)
                + "<circle cx='140' cy='96' r='70' fill='#ecfeff' stroke='#0e7490' stroke-width='2.4'/>"
                + line(70, 96, 210, 96, "#c2410c", 2)
                + "<circle cx='140' cy='96' r='3.5' fill='#0f172a'/>"
                + text(140, 86, "d = " + diameter + " cm", 12, "#9f1239")
                + text(154, 118, "r", 12, "#0f172a")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String coordinatePoint(int x, int y, String caption) {
        int max = Math.max(4, Math.max(Math.abs(x), Math.abs(y)) + 1);
        int originX = 40;
        int originY = 200;
        int scale = Math.max(16, 160 / max);
        int px = originX + x * scale;
        int py = originY - y * scale;
        StringBuilder grid = new StringBuilder();
        for (int i = 0; i <= max; i++) {
            grid.append(line(originX, originY - i * scale, originX + max * scale, originY - i * scale, "#e2e8f0", 1));
            grid.append(line(originX + i * scale, originY, originX + i * scale, originY - max * scale, "#e2e8f0", 1));
        }
        String svg = svgOpen(originX + max * scale + 36, originY + 24)
                + grid
                + line(originX, originY, originX + max * scale, originY, "#0f172a", 2)
                + line(originX, originY, originX, originY - max * scale, "#0f172a", 2)
                + "<circle cx='" + px + "' cy='" + py + "' r='6' fill='#ea580c'/>"
                + text(px + 16, py - 6, "(" + x + ", " + y + ")", 12, "#9a3412")
                + text(originX + max * scale + 10, originY + 4, "x", 12, "#0f172a")
                + text(originX - 12, originY - max * scale, "y", 12, "#0f172a")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String barChart(String title, String[] labels, int[] values) {
        int max = 1;
        for (int v : values) {
            max = Math.max(max, v);
        }
        int w = 400;
        int base = 150;
        int left = 48;
        int barW = 48;
        int gap = 28;
        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int h = (int) Math.round(100.0 * values[i] / max);
            int x = left + i * (barW + gap);
            int y = base - h;
            bars.append("<rect x='").append(x).append("' y='").append(y)
                    .append("' width='").append(barW).append("' height='").append(h)
                    .append("' fill='#38bdf8' stroke='#0369a1'/>");
            bars.append(text(x + barW / 2.0, base + 18, labels[i], 11, "#334155"));
            bars.append(text(x + barW / 2.0, y - 8, String.valueOf(values[i]), 12, "#0f172a"));
        }
        String svg = svgOpen(w, 190)
                + line(36, base, w - 20, base, "#0f172a", 2)
                + line(36, 30, 36, base, "#0f172a", 2)
                + bars
                + text(w / 2.0, 18, title, 13, "#0f172a")
                + svgClose();
        return wrap(title, svg);
    }

    public static String spinner(String[] labels, int highlightIndex, String caption) {
        int n = labels.length;
        double cx = 120;
        double cy = 100;
        double r = 72;
        StringBuilder slices = new StringBuilder();
        String[] fills = {"#fdba74", "#93c5fd", "#86efac", "#f9a8d4", "#fde68a", "#c4b5fd"};
        for (int i = 0; i < n; i++) {
            double a0 = -Math.PI / 2 + 2 * Math.PI * i / n;
            double a1 = -Math.PI / 2 + 2 * Math.PI * (i + 1) / n;
            slices.append(wedge(cx, cy, r, a0, a1, fills[i % fills.length], i == highlightIndex));
            double mid = (a0 + a1) / 2;
            slices.append(text(cx + Math.cos(mid) * 40, cy + Math.sin(mid) * 40 + 4, labels[i], 12, "#0f172a"));
        }
        String svg = svgOpen(240, 200)
                + slices
                + "<circle cx='" + fmt(cx) + "' cy='" + fmt(cy) + "' r='" + fmt(r)
                + "' fill='none' stroke='#0f172a' stroke-width='2'/>"
                + svgClose();
        return wrap(caption, svg);
    }

    public static String coinTree(String caption) {
        String svg = svgOpen(360, 180)
                + text(180, 22, "Start", 13, "#0f172a")
                + line(180, 28, 90, 70, "#64748b", 1.6)
                + line(180, 28, 270, 70, "#64748b", 1.6)
                + text(70, 86, "H  1/2", 12, "#0369a1")
                + text(250, 86, "T  1/2", 12, "#0369a1")
                + line(90, 92, 50, 140, "#64748b", 1.6)
                + line(90, 92, 130, 140, "#64748b", 1.6)
                + line(270, 92, 230, 140, "#64748b", 1.6)
                + line(270, 92, 310, 140, "#64748b", 1.6)
                + text(42, 158, "HH", 12, "#9a3412")
                + text(118, 158, "HT", 12, "#9a3412")
                + text(218, 158, "TH", 12, "#9a3412")
                + text(298, 158, "TT", 12, "#9a3412")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String factorTree(int n, int a, int b, String caption) {
        String svg = svgOpen(280, 150)
                + text(140, 24, String.valueOf(n), 16, "#0f172a")
                + line(140, 30, 70, 70, "#64748b", 1.6)
                + line(140, 30, 210, 70, "#64748b", 1.6)
                + text(70, 88, String.valueOf(a), 15, "#9a3412")
                + text(210, 88, String.valueOf(b), 15, "#9a3412")
                + text(140, 130, n + " = " + a + " × " + b, 13, "#334155")
                + svgClose();
        return wrap(caption, svg);
    }

    public static String pythagoras345(String caption) {
        return rightTriangle(3, 4, "5", caption);
    }

    private static String barRow(int x, int y, int width, int shaded, int parts, String label) {
        double boxW = (double) width / parts;
        StringBuilder sb = new StringBuilder();
        sb.append(text(x + width / 2.0, y - 2, label, 12, "#334155"));
        for (int i = 0; i < parts; i++) {
            sb.append("<rect x='").append(x + i * boxW).append("' y='").append(y + 6)
                    .append("' width='").append(fmt(boxW)).append("' height='28' fill='")
                    .append(i < shaded ? "#fb923c" : "#fff").append("' stroke='#9a3412'/>");
        }
        return sb.toString();
    }

    private static String cell(int x, int y, int w, int h, String head, String value) {
        return "<rect x='" + x + "' y='" + y + "' width='" + w + "' height='" + h
                + "' rx='8' fill='#fff' stroke='#fdba74'/>"
                + text(x + w / 2.0, y + 22, head, 11, "#9a3412")
                + text(x + w / 2.0, y + 50, value, 22, "#0f172a");
    }

    private static String wedge(double cx, double cy, double r, double a0, double a1, String fill, boolean highlight) {
        double x0 = cx + Math.cos(a0) * r;
        double y0 = cy + Math.sin(a0) * r;
        double x1 = cx + Math.cos(a1) * r;
        double y1 = cy + Math.sin(a1) * r;
        int large = (a1 - a0) > Math.PI ? 1 : 0;
        return "<path d='M " + fmt(cx) + " " + fmt(cy) + " L " + fmt(x0) + " " + fmt(y0)
                + " A " + fmt(r) + " " + fmt(r) + " 0 " + large + " 1 " + fmt(x1) + " " + fmt(y1)
                + " Z' fill='" + fill + "' stroke='#0f172a' stroke-width='" + (highlight ? "3" : "1") + "'/>";
    }

    private static String svgOpen(int w, int h) {
        return "<svg class='math-svg' viewBox='0 0 " + w + " " + h
                + "' width='" + w + "' height='" + h
                + "' role='img' xmlns='http://www.w3.org/2000/svg'>";
    }

    private static String svgClose() {
        return "</svg>";
    }

    private static String line(double x1, double y1, double x2, double y2, String color, double width) {
        return "<line x1='" + fmt(x1) + "' y1='" + fmt(y1) + "' x2='" + fmt(x2) + "' y2='" + fmt(y2)
                + "' stroke='" + color + "' stroke-width='" + width + "' stroke-linecap='round'/>";
    }

    private static String poly(double x1, double y1, double x2, double y2, double x3, double y3) {
        return "<polygon points='" + fmt(x1) + "," + fmt(y1) + " " + fmt(x2) + "," + fmt(y2)
                + " " + fmt(x3) + "," + fmt(y3) + "' fill='#0f172a'/>";
    }

    private static String text(double x, double y, String value, int size, String fill) {
        return "<text x='" + fmt(x) + "' y='" + fmt(y) + "' text-anchor='middle' font-size='"
                + size + "' font-family='Nunito,Segoe UI,sans-serif' fill='" + fill
                + "' font-weight='700'>" + esc(value) + "</text>";
    }

    private static String fmt(double v) {
        return String.format(java.util.Locale.US, "%.1f", v);
    }

    private static String esc(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
