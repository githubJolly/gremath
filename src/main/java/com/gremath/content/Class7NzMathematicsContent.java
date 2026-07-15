package com.gremath.content;

import com.gremath.model.Lesson;
import com.gremath.model.Topic;

import java.util.List;

/**
 * Year 7 Mathematics and Statistics topic aligned to the NZ Curriculum teaching sequence
 * (Phase 3 / Year 7). Content is original LetusLearn wording organised by the same strands.
 */
public class Class7NzMathematicsContent implements TopicContent {

    private static final String STRAT_EXP =
            "<p>Year 7 number work starts with powers of 10 and square roots.</p>"
                    + Doc.steps(
                    "Write place values as powers of 10 (e.g. 10,000 = 10^4).",
                    "Expand multi-digit numbers using powers of 10.",
                    "Use exponent notation for repeated multiplication.",
                    "Link square numbers to radical notation (√)."
            )
                    + Doc.tip("Estimate square roots by finding the nearest perfect squares.");

    private static final String STRAT_PRIMES =
            "<p>Prime structure unlocks HCF, LCM and divisibility checks.</p>"
                    + Doc.steps(
                    "Test primes to 100 using divisibility rules.",
                    "Factor pairs first, then compare common factors for HCF.",
                    "List multiples (or use prime powers) for LCM.",
                    "Apply 2, 3, 4, 5, 6, 8, 9, 10 tests before long division."
            )
                    + Doc.warn("1 is neither prime nor composite.");

    private static final String STRAT_INT =
            "<p>Integers and GEMA keep multi-step calculations consistent.</p>"
                    + Doc.steps(
                    "Place negatives left of zero on a number line.",
                    "Use additive inverses: a + (−a) = 0.",
                    "Add/subtract integers with directed jumps.",
                    "Evaluate with GEMA: grouped → exponents → ×÷ → +−."
            )
                    + Doc.tip("Temperature and money contexts make signed numbers concrete.");

    private static final String STRAT_FDP =
            "<p>Treat fractions, decimals and percentages as linked representations.</p>"
                    + Doc.steps(
                    "Convert to a common form before comparing.",
                    "Add/subtract with related denominators or aligned decimals.",
                    "Multiply/divide with unit thinking and place-value shifts.",
                    "In NZ money tasks, work to 2 d.p. and check change carefully."
            )
                    + Doc.tip("Percentage discount: amount = rate × original, then subtract from price.");

    private static final String STRAT_ALG =
            "<p>Algebra generalises patterns into symbols and graphs.</p>"
                    + Doc.steps(
                    "Define the variable clearly.",
                    "Build 1–2 step equations from word stories.",
                    "Collect like terms; rearrange simple formulae.",
                    "Check solutions by substitution; plot linear rules on four quadrants."
            )
                    + Doc.tip("y = mx + c: m is the constant change, c is the starting value.");

    private static final String STRAT_MEAS =
            "<p>Choose metric units, then apply perimeter/area/volume formulae.</p>"
                    + Doc.steps(
                    "Convert with powers of 10 between metric prefixes.",
                    "Perimeter = path length; area = covering; volume = filling.",
                    "Split composite shapes into rectangles/triangles.",
                    "Read timetables carefully for elapsed duration."
            )
                    + Doc.warn("Keep cm² / m³ units matching the formula you used.");

    private static final String STRAT_GEO =
            "<p>Classify shapes and reason with angle relationships.</p>"
                    + Doc.steps(
                    "Sort triangles by sides and by angles.",
                    "Use angle sum and exterior-angle facts for polygons.",
                    "Apply parallel-line / transversal relationships.",
                    "Describe reflections, rotations and translations on a grid."
            )
                    + Doc.tip("Equilateral triangles have three equal angles of 60°.");

    private static final String STRAT_STATS =
            "<p>Plan the question, choose a display, then interpret carefully.</p>"
                    + Doc.steps(
                    "Decide categorical vs numerical variables.",
                    "Compute mean, median, mode and range.",
                    "Choose dot plots, bars or time-series graphs.",
                    "For chance: experimental relative frequency vs theoretical P = fav/total."
            )
                    + Doc.warn("Outliers pull the mean more than the median.");

    @Override
    public Topic build() {
        Topic t = new Topic(
                "class7-nz-mathematics",
                "Year 7 Mathematics (New Zealand Curriculum)",
                "Number, algebra, measurement, geometry, statistics and probability for Year 7 learners — aligned to the NZ Mathematics and Statistics teaching sequence.",
                "CLASS7_NZ",
                4
        );

        t.addLesson(new Lesson(
                "1. Place value, exponents and square roots",
                "<p>In Year 7, place value is seen as powers of 10 stretching forever. Exponents shorten repeated multiplication, and square roots undo squaring.</p>"
                        + Doc.key("10^0 = 1, 10^1 = 10, 10^2 = 100, 10^3 = 1,000, …")
                        + Doc.formula("Expanded form: 34,506 = 3×10^4 + 4×10^3 + 5×10^2 + 6")
                        + Doc.steps(
                        "Rewrite large numbers using powers of 10.",
                        "Compare and order using the highest place first.",
                        "Practise square numbers to at least 144 and use √ notation.",
                        "Estimate √n by sandwiching between perfect squares."
                )
                        + Doc.example("√81", "9 × 9 = 81, so √81 = 9.")
                        + Doc.recap("Powers of 10, exponents and square roots deepen place-value fluency."),
                1, "c7nz-exponents", STRAT_EXP
        ));

        t.addLesson(new Lesson(
                "2. Primes, HCF, LCM and divisibility",
                "<p>Numbers greater than 1 are prime (exactly two factors) or composite (more than two). HCF and LCM organise shared structure; divisibility rules speed checks.</p>"
                        + Doc.key("1 is neither prime nor composite.")
                        + Doc.steps(
                        "Identify primes to 100.",
                        "Find HCF of two numbers under 100.",
                        "Find LCM of two numbers under 10 (then extend).",
                        "Use divisibility tests for 2, 3, 4, 5, 6, 8, 9 and 10."
                )
                        + Doc.example("HCF(36, 48)", "Common factors include 1, 2, 3, 4, 6, 12 → HCF = 12.")
                        + Doc.recap("Prime thinking supports factorisation, HCF/LCM and clean division."),
                2, "c7nz-primes-hcf", STRAT_PRIMES
        ));

        t.addLesson(new Lesson(
                "3. Integers and order of operations (GEMA)",
                "<p>Integers include negatives, zero and positives. Additive inverses cancel to zero. Multi-step expressions follow a fixed order.</p>"
                        + Doc.formula("GEMA: Grouped → Exponents → Multiplicative (×÷) → Additive (+−)")
                        + Doc.steps(
                        "Locate and order integers on a number line.",
                        "Add and subtract with directed moves.",
                        "Solve temperature and finance contexts with signed numbers.",
                        "Evaluate expressions with brackets and exponents first."
                )
                        + Doc.example("Evaluate 3 + 4 × 2^2", "Exponents first: 2^2 = 4; then 4×4 = 16; then 3+16 = 19.")
                        + Doc.recap("Signed numbers and GEMA keep Year 7 calculations reliable."),
                3, "c7nz-integers", STRAT_INT
        ));

        t.addLesson(new Lesson(
                "4. Fractions, decimals, percentages and financial maths",
                "<p>Fractions, decimals and percentages describe the same relative amounts. Year 7 extends conversion, comparison and operations, including NZ money contexts.</p>"
                        + Doc.formula("part = percent × whole &nbsp;&nbsp; sale price = original − discount")
                        + Doc.steps(
                        "Convert between forms; recognise terminating vs repeating decimals.",
                        "Add/subtract fractions with related denominators and decimals to hundredths.",
                        "Multiply and divide with fractions/decimals using sense checks.",
                        "Work with NZ dollars to 2 d.p.; calculate cost, change and percentage discounts."
                )
                        + Doc.example("25% off $80", "Discount = 0.25×80 = $20 → sale price $60.")
                        + Doc.recap("Flexible FDP thinking powers proportional and financial reasoning."),
                4, "c7nz-fdp-finance", STRAT_FDP
        ));

        t.addLesson(new Lesson(
                "5. Algebra: equations, like terms and linear graphs",
                "<p>Variables stand for unknown values. Year 7 forms and solves short linear equations, collects like terms, and connects tables, graphs and rules.</p>"
                        + Doc.formula("Solve ax + b = c by undoing operations; check by substitution.")
                        + Doc.steps(
                        "Translate stories into 1–2 step equations.",
                        "Collect like terms and rearrange simple formulae.",
                        "Complete tables for linear relationships.",
                        "Plot ordered pairs on four quadrants; notice y = mx + c patterns."
                )
                        + Doc.example("Solve 2n + 5 = 17", "2n = 12 → n = 6. Check: 2×6+5 = 17.")
                        + Doc.recap("Algebra links symbols, tables and graphs for generalisation."),
                5, "c7nz-algebra", STRAT_ALG
        ));

        t.addLesson(new Lesson(
                "6. Measurement: perimeter, area, volume and duration",
                "<p>Metric prefixes scale units by powers of 10. Perimeter, area and volume quantify path, cover and fill; timetables quantify duration.</p>"
                        + Doc.formula("Rectangle area = l×w &nbsp; Triangle area = ½bh &nbsp; Prism volume = l×w×h")
                        + Doc.steps(
                        "Convert length, mass and capacity with milli/centi/kilo prefixes.",
                        "Calculate perimeter and area of rectangles, squares and triangles.",
                        "Find volumes of cubes and rectangular prisms; tackle simple composites.",
                        "Interpret charts/timetables and convert mixed time units."
                )
                        + Doc.example("Area of right triangle base 10 cm, height 6 cm", "½×10×6 = 30 cm².")
                        + Doc.recap("Measurement blends unit fluency with spatial formulae."),
                6, "c7nz-measurement", STRAT_MEAS
        ));

        t.addLesson(new Lesson(
                "7. Geometry: triangles, angles and transformations",
                "<p>Triangles are classified by sides and angles. Polygon angle facts and parallel-line relationships unlock unknowns. Transformations move shapes on the plane.</p>"
                        + Doc.key("Triangle angle sum = 180°. Straight line = 180°. Around a point = 360°.")
                        + Doc.steps(
                        "Classify equilateral, isosceles and scalene; acute, right and obtuse.",
                        "Use interior/exterior angle ideas for polygons.",
                        "Reason with parallel lines and transversals.",
                        "Describe reflections, rotations, translations; explore nets of prisms/pyramids."
                )
                        + Doc.example("Isosceles triangle with vertex 40°", "Base angles = (180−40)/2 = 70° each.")
                        + Doc.recap("Geometry is property-based reasoning about shape and space."),
                7, "c7nz-geometry", STRAT_GEO
        ));

        t.addLesson(new Lesson(
                "8. Statistics and probability",
                "<p>Statistics turns questions into data displays and summaries. Probability measures chance experimentally and theoretically.</p>"
                        + Doc.formula("Mean = sum ÷ count &nbsp; Range = max − min &nbsp; P(event) = favourable ÷ total")
                        + Doc.steps(
                        "Identify categorical vs discrete/continuous numerical variables.",
                        "Compute mean, median, mode and range; notice outliers.",
                        "Create and critique bar, stacked/clustered, dot and time-series graphs.",
                        "Compare experimental relative frequency with theoretical probability; use complements."
                )
                        + Doc.example("Data 4, 6, 6, 9", "Mean = 6.25, median = 6, mode = 6, range = 5.")
                        + Doc.recap("Data literacy and chance reasoning support informed decisions."),
                8, "c7nz-stats-prob", STRAT_STATS
        ));

        t.addQuestion(Doc.q(
                "What is 10^3?",
                List.of("30", "100", "1,000", "10,000"),
                2,
                "10^3 = 10×10×10 = 1,000.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Using GEMA, evaluate 2 + 3 × 4.",
                List.of("20", "14", "9", "24"),
                1,
                "Multiplication before addition: 3×4 = 12, then 2+12 = 14.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Solve 3x − 4 = 11.",
                List.of("x = 5", "x = 3", "x = 7", "x = 15"),
                0,
                "3x = 15 → x = 5.",
                "MEDIUM"
        ));
        t.addQuestion(Doc.q(
                "A fair spinner has 5 equal sections; 2 are red. Theoretical P(red) is:",
                List.of("2/5", "3/5", "2/3", "5/2"),
                0,
                "Favourable 2 out of 5 equally likely outcomes.",
                "EASY"
        ));

        return t;
    }
}
