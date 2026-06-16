/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class AlgebraPractice {
    private static final String TOPIC = "algebra";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom"};
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private AlgebraPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(AlgebraPractice.variable());
        reg.add(AlgebraPractice.linear());
        reg.add(AlgebraPractice.simultaneous());
        reg.add(AlgebraPractice.quadratic());
        reg.add(AlgebraPractice.identities());
        reg.add(AlgebraPractice.inequalities());
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static String x(int v) {
        return "x = " + v;
    }

    private static LessonPractice variable() {
        LessonPractice lp = new LessonPractice("alg-variable", TOPIC, "Why letters? The idea of a variable");
        lp.concept(rng -> {
            int b = QBuilder.range(rng, 3, 25);
            int xv = QBuilder.range(rng, 2, 30);
            int r = xv + b;
            return QBuilder.build(rng, "A number increased by " + b + " gives " + r + ". What is the number?", AlgebraPractice.s(xv), "Let the number be x. x + " + b + " = " + r + ", so x = " + r + " \u2212 " + b + " = " + xv + ".", "EASY", EX, AlgebraPractice.s(r), AlgebraPractice.s(r + b), AlgebraPractice.s(b), AlgebraPractice.s(xv + 1));
        }, rng -> {
            int b = QBuilder.range(rng, 1, 15);
            int xv = QBuilder.range(rng, 2, 20);
            int r = 2 * xv + b;
            return QBuilder.build(rng, "Twice a number plus " + b + " equals " + r + ". What is the number?", AlgebraPractice.s(xv), "2x + " + b + " = " + r + " \u2192 2x = " + (r - b) + " \u2192 x = " + xv + ".", "MEDIUM", EX, AlgebraPractice.s(r - b), AlgebraPractice.s(xv + 1), AlgebraPractice.s(xv - 1), AlgebraPractice.s(2 * xv));
        }, rng -> {
            int b = QBuilder.range(rng, 2, 12);
            return QBuilder.build(rng, "Which expression means '" + b + " more than twice a number n'?", "2n + " + b, "'Twice a number' is 2n; '" + b + " more than' adds " + b + ": 2n + " + b + ".", "EASY", EX, "2(n + " + b + ")", "n + " + b, b + "n + 2", "2n \u2212 " + b);
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int b = QBuilder.range(rng, 3, 20);
            int start = QBuilder.range(rng, 5, 40);
            int r = start + b;
            return QBuilder.build(rng, name + " has some marbles. After winning " + b + " more, " + name + " has " + r + " marbles. How many were there at first?", AlgebraPractice.s(start), "Let the start be x. x + " + b + " = " + r + ", so x = " + start + ".", "EASY", WP, AlgebraPractice.s(r), AlgebraPractice.s(r + b), AlgebraPractice.s(b), AlgebraPractice.s(start - 1));
        }, rng -> {
            int a = QBuilder.range(rng, 3, 9);
            int xv = QBuilder.range(rng, 4, 20);
            int r = 3 * (xv - a);
            return QBuilder.build(rng, "A number has " + a + " subtracted from it, and the result is then tripled to give " + r + ". What is the number?", AlgebraPractice.s(xv), "3(x \u2212 " + a + ") = " + r + " \u2192 x \u2212 " + a + " = " + r / 3 + " \u2192 x = " + xv + ".", "HARD", CWP, AlgebraPractice.s(r / 3), AlgebraPractice.s(xv + a), AlgebraPractice.s(r), AlgebraPractice.s(xv - 1));
        });
        lp.classicConcept(new GeneratedQuestion("If x + 7 = 11, then x is:", List.of("4", "18", "7", "3"), 0, "Subtract 7 from both sides: x = 4.", "EASY", EX), new GeneratedQuestion("'5 less than three times a number n' is written as:", List.of("3n \u2212 5", "5 \u2212 3n", "3(n \u2212 5)", "5n \u2212 3"), 0, "Three times n is 3n; '5 less than' subtracts 5: 3n \u2212 5.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A pencil costs \u20b92 more than an eraser. Together they cost \u20b910. The eraser costs:", List.of("\u20b94", "\u20b96", "\u20b95", "\u20b93"), 0, "Let eraser = x. x + (x+2) = 10 \u2192 2x = 8 \u2192 x = \u20b94.", "MEDIUM", WP), new GeneratedQuestion("I think of a number, double it, add 6, and get 20. The number is:", List.of("7", "13", "10", "8"), 0, "2x + 6 = 20 \u2192 2x = 14 \u2192 x = 7.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice linear() {
        LessonPractice lp = new LessonPractice("alg-linear", TOPIC, "Solving linear equations");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 2, 9);
            int xv = QBuilder.range(rng, 2, 15);
            int b = QBuilder.range(rng, 1, 20);
            int c = a * xv + b;
            return QBuilder.build(rng, "Solve: " + a + "x + " + b + " = " + c + ".", AlgebraPractice.x(xv), "Subtract " + b + ": " + a + "x = " + (c - b) + ". Divide by " + a + ": x = " + xv + ".", "EASY", EX, AlgebraPractice.x(xv + 1), AlgebraPractice.x(xv - 1), AlgebraPractice.x(c - b), AlgebraPractice.x(c));
        }, rng -> {
            int a = QBuilder.range(rng, 2, 9);
            int xv = QBuilder.range(rng, 3, 15);
            int b = QBuilder.range(rng, 1, 20);
            int c = a * xv - b;
            return QBuilder.build(rng, "Solve: " + a + "x \u2212 " + b + " = " + c + ".", AlgebraPractice.x(xv), "Add " + b + ": " + a + "x = " + (c + b) + ". Divide by " + a + ": x = " + xv + ".", "EASY", EX, AlgebraPractice.x(xv + 1), AlgebraPractice.x(xv - 1), AlgebraPractice.x(c + b), AlgebraPractice.x(c));
        }, rng -> {
            int a = QBuilder.range(rng, 4, 9);
            int d = QBuilder.range(rng, 1, 3);
            int xv = QBuilder.range(rng, 2, 12);
            int b = QBuilder.range(rng, 1, 10);
            int e = (a - d) * xv + b;
            return QBuilder.build(rng, "Solve: " + a + "x + " + b + " = " + d + "x + " + e + ".", AlgebraPractice.x(xv), "Bring x's together: (" + a + "\u2212" + d + ")x = " + e + "\u2212" + b + " \u2192 " + (a - d) + "x = " + (e - b) + " \u2192 x = " + xv + ".", "MEDIUM", EX, AlgebraPractice.x(xv + 1), AlgebraPractice.x(xv - 1), AlgebraPractice.x(e - b), AlgebraPractice.x(e));
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int n = QBuilder.range(rng, 3, 8);
            int price = QBuilder.range(rng, 5, 20);
            int bag = QBuilder.range(rng, 10, 40);
            int total = n * price + bag;
            return QBuilder.build(rng, name + " buys " + n + " identical pens and a bag costing \u20b9" + bag + ". The total is \u20b9" + total + ". What does one pen cost?", "\u20b9" + price, "Let a pen be x. " + n + "x + " + bag + " = " + total + " \u2192 " + n + "x = " + (total - bag) + " \u2192 x = \u20b9" + price + ".", "MEDIUM", WP, "\u20b9" + (price + 1), "\u20b9" + (total - bag), "\u20b9" + (price - 1), "\u20b9" + total / n);
        }, rng -> {
            int first = QBuilder.range(rng, 5, 40);
            int sum = first + (first + 1) + (first + 2);
            return QBuilder.build(rng, "Three consecutive integers add up to " + sum + ". What is the smallest of them?", AlgebraPractice.s(first), "Let them be n, n+1, n+2. Their sum 3n + 3 = " + sum + " \u2192 3n = " + (sum - 3) + " \u2192 n = " + first + ".", "HARD", CWP, AlgebraPractice.s(first + 1), AlgebraPractice.s(sum / 3), AlgebraPractice.s(first - 1), AlgebraPractice.s(first + 2));
        });
        lp.classicConcept(new GeneratedQuestion("Solve: 3x \u2212 7 = 11.", List.of("x = 6", "x = 4", "x = 5", "x = 9"), 0, "Add 7: 3x = 18, then divide by 3: x = 6.", "EASY", EX), new GeneratedQuestion("Solve: 5x + 4 = 2x + 19.", List.of("x = 5", "x = 3", "x = 7", "x = 15"), 0, "3x = 15 \u2192 x = 5.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A taxi charges \u20b950 base plus \u20b912 per km. A ride costs \u20b9170. How many km?", List.of("10", "12", "8", "14"), 0, "50 + 12k = 170 \u2192 12k = 120 \u2192 k = 10.", "MEDIUM", WP), new GeneratedQuestion("The sum of two numbers is 30 and one is twice the other. The larger number is:", List.of("20", "10", "15", "18"), 0, "x + 2x = 30 \u2192 x = 10, so the larger is 2\u00d710 = 20.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice simultaneous() {
        LessonPractice lp = new LessonPractice("alg-simultaneous", TOPIC, "Two equations, two unknowns");
        lp.concept(rng -> {
            int xv = QBuilder.range(rng, 3, 15);
            int yv = QBuilder.range(rng, 1, xv - 1);
            int sum = xv + yv;
            int diff = xv - yv;
            return QBuilder.build(rng, "If x + y = " + sum + " and x \u2212 y = " + diff + ", what is x?", AlgebraPractice.s(xv), "Add the equations: 2x = " + (sum + diff) + " \u2192 x = " + xv + ".", "MEDIUM", EX, AlgebraPractice.s(yv), AlgebraPractice.s(sum), AlgebraPractice.s(diff), AlgebraPractice.s(xv + 1));
        }, rng -> {
            int xv = QBuilder.range(rng, 3, 15);
            int yv = QBuilder.range(rng, 1, xv - 1);
            int sum = xv + yv;
            int diff = xv - yv;
            return QBuilder.build(rng, "If x + y = " + sum + " and x \u2212 y = " + diff + ", what is y?", AlgebraPractice.s(yv), "Subtract: 2y = " + (sum - diff) + " \u2192 y = " + yv + ".", "MEDIUM", EX, AlgebraPractice.s(xv), AlgebraPractice.s(sum), AlgebraPractice.s(diff), AlgebraPractice.s(yv + 1));
        }, rng -> {
            int a = QBuilder.range(rng, 2, 5);
            int xv = QBuilder.range(rng, 2, 8);
            int yv = QBuilder.range(rng, 2, 12);
            int p = a * xv + yv;
            return QBuilder.build(rng, "If " + a + "x + y = " + p + " and x = " + xv + ", what is y?", AlgebraPractice.s(yv), "Substitute x = " + xv + ": " + a + "(" + xv + ") + y = " + p + " \u2192 y = " + yv + ".", "EASY", EX, AlgebraPractice.s(p), AlgebraPractice.s(p - xv), AlgebraPractice.s(yv + 1), AlgebraPractice.s(a * xv));
        });
        lp.word(rng -> {
            int apple = QBuilder.range(rng, 5, 15);
            int banana = QBuilder.range(rng, 3, 10);
            int c1 = 2 * apple + banana;
            int c2 = apple + 2 * banana;
            return QBuilder.build(rng, "2 apples and 1 banana cost \u20b9" + c1 + "; 1 apple and 2 bananas cost \u20b9" + c2 + ". What is the price of one apple?", "\u20b9" + apple, "Adding both: 3(apple+banana) = " + (c1 + c2) + ", so apple+banana = " + (c1 + c2) / 3 + ". Subtracting gives apple = \u20b9" + apple + ".", "HARD", WP, "\u20b9" + banana, "\u20b9" + (apple + 1), "\u20b9" + c1 / 2, "\u20b9" + (apple - 1));
        }, rng -> {
            int adult = QBuilder.range(rng, 30, 60);
            int child = QBuilder.range(rng, 10, adult - 5);
            int na = QBuilder.range(rng, 2, 5);
            int nc = QBuilder.range(rng, 2, 6);
            int total = na * adult + nc * child;
            return QBuilder.build(rng, na + " adult tickets and " + nc + " child tickets cost \u20b9" + total + ". If a child ticket is \u20b9" + child + ", what does an adult ticket cost?", "\u20b9" + adult, "Child tickets cost " + nc + "\u00d7" + child + " = \u20b9" + nc * child + ". Adult tickets: " + (total - nc * child) + " \u00f7 " + na + " = \u20b9" + adult + ".", "HARD", CWP, "\u20b9" + child, "\u20b9" + (adult + 5), "\u20b9" + total / (na + nc), "\u20b9" + (adult - 5));
        });
        lp.classicConcept(new GeneratedQuestion("For 2x + 3y = 12 and x = 3, find y.", List.of("2", "1", "3", "4"), 0, "2(3) + 3y = 12 \u2192 3y = 6 \u2192 y = 2.", "EASY", EX), new GeneratedQuestion("If x + y = 10 and x \u2212 y = 4, then x \u00d7 y equals:", List.of("21", "24", "20", "25"), 0, "x = 7, y = 3, so xy = 21.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("The sum of two numbers is 25 and their difference is 7. The numbers are:", List.of("16 and 9", "15 and 10", "18 and 7", "20 and 5"), 0, "x = (25+7)/2 = 16, y = 9.", "MEDIUM", WP), new GeneratedQuestion("3 pens and 2 books cost \u20b9180; 1 pen and 1 book cost \u20b970. A book costs:", List.of("\u20b930", "\u20b940", "\u20b925", "\u20b935"), 0, "From p+b=70, p=70\u2212b. Then 3(70\u2212b)+2b=180 \u2192 210\u2212b=180 \u2192 b=\u20b930.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice quadratic() {
        LessonPractice lp = new LessonPractice("alg-quadratic", TOPIC, "Quadratic equations");
        lp.concept(rng -> {
            int r1 = QBuilder.range(rng, 1, 9);
            int r2 = QBuilder.range(rng, 1, 9);
            int sum = r1 + r2;
            int prod = r1 * r2;
            return QBuilder.build(rng, "The roots of x\u00b2 \u2212 " + sum + "x + " + prod + " = 0 are:", r1 + " and " + r2, "Find two numbers adding to " + sum + " and multiplying to " + prod + ": " + r1 + " and " + r2 + ". So (x\u2212" + r1 + ")(x\u2212" + r2 + ") = 0.", "MEDIUM", EX, -r1 + " and " + -r2, r1 + " and " + (r2 + 1), r1 + 1 + " and " + r2, "1 and " + prod);
        }, rng -> {
            int a = QBuilder.pick(rng, 1, 2, 3);
            int sum = QBuilder.range(rng, 2, 12);
            int b = -a * sum;
            int c = QBuilder.range(rng, 1, 20);
            return QBuilder.build(rng, "The sum of the roots of " + a + "x\u00b2 " + (b < 0 ? "\u2212 " + -b : "+ " + b) + "x + " + c + " = 0 is:", AlgebraPractice.s(sum), "Sum of roots = \u2212b/a = " + -b + " \u00f7 " + a + " = " + sum + ".", "MEDIUM", EX, AlgebraPractice.s(-sum), AlgebraPractice.s(c / a), AlgebraPractice.s(sum + 1), AlgebraPractice.s(a));
        }, rng -> {
            int a = QBuilder.pick(rng, 1, 2, 3);
            int prod = QBuilder.range(rng, 2, 12);
            int c = a * prod;
            int b = QBuilder.range(rng, 1, 10);
            return QBuilder.build(rng, "The product of the roots of " + a + "x\u00b2 + " + b + "x + " + c + " = 0 is:", AlgebraPractice.s(prod), "Product of roots = c/a = " + c + " \u00f7 " + a + " = " + prod + ".", "MEDIUM", EX, AlgebraPractice.s(-prod), AlgebraPractice.s(b / a), AlgebraPractice.s(prod + 1), AlgebraPractice.s(c));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 4, 15);
            int prod = n * (n + 1);
            return QBuilder.build(rng, "The product of two consecutive positive integers is " + prod + ". What is the smaller integer?", AlgebraPractice.s(n), "n(n+1) = " + prod + ". Since " + n + "\u00d7" + (n + 1) + " = " + prod + ", the smaller is " + n + ".", "HARD", WP, AlgebraPractice.s(n + 1), AlgebraPractice.s(prod / 2), AlgebraPractice.s(n - 1), AlgebraPractice.s(n + 2));
        }, rng -> {
            int w = QBuilder.range(rng, 3, 12);
            int l = w + QBuilder.range(rng, 2, 6);
            int area = w * l;
            return QBuilder.build(rng, "A rectangle's length is " + (l - w) + " m more than its width and its area is " + area + " m\u00b2. What is the width?", w + " m", "Let width = x. x(x+" + (l - w) + ") = " + area + ". Testing whole numbers, x = " + w + " works (" + w + "\u00d7" + l + " = " + area + ").", "HARD", CWP, l + " m", w + 1 + " m", area / l + " m", w - 1 + " m");
        });
        lp.classicConcept(new GeneratedQuestion("The roots of x\u00b2 \u2212 5x + 6 = 0 are:", List.of("2 and 3", "\u22122 and \u22123", "1 and 6", "\u22121 and \u22126"), 0, "Factor: (x\u22122)(x\u22123) = 0, so x = 2 or 3.", "EASY", EX), new GeneratedQuestion("The sum of the roots of 2x\u00b2 \u2212 8x + 6 = 0 is:", List.of("4", "\u22124", "3", "8"), 0, "Sum of roots = \u2212b/a = 8/2 = 4.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("The product of two consecutive integers is 56. The integers are:", List.of("7 and 8", "6 and 9", "8 and 9", "5 and 11"), 0, "7\u00d78 = 56.", "MEDIUM", WP), new GeneratedQuestion("A garden's length is 3 m more than its width; its area is 40 m\u00b2. The width is:", List.of("5 m", "8 m", "4 m", "6 m"), 0, "x(x+3) = 40 \u2192 x = 5 (since 5\u00d78 = 40).", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice identities() {
        LessonPractice lp = new LessonPractice("alg-identities", TOPIC, "Identities that save time");
        lp.concept(rng -> {
            int k = QBuilder.range(rng, 3, 9);
            int ans = k * k - 2;
            return QBuilder.build(rng, "If x + 1/x = " + k + ", then x\u00b2 + 1/x\u00b2 equals:", AlgebraPractice.s(ans), "Square: (x + 1/x)\u00b2 = x\u00b2 + 2 + 1/x\u00b2 = " + k * k + ", so x\u00b2 + 1/x\u00b2 = " + k * k + " \u2212 2 = " + ans + ".", "HARD", EX, AlgebraPractice.s(k * k), AlgebraPractice.s(k * k + 2), AlgebraPractice.s(ans - 1), AlgebraPractice.s(2 * k));
        }, rng -> {
            int a = QBuilder.range(rng, 6, 20);
            int b = QBuilder.range(rng, 1, a - 1);
            int ans = a * a - b * b;
            return QBuilder.build(rng, "Using a\u00b2 \u2212 b\u00b2 = (a+b)(a\u2212b), what is " + a + "\u00b2 \u2212 " + b + "\u00b2?", AlgebraPractice.s(ans), "(" + a + "+" + b + ")(" + a + "\u2212" + b + ") = " + (a + b) + "\u00d7" + (a - b) + " = " + ans + ".", "MEDIUM", EX, AlgebraPractice.s((a + b) * (a + b)), AlgebraPractice.s(ans + 1), AlgebraPractice.s(a * a + b * b), AlgebraPractice.s((a - b) * (a - b)));
        }, rng -> {
            int k = QBuilder.range(rng, 2, 8);
            int ans = k * k + 2;
            return QBuilder.build(rng, "If x \u2212 1/x = " + k + ", then x\u00b2 + 1/x\u00b2 equals:", AlgebraPractice.s(ans), "Square: (x \u2212 1/x)\u00b2 = x\u00b2 \u2212 2 + 1/x\u00b2 = " + k * k + ", so x\u00b2 + 1/x\u00b2 = " + k * k + " + 2 = " + ans + ".", "HARD", EX, AlgebraPractice.s(k * k), AlgebraPractice.s(k * k - 2), AlgebraPractice.s(ans + 1), AlgebraPractice.s(2 * k));
        });
        lp.word(rng -> {
            int a = QBuilder.range(rng, 10, 30);
            int b = QBuilder.range(rng, 1, 9);
            int ans = a * a - b * b;
            return QBuilder.build(rng, "A square plot of side " + a + " m has a square pond of side " + b + " m removed. What area (in m\u00b2) is left, using a\u00b2 \u2212 b\u00b2?", AlgebraPractice.s(ans), "Area left = " + a + "\u00b2 \u2212 " + b + "\u00b2 = (" + a + "+" + b + ")(" + a + "\u2212" + b + ") = " + ans + " m\u00b2.", "MEDIUM", WP, AlgebraPractice.s(a * a), AlgebraPractice.s((a - b) * (a - b)), AlgebraPractice.s(ans - b), AlgebraPractice.s((a + b) * (a + b)));
        }, rng -> {
            int sum = QBuilder.range(rng, 6, 20);
            int prod = QBuilder.range(rng, 5, 30);
            int ans = sum * sum - 2 * prod;
            return QBuilder.build(rng, "Two numbers add to " + sum + " and multiply to " + prod + ". What is the sum of their squares?", AlgebraPractice.s(ans), "(a+b)\u00b2 = a\u00b2 + 2ab + b\u00b2, so a\u00b2+b\u00b2 = " + sum + "\u00b2 \u2212 2\u00d7" + prod + " = " + sum * sum + " \u2212 " + 2 * prod + " = " + ans + ".", "HARD", CWP, AlgebraPractice.s(sum * sum), AlgebraPractice.s(sum * sum + 2 * prod), AlgebraPractice.s(ans - 1), AlgebraPractice.s(2 * prod));
        });
        lp.classicConcept(new GeneratedQuestion("If x + 1/x = 4, then x\u00b2 + 1/x\u00b2 equals:", List.of("14", "16", "18", "12"), 0, "(x + 1/x)\u00b2 = 16 = x\u00b2 + 2 + 1/x\u00b2, so x\u00b2 + 1/x\u00b2 = 14.", "HARD", EX), new GeneratedQuestion("The value of 102\u00b2 \u2212 98\u00b2 is:", List.of("800", "400", "1600", "200"), 0, "(102+98)(102\u221298) = 200\u00d74 = 800.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("Two numbers add to 12 and multiply to 35. The sum of their squares is:", List.of("74", "144", "70", "84"), 0, "a\u00b2+b\u00b2 = 12\u00b2 \u2212 2\u00d735 = 144 \u2212 70 = 74.", "HARD", WP), new GeneratedQuestion("If a \u2212 b = 5 and ab = 6, then a\u00b2 + b\u00b2 equals:", List.of("37", "25", "13", "49"), 0, "(a\u2212b)\u00b2 = a\u00b2 \u2212 2ab + b\u00b2 = 25, so a\u00b2+b\u00b2 = 25 + 2\u00d76 = 37.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice inequalities() {
        LessonPractice lp = new LessonPractice("alg-inequalities", TOPIC, "Linear inequalities");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 2, 6);
            int b = QBuilder.range(rng, 1, 10);
            int xMin = QBuilder.range(rng, 2, 10);
            int c = a * xMin + b - 1;
            int answer = (int)Math.floor((double)(c - b) / (double)a) + 1;
            return QBuilder.build(rng, "Solve " + a + "x + " + b + " > " + c + ". What is the smallest integer value of x?", AlgebraPractice.s(answer), a + "x > " + (c - b) + " \u2192 x > " + (c - b) + "/" + a + " \u2248 " + String.format("%.2f", (double)(c - b) / (double)a) + ", so the smallest integer is " + answer + ".", "MEDIUM", EX, AlgebraPractice.s(answer - 1), AlgebraPractice.s(answer + 1), AlgebraPractice.s(c - b), AlgebraPractice.s(answer + 2));
        }, rng -> {
            int a = QBuilder.range(rng, 2, 6);
            int q = QBuilder.range(rng, 3, 12);
            int c = a * q;
            int answer = q - 1;
            return QBuilder.build(rng, "Solve " + a + "x < " + c + ". What is the largest integer value of x?", AlgebraPractice.s(answer), "x < " + c + "/" + a + " = " + q + ", so the largest integer below " + q + " is " + answer + ".", "EASY", EX, AlgebraPractice.s(q), AlgebraPractice.s(answer - 1), AlgebraPractice.s(answer + 2), AlgebraPractice.s(c));
        }, rng -> {
            int m = QBuilder.range(rng, 2, 20);
            int n = m + QBuilder.range(rng, 3, 8);
            int count = n - m - 1;
            return QBuilder.build(rng, "How many integers x satisfy " + m + " < x < " + n + "?", AlgebraPractice.s(count), "The integers strictly between " + m + " and " + n + " are " + (m + 1) + " \u2026 " + (n - 1) + ", which is " + count + " values.", "MEDIUM", EX, AlgebraPractice.s(count + 1), AlgebraPractice.s(count - 1), AlgebraPractice.s(n - m), AlgebraPractice.s(count + 2));
        });
        lp.word(rng -> {
            int price = QBuilder.range(rng, 8, 25);
            int budget = QBuilder.range(rng, 80, 250);
            int answer = budget / price;
            return QBuilder.build(rng, "Notebooks cost \u20b9" + price + " each and you have \u20b9" + budget + ". What is the most notebooks you can buy?", AlgebraPractice.s(answer), "You need " + price + "n \u2264 " + budget + " \u2192 n \u2264 " + budget + "/" + price + " \u2248 " + String.format("%.2f", (double)budget / (double)price) + ", so at most " + answer + ".", "MEDIUM", WP, AlgebraPractice.s(answer + 1), AlgebraPractice.s(answer - 1), AlgebraPractice.s(budget / (price + 1)), AlgebraPractice.s(answer + 2));
        }, rng -> {
            int perKm = QBuilder.range(rng, 8, 15);
            int base = QBuilder.range(rng, 30, 60);
            int budget = base + perKm * QBuilder.range(rng, 5, 20) + QBuilder.range(rng, 1, perKm - 1);
            int answer = (budget - base) / perKm;
            return QBuilder.build(rng, "A cab charges \u20b9" + base + " base plus \u20b9" + perKm + "/km. With \u20b9" + budget + ", what is the maximum whole number of km you can travel?", AlgebraPractice.s(answer), base + " + " + perKm + "k \u2264 " + budget + " \u2192 k \u2264 " + (budget - base) + "/" + perKm + " \u2248 " + String.format("%.2f", (double)(budget - base) / (double)perKm) + ", so at most " + answer + " km.", "HARD", CWP, AlgebraPractice.s(answer + 1), AlgebraPractice.s(answer - 1), AlgebraPractice.s(budget / perKm), AlgebraPractice.s(answer + 2));
        });
        lp.classicConcept(new GeneratedQuestion("Solve 2x + 1 > 9. The smallest integer x is:", List.of("5", "4", "6", "3"), 0, "2x > 8 \u2192 x > 4, so the smallest integer is 5.", "MEDIUM", EX), new GeneratedQuestion("Solve \u22123x > 12. Then:", List.of("x < \u22124", "x > \u22124", "x < 4", "x > 4"), 0, "Divide by \u22123 and FLIP the sign: x < \u22124.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("Pens cost \u20b915 each and you have \u20b9100. The most you can buy is:", List.of("6", "7", "5", "8"), 0, "15n \u2264 100 \u2192 n \u2264 6.67, so at most 6 pens.", "MEDIUM", WP), new GeneratedQuestion("A lift holds at most 600 kg. With an operator of 70 kg, how many 80 kg boxes can it carry?", List.of("6", "7", "5", "8"), 0, "70 + 80b \u2264 600 \u2192 80b \u2264 530 \u2192 b \u2264 6.6, so at most 6 boxes.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

