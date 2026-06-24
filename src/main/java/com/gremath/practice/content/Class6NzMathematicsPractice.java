package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;

import java.util.List;

public final class Class6NzMathematicsPractice {
    private static final String TOPIC = "class6-nz-mathematics";
    private static final String SKILL = "skill-check";
    private static final String VISUAL = "visual pattern";
    private static final String WORD = "word problem";
    private static final String COMPLEX = "complex word problem";

    private Class6NzMathematicsPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(placeValue());
        reg.add(operations());
        reg.add(fractionsDecimalsPercentages());
        reg.add(patternsAndAlgebra());
        reg.add(geometry());
        reg.add(measurement());
        reg.add(dataAndChance());
    }

    private static String s(int n) {
        return Integer.toString(n);
    }

    private static LessonPractice placeValue() {
        LessonPractice lp = new LessonPractice("c6nz-place-value", TOPIC, "Place value and whole numbers");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, 10000, 99999);
                    int b = QBuilder.range(rng, 10000, 99999);
                    String correct = a > b ? s(a) : s(b);
                    return QBuilder.build(rng, "Which number is greater: " + a + " or " + b + "?", correct,
                            "Compare from left to right by place value. The first larger place decides.",
                            "EASY", SKILL, s(a < b ? a : b), "They are equal", s(Math.abs(a - b)));
                },
                rng -> {
                    int n = QBuilder.range(rng, 10000, 99999);
                    int rounded = ((n + 50) / 100) * 100;
                    return QBuilder.build(rng, "Round " + n + " to the nearest hundred.", s(rounded),
                            "Check the tens digit. 5 or more rounds up, otherwise round down.",
                            "MEDIUM", SKILL, s(rounded + 100), s(rounded - 100), s(n));
                },
                rng -> {
                    int n = QBuilder.range(rng, 1000, 9999);
                    int thousands = n / 1000;
                    int hundreds = (n / 100) % 10;
                    int tens = (n / 10) % 10;
                    int ones = n % 10;
                    String expanded = thousands * 1000 + " + " + hundreds * 100 + " + " + tens * 10 + " + " + ones;
                    return QBuilder.build(rng, "Which expanded form matches " + n + "?", expanded,
                            "Write each digit as value = digit x place.",
                            "MEDIUM", VISUAL, n + " + 0", thousands + " + " + hundreds + " + " + tens + " + " + ones, s(n));
                },
                rng -> {
                    int n = QBuilder.range(rng, 1000, 99999);
                    int digit = (n / 100) % 10;
                    return QBuilder.build(rng, "What is the digit in the hundreds place of " + n + "?", s(digit),
                            "Count places from right: ones, tens, hundreds.",
                            "EASY", VISUAL, s((n / 10) % 10), s((n / 1000) % 10), s(n % 10));
                }
        );
        lp.word(
                rng -> {
                    int stadiumA = QBuilder.range(rng, 20000, 90000);
                    int stadiumB = QBuilder.range(rng, 20000, 90000);
                    int diff = Math.abs(stadiumA - stadiumB);
                    return QBuilder.build(rng, "Two stadiums seat " + stadiumA + " and " + stadiumB + " people. What is the difference in capacity?", s(diff),
                            "Difference means subtract larger minus smaller.",
                            "EASY", WORD, s(diff + 100), s(diff - 100), s(stadiumA + stadiumB));
                },
                rng -> {
                    int estimateA = QBuilder.range(rng, 11000, 99999);
                    int estimateB = QBuilder.range(rng, 11000, 99999);
                    int totalEstimate = ((estimateA + 500) / 1000) * 1000 + ((estimateB + 500) / 1000) * 1000;
                    return QBuilder.build(rng, "Estimate " + estimateA + " + " + estimateB + " by rounding each number to the nearest thousand.", s(totalEstimate),
                            "Round each addend first, then add rounded values.",
                            "MEDIUM", COMPLEX, s(totalEstimate + 1000), s(totalEstimate - 1000), s(estimateA + estimateB));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which number has 7 in the ten-thousands place?", List.of("73,421", "37,421", "47,321", "27,431"), 0,
                        "Ten-thousands is the leftmost digit in a 5-digit number.", "EASY", SKILL),
                new GeneratedQuestion("Round 58,649 to the nearest thousand.", List.of("59,000", "58,000", "58,600", "60,000"), 0,
                        "Since 649 is 500 or more, round up to 59,000.", "MEDIUM", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("Town A has 48,920 people and Town B has 51,104. Which statement is true?", List.of("Town B is larger by 2,184", "Town A is larger by 2,184", "Both are equal", "Difference is 1,184"), 0,
                        "Subtract 51,104 - 48,920 = 2,184.", "MEDIUM", WORD),
                new GeneratedQuestion("A school rounded its roll of 4,486 students to the nearest hundred for planning. Which value should be used?", List.of("4,500", "4,400", "4,490", "5,000"), 0,
                        "Tens digit is 8, so round up to 4,500.", "EASY", WORD)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice operations() {
        LessonPractice lp = new LessonPractice("c6nz-operations", TOPIC, "Addition, subtraction, multiplication and division");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, 200, 999);
                    int b = QBuilder.range(rng, 100, 700);
                    return QBuilder.build(rng, "Find " + a + " - " + b + ".", s(a - b),
                            "Subtract by place value and regroup where needed.",
                            "EASY", SKILL, s(a + b), s(b - a), s(a - b + 10));
                },
                rng -> {
                    int a = QBuilder.range(rng, 20, 90);
                    int b = QBuilder.range(rng, 11, 35);
                    return QBuilder.build(rng, "Find " + a + " x " + b + ".", s(a * b),
                            "Use area model or vertical multiplication.",
                            "MEDIUM", SKILL, s(a + b), s(a * (b - 1)), s(a * b + a));
                },
                rng -> {
                    int d = QBuilder.pick(rng, 3, 4, 5, 6, 7, 8, 9);
                    int q = QBuilder.range(rng, 20, 90);
                    int n = d * q;
                    return QBuilder.build(rng, "Find " + n + " / " + d + ".", s(q),
                            "Division is the inverse of multiplication.",
                            "EASY", SKILL, s(q + 1), s(q - 1), s(d));
                },
                rng -> {
                    int a = QBuilder.range(rng, 2, 9);
                    int b = QBuilder.range(rng, 2, 9);
                    int c = QBuilder.range(rng, 10, 50);
                    int correct = a * b + c;
                    return QBuilder.build(rng, "Evaluate: " + a + " x " + b + " + " + c, s(correct),
                            "Do multiplication before addition.",
                            "MEDIUM", VISUAL, s((a + b) * c), s(a * (b + c)), s(a + b + c));
                }
        );
        lp.word(
                rng -> {
                    int boxes = QBuilder.range(rng, 18, 45);
                    int items = QBuilder.range(rng, 6, 14);
                    return QBuilder.build(rng, "A store has " + boxes + " boxes with " + items + " pencils in each box. How many pencils are there?", s(boxes * items),
                            "Equal groups means multiply.",
                            "EASY", WORD, s(boxes + items), s(boxes * items + items), s(boxes * (items - 1)));
                },
                rng -> {
                    int total = QBuilder.range(rng, 300, 900);
                    int groups = QBuilder.pick(rng, 4, 5, 6, 8, 9);
                    int q = total / groups;
                    int adjusted = q * groups;
                    return QBuilder.build(rng, "A coach has " + adjusted + " cones and arranges them equally in " + groups + " lines. How many cones per line?", s(q),
                            "Sharing equally means divide total by number of groups.",
                            "MEDIUM", WORD, s(q + 2), s(groups), s(adjusted - q));
                },
                rng -> {
                    int morning = QBuilder.range(rng, 120, 380);
                    int afternoon = QBuilder.range(rng, 90, 260);
                    int sold = QBuilder.range(rng, 60, 180);
                    int result = morning + afternoon - sold;
                    return QBuilder.build(rng, "A canteen made " + morning + " sandwiches in the morning and " + afternoon + " in the afternoon, then sold " + sold + ". How many remained?", s(result),
                            "Total made first, then subtract sold.",
                            "HARD", COMPLEX, s(result + sold), s(morning - afternoon - sold), s(result + 10));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which expression equals 84?", List.of("7 x 12", "7 + 12", "96 - 12", "9 x 8 + 2"), 0,
                        "7 x 12 = 84 exactly.", "EASY", SKILL),
                new GeneratedQuestion("Evaluate: 36 / 6 + 4 x 3", List.of("18", "20", "10", "5"), 0,
                        "Do division and multiplication first: 6 + 12 = 18.", "MEDIUM", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A bus carries 48 students. How many buses are needed for 240 students?", List.of("5", "4", "6", "7"), 0,
                        "240 / 48 = 5.", "EASY", WORD),
                new GeneratedQuestion("A farmer packs 368 apples equally into 8 crates. How many apples per crate?", List.of("46", "45", "48", "44"), 0,
                        "368 / 8 = 46.", "MEDIUM", WORD)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice fractionsDecimalsPercentages() {
        LessonPractice lp = new LessonPractice("c6nz-fdp", TOPIC, "Fractions, decimals and percentages");
        lp.concept(
                rng -> {
                    int denominator = QBuilder.pick(rng, 2, 4, 5, 10, 20, 25);
                    int numerator = QBuilder.range(rng, 1, denominator - 1);
                    int percent = numerator * 100 / denominator;
                    return QBuilder.build(rng, "Convert " + numerator + "/" + denominator + " to a percentage.", percent + "%",
                            "Multiply fraction by 100 percent.",
                            "EASY", SKILL, numerator + "%", (percent + 10) + "%", (percent - 10) + "%");
                },
                rng -> {
                    int whole = QBuilder.pick(rng, 40, 60, 80, 100, 120, 200);
                    int pct = QBuilder.pick(rng, 10, 20, 25, 30, 40, 50, 75);
                    int part = whole * pct / 100;
                    return QBuilder.build(rng, "What is " + pct + "% of " + whole + "?", s(part),
                            "Use percent x whole / 100.",
                            "MEDIUM", SKILL, s(part + whole / 10), s(whole - part), s(part - whole / 20));
                },
                rng -> {
                    int a = QBuilder.range(rng, 10, 99);
                    int b = QBuilder.range(rng, 10, 99);
                    String correct = (a / 100.0 > b / 100.0) ? "0." + a : "0." + b;
                    return QBuilder.build(rng, "Which decimal is greater: 0." + a + " or 0." + b + "?", correct,
                            "Compare tenths, then hundredths.",
                            "EASY", VISUAL, "Both are equal", "0." + (a < b ? a : b), "0." + Math.min(99, Math.max(a, b) + 1));
                },
                rng -> {
                    int num = QBuilder.pick(rng, 1, 2, 3, 4);
                    int den = 4;
                    String bar = "[" + "=".repeat(num) + ".".repeat(den - num) + "]";
                    return QBuilder.build(rng, "The shaded bar " + bar + " represents which fraction?", num + "/" + den,
                            "Count shaded parts over total equal parts.",
                            "MEDIUM", VISUAL, den + "/" + num, (num + 1) + "/" + den, num + "/" + (den + 1));
                }
        );
        lp.word(
                rng -> {
                    int total = QBuilder.pick(rng, 80, 100, 120, 160, 200);
                    int pass = QBuilder.pick(rng, 25, 40, 50, 60, 75);
                    int passed = total * pass / 100;
                    return QBuilder.build(rng, "In a test, " + pass + "% of " + total + " students passed. How many passed?", s(passed),
                            "Find the given percent of the total group.",
                            "EASY", WORD, s(total - passed), s(pass), s(passed + 10));
                },
                rng -> {
                    int score = QBuilder.pick(rng, 36, 48, 54, 63, 72);
                    int pct = QBuilder.pick(rng, 30, 40, 45, 60);
                    int total = score * 100 / pct;
                    return QBuilder.build(rng, score + " is " + pct + "% of what number?", s(total),
                            "If part and percent are known, divide by percent then multiply by 100.",
                            "HARD", COMPLEX, s(total + 20), s(total - 20), s(score + pct));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which are equivalent?", List.of("0.75 and 3/4", "0.7 and 3/4", "25% and 2/5", "0.2 and 1/5 of 100"), 0,
                        "3/4 = 0.75 exactly.", "EASY", SKILL),
                new GeneratedQuestion("Order from least to greatest: 0.4, 35%, 1/2", List.of("35%, 0.4, 1/2", "0.4, 35%, 1/2", "1/2, 0.4, 35%", "35%, 1/2, 0.4"), 0,
                        "Convert to same form: 35% = 0.35, 0.4 = 0.4, 1/2 = 0.5.", "MEDIUM", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A jacket is discounted by 25% from $80. What is the sale price?", List.of("$60", "$55", "$20", "$75"), 0,
                        "25% of 80 is 20, so new price is 80 - 20 = 60.", "EASY", WORD),
                new GeneratedQuestion("A bottle is 3/5 full and holds 1.5 L now. What is full capacity?", List.of("2.5 L", "2 L", "3 L", "1.8 L"), 0,
                        "If 3/5 is 1.5, then 1/5 is 0.5 and 5/5 is 2.5.", "HARD", COMPLEX)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice patternsAndAlgebra() {
        LessonPractice lp = new LessonPractice("c6nz-patterns", TOPIC, "Patterns and simple algebra");
        lp.concept(
                rng -> {
                    int start = QBuilder.range(rng, 2, 15);
                    int step = QBuilder.pick(rng, 2, 3, 4, 5, 6, 7);
                    int term = start + step * 4;
                    return QBuilder.build(rng, "Sequence: " + start + ", " + (start + step) + ", " + (start + 2 * step) + ", " + (start + 3 * step) + ", ... What is the next term?", s(term),
                            "Identify constant difference and continue.",
                            "EASY", SKILL, s(term + step), s(term - step), s(start + step));
                },
                rng -> {
                    int x = QBuilder.range(rng, 3, 30);
                    int rhs = x + QBuilder.range(rng, 8, 50);
                    int add = rhs - x;
                    return QBuilder.build(rng, "Solve: x + " + add + " = " + rhs, s(x),
                            "Inverse operation: subtract " + add + " from both sides.",
                            "MEDIUM", SKILL, s(x + 1), s(rhs), s(add));
                },
                rng -> {
                    int x = QBuilder.range(rng, 2, 20);
                    int mul = QBuilder.pick(rng, 2, 3, 4, 5, 6);
                    int rhs = x * mul;
                    return QBuilder.build(rng, "Solve: " + mul + "n = " + rhs, s(x),
                            "Divide both sides by " + mul + ".",
                            "MEDIUM", SKILL, s(x + 2), s(rhs - mul), s(mul));
                },
                rng -> {
                    int n = QBuilder.range(rng, 2, 12);
                    int y = 3 * n + 2;
                    return QBuilder.build(rng, "Rule: y = 3n + 2. What is y when n = " + n + "?", s(y),
                            "Substitute n value into the rule.",
                            "MEDIUM", VISUAL, s(3 * n), s(n + 2), s(y + 3));
                }
        );
        lp.word(
                rng -> {
                    int rows = QBuilder.range(rng, 3, 10);
                    int first = QBuilder.range(rng, 5, 15);
                    int add = QBuilder.pick(rng, 2, 3, 4);
                    int finalRow = first + add * (rows - 1);
                    return QBuilder.build(rng, "A theater has " + first + " seats in row 1 and each new row has " + add + " more seats. How many seats are in row " + rows + "?", s(finalRow),
                            "Arithmetic pattern with constant increase.",
                            "MEDIUM", WORD, s(finalRow + add), s(first + rows), s(finalRow - add));
                },
                rng -> {
                    int x = QBuilder.range(rng, 4, 20);
                    int tickets = 2 * x + 7;
                    return QBuilder.build(rng, "An event uses rule tickets = 2p + 7, where p is number of performers. If p = " + x + ", how many tickets?", s(tickets),
                            "Replace p with the given value and evaluate.",
                            "EASY", WORD, s(2 * x), s(tickets + 2), s(x + 7));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which rule generates 5, 9, 13, 17, ...?", List.of("Add 4 each time", "Multiply by 2", "Add 5 each time", "Subtract 4 each time"), 0,
                        "Difference between terms is consistently +4.", "EASY", SKILL),
                new GeneratedQuestion("If m - 8 = 19, then m =", List.of("27", "11", "152", "26"), 0,
                        "Add 8 to both sides.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A pattern starts at 12 and adds 6 each step. What is the 5th term?", List.of("36", "30", "42", "24"), 0,
                        "Terms: 12, 18, 24, 30, 36.", "MEDIUM", WORD),
                new GeneratedQuestion("Point (x, y) follows y = x + 4. If x = 7, which point fits?", List.of("(7, 11)", "(11, 7)", "(7, 4)", "(3, 7)"), 0,
                        "y = 7 + 4 = 11.", "MEDIUM", WORD)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice geometry() {
        LessonPractice lp = new LessonPractice("c6nz-geometry", TOPIC, "Geometry: shapes, angles and symmetry");
        lp.concept(
                rng -> QBuilder.build(rng, "How many right angles does a rectangle have?", "4",
                        "A rectangle always has four 90-degree angles.",
                        "EASY", SKILL, "2", "1", "0"),
                rng -> {
                    int angle = QBuilder.pick(rng, 35, 48, 62, 74, 89);
                    return QBuilder.build(rng, "An angle of " + angle + " degrees is:", "acute",
                            "Acute angles are less than 90 degrees.",
                            "EASY", SKILL, "right", "obtuse", "straight");
                },
                rng -> {
                    int onLine = QBuilder.range(rng, 30, 150);
                    int missing = 180 - onLine;
                    return QBuilder.build(rng, "Two angles on a straight line are " + onLine + " and x. Find x.", s(missing),
                            "Angles on a straight line sum to 180 degrees.",
                            "MEDIUM", SKILL, s(missing + 10), s(missing - 10), s(360 - onLine));
                },
                rng -> {
                    int around = QBuilder.range(rng, 80, 300);
                    int missing = 360 - around;
                    return QBuilder.build(rng, "Angles around a point sum to 360. If known angles add to " + around + ", the missing angle is:", s(missing),
                            "Use total around a point = 360 degrees.",
                            "MEDIUM", VISUAL, s(missing + 15), s(missing - 15), s(180 - around));
                }
        );
        lp.word(
                rng -> {
                    int sides = QBuilder.pick(rng, 3, 4, 5, 6, 8);
                    return QBuilder.build(rng, "A regular polygon has " + sides + " equal sides. Which shape could this be when sides = 5?", "pentagon",
                            "A 5-sided polygon is a pentagon.",
                            "EASY", WORD, "hexagon", "triangle", "rectangle");
                },
                rng -> {
                    int total = QBuilder.pick(rng, 12, 16, 20, 24, 28);
                    int each = total / 4;
                    return QBuilder.build(rng, "A shape has rotational symmetry of order 4 over 360 degrees. Each turn to match is how many degrees?", s(each),
                            "Divide full turn by order of rotation.",
                            "HARD", COMPLEX, s(each + 10), s(each - 10), s(total));
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which shape always has exactly one pair of parallel sides?", List.of("trapezium", "rectangle", "square", "rhombus"), 0,
                        "A trapezium has one pair of parallel sides.", "MEDIUM", SKILL),
                new GeneratedQuestion("A triangle with all sides equal is called:", List.of("equilateral", "isosceles", "scalene", "right"), 0,
                        "Equilateral means all three sides equal.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A clock hand turns from 2 to 5. How many degrees does it turn?", List.of("90", "60", "120", "150"), 0,
                        "Each hour mark is 30 degrees. 3 steps x 30 = 90.", "MEDIUM", WORD),
                new GeneratedQuestion("A designer folds a shape and it matches perfectly along one line only. How many lines of symmetry does it have?", List.of("1", "2", "0", "4"), 0,
                        "Perfect matching on one fold means one line of symmetry.", "EASY", WORD)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice measurement() {
        LessonPractice lp = new LessonPractice("c6nz-measurement", TOPIC, "Measurement: length, area, volume, time and temperature");
        lp.concept(
                rng -> {
                    int m = QBuilder.range(rng, 2, 25);
                    return QBuilder.build(rng, "Convert " + m + " m to cm.", s(m * 100),
                            "1 m = 100 cm.",
                            "EASY", SKILL, s(m * 10), s(m * 1000), s(m + 100));
                },
                rng -> {
                    int l = QBuilder.range(rng, 1, 12);
                    return QBuilder.build(rng, "Convert " + l + " L to mL.", s(l * 1000),
                            "1 L = 1000 mL.",
                            "EASY", SKILL, s(l * 100), s(l * 10), s(l + 1000));
                },
                rng -> {
                    int length = QBuilder.range(rng, 4, 25);
                    int width = QBuilder.range(rng, 3, 20);
                    return QBuilder.build(rng, "Find area of rectangle " + length + " cm by " + width + " cm.", s(length * width) + " cm2",
                            "Area = length x width.",
                            "MEDIUM", VISUAL, s(2 * (length + width)) + " cm2", s(length + width) + " cm2", s(length * width) + " cm");
                },
                rng -> {
                    int startH = QBuilder.range(rng, 1, 10);
                    int startM = QBuilder.pick(rng, 0, 10, 15, 20, 30, 40, 45, 50);
                    int addMin = QBuilder.pick(rng, 35, 45, 55, 65, 75, 95);
                    int totalStart = startH * 60 + startM;
                    int end = totalStart + addMin;
                    int endH = (end / 60) % 12 == 0 ? 12 : (end / 60) % 12;
                    int endM = end % 60;
                    String ans = endH + ":" + String.format("%02d", endM);
                    return QBuilder.build(rng, "A lesson starts at " + startH + ":" + String.format("%02d", startM) + " and lasts " + addMin + " minutes. What time does it finish?", ans,
                            "Convert to total minutes, add, and convert back to time.",
                            "HARD", SKILL, startH + ":" + String.format("%02d", (startM + addMin) % 60), (endH + 1) + ":" + String.format("%02d", endM), endH + ":" + String.format("%02d", (endM + 10) % 60));
                }
        );
        lp.word(
                rng -> {
                    int side = QBuilder.range(rng, 2, 12);
                    int volume = side * side * side;
                    return QBuilder.build(rng, "A cube has side " + side + " cm. What is its volume?", s(volume) + " cm3",
                            "Volume of cube = side x side x side.",
                            "MEDIUM", WORD, s(side * side) + " cm3", s(volume + side) + " cm3", s(6 * side * side) + " cm3");
                },
                rng -> {
                    int temp = QBuilder.range(rng, -5, 18);
                    int drop = QBuilder.range(rng, 3, 11);
                    int result = temp - drop;
                    return QBuilder.build(rng, "Morning temperature was " + temp + " C and dropped by " + drop + " C. What is now?", s(result) + " C",
                            "Drop means subtract.",
                            "EASY", WORD, s(result + drop) + " C", s(-result) + " C", s(result - 1) + " C");
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Perimeter of a square with side 9 cm is:", List.of("36 cm", "81 cm", "18 cm", "27 cm"), 0,
                        "Perimeter = 4 x side.", "EASY", SKILL),
                new GeneratedQuestion("A right triangle has base 10 cm and height 6 cm. Area is:", List.of("30 cm2", "60 cm2", "16 cm2", "20 cm2"), 0,
                        "Area of right triangle = 1/2 x base x height.", "MEDIUM", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A bottle has 750 mL juice. How many such bottles make 3 L?", List.of("4", "3", "5", "2"), 0,
                        "3 L = 3000 mL, and 3000/750 = 4.", "MEDIUM", WORD),
                new GeneratedQuestion("A movie starts at 14:35 and ends at 16:05. Duration is:", List.of("1 h 30 min", "1 h 40 min", "2 h 30 min", "90 h"), 0,
                        "From 14:35 to 15:35 is 1 hour, then 30 minutes more.", "EASY", WORD)
        );
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice dataAndChance() {
        LessonPractice lp = new LessonPractice("c6nz-data-chance", TOPIC, "Data, graphs and chance");
        lp.concept(
                rng -> {
                    int a = QBuilder.range(rng, 10, 40);
                    int b = QBuilder.range(rng, 10, 40);
                    int c = QBuilder.range(rng, 10, 40);
                    int d = QBuilder.range(rng, 10, 40);
                    int mean = (a + b + c + d) / 4;
                    return QBuilder.build(rng, "Find the mean of " + a + ", " + b + ", " + c + ", " + d + ".", s(mean),
                            "Add values then divide by the number of values.",
                            "MEDIUM", SKILL, s(mean + 1), s(mean - 1), s(a + b + c + d));
                },
                rng -> {
                    int low = QBuilder.range(rng, 8, 30);
                    int high = QBuilder.range(rng, 35, 70);
                    int range = high - low;
                    return QBuilder.build(rng, "A data set has minimum " + low + " and maximum " + high + ". What is the range?", s(range),
                            "Range = max - min.",
                            "EASY", SKILL, s(range + 1), s(range - 1), s(high + low));
                },
                rng -> {
                    int red = QBuilder.range(rng, 1, 9);
                    int blue = QBuilder.range(rng, 1, 9);
                    int green = QBuilder.range(rng, 1, 9);
                    int total = red + blue + green;
                    return QBuilder.build(rng, "A bag has " + red + " red, " + blue + " blue, and " + green + " green counters. Probability of blue is:", blue + "/" + total,
                            "Probability = favorable outcomes / total outcomes.",
                            "MEDIUM", SKILL, red + "/" + total, green + "/" + total, blue + "/" + (total - 1));
                },
                rng -> {
                    int heads = QBuilder.range(rng, 3, 17);
                    int tosses = QBuilder.range(rng, heads + 2, 24);
                    return QBuilder.build(rng, "A coin shows heads " + heads + " times out of " + tosses + " tosses. Experimental probability of heads is:", heads + "/" + tosses,
                            "Use observed frequency over total trials.",
                            "EASY", VISUAL, (tosses - heads) + "/" + tosses, heads + "/" + (tosses - 1), heads + "/" + (tosses + 1));
                }
        );
        lp.word(
                rng -> {
                    int m = QBuilder.range(rng, 20, 45);
                    int t = QBuilder.range(rng, 25, 55);
                    int w = QBuilder.range(rng, 15, 40);
                    int f = QBuilder.range(rng, 20, 50);
                    int sum = m + t + w + f;
                    return QBuilder.build(rng, "Daily visitors were Mon " + m + ", Tue " + t + ", Wed " + w + ", Thu " + f + ". What was the average visitors per day?", s(sum / 4),
                            "Average = total visitors / number of days.",
                            "MEDIUM", WORD, s(sum), s(sum / 3), s(sum / 5));
                },
                rng -> {
                    int spinner = QBuilder.pick(rng, 4, 6, 8, 10);
                    int favorable = QBuilder.range(rng, 1, spinner - 1);
                    return QBuilder.build(rng, "A fair spinner has " + spinner + " equal sections; " + favorable + " are stars. What is P(star)?", favorable + "/" + spinner,
                            "For equally likely outcomes, probability is favorable over total.",
                            "EASY", WORD, s(favorable) + "/" + (spinner + 1), s(favorable + 1) + "/" + spinner, s(spinner - favorable) + "/" + spinner);
                }
        );
        lp.classicConcept(
                new GeneratedQuestion("Which is impossible?", List.of("Rolling a 7 on a standard six-sided die", "Getting a head on a coin toss", "Drawing a red card from a mixed deck", "Spinning an odd number on 1-6 spinner"), 0,
                        "A standard die has outcomes 1 to 6 only.", "EASY", SKILL),
                new GeneratedQuestion("Data: 12, 18, 20, 10. The range is:", List.of("10", "15", "8", "12"), 0,
                        "Range = 20 - 10 = 10.", "EASY", SKILL)
        );
        lp.classicWord(
                new GeneratedQuestion("A class survey shows 9 students prefer apples, 6 bananas, 5 oranges. Probability of randomly choosing a banana fan is:", List.of("6/20", "9/20", "5/20", "6/9"), 0,
                        "Total students = 20; banana fans = 6.", "MEDIUM", WORD),
                new GeneratedQuestion("Temperatures over five days are 18, 20, 22, 17, 23. Mean temperature is:", List.of("20", "19", "21", "18"), 0,
                        "Sum is 100, divide by 5 gives 20.", "MEDIUM", WORD)
        );
        return lp.sheets(20, 10, 20);
    }
}

