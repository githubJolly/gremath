package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.curriculum.SubjectFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/**
 * Distinct science stems with diagrams and per-item hints that never state the answer.
 */
final class NzScienceQuestionBank {

    private NzScienceQuestionBank() {
    }

    static QuestionTemplate[] investigate(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Two paper towels soak the same volume of water. What makes this a fair test?"
                                                : "In this set-up, what is being changed on purpose?",
                                        SubjectFigures.fairTest("Only the brand changes. Water, amount and time stay the same.")),
                                word ? "Only the brand of towel" : "The towel brand",
                                "A fair test changes one independent variable.",
                                "EASY", tag(word, "visual pattern"),
                                "The volume of water and the brand together", "The conclusion before any trial", "Every variable at once"),
                        "Name the one thing the picture lets you change. Everything else should match."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Which is a testable question for two plants grown in the same light?"
                                        : "Which question can actually be tested with a ruler and two plants?",
                                "Does plant A grow taller than plant B in the same light?",
                                "Testable questions name something you can measure.",
                                "MEDIUM", tag(word),
                                "Are plants nicer than rocks?", "Is science cool?", "Should we like plants?"),
                        "If you cannot measure it or compare it, it is not a fair-test question."),
                rng -> hint(QBuilder.build(rng, "A conclusion should be based on…",
                                "The evidence you collected", "Evidence first, hope later.",
                                "EASY", "skill-check",
                                "A guess with no data", "What a friend hoped", "The longest word you know"),
                        "Look back at the results table. The claim can only say what those numbers show."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "You repeat a bounce test three times. Repeating helps you…"
                                        : "The independent variable is the one you…",
                                year <= 4 ? "see if the result keeps happening" : "change on purpose",
                                year <= 4 ? "Repeats check that a result is not a one-off." : "Independent = what you change.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "skip measuring" : "never touch",
                                year <= 4 ? "change the conclusion first" : "keep identical every time",
                                year <= 4 ? "hide the equipment" : "the weather only"),
                        year <= 4
                                ? "One lucky bounce is not a pattern. Several trials let you trust the result."
                                : "Independent is the knob you turn. Dependent is the number you read afterwards."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Before a claim about ‘all kiwi’, one class’s six birds is…"
                                        : "A sample of six birds cannot prove a claim about…",
                                word ? "too small to speak for every kiwi" : "every kiwi in Aotearoa",
                                "Say who you actually measured.",
                                "HARD", tag(word),
                                word ? "enough to rewrite the whole species" : "those six birds’ own masses",
                                "proof that measurement is illegal", "a reason to skip units"),
                        "Name the group you actually tested. Do not stretch the claim past that group."),
                rng -> hint(QBuilder.build(rng, "Which is a safety habit in a Year " + year + " investigation?",
                                "Follow the adult’s method and tidy spills",
                                "Safe science is planned, not rushed.",
                                "EASY", "skill-check",
                                "Taste unknown powders", "Point a flame at a classmate", "Run with glass"),
                        "If an action could harm people or gear, it is not part of the method."),
                rng -> hint(QBuilder.build(rng, "A model of Earth and the Sun is useful because it…",
                                "helps you picture an idea you cannot hold in your hand",
                                "Models simplify. They are not the real sky.",
                                "MEDIUM", "skill-check",
                                "replaces all evidence forever", "is always the same size as Earth", "stops you asking questions"),
                        "Ask what the model is trying to show — and what it leaves out."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Two groups get different bounce heights. A scientist’s next move is to…"
                                        : "Results that disagree should make you…",
                                word ? "check the method and measure again" : "re-read the method and test again",
                                "Disagreement is a reason to check, not to invent a nicer number.",
                                "MEDIUM", tag(word),
                                "throw away the lower results only", "change the question to match a hope", "stop recording"),
                        "When two results clash, check whether the method stayed the same, then collect more data."),
                rng -> hint(QBuilder.build(rng, "Keeping the water volume the same in every trial is an example of a…",
                                "controlled variable",
                                "Controls stay constant so the change you chose can be blamed.",
                                "MEDIUM", "skill-check",
                                "wild guess", "conclusion", "new species"),
                        "The thing you keep identical is a control. The thing you change is not."),
                rng -> hint(QBuilder.build(rng, "Which sentence is a prediction, not a result?",
                                "I think Brand A will hold more water than Brand B",
                                "A prediction is said before the trial.",
                                "EASY", "skill-check",
                                "Brand A held 12 mL more in our table", "We measured 40 mL each time", "The towel felt blue"),
                        "Predictions use ‘I think’ before you measure. Results quote the table.")
        };
    }

    static QuestionTemplate[] living(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "In this Aotearoa food chain, the pīwakawaka gets energy by…"
                                                : "What do the arrows show?",
                                        SubjectFigures.foodChain("Energy moves along the arrows.")),
                                word ? "eating the insect" : "energy flow (who eats whom)",
                                "Arrows follow the food / energy, not the scenery.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "photosynthesising like harakeke" : "the days of the week",
                                "map north", "the names of minerals"),
                        "Start at the plant. Follow each arrow to the eater."),
                rng -> hint(QBuilder.build(rng, "An adaptation is…",
                                "A feature that helps a living thing survive in its habitat",
                                "Helps survival in that place.",
                                "MEDIUM", "skill-check",
                                "A random decoration with no use", "Always a human-made tool", "The same as a fossil"),
                        "Name the feature and the job it does in that habitat."),
                rng -> hint(QBuilder.build(rng, year <= 2
                                        ? "A rock does not grow, feed or reproduce. It is…"
                                        : "Kiwi are nocturnal. That means they are mainly active…",
                                year <= 2 ? "non-living" : "At night",
                                year <= 2 ? "Living things need food, water and a place to live." : "Nocturnal = night-active.",
                                "EASY", "skill-check",
                                year <= 2 ? "a plant" : "Only at midday",
                                year <= 2 ? "an insect" : "Never",
                                year <= 2 ? "a bird" : "Underwater all day"),
                        year <= 2
                                ? "Ask: does it need food, grow and make more of itself?"
                                : "Nocturnal names the time of day the animal is busy."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A wētā lives in a dark bush floor. Its habitat is…"
                                        : "Habitat means…",
                                word ? "the bush floor where it finds food and shelter" : "the place a living thing finds food, water and shelter",
                                "Habitat is the address plus the resources.",
                                "EASY", tag(word),
                                "only the animal’s favourite colour", "a type of force", "the school bell time"),
                        "Habitat is where it lives and what it needs there — not a decoration."),
                rng -> {
                    if (year >= 7) {
                        return hint(QBuilder.build(rng, "Cells are…",
                                        "the basic units of living things",
                                        "Tissue is made of cells.",
                                        "EASY", "skill-check",
                                        "only found in rocks", "the same as atoms", "a type of weather"),
                                "Zoom in: organs are built from tissues, tissues from cells.");
                    }
                    return hint(QBuilder.build(rng, "A life cycle diagram is mainly showing…",
                                    "stages from young to adult and often back to eggs or seeds",
                                    "Order of stages, not a food chain.",
                                    "MEDIUM", "skill-check",
                                    "who eats whom", "only the weather", "map symbols"),
                            "Read the cycle clockwise. Each picture is a stage, not a meal.");
                },
                rng -> hint(QBuilder.build(rng, year >= 8
                                        ? "Natural selection acts on…"
                                        : "Native species in Aotearoa are species that…",
                                year >= 8 ? "variation already present in a population"
                                        : "belong here without people bringing them",
                                year >= 8 ? "Helpful traits become more common over generations."
                                        : "Native is not the same as a pet from overseas.",
                                "MEDIUM", "skill-check",
                                year >= 8 ? "a single animal growing a new organ in one afternoon" : "only live in shopping malls",
                                year >= 8 ? "only the colour of the sky" : "cannot be birds",
                                year >= 8 ? "the days of the week" : "are always extinct"),
                        year >= 8
                                ? "Look for variation that already exists, then who survives to have young."
                                : "Ask whether people introduced it, or it was already part of this whenua."),
                rng -> hint(QBuilder.build(rng, "If insects disappear from a food chain, a bird that eats them is likely to…",
                                "have less food unless it can switch prey",
                                "Links depend on each other.",
                                "HARD", "skill-check",
                                "make its own harakeke energy", "turn into a plant", "stop needing energy"),
                        "Follow the arrow into the bird. That arrow is its food supply."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Why might a thick kiwi beak help on a forest floor?"
                                        : "A feature helps survival when it…",
                                word ? "It can probe soil for invertebrates" : "gives an advantage in that habitat",
                                "Link the body part to a job.",
                                "MEDIUM", tag(word),
                                word ? "It makes the bird a rock" : "is only decorative",
                                "It removes the need for food", "It changes the days of the week"),
                        "Name the habitat problem, then how the feature solves it."),
                rng -> hint(QBuilder.build(rng, "A producer in a food chain is usually a…",
                                "plant that makes its own food",
                                "Producers start the energy story.",
                                "EASY", "skill-check",
                                "hawk", "cat", "plastic bottle"),
                        "Find the living thing that does not eat another animal or plant."),
                rng -> hint(QBuilder.build(rng, "Interdependence in an ecosystem means living things…",
                                "rely on one another and on the non-living environment",
                                "Food, shelter, oxygen and decay all connect.",
                                "MEDIUM", "skill-check",
                                "never affect each other", "only compete in maths tests", "live only in classrooms"),
                        "Ask who would notice if one species or resource vanished.")
        };
    }

    static QuestionTemplate[] matter(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Ice, water and steam are the same substance in different…"
                                                : "Which state has particles closest together?",
                                        SubjectFigures.statesOfMatter("Spacing of particles changes with the state.")),
                                word ? "states" : "solid",
                                "Solid packed, liquid sliding, gas spread out.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "colours only" : "gas",
                                word ? "forces" : "liquid only if it is boiling",
                                "map keys"),
                        "Compare the spacing in the three pictures. Closest packing is solid."),
                rng -> hint(QBuilder.build(rng, "Ice melting into water is…",
                                "A reversible change of state",
                                "Melting can be undone by freezing.",
                                "EASY", "skill-check",
                                "An irreversible burning", "A living process", "A type of force"),
                        "Ask: can I get the ice back by changing temperature only?"),
                rng -> hint(QBuilder.build(rng, "In a gas, particles…",
                                "Move freely and are far apart",
                                "Gases fill their container.",
                                "MEDIUM", "skill-check",
                                "Are locked in a rigid pattern", "Do not exist", "Are always ice"),
                        "Picture the loosest, most spaced drawing. That is the gas."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Toast going black in a toaster is hard to undo because…"
                                        : "Which change is not easily reversed?",
                                word ? "burning makes new substances" : "Burning toast",
                                "Burning is a chemical change.",
                                "MEDIUM", tag(word),
                                word ? "it is only melting" : "Freezing water",
                                "Melting chocolate", "Condensing steam"),
                        "If new stuff appears (ash, smoke, a new smell), it is usually not just a change of state."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "A waterproof coat is useful in the rain because the material…"
                                        : "Salt disappearing into water is usually…",
                                year <= 4 ? "does not let water through easily" : "dissolving (a mixture you can often separate)",
                                year <= 4 ? "Match a property to a job." : "Dissolving mixes; you can often get the salt back.",
                                "EASY", "skill-check",
                                year <= 4 ? "soaks like a sponge on purpose" : "burning the salt into a gas forever",
                                year <= 4 ? "is made of cloud" : "turning salt into a plant",
                                year <= 4 ? "weighs nothing" : "a type of gravity"),
                        year <= 4
                                ? "Name the job (keep dry) then the property (waterproof)."
                                : "Dissolving hides the grains; evaporating the water often brings them back."),
                rng -> hint(QBuilder.build(rng, "A mixture of sand and water can often be separated by…",
                                "filtering or settling",
                                "The sand does not dissolve.",
                                "MEDIUM", "skill-check",
                                "waiting for it to become a new element", "freezing the names", "using a magnet on every grain of water"),
                        "If the bits are still sand, a filter or time to settle can split them from the water."),
                rng -> hint(QBuilder.build(rng, "Condensing is when a gas…",
                                "turns into a liquid",
                                "Steam on a cold window is condensation.",
                                "EASY", "skill-check",
                                "turns into a solid only ever", "vanishes from the universe", "becomes a magnet"),
                        "Name the start state and the end state. Gas → liquid is condense."),
                rng -> hint(QBuilder.build(rng, "Heating a solid until it becomes a liquid is called…",
                                "melting",
                                "Melt = solid to liquid.",
                                "EASY", "skill-check",
                                "freezing", "condensing", "evaporating"),
                        "Write ‘from ____ to ____’. Solid to liquid has its own everyday name."),
                rng -> hint(QBuilder.build(rng, year >= 7
                                        ? "A chemical change is different from a physical change because it…"
                                        : "Steam is water in the…",
                                year >= 7 ? "makes new substances with different properties" : "gas state",
                                year >= 7 ? "New stuff, not just a new shape." : "Same substance, different state.",
                                "MEDIUM", "skill-check",
                                year >= 7 ? "only changes the container’s colour label" : "solid state",
                                year >= 7 ? "never involves heat" : "a type of rock",
                                year >= 7 ? "is the same as stirring" : "a force"),
                        year >= 7
                                ? "Ask whether you still have the same substance afterwards."
                                : "Steam is not ‘wet air’ as a new substance — it is water as a gas."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Why does a bike pump feel warmer when you squeeze the air?"
                                        : "Particles in a solid…",
                                word ? "Compressed particles hit more often, so the air warms"
                                        : "vibrate in fixed positions",
                                word ? "Energy and particle motion link." : "Solids keep a shape.",
                                "HARD", tag(word),
                                word ? "The metal turns into a liquid automatically" : "fly freely far apart",
                                "Gravity switches off", "The air becomes a plant"),
                        word
                                ? "Think what squeezing does to how often particles bump."
                                : "Solid particles stay in place but still jiggle.")
        };
    }

    static QuestionTemplate[] forces(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "A classmate shoves a box and another tugs the rope. Both actions are…"
                                                : "A push and a pull are both…",
                                        SubjectFigures.forceArrows("Arrows show push and pull on the same object.")),
                                "Forces",
                                "Forces change motion or shape.",
                                "EASY", tag(word, "visual pattern"),
                                "Types of colour", "States of matter", "Map symbols"),
                        "If it makes something start, stop, speed up, slow down or change direction, it is a force."),
                rng -> hint(QBuilder.build(rng, "Gravity on Earth pulls objects…",
                                "Towards the centre of Earth",
                                "Down means toward Earth.",
                                "EASY", "skill-check",
                                "Only sideways", "Into space automatically", "Randomly"),
                        "‘Down’ is toward the middle of the planet, not toward the bottom of the page in space."),
                rng -> hint(QBuilder.build(rng, "Friction usually…",
                                "Resists movement between surfaces",
                                "Rougher surfaces, more friction.",
                                "EASY", "skill-check",
                                "Creates extra gravity", "Stops light from travelling", "Makes objects weightless"),
                        "Friction is the ‘rub’ that fights a slide. Name the two surfaces."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "A magnet can pull some metals without touching them. That force is…"
                                        : "Balanced forces on a still book mean the forces…",
                                year <= 4 ? "non-contact (magnetic)" : "cancel so there is no overall change of motion",
                                year <= 4 ? "Magnets act at a distance." : "Still does not mean ‘no forces’.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "a type of sound" : "must be zero everywhere in the universe",
                                year <= 4 ? "only gravity from the Moon" : "always speed the book up",
                                year <= 4 ? "a change of state" : "turn the book into a gas"),
                        year <= 4
                                ? "Ask whether the objects have to touch. Magnets and gravity do not."
                                : "Still or steady speed can still have forces — they just balance."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Soles on wet tiles: you are more likely to slip because friction has…"
                                        : "A force can change an object’s…",
                                word ? "decreased" : "speed or direction (or shape)",
                                word ? "Water is a lubricant here." : "Forces change motion.",
                                "MEDIUM", tag(word),
                                word ? "increased to a maximum" : "favourite colour only",
                                "become a state of matter", "turned into a map key"),
                        word
                                ? "Smoother or wetter contact usually means less grip."
                                : "List what can change: start, stop, faster, slower, turn, squash."),
                rng -> hint(QBuilder.build(rng, "A simple machine like a ramp is useful because it…",
                                "lets you use a smaller force over a longer distance",
                                "Work is spread out, not deleted.",
                                "MEDIUM", "skill-check",
                                "removes gravity from Earth", "creates energy from nothing", "stops all friction forever"),
                        "Ask how the tool changes the size or direction of the force — not whether gravity vanished."),
                rng -> hint(QBuilder.build(rng, year >= 7
                                        ? "Mass is the amount of stuff. Weight is…"
                                        : "To start a heavy box sliding you usually need…",
                                year >= 7 ? "the gravitational force on that mass" : "a bigger push than friction can cancel",
                                year >= 7 ? "Weight depends on the planet’s gravity." : "Unbalanced force starts the slide.",
                                "HARD", "skill-check",
                                year >= 7 ? "always the same number as mass in every unit" : "less force than a feather",
                                year >= 7 ? "a type of colour" : "to freeze the box",
                                year >= 7 ? "only measured in litres" : "to turn it into a liquid"),
                        year >= 7
                                ? "Mass stays with the object. Weight is how hard gravity tugs it."
                                : "Motion starts when your push beats the forces that hold it still."),
                rng -> hint(QBuilder.build(rng, "Which picture best shows a contact force?",
                                "A foot kicking a ball",
                                "Contact means touching.",
                                "EASY", "skill-check",
                                "Earth pulling the Moon with no touch", "A magnet attracting a pin from 5 cm away", "Gravity on a falling apple (no hand)"),
                        "Contact forces need a touch. Gravity and magnets can act without one."),
                rng -> hint(QBuilder.build(rng, "If you stop pedalling on the flat, the bike slows because…",
                                "friction and air resistance are unbalanced backwards",
                                "Unbalanced forces change speed.",
                                "MEDIUM", "skill-check",
                                "gravity suddenly switches off", "mass disappears", "the wheels become gases"),
                        "Name the forces that keep acting when the pedalling force stops."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A tug-of-war is a draw. The two teams’ pulls are…"
                                        : "Opposite forces that are equal in size are…",
                                "balanced",
                                "Equal opposite forces do not change the motion.",
                                "EASY", tag(word),
                                "creating new planets", "the same as melting", "only colours"),
                        "If nothing speeds up, slows down or turns, the forces may be balanced.")
        };
    }

    static QuestionTemplate[] earth(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Why is it night in one part of Aotearoa while it is day in another?"
                                                : "Day and night are caused mainly by…",
                                        SubjectFigures.dayNight("One side of Earth faces the Sun.")),
                                word ? "Earth has rotated so one side faces away from the Sun"
                                        : "Earth rotating on its axis",
                                "Rotation, not the Sun switching off.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "The Moon covers the whole Sun every night" : "The Moon turning off the Sun",
                                "Clouds covering the whole planet every night",
                                "Earth moving closer then farther each hour"),
                        "Stand a globe by a lamp. The dark half is night — the globe turned, the lamp did not switch off."),
                rng -> hint(QBuilder.build(rng, "Seasons are most strongly linked to…",
                                "Earth's tilt as it orbits the Sun",
                                "Tilt plus orbit, not just distance.",
                                "MEDIUM", "skill-check",
                                "The number of rivers", "How many people wear jumpers", "Earth stopping once a year"),
                        "Ask which hemisphere is tilted toward the Sun in that month."),
                rng -> hint(QBuilder.build(rng, "A thermometer is used to measure…",
                                "Temperature",
                                "A weather variable you can read on a scale.",
                                "EASY", "skill-check",
                                "Wind direction only", "Earthquake depth", "The time of high tide only"),
                        "Match the tool to the quantity. Thermometer → how hot or cold."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Today’s rain and wind are weather. The usual pattern over many years is…"
                                        : "Weather is the day-to-day conditions. Climate is…",
                                word ? "climate" : "the long-term pattern of weather",
                                "Weather is a snapshot; climate is the habit.",
                                "MEDIUM", tag(word),
                                word ? "a type of rock only" : "only what happened this hour",
                                "the school timetable", "a food chain"),
                        "One wet Tuesday is weather. Many wet winters in a row is climate."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "The Sun appears to move across the sky because…"
                                        : "Aotearoa sits on a plate boundary, so we must plan for…",
                                year <= 4 ? "Earth is turning" : "earthquakes (and sometimes volcanic activity)",
                                year <= 4 ? "The sky’s path is Earth’s spin." : "Geology is local here.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "the Sun orbits Earth each hour" : "the complete absence of any rock",
                                year <= 4 ? "clouds push the Sun" : "only snow in the Sahara",
                                year <= 4 ? "night is a switched-off lamp" : "rivers flowing uphill as a rule"),
                        year <= 4
                                ? "The Sun is not racing around us each day — we are spinning."
                                : "Name the Earth process that matches shaking ground or a volcano, not a food chain."),
                rng -> hint(QBuilder.build(rng, "The water cycle includes water…",
                                "evaporating, condensing and falling as rain or snow",
                                "Same water, changing state and place.",
                                "EASY", "skill-check",
                                "leaving Earth forever each afternoon", "turning into rock overnight", "becoming a magnet"),
                        "Track one drop: up as vapour, together as cloud, down as rain."),
                rng -> hint(QBuilder.build(rng, "Soil is useful to plants mainly because it can…",
                                "hold water and minerals for roots",
                                "A living-world link to Earth materials.",
                                "EASY", "skill-check",
                                "replace sunlight completely", "remove the need for water", "create day and night"),
                        "Roots need a material that holds water and nutrients — that is a soil job."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "Fossils and rock layers can help scientists…"
                                        : "A compass needle is useful because it…",
                                year >= 6 ? "put events in time order (older layers usually deeper)"
                                        : "lines up with Earth’s magnetic field to show direction",
                                year >= 6 ? "Sequence, then a story." : "Direction tool, not a weather story.",
                                "MEDIUM", "skill-check",
                                year >= 6 ? "prove plants never existed" : "measures only temperature",
                                year >= 6 ? "measure today’s wind only" : "creates seasons",
                                year >= 6 ? "turn off gravity" : "names food chains"),
                        year >= 6
                                ? "Deeper layers were usually laid down first. Read the stack like a timeline."
                                : "A compass answers ‘which way’, not ‘how hot’."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Why do we not have a solar eclipse every night?"
                                        : "Night happens when your part of Earth…",
                                word ? "The Moon’s shadow only hits Earth in a special line-up"
                                        : "faces away from the Sun",
                                word ? "Eclipse ≠ night." : "Facing away is rotation.",
                                "HARD", tag(word),
                                word ? "The Sun turns off on a timer" : "moves to another galaxy each evening",
                                "Earth stops spinning every night", "Clouds delete the Sun"),
                        word
                                ? "Night is Earth’s shadow on itself. An eclipse needs a rare line-up."
                                : "If your side cannot see the Sun, it is night."),
                rng -> hint(QBuilder.build(rng, "Stars look like they wheel overnight because…",
                                "Earth is rotating under a distant sky",
                                "The sky’s apparent motion is our spin.",
                                "MEDIUM", "skill-check",
                                "the stars orbit Aotearoa every hour", "the Sun pushes them", "they are weather balloons only"),
                        "The same spin that makes the Sun ‘rise’ makes the star field appear to turn.")
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
