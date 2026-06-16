/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class CountingPractice {
    private static final String TOPIC = "permutations-combinations";
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private CountingPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(CountingPractice.multiplication());
        reg.add(CountingPractice.factorial());
        reg.add(CountingPractice.permutation());
        reg.add(CountingPractice.combination());
        reg.add(CountingPractice.circularRepeat());
    }

    private static int fact(int n) {
        int r = 1;
        for (int i = 2; i <= n; ++i) {
            r *= i;
        }
        return r;
    }

    private static int nPr(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; ++i) {
            ans *= n - i;
        }
        return ans;
    }

    private static int nCr(int n, int r) {
        r = Math.min(r, n - r);
        int num = 1;
        int den = 1;
        for (int i = 1; i <= r; ++i) {
            num *= n - r + i;
            den *= i;
        }
        return num / den;
    }

    private static LessonPractice multiplication() {
        LessonPractice lp = new LessonPractice("cnt-multiplication", TOPIC, "The counting (multiplication) principle");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 2, 8);
            int b = QBuilder.range(rng, 2, 7);
            int total = a * b;
            return QBuilder.build(rng, "If a task has " + a + " choices at step 1 and " + b + " choices at step 2, how many total outcomes are possible?", Integer.toString(total), "Multiply stage-wise choices: " + a + " \u00d7 " + b + " = " + total + ".", "EASY", EX, Integer.toString(total + a), Integer.toString(total - a), Integer.toString(a + b), Integer.toString(total + 1));
        }, rng -> {
            int letters = QBuilder.pick(rng, 3, 4, 5);
            int digits = QBuilder.pick(rng, 4, 5, 6, 7);
            int total = letters * digits;
            return QBuilder.build(rng, "A code has one letter slot and one digit slot. If letters available = " + letters + " and digits available = " + digits + ", how many distinct codes?", Integer.toString(total), "Choices are independent: " + letters + " \u00d7 " + digits + " = " + total + ".", "EASY", EX, Integer.toString(letters + digits), Integer.toString(total + digits), Integer.toString(total - digits), Integer.toString(total + 2));
        });
        lp.word(rng -> {
            int shirts = QBuilder.range(rng, 2, 6);
            int trousers = QBuilder.range(rng, 2, 5);
            int outfits = shirts * trousers;
            return QBuilder.build(rng, "A student has " + shirts + " shirts and " + trousers + " trousers. How many shirt-trouser outfits can be made?", Integer.toString(outfits), "Each shirt pairs with each trouser: " + shirts + " \u00d7 " + trousers + " = " + outfits + ".", "EASY", WP, Integer.toString(shirts + trousers), Integer.toString(outfits + shirts), Integer.toString(outfits - shirts), Integer.toString(outfits + 1));
        }, rng -> {
            int starters = QBuilder.pick(rng, 3, 4, 5);
            int mains = QBuilder.pick(rng, 4, 5, 6);
            int desserts = QBuilder.pick(rng, 2, 3, 4);
            int total = starters * mains * desserts;
            return QBuilder.build(rng, "A menu lets you choose 1 starter from " + starters + ", 1 main from " + mains + " and 1 dessert from " + desserts + ". How many meals are possible?", Integer.toString(total), "Multiply all independent stages: " + starters + " \u00d7 " + mains + " \u00d7 " + desserts + " = " + total + ".", "HARD", CWP, Integer.toString(starters + mains + desserts), Integer.toString(total + starters), Integer.toString(total - starters), Integer.toString(total + 2));
        });
        lp.classicConcept(new GeneratedQuestion("How many outcomes are there if you roll one die and toss one coin?", List.of("12", "6", "8", "10"), 0, "Die gives 6 outcomes, coin gives 2; total = 6\u00d72 = 12.", "EASY", EX), new GeneratedQuestion("How many 2-digit numbers can be formed using digits 1-5 if repetition is allowed?", List.of("25", "20", "10", "30"), 0, "5 choices for tens and 5 for units, so 5\u00d75 = 25.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A lock uses one letter (A,B,C,D) followed by one digit (1-6). Number of passwords:", List.of("24", "10", "16", "20"), 0, "4 letter choices \u00d7 6 digit choices = 24.", "EASY", WP), new GeneratedQuestion("A student chooses one elective from 5 and one lab from 4. Number of plans:", List.of("20", "9", "16", "24"), 0, "5\u00d74 = 20 plans.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice factorial() {
        LessonPractice lp = new LessonPractice("cnt-factorial", TOPIC, "Factorials \u2014 counting arrangements");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 3, 7);
            return QBuilder.build(rng, "What is " + n + "! ?", Integer.toString(CountingPractice.fact(n)), n + "! means multiplying from " + n + " to 1: value = " + CountingPractice.fact(n) + ".", "EASY", EX, Integer.toString(CountingPractice.fact(n - 1)), Integer.toString(CountingPractice.fact(n) + n), Integer.toString(CountingPractice.fact(n) - n), Integer.toString(n * n));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 8);
            return QBuilder.build(rng, "In how many ways can " + n + " distinct books be arranged on a shelf?", Integer.toString(CountingPractice.fact(n)), "Arrangement of n distinct items in a row = n! = " + CountingPractice.fact(n) + ".", "EASY", EX, Integer.toString(CountingPractice.fact(n - 1)), Integer.toString(CountingPractice.fact(n) + 1), Integer.toString(CountingPractice.fact(n) - 1), Integer.toString(CountingPractice.nPr(n, n - 1)));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 3, 7);
            return QBuilder.build(rng, n + " students stand in a queue for photo-shoot. Number of line-ups?", Integer.toString(CountingPractice.fact(n)), "Queue order matters: total arrangements = " + n + "! = " + CountingPractice.fact(n) + ".", "MEDIUM", WP, Integer.toString(CountingPractice.fact(n - 1)), Integer.toString(CountingPractice.fact(n) + n), Integer.toString(CountingPractice.fact(n) - n), Integer.toString(n * (n - 1)));
        }, rng -> {
            int n = QBuilder.range(rng, 4, 8);
            int fixed = QBuilder.range(rng, 1, 2);
            int free = n - fixed;
            return QBuilder.build(rng, "In a row of " + n + " seats, " + fixed + " specific person(s) are fixed at the leftmost seats. In how many ways can the rest sit?", Integer.toString(CountingPractice.fact(free)), "Only the remaining " + free + " people move, so arrangements = " + free + "! = " + CountingPractice.fact(free) + ".", "HARD", CWP, Integer.toString(CountingPractice.fact(n)), Integer.toString(CountingPractice.fact(free - 1)), Integer.toString(CountingPractice.fact(free) + 1), Integer.toString(free * free));
        });
        lp.classicConcept(new GeneratedQuestion("In how many ways can 5 people stand in a row?", List.of("120", "25", "60", "20"), 0, "5! = 120.", "EASY", EX), new GeneratedQuestion("The value of 0! is:", List.of("1", "0", "Undefined", "10"), 0, "By definition, 0! = 1.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("How many ways can 6 distinct trophies be arranged on a shelf?", List.of("720", "120", "360", "600"), 0, "6! = 720.", "MEDIUM", WP), new GeneratedQuestion("Eight runners line up for a photo. If one fixed captain must stand first, arrangements are:", List.of("5040", "40320", "720", "2520"), 0, "Captain fixed, remaining 7 arranged: 7! = 5040.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice permutation() {
        LessonPractice lp = new LessonPractice("cnt-permutation", TOPIC, "Permutations: when order matters");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 6, 10);
            int r = QBuilder.range(rng, 2, 4);
            int ans = CountingPractice.nPr(n, r);
            return QBuilder.build(rng, "Find " + n + "P" + r + ".", Integer.toString(ans), n + "P" + r + " = n!/(n-r)! = " + ans + ".", "MEDIUM", EX, Integer.toString(CountingPractice.nCr(n, r)), Integer.toString(ans + n), Integer.toString(ans - n), Integer.toString(n * r));
        }, rng -> {
            int n = QBuilder.range(rng, 5, 9);
            int r = QBuilder.range(rng, 2, 4);
            int ans = CountingPractice.nPr(n, r);
            return QBuilder.build(rng, "How many ordered " + r + "-digit codes can be formed from " + n + " distinct symbols without repetition?", Integer.toString(ans), "Order matters and no repeats, so count = " + n + "P" + r + " = " + ans + ".", "MEDIUM", EX, Integer.toString(CountingPractice.nCr(n, r)), Integer.toString(ans + r), Integer.toString(ans - r), Integer.toString(CountingPractice.fact(r)));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 7, 10);
            int r = 3;
            int ans = CountingPractice.nPr(n, r);
            return QBuilder.build(rng, "From " + n + " runners, medals Gold/Silver/Bronze are awarded. Number of outcomes?", Integer.toString(ans), "Medal positions are ordered, so use permutation: " + n + "P3 = " + ans + ".", "MEDIUM", WP, Integer.toString(CountingPractice.nCr(n, r)), Integer.toString(ans + n), Integer.toString(ans - n), Integer.toString(CountingPractice.fact(r)));
        }, rng -> {
            int digits = 10;
            int r = 4;
            int ans = 9 * CountingPractice.nPr(9, 3);
            return QBuilder.build(rng, "How many 4-digit numbers can be formed from 0-9 with no repetition?", Integer.toString(ans), "First digit cannot be 0 (9 choices). Remaining 3 places: 9P3. Total = 9\u00d79P3 = " + ans + ".", "HARD", CWP, Integer.toString(CountingPractice.nPr(digits, r)), Integer.toString(ans + 9), Integer.toString(ans - 9), Integer.toString(CountingPractice.nCr(digits, r)));
        });
        lp.classicConcept(new GeneratedQuestion("How many 3-digit numbers can be formed from 1-9 with no repetition?", List.of("504", "729", "720", "84"), 0, "9P3 = 9\u00d78\u00d77 = 504.", "MEDIUM", EX), new GeneratedQuestion("The value of 7P2 is:", List.of("42", "21", "35", "49"), 0, "7P2 = 7\u00d76 = 42.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("From 8 students, captain and vice-captain are chosen. Number of choices:", List.of("56", "28", "64", "16"), 0, "Order matters (captain vs vice-captain): 8P2 = 56.", "MEDIUM", WP), new GeneratedQuestion("How many 5-letter arrangements can be made from 7 distinct letters without repetition?", List.of("2520", "21", "5040", "210"), 0, "7P5 = 7\u00d76\u00d75\u00d74\u00d73 = 2520.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice combination() {
        LessonPractice lp = new LessonPractice("cnt-combination", TOPIC, "Combinations: when order doesn't matter");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 6, 12);
            int r = QBuilder.range(rng, 2, 4);
            int ans = CountingPractice.nCr(n, r);
            return QBuilder.build(rng, "Find " + n + "C" + r + ".", Integer.toString(ans), n + "C" + r + " = n!/[r!(n-r)!] = " + ans + ".", "MEDIUM", EX, Integer.toString(CountingPractice.nPr(n, r)), Integer.toString(ans + n), Integer.toString(ans - n), Integer.toString(r * n));
        }, rng -> {
            int n = QBuilder.range(rng, 5, 10);
            int r = 2;
            int ans = CountingPractice.nCr(n, r);
            return QBuilder.build(rng, "How many teams of 2 can be chosen from " + n + " people?", Integer.toString(ans), "Order does not matter, so use combination: " + n + "C2 = " + ans + ".", "EASY", EX, Integer.toString(CountingPractice.nPr(n, r)), Integer.toString(ans + 1), Integer.toString(ans - 1), Integer.toString(n));
        });
        lp.word(rng -> {
            int men = QBuilder.range(rng, 4, 7);
            int women = QBuilder.range(rng, 3, 6);
            int chooseMen = 2;
            int chooseWomen = 1;
            int ans = CountingPractice.nCr(men, chooseMen) * CountingPractice.nCr(women, chooseWomen);
            return QBuilder.build(rng, "A committee of 3 must have exactly 2 men and 1 woman. If there are " + men + " men and " + women + " women, how many committees?", Integer.toString(ans), "Choose men and women separately: " + men + "C2 \u00d7 " + women + "C1 = " + ans + ".", "HARD", WP, Integer.toString(CountingPractice.nCr(men + women, 3)), Integer.toString(ans + men), Integer.toString(ans - men), Integer.toString(CountingPractice.nCr(men, 2)));
        }, rng -> {
            int n = QBuilder.range(rng, 8, 12);
            int r = QBuilder.range(rng, 3, 5);
            int ans = CountingPractice.nCr(n, r);
            return QBuilder.build(rng, "From " + n + " books, in how many ways can a student select " + r + " books?", Integer.toString(ans), "Selection ignores order, so total = " + n + "C" + r + " = " + ans + ".", "MEDIUM", CWP, Integer.toString(CountingPractice.nPr(n, r)), Integer.toString(ans + r), Integer.toString(ans - r), Integer.toString(CountingPractice.nCr(n, n - r)));
        });
        lp.classicConcept(new GeneratedQuestion("How many ways to choose 2 books from 6?", List.of("15", "12", "30", "20"), 0, "6C2 = 6\u00d75/2 = 15.", "EASY", EX), new GeneratedQuestion("The value of 8C3 is:", List.of("56", "336", "24", "64"), 0, "8C3 = 56.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A committee of 3 is chosen from 4 men and 3 women, with exactly 2 men. Number of ways:", List.of("18", "12", "9", "24"), 0, "4C2 \u00d7 3C1 = 6 \u00d7 3 = 18.", "HARD", WP), new GeneratedQuestion("From 10 applicants, 4 are shortlisted. Number of shortlists:", List.of("210", "5040", "252", "120"), 0, "Order not relevant: 10C4 = 210.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice circularRepeat() {
        LessonPractice lp = new LessonPractice("cnt-circular-repeat", TOPIC, "Circular permutations and repeated items");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 4, 8);
            int ans = CountingPractice.fact(n - 1);
            return QBuilder.build(rng, "In how many ways can " + n + " distinct people sit around a round table?", Integer.toString(ans), "Circular arrangements of n distinct people = (n-1)! = " + ans + ".", "MEDIUM", EX, Integer.toString(CountingPractice.fact(n)), Integer.toString(ans + n), Integer.toString(ans - 1), Integer.toString(CountingPractice.nPr(n, 2)));
        }, rng -> {
            String word = QBuilder.pick(rng, "LEVEL", "RADAR", "MOMENT", "BANANA");
            int ans = "LEVEL".equals(word) ? CountingPractice.fact(5) / (CountingPractice.fact(2) * CountingPractice.fact(2)) : ("RADAR".equals(word) ? CountingPractice.fact(5) / CountingPractice.fact(2) : ("MOMENT".equals(word) ? CountingPractice.fact(6) / CountingPractice.fact(2) : CountingPractice.fact(6) / (CountingPractice.fact(3) * CountingPractice.fact(2))));
            return QBuilder.build(rng, "How many distinct arrangements can be made using all letters of " + word + "?", Integer.toString(ans), "Use repeated-item formula n! divided by repeat factorials. Result = " + ans + ".", "HARD", EX, Integer.toString(ans + 1), Integer.toString(ans - 1), Integer.toString(word.length()), Integer.toString(CountingPractice.fact(word.length())));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 5, 8);
            int ans = CountingPractice.fact(n - 1);
            return QBuilder.build(rng, n + " friends sit around a circular campfire. Number of seatings?", Integer.toString(ans), "Rotations are identical around a circle, so count = (n-1)! = " + ans + ".", "MEDIUM", WP, Integer.toString(CountingPractice.fact(n)), Integer.toString(ans + 2), Integer.toString(ans - 2), Integer.toString(n * (n - 1)));
        }, rng -> {
            int n = QBuilder.pick(rng, 6, 7, 8);
            int repeats = 2;
            int ans = CountingPractice.fact(n) / CountingPractice.fact(repeats);
            return QBuilder.build(rng, "A nameplate has " + n + " letters where exactly one letter repeats twice. How many distinct arrangements are possible?", Integer.toString(ans), "If one letter repeats twice, divide by 2!: arrangements = " + n + "!/2 = " + ans + ".", "HARD", CWP, Integer.toString(CountingPractice.fact(n)), Integer.toString(ans + n), Integer.toString(ans - n), Integer.toString(CountingPractice.fact(n - 1)));
        });
        lp.classicConcept(new GeneratedQuestion("The number of circular arrangements of 6 people is:", List.of("120", "720", "60", "24"), 0, "(6-1)! = 120.", "MEDIUM", EX), new GeneratedQuestion("Distinct arrangements of letters of LEVEL are:", List.of("30", "60", "120", "20"), 0, "5!/(2!2!) = 30.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("How many ways can 7 runners stand around a circular track for a photo?", List.of("720", "5040", "840", "360"), 0, "Circular arrangement count = (7-1)! = 720.", "MEDIUM", WP), new GeneratedQuestion("Distinct arrangements of BANANA are:", List.of("60", "120", "30", "180"), 0, "6!/(3!2!) = 60.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

