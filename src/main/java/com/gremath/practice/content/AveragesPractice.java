/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class AveragesPractice {
    private static final String TOPIC = "averages-mixtures";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom"};
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private AveragesPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(AveragesPractice.mean());
        reg.add(AveragesPractice.change());
        reg.add(AveragesPractice.weighted());
        reg.add(AveragesPractice.alligation());
        reg.add(AveragesPractice.medianMode());
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static String list(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a[i]);
        }
        return sb.toString();
    }

    private static LessonPractice mean() {
        LessonPractice lp = new LessonPractice("avg-mean", TOPIC, "What is an average?");
        lp.concept(rng -> {
            int[][] sets = new int[][]{{-3, -1, 1, 3}, {-5, -1, 1, 5}, {-4, -2, 2, 4}, {-6, -2, 2, 6}, {-3, -3, 3, 3}};
            int[] off = sets[rng.nextInt(sets.length)];
            int base = QBuilder.range(rng, 12, 60);
            int a = base + off[0];
            int b = base + off[1];
            int c = base + off[2];
            int d = base + off[3];
            return QBuilder.build(rng, "Find the average of " + a + ", " + b + ", " + c + " and " + d + ".", AveragesPractice.s(base), "Sum = " + (a + b + c + d) + ", divided by 4 = " + base + ".", "EASY", EX, AveragesPractice.s(base + 1), AveragesPractice.s(base - 1), AveragesPractice.s(base + 2), AveragesPractice.s(a + b + c + d));
        }, rng -> {
            int n = QBuilder.range(rng, 3, 9);
            int A = QBuilder.range(rng, 10, 50);
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". What is their total?", AveragesPractice.s(n * A), "Total = average \u00d7 count = " + A + " \u00d7 " + n + " = " + n * A + ".", "EASY", EX, AveragesPractice.s(A), AveragesPractice.s((n + 1) * A), AveragesPractice.s(n * A - n), AveragesPractice.s(n * A + n));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 10);
            int A = QBuilder.range(rng, 15, 60);
            int x = QBuilder.range(rng, 2, 12);
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". If every number is increased by " + x + ", what is the new average?", AveragesPractice.s(A + x), "Adding " + x + " to each number adds " + x + " to the average: " + A + " + " + x + " = " + (A + x) + ".", "MEDIUM", EX, AveragesPractice.s(A), AveragesPractice.s(A + n * x), AveragesPractice.s(A * x), AveragesPractice.s(A + x + 1));
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int[][] sets = new int[][]{{-3, 0, 3}, {-6, 0, 6}, {-2, 0, 2}, {-9, 0, 9}, {-4, -1, 5}};
            int[] off = sets[rng.nextInt(sets.length)];
            int base = QBuilder.range(rng, 40, 85);
            int a = base + off[0];
            int b = base + off[1];
            int c = base + off[2];
            return QBuilder.build(rng, name + " scored " + a + ", " + b + " and " + c + " in three tests. What is the average score?", AveragesPractice.s(base), "Sum = " + (a + b + c) + ", divided by 3 = " + base + ".", "EASY", WP, AveragesPractice.s(base + 1), AveragesPractice.s(base - 2), AveragesPractice.s(a + b + c), AveragesPractice.s(base + 3));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 9);
            int A = QBuilder.range(rng, 20, 60);
            int last = QBuilder.range(rng, 10, 80);
            int S = n * A - last;
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". The first " + (n - 1) + " of them add up to " + S + ". What is the last number?", AveragesPractice.s(last), "Total = " + n + "\u00d7" + A + " = " + n * A + ". Last = " + n * A + " \u2212 " + S + " = " + last + ".", "HARD", CWP, AveragesPractice.s(n * A), AveragesPractice.s(S), AveragesPractice.s(last + n), AveragesPractice.s(A));
        });
        lp.classicConcept(new GeneratedQuestion("The average of 4, 8, 10 and 14 is:", List.of("9", "8", "10", "12"), 0, "Sum = 36, count = 4, average = 9.", "EASY", EX), new GeneratedQuestion("The average of the first 5 whole numbers (0,1,2,3,4) is:", List.of("2", "2.5", "3", "1.5"), 0, "Sum = 10, count = 5, average = 2.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A student scores 70, 80 and 90 in three subjects. The average is:", List.of("80", "75", "85", "82"), 0, "Sum = 240, /3 = 80.", "EASY", WP), new GeneratedQuestion("The average of 6 numbers is 25. Five of them total 130. The sixth number is:", List.of("20", "25", "15", "30"), 0, "Total = 150, sixth = 150 \u2212 130 = 20.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice change() {
        LessonPractice lp = new LessonPractice("avg-change", TOPIC, "Adding or removing a value");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 4, 10);
            int A = QBuilder.range(rng, 20, 50);
            int B = A + QBuilder.pick(rng, -3, -2, 2, 3);
            int removed = n * A - (n - 1) * B;
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". After one number is removed, the average of the rest becomes " + B + ". What was the removed number?", AveragesPractice.s(removed), "Total = " + n * A + "; remaining " + (n - 1) + " sum to " + (n - 1) * B + ". Removed = " + n * A + " \u2212 " + (n - 1) * B + " = " + removed + ".", "HARD", EX, AveragesPractice.s(A), AveragesPractice.s(B), AveragesPractice.s(removed + n), AveragesPractice.s(removed - n));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 9);
            int A = QBuilder.range(rng, 20, 50);
            int B = A + QBuilder.pick(rng, -2, -1, 1, 2);
            int x = (n + 1) * B - n * A;
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". A new number " + x + " is added. What is the new average of all " + (n + 1) + " numbers?", AveragesPractice.s(B), "New total = " + n * A + " + " + x + " = " + (n * A + x) + ", divided by " + (n + 1) + " = " + B + ".", "HARD", EX, AveragesPractice.s(A), AveragesPractice.s(x), AveragesPractice.s(B + 1), AveragesPractice.s(B - 1));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 10);
            int A = QBuilder.range(rng, 20, 50);
            int d = QBuilder.pick(rng, -3, -2, 2, 3);
            int old = QBuilder.range(rng, 10, 40);
            int neu = old + n * d;
            return QBuilder.build(rng, "The average of " + n + " numbers is " + A + ". A number " + old + " is replaced by " + neu + ". What is the new average?", AveragesPractice.s(A + d), "The total changes by " + (neu - old) + ", so the average changes by " + (neu - old) + " \u00f7 " + n + " = " + d + ": new average = " + (A + d) + ".", "HARD", EX, AveragesPractice.s(A), AveragesPractice.s(A + (neu - old)), AveragesPractice.s(A + d + 1), AveragesPractice.s(A - d));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 4, 10);
            int A = QBuilder.range(rng, 25, 55);
            int B = A + QBuilder.pick(rng, 2, 3, 4);
            int x = (n + 1) * B - n * A;
            return QBuilder.build(rng, "A batsman's average after " + n + " innings is " + A + ". He scores " + x + " in the next innings. What is his new average?", AveragesPractice.s(B), "New total = " + n + "\u00d7" + A + " + " + x + " = " + (n * A + x) + ", over " + (n + 1) + " innings = " + B + ".", "MEDIUM", WP, AveragesPractice.s(A), AveragesPractice.s(B + 1), AveragesPractice.s(x), AveragesPractice.s(B - 1));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 9);
            int A = QBuilder.range(rng, 50, 75);
            int B = A + QBuilder.pick(rng, 2, 3, 4, 5);
            int need = (n + 1) * B - n * A;
            return QBuilder.build(rng, "A student's average over " + n + " tests is " + A + ". What must she score in the next test to raise her average to " + B + "?", AveragesPractice.s(need), "Required total = " + (n + 1) + "\u00d7" + B + " = " + (n + 1) * B + "; current total = " + n * A + ". Needed score = " + need + ".", "HARD", CWP, AveragesPractice.s(B), AveragesPractice.s((n + 1) * B), AveragesPractice.s(need - n), AveragesPractice.s(need + n));
        });
        lp.classicConcept(new GeneratedQuestion("The average of 5 numbers is 20. If one number is removed the average becomes 22. The removed number is:", List.of("12", "10", "14", "8"), 0, "Total = 100; remaining 4 sum to 88; removed = 12.", "MEDIUM", EX), new GeneratedQuestion("The average of 10 numbers is 15. Adding one more number keeps the average 15. The new number is:", List.of("15", "0", "10", "30"), 0, "To keep the average, the new number must equal the average, i.e. 15.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A cricketer averages 40 in 10 innings. After the 11th innings his average is 41. He scored:", List.of("51", "41", "44", "61"), 0, "New total = 11\u00d741 = 451; old total = 400; score = 51.", "MEDIUM", WP), new GeneratedQuestion("The average age of 4 friends is 20. A 25-year-old joins. The new average age is:", List.of("21", "22", "20", "23"), 0, "New total = 80 + 25 = 105, over 5 people = 21.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice weighted() {
        LessonPractice lp = new LessonPractice("avg-weighted", TOPIC, "Weighted averages (unequal groups)");
        lp.concept(rng -> {
            int n1 = 0;
            int n2 = 0;
            int A1 = 0;
            int A2 = 0;
            for (int i = 0; i < 80; ++i) {
                n1 = QBuilder.range(rng, 10, 40);
                n2 = QBuilder.range(rng, 10, 40);
                A1 = QBuilder.range(rng, 30, 60);
                if ((n1 * A1 + n2 * (A2 = QBuilder.range(rng, 30, 60))) % (n1 + n2) == 0 && A1 != A2) break;
            }
            int avg = (n1 * A1 + n2 * A2) / (n1 + n2);
            return QBuilder.build(rng, "A group of " + n1 + " students averages " + A1 + " and another " + n2 + " students average " + A2 + ". What is the combined average?", AveragesPractice.s(avg), "Combined = (total) \u00f7 (count) = (" + n1 + "\u00d7" + A1 + " + " + n2 + "\u00d7" + A2 + ") \u00f7 " + (n1 + n2) + " = " + avg + ".", "MEDIUM", EX, AveragesPractice.s((A1 + A2) / 2), AveragesPractice.s(avg + 1), AveragesPractice.s(avg - 1), AveragesPractice.s(A1));
        }, rng -> {
            int n1 = QBuilder.range(rng, 2, 6);
            int n2 = QBuilder.range(rng, 2, 6);
            int A1 = QBuilder.range(rng, 20, 50);
            int combined = QBuilder.range(rng, 25, 45);
            int total = combined * (n1 + n2);
            int A2 = total - n1 * A1;
            if (A2 % n2 != 0) {
                A1 = combined;
                A2 = combined * n2;
            }
            int avg2 = A2 / n2;
            return QBuilder.build(rng, "The combined average of " + (n1 + n2) + " items is " + combined + ". A sub-group of " + n1 + " items averages " + A1 + ". What is the average of the other " + n2 + " items?", AveragesPractice.s(avg2), "Total = " + total + "; first group = " + n1 * A1 + "; rest = " + (total - n1 * A1) + " over " + n2 + " = " + avg2 + ".", "HARD", EX, AveragesPractice.s(combined), AveragesPractice.s(A1), AveragesPractice.s(avg2 + 1), AveragesPractice.s(avg2 - 1));
        });
        lp.word(rng -> {
            int n1 = 0;
            int n2 = 0;
            int A1 = 0;
            int A2 = 0;
            for (int i = 0; i < 80; ++i) {
                n1 = QBuilder.range(rng, 10, 30);
                n2 = QBuilder.range(rng, 10, 30);
                A1 = QBuilder.range(rng, 35, 50);
                if ((n1 * A1 + n2 * (A2 = QBuilder.range(rng, 30, 45))) % (n1 + n2) == 0 && A1 != A2) break;
            }
            int avg = (n1 * A1 + n2 * A2) / (n1 + n2);
            return QBuilder.build(rng, "In a class, " + n1 + " boys average " + A1 + " kg and " + n2 + " girls average " + A2 + " kg. What is the average weight of the whole class?", avg + " kg", "Total weight = " + n1 + "\u00d7" + A1 + " + " + n2 + "\u00d7" + A2 + " = " + (n1 * A1 + n2 * A2) + " kg, over " + (n1 + n2) + " = " + avg + " kg.", "MEDIUM", WP, (A1 + A2) / 2 + " kg", avg + 1 + " kg", avg - 1 + " kg", A1 + " kg");
        }, rng -> {
            int q1 = QBuilder.pick(rng, 2, 3, 4);
            int q2 = QBuilder.pick(rng, 1, 2, 3);
            int p1 = QBuilder.pick(rng, 20, 30, 40);
            int p2 = QBuilder.pick(rng, 50, 60, 70);
            int avg = (q1 * p1 + q2 * p2) / (q1 + q2);
            int total = q1 * p1 + q2 * p2;
            if (total % (q1 + q2) != 0) {
                p2 = p1;
                avg = p1;
            }
            return QBuilder.build(rng, "A shopkeeper mixes " + q1 + " kg of tea at \u20b9" + p1 + "/kg with " + q2 + " kg at \u20b9" + p2 + "/kg. What is the average price per kg of the mixture?", "\u20b9" + avg, "Total cost = " + q1 + "\u00d7" + p1 + " + " + q2 + "\u00d7" + p2 + " = \u20b9" + (q1 * p1 + q2 * p2) + ", over " + (q1 + q2) + " kg = \u20b9" + avg + "/kg.", "HARD", CWP, "\u20b9" + (p1 + p2) / 2, "\u20b9" + (avg + 2), "\u20b9" + (avg - 2), "\u20b9" + p2);
        });
        lp.classicConcept(new GeneratedQuestion("30 boys average 40 kg and 20 girls average 35 kg. The overall average is:", List.of("38 kg", "37.5 kg", "39 kg", "37 kg"), 0, "Total = 30\u00d740 + 20\u00d735 = 1900, over 50 = 38 kg.", "MEDIUM", EX), new GeneratedQuestion("A test has weights 40% (project) and 60% (exam). Scores: project 90, exam 80. Weighted score:", List.of("84", "85", "86", "83"), 0, "0.4\u00d790 + 0.6\u00d780 = 36 + 48 = 84.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("3 kg of rice at \u20b940 is mixed with 2 kg at \u20b960. The average price per kg is:", List.of("\u20b948", "\u20b950", "\u20b945", "\u20b952"), 0, "Cost = 120 + 120 = 240, over 5 kg = \u20b948.", "MEDIUM", WP), new GeneratedQuestion("A car runs 60 km at 30 km/h and 60 km at 60 km/h. Its average speed is:", List.of("40 km/h", "45 km/h", "50 km/h", "48 km/h"), 0, "Time = 2 + 1 = 3 h for 120 km, so average speed = 120 \u00f7 3 = 40 km/h (not 45!).", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice alligation() {
        LessonPractice lp = new LessonPractice("avg-alligation", TOPIC, "Mixtures and the alligation rule");
        lp.concept(rng -> {
            int d;
            int c = QBuilder.pick(rng, 20, 25, 30, 40);
            int m = (c + (d = c + QBuilder.pick(rng, 10, 15, 20, 30))) / 2 + QBuilder.pick(rng, -2, 0, 2);
            if (m <= c || m >= d) {
                m = (c + d) / 2;
            }
            int hi = d - m;
            int lo = m - c;
            int g = AveragesPractice.gcd(hi, lo);
            return QBuilder.build(rng, "In what ratio must an item at \u20b9" + c + "/kg be mixed with one at \u20b9" + d + "/kg to get a mixture worth \u20b9" + m + "/kg? (cheap : dear)", hi / g + " : " + lo / g, "By alligation, cheap : dear = (dear \u2212 mean) : (mean \u2212 cheap) = " + hi + " : " + lo + " = " + hi / g + " : " + lo / g + ".", "HARD", EX, lo / g + " : " + hi / g, "1 : 1", hi / g + 1 + " : " + lo / g, d + " : " + c);
        }, rng -> {
            int c = QBuilder.pick(rng, 10, 12, 15, 20);
            int d = c + QBuilder.pick(rng, 10, 20, 30);
            int parts = QBuilder.pick(rng, 2, 3, 4);
            int m = c + (d - c) / parts;
            int hi = d - m;
            int lo = m - c;
            int g = AveragesPractice.gcd(hi, lo);
            return QBuilder.build(rng, "Two qualities of sugar cost \u20b9" + c + " and \u20b9" + d + " per kg. They are mixed in the ratio " + hi / g + " : " + lo / g + " (cheap : dear). What is the price of the mixture?", "\u20b9" + m, "Mean price splits the gap by the (cross) ratio: with cheap : dear = " + hi / g + " : " + lo / g + ", the mean is \u20b9" + m + "/kg.", "HARD", EX, "\u20b9" + (c + d) / 2, "\u20b9" + (m + 2), "\u20b9" + (m - 2), "\u20b9" + d);
        });
        lp.word(rng -> {
            int milk = QBuilder.pick(rng, 20, 24, 30, 36, 40);
            int waterParts = QBuilder.pick(rng, 1, 2, 3);
            int total = milk + milk / QBuilder.pick(rng, 2, 3, 4);
            int water = total - milk;
            int g = AveragesPractice.gcd(milk, water);
            return QBuilder.build(rng, "A mixture has " + milk + " litres of milk and " + water + " litres of water. What is the ratio of milk to water (simplest form)?", milk / g + " : " + water / g, "milk : water = " + milk + " : " + water + " = " + milk / g + " : " + water / g + ".", "MEDIUM", WP, water / g + " : " + milk / g, "1 : 1", milk / g + 1 + " : " + water / g, milk + " : " + total);
        }, rng -> {
            int dear;
            int c = QBuilder.pick(rng, 30, 40, 50);
            int d = c + QBuilder.pick(rng, 20, 30, 40);
            int m = c + (d - c) / 2;
            int cheap = dear = QBuilder.pick(rng, 4, 6, 8, 10).intValue();
            return QBuilder.build(rng, "A trader wants a blend worth \u20b9" + m + "/kg from coffee at \u20b9" + c + " and \u20b9" + d + ". If he uses " + dear + " kg of the costlier coffee, how many kg of the cheaper one does he need?", cheap + " kg", "At a midpoint price the ratio cheap : dear = 1 : 1, so he needs the same amount: " + cheap + " kg.", "HARD", CWP, dear * 2 + " kg", dear / 2 + " kg", dear + 2 + " kg", dear + 4 + " kg");
        });
        lp.classicConcept(new GeneratedQuestion("In what ratio must rice at 30/kg be mixed with rice at 45/kg to get 40/kg?", List.of("1 : 2", "2 : 1", "1 : 1", "3 : 2"), 0, "(45\u221240) : (40\u221230) = 5 : 10 = 1 : 2.", "MEDIUM", EX), new GeneratedQuestion("Water (free) is mixed with milk at \u20b940/L to sell at \u20b932/L. Water : milk is:", List.of("1 : 4", "1 : 5", "1 : 3", "2 : 5"), 0, "(40\u221232) : (32\u22120) = 8 : 32 = 1 : 4.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A 20-litre mixture is 3 parts milk to 1 part water. How many litres are water?", List.of("5", "4", "6", "10"), 0, "4 parts = 20, one part = 5, water = 1 part = 5 litres.", "MEDIUM", WP), new GeneratedQuestion("How many litres of water must be added to 9 litres of pure milk to make it 75% milk?", List.of("3", "2", "4", "1"), 0, "Milk stays 9 L = 75% of total \u2192 total = 12 L, so add 3 L water.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice medianMode() {
        LessonPractice lp = new LessonPractice("avg-median-mode", TOPIC, "Median and mode: other kinds of 'middle'");
        lp.concept(rng -> {
            int[] vals = AveragesPractice.distinct(rng, 5, 1, 40);
            int[] sorted = (int[])vals.clone();
            Arrays.sort(sorted);
            int median = sorted[2];
            int[] shown = (int[])vals.clone();
            return QBuilder.build(rng, "Find the median of these numbers: " + AveragesPractice.list(shown) + ".", AveragesPractice.s(median), "Sort them: " + AveragesPractice.list(sorted) + ". The middle (3rd of 5) value is " + median + ".", "MEDIUM", EX, AveragesPractice.s(sorted[0]), AveragesPractice.s(sorted[4]), AveragesPractice.s((sorted[1] + sorted[3]) / 2), AveragesPractice.s(median + 1));
        }, rng -> {
            int mode = QBuilder.range(rng, 5, 30);
            int[] others = AveragesPractice.distinctExcluding(rng, 4, 1, 40, mode);
            int[] arr = new int[]{mode, others[0], mode, others[1], others[2], mode, others[3]};
            AveragesPractice.shuffleInts(rng, arr);
            return QBuilder.build(rng, "Find the mode of these numbers: " + AveragesPractice.list(arr) + ".", AveragesPractice.s(mode), mode + " appears most often (three times), so it is the mode.", "MEDIUM", EX, AveragesPractice.s(others[0]), AveragesPractice.s(others[1]), AveragesPractice.s(others[2]), AveragesPractice.s(others[3]));
        }, rng -> {
            int[] vals = AveragesPractice.distinctEven(rng, 6, 2, 40);
            int[] sorted = (int[])vals.clone();
            Arrays.sort(sorted);
            int median = (sorted[2] + sorted[3]) / 2;
            return QBuilder.build(rng, "Find the median of: " + AveragesPractice.list(vals) + ".", AveragesPractice.s(median), "Sort: " + AveragesPractice.list(sorted) + ". With 6 values, median = average of the 3rd and 4th = (" + sorted[2] + " + " + sorted[3] + ") \u00f7 2 = " + median + ".", "HARD", EX, AveragesPractice.s(sorted[2]), AveragesPractice.s(sorted[3]), AveragesPractice.s(sorted[0]), AveragesPractice.s(median + 1));
        });
        lp.word(rng -> {
            int[] vals = AveragesPractice.distinct(rng, 5, 10, 60);
            int[] sorted = (int[])vals.clone();
            Arrays.sort(sorted);
            int median = sorted[2];
            return QBuilder.build(rng, "Five houses on a street have prices (in lakhs): " + AveragesPractice.list(vals) + ". What is the median price?", median + " lakh", "Order them: " + AveragesPractice.list(sorted) + "; the middle value is " + median + " lakh.", "MEDIUM", WP, sorted[0] + " lakh", sorted[4] + " lakh", (sorted[1] + sorted[3]) / 2 + " lakh", median + 2 + " lakh");
        }, rng -> {
            int mode = QBuilder.pick(rng, 7, 8, 9, 10);
            int[] others = AveragesPractice.distinctExcluding(rng, 3, 4, 12, mode);
            int[] arr = new int[]{mode, others[0], mode, others[1], mode, others[2]};
            AveragesPractice.shuffleInts(rng, arr);
            return QBuilder.build(rng, "A shoe shop sold pairs of these sizes today: " + AveragesPractice.list(arr) + ". Which size should it stock most of (the mode)?", "Size " + mode, "Size " + mode + " was sold most often, so it is the mode \u2014 stock the most of it.", "HARD", CWP, "Size " + others[0], "Size " + others[1], "Size " + others[2], "Size " + (mode + 1));
        });
        lp.classicConcept(new GeneratedQuestion("The median of 3, 7, 9, 12 and 20 is:", List.of("9", "12", "7", "10.2"), 0, "Already sorted; the middle of 5 values is 9.", "EASY", EX), new GeneratedQuestion("The mode of 4, 5, 5, 6, 9, 5, 7 is:", List.of("5", "6", "4", "7"), 0, "5 appears three times \u2014 more than any other value.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("Salaries (in thousands) are 20, 22, 24, 25 and 300. The best 'typical' value is the median, which is:", List.of("24", "78.2", "300", "20"), 0, "The mean (78.2) is distorted by the 300 outlier; the median (middle of the sorted list) is 24.", "HARD", WP), new GeneratedQuestion("In 2, 4, 4, 4, 6, 8, the mean, median and mode are:", List.of("Mean 4.67, Median 4, Mode 4", "All equal to 4", "Mean 4, Median 4, Mode 6", "Mean 5, Median 4, Mode 4"), 0, "Sum 28/6 = 4.67; median = (4+4)/2 = 4; mode = 4 (appears thrice).", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static int[] distinct(Random rng, int count, int lo, int hi) {
        ArrayList<Integer> pool = new ArrayList<Integer>();
        for (int v = lo; v <= hi; ++v) {
            pool.add(v);
        }
        Collections.shuffle(pool, rng);
        int[] out = new int[count];
        for (int i = 0; i < count; ++i) {
            out[i] = (Integer)pool.get(i);
        }
        return out;
    }

    private static int[] distinctEven(Random rng, int count, int lo, int hi) {
        ArrayList<Integer> pool = new ArrayList<Integer>();
        for (int v = lo; v <= hi; ++v) {
            if (v % 2 != 0) continue;
            pool.add(v);
        }
        Collections.shuffle(pool, rng);
        int[] out = new int[count];
        for (int i = 0; i < count; ++i) {
            out[i] = (Integer)pool.get(i);
        }
        return out;
    }

    private static int[] distinctExcluding(Random rng, int count, int lo, int hi, int excl) {
        ArrayList<Integer> pool = new ArrayList<Integer>();
        for (int v = lo; v <= hi; ++v) {
            if (v == excl) continue;
            pool.add(v);
        }
        Collections.shuffle(pool, rng);
        int[] out = new int[count];
        for (int i = 0; i < count; ++i) {
            out[i] = (Integer)pool.get(i);
        }
        return out;
    }

    private static void shuffleInts(Random rng, int[] a) {
        for (int i = a.length - 1; i > 0; --i) {
            int j = rng.nextInt(i + 1);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}

