package com.gremath.curriculum.lessons;

import com.gremath.curriculum.LessonExtras;
import com.gremath.curriculum.LessonHtml;
import com.gremath.curriculum.MathFigures;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Year-by-year Mathematics and Statistics lessons aligned to the NZC 2025 teaching sequence
 * (Number, Algebra, Measurement, Geometry, Statistics, Probability, plus operations and rational number).
 */
public final class NzMathLessons {

    private NzMathLessons() {
    }

    public static List<NzLessonSpec> forYear(int year) {
        if (year == 7) {
            return year7Sequence();
        }
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, 1, title(NUMBER_T, year), "Number | Tau", "NUMBER", number(year), stratNumber(year)));
        out.add(spec(year, 2, title(OPS_T, year), "Number · operations", "OPS", operations(year), stratOps(year)));
        out.add(spec(year, 3, title(FDP_T, year), "Number · rational numbers", "FRACTION", fdp(year), stratFdp(year)));
        out.add(spec(year, 4, title(ALG_T, year), "Algebra | Taurangi", "ALGEBRA", algebra(year), stratAlg(year)));
        out.add(spec(year, 5, title(MEAS_T, year), "Measurement | Ine", "MEASURE", measure(year), stratMeas(year)));
        out.add(spec(year, 6, title(GEO_T, year), "Geometry | Āhuahanga", "GEOMETRY", geometry(year), stratGeo(year)));
        out.add(spec(year, 7, title(DATA_T, year), "Statistics | Tauanga", "DATA", statistics(year), stratData(year)));
        out.add(spec(year, 8, title(CHANCE_T, year), "Probability | Tūponotanga", "CHANCE", chance(year), stratChance(year)));
        return out;
    }

    /** Phase 3 Year 7 keeps the eight NZC topics that already have rich practice banks. */
    private static List<NzLessonSpec> year7Sequence() {
        int year = 7;
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, 1, "Place value, exponents and square roots", "Number | Tau", "NUMBER", number(7), stratNumber(7)));
        out.add(spec(year, 2, "Primes, HCF, LCM and divisibility", "Number | Tau", "PRIME", primesYear7(), stratNumber(7)));
        out.add(spec(year, 3, "Integers and order of operations (GEMA)", "Number · operations", "OPS", operations(7), stratOps(7)));
        out.add(spec(year, 4, "Fractions, decimals, percentages and financial maths", "Number · rational numbers", "FRACTION", fdp(7), stratFdp(7)));
        out.add(spec(year, 5, "Algebra: equations, like terms and linear graphs", "Algebra | Taurangi", "ALGEBRA", algebra(7), stratAlg(7)));
        out.add(spec(year, 6, "Measurement: perimeter, area, volume and duration", "Measurement | Ine", "MEASURE", measure(7), stratMeas(7)));
        out.add(spec(year, 7, "Geometry: triangles, angles and transformations", "Geometry | Āhuahanga", "GEOMETRY", geometry(7), stratGeo(7)));
        out.add(spec(year, 8, "Statistics and probability", "Statistics & Probability", "CHANCE",
                statistics(7) + chance(7), LessonHtml.strategy("statistics and probability",
                        new String[]{"For data: title, variable, display, conclude with a limitation.",
                                "For chance: list the sample space, then favourable ÷ total.",
                                "Use a complement 1 − P(A) when 'not A' is quicker.",
                                "Say whether a probability is theoretical or experimental."},
                        "claiming a whole population from one class, or treating experimental frequency as a promise")));
        return out;
    }

    private static String primesYear7() {
        return LessonHtml.teach(LessonHtml.phaseLabel(7), "Number | Tau",
                new String[]{"Know that whole numbers greater than 1 are prime or composite; 1 is neither.",
                        "Use divisibility tests for 2, 3, 4, 5, 6, 8, 9 and 10.",
                        "Find HCF of two numbers under 100 and LCM of two numbers under 10 (and beyond with primes)."},
                LessonHtml.p("A prime number has exactly two distinct factors: 1 and itself. 2 is the only even prime. A composite number has more than two factors. 1 is neither prime nor composite.")
                        + LessonHtml.p("Highest common factor (HCF) is the largest whole number that divides both numbers. Least common multiple (LCM) is the smallest number that both divide. Prime factorisation makes both systematic: take lowest powers for HCF and highest powers for LCM.")
                        + LessonHtml.p("Divisibility rules: even → 2; last digit 0 or 5 → 5; last digit 0 → 10; digit sum ÷3 → 3; digit sum ÷9 → 9; last two digits ÷4 → 4; ÷2 and ÷3 → 6; last three digits ÷8 is a useful 8-test."),
                "Bus-route numbers, jersey numbers and school roll groups are everyday integers you can classify as prime or composite — a habit, not a party trick.",
                new String[]{"Test small primes in order (2, 3, 5, 7…) up to the square root.",
                        "Write each number as a product of primes with exponents.",
                        "HCF: shared primes with the smaller exponents. LCM: all primes with the larger exponents.",
                        "Check by multiplying the factors back."},
                "Is 51 prime?",
                MathFigures.factorTree(51, 3, 17, "A factor tree splits 51 until both branches are prime.")
                        + "<p>Digit sum 6 is divisible by 3, so 51 = 3 × 17. Composite — not prime.</p>",
                "HCF and LCM of 12 and 18",
                "12 = 2²×3, 18 = 2×3². HCF = 2×3 = 6. LCM = 2²×3² = 36. Check: 6 divides both; 36 is a multiple of both.",
                LessonHtml.table(new String[]{"Rule", "Test"},
                        new String[][]{{"÷2", "last digit even"}, {"÷3", "digit sum ÷3"}, {"÷4", "last two digits ÷4"}, {"÷5", "ends in 0 or 5"}, {"÷9", "digit sum ÷9"}}),
                "Listing 9 or 15 as prime because they are odd. Odd does not mean prime.",
                "Keep a tidy factor tree (or repeated division table) so exponents are not lost.",
                "Primes, divisibility, HCF and LCM — the engine room for fractions next.",
                "prime, composite, HCF, LCM, divisible, factor tree");
    }

    private static final String[] NUMBER_T = {
            "",
            "Counting, numerals and numbers to 20",
            "Place value to 100: tens and ones",
            "Place value to 1,000 and grouping by tens and hundreds",
            "Numbers to 10,000, rounding and zero as a placeholder",
            "Numbers to 1,000,000, factors and place-value rounding",
            "Any whole number, negatives, squares and cubes",
            "Powers of 10, primes, HCF and LCM",
            "Integers, prime factors and negative powers of 10",
            "Index laws, standard form and surds",
            "Number fluency for algebra, finance and measurement"
    };
    private static final String[] OPS_T = {
            "",
            "Joining and separating: addition and subtraction to 10",
            "Addition and subtraction facts to 20, then to 100",
            "Adding and subtracting to 1,000 and equal groups",
            "Multiplication and division facts, and remainders as whole numbers",
            "Larger products, remainders and written algorithms",
            "Order of operations; remainders as fractions or decimals",
            "Integers, GEMA and division by one- or two-digit numbers",
            "Directed numbers, discounts and proportional change",
            "Scientific notation, estimation and multi-step number",
            "Financial maths, GST, rates and compound number problems"
    };
    private static final String[] FDP_T = {
            "",
            "Halves, equal shares and fair grouping",
            "Halves and quarters of shapes, lengths and sets",
            "Halves, thirds and quarters — numerator and denominator",
            "Equivalent fractions, mixed numbers and tenths",
            "Hundredths, percentages and related denominators",
            "Thousandths, FDP fluency and finding the whole",
            "Operating with fractions, decimals, percentages and simple ratios",
            "Ratio, rates and dividing a quantity in a given ratio",
            "Recurring decimals, percentage change and reverse percentages",
            "Proportional reasoning in compound and financial contexts"
    };
    private static final String[] ALG_T = {
            "",
            "Repeating patterns and the meaning of equals",
            "The unit of repeat and missing numbers",
            "Growing patterns and true or false number sentences",
            "Constant change, tables and describing a rule",
            "Rules, inequalities and plotting in the first quadrant",
            "Tables of values, coordinates and linear n-rules",
            "Variables, like terms and one- and two-step equations",
            "Linear equations, inequalities and straight-line graphs",
            "Simultaneous linear equations and rearrangement",
            "Quadratic expressions, factorising and simple parabolas"
    };
    private static final String[] MEAS_T = {
            "",
            "Comparing length, mass and capacity",
            "Informal units, then centimetres, grams and millilitres",
            "Metres, kilograms, litres and perimeter",
            "Area of rectangles, mixed units and time to the minute",
            "Metric prefixes, volume of cuboids and classifying angles",
            "Right triangles, cubic units, timetables and elapsed time",
            "Compound area, circumference beginning and duration",
            "Pythagoras in right triangles and 3-D measurement",
            "Right-triangle trigonometry (SOH CAH TOA)",
            "Surface area and volume of prisms and cylinders"
    };
    private static final String[] GEO_T = {
            "",
            "Shapes around us: sides, corners and everyday 3-D objects",
            "2-D and 3-D shapes, turns and position language",
            "Polygons, quarter turns and simple maps",
            "Regular polygons, symmetry, reflection and grid references",
            "Prisms, parallel and perpendicular lines, nets and compass points",
            "Triangles, quadrilaterals, tessellation and two-step transformations",
            "Angle facts, triangle sum and transformations on a grid",
            "Congruence, similarity and geometric reasoning",
            "Similar figures, scale drawings and bearings",
            "Deductive habits, circle language and loci ideas"
    };
    private static final String[] DATA_T = {
            "",
            "Sorting, tallying and talking about a collection",
            "Pictographs and simple tables",
            "Bar graphs and reading a scale",
            "Dot plots, discrete data and a statistical question",
            "Continuous data, clustered bars and paired categories",
            "Mean, range, time-series graphs and choosing a display",
            "The investigative cycle: question, collect, display, conclude",
            "Median, mode, samples and comparing distributions",
            "Box plots, scatter graphs and informal inference",
            "Evaluating claims, outliers and bivariate relationships"
    };
    private static final String[] CHANCE_T = {
            "",
            "Might, will and won't — talking about what could happen",
            "Impossible, unlikely, even chance, likely, certain",
            "Listing outcomes of simple games",
            "Likelihood on a 0-to-1 number line",
            "Sample space and equally likely outcomes",
            "Theoretical probability and checking the sum is 1",
            "Experimental versus theoretical probability",
            "Two-way tables and combined events",
            "Tree diagrams and independent events",
            "Conditional language and relative frequency"
    };

    private static String title(String[] titles, int year) {
        return titles[year];
    }

    private static NzLessonSpec spec(int year, int order, String title, String strand, String kind,
                                     String html, String strategy) {
        if (html != null && !html.contains("<svg")) {
            html = insertFigure(html, figureFor(year, kind));
        }
        html = LessonExtras.apply(year, kind, html);
        return new NzLessonSpec(order, order + ". " + title, strand, html,
                practiceKey(year, order), strategy, kind);
    }

    private static String insertFigure(String html, String figure) {
        if (figure == null || figure.isBlank()) {
            return html;
        }
        String marker = "<h3>How to work it out</h3>";
        int i = html.indexOf(marker);
        if (i >= 0) {
            return html.substring(0, i) + figure + html.substring(i);
        }
        return html + figure;
    }

    private static String figureFor(int year, String kind) {
        return switch (kind) {
            case "PRIME" -> MathFigures.factorTree(51, 3, 17, "A factor tree splits 51 until both branches are prime.");
            case "NUMBER" -> year <= 3
                    ? MathFigures.numberLine(0, year == 1 ? 20 : 20, year == 1 ? 12 : 15,
                    year == 1 ? "Numbers grow to the right. 12 sits past 8."
                            : "A number line shows order. Further right is larger.")
                    : year <= 6
                    ? MathFigures.placeValueChart(year, (year * 2) % 10, 4, 7,
                    "Each house is worth ten times the house on its right.")
                    : MathFigures.integerJump(3, -7, "Integers: adding a negative is a jump left.");
            case "OPS" -> year <= 4
                    ? MathFigures.array(Math.min(year + 1, 5), 4, "Equal rows are multiplication. Count the array.")
                    : MathFigures.integerJump(2, year >= 7 ? -6 : 5,
                    year >= 7 ? "Directed jumps: left for negatives, right for positives."
                            : "Count on in equal jumps. The landing points are multiples.");
            case "FRACTION" -> MathFigures.fractionBar(year <= 2 ? 1 : 2, year <= 2 ? 2 : 4,
                    year <= 2 ? "A half is one of two matching parts."
                            : "Shaded parts over equal parts — that is the fraction.");
            case "ALGEBRA" -> year <= 4
                    ? MathFigures.numberLine(0, 12, 8, "A missing number keeps both sides of = in balance.")
                    : MathFigures.coordinatePoint(2, Math.min(year - 2, 8),
                    "Ordered pair: along the x-axis first, then up.");
            case "MEASURE" -> measureFigure(year);
            case "GEOMETRY" -> MathFigures.triangleAngles(year <= 3 ? 60 : 70, year <= 3 ? 60 : 50, "?",
                    "Do not trust the sketch. Use a named fact (triangle sum is 180°).");
            case "DATA" -> MathFigures.barChart("Class votes",
                    new String[]{"A", "B", "C"}, new int[]{6, 4, 2});
            case "CHANCE" -> MathFigures.spinner(new String[]{"R", "B", "G", "Y"}, 0,
                    "Equal sectors: each colour has the same chance if the spinner is fair.");
            default -> MathFigures.numberLine(0, 10, 5, "A picture of the idea before the numbers.");
        };
    }

    public static String practiceKey(int year, int order) {
        if (year == 6) {
            return switch (order) {
                case 1 -> "c6nz-place-value";
                case 2 -> "c6nz-operations";
                case 3 -> "c6nz-fdp";
                case 4 -> "c6nz-patterns";
                case 5 -> "c6nz-measurement";
                case 6 -> "c6nz-geometry";
                case 7 -> "c6nz-data-chance";
                default -> "c6nz-probability";
            };
        }
        if (year == 7) {
            return switch (order) {
                case 1 -> "c7nz-exponents";
                case 2 -> "c7nz-primes-hcf";
                case 3 -> "c7nz-integers";
                case 4 -> "c7nz-fdp-finance";
                case 5 -> "c7nz-algebra";
                case 6 -> "c7nz-measurement";
                case 7 -> "c7nz-geometry";
                default -> "c7nz-stats-prob";
            };
        }
        return "nz-" + year + "-" + NzSubject.MATHEMATICS.slug() + "-" + order;
    }

    private static String number(int y) {
        return switch (y) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Count forwards and backwards within 20; the last number said is how many.",
                            "Read, write and order numerals 0–20, including 1st, 2nd and 3rd.",
                            "Place numbers on a labelled number line and compare using more, less and the same."},
                    LessonHtml.p("Numbers are names and symbols for how many. The whole numbers from 0 to 20 form a sequence: each has a unique name and numeral. When you count a collection you touch each object once (one-to-one) and the last number is the total (cardinality).")
                            + LessonHtml.p("Numbers from 13 to 19 use a teen ending. You can also use numbers for position: 1st, 2nd, 3rd. A number line shows order and size — numbers further right are larger. Small collections of about 3–5 can be recognised without counting (subitising), which is the start of seeing 8 as 5 and 3.")
                            + LessonHtml.p("Year 1 does not yet require tens-and-ones language for every two-digit number, but 10 and 11–20 should feel like 'ten and some more' when you use a tens frame."),
                    "In te reo Māori, tahi to tekau name 1–10. Counting in two languages shows that the quantity stays the same even when the word changes.",
                    new String[]{"Line objects up or move them so none are missed or double-counted.",
                            "Say number names in order. The last word is how many.",
                            "Match the quantity to a numeral and write it.",
                            "Check by counting again or by making the same number on a tens frame."},
                    "How many shells?",
                    "Seven shells are in a kete. Count 1–7. The last number is 7, so there are 7 shells. Seven is more than 5 and less than 10.",
                    "Which is larger, 12 or 8?",
                    "On a 0–20 number line, 12 sits to the right of 8, so 12 is greater. 12 is 10 and 2, while 8 is still less than 10.",
                    LessonHtml.table(new String[]{"Word", "Numeral", "Just after"},
                            new String[][]{{"five", "5", "6"}, {"ten", "10", "11"}, {"fifteen", "15", "16"}, {"twenty", "20", "next year"}}),
                    "Do not skip objects or count the same object twice. The last number is the total — not the name of the last object only.",
                    "If a collection looks messy, make rows of five so your eyes can check the count.",
                    "Count each object once, trust the last number, and use a number line to compare size.",
                    "count, how many, more, less, numeral, number line, first, second, third");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Read, write and order numbers to 100 using tens and ones.",
                            "Count in 2s and 10s; use te reo Māori numbers to 30.",
                            "Locate numbers on a partially labelled number line."},
                    LessonHtml.p("Our number system is base 10: ten ones make one ten, and the digit's place tells its value. In 47 the 4 means 4 tens (40) and the 7 means 7 ones. Names from 20 to 99 use a ty ending (twenty, thirty).")
                            + LessonHtml.p("Te reo Māori number names follow place value clearly: rua tekau mā tahi is two tens and one (21). That structure is a gift for understanding tens and ones.")
                            + LessonHtml.p("You compare two-digit numbers from the tens place first. 61 is greater than 59 because 6 tens beat 5 tens, even though 9 ones is more than 1 one."),
                    "Māori naming (rua tekau mā rima = 25) matches the tens-and-ones chart you draw in class.",
                    new String[]{"Split a two-digit number into tens and ones (bundles of 10 sticks help).",
                            "Compare tens first, then ones if tens are equal.",
                            "Show the number in numerals, words and expanded form (40 + 7).",
                            "Place it between neighbouring tens on a number line."},
                    "What is the value of the 3 in 35?",
                    "The 3 is in the tens place, so it means 30, not 3. Expanded form: 30 + 5.",
                    "Order 18, 81 and 80",
                    "Tens: 1 ten, 8 tens, 8 tens. 18 is smallest. 80 and 81 share 8 tens, so compare ones: 0 then 1. Order: 18, 80, 81.",
                    LessonHtml.table(new String[]{"Number", "Tens", "Ones"},
                            new String[][]{{"20", "2", "0"}, {"47", "4", "7"}, {"90", "9", "0"}, {"103 is Year 3", "—", "—"}}),
                    "Do not compare from the ones place first. 19 is not greater than 21 just because 9 is a big digit.",
                    "Zero is a placeholder: 40 has 4 tens and 0 ones. Without the 0, 4 would mean four, not forty.",
                    "Place value is tens and ones. Compare from the left, and practise Māori number names to 30.",
                    "tens, ones, place value, digit, expanded form, tekau");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Read, write and order numbers to 1,000 with hundreds, tens and ones.",
                            "Count in 2s, 3s, 4s, 5s, 8s, 10s and 100s from matching starting points.",
                            "Round to the nearest 10 or 100 and estimate before calculating."},
                    LessonHtml.p("Ten tens make one hundred; ten hundreds make one thousand. 482 is 4 hundreds, 8 tens and 2 ones. Place value still works from the left when you compare: 705 is greater than 698 because 7 hundreds beat 6 hundreds.")
                            + LessonHtml.p("Rounding uses a number line. To the nearest 10, look at ones: 5 or more rounds up. To the nearest 100, look at tens. Estimation is rounding's purpose — know if 329 + 80 should be near 400 before you compute.")
                            + LessonHtml.p("Skip-counting in 2s, 5s and 10s is already multiplication in disguise. Year 3 adds 3s, 4s and 8s from multiples of those numbers, and odd/even: numbers ending 0, 2, 4, 6, 8 are even."),
                    "A school roll of 328 is three hundreds, two tens and eight ones — useful when ordering class sizes across a kura.",
                    new String[]{"Write the number in a H–T–O chart.",
                            "Compare from hundreds, then tens, then ones.",
                            "Round by finding the nearest benchmark on a number line.",
                            "Estimate the calculation, then compute and compare."},
                    "Round 347 to the nearest 10 and 100",
                    "Nearest 10: ones digit 7 ≥ 5, so 350. Nearest 100: tens digit 4 &lt; 5, so 300.",
                    "Which is larger, 509 or 590?",
                    "Hundreds are equal (5). Tens: 0 versus 9. 590 is larger. The 9 is worth 90, not 9.",
                    LessonHtml.table(new String[]{"Number", "Hundreds", "Tens", "Ones"},
                            new String[][]{{"205", "2", "0", "5"}, {"370", "3", "7", "0"}, {"1,000", "10 hundreds", "0", "0"}}),
                    "Zero in the middle matters: 405 is not 45. The 0 holds the tens place empty.",
                    "When skip-counting, say the multiple out loud (8, 16, 24…) so the equal-group idea stays attached.",
                    "Hundreds, tens, ones; round to estimate; skip-count to build multiplicative thinking.",
                    "hundred, thousand, round, estimate, odd, even, multiple");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Read, write and order numbers to 10,000 with thousands as a new place.",
                            "Use zero as a placeholder and round to 10, 100 or 1,000.",
                            "Count in a wide range of steps, including 25s and 50s."},
                    LessonHtml.p("Each place is ten times the place on its right. In 4,082 the 4 means 4 thousands, the 0 holds hundreds empty, 8 means 80 and 2 means 2. Without the 0, 482 would be a different number.")
                            + LessonHtml.p("Rounding to the nearest thousand looks at the hundreds digit. Rounding tenths to the nearest whole number begins later in this year once decimals appear, but whole-number rounding should be fluent now.")
                            + LessonHtml.p("Skip-counting from any multiple (including 25 and 50) supports money, time and later factors. You are building a mental map of the number system up to 10,000."),
                    "New Zealand's smaller towns often have populations in the thousands. Reading 8,430 as eight thousand, four hundred and thirty is a civic literacy skill as well as a maths one.",
                    new String[]{"Say the number in words, then write expanded form.",
                            "Compare from the left-most place.",
                            "Round by inspecting the digit one place to the right of the target.",
                            "Check with a number line if two thousands sit equally far — agree the '5 or more' rule."},
                    "Expanded form of 7,305",
                    "7,000 + 300 + 5. There are 0 tens. The 3 is hundreds, not tens.",
                    "Round 6,480 to the nearest thousand",
                    "Hundreds digit is 4, so round down to 6,000. To the nearest hundred it would be 6,500.",
                    LessonHtml.table(new String[]{"Place", "In 5,026"},
                            new String[][]{{"thousands", "5 → 5,000"}, {"hundreds", "0 → 0"}, {"tens", "2 → 20"}, {"ones", "6 → 6"}}),
                    "Reading 5,026 as 'five thousand and twenty-six' is right; calling it 526 is a place-value collapse.",
                    "When comparing, if the first digits match, slide right until they differ. That first difference decides.",
                    "Thousands extend base 10. Zero holds empty places. Round to estimate big totals.",
                    "thousand, placeholder, round, digit, expanded form, multiple");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Read, write and order numbers to 1,000,000.",
                            "Find factor pairs for products of numbers 1–10.",
                            "Count through zero into negative whole numbers in simple contexts."},
                    LessonHtml.p("Base 10 extends to millions: 1,000 thousands make one million. Each digit is still worth ten times the digit on its right. Rounding can now target hundred thousands or ten thousands depending on the question.")
                            + LessonHtml.p("Factors are whole numbers that divide another number exactly. 3 and 4 are a factor pair of 12 because 3 × 4 = 12. Factor pairs later unlock primes, HCF and simplifying fractions.")
                            + LessonHtml.p("Negative numbers sit to the left of 0 on a horizontal number line (or below 0 on a vertical thermometer). Name −4 as negative four. Zero is neither positive nor negative. Debt and temperature below freezing are honest Year 5 contexts."),
                    "A winter morning in Ōtautahi might read −2 °C. That is two degrees below zero — not 'minus a temperature that doesn't exist'.",
                    new String[]{"Write large numbers with grouping spaces or commas and say them in words.",
                            "List factor pairs systematically (1 × n, 2 × …).",
                            "Place negatives relative to 0 before comparing two negatives.",
                            "Round by identifying the target place, then inspecting the next digit."},
                    "Factor pairs of 24",
                    "1×24, 2×12, 3×8, 4×6 (and the reverses). 5 does not divide 24 exactly, so 5 is not a factor.",
                    "Order 3, −1, 0, −4",
                    MathFigures.numberLine(-5, 4, -4, "Further left is smaller: −4, −1, 0, 3.")
                            + "<p>−4 is less than −1 because it is further left (colder, or more in debt).</p>",
                    LessonHtml.table(new String[]{"Number", "In words"},
                            new String[][]{{"250,000", "two hundred and fifty thousand"}, {"1,000,000", "one million"}, {"−5", "negative five"}}),
                    "When comparing negatives, the one with the larger numeral is not larger: −9 is less than −2.",
                    "Keep factor pairs in order so you do not miss 6 × 4 after listing 4 × 6.",
                    "Millions, factors and the first negatives — still one base-10 system, now stretching both ways.",
                    "million, factor, factor pair, negative, positive, round");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Read, write and order any whole number and represent it with base 10.",
                            "Know square numbers to 144 and cube numbers to 125, with ² and ³ notation.",
                            "Count through negatives and treat the number system as continuing infinitely both ways."},
                    LessonHtml.p("Place value does not stop at millions — it continues infinitely to the left. Year 6 learners should be able to compose and decompose any whole number and round to a specified place, including rounding hundredths to a tenth once decimals are in play.")
                            + LessonHtml.p("A square number is a number multiplied by itself: 8² = 64. A cube number is multiplied by itself twice: 5³ = 125. These connect to area of squares and volume of cubes in measurement.")
                            + LessonHtml.p("Negatives are now part of counting sequences: start at −6 and count backwards in 2s. The same number line also holds decimals to thousandths — one system, many places."),
                    "Sports scores, distances in kilometres across Te Ika-a-Māui, and account balances all use this extended number system.",
                    new String[]{"Name every place from millions (or beyond) down to ones.",
                            "Memorise squares 1²–12² and cubes 1³–5³ as landmarks.",
                            "Jump through 0 on a number line without skipping the sign change.",
                            "Round to the place named in the question, not a favourite place."},
                    "Evaluate 6² and 3³",
                    "6² = 6 × 6 = 36 (a square number). 3³ = 3 × 3 × 3 = 27 (a cube number). 6 × 2 = 12 is not 6².",
                    "Count back in 2s from 3 through 0",
                    MathFigures.numberLine(-4, 4, -1, "Count back in 2s: 3, 1, −1, −3. Zero is crossed, not skipped.")
                            + "<p>After 1, subtract 2 to get −1.</p>",
                    LessonHtml.table(new String[]{"n", "n²", "n³"},
                            new String[][]{{"1", "1", "1"}, {"4", "16", "64"}, {"5", "25", "125"}, {"12", "144", "—"}}),
                    "6² is not 6 × 2. The small 2 means 'use 6 as a factor twice'.",
                    "If rounding 3.46 to the nearest tenth, look at the hundredths digit 6: 3.5.",
                    "Any whole number, squares and cubes, and a number line that includes negatives.",
                    "infinite, square number, cube number, exponent, negative, round");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Write numbers using positive powers of 10 and expanded form with exponents.",
                            "Identify primes to 100, and find HCF and LCM of small numbers.",
                            "Use divisibility tests for 2, 3, 4, 5, 6, 8, 9 and 10."},
                    LessonHtml.p("Each place value is a power of 10: 10,000 = 10⁴. Expanded form can be written 34,506 = 3×10⁴ + 4×10³ + 5×10² + 6. Exponent notation also shortens repeated multiplication: 5² means 5×5.")
                            + MathFigures.placeValueChart(3, 4, 5, 6, "3,456 = 3 thousands + 4 hundreds + 5 tens + 6 ones")
                            + LessonHtml.p("Whole numbers greater than 1 are prime (exactly two distinct factors: 1 and itself) or composite (more than two factors). 1 is neither. HCF is the largest factor shared by two numbers; LCM is the smallest common multiple.")
                            + LessonHtml.p("Divisibility rules save time: a number is divisible by 3 if the digit sum is; by 9 if the digit sum is; by 4 if the last two digits form a multiple of 4. These rules feed prime factorisation next year."),
                    "Bus route numbers, census population figures, and scientific powers of ten (10³ metres = 1 km) all sit in this Phase 3 number work.",
                    new String[]{"Rewrite large places as powers of 10.",
                            "Test primality with divisibility rules up to the square root (for numbers to 100, test primes to 10).",
                            "List factor pairs to find HCF; list multiples or use primes for LCM.",
                            "Estimate square roots by trapping the number between two squares."},
                    "Is 51 prime?",
                    "Digit sum 6 is divisible by 3, so 51 = 3 × 17. Composite, not prime.",
                    "HCF and LCM of 12 and 18",
                    "12 = 2²×3, 18 = 2×3². HCF uses the lowest powers: 2×3 = 6. LCM uses the highest: 2²×3² = 36.",
                    LessonHtml.table(new String[]{"Power", "Value"},
                            new String[][]{{"10²", "100"}, {"10³", "1,000"}, {"10⁴", "10,000"}, {"5²", "25"}}),
                    "1 is not prime. 2 is the only even prime. Do not list 9 as prime because it 'looks odd'.",
                    "A mnemonic such as GEMA is for order of operations in the next lesson — powers of 10 here are about structure, not yet mixed expressions.",
                    "Powers of 10, primes, HCF/LCM and divisibility are the toolkit for fractions and algebra.",
                    "exponent, prime, composite, HCF, LCM, divisible, square root");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Use positive and negative powers of 10, including 10⁻¹ = 0.1.",
                            "Write composite numbers as products of primes with exponents.",
                            "Evaluate square and cube roots of perfect powers, and approximate others."},
                    LessonHtml.p("Place value continues infinitely left and right. Negative exponents write repeated division by 10: 10⁻² = 1/100 = 0.01. Then 3.61 = 3×10⁰ + 6×10⁻¹ + 1×10⁻².")
                            + LessonHtml.p("Every composite number has a unique prime factorisation (fundamental theorem of arithmetic). 36 = 2² × 3². Cube roots join square roots: ∛125 = 5.")
                            + LessonHtml.p("Integers include negatives, positives and zero. Every number has an additive inverse: −5 + 5 = 0. You add and subtract integers on a number line and in finance or temperature problems."),
                    "A tide gauge or a bank overdraft uses negative numbers; millimetres as 10⁻³ m shows why negative powers appear in science and technology.",
                    new String[]{"Convert between 0.01, 1/100 and 10⁻² until they feel like the same object.",
                            "Factor composites by dividing by primes 2, 3, 5, 7… and collect exponents.",
                            "For roots, find the nearby perfect square/cube, then estimate.",
                            "When adding integers, think directed jumps, not 'minus means take the smaller'."},
                    "Prime factorise 84",
                    "84 = 2 × 42 = 2 × 2 × 21 = 2 × 2 × 3 × 7 = 2² × 3 × 7.",
                    "Compare −3.4 and −3",
                    "−3.4 is to the left of −3, so −3.4 &lt; −3. Decimals do not flip the inequality just because 3.4 &gt; 3.",
                    LessonHtml.table(new String[]{"Form", "Same value"},
                            new String[][]{{"10⁻¹", "0.1 = 1/10"}, {"10⁻²", "0.01 = 1/100"}, {"10⁰", "1"}}),
                    "A negative exponent is not a negative answer: 10⁻² is positive one hundredth.",
                    "Unique prime factorisation means you should get the same primes (maybe in a different order) every time.",
                    "Negative powers of 10, prime powers, roots and integers — one extended number system.",
                    "negative exponent, prime factor, integer, cube root, additive inverse");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Apply index laws for multiplying and dividing powers with the same base.",
                            "Write very large or small numbers in scientific notation.",
                            "Simplify square roots of non-square numbers where appropriate (surds)."},
                    LessonHtml.p("Index laws come from the meaning of exponents: aᵐ × aⁿ = aᵐ⁺ⁿ because you are concatenating factors. aᵐ ÷ aⁿ = aᵐ⁻ⁿ. (aᵐ)ⁿ = aᵐⁿ. a⁰ = 1 (a ≠ 0). These laws keep algebra tidy.")
                            + LessonHtml.p("Scientific notation writes a × 10ᵏ with 1 ≤ |a| &lt; 10. Distances in the solar system and cell sizes become readable. You must also judge whether a calculated answer is a reasonable order of magnitude.")
                            + LessonHtml.p("A surd is a root that does not simplify to a whole number, such as √12 = 2√3. Year 9 is about recognising perfect-square factors, not endless nested radicals."),
                    "Aotearoa is about 1.5 × 10³ km from north to south if you quote a rough length of the country — scientific notation is for scale, not showing off.",
                    new String[]{"Rewrite the expression using the definition of a power before leaping to a law.",
                            "For scientific notation, move the point until one digit sits on the left, and count the moves as the exponent.",
                            "For surds, factor out the largest square factor.",
                            "Estimate using 1 or 10 times a power of 10 to check reasonableness."},
                    "Simplify 2³ × 2⁵",
                    "Same base, add exponents: 2⁸ = 256. Not 2¹⁵ (that would be multiplying the exponents incorrectly here).",
                    "Write 45,000 in scientific notation",
                    "4.5 × 10⁴. The point moved 4 places. 45 × 10³ is equivalent but not standard form.",
                    LessonHtml.table(new String[]{"Law", "Example"},
                            new String[][]{{"aᵐ × aⁿ = aᵐ⁺ⁿ", "3² × 3⁴ = 3⁶"}, {"aᵐ ÷ aⁿ = aᵐ⁻ⁿ", "5⁷ ÷ 5³ = 5⁴"}, {"(aᵐ)ⁿ = aᵐⁿ", "(2³)² = 2⁶"}}),
                    "2³ × 2⁵ is not 4⁸. Only add exponents when the bases match.",
                    "If |a| is 12.6 in your scientific notation, you have not finished — rewrite as 1.26 × 10ᵏ⁺¹.",
                    "Index laws, standard form and simple surds let you work across tiny and huge quantities.",
                    "index law, scientific notation, order of magnitude, surd, base, exponent");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number | Tau",
                    new String[]{"Keep index, standard-form and rational-number skills fluent under exam-style pressure.",
                            "Choose an efficient form (fraction, decimal, percentage, standard form) for the context.",
                            "Use estimation and inverse operations as a checking habit."},
                    LessonHtml.p("Year 10 number work is less about new objects and more about using the full toolkit inside algebra, trigonometry, finance and statistics. You should move between fractions, decimals, percentages, indices and standard form without losing meaning.")
                            + LessonHtml.p("GST at 15%, simple and compound interest, and unit rates (km/h, $/100 g) are number in disguise. Always name the base: 15% of what?")
                            + LessonHtml.p("A wrong order of magnitude is more serious than a small rounding slip. Ask: could New Zealand's population really be 5 × 10⁶ or did I mean 5 × 10⁵?"),
                    "KiwiSaver, power bills and supermarket unit prices are Year 10 number in the community — accuracy to a sensible number of decimal places matters.",
                    new String[]{"Underline the quantity that is 100% or the 'whole'.",
                            "Convert to the form that makes the operation easiest, then convert back if needed.",
                            "Estimate first using 1, 2, 5 and 10 times powers of 10.",
                            "Reverse-check with the inverse operation or a different form."},
                    "15% GST on a $80 item (GST-exclusive)",
                    "15% of 80 = 0.15 × 80 = $12. GST-inclusive total $92. Check: 80 × 1.15 = 92.",
                    "Which is larger, 3.2 × 10⁴ or 4.1 × 10³?",
                    "32,000 versus 4,100. Compare exponents first: 10⁴ beats 10³, so 3.2 × 10⁴ is larger.",
                    LessonHtml.table(new String[]{"Context", "Sensible form"},
                            new String[][]{{"discount", "percentage then decimal multiplier"}, {"tiny length", "scientific notation"}, {"ratio of classes", "simplified fraction"}}),
                    "Do not add GST on top of a price that already includes GST. Read whether the amount is exclusive or inclusive.",
                    "Keep a calculator as a checker, not a substitute for knowing what 10% looks like mentally.",
                    "Fluent, checked number sense is the platform for every other Year 10 strand.",
                    "GST, unit rate, multiplier, significant figure, inverse");
        };
    }

    private static String operations(int y) {
        return switch (y) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"See addition as joining parts and subtraction as taking away or comparing.",
                            "Memorise facts within 5 and begin facts to 10, including 10 + 0.",
                            "Solve one-step stories with objects and pictures."},
                    LessonHtml.p("Addition puts parts together to find a whole. Subtraction separates a whole or finds a difference. Adding 0 does not change a number. Order matters for subtraction: 5 − 2 is not 2 − 5.")
                            + LessonHtml.p("Year 1 facts are small so they can become automatic. Doubles to 10 (4 + 4) and the number before/after up to 10 sit alongside stories: altogether, left, how many more.")
                            + LessonHtml.p("You are not expected to use column methods. Objects, tens frames and number lines are the right tools."),
                    "Sharing playdough, scoring in a game of ki-o-rahi mini activities, or packing lunchboxes all generate join and take-away stories.",
                    new String[]{"Act the story with objects.", "Write a number sentence.", "Count on, count back, or use a known fact.", "Check in the story."},
                    "3 + 2", "Three red and two blue counters: 5 in all. Number sentence 3 + 2 = 5.",
                    "6 grapes, eat 2", "6 − 2 = 4 left. Check: 4 + 2 = 6.",
                    LessonHtml.table(new String[]{"Clue", "Try"}, new String[][]{{"altogether, join", "+"}, {"left, take away", "−"}, {"how many more", "difference (−)"}}),
                    "Do not subtract the first number from the second just because it looks smaller on the page. Respect the story order.",
                    "Fact families: if 3 + 2 = 5, then 2 + 3 = 5, 5 − 2 = 3, 5 − 3 = 2.",
                    "Join or separate, write a sentence, check in the story.",
                    "add, subtract, total, difference, equal, fact");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Memorise addition and subtraction facts to 20, including doubles.",
                            "Add and subtract two-digit numbers that do not always require regrouping, using place value.",
                            "Know × and ÷ facts for 2s, 5s and 10s as equal groups."},
                    LessonHtml.p("Addition is commutative; subtraction is not. You can derive 70 + 20 from 7 + 2. Addition and subtraction are inverses, so they check each other.")
                            + LessonHtml.p("Equal groups are multiplication: 4 groups of 5 is 4 × 5. Division is sharing or grouping. Year 2 memorises 2s, 5s and 10s and links them to skip-counting.")
                            + LessonHtml.p("Multiplying by 1 leaves a number unchanged; multiplying by 0 gives 0. You cannot divide by 0 — that idea is planted now and proven later."),
                    "Ten-dollar notes make 2s, 5s and 10s facts visible when you count a kete of play money.",
                    new String[]{"Choose + − × or ÷ from the story.", "Use a known fact or place-value jump.", "Write the number sentence.", "Check with the inverse."},
                    "32 + 20", "3 tens + 2 tens = 5 tens, ones unchanged: 52. Derived from 3 + 2 = 5.",
                    "6 bags of 5 apples",
                    MathFigures.array(6, 5, "6 rows of 5: an array for 6 × 5 = 30.")
                            + "<p>6 × 5 = 30. Division check: 30 ÷ 5 = 6 bags.</p>",
                    null,
                    "32 + 8 is not 40 if you add 8 to the tens by mistake. Ones must make a ten first (regrouping begins here).",
                    "Arrays (rows and columns) show why 3 × 4 = 4 × 3.",
                    "Facts to 20, place-value addition, and 2s 5s 10s equal groups.",
                    "inverse, commutative, array, equal groups, regroup");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Add and subtract to 1,000, including regrouping (renaming).",
                            "Memorise × and ÷ facts for 2, 3, 4, 5, 8 and 10.",
                            "Multiply a two-digit number by a one-digit number; divide with no remainder."},
                    LessonHtml.p("Column methods align digits by place. When ones exceed 9 you rename 10 ones as 1 ten. Subtraction across a zero uses the same renaming in reverse.")
                            + LessonHtml.p("Multiplication is repeated addition, an array, or a known fact. Division is equal sharing or grouping. Memorised facts for 3, 4 and 8 join 2, 5 and 10.")
                            + LessonHtml.p("Multi-step problems appear: add then subtract, or multiply then add. Write a number sentence for each step."),
                    "A school fundraising total of $329 + $54 needs regrouping of ones. Money stories make renaming meaningful.",
                    new String[]{"Align places.", "Rename when a place has 10 or more (or not enough to subtract).", "Use a fact or an array for × and ÷.", "Estimate, then check with the inverse."},
                    "137 + 54", "Ones 7+4=11 → write 1, carry 1 ten. Tens 3+5+1=9. Hundreds 1. Total 191.",
                    "24 ÷ 3", "How many 3s in 24? 8, because 3 × 8 = 24. No remainder.",
                    null,
                    "Forgetting to add the renamed ten is the classic column-addition error.",
                    "If 8 × 7 is unknown, use 8 × 5 + 8 × 2 = 40 + 16 = 56 (distributive thinking).",
                    "Regrouping, fact fluency for 2–5, 8 and 10, and clean ×/÷ with no remainder.",
                    "rename, regroup, column, product, dividend, divisor, quotient");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Add and subtract up to four-digit numbers.",
                            "Memorise × and ÷ facts 2–10; multiply 2- or 3-digit by 1-digit.",
                            "Divide up to 3-digit by 1-digit with no remainder; interpret remainders next year."},
                    LessonHtml.p("Written algorithms rely on place value and renaming. Area models for multiplication show why 23 × 4 = 20×4 + 3×4. Division is grouping, sharing or the inverse of multiplication.")
                            + LessonHtml.p("Multiplying by 0 or 1, and dividing by 1, should be automatic. Mental strategies (doubling, half, ×10 then adjust) sit beside columns.")
                            + LessonHtml.p("Word problems may hide two steps. Underline the quantities and the question before choosing operations."),
                    "Inter-school sports: 1,248 spectators on Saturday and 876 on Sunday. Totals and differences are four-digit operations in a real crowd.",
                    new String[]{"Estimate using rounded numbers.", "Choose mental, area or column method.", "Keep places aligned.", "Check with inverse or a second method."},
                    "26 × 4", "20×4=80, 6×4=24, total 104. Or 25×4 + 4 = 104.",
                    "65 ÷ 5", "5 × 13 = 65, so 13. Think of 65 as 50+15, 10+3 groups of 5.",
                    null,
                    "A remainder of 0 is still a legal division result — do not 'invent' a leftover.",
                    "If both numbers look big, estimate first so 23 × 4 = 92 would immediately look too small.",
                    "Four-digit ±, facts to 10, and 2–3 digit × 1-digit with exact division.",
                    "algorithm, area model, remainder (none yet), estimate, multiple");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Memorise × and ÷ facts to 12; multiply 3–4 digit by 1-digit and two 2-digit numbers.",
                            "Divide up to 4-digit by 1-digit with a whole-number remainder.",
                            "Use factor pairs and multiples to compute mentally."},
                    LessonHtml.p("Remainders can be left as 'remainder 2' this year. Later you will write them as fractions or decimals depending on the story (leftover people cannot be 0.3 of a person).")
                            + LessonHtml.p("Two two-digit products (23 × 45) use the area model or long multiplication. Factor pairs help you restructure 24 × 5 as 12 × 10.")
                            + LessonHtml.p("Language: dividend ÷ divisor = quotient, possible remainder. Product is the result of multiplication."),
                    "Hiring vans for 278 students with 4 extra seats per van leftover is a remainder story — you still need another van in real life.",
                    new String[]{"Translate the story to × or ÷.", "Estimate.", "Compute, recording any remainder.", "Interpret the remainder in context."},
                    "278 ÷ 4", "4 × 69 = 276, remainder 2. As a class of people you need 70 vans if each holds 4 — remainder means an extra group.",
                    "12 × 15", "12 × 10 + 12 × 5 = 120 + 60 = 180.",
                    null,
                    "Writing 278 ÷ 4 = 69 ignores the leftover 2. Either record the remainder or keep dividing.",
                    "Check multiplication by dividing the product by one factor.",
                    "Facts to 12, larger products, and remainders that mean something in the story.",
                    "quotient, remainder, dividend, divisor, product, factor");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Use GEMA: grouped, exponents, multiplicative, additive.",
                            "Multiply any whole number by a two-digit number; divide up to 5-digit by 1-digit.",
                            "Express remainders as whole numbers, fractions or rounded decimals to match the context."},
                    LessonHtml.p("When expressions mix operations, order matters. Work grouped brackets first, then exponents, then × and ÷ left to right, then + and − left to right. A mnemonic such as GEMA is allowed; the meaning matters more than the chant.")
                            + LessonHtml.p("Remainders: leftover apples stay whole; leftover ribbon can be a decimal metre; leftover pizza is a fraction. 31 ÷ 6 = 5 remainder 1 = 5 1/6.")
                            + LessonHtml.p("You connect unit fractions of a number to division: 1/6 of 31 is 31 ÷ 6."),
                    "A recipe scaled for a school hāngī committee uses × and ÷ in the same plan — order of operations keeps the scaling honest.",
                    new String[]{"Mark brackets and exponents.", "Compute ×÷ left to right, then +−.", "Choose remainder form from the story.", "Estimate to check."},
                    "3 + 4 × 2", "× first: 4 × 2 = 8, then 3 + 8 = 11. Not 14 (that would be adding first).",
                    "1283 ÷ 5", "5 × 256 = 1280, remainder 3. As a decimal 256.6; as a fraction 256 3/5.",
                    LessonHtml.table(new String[]{"Order", "Do this"},
                            new String[][]{{"1", "brackets / grouped"}, {"2", "exponents"}, {"3", "× and ÷ left to right"}, {"4", "+ and − left to right"}}),
                    "Left-to-right for × and ÷: 24 ÷ 4 × 2 = 6 × 2 = 12, not 24 ÷ 8.",
                    "If two answers are 11 and 14, ask which operation the expression actually wrote first in GEMA.",
                    "GEMA, large ×÷, and remainder form chosen by context.",
                    "GEMA, brackets, exponent, remainder, mixed number");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Add and subtract integers using a number line and additive inverses.",
                            "Evaluate mixed expressions with GEMA, including exponents.",
                            "Divide whole numbers by 1- or 2-digit divisors, with fraction or decimal remainders."},
                    LessonHtml.p("Integers are positive wholes, negative wholes and zero. Adding a negative is a jump left; subtracting a negative is a jump right because subtraction means adding the inverse.")
                            + LessonHtml.p("GEMA still governs 3 + (−7) and 2³ × 5. Grouped work is not optional when brackets appear.")
                            + LessonHtml.p("327 ÷ 15 = 21.8 or 21 4/5. Rounding and benchmarks (14.7 × 5 sits between 70 and 75) check reasonableness."),
                    "A temperature drop from 3 °C to −4 °C is a change of 7 degrees — integer subtraction in a weather story.",
                    new String[]{"Locate both integers on a line.", "Translate subtract-negative as add-positive.", "Apply GEMA.", "Estimate with rounding."},
                    "3 + (−7)",
                    MathFigures.integerJump(3, -7, "Start at 3 (blue). Adding −7 is a jump of 7 left to −4 (orange).")
                            + "<p>Start at 3, jump 7 left: −4. Check: −4 is the number 7 below 3.</p>",
                    "5s + 3 = 18 (preview of algebra)", "This is an equation. Operations lesson still: inverse of +3 is −3, inverse of ×5 is ÷5. (See algebra lesson.)",
                    null,
                    "−3 − 5 is −8, not 2. Both jumps go left if you subtract a positive from a negative.",
                    "Additive inverse: a number plus its opposite is 0. That identity unlocks equation solving.",
                    "Integer jumps, GEMA and honest remainders.",
                    "integer, additive inverse, GEMA, benchmark, estimate");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Evaluate expressions with negatives using GEMA.",
                            "Apply percentage discounts, including non-tidy percents.",
                            "Compare weekly/monthly/yearly financial plans."},
                    LessonHtml.p("Year 8 operations include directed numbers inside GEMA and money rounded to two decimal places. Cash in Aotearoa still rounds to the nearest 10 cents for coins, while card payments keep cents.")
                            + LessonHtml.p("A 35% discount on $180 is $180 − 0.35×180 = $117. Percentage increase uses a multiplier greater than 1.")
                            + LessonHtml.p("Plans: a phone plan at $20/week is not the same as $80/month unless you convert with a consistent number of weeks. Show working."),
                    "Buy-now-pay-later and supermarket specials are financial mathematics in the 2025 sequence — calculate before you trust the large print.",
                    new String[]{"Convert % to a decimal multiplier.", "Apply GEMA if several operations sit together.", "Round money to 2 d.p. (or 10c for cash).", "Compare plans on the same time base."},
                    "20% off $45", "0.20 × 45 = $9 off. New price $36. Multiplier: 45 × 0.8 = 36.",
                    "3 + −7 × 2", "× first: −7 × 2 = −14, then 3 + −14 = −11.",
                    null,
                    "Taking 35% off by subtracting 35 is meaningless. Percent needs a base amount.",
                    "Write the multiplier (0.65 for 35% off) so you can reverse-check.",
                    "Directed GEMA, percentage of money, and plans compared fairly.",
                    "discount, multiplier, GST, budget, two decimal places");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Combine index laws with the four operations in multi-step problems.",
                            "Use scientific notation in calculations and interpret the result.",
                            "Keep rounding until the end unless the context demands otherwise."},
                    LessonHtml.p("Year 9 operations problems mix indices, standard form and estimation. Calculate (3.0 × 10⁴) × (2.0 × 10³) by multiplying 3×2 and adding exponents: 6.0 × 10⁷.")
                            + LessonHtml.p("Rounding too early creates ugly error. Keep two extra figures, then round to a sensible degree of accuracy.")
                            + LessonHtml.p("Negative bases and exponents need care: (−2)⁴ is positive 16, but −2⁴ is −16 because exponent binds to 2 first."),
                    "Earthquake energy scales and population figures in scientific notation appear in science and social sciences — the arithmetic is this lesson.",
                    new String[]{"Rewrite in a single form (all scientific notation, or all ordinary).", "Apply index laws.", "Only then convert back.", "Sanity-check the exponent."},
                    "(2 × 10⁵) × (4 × 10⁻²)", "8 × 10³ = 8000. Exponents 5 + (−2) = 3.",
                    "−3² versus (−3)²", "−3² = −9; (−3)² = 9. Brackets change the base.",
                    null,
                    "Adding exponents when you meant to multiply the coefficients is a common slip in scientific notation.",
                    "If the coefficient leaves the 1-to-10 range, adjust the exponent.",
                    "Index-aware arithmetic with late rounding and bracket discipline.",
                    "scientific notation, degree of accuracy, coefficient, bind");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · operations",
                    new String[]{"Solve multi-step financial and rate problems with a clear multiplier.",
                            "Choose mental, written or calculator methods appropriately.",
                            "Communicate answers with units and a sensible number of decimals."},
                    LessonHtml.p("Year 10 operations live inside rates (km/h, g/L), reverse percentages, and compound interest. The mathematics is still GEMA plus a multiplier model: new = original × (1 ± r).")
                            + LessonHtml.p("Simple interest I = Prt; compound interest grows on the new principal. Know which one a question describes.")
                            + LessonHtml.p("A rate is a comparison of two different units. Always reduce to a per-one amount if you need to compare deals."),
                    "Power companies, KiwiSaver illustrations and fuel prices in $/L are rate problems. Show the per-unit amount.",
                    new String[]{"Identify original, rate and time.", "Write a multiplier or formula.", "Calculate, keeping extra decimals.", "Round and attach units."},
                    "Simple interest on $800 at 5% for 3 years", "I = 800 × 0.05 × 3 = $120. Total $920.",
                    "Which is better: 1.5 kg for $6 or 2 kg for $7.60?", "Per kg: $4.00 versus $3.80. The 2 kg bag is better value.",
                    null,
                    "Using compound interest formula when the question says simple (or the reverse) is a context error, not an arithmetic one.",
                    "Convert all times to years (or all to months) before using I = Prt.",
                    "Multipliers, rates and interest — operations with units and judgement.",
                    "simple interest, compound interest, rate, multiplier, unit price");
        };
    }

    private static String fdp(int y) {
        return switch (y) {
            case 1 -> fdpEarly(y, "halves",
                    "A half is one of two equal parts of a whole or of a set. Equal sharing is the seed of division.",
                    "1/2 of 8 mussels is 4 on each of two plates.",
                    "whole, half, equal, share");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Recognise halves and quarters of regions, lengths and sets.",
                            "Connect 1/2 and 2/4 as the same amount of the same whole.",
                            "Find a half or quarter by equal sharing."},
                    LessonHtml.p("The denominator (bottom) will soon name how many equal parts. For now, half means two equal parts and quarter means four. Two quarters make a half of the same whole.")
                            + LessonHtml.p("A quarter of a set of 12 is 3 because 12 shared into 4 equal groups is 3 per group.")
                            + LessonHtml.p("Folding paper is a proof: one fold makes halves; folding again makes quarters."),
                    "Quartered oranges at a marae kai table only work as quarters if the pieces are equal — fairness is the fraction.",
                    new String[]{"Name the whole.", "Split into 2 or 4 matching parts.", "Count the parts you want.", "Check by recombining."},
                    "Quarter of 12",
                    MathFigures.fractionBar(1, 4, "One of four equal parts of a 12-item set is 3.")
                            + "<p>12 ÷ 4 = 3. Each quarter is 3.</p>",
                    "Two quarters of a sandwich",
                    MathFigures.fractionBar(2, 4, "Two quarters of the same whole is a half.")
                            + "<p>Two of four equal pieces is the same as one half.</p>",
                    LessonHtml.table(new String[]{"Fraction", "Equal parts", "Name"},
                            new String[][]{{"1/2", "2", "half"}, {"1/4", "4", "quarter"}, {"2/4", "4", "two quarters = half"}}),
                    "A 'quarter' that is bigger than the other pieces is not a quarter.",
                    "Same whole when comparing. Half of a pizza is not half of a biscuit.",
                    "Halves and quarters are equal parts; 2/4 = 1/2 of the same whole.",
                    "half, quarter, equal parts, whole, share");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Read and write halves, thirds and quarters with symbols.",
                            "Know numerator (how many parts) and denominator (how many equal parts in the whole).",
                            "Compare unit fractions: larger denominator means smaller pieces of the same whole."},
                    LessonHtml.p("A unit fraction has numerator 1. 1/3 is one of three equal parts. For unit fractions of the same whole, 1/12 is smaller than 1/6 because the whole is cut into more pieces.")
                            + LessonHtml.p("Fractions with the same denominator compare by numerator: 3/8 &gt; 2/8. Equivalent fractions name the same quantity: 2/4 = 1/2. Many names for 1 exist: 2/2, 3/3, 4/4.")
                            + LessonHtml.p("You add fractions with the same denominator by adding numerators: 1/8 + 2/8 = 3/8. The denominator stays, because the piece size did not change.")
                            + LessonHtml.p("Finding a unit fraction of a number is division: 1/3 of 15 is 15 ÷ 3 = 5. Finding the whole from a unit fraction is multiplication."),
                    "Sharing a pavlova into thirds at a celebration only works if the cuts are equal — denominator as equal parts.",
                    new String[]{"Draw the whole and equal parts.", "Label numerator and denominator.", "Compare using same-whole pictures or number lines.", "Add same-denominator fractions by combining numerators."},
                    "Which is larger, 1/3 or 1/4 of the same bar?",
                    MathFigures.fractionCompare(1, 3, 1, 4, "1/3 shaded", "1/4 shaded",
                            "Same-length bars. Thirds are larger pieces than quarters.")
                            + "<p>Thirds are larger pieces than quarters. 1/3 &gt; 1/4.</p>",
                    "If 1/4 of a set is 3, what is the whole?",
                    "Four equal groups of 3: 4 × 3 = 12.",
                    null,
                    "You cannot compare 1/3 of a cake with 1/3 of a grape and call them equal amounts — the wholes differ.",
                    "Count in unit fractions up to 1: 1/4, 2/4, 3/4, 4/4.",
                    "Numerator counts pieces; denominator sizes them. Same-denominator addition keeps the piece size.",
                    "numerator, denominator, unit fraction, equivalent, third");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Read tenths as fractions and decimals; 1/2 = 0.5.",
                            "Place mixed numbers and improper fractions on a number line.",
                            "Add and subtract tenths and same-denominator fractions, including beyond 1."},
                    LessonHtml.p("The base-10 system continues right of the ones place. A decimal point marks tenths. 0.3 = 3/10. Dividing by 10 moves digits one place right.")
                            + LessonHtml.p("Improper fractions (7/4) and mixed numbers (1 3/4) are the same quantity. Year 4 also scales recipes (double, half) using multiplication.")
                            + LessonHtml.p("Money is decimal in disguise, but this year you may still say $2 and 50 cents before $2.50 is required in Year 5."),
                    "A 100-metre athletics track marked in 10 m sections is a tenths model of 1.0.",
                    new String[]{"Write tenths in both forms.", "Compare decimals from the tenths place.", "Convert mixed ↔ improper by grouping wholes of size d/d.", "Add tenths like whole numbers, keeping the point aligned."},
                    "3/10 as a decimal", "0.3. Not 3.0 and not 0.03.",
                    "1.3 + 0.2", "1.5. Tenths 3+2=5.",
                    LessonHtml.table(new String[]{"Fraction", "Decimal"},
                            new String[][]{{"1/2", "0.5"}, {"1/10", "0.1"}, {"7/10", "0.7"}, {"10/10", "1.0"}}),
                    "0.9 is less than 1; 0.10 is not 'ten' — extra zeros on the right of a decimal do not change tenths yet, but 0.1 and 0.10 are equal tenths versus hundredths later.",
                    "Align decimal points in a column just as you align place value.",
                    "Tenths link fractions to decimals; mixed and improper names for numbers greater than 1.",
                    "tenth, decimal point, improper fraction, mixed number, scale");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Use hundredths, and common percentages 10%, 25%, 50%.",
                            "Add fractions when one denominator is a multiple of the other.",
                            "Find a non-unit fraction of a whole number."},
                    LessonHtml.p("Hundredths are 1/100 = 0.01. Percent means per hundred: 25% = 25/100 = 1/4 = 0.25. Memorise 1/2, 1/4, 3/4 as decimals and percents.")
                            + LessonHtml.p("To add 2/3 + 1/9, convert 2/3 to 6/9, then add numerators: 7/9.")
                            + LessonHtml.p("2/3 of 24 means (24 ÷ 3) × 2 = 16. If 8 is 2/5 of a set, one fifth is 4, so the whole is 20.")
                            + LessonHtml.p("Money now uses decimal notation to two places because cents are hundredths of a dollar."),
                    "A 25% off sale at a warehouse is a quarter off — connect the shop sticker to 1/4.",
                    new String[]{"Convert to a common form (same denominator, or both decimals, or both %).", "Compute.", "Convert back if the question asks for a particular form.", "Check with a benchmark (1/2, 10%)."},
                    "25% of 80", "A quarter of 80 is 20. Or 0.25 × 80 = 20.",
                    "2/3 + 1/9", "2/3 = 6/9; 6/9 + 1/9 = 7/9.",
                    LessonHtml.table(new String[]{"Percent", "Fraction", "Decimal"},
                            new String[][]{{"10%", "1/10", "0.1"}, {"25%", "1/4", "0.25"}, {"50%", "1/2", "0.5"}, {"75%", "3/4", "0.75"}}),
                    "0.2 is 0.20, which is 20 hundredths — greater than 0.12. Extra digits need place-value reading, not digit-sum guessing.",
                    "Find 10% by dividing by 10, then build 20% or 5% from that.",
                    "Hundredths, %, related denominators, and fractions of amounts.",
                    "hundredth, percent, equivalent fraction, non-unit fraction");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Use thousandths and convert fluently among 1/2, 1/4, 1/5 families and %.",
                            "Find a percentage of an amount, and find the whole from a percentage.",
                            "Reason proportionally to compare two quantities."},
                    LessonHtml.p("Thousandths: 0.031 = 31/1000. Multiplying and dividing by 10, 100 or 1,000 slides the point. Common equivalences must be memorised, including fifths: 1/5 = 0.2 = 20%.")
                            + LessonHtml.p("If 75% is 24, then 25% is 8 and 100% is 32. Multiplicative reasoning, not adding on 75.")
                            + LessonHtml.p("Proportional comparison: if 3 red for every 7 blue, 18 red means 6 times as many, so 42 blue and 60 balls in all — this previews Year 7–8 ratio."),
                    "Athletics: 0.01 s is a hundredth; swimming times sometimes use thousandths. Place value is sport as well as shopping.",
                    new String[]{"Convert to one form.", "Use division to find 1% or a unit fraction, then scale.", "For 'find the whole', divide by the given percent and multiply by 100.", "State units."},
                    "0.31 as a percent", "0.31 = 31/100 = 31%.",
                    "40% of a set is 28. Find 100%",
                    "10% is 7, so 100% is 70. Or 28 ÷ 40 × 100 = 70.",
                    null,
                    "Treating 0.31 as 31% is right; treating 0.31 as 3.1% is a place-value slip.",
                    "Benchmarks 1%, 10%, 50% build almost every common percentage.",
                    "Thousandths, fluent FDP, and finding the whole from a part.",
                    "thousandth, proportion, equivalent, reverse percentage");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Convert between terminating/repeating decimals and fractions.",
                            "Multiply fractions; divide a unit fraction into a whole.",
                            "Use ratios as well as fractions and percentages for proportion."},
                    LessonHtml.p("5/16 = 0.3125 (terminating). 1/3 = 0.333… (repeating). Percentages remain hundredths. The product of two fractions is numerator×numerator over denominator×denominator.")
                            + LessonHtml.p("Dividing by a unit fraction is asking how many of those pieces fit: 3 ÷ 1/4 = 12. Ratios describe unequal shares: 3:7.")
                            + LessonHtml.p("NZ currency answers round to 2 d.p. Percentage discounts apply to whole-dollar or cent amounts as stated."),
                    "Three red balls for every seven blue is a ratio in a PE equipment shed — part:part, not automatically part:whole unless you add.",
                    new String[]{"Simplify fractions first when you can.", "For ×, multiply across; for ÷ by a unit fraction, multiply by the reciprocal.", "Convert ratio to a total of parts.", "Round money last."},
                    "2/3 × 5",
                    MathFigures.fractionBar(2, 3, "2/3 of one whole. Five of these make 10/3.")
                            + "<p>2/3 × 5 = 10/3 = 3 1/3.</p>",
                    "3 red : 7 blue, 18 red. How many blue?",
                    "18 is 6×3, so blue is 6×7 = 42.",
                    null,
                    "A ratio 3:7 is not 3/7 of the total unless you mean the red part of (3+7). Red is 3/10 of the whole.",
                    "Keep a fraction in simplest form unless the context wants a mixed number.",
                    "All four operations with rationals, plus ratio as a third outfit for proportion.",
                    "terminating, repeating, ratio, reciprocal, simplest form");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Multiply fractions including mixed numbers.",
                            "Divide a quantity in a part:part or part:whole ratio.",
                            "Find any percentage of an amount, including reverse 3% is 27."},
                    LessonHtml.p("Convert mixed numbers to improper fractions before multiplying. 45% of 20 equals 20% of 45 — commutativity of multiplication in disguise.")
                            + LessonHtml.p("Share $80 in the ratio 3:5: total 8 parts, one part $10, so $30 and $50.")
                            + LessonHtml.p("If 3% is 27, then 1% is 9 and 100% is 900. Reverse percentage is division by the given percent."),
                    "Splitting a fundraising target among three year-groups in a ratio is school-life proportion.",
                    new String[]{"Write mixed numbers as improper fractions.", "Find one part.", "Scale to the asked parts.", "Check the parts sum to the whole."},
                    "Share 40 in 3:5", "8 parts, 5 each. 15 and 25. 15+25=40.",
                    "3% is 27. Find 100%",
                    "1% = 9, 100% = 900.",
                    null,
                    "Do not allocate 3/5 of 40 to the first named person in 3:5 — that would ignore that 3+5=8 parts.",
                    "Always add ratio parts to get the whole unless the ratio is already part:whole.",
                    "Mixed-number multiplication, ratio shares, and reverse percentages.",
                    "part:part, part:whole, mixed number, reverse percentage");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Work with recurring decimals and reverse percentages including increase.",
                            "Calculate percentage change: (new − original) / original × 100%.",
                            "Link ratios to linear equations (preview of algebra)."},
                    LessonHtml.p("A price that rises from $50 to $65 has increased by $15, which is 15/50 = 30%. Decrease uses the same structure with a negative change.")
                            + LessonHtml.p("If a price includes 15% GST, exclusive amount = inclusive ÷ 1.15. Reverse percentages need the correct multiplier.")
                            + LessonHtml.p("Recurring-decimal notation (0.1̇6̇) should be recognised as a rational number."),
                    "Council rates notices and GST-inclusive advertising are reverse-percentage literacy for young citizens.",
                    new String[]{"Identify original and new.", "Write change/original.", "Convert to %.", "For reverse, divide by (1 ± r)."},
                    "Increase 80 by 15%", "80 × 1.15 = 92.",
                    "A GST-inclusive price is $92. Find exclusive (15% GST)",
                    "92 ÷ 1.15 = 80.",
                    null,
                    "Percentage change is always compared with the original, not the new, unless the question says otherwise.",
                    "Write the multiplier 1.15 or 0.85 before calculating so the reverse is obvious.",
                    "Percentage change and reverse percentages with the correct base.",
                    "percentage change, GST inclusive, multiplier, recurring");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                    new String[]{"Use proportional reasoning in compound contexts (rates × percentages).",
                            "Choose fraction, decimal, % or ratio for the cleanest working.",
                            "Communicate exact vs rounded answers."},
                    LessonHtml.p("Year 10 proportional problems stack ideas: a 20% discount then 15% GST, or a ratio share then a percentage tax. Compute sequentially with multipliers, not by adding percents that apply to different bases.")
                            + LessonHtml.p("Exact answers stay as fractions until the context wants money (2 d.p.) or a rounded percent.")
                            + LessonHtml.p("If two rates are involved (km in 45 min, then % of a journey), convert to consistent units first."),
                    "A multi-stop bus fare discount plus GST is a stacked-multiplier problem — very Year 10.",
                    new String[]{"Sketch a chain of multipliers.", "Keep an exact form in the middle.", "Round only at the end.", "Check with a rough estimate."},
                    "20% off, then add 15% GST, on $50 exclusive",
                    "After discount $40. Then ×1.15 = $46. Not 35% combined.",
                    "Express 18:24 in simplest form",
                    "Divide by 6: 3:4.",
                    null,
                    "Adding 20% and 15% to get 35% off-then-tax is wrong because the bases differ.",
                    "Draw arrows: original → after discount → after GST.",
                    "Stacked proportional change with the right base each time.",
                    "compound percentage, consistent units, exact, rounded");
        };
    }

    private static String fdpEarly(int y, String focus, String meaning, String example, String vocab) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Number · rational numbers",
                new String[]{"Recognise that a whole can be split into two equal parts called halves.",
                        "Share a small set into two equal groups.",
                        "Use half, whole, equal and share correctly."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("You do not need fraction symbols every day yet, but you should connect 1/2 to a picture of two matching parts with one considered."),
                "Cutting fruit or a sandwich into two matching pieces is a half only if the pieces are equal. Fairness is the mathematics.",
                new String[]{"Name the whole.", "Split into two matching parts.", "Point to one part and call it a half.", "Recombine to check."},
                "Half a sandwich", "Two matching pieces. Two halves make one whole.",
                "Half of a set", example,
                LessonHtml.table(new String[]{"Word", "Meaning"}, new String[][]{{"whole", "the complete thing or set"}, {"half", "one of two equal parts"}, {"equal", "the same amount"}}),
                "Two pieces are not halves if one is bigger.",
                "Fair share first, then name the part.",
                "A half is one of two equal parts of a whole or of a set. Focus: " + focus + ".",
                vocab);
    }

    private static String algebra(int y) {
        return switch (y) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Copy, continue and describe a two-element repeating pattern.",
                            "Use 1st–5th for position.",
                            "Treat = as 'same amount', not 'write the answer here'."},
                    LessonHtml.p("A repeating pattern has a unit of repeat (clap-stamp). If you can name the chunk, you can predict the next element. The equal sign means both sides name the same quantity: 2+3=4+1 is true.")
                            + LessonHtml.p("Ordinal numbers let you say which element you mean. Open sentences such as 2+5=3+□ appear as missing-number puzzles."),
                    "Tukutuku and kōwhaiwhai often use a unit of repeat — the same habit as ABAB colour patterns.",
                    new String[]{"Say the sequence and find the repeating chunk.", "Check the chunk is stable.", "Predict next or missing elements.", "For equations, evaluate both sides."},
                    "Red, blue, red, blue, red, ____", "Unit red-blue. Next is blue.",
                    "Is 3+1=2+2 true?", "Both sides 4. True.",
                    null,
                    "Do not treat = as a button that dumps an answer on the right.",
                    "Circle the repeating chunk in colour.",
                    "Find the unit of repeat; treat equals as balance.",
                    "pattern, repeat, unit, equal, 1st, 2nd");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Work with three-element repeating patterns and missing elements.",
                            "Complete open sentences with + and −.",
                            "Use × and ÷ symbols in number sentences."},
                    LessonHtml.p("The unit of repeat can be three elements (ABCABC). A missing element is found from the unit, not from guessing a pretty colour.")
                            + LessonHtml.p("Open sentences: 2+5=3+□. The unknown is the number that keeps both sides equal. × and ÷ now appear as symbols for equal groups."),
                    "A poi pattern or a waiata echo can be a three-beat unit of repeat.",
                    new String[]{"Mark the unit.", "Map the missing slot onto the unit.", "For □, ask 'what keeps the sides equal?'", "Check by substituting."},
                    "red, green, blue, red, ____, blue", "Unit RGB. Missing is green.",
                    "6÷□=2", "□=3 because 6÷3=2.",
                    null,
                    "Filling a gap with 'whatever looks next' without naming the unit leads to errors in longer patterns.",
                    "Substitute your □ back into the sentence every time.",
                    "Three-element repeats and the unknown as a balanced amount.",
                    "unit of repeat, unknown, number sentence, true, false");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Recognise and continue growing number patterns.",
                            "Check true/false sentences with all four operations up to 1,000.",
                            "Complete open sentences such as 217−□=105."},
                    LessonHtml.p("A growing pattern changes by a consistent rule (add 3 each time). Repeating patterns still exist, but Year 3 emphasises growth you can describe in words.")
                            + LessonHtml.p("Equality is still balance. 12÷3=5−2 should be checked as 4=3, which is false. Comparison symbols &gt; and &lt; join =."),
                    "Growing patterns appear in kōwhaiwhai that add a new koru each cycle — count the increase.",
                    new String[]{"Find what changes from term to term.", "Write the rule in words.", "Test on the next two terms.", "For sentences, compute each side separately."},
                    "2, 5, 8, 11, … next?", "Add 3: next is 14.",
                    "313&lt;330 ?", "Yes. Hundreds equal, tens 1&lt;3.",
                    null,
                    "A pattern that adds 2 then 3 then 2 is not a single constant-difference growing pattern — describe what you actually see.",
                    "Word rules before symbols: 'add 3 each time' is the algebra.",
                    "Growing patterns plus honest true/false sentences.",
                    "growing pattern, rule, greater than, less than, open sentence");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Describe growing patterns that add, subtract or multiply by a constant.",
                            "Use a table of position and value.",
                            "Keep both sides balanced when you add the same amount to each side."},
                    LessonHtml.p("Arithmetically growing patterns add or subtract a constant (5, 7, 9, 11). Geometrically growing patterns multiply or divide by a constant (3, 6, 12, 24). Tables reveal the rule.")
                            + LessonHtml.p("Balance: doing the same operation to both sides of a true sentence keeps it true. That is the seed of solving equations.")
                            + LessonHtml.p("You complete sentences like 4200−□=4001 and judge 11×7=78 (false)."),
                    "A growing taniko band that adds two stitches each row is an arithmetic growth you can table.",
                    new String[]{"Make a table: term number | value.", "Look at differences or ratios.", "Write a word rule.", "Predict a further term and test."},
                    "5, 7, 9, 11 … 10th term?",
                    "Starts at 5, adds 2 each time. After 9 steps of +2: 5+18=23. (Term 1 is 5.)",
                    "Is 11×7=78 true?", "11×7=77, so false.",
                    null,
                    "Mixing up term number and term value (calling the 4th term '4') is a frequent error.",
                    "Number the terms 1, 2, 3… in a table before hunting for n.",
                    "Constant change, tables, and balance on both sides.",
                    "arithmetic sequence, geometric (×) sequence, table, balance, conjecture");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Use &gt;, &lt; and = between expressions, not only between numbers.",
                            "Continue patterns with constant decimal change (3, 4.5, 6…).",
                            "Plot coordinate points in the first quadrant from a table."},
                    LessonHtml.p("A coordinate plane is two number lines meeting at (0,0). An ordered pair (x, y) means along, then up. Plotting a growing pattern can reveal a straight line when the change is constant.")
                            + LessonHtml.p("Inequalities compare expressions: 2,456+203,938 versus 3,456+231,930 — you do not always need the exact totals if you compare structure.")
                            + LessonHtml.p("A rule in words becomes a machine: 'double then add 1' later becomes 2n+1."),
                    "A map grid of a local park is a coordinate plane with different labels — same idea as (x, y).",
                    new String[]{"Build a table from the rule.", "Plot (term, value) or (x, y).", "Look for a straight alignment when the difference is constant.", "State the rule in words."},
                    "Rule: add 1.5 each time, start 3. Next three terms?",
                    "3, 4.5, 6, 7.5, 9.",
                    "Plot (2, 5) from y = 2x+1",
                    MathFigures.coordinatePoint(2, 5, "From the origin: 2 along the x-axis, then 5 up.")
                            + "<p>x = 2, y = 5. Ordered pair (2, 5) is not the same as (5, 2).</p>",
                    null,
                    "(2,5) is not the same as (5,2). Order in an ordered pair is the definition.",
                    "If points are not collinear, the rule is not a constant difference.",
                    "Inequalities, decimal growth, and first-quadrant coordinates.",
                    "coordinate, ordered pair, x-axis, y-axis, inequality, rule");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Write a rule for a growing pattern and test further terms.",
                            "Generate a table and plot it on a coordinate plane.",
                            "Use ≤ and ≥ as well as &lt; and &gt;."},
                    LessonHtml.p("A linear rule has a constant difference. Term n of 3, 7, 11, 15… is 4n−1 (check: n=1 → 3). Always test at least two terms.")
                            + LessonHtml.p("Inequalities may include equality: 8×7 ≤ 8×5+4². GEMA applies inside comparisons.")
                            + LessonHtml.p("The coordinate plane can include points on the axes, such as (0, 3) or (4, 0).")
                            + LessonHtml.worked("Build the n-rule for 4, 7, 10, 13…",
                            LessonHtml.lines(
                                    "Constant difference d = 3.",
                                    "Term 1 is 4, so the rule looks like 3n + something.",
                                    "When n=1: 3(1)+□=4, so □=1. Rule: 3n+1.",
                                    "Check n=4: 3×4+1=13. Matches."))
                            + LessonHtml.worked("A sausage sizzle: $3 per sausage, $2 booking. Cost C for n sausages.",
                            LessonHtml.lines(
                                    "C = 3n + 2",
                                    "For 5 sausages: C = 15+2 = $17",
                                    "If the bill is $20: 3n+2=20, 3n=18, n=6 sausages.")),
                    "A fundraising graph of 'dollars versus week number' is a coordinate picture of a linear rule.",
                    new String[]{"Find the constant difference d.", "Connect term 1 to the n-rule.", "Test n=1 and n=2.", "Plot and see if the line is straight."},
                    "2, 5, 8, 11… rule for term n",
                    "Difference 3. Term n = 3n−1. Check n=1: 2. n=4: 11.",
                    "8×7 ≤ 8×5 + 4² ?",
                    "56 ≤ 40+16 → 56 ≤ 56. True (equal is allowed by ≤).",
                    null,
                    "3n+1 and 3n−1 both grow by 3 but start differently — check n=1.",
                    "A table plus a graph catches a wrong rule faster than either alone.",
                    "n-rules, plots, and inequalities that allow equality.",
                    "linear rule, constant difference, inequality, coordinate plane");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Use a letter as an unknown, a variable, or a formula placeholder.",
                            "Form and solve one- and two-step linear equations with integer solutions.",
                            "Simplify like terms and write 3b for b+b+b."},
                    LessonHtml.p("Algebra notation: 3b means 3×b, not 3+b. b means 1b. Division can be a fraction bar. Substitution: if w=4, then w+12=16.")
                            + LessonHtml.p("Solve by inverse operations: 5s+3=18 → subtract 3 → 5s=15 → divide by 5 → s=3. Trial and error works but is inefficient.")
                            + LessonHtml.p("Like terms share the same letter and power: 3x and 5x combine to 8x; 3x and 5y do not.")
                            + linearEquationsDetail(7),
                    "Formula for a rectangle A=bh is algebra in measurement — the same letters you solve for in equations.",
                    new String[]{"Name what the letter stands for.", "Do the inverse of the last operation first.", "Simplify like terms before solving if needed.", "Substitute back to check."},
                    "5s+3=18",
                    MathFigures.numberLine(0, 18, 3, "s = 3 sits on the number line. Check: 5×3 + 3 = 18.")
                            + "<p>5s = 15, so s = 3. Substitute back: 15 + 3 = 18.</p>",
                    "Simplify 3x+2x+4", "5x+4. The 4 is a constant, not an x term.",
                    LessonHtml.table(new String[]{"Notation", "Meaning"},
                            new String[][]{{"3b", "b+b+b or 3×b"}, {"b", "1×b"}, {"b/2", "b÷2"}}),
                    "3b = 3+b is the most common reading error. Juxtaposition means multiply.",
                    "Always check by substitution. An arithmetic slip hides if you skip the check.",
                    "Letters, like terms, and inverse steps for linear equations.",
                    "variable, unknown, like terms, substitution, inverse");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Solve linear equations with rational solutions and linear inequalities.",
                            "Represent inequality solutions on a number line.",
                            "Plot a straight line from a table or from y=mx+c in simple cases."},
                    LessonHtml.p("Equations may have decimal or negative solutions: 5s+9=−18 → 5s=−27 → s=−5.4. Inequalities: t−3 ≥ −5 → t ≥ −2, with a closed circle on −2 and an arrow right.")
                            + LessonHtml.p("A straight line has a constant gradient m (rise/run) and intercept c where it meets the y-axis. y=2x+1 is a machine: input x, output y.")
                            + LessonHtml.p("Forming the equation from a word problem is half the mathematics. Define the letter in a sentence first.")
                            + linearEquationsDetail(8),
                    "A phone plan $12 plus $0.50 per extra gigabyte is y=0.5x+12 — a linear model of a real bill.",
                    new String[]{"Define the unknown.", "Write the equation or inequality.", "Solve with inverses (flip the inequality if you multiply/divide by a negative).", "Graph or check."},
                    "t−3 ≥ −5", "t ≥ −2. Closed circle at −2, shade right.",
                    "y=2x+1 when x=4",
                    MathFigures.coordinatePoint(4, 9, "The point (4, 9) sits on the line y = 2x + 1.")
                            + "<p>y = 2×4 + 1 = 9.</p>",
                    null,
                    "Multiplying both sides of an inequality by a negative reverses the sign. Forgetting that is a classic error.",
                    "Gradient is rise over run, not run over rise.",
                    "Rational solutions, inequalities on a line, and y=mx+c as a story.",
                    "gradient, intercept, inequality, closed circle, linear");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Solve two linear equations simultaneously (elimination or substitution).",
                            "Rearrange formulae to change the subject.",
                            "Expand single brackets and factorise simple expressions."},
                    LessonHtml.p("Two unknowns need two independent equations. A pair (x, y) is a solution only if it makes <em>both</em> equations true at once. Graphically that is the intersection of two straight lines.")
                            + LessonHtml.p("You will learn two algebraic methods in full: <strong>substitution</strong> (replace a letter with an expression) and <strong>elimination</strong> (add or subtract equations so one letter cancels).")
                            + LessonHtml.p("Changing the subject of v=u+at to t=(v−u)/a is inverse operations in a formula. Expand: 3(x+4)=3x+12. Factor: 3x+12=3(x+4).")
                            + simultaneousDetail(),
                    "Two adults' ticket totals at a stadium kiosk can become a two-equation story (ticket + snack).",
                    new String[]{"Label both unknowns.", "Choose substitution if one letter is already isolated.", "Otherwise align coefficients and eliminate.", "Substitute back and check both originals."},
                    "x+y=10 and y=x+2", "x+(x+2)=10, 2x=8, x=4, y=6.",
                    "Make t the subject of v=u+at", "v−u=at, t=(v−u)/a.",
                    null,
                    "Finding a pair that fits one equation but not the other is not a solution of the system.",
                    "Write a check against both original equations, not the one you just used to substitute.",
                    "Simultaneous linear equations, rearrangement, expand/factor.",
                    "simultaneous, substitution, elimination, subject, expand, factorise");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Algebra | Taurangi",
                    new String[]{"Expand double brackets and factorise simple quadratics.",
                            "Solve x²+bx+c=0 by factorising where possible.",
                            "Sketch y=x² and simple translations; identify vertex and intercepts."},
                    LessonHtml.p("A quadratic involves x². Expanding (x+3)(x+2)=x²+5x+6 uses FOIL or an area model. Factorising reverses it. If (x+3)(x+2)=0 then x=−3 or x=−2 (null factor law).")
                            + LessonHtml.p("The graph of y=x² is a parabola, vertex at the origin, opening up. y=(x−1)²−4 has moved 1 right and 4 down.")
                            + LessonHtml.p("Not every quadratic factorises nicely over the integers. Year 10 also meets the idea of a discriminant later in some programmes; here we stay with factorising and graphs.")
                            + quadraticDetail(),
                    "The path of a kicked ball is approximately parabolic — a physical picture of y=ax²+bx+c, even if air resistance complicates the real world.",
                    new String[]{"Write =0.", "Factor if you can.", "Set each factor equal to 0.", "Check in the original; sketch intercepts."},
                    "Solve x²+5x+6=0", "(x+2)(x+3)=0 so x=−2 or x=−3.",
                    "Expand (x+4)(x−1)", "x²+3x−4.",
                    LessonHtml.table(new String[]{"Graph", "Feature"},
                            new String[][]{{"y=x²", "vertex (0,0), opens up"}, {"y=−x²", "opens down"}, {"y=(x−2)²", "vertex (2,0)"}}),
                    "x²+5x+6=0 is not solved by x²=−5x−6 without finishing. Factor or complete a valid method.",
                    "The solutions are x-intercepts of the parabola. A sketch catches extra or missing roots.",
                    "Quadratics: expand, factor, solve, sketch.",
                    "quadratic, parabola, vertex, intercept, null factor, FOIL");
        };
    }

    private static String measure(int y) {
        return measBody(y);
    }

    private static String measBody(int y) {
        String[][] pack = switch (y) {
            case 1 -> new String[][]{
                    {"Compare two objects directly by length, mass or capacity.", "Use longer/shorter, heavier/lighter, holds more/less.", "Talk about full, half-full and empty."},
                    {"Measurement answers how long, how heavy, how much it holds. Year 1 compares directly: pencils side by side, bags in two hands, pouring between cups."},
                    {"Length is distance between points. Mass is heaviness. Capacity is how much liquid a container can hold. Fair comparison means the same starting line and no stretched string."},
                    {"Traditional Māori measurement often used the body (for example an arm span). Informal units are units people can share and repeat."},
                    {"Name the attribute.", "Line up starting points or use the same balance.", "Say which is more/less.", "Swap sides to check."},
                    {"Which ribbon is longer?", "Match left ends. The one that sticks out is longer.", "Which bag is heavier?", "The books pull down more than the feathers, even if that bag looks smaller."},
                    {"A taller glass does not always hold more. Width matters for capacity.", "Always name the attribute. Do not say a rock is 'longer' when you mean heavier.", "Name, compare fairly, use precise words.", "length, mass, capacity, longer, heavier, full, empty"}
            };
            case 2 -> new String[][]{
                    {"Measure length in cm, mass in g and capacity in mL with labelled tools.", "Use informal units first, then standard units.", "Compare several objects using the same unit."},
                    {"Standard units let people communicate. A centimetre on a ruler is the same in Kaitāia and Invercargill. Informal units (paper clips) must be the same size with no gaps."},
                    {"Estimate first using a benchmark (a finger about 1 cm wide), then measure. Record the unit every time."},
                    {"Kitchen millilitres on a medicine cup and gram scales in technology are Year 2 tools in real life."},
                    {"Estimate.", "Choose the tool and unit.", "Measure with no gaps/overlaps.", "Record number and unit."},
                    {"A pencil about 15 cm", "Estimate: longer than 10 cm, shorter than a 30 cm ruler. Measure: 16 cm.", "Which holds more, 200 mL or 1 L?", "1 L = 1000 mL, so 1 L holds more."},
                    {"Mixing cm and m in one answer without converting (3 m + 40 cm ≠ 43).", "Write the unit. 15 means nothing without cm.", "Estimate, measure with a standard unit, record the unit.", "centimetre, gram, millilitre, estimate, unit, benchmark"}
            };
            case 3 -> new String[][]{
                    {"Measure length in m and cm, mass in kg and g, capacity in L and mL.", "Find the perimeter of a polygon by adding side lengths.", "Compare and order using whole-number metric units."},
                    {"Perimeter is the distance around a closed 2-D shape — the sum of its sides. A polygon has straight sides that join up."},
                    {"You now choose m versus cm: a classroom is metres; a rubber is centimetres. Kilograms for a school bag; grams for an apple."},
                    {"A sports field perimeter in metres is a practical Year 3 measure; running the boundary is walking the perimeter."},
                    {"Choose a sensible unit.", "Measure each side in the same unit.", "Add for perimeter.", "Check by estimating the loop."},
                    {"A 6 cm by 4 cm rectangle, perimeter?", "6+4+6+4=20 cm. Or 2×(6+4)=20 cm.", "Order 800 mL, 1 L, 90 mL", "90 mL, 800 mL, 1 L (1000 mL)."},
                    {"Adding 3 m and 40 cm as 43. Convert first: 3.40 m or 340 cm.", "Tick each side as you add so a side is not missed.", "Same units, then add for perimeter.", "metre, kilogram, litre, perimeter, polygon"}
            };
            case 4 -> new String[][]{
                    {"Calculate rectangle area by length × width.", "Tell analogue and digital time to the nearest minute.", "Convert m and cm; use mixed units such as 1 m 23 cm."},
                    {"Area is the measure of a region. A rectangle of 8 cm by 5 cm contains 40 centimetre squares, so area is 40 cm². Perimeter is still the fence; area is the grass."},
                    {"Time uses 60: 60 seconds = 1 minute, 60 minutes = 1 hour. Duration problems need a timeline more than mental borrowing from base 10."},
                    {"A PE lesson from 1:45 to 2:20 is 35 minutes — elapsed time across the hour."},
                    {"Sketch and label sides.", "For area, multiply; for perimeter, add.", "For time, jump to the next hour then add leftover minutes if that helps.", "Include units (cm² vs cm)."},
                    {"Area of 8 by 5", "40 cm². Perimeter 26 cm. Different answers, different attributes.", "2:53 to 3:28", "7 min to 3:00, plus 28 = 35 min."},
                    {"Using cm for area. Area needs square units.", "Shapes with the same area can have different perimeters.", "Area vs perimeter, mixed metric length, time to the minute.", "area, square centimetre, duration, analogue, digital"}
            };
            case 5 -> new String[][]{
                    {"Use milli-, centi- and kilo- prefixes; convert g↔kg and mL↔L.", "Classify angles as acute, right, obtuse, straight, reflex.", "Find volume of a cuboid by layers of cubes."},
                    {"Prefixes scale the base unit: milli- is 1/1000, centi- 1/100, kilo- ×1000. 10.5 kg = 10 kg 500 g."},
                    {"Angles measure turn in degrees: 90° right, 180° straight, 360° full turn. Acute &lt; 90°, obtuse between 90° and 180°, reflex between 180° and 360°."},
                    {"A protractor in a technology drawing, and a 1 cm³ cube (centicube) for volume, are standard Year 5 tools."},
                    {"Convert to one unit before combining.", "Compare an angle to 90° and 180° before measuring.", "Volume: cubes in one layer × number of layers, or l×w×h.", "State cm³ or m³."},
                    {"10 kg 500 g in kg", "10.5 kg.", "An angle a bit more than a corner of a page", "Obtuse (if less than 180°)."},
                    {"Calling every 'big' angle reflex. Reflex starts after 180°.", "Volume of a cuboid is not the same as surface area.", "Prefixes, angle classes, and cuboid volume.", "kilo, milli, acute, obtuse, reflex, cubic centimetre"}
            };
            case 6 -> new String[][]{
                    {"Calculate area of rectangles and right-angled triangles; volume of rectangular prisms in cm³/m³.", "Use a protractor to 360°; know angles on a straight line and at a point.", "Read 12- and 24-hour time and timetables."},
                    {"A right triangle is half a rectangle with the same base and height: A = ½bh. Vertically opposite angles are equal; angles on a line sum to 180°; at a point to 360°."},
                    {"Elapsed time across noon/midnight needs 12/24-hour conversion. 24-hour 15:10 is 3:10 p.m."},
                    {"Bus timetables in 24-hour time are a civic measurement skill in Aotearoa towns and cities.",},
                    {"Identify the attribute (area, volume, angle, duration).", "Choose the fact or formula.", "Convert units if mixed.", "Check with an estimate."},
                    {"Right triangle base 10 cm height 6 cm", "Area ½×10×6=30 cm².", "Angles on a line: one is 125°, the adjacent?", "180−125=55°."},
                    {"Using ½bh for a non-right triangle without an identified perpendicular height.", "Always mark the right angle before using ½bh this year.", "Triangle area, angle facts, and timetable duration.", "right-angled triangle, protractor, vertically opposite, 24-hour time"}
            };
            case 7 -> new String[][]{
                    {"Compute perimeter and area of compound rectilinear shapes.", "Use C=πd and A=πr² with π as 3.14 or a calculator π.", "Solve duration problems including overnight."},
                    {"A compound shape can be split into rectangles (add) or thought of as a large rectangle minus a cut-out (subtract). Circles: radius to centre, diameter across; C=2πr=πd."},
                    {"π is the constant ratio of circumference to diameter for every circle. Year 7 uses it as a given number, not a mystery."},
                    {"Running a circular field or taping a hula hoop is circumference in PE.",},
                    {"Sketch and split the shape.", "Label all lengths you need (missing sides from subtraction).", "For circles, know whether you have r or d.", "Include units."},
                    {"Circle diameter 10 cm, C ≈ ?", "πd ≈ 3.14×10=31.4 cm.", "L-shape 8 by 6 missing a 3 by 2 corner", "Area 8×6−3×2=42."},
                    {"Using radius in πd or diameter in πr². Match the formula to the given length.", "Write π in the working if the question wants an exact answer.", "Compound area, circle formulae, careful duration.", "compound shape, radius, diameter, circumference, π"}
            };
            case 8 -> new String[][]{
                    {"Use Pythagoras: a²+b²=c² for right triangles (c hypotenuse).", "Find surface area of cuboids by summing face areas.", "Convert between metric units including cm³ and mL (1 cm³=1 mL)."},
                    {"In a right triangle the square on the hypotenuse equals the sum of squares on the other two sides. Always identify the hypotenuse as the side opposite the right angle (longest side)."},
                    {"Surface area is the wrapping paper; volume is the space inside. Do not swap the formulae."},
                    {"A wheelchair ramp's length from height and run is Pythagoras in a technology/HPE accessibility context.",},
                    {"Confirm a right angle exists.", "Label hypotenuse c.", "Substitute, square root last.", "Units: length, not length², after the root."},
                    {"Legs 3 and 4, hypotenuse?", "9+16=25, c=5. The 3-4-5 triangle.", "Cuboid 2 by 3 by 4, volume", "24 cubic units. SA=2(2×3+2×4+3×4)=52."},
                    {"Putting the longest given side as a leg automatically. Check where the right angle is.", "Square root is the last step, not the first.", "Pythagoras, surface area, and 3-D unit links.", "hypotenuse, Pythagoras, surface area, volume"}
            };
            case 9 -> new String[][]{
                    {"Use sin, cos, tan as opposite/hypotenuse, adjacent/hypotenuse, opposite/adjacent.",
                            "Choose the ratio from the named angle.", "Solve for a side, and for an angle using inverse trig."},
                    {"Trigonometry compares sides in a right triangle. SOH CAH TOA is a memory aid: sin θ = O/H, cos θ = A/H, tan θ = O/A. The adjacent and opposite names depend on which acute angle you are using."},
                    {"Inverse sin/cos/tan (sin⁻¹) recover an angle from a ratio. Always check your calculator is in degrees unless the question uses radians (rare at Year 9)."},
                    {"Finding the height of a flagpole from a measured angle of elevation is a classic Aotearoa school-ground trig task.",},
                    {"Sketch; mark the angle.", "Label O, A, H relative to that angle.", "Pick the ratio that uses the two sides you have/need.", "Solve; check with an estimate (angles near 45° have tan≈1)."},
                    {"Angle 30°, hypotenuse 10, opposite?", "sin 30°=1/2, so opposite=5.", "Opposite 4, adjacent 4, angle?", "tan θ=1, θ=45°."},
                    {"Swapping opposite and adjacent when the angle moves to the other acute corner.", "Degrees mode on the calculator. Radians produce nonsense numbers here.", "Right-triangle trig: choose the ratio, then invert if needed.", "sine, cosine, tangent, opposite, adjacent, hypotenuse, angle of elevation"}
            };
            default -> new String[][]{
                    {"Find surface area and volume of prisms and cylinders.", "Keep π exact or rounded as the question asks.", "Solve multi-step problems that mix Pythagoras or trig with area/volume."},
                    {"A prism has a uniform cross-section. Volume = area of cross-section × length. Cylinder: V=πr²h, SA=2πr²+2πrh (two circles + rectangle wrap)."},
                    {"A triangular prism needs the triangular area first (½bh) then times length. Missing lengths may need Pythagoras."},
                    {"Water tanks (cylinders) on NZ farms and school hall volumes (prisms) are authentic measurement contexts.",},
                    {"Identify the solid.", "Find any missing length.", "Write the formula.", "Substitute; units cubed or squared."},
                    {"Cylinder r=3, h=10, V", "π×9×10=90π (exact) ≈ 283 cubic units if π=3.14.", "Why SA includes 2πrh", "The curved wrap is a rectangle of sides C=2πr and h."},
                    {"Using diameter as radius. Always halve d to get r.", "Volume uses cubic units; a length answer after V= is a red flag.", "Prism/cylinder SA and volume, with lengths found as needed.", "prism, cylinder, cross-section, surface area, volume"}
            };
        };
        String[] goals = pack[0];
        String meaning = LessonHtml.p(pack[1][0]) + LessonHtml.p(pack[2][0]);
        String aotearoa = pack[3][0];
        String[] steps = pack[4];
        String warn = pack[6][0], tip = pack[6][1], recap = pack[6][2], vocab = pack[6][3];
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Measurement | Ine", goals, meaning, aotearoa, steps,
                pack[5][0], pack[5][1], pack[5][2], pack[5][3], measureFigure(y), warn, tip, recap, vocab);
    }

    private static String measureFigure(int y) {
        return switch (y) {
            case 1 -> MathFigures.rectangle(8, 3, "Compare length by lining up the same starting edge.");
            case 2, 3 -> MathFigures.rectangle(6, 4, "A 6 cm by 4 cm rectangle. Perimeter adds the four sides.");
            case 4 -> MathFigures.rectangle(8, 5, "Area is the grass (8 × 5). Perimeter is the fence.");
            case 5 -> MathFigures.rightTriangle(8, 6, null, "Compare this angle with a square corner: acute, right or obtuse?");
            case 6 -> MathFigures.rightTriangle(10, 6, null, "Right triangle: area is half of the 10 cm by 6 cm rectangle.");
            case 7 -> MathFigures.lShape(8, 6, 3, 2, "Compound shape: add two rectangles, or subtract a cut-out.")
                    + MathFigures.circle(10, "Every circle: C = πd and A = πr². Diameter is twice the radius.");
            case 8 -> MathFigures.pythagoras345("Pythagoras: 3² + 4² = 5². The square on the hypotenuse is 25.");
            case 9 -> MathFigures.rightTriangle(4, 4, "hyp", "SOH CAH TOA: label opposite, adjacent and hypotenuse from the marked angle.");
            default -> MathFigures.circle(6, "Cylinder volume uses the circle area πr², then multiply by height.");
        };
    }

    private static String geometry(int y) {
        return switch (y) {
            case 1 -> geoSimple(y, "Name circle, triangle, square, rectangle and everyday 3-D (sphere, cube, cylinder).",
                    "Count sides and corners. A square is still a square when rotated.",
                    "Wharenui gables (triangles), portholes (circles), drink cans (cylinders).",
                    "side, corner, circle, triangle, square, cube, next to, above");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Distinguish 2-D and 3-D and name more solids (cuboid, cone, pyramid).",
                            "Describe quarter, half and full turns, clockwise and anticlockwise.",
                            "Use position language and simple pathways."},
                    LessonHtml.p("A turn is a rotation around a point. Quarter, half, three-quarter and full turns are benchmarks before degrees. Clockwise is the way clock hands move.")
                            + LessonHtml.p("2-D shapes are faces of 3-D objects. A cube's face is a square. Looking from different viewpoints changes what you see, not the object itself."),
                    "A poi swing or a compass turn in the hall is a quarter-turn in the body — geometry you can feel.",
                    new String[]{"Decide 2-D or 3-D.", "Count faces/edges/vertices for solids.", "Show the turn with an arm or object.", "Give a pathway with position words."},
                    "Face of a die", "A cube has 6 square faces, 12 edges, 8 vertices.",
                    "Face the window, quarter turn clockwise", "You now face a different wall. A quarter turn is a right-angle turn.",
                    null,
                    "Calling a cuboid a cube. Cubes have all edges equal.",
                    "Stand up to test turns. Body memory supports later 90° language.",
                    "Solids, turns and pathways.",
                    "cuboid, cone, pyramid, clockwise, quarter turn, face, edge, vertex");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Identify polygons by number of sides (up to octagon).",
                            "Use half and quarter turns as right-angle language.",
                            "Read a simple map with near/far and left/right."},
                    LessonHtml.p("A polygon is a closed 2-D shape with straight sides. Pentagon 5, hexagon 6, octagon 8. Regular means equal sides and equal angles — that word becomes important in Year 4.")
                            + LessonHtml.p("Maps are a view from above. A key explains symbols. You describe a path from the classroom to the field without needing scale yet."),
                    "A netball court diagram is a map of polygons and pathways.",
                    new String[]{"Count sides to name the polygon.", "Check it is closed and straight-edged.", "Plan a path with turns.", "Use the map key."},
                    "Stop sign shape (in many countries)", "Regular octagon — 8 equal sides.",
                    "Path: forward, quarter turn left, forward", "Two segments and a 90° turn.",
                    null,
                    "A star is not a simple polygon in Year 3 classification — stick to one closed loop.",
                    "Trace the outline; if you lift your finger, you may have counted a side twice.",
                    "Polygons, right-angle turns, map talk.",
                    "polygon, pentagon, hexagon, octagon, map, key");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Classify regular and irregular polygons to 12 sides.",
                            "Find lines of symmetry; perform a single reflection, translation or rotation.",
                            "Use alphanumeric grid references (B3)."},
                    LessonHtml.p("Regular: all sides equal and all interior angles equal. A rectangle is not regular unless it is a square. Circles have infinitely many mirror lines.")
                            + LessonHtml.p("Reflection flips over a line; translation slides without turning; rotation turns about a point. Grid references name squares on a map: letter then number, or as the key says.")
                            + LessonHtml.p("Horizontal, vertical and diagonal are direction words for sides and lines of symmetry."),
                    "A street map of your town using A1, B2… is geometry of location.",
                    new String[]{"List attributes: sides, angles, symmetry lines.", "Name the transformation.", "For maps, read the key then the grid square.", "Check the image matches the rule (flip vs slide)."},
                    "Lines of symmetry of a rectangle (not a square)", "Two: midlines parallel to the sides. Diagonals are not mirror lines unless it is a square.",
                    "Translate a triangle 3 right, 1 up", "Every vertex moves the same; the triangle is congruent, not flipped.",
                    null,
                    "Rotating a shape is not the same as reflecting it — letters like 'b' and 'd' show the difference.",
                    "Folding (or imagining a fold) tests a mirror line.",
                    "Regularity, symmetry, one-step transformations, grid references.",
                    "regular, symmetry, reflection, translation, rotation, grid reference");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Identify prisms by cross-section, faces, edges and vertices.",
                            "Spot parallel and perpendicular lines, including in polygons.",
                            "Match a 3-D object to its net; use four compass points."},
                    LessonHtml.p("Parallel lines never meet and stay the same distance apart. Perpendicular lines meet at 90°. A prism has two identical parallel ends and rectangular sides along the length.")
                            + LessonHtml.p("A net is the unfolded surface. Not every arrangement of polygons folds to the solid — they must be an actual net.")
                            + LessonHtml.p("N, E, S, W support map pathways with distance in m or km."),
                    "Tāne Mahuta is a place you might map with compass directions from a visitor centre — geometry plus place.",
                    new String[]{"Name parallel/perpendicular pairs.", "Count faces of the prism (n-gon prism has n+2 faces).", "Test a net by imagining folds.", "Give a compass course."},
                    "A triangular prism", "5 faces (2 triangles + 3 rectangles), 9 edges, 6 vertices.",
                    "Which lines on an H are parallel?", "The two verticals are parallel; the crossbar is perpendicular to both.",
                    null,
                    "A pyramid is not a prism — it tapers to a point.",
                    "Sketch the net, then tick faces so none are missing or doubled.",
                    "Prisms, parallel/perpendicular, nets, compass.",
                    "parallel, perpendicular, prism, cross-section, net, compass");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Classify triangles and quadrilaterals (including kite, rhombus, trapezium, parallelogram).",
                            "Know rotational symmetry order; tessellate with rotation/reflection/translation.",
                            "Predict two-step transformations; use map scale."},
                    LessonHtml.p("Quadrilateral families overlap: a square is a rectangle, a rhombus and a parallelogram. Classify by properties (parallel sides, equal sides, right angles), not by a single picture in a textbook.")
                            + LessonHtml.p("Rotational symmetry order is how many times a shape matches itself in a 360° turn. A rectangle that is not a square has order 2. A circle has infinite order.")
                            + LessonHtml.p("Tessellation: shapes tile a plane with no gaps. Interior angles of triangles sum to 180°, quadrilaterals 360° — used more formally in Year 7."),
                    "Tiling in a swimming-pool changing room, or tukutuku-style repeating units, are tessellations.",
                    new String[]{"List properties, then choose the most specific name.", "Test rotational order by turning a tracing.", "Apply transformation 1, then 2, on tracing paper.", "Use scale: 1 cm to 1 km means multiply."},
                    "A rhombus that is not a square", "Four equal sides, opposite sides parallel, angles not all 90°.",
                    "Order of rotational symmetry of an equilateral triangle", "3.",
                    null,
                    "Calling every diamond a rhombus is fine; calling every rhombus a square is not.",
                    "The most specific name wins: square rather than 'just rectangle' when all sides are equal.",
                    "Quadrilateral properties, rotational symmetry, two-step moves, scale.",
                    "kite, rhombus, trapezium, parallelogram, tessellation, rotational symmetry, scale");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Use triangle angle sum 180° and quadrilateral 360° to find unknowns.",
                            "Apply transformations on a coordinate grid.",
                            "Solve angle problems with vertically opposite, straight line and point facts."},
                    LessonHtml.p("Geometric reasoning means a fact, not a guess from a sketch (sketches can lie). Mark given angles, then chain facts until the unknown is found.")
                            + LessonHtml.p("On a grid, rotation 90° about the origin maps (x, y) to (−y, x) in the usual anticlockwise convention used in many texts — always follow the question's direction.")
                            + LessonHtml.p("Co-interior, corresponding and alternate angles with parallel lines appear as you meet transversals."),
                    "A truss on a farm shed is a triangle because triangles are rigid — angle sum still 180° on each triangular face.",
                    new String[]{"Mark all given information.", "Write the fact you use (e.g. 'angles on a line').", "Calculate.", "State the unknown with a reason."},
                    "Triangle angles 70° and 50°, third?",
                    MathFigures.triangleAngles(70, 50, "?", "Mark the two known angles. The third is 180° − 120°.")
                            + "<p>180 − 70 − 50 = 60°.</p>",
                    "Point angles 90°, 90° and 120°, remaining?", "360−300=60°.",
                    MathFigures.anglesOnLine(125, "Angles on a straight line sum to 180°. If one is 125°, the adjacent is 55°."),
                    "Trusting a drawing that 'looks like' 90° without a right-angle mark.",
                    "Every step should name a fact. That is Year 7 reasoning.",
                    "Angle chains, grid transformations, reasons written down.",
                    "transversal, corresponding, alternate, co-interior, reason");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Know congruence (same shape and size) vs similarity (same shape, possibly scaled).",
                            "Use SSS, SAS, ASA, RHS as congruence tests in simple cases.",
                            "Scale a figure by a factor; relate to similar triangles."},
                    LessonHtml.p("Congruent shapes match by a sequence of rigid transformations (translate, rotate, reflect). Similar shapes match after a dilation (enlargement/reduction) as well. Corresponding angles of similar figures are equal; corresponding sides are in proportion.")
                            + LessonHtml.p("A scale factor k multiplies lengths; areas scale by k² (preview of Year 10).")
                            + LessonHtml.p("Reasons still matter: 'SAS' is a test, not a decoration."),
                    "Two maps of Aotearoa at different scales are similar (ideally) — angles of the coastline match, lengths proportional.",
                    new String[]{"Match corresponding vertices.", "Check angles equal and sides proportional.", "Name the test or the scale factor.", "Compute a missing length by proportion."},
                    "Triangles with sides 3,4,5 and 6,8,10", "Sides ×2, angles equal → similar (in fact both right-angled). Scale factor 2.",
                    "Enlarge a 5 cm side by k=3", "15 cm.",
                    null,
                    "AAA shows similarity, not congruence (size may differ).",
                    "Draw arrows between corresponding sides before writing a ratio.",
                    "Congruence tests, similarity and scale factor.",
                    "congruent, similar, corresponding, scale factor, SSS, SAS, ASA, RHS");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Use similar triangles to find heights and distances.",
                            "Interpret scale drawings and bearings from north.",
                            "Combine Pythagoras and similarity in one figure."},
                    LessonHtml.p("Bearings are usually measured clockwise from north, written as three figures (045°). Scale drawings need a stated scale and accurate corresponding angles.")
                            + LessonHtml.p("A shadow problem: a 1.5 m student casts 2 m, a tree casts 10 m → tree / 1.5 = 10 / 2, tree = 7.5 m, if the sun's rays are parallel (similar triangles).")
                            + LessonHtml.p("Accuracy: a bearing off by 10° is a navigation error, not a rounding issue."),
                    "Tramping map bearings and school orienteering courses are this lesson outdoors.",
                    new String[]{"Sketch north lines.", "Mark the bearing clockwise from north.", "Set up a similarity ratio with corresponding sides.", "Solve; include units."},
                    "Bearing 045°", "North-east. 45° clockwise from north.",
                    "Scale 1:50 000, 4 cm on map", "4 × 50 000 = 200 000 cm = 2 km.",
                    null,
                    "Measuring bearings from the nearest page edge instead of north.",
                    "Corresponding sides are between corresponding angles — mark them first.",
                    "Similarity in the field: bearings, scale, heights.",
                    "bearing, scale drawing, similar triangles, corresponding, north");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                    new String[]{"Write short deductive chains (given → fact → conclusion).",
                            "Use circle language: radius, chord, diameter, tangent, arc.",
                            "Solve problems that mix algebra with geometry (e.g. an angle as 2x)."},
                    LessonHtml.p("Year 10 geometry is about proof habits even when full circle theorems are only introduced: a diameter is a chord through the centre; a tangent meets a radius at 90° in the standard theorem set.")
                            + LessonHtml.p("If an angle is labelled 2x, the diagram is an equation waiting to happen. Geometry and algebra are one toolkit.")
                            + LessonHtml.p("Loci (a set of points a given distance from a point is a circle) appear in constructions."),
                    "A circular running track with a straight and a bend mixes circle and straight-line geometry in athletics.",
                    new String[]{"List givens.", "Name a fact.", "Write the consequence.", "Stop when the unknown is found; check units and diagram."},
                    "Radius 7 cm, diameter?", "14 cm. Diameter = 2r.",
                    "Angles in a triangle 2x, 3x, 40°", "5x+40=180, 5x=140, x=28. Angles 56°, 84°, 40°.",
                    null,
                    "Using a radius as if it were a diameter. Factor of 2 slips are expensive.",
                    "Mark equal radii — every radius of the same circle is equal. That one fact unlocks isosceles triangles.",
                    "Deduction, circle vocabulary, algebra-in-the-diagram.",
                    "radius, chord, tangent, arc, locus, deduction");
        };
    }

    private static String geoSimple(int y, String g1, String meaning, String nz, String vocab) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Geometry | Āhuahanga",
                new String[]{g1, "Talk about sides and corners (vertices).", "Describe position with in front, behind, next to, above, below."},
                LessonHtml.p("Geometry is the language of shape and space. A 2-D shape is flat; a 3-D object takes up space. Classify by properties, not by how pointy a drawing looks.")
                        + LessonHtml.p(meaning),
                nz,
                new String[]{"Decide 2-D or 3-D.", "Count sides and corners (or faces).", "Choose the name that matches properties.", "Use position words."},
                "A yield-style triangle", "3 sides, 3 corners — still a triangle if it is not sitting on a base.",
                "Position", "The glue stick is in front of the scissors and next to the ruler.",
                LessonHtml.table(new String[]{"Name", "Clue"}, new String[][]{{"triangle", "3 sides"}, {"square", "4 equal sides"}, {"circle", "no corners"}, {"cube", "6 square faces"}}),
                "A square is still a square if rotated to look like a diamond.",
                "Trace sides with a finger as you count.",
                "Name shapes by properties and describe where they are.",
                vocab);
    }

    private static String statistics(int y) {
        return switch (y) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Sort by one attribute.", "Make a tally or object graph.", "Say which category has more, fewer or the same."},
                    LessonHtml.p("Statistics starts with a question about a group. You sort, count and display so someone else can read the story. In Year 1, one picture = one item.")
                            + LessonHtml.p("After the display: which has most, least, and what that might mean without inventing extra people."),
                    "Favourite kai, travel to kura, or birds in the school grounds are local investigative questions.",
                    new String[]{"Ask a clear question.", "Sort and tally.", "Title and labels.", "Read most/least."},
                    "Apples 6, bananas 4, oranges 2",
                    MathFigures.barChart("Favourite fruit", new String[]{"Apple", "Banana", "Orange"}, new int[]{6, 4, 2})
                            + "<p>Apples most; 12 pieces in all.</p>",
                    "Pictograph with 5 bike faces", "5 children biked if 1 face = 1 child.",
                    null, "Unequal picture sizes cheat the graph.", "Title first — it is the question.",
                    "Sort, count, display, then say what it shows.", "sort, tally, most, least, title, pictograph");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Build a pictograph or simple table from class data.", "Read a picture key (sometimes 1 picture = 2).", "Compare two categories using 'more than'."},
                    LessonHtml.p("A key may say each symbol stands for 2 children. Then 3 symbols mean 6. Always read the key before counting.")
                            + LessonHtml.p("Tables organise tallies into numbers. You can ask a new question of the same data (how many more walked than biked?)."),
                    "A travel-to-school pictograph is a classic Aotearoa classroom investigation.",
                    new String[]{"Read the key.", "Convert symbols to numbers.", "Compare with subtraction.", "Write a sentence with the context."},
                    "Key: 1 bus = 2 children, 4 buses shown", "8 children came by bus.",
                    "Walk 12, bike 7, how many more walked?", "5 more walked.",
                    null, "Ignoring a 1 picture = 2 key doubles or halves everything.", "Write 'children' not just '12'.",
                    "Keys, tables and comparison sentences.", "key, table, more than, data, category");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Draw a bar graph with a scale starting at 0.", "Read a value from a bar or table.", "Spot a misleading scale if bars look dramatic."},
                    LessonHtml.p("Bar graphs need a title, labelled axes, equal bar widths and a scale from 0. Numerical counts sit on one axis; categories on the other.")
                            + LessonHtml.p("If a scale jumps from 0 to 50 to 51, the graph can lie. Year 3 learners should notice 'does this start at 0?'"),
                    "Graphing rainfall for a week in millimetres connects measurement and statistics.",
                    new String[]{"Draw axes and a 0-based scale.", "Plot bars accurately.", "Read a bar against the scale.", "Write one true sentence and one thing the graph cannot tell you."},
                    "A bar to 8 on a scale of 1", "The category has 8.",
                    "Why start at 0?", "So bar height matches quantity fairly.",
                    null, "3-D bar art that hides the true height.", "The graph cannot tell you why unless you collected reasons.",
                    "Fair bar graphs and honest reading.", "bar graph, scale, axis, title, category");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Distinguish categorical, discrete numerical and continuous numerical variables.", "Create a dot plot.", "Answer frequency questions from a plot."},
                    LessonHtml.p("A variable is an attribute we record. Categorical: eye colour. Discrete numerical: number of pets (counted). Continuous: height (measured).")
                            + LessonHtml.p("Dot plots show each value. Shape, middle clump and spread (min to max) are the first interpretation tools.")
                            + LessonHtml.p("A statistical investigative question names the variable and the group."),
                    "How many skips in 30 seconds? is a discrete numerical investigation popular in NZ primary PE.",
                    new String[]{"Name the variable type.", "Collect with a consistent method.", "Plot dots in columns.", "Describe shape, middle, spread in context."},
                    "Most common number of pets on a dot plot", "The tallest column of dots (mode-like reading).",
                    "Person with the most pets", "Read the largest value, not the tallest frequency, if that is the question.",
                    null, "Confusing 'how many people have 2 pets' with 'what is the most pets anyone has'.", "Read the question: value vs frequency.",
                    "Variable types, dot plots, frequency vs extreme value.", "categorical, discrete, continuous, dot plot, frequency, spread");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Collect continuous data with a rounding rule.", "Build a grouped table and a clustered bar graph for paired categories.", "Talk about bivariate categorical data."},
                    LessonHtml.p("Bivariate data records two variables per person (lunch activity and gender). Clustered bars sit side by side with a key.")
                            + LessonHtml.p("Continuous measurements need a stated rounding (nearest cm). Grouped tables use intervals such as 0–0.99, 1–1.99.")
                            + LessonHtml.p("Interpretation: which combination is most frequent? Do not claim a cause from a classroom sample of 28."),
                    "Lunchtime activity by year group is a respectful, local bivariate question.",
                    new String[]{"State both variables.", "Round as specified.", "Choose clustered bars or a grouped table.", "Describe the biggest category pair; note sample size."},
                    "Intervals 0–9, 10–19 for times in seconds", "A time of 10 s sits in 10–19, not 0–9, if left edges are inclusive as designed.",
                    "Clustered bars", "One axis categories, colour = second variable, height = frequency.",
                    null, "Overlapping intervals (0–10 and 10–20) double-count 10 unless you define endpoints.", "Write who the data is about (our class, not all of NZ).",
                    "Continuous rounding, grouping, bivariate bars.", "bivariate, clustered bar, grouped table, sample");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Calculate mean and range for numerical data.", "Create a time-series (line) graph.", "Choose an appropriate visualisation."},
                    LessonHtml.p("Mean = total ÷ n. Range = max − min. Mean is a centre; range is a spread. A huge range with a tidy mean still means varied data.")
                            + LessonHtml.p("Time-series: x is time, y is the measurement (mass of carrots over 5 days). Look for a trend (generally up, down, or seasonal wiggle).")
                            + LessonHtml.p("Media graphs: check scale, missing 0, 3-D junk, and whether the title matches the data."),
                    "Graphing a week's rainfall or a science plant's height is a time-series in the NZC Year 6 sequence.",
                    new String[]{"List the values.", "Mean: add then divide by how many.", "Range: biggest minus smallest.", "For time-series, time on x, join points if appropriate."},
                    "Mean of 4, 6, 8",
                    MathFigures.barChart("Scores", new String[]{"A", "B", "C"}, new int[]{4, 6, 8})
                            + "<p>Mean = 18 ÷ 3 = 6. Range = 8 − 4 = 4.</p>",
                    "Does a time graph trend up?", "If later points sit generally higher than earlier, yes — still describe wiggles.",
                    null, "Averaging two means of different group sizes without weighting.", "Mean is not always a data value. Range uses only two points — it can hide a cluster.",
                    "Mean, range, time-series, and graph choice.", "mean, range, time-series, trend, visualisation");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Follow PPDAC: problem, plan, data, analysis, conclusion.", "Use mean, median and mode as appropriate.", "Comment on sample vs population modestly."},
                    LessonHtml.p("PPDAC is the NZ statistical investigation cycle. A good problem is specific (Year 7 students at our school, not 'people'). Plan includes how you avoid bias (don't only ask your friends).")
                            + LessonHtml.p("Median is the middle when ordered; mode is the most frequent. Skewed data (one very large outlier) can pull the mean — median may represent the 'typical' better.")
                            + LessonHtml.p("Conclusions should match the sample: 'In our class…' not 'All New Zealanders…'."),
                    "Aotearoa NZ's census is a population study; your class survey is a sample. Knowing the difference is citizenship as well as statistics.",
                    new String[]{"Write an investigative question.", "Plan who, what, how.", "Display and calculate.", "Conclude with context and limitations."},
                    "Ordered 2, 3, 3, 5, 9. Median? Mode? Mean?",
                    MathFigures.barChart("Five scores", new String[]{"2", "3", "3", "5", "9"}, new int[]{2, 3, 3, 5, 9})
                            + "<p>Median 3, mode 3, mean 4.4. The 9 pulls the mean up.</p>",
                    "Why might asking only the basketball team about sport time be biased?",
                    "They likely train more than a mixed sample of the year group.",
                    null, "Reporting a mean of 4.44444… people. Round to a sensible degree.", "Match the average to the question: typical wage often uses median.",
                    "PPDAC, three averages, honest conclusions.", "PPDAC, median, mode, outlier, sample, bias");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Compare two distributions with back-to-back stem plots or dual box-like five-number summaries.", "Use samples and discuss variability.", "Critique a survey question."},
                    LessonHtml.p("Comparing Year 8 boys' and girls' (or two classes') heights needs the same variable, units and a display that shows spread, not only means.")
                            + LessonHtml.p("A leading survey question ('Don't you agree that…') biases answers. Closed vs open questions change the data type.")
                            + LessonHtml.p("Variability: two samples from the same population will not match exactly. That is expected, not a mistake."),
                    "School sports-day times for two houses can be compared without claiming one house is 'better at life'.",
                    new String[]{"Align units and group definitions.", "Display both distributions.", "Compare centre and spread in context.", "Note sample size and question wording."},
                    "Means 12.1 s and 12.4 s, n=8 each, large overlap", "Too close to claim a real difference without more data.",
                    "Better question than 'Do you like healthy food?'", "Ask a specific behaviour: 'How many pieces of fruit did you eat yesterday?'",
                    null, "Comparing means while ignoring that one group has a huge outlier.", "Write 'in this sample' in every conclusion.",
                    "Comparing distributions and critiquing questions.", "distribution, variability, five-number, bias, sample size");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Read and sketch box plots from a five-number summary.", "Interpret scatter graphs and describe relationships informally.", "Make a cautious informal inference from a sample to a wider group."},
                    LessonHtml.p("Box plots show min, Q1, median, Q3, max. The box is the middle 50%. Long whiskers mean spread. Outliers may be plotted as dots in some conventions.")
                            + LessonHtml.p("Scatter graphs of two numerical variables: positive relationship if they rise together, negative if one rises as the other falls, none if cloud-like. Correlation is not causation.")
                            + LessonHtml.p("Informal inference: if two sample boxes barely overlap, a difference in the populations is more plausible — still not proof."),
                    "A scatter of hours of sleep vs self-reported focus in a Year 9 class is a relationship, not a proof that sleep causes test scores.",
                    new String[]{"Compute or read the five-number summary.", "Draw the box and whiskers to scale.", "For scatter, comment on direction, strength (how tight), outliers.", "Infer cautiously; name the population you wish you had."},
                    "Five-number 2, 4, 5, 7, 12", "Median 5, IQR=7−4=3, whisker to 12 may flag a high value.",
                    "Points tightly up and right", "Strong positive relationship in this sample.",
                    null, "Saying 'X causes Y' from a scatter. Ice cream sales and drowning both rise in summer — a lurking variable (heat).", "IQR = Q3−Q1 measures the box, not the full range.",
                    "Box plots, scatter, cautious inference.", "box plot, quartile, IQR, scatter, relationship, causation");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Statistics | Tauanga",
                    new String[]{"Evaluate claims in media statistics.", "Handle outliers with a stated rule.", "Use bivariate numerical and time-series thinking together."},
                    LessonHtml.p("Year 10 students should ask: who was surveyed, how many, how were they chosen, what was asked, what is missing from the graph? A mean without n or a 3-D pie chart is a red flag.")
                            + LessonHtml.p("Outliers: an error (1700 cm tall) should be checked; a real extreme (a national representative in a class height set) may stay but should be discussed.")
                            + LessonHtml.p("Bivariate time-series (temperature and ice-cream sales by month) still does not prove causation."),
                    "Headlines about 'NCEA stats' or poll percentages need sample size and margin-of-error thinking even before formal NCEA methods.",
                    new String[]{"Interrogate the source.", "Check the display (scale, 0, 3-D).", "Decide outlier treatment with a reason.", "Write a limited conclusion."},
                    "A graph starting at 48 instead of 0 for exam scores 50–55", "Differences look huge — misleading scale.",
                    "n=12, claim 'all teens'", "Sample too small and too narrow for that population.",
                    null, "Repeating a viral statistic without asking who, how, how many.", "Good statistics is scepticism plus method, not cynicism.",
                    "Critique, outliers, and honest bivariate claims.", "outlier, misleading graph, sample, population, lurking variable");
        };
    }

    private static String chance(int y) {
        return switch (y) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Use will, might and won't for everyday events.", "List what could happen in a simple game.", "Notice results can change even if the game does not."},
                    LessonHtml.p("Chance is language for uncertainty. We do not require fractions yet. Some events always happen, some never, some sometimes.")
                            + LessonHtml.p("A two-colour counter might land red or yellow — not purple, because purple is not an outcome of that object."),
                    "Aotearoa weather: it might rain even if morning looks fine. That is honest might, not a wild guess.",
                    new String[]{"Name the event.", "Choose will/might/won't with a reason.", "If a game, list possible results first.", "Play a few times and notice variation."},
                    "Will it be dark tonight?", "Will — night follows day.",
                    "Two-colour counter", "Might red, might yellow; won't purple.",
                    null, "Treating might as will after one lucky outcome.", "List outcomes before playing — later this is sample space.",
                    "Will / might / won't, and possible game results.", "might, will, won't, chance, possible");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Place events on a language scale: impossible → certain.", "Use even chance for a fair two-sided situation.", "Compare two events with more/less likely."},
                    LessonHtml.p("Impossible events cannot happen; certain events must. Even chance (a fair coin) sits in the middle. Likely and unlikely sit between.")
                            + LessonHtml.p("A coin is even chance only if it is fair. A trick coin is a different situation."),
                    "The sun rising is certain; a cow orbiting Earth is impossible; seeing a tūī at interval might be likely in some kura and unlikely in others — context matters.",
                    new String[]{"State the event clearly.", "Choose a word on the scale.", "Compare two events.", "Say if a game looks fair."},
                    "Fair coin P(heads) in words", "Even chance.",
                    "Rolling a 6 vs rolling an even on a fair die (language only)", "Even is more likely (three faces vs one) — Year 3 will list them.",
                    LessonHtml.table(new String[]{"Word", "Idea"}, new String[][]{{"impossible", "cannot happen"}, {"unlikely", "could, but not often"}, {"even chance", "two fair options"}, {"certain", "must happen"}}),
                    "Calling a rare event impossible. Impossible means cannot, not 'I have never seen it'.", "Fairness depends on equal chance, not on who won last time.",
                    "A five-word chance scale and fair vs unfair games.", "impossible, unlikely, even chance, likely, certain, fair");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"List all outcomes of a spinner or die.", "Say which outcomes are equally likely if the game is fair.", "Use more/less likely from the list."},
                    LessonHtml.p("An outcome is a possible result. Listing them all (the start of sample space) prevents missing 'both coins tails'.")
                            + LessonHtml.p("If a spinner has four equal sectors, each colour is equally likely. If red takes half the spinner, red is more likely — fraction language begins."),
                    "A playground spinner or a Māori game with equal stick lots can be a fair chance device if lots are equal.",
                    new String[]{"Name the device.", "List outcomes.", "Check they are equally likely (equal areas/faces).", "Compare events made of several outcomes."},
                    "Fair die faces", "1,2,3,4,5,6 — six equally likely outcomes.",
                    "Even numbers on a die", "2,4,6 — three of six, more likely than a single 6.",
                    null, "Forgetting 1 on a die when listing. Count to 6.", "Equal area matters on spinners. A huge red sector is not even chance.",
                    "List outcomes, then judge more/less likely.", "outcome, equally likely, spinner, list");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Place likelihood on a 0 to 1 line.", "Use 0 impossible, 1 certain, 1/2 even.", "Conduct repeated chance experiments and talk about variation."},
                    LessonHtml.p("Probability numbers live between 0 and 1. Language maps onto intervals: very unlikely near 0, likely near 1. A trial is one run of a chance situation.")
                            + LessonHtml.p("Repeating a game 20 times, you will not get exactly half heads. Variation is expected. The long-run idea waits for later years."),
                    "Will you eat something later today? is likely for most students — place it between 1/2 and 1.",
                    new String[]{"Identify 0, 1/2, 1 on a line.", "Place the event.", "Run trials; tally.", "Compare the tally with what 'even' would suggest, without forcing a match."},
                    "Sun will rise tomorrow", "Certain — near 1.",
                    "20 coin flips, 12 heads", "Not wrong. Variation around 10 is normal in a small experiment.",
                    null, "Expecting exactly 10/20 heads every experiment. Probability is not a promise to a small sample.", "Keep the 0–1 line visible whenever you use chance words.",
                    "0–1 scale, trials, and variation.", "probability, trial, chance-based, 0 to 1, variation");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"List a sample space.", "Compute P(event)=favourable/total for equally likely outcomes.", "Use a spinner fraction model."},
                    LessonHtml.p("Sample space is the set of all outcomes. If equally likely, P = number of ways / number of possible outcomes. All mutually exclusive exhaustive outcomes sum to 1.")
                            + LessonHtml.p("A spinner split into 1/4 red and 3/4 blue has P(red)=1/4. Combined events: P(red or blue)=1 on that spinner.")
                            + LessonHtml.p("You still need the equally-likely assumption. A weighted die is a different model."),
                    "A carnival spinner with unequal slices is a warning: count area, not number of colour names if slices differ.",
                    new String[]{"List sample space.", "Check equally likely.", "Count favourable.", "Write the probability as a fraction in simplest form if asked."},
                    "P(4 on a fair die)", "1/6.",
                    "P(even)",
                    MathFigures.spinner(new String[]{"1", "2", "3", "4", "5", "6"}, 3, "A fair spinner (or die) has equal sectors. Even faces are 2, 4 and 6.")
                            + "<p>3/6 = 1/2.</p>",
                    null, "Writing P=4 because the face says 4. Probability is a fraction of outcomes, not the label.", "Simplest form: 2/6=1/3.",
                    "Sample space and equally likely fractions.", "sample space, event, equally likely, favourable");
            case 6 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Calculate probabilities of combined outcomes on a spinner or die.", "Check that all outcome probabilities sum to 1.", "Connect experimental relative frequency to theoretical P."},
                    LessonHtml.p("Theoretical probability assumes equally likely outcomes. Experimental probability is (times it happened)/(trials). With more trials, experimental values often sit closer to theoretical — but not always in a short run.")
                            + LessonHtml.p("P(A or B) for disjoint outcomes on a die: add. If they overlap, do not double-count (Year 8 two-way tables make overlap clearer).")
                            + LessonHtml.p("Sum to 1 is a check: if your list of exclusive outcomes adds to 0.9, something is missing."),
                    "Kapa haka ticket raffles with equal tickets are theoretical 1/n; a lopsided spinner is not.",
                    new String[]{"State theoretical P.", "Run or imagine many trials for experimental P.", "Compare; explain possible difference.", "Check sums = 1."},
                    "P(1 or 2 on a die)", "2/6=1/3.",
                    "40 spins, red 12 times, experimental P(red)", "12/40=0.3. If the spinner is 1/4 red, 0.25 theoretical — 0.3 is a plausible short-run result.",
                    null, "Adding P(even)+P(odd)+P(6) without noticing 6 is already even.", "Disjoint vs overlapping events — draw a blob diagram if unsure.",
                    "Theoretical vs experimental, combinations, sum to 1.", "theoretical, experimental, relative frequency, disjoint");
            case 7 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Contrast experimental and theoretical probability with more trials.", "Use P(not A)=1−P(A).", "Design a fair vs unfair game and justify."},
                    LessonHtml.p("The complement: if P(rain)=0.3, P(not rain)=0.7, provided those two cover the situation. This is faster than listing everything.")
                            + LessonHtml.p("Fair games have equal expected chances for players given the rules; unfair games hide extra area or extra faces.")
                            + LessonHtml.p("You begin to record relative frequencies in a table and comment on expected variation."),
                    "Designing a kauwae or classroom spinner that looks fair but isn't is a powerful Year 7 task — ethics of chance.",
                    new String[]{"Find P(A).", "Use complement if 'not A' is easier.", "Compare experimental with theoretical.", "Judge fairness from the model, not from one winner."},
                    "P(not a 6) on a die", "5/6.",
                    "A spinner 3/4 red, P(not red)",
                    MathFigures.spinner(new String[]{"R", "R", "R", "B"}, 3, "Three equal red sectors and one blue. P(not red) = 1/4.")
                            + "<p>Complement: 1 − 3/4 = 1/4.</p>",
                    null, "Using 1−P(A) when other outcomes besides A and not-A exist (rain, snow, sun). Complements must partition the space.", "Fairness is about the model. One unlucky game does not prove unfairness.",
                    "Complements, fairness, and longer experiments.", "complement, fair game, relative frequency, variation");
            case 8 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Read two-way tables of outcomes.", "Find P(A and B), P(A or B) with possible overlap.", "Use 'and' as multiply only when independent — and say so."},
                    LessonHtml.p("A two-way table (year group vs bus/walk) lets you find joints and conditionals in a counting way: 8 of 30 walk and are Year 8, so that joint frequency is 8/30.")
                            + LessonHtml.p("P(A or B)=P(A)+P(B)−P(A and B) if you must avoid double-counting the overlap. Independent events: one does not change the other (two coins).")
                            + LessonHtml.p("Without independence, you cannot blindly multiply. Year 9 trees make dependence visible."),
                    "A table of year level against travel mode is both statistics and probability — same numbers, different questions (describe vs chance if I pick a student at random).",
                    new String[]{"Enter totals in the table.", "Identify the cell or the union of cells.", "Subtract overlap for OR if needed.", "Write P as a fraction of the grand total (for a random pick)."},
                    "Table total 40, 10 both sport and music, P(sport or music) if 18 sport, 15 music",
                    "18+15−10=23, P=23/40.",
                    "Two fair coins, P(both heads)", "1/4 if independent. Sample space HH, HT, TH, TT.",
                    null, "Adding 18+15 and forgetting the 10 who do both.", "Independence is an assumption. Say it.",
                    "Two-way tables, OR with overlap, independence caution.", "two-way table, union, intersection, independent, overlap");
            case 9 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Draw tree diagrams for two-stage experiments.", "Multiply along branches; add across mutually exclusive paths.", "Model independent vs dependent draws (with/without replacement)."},
                    LessonHtml.p("A tree shows stages. Independent coins: each second-branch pair repeats 1/2. Without replacement: the second draw's fractions change (4/9 then 3/8).")
                            + LessonHtml.p("P(path)=product of branch probabilities. P(event)=sum of paths that count as the event.")
                            + LessonHtml.p("Always check the second-stage fractions add to 1 on each fork."),
                    "Raffle tickets drawn without putting names back is without replacement — a school-fair tree diagram.",
                    new String[]{"Draw stage 1 branches.", "From each, draw stage 2 with the correct conditional fractions.", "Multiply along, add the winning paths.", "Check a complete set of paths sums to 1."},
                    "Two fair coins, P(exactly one head)",
                    MathFigures.coinTree("Multiply along a path; add the two one-head paths HT and TH.")
                            + "<p>HT or TH: 1/4 + 1/4 = 1/2.</p>",
                    "Bag 3 red 2 blue, two draws without replacement, P(two red)",
                    "(3/5)×(2/4)=6/20=3/10.",
                    null, "Using 3/5 twice when the first red was not replaced.", "Label each branch with a probability, not only a colour.",
                    "Trees, multiply along, add across, replacement matters.", "tree diagram, branch, without replacement, independent, path");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Probability | Tūponotanga",
                    new String[]{"Use conditional language: P(A given B) from a table or tree.", "Connect relative frequency to estimated probability.", "Avoid common fallacies (gambler's fallacy)."},
                    LessonHtml.p("Conditional probability: given that a student walks, what is P(they are Year 10)? Restrict to the walk column of a two-way table, then find the year-10 cell over that column total.")
                            + LessonHtml.p("Relative frequency after many trials estimates P. It is not a guarantee for the next trial. The gambler's fallacy is believing a tail is 'due' after five heads on a fair coin — the coin has no memory.")
                            + LessonHtml.p("Medical or screening examples need care: false positives are conditionals. Keep numbers in a table."),
                    "Sports: a team that lost five in a row is not 'due' a win if each match is independent — a useful myth to retire.",
                    new String[]{"Restrict the sample space to the given condition.", "Count inside that restricted set.", "Write P(A|B) in words as well as symbols.", "Refuse the 'due a win' story for independent trials."},
                    "Fair coin, five heads already, P(next is heads)", "Still 1/2 if fair and independent.",
                    "Table: 20 walkers, 8 of them Year 10. P(Year 10 | walks)", "8/20=2/5.",
                    null, "Using the grand total instead of the restricted total for a 'given' question.", "Write 'given' in the sentence so you remember to restrict.",
                    "Conditionals, long-run frequency, and no memory in independent trials.", "conditional, given, relative frequency, independent, gambler's fallacy");
        };
    }

    private static String stratNumber(int y) {
        return LessonHtml.strategy("number",
                new String[]{"Write the number in places (or powers of 10 from Year 7).", "Compare or round from the target place.", "Estimate before any heavy calculation.", "Name the number in words to catch placeholder zeros."},
                y <= 3 ? "starting from the ones place when comparing two-digit numbers" : "dropping placeholder zeros or mixing up negatives");
    }

    private static String stratOps(int y) {
        return LessonHtml.strategy("operations",
                new String[]{"Underline the story's operation words.", "Estimate.", "Compute with a method that matches the size of the numbers.", "Check with the inverse or a second estimate."},
                y >= 6 ? "ignoring GEMA (adding before multiplying)" : "choosing × when the story was sharing, or the reverse");
    }

    private static String stratFdp(int y) {
        return LessonHtml.strategy("fractions, decimals and percentages",
                new String[]{"Name the whole (the 100%).", "Convert to a common form.", "Compute.", "Interpret the remainder or the money rounding."},
                "comparing fractions of different wholes, or adding percentages of different bases");
    }

    private static String linearEquationsDetail(int year) {
        String extra = year >= 8
                ? LessonHtml.h4("Variables on both sides")
                + LessonHtml.p("Collect the letter terms on one side and the numbers on the other. Do the same operation to both sides, one move at a time.")
                + LessonHtml.worked("5x + 9 = 2x + 24",
                LessonHtml.lines(
                        "Subtract 2x from both sides: 5x − 2x + 9 = 24",
                        "3x + 9 = 24",
                        "Subtract 9 from both sides: 3x = 15",
                        "Divide both sides by 3: <strong>x = 5</strong>",
                        "Check: left 5(5)+9 = 34. Right 2(5)+24 = 34. Balanced."))
                + LessonHtml.h4("Clear fractions first")
                + LessonHtml.p("If the equation has denominators, multiply every term by the lowest common multiple so the fractions disappear.")
                + LessonHtml.worked("x/3 + 2 = 7",
                LessonHtml.lines(
                        "Subtract 2 from both sides: x/3 = 5",
                        "Multiply both sides by 3: <strong>x = 15</strong>",
                        "Check: 15/3 + 2 = 5 + 2 = 7."))
                + LessonHtml.worked("2x/5 − 1 = 3",
                LessonHtml.lines(
                        "Add 1: 2x/5 = 4",
                        "Multiply by 5: 2x = 20",
                        "Divide by 2: <strong>x = 10</strong>",
                        "Check: 20/5 − 1 = 4 − 1 = 3."))
                : "";
        return LessonHtml.h4("The balance rule")
                + LessonHtml.p("An equation is a balanced scale. Whatever you do to the left, do to the right. Undo operations in reverse: if the last thing done to the letter was ×5, divide by 5 last of all — after you have undone + and −.")
                + LessonHtml.h4("One-step equations")
                + LessonHtml.worked("n + 8 = 20",
                LessonHtml.lines(
                        "The 8 was added to n, so subtract 8 from both sides.",
                        "n + 8 − 8 = 20 − 8",
                        "<strong>n = 12</strong>",
                        "Check by substitution: 12 + 8 = 20."))
                + LessonHtml.worked("4k = 28",
                LessonHtml.lines(
                        "k was multiplied by 4, so divide both sides by 4.",
                        "4k ÷ 4 = 28 ÷ 4",
                        "<strong>k = 7</strong>",
                        "Check: 4 × 7 = 28."))
                + LessonHtml.worked("m − 11 = 9",
                LessonHtml.lines(
                        "11 was subtracted, so add 11 to both sides.",
                        "m − 11 + 11 = 9 + 11",
                        "<strong>m = 20</strong>",
                        "Check: 20 − 11 = 9."))
                + LessonHtml.h4("Two-step equations — undo the last operation first")
                + LessonHtml.p("Think of the letter as a gift: multiplied first, then something added. You unwrap the add/subtract first, then the multiply/divide.")
                + LessonHtml.worked("5s + 3 = 18",
                LessonHtml.lines(
                        "Subtract 3 from both sides (undo the +3): 5s = 15",
                        "Divide both sides by 5: <strong>s = 3</strong>",
                        "Check: 5×3 + 3 = 15 + 3 = 18."))
                + LessonHtml.worked("2p − 7 = 11",
                LessonHtml.lines(
                        "Add 7 to both sides: 2p = 18",
                        "Divide by 2: <strong>p = 9</strong>",
                        "Check: 2×9 − 7 = 18 − 7 = 11."))
                + LessonHtml.worked("A $4 ticket plus $2 booking fee for each of n tickets is $26. Form and solve 4n + 2 = 26.",
                LessonHtml.lines(
                        "4n + 2 = 26",
                        "Subtract 2: 4n = 24",
                        "Divide by 4: <strong>n = 6 tickets</strong>",
                        "Check: 4×6 + 2 = 26."))
                + extra;
    }

    private static String simultaneousDetail() {
        return LessonHtml.h4("When to use which method")
                + LessonHtml.table(new String[]{"If you see…", "Use", "Why"},
                new String[][]{
                        {"One letter already alone, e.g. y = 2x + 1", "Substitution", "You can drop that expression straight into the other equation."},
                        {"Matching or opposite coefficients, e.g. +3y and −3y", "Elimination (add or subtract)", "A letter cancels in one line."},
                        {"Coefficients that are multiples, e.g. 2x and 6x", "Elimination (multiply first)", "Make the coefficients equal, then cancel."}
                })
                + LessonHtml.h4("Method 1 — substitution")
                + LessonHtml.p("1. Rearrange one equation so a letter is by itself. 2. Replace that letter in the <em>other</em> equation with the expression. 3. Solve the one-letter equation. 4. Substitute back to find the second letter. 5. Check both originals.")
                + LessonHtml.worked("Substitution · y already isolated: y = 2x and x + y = 9",
                LessonHtml.lines(
                        "Replace y in the second equation with 2x: x + (2x) = 9",
                        "3x = 9",
                        "x = 3",
                        "Now y = 2×3 = 6",
                        "Check both: y = 2x → 6 = 6. x + y = 9 → 3 + 6 = 9. Solution <strong>(x, y) = (3, 6)</strong>."))
                + LessonHtml.worked("Substitution · isolate first: x + y = 10 and y = x + 2",
                LessonHtml.lines(
                        "y is already x + 2. Put that into x + y = 10:",
                        "x + (x + 2) = 10",
                        "2x + 2 = 10",
                        "2x = 8",
                        "x = 4, then y = 4 + 2 = 6",
                        "Check: 4 + 6 = 10 and 6 = 4 + 2. <strong>(4, 6)</strong>."))
                + LessonHtml.worked("Substitution · isolate x from 2x + y = 11, with x − y = 1",
                LessonHtml.lines(
                        "From the second: x = y + 1",
                        "Put into the first: 2(y + 1) + y = 11",
                        "2y + 2 + y = 11",
                        "3y + 2 = 11",
                        "3y = 9, y = 3",
                        "x = 3 + 1 = 4",
                        "Check: 2(4)+3 = 11 and 4 − 3 = 1. <strong>(4, 3)</strong>."))
                + LessonHtml.h4("Method 2 — elimination")
                + LessonHtml.p("Line the equations up, x under x and y under y. Add or subtract so one letter disappears. If the coefficients are not ready, multiply one (or both) equations first.")
                + LessonHtml.worked("Elimination by adding · opposite y: x + y = 7 and x − y = 3",
                LessonHtml.lines(
                        "Add the equations: (x + y) + (x − y) = 7 + 3",
                        "2x = 10, so x = 5",
                        "Put x = 5 into x + y = 7: 5 + y = 7, y = 2",
                        "Check the second: 5 − 2 = 3. <strong>(5, 2)</strong>."))
                + LessonHtml.worked("Elimination by subtracting · matching x: 3x + 2y = 16 and 3x + y = 13",
                LessonHtml.lines(
                        "Subtract the second from the first: (3x + 2y) − (3x + y) = 16 − 13",
                        "y = 3",
                        "Put y = 3 into 3x + y = 13: 3x + 3 = 13, 3x = 10, x = 10/3",
                        "Check: 3(10/3) + 2(3) = 10 + 6 = 16. <strong>(10/3, 3)</strong>."))
                + LessonHtml.worked("Elimination · multiply first: 2x + 3y = 16 and x + y = 6",
                LessonHtml.lines(
                        "Multiply the second by 3 so the y terms match: 3x + 3y = 18",
                        "Now subtract the first: (3x + 3y) − (2x + 3y) = 18 − 16",
                        "x = 2",
                        "Put x = 2 into x + y = 6: 2 + y = 6, y = 4",
                        "Check: 2(2) + 3(4) = 4 + 12 = 16. <strong>(2, 4)</strong>."))
                + LessonHtml.worked("Elimination · multiply both: 2x + 3y = 7 and 3x − 2y = 4",
                LessonHtml.lines(
                        "Aim to cancel y. Multiply first by 2 and second by 3:",
                        "4x + 6y = 14",
                        "9x − 6y = 12",
                        "Add: 13x = 26, x = 2",
                        "From 2(2) + 3y = 7: 4 + 3y = 7, 3y = 3, y = 1",
                        "Check: 3(2) − 2(1) = 6 − 2 = 4. <strong>(2, 1)</strong>."))
                + LessonHtml.h4("A word problem — two adults at a kiosk")
                + LessonHtml.worked("Adult tickets $t and snacks $s. Two adults: 2t + s = 28. One adult plus two snacks: t + 2s = 26. Find t and s.",
                LessonHtml.lines(
                        "Substitution: from the second, t = 26 − 2s",
                        "Put into the first: 2(26 − 2s) + s = 28",
                        "52 − 4s + s = 28",
                        "52 − 3s = 28",
                        "−3s = −24, s = 8",
                        "t = 26 − 16 = 10",
                        "Check: 2(10)+8 = 28 and 10+16 = 26. Ticket $10, snack $8."));
    }

    private static String quadraticDetail() {
        return LessonHtml.h4("Expanding double brackets (FOIL / area)")
                + LessonHtml.p("First, Outer, Inner, Last: (x + a)(x + b) = x² + (a+b)x + ab. An area model is the same four rectangles.")
                + LessonHtml.worked("Expand (x + 3)(x + 2)",
                LessonHtml.lines(
                        "First: x·x = x²",
                        "Outer: x·2 = 2x",
                        "Inner: 3·x = 3x",
                        "Last: 3·2 = 6",
                        "Add: <strong>x² + 5x + 6</strong>."))
                + LessonHtml.worked("Expand (x + 4)(x − 1)",
                LessonHtml.lines(
                        "x² + (−1)x + 4x + (4)(−1)",
                        "x² + 3x − 4."))
                + LessonHtml.h4("Factorising x² + bx + c")
                + LessonHtml.p("Find two numbers that multiply to c and add to b. Those numbers go in the brackets.")
                + LessonHtml.worked("Factorise x² + 5x + 6",
                LessonHtml.lines(
                        "Need two numbers: product 6, sum 5. That is 2 and 3.",
                        "<strong>(x + 2)(x + 3)</strong>",
                        "Expand to check: x² + 5x + 6."))
                + LessonHtml.worked("Solve x² + 5x + 6 = 0",
                LessonHtml.lines(
                        "(x + 2)(x + 3) = 0",
                        "Null factor law: a product is 0 only if a factor is 0.",
                        "x + 2 = 0 or x + 3 = 0",
                        "<strong>x = −2 or x = −3</strong>",
                        "Check: (−2)² + 5(−2) + 6 = 4 − 10 + 6 = 0."))
                + LessonHtml.worked("Solve x² − 5x + 6 = 0",
                LessonHtml.lines(
                        "Numbers: product +6, sum −5 → −2 and −3.",
                        "(x − 2)(x − 3) = 0",
                        "<strong>x = 2 or x = 3</strong>."));
    }

    private static String stratAlg(int y) {
        return LessonHtml.strategy("algebra",
                new String[]{"Find what stays the same and what changes (or define the letter).", "Write a rule or equation in words, then symbols.", "Test on a known term or substitute back.", "Graph or use a number line if it helps."},
                y <= 4 ? "treating = as 'the answer goes here'" : "combining unlike terms or forgetting to check by substitution");
    }

    private static String stratMeas(int y) {
        return LessonHtml.strategy("measurement",
                new String[]{"Name the attribute (length, area, volume, angle, time).", "Convert to one unit.", "Choose the formula or fact.", "Attach square/cubic units if needed."},
                "using perimeter when area was asked, or cm instead of cm²");
    }

    private static String stratGeo(int y) {
        return LessonHtml.strategy("geometry",
                new String[]{"List properties, do not trust the sketch alone.", "Mark given facts on a diagram.", "Name the transformation or the angle fact.", "Write a short reason for each step from Year 7."},
                "classifying by looks (a tilted square 'isn't a square')");
    }

    private static String stratData(int y) {
        return LessonHtml.strategy("statistics",
                new String[]{"Read the title, labels, units and sample.", "Identify the variable type.", "Calculate or read the display.", "Conclude in context, with a limitation."},
                "reading a dramatic scale without checking that it starts at 0");
    }

    private static String stratChance(int y) {
        return LessonHtml.strategy("probability",
                new String[]{"List the sample space (or restrict it if the question says given).", "Check equally likely — or use the table/tree given.", "Write favourable ÷ total.", "Check probabilities of a complete set sum to 1."},
                y <= 2 ? "calling a rare event impossible" : "forgetting overlap in OR, or using the same fraction twice without replacement");
    }
}
