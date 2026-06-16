/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;
import java.util.Random;

public final class GeometryPractice {
    private static final String TOPIC = "geometry";
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";
    private static final int[][] TRIPLES = new int[][]{{3, 4, 5}, {6, 8, 10}, {5, 12, 13}, {8, 15, 17}, {9, 12, 15}, {7, 24, 25}, {20, 21, 29}, {9, 40, 41}};

    private GeometryPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(GeometryPractice.angles());
        reg.add(GeometryPractice.triangles());
        reg.add(GeometryPractice.circles());
        reg.add(GeometryPractice.areaVolume());
        reg.add(GeometryPractice.perimeter());
        reg.add(GeometryPractice.coordinate());
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }

    private static int[] triple(Random rng) {
        return TRIPLES[rng.nextInt(TRIPLES.length)];
    }

    private static LessonPractice angles() {
        LessonPractice lp = new LessonPractice("geo-angles", TOPIC, "Lines and angles");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 20, 160);
            return QBuilder.build(rng, "Two angles lie on a straight line. If one is " + a + "\u00b0, what is the other?", 180 - a + "\u00b0", "Angles on a straight line add to 180\u00b0, so the other = 180 \u2212 " + a + " = " + (180 - a) + "\u00b0.", "EASY", EX, 90 - a + "\u00b0", 180 + a + "\u00b0", a + "\u00b0", 160 - a + "\u00b0");
        }, rng -> {
            int a = QBuilder.range(rng, 10, 80);
            return QBuilder.build(rng, "What is the complement of a " + a + "\u00b0 angle?", 90 - a + "\u00b0", "Complementary angles add to 90\u00b0: 90 \u2212 " + a + " = " + (90 - a) + "\u00b0.", "EASY", EX, 180 - a + "\u00b0", a + "\u00b0", 90 + a + "\u00b0", 100 - a + "\u00b0");
        }, rng -> {
            int[][] sets = new int[][]{{1, 2, 3}, {2, 3, 4}, {1, 3, 5}, {2, 2, 5}, {1, 1, 4}, {3, 4, 5}};
            int[] rt = sets[rng.nextInt(sets.length)];
            int sum = rt[0] + rt[1] + rt[2];
            int one = 180 / sum;
            int largest = one * Math.max(rt[0], Math.max(rt[1], rt[2]));
            return QBuilder.build(rng, "The angles of a triangle are in the ratio " + rt[0] + " : " + rt[1] + " : " + rt[2] + ". What is the largest angle?", largest + "\u00b0", "The 3 parts sum to " + sum + " = 180\u00b0, so one part = " + one + "\u00b0. Largest = " + largest / one + "\u00d7" + one + " = " + largest + "\u00b0.", "MEDIUM", EX, one * Math.min(rt[0], Math.min(rt[1], rt[2])) + "\u00b0", largest + 10 + "\u00b0", "90\u00b0", largest - 10 + "\u00b0");
        });
        lp.word(rng -> {
            int a = QBuilder.range(rng, 30, 150);
            return QBuilder.build(rng, "A door swings open through " + a + "\u00b0. How many more degrees until it has turned a full straight line (180\u00b0)?", 180 - a + "\u00b0", "180 \u2212 " + a + " = " + (180 - a) + "\u00b0 remain.", "EASY", WP, 90 - a + "\u00b0", a + "\u00b0", 360 - a + "\u00b0", 150 - a + "\u00b0");
        }, rng -> {
            int a = QBuilder.range(rng, 100, 160);
            int co = 180 - a;
            return QBuilder.build(rng, "Two parallel lines are crossed by a line. One of the angles formed is " + a + "\u00b0. What is its co-interior (allied) angle on the same side?", co + "\u00b0", "Co-interior angles between parallel lines add to 180\u00b0: 180 \u2212 " + a + " = " + co + "\u00b0.", "HARD", CWP, a + "\u00b0", a - co + "\u00b0", 90 - co + "\u00b0", co + 20 + "\u00b0");
        });
        lp.classicConcept(new GeneratedQuestion("The angles of a triangle are in ratio 1 : 2 : 3. The largest angle is:", List.of("90\u00b0", "60\u00b0", "120\u00b0", "100\u00b0"), 0, "6 parts = 180\u00b0, one part = 30\u00b0, largest = 3\u00d730 = 90\u00b0.", "MEDIUM", EX), new GeneratedQuestion("Two angles are supplementary and one is 110\u00b0. The other is:", List.of("70\u00b0", "80\u00b0", "90\u00b0", "20\u00b0"), 0, "Supplementary angles add to 180\u00b0: 180 \u2212 110 = 70\u00b0.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("The minute hand turns from 12 to 3. Through what angle has it turned?", List.of("90\u00b0", "180\u00b0", "120\u00b0", "45\u00b0"), 0, "A quarter turn of the full 360\u00b0 = 90\u00b0.", "EASY", WP), new GeneratedQuestion("In a triangle, two angles are 50\u00b0 and 60\u00b0. The third angle is:", List.of("70\u00b0", "80\u00b0", "90\u00b0", "60\u00b0"), 0, "Angles of a triangle sum to 180\u00b0: 180 \u2212 50 \u2212 60 = 70\u00b0.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice triangles() {
        LessonPractice lp = new LessonPractice("geo-triangles", TOPIC, "Triangles and the Pythagorean theorem");
        lp.concept(rng -> {
            int[] tr = GeometryPractice.triple(rng);
            return QBuilder.build(rng, "A right triangle has legs " + tr[0] + " and " + tr[1] + ". What is the hypotenuse?", GeometryPractice.s(tr[2]), tr[0] + "\u00b2 + " + tr[1] + "\u00b2 = " + tr[0] * tr[0] + " + " + tr[1] * tr[1] + " = " + tr[2] * tr[2] + ", so hypotenuse = \u221a" + tr[2] * tr[2] + " = " + tr[2] + ".", "EASY", EX, GeometryPractice.s(tr[2] + 1), GeometryPractice.s(tr[0] + tr[1]), GeometryPractice.s(tr[2] - 1), GeometryPractice.s(tr[2] + 2));
        }, rng -> {
            int[] tr = GeometryPractice.triple(rng);
            return QBuilder.build(rng, "A right triangle has hypotenuse " + tr[2] + " and one leg " + tr[0] + ". What is the other leg?", GeometryPractice.s(tr[1]), tr[2] + "\u00b2 \u2212 " + tr[0] + "\u00b2 = " + tr[2] * tr[2] + " \u2212 " + tr[0] * tr[0] + " = " + tr[1] * tr[1] + ", so the leg = " + tr[1] + ".", "MEDIUM", EX, GeometryPractice.s(tr[1] + 1), GeometryPractice.s(tr[2] - tr[0]), GeometryPractice.s(tr[1] - 1), GeometryPractice.s(tr[1] + 2));
        }, rng -> {
            int base = QBuilder.range(rng, 4, 30) * 2;
            int h = QBuilder.range(rng, 3, 20);
            int area = base * h / 2;
            return QBuilder.build(rng, "What is the area of a triangle with base " + base + " and height " + h + "?", GeometryPractice.s(area), "Area = \u00bd \u00d7 base \u00d7 height = \u00bd \u00d7 " + base + " \u00d7 " + h + " = " + area + ".", "EASY", EX, GeometryPractice.s(base * h), GeometryPractice.s(area + h), GeometryPractice.s(area - h), GeometryPractice.s(base + h));
        });
        lp.word(rng -> {
            int[] tr = GeometryPractice.triple(rng);
            return QBuilder.build(rng, "A ladder " + tr[2] + " m long leans against a wall with its foot " + tr[0] + " m from the base. How high up the wall does it reach?", tr[1] + " m", "The wall, ground and ladder form a right triangle: height = \u221a(" + tr[2] + "\u00b2 \u2212 " + tr[0] + "\u00b2) = \u221a" + tr[1] * tr[1] + " = " + tr[1] + " m.", "MEDIUM", WP, tr[2] - tr[0] + " m", tr[1] + 1 + " m", tr[2] + " m", tr[1] - 1 + " m");
        }, rng -> {
            int[] tr = GeometryPractice.triple(rng);
            int k = QBuilder.pick(rng, 1, 2);
            int a = tr[0] * k;
            int b = tr[1] * k;
            int c = tr[2] * k;
            return QBuilder.build(rng, "A park is a right triangle with the two shorter sides " + a + " m and " + b + " m. A path runs along all three sides. What is its total length (perimeter)?", a + b + c + " m", "The hypotenuse = \u221a(" + a + "\u00b2 + " + b + "\u00b2) = " + c + " m. Perimeter = " + a + " + " + b + " + " + c + " = " + (a + b + c) + " m.", "HARD", CWP, a + b + " m", a + b + c + k + " m", a * b / 2 + " m", a + b + c - k + " m");
        });
        lp.classicConcept(new GeneratedQuestion("A right triangle has legs 3 and 4. Its hypotenuse is:", List.of("5", "6", "7", "\u221a7"), 0, "3\u00b2 + 4\u00b2 = 25, so hypotenuse = 5.", "EASY", EX), new GeneratedQuestion("The area of a triangle with base 10 and height 6 is:", List.of("30", "60", "16", "32"), 0, "Area = \u00bd \u00d7 10 \u00d7 6 = 30.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A 13 m ladder rests with its foot 5 m from a wall. It reaches a height of:", List.of("12 m", "10 m", "8 m", "11 m"), 0, "\u221a(13\u00b2 \u2212 5\u00b2) = \u221a144 = 12 m.", "MEDIUM", WP), new GeneratedQuestion("Two roads meet at a right angle. Walking 6 km on one then 8 km on the other, the straight-line distance back to start is:", List.of("10 km", "14 km", "12 km", "9 km"), 0, "\u221a(6\u00b2 + 8\u00b2) = \u221a100 = 10 km.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice circles() {
        LessonPractice lp = new LessonPractice("geo-circles", TOPIC, "Circles");
        lp.concept(rng -> {
            int r = QBuilder.pick(rng, 7, 14, 21, 28, 35);
            int circ = 44 * r / 7;
            return QBuilder.build(rng, "What is the circumference of a circle of radius " + r + " (use \u03c0 = 22/7)?", GeometryPractice.s(circ), "Circumference = 2\u03c0r = 2 \u00d7 22/7 \u00d7 " + r + " = " + circ + ".", "MEDIUM", EX, GeometryPractice.s(22 * r / 7), GeometryPractice.s(circ + r), GeometryPractice.s(circ - r), GeometryPractice.s(r * r));
        }, rng -> {
            int r = QBuilder.pick(rng, 7, 14, 21);
            int area = 22 * r * r / 7;
            return QBuilder.build(rng, "What is the area of a circle of radius " + r + " (use \u03c0 = 22/7)?", GeometryPractice.s(area), "Area = \u03c0r\u00b2 = 22/7 \u00d7 " + r + "\u00b2 = " + area + ".", "MEDIUM", EX, GeometryPractice.s(44 * r / 7), GeometryPractice.s(area + r), GeometryPractice.s(area - r), GeometryPractice.s(r * r));
        }, rng -> {
            int r = QBuilder.range(rng, 3, 40);
            return QBuilder.build(rng, "A circle has radius " + r + ". What is its diameter?", GeometryPractice.s(2 * r), "Diameter = 2 \u00d7 radius = 2 \u00d7 " + r + " = " + 2 * r + ".", "EASY", EX, GeometryPractice.s(r), GeometryPractice.s(r * r), GeometryPractice.s(2 * r + 1), GeometryPractice.s(4 * r));
        });
        lp.word(rng -> {
            int r = QBuilder.pick(rng, 7, 14, 21);
            int circ = 44 * r / 7;
            return QBuilder.build(rng, "A circular track has radius " + r + " m. How far do you walk in one full lap (use \u03c0 = 22/7)?", circ + " m", "One lap = circumference = 2 \u00d7 22/7 \u00d7 " + r + " = " + circ + " m.", "MEDIUM", WP, 22 * r / 7 + " m", circ + r + " m", r * r + " m", circ - r + " m");
        }, rng -> {
            int r = QBuilder.pick(rng, 7, 14);
            int circ = 44 * r / 7;
            int laps = QBuilder.pick(rng, 5, 10, 4);
            int total = circ * laps;
            return QBuilder.build(rng, "A wheel of radius " + r + " cm makes " + laps + " complete turns. How far does it travel (use \u03c0 = 22/7)?", total + " cm", "Distance per turn = circumference = " + circ + " cm. In " + laps + " turns: " + circ + " \u00d7 " + laps + " = " + total + " cm.", "HARD", CWP, GeometryPractice.s(circ), total + circ + " cm", 22 * r / 7 * laps + " cm", total - circ + " cm");
        });
        lp.classicConcept(new GeneratedQuestion("The area of a circle with radius 7 (use \u03c0 = 22/7) is:", List.of("154", "144", "44", "49"), 0, "Area = 22/7 \u00d7 7 \u00d7 7 = 154.", "MEDIUM", EX), new GeneratedQuestion("The circumference of a circle with diameter 14 (use \u03c0 = 22/7) is:", List.of("44", "88", "22", "154"), 0, "Circumference = \u03c0 \u00d7 d = 22/7 \u00d7 14 = 44.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A circular garden of radius 21 m is fenced. The fence length (\u03c0 = 22/7) is:", List.of("132 m", "66 m", "264 m", "121 m"), 0, "Circumference = 2 \u00d7 22/7 \u00d7 21 = 132 m.", "MEDIUM", WP), new GeneratedQuestion("A wheel of radius 7 cm rolls 10 turns. Distance covered (\u03c0 = 22/7) is:", List.of("440 cm", "44 cm", "220 cm", "490 cm"), 0, "Per turn = 44 cm; 10 turns = 440 cm.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice areaVolume() {
        LessonPractice lp = new LessonPractice("geo-area-volume", TOPIC, "Areas and volumes you must know");
        lp.concept(rng -> {
            int l = QBuilder.range(rng, 4, 25);
            int w = QBuilder.range(rng, 3, 20);
            return QBuilder.build(rng, "What is the area of a rectangle " + l + " by " + w + "?", GeometryPractice.s(l * w), "Area = length \u00d7 width = " + l + " \u00d7 " + w + " = " + l * w + ".", "EASY", EX, GeometryPractice.s(2 * (l + w)), GeometryPractice.s(l * w + l), GeometryPractice.s(l + w), GeometryPractice.s(l * w - w));
        }, rng -> {
            int side = QBuilder.range(rng, 2, 12);
            return QBuilder.build(rng, "What is the volume of a cube with side " + side + "?", GeometryPractice.s(side * side * side), "Volume = side\u00b3 = " + side + "\u00b3 = " + side * side * side + ".", "EASY", EX, GeometryPractice.s(side * side), GeometryPractice.s(6 * side * side), GeometryPractice.s(3 * side), GeometryPractice.s(side * side * side + side));
        }, rng -> {
            int r = QBuilder.pick(rng, 7, 14);
            int h = QBuilder.range(rng, 2, 10);
            int vol = 22 * r * r * h / 7;
            return QBuilder.build(rng, "What is the volume of a cylinder with radius " + r + " and height " + h + " (use \u03c0 = 22/7)?", GeometryPractice.s(vol), "Volume = \u03c0r\u00b2h = 22/7 \u00d7 " + r + "\u00b2 \u00d7 " + h + " = " + vol + ".", "HARD", EX, GeometryPractice.s(22 * r * r / 7), GeometryPractice.s(vol + h), GeometryPractice.s(vol - h), GeometryPractice.s(r * r * h));
        });
        lp.word(rng -> {
            int l = QBuilder.range(rng, 3, 12);
            int w = QBuilder.range(rng, 2, 10);
            int h = QBuilder.range(rng, 2, 8);
            int vol = l * w * h;
            return QBuilder.build(rng, "A box measures " + l + " \u00d7 " + w + " \u00d7 " + h + " cm. What is its volume?", vol + " cm\u00b3", "Volume = l \u00d7 w \u00d7 h = " + l + " \u00d7 " + w + " \u00d7 " + h + " = " + vol + " cm\u00b3.", "MEDIUM", WP, l * w + " cm\u00b3", vol + h + " cm\u00b3", 2 * (l * w + w * h + l * h) + " cm\u00b3", vol - h + " cm\u00b3");
        }, rng -> {
            int floorL = QBuilder.pick(rng, 6, 8, 12, 10) * 10;
            int floorW = QBuilder.pick(rng, 4, 6, 8) * 10;
            int tile = QBuilder.pick(rng, 10, 20);
            int tiles = floorL * floorW / (tile * tile);
            return QBuilder.build(rng, "A floor " + floorL + " cm by " + floorW + " cm is covered with square tiles of side " + tile + " cm. How many tiles are needed?", GeometryPractice.s(tiles), "Floor area = " + floorL * floorW + " cm\u00b2; each tile = " + tile * tile + " cm\u00b2. Tiles = " + floorL * floorW + " \u00f7 " + tile * tile + " = " + tiles + ".", "HARD", CWP, GeometryPractice.s(tiles + 1), GeometryPractice.s((floorL + floorW) / tile), GeometryPractice.s(tiles - 1), GeometryPractice.s(tiles * 2));
        });
        lp.classicConcept(new GeneratedQuestion("The volume of a cube with side 4 is:", List.of("64", "16", "48", "12"), 0, "Volume = 4\u00b3 = 64.", "EASY", EX), new GeneratedQuestion("The area of a square of side 9 is:", List.of("81", "36", "18", "72"), 0, "Area = side\u00b2 = 81.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A tank 2 m \u00d7 3 m \u00d7 4 m holds how many cubic metres of water when full?", List.of("24", "9", "26", "20"), 0, "Volume = 2\u00d73\u00d74 = 24 m\u00b3.", "MEDIUM", WP), new GeneratedQuestion("How many 5 cm cubes fit in a box 20 cm \u00d7 10 cm \u00d7 5 cm?", List.of("8", "10", "16", "4"), 0, "Box volume = 1000 cm\u00b3; cube = 125 cm\u00b3; 1000 \u00f7 125 = 8.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice perimeter() {
        LessonPractice lp = new LessonPractice("geo-perimeter", TOPIC, "Perimeter and circumference");
        lp.concept(rng -> {
            int l = QBuilder.range(rng, 5, 30);
            int w = QBuilder.range(rng, 3, 25);
            int p = 2 * (l + w);
            return QBuilder.build(rng, "What is the perimeter of a rectangle " + l + " by " + w + "?", GeometryPractice.s(p), "Perimeter = 2 \u00d7 (length + width) = 2 \u00d7 (" + l + " + " + w + ") = " + p + ".", "EASY", EX, GeometryPractice.s(l * w), GeometryPractice.s(l + w), GeometryPractice.s(p + 2), GeometryPractice.s(p - 2));
        }, rng -> {
            int side = QBuilder.range(rng, 4, 40);
            return QBuilder.build(rng, "What is the perimeter of a square of side " + side + "?", GeometryPractice.s(4 * side), "Perimeter = 4 \u00d7 side = 4 \u00d7 " + side + " = " + 4 * side + ".", "EASY", EX, GeometryPractice.s(side * side), GeometryPractice.s(2 * side), GeometryPractice.s(4 * side + 1), GeometryPractice.s(3 * side));
        }, rng -> {
            int a = QBuilder.range(rng, 5, 20);
            int b = QBuilder.range(rng, 5, 20);
            int c = QBuilder.range(rng, 5, 20);
            return QBuilder.build(rng, "A triangle has sides " + a + ", " + b + " and " + c + ". What is its perimeter?", GeometryPractice.s(a + b + c), "Perimeter = sum of all sides = " + a + " + " + b + " + " + c + " = " + (a + b + c) + ".", "EASY", EX, GeometryPractice.s(a * b), GeometryPractice.s(a + b + c + 1), GeometryPractice.s((a + b + c) / 2), GeometryPractice.s(a + b));
        });
        lp.word(rng -> {
            int l = QBuilder.range(rng, 6, 30);
            int w = QBuilder.range(rng, 4, 25);
            int p = 2 * (l + w);
            return QBuilder.build(rng, "A rectangular garden is " + l + " m by " + w + " m. How many metres of fencing are needed to enclose it?", p + " m", "Fencing = perimeter = 2 \u00d7 (" + l + " + " + w + ") = " + p + " m.", "MEDIUM", WP, l * w + " m", l + w + " m", p + 4 + " m", p - 4 + " m");
        }, rng -> {
            int side = QBuilder.range(rng, 8, 25);
            int p = 4 * side;
            int costPer = QBuilder.pick(rng, 10, 15, 20, 25);
            int total = p * costPer;
            return QBuilder.build(rng, "A square plot of side " + side + " m is fenced at \u20b9" + costPer + " per metre. What is the total cost of fencing?", "\u20b9" + total, "Perimeter = 4\u00d7" + side + " = " + p + " m; cost = " + p + " \u00d7 \u20b9" + costPer + " = \u20b9" + total + ".", "HARD", CWP, "\u20b9" + side * side * costPer, "\u20b9" + (p + costPer), "\u20b9" + (total + costPer), "\u20b9" + (total - costPer));
        });
        lp.classicConcept(new GeneratedQuestion("The perimeter of a rectangle 12 by 8 is:", List.of("40", "96", "20", "48"), 0, "2 \u00d7 (12 + 8) = 40.", "EASY", EX), new GeneratedQuestion("The perimeter of a square of side 15 is:", List.of("60", "225", "45", "30"), 0, "4 \u00d7 15 = 60.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("Fencing a 25 m by 15 m field requires how many metres?", List.of("80", "40", "375", "160"), 0, "2 \u00d7 (25 + 15) = 80 m.", "MEDIUM", WP), new GeneratedQuestion("A square park of side 50 m is fenced at \u20b920/m. Total cost is:", List.of("\u20b94,000", "\u20b92,000", "\u20b95,000", "\u20b910,000"), 0, "Perimeter = 200 m; cost = 200 \u00d7 20 = \u20b94,000.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice coordinate() {
        LessonPractice lp = new LessonPractice("geo-coordinate", TOPIC, "Coordinate geometry: points on a grid");
        lp.concept(rng -> {
            int[] tr = GeometryPractice.triple(rng);
            int x1 = QBuilder.range(rng, -5, 5);
            int y1 = QBuilder.range(rng, -5, 5);
            int x2 = x1 + tr[0];
            int y2 = y1 + tr[1];
            return QBuilder.build(rng, "What is the distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")?", GeometryPractice.s(tr[2]), "Distance = \u221a[(" + tr[0] + ")\u00b2 + (" + tr[1] + ")\u00b2] = \u221a" + tr[2] * tr[2] + " = " + tr[2] + ".", "MEDIUM", EX, GeometryPractice.s(tr[0] + tr[1]), GeometryPractice.s(tr[2] + 1), GeometryPractice.s(tr[2] - 1), GeometryPractice.s(tr[0] * tr[1]));
        }, rng -> {
            int x1 = QBuilder.range(rng, -6, 6) * 2;
            int y1 = QBuilder.range(rng, -6, 6) * 2;
            int x2 = QBuilder.range(rng, -6, 6) * 2;
            int y2 = QBuilder.range(rng, -6, 6) * 2;
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) / 2;
            return QBuilder.build(rng, "What is the midpoint of (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")?", "(" + mx + ", " + my + ")", "Midpoint = ((" + x1 + "+" + x2 + ")/2, (" + y1 + "+" + y2 + ")/2) = (" + mx + ", " + my + ").", "MEDIUM", EX, "(" + (mx + 1) + ", " + my + ")", "(" + (x1 + x2) + ", " + (y1 + y2) + ")", "(" + my + ", " + mx + ")", "(" + mx + ", " + (my + 1) + ")");
        }, rng -> {
            int x1 = QBuilder.range(rng, -4, 4);
            int y1 = QBuilder.range(rng, -8, 8);
            int run = QBuilder.pick(rng, 1, 2, 3);
            int slope = QBuilder.pick(rng, 1, 2, 3, -1, -2);
            int x2 = x1 + run;
            int y2 = y1 + slope * run;
            return QBuilder.build(rng, "What is the slope of the line through (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")?", GeometryPractice.s(slope), "Slope = (y\u2082\u2212y\u2081)/(x\u2082\u2212x\u2081) = (" + y2 + "\u2212" + y1 + ")/(" + x2 + "\u2212" + x1 + ") = " + (y2 - y1) + "/" + run + " = " + slope + ".", "HARD", EX, GeometryPractice.s(slope + 1), GeometryPractice.s(-slope), GeometryPractice.s(run), GeometryPractice.s(slope - 1));
        });
        lp.word(rng -> {
            int[] tr = GeometryPractice.triple(rng);
            return QBuilder.build(rng, "A drone flies from the origin (0, 0) to the point (" + tr[0] + ", " + tr[1] + "). How far is it from base (straight line)?", tr[2] + " units", "Distance = \u221a(" + tr[0] + "\u00b2 + " + tr[1] + "\u00b2) = \u221a" + tr[2] * tr[2] + " = " + tr[2] + " units.", "MEDIUM", WP, tr[0] + tr[1] + " units", tr[2] + 1 + " units", tr[2] - 1 + " units", tr[0] * tr[1] + " units");
        }, rng -> {
            int x1 = QBuilder.range(rng, -5, 5) * 2;
            int y1 = QBuilder.range(rng, -5, 5) * 2;
            int x2 = QBuilder.range(rng, -5, 5) * 2;
            int y2 = QBuilder.range(rng, -5, 5) * 2;
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) / 2;
            return QBuilder.build(rng, "Two friends stand at (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") on a grid. Where should they meet exactly in the middle?", "(" + mx + ", " + my + ")", "The meeting point is the midpoint = (" + mx + ", " + my + ").", "HARD", CWP, "(" + (mx + 2) + ", " + my + ")", "(" + (x1 + x2) + ", " + (y1 + y2) + ")", "(" + my + ", " + mx + ")", "(" + mx + ", " + (my + 2) + ")");
        });
        lp.classicConcept(new GeneratedQuestion("The distance between (0, 0) and (3, 4) is:", List.of("5", "7", "12", "1"), 0, "\u221a(3\u00b2 + 4\u00b2) = \u221a25 = 5.", "EASY", EX), new GeneratedQuestion("The midpoint of (2, 4) and (6, 10) is:", List.of("(4, 7)", "(8, 14)", "(2, 3)", "(4, 6)"), 0, "((2+6)/2, (4+10)/2) = (4, 7).", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A ship sails from (0,0) to (8,6). Its straight-line distance from port is:", List.of("10", "14", "12", "9"), 0, "\u221a(8\u00b2 + 6\u00b2) = \u221a100 = 10.", "MEDIUM", WP), new GeneratedQuestion("The slope of the line through (1, 2) and (4, 11) is:", List.of("3", "9", "2", "1/3"), 0, "(11\u22122)/(4\u22121) = 9/3 = 3.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

