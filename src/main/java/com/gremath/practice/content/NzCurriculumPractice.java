package com.gremath.practice.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/**
 * Registers generated practice for every NZ curriculum lesson that is not already
 * covered by the hand-crafted Year 6/7 mathematics banks.
 */
public final class NzCurriculumPractice {
    private NzCurriculumPractice() {
    }

    public static void register(PracticeRegistry registry) {
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                if (NzCurriculumCatalog.isHandcrafted(year, subject) && subject == NzSubject.MATHEMATICS) {
                    continue;
                }
                String slug = NzCurriculumCatalog.topicSlug(year, subject);
                for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, subject)) {
                    registry.add(build(year, subject, slug, spec));
                }
            }
        }
    }

    private static LessonPractice build(int year, NzSubject subject, String slug, NzLessonSpec spec) {
        int conceptSheets = year <= 4 ? 8 : 10;
        int wordSheets = year <= 4 ? 5 : 6;
        int perSheet = year <= 3 ? 10 : 12;
        LessonPractice lp = new LessonPractice(spec.practiceKey(), slug, spec.title().replaceFirst("^\\d+\\.\\s*", ""));
        lp.sheets(conceptSheets, wordSheets, perSheet);
        lp.concept(conceptTemplates(year, spec.practiceKind()));
        lp.word(wordTemplates(year, spec.practiceKind()));
        return lp;
    }

    private static QuestionTemplate[] conceptTemplates(int year, String kind) {
        return switch (kind) {
            case "NUMBER" -> mathNumber(year, false);
            case "OPS" -> mathOps(year, false);
            case "FRACTION" -> mathFraction(year, false);
            case "ALGEBRA" -> mathAlgebra(year, false);
            case "MEASURE" -> mathMeasure(year, false);
            case "GEOMETRY" -> mathGeometry(year, false);
            case "DATA" -> mathData(year, false);
            case "CHANCE" -> mathChance(year, false);
            case "READING" -> reading(year, false);
            case "WRITING" -> writing(year, false);
            case "GRAMMAR" -> grammar(year, false);
            case "VOCAB" -> vocab(year, false);
            case "ORAL" -> oral(year, false);
            case "INVESTIGATE" -> investigate(year, false);
            case "LIVING" -> living(year, false);
            case "MATTER" -> matter(year, false);
            case "FORCES" -> forces(year, false);
            case "EARTH" -> earth(year, false);
            case "IDENTITY" -> identity(year, false);
            case "PLACE" -> place(year, false);
            case "HISTORY" -> history(year, false);
            case "ECONOMY" -> economy(year, false);
            case "CIVICS" -> civics(year, false);
            case "DESIGN" -> design(year, false);
            case "DIGITAL" -> digital(year, false);
            case "MAKING" -> making(year, false);
            case "COMPUTE" -> compute(year, false);
            case "EVALUATE" -> evaluate(year, false);
            case "VISUAL" -> visual(year, false);
            case "MUSIC" -> music(year, false);
            case "DRAMA" -> drama(year, false);
            case "DANCE" -> dance(year, false);
            case "RESPOND" -> respond(year, false);
            case "MOVE" -> move(year, false);
            case "HAUORA" -> hauora(year, false);
            case "RELATE" -> relate(year, false);
            case "SAFETY" -> safety(year, false);
            case "COMMUNITY" -> community(year, false);
            case "GREETINGS" -> greetings(year, false);
            case "WORDS" -> words(year, false);
            case "LISTEN" -> listen(year, false);
            case "READLANG" -> readLang(year, false);
            case "TIKANGA" -> tikanga(year, false);
            default -> mathNumber(year, false);
        };
    }

    private static QuestionTemplate[] wordTemplates(int year, String kind) {
        return switch (kind) {
            case "NUMBER" -> mathNumber(year, true);
            case "OPS" -> mathOps(year, true);
            case "FRACTION" -> mathFraction(year, true);
            case "ALGEBRA" -> mathAlgebra(year, true);
            case "MEASURE" -> mathMeasure(year, true);
            case "GEOMETRY" -> mathGeometry(year, true);
            case "DATA" -> mathData(year, true);
            case "CHANCE" -> mathChance(year, true);
            default -> conceptTemplates(year, kind);
        };
    }

    private static int maxN(int year) {
        if (year <= 2) {
            return 20;
        }
        if (year <= 4) {
            return 100;
        }
        if (year <= 6) {
            return 1000;
        }
        return 10_000;
    }

    private static QuestionTemplate[] mathNumber(int year, boolean word) {
        int max = maxN(year);
        if (year == 1) {
            max = 20;
        }
        int cap = max;
        return new QuestionTemplate[]{
                rng -> {
                    int a = QBuilder.range(rng, Math.max(2, cap / 4), cap);
                    int b = QBuilder.range(rng, Math.max(1, cap / 5), cap);
                    if (a == b) {
                        b = Math.min(cap, a + 1);
                    }
                    String greater = String.valueOf(Math.max(a, b));
                    String prompt = word
                            ? "A kura has " + a + " books and another has " + b + ". Which has more books (give the larger number)?"
                            : "Which number is greater: " + a + " or " + b + "?";
                    return QBuilder.build(rng, prompt, greater,
                            "Compare digits from the left. The first larger place wins.",
                            "EASY", word ? "word problem" : "skill-check",
                            String.valueOf(Math.min(a, b)), String.valueOf(Math.abs(a - b)), String.valueOf(a + b));
                },
                rng -> {
                    int n = QBuilder.range(rng, year <= 1 ? 10 : 10, Math.max(20, Math.min(cap, year <= 2 ? 99 : cap / 2)));
                    int tens = (n / 10) * 10;
                    int rounded = n % 10 >= 5 ? tens + 10 : tens;
                    if (year == 1) {
                        int before = QBuilder.range(rng, 2, 19);
                        return QBuilder.build(rng, "What number comes just after " + before + "?",
                                String.valueOf(before + 1), "Count on one.", "EASY", "skill-check",
                                String.valueOf(before - 1), String.valueOf(before), String.valueOf(before + 2));
                    }
                    return QBuilder.build(rng, "Round " + n + " to the nearest ten.", String.valueOf(rounded),
                            "Look at the ones digit. 5 or more rounds up.",
                            "MEDIUM", "skill-check",
                            String.valueOf(tens), String.valueOf(n), String.valueOf(rounded + 10));
                },
                rng -> {
                    int n = year <= 2
                            ? QBuilder.range(rng, 10, Math.min(cap, 99))
                            : QBuilder.range(rng, 21, Math.min(cap, 999));
                    int tensDigit = (n / 10) % 10;
                    return QBuilder.build(rng, "What digit is in the tens place of " + n + "?",
                            String.valueOf(tensDigit),
                            "From the right: ones, then tens.",
                            "EASY", "visual pattern",
                            String.valueOf(n % 10), String.valueOf((n / 100) % 10), String.valueOf(n));
                },
                rng -> {
                    if (year < 5) {
                        int n = QBuilder.range(rng, 4, Math.min(cap, 40));
                        boolean even = n % 2 == 0;
                        return QBuilder.build(rng, "Is " + n + " even or odd?", even ? "even" : "odd",
                                "Even numbers end in 0, 2, 4, 6 or 8.", "EASY", "skill-check",
                                even ? "odd" : "even", "prime", "a fraction");
                    }
                    int n = QBuilder.pick(rng, 4, 9, 16, 25, 36, 49, 64, 81, 100);
                    int root = (int) Math.round(Math.sqrt(n));
                    return QBuilder.build(rng, "What is √" + n + " (the square root)?", String.valueOf(root),
                            n + " is " + root + " × " + root + ".", "MEDIUM", "skill-check",
                            String.valueOf(n / 2), String.valueOf(root + 1), String.valueOf(n));
                }
        };
    }

    private static QuestionTemplate[] mathOps(int year, boolean word) {
        int max = Math.min(maxN(year), year <= 2 ? 20 : 200);
        return new QuestionTemplate[]{
                rng -> {
                    int a = QBuilder.range(rng, 2, max / 2);
                    int b = QBuilder.range(rng, 2, max / 2);
                    int sum = a + b;
                    String prompt = word
                            ? "You collect " + a + " shells in the morning and " + b + " in the afternoon. How many shells in total?"
                            : "What is " + a + " + " + b + "?";
                    return QBuilder.build(rng, prompt, String.valueOf(sum),
                            "Addition combines quantities.",
                            "EASY", word ? "word problem" : "skill-check",
                            String.valueOf(Math.abs(a - b)), String.valueOf(a + b + 1), String.valueOf(a * 2));
                },
                rng -> {
                    int b = QBuilder.range(rng, 2, 12);
                    int a = b * QBuilder.range(rng, 2, year <= 2 ? 5 : 10);
                    String prompt = word
                            ? "There are " + a + " muffins shared equally among " + b + " plates. How many on each plate?"
                            : "What is " + a + " ÷ " + b + "?";
                    return QBuilder.build(rng, prompt, String.valueOf(a / b),
                            "Division splits into equal groups.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(a / b + 1), String.valueOf(a - b), String.valueOf(b));
                },
                rng -> {
                    int a = QBuilder.range(rng, 3, year <= 3 ? 9 : 12);
                    int b = QBuilder.range(rng, 3, year <= 3 ? 9 : 12);
                    String prompt = word
                            ? "A crate holds " + a + " rows of " + b + " bottles. How many bottles?"
                            : "What is " + a + " × " + b + "?";
                    return QBuilder.build(rng, prompt, String.valueOf(a * b),
                            "Multiplication is equal groups.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(a + b), String.valueOf(a * b + a), String.valueOf(Math.abs(a - b)));
                }
        };
    }

    private static QuestionTemplate[] mathFraction(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "A sandwich cut into two equal pieces: each piece is a…", "half",
                            "A half is one of two equal parts.", "EASY", "skill-check",
                            "quarter of a different whole", "whole sandwich twice", "three pieces"),
                    rng -> QBuilder.build(rng, "8 mussels shared equally onto 2 plates. How many on each plate?", "4",
                            "Half of 8 is 4. Equal sharing.", "EASY", word ? "word problem" : "skill-check",
                            "8", "2", "6"),
                    rng -> QBuilder.build(rng, "Two pieces are halves only if they are…", "equal in size",
                            "Fairness is the mathematics of a half.", "MEDIUM", "skill-check",
                            "any two pieces", "one much bigger", "three pieces")
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    int d = QBuilder.pick(rng, 2, 4, 5, 10);
                    int n = QBuilder.range(rng, 1, d - 1);
                    String correct = n + "/" + d;
                    return QBuilder.build(rng, "A shape is split into " + d + " equal parts and " + n + " are shaded. What fraction is shaded?",
                            correct, "Shaded parts over equal parts.",
                            "EASY", "visual pattern",
                            n + "/" + (d + 1), d + "/" + n, "1/" + n);
                },
                rng -> {
                    if (year < 4) {
                        return QBuilder.build(rng, "Which is larger for the same whole: 1/3 or 1/4?", "1/3",
                                "Thirds are larger pieces than quarters of the same whole.", "MEDIUM", "skill-check",
                                "1/4", "they must be equal", "1/12");
                    }
                    int pct = QBuilder.pick(rng, 10, 25, 50, 75);
                    String dec = pct == 10 ? "0.1" : pct == 25 ? "0.25" : pct == 50 ? "0.5" : "0.75";
                    String prompt = word
                            ? "A sale takes " + pct + "% off. Which decimal matches " + pct + "%?"
                            : "What decimal equals " + pct + "%?";
                    return QBuilder.build(rng, prompt, dec,
                            "Percent means out of 100. Divide by 100.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(pct), "0." + pct, pct == 50 ? "0.05" : "0.5");
                },
                rng -> {
                    int whole = QBuilder.pick(rng, 20, 40, 80, 100);
                    int pct = QBuilder.pick(rng, 10, 25, 50);
                    int ans = whole * pct / 100;
                    if (year < 5) {
                        return QBuilder.build(rng, "What is 1/2 of " + whole + "?", String.valueOf(whole / 2),
                                "Half means divide by 2.", "EASY", "skill-check",
                                String.valueOf(whole), String.valueOf(whole / 4), String.valueOf(whole - 2));
                    }
                    String prompt = word
                            ? "There are " + whole + " students. " + pct + "% walk to kura. How many walk?"
                            : "What is " + pct + "% of " + whole + "?";
                    return QBuilder.build(rng, prompt, String.valueOf(ans),
                            "Percent of a number: (percent × whole) ÷ 100.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(whole - ans), String.valueOf(pct), String.valueOf(ans + 5));
                }
        };
    }

    private static QuestionTemplate[] mathAlgebra(int year, boolean word) {
        if (year >= 10) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, word
                                    ? "A rectangle is (x + 3) by (x + 1). Which expansion is its area?"
                                    : "Expand (x + 3)(x + 1).",
                            "x² + 4x + 3", "FOIL: x² + x + 3x + 3.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            "x² + 3", "x² + 3x + 1", "2x + 4"),
                    rng -> QBuilder.build(rng, "Factorise x² + 5x + 6.",
                            "(x + 2)(x + 3)", "Two numbers that multiply to 6 and add to 5: 2 and 3.",
                            "MEDIUM", "skill-check", "(x + 1)(x + 6)", "(x + 5)(x + 1)", "x(x + 5) + 6"),
                    rng -> QBuilder.build(rng, "The solutions of (x + 2)(x − 5) = 0 are…",
                            "x = −2 and x = 5", "A product is 0 when a factor is 0.",
                            "EASY", "skill-check", "x = 2 and x = −5", "x = 2 and x = 5", "no real solutions")
            };
        }
        if (year >= 8) {
            return new QuestionTemplate[]{
                    rng -> {
                        int a = QBuilder.range(rng, 2, 6);
                        int x = QBuilder.range(rng, 3, 9);
                        int b = QBuilder.range(rng, 1, 8);
                        int rhs = a * x + b;
                        return QBuilder.build(rng, "Solve " + a + "x + " + b + " = " + rhs + ".",
                                String.valueOf(x), "Subtract " + b + ", then divide by " + a + ".",
                                "MEDIUM", "skill-check",
                                String.valueOf(rhs), String.valueOf(a + b), String.valueOf(x + 1));
                    },
                    rng -> QBuilder.build(rng, "On y = 2x + 1, when x = 3 the y-value is…",
                            "7", "2×3 + 1 = 7. Gradient 2, intercept 1.",
                            "EASY", "skill-check", "5", "6", "9"),
                    rng -> QBuilder.build(rng, "Like terms: 3a + 5a equals…",
                            "8a", "Add coefficients; keep the same letter.",
                            "EASY", "skill-check", "8a²", "15a", "3a5a")
            };
        }
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "The repeating pattern 🔴🔵🔴🔵🔴… next is…",
                            "blue", "The unit of repeat is red-blue.",
                            "EASY", "visual pattern", "red twice", "green", "stop"),
                    rng -> QBuilder.build(rng, "7 = 3 + 4 is true because equals means…",
                            "both sides name the same amount", "Equals is a balance, not 'write the answer'.",
                            "MEDIUM", "skill-check", "always put a bigger number on the right", "the left is a question only", "4 is ignored"),
                    rng -> {
                        int start = QBuilder.range(rng, 1, 5);
                        int step = 2;
                        int next = start + 4 * step;
                        String seq = start + ", " + (start + step) + ", " + (start + 2 * step) + ", " + (start + 3 * step) + ", …";
                        return QBuilder.build(rng, "What is the next number in " + seq + "?", String.valueOf(next),
                                "The pattern adds " + step + " each time.",
                                "EASY", "visual pattern",
                                String.valueOf(next + step), String.valueOf(next - 1), String.valueOf(start * step));
                    }
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    int start = QBuilder.range(rng, 1, 8);
                    int step = QBuilder.range(rng, 2, 5);
                    int next = start + 4 * step;
                    String seq = start + ", " + (start + step) + ", " + (start + 2 * step) + ", " + (start + 3 * step) + ", …";
                    return QBuilder.build(rng, "What is the next number in " + seq + "?", String.valueOf(next),
                            "The pattern adds " + step + " each time.",
                            "EASY", "visual pattern",
                            String.valueOf(next + step), String.valueOf(next - 1), String.valueOf(start * step));
                },
                rng -> {
                    int x = QBuilder.range(rng, 3, 12);
                    int add = QBuilder.range(rng, 2, 9);
                    String prompt = word
                            ? "A mystery box plus " + add + " kiwifruit makes " + (x + add) + ". What is in the box?"
                            : "If n + " + add + " = " + (x + add) + ", what is n?";
                    return QBuilder.build(rng, prompt, String.valueOf(x),
                            "Undo addition by subtracting " + add + ".",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(x + add), String.valueOf(add), String.valueOf(x + 1));
                },
                rng -> {
                    int n = QBuilder.range(rng, 4, 10);
                    int rule = 2 * n + 1;
                    return QBuilder.build(rng, "A rule is 2n + 1. What is the value when n = " + n + "?",
                            String.valueOf(rule), "Multiply n by 2, then add 1.",
                            "MEDIUM", "skill-check",
                            String.valueOf(2 * n), String.valueOf(n + 1), String.valueOf(2 * n - 1));
                }
        };
    }

    private static QuestionTemplate[] mathMeasure(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "Which is longer: a classroom or a pencil?", "A classroom",
                            "Compare the same attribute: length.", "EASY", "skill-check",
                            "A pencil", "They are always the same", "Length cannot be compared"),
                    rng -> {
                        int cm = QBuilder.range(rng, 8, 19);
                        return QBuilder.build(rng, "A crayon is about " + cm + " cm long. Which unit was used?", "centimetres",
                                "cm is a length unit for small objects.", "EASY", "skill-check",
                                "kilograms", "litres", "degrees");
                    },
                    rng -> QBuilder.build(rng, "A full cup holds more than an empty cup. This is comparing…", "capacity",
                            "Capacity is how much a container can hold.", "EASY", "skill-check",
                            "only colour", "only speed", "only time")
            };
        }
        if (year >= 9) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "In a right triangle, opposite / hypotenuse is…",
                            "sin", "SOH: sine = opposite / hypotenuse.",
                            "MEDIUM", "skill-check", "cos", "tan", "area"),
                    rng -> {
                        int r = QBuilder.range(rng, 2, 5);
                        int h = QBuilder.range(rng, 4, 10);
                        return QBuilder.build(rng, word
                                        ? "A water tank is a cylinder, radius " + r + " m, height " + h + " m. Volume formula is…"
                                        : "Volume of a cylinder radius " + r + ", height " + h + " is…",
                                "π × " + r + "² × " + h, "V = πr²h.",
                                "MEDIUM", word ? "word problem" : "skill-check",
                                "2π × " + r + " × " + h, String.valueOf(2 * (r + h)), "π × " + r + " × " + h);
                    },
                    rng -> QBuilder.build(rng, "Adjacent / hypotenuse is…",
                            "cos", "CAH: cosine = adjacent / hypotenuse.",
                            "EASY", "skill-check", "sin", "tan", "πr²")
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    int l = QBuilder.range(rng, 3, 12);
                    int w = QBuilder.range(rng, 2, 10);
                    String prompt = word
                            ? "A garden is " + l + " m long and " + w + " m wide. What is its area in m²?"
                            : "Area of a " + l + " by " + w + " rectangle?";
                    return QBuilder.build(rng, prompt, String.valueOf(l * w),
                            "Area of a rectangle = length × width.",
                            "EASY", word ? "word problem" : "skill-check",
                            String.valueOf(2 * (l + w)), String.valueOf(l + w), String.valueOf(l * w + l));
                },
                rng -> {
                    int l = QBuilder.range(rng, 4, 15);
                    int w = QBuilder.range(rng, 3, 10);
                    String prompt = word
                            ? "Ribbon around a " + l + " cm by " + w + " cm card. What length of ribbon (perimeter)?"
                            : "Perimeter of a " + l + " by " + w + " rectangle?";
                    return QBuilder.build(rng, prompt, String.valueOf(2 * (l + w)),
                            "Perimeter = 2 × (length + width).",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(l * w), String.valueOf(l + w), String.valueOf(2 * l + w));
                },
                rng -> {
                    int m = QBuilder.range(rng, 2, 9);
                    return QBuilder.build(rng, "How many centimetres are in " + m + " metres?",
                            String.valueOf(m * 100), "1 m = 100 cm.",
                            "EASY", "skill-check",
                            String.valueOf(m * 10), String.valueOf(m * 1000), String.valueOf(m + 100));
                },
                rng -> {
                    if (year < 6) {
                        int b = QBuilder.range(rng, 4, 12);
                        int h = QBuilder.range(rng, 2, 10);
                        if (year < 5) {
                            return QBuilder.build(rng, "A right angle measures…", "90°",
                                    "A quarter turn is 90 degrees.", "EASY", "skill-check",
                                    "45°", "180°", "360°");
                        }
                        return QBuilder.build(rng, "Area of a " + b + " cm by " + h + " cm rectangle in cm²?",
                                String.valueOf(b * h), "A = l × w, unit cm².", "MEDIUM", "skill-check",
                                String.valueOf(2 * (b + h)), String.valueOf(b + h), String.valueOf(b * h * 2));
                    }
                    int b = 2 * QBuilder.range(rng, 3, 8);
                    int h = QBuilder.range(rng, 4, 12);
                    int area = b * h / 2;
                    return QBuilder.build(rng, "Area of a right triangle with base " + b + " cm and height " + h + " cm?",
                            String.valueOf(area), "A = ½ × base × height.", "MEDIUM", "skill-check",
                            String.valueOf(b * h), String.valueOf(b + h), String.valueOf(2 * (b + h)));
                },
                rng -> {
                    if (year < 8) {
                        int h = QBuilder.range(rng, 1, 5);
                        int min = QBuilder.pick(rng, 15, 30, 45);
                        return QBuilder.build(rng, h + " hour(s) and " + min + " minutes is how many minutes?",
                                String.valueOf(h * 60 + min), "1 hour = 60 minutes.", "MEDIUM", "skill-check",
                                String.valueOf(h * 100 + min), String.valueOf(h + min), String.valueOf(h * 60));
                    }
                    return QBuilder.build(rng, "In a right triangle the side opposite the right angle is the…",
                            "hypotenuse", "The hypotenuse is the longest side.", "EASY", "skill-check",
                            "adjacent only", "perimeter", "radius");
                }
        };
    }

    private static QuestionTemplate[] mathGeometry(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> {
                    if (year <= 2) {
                        return QBuilder.build(rng, "How many sides does a triangle have?", "3",
                                "A triangle has 3 sides and 3 corners.", "EASY", "skill-check",
                                "4", "2", "8");
                    }
                    if (year <= 4) {
                        return QBuilder.build(rng, "A square rotated on its corner is still a…", "square",
                                "Properties do not change when you turn a shape.", "MEDIUM", "skill-check",
                                "circle", "triangle that lost a side", "not a shape");
                    }
                    return QBuilder.build(rng, "Parallel lines…", "stay the same distance apart and never meet",
                            "Parallel means never meeting, constant distance.", "EASY", "skill-check",
                            "always cross at 90°", "must be curved", "meet at one point only");
                },
                rng -> {
                    if (year <= 3) {
                        return QBuilder.build(rng, "A quarter turn is the same as a…", "right angle / 90° turn",
                                "A quarter of a full turn is 90°.", "EASY", "skill-check",
                                "full circle", "half turn", "no turn");
                    }
                    if (year <= 6) {
                        return QBuilder.build(rng, "A cube has how many faces?", "6",
                                "Six square faces.", "EASY", "skill-check", "4", "8", "12");
                    }
                    return QBuilder.build(rng, "The angles in a triangle add to…", "180°",
                            "Triangle angle sum is 180°.", "EASY", "skill-check", "90°", "360°", "100°");
                },
                rng -> {
                    if (year <= 5) {
                        return QBuilder.build(rng, word
                                        ? "You slide a shape without turning it. That transformation is a…"
                                        : "A slide without turning is a…",
                                "translation", "Translation is a slide. Reflection is a flip. Rotation is a turn.",
                                "MEDIUM", word ? "word problem" : "skill-check",
                                "reflection", "enlargement only", "subtraction");
                    }
                    if (year <= 8) {
                        int a = QBuilder.range(rng, 40, 80);
                        return QBuilder.build(rng, "Two angles on a straight line: one is " + a + "°. The other is?",
                                String.valueOf(180 - a), "Angles on a straight line sum to 180°.",
                                "MEDIUM", "skill-check", String.valueOf(90 - a), String.valueOf(360 - a), String.valueOf(a));
                    }
                    return QBuilder.build(rng, "Similar figures have…", "equal corresponding angles and proportional sides",
                            "Same shape, possibly different size.", "MEDIUM", "skill-check",
                            "always the same size as well", "no equal angles", "only matching colours");
                }
        };
    }

    private static QuestionTemplate[] mathChance(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "The sun will rise tomorrow. In chance language this is…", "certain / will happen",
                            "Some events must happen.", "EASY", "skill-check",
                            "impossible", "never", "a guess with no meaning"),
                    rng -> QBuilder.build(rng, "A cow flying over the field is…", "won't / impossible in ordinary life",
                            "Impossible means it cannot happen.", "EASY", "skill-check",
                            "certain", "even chance", "the same as likely"),
                    rng -> QBuilder.build(rng, "A fair two-colour counter might land red or yellow. Purple is…", "not a possible outcome",
                            "List what the object can actually do.", "MEDIUM", "skill-check",
                            "certain", "the most likely", "the only outcome")
            };
        }
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A fair six-sided die is rolled. What is P(rolling a 4)?",
                        "1/6", "One favourable outcome out of six equally likely faces.",
                        "EASY", "skill-check", "1/4", "4/6", "1/2"),
                rng -> {
                    int fav = QBuilder.range(rng, 1, 4);
                    int tot = QBuilder.range(rng, 6, 10);
                    return QBuilder.build(rng, "A bag has " + tot + " marbles and " + fav + " are red. P(red) = ?",
                            fav + "/" + tot, "Probability = favourable / total.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            tot + "/" + fav, fav + "/" + (tot + 1), "1/" + fav);
                },
                rng -> {
                    if (year < 6) {
                        return QBuilder.build(rng, "On a 0 to 1 chance line, even chance sits at…", "1/2",
                                "Equally likely sits in the middle.", "EASY", "skill-check", "0", "1", "2");
                    }
                    return QBuilder.build(rng, "P(not a 6) on a fair die is…", "5/6",
                            "Complement: 1 − 1/6 = 5/6.", "MEDIUM", "skill-check", "1/6", "6/5", "1");
                },
                rng -> {
                    if (year < 9) {
                        return QBuilder.build(rng, "The probabilities of all disjoint outcomes of a spinner should sum to…", "1",
                                "A complete set of exclusive outcomes covers certainty.", "MEDIUM", "skill-check",
                                "0", "100 only if you ignore fractions", "6");
                    }
                    return QBuilder.build(rng, "Two fair coins. P(both heads) is…", "1/4",
                            "HH is one of four equally likely pairs: HH HT TH TT.", "MEDIUM", "skill-check",
                            "1/2", "1/3", "2/3");
                }
        };
    }

    private static QuestionTemplate[] mathData(int year, boolean word) {
        if (year <= 2) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, word
                                    ? "A class tally: apples 8, bananas 5. Which fruit was more popular?"
                                    : "On a pictogram, the tallest column shows…",
                            word ? "apples" : "the most common category",
                            "The tallest bar or largest tally is the mode (most common).",
                            "EASY", word ? "word problem" : "skill-check",
                            word ? "bananas" : "the rarest category", "a random guess", "the title of the graph"),
                    rng -> QBuilder.build(rng, "A tally of |||| ||| means how many?",
                            "8", "Each | is one. Four in a gate is 5, plus 3 is 8 — or eight ones.",
                            "EASY", "visual pattern", "4", "3", "5"),
                    rng -> QBuilder.build(rng, "A graph needs a title so that…",
                            "readers know what was counted", "Title, labels and a key make data readable.",
                            "MEDIUM", "skill-check", "the numbers can stay secret", "colour is illegal", "tally marks are banned")
            };
        }
        return new QuestionTemplate[]{
                rng -> {
                    if (year <= 4) {
                        return QBuilder.build(rng, word
                                        ? "A survey of favourite sports: rugby 12, netball 9, football 12. What is the mode?"
                                        : "Data 3, 5, 5, 7. The mode is…",
                                word ? "rugby and football (bimodal 12)" : "5",
                                "Mode is the most common value. Two categories can share the mode.",
                                "MEDIUM", word ? "word problem" : "skill-check",
                                word ? "netball" : "3", word ? "football only" : "7", "the mean of all sports");
                    }
                    int x = QBuilder.range(rng, 5, 15);
                    int y = QBuilder.range(rng, 5, 15);
                    int z = 3 * QBuilder.range(rng, 6, 14) - x - y;
                    if (z < 1) {
                        z = x;
                    }
                    int m = (x + y + z) / 3;
                    return QBuilder.build(rng, word
                                    ? "Scores " + x + ", " + y + " and " + z + ". What is the mean?"
                                    : "What is the mean of " + x + ", " + y + " and " + z + "?",
                            String.valueOf(m), "Mean = total ÷ how many numbers.",
                            "MEDIUM", word ? "word problem" : "skill-check",
                            String.valueOf(x + y + z), String.valueOf(Math.max(x, Math.max(y, z))), String.valueOf(m + 1));
                },
                rng -> {
                    int a = 4;
                    int b = 8;
                    int c = 12;
                    int median = b;
                    if (year < 5) {
                        return QBuilder.build(rng, "A bar graph should have…",
                                "a title and labelled axes", "Without labels, the bars have no meaning.",
                                "EASY", "skill-check", "no title ever", "only colours and no numbers", "secret axes");
                    }
                    return QBuilder.build(rng, "For ordered data " + a + ", " + b + ", " + c + ", the median is…",
                            String.valueOf(median), "Median is the middle value when ordered.",
                            "EASY", "skill-check", String.valueOf(a), String.valueOf((a + b + c) / 3), String.valueOf(c - a));
                },
                rng -> {
                    if (year < 6) {
                        return QBuilder.build(rng, "Range of 10, 14 and 18 is…",
                                "8", "Range = largest − smallest = 18 − 10.",
                                "MEDIUM", "skill-check", "14", "42", "10");
                    }
                    if (year < 9) {
                        return QBuilder.build(rng, "A sample of one class cannot prove a claim about…",
                                "every student in Aotearoa", "Samples have limits. State the population you actually measured.",
                                "MEDIUM", "skill-check", "that class's own favourite fruit", "the title of their graph", "how they tallied");
                    }
                    return QBuilder.build(rng, "In a scatter graph, points rising together suggest…",
                            "a positive association", "Bivariate data can show a relationship, not automatically a cause.",
                            "MEDIUM", "skill-check", "that one variable caused the other for sure", "no relationship is possible", "the median of a pie chart");
                }
        };
    }

    private static QuestionTemplate[] reading(int year, boolean word) {
        if (year >= 9) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "A news headline says 'chaos' but the article describes a permitted hīkoi. The headline is mainly…",
                            "positioning the reader before they read the evidence",
                            "Diction in headlines is a design choice, not a neutral summary.",
                            "MEDIUM", "skill-check",
                            "proof that the march was illegal", "a spelling rule", "unrelated to audience"),
                    rng -> QBuilder.build(rng, "Critical reading of media should first ask…",
                            "Who made this, for whom, and what is missing?",
                            "Maker, audience and omission before you quote.",
                            "EASY", "skill-check",
                            "Which font is prettiest?", "Can I skip the date?", "Is this the longest paragraph?"),
                    rng -> QBuilder.build(rng, "A metaphor should be analysed by stating…",
                            "the image and the effect on a reader",
                            "Technique without effect is name-dropping.",
                            "MEDIUM", "skill-check",
                            "only the page number", "that all metaphors are errors", "the author's favourite colour")
            };
        }
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "You read a story once to get the overall idea. What is that first reading for?",
                        "The gist or main idea", "First reading is for overall meaning.",
                        "EASY", "skill-check", "Every tiny detail", "Only the last sentence", "The author's full biography"),
                rng -> QBuilder.build(rng, "Two answers look possible. What should you do?",
                        "Choose the one best supported by the text", "Evidence in the text decides.",
                        "MEDIUM", "skill-check", "Pick the longest answer", "Guess the author's feelings only", "Choose the first option"),
                rng -> QBuilder.build(rng, year <= 3 ? "A retell should include…" : "Inference means…",
                        year <= 3 ? "Who, where and what happened, in order"
                                : "Using clues in the text to work out something not stated directly",
                        year <= 3 ? "Beginning, middle and end keep the listener with you."
                                : "Inference still needs text clues.",
                        "MEDIUM", "skill-check",
                        year <= 3 ? "Only the title in a random order" : "Ignoring the text and using only your opinion",
                        "Copying a sentence word for word", "Reading only the title")
        };
    }

    private static QuestionTemplate[] writing(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A paragraph should usually have…",
                        "One main idea with supporting details", "One idea per paragraph.",
                        "EASY", "skill-check", "As many unrelated ideas as possible", "Only a title and no sentences", "A list of random words"),
                rng -> QBuilder.build(rng, "The best first step before drafting is to…",
                        "Plan your purpose, audience and ideas", "Plan before you write.",
                        "MEDIUM", "skill-check", "Start with the last sentence", "Ignore who will read it", "Copy a friend"),
                rng -> QBuilder.build(rng, "A topic sentence usually…",
                        "States the main point of the paragraph", "It tells the reader the focus.",
                        "EASY", "skill-check", "Is always a question mark only", "Lists every fact in the whole text", "Has no meaning")
        };
    }

    private static QuestionTemplate[] grammar(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Which sentence is punctuated correctly?",
                        "The kiwi is nocturnal.", "A sentence starts with a capital and ends with a full stop.",
                        "EASY", "skill-check", "the kiwi is nocturnal", "The kiwi is nocturnal", "the Kiwi Is nocturnal."),
                rng -> QBuilder.build(rng, "Which sentence is a run-on that should be split or joined properly?",
                        "We went to the beach it was hot.", "Two complete ideas need a full stop, comma+conjunction, or semicolon.",
                        "MEDIUM", "skill-check", "We went to the beach because it was hot.", "It was hot at the beach.", "The beach was hot."),
                rng -> QBuilder.build(rng, "Choose the verb that agrees: She ____ to school.",
                        "walks", "Singular she takes walks.",
                        "EASY", "skill-check", "walk", "walking", "walked to")
        };
    }

    private static QuestionTemplate[] vocab(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "The prefix un- in unhappy most nearly means…",
                        "not", "un- often means not.",
                        "EASY", "skill-check", "again", "full of", "before"),
                rng -> QBuilder.build(rng, "A synonym for enormous is…",
                        "huge", "Synonyms mean nearly the same.",
                        "EASY", "skill-check", "tiny", "slow", "quiet"),
                rng -> QBuilder.build(rng, "You meet an unknown word. A smart first move is to…",
                        "Use the words around it as context clues", "Context + word parts help.",
                        "MEDIUM", "skill-check", "Skip the whole book", "Change the author's name", "Count the letters only")
        };
    }

    private static QuestionTemplate[] oral(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "In a discussion you should…",
                        "Listen to understand, then add a reason", "Turn-taking and reasons matter.",
                        "EASY", "skill-check", "Talk over others", "Ignore everyone", "Only shout"),
                rng -> QBuilder.build(rng, "A respectful opinion sounds like…",
                        "I think… because…", "Opinions need reasons.",
                        "EASY", "skill-check", "I'm right and that's it", "Whatever", "You are wrong, full stop"),
                rng -> QBuilder.build(rng, "When presenting, it helps to…",
                        "Speak clearly and pause at the end of ideas", "Voice and pace help listeners.",
                        "MEDIUM", "skill-check", "Mumble at the floor", "Read so fast nobody can follow", "Never look up")
        };
    }

    private static QuestionTemplate[] investigate(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "In a fair test you should change…",
                        "Only one variable at a time", "Keep everything else the same.",
                        "EASY", "skill-check", "Every variable at once", "Nothing at all, ever", "The conclusion before you start"),
                rng -> QBuilder.build(rng, "A conclusion should be based on…",
                        "The evidence you collected", "Evidence first.",
                        "EASY", "skill-check", "A guess with no data", "What your friend hoped", "The longest word you know"),
                rng -> QBuilder.build(rng, "Which is a testable question?",
                        "Does plant A grow taller than plant B in the same light?", "Testable questions can be measured.",
                        "MEDIUM", "skill-check", "Are plants nicer than rocks?", "Is science cool?", "Should we like plants?")
        };
    }

    private static QuestionTemplate[] living(int year, boolean word) {
        if (year >= 7) {
            return new QuestionTemplate[]{
                    rng -> QBuilder.build(rng, "Cells are…",
                            "the basic units of living things", "Tissue is made of cells; organs of tissues.",
                            "EASY", "skill-check", "only found in rocks", "the same as atoms", "a type of weather"),
                    rng -> QBuilder.build(rng, "Natural selection acts on…",
                            "variation already present in a population",
                            "Traits that help survival and reproduction become more common over generations.",
                            "MEDIUM", "skill-check",
                            "a single animal choosing to grow a new organ in one afternoon",
                            "only the colour of the sky", "the days of the week"),
                    rng -> QBuilder.build(rng, "A food web in an Aotearoa forest is mainly about…",
                            "feeding relationships and energy flow", "Arrows usually point to the eater / energy receiver as taught.",
                            "EASY", "skill-check", "only the names of minerals", "map north", "the school timetable")
            };
        }
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A food chain shows…",
                        "How energy and food pass from one living thing to another", "Eating relationships.",
                        "EASY", "skill-check", "Only the names of rocks", "The days of the week", "Map directions"),
                rng -> QBuilder.build(rng, "An adaptation is…",
                        "A feature that helps a living thing survive in its habitat", "Helps survival.",
                        "MEDIUM", "skill-check", "A random decoration with no use", "Always a human-made tool", "The same as a fossil"),
                rng -> QBuilder.build(rng, "Kiwi are nocturnal. That means they are mainly active…",
                        "At night", "Nocturnal = night-active.",
                        "EASY", "skill-check", "Only at midday", "Never", "Underwater all day")
        };
    }

    private static QuestionTemplate[] matter(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Ice melting into water is…",
                        "A reversible change of state", "Melting can be reversed by freezing.",
                        "EASY", "skill-check", "An irreversible burning", "A living process", "A type of force"),
                rng -> QBuilder.build(rng, "In a gas, particles…",
                        "Move freely and are far apart", "Gases fill their container.",
                        "MEDIUM", "skill-check", "Are locked in a rigid pattern", "Do not exist", "Are always ice"),
                rng -> QBuilder.build(rng, "Which change is not easily reversed?",
                        "Burning toast", "Burning makes new substances.",
                        "MEDIUM", "skill-check", "Freezing water", "Melting chocolate", "Condensing steam")
        };
    }

    private static QuestionTemplate[] forces(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Gravity on Earth pulls objects…",
                        "Towards the centre of Earth", "Down toward Earth.",
                        "EASY", "skill-check", "Only sideways", "Into space automatically", "Randomly"),
                rng -> QBuilder.build(rng, "Friction usually…",
                        "Resists movement between surfaces", "Rough surfaces, more friction.",
                        "EASY", "skill-check", "Creates extra gravity", "Stops light from travelling", "Makes objects weightless"),
                rng -> QBuilder.build(rng, "A push and a pull are both…",
                        "Forces", "Forces change motion.",
                        "EASY", "skill-check", "Types of colour", "States of matter", "Map symbols")
        };
    }

    private static QuestionTemplate[] earth(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Day and night are caused mainly by…",
                        "Earth rotating on its axis", "One side faces the Sun.",
                        "EASY", "skill-check", "The Moon turning off the Sun", "Clouds covering the whole planet every night", "Earth moving closer then farther each hour"),
                rng -> QBuilder.build(rng, "Seasons are most strongly linked to…",
                        "Earth's tilt as it orbits the Sun", "Tilt, not just distance.",
                        "MEDIUM", "skill-check", "The number of rivers", "How many people wear jumpers", "Earth stopping once a year"),
                rng -> QBuilder.build(rng, "A thermometer is used to measure…",
                        "Temperature", "Weather variable.",
                        "EASY", "skill-check", "Wind direction only", "Earthquake depth", "The time of high tide only")
        };
    }

    private static QuestionTemplate[] identity(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A pepeha often includes…",
                        "Connections to people and places such as maunga and awa", "Identity in place and people.",
                        "EASY", "skill-check", "Only a favourite colour", "A bank PIN", "A sports score"),
                rng -> QBuilder.build(rng, "Culture is…",
                        "Lived practices, languages and values of a group of people", "Everyday, not only festivals.",
                        "MEDIUM", "skill-check", "Only food on holidays", "The same as climate", "A type of map"),
                rng -> QBuilder.build(rng, "Respecting someone's identity includes…",
                        "Using their correct name and listening to their story", "Names and listening matter.",
                        "EASY", "skill-check", "Ignoring them", "Changing their name without asking", "Speaking over them")
        };
    }

    private static QuestionTemplate[] place(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "On a map, a key (legend) tells you…",
                        "What the symbols mean", "Always read the key.",
                        "EASY", "skill-check", "The author's favourite book", "Tomorrow's lunch", "Who won a game"),
                rng -> QBuilder.build(rng, "A natural feature is…",
                        "A mountain, river or forest", "Not human-built.",
                        "EASY", "skill-check", "A motorway", "A shopping mall", "A rugby stadium"),
                rng -> QBuilder.build(rng, "Aotearoa New Zealand has a very long…",
                        "Coastline", "Islands in the Pacific.",
                        "MEDIUM", "skill-check", "Sahara desert border", "Land border with Brazil", "Underground subway in every town")
        };
    }

    private static QuestionTemplate[] history(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "The Treaty of Waitangi was first signed in…",
                        "1840", "A founding document of NZ.",
                        "MEDIUM", "skill-check", "2010", "1066", "1770 only in Australia"),
                rng -> QBuilder.build(rng, "A good historian asks…",
                        "Whose voice is in this source, and whose is missing?", "Sources are partial.",
                        "MEDIUM", "skill-check", "Is this the longest paragraph?", "What colour is the page?", "Can I skip evidence?"),
                rng -> QBuilder.build(rng, "Putting events in time order is called…",
                        "Sequencing (chronology)", "Then and now.",
                        "EASY", "skill-check", "Rhyming", "Measuring mass", "Coding")
        };
    }

    private static QuestionTemplate[] economy(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A need is something…",
                        "You must have to live, like food or shelter", "Needs vs wants.",
                        "EASY", "skill-check", "You want for fun only", "That is always a video game", "That cannot be used"),
                rng -> QBuilder.build(rng, "A producer is someone who…",
                        "Makes or grows goods or provides a service", "Producer → consumer.",
                        "EASY", "skill-check", "Only watches TV", "Hides resources", "Never works"),
                rng -> QBuilder.build(rng, "Using a resource carefully because it can run out is part of…",
                        "Sustainability", "People and planet.",
                        "MEDIUM", "skill-check", "Ignoring waste", "Using everything as fast as possible", "Never sharing ideas")
        };
    }

    private static QuestionTemplate[] civics(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A fair classroom rule should…",
                        "Help people stay safe and be able to learn", "Rules have purposes.",
                        "EASY", "skill-check", "Help only one person", "Be a secret", "Change every minute with no reason"),
                rng -> QBuilder.build(rng, "A citizen can participate by…",
                        "Voting, volunteering or speaking up about an issue", "Participation.",
                        "MEDIUM", "skill-check", "Never noticing problems", "Breaking rules for fun", "Hiding from the community"),
                rng -> QBuilder.build(rng, "Rights work best when people also accept…",
                        "Responsibilities to others", "Rights + responsibilities.",
                        "EASY", "skill-check", "No duties at all", "Only their own wishes", "Silence forever")
        };
    }

    private static QuestionTemplate[] design(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A design brief should name…",
                        "The user and the problem to solve", "Start with people.",
                        "EASY", "skill-check", "Only the colours you like", "A random object with no purpose", "The longest word"),
                rng -> QBuilder.build(rng, "Improving a design after testing is called…",
                        "Iteration", "First idea is rarely best.",
                        "MEDIUM", "skill-check", "Giving up", "Copying without thinking", "Hiding the brief"),
                rng -> QBuilder.build(rng, "Why sketch more than one idea?",
                        "So you can compare and choose a better fit for the user", "Options help.",
                        "EASY", "skill-check", "To waste paper only", "Because one idea is illegal", "Sketches are never useful")
        };
    }

    private static QuestionTemplate[] digital(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "An algorithm is…",
                        "A clear sequence of steps to complete a task", "Step-by-step.",
                        "EASY", "skill-check", "A type of fruit", "A random guess", "A musical instrument"),
                rng -> QBuilder.build(rng, "A kind digital citizen would…",
                        "Be respectful and protect personal information", "Safety and kindness.",
                        "EASY", "skill-check", "Share a classmate's password", "Post unkind comments", "Click every unknown link"),
                rng -> QBuilder.build(rng, "Computers follow instructions…",
                        "Exactly as written, even if there is a mistake", "Be precise.",
                        "MEDIUM", "skill-check", "By reading minds", "Only on Tuesdays", "By ignoring bugs")
        };
    }

    private static QuestionTemplate[] making(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "You need a waterproof cover. A sensible material is…",
                        "Plastic or coated fabric", "Match property to purpose.",
                        "EASY", "skill-check", "Tissue paper", "Open weave cotton only", "Dry sand"),
                rng -> QBuilder.build(rng, "A prototype is…",
                        "An early model made to test and learn", "Learning object.",
                        "MEDIUM", "skill-check", "The final unused idea", "A rule you must never change", "A type of graph"),
                rng -> QBuilder.build(rng, "A safe making habit is…",
                        "Use tools as taught and tidy the workspace", "Safety first.",
                        "EASY", "skill-check", "Run with scissors", "Leave spills", "Ignore instructions")
        };
    }

    private static QuestionTemplate[] compute(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "In a system, flour, mixing and a cake are examples of…",
                        "Input, process and output", "IPO model.",
                        "EASY", "skill-check", "Three random nouns", "Only outputs", "Only inputs"),
                rng -> QBuilder.build(rng, "When code does not work, you should…",
                        "Find the bug and change one thing at a time", "Debug patiently.",
                        "MEDIUM", "skill-check", "Rewrite everything at once with no test", "Blame the computer's feelings", "Delete the brief"),
                rng -> QBuilder.build(rng, "Breaking a big task into smaller steps is…",
                        "Decomposition", "A computational thinking skill.",
                        "MEDIUM", "skill-check", "Ignoring the task", "Memorising a poem only", "Painting")
        };
    }

    private static QuestionTemplate[] evaluate(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "To judge a product you should first…",
                        "Re-read the brief and success criteria", "Fit for purpose.",
                        "EASY", "skill-check", "Only check if it looks fashionable", "Ask a stranger's favourite colour", "Ignore the user"),
                rng -> QBuilder.build(rng, "A useful evaluation names…",
                        "One strength and one next improvement", "Specific feedback.",
                        "MEDIUM", "skill-check", "Nothing at all", "Only insults", "A random number"),
                rng -> QBuilder.build(rng, "If a latch is too fiddly for Year 2 hands, it fails because it is not…",
                        "Fit for the intended user", "Users matter.",
                        "MEDIUM", "skill-check", "Painted gold", "Heavy enough", "From a famous brand")
        };
    }

    private static QuestionTemplate[] visual(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Line, colour, shape and texture are…",
                        "Visual art elements", "Building blocks of art.",
                        "EASY", "skill-check", "Types of sport", "Map directions", "Only used in maths"),
                rng -> QBuilder.build(rng, "Warm colours include…",
                        "Red, orange and yellow", "Warm vs cool.",
                        "EASY", "skill-check", "Only black", "Blue and green only", "Transparent water"),
                rng -> QBuilder.build(rng, "Before saying you like an artwork, first…",
                        "Describe what you notice", "Look carefully.",
                        "MEDIUM", "skill-check", "Cover your eyes", "Change the artist's name", "Count to 1000")
        };
    }

    private static QuestionTemplate[] music(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "The steady pulse you can tap along to is the…",
                        "Beat", "Heartbeat of the music.",
                        "EASY", "skill-check", "Lyrics only", "Costume", "Stage light"),
                rng -> QBuilder.build(rng, "Pitch is about whether a sound is…",
                        "High or low", "High/low.",
                        "EASY", "skill-check", "Only loud", "Only slow", "A colour"),
                rng -> QBuilder.build(rng, "Dynamics describe…",
                        "How loud or soft the music is", "Volume.",
                        "MEDIUM", "skill-check", "The composer's age", "The colour of the piano", "The room number")
        };
    }

    private static QuestionTemplate[] drama(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Staying in role means…",
                        "Keeping the character's voice and actions until the scene ends", "Commit to the scene.",
                        "EASY", "skill-check", "Checking your phone mid-scene", "Telling jokes as yourself only", "Leaving the space"),
                rng -> QBuilder.build(rng, "A shy character might use…",
                        "Smaller movements and a quieter voice", "Body and voice show character.",
                        "MEDIUM", "skill-check", "Always shouting", "No face at all", "Standing still forever with no choice"),
                rng -> QBuilder.build(rng, "'Yes, and…' in drama means…",
                        "Accept a partner's idea and add to it", "Build together.",
                        "EASY", "skill-check", "Say no to every idea", "Ignore your partner", "Only copy film credits")
        };
    }

    private static QuestionTemplate[] dance(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A dance motif is…",
                        "A movement idea you can repeat and vary", "Theme movement.",
                        "MEDIUM", "skill-check", "A type of shoe only", "The audience count", "A frozen lunch"),
                rng -> QBuilder.build(rng, "Changing from a low shape to a high jump is a change of…",
                        "Level", "Low, middle, high.",
                        "EASY", "skill-check", "Colour", "Spelling", "Temperature"),
                rng -> QBuilder.build(rng, "Safe dancing includes…",
                        "Control, space awareness and soft landings", "Look after bodies.",
                        "EASY", "skill-check", "Pushing others", "Landing locked-kneed from a height", "Closing your eyes and sprinting")
        };
    }

    private static QuestionTemplate[] respond(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A strong arts response starts with…",
                        "What you notice (see or hear)", "Describe first.",
                        "EASY", "skill-check", "An insult", "Changing the work secretly", "Silence only"),
                rng -> QBuilder.build(rng, "Kind, useful feedback is…",
                        "Specific and respectful, with a next step", "Because…",
                        "MEDIUM", "skill-check", "Only 'I like it' with no reason", "Rude and vague", "Copied from a random website"),
                rng -> QBuilder.build(rng, "Connecting an artwork to a feeling should still mention…",
                        "A detail in the work that led you there", "Evidence.",
                        "MEDIUM", "skill-check", "Nothing from the work", "Only the weather outside", "A secret code")
        };
    }

    private static QuestionTemplate[] move(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A useful catching cue is…",
                        "Eyes on the ball and hands ready", "One cue at a time.",
                        "EASY", "skill-check", "Look at the sky only", "Hands in pockets", "Turn your back"),
                rng -> QBuilder.build(rng, "Locomotor skills include…",
                        "Running, jumping and skipping", "Moving from place to place.",
                        "EASY", "skill-check", "Only sitting", "Sleeping", "Holding your breath"),
                rng -> QBuilder.build(rng, "Fair play means…",
                        "Including others and following agreed rules", "Everyone can join in.",
                        "EASY", "skill-check", "Cheating to win", "Leaving people out", "Arguing with the referee always")
        };
    }

    private static QuestionTemplate[] hauora(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Taha tinana refers to…",
                        "Physical wellbeing (the body)", "Four taha of hauora.",
                        "EASY", "skill-check", "Only money", "Map drawing", "Spelling tests only"),
                rng -> QBuilder.build(rng, "Taha whānau is about…",
                        "Relationships and belonging with others", "Family/social.",
                        "EASY", "skill-check", "Only isolated exercise", "Ignoring friends", "The colour blue"),
                rng -> QBuilder.build(rng, "Hauora is best described as…",
                        "A whole view of wellbeing, not only 'not being sick'", "Holistic.",
                        "MEDIUM", "skill-check", "A type of ball sport only", "A maths formula", "A computer brand")
        };
    }

    private static QuestionTemplate[] relate(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "An I-statement sounds like…",
                        "I felt left out when the game started without me", "Feelings + situation.",
                        "EASY", "skill-check", "You're mean", "Whatever", "I win"),
                rng -> QBuilder.build(rng, "Consent means…",
                        "A clear yes that can also be withdrawn", "Ask first. Stop if no.",
                        "MEDIUM", "skill-check", "Guessing someone agrees", "Never asking", "Ignoring a no"),
                rng -> QBuilder.build(rng, "If a problem feels too big you should…",
                        "Talk to a trusted adult", "Help-seeking.",
                        "EASY", "skill-check", "Keep it a forever secret no matter what", "Post it to strangers only", "Blame yourself in silence")
        };
    }

    private static QuestionTemplate[] safety(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "At the beach you should swim…",
                        "Between the flags, and never alone", "Water safety.",
                        "EASY", "skill-check", "As far as you like with no plan", "In a rip on purpose", "At night with no adults"),
                rng -> QBuilder.build(rng, "In an emergency in New Zealand you can call…",
                        "111", "Get help fast.",
                        "EASY", "skill-check", "000 only (that's another country)", "123456", "The weather channel"),
                rng -> QBuilder.build(rng, "Online, a safer choice is to…",
                        "Keep personal details private and tell an adult about unkind contact", "Digital safety.",
                        "MEDIUM", "skill-check", "Share your address with strangers", "Click every pop-up", "Use a friend's password")
        };
    }

    private static QuestionTemplate[] community(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A buddy bench is an example of…",
                        "A small design that helps people belong", "Inclusive community.",
                        "EASY", "skill-check", "A type of maths test", "A punishment", "A secret code"),
                rng -> QBuilder.build(rng, "An inclusive game change might be…",
                        "Adjusting rules so more people can take part", "Everyone can play.",
                        "MEDIUM", "skill-check", "Removing anyone who is new", "Making the game secret", "Only the fastest may play"),
                rng -> QBuilder.build(rng, "Personal choices can affect a community when…",
                        "Lots of people do the same thing, like recycling or including others", "Collective effect.",
                        "MEDIUM", "skill-check", "Nothing anyone does ever matters", "Only famous people matter", "Communities have no people")
        };
    }

    private static QuestionTemplate[] greetings(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A friendly everyday hello in te reo Māori is…",
                        "Kia ora", "Common greeting.",
                        "EASY", "skill-check", "Goodbye only", "Tekau", "Whero"),
                rng -> QBuilder.build(rng, "Tēnā koe is typically used to greet…",
                        "One person", "Koe = you (singular).",
                        "MEDIUM", "skill-check", "A sports team of 15 all at once as the only form", "A mountain", "A number"),
                rng -> QBuilder.build(rng, "Tēnā koutou greets…",
                        "A group of people", "Koutou = you plural.",
                        "MEDIUM", "skill-check", "Only one baby", "A colour", "The number two")
        };
    }

    private static QuestionTemplate[] words(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Rua means…",
                        "Two", "tahi 1, rua 2, toru 3.",
                        "EASY", "skill-check", "Ten", "Red", "Water"),
                rng -> QBuilder.build(rng, "Whero is a colour meaning…",
                        "Red", "whero red, kōwhai yellow, kikorangi blue.",
                        "EASY", "skill-check", "Seven", "Family", "Food"),
                rng -> QBuilder.build(rng, "Whānau most nearly means…",
                        "Family / extended family", "People you belong with.",
                        "EASY", "skill-check", "A type of rock", "The number eight", "A bus ticket"),
                rng -> QBuilder.build(rng, "Kai means…",
                        "Food", "Everyday vocab.",
                        "EASY", "skill-check", "Shoe", "Cloud", "Five")
        };
    }

    private static QuestionTemplate[] listen(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Kei te pēhea koe? is asking…",
                        "How are you?", "Common exchange.",
                        "EASY", "skill-check", "What time is it?", "Where is the bus?", "How old is the mountain?"),
                rng -> QBuilder.build(rng, "A useful reply to Kei te pēhea koe? is…",
                        "Kei te pai", "I'm good / I'm well.",
                        "EASY", "skill-check", "Tekau anake", "Whero whero", "111"),
                rng -> QBuilder.build(rng, "When you are learning to speak, a smart strategy is to…",
                        "Copy a model sentence and change one word", "Scaffold speaking.",
                        "MEDIUM", "skill-check", "Never speak until perfect", "Use only English forever", "Skip listening")
        };
    }

    private static QuestionTemplate[] readLang(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "A classroom label 'tēpu' on a table helps you…",
                        "Connect a written word to a real object", "Print + meaning.",
                        "EASY", "skill-check", "Solve a quadratic", "Measure rainfall", "Skip reading"),
                rng -> QBuilder.build(rng, "If you do not know every word in a short text you should…",
                        "Use pictures and known words to get the gist", "Gist first.",
                        "MEDIUM", "skill-check", "Give up immediately", "Cover the pictures", "Translate the page numbers only"),
                rng -> QBuilder.build(rng, "Reading a bilingual book can help because…",
                        "You can check meaning in the language you know", "Dual language support.",
                        "EASY", "skill-check", "It removes all pictures forever", "It hides the story", "It is only for maths")
        };
    }

    private static QuestionTemplate[] tikanga(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> QBuilder.build(rng, "Tikanga is best described as…",
                        "Correct cultural practices and protocols", "The right way of doing things in a Māori context.",
                        "MEDIUM", "skill-check", "A type of fraction", "A computer error", "A sports score"),
                rng -> QBuilder.build(rng, "Manaakitanga is about…",
                        "Care, hospitality and looking after people", "Kindness in action.",
                        "EASY", "skill-check", "Ignoring guests", "Winning an argument", "Measuring area"),
                rng -> QBuilder.build(rng, "Using te reo Māori respectfully means…",
                        "Taking care with pronunciation and not using it as a joke", "Language and people together.",
                        "MEDIUM", "skill-check", "Making fun of words", "Never learning any words", "Mixing it with passwords")
        };
    }
}
