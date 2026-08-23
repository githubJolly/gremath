package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/** Extra illustrated, uniquely worded items for the Year 6 and Year 7 handcrafted banks. */
final class Year67IllustratedBank {

    private Year67IllustratedBank() {
    }

    static QuestionTemplate[] c6Place() {
        return new QuestionTemplate[]{
                rng -> {
                    int th = QBuilder.range(rng, 1, 9);
                    int h = QBuilder.range(rng, 0, 9);
                    int t = QBuilder.range(rng, 0, 9);
                    int o = QBuilder.range(rng, 0, 9);
                    int n = th * 1000 + h * 100 + t * 10 + o;
                    return q(rng, MathFigures.ask("Which number does this chart show?",
                                    MathFigures.placeValueChart(th, h, t, o, "Read each house as a value.")),
                            String.valueOf(n), "Digit × place, then add.", "MEDIUM", "visual pattern",
                            String.valueOf(th + h + t + o), String.valueOf(n + 10), th + "" + h + t + o + "0",
                            "Read thousands, hundreds, tens, ones — do not add the digits as if they were ones.");
                },
                rng -> {
                    int n = QBuilder.range(rng, 2100, 8900);
                    return q(rng, "The value of the thousands digit in " + n + " is…",
                            String.valueOf((n / 1000) * 1000), "Value, not the lone digit.",
                            "MEDIUM", "skill-check", String.valueOf(n / 1000), String.valueOf((n / 100) % 10), String.valueOf(n),
                            "The thousands digit’s value is that digit × 1000.");
                },
                rng -> {
                    int n = QBuilder.range(rng, -8, 12);
                    return q(rng, MathFigures.ask("Which integer is marked?",
                                    MathFigures.numberLine(-10, 15, n, "The orange mark is the integer.")),
                            String.valueOf(n), "Read the tick under the mark.", "EASY", "visual pattern",
                            String.valueOf(n + 1), String.valueOf(n - 1), String.valueOf(Math.abs(n)),
                            "Negatives sit left of 0. Match the mark to the label, not to a nearby pretty tick.");
                },
                rng -> q(rng, "Which is the best estimate of 48,612 + 21,389 to the nearest ten thousand?",
                        "70,000", "50,000 + 20,000.", "HARD", "skill-check",
                        "69,000", "80,000", "48,000",
                        "Round each number to the named place first, then add the rounded values.")
        };
    }

    static QuestionTemplate[] c6Ops() {
        return new QuestionTemplate[]{
                rng -> {
                    int r = QBuilder.range(rng, 3, 6);
                    int c = QBuilder.range(rng, 4, 8);
                    return q(rng, MathFigures.ask("How many items in this array?",
                                    MathFigures.array(r, c, r + " by " + c)),
                            String.valueOf(r * c), "Rows × columns.", "EASY", "visual pattern",
                            String.valueOf(r + c), String.valueOf(r * c + r), String.valueOf(2 * r * c),
                            "Count one row, then multiply by how many rows. Do not add rows and columns.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 8);
                    int b = QBuilder.range(rng, 3, 9);
                    int c = QBuilder.range(rng, 4, 12);
                    return q(rng, "Without a calculator: (" + a + " + " + b + ") × " + c + " =",
                            String.valueOf((a + b) * c), "Brackets first.", "MEDIUM", "skill-check",
                            String.valueOf(a + b * c), String.valueOf(a * b * c), String.valueOf(a + b + c),
                            "Finish the bracket, then multiply. GEMA does not add after skipping the bracket.");
                },
                rng -> q(rng, "47 ÷ 5. What is the remainder?",
                        "2", "5 × 9 = 45, leftover 2.", "EASY", "skill-check",
                        "3", "5", "9",
                        "Multiply up to the nearest multiple that does not pass 47. The leftover is the remainder.")
        };
    }

    static QuestionTemplate[] c6Fdp() {
        return new QuestionTemplate[]{
                rng -> {
                    int n = QBuilder.pick(rng, 1, 2, 3);
                    int d = QBuilder.pick(rng, 5, 8, 10);
                    if (n >= d) {
                        n = 1;
                    }
                    return q(rng, MathFigures.ask("What fraction is shaded?",
                                    MathFigures.fractionBar(n, d, n + "/" + d)),
                            n + "/" + d, "Shaded over equal parts.", "EASY", "visual pattern",
                            n + "/" + (d + 1), d + "/" + n, "1/" + n,
                            "Count slices first, then count the orange ones.");
                },
                rng -> q(rng, MathFigures.ask("Same whole: which is larger?",
                                MathFigures.fractionCompare(1, 2, 1, 5, "1/2", "1/5", "Same-length bars.")),
                        "1/2", "Halves are bigger pieces than fifths.", "MEDIUM", "visual pattern",
                        "1/5", "they are equal", "2/5",
                        "More slices of the same bar means each slice is smaller."),
                rng -> q(rng, "A $80 hoodie is 25% off. You pay…",
                        "$60", "Quarter off is $20.", "MEDIUM", "word problem",
                        "$20", "$25", "$80",
                        "Sale price is original minus the discount, not the discount by itself.")
        };
    }

    static QuestionTemplate[] c6Alg() {
        return new QuestionTemplate[]{
                rng -> {
                    int x = QBuilder.range(rng, 1, 6);
                    int y = 2 * x + 1;
                    return q(rng, MathFigures.ask("Rule y = 2x + 1. Which point is when x = " + x + "?",
                                    MathFigures.coordinatePoint(x, y, "Along, then up.")),
                            "(" + x + ", " + y + ")", "Substitute, then plot (x, y).", "MEDIUM", "visual pattern",
                            "(" + y + ", " + x + ")", "(" + x + ", " + x + ")", "(0, " + y + ")",
                            "Find y from the rule first. Plot (x, y), never (y, x).");
                },
                rng -> q(rng, "3a + a equals…",
                        "4a", "Like terms.", "EASY", "skill-check",
                        "3a", "3", "a³",
                        "Same letter: add the numbers in front. 3a + 1a = 4a.")
        };
    }

    static QuestionTemplate[] c6Geo() {
        return new QuestionTemplate[]{
                rng -> {
                    int a = QBuilder.range(rng, 35, 80);
                    int b = QBuilder.range(rng, 35, 80);
                    int c = 180 - a - b;
                    if (c <= 10) {
                        c = 40;
                        b = 180 - a - c;
                    }
                    return q(rng, MathFigures.ask("Missing angle?",
                                    MathFigures.triangleAngles(a, b, "?", "Sum 180°.")),
                            c + "°", "180 − known angles.", "MEDIUM", "visual pattern",
                            (a + b) + "°", "90°", (180 - a) + "°",
                            "Add the two labels. Subtract from 180. Ignore how sharp the drawing looks.");
                },
                rng -> {
                    int a = QBuilder.range(rng, 50, 130);
                    return q(rng, MathFigures.ask("Unmarked angle on this line?",
                                    MathFigures.anglesOnLine(a, "Straight line = 180°.")),
                            String.valueOf(180 - a), "Supplementary.", "EASY", "visual pattern",
                            String.valueOf(360 - a), String.valueOf(a), "90",
                            "A straight line is 180°. Subtract the angle you can see.");
                }
        };
    }

    static QuestionTemplate[] c6Meas() {
        return new QuestionTemplate[]{
                rng -> {
                    int l = QBuilder.range(rng, 5, 12);
                    int w = QBuilder.range(rng, 3, 9);
                    return q(rng, MathFigures.ask("Area of this rectangle?",
                                    MathFigures.rectangle(l, w, l + " cm by " + w + " cm")),
                            (l * w) + " cm2", "l × w.", "EASY", "visual pattern",
                            (2 * (l + w)) + " cm2", (l + w) + " cm2", (l * w) + " cm",
                            "Area is the inside. Multiply. Perimeter would add the fence.");
                },
                rng -> {
                    int b = 2 * QBuilder.range(rng, 3, 7);
                    int h = QBuilder.range(rng, 4, 10);
                    return q(rng, MathFigures.ask("Right-triangle area?",
                                    MathFigures.rightTriangle(b, h, null, "Half a rectangle.")),
                            (b * h / 2) + " cm2", "½bh.", "MEDIUM", "visual pattern",
                            (b * h) + " cm2", (b + h) + " cm2", (2 * (b + h)) + " cm2",
                            "Half the rectangle with the same base and height. Do not forget the ½.");
                }
        };
    }

    static QuestionTemplate[] c6Data() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("Which fruit won the class vote?",
                                MathFigures.barChart("Favourite fruit", new String[]{"Apple", "Banana", "Kiwi"}, new int[]{9, 5, 3})),
                        "Apple", "Tallest bar.", "EASY", "visual pattern",
                        "Banana", "Kiwi", "they tied",
                        "The tallest bar is the most common category — the mode of the display."),
                rng -> q(rng, MathFigures.ask("P(star) if stars are the highlighted sectors?",
                                MathFigures.spinner(new String[]{"★", "○", "○", "○"}, 0, "One star of four.")),
                        "1/4", "One of four equal sectors.", "MEDIUM", "visual pattern",
                        "1/3", "3/4", "1",
                        "Favourable equal sectors ÷ all sectors. The highlight is one of four.")
        };
    }

    static QuestionTemplate[] c6Prob() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("This spinner is fair. P(star)?",
                                MathFigures.spinner(new String[]{"★", "○", "○", "○"}, 0, "Equal sectors.")),
                        "1/4", "One of four.", "EASY", "visual pattern",
                        "1/3", "1/2", "1",
                        "Count equal sectors first. Then count the highlighted ones."),
                rng -> q(rng, MathFigures.ask("Two fair coins. How many equally likely outcomes?",
                                MathFigures.coinTree("HH, HT, TH, TT.")),
                        "4", "List the tree leaves.", "MEDIUM", "visual pattern",
                        "2", "3", "1",
                        "Each coin has two faces. The tree shows every pairing — count the end branches.")
        };
    }

    static QuestionTemplate[] c7Exp() {
        return new QuestionTemplate[]{
                rng -> {
                    int side = QBuilder.pick(rng, 5, 6, 8, 9);
                    return q(rng, MathFigures.ask("A square courtyard. Area?",
                                    MathFigures.rectangle(side, side, "side " + side + " m")),
                            (side * side) + " m²", "side².", "EASY", "visual pattern",
                            (4 * side) + " m²", (2 * side) + " m²", side + " m²",
                            "Area of a square is side × side, not 4 × side (that is perimeter).");
                },
                rng -> {
                    int a = QBuilder.range(rng, 1, 6);
                    int b = QBuilder.range(rng, 0, 9);
                    int c = QBuilder.range(rng, 0, 9);
                    return q(rng, MathFigures.ask("Which expanded form matches the chart?",
                                    MathFigures.placeValueChart(0, a, b, c, a + "" + b + c + " as hundreds, tens, ones")),
                            a + "×10^2 + " + b + "×10^1 + " + c,
                            "Places are powers of 10.", "MEDIUM", "visual pattern",
                            a + "+" + b + "+" + c, String.valueOf(a * 100 + b * 10 + c), a + "×10 + " + b,
                            "Hundreds are ×10², tens ×10¹, ones ×10⁰.");
                }
        };
    }

    static QuestionTemplate[] c7Primes() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("51 splits as shown. 51 is…",
                                MathFigures.factorTree(51, 3, 17, "Both branches are primes.")),
                        "composite", "3 × 17.", "MEDIUM", "visual pattern",
                        "prime", "neither", "a square number only",
                        "More than two distinct factors means composite. A factor tree that keeps splitting is the clue."),
                rng -> q(rng, "Which test shows 84 is divisible by 3?",
                        "digit sum 12 is divisible by 3", "8+4=12, 12÷3=4.", "EASY", "skill-check",
                        "it is even so it is ÷3", "it ends in 4", "84 looks prime",
                        "The ÷3 test is the digit sum, not evenness (that is ÷2).")
        };
    }

    static QuestionTemplate[] c7Int() {
        return new QuestionTemplate[]{
                rng -> {
                    int start = QBuilder.range(rng, -3, 8);
                    int d = QBuilder.range(rng, 3, 8);
                    return q(rng, MathFigures.ask("Start at " + start + " and jump " + d + " left. Land on?",
                                    MathFigures.integerJump(start, -d, "Left is more negative.")),
                            String.valueOf(start - d), "Subtract.", "MEDIUM", "visual pattern",
                            String.valueOf(start + d), String.valueOf(d - start), String.valueOf(start),
                            "Left on the integer line is subtract. Crossing 0 is allowed.");
                },
                rng -> q(rng, "Evaluate 2 + 5 × 3.",
                        "17", "× first.", "EASY", "skill-check",
                        "21", "30", "10",
                        "GEMA: multiply before you add, unless brackets group the add.")
        };
    }

    static QuestionTemplate[] c7Fdp() {
        return new QuestionTemplate[]{
                rng -> {
                    int n = QBuilder.pick(rng, 1, 2, 3);
                    int d = 4;
                    return q(rng, MathFigures.ask("Shaded fraction as a percent?",
                                    MathFigures.fractionBar(n, d, n + "/4")),
                            (n * 25) + "%", "Quarters are 25%.", "EASY", "visual pattern",
                            n + "%", (n * 10) + "%", "100%",
                            "Each quarter is 25%. Multiply the number of shaded quarters by 25.");
                },
                rng -> q(rng, "Share $80 in the ratio 1:3. The larger share is…",
                        "$60", "4 parts, $20 each.", "HARD", "word problem",
                        "$20", "$40", "$80",
                        "Add the ratio parts. One part = total ÷ parts. Scale to the larger name.")
        };
    }

    static QuestionTemplate[] c7Alg() {
        return new QuestionTemplate[]{
                rng -> {
                    int x = QBuilder.range(rng, 1, 5);
                    int y = 3 * x + 1;
                    return q(rng, MathFigures.ask("y = 3x + 1. Point when x = " + x + "?",
                                    MathFigures.coordinatePoint(x, y, "(x, y)")),
                            "(" + x + ", " + y + ")", "Substitute.", "MEDIUM", "visual pattern",
                            "(" + y + ", " + x + ")", "(" + x + ", 3)", "(0, 1)",
                            "Work y, then plot along first. (y, x) is the common swap.");
                }
        };
    }

    static QuestionTemplate[] c7Meas() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("Split this L-shape. A useful method is…",
                                MathFigures.lShape(8, 6, 3, 2, "Add two rectangles or subtract a cut-out.")),
                        "8×6 − 3×2", "Compound area.", "HARD", "visual pattern",
                        "8+6+3+2", "8×6×3", "π×8",
                        "A compound shape is rectangles joined or a rectangle minus a bite. Multiply, then add or subtract."),
                rng -> q(rng, MathFigures.ask("Diameter 10 cm. Circumference is about…",
                                MathFigures.circle(10, "C = πd ≈ 3.14 × 10.")),
                        "31.4 cm", "πd.", "MEDIUM", "visual pattern",
                        "10 cm", "5 cm", "100 cm",
                        "Use diameter in πd. Halve first only if the formula wants radius.")
        };
    }

    static QuestionTemplate[] c7Geo() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("3-4-5 triangle. The longest side is…",
                                MathFigures.pythagoras345("Hypotenuse opposite the right angle.")),
                        "5", "9+16=25.", "MEDIUM", "visual pattern",
                        "3", "4", "7",
                        "The hypotenuse is opposite the square corner and is the longest side."),
                rng -> {
                    int a = QBuilder.range(rng, 40, 80);
                    int b = QBuilder.range(rng, 40, 70);
                    int c = 180 - a - b;
                    return q(rng, MathFigures.ask("Third angle?",
                                    MathFigures.triangleAngles(a, b, "?", "180° sum.")),
                            c + "°", "Subtract from 180.", "EASY", "visual pattern",
                            (a + b) + "°", "90°", (180 - a) + "°",
                            "Triangle sum is 180°. Do not use a protractor on a sketch that may lie.");
                }
        };
    }

    static QuestionTemplate[] c7Stats() {
        return new QuestionTemplate[]{
                rng -> q(rng, MathFigures.ask("Which day looks busiest?",
                                MathFigures.barChart("Visitors", new String[]{"Mon", "Tue", "Wed"}, new int[]{12, 20, 9})),
                        "Tue", "Tallest bar.", "EASY", "visual pattern",
                        "Mon", "Wed", "they are equal",
                        "Read the tallest column. That category has the highest frequency."),
                rng -> q(rng, MathFigures.ask("Two fair coins. P(exactly one head)?",
                                MathFigures.coinTree("HT and TH.")),
                        "1/2", "Two of four paths.", "HARD", "visual pattern",
                        "1/4", "3/4", "1",
                        "List HH HT TH TT. Exactly one head is HT and TH — two paths of four.")
        };
    }

    private static GeneratedQuestion q(java.util.Random rng, String text, String correct, String expl,
                                       String diff, String tag, String d1, String d2, String d3, String hint) {
        return QBuilder.build(rng, text, correct, expl, diff, tag, d1, d2, d3).withHint(hint);
    }
}
