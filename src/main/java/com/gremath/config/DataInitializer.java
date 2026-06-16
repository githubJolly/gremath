package com.gremath.config;

import com.gremath.model.Lesson;
import com.gremath.model.Question;
import com.gremath.model.Topic;
import com.gremath.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Seeds the database with GRE / CAT quantitative topics, lessons and practice questions
 * the first time the application starts (when no topics exist yet).
 */
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(TopicRepository topicRepository) {
        return args -> {
            if (topicRepository.count() > 0) {
                return;
            }

            topicRepository.save(numberProperties());
            topicRepository.save(percentages());
            topicRepository.save(ratiosProportions());
            topicRepository.save(averagesMixtures());
            topicRepository.save(algebra());
            topicRepository.save(geometry());
            topicRepository.save(timeSpeedDistance());
            topicRepository.save(permutationsCombinations());
            topicRepository.save(probability());
            topicRepository.save(profitLossInterest());
        };
    }

    // Helper to build a question concisely.
    private Question q(String text, List<String> options, int correct, String explanation, String difficulty) {
        return new Question(text, new java.util.ArrayList<>(options), correct, explanation, difficulty);
    }

    private Topic numberProperties() {
        Topic t = new Topic("number-properties", "Number Properties & Divisibility",
                "Integers, factors, multiples, primes, even/odd, divisibility rules and remainders.",
                "BOTH", 1);

        t.addLesson(new Lesson("Types of numbers",
                "<p>Key sets you must know:</p>" +
                "<ul>" +
                "<li><strong>Integers</strong>: ..., -2, -1, 0, 1, 2, ...</li>" +
                "<li><strong>Whole numbers</strong>: 0, 1, 2, 3, ...</li>" +
                "<li><strong>Prime numbers</strong>: exactly two factors (1 and itself): 2, 3, 5, 7, 11, ... Note <strong>2 is the only even prime</strong>.</li>" +
                "<li><strong>Composite numbers</strong>: more than two factors. 1 is neither prime nor composite.</li>" +
                "</ul>", 1));

        t.addLesson(new Lesson("Even &amp; odd rules",
                "<p>These results are tested constantly:</p>" +
                "<div class='formula'>even &plusmn; even = even &nbsp;&nbsp; odd &plusmn; odd = even &nbsp;&nbsp; even &plusmn; odd = odd</div>" +
                "<div class='formula'>even &times; anything = even &nbsp;&nbsp; odd &times; odd = odd</div>" +
                "<p>An integer is even iff it is divisible by 2.</p>", 2));

        t.addLesson(new Lesson("Divisibility rules",
                "<table>" +
                "<tr><th>Divisor</th><th>Rule</th></tr>" +
                "<tr><td>2</td><td>Last digit is even</td></tr>" +
                "<tr><td>3</td><td>Sum of digits divisible by 3</td></tr>" +
                "<tr><td>4</td><td>Last two digits divisible by 4</td></tr>" +
                "<tr><td>5</td><td>Ends in 0 or 5</td></tr>" +
                "<tr><td>6</td><td>Divisible by 2 and 3</td></tr>" +
                "<tr><td>9</td><td>Sum of digits divisible by 9</td></tr>" +
                "<tr><td>11</td><td>Alternating digit sum divisible by 11</td></tr>" +
                "</table>", 3));

        t.addLesson(new Lesson("Factors, HCF &amp; LCM",
                "<p>Any integer can be written as a product of primes (prime factorisation), e.g. 360 = 2&sup3; &times; 3&sup2; &times; 5.</p>" +
                "<p>The number of factors = product of (exponent + 1). For 360: (3+1)(2+1)(1+1) = 24 factors.</p>" +
                "<div class='formula'>HCF &times; LCM = product of the two numbers</div>", 4));

        t.addQuestion(q("Which of the following is a prime number?",
                List.of("51", "57", "61", "91"), 2,
                "61 has no divisor other than 1 and 61. 51 = 3&times;17, 57 = 3&times;19, 91 = 7&times;13.", "EASY"));

        t.addQuestion(q("If n is an odd integer, which expression is always even?",
                List.of("n + 2", "n\u00B2", "3n", "n + 1"), 3,
                "odd + 1 = even. n+2 stays odd, n\u00B2 of an odd is odd, and 3\u00D7odd is odd.", "EASY"));

        t.addQuestion(q("How many positive factors does 72 have?",
                List.of("6", "8", "12", "10"), 2,
                "72 = 2\u00B3 \u00D7 3\u00B2, so number of factors = (3+1)(2+1) = 12.", "MEDIUM"));

        t.addQuestion(q("What is the remainder when 2^10 is divided by 3?",
                List.of("0", "1", "2", "3"), 1,
                "2 \u2261 -1 (mod 3), so 2^10 \u2261 (-1)^10 = 1 (mod 3).", "MEDIUM"));

        t.addQuestion(q("The HCF of two numbers is 6 and their LCM is 60. If one number is 12, the other is:",
                List.of("30", "24", "18", "36"), 0,
                "Product = HCF \u00D7 LCM = 6 \u00D7 60 = 360. Other = 360 / 12 = 30.", "MEDIUM"));

        return t;
    }

    private Topic percentages() {
        Topic t = new Topic("percentages", "Percentages",
                "Converting percentages, percentage change, successive change and applications.",
                "BOTH", 2);

        t.addLesson(new Lesson("The basics",
                "<p>Percent means &ldquo;per hundred&rdquo;. To convert a fraction to a percentage, multiply by 100.</p>" +
                "<div class='formula'>x% of N = (x / 100) &times; N</div>" +
                "<p>Useful equivalents: 1/2 = 50%, 1/4 = 25%, 1/5 = 20%, 1/8 = 12.5%, 1/3 \u2248 33.33%.</p>", 1));

        t.addLesson(new Lesson("Percentage change",
                "<div class='formula'>% change = (New &minus; Old) / Old &times; 100</div>" +
                "<p>An increase from 80 to 100 is (20/80)&times;100 = 25%. A decrease from 100 to 80 is (20/100)&times;100 = 20%. Order matters because the base changes.</p>", 2));

        t.addLesson(new Lesson("Successive changes",
                "<p>For two successive changes of a% and b%, the net change is:</p>" +
                "<div class='formula'>net% = a + b + (a &times; b)/100</div>" +
                "<p>Example: +20% then &minus;20% gives 20 &minus; 20 &minus; 400/100 = &minus;4% (a net loss).</p>", 3));

        t.addQuestion(q("What is 15% of 240?",
                List.of("24", "36", "32", "40"), 1,
                "0.15 \u00D7 240 = 36.", "EASY"));

        t.addQuestion(q("A price rises from 50 to 65. What is the percentage increase?",
                List.of("15%", "25%", "30%", "23%"), 2,
                "Increase = 15 on a base of 50 = (15/50)\u00D7100 = 30%.", "EASY"));

        t.addQuestion(q("If a number is increased by 25% and then decreased by 20%, the net change is:",
                List.of("No change", "+5%", "-5%", "+45%"), 0,
                "Net% = 25 - 20 - (25\u00D720)/100 = 5 - 5 = 0%. No net change.", "MEDIUM"));

        t.addQuestion(q("60% of students passed. If 80 students failed, how many students are there in total?",
                List.of("160", "200", "240", "120"), 1,
                "Failures = 40% = 80, so 1% = 2, total = 200.", "MEDIUM"));

        t.addQuestion(q("A's salary is 20% more than B's. By what percent is B's salary less than A's?",
                List.of("20%", "25%", "16.67%", "10%"), 2,
                "If B = 100, A = 120. B is less by 20/120 = 16.67%.", "HARD"));

        return t;
    }

    private Topic ratiosProportions() {
        Topic t = new Topic("ratios-proportions", "Ratios & Proportions",
                "Simplifying ratios, dividing quantities, and direct/inverse proportion.",
                "BOTH", 3);

        t.addLesson(new Lesson("Understanding ratios",
                "<p>A ratio a : b compares two quantities. It can be scaled: 2 : 3 = 4 : 6 = 10 : 15.</p>" +
                "<p>To split an amount N in ratio a : b, each part is N/(a+b), so the shares are N&middot;a/(a+b) and N&middot;b/(a+b).</p>", 1));

        t.addLesson(new Lesson("Proportion",
                "<p>A proportion states two ratios are equal: a/b = c/d, equivalently <strong>ad = bc</strong> (cross-multiplication).</p>" +
                "<div class='formula'>Direct: y = kx &nbsp; (both grow together)</div>" +
                "<div class='formula'>Inverse: xy = k &nbsp; (one grows as the other shrinks)</div>", 2));

        t.addQuestion(q("Simplify the ratio 18 : 24.",
                List.of("2 : 3", "3 : 4", "4 : 5", "6 : 7"), 1,
                "Divide both by 6: 18/6 : 24/6 = 3 : 4.", "EASY"));

        t.addQuestion(q("Divide 90 in the ratio 2 : 3. The larger share is:",
                List.of("36", "54", "45", "60"), 1,
                "Total parts = 5, each part = 18. Larger share = 3\u00D718 = 54.", "EASY"));

        t.addQuestion(q("If a : b = 2 : 3 and b : c = 4 : 5, then a : c is:",
                List.of("8 : 15", "2 : 5", "5 : 8", "3 : 5"), 0,
                "Make b common: a:b = 8:12, b:c = 12:15, so a:c = 8:15.", "MEDIUM"));

        t.addQuestion(q("12 workers build a wall in 10 days. How many days for 8 workers (inverse proportion)?",
                List.of("15", "12", "20", "6.7"), 0,
                "Work is constant: 12\u00D710 = 8\u00D7d \u2192 d = 120/8 = 15 days.", "MEDIUM"));

        return t;
    }

    private Topic averagesMixtures() {
        Topic t = new Topic("averages-mixtures", "Averages, Mixtures & Alligation",
                "Arithmetic mean, weighted average and the rule of alligation.",
                "BOTH", 4);

        t.addLesson(new Lesson("Averages",
                "<div class='formula'>Average = (sum of values) / (number of values)</div>" +
                "<p>If the average of n numbers is A, their total is nA. Adding a value above the average raises the mean; below it lowers the mean.</p>", 1));

        t.addLesson(new Lesson("Weighted average &amp; alligation",
                "<p>When groups of different sizes are combined, use the weighted average:</p>" +
                "<div class='formula'>Avg = (n\u2081A\u2081 + n\u2082A\u2082) / (n\u2081 + n\u2082)</div>" +
                "<p>Alligation gives the ratio in which two ingredients at prices/concentrations must be mixed to reach a mean value:</p>" +
                "<div class='formula'>n\u2081 : n\u2082 = (A\u2082 &minus; M) : (M &minus; A\u2081)</div>", 2));

        t.addQuestion(q("The average of 4, 8, 10 and 14 is:",
                List.of("8", "9", "10", "12"), 1,
                "Sum = 36, count = 4, average = 9.", "EASY"));

        t.addQuestion(q("The average of 5 numbers is 20. If one number is removed the average becomes 22. The removed number is:",
                List.of("12", "10", "14", "8"), 0,
                "Total = 100. Remaining 4 sum to 88. Removed = 100 - 88 = 12.", "MEDIUM"));

        t.addQuestion(q("In what ratio must rice at 30/kg be mixed with rice at 45/kg to get a mixture at 40/kg?",
                List.of("1 : 1", "1 : 2", "2 : 1", "3 : 2"), 1,
                "By alligation: (45-40) : (40-30) = 5 : 10 = 1 : 2.", "MEDIUM"));

        t.addQuestion(q("A class of 30 boys averages 40 kg and 20 girls average 35 kg. The class average weight is:",
                List.of("37.5 kg", "38 kg", "38.5 kg", "37 kg"), 1,
                "Total = 30\u00D740 + 20\u00D735 = 1200 + 700 = 1900; /50 = 38 kg.", "MEDIUM"));

        return t;
    }

    private Topic algebra() {
        Topic t = new Topic("algebra", "Algebra: Linear & Quadratic Equations",
                "Solving linear and quadratic equations, and useful algebraic identities.",
                "BOTH", 5);

        t.addLesson(new Lesson("Linear equations",
                "<p>A linear equation in one variable looks like ax + b = 0, solved by isolating x: x = &minus;b/a.</p>" +
                "<p>For two variables, use substitution or elimination to solve simultaneous equations.</p>", 1));

        t.addLesson(new Lesson("Quadratic equations",
                "<p>A quadratic is ax&sup2; + bx + c = 0. Solve by factoring or the quadratic formula:</p>" +
                "<div class='formula'>x = (&minus;b &plusmn; &radic;(b&sup2; &minus; 4ac)) / 2a</div>" +
                "<p>Sum of roots = &minus;b/a, product of roots = c/a. The discriminant b&sup2;&minus;4ac tells how many real roots exist.</p>", 2));

        t.addLesson(new Lesson("Key identities",
                "<div class='formula'>(a + b)&sup2; = a&sup2; + 2ab + b&sup2;</div>" +
                "<div class='formula'>(a &minus; b)&sup2; = a&sup2; &minus; 2ab + b&sup2;</div>" +
                "<div class='formula'>a&sup2; &minus; b&sup2; = (a + b)(a &minus; b)</div>", 3));

        t.addQuestion(q("Solve: 3x - 7 = 11.",
                List.of("x = 6", "x = 4", "x = 5", "x = 9"), 0,
                "3x = 18, so x = 6.", "EASY"));

        t.addQuestion(q("The roots of x\u00B2 - 5x + 6 = 0 are:",
                List.of("2 and 3", "-2 and -3", "1 and 6", "-1 and -6"), 0,
                "Factor: (x-2)(x-3) = 0, so x = 2 or 3.", "EASY"));

        t.addQuestion(q("If x + 1/x = 4, then x\u00B2 + 1/x\u00B2 equals:",
                List.of("14", "16", "18", "12"), 0,
                "(x + 1/x)\u00B2 = x\u00B2 + 2 + 1/x\u00B2 = 16, so x\u00B2 + 1/x\u00B2 = 14.", "HARD"));

        t.addQuestion(q("For 2x + 3y = 12 and x = 3, find y.",
                List.of("1", "2", "3", "4"), 1,
                "2(3) + 3y = 12 \u2192 3y = 6 \u2192 y = 2.", "EASY"));

        t.addQuestion(q("The sum of the roots of 2x\u00B2 - 8x + 6 = 0 is:",
                List.of("4", "-4", "3", "8"), 0,
                "Sum of roots = -b/a = 8/2 = 4.", "MEDIUM"));

        return t;
    }

    private Topic geometry() {
        Topic t = new Topic("geometry", "Geometry & Mensuration",
                "Lines, triangles, circles and the area/volume formulas you must memorise.",
                "BOTH", 6);

        t.addLesson(new Lesson("Triangles",
                "<p>Angles of a triangle sum to 180&deg;. The Pythagorean theorem for right triangles:</p>" +
                "<div class='formula'>a&sup2; + b&sup2; = c&sup2; &nbsp; (c is the hypotenuse)</div>" +
                "<div class='formula'>Area = &frac12; &times; base &times; height</div>", 1));

        t.addLesson(new Lesson("Circles",
                "<div class='formula'>Circumference = 2&pi;r &nbsp;&nbsp; Area = &pi;r&sup2;</div>" +
                "<p>A diameter is twice the radius. Use &pi; \u2248 3.14 or 22/7 as instructed.</p>", 2));

        t.addLesson(new Lesson("Areas &amp; volumes",
                "<table>" +
                "<tr><th>Shape</th><th>Formula</th></tr>" +
                "<tr><td>Rectangle area</td><td>length &times; width</td></tr>" +
                "<tr><td>Square area</td><td>side&sup2;</td></tr>" +
                "<tr><td>Cuboid volume</td><td>l &times; w &times; h</td></tr>" +
                "<tr><td>Cylinder volume</td><td>&pi;r&sup2;h</td></tr>" +
                "<tr><td>Sphere volume</td><td>(4/3)&pi;r&sup3;</td></tr>" +
                "</table>", 3));

        t.addQuestion(q("The area of a triangle with base 10 and height 6 is:",
                List.of("60", "30", "16", "32"), 1,
                "Area = \u00BD \u00D7 10 \u00D7 6 = 30.", "EASY"));

        t.addQuestion(q("A right triangle has legs 3 and 4. Its hypotenuse is:",
                List.of("5", "6", "7", "\u221A7"), 0,
                "3\u00B2 + 4\u00B2 = 9 + 16 = 25, so hypotenuse = 5.", "EASY"));

        t.addQuestion(q("The area of a circle with radius 7 (use \u03C0 = 22/7) is:",
                List.of("154", "144", "44", "49"), 0,
                "Area = (22/7) \u00D7 7 \u00D7 7 = 154.", "MEDIUM"));

        t.addQuestion(q("The angles of a triangle are in ratio 1 : 2 : 3. The largest angle is:",
                List.of("60\u00B0", "90\u00B0", "120\u00B0", "100\u00B0"), 1,
                "Parts sum to 6 = 180\u00B0, so 1 part = 30\u00B0. Largest = 3\u00D730 = 90\u00B0.", "MEDIUM"));

        t.addQuestion(q("The volume of a cube with side 4 is:",
                List.of("16", "48", "64", "12"), 2,
                "Volume = side\u00B3 = 4\u00B3 = 64.", "EASY"));

        return t;
    }

    private Topic timeSpeedDistance() {
        Topic t = new Topic("time-speed-distance", "Time, Speed & Distance",
                "Speed-distance-time relationship, average speed, and relative speed.",
                "BOTH", 7);

        t.addLesson(new Lesson("Core relationship",
                "<div class='formula'>Distance = Speed &times; Time</div>" +
                "<p>So Speed = Distance/Time and Time = Distance/Speed. Keep units consistent.</p>" +
                "<p>Convert: 1 km/h = 5/18 m/s, and 1 m/s = 18/5 km/h.</p>", 1));

        t.addLesson(new Lesson("Average &amp; relative speed",
                "<p>Average speed for equal distances at speeds u and v is the harmonic mean:</p>" +
                "<div class='formula'>Avg speed = 2uv / (u + v)</div>" +
                "<p>Relative speed: add speeds when moving towards each other, subtract when moving in the same direction.</p>", 2));

        t.addQuestion(q("A car travels 150 km in 3 hours. Its speed is:",
                List.of("45 km/h", "50 km/h", "60 km/h", "75 km/h"), 1,
                "Speed = 150/3 = 50 km/h.", "EASY"));

        t.addQuestion(q("Convert 72 km/h to m/s.",
                List.of("15 m/s", "20 m/s", "25 m/s", "30 m/s"), 1,
                "72 \u00D7 5/18 = 20 m/s.", "EASY"));

        t.addQuestion(q("A person covers half a journey at 40 km/h and half at 60 km/h. Average speed is:",
                List.of("50 km/h", "48 km/h", "52 km/h", "45 km/h"), 1,
                "Equal distances \u2192 2\u00D740\u00D760/(40+60) = 4800/100 = 48 km/h.", "HARD"));

        t.addQuestion(q("Two trains 80 km apart move towards each other at 30 and 50 km/h. They meet in:",
                List.of("1 hour", "1.5 hours", "2 hours", "0.5 hour"), 0,
                "Relative speed = 80 km/h, time = 80/80 = 1 hour.", "MEDIUM"));

        return t;
    }

    private Topic permutationsCombinations() {
        Topic t = new Topic("permutations-combinations", "Permutations & Combinations",
                "Counting principle, arrangements (nPr) and selections (nCr).",
                "BOTH", 8);

        t.addLesson(new Lesson("Counting principle &amp; factorials",
                "<p>If one task can be done in m ways and another in n ways, together they can be done in m&times;n ways.</p>" +
                "<div class='formula'>n! = n &times; (n&minus;1) &times; ... &times; 2 &times; 1, &nbsp; 0! = 1</div>", 1));

        t.addLesson(new Lesson("Permutations vs combinations",
                "<p><strong>Permutation</strong> = arrangement (order matters):</p>" +
                "<div class='formula'>nPr = n! / (n &minus; r)!</div>" +
                "<p><strong>Combination</strong> = selection (order does not matter):</p>" +
                "<div class='formula'>nCr = n! / [r!(n &minus; r)!]</div>", 2));

        t.addQuestion(q("In how many ways can 5 people stand in a row?",
                List.of("25", "60", "120", "20"), 2,
                "5! = 120.", "EASY"));

        t.addQuestion(q("How many ways to choose 2 books from 6?",
                List.of("12", "15", "30", "20"), 1,
                "6C2 = 6\u00D75/2 = 15.", "EASY"));

        t.addQuestion(q("How many 3-digit numbers can be formed from 1-9 with no repetition?",
                List.of("504", "729", "720", "84"), 0,
                "9P3 = 9\u00D78\u00D77 = 504.", "MEDIUM"));

        t.addQuestion(q("A committee of 3 is chosen from 4 men and 3 women, with exactly 2 men. Number of ways:",
                List.of("12", "18", "9", "24"), 1,
                "Choose 2 men (4C2 = 6) and 1 woman (3C1 = 3): 6\u00D73 = 18.", "HARD"));

        return t;
    }

    private Topic probability() {
        Topic t = new Topic("probability", "Probability",
                "Basic probability, complementary events and the addition rule.",
                "BOTH", 9);

        t.addLesson(new Lesson("Definition",
                "<div class='formula'>P(event) = favourable outcomes / total outcomes</div>" +
                "<p>Probability is always between 0 and 1. P(certain) = 1, P(impossible) = 0.</p>", 1));

        t.addLesson(new Lesson("Rules",
                "<div class='formula'>P(not A) = 1 &minus; P(A)</div>" +
                "<div class='formula'>P(A or B) = P(A) + P(B) &minus; P(A and B)</div>" +
                "<p>For independent events, P(A and B) = P(A) &times; P(B).</p>", 2));

        t.addQuestion(q("A fair die is rolled. P(getting an even number) is:",
                List.of("1/3", "1/2", "1/6", "2/3"), 1,
                "Even numbers {2,4,6} = 3 of 6 outcomes = 1/2.", "EASY"));

        t.addQuestion(q("A card is drawn from 52. P(it is a king) is:",
                List.of("1/13", "1/26", "1/4", "4/13"), 0,
                "4 kings / 52 = 1/13.", "EASY"));

        t.addQuestion(q("Two coins are tossed. P(at least one head) is:",
                List.of("1/4", "1/2", "3/4", "1"), 2,
                "P(no head) = 1/4, so P(at least one) = 1 - 1/4 = 3/4.", "MEDIUM"));

        t.addQuestion(q("A bag has 3 red and 2 blue balls. P(drawing a red) is:",
                List.of("2/5", "3/5", "1/2", "3/2"), 1,
                "3 red of 5 total = 3/5.", "EASY"));

        return t;
    }

    private Topic profitLossInterest() {
        Topic t = new Topic("profit-loss-interest", "Profit, Loss & Interest",
                "Cost price, selling price, profit/loss percent, and simple & compound interest.",
                "BOTH", 10);

        t.addLesson(new Lesson("Profit and loss",
                "<div class='formula'>Profit = SP &minus; CP, &nbsp; Profit% = (Profit / CP) &times; 100</div>" +
                "<div class='formula'>Loss = CP &minus; SP, &nbsp; Loss% = (Loss / CP) &times; 100</div>" +
                "<p>Always compute the percentage on the <strong>cost price</strong> unless told otherwise.</p>", 1));

        t.addLesson(new Lesson("Simple &amp; compound interest",
                "<div class='formula'>Simple Interest = P &times; R &times; T / 100</div>" +
                "<div class='formula'>Compound Amount = P (1 + R/100)^T</div>" +
                "<p>P = principal, R = rate per period (%), T = number of periods.</p>", 2));

        t.addQuestion(q("An item costs 200 and sells for 250. The profit percent is:",
                List.of("20%", "25%", "50%", "15%"), 1,
                "Profit = 50 on CP 200 = 25%.", "EASY"));

        t.addQuestion(q("Simple interest on 1000 at 5% per year for 3 years is:",
                List.of("100", "150", "200", "50"), 1,
                "SI = 1000\u00D75\u00D73/100 = 150.", "EASY"));

        t.addQuestion(q("An article bought for 500 is sold at a 10% loss. The selling price is:",
                List.of("450", "550", "490", "460"), 0,
                "Loss = 10% of 500 = 50, SP = 500 - 50 = 450.", "EASY"));

        t.addQuestion(q("The compound amount on 2000 at 10% per annum for 2 years is:",
                List.of("2400", "2420", "2200", "2410"), 1,
                "2000\u00D7(1.1)\u00B2 = 2000\u00D71.21 = 2420.", "MEDIUM"));

        return t;
    }
}
