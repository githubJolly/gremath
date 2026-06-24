package com.gremath.content;

import com.gremath.model.Lesson;
import com.gremath.model.Topic;
import java.util.List;

/**
 * Foundation topic for Year 6 learners following the New Zealand curriculum.
 * Lessons are intentionally concept-first and contextual.
 */
public class Class6NzMathematicsContent implements TopicContent {
    private static final String STRAT_PLACE_VALUE =
            "<p>Use place-value structure first, then compare from left to right.</p>"
                    + Doc.steps(
                    "Rewrite large numbers in expanded form.",
                    "Compare highest place first (millions, hundred-thousands, ...).",
                    "Round only after identifying the target place correctly.",
                    "Use estimation to check operation results."
            )
                    + Doc.tip("If two numbers share the same leading digits, the first place where they differ decides the larger number.");

    private static final String STRAT_OPERATIONS =
            "<p>Translate context to operation symbols before calculating.</p>"
                    + Doc.steps(
                    "Mark clue words: total, difference, groups, each, left over.",
                    "Estimate roughly before exact arithmetic.",
                    "Use inverse operations to verify final answers.",
                    "For multi-step expressions, follow order of operations."
            )
                    + Doc.warn("A remainder can be interpreted in different ways depending on the story: leftover items, partial group, or decimal/fraction.");

    private static final String STRAT_FDP =
            "<p>Treat fractions, decimals and percentages as equivalent forms.</p>"
                    + Doc.steps(
                    "Convert to a common form before comparing values.",
                    "Use benchmark equivalents: 1/2, 1/4, 3/4, 10%, 25%, 50%.",
                    "For percent-of problems: part = percent x whole.",
                    "In word problems, identify the base quantity (the full 100%)."
            )
                    + Doc.tip("Use a 100-grid mental model: percent means out of 100, which links directly to decimal place value.");

    private static final String STRAT_PATTERNS =
            "<p>Find the growth rule first, then generalize.</p>"
                    + Doc.steps(
                    "Check differences (add/subtract) and ratios (multiply/divide).",
                    "Write the rule in words before symbols.",
                    "Use a table to test the rule on several terms.",
                    "For coordinate tasks, map rule output to y-values."
            )
                    + Doc.tip("When a sequence has a constant difference, it is linear and can be modeled with a simple n-rule.");

    private static final String STRAT_GEOMETRY =
            "<p>Classify by properties, not appearance.</p>"
                    + Doc.steps(
                    "Track sides, angles, parallel lines and symmetry lines.",
                    "Use angle facts (straight line 180, around a point 360).",
                    "Differentiate 2D attributes from 3D attributes.",
                    "Use transformations to test pattern structure."
            )
                    + Doc.warn("A square is a special rectangle and also a special rhombus; categories can overlap.");

    private static final String STRAT_MEASUREMENT =
            "<p>Estimate, choose units, then compute.</p>"
                    + Doc.steps(
                    "Select sensible units before calculation.",
                    "Convert to a common unit before combining values.",
                    "For area and volume, check that units are squared/cubed.",
                    "Use timeline diagrams for elapsed-time problems."
            )
                    + Doc.tip("Metric conversions are powers of 10 shifts; write unit ladders to avoid place-value slips.");

    private static final String STRAT_DATA_CHANCE =
            "<p>Read the data source before making conclusions.</p>"
                    + Doc.steps(
                    "Identify what each axis/label and unit means.",
                    "Compute mean and range from accurate totals.",
                    "Compare trends, not just isolated points.",
                    "For chance, list sample space before assigning probability."
            )
                    + Doc.warn("A graph may look dramatic if the scale is uneven. Always check axis intervals.");

    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-mathematics",
                "Class 6 Mathematics (New Zealand Curriculum)",
                "Number knowledge, fractions/decimals, geometry, measurement and simple statistics for Year 6 learners.",
                "CLASS6_NZ",
                1
        );

        t.addLesson(new Lesson(
                "1. Place value and whole numbers",
                "<p>Understand how each digit changes value based on its place. In 4,582 the 4 means four thousands, not just four.</p>"
                        + "<div class='callout c-key'><strong>Visual place chart:</strong> [Millions | Hundred-thousands | Ten-thousands | Thousands | Hundreds | Tens | Ones]</div>"
                        + Doc.key("Read and write numbers up to at least 100,000 confidently, including expanded form.")
                        + Doc.steps(
                        "Break a number into place values (thousands, hundreds, tens, ones).",
                        "Compare numbers by looking from left to right.",
                        "Use estimation to check if answers are sensible."
                )
                        + Doc.example("Compare 48,209 and 48,029", "Both start with 48 thousand. Compare hundreds: 2 hundreds is greater than 0 hundreds, so 48,209 is larger.")
                        + Doc.recap("Place value helps with reading numbers, comparing them, and estimating answers quickly."),
                1,
                "c6nz-place-value",
                STRAT_PLACE_VALUE
        ));

        t.addLesson(new Lesson(
                "2. Addition, subtraction, multiplication and division",
                "<p>Choose the right operation based on context: combine, difference, equal groups, or sharing.</p>"
                        + "<div class='callout c-tip'><strong>Operation map:</strong> combine -> +, difference -> -, equal groups -> x, sharing -> /</div>"
                        + Doc.tip("Before calculating, estimate first to know the rough answer.")
                        + Doc.steps(
                        "Underline the key quantity words in the question.",
                        "Choose the operation and write the number sentence.",
                        "Solve and then check with inverse operations."
                )
                        + Doc.example("624 ÷ 8", "Think: what number times 8 gives 624? It is 78, because 8 × 78 = 624.")
                        + Doc.recap("Use all four operations flexibly and always check reasonableness."),
                2,
                "c6nz-operations",
                STRAT_OPERATIONS
        ));

        t.addLesson(new Lesson(
                "3. Fractions, decimals and percentages",
                "<p>Fractions, decimals and percentages describe the same part of a whole in different forms.</p>"
                        + Doc.formula("1/2 = 0.5 = 50%")
                        + Doc.formula("1/4 = 0.25 = 25%")
                        + Doc.steps(
                        "Use visual models (bars, circles, grids).",
                        "Find equivalent fractions by multiplying/dividing top and bottom by the same number.",
                        "Convert simple fractions to decimals and percentages."
                )
                        + "<table><tr><th>Fraction</th><th>Decimal</th><th>Percent</th></tr><tr><td>1/2</td><td>0.5</td><td>50%</td></tr><tr><td>1/4</td><td>0.25</td><td>25%</td></tr><tr><td>3/4</td><td>0.75</td><td>75%</td></tr></table>"
                        + Doc.example("What is 25% of 80?", "25% means one-quarter. One-quarter of 80 is 20.")
                        + Doc.recap("Switching between fraction, decimal and percent builds flexible number thinking."),
                3,
                "c6nz-fdp",
                STRAT_FDP
        ));

        t.addLesson(new Lesson(
                "4. Patterns and simple algebra",
                "<p>Patterns help learners generalise and build early algebraic thinking.</p>"
                        + Doc.analogy("A pattern rule is like a recipe: if you know the rule, you can produce any term.")
                        + Doc.steps(
                        "Identify what changes each step (add, subtract, multiply).",
                        "Write the rule in words.",
                        "Use a symbol (like n) to describe the nth term for simple linear patterns."
                )
                        + "<div class='callout c-key'><strong>Pattern strip:</strong> 4, 7, 10, 13, ...  ( +3 each time )</div>"
                        + Doc.example("3, 6, 9, 12, ...", "Rule: add 3 each time. A simple nth term expression is 3n.")
                        + Doc.recap("Patterns are the bridge from arithmetic to algebra."),
                4,
                "c6nz-patterns",
                STRAT_PATTERNS
        ));

        t.addLesson(new Lesson(
                "5. Geometry: shapes, angles and symmetry",
                "<p>Classify 2D and 3D shapes using properties such as sides, faces, angles and lines of symmetry.</p>"
                        + Doc.key("A right angle is 90°. Acute is less than 90°. Obtuse is greater than 90° and less than 180°.")
                        + Doc.steps(
                        "Sort shapes by properties, not only by appearance.",
                        "Use a protractor to estimate and measure angles.",
                        "Find lines of symmetry by folding or mirror reasoning."
                )
                        + "<div class='callout c-tip'><strong>Angle bar:</strong> acute (<90) | right (=90) | obtuse (90-180) | straight (=180)</div>"
                        + Doc.example("Rectangle vs square", "Both have four right angles. A square has all sides equal, a rectangle may not.")
                        + Doc.recap("Geometry is about properties and relationships between shapes."),
                5,
                "c6nz-geometry",
                STRAT_GEOMETRY
        ));

        t.addLesson(new Lesson(
                "6. Measurement: length, area, volume, time and temperature",
                "<p>Choose suitable units and convert between common metric measures.</p>"
                        + Doc.formula("1 m = 100 cm, 1 km = 1000 m, 1 L = 1000 mL")
                        + Doc.tip("Always include units in working and final answers.")
                        + Doc.steps(
                        "Estimate first (about how much?).",
                        "Measure with the right tool and unit.",
                        "Convert only when needed to compare or combine values."
                )
                        + "<table><tr><th>Quantity</th><th>Common units</th></tr><tr><td>Length</td><td>mm, cm, m, km</td></tr><tr><td>Mass</td><td>g, kg</td></tr><tr><td>Capacity</td><td>mL, L</td></tr><tr><td>Time</td><td>s, min, h</td></tr></table>"
                        + Doc.example("2.5 m + 40 cm", "Convert to one unit first: 40 cm = 0.4 m, so total is 2.9 m.")
                        + Doc.recap("Measurement combines estimation, unit sense and conversion."),
                6,
                "c6nz-measurement",
                STRAT_MEASUREMENT
        ));

        t.addLesson(new Lesson(
                "7. Data, graphs and chance",
                "<p>Collect, organise and interpret data using tables and simple graphs. Describe chance with language like impossible, unlikely, even chance, likely and certain.</p>"
                        + Doc.steps(
                        "Read the title, labels and scale on a graph before answering.",
                        "Compare categories and explain what the data suggests.",
                        "Use fractions or percentages to describe simple probabilities."
                )
                        + "<div class='callout c-key'><strong>Chance line:</strong> 0 (impossible) -- 1/2 (even chance) -- 1 (certain)</div>"
                        + Doc.example("If 3 out of 12 outcomes are red", "Probability of red = 3/12 = 1/4 = 25%.")
                        + Doc.recap("Data shows what happened; probability predicts what may happen."),
                7,
                "c6nz-data-chance",
                STRAT_DATA_CHANCE
        ));

        t.addQuestion(Doc.q(
                "Which number is greater?",
                List.of("48,029", "48,209", "They are equal", "Cannot be compared"),
                1,
                "Compare place value from left to right. The hundreds digit decides this one.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Which is equivalent to 1/4?",
                List.of("0.4", "25%", "40%", "2/5"),
                1,
                "One-quarter equals 0.25 which is 25%.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "How many millilitres are in 1.5 litres?",
                List.of("150", "1500", "1050", "15,000"),
                1,
                "1 litre = 1000 mL, so 1.5 L = 1500 mL.",
                "MEDIUM"
        ));
        t.addQuestion(Doc.q(
                "A pattern goes 5, 9, 13, 17, ... What is the next term?",
                List.of("19", "20", "21", "22"),
                2,
                "The pattern adds 4 each step, so after 17 comes 21.",
                "EASY"
        ));

        return t;
    }
}
