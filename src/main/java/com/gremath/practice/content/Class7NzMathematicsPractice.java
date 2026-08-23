package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;

import java.util.List;

public final class Class7NzMathematicsPractice {
    private static final String TOPIC = "class7-nz-mathematics";
    private static final String SKILL = "skill-check";
    private static final String WORD = "word problem";
    private static final String COMPLEX = "complex word problem";

    private Class7NzMathematicsPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(exponents());
        reg.add(primesHcf());
        reg.add(integers());
        reg.add(fdpFinance());
        reg.add(algebra());
        reg.add(measurement());
        reg.add(geometry());
        reg.add(statsProb());
    }

    private static String s(int n) {
        return Integer.toString(n);
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
        return a / gcd(a, b) * b;
    }

    private static LessonPractice exponents() {
        LessonPractice lp = new LessonPractice("c7nz-exponents", TOPIC, "Place value, exponents and square roots");
        lp.concept(
                rng -> {
                    int e = QBuilder.range(rng, 2, 5);
                    int val = (int) Math.pow(10, e);
                    return QBuilder.build(rng, QBuilder.pick(rng,
                                    "What is 10^" + e + "?",
                                    "10 to the power of " + e + " equals…"), s(val),
                            "10^" + e + " means " + e + " tens multiplied: " + val + ".",
                            "EASY", SKILL, s(10 * e), s(val * 10), s(val / 10))
                            .withHint("Count zeros after 1. 10^" + e + " is not 10 × " + e + ".");
                },
                rng -> {
                    int n = QBuilder.pick(rng, 4, 5, 6, 7, 8, 9, 10, 11, 12);
                    return QBuilder.build(rng, "What is " + n + "^2?", s(n * n),
                            n + " squared is " + n + " × " + n + " = " + (n * n) + ".",
                            "EASY", SKILL, s(2 * n), s(n * n + n), s(n * n - 1));
                },
                rng -> {
                    int root = QBuilder.pick(rng, 5, 6, 7, 8, 9, 10, 11, 12);
                    return QBuilder.build(rng, "What is √" + (root * root) + "?", s(root),
                            "√" + (root * root) + " asks which number times itself gives " + (root * root) + ".",
                            "MEDIUM", SKILL, s(root + 1), s(root * 2), s(root - 1));
                },
                rng -> {
                    int a = QBuilder.range(rng, 1, 9);
                    int b = QBuilder.range(rng, 0, 9);
                    int c = QBuilder.range(rng, 0, 9);
                    int n = a * 100 + b * 10 + c;
                    String expanded = a + "×10^2 + " + b + "×10^1 + " + c;
                    return QBuilder.build(rng, "Expanded form of " + n + " using powers of 10 is closest to:", expanded,
                            "Hundreds = ×10^2, tens = ×10^1, ones = ×10^0.",
                            "MEDIUM", SKILL, a + " + " + b + " + " + c, a + "×1000 + " + b + "×10 + " + c, s(n));
                }
        );
        lp.word(
                rng -> {
                    int side = QBuilder.pick(rng, 6, 8, 9, 10, 12);
                    return QBuilder.build(rng, "A square courtyard has side " + side + " m. What is its area?", s(side * side) + " m²",
                            "Area of square = side² = " + side + "² = " + (side * side) + " m².",
                            "EASY", WORD, s(4 * side) + " m²", s(side * side + side) + " m²", s(2 * side) + " m²");
                },
                rng -> {
                    int tiles = QBuilder.pick(rng, 36, 49, 64, 81, 100, 121, 144);
                    int side = (int) Math.sqrt(tiles);
                    return QBuilder.build(rng, "A square mosaic uses " + tiles + " equal tiles. How many tiles along one side?", s(side),
                            "Side length = √" + tiles + " = " + side + ".",
                            "MEDIUM", COMPLEX, s(side + 1), s(tiles / 2), s(side * 2));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("10^4 equals:", List.of("10,000", "1,000", "100,000", "40"), 0, "10×10×10×10 = 10,000.", "EASY", SKILL),
                new GeneratedQuestion("√144 equals:", List.of("12", "14", "72", "24"), 0, "12×12 = 144.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A square photo has area 64 cm². Side length is:", List.of("8 cm", "16 cm", "32 cm", "4 cm"), 0, "√64 = 8.", "EASY", WORD),
                new GeneratedQuestion("Which power of 10 matches one million?", List.of("10^6", "10^5", "10^7", "10^4"), 0, "1,000,000 = 10^6.", "MEDIUM", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Exp());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice primesHcf() {
        LessonPractice lp = new LessonPractice("c7nz-primes-hcf", TOPIC, "Primes, HCF, LCM and divisibility");
        lp.concept(
                rng -> {
                    int n = QBuilder.pick(rng, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53);
                    return QBuilder.build(rng, "Is " + n + " prime or composite?", "Prime",
                            n + " has only factors 1 and itself.",
                            "EASY", SKILL, "Composite", "Neither", "Both");
                },
                rng -> {
                    int a = QBuilder.pick(rng, 12, 18, 24, 30, 36, 48);
                    int b = QBuilder.pick(rng, 16, 20, 28, 32, 40, 45);
                    int g = gcd(a, b);
                    return QBuilder.build(rng, "HCF of " + a + " and " + b + " is:", s(g),
                            "Greatest shared factor of " + a + " and " + b + " is " + g + ".",
                            "MEDIUM", SKILL, s(lcm(a, b)), s(g + 1), s(Math.min(a, b)));
                },
                rng -> {
                    int a = QBuilder.pick(rng, 4, 5, 6, 8, 9);
                    int b = QBuilder.pick(rng, 3, 4, 6, 7, 8);
                    int l = lcm(a, b);
                    return QBuilder.build(rng, "LCM of " + a + " and " + b + " is:", s(l),
                            "Smallest shared multiple is " + l + ".",
                            "MEDIUM", SKILL, s(gcd(a, b)), s(a * b), s(l + a));
                },
                rng -> {
                    int n = QBuilder.range(rng, 100, 999);
                    String ans = n % 3 == 0 ? "Yes" : "No";
                    return QBuilder.build(rng, "Is " + n + " divisible by 3?", ans,
                            "Digit sum test: divisible by 3 iff digit sum is.",
                            "EASY", SKILL, ans.equals("Yes") ? "No" : "Yes", "Only if even");
                }
        );
        lp.word(
                rng -> {
                    int a = QBuilder.pick(rng, 24, 36, 48, 60);
                    int b = QBuilder.pick(rng, 18, 30, 42, 54);
                    int g = gcd(a, b);
                    return QBuilder.build(rng, "Two ribbons " + a + " cm and " + b + " cm are cut into equal longest pieces with none wasted. Piece length?", g + " cm",
                            "Longest equal piece = HCF = " + g + " cm.",
                            "MEDIUM", WORD, lcm(a, b) + " cm", (g + 2) + " cm", Math.min(a, b) + " cm");
                },
                rng -> {
                    int a = QBuilder.pick(rng, 4, 6, 8, 9);
                    int b = QBuilder.pick(rng, 5, 6, 7, 10);
                    int l = lcm(a, b);
                    return QBuilder.build(rng, "Bells ring every " + a + " and " + b + " minutes. After how many minutes do they next ring together?", l + " min",
                            "They sync at LCM = " + l + " minutes.",
                            "MEDIUM", COMPLEX, (a * b) + " min", s(gcd(a, b)) + " min", (a + b) + " min");
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which number is prime?", List.of("47", "49", "51", "57"), 0, "47 is prime; others factor.", "MEDIUM", SKILL),
                new GeneratedQuestion("HCF of 18 and 24 is:", List.of("6", "12", "3", "72"), 0, "Common factors max at 6.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("LCM of 6 and 8 is:", List.of("24", "48", "14", "2"), 0, "LCM(6,8)=24.", "EASY", WORD),
                new GeneratedQuestion("Which is divisible by 9?", List.of("729", "728", "730", "731"), 0, "7+2+9=18, divisible by 9.", "MEDIUM", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Primes());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice integers() {
        LessonPractice lp = new LessonPractice("c7nz-integers", TOPIC, "Integers and order of operations (GEMA)");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, -20, 20);
                    return QBuilder.build(rng, "Additive inverse of " + a + " is:", s(-a),
                            a + " + (" + (-a) + ") = 0.",
                            "EASY", SKILL, s(a), "0", s(Math.abs(a)));
                },
                rng -> {
                    int a = QBuilder.range(rng, -15, 15);
                    int b = QBuilder.range(rng, -15, 15);
                    return QBuilder.build(rng, "Calculate " + a + " + (" + b + ").", s(a + b),
                            "Combine signed values carefully.",
                            "MEDIUM", SKILL, s(a - b), s(-(a + b)), s(a + b + 1));
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 8);
                    int b = QBuilder.range(rng, 2, 6);
                    int c = QBuilder.range(rng, 1, 5);
                    int ans = a + b * c;
                    return QBuilder.build(rng, "Evaluate " + a + " + " + b + " × " + c + " (GEMA).", s(ans),
                            "Multiply first: " + b + "×" + c + " = " + (b * c) + ", then add " + a + ".",
                            "MEDIUM", SKILL, s((a + b) * c), s(a * b + c), s(ans + 1));
                },
                rng -> {
                    int e = QBuilder.pick(rng, 2, 3);
                    int base = QBuilder.pick(rng, 2, 3, 4);
                    int add = QBuilder.range(rng, 1, 8);
                    int ans = add + (int) Math.pow(base, e);
                    return QBuilder.build(rng, "Evaluate " + add + " + " + base + "^" + e + ".", s(ans),
                            "Exponents before addition: " + base + "^" + e + " = " + (int) Math.pow(base, e) + ".",
                            "HARD", SKILL, s(add + base * e), s((add + base) * e), s(ans - 1));
                }
        );
        lp.word(
                rng -> {
                    int start = QBuilder.range(rng, -5, 12);
                    int drop = QBuilder.range(rng, 3, 15);
                    return QBuilder.build(rng, "Temperature was " + start + "°C then dropped " + drop + "°C. New temperature?", (start - drop) + "°C",
                            "Drop means subtract: " + start + " − " + drop + " = " + (start - drop) + ".",
                            "EASY", WORD, (start + drop) + "°C", (-start - drop) + "°C", (drop - start) + "°C");
                },
                rng -> {
                    int bal = QBuilder.range(rng, 50, 200);
                    int spend = bal + QBuilder.range(rng, 20, 80);
                    return QBuilder.build(rng, "Account has $" + bal + " and spends $" + spend + ". New balance?", "$" + (bal - spend),
                            "Balance = " + bal + " − " + spend + " = " + (bal - spend) + ".",
                            "MEDIUM", COMPLEX, "$" + (spend - bal), "$" + (bal + spend), "$" + (-bal));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("2 + 3 × 4 =", List.of("14", "20", "9", "24"), 0, "3×4 first → 14.", "EASY", SKILL),
                new GeneratedQuestion("Additive inverse of −7 is:", List.of("7", "−7", "0", "1"), 0, "−7 + 7 = 0.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("From −3°C to 5°C, temperature rose by:", List.of("8°C", "2°C", "−8°C", "15°C"), 0, "5 − (−3) = 8.", "MEDIUM", WORD),
                new GeneratedQuestion("Evaluate (2 + 3) × 4.", List.of("20", "14", "9", "24"), 0, "Brackets first: 5×4 = 20.", "EASY", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Int());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice fdpFinance() {
        LessonPractice lp = new LessonPractice("c7nz-fdp-finance", TOPIC, "Fractions, decimals, percentages and financial maths");
        lp.concept(
                rng -> {
                    int den = QBuilder.pick(rng, 2, 4, 5, 10, 20, 25);
                    int num = QBuilder.range(rng, 1, den - 1);
                    int pct = num * 100 / den;
                    return QBuilder.build(rng, MathFigures.ask(
                                    "This bar shows " + num + "/" + den + ". What percent is shaded?",
                                    MathFigures.fractionBar(num, den, num + " of " + den + " equal parts")),
                            pct + "%",
                            "Multiply the fraction by 100%: " + num + "/" + den + " = " + pct + "%.",
                            "EASY", SKILL, (pct + 10) + "%", num + "%", (100 / den) + "%");
                },
                rng -> {
                    int whole = QBuilder.pick(rng, 40, 60, 80, 100, 120, 200);
                    int pct = QBuilder.pick(rng, 10, 20, 25, 30, 40, 50);
                    int part = whole * pct / 100;
                    return QBuilder.build(rng, "What is " + pct + "% of " + whole + "?", s(part),
                            "part = percent × whole / 100.",
                            "MEDIUM", SKILL, s(whole - part), s(part + 10), s(pct));
                },
                rng -> {
                    int a = QBuilder.range(rng, 10, 99);
                    int b = QBuilder.range(rng, 10, 99);
                    String correct = a >= b ? "0." + a : "0." + b;
                    return QBuilder.build(rng, "Which is larger: 0." + a + " or 0." + b + "?", correct,
                            "Compare tenths then hundredths.",
                            "EASY", SKILL, a < b ? "0." + a : "0." + b, "Equal", "0." + Math.max(a, b) + "1");
                },
                rng -> {
                    int price = QBuilder.pick(rng, 40, 50, 60, 80, 100, 120);
                    int pct = QBuilder.pick(rng, 10, 20, 25, 30, 50);
                    int sale = price - price * pct / 100;
                    return QBuilder.build(rng, "A $" + price + " item has " + pct + "% discount. Sale price?", "$" + sale,
                            "Discount = " + pct + "% of " + price + "; subtract from original.",
                            "MEDIUM", SKILL, "$" + (price * pct / 100), "$" + (price + sale), "$" + (sale + 5));
                }
        );
        lp.word(
                rng -> {
                    int cost = QBuilder.range(rng, 15, 80);
                    int pay = cost + QBuilder.pick(rng, 5, 10, 20, 50);
                    return QBuilder.build(rng, "Item costs $" + cost + ". You pay with $" + pay + ". Change?", "$" + (pay - cost),
                            "Change = money given − cost.",
                            "EASY", WORD, "$" + (pay + cost), "$" + cost, "$" + (pay - cost + 1));
                },
                rng -> {
                    int original = QBuilder.pick(rng, 80, 100, 120, 160, 200);
                    int pct = QBuilder.pick(rng, 15, 20, 25, 30);
                    int sale = original - original * pct / 100;
                    return QBuilder.build(rng, "Jacket $" + original + " is " + pct + "% off. What do you pay?", "$" + sale,
                            "Pay original minus discount amount.",
                            "MEDIUM", COMPLEX, "$" + (original * pct / 100), "$" + original, "$" + (sale - 5));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("3/4 as a percent is:", List.of("75%", "34%", "43%", "70%"), 0, "3÷4=0.75=75%.", "EASY", SKILL),
                new GeneratedQuestion("0.2 as a fraction in lowest terms:", List.of("1/5", "2/10", "1/2", "2/5"), 0, "0.2 = 2/10 = 1/5.", "MEDIUM", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("25% of $60 is:", List.of("$15", "$25", "$20", "$10"), 0, "0.25×60=15.", "EASY", WORD),
                new GeneratedQuestion("Pay $50 for a $37.40 item. Change is:", List.of("$12.60", "$13.60", "$12.40", "$87.40"), 0, "50−37.40=12.60.", "MEDIUM", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Fdp());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice algebra() {
        LessonPractice lp = new LessonPractice("c7nz-algebra", TOPIC, "Algebra: equations, like terms and linear graphs");
        lp.concept(
                rng -> {
                    int x = QBuilder.range(rng, 2, 20);
                    int add = QBuilder.range(rng, 3, 25);
                    return QBuilder.build(rng, "Solve: x + " + add + " = " + (x + add), s(x),
                            "Subtract " + add + " from both sides.",
                            "EASY", SKILL, s(x + add), s(add), s(x + 1));
                },
                rng -> {
                    int x = QBuilder.range(rng, 2, 15);
                    int m = QBuilder.pick(rng, 2, 3, 4, 5);
                    int b = QBuilder.range(rng, 1, 12);
                    int rhs = m * x + b;
                    return QBuilder.build(rng, "Solve: " + m + "x + " + b + " = " + rhs, s(x),
                            "Subtract " + b + ", then divide by " + m + ".",
                            "MEDIUM", SKILL, s(rhs), s(x + 1), s(m));
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 8);
                    int b = QBuilder.range(rng, 1, 7);
                    int c = QBuilder.range(rng, 1, 6);
                    return QBuilder.build(rng, "Simplify: " + a + "x + " + b + "x + " + c, (a + b) + "x + " + c,
                            "Collect like x terms: " + a + "x + " + b + "x = " + (a + b) + "x.",
                            "MEDIUM", SKILL, a + "x + " + b + " + " + c, (a + b + c) + "x", a + "x + " + (b + c));
                },
                rng -> {
                    int n = QBuilder.range(rng, 1, 8);
                    int m = QBuilder.pick(rng, 2, 3, 4);
                    int c = QBuilder.range(rng, 0, 5);
                    int y = m * n + c;
                    return QBuilder.build(rng, "Rule y = " + m + "n + " + c + ". If n = " + n + ", y = ?", s(y),
                            "Substitute: " + m + "×" + n + " + " + c + " = " + y + ".",
                            "MEDIUM", SKILL, s(m * n), s(n + c), s(y + m));
                }
        );
        lp.word(
                rng -> {
                    int tickets = QBuilder.range(rng, 3, 12);
                    int price = QBuilder.pick(rng, 8, 10, 12, 15);
                    int fee = QBuilder.pick(rng, 2, 3, 5);
                    int total = tickets * price + fee;
                    return QBuilder.build(rng, "Tickets cost $" + price + " each plus $" + fee + " booking fee. " + tickets + " tickets cost?", "$" + total,
                            "Total = " + tickets + "×" + price + " + " + fee + ".",
                            "MEDIUM", WORD, "$" + (tickets * price), "$" + (total - fee), "$" + (tickets + price + fee));
                },
                rng -> {
                    int start = QBuilder.range(rng, 5, 20);
                    int step = QBuilder.pick(rng, 2, 3, 4, 5);
                    int term = 5;
                    int value = start + step * (term - 1);
                    return QBuilder.build(rng, "Pattern starts at " + start + " and adds " + step + " each time. 5th term?", s(value),
                            "5th term = start + 4×step.",
                            "HARD", COMPLEX, s(start + step * term), s(start + step), s(value - step));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Solve 2x = 18.", List.of("x = 9", "x = 16", "x = 36", "x = 8"), 0, "Divide both sides by 2.", "EASY", SKILL),
                new GeneratedQuestion("Simplify 3a + 5a.", List.of("8a", "15a", "8", "3a5a"), 0, "Like terms: 3+5=8.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("If y = 3x + 1 and x = 4, y is:", List.of("13", "12", "7", "16"), 0, "3×4+1=13.", "EASY", WORD),
                new GeneratedQuestion("Solve x − 8 = 11.", List.of("x = 19", "x = 3", "x = −3", "x = 88"), 0, "Add 8: x=19.", "EASY", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Alg());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice measurement() {
        LessonPractice lp = new LessonPractice("c7nz-measurement", TOPIC, "Measurement: perimeter, area, volume and duration");
        lp.concept(
                rng -> {
                    int m = QBuilder.range(rng, 2, 25);
                    return QBuilder.build(rng, "Convert " + m + " m to cm.", s(m * 100),
                            "1 m = 100 cm.",
                            "EASY", SKILL, s(m * 10), s(m * 1000), s(m + 100));
                },
                rng -> {
                    int l = QBuilder.range(rng, 4, 20);
                    int w = QBuilder.range(rng, 3, 15);
                    return QBuilder.build(rng, MathFigures.ask(
                                    "What is the perimeter of this rectangle?",
                                    MathFigures.rectangle(l, w, l + " cm by " + w + " cm")),
                            s(2 * (l + w)) + " cm",
                            "P = 2(l + w) = 2(" + l + " + " + w + ") = " + (2 * (l + w)) + " cm.",
                            "EASY", SKILL, s(l * w) + " cm", s(l + w) + " cm", s(2 * l * w) + " cm");
                },
                rng -> {
                    int b = QBuilder.range(rng, 4, 20);
                    int h = QBuilder.range(rng, 3, 16);
                    return QBuilder.build(rng, MathFigures.ask(
                                    "What is the area of this right triangle?",
                                    MathFigures.rightTriangle(b, h, null, "Right angle marked. Area = ½ × base × height.")),
                            s(b * h / 2) + " cm²",
                            "Area = ½ × " + b + " × " + h + " = " + (b * h / 2) + " cm².",
                            "MEDIUM", SKILL, s(b * h) + " cm²", s(b + h) + " cm²", s(2 * (b + h)) + " cm²");
                },
                rng -> {
                    int l = QBuilder.range(rng, 2, 10);
                    int w = QBuilder.range(rng, 2, 8);
                    int h = QBuilder.range(rng, 2, 8);
                    return QBuilder.build(rng, "Volume of " + l + "×" + w + "×" + h + " cm rectangular prism?", s(l * w * h) + " cm³",
                            "V = l×w×h.",
                            "MEDIUM", SKILL, s(l * w) + " cm³", s(2 * (l * w + w * h + h * l)) + " cm³", s(l + w + h) + " cm³");
                }
        );
        lp.word(
                rng -> {
                    int startH = QBuilder.range(rng, 8, 14);
                    int startM = QBuilder.pick(rng, 0, 15, 20, 30, 45);
                    int dur = QBuilder.pick(rng, 40, 50, 55, 70, 90);
                    int end = startH * 60 + startM + dur;
                    int endH = end / 60;
                    int endM = end % 60;
                    String ans = endH + ":" + String.format("%02d", endM);
                    return QBuilder.build(rng, "Bus leaves at " + startH + ":" + String.format("%02d", startM) + " and travels " + dur + " min. Arrival time?", ans,
                            "Add duration to start time.",
                            "HARD", WORD, startH + ":" + String.format("%02d", (startM + dur) % 60), (endH + 1) + ":" + String.format("%02d", endM), ans + "0");
                },
                rng -> {
                    int side = QBuilder.range(rng, 3, 12);
                    return QBuilder.build(rng, "Cube of side " + side + " cm. Volume?", s(side * side * side) + " cm³",
                            "V = side³.",
                            "MEDIUM", COMPLEX, s(side * side) + " cm³", s(6 * side * side) + " cm³", s(3 * side) + " cm³");
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Area of 8 cm by 5 cm rectangle:", List.of("40 cm²", "26 cm²", "13 cm²", "80 cm²"), 0, "8×5=40.", "EASY", SKILL),
                new GeneratedQuestion("3 kg = how many grams?", List.of("3000", "300", "30", "30000"), 0, "1 kg = 1000 g.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("Movie 14:20 to 16:05 lasts:", List.of("1 h 45 min", "1 h 30 min", "2 h 15 min", "105 h"), 0, "From 14:20 to 16:05 is 105 min = 1 h 45 min.", "MEDIUM", WORD),
                new GeneratedQuestion("Perimeter of square side 9 cm:", List.of("36 cm", "81 cm", "18 cm", "27 cm"), 0, "4×9=36.", "EASY", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Meas());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice geometry() {
        LessonPractice lp = new LessonPractice("c7nz-geometry", TOPIC, "Geometry: triangles, angles and transformations");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, 20, 80);
                    int b = QBuilder.range(rng, 20, 80);
                    int c = 180 - a - b;
                    if (c <= 0) {
                        c = 40;
                        b = 180 - a - c;
                    }
                    return QBuilder.build(rng, MathFigures.ask(
                                    "Find the missing angle in this triangle.",
                                    MathFigures.triangleAngles(a, b, "?", "Triangle angle sum is 180°.")),
                            c + "°",
                            "Angles in a triangle sum to 180°: 180 − " + a + " − " + b + " = " + c + "°.",
                            "MEDIUM", SKILL, (a + b) + "°", (180 - a) + "°", (90 - c) + "°");
                },
                rng -> {
                    int vertex = QBuilder.pick(rng, 20, 30, 40, 50, 70, 80);
                    int base = (180 - vertex) / 2;
                    return QBuilder.build(rng, "Isosceles triangle, vertex " + vertex + "°. Each base angle?", base + "°",
                            "Base angles equal: (180 − vertex)/2.",
                            "MEDIUM", SKILL, vertex + "°", (180 - vertex) + "°", (base + 10) + "°");
                },
                rng -> {
                    int onLine = QBuilder.range(rng, 40, 140);
                    return QBuilder.build(rng, MathFigures.ask(
                                    "The diagram shows a straight line. What is the unmarked angle?",
                                    MathFigures.anglesOnLine(onLine, "Adjacent angles on a straight line add to 180°.")),
                            (180 - onLine) + "°",
                            "Straight line sums to 180°: 180 − " + onLine + " = " + (180 - onLine) + "°.",
                            "EASY", SKILL, (360 - onLine) + "°", (90 - onLine) + "°", onLine + "°");
                },
                rng -> QBuilder.build(rng, "Equilateral triangle each angle is:", "60°",
                        "Three equal angles: 180÷3 = 60.",
                        "EASY", SKILL, "90°", "45°", "120°")
        );
        lp.word(
                rng -> {
                    int order = QBuilder.pick(rng, 2, 3, 4, 5, 6);
                    int turn = 360 / order;
                    return QBuilder.build(rng, "Shape has rotational symmetry order " + order + ". Turn angle to match?", turn + "°",
                            "Full turn ÷ order = " + turn + "°.",
                            "HARD", WORD, (360 - turn) + "°", (order * 10) + "°", "180°");
                },
                rng -> QBuilder.build(rng, "A square is reflected over a vertical midline. The image is:", "still a square in mirrored position",
                        "Reflection preserves size and shape; orientation flips.",
                        "MEDIUM", COMPLEX, "a circle", "a larger square", "a triangle")
        );
        lp.classicConcept(
                new GeneratedQuestion("Sum of angles in any triangle:", List.of("180°", "360°", "90°", "270°"), 0, "Always 180°.", "EASY", SKILL),
                new GeneratedQuestion("A right triangle has one angle of:", List.of("90°", "180°", "60° only", "45° only"), 0, "Right means 90°.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("Clock hand from 3 to 6 turns:", List.of("90°", "60°", "180°", "30°"), 0, "3 hour marks × 30° = 90°.", "MEDIUM", WORD),
                new GeneratedQuestion("Triangle angles 50°, 60°, ?:", List.of("70°", "80°", "90°", "100°"), 0, "180−110=70.", "EASY", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Geo());
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice statsProb() {
        LessonPractice lp = new LessonPractice("c7nz-stats-prob", TOPIC, "Statistics and probability");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, 5, 20);
                    int b = QBuilder.range(rng, 5, 20);
                    int c = QBuilder.range(rng, 5, 20);
                    int d = QBuilder.range(rng, 5, 20);
                    int mean = (a + b + c + d) / 4;
                    return QBuilder.build(rng, "Mean of " + a + ", " + b + ", " + c + ", " + d + "?", s(mean),
                            "Sum ÷ 4.",
                            "MEDIUM", SKILL, s(mean + 1), s(a + b + c + d), s(mean - 1));
                },
                rng -> {
                    int low = QBuilder.range(rng, 5, 25);
                    int high = QBuilder.range(rng, 30, 80);
                    return QBuilder.build(rng, "Range if min=" + low + " and max=" + high + "?", s(high - low),
                            "Range = max − min.",
                            "EASY", SKILL, s(high + low), s(high - low + 1), s(high));
                },
                rng -> {
                    int fav = QBuilder.range(rng, 1, 8);
                    int total = QBuilder.range(rng, fav + 2, 12);
                    String[] labels = new String[total];
                    for (int i = 0; i < total; i++) {
                        labels[i] = i < fav ? "W" : "L";
                    }
                    return QBuilder.build(rng, MathFigures.ask(
                                    "A fair spinner. What is P(landing on W)?",
                                    MathFigures.spinner(labels, 0, fav + " winning sectors out of " + total)),
                            fav + "/" + total,
                            "Theoretical probability = favourable ÷ total = " + fav + "/" + total + ".",
                            "EASY", SKILL, (total - fav) + "/" + total, fav + "/" + (total + 1), s(fav) + "/" + (total - 1));
                },
                rng -> {
                    int p = QBuilder.pick(rng, 1, 2, 3, 4);
                    int q = 5;
                    return QBuilder.build(rng, "P(event) = " + p + "/" + q + ". P(not event)?", (q - p) + "/" + q,
                            "Complement: 1 − P = (q−p)/q.",
                            "MEDIUM", SKILL, p + "/" + q, (q - p) + "/" + (q + 1), "1/" + q);
                }
        );
        lp.word(
                rng -> {
                    int heads = QBuilder.range(rng, 8, 25);
                    int tosses = QBuilder.range(rng, heads + 5, 40);
                    return QBuilder.build(rng, "Coin: " + heads + " heads in " + tosses + " tosses. Experimental P(heads)?", heads + "/" + tosses,
                            "Relative frequency = observed ÷ trials.",
                            "MEDIUM", WORD, (tosses - heads) + "/" + tosses, heads + "/" + (tosses - 1), "1/2");
                },
                rng -> {
                    int[] data = {QBuilder.range(rng, 10, 20), QBuilder.range(rng, 10, 20), QBuilder.range(rng, 10, 20), QBuilder.range(rng, 10, 20), QBuilder.range(rng, 10, 20)};
                    int sum = data[0] + data[1] + data[2] + data[3] + data[4];
                    return QBuilder.build(rng, "Five daily sales: " + data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] + ". Mean sales?", s(sum / 5),
                            "Average = total ÷ 5.",
                            "HARD", COMPLEX, s(sum), s(sum / 4), s(sum / 6));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Mode of 2, 5, 5, 7 is:", List.of("5", "2", "7", "4.75"), 0, "5 appears most.", "EASY", SKILL),
                new GeneratedQuestion("Median of 3, 8, 9:", List.of("8", "3", "9", "6.7"), 0, "Middle value when ordered is 8.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("Die fair. P(rolling a 4)?", List.of("1/6", "4/6", "1/4", "1/2"), 0, "One favourable of six faces.", "EASY", WORD),
                new GeneratedQuestion("P(rain)=0.3. P(not rain)?", List.of("0.7", "0.3", "1.3", "0"), 0, "Complement 1−0.3=0.7.", "MEDIUM", WORD)
        );
        lp.concept(Year67IllustratedBank.c7Stats());
        return lp.sheets(20, 10, 20);
    }
}
