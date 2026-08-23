package com.gremath.practice;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Per-question method hints. Banks are topic-specific and never state the answer.
 * A sheet picks unused lines first so students do not see the same sentence on every item.
 */
public final class HintBank {

    private HintBank() {
    }

    public static String pick(String practiceKey, GeneratedQuestion q, int index, Set<String> used) {
        if (q != null && q.getHint() != null && !q.getHint().isBlank()) {
            used.add(q.getHint());
            return q.getHint();
        }
        String[] bank = bankFor(practiceKey, q == null ? null : q.getTag());
        for (int step = 0; step < bank.length; step++) {
            String hint = bank[Math.floorMod(index + step * 5, bank.length)];
            if (used.add(hint)) {
                return hint;
            }
        }
        return bank[Math.floorMod(index, bank.length)];
    }

    static String[] bankFor(String practiceKey, String tag) {
        String k = practiceKey == null ? "" : practiceKey.toLowerCase();
        boolean word = tag != null && tag.toLowerCase().contains("word");
        if (is(k, "place", "exponent", "c6nz-place", "c7nz-exponents") || mathsOrder(k, 1)) {
            return word ? NUMBER_WORD : NUMBER;
        }
        if (is(k, "prime", "hcf", "integer", "operation", "c6nz-operations", "c7nz-primes", "c7nz-integers")
                || mathsOrder(k, 2) || mathsOrder(k, 3)) {
            return word ? OPS_WORD : OPS;
        }
        if (is(k, "fdp", "finance", "fraction", "c6nz-fdp", "c7nz-fdp") || mathsOrder(k, 4)) {
            return word ? FDP_WORD : FDP;
        }
        if (is(k, "algebra", "pattern", "c6nz-pattern", "c7nz-algebra") || mathsOrder(k, 5)) {
            return word ? ALG_WORD : ALG;
        }
        if (is(k, "measure", "c6nz-measurement", "c7nz-measurement") || mathsOrder(k, 6)) {
            return word ? MEAS_WORD : MEAS;
        }
        if (is(k, "geometry", "c6nz-geometry", "c7nz-geometry") || mathsOrder(k, 7)) {
            return word ? GEO_WORD : GEO;
        }
        if (is(k, "data", "stat", "chance", "prob", "c6nz-data", "c6nz-prob", "c7nz-stats") || mathsOrder(k, 8)) {
            return word ? DATA_WORD : DATA;
        }
        if (is(k, "read", "english") && k.contains("1")) {
            return READING;
        }
        if (k.contains("english") || is(k, "writing", "grammar", "vocab", "oral", "read")) {
            return ENGLISH;
        }
        if (k.contains("science") || is(k, "living", "matter", "force", "earth", "investigate")) {
            return SCIENCE;
        }
        if (k.contains("social") || is(k, "identity", "place", "history", "economy", "civic")) {
            return SOCIAL;
        }
        if (k.contains("technolog") || is(k, "design", "digital", "making", "compute", "evaluate")) {
            return TECH;
        }
        if (k.contains("the-arts") || k.contains("arts") || is(k, "visual", "music", "drama", "dance", "respond")) {
            return ARTS;
        }
        if (k.contains("health") || is(k, "move", "hauora", "relate", "safety", "community")) {
            return HPE;
        }
        if (k.contains("language") || is(k, "greeting", "tikanga", "listen", "readlang", "kupu", "words")) {
            return LANG;
        }
        return word ? GENERIC_WORD : GENERIC;
    }

    private static boolean is(String key, String... needles) {
        for (String n : needles) {
            if (key.contains(n)) {
                return true;
            }
        }
        return false;
    }

    private static boolean mathsOrder(String key, int order) {
        return key.matches("nz-\\d+-mathematics-" + order);
    }

    private static final String[] NUMBER = {
            "Compare from the left-most place. The first digit that differs decides.",
            "Write the number in expanded form, then reread the question.",
            "Mark both numbers on a mental number line before you choose.",
            "Rounding: look only at the digit one place to the right of the target.",
            "Name the place (ones, tens, hundreds…) out loud, then pick the digit sitting there.",
            "A square-root question is asking which number times itself gives the inside.",
            "Zero is a placeholder — dropping it changes the place of every other digit.",
            "For primes, test divisibility by 2, 3, 5, then 7, up to the square root.",
            "HCF wants shared primes with the smaller exponents; LCM wants the larger ones.",
            "Estimate first: is your option about 10, 100 or 1,000? Cross out wild sizes.",
            "Negatives get smaller as you move left. −9 is less than −2.",
            "Powers of 10: the exponent counts how many zeros after a 1."
    };

    private static final String[] NUMBER_WORD = {
            "Underline the two amounts. The question wants the larger, the difference, or a round estimate — not all three.",
            "Translate the story to one number sentence, then compare or round.",
            "Ignore extra setting words. Keep only the quantities and the ask.",
            "If it is a stadium, books or people story, it is still place value or a difference.",
            "Check units: people, pages and dollars are not interchangeable.",
            "After you pick, reread: did they want the number or the difference?"
    };

    private static final String[] OPS = {
            "Decide + − × or ÷ from the symbols, then compute. Do not mix them up.",
            "GEMA: grouped work, then exponents, then ×÷ left to right, then +−.",
            "Subtraction is not commutative. Keep the order the question wrote.",
            "For equal groups, × builds the total; ÷ undoes it. Check with the inverse.",
            "A remainder is leftover after equal groups — do not throw it away.",
            "Adding a negative is a jump left on the number line.",
            "Subtracting a negative is a jump right (add the opposite).",
            "Estimate by rounding both numbers, then see if your exact answer sits nearby.",
            "Fact families: if 6 × 7 = 42 then 42 ÷ 7 = 6.",
            "Align places if you use columns. A slipped tens digit wrecks the total.",
            "× by 10 appends a zero to a whole number; do not do that for decimals blindly.",
            "If two operations sit together, mark the one GEMA wants first."
    };

    private static final String[] OPS_WORD = {
            "Circle the action words: altogether, left, shared, rows, each, dropped.",
            "Write one number sentence that matches the story, then compute.",
            "Remainders in people-stories often mean you need an extra group.",
            "Temperature drop means subtract; a rise means add — including through zero.",
            "Money change is given − cost, not cost − given.",
            "Check by reversing: add to check a take-away; multiply to check a share."
    };

    private static final String[] FDP = {
            "Name the whole first. A fraction is parts of that same whole.",
            "Shaded / equal parts. Count the pieces, do not guess from the colour.",
            "For unit fractions, a larger denominator means a smaller piece of the same bar.",
            "Percent means per hundred. Divide by 100 to get the decimal multiplier.",
            "To find a percentage of an amount: amount × percent ÷ 100.",
            "Equivalent fractions multiply (or divide) top and bottom by the same number.",
            "A ratio 3:5 has 8 parts. Find one part, then scale.",
            "Discount: take the percent off the original, then subtract — or multiply by (1 − p).",
            "Compare decimals from the tenths place, then hundredths. 0.9 beats 0.89.",
            "Find the whole from a part: divide by the given percent, then × 100.",
            "Do not add percentages that sit on different bases.",
            "Money answers usually need two decimal places. Round last."
    };

    private static final String[] FDP_WORD = {
            "Underline the original price and the percent. Sale price is not the discount amount.",
            "Sharing in a ratio: add the parts, then split the total.",
            "‘Of’ in a percent story almost always means multiply.",
            "GST-inclusive ÷ 1.15 gives the exclusive amount (15% GST).",
            "Fair shares must be equal pieces of the same whole — pizza vs biscuit differ.",
            "Write the multiplier (0.75 for 25% off) so you can reverse-check."
    };

    private static final String[] ALG = {
            "Equals means balance. Do the same inverse to both sides.",
            "3b means 3 × b, not 3 + b. Juxtaposition is multiply.",
            "Like terms share the letter and the power. 3x + 5x = 8x; 3x + 5 does not merge.",
            "Find the constant difference, then write a rule for term n and test n = 1.",
            "An ordered pair is (along, then up). (2, 5) is not (5, 2).",
            "Substitute the given value, then simplify with GEMA.",
            "Undo the last operation first: if +3 is last, subtract 3 first.",
            "A growing pattern table (term | value) reveals the rule faster than staring.",
            "Check by putting your solution back into the original equation.",
            "Inequalities flip if you multiply or divide both sides by a negative.",
            "y = mx + c: m is the step, c is where the line meets the y-axis.",
            "Define the letter in a sentence before you write the equation."
    };

    private static final String[] ALG_WORD = {
            "Let the unknown be a letter. Write one sentence: ‘n is the number of…’",
            "Tickets × price + fee is a two-step equation, not a guess.",
            "The 5th term is start + 4 × step if term 1 is the start.",
            "Plot or table the first few terms if the rule is hiding.",
            "After solving, check that the story still makes sense (no negative tickets).",
            "Underline every number that belongs in the equation — ignore flavour words."
    };

    private static final String[] MEAS = {
            "Name the attribute first: length, area, volume, angle or time.",
            "Area uses square units; perimeter is a length; volume is cubic.",
            "Rectangle area = l × w. Perimeter = 2(l + w). Do not swap them.",
            "A right triangle is half a rectangle: ½ × base × height.",
            "Convert to one unit before you add or subtract (cm with cm).",
            "1 m = 100 cm, 1 L = 1000 mL, 1 kg = 1000 g.",
            "For a compound L-shape, split into rectangles or subtract a cut-out.",
            "Circle: C = πd and A = πr². Halve a diameter before you use r.",
            "Elapsed time: jump to the next hour, then add leftover minutes.",
            "Pythagoras needs a right angle. The hypotenuse is opposite that corner.",
            "Volume of a cuboid is l × w × h — layers of cubes.",
            "Read the diagram labels. A missing side is often a subtraction of two given lengths."
    };

    private static final String[] MEAS_WORD = {
            "Sketch the object and label every length the story gives you.",
            "A timetable question is duration, not area. Convert to minutes.",
            "Ribbon around a card is perimeter; covering the face is area.",
            "Overnight or past 12:00 needs a 12/24-hour conversion.",
            "Units must match the ask: cm² if it is a region, cm if it is a fence.",
            "Estimate first (a pace ≈ 1 m) so a wild option stands out."
    };

    private static final String[] GEO = {
            "Trust marked facts, not how the sketch looks. Sketches can lie.",
            "Triangle angles sum to 180°. Subtract the two you know.",
            "Angles on a straight line sum to 180°. At a point they sum to 360°.",
            "A square is still a square after a turn. Properties do not care about tilt.",
            "Translation slides; reflection flips; rotation turns. Name the move first.",
            "Parallel lines never meet. Perpendicular lines meet at 90°.",
            "Equilateral: all sides and angles equal (60°). Isosceles: two base angles equal.",
            "Corresponding sides of similar shapes are in proportion; angles match.",
            "Count faces, edges and vertices — do not guess from a pretty drawing.",
            "A net must fold to the solid with no missing or extra faces.",
            "Grid references and coordinates: along first, then up.",
            "Write a reason for each step: ‘angles on a line’ or ‘triangle sum’."
    };

    private static final String[] GEO_WORD = {
            "Mark the given angles on a quick sketch, then chain a named fact.",
            "A clock turn: each hour mark is 30°. Count the steps.",
            "Fold-test language means a line of symmetry — how many perfect folds?",
            "Rotational order: how many times the shape matches itself in 360°.",
            "Scale drawings: multiply the map length by the scale number.",
            "If the story names a farm truss or a netball court, it is still angle or length facts."
    };

    private static final String[] DATA = {
            "Read the title, the key and whether the scale starts at 0.",
            "Mean = total ÷ how many. Range = largest − smallest.",
            "Median is the middle after you order the list. Mode is the most common.",
            "A tall bar is the most common category — unless the key says 1 picture = 2.",
            "Theoretical P = favourable ÷ total equally likely outcomes.",
            "Experimental P is what happened ÷ trials. It will wobble in a short run.",
            "Complement: P(not A) = 1 − P(A) when A and not-A cover everything.",
            "A sample of one class is not every student in Aotearoa. Say who you measured.",
            "Do not add overlapping events without subtracting the overlap.",
            "Outliers pull the mean; the median often stays a better ‘typical’.",
            "On a spinner, equal sectors matter. A huge red slice is not even chance.",
            "List the sample space first so you do not invent extra outcomes."
    };

    private static final String[] DATA_WORD = {
            "The graph cannot tell you why unless the investigation collected reasons.",
            "Relative frequency after many trials estimates P — it is not a promise for the next go.",
            "If the claim is about ‘all teens’ and n = 12, the sample is too small.",
            "Fair games come from the model (equal tickets), not from who won last time.",
            "Write the probability as a fraction of the grand total for a random pick.",
            "A two-way table: find the cell, then divide by the total the question names."
    };

    private static final String[] READING = {
            "The first read is for the gist. The second read hunts evidence.",
            "Choose the option the text actually supports, not the one you prefer.",
            "Inference still needs a clue in the lines — not a free opinion.",
            "Who, where, what, in order, makes a retell a listener can follow.",
            "A headline can position you before you meet the evidence. Ask who made it.",
            "Technique without effect is name-dropping. State what it does to a reader."
    };

    private static final String[] ENGLISH = {
            "One paragraph, one main idea. The topic sentence names that idea.",
            "Plan purpose and audience before you draft.",
            "A sentence needs a capital and end punctuation. Fix run-ons by splitting or joining.",
            "Subject and verb must agree: she walks, they walk.",
            "un- often means not. Synonyms are near-meanings, not opposites.",
            "Use the words around an unknown word before you skip the page.",
            "In talk: listen, then add a reason. ‘I think… because…’",
            "Presenting: clear voice, pause at the end of an idea, look up.",
            "First read for gist. Second read hunts a line you can point to.",
            "Inference still needs a clue. If you cannot underline it, it is a guess.",
            "Revise ideas first. Proofread spelling after.",
            "It's = it is. Its = belonging to it.",
            "A heading is a promise of the next chunk. Use it.",
            "Show with an action instead of only labelling a feeling."
    };

    private static final String[] TECH = {
            "Name the user and the problem before you pick a gadget.",
            "A brief is a test: can you tick success criteria?",
            "Iterate: test, change one thing, test again.",
            "Computers do what you typed, not what you meant.",
            "An algorithm is a sequence a robot could follow.",
            "Keep passwords and addresses off the screen and away from chats.",
            "Match material to the job: waterproof, strong, light.",
            "Evaluate against the brief, not only whether it looks cool."
    };

    private static final String[] ARTS = {
            "Describe what you notice before you say you like it.",
            "Name an element: line, colour, beat, level, role.",
            "Stay in role until the scene ends.",
            "The beat is the pulse you can tap. Pitch is high or low.",
            "Safe dance: see the space, bend knees, land quietly.",
            "Feedback: I notice… I wonder… next time try…",
            "Cultural patterns need respect and meaning, not a joke border.",
            "A motif is a movement or sound idea you can repeat and vary."
    };

    private static final String[] HPE = {
            "One cue at a time: eyes on the ball, hands ready.",
            "Fair play is rules plus welcome — change the rule, not the person.",
            "Hauora is four taha, not only ‘not being sick’.",
            "I-statement: I feel ___ when ___. No name-calling.",
            "Consent is a clear yes that can become a no.",
            "Swim between the flags. Call 111 in an emergency.",
            "A trusted adult is a hauora tool, not a last resort only.",
            "Warm up, play, cool down. Bodies like a runway."
    };

    private static final String[] LANG = {
            "Kia ora is a friendly hello. Tēnā koe greets one person.",
            "Koutou is for a group. Kōrua is for two.",
            "A macron holds the vowel longer and can change meaning.",
            "Copy a model sentence and swap one kupu.",
            "Kei te pēhea koe? → Kei te pai is a useful reply.",
            "Tikanga is the right way in that place — ask, then follow.",
            "Use the word to a person the same day or it stays a list.",
            "Language and people travel together. Do not use kupu as a joke."
    };

    private static final String[] SCIENCE = {
            "Change only one variable in a fair test. Keep the rest the same.",
            "A conclusion must sit on the evidence you collected, not a hope.",
            "Testable questions can be measured. ‘Is it nicer?’ cannot.",
            "Name the process (melt, burn, pull) and whether it reverses.",
            "Living things: cells, needs, habitat, and how a feature helps.",
            "Earth: rotation gives day/night; tilt-plus-orbit gives seasons.",
            "Forces are pushes or pulls. Gravity acts toward Earth’s centre.",
            "A food chain is energy flow, not a list of rock names.",
            "Independent is what you change. Dependent is the number you read after.",
            "Repeats check that a result is not a one-off bounce.",
            "Particles pack in a solid, slide in a liquid, and spread in a gas.",
            "Night is Earth’s dark half. The Sun does not switch off.",
            "Friction is the rub that fights a slide. Name the two surfaces.",
            "A sample of one class is not every kiwi in Aotearoa.",
            "If new stuff appears (ash, smoke), it is usually not just a change of state.",
            "Follow each food-chain arrow to the eater."
    };

    private static final String[] SOCIAL = {
            "Name who, where and when before you judge a claim.",
            "A place has physical and human features. Do not mix them up.",
            "Identity can be personal, family, iwi, or national — say which layer.",
            "History needs a source and a date, not only a story you like.",
            "An economy question is about needs, wants, work or trade.",
            "Civics: who decides, who is affected, and what rule is in play.",
            "Read the map key before you guess a colour.",
            "Ask whose voice is in the source, and whose is missing.",
            "A need keeps you alive. A want is an extra.",
            "If someone has a right, name the duty that sits beside it.",
            "Let people name their own groups. Do not glue on a stereotype.",
            "Chronology is the queue of dates — cause cannot run backwards.",
            "Local government often decides parks, rubbish and nearby roads.",
            "Trade is an exchange: each side gives and gets.",
            "c. means about. Place voyaging left of 1840 on a left-to-right line.",
            "Invitation, not interrogation: people choose what they share."
    };

    private static final String[] GENERIC = {
            "Underline what the question is actually asking, then the facts you need.",
            "Cross out options that ignore the definition in the lesson.",
            "Use the worked-example method, not a memory of a similar number.",
            "If two options look close, reread the last four words of the stem.",
            "Estimate first so an impossible size stands out.",
            "Check units and whether the answer should be a word, a number or a fraction."
    };

    private static final String[] GENERIC_WORD = {
            "Turn the story into one clean sentence of maths or evidence.",
            "Drop the setting words. Keep quantities, names and the ask.",
            "Ask: is this a calculate, compare, or explain item?",
            "Your answer must fit the people or place in the story.",
            "If it is unfair or misleading, say what the display hid.",
            "Reread the question after you pick — did they want a reason or a value?"
    };

    public static Set<String> newUsedSet() {
        return new LinkedHashSet<>();
    }
}
