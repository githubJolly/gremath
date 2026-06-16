/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RatiosPractice {
    private static final String TOPIC = "ratios-proportions";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom"};
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";
    private static final int[][] PAIRS = new int[][]{{2, 3}, {3, 4}, {4, 5}, {5, 6}, {2, 5}, {3, 5}, {5, 7}, {4, 7}, {3, 7}, {5, 8}, {7, 8}, {2, 7}, {1, 4}, {1, 3}};

    private RatiosPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(RatiosPractice.basics());
        reg.add(RatiosPractice.split());
        reg.add(RatiosPractice.chain());
        reg.add(RatiosPractice.proportion());
        reg.add(RatiosPractice.partnership());
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }

    private static int lcm(int a, int b) {
        return a / RatiosPractice.gcd(a, b) * b;
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static int[] pair(Random rng) {
        return PAIRS[rng.nextInt(PAIRS.length)];
    }

    private static LessonPractice basics() {
        LessonPractice lp = new LessonPractice("ratio-basics", TOPIC, "What is a ratio?");
        lp.concept(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int k = QBuilder.range(rng, 2, 9);
            int a = pq[0] * k;
            int b = pq[1] * k;
            return QBuilder.build(rng, "Simplify the ratio " + a + " : " + b + ".", pq[0] + " : " + pq[1], "Divide both by their HCF (" + k + "): " + a + " : " + b + " = " + pq[0] + " : " + pq[1] + ".", "EASY", EX, pq[1] + " : " + pq[0], pq[0] + 1 + " : " + pq[1], pq[0] + " : " + (pq[1] + 1), 2 * pq[0] + " : " + pq[1]);
        }, rng -> {
            int[] pq = RatiosPractice.pair(rng);
            return QBuilder.build(rng, "Which ratio is equivalent to " + pq[0] + " : " + pq[1] + "?", 2 * pq[0] + " : " + 2 * pq[1], "Multiply both parts by the same number: " + pq[0] + " : " + pq[1] + " = " + 2 * pq[0] + " : " + 2 * pq[1] + ".", "EASY", EX, 2 * pq[0] + " : " + pq[1], pq[0] + " : " + 2 * pq[1], pq[0] + 2 + " : " + (pq[1] + 2), pq[1] + " : " + pq[0]);
        }, rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 3, 12);
            int a = pq[0] * m;
            int b = pq[1] * m;
            return QBuilder.build(rng, "If a : b = " + pq[0] + " : " + pq[1] + " and a = " + a + ", what is b?", RatiosPractice.s(b), "Scale factor = " + a + " \u00f7 " + pq[0] + " = " + m + ", so b = " + pq[1] + " \u00d7 " + m + " = " + b + ".", "MEDIUM", EX, RatiosPractice.s(a), RatiosPractice.s(b + m), RatiosPractice.s(b - m), RatiosPractice.s(pq[1] * (m + 1)));
        });
        lp.word(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 3, 12);
            int boys = pq[0] * m;
            int girls = pq[1] * m;
            return QBuilder.build(rng, "In a class, the ratio of boys to girls is " + pq[0] + " : " + pq[1] + ". If there are " + boys + " boys, how many girls are there?", RatiosPractice.s(girls), "Each 'part' = " + boys + " \u00f7 " + pq[0] + " = " + m + " students, so girls = " + pq[1] + " \u00d7 " + m + " = " + girls + ".", "EASY", WP, RatiosPractice.s(boys), RatiosPractice.s(girls + m), RatiosPractice.s(boys + girls), RatiosPractice.s(pq[1] * (m - 1)));
        }, rng -> {
            int p = QBuilder.pick(rng, 2, 3, 4, 5);
            int qq = QBuilder.pick(rng, 3, 5, 6, 7);
            int r = QBuilder.pick(rng, 1, 2, 3);
            int m = QBuilder.range(rng, 3, 9);
            int flour = qq * m;
            int sugar = p * m;
            return QBuilder.build(rng, "A recipe uses sugar : flour : butter = " + p + " : " + qq + " : " + r + ". To use " + flour + " g of flour, how much sugar is needed?", sugar + " g", "Flour is " + qq + " parts = " + flour + " g, so one part = " + m + " g. Sugar = " + p + " \u00d7 " + m + " = " + sugar + " g.", "HARD", CWP, r * m + " g", flour + " g", sugar + m + " g", (p + r) * m + " g");
        });
        lp.classicConcept(new GeneratedQuestion("The ratio 0.75 : 1.5 in simplest whole-number form is:", List.of("1 : 2", "3 : 4", "2 : 3", "1 : 3"), 0, "Multiply both by 4: 3 : 6 = 1 : 2.", "MEDIUM", EX), new GeneratedQuestion("If a : b = 5 : 7, then (a + b) : b equals:", List.of("12 : 7", "5 : 12", "7 : 12", "12 : 5"), 0, "Take parts: a+b = 12 parts, b = 7 parts, so (a+b) : b = 12 : 7.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("In a fruit basket, apples : oranges = 3 : 4. If there are 12 apples, how many oranges are there?", List.of("16", "9", "12", "20"), 0, "One part = 12 \u00f7 3 = 4, so oranges = 4 \u00d7 4 = 16.", "EASY", WP), new GeneratedQuestion("A sum of money is shared as 2 : 3 : 5. If the smallest share is \u20b9400, the total is:", List.of("\u20b92,000", "\u20b91,600", "\u20b92,400", "\u20b91,200"), 0, "Smallest = 2 parts = 400, so 1 part = 200 and total = 10 parts = \u20b92,000.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice split() {
        LessonPractice lp = new LessonPractice("ratio-split", TOPIC, "Splitting a quantity in a given ratio");
        lp.concept(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 4, 20);
            int total = (pq[0] + pq[1]) * m;
            int larger = Math.max(pq[0], pq[1]) * m;
            return QBuilder.build(rng, "Divide " + total + " in the ratio " + pq[0] + " : " + pq[1] + ". What is the larger share?", RatiosPractice.s(larger), "Total parts = " + (pq[0] + pq[1]) + ", one part = " + total + " \u00f7 " + (pq[0] + pq[1]) + " = " + m + ". Larger = " + Math.max(pq[0], pq[1]) + "\u00d7" + m + " = " + larger + ".", "EASY", EX, RatiosPractice.s(Math.min(pq[0], pq[1]) * m), RatiosPractice.s(total / 2), RatiosPractice.s(larger + m), RatiosPractice.s(larger - m));
        }, rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 4, 20);
            int total = (pq[0] + pq[1]) * m;
            int smaller = Math.min(pq[0], pq[1]) * m;
            return QBuilder.build(rng, "Divide " + total + " in the ratio " + pq[0] + " : " + pq[1] + ". What is the smaller share?", RatiosPractice.s(smaller), "One part = " + total + " \u00f7 " + (pq[0] + pq[1]) + " = " + m + ". Smaller = " + Math.min(pq[0], pq[1]) + "\u00d7" + m + " = " + smaller + ".", "EASY", EX, RatiosPractice.s(Math.max(pq[0], pq[1]) * m), RatiosPractice.s(total / 2), RatiosPractice.s(smaller + m), RatiosPractice.s(smaller - m));
        }, rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 4, 15);
            int total = (pq[0] + pq[1]) * m;
            int firstShare = pq[0] * m;
            return QBuilder.build(rng, "An amount is split in the ratio " + pq[0] + " : " + pq[1] + ". If the " + pq[0] + "-part share is " + firstShare + ", what is the total amount?", RatiosPractice.s(total), "One part = " + firstShare + " \u00f7 " + pq[0] + " = " + m + ", so total = " + (pq[0] + pq[1]) + " \u00d7 " + m + " = " + total + ".", "MEDIUM", EX, RatiosPractice.s(firstShare + pq[1] * m + m), RatiosPractice.s(firstShare * 2), RatiosPractice.s(pq[1] * m), RatiosPractice.s(total + m));
        });
        lp.word(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int m = QBuilder.range(rng, 50, 300);
            int total = (pq[0] + pq[1]) * m;
            int big = Math.max(pq[0], pq[1]) * m;
            String a = QBuilder.pick(rng, NAMES);
            String b = QBuilder.pick(rng, NAMES);
            return QBuilder.build(rng, a + " and " + b + " share \u20b9" + total + " in the ratio " + pq[0] + " : " + pq[1] + ". What is the bigger share?", "\u20b9" + big, "One part = " + total + " \u00f7 " + (pq[0] + pq[1]) + " = " + m + ". Bigger share = " + big + ".", "EASY", WP, "\u20b9" + Math.min(pq[0], pq[1]) * m, "\u20b9" + total / 2, "\u20b9" + (big + m), "\u20b9" + (big - m));
        }, rng -> {
            int p = QBuilder.pick(rng, 2, 3, 4);
            int qq = QBuilder.pick(rng, 3, 5, 6);
            int r = QBuilder.pick(rng, 4, 5, 7);
            int m = QBuilder.range(rng, 40, 200);
            int total = (p + qq + r) * m;
            int cShare = r * m;
            return QBuilder.build(rng, "\u20b9" + total + " is divided among A, B and C in the ratio " + p + " : " + qq + " : " + r + ". What is C's share?", "\u20b9" + cShare, "Total parts = " + (p + qq + r) + ", one part = " + m + ", so C gets " + r + "\u00d7" + m + " = \u20b9" + cShare + ".", "HARD", CWP, "\u20b9" + p * m, "\u20b9" + qq * m, "\u20b9" + total / 3, "\u20b9" + (cShare + m));
        });
        lp.classicConcept(new GeneratedQuestion("\u20b9720 is divided in the ratio 4 : 5. The smaller part is:", List.of("\u20b9320", "\u20b9400", "\u20b9360", "\u20b9288"), 0, "9 parts = 720, one part = 80, smaller = 4\u00d780 = \u20b9320.", "EASY", EX), new GeneratedQuestion("Two numbers are in the ratio 3 : 5 and their sum is 64. The larger number is:", List.of("40", "24", "32", "45"), 0, "8 parts = 64, one part = 8, larger = 5\u00d78 = 40.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A \u20b91,500 prize is split between two teams as 2 : 3. The larger amount is:", List.of("\u20b9900", "\u20b9600", "\u20b9750", "\u20b91,000"), 0, "5 parts = 1500, one part = 300, larger = 3\u00d7300 = \u20b9900.", "EASY", WP), new GeneratedQuestion("\u20b94,800 is shared among three workers as 1 : 2 : 3 by hours worked. The hardest worker gets:", List.of("\u20b92,400", "\u20b91,600", "\u20b9800", "\u20b92,000"), 0, "6 parts = 4800, one part = 800, largest = 3\u00d7800 = \u20b92,400.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice chain() {
        LessonPractice lp = new LessonPractice("ratio-chain", TOPIC, "Chaining ratios together");
        lp.concept(rng -> {
            int p = QBuilder.pick(rng, 2, 3, 4, 5);
            int qq = QBuilder.pick(rng, 3, 4, 5, 6);
            int r = QBuilder.pick(rng, 2, 3, 4, 5);
            int sq = QBuilder.pick(rng, 3, 5, 6, 7);
            int ac1 = p * r;
            int ac2 = qq * sq;
            int g = RatiosPractice.gcd(ac1, ac2);
            return QBuilder.build(rng, "If a : b = " + p + " : " + qq + " and b : c = " + r + " : " + sq + ", what is a : c in simplest form?", ac1 / g + " : " + ac2 / g, "a : c = (" + p + "\u00d7" + r + ") : (" + qq + "\u00d7" + sq + ") = " + ac1 + " : " + ac2 + " = " + ac1 / g + " : " + ac2 / g + ".", "MEDIUM", EX, ac1 + " : " + ac2, ac2 / g + " : " + ac1 / g, p + " : " + sq, ac1 / g + 1 + " : " + ac2 / g);
        }, rng -> {
            int p = QBuilder.pick(rng, 2, 3, 4);
            int qq = QBuilder.pick(rng, 3, 4, 6);
            int r = QBuilder.pick(rng, 2, 3, 5);
            int sq = QBuilder.pick(rng, 4, 5, 7);
            int L = RatiosPractice.lcm(qq, r);
            int A = p * (L / qq);
            int C = sq * (L / r);
            return QBuilder.build(rng, "If a : b = " + p + " : " + qq + " and b : c = " + r + " : " + sq + ", then a : b : c = ?", A + " : " + L + " : " + C, "Make b the same (LCM of " + qq + " and " + r + " = " + L + "): a = " + A + ", b = " + L + ", c = " + C + ".", "HARD", EX, p + " : " + qq + " : " + sq, A + " : " + L + " : " + (C + 1), A + 1 + " : " + L + " : " + C, C + " : " + L + " : " + A);
        });
        lp.word(rng -> {
            int p = QBuilder.pick(rng, 2, 3, 4);
            int qq = QBuilder.pick(rng, 3, 4, 5);
            int r = QBuilder.pick(rng, 2, 3, 4);
            int sq = QBuilder.pick(rng, 3, 5, 6);
            int L = RatiosPractice.lcm(qq, r);
            int A = p * (L / qq);
            int C = sq * (L / r);
            int g = RatiosPractice.gcd(A, C);
            return QBuilder.build(rng, "In a zoo, cats : dogs = " + p + " : " + qq + " and dogs : birds = " + r + " : " + sq + ". What is the ratio of cats to birds (simplest form)?", A / g + " : " + C / g, "Link through dogs: cats : birds = " + A + " : " + C + " = " + A / g + " : " + C / g + ".", "HARD", CWP, A + " : " + C, p + " : " + sq, C / g + " : " + A / g, A / g + 1 + " : " + C / g);
        });
        lp.classicConcept(new GeneratedQuestion("If a : b = 2 : 3 and b : c = 4 : 5, then a : c is:", List.of("8 : 15", "2 : 5", "5 : 8", "3 : 5"), 0, "a : c = (2\u00d74) : (3\u00d75) = 8 : 15.", "MEDIUM", EX), new GeneratedQuestion("If x : y = 3 : 4 and y : z = 6 : 7, then x : y : z is:", List.of("9 : 12 : 14", "3 : 4 : 7", "3 : 6 : 7", "9 : 12 : 7"), 0, "Make y common (LCM 12): x : y : z = 9 : 12 : 14.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A's pay : B's pay = 2 : 3 and B's pay : C's pay = 4 : 5. A's pay : C's pay is:", List.of("8 : 15", "2 : 5", "3 : 5", "8 : 12"), 0, "A : C = (2\u00d74) : (3\u00d75) = 8 : 15.", "MEDIUM", WP), new GeneratedQuestion("In a recipe, water : milk = 1 : 2 and milk : cream = 3 : 1. Then water : cream is:", List.of("3 : 2", "1 : 2", "2 : 3", "3 : 1"), 0, "Make milk common (6): water : milk : cream = 3 : 6 : 2, so water : cream = 3 : 2.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice proportion() {
        LessonPractice lp = new LessonPractice("ratio-proportion", TOPIC, "Proportion: direct vs inverse");
        lp.concept(rng -> {
            int c = QBuilder.range(rng, 5, 25);
            int x = QBuilder.range(rng, 2, 9);
            int y = QBuilder.range(rng, 10, 20);
            int cost = x * c;
            int ans = y * c;
            return QBuilder.build(rng, "If " + x + " pens cost \u20b9" + cost + ", how much do " + y + " pens cost (at the same rate)?", "\u20b9" + ans, "One pen costs " + cost + " \u00f7 " + x + " = \u20b9" + c + ", so " + y + " pens cost " + y + " \u00d7 " + c + " = \u20b9" + ans + ".", "EASY", EX, "\u20b9" + cost * y, "\u20b9" + (ans + c), "\u20b9" + (cost + y), "\u20b9" + (ans - c));
        }, rng -> {
            int workers1 = QBuilder.pick(rng, 6, 8, 9, 10, 12);
            int days1 = QBuilder.pick(rng, 6, 8, 9, 10, 12, 15);
            int work = workers1 * days1;
            int workers2 = RatiosPractice.divisorOf(rng, work, workers1);
            int days2 = work / workers2;
            return QBuilder.build(rng, workers1 + " workers finish a job in " + days1 + " days. How many days will " + workers2 + " workers take (working at the same rate)?", RatiosPractice.s(days2), "Work is constant: workers \u00d7 days = " + work + ". With " + workers2 + " workers, days = " + work + " \u00f7 " + workers2 + " = " + days2 + ".", "MEDIUM", EX, RatiosPractice.s(days1), RatiosPractice.s(days2 + 1), RatiosPractice.s(days2 - 1), RatiosPractice.s(work / (workers2 + 1)));
        });
        lp.word(rng -> {
            int a = QBuilder.pick(rng, 4, 5, 6, 8);
            int d = QBuilder.pick(rng, 6, 8, 10, 12);
            int work = a * d;
            int b = RatiosPractice.divisorOf(rng, work, a);
            int d2 = work / b;
            return QBuilder.build(rng, a + " taps fill a tank in " + d + " hours. How long will " + b + " taps take to fill it?", d2 + " hours", "taps \u00d7 hours is constant = " + work + ". With " + b + " taps: " + work + " \u00f7 " + b + " = " + d2 + " hours.", "MEDIUM", WP, d + " hours", d2 + 1 + " hours", d2 - 1 + " hours", work / (b + 1) + " hours");
        }, rng -> {
            int m = QBuilder.pick(rng, 2, 3, 4);
            int d = QBuilder.pick(rng, 2, 3, 4);
            int u = QBuilder.pick(rng, 10, 12, 20, 24, 30);
            int x = QBuilder.pick(rng, 2, 3);
            int y = QBuilder.pick(rng, 2, 3);
            int m2 = m * x;
            int d2 = d * y;
            int u2 = u * x * y;
            return QBuilder.build(rng, "If " + m + " machines make " + u + " units in " + d + " days, how many units do " + m2 + " machines make in " + d2 + " days?", RatiosPractice.s(u2), "Output scales with both machines and days: " + u + " \u00d7 (" + m2 + "/" + m + ") \u00d7 (" + d2 + "/" + d + ") = " + u2 + " units.", "HARD", CWP, RatiosPractice.s(u * x), RatiosPractice.s(u * y), RatiosPractice.s(u2 + u), RatiosPractice.s(u * x * y / 2));
        });
        lp.classicConcept(new GeneratedQuestion("If 5 kg of rice costs \u20b9250, the cost of 8 kg is:", List.of("\u20b9400", "\u20b9350", "\u20b9450", "\u20b9320"), 0, "Per kg = 250 \u00f7 5 = \u20b950, so 8 kg = 8 \u00d7 50 = \u20b9400 (direct proportion).", "EASY", EX), new GeneratedQuestion("15 men finish a wall in 8 days. How many days for 10 men?", List.of("12", "10", "16", "6"), 0, "men \u00d7 days = 120 (constant). 120 \u00f7 10 = 12 days (inverse proportion).", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A car travels 240 km on 16 litres. How far on 10 litres (same efficiency)?", List.of("150 km", "120 km", "160 km", "180 km"), 0, "Per litre = 240 \u00f7 16 = 15 km, so 10 litres \u2192 150 km (direct).", "EASY", WP), new GeneratedQuestion("6 pumps empty a tank in 20 minutes. If 4 pumps fail, how long do the rest take?", List.of("60 min", "30 min", "40 min", "120 min"), 0, "pumps \u00d7 time = 120. With 2 pumps left: 120 \u00f7 2 = 60 minutes (inverse).", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice partnership() {
        LessonPractice lp = new LessonPractice("ratio-partnership", TOPIC, "Partnership: sharing profit fairly");
        lp.concept(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int u = QBuilder.range(rng, 1000, 5000);
            int part = QBuilder.range(rng, 200, 900);
            int aInv = pq[0] * u;
            int bInv = pq[1] * u;
            int profit = (pq[0] + pq[1]) * part;
            int aShare = pq[0] * part;
            return QBuilder.build(rng, "A invests \u20b9" + aInv + " and B invests \u20b9" + bInv + ". They share a profit of \u20b9" + profit + " in proportion to investment. What is A's share?", "\u20b9" + aShare, "Investment ratio = " + pq[0] + " : " + pq[1] + " (" + (pq[0] + pq[1]) + " parts). One part of profit = " + profit + " \u00f7 " + (pq[0] + pq[1]) + " = " + part + ", so A gets " + pq[0] + "\u00d7" + part + " = \u20b9" + aShare + ".", "MEDIUM", EX, "\u20b9" + pq[1] * part, "\u20b9" + profit / 2, "\u20b9" + (aShare + part), "\u20b9" + (aShare - part));
        });
        lp.word(rng -> {
            int[] pq = RatiosPractice.pair(rng);
            int u = QBuilder.range(rng, 1000, 4000);
            int part = QBuilder.range(rng, 200, 800);
            int aInv = pq[0] * u;
            int bInv = pq[1] * u;
            int profit = (pq[0] + pq[1]) * part;
            int bShare = pq[1] * part;
            String a = QBuilder.pick(rng, NAMES);
            String b = QBuilder.pick(rng, NAMES);
            return QBuilder.build(rng, a + " puts in \u20b9" + aInv + " and " + b + " puts in \u20b9" + bInv + " for the same time. A profit of \u20b9" + profit + " is shared by investment. What is " + b + "'s share?", "\u20b9" + bShare, "Ratio " + pq[0] + " : " + pq[1] + ", one part = " + part + ", so " + b + " gets " + pq[1] + "\u00d7" + part + " = \u20b9" + bShare + ".", "MEDIUM", WP, "\u20b9" + pq[0] * part, "\u20b9" + profit / 2, "\u20b9" + (bShare + part), "\u20b9" + (bShare - part));
        }, rng -> {
            int a = QBuilder.pick(rng, 2000, 3000, 4000);
            int ta = QBuilder.pick(rng, 6, 8, 12);
            int b = QBuilder.pick(rng, 3000, 5000, 6000);
            int tb = QBuilder.pick(rng, 4, 6, 10);
            int wa = a / 1000 * ta;
            int wb = b / 1000 * tb;
            int g = RatiosPractice.gcd(wa, wb);
            int part = QBuilder.range(rng, 300, 900);
            int profit = (wa + wb) / g * part;
            int aShare = wa / g * part;
            return QBuilder.build(rng, "A invests \u20b9" + a + " for " + ta + " months and B invests \u20b9" + b + " for " + tb + " months. A profit of \u20b9" + profit + " is shared by money\u00d7time. What is A's share?", "\u20b9" + aShare, "Weights = money\u00d7time = " + wa + " : " + wb + " = " + wa / g + " : " + wb / g + ". One part of profit = " + part + ", so A gets " + wa / g + "\u00d7" + part + " = \u20b9" + aShare + ".", "HARD", CWP, "\u20b9" + wb / g * part, "\u20b9" + profit / 2, "\u20b9" + (aShare + part), "\u20b9" + (aShare - part));
        });
        lp.classicConcept(new GeneratedQuestion("A and B invest \u20b94,000 and \u20b96,000. A profit of \u20b91,000 is shared by investment. A's share is:", List.of("\u20b9400", "\u20b9600", "\u20b9500", "\u20b9450"), 0, "Ratio 4000 : 6000 = 2 : 3 (5 parts). A = (2/5)\u00d71000 = \u20b9400.", "MEDIUM", EX), new GeneratedQuestion("Three partners invest in the ratio 1 : 2 : 3. Of a \u20b96,000 profit, the largest share is:", List.of("\u20b93,000", "\u20b92,000", "\u20b91,000", "\u20b92,500"), 0, "6 parts = 6000, one part = 1000, largest = 3\u00d71000 = \u20b93,000.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("X invests \u20b95,000 for 12 months, Y invests \u20b96,000 for 10 months. Profit \u20b91,200 by money\u00d7time. X's share is:", List.of("\u20b9600", "\u20b9500", "\u20b9700", "\u20b9720"), 0, "Weights 5000\u00d712 : 6000\u00d710 = 60 : 60 = 1 : 1, so X gets half = \u20b9600.", "HARD", CWP), new GeneratedQuestion("Two friends start a stall investing \u20b9300 and \u20b9500. A \u20b9160 profit is shared fairly. The smaller share is:", List.of("\u20b960", "\u20b9100", "\u20b980", "\u20b940"), 0, "Ratio 3 : 5 (8 parts). Smaller = (3/8)\u00d7160 = \u20b960.", "MEDIUM", WP));
        return lp.sheets(20, 10, 20);
    }

    private static int divisorOf(Random rng, int work, int avoid) {
        ArrayList<Integer> divs = new ArrayList<Integer>();
        for (int d = 2; d <= 20; ++d) {
            if (work % d != 0 || d == avoid) continue;
            divs.add(d);
        }
        if (divs.isEmpty()) {
            return avoid;
        }
        return (Integer)divs.get(rng.nextInt(divs.size()));
    }
}

