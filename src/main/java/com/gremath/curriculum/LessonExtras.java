package com.gremath.curriculum;

/**
 * Extra worked examples and a second diagram for every year/subject lesson.
 */
public final class LessonExtras {

    private LessonExtras() {
    }

    public static String apply(int year, String kind, String html) {
        if (html == null || html.isBlank()) {
            return html;
        }
        String extras = extraFigure(year, kind) + extraExamples(year, kind);
        int i = html.indexOf("<div class='callout c-warn'>");
        if (i < 0) {
            i = html.indexOf("<div class='callout c-exam'>");
        }
        if (i < 0) {
            i = html.indexOf("<div class='callout c-recap'>");
        }
        if (i >= 0) {
            return html.substring(0, i) + extras + html.substring(i);
        }
        return html + extras;
    }

    private static int band(int year) {
        if (year <= 3) {
            return 1;
        }
        if (year <= 6) {
            return 2;
        }
        if (year <= 8) {
            return 3;
        }
        return 4;
    }

    private static String extraFigure(int year, String kind) {
        String k = kind == null ? "" : kind;
        int b = band(year);
        return switch (k) {
            case "NUMBER" -> b == 1
                    ? MathFigures.tensFrame(Math.min(10, year + 4), "A tens frame: fill " + (year + 4) + " and see the empty boxes.")
                    : b == 2
                    ? MathFigures.numberLine(0, 20, 16, "16 sits further right than 12. Compare from the left-most place.")
                    : MathFigures.integerJump(4, year >= 8 ? -9 : -5, "A directed jump on the number line.");
            case "PRIME" -> MathFigures.factorTree(21, 3, 7, "Split until both branches are prime: 21 = 3 × 7.");
            case "OPS" -> MathFigures.array(Math.min(6, year + 1), 4, "Equal rows: count a group, then multiply.");
            case "FRACTION" -> year <= 2
                    ? MathFigures.fractionBar(1, 2, "One of two equal parts is a half.")
                    : MathFigures.fractionCompare(1, 2, 1, 4, "1/2", "1/4", "Same-size wholes: 1/2 is larger than 1/4.");
            case "ALGEBRA" -> year <= 4
                    ? MathFigures.balanceScale("7 + □", "12", "Both sides of = must weigh the same.")
                    : MathFigures.coordinatePoint(Math.min(year - 3, 6), Math.min(year - 2, 8),
                    "Along first (x), then up (y).");
            case "MEASURE" -> year <= 4
                    ? MathFigures.rectangle(6, 3, "Label length and width before you add or multiply.")
                    : year <= 7
                    ? MathFigures.lShape(8, 5, 3, 2, "Split an L-shape into two rectangles.")
                    : MathFigures.circle(8, "Diameter is twice the radius.");
            case "GEOMETRY" -> year <= 5
                    ? MathFigures.triangleAngles(60, 60, "60°", "An equilateral triangle: three equal angles.")
                    : MathFigures.anglesOnLine(110, "A straight line is 180°. The missing angle is 70°.");
            case "DATA" -> MathFigures.barChart("Class pets", new String[]{"Cat", "Dog", "Fish"}, new int[]{5, 8, 3});
            case "CHANCE" -> MathFigures.spinner(new String[]{"A", "B", "C", "D"}, 1, "Four equal sectors: each has chance 1/4.");
            case "ORAL" -> SubjectFigures.speechTurn("Add because… so the listener hears your reason.");
            case "READING" -> SubjectFigures.storyMountain("Start, problem, end — then hunt a quote.");
            case "WRITING" -> SubjectFigures.sentenceParts("Who / did what / where keeps a sentence on track.");
            case "GRAMMAR" -> SubjectFigures.sentenceParts("Subject, verb, extra information.");
            case "INVESTIGATE" -> SubjectFigures.fairTest("Only one change. Measure the same way twice.");
            case "LIVING" -> SubjectFigures.plantParts("Leaf, stem, roots — name the part that does the job.");
            case "MATTER" -> SubjectFigures.waterCycle("Heat lifts water; cooling brings it down as rain.");
            case "FORCES" -> SubjectFigures.circuit("A complete loop: cell, lamp, switch.");
            case "EARTH" -> SubjectFigures.waterCycle("The same water moves: sea, cloud, rain, river.");
            case "IDENTITY" -> SubjectFigures.timeline("People, place and time sit together in a pepeha.");
            case "PLACE" -> SubjectFigures.identityPlaces("Read the land: maunga and awa on a simple map.");
            case "HISTORY" -> SubjectFigures.timeline("Put events in order before you explain why.");
            case "ECONOMY" -> SubjectFigures.needsWants("Sort: need to live, or nice to have?");
            case "CIVICS" -> SubjectFigures.civicRules("A rule at school has a reason you can say.");
            case "DESIGN", "EVALUATE", "MAKING", "DIGITAL", "COMPUTE" -> SubjectFigures.designBrief(
                    "Sketch the user, the problem, then one idea to test.");
            case "VISUAL", "RESPOND" -> SubjectFigures.storyMountain("Notice, name an element, then say the effect.");
            case "MUSIC" -> SubjectFigures.musicNotes("Clap the beat, then point to a higher pitch.");
            case "DRAMA", "DANCE", "MOVE" -> SubjectFigures.moveSkill("Body ready. Eyes on the target.");
            case "HAUORA", "RELATE", "COMMUNITY" -> SubjectFigures.hauoraTaha("Name the taha you are looking after.");
            case "SAFETY" -> SubjectFigures.safetyFlags("Stay between the flags with a buddy.");
            case "GREETINGS", "WORDS", "LISTEN", "READLANG", "TIKANGA" -> SubjectFigures.greetingKiaOra(
                    "Kia ora to a group. Tēnā koe to one person.");
            default -> MathFigures.numberLine(0, 10, year, "A picture first, then the words.");
        };
    }

    private static String extraExamples(int year, String kind) {
        String k = kind == null ? "" : kind;
        String[] pair = examplesFor(year, k);
        return LessonHtml.h4("More examples")
                + LessonHtml.worked(pair[0], LessonHtml.p(pair[1]))
                + LessonHtml.worked(pair[2], LessonHtml.p(pair[3]));
    }

    private static String[] examplesFor(int year, String kind) {
        int b = band(year);
        return switch (kind) {
            case "NUMBER" -> b == 1
                    ? new String[]{"Show 8 on a tens frame", "Fill 8 dots. Two boxes stay empty. 8 and 2 make 10.",
                    "Which is more, 14 or 11?", "Line them on a number line. 14 is further right, so 14 is more."}
                    : b == 2
                    ? new String[]{"Write 3,406 in expanded form", "3,406 = 3,000 + 400 + 6. The tens house is 0 — a placeholder.",
                    "Round 7,482 to the nearest hundred", "Look at tens: 8 ≥ 5, so 7,500."}
                    : new String[]{"Order −6, 2, −1, 0", "Number line left to right: −6, −1, 0, 2.",
                    "Write 45,000 in scientific notation (Y9–10 idea)", year >= 9
                    ? "45,000 = 4.5 × 10⁴. The digit part is at least 1 and less than 10."
                    : "45,000 = 45 × 1,000. Each jump of ×10 is a place-value house."};
            case "PRIME" -> new String[]{"Is 51 prime?",
                    "Digit sum 6 is divisible by 3, so 51 = 3 × 17. Composite — not prime.",
                    "HCF and LCM of 8 and 12",
                    "8 = 2³, 12 = 2²×3. HCF = 2² = 4. LCM = 2³×3 = 24."};
            case "OPS" -> b <= 2
                    ? new String[]{"6 rows of 4", "6 × 4 = 24. An array of 6 by 4 has 24 dots.",
                    "28 shared among 4", "28 ÷ 4 = 7. Each person gets 7 with none left."}
                    : new String[]{"(−3) + 8", "Start at −3, jump 8 right: 5.",
                    "GEMA: 4 + 3 × 2", "Multiply first: 4 + 6 = 10. Not 14."};
            case "FRACTION" -> b == 1
                    ? new String[]{"Shade 1/2 of 8 counters", "Half of 8 is 4. Two equal groups.",
                    "Is 2/4 the same as 1/2?", "Same whole, same amount shaded — equivalent."}
                    : new String[]{"Find 3/4 of 20", "20 ÷ 4 = 5, then 3 × 5 = 15.",
                    "0.25 as a fraction and percent", "0.25 = 1/4 = 25%."};
            case "ALGEBRA" -> b <= 2
                    ? new String[]{"7 + □ = 12", "Undo +7: □ = 5. Check: 7 + 5 = 12.",
                    "Pattern 2, 5, 8, 11… next two", "Add 3 each time: 14, then 17."}
                    : new String[]{"Solve 3x − 5 = 10", "Add 5: 3x = 15. Divide by 3: x = 5. Check: 15 − 5 = 10.",
                    "If y = 2x and x + y = 12", "x + 2x = 12, 3x = 12, x = 4, y = 8. Check both equations."};
            case "MEASURE" -> b <= 2
                    ? new String[]{"Perimeter of a 6 cm by 4 cm rectangle", "6+4+6+4 = 20 cm. The fence, not the grass.",
                    "Which unit for a classroom length?", "Metres. Centimetres would be an awkward big number."}
                    : new String[]{"Area of a right triangle base 10 cm, height 6 cm", "½ × 10 × 6 = 30 cm². Height is perpendicular.",
                    "C = πd for d = 10 cm, π ≈ 3.14", "C ≈ 31.4 cm. Radius would be 5 cm."};
            case "GEOMETRY" -> new String[]{"Triangle angles 70° and 50°. Third angle?",
                    "180 − 70 − 50 = 60°. Always check the three sum to 180°.",
                    "A shape with 4 equal sides and 4 right angles",
                    "A square. A rhombus can have equal sides without right angles."};
            case "DATA" -> new String[]{"Bar heights 5, 8, 3. Which is the mode if those are counts?",
                    "Dog (8) is the tallest bar — most common in this chart.",
                    "Mean of 2, 4, 6", "Sum 12, divide by 3: mean = 4. Median is also 4."};
            case "CHANCE" -> new String[]{"Fair die. P(even)?",
                    "Even faces 2, 4, 6. Favourable 3, total 6. P = 1/2.",
                    "Spinner 3 red, 1 blue. P(not red)?",
                    "Not red is the one blue sector: 1/4."};
            case "ORAL" -> new String[]{"Turn-taking in news time",
                    "Listen to the whole idea. Then add: ‘I agree because…’ or ‘I wonder…’.",
                    "Year " + year + " talk: explain a process",
                    "Order the steps. Use first, next, last. Check a listener can repeat them."};
            case "READING" -> new String[]{"Find the gist in three sentences",
                    "Who? What happened? Why does it matter? Write one sentence that covers all three.",
                    "Evidence for a feeling",
                    "Do not only say ‘she is sad’. Quote the clue: ‘she stared at the empty seat’."};
            case "WRITING" -> new String[]{"Plan a paragraph",
                    "Topic sentence, two details, a closer. One idea — not a list of ten.",
                    "A Year " + year + " audience check",
                    "Read it aloud. If a listener gets lost, split a long sentence."};
            case "GRAMMAR" -> new String[]{"Spot the verb",
                    "In ‘The tūī sings at dawn’, sings is the doing word. Subject is The tūī.",
                    "Fix the stop",
                    "Two complete ideas need a full stop or a joining word — not a comma splice."};
            case "INVESTIGATE" -> new String[]{"Is this a fair test?",
                    "If two things change (brand and cup size), you cannot tell which caused the result.",
                    "Write a claim from data",
                    "‘Brand A lasted longer in this test of 3 trials’ — not ‘Brand A is always best’."};
            case "LIVING" -> new String[]{"Living or non-living?",
                    "A rock does not grow, feed or reproduce. A seedling does. Use needs, not ‘it moves’.",
                    "Name the producer in harakeke → insect → pīwakawaka",
                    "Harakeke is the producer. Arrows show energy flow, not who is ‘friends’."};
            case "MATTER" -> new String[]{"Ice to water",
                    "Melting: solid to liquid. Particles stay the same stuff; arrangement changes.",
                    "Which state fills any container?",
                    "A gas spreads to fill the space. A liquid takes the shape but keeps a level."};
            case "FORCES" -> new String[]{"Push or pull?",
                    "Opening a drawer is a pull. Closing a door is usually a push. Draw an arrow.",
                    "Why a lamp stays off",
                    "An open switch breaks the loop. No complete path, no current."};
            case "EARTH" -> new String[]{"Why night happens",
                    "Earth rotates. Your place turns away from the Sun — it is not the Sun ‘switching off’.",
                    "Where does rain come from in the cycle?",
                    "Water evaporates, cools in a cloud, then falls. The sea is one store."};
            case "IDENTITY" -> new String[]{"Name a connection to place",
                    "A pepeha can name a maunga and an awa. Say why that place matters to the speaker.",
                    "Year " + year + " identity example",
                    "A sports club, iwi, or street can all be part of who someone is — give one reason."};
            case "PLACE" -> new String[]{"Read a map key",
                    "Green might mean forest — but only if the key says so. Check before you guess.",
                    "Describe a local place in two features",
                    "Example: a river bend and a school. Use north/south if you have a compass rose."};
            case "HISTORY" -> new String[]{"Put three events in time order",
                    "Voyaging to Aotearoa, Te Tiriti 1840, then a local event you can date.",
                    "A source check",
                    "Ask: who made this? When? What might they want us to believe?"};
            case "ECONOMY" -> new String[]{"Need or want?",
                    "Clean water is a need. A new game is a want. Both can matter, but they are not the same.",
                    "A scarce resource",
                    "If everyone wants the same lunch table, time and space are limited — you need a fair rule."};
            case "CIVICS" -> new String[]{"A school rule with a reason",
                    "Hats outside: sun safety. The duty (wear a hat) protects a right (to be safe).",
                    "Who decides locally?",
                    "A board, council or class vote — name the group and one decision they can make."};
            case "DESIGN", "EVALUATE", "MAKING", "DIGITAL", "COMPUTE" -> new String[]{
                    "User and problem",
                    "User: a Year " + year + " student with a messy bag. Problem: keys get lost. Idea: a bright tag.",
                    "Test and improve",
                    "Try the tag for a day. If it falls off, change the clip — that is iterating."};
            case "VISUAL", "RESPOND" -> new String[]{"Name one element",
                    "‘Thick black line around the waka’ is better than ‘it looks cool’.",
                    "Effect on the viewer",
                    "Warm colours can feel close and busy. Say what you think the artist wanted."};
            case "MUSIC" -> new String[]{"Keep a steady beat",
                    "Clap on the pulse while someone sings. If claps wander, the beat is not steady.",
                    "Higher or lower?",
                    "A pīpīwharauroa call is usually higher than a stamped foot. Point up or down."};
            case "DRAMA", "DANCE" -> new String[]{"Stay in role",
                    "If you are the kaiako in the scene, you do not giggle as yourself. Freeze, then speak.",
                    "Space and safety",
                    "Know your spot. No running through someone else’s movement path."};
            case "MOVE" -> new String[]{"Catch ready position",
                    "Eyes on the ball, hands out, soft elbows. Watch it in, then squeeze.",
                    "A fair game change",
                    "If one side has fewer players, shrink the field so the game stays even."};
            case "HAUORA", "RELATE", "COMMUNITY" -> new String[]{"Name a taha",
                    "A walk with whānau can support tinana and whānau at once. Say both.",
                    "A kind response",
                    "If a friend is left out: invite them, then tell a kaiako if it keeps happening."};
            case "SAFETY" -> new String[]{"Water safety",
                    "Swim between the flags, with a buddy. If you cannot see the flags, stay out.",
                    "Online safety, Year " + year,
                    "Do not share a password. Tell a trusted adult about a message that feels wrong."};
            case "GREETINGS", "WORDS", "LISTEN", "READLANG", "TIKANGA" -> new String[]{
                    "Choose the greeting",
                    "One person: tēnā koe. Two or more: tēnā koutou or kia ora koutou.",
                    "Use a kupu in a sentence",
                    "‘Kia ora, e hoa’ is better than a list of words with no sentence."};
            default -> new String[]{"Say the idea in your own words",
                    "If you cannot explain it to a Year " + Math.max(1, year - 1) + " learner, read the lesson again.",
                    "Give a second example",
                    "Change the numbers or the names, keep the same method, then check."};
        };
    }
}
