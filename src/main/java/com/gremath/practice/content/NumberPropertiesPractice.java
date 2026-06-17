/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class NumberPropertiesPractice {
    private static final String TOPIC = "number-properties";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom", "Neha", "Sam"};
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private NumberPropertiesPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(NumberPropertiesPractice.numbers());
        reg.add(NumberPropertiesPractice.factors());
        reg.add(NumberPropertiesPractice.primes());
        reg.add(NumberPropertiesPractice.evenOdd());
        reg.add(NumberPropertiesPractice.divisibility());
        reg.add(NumberPropertiesPractice.hcfLcm());
        reg.add(NumberPropertiesPractice.remainders());
        reg.add(NumberPropertiesPractice.unitsDigit());
        reg.add(NumberPropertiesPractice.factorCount());
        reg.add(NumberPropertiesPractice.factorials());
        reg.add(NumberPropertiesPractice.coprimes());
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a / NumberPropertiesPractice.gcd(a, b) * b;
    }

    private static int countFactors(int n) {
        int c = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i != 0) continue;
            ++c;
        }
        return c;
    }

    private static int smallestPrimeFactor(int n) {
        for (int i = 2; i <= n; ++i) {
            if (n % i != 0) continue;
            return i;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int i = 2;
        while ((long)i * (long)i <= (long)n) {
            if (n % i == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    private static int primesBetween(int a, int b) {
        int c = 0;
        for (int i = a; i <= b; ++i) {
            if (!NumberPropertiesPractice.isPrime(i)) continue;
            ++c;
        }
        return c;
    }

    private static int sumOfFactors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i != 0) continue;
            sum += i;
        }
        return sum;
    }

    private static int countOddFactors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i += 2) {
            if (n % i != 0) continue;
            ++c;
        }
        return c;
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        for (int p = 5; p <= n; p *= 5) {
            count += n / p;
        }
        return count;
    }

    private static int highestPowerOfPrime(int n, int prime) {
        int count = 0;
        long p = prime;
        while (p <= (long)n) {
            count += (int)((long)n / p);
            p *= prime;
        }
        return count;
    }

    private static boolean isCoprime(int a, int b) {
        return NumberPropertiesPractice.gcd(a, b) == 1;
    }

    private static int unitsDigit(int base, int exp) {
        int d = base % 10;
        int r = 1;
        for (int i = 0; i < exp; ++i) {
            r = r * d % 10;
        }
        return r;
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static LessonPractice numbers() {
        LessonPractice lp = new LessonPractice("np-numbers", TOPIC, "What is a number, really?");
        lp.concept(rng -> {
            int x = -QBuilder.range(rng, 2, 40);
            return QBuilder.build(rng, "What is the value of |" + x + "| (the absolute value of " + x + ")?", NumberPropertiesPractice.s(-x), "Absolute value is the distance from 0, always non-negative: |" + x + "| = " + -x + ".", "EASY", EX, NumberPropertiesPractice.s(x), "0", NumberPropertiesPractice.s(2 * x), NumberPropertiesPractice.s(-x + 1));
        }, rng -> {
            int x = QBuilder.pick(rng, -25, -12, -8, -3, 5, 9, 14, 20, -17, 7);
            return QBuilder.build(rng, "What is the additive inverse (the opposite) of " + x + "?", NumberPropertiesPractice.s(-x), "The additive inverse is what you add to get 0: " + x + " + (" + -x + ") = 0.", "EASY", EX, NumberPropertiesPractice.s(x), "0", NumberPropertiesPractice.s(2 * x), NumberPropertiesPractice.s(-x + 2));
        }, rng -> {
            int a = QBuilder.range(rng, -15, 15);
            int b = QBuilder.range(rng, -15, 15);
            int d = Math.abs(a - b);
            return QBuilder.build(rng, "On the number line, how far apart are " + a + " and " + b + "?", NumberPropertiesPractice.s(d), "Distance = |" + a + " \u2212 (" + b + ")| = |" + (a - b) + "| = " + d + ".", "MEDIUM", EX, NumberPropertiesPractice.s(a + b), NumberPropertiesPractice.s(Math.abs(a) + Math.abs(b)), NumberPropertiesPractice.s(d + 2), NumberPropertiesPractice.s(Math.abs(a + b)));
        }, rng -> {
            int a = QBuilder.range(rng, -20, 20);
            int b = QBuilder.range(rng, -20, 20);
            return QBuilder.build(rng, "What is " + a + " + (" + b + ")?", NumberPropertiesPractice.s(a + b), "Add with signs: " + a + " + (" + b + ") = " + (a + b) + ".", "EASY", EX, NumberPropertiesPractice.s(a - b), NumberPropertiesPractice.s(b - a), NumberPropertiesPractice.s(-(a + b)), NumberPropertiesPractice.s(a + b + 1));
        });
        lp.word(rng -> {
            int a = QBuilder.range(rng, -2, 12);
            int b = QBuilder.range(rng, 4, 18);
            int res = a - b;
            return QBuilder.build(rng, "The temperature was " + a + "\u00b0C and then dropped by " + b + "\u00b0C. What is the new temperature?", NumberPropertiesPractice.s(res) + "\u00b0C", "Dropping means subtract: " + a + " \u2212 " + b + " = " + res + "\u00b0C.", "EASY", WP, a + b + "\u00b0C", b - a + "\u00b0C", -res + "\u00b0C", res + 1 + "\u00b0C");
        }, rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int bal = QBuilder.range(rng, 200, 900);
            int spend = bal + QBuilder.range(rng, 50, 400);
            int res = bal - spend;
            return QBuilder.build(rng, name + " has \u20b9" + bal + " in an account and spends \u20b9" + spend + " using an overdraft. What is the new balance?", "\u20b9" + res, "New balance = " + bal + " \u2212 " + spend + " = \u20b9" + res + " (a negative balance means money is owed).", "MEDIUM", WP, "\u20b9" + (spend - bal), "\u20b9" + (bal + spend), "\u20b9" + (-res - 50), "\u20b9" + (res + 100));
        }, rng -> {
            int a = QBuilder.range(rng, 5, 18);
            int b = QBuilder.range(rng, 3, 12);
            int c = QBuilder.range(rng, 2, 10);
            int res = -a - b + c;
            return QBuilder.build(rng, "A diver is " + a + " m below the surface (depth " + -a + " m). She descends " + b + " m more and then rises " + c + " m. What is her final depth (a signed number)?", NumberPropertiesPractice.s(res) + " m", "Start " + -a + ", descend (subtract) " + b + ", rise (add) " + c + ": " + -a + " \u2212 " + b + " + " + c + " = " + res + " m.", "HARD", CWP, -a - b - c + " m", -a + b + c + " m", a + b - c + " m", res + 2 + " m");
        });
        lp.classicConcept(new GeneratedQuestion("Which statement is always true for any integer n?", List.of("n + (\u2212n) = 0", "n \u00f7 n = n", "n \u00d7 0 = n", "n \u2212 0 = 0"), 0, "A number plus its opposite is always 0. The others fail (e.g. n\u00d70 = 0, not n).", "EASY", EX), new GeneratedQuestion("If a is negative and b is positive, which is definitely positive?", List.of("b \u2212 a", "a + b", "a \u00d7 b", "a \u2212 b"), 0, "b \u2212 a = positive \u2212 negative = positive + positive, always positive. The others depend on sizes/signs.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A lift starts at the 3rd floor, goes down 5 floors, then up 2. Which floor is it on?", List.of("Floor 0 (ground)", "Floor 1", "Floor \u22121 (basement 1)", "Floor 2"), 0, "3 \u2212 5 + 2 = 0, i.e. the ground floor.", "EASY", WP), new GeneratedQuestion("Mount peak is +2,400 m and a valley is \u2212600 m. What is the vertical distance between them?", List.of("3,000 m", "1,800 m", "2,400 m", "600 m"), 0, "Distance = 2,400 \u2212 (\u2212600) = 3,000 m.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice factors() {
        LessonPractice lp = new LessonPractice("np-factors-multiples", TOPIC, "Factors and multiples");
        lp.concept(rng -> {
            int n = QBuilder.pick(rng, 12, 18, 24, 28, 30, 36, 40, 48, 60, 72, 20, 45);
            int f = NumberPropertiesPractice.countFactors(n);
            return QBuilder.build(rng, "How many factors (divisors) does " + n + " have?", NumberPropertiesPractice.s(f), n + " has these many divisors when you count every number that divides it exactly: " + f + ".", "MEDIUM", EX, NumberPropertiesPractice.s(f + 1), NumberPropertiesPractice.s(f - 1), NumberPropertiesPractice.s(f + 2), NumberPropertiesPractice.s(Math.max(2, f - 2)));
        }, rng -> {
            int n = QBuilder.pick(rng, 12, 15, 21, 33, 35, 39, 55, 14, 22, 26);
            int g = n / NumberPropertiesPractice.smallestPrimeFactor(n);
            return QBuilder.build(rng, "What is the largest factor of " + n + " that is smaller than " + n + " itself?", NumberPropertiesPractice.s(g), "The largest proper factor = " + n + " \u00f7 (its smallest prime factor " + NumberPropertiesPractice.smallestPrimeFactor(n) + ") = " + g + ".", "MEDIUM", EX, NumberPropertiesPractice.s(n - 1), NumberPropertiesPractice.s(g + 1), NumberPropertiesPractice.s(NumberPropertiesPractice.smallestPrimeFactor(n)), NumberPropertiesPractice.s(g - 1));
        }, rng -> {
            int k = QBuilder.pick(rng, 3, 4, 6, 7, 8, 9, 11, 12);
            int m = QBuilder.range(rng, 20, 80);
            int mult = (m / k + 1) * k;
            return QBuilder.build(rng, "What is the smallest multiple of " + k + " that is greater than " + m + "?", NumberPropertiesPractice.s(mult), "Multiples of " + k + " jump by " + k + ". The first one above " + m + " is " + mult + ".", "MEDIUM", EX, NumberPropertiesPractice.s(mult - k), NumberPropertiesPractice.s(mult + k), NumberPropertiesPractice.s(m + k), NumberPropertiesPractice.s(mult - 1));
        }, rng -> {
            int b = QBuilder.pick(rng, 6, 7, 8, 9, 12, 15, 11, 13);
            int k = QBuilder.range(rng, 5, 12);
            return QBuilder.build(rng, "What is the " + k + "th multiple of " + b + "?", NumberPropertiesPractice.s(b * k), "The k-th multiple is just k \u00d7 b = " + k + " \u00d7 " + b + " = " + b * k + ".", "EASY", EX, NumberPropertiesPractice.s(b * (k + 1)), NumberPropertiesPractice.s(b * (k - 1)), NumberPropertiesPractice.s(b + k), NumberPropertiesPractice.s(b * k + b));
        });
        lp.word(rng -> {
            int a = QBuilder.pick(rng, 24, 36, 48, 60, 72, 40, 54, 90);
            int b = QBuilder.pick(rng, 16, 30, 18, 32, 45, 28, 42, 60);
            int g = NumberPropertiesPractice.gcd(a, b);
            return QBuilder.build(rng, "A floor " + a + " cm by " + b + " cm is to be covered with identical square tiles with no cutting. What is the largest possible tile side?", g + " cm", "Largest square tile = HCF of " + a + " and " + b + " = " + g + " cm.", "MEDIUM", WP, NumberPropertiesPractice.lcm(a, b) + " cm", g + 2 + " cm", Math.min(a, b) + " cm", g - 1 + " cm");
        }, rng -> {
            int a = QBuilder.pick(rng, 6, 8, 9, 12, 10, 15);
            int b = QBuilder.pick(rng, 4, 5, 7, 8, 9, 14);
            int l = NumberPropertiesPractice.lcm(a, b);
            return QBuilder.build(rng, "Two lights blink every " + a + " and " + b + " seconds. If they blink together now, after how many seconds do they next blink together?", l + " s", "They sync at the LCM of " + a + " and " + b + " = " + l + " seconds.", "MEDIUM", WP, a * b + " s", NumberPropertiesPractice.gcd(a, b) + " s", l + a + " s", a + b + " s");
        }, rng -> {
            int a = QBuilder.pick(rng, 6, 8, 12, 9);
            int b = QBuilder.pick(rng, 10, 15, 18, 14);
            int c = QBuilder.pick(rng, 20, 24, 30, 21);
            int l = NumberPropertiesPractice.lcm(NumberPropertiesPractice.lcm(a, b), c);
            return QBuilder.build(rng, "Three bells toll every " + a + ", " + b + " and " + c + " minutes. If they toll together at noon, after how many minutes do all three toll together again?", l + " min", "All three sync at the LCM of " + a + ", " + b + ", " + c + " = " + l + " minutes.", "HARD", CWP, a * b * c + " min", NumberPropertiesPractice.lcm(a, b) + " min", l + a + " min", NumberPropertiesPractice.gcd(NumberPropertiesPractice.gcd(a, b), c) + " min");
        });
        lp.classicConcept(new GeneratedQuestion("Which number has exactly 3 factors?", List.of("49", "12", "8", "6"), 0, "Only perfect squares of primes have exactly 3 factors: 49 = 7\u00b2 has factors 1, 7, 49.", "HARD", EX), new GeneratedQuestion("The number 2\u00b3 \u00d7 3 \u00d7 5\u00b2 has how many factors?", List.of("24", "12", "18", "30"), 0, "Add 1 to each power and multiply: (3+1)(1+1)(2+1) = 4\u00d72\u00d73 = 24.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("Two ropes of 18 m and 24 m are cut into equal pieces of the greatest possible length with none wasted. How long is each piece?", List.of("6 m", "3 m", "12 m", "9 m"), 0, "Greatest equal length = HCF(18, 24) = 6 m.", "MEDIUM", WP), new GeneratedQuestion("Three runners complete a lap in 60, 80 and 120 seconds. After how long are they together at the start again?", List.of("240 s", "120 s", "480 s", "360 s"), 0, "LCM(60, 80, 120) = 240 seconds.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice primes() {
        LessonPractice lp = new LessonPractice("np-primes", TOPIC, "Prime and composite numbers");
        lp.concept(rng -> {
            int n = QBuilder.pick(rng, 51, 57, 91, 61, 67, 87, 93, 73, 77, 83, 119, 97);
            String correct = NumberPropertiesPractice.isPrime(n) ? "Prime" : "Composite";
            String exp = NumberPropertiesPractice.isPrime(n) ? n + " has no factors other than 1 and itself, so it is prime." : n + " = " + NumberPropertiesPractice.smallestPrimeFactor(n) + " \u00d7 " + n / NumberPropertiesPractice.smallestPrimeFactor(n) + ", so it is composite.";
            return QBuilder.build(rng, "Is " + n + " prime or composite?", correct, exp, "MEDIUM", EX, NumberPropertiesPractice.isPrime(n) ? "Composite" : "Prime", "Neither", "Both");
        }, rng -> {
            int a = QBuilder.pick(rng, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90);
            int b = a + 10;
            int c = NumberPropertiesPractice.primesBetween(a, b);
            return QBuilder.build(rng, "How many prime numbers are there between " + a + " and " + b + " (inclusive)?", NumberPropertiesPractice.s(c), "Counting the primes in [" + a + ", " + b + "] gives " + c + ".", "HARD", EX, NumberPropertiesPractice.s(c + 1), NumberPropertiesPractice.s(c - 1), NumberPropertiesPractice.s(c + 2), NumberPropertiesPractice.s(Math.max(0, c - 2)));
        }, rng -> {
            int n = QBuilder.pick(rng, 8, 14, 20, 24, 26, 33, 9, 18, 35, 16);
            int spf = NumberPropertiesPractice.smallestPrimeFactor(n);
            return QBuilder.build(rng, "What is the smallest prime factor of " + n + "?", NumberPropertiesPractice.s(spf), n + "'s smallest prime factor is " + spf + " (the first prime that divides it).", "EASY", EX, NumberPropertiesPractice.s(n), NumberPropertiesPractice.s(spf + 1), NumberPropertiesPractice.s(n / spf), NumberPropertiesPractice.s(spf + 2));
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int n = QBuilder.pick(rng, 12, 15, 18, 20, 24, 28, 30, 21);
            int friends = n / NumberPropertiesPractice.smallestPrimeFactor(n);
            return QBuilder.build(rng, name + " has " + n + " sweets and wants to share them equally among friends (more than one friend, more than one sweet each, none left). What is the greatest number of friends possible?", NumberPropertiesPractice.s(friends), "Greatest group count = " + n + " \u00f7 smallest prime factor (" + NumberPropertiesPractice.smallestPrimeFactor(n) + ") = " + friends + ".", "MEDIUM", WP, NumberPropertiesPractice.s(n), NumberPropertiesPractice.s(friends + 1), NumberPropertiesPractice.s(NumberPropertiesPractice.smallestPrimeFactor(n)), NumberPropertiesPractice.s(friends - 1));
        }, rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30, 40, 1, 50);
            int b = a + 10;
            int c = NumberPropertiesPractice.primesBetween(a, b);
            return QBuilder.build(rng, "A school assigns 'prime' jersey numbers only. How many jersey numbers between " + a + " and " + b + " can be used?", NumberPropertiesPractice.s(c), "Count the primes in [" + a + ", " + b + "] = " + c + ".", "HARD", CWP, NumberPropertiesPractice.s(c + 1), NumberPropertiesPractice.s(c - 1), NumberPropertiesPractice.s(b - a), NumberPropertiesPractice.s(c + 2));
        });
        lp.classicConcept(new GeneratedQuestion("Which of the following is a prime number?", List.of("83", "87", "91", "93"), 0, "83 is prime. 87 = 3\u00d729, 91 = 7\u00d713, 93 = 3\u00d731.", "MEDIUM", EX), new GeneratedQuestion("How many even prime numbers are there?", List.of("Exactly one", "None", "Two", "Infinitely many"), 0, "2 is the only even prime; every other even number is divisible by 2 and so has an extra factor.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A florist has 17 roses and wants equal bunches with more than one bunch and more than one rose each. Can she?", List.of("No \u2014 17 is prime", "Yes, bunches of 3", "Yes, bunches of 4", "Yes, bunches of 7"), 0, "17 is prime, so its only divisors are 1 and 17 \u2014 no valid equal grouping exists.", "MEDIUM", WP), new GeneratedQuestion("Students stand in a rectangle with more than one row and column. For which total is this impossible?", List.of("23", "24", "20", "36"), 0, "23 is prime, so the only rectangle is 1\u00d723 \u2014 impossible with >1 row and column. The others are composite.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice evenOdd() {
        LessonPractice lp = new LessonPractice("np-even-odd", TOPIC, "Even & odd");
        lp.concept(rng -> {
            int b;
            int a = QBuilder.range(rng, 10, 99);
            String correct = (a + (b = QBuilder.range(rng, 10, 99))) % 2 == 0 ? "Even" : "Odd";
            return QBuilder.build(rng, "Is the sum " + a + " + " + b + " odd or even?", correct, "even+even and odd+odd are even; even+odd is odd. Here the sum is " + (a + b) + ", which is " + correct.toLowerCase() + ".", "EASY", EX, correct.equals("Even") ? "Odd" : "Even", "Cannot tell");
        }, rng -> {
            int b;
            int a = QBuilder.range(rng, 2, 40);
            String correct = a * (b = QBuilder.range(rng, 2, 40)) % 2 == 0 ? "Even" : "Odd";
            return QBuilder.build(rng, "Is the product " + a + " \u00d7 " + b + " odd or even?", correct, "A product is odd only if every factor is odd. " + a + "\u00d7" + b + " = " + a * b + ", which is " + correct.toLowerCase() + ".", "EASY", EX, correct.equals("Even") ? "Odd" : "Even", "Cannot tell");
        }, rng -> {
            int n = QBuilder.range(rng, 3, 15);
            return QBuilder.build(rng, "What is the sum of the first " + n + " odd numbers (1 + 3 + 5 + \u2026)?", NumberPropertiesPractice.s(n * n), "The sum of the first n odd numbers is always n\u00b2: " + n + "\u00b2 = " + n * n + ".", "MEDIUM", EX, NumberPropertiesPractice.s(n * n + 1), NumberPropertiesPractice.s(n * (n + 1)), NumberPropertiesPractice.s(2 * n), NumberPropertiesPractice.s(n * n - 1));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 15, 60);
            int left = n % 2;
            return QBuilder.build(rng, n + " students pair up for a dance. How many are left without a partner?", NumberPropertiesPractice.s(left), n + " is " + (left == 0 ? "even, so everyone pairs up (0 left)." : "odd, so one person is left over."), "EASY", WP, NumberPropertiesPractice.s(1 - left), NumberPropertiesPractice.s(2), NumberPropertiesPractice.s(n / 2));
        }, rng -> {
            int c;
            int r = QBuilder.range(rng, 3, 12);
            String correct = r * (c = QBuilder.range(rng, 3, 12)) % 2 == 0 ? "Even" : "Odd";
            return QBuilder.build(rng, "A hall has " + r + " rows of " + c + " chairs. Is the total number of chairs odd or even?", correct, "Total = " + r + "\u00d7" + c + " = " + r * c + ". A product is even unless both factors are odd, so it is " + correct.toLowerCase() + ".", "MEDIUM", CWP, correct.equals("Even") ? "Odd" : "Even", "Cannot tell");
        });
        lp.classicConcept(new GeneratedQuestion("If n is an odd integer, which expression is always even?", List.of("n + 1", "n + 2", "n\u00b2", "3n"), 0, "odd + 1 = even. n+2 stays odd, n\u00b2 of an odd is odd, 3\u00d7odd is odd.", "EASY", EX), new GeneratedQuestion("The product of any two consecutive integers is always:", List.of("Even", "Odd", "Prime", "A perfect square"), 0, "Of any two consecutive integers, one is even, so their product is even.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A bag of 30 marbles is split equally between 2 children. Is this possible with none left?", List.of("Yes", "No", "Only if one gets more", "Cannot tell"), 0, "30 is even, so it divides into two equal whole groups of 15.", "EASY", WP), new GeneratedQuestion("17 handshakes happen, each between 2 people. Could exactly 17 people each have shaken exactly one hand?", List.of("No", "Yes", "Only at a party", "Cannot tell"), 0, "Each handshake uses 2 people, so the number of single-handshake people must be even. 17 is odd \u2014 impossible.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice divisibility() {
        LessonPractice lp = new LessonPractice("np-divisibility", TOPIC, "Divisibility rules");
        lp.concept(rng -> {
            int d = QBuilder.pick(rng, 3, 4, 6, 9, 11);
            int n = QBuilder.range(rng, 100, 999);
            String correct = n % d == 0 ? "Yes" : "No";
            return QBuilder.build(rng, "Is " + n + " divisible by " + d + "?", correct, n + " \u00f7 " + d + (String)(n % d == 0 ? " is exact, so yes." : " leaves remainder " + n % d + ", so no."), "MEDIUM", EX, correct.equals("Yes") ? "No" : "Yes", "Only if it ends in 0");
        }, rng -> {
            int base = QBuilder.range(rng, 10, 98) * 10;
            int need = (3 - base % 3) % 3;
            return QBuilder.build(rng, "What is the smallest digit d so that " + base + " + d is divisible by 3?", NumberPropertiesPractice.s(need), "Sum the digits of " + base + " and add d; for divisibility by 3 the total must be a multiple of 3. The smallest such d is " + need + ".", "HARD", EX, NumberPropertiesPractice.s((need + 1) % 3 == 0 ? 3 : need + 1), NumberPropertiesPractice.s(need + 3), NumberPropertiesPractice.s((need + 2) % 10));
        }, rng -> {
            int n = QBuilder.range(rng, 1000, 9999);
            String correct = n % 4 == 0 ? "Yes" : "No";
            int last2 = n % 100;
            return QBuilder.build(rng, "Is " + n + " divisible by 4?", correct, "A number is divisible by 4 iff its last two digits (" + last2 + ") form a multiple of 4. Here: " + correct.toLowerCase() + ".", "MEDIUM", EX, correct.equals("Yes") ? "No" : "Yes", "Only if even");
        });
        lp.word(rng -> {
            int d = QBuilder.pick(rng, 6, 8, 12, 9, 15);
            int n = QBuilder.range(rng, 40, 200);
            String correct = n % d == 0 ? "Yes" : "No";
            return QBuilder.build(rng, n + " chocolates are packed into boxes of " + d + " with none left over. Is this possible?", correct, n + " \u00f7 " + d + (String)(n % d == 0 ? " is exact \u2014 yes." : " leaves " + n % d + " \u2014 no."), "EASY", WP, correct.equals("Yes") ? "No" : "Yes", "Only with smaller boxes");
        }, rng -> {
            int d = QBuilder.pick(rng, 3, 4, 6, 7, 8, 9);
            int n = QBuilder.range(rng, 50, 300);
            int cnt = n / d;
            return QBuilder.build(rng, "Tickets are numbered 1 to " + n + ". How many ticket numbers are divisible by " + d + "?", NumberPropertiesPractice.s(cnt), "Count of multiples of " + d + " up to " + n + " = floor(" + n + " \u00f7 " + d + ") = " + cnt + ".", "HARD", CWP, NumberPropertiesPractice.s(cnt + 1), NumberPropertiesPractice.s(cnt - 1), NumberPropertiesPractice.s(n / (d + 1)), NumberPropertiesPractice.s(cnt + 2));
        });
        lp.classicConcept(new GeneratedQuestion("Which number is divisible by both 3 and 4?", List.of("132", "114", "146", "158"), 0, "132: digit sum 6 (\u00f73) and last two digits 32 (\u00f74), so it is divisible by 12.", "MEDIUM", EX), new GeneratedQuestion("For 2,7X4 to be divisible by 9, the digit X should be:", List.of("5", "3", "4", "6"), 0, "Digit sum 2+7+X+4 = 13+X must be a multiple of 9, so X = 5 (giving 18).", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("96 students are to be split into equal teams of 8. Is it possible with none left out?", List.of("Yes", "No", "Only teams of 6", "Cannot tell"), 0, "96 \u00f7 8 = 12 exactly, so yes \u2014 12 teams.", "EASY", WP), new GeneratedQuestion("Among the numbers 1 to 100, how many are divisible by 6?", List.of("16", "17", "15", "18"), 0, "floor(100 \u00f7 6) = 16.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice hcfLcm() {
        LessonPractice lp = new LessonPractice("np-hcf-lcm", TOPIC, "Prime factorisation, HCF & LCM");
        lp.concept(rng -> {
            int a = QBuilder.pick(rng, 12, 18, 24, 36, 48, 60, 16, 40);
            int b = QBuilder.pick(rng, 8, 30, 45, 27, 32, 54, 20, 50);
            int g = NumberPropertiesPractice.gcd(a, b);
            return QBuilder.build(rng, "What is the HCF (greatest common factor) of " + a + " and " + b + "?", NumberPropertiesPractice.s(g), "The largest number dividing both " + a + " and " + b + " is " + g + ".", "MEDIUM", EX, NumberPropertiesPractice.s(NumberPropertiesPractice.lcm(a, b)), NumberPropertiesPractice.s(g + 1), NumberPropertiesPractice.s(g * 2), NumberPropertiesPractice.s(Math.min(a, b)));
        }, rng -> {
            int a = QBuilder.pick(rng, 4, 6, 8, 9, 10, 12, 15);
            int b = QBuilder.pick(rng, 5, 7, 8, 14, 18, 20, 6);
            int l = NumberPropertiesPractice.lcm(a, b);
            return QBuilder.build(rng, "What is the LCM (lowest common multiple) of " + a + " and " + b + "?", NumberPropertiesPractice.s(l), "The smallest number both " + a + " and " + b + " divide into is " + l + ".", "MEDIUM", EX, NumberPropertiesPractice.s(a * b), NumberPropertiesPractice.s(NumberPropertiesPractice.gcd(a, b)), NumberPropertiesPractice.s(l + a), NumberPropertiesPractice.s(l - b));
        }, rng -> {
            int a = QBuilder.pick(rng, 12, 18, 24, 36, 20, 30);
            int b = QBuilder.pick(rng, 8, 30, 16, 42, 45, 24);
            int g = NumberPropertiesPractice.gcd(a, b);
            int l = NumberPropertiesPractice.lcm(a, b);
            return QBuilder.build(rng, "Two numbers have HCF " + g + " and LCM " + l + ". If one number is " + a + ", what is the other?", NumberPropertiesPractice.s(b), "Use HCF \u00d7 LCM = product of the numbers: other = (" + g + " \u00d7 " + l + ") \u00f7 " + a + " = " + b + ".", "HARD", EX, NumberPropertiesPractice.s(l / a * g + 1), NumberPropertiesPractice.s(g), NumberPropertiesPractice.s(l), NumberPropertiesPractice.s(a));
        });
        lp.word(rng -> {
            int a = QBuilder.pick(rng, 24, 36, 48, 60, 72, 40);
            int b = QBuilder.pick(rng, 16, 30, 18, 32, 45, 28);
            int g = NumberPropertiesPractice.gcd(a, b);
            return QBuilder.build(rng, "Two ribbons of " + a + " cm and " + b + " cm are cut into equal pieces of the greatest length with none wasted. How long is each piece?", g + " cm", "Greatest equal length = HCF(" + a + ", " + b + ") = " + g + " cm.", "MEDIUM", WP, NumberPropertiesPractice.lcm(a, b) + " cm", g + 2 + " cm", Math.min(a, b) + " cm", g - 1 + " cm");
        }, rng -> {
            int a = QBuilder.pick(rng, 5, 6, 8, 9, 10, 12);
            int b = QBuilder.pick(rng, 7, 8, 9, 14, 15, 18);
            int l = NumberPropertiesPractice.lcm(a, b);
            return QBuilder.build(rng, "Runner A finishes a lap in " + a + " min and runner B in " + b + " min. If they start together, after how many minutes are they together at the start again?", l + " min", "They meet at the start after LCM(" + a + ", " + b + ") = " + l + " minutes.", "MEDIUM", WP, a * b + " min", NumberPropertiesPractice.gcd(a, b) + " min", l + a + " min", a + b + " min");
        }, rng -> {
            int a = QBuilder.pick(rng, 6, 8, 9, 12);
            int b = QBuilder.pick(rng, 10, 14, 15, 18);
            int c = QBuilder.pick(rng, 20, 21, 24, 30);
            int l = NumberPropertiesPractice.lcm(NumberPropertiesPractice.lcm(a, b), c);
            return QBuilder.build(rng, "Three machines complete a cycle in " + a + ", " + b + " and " + c + " seconds. After how many seconds do all three finish a cycle together?", l + " s", "All sync at LCM(" + a + ", " + b + ", " + c + ") = " + l + " seconds.", "HARD", CWP, a * b * c + " s", NumberPropertiesPractice.lcm(a, b) + " s", l + c + " s", NumberPropertiesPractice.gcd(NumberPropertiesPractice.gcd(a, b), c) + " s");
        });
        lp.classicConcept(new GeneratedQuestion("The HCF of two numbers is 6 and their LCM is 60. If one number is 12, the other is:", List.of("30", "24", "18", "36"), 0, "Product = HCF \u00d7 LCM = 6\u00d760 = 360, so the other = 360 \u00f7 12 = 30.", "MEDIUM", EX), new GeneratedQuestion("What is the HCF of two distinct prime numbers?", List.of("1", "Their product", "The smaller prime", "2"), 0, "Distinct primes share no factor except 1, so their HCF is 1 (they are co-prime).", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("The least number of chocolates that can be shared exactly among 4, 6 or 9 children is:", List.of("36", "24", "54", "72"), 0, "We need the LCM of 4, 6, 9 = 36.", "MEDIUM", WP), new GeneratedQuestion("Three church bells ring every 18, 24 and 32 minutes. After how many minutes do they ring together?", List.of("288 min", "144 min", "216 min", "96 min"), 0, "LCM(18, 24, 32) = 288 minutes.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice remainders() {
        LessonPractice lp = new LessonPractice("np-remainders", TOPIC, "Remainders made simple");
        lp.concept(rng -> {
            int n = QBuilder.range(rng, 50, 500);
            int d = QBuilder.pick(rng, 3, 4, 6, 7, 8, 9, 11);
            int r = n % d;
            return QBuilder.build(rng, "What is the remainder when " + n + " is divided by " + d + "?", NumberPropertiesPractice.s(r), n + " = " + d + "\u00d7" + n / d + " + " + r + ", so the remainder is " + r + ".", "EASY", EX, NumberPropertiesPractice.s((r + 1) % d), NumberPropertiesPractice.s((r + 2) % d), NumberPropertiesPractice.s(d - 1), NumberPropertiesPractice.s((r + d - 1) % d));
        }, rng -> {
            int a = QBuilder.range(rng, 11, 40);
            int b = QBuilder.range(rng, 11, 40);
            int d = QBuilder.pick(rng, 5, 7, 9, 11);
            int r = a * b % d;
            return QBuilder.build(rng, "What is the remainder when " + a + " \u00d7 " + b + " is divided by " + d + "?", NumberPropertiesPractice.s(r), "Remainder of a product = remainder of (" + a % d + " \u00d7 " + b % d + ") = " + a % d * (b % d) + " mod " + d + " = " + r + ".", "MEDIUM", EX, NumberPropertiesPractice.s((r + 1) % d), NumberPropertiesPractice.s((r + 2) % d), NumberPropertiesPractice.s((r + d - 1) % d), NumberPropertiesPractice.s(d - 1));
        }, rng -> {
            int d = QBuilder.pick(rng, 5, 6, 7, 8, 9);
            int r = QBuilder.range(rng, 1, d - 1);
            int q = QBuilder.range(rng, 3, 12);
            int n = d * q + r;
            return QBuilder.build(rng, "A number gives quotient " + q + " and remainder " + r + " when divided by " + d + ". What is the number?", NumberPropertiesPractice.s(n), "Number = divisor\u00d7quotient + remainder = " + d + "\u00d7" + q + " + " + r + " = " + n + ".", "MEDIUM", EX, NumberPropertiesPractice.s(n + 1), NumberPropertiesPractice.s(d * q), NumberPropertiesPractice.s(n - r - r), NumberPropertiesPractice.s(n + d));
        });
        lp.word(rng -> {
            int n = QBuilder.range(rng, 20, 120);
            int k = QBuilder.pick(rng, 3, 4, 5, 6, 7, 8);
            int r = n % k;
            return QBuilder.build(rng, n + " sweets are shared equally among " + k + " children. How many sweets are left over?", NumberPropertiesPractice.s(r), "Each child gets " + n / k + " (that's " + k * (n / k) + " sweets), leaving " + r + " over.", "EASY", WP, NumberPropertiesPractice.s((r + 1) % k), NumberPropertiesPractice.s(k - 1), NumberPropertiesPractice.s(n / k), NumberPropertiesPractice.s((r + 2) % k));
        }, rng -> {
            int d = QBuilder.pick(rng, 5, 6, 7, 8, 9);
            int r = QBuilder.range(rng, 1, d - 1);
            int m = QBuilder.range(rng, 30, 80);
            int n = (m / d + 1) * d + r;
            return QBuilder.build(rng, "When eggs are grouped in " + d + "s, " + r + " are left over. What is the smallest number of eggs greater than " + m + " that fits this?", NumberPropertiesPractice.s(n), "Numbers leaving remainder " + r + " mod " + d + " are " + r + ", " + (r + d) + ", \u2026 The first one above " + m + " is " + n + ".", "HARD", CWP, NumberPropertiesPractice.s(n + d), NumberPropertiesPractice.s(n - d), NumberPropertiesPractice.s(m + r), NumberPropertiesPractice.s(n + 1));
        });
        lp.classicConcept(new GeneratedQuestion("What is the remainder when 2^10 is divided by 3?", List.of("1", "0", "2", "3"), 0, "2 \u2261 \u22121 (mod 3), so 2^10 \u2261 (\u22121)^10 = 1.", "MEDIUM", EX), new GeneratedQuestion("A number divided by 7 leaves remainder 4. What is the remainder when twice the number is divided by 7?", List.of("1", "8", "4", "2"), 0, "Twice gives remainder 2\u00d74 = 8 \u2261 1 (mod 7).", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("53 pencils are shared equally among 6 students. How many are left over?", List.of("5", "3", "1", "0"), 0, "53 = 6\u00d78 + 5, so 5 pencils remain.", "EASY", WP), new GeneratedQuestion("The smallest number that leaves remainder 2 when divided by 3, 4 and 5 is:", List.of("62", "60", "30", "22"), 0, "Number = LCM(3,4,5) + 2 = 60 + 2 = 62.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice unitsDigit() {
        LessonPractice lp = new LessonPractice("np-units-digit", TOPIC, "Units digit of powers (cyclicity)");
        lp.concept(rng -> {
            int base = QBuilder.pick(rng, 2, 3, 4, 7, 8, 9, 12, 13, 17, 6);
            int exp = QBuilder.range(rng, 2, 20);
            int u = NumberPropertiesPractice.unitsDigit(base, exp);
            return QBuilder.build(rng, "What is the units digit of " + base + "^" + exp + "?", NumberPropertiesPractice.s(u), "Use the cycle of the units digit of " + base + ". Working through the cycle for exponent " + exp + " gives a units digit of " + u + ".", "HARD", EX, NumberPropertiesPractice.s((u + 1) % 10), NumberPropertiesPractice.s((u + 2) % 10), NumberPropertiesPractice.s((u + 6) % 10), NumberPropertiesPractice.s((u + 4) % 10));
        }, rng -> {
            int a = QBuilder.range(rng, 12, 99);
            int b = QBuilder.range(rng, 12, 99);
            int u = a * b % 10;
            return QBuilder.build(rng, "What is the units digit of " + a + " \u00d7 " + b + "?", NumberPropertiesPractice.s(u), "The units digit of a product depends only on the units digits: " + a % 10 + " \u00d7 " + b % 10 + " ends in " + u + ".", "MEDIUM", EX, NumberPropertiesPractice.s((u + 1) % 10), NumberPropertiesPractice.s((u + 3) % 10), NumberPropertiesPractice.s((u + 7) % 10), NumberPropertiesPractice.s((u + 5) % 10));
        }, rng -> {
            int base = QBuilder.pick(rng, 2, 3, 7, 8);
            int exp = QBuilder.pick(rng, 4, 8, 12, 16, 20, 24);
            int u = NumberPropertiesPractice.unitsDigit(base, exp);
            return QBuilder.build(rng, "The units digit of " + base + "^" + exp + " is the same as " + base + " raised to which position in its 4-step cycle?", NumberPropertiesPractice.s(u), base + " has a 4-long cycle; since " + exp + " is a multiple of 4, the units digit is the last in the cycle = " + u + ".", "HARD", EX, NumberPropertiesPractice.s((u + 2) % 10), NumberPropertiesPractice.s((u + 4) % 10), NumberPropertiesPractice.s((u + 6) % 10), NumberPropertiesPractice.s((u + 8) % 10));
        });
        lp.word(rng -> {
            int base = QBuilder.pick(rng, 2, 3, 7, 8, 9, 4);
            int exp = QBuilder.range(rng, 5, 25);
            int u = NumberPropertiesPractice.unitsDigit(base, exp);
            return QBuilder.build(rng, "A code is the last digit of " + base + "^" + exp + ". What is the code?", NumberPropertiesPractice.s(u), "Find the units digit using the cycle of " + base + ": it is " + u + ".", "HARD", CWP, NumberPropertiesPractice.s((u + 1) % 10), NumberPropertiesPractice.s((u + 5) % 10), NumberPropertiesPractice.s((u + 3) % 10), NumberPropertiesPractice.s((u + 7) % 10));
        }, rng -> {
            int base = QBuilder.pick(rng, 11, 21, 15, 25, 16, 26, 10, 20);
            int exp = QBuilder.range(rng, 3, 30);
            int u = NumberPropertiesPractice.unitsDigit(base, exp);
            return QBuilder.build(rng, "A savings scheme grows to " + base + "^" + exp + " rupees. What is the last digit of this amount?", NumberPropertiesPractice.s(u), base + " ends in " + base % 10 + ", which keeps the same units digit for every power, so the last digit is " + u + ".", "MEDIUM", WP, NumberPropertiesPractice.s((u + 1) % 10), NumberPropertiesPractice.s((u + 2) % 10), NumberPropertiesPractice.s((u + 5) % 10), NumberPropertiesPractice.s((u + 4) % 10));
        });
        lp.classicConcept(new GeneratedQuestion("What is the units digit of 7^100?", List.of("1", "7", "9", "3"), 0, "7 cycles 7,9,3,1 (length 4). 100 is a multiple of 4, so the units digit is the 4th, which is 1.", "HARD", EX), new GeneratedQuestion("What is the units digit of 6 raised to any positive power?", List.of("6", "0", "1", "It varies"), 0, "6\u00d76 = 36, 6\u00d736 = 216 \u2026 a number ending in 6 always stays ending in 6.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A PIN is the last digit of 3^2024. What is it?", List.of("1", "3", "9", "7"), 0, "3 cycles 3,9,7,1 (length 4). 2024 is a multiple of 4, so the units digit is 1.", "HARD", CWP), new GeneratedQuestion("The last digit of 2^7 is:", List.of("8", "4", "2", "6"), 0, "2 cycles 2,4,8,6. Position 7 \u2192 7 mod 4 = 3 \u2192 the 3rd value, 8.", "MEDIUM", WP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice factorCount() {
        LessonPractice lp = new LessonPractice("np-factor-count", TOPIC, "Counting factors and their sums");
        lp.concept(rng -> {
            int n = QBuilder.pick(rng, 36, 48, 60, 72, 96, 100, 120, 144, 180, 200);
            int f = NumberPropertiesPractice.countFactors(n);
            return QBuilder.build(rng, "How many factors does " + n + " have?", NumberPropertiesPractice.s(f), "Write " + n + " in prime powers, add 1 to each power, then multiply. " + n + " has " + f + " factors.", "MEDIUM", EX, NumberPropertiesPractice.s(f + 1), NumberPropertiesPractice.s(f - 1), NumberPropertiesPractice.s(f + 2), NumberPropertiesPractice.s(Math.max(2, f - 2)));
        }, rng -> {
            int n = QBuilder.pick(rng, 12, 18, 20, 28, 40, 45, 50, 60);
            int sum = NumberPropertiesPractice.sumOfFactors(n);
            return QBuilder.build(rng, "What is the sum of all factors of " + n + "?", NumberPropertiesPractice.s(sum), "Add every divisor of " + n + " (or multiply the power-sum brackets of its prime form). Total = " + sum + ".", "HARD", EX, NumberPropertiesPractice.s(sum + 1), NumberPropertiesPractice.s(sum - n), NumberPropertiesPractice.s(sum + n), NumberPropertiesPractice.s(sum - 1));
        }, rng -> {
            int n = QBuilder.pick(rng, 24, 40, 54, 72, 90, 96, 120, 144);
            int odd = NumberPropertiesPractice.countOddFactors(n);
            return QBuilder.build(rng, "How many odd factors does " + n + " have?", NumberPropertiesPractice.s(odd), "Ignore every power of 2 in the prime form of " + n + " and count the rest: " + odd + " odd factors.", "HARD", EX, NumberPropertiesPractice.s(odd + 1), NumberPropertiesPractice.s(odd - 1), NumberPropertiesPractice.s(NumberPropertiesPractice.countFactors(n)), NumberPropertiesPractice.s(odd + 2));
        });
        lp.word(rng -> {
            int n = QBuilder.pick(rng, 12, 18, 20, 24, 30, 40, 45, 48);
            int pairs = NumberPropertiesPractice.countFactors(n) / 2;
            return QBuilder.build(rng, "A gardener plants " + n + " identical bushes in a full rectangular block (rows \u00d7 columns). How many differently shaped blocks are possible?", NumberPropertiesPractice.s(pairs), "Each rectangle uses a factor pair of " + n + ". With " + NumberPropertiesPractice.countFactors(n) + " factors, there are " + pairs + " distinct shapes.", "MEDIUM", WP, NumberPropertiesPractice.s(pairs + 1), NumberPropertiesPractice.s(pairs - 1), NumberPropertiesPractice.s(NumberPropertiesPractice.countFactors(n)), NumberPropertiesPractice.s(pairs + 2));
        }, rng -> {
            int n = QBuilder.pick(rng, 12, 18, 24, 28, 30, 36, 40);
            int ways = NumberPropertiesPractice.countFactors(n) - 2;
            return QBuilder.build(rng, n + " chairs are set in equal rows with more than one row and more than one chair per row. In how many ways can this be done?", NumberPropertiesPractice.s(ways), "Count factor pairs but drop the 1\u00d7" + n + " and " + n + "\u00d71 layouts: " + NumberPropertiesPractice.countFactors(n) + " \u2212 2 = " + ways + " ways.", "HARD", CWP, NumberPropertiesPractice.s(ways + 1), NumberPropertiesPractice.s(ways + 2), NumberPropertiesPractice.s(NumberPropertiesPractice.countFactors(n)), NumberPropertiesPractice.s(Math.max(1, ways - 1)));
        });
        lp.classicConcept(new GeneratedQuestion("Which number has an odd number of factors?", List.of("49", "50", "48", "45"), 0, "Only perfect squares have an odd number of factors. 49 = 7\u00b2 has factors 1, 7, 49.", "MEDIUM", EX), new GeneratedQuestion("How many factors does 2\u00b3 \u00d7 3\u00b2 \u00d7 5 have?", List.of("24", "18", "12", "30"), 0, "(3+1)(2+1)(1+1) = 4\u00d73\u00d72 = 24.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A perfect-square number of tiles can always be laid out as:", List.of("a square (equal rows and columns)", "only a single line", "only a 2-row block", "never a rectangle"), 0, "A perfect square has a factor equal to its own square root, giving an equal rows\u00d7columns layout.", "MEDIUM", WP), new GeneratedQuestion("How many factors of 1200 = 2\u2074\u00d73\u00d75\u00b2 are divisible by 15?", List.of("10", "12", "8", "15"), 0, "Force 3\u00b9 and 5\u00b9: free choices are the power of 2 (5 ways) and the spare 5 (2 ways) \u2192 5\u00d72 = 10.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice factorials() {
        LessonPractice lp = new LessonPractice("np-factorial", TOPIC, "Factorials: trailing zeroes & highest powers");
        lp.concept(rng -> {
            int n = QBuilder.pick(rng, 25, 30, 47, 50, 60, 72, 100, 125, 90, 80);
            int z = NumberPropertiesPractice.trailingZeroes(n);
            return QBuilder.build(rng, "How many trailing zeroes does " + n + "! end in?", NumberPropertiesPractice.s(z), "Count the 5s: [" + n + "/5] + [" + n + "/25] + \u2026 = " + z + " zeroes.", "HARD", EX, NumberPropertiesPractice.s(z + 1), NumberPropertiesPractice.s(z - 1), NumberPropertiesPractice.s(z + 2), NumberPropertiesPractice.s(n / 5));
        }, rng -> {
            int n = QBuilder.pick(rng, 30, 40, 50, 60, 80, 100);
            int p = QBuilder.pick(rng, 3, 7);
            int hp = NumberPropertiesPractice.highestPowerOfPrime(n, p);
            return QBuilder.build(rng, "What is the highest power of " + p + " that divides " + n + "! exactly?", NumberPropertiesPractice.s(hp), "Add [" + n + "/" + p + "] + [" + n + "/" + p * p + "] + \u2026 = " + hp + ".", "HARD", EX, NumberPropertiesPractice.s(hp + 1), NumberPropertiesPractice.s(hp - 1), NumberPropertiesPractice.s(n / p), NumberPropertiesPractice.s(hp + 2));
        }, rng -> {
            int n = QBuilder.pick(rng, 20, 25, 30, 40, 50);
            int hp = NumberPropertiesPractice.highestPowerOfPrime(n, 2);
            return QBuilder.build(rng, "What is the highest power of 2 that divides " + n + "! exactly?", NumberPropertiesPractice.s(hp), "Add [" + n + "/2] + [" + n + "/4] + [" + n + "/8] + \u2026 = " + hp + ".", "HARD", EX, NumberPropertiesPractice.s(hp + 1), NumberPropertiesPractice.s(hp - 1), NumberPropertiesPractice.s(n / 2), NumberPropertiesPractice.s(hp + 2));
        });
        lp.word(rng -> {
            int n = QBuilder.pick(rng, 30, 45, 50, 60, 75, 90);
            int z = NumberPropertiesPractice.trailingZeroes(n);
            return QBuilder.build(rng, "The product of all whole numbers from 1 to " + n + " is written out. How many zeroes does it end in?", NumberPropertiesPractice.s(z), "That product is " + n + "!. Trailing zeroes = number of 5s = " + z + ".", "HARD", WP, NumberPropertiesPractice.s(z + 1), NumberPropertiesPractice.s(z - 1), NumberPropertiesPractice.s(z + 2), NumberPropertiesPractice.s(n / 5));
        }, rng -> {
            int n = QBuilder.pick(rng, 40, 50, 60, 80, 87);
            int fives = NumberPropertiesPractice.highestPowerOfPrime(n, 5);
            int threes = NumberPropertiesPractice.highestPowerOfPrime(n, 3);
            int ans = Math.min(fives, threes);
            return QBuilder.build(rng, "What is the highest power of 15 that divides " + n + "! exactly?", NumberPropertiesPractice.s(ans), "15 = 3\u00d75. Count both: 5s = " + fives + ", 3s = " + threes + ". The scarcer one wins \u2192 " + ans + ".", "HARD", CWP, NumberPropertiesPractice.s(ans + 1), NumberPropertiesPractice.s(ans - 1), NumberPropertiesPractice.s(Math.max(fives, threes)), NumberPropertiesPractice.s(ans + 2));
        });
        lp.classicConcept(new GeneratedQuestion("How many trailing zeroes are there in 100!?", List.of("24", "20", "25", "10"), 0, "[100/5] + [100/25] = 20 + 4 = 24.", "HARD", EX), new GeneratedQuestion("The highest power of 5 in 50! is:", List.of("12", "10", "6", "8"), 0, "[50/5] + [50/25] = 10 + 2 = 12.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("Why do we count only the 5s for trailing zeroes in a factorial?", List.of("5s are scarcer than 2s, and each zero needs a 2\u00d75 pair", "5s are larger numbers", "2s never appear in factorials", "factorials contain no 2s"), 0, "Every trailing zero comes from a 2\u00d75 pair; 2s are plentiful, so the supply of 5s is the limit.", "MEDIUM", WP), new GeneratedQuestion("The highest power of 6 dividing 20! is governed by:", List.of("the number of 3s (the scarcer prime)", "the number of 2s", "the number of 6s directly", "the number of 5s"), 0, "6 = 2\u00d73; 3s are scarcer than 2s in any factorial, so the 3s decide it.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice coprimes() {
        LessonPractice lp = new LessonPractice("np-coprime", TOPIC, "Co-prime numbers and how to use them");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 8, 40);
            int b = QBuilder.range(rng, 8, 40);
            int g = NumberPropertiesPractice.gcd(a, b);
            String correct = g == 1 ? "Yes" : "No";
            return QBuilder.build(rng, "Are " + a + " and " + b + " co-prime (HCF = 1)?", correct, "HCF(" + a + ", " + b + ") = " + g + (g == 1 ? ", so they are co-prime." : ", which is more than 1, so they are not co-prime."), "MEDIUM", EX, g == 1 ? "No" : "Yes", "Only if both are prime");
        }, rng -> {
            int n = QBuilder.range(rng, 12, 80);
            return QBuilder.build(rng, "What is the HCF of the consecutive numbers " + n + " and " + (n + 1) + "?", "1", "Two consecutive numbers never share a factor other than 1, so their HCF is always 1.", "EASY", EX, NumberPropertiesPractice.s(n), NumberPropertiesPractice.s(n + 1), "2", "0");
        }, rng -> {
            int a = QBuilder.pick(rng, 7, 9, 11, 13, 15, 17);
            int b = a + 2;
            return QBuilder.build(rng, "Are the consecutive odd numbers " + a + " and " + b + " co-prime?", "Yes", "Two consecutive odd numbers are always co-prime, so the answer is Yes.", "MEDIUM", EX, "No", "Cannot tell", "Only if both are prime");
        });
        lp.word(rng -> {
            int[] sp = QBuilder.pick(rng, new int[]{36, 4, 9}, new int[]{15, 3, 5}, new int[]{35, 5, 7}, new int[]{45, 9, 5}, new int[]{20, 4, 5}, new int[]{63, 9, 7}, new int[]{40, 8, 5}, new int[]{12, 4, 3});
            int d = sp[0];
            return QBuilder.build(rng, "To test divisibility by " + d + ", which co-prime pair can you check separately?", sp[1] + " and " + sp[2], d + " = " + sp[1] + " \u00d7 " + sp[2] + ", and these share no common factor, so testing both is enough.", "MEDIUM", WP, "2 and " + d / 2, "1 and " + d, sp[1] + " and " + d, "3 and " + d);
        }, rng -> {
            int a = QBuilder.pick(rng, 8, 9, 10, 12, 14, 15);
            int b = QBuilder.pick(rng, 9, 11, 13, 7, 25, 16);
            int l = NumberPropertiesPractice.lcm(a, b);
            return QBuilder.build(rng, "Two gears with " + a + " and " + b + " teeth start aligned. After how many teeth of rotation do they realign?", NumberPropertiesPractice.s(l), "They realign after the LCM of " + a + " and " + b + " = " + l + (NumberPropertiesPractice.isCoprime(a, b) ? " (and since they are co-prime, this equals " + a + "\u00d7" + b + ")." : "."), "HARD", CWP, NumberPropertiesPractice.s(a + b), NumberPropertiesPractice.s(NumberPropertiesPractice.gcd(a, b)), NumberPropertiesPractice.s(l + a), NumberPropertiesPractice.s(Math.max(a, b)));
        });
        lp.classicConcept(new GeneratedQuestion("Which pair of numbers is co-prime?", List.of("8 and 15", "8 and 12", "9 and 15", "10 and 25"), 0, "8 = 2\u00b3 and 15 = 3\u00d75 share no prime, so HCF = 1. The other pairs share a common factor.", "MEDIUM", EX), new GeneratedQuestion("The HCF of two distinct prime numbers is:", List.of("1", "their product", "the smaller prime", "2"), 0, "Distinct primes share no factor but 1, so they are co-prime.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A number passes the divisibility tests for both 4 and 9. It is definitely divisible by:", List.of("36", "13", "49", "It cannot be decided"), 0, "4 and 9 are co-prime, so passing both means divisibility by 4\u00d79 = 36.", "MEDIUM", WP), new GeneratedQuestion("Why can't you test divisibility by 12 using 2 and 6 separately?", List.of("2 and 6 are not co-prime", "12 is prime", "6 is prime", "you can \u2014 it always works"), 0, "2 and 6 share the factor 2, so the co-prime split rule fails; use 3 and 4 instead.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

