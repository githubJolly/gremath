package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/**
 * Year-aware maths items with distinct stems (so sheets do not recycle the same sentence)
 * and a method hint that never states the answer.
 */
final class NzMathQuestionBank {

    private NzMathQuestionBank() {
    }

    static QuestionTemplate[] number(int year, boolean word) {
        int cap = year <= 1 ? 20 : year <= 2 ? 100 : year <= 4 ? 1000 : year <= 6 ? 10_000 : 100_000;
        return new QuestionTemplate[]{
                rng -> {
                    int a = QBuilder.range(rng, Math.max(3, cap / 8), cap);
                    int b = QBuilder.range(rng, Math.max(2, cap / 10), cap);
                    if (a == b) {
                        b = Math.min(cap, a + QBuilder.range(rng, 1, 9));
                    }
                    String larger = String.valueOf(Math.max(a, b));
                    String prompt = word
                            ? QBuilder.pick(rng,
                            "Kura A has " + a + " books and kura B has " + b + ". Which collection is larger? Give that number.",
                            "Two sports crowds: " + a + " and " + b + ". Report the bigger crowd.")
                            : QBuilder.pick(rng,
                            "Which number is greater: " + a + " or " + b + "?",
                            "Pick the larger of " + a + " and " + b + ".",
                            a + " □ " + b + " — which value wins if □ means ‘greater’?");
                    return hint(QBuilder.build(rng, prompt, larger,
                            "Compare from the left-most place. First different digit decides.",
                            "EASY", tag(word),
                            String.valueOf(Math.min(a, b)), String.valueOf(Math.abs(a - b)), String.valueOf(a + b)),
                            "Compare place by place from the left. Ignore the extra story words.");
                },
                rng -> {
                    if (year == 1) {
                        int n = QBuilder.range(rng, 2, 18);
                        return hint(QBuilder.build(rng, "What number comes just after " + n + "?",
                                String.valueOf(n + 1), "Count on one.", "EASY", "skill-check",
                                String.valueOf(n - 1), String.valueOf(n), String.valueOf(n + 2)),
                                "Say the counting sequence. The next word after " + n + " is the answer.");
                    }
                    int n = QBuilder.range(rng, 14, Math.min(cap, year <= 2 ? 90 : 480));
                    int tens = (n / 10) * 10;
                    int rounded = n % 10 >= 5 ? tens + 10 : tens;
                    return hint(QBuilder.build(rng, QBuilder.pick(rng,
                                    "Round " + n + " to the nearest ten.",
                                    "What is " + n + " to the nearest 10?"),
                            String.valueOf(rounded),
                            "Ones digit 5 or more rounds up.", "MEDIUM", "skill-check",
                            String.valueOf(tens), String.valueOf(n), String.valueOf(rounded + 10)),
                            "Look only at the ones digit. 0–4 stay, 5–9 bump the tens.");
                },
                rng -> {
                    int n = year <= 2 ? QBuilder.range(rng, 10, 99) : QBuilder.range(rng, 120, Math.min(cap, 9999));
                    int tensDigit = (n / 10) % 10;
                    return hint(QBuilder.build(rng, QBuilder.pick(rng,
                                    "What digit sits in the tens place of " + n + "?",
                                    "In " + n + ", the tens digit is…"),
                            String.valueOf(tensDigit),
                            "From the right: ones, then tens.", "EASY", "visual pattern",
                            String.valueOf(n % 10), String.valueOf((n / 100) % 10), String.valueOf(n)),
                            "Point to ones first, then slide one place left. That neighbour is tens.");
                },
                rng -> {
                    if (year < 5) {
                        int n = QBuilder.range(rng, 5, Math.min(cap, 40));
                        boolean even = n % 2 == 0;
                        return hint(QBuilder.build(rng, "Is " + n + " even or odd?", even ? "even" : "odd",
                                "Even numbers end in 0, 2, 4, 6 or 8.", "EASY", "skill-check",
                                even ? "odd" : "even", "prime", "a fraction"),
                                "Check only the last digit. Even last digits are even numbers.");
                    }
                    int root = QBuilder.pick(rng, 4, 5, 6, 7, 8, 9, 10, 11, 12);
                    return hint(QBuilder.build(rng, "What is √" + (root * root) + "?",
                            String.valueOf(root), root + " × " + root + " = " + (root * root) + ".",
                            "MEDIUM", "skill-check", String.valueOf(root + 1), String.valueOf(root * 2), String.valueOf(root * root)),
                            "Square root asks: which number times itself makes the inside?");
                },
                rng -> {
                    int n = year <= 2 ? QBuilder.range(rng, 11, 47) : QBuilder.range(rng, 103, Math.min(cap, 870));
                    int ones = n % 10;
                    return hint(QBuilder.build(rng, "What is the ones digit of " + n + "?",
                            String.valueOf(ones), "The ones place is the last digit.", "EASY", "skill-check",
                            String.valueOf((n / 10) % 10), String.valueOf(n / 10), String.valueOf(ones + 1)),
                            "Cover every digit except the last one. That last digit is ones.");
                },
                rng -> {
                    if (year <= 3) {
                        int start = QBuilder.range(rng, 2, year == 1 ? 12 : 40);
                        return hint(QBuilder.build(rng, MathFigures.ask(
                                        "Which number is marked on this line?",
                                        MathFigures.numberLine(0, year == 1 ? 20 : 20, start, "The orange dot is the number you want.")),
                                String.valueOf(start), "Read the labelled tick under the mark.",
                                "MEDIUM", "visual pattern",
                                String.valueOf(start + 1), String.valueOf(start - 1), String.valueOf(start + 2)),
                                "Match the orange mark to the nearest labelled tick. Do not count the arrows.");
                    }
                    int th = QBuilder.range(rng, 1, 8);
                    int h = QBuilder.range(rng, 0, 9);
                    int t = QBuilder.range(rng, 0, 9);
                    int o = QBuilder.range(rng, 1, 9);
                    String expanded = (th * 1000) + " + " + (h * 100) + " + " + (t * 10) + " + " + o;
                    int n = th * 1000 + h * 100 + t * 10 + o;
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "Which expanded form matches the chart for " + n + "?",
                                    MathFigures.placeValueChart(th, h, t, o, "Read each house as value, not as a lone digit.")),
                            expanded, "Digit × place value, then add.", "MEDIUM", "visual pattern",
                            th + " + " + h + " + " + t + " + " + o, String.valueOf(n), th + "×10 + " + h),
                            "Thousands, hundreds, tens, ones — write each as a value, then add.");
                },
                rng -> {
                    int n = QBuilder.range(rng, 6, year <= 2 ? 19 : 80);
                    return hint(QBuilder.build(rng, word
                                    ? "A game starts on " + n + ". You count back 1. Where do you land?"
                                    : "What number comes just before " + n + "?",
                            String.valueOf(n - 1), "Count back one.", "EASY", tag(word),
                            String.valueOf(n + 1), String.valueOf(n), String.valueOf(n - 2)),
                            "Before means one less. Do not jump two.");
                },
                rng -> {
                    if (year < 4) {
                        int a = QBuilder.range(rng, 10, 40);
                        int b = QBuilder.range(rng, 10, 40);
                        if (a == b) {
                            b += 3;
                        }
                        String order = Math.min(a, b) + " then " + Math.max(a, b);
                        return hint(QBuilder.build(rng, "Write " + a + " and " + b + " from smaller to larger.",
                                order, "Smaller sits left on the number line.", "MEDIUM", "skill-check",
                                Math.max(a, b) + " then " + Math.min(a, b), String.valueOf(a + b), String.valueOf(Math.abs(a - b))),
                                "Put both on a number line. Left first, then right.");
                    }
                    int n = QBuilder.range(rng, 250, 890);
                    int hundreds = ((n + 50) / 100) * 100;
                    return hint(QBuilder.build(rng, "Round " + n + " to the nearest hundred.",
                            String.valueOf(hundreds), "Tens digit 5 or more rounds the hundreds up.",
                            "MEDIUM", "skill-check", String.valueOf((n / 100) * 100), String.valueOf(n), String.valueOf(hundreds + 100)),
                            "Look at the tens digit only. That digit decides up or down to a hundred.");
                },
                rng -> {
                    if (year < 6) {
                        return hint(QBuilder.build(rng, "10 ones make how many tens?",
                                "1 ten", "Ten ones bundle as one ten.", "EASY", "skill-check",
                                "10 tens", "0 tens", "100 ones"),
                                "A bundle of ten ones is a single ten. That is place value.");
                    }
                    int e = QBuilder.range(rng, 2, 5);
                    int val = (int) Math.pow(10, e);
                    return hint(QBuilder.build(rng, "What is 10^" + e + "?",
                            String.valueOf(val), "10^" + e + " is 1 followed by " + e + " zeros.",
                            "MEDIUM", "skill-check", String.valueOf(10 * e), String.valueOf(val * 10), String.valueOf(e)),
                            "The exponent counts zeros after 1, not ‘10 times the exponent’.");
                },
                rng -> {
                    if (year < 5) {
                        int n = QBuilder.pick(rng, 11, 14, 16, 18, 21, 24, 27);
                        return hint(QBuilder.build(rng, n + " is the same as…",
                                (n / 10) + " tens and " + (n % 10) + " ones",
                                "Split into tens and leftover ones.", "EASY", "skill-check",
                                (n % 10) + " tens and " + (n / 10) + " ones", n + " tens", String.valueOf(n + 10)),
                                "How many full groups of 10, and how many left over?");
                    }
                    int n = QBuilder.pick(rng, 12, 18, 20, 24, 30, 36);
                    return hint(QBuilder.build(rng, "Which is a factor pair of " + n + "?",
                            "3 × " + (n / 3), n + " divides evenly by 3.",
                            "MEDIUM", "skill-check",
                            "5 × " + (n / 5 + 1), "7 × 7", n + " × 0"),
                            "A factor pair multiplies exactly to the number. Check by multiplying back.");
                }
        };
    }

    static QuestionTemplate[] ops(int year, boolean word) {
        int max = year <= 2 ? 20 : year <= 4 ? 100 : 200;
        return new QuestionTemplate[]{
                rng -> {
                    int a = QBuilder.range(rng, 2, max / 2);
                    int b = QBuilder.range(rng, 2, max / 2);
                    String prompt = word
                            ? QBuilder.pick(rng,
                            "You find " + a + " shells at dawn and " + b + " at dusk. How many shells altogether?",
                            "A kete has " + a + " kūmara. You add " + b + " more. What is the new total?")
                            : QBuilder.pick(rng, "What is " + a + " + " + b + "?", "Compute " + a + " plus " + b + ".");
                    return hint(QBuilder.build(rng, prompt, String.valueOf(a + b),
                            "Addition joins parts.", "EASY", tag(word),
                            String.valueOf(Math.abs(a - b)), String.valueOf(a + b + 1), String.valueOf(a)),
                            "Altogether / plus means join. Add, then check by counting on from the larger.");
                },
                rng -> {
                    int b = QBuilder.range(rng, 2, 12);
                    int a = b * QBuilder.range(rng, 2, year <= 2 ? 5 : 9);
                    String prompt = word
                            ? "Share " + a + " muffins onto " + b + " plates equally. How many on each plate?"
                            : "What is " + a + " ÷ " + b + "?";
                    return hint(QBuilder.build(rng, prompt, String.valueOf(a / b),
                            "Division makes equal groups.", "MEDIUM", tag(word),
                            String.valueOf(a / b + 1), String.valueOf(a - b), String.valueOf(b)),
                            "Equal sharing: how many in each group? Check with ×.");
                },
                rng -> {
                    int r = QBuilder.range(rng, 2, year <= 3 ? 6 : 9);
                    int c = QBuilder.range(rng, 2, year <= 3 ? 6 : 9);
                    String prompt = word
                            ? "A crate has " + r + " rows of " + c + " bottles. How many bottles?"
                            : MathFigures.ask("How many dots in this array?",
                            MathFigures.array(r, c, r + " rows of " + c));
                    return hint(QBuilder.build(rng, prompt, String.valueOf(r * c),
                            "Rows × columns.", "MEDIUM", tag(word, "visual pattern"),
                            String.valueOf(r + c), String.valueOf(r * c + r), String.valueOf(Math.abs(r - c))),
                            "An array is equal rows. Multiply rows by how many in a row.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 8, max);
                    int b = QBuilder.range(rng, 2, Math.min(a - 1, 20));
                    String prompt = word
                            ? "A score of " + a + " loses " + b + " points. What remains?"
                            : "What is " + a + " − " + b + "?";
                    return hint(QBuilder.build(rng, prompt, String.valueOf(a - b),
                            "Subtraction takes away or finds a difference.", "EASY", tag(word),
                            String.valueOf(a + b), String.valueOf(b - a), String.valueOf(a)),
                            "Keep the order. Start at the first number and count back the second.");
                },
                rng -> {
                    if (year < 6) {
                        int a = QBuilder.range(rng, 3, 9);
                        int b = QBuilder.range(rng, 2, 8);
                        int c = QBuilder.range(rng, 1, 6);
                        return hint(QBuilder.build(rng, "What is " + a + " + " + b + " − " + c + "?",
                                String.valueOf(a + b - c), "Left to right for + and −.",
                                "MEDIUM", "skill-check",
                                String.valueOf(a + b + c), String.valueOf(a - b + c), String.valueOf(a * b - c)),
                                "+ and − travel left to right unless brackets say otherwise.");
                    }
                    int a = QBuilder.range(rng, 2, 6);
                    int b = QBuilder.range(rng, 2, 5);
                    int c = QBuilder.range(rng, 2, 8);
                    int ans = a + b * c;
                    return hint(QBuilder.build(rng, "Evaluate " + a + " + " + b + " × " + c + ".",
                            String.valueOf(ans), "× before +.", "MEDIUM", "skill-check",
                            String.valueOf((a + b) * c), String.valueOf(a * b + c), String.valueOf(ans + 1)),
                            "GEMA: multiply before you add, unless brackets group the add.");
                },
                rng -> {
                    if (year < 7) {
                        return hint(QBuilder.build(rng, "Which number sentence matches 4 groups of 5?",
                                "4 × 5 = 20", "Equal groups are multiplication.",
                                "EASY", "skill-check", "4 + 5 = 9", "5 − 4 = 1", "20 ÷ 4 = 4"),
                                "‘Groups of’ is ×. Adding 4 and 5 only gives one group plus 5.");
                    }
                    int start = QBuilder.range(rng, -4, 8);
                    int drop = QBuilder.range(rng, 3, 9);
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "Temperature starts at " + start + " °C and drops " + drop + " °C. New reading?",
                                    MathFigures.integerJump(start, -drop, "A drop is a jump left.")),
                            (start - drop) + "°C",
                            "Drop means subtract, including through zero.",
                            "MEDIUM", tag(word),
                            (start + drop) + "°C", (drop - start) + "°C", start + "°C"),
                            "A drop is a left jump on the integer line. Crossing 0 is allowed.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 9);
                    int b = QBuilder.range(rng, 2, 9);
                    return hint(QBuilder.build(rng, "Which check shows " + a + " × " + b + " is correct?",
                            (a * b) + " ÷ " + a + " = " + b,
                            "Division undoes multiplication.", "MEDIUM", "skill-check",
                            a + " + " + b + " = " + (a * b), (a * b) + " − " + a + " = " + b, a + " × " + a + " = " + b),
                            "The inverse of × is ÷. Divide the product by one factor to get the other.");
                },
                rng -> {
                    if (year <= 3) {
                        return hint(QBuilder.build(rng, "6 + 0 equals…",
                                "6", "Adding 0 does not change a number.", "EASY", "skill-check",
                                "0", "60", "7"),
                                "Zero is the identity for addition. The number stays itself.");
                    }
                    int n = QBuilder.range(rng, 20, 80);
                    int d = QBuilder.pick(rng, 4, 5, 6, 8);
                    int q = n / d;
                    int r = n % d;
                    return hint(QBuilder.build(rng, n + " ÷ " + d + " is " + q + " remainder…",
                            String.valueOf(r), d + " × " + q + " = " + (d * q) + ", leftover " + r + ".",
                            "HARD", "skill-check", String.valueOf(q), String.valueOf(d), String.valueOf(r + d)),
                            "How much is left after making as many equal groups as you can?");
                },
                rng -> {
                    int a = QBuilder.range(rng, 3, 12);
                    return hint(QBuilder.build(rng, "Double " + a + " is…",
                            String.valueOf(2 * a), "Double means × 2.", "EASY", "skill-check",
                            String.valueOf(a + 2), String.valueOf(a * a), String.valueOf(a / 2 + 1)),
                            "Double is two of the same number joined — multiply by 2.");
                },
                rng -> {
                    if (year < 4) {
                        return hint(QBuilder.build(rng, "Half of 16 is…",
                                "8", "Half means ÷ 2 when the number is even.", "EASY", tag(word),
                                "4", "6", "16"),
                                "Split into two equal groups. Half of 16 is 8.");
                    }
                    int a = QBuilder.range(rng, 4, 9);
                    int b = QBuilder.range(rng, 3, 8);
                    int c = QBuilder.range(rng, 2, 6);
                    return hint(QBuilder.build(rng, "What is (" + a + " + " + b + ") × " + c + "?",
                            String.valueOf((a + b) * c), "Brackets first.", "MEDIUM", "skill-check",
                            String.valueOf(a + b * c), String.valueOf(a * b * c), String.valueOf(a + b + c)),
                            "Brackets are grouped work. Finish inside, then multiply.");
                }
        };
    }

    static QuestionTemplate[] fraction(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                    "Each piece of this sandwich is a…",
                                    MathFigures.fractionBar(1, 2, "Two matching parts.")),
                            "half", "A half is one of two equal parts.", "EASY", "visual pattern",
                            "quarter of a different whole", "the whole twice", "three pieces"),
                            "Halves only count if the two pieces match. Unequal cuts are not halves."),
                    rng -> hint(QBuilder.build(rng, "8 mussels shared equally onto 2 plates. How many on each?",
                            "4", "Half of 8 is 4.", "EASY", tag(word), "8", "2", "6"),
                            "Equal share between two plates is a half. 8 ÷ 2."),
                    rng -> hint(QBuilder.build(rng, "Two pieces are halves only if they are…",
                            "equal in size", "Fairness is the mathematics.", "MEDIUM", "skill-check",
                            "any two pieces", "one much bigger", "three pieces"),
                            "The word half is about equal parts of the same whole."),
                    rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                    "How much of this bar is shaded?",
                                    MathFigures.fractionBar(1, 4, "Four equal parts, one shaded.")),
                            "one quarter", "One of four matching parts is a quarter.",
                            "MEDIUM", "visual pattern", "one half", "three quarters", "the whole"),
                            "Count equal parts first (denominator), then count shaded (numerator)."),
                    rng -> hint(QBuilder.build(rng, "Two quarters of the same sandwich equal…",
                            "one half", "2/4 = 1/2 of the same whole.", "MEDIUM", "skill-check",
                            "two wholes", "one quarter", "nothing"),
                            "Same whole. Two of four matching pieces make a half."),
                    rng -> hint(QBuilder.build(rng, word
                                    ? "A fruit is cut into 2 matching pieces. You eat one. What fraction did you eat?"
                                    : "1 out of 2 equal parts is written…",
                            "1/2", "Numerator 1, denominator 2.", "EASY", tag(word), "2/1", "1/4", "2/2"),
                            "Top counts the pieces you have. Bottom counts how many equal pieces make the whole.")
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    int d = QBuilder.pick(rng, 2, 3, 4, 5, 8, 10);
                    int n = QBuilder.range(rng, 1, d - 1);
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "What fraction of this bar is shaded?",
                                    MathFigures.fractionBar(n, d, n + " of " + d + " equal parts")),
                            n + "/" + d, "Shaded over equal parts.", "EASY", "visual pattern",
                            n + "/" + (d + 1), d + "/" + n, "1/" + n),
                            "Denominator = how many equal slices. Numerator = how many are shaded.");
                },
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                "Which is larger for the same whole?",
                                MathFigures.fractionCompare(1, 3, 1, 4, "1/3", "1/4", "Same-length bars.")),
                        "1/3", "Thirds are larger pieces than quarters.", "MEDIUM", "visual pattern",
                        "1/4", "they must be equal", "1/12"),
                        "Same-length bars. More slices means each slice is smaller. 1/3 beats 1/4."),
                rng -> {
                    int pct = QBuilder.pick(rng, 10, 25, 50, 75);
                    String dec = pct == 10 ? "0.1" : pct == 25 ? "0.25" : pct == 50 ? "0.5" : "0.75";
                    return hint(QBuilder.build(rng, word
                                    ? "A sale is " + pct + "% off. Which decimal is " + pct + "%?"
                                    : "Which decimal equals " + pct + "%?",
                            dec, "Percent ÷ 100.", "MEDIUM", tag(word),
                            String.valueOf(pct), "0." + pct, "1." + pct),
                            "Percent is per hundred. Slide the point two places (÷ 100).");
                },
                rng -> {
                    int whole = QBuilder.pick(rng, 20, 40, 80, 100);
                    int pct = QBuilder.pick(rng, 10, 25, 50);
                    int ans = whole * pct / 100;
                    return hint(QBuilder.build(rng, word
                                    ? whole + " students. " + pct + "% walk. How many walk?"
                                    : "What is " + pct + "% of " + whole + "?",
                            String.valueOf(ans), "part = percent × whole ÷ 100.", "MEDIUM", tag(word),
                            String.valueOf(whole - ans), String.valueOf(pct), String.valueOf(ans + 5)),
                            "Find 10% by ÷ 10, then scale, or multiply by the decimal.");
                },
                rng -> {
                    int d = QBuilder.pick(rng, 4, 5, 8, 10);
                    return hint(QBuilder.build(rng, "Which fraction equals 1?",
                            d + "/" + d, "When numerator equals denominator you have one whole.",
                            "EASY", "skill-check", "1/" + d, d + "/1 is always 1 only if d=1", "0/" + d),
                            "A full bar is d/d. That is 1, not 0 and not d.");
                },
                rng -> {
                    if (year < 5) {
                        return hint(QBuilder.build(rng, "3/8 + 2/8 =",
                                "5/8", "Same denominator: add numerators.", "MEDIUM", "skill-check",
                                "5/16", "6/8", "1/8"),
                                "The piece size (8) stays. Only the count of pieces changes.");
                    }
                    int price = QBuilder.pick(rng, 40, 60, 80, 100);
                    int pct = QBuilder.pick(rng, 10, 20, 25);
                    int sale = price - price * pct / 100;
                    return hint(QBuilder.build(rng, word
                                    ? "A $" + price + " hoodie is " + pct + "% off. What do you pay?"
                                    : "$" + price + " with " + pct + "% discount. Sale price?",
                            "$" + sale, "Subtract the discount from the original.", "MEDIUM", tag(word),
                            "$" + (price * pct / 100), "$" + price, "$" + (sale + 5)),
                            "Sale price is original minus the discount — not the discount alone.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 12, 48);
                    int b = QBuilder.range(rng, 12, 48);
                    String left = "0." + a;
                    String right = "0." + b;
                    String larger = a >= b ? left : right;
                    return hint(QBuilder.build(rng, "Which decimal is larger, " + left + " or " + right + "?",
                            larger, "Compare tenths, then hundredths.", "EASY", "skill-check",
                            a >= b ? right : left, "they are words not numbers", "1" + left),
                            "Line up the decimal points. Compare the first place that differs.");
                },
                rng -> {
                    if (year < 7) {
                        return hint(QBuilder.build(rng, "2/4 in simplest form is…",
                                "1/2", "Divide top and bottom by 2.", "MEDIUM", "skill-check",
                                "2/4 already simplest", "4/2", "2/2"),
                                "Divide numerator and denominator by the same number until you cannot.");
                    }
                    return hint(QBuilder.build(rng, "Share 40 in the ratio 3:5. The larger share is…",
                            "25", "8 parts; one part is 5; 5 × 5 = 25.", "HARD", tag(word),
                            "15", "24", "30"),
                            "Add the ratio parts first. That total is the whole. Then find one part.");
                },
                rng -> hint(QBuilder.build(rng, "0.5 is the same as…",
                        "1/2", "0.5 = 5/10 = 1/2.", "EASY", "skill-check",
                        "1/5", "5/2", "0.05"),
                        "Read 0.5 as five tenths, then simplify."),
                rng -> {
                    int whole = QBuilder.pick(rng, 12, 16, 20, 24);
                    return hint(QBuilder.build(rng, "What is 1/4 of " + whole + "?",
                            String.valueOf(whole / 4), "Divide by 4.", "EASY", tag(word),
                            String.valueOf(whole / 2), String.valueOf(whole), String.valueOf(4)),
                            "A unit fraction of an amount is divide by the denominator.");
                }
        };
    }

    static QuestionTemplate[] algebra(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> hint(QBuilder.build(rng, "The repeating pattern red, blue, red, blue, red… next is…",
                            "blue", "The unit is red-blue.", "EASY", "visual pattern",
                            "red twice", "green", "stop"),
                            "Circle the chunk that repeats. The next slot follows that chunk."),
                    rng -> hint(QBuilder.build(rng, "7 = 3 + 4 is true because equals means…",
                            "both sides name the same amount", "Equals is balance.",
                            "MEDIUM", "skill-check",
                            "always put a bigger number on the right", "the left is only a question", "4 is ignored"),
                            "Read = as ‘is the same as’, not as a button that dumps an answer."),
                    rng -> hint(QBuilder.build(rng, "What missing number makes 5 + □ = 9 true?",
                            "4", "5 + 4 = 9.", "EASY", "skill-check", "5", "9", "14"),
                            "Ask: what sits with 5 to make 9? That is the unknown."),
                    rng -> hint(QBuilder.build(rng, "clap, stamp, clap, stamp… the unit of repeat is…",
                            "clap-stamp", "Two-element unit.", "EASY", "skill-check",
                            "only clap", "stamp-stamp", "a random noise"),
                            "Name the smallest chunk you can loop. That is the unit of repeat."),
                    rng -> hint(QBuilder.build(rng, "2 + 5 = 3 + □. The box is…",
                            "4", "Both sides must be 7.", "MEDIUM", "skill-check", "5", "2", "10"),
                            "Work out the side you know. The other side must match that total."),
                    rng -> hint(QBuilder.build(rng, "Is 6 = 6 a true sentence?",
                            "yes — both sides name 6", "A number equals itself.", "EASY", "skill-check",
                            "no — equals needs a plus", "only if we write 3+3", "never"),
                            "Equals does not require an operation. Same amount on both sides is enough.")
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    int start = QBuilder.range(rng, 2, 12);
                    int step = QBuilder.pick(rng, 2, 3, 4, 5);
                    int next = start + 4 * step;
                    return hint(QBuilder.build(rng, "Sequence " + start + ", " + (start + step) + ", "
                                    + (start + 2 * step) + ", " + (start + 3 * step) + " … next term?",
                            String.valueOf(next), "Add the constant difference.", "EASY", "skill-check",
                            String.valueOf(next + step), String.valueOf(start), String.valueOf(step)),
                            "Find what is added each time. Add that once more for the next term.");
                },
                rng -> {
                    int x = QBuilder.range(rng, 3, 18);
                    int add = QBuilder.range(rng, 4, 20);
                    return hint(QBuilder.build(rng, "Solve x + " + add + " = " + (x + add) + ".",
                            String.valueOf(x), "Subtract " + add + " from both sides.",
                            "EASY", "skill-check", String.valueOf(x + add), String.valueOf(add), String.valueOf(x + 1)),
                            "Undo + by subtracting the same number from both sides.");
                },
                rng -> {
                    int x = QBuilder.range(rng, 2, 12);
                    int m = QBuilder.pick(rng, 2, 3, 4, 5);
                    return hint(QBuilder.build(rng, "Solve " + m + "n = " + (m * x) + ".",
                            String.valueOf(x), "Divide both sides by " + m + ".",
                            "MEDIUM", "skill-check", String.valueOf(m * x), String.valueOf(m), String.valueOf(x + 2)),
                            "Undo × by dividing both sides by the coefficient.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 7);
                    int b = QBuilder.range(rng, 1, 6);
                    int c = QBuilder.range(rng, 1, 5);
                    return hint(QBuilder.build(rng, "Simplify " + a + "x + " + b + "x + " + c + ".",
                            (a + b) + "x + " + c, "Collect like x terms.", "MEDIUM", "skill-check",
                            a + "x + " + (b + c), (a + b + c) + "x", a + " + " + b + "x + " + c),
                            "Only the x terms join. The lone number stays a constant.");
                },
                rng -> {
                    if (year < 5) {
                        return hint(QBuilder.build(rng, "11 × 7 = 78 is…",
                                "false", "11 × 7 = 77.", "EASY", "skill-check",
                                "true", "sometimes", "not a sentence"),
                                "Compute each side. Equals is only true when the totals match.");
                    }
                    int x = QBuilder.range(rng, 1, 6);
                    int y = 2 * x + 1;
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "The rule is y = 2x + 1. Which point fits x = " + x + "?",
                                    MathFigures.coordinatePoint(x, y, "Along first, then up.")),
                            "(" + x + ", " + y + ")", "Substitute x, then plot (x, y).",
                            "MEDIUM", "visual pattern",
                            "(" + y + ", " + x + ")", "(" + x + ", " + x + ")", "(0, " + y + ")"),
                            "Work y from the rule, then plot (x, y) — not (y, x).");
                },
                rng -> {
                    int tickets = QBuilder.range(rng, 3, 9);
                    int price = QBuilder.pick(rng, 8, 10, 12);
                    int fee = QBuilder.pick(rng, 2, 4, 5);
                    int total = tickets * price + fee;
                    return hint(QBuilder.build(rng, word
                                    ? tickets + " tickets at $" + price + " plus a $" + fee + " fee. Total?"
                                    : "Evaluate " + tickets + " × " + price + " + " + fee + ".",
                            "$" + total, "Multiply then add.", "MEDIUM", tag(word),
                            "$" + (tickets * price), "$" + (tickets + price + fee), "$" + fee),
                            "This is a two-step rule: groups first (×), then the extra fee (+).");
                },
                rng -> hint(QBuilder.build(rng, "3b means…",
                        "3 × b", "Juxtaposition is multiply.", "EASY", "skill-check",
                        "3 + b", "30 + b", "b − 3"),
                        "A number stuck to a letter means multiply, not add."),
                rng -> {
                    int start = QBuilder.range(rng, 4, 15);
                    int step = QBuilder.pick(rng, 2, 3, 4);
                    int fifth = start + 4 * step;
                    return hint(QBuilder.build(rng, "A pattern starts at " + start + " and adds " + step
                                    + " each time. 5th term?",
                            String.valueOf(fifth), "Term 1 is the start; four steps to term 5.",
                            "HARD", tag(word),
                            String.valueOf(start + 5 * step), String.valueOf(start + step), String.valueOf(step * 5)),
                            "Term 5 is the start plus 4 jumps, not 5 jumps.");
                },
                rng -> hint(QBuilder.build(rng, "If 4 + □ = 4, the box is…",
                        "0", "Adding 0 leaves a number unchanged.", "EASY", "skill-check",
                        "4", "1", "8"),
                        "What can you add and stay at 4? That identity is 0."),
                rng -> {
                    if (year < 8) {
                        return hint(QBuilder.build(rng, "The pair (2, 5) means…",
                                "2 along, 5 up", "x first, then y.", "MEDIUM", "skill-check",
                                "5 along, 2 up", "a length of 25", "two separate numbers with no order"),
                                "The first number is x (along). The second is y (up).");
                    }
                    return hint(QBuilder.build(rng, "On y = 2x + 1, when x = 4, y is…",
                            "9", "2×4+1=9.", "EASY", "skill-check", "8", "7", "5"),
                            "Substitute x = 4 into the rule. Multiply first, then add.");
                }
        };
    }

    static QuestionTemplate[] measure(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> {
                    int l = QBuilder.range(rng, 3, 12);
                    int w = QBuilder.range(rng, 2, 9);
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    word ? "A garden is " + l + " m by " + w + " m. What is its area?"
                                            : "What is the area of this rectangle?",
                                    MathFigures.rectangle(l, w, l + " by " + w)),
                            String.valueOf(l * w), "A = l × w.", "EASY", tag(word, "visual pattern"),
                            String.valueOf(2 * (l + w)), String.valueOf(l + w), String.valueOf(l * w + l)),
                            "Area is the inside. Multiply the two side lengths. Not the fence.");
                },
                rng -> {
                    int l = QBuilder.range(rng, 4, 14);
                    int w = QBuilder.range(rng, 3, 10);
                    return hint(QBuilder.build(rng, word
                                    ? "Ribbon around a " + l + " cm by " + w + " cm card. How long is the ribbon?"
                                    : "Perimeter of a " + l + " by " + w + " rectangle?",
                            String.valueOf(2 * (l + w)), "P = 2(l + w).", "MEDIUM", tag(word),
                            String.valueOf(l * w), String.valueOf(l + w), String.valueOf(2 * l + w)),
                            "Perimeter walks the fence. Add all four sides, or 2(l + w).");
                },
                rng -> {
                    int m = QBuilder.range(rng, 2, 9);
                    return hint(QBuilder.build(rng, "How many centimetres in " + m + " metres?",
                            String.valueOf(m * 100), "1 m = 100 cm.", "EASY", "skill-check",
                            String.valueOf(m * 10), String.valueOf(m * 1000), String.valueOf(m + 100)),
                            "Centi- is 1/100 of a metre, so 1 m holds 100 cm.");
                },
                rng -> {
                    if (year < 5) {
                        return hint(QBuilder.build(rng, "A right angle measures…",
                                "90°", "A quarter turn.", "EASY", "skill-check",
                                "45°", "180°", "360°"),
                                "A square corner is 90°. That is a quarter of a full turn.");
                    }
                    int b = 2 * QBuilder.range(rng, 3, 8);
                    int h = QBuilder.range(rng, 4, 12);
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "Area of this right triangle?",
                                    MathFigures.rightTriangle(b, h, null, "Half of the surrounding rectangle.")),
                            String.valueOf(b * h / 2), "A = ½bh.", "MEDIUM", "visual pattern",
                            String.valueOf(b * h), String.valueOf(b + h), String.valueOf(2 * (b + h))),
                            "Right triangle area is half the rectangle with the same base and height.");
                },
                rng -> {
                    int h = QBuilder.range(rng, 1, 4);
                    int min = QBuilder.pick(rng, 15, 20, 30, 45);
                    return hint(QBuilder.build(rng, h + " hour(s) and " + min + " minutes is how many minutes?",
                            String.valueOf(h * 60 + min), "1 hour = 60 minutes.", "MEDIUM", "skill-check",
                            String.valueOf(h * 100 + min), String.valueOf(h + min), String.valueOf(h * 60)),
                            "Hours to minutes: × 60, then add the leftover minutes.");
                },
                rng -> {
                    int side = QBuilder.range(rng, 3, 10);
                    return hint(QBuilder.build(rng, word
                                    ? "A square courtyard has side " + side + " m. Perimeter?"
                                    : "Perimeter of a square of side " + side + "?",
                            String.valueOf(4 * side), "Four equal sides.", "EASY", tag(word),
                            String.valueOf(side * side), String.valueOf(2 * side), String.valueOf(side + 4)),
                            "A square has 4 matching sides. Perimeter is 4 × side, not side².");
                },
                rng -> {
                    if (year < 6) {
                        return hint(QBuilder.build(rng, "Which unit is best for the length of a classroom?",
                                "metres", "Rooms are metres; rubbers are centimetres.", "EASY", "skill-check",
                                "millimetres only", "kilometres", "litres"),
                                "Pick a unit that gives a sensible-sized number. Classrooms are metres.");
                    }
                    int l = QBuilder.range(rng, 2, 6);
                    int w = QBuilder.range(rng, 2, 5);
                    int h = QBuilder.range(rng, 2, 5);
                    return hint(QBuilder.build(rng, "Volume of a " + l + " by " + w + " by " + h + " cm cuboid?",
                            (l * w * h) + " cm³", "V = lwh.", "MEDIUM", "skill-check",
                            (l * w) + " cm³", (l + w + h) + " cm³", (2 * (l * w + w * h + h * l)) + " cm³"),
                            "Volume fills the box. Multiply three lengths. The unit is cubic.");
                },
                rng -> {
                    if (year < 7) {
                        return hint(QBuilder.build(rng, "1 L = how many mL?",
                                "1000", "milli- is 1/1000.", "EASY", "skill-check",
                                "100", "10", "10000"),
                                "A litre is 1000 millilitres. Milli- means thousandth.");
                    }
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "A circle has diameter 10 cm. Circumference is about…",
                                    MathFigures.circle(10, "C = πd. Use π ≈ 3.14.")),
                            "31.4 cm", "π × 10 ≈ 31.4.", "HARD", "visual pattern",
                            "10 cm", "5 cm", "100 cm"),
                            "Use diameter in πd. Do not square 10 unless you want area.");
                },
                rng -> hint(QBuilder.build(rng, "Which is an area unit?",
                        "cm²", "Area needs square units.", "EASY", "skill-check",
                        "cm", "kg", "minutes"),
                        "A region is measured in squares. Look for the small 2: cm²."),
                rng -> {
                    int startH = QBuilder.range(rng, 9, 14);
                    int startM = QBuilder.pick(rng, 0, 15, 30);
                    int dur = QBuilder.pick(rng, 40, 50, 70);
                    int end = startH * 60 + startM + dur;
                    String ans = (end / 60) + ":" + String.format("%02d", end % 60);
                    return hint(QBuilder.build(rng, "A bus leaves at " + startH + ":"
                                    + String.format("%02d", startM) + " and travels " + dur + " min. Arrival?",
                            ans, "Add duration to start time.", "HARD", tag(word),
                            startH + ":" + String.format("%02d", (startM + dur) % 60),
                            ans + "0", (startH + 1) + ":00"),
                            "Turn the start into minutes past midnight (or past noon), add, convert back.");
                }
        };
    }

    static QuestionTemplate[] geometry(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> {
                    if (year <= 2) {
                        return hint(QBuilder.build(rng, MathFigures.ask(
                                        "How many sides does this shape have?",
                                        MathFigures.triangleAngles(60, 60, "60°", "Count the edges.")),
                                "3", "A triangle has 3 sides.", "EASY", "visual pattern",
                                "4", "2", "8"),
                                "Trace each edge once. A triangle has three.");
                    }
                    if (year <= 4) {
                        return hint(QBuilder.build(rng, "A square rotated on its corner is still a…",
                                "square", "Properties survive a turn.", "MEDIUM", "skill-check",
                                "circle", "triangle", "not a shape"),
                                "Names come from sides and angles, not from how the page is tilted.");
                    }
                    return hint(QBuilder.build(rng, "Parallel lines…",
                            "stay the same distance apart and never meet",
                            "Constant distance, no crossing.", "EASY", "skill-check",
                            "always cross at 90°", "must be curved", "meet at one point only"),
                            "Parallel means they would never meet, even if you draw them longer.");
                },
                rng -> {
                    if (year <= 3) {
                        return hint(QBuilder.build(rng, "A quarter turn is the same as a…",
                                "right angle / 90° turn", "Quarter of 360° is 90°.", "EASY", "skill-check",
                                "full circle", "half turn", "no turn"),
                                "A full turn is 360°. A quarter of that is a square corner.");
                    }
                    if (year <= 6) {
                        return hint(QBuilder.build(rng, "A cube has how many faces?",
                                "6", "Six square faces.", "EASY", "skill-check", "4", "8", "12"),
                                "A die is a cube. Count the flat squares: six.");
                    }
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "The angles in this triangle add to…",
                                    MathFigures.triangleAngles(70, 50, "?", "Use the fact, not the drawing.")),
                            "180°", "Always 180°.", "EASY", "visual pattern",
                            "90°", "360°", "100°"),
                            "Every triangle — skinny or wide — sums to 180°. Subtract to find a missing angle.");
                },
                rng -> {
                    if (year <= 5) {
                        return hint(QBuilder.build(rng, word
                                        ? "You slide a shape without turning it. That move is a…"
                                        : "A slide without turning is a…",
                                "translation", "Slide = translation.", "MEDIUM", tag(word),
                                "reflection", "enlargement only", "subtraction"),
                                "Translation is a slide. Reflection flips. Rotation turns.");
                    }
                    if (year <= 8) {
                        int a = QBuilder.range(rng, 40, 140);
                        return hint(QBuilder.build(rng, MathFigures.ask(
                                        "The marked angle is " + a + "°. What is the adjacent angle on the line?",
                                        MathFigures.anglesOnLine(a, "Straight line = 180°.")),
                                String.valueOf(180 - a), "Supplementary on a line.", "MEDIUM", "visual pattern",
                                String.valueOf(90 - a), String.valueOf(360 - a), String.valueOf(a)),
                                "A straight line is 180°. Subtract the angle you can see.");
                    }
                    return hint(QBuilder.build(rng, "Similar figures have…",
                            "equal corresponding angles and proportional sides",
                            "Same shape, possibly different size.", "MEDIUM", "skill-check",
                            "always the same size as well", "no equal angles", "only matching colours"),
                            "Similar is same shape. Lengths scale; matching angles stay equal.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 30, 80);
                    int b = QBuilder.range(rng, 30, 80);
                    int c = 180 - a - b;
                    if (c <= 0) {
                        c = 40;
                        b = 180 - a - c;
                    }
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "Find the missing angle.",
                                    MathFigures.triangleAngles(a, b, "?", "Triangle sum 180°.")),
                            c + "°", "180 − " + a + " − " + b + " = " + c + "°.",
                            "MEDIUM", "visual pattern",
                            (a + b) + "°", (180 - a) + "°", "90°"),
                            "Add the two labelled angles. Subtract that total from 180°.");
                },
                rng -> hint(QBuilder.build(rng, "An equilateral triangle has each angle…",
                        "60°", "180 ÷ 3 = 60.", "EASY", "skill-check",
                        "90°", "45°", "120°"),
                        "Three equal angles share 180°. Each is 60°."),
                rng -> hint(QBuilder.build(rng, "A rectangle that is not a square has how many lines of symmetry?",
                        "2", "Midlines parallel to the sides, not the diagonals.",
                        "MEDIUM", "skill-check", "4", "1", "0"),
                        "Fold tests: two midlines work. Diagonals only work if it is a square."),
                rng -> hint(QBuilder.build(rng, "How many vertices does a cube have?",
                        "8", "Eight corners.", "EASY", "skill-check", "6", "12", "4"),
                        "Vertices are corners. A cube has a corner for each of 8 points."),
                rng -> {
                    int order = QBuilder.pick(rng, 2, 3, 4, 6);
                    return hint(QBuilder.build(rng, "Rotational symmetry order " + order
                                    + ". Turn that matches the shape?",
                            (360 / order) + "°", "360 ÷ order.", "HARD", tag(word),
                            "180°", (order * 10) + "°", "90°"),
                            "A full turn is 360°. Divide by how many times it matches itself.");
                },
                rng -> hint(QBuilder.build(rng, "Perpendicular lines meet at…",
                        "90°", "A right angle.", "EASY", "skill-check",
                        "45° only", "180°", "0°"),
                        "Perpendicular is the square-corner meeting. Mark 90°."),
                rng -> hint(QBuilder.build(rng, word
                                ? "A clock hand moves from 12 to 3. What angle is that?"
                                : "A quarter of a clock face is…",
                        "90°", "Three hour marks × 30° = 90°.", "MEDIUM", tag(word),
                        "30°", "180°", "12°"),
                        "The clock is 360°. 12 to 3 is a quarter of the way around.")
        };
    }

    static QuestionTemplate[] data(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                word ? "Which fruit was most popular?"
                                        : "Which category has the most votes?",
                                MathFigures.barChart("Favourite fruit",
                                        new String[]{"Apple", "Banana", "Orange"}, new int[]{6, 4, 2})),
                        "Apple", "Tallest bar is most common.", "EASY", "visual pattern",
                        "Banana", "Orange", "they are equal"),
                        "Read the tallest bar. That category is the mode of the display."),
                rng -> {
                    int a = QBuilder.range(rng, 4, 12);
                    int b = QBuilder.range(rng, 4, 12);
                    int c = QBuilder.range(rng, 4, 12);
                    int mean = (a + b + c) / 3;
                    return hint(QBuilder.build(rng, "Mean of " + a + ", " + b + " and " + c + "?",
                            String.valueOf(mean), "Total ÷ 3.", "MEDIUM", tag(word),
                            String.valueOf(a + b + c), String.valueOf(Math.max(a, c)), String.valueOf(mean + 1)),
                            "Add every value. Divide by how many numbers you added.");
                },
                rng -> {
                    int low = QBuilder.range(rng, 5, 20);
                    int high = QBuilder.range(rng, 25, 60);
                    return hint(QBuilder.build(rng, "Range if min = " + low + " and max = " + high + "?",
                            String.valueOf(high - low), "Max − min.", "EASY", "skill-check",
                            String.valueOf(high + low), String.valueOf(high), String.valueOf(high - low + 1)),
                            "Range uses only the ends. Subtract smallest from largest.");
                },
                rng -> hint(QBuilder.build(rng, "For ordered data 4, 8, 12 the median is…",
                        "8", "The middle value.", "EASY", "skill-check",
                        "4", "8 is the mean too, but the question asked median", "12"),
                        "Order the list. The centre item is the median."),
                rng -> hint(QBuilder.build(rng, "Mode of 2, 5, 5, 7 is…",
                        "5", "5 appears most.", "EASY", "skill-check",
                        "2", "7", "4.75"),
                        "Mode is the value that shows up most often — not the mean."),
                rng -> hint(QBuilder.build(rng, "A bar graph should have…",
                        "a title and labelled axes", "Without labels the bars are meaningless.",
                        "EASY", "skill-check", "no title ever", "only colours", "secret axes"),
                        "Title, axis names and a 0-based scale make a graph honest."),
                rng -> {
                    if (year < 6) {
                        return hint(QBuilder.build(rng, "A tally |||| ||| means how many?",
                                "8", "Five-bar gate plus three.", "EASY", "visual pattern",
                                "4", "3", "5"),
                                "A gate of four with a slash is 5. Then add the extra strokes.");
                    }
                    return hint(QBuilder.build(rng, "A sample of one class cannot prove a claim about…",
                            "every student in Aotearoa", "Say the population you actually measured.",
                            "MEDIUM", "skill-check",
                            "that class's own favourite fruit", "their graph title", "how they tallied"),
                            "Conclusions must match the group you asked — not the whole country.");
                },
                rng -> hint(QBuilder.build(rng, word
                                ? "Scores 3, 5, 5, 7. What is the mode?"
                                : "Data 3, 5, 5, 7. The mode is…",
                        "5", "Most common.", "MEDIUM", tag(word),
                        "3", "7", "5 is also the median — still the mode here"),
                        "Which number appears more than the others? That is the mode."),
                rng -> hint(QBuilder.build(rng, "If a pictograph key says 1 picture = 2 children, 4 pictures mean…",
                        "8 children", "4 × 2 = 8.", "MEDIUM", "skill-check",
                        "4 children", "2 children", "6 children"),
                        "Always read the key. One symbol may stand for more than one person."),
                rng -> {
                    if (year < 9) {
                        return hint(QBuilder.build(rng, "A graph that starts at 48 instead of 0 can…",
                                "make small differences look huge", "Misleading scale.",
                                "MEDIUM", "skill-check",
                                "never be wrong", "only help scientists", "change the raw data automatically"),
                                "Check the axis start. A chopped scale exaggerates change.");
                    }
                    return hint(QBuilder.build(rng, "Points rising together on a scatter graph suggest…",
                            "a positive association", "Not automatically a cause.",
                            "MEDIUM", "skill-check",
                            "that one variable caused the other for sure", "no relationship", "the median of a pie"),
                            "Together-up is a positive association. Causation needs more than the cloud.");
                }
        };
    }

    static QuestionTemplate[] chance(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> hint(QBuilder.build(rng, "The sun will rise tomorrow. In chance language this is…",
                            "certain / will happen", "Some events must happen.", "EASY", "skill-check",
                            "impossible", "never", "a guess with no meaning"),
                            "Certain means it must happen. Tomorrow’s sunrise is in that box."),
                    rng -> hint(QBuilder.build(rng, "A cow flying by itself over the field is…",
                            "won't / impossible in ordinary life", "Impossible means cannot.",
                            "EASY", "skill-check", "certain", "even chance", "the same as likely"),
                            "Impossible is ‘cannot’, not ‘I have never seen it’."),
                    rng -> hint(QBuilder.build(rng, "A fair two-colour counter might land red or yellow. Purple is…",
                            "not a possible outcome", "List what the object can actually do.",
                            "MEDIUM", "skill-check", "certain", "the most likely", "the only outcome"),
                            "Outcomes must belong to the object. Purple is not on that counter."),
                    rng -> hint(QBuilder.build(rng, "A fair coin: heads or tails is…",
                            "even chance", "Two fair options.", "EASY", "skill-check",
                            "certain heads", "impossible", "always tails"),
                            "Two matching chances sit in the middle of the language scale."),
                    rng -> hint(QBuilder.build(rng, "Likely sits between…",
                            "even chance and certain", "The five-word scale.", "MEDIUM", "skill-check",
                            "impossible and even", "certain and more-than-certain", "nowhere"),
                            "Place the word on the scale: impossible → unlikely → even → likely → certain."),
                    rng -> hint(QBuilder.build(rng, word
                                    ? "You might see a tūī at interval. That word might means…"
                                    : "Might means the event…",
                            "could happen, but it is not sure", "Honest uncertainty.",
                            "EASY", tag(word), "must happen", "cannot happen", "already happened"),
                            "Might is the honest middle. Not a promise and not a ban.")
            };
        }
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, "A fair six-sided die. P(rolling a 4)?",
                        "1/6", "One face of six.", "EASY", "skill-check",
                        "1/4", "4/6", "1/2"),
                        "Favourable faces ÷ all faces. One 4 among six numbers."),
                rng -> {
                    int fav = QBuilder.range(rng, 1, 3);
                    int tot = QBuilder.range(rng, 6, 8);
                    String[] labels = new String[tot];
                    for (int i = 0; i < tot; i++) {
                        labels[i] = i < fav ? "R" : "B";
                    }
                    return hint(QBuilder.build(rng, MathFigures.ask(
                                    "P(red) on this fair spinner?",
                                    MathFigures.spinner(labels, 0, fav + " red of " + tot)),
                            fav + "/" + tot, "Favourable / total.", "MEDIUM", "visual pattern",
                            tot + "/" + fav, fav + "/" + (tot + 1), "1/" + fav),
                            "Count red sectors, then divide by how many equal sectors there are.");
                },
                rng -> hint(QBuilder.build(rng, year < 6
                                ? "On a 0 to 1 chance line, even chance sits at…"
                                : "P(not a 6) on a fair die is…",
                        year < 6 ? "1/2" : "5/6",
                        year < 6 ? "The middle of 0 to 1." : "Complement 1 − 1/6.",
                        year < 6 ? "EASY" : "MEDIUM", "skill-check",
                        year < 6 ? "0" : "1/6", year < 6 ? "1" : "6/5", year < 6 ? "2" : "1"),
                        year < 6 ? "Even chance is halfway from impossible (0) to certain (1)."
                                : "‘Not 6’ is the other five faces. 1 − 1/6."),
                rng -> hint(QBuilder.build(rng, "All disjoint outcomes of a spinner should sum to…",
                        "1", "A complete set is certain.", "MEDIUM", "skill-check",
                        "0", "100 only if you ignore fractions", "6"),
                        "If you listed everything that can happen, the probabilities add to 1."),
                rng -> {
                    int heads = QBuilder.range(rng, 8, 18);
                    int tosses = QBuilder.range(rng, heads + 4, 30);
                    return hint(QBuilder.build(rng, word
                                    ? "A coin shows heads " + heads + " times in " + tosses + " tosses. Experimental P(heads)?"
                                    : heads + " heads in " + tosses + " tosses. Relative frequency?",
                            heads + "/" + tosses, "Observed ÷ trials.", "MEDIUM", tag(word),
                            (tosses - heads) + "/" + tosses, "1/2", heads + "/" + (tosses - 1)),
                            "Experimental probability uses what happened, not what ‘should’ happen.");
                },
                rng -> hint(QBuilder.build(rng, "P(event) = 2/5. P(not event)?",
                        "3/5", "Complement.", "MEDIUM", "skill-check",
                        "2/5", "1/5", "5/2"),
                        "If those two cover the whole situation, not-event is 1 minus the given fraction."),
                rng -> hint(QBuilder.build(rng, "Two fair coins. P(both heads) is…",
                        "1/4", "HH is one of HH HT TH TT.", "MEDIUM", "skill-check",
                        "1/2", "1/3", "2/3"),
                        "List the four pairs first. Only one pair is two heads."),
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                "P(exactly one head) for two fair coins?",
                                MathFigures.coinTree("HT and TH are the one-head paths.")),
                        "1/2", "1/4 + 1/4.", "HARD", "visual pattern",
                        "1/4", "3/4", "1"),
                        "Add the paths that count: HT and TH. Multiply along a path, add across paths."),
                rng -> hint(QBuilder.build(rng, "A bag has 3 red and 5 blue, equally likely. P(blue)?",
                        "5/8", "5 of 8 marbles.", "EASY", tag(word),
                        "3/8", "5/3", "1/5"),
                        "Blue marbles over all marbles. Do not reduce until you have written 5/8."),
                rng -> hint(QBuilder.build(rng, "After five heads on a fair coin, P(next is heads) is…",
                        "still 1/2", "The coin has no memory.", "HARD", "skill-check",
                        "almost 0 because heads are used up", "1", "1/32"),
                        "Independent trials do not get ‘due’ a tail. The chance resets every toss.")
        };
    }

    private static String tag(boolean word) {
        return word ? "word problem" : "skill-check";
    }

    private static String tag(boolean word, String other) {
        return word ? "word problem" : other;
    }

    private static GeneratedQuestion hint(GeneratedQuestion q, String hint) {
        return q.withHint(hint);
    }
}
