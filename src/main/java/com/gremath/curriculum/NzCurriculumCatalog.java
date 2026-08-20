package com.gremath.curriculum;

import com.gremath.content.Doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Complete Years 1–10 × 8 learning-area catalogue. Hand-crafted Class 6 Maths/English/Science
 * and Class 7 Maths keep their existing slugs; every other cell is generated from this map.
 */
public final class NzCurriculumCatalog {

    private NzCurriculumCatalog() {
    }

    public static List<Integer> years() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static boolean isHandcrafted(int year, NzSubject subject) {
        if (year == 6 && (subject == NzSubject.MATHEMATICS || subject == NzSubject.ENGLISH || subject == NzSubject.SCIENCE)) {
            return true;
        }
        return year == 7 && subject == NzSubject.MATHEMATICS;
    }

    public static String topicSlug(int year, NzSubject subject) {
        if (year == 6 && subject == NzSubject.MATHEMATICS) {
            return "class6-nz-mathematics";
        }
        if (year == 6 && subject == NzSubject.ENGLISH) {
            return "class6-nz-english";
        }
        if (year == 6 && subject == NzSubject.SCIENCE) {
            return "class6-nz-science";
        }
        if (year == 7 && subject == NzSubject.MATHEMATICS) {
            return "class7-nz-mathematics";
        }
        return "year" + year + "-" + subject.slug();
    }

    public static String examType(int year) {
        if (year == 6) {
            return "CLASS6_NZ";
        }
        if (year == 7) {
            return "CLASS7_NZ";
        }
        return "NZ_Y" + year;
    }

    public static String topicHref(int year, NzSubject subject) {
        return "/topics/" + topicSlug(year, subject);
    }

    public static int lessonCount(int year, NzSubject subject) {
        if (year == 6 && subject == NzSubject.MATHEMATICS) {
            return 7;
        }
        if (year == 7 && subject == NzSubject.MATHEMATICS) {
            return 8;
        }
        return lessons(year, subject).size();
    }

    public static String practiceKey(int year, NzSubject subject, int order) {
        if (year == 6 && subject == NzSubject.ENGLISH) {
            return switch (order) {
                case 1 -> "nz-6-english-1";
                case 2 -> "nz-6-english-2";
                case 3 -> "nz-6-english-3";
                case 4 -> "nz-6-english-4";
                default -> "nz-6-english-5";
            };
        }
        if (year == 6 && subject == NzSubject.SCIENCE) {
            return switch (order) {
                case 1 -> "nz-6-science-1";
                case 2 -> "nz-6-science-2";
                case 3 -> "nz-6-science-3";
                case 4 -> "nz-6-science-4";
                default -> "nz-6-science-5";
            };
        }
        return "nz-" + year + "-" + subject.slug() + "-" + order;
    }

    public static Optional<YearSubject> fromTopicSlug(String slug) {
        if (slug == null) {
            return Optional.empty();
        }
        if ("class6-nz-mathematics".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.MATHEMATICS));
        }
        if ("class6-nz-english".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.ENGLISH));
        }
        if ("class6-nz-science".equals(slug)) {
            return Optional.of(new YearSubject(6, NzSubject.SCIENCE));
        }
        if ("class7-nz-mathematics".equals(slug)) {
            return Optional.of(new YearSubject(7, NzSubject.MATHEMATICS));
        }
        if (!slug.startsWith("year")) {
            return Optional.empty();
        }
        int dash = slug.indexOf('-');
        if (dash < 0) {
            return Optional.empty();
        }
        try {
            int year = Integer.parseInt(slug.substring(4, dash));
            return NzSubject.fromSlug(slug.substring(dash + 1)).map(s -> new YearSubject(year, s));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    public static OptionalInt yearFromExamType(String examType) {
        if (examType == null) {
            return OptionalInt.empty();
        }
        if ("CLASS6_NZ".equals(examType)) {
            return OptionalInt.of(6);
        }
        if ("CLASS7_NZ".equals(examType)) {
            return OptionalInt.of(7);
        }
        if (examType.startsWith("NZ_Y")) {
            try {
                return OptionalInt.of(Integer.parseInt(examType.substring(4)));
            } catch (NumberFormatException ex) {
                return OptionalInt.empty();
            }
        }
        return OptionalInt.empty();
    }

    public static List<NzLessonSpec> lessons(int year, NzSubject subject) {
        return switch (subject) {
            case MATHEMATICS -> mathLessons(year);
            case ENGLISH -> englishLessons(year);
            case SCIENCE -> scienceLessons(year);
            case SOCIAL_SCIENCES -> socialLessons(year);
            case TECHNOLOGY -> techLessons(year);
            case THE_ARTS -> artsLessons(year);
            case HEALTH_PE -> hpeLessons(year);
            case LEARNING_LANGUAGES -> languageLessons(year);
        };
    }

    public static String topicName(int year, NzSubject subject) {
        return "Year " + year + " " + subject.displayName();
    }

    public static String topicDescription(int year, NzSubject subject) {
        return "Year " + year + " lessons and practice for " + subject.displayName()
                + ", aligned to the New Zealand Curriculum. " + subject.blurb();
    }

    private static List<NzLessonSpec> mathLessons(int year) {
        String pv = year <= 2 ? "numbers to 20" : year <= 4 ? "numbers to 1,000" : year <= 6 ? "numbers to 1,000,000" : "integers and large numbers";
        String ops = year <= 2 ? "adding and subtracting" : year <= 4 ? "the four operations" : year <= 6 ? "multi-step operations" : "directed numbers and order of operations";
        String fdp = year <= 2 ? "halves and equal shares" : year <= 4 ? "unit fractions" : year <= 6 ? "fractions, decimals and percentages" : "FDP fluency and finance";
        String alg = year <= 2 ? "repeating patterns" : year <= 4 ? "growing patterns" : year <= 6 ? "rules and unknowns" : "linear relationships";
        String meas = year <= 2 ? "length, mass and time" : year <= 4 ? "metric units and area" : year <= 6 ? "area, volume and angles" : "compound measurement";
        String data = year <= 2 ? "tally charts and pictographs" : year <= 4 ? "bar graphs and chance language" : year <= 6 ? "mean, range and probability" : "statistical investigations";

        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.MATHEMATICS, 1, "Place value and " + pv, "Number",
                "Every digit has a value that depends on its place. Year " + year + " learners work with " + pv + ".",
                new String[]{"Break a number into places (ones, tens, hundreds…).", "Compare from the left-most digit.", "Use a number line to round and estimate."},
                "In 482, the 4 means 400, the 8 means 80, and the 2 means 2.",
                "If two numbers share the same leading digits, the first place they differ decides which is larger.",
                "Place value is the map of our number system — use it before you calculate.",
                "NUMBER"));
        out.add(spec(year, NzSubject.MATHEMATICS, 2, "Operations: " + ops, "Number",
                "Choose the right operation from the story, then calculate carefully. This year focuses on " + ops + ".",
                new String[]{"Underline the quantity words (altogether, left, each, share).", "Write a number sentence first.", "Check with the inverse operation."},
                "If 6 bags hold 8 apples each, that is 6 × 8 = 48 apples.",
                "Estimate first so you know if the answer is in the right ballpark.",
                "Match the story to +, −, × or ÷, then check reasonableness.",
                "OPS"));
        out.add(spec(year, NzSubject.MATHEMATICS, 3, fdp.substring(0, 1).toUpperCase() + fdp.substring(1), "Number",
                "Equal parts, decimals and percentages are different outfits for the same idea. Year " + year + ": " + fdp + ".",
                new String[]{"Draw the whole, then split into equal parts.", "Convert to a common form before comparing.", "Use benchmarks like 1/2, 1/4, 10% and 50%."},
                "3/4 = 0.75 = 75%. All three name the same amount.",
                "Percent means out of 100 — picture a 100-grid.",
                "Fractions, decimals and percentages describe parts of a whole.",
                "FRACTION"));
        out.add(spec(year, NzSubject.MATHEMATICS, 4, alg.substring(0, 1).toUpperCase() + alg.substring(1), "Algebra",
                "Patterns have rules. Year " + year + " students describe " + alg + " with words, tables and symbols.",
                new String[]{"Find what stays the same and what changes.", "Write the rule in words, then symbols.", "Test the rule on the next terms."},
                "2, 5, 8, 11… adds 3 each time. Term n is 3n − 1.",
                "A constant difference means a linear (straight-line) rule.",
                "Find the rule, test it, then use it to predict.",
                "ALGEBRA"));
        out.add(spec(year, NzSubject.MATHEMATICS, 5, "Measurement and geometry: " + meas, "Measurement & Geometry",
                "Measure with the right unit, then describe shapes by their properties. Year " + year + " focus: " + meas + ".",
                new String[]{"Choose a sensible unit before calculating.", "Convert to one unit before combining.", "Classify shapes by sides, angles and symmetry — not just how they look."},
                "A 12 cm by 5 cm rectangle has area 60 cm² and perimeter 34 cm.",
                "Area uses square units; volume uses cubic units. Don't mix them.",
                "Estimate, convert, then calculate — and name shapes by properties.",
                "MEASURE"));
        out.add(spec(year, NzSubject.MATHEMATICS, 6, "Statistics and probability: " + data, "Statistics",
                "Collect, display and read data, then talk about chance. Year " + year + " focus: " + data + ".",
                new String[]{"Read the title, labels and scale first.", "Describe the story the graph tells.", "For chance, list all outcomes before assigning a probability."},
                "P(even on a fair die) = 3/6 = 1/2.",
                "A dramatic-looking graph might have an uneven scale — always check the axis.",
                "Data needs context; probability is favourable outcomes over total outcomes.",
                "DATA"));
        return out;
    }

    private static List<NzLessonSpec> englishLessons(int year) {
        String reading = year <= 2 ? "letters, sounds and simple stories" : year <= 4 ? "fluency and finding details" : year <= 6 ? "main idea, inference and evidence" : "critical reading of complex texts";
        String writing = year <= 2 ? "sentences and captions" : year <= 4 ? "paragraphs and recounts" : year <= 6 ? "structured explanations and persuasion" : "formal, crafted writing for purpose";
        String grammar = year <= 2 ? "capitals, full stops and spaces" : year <= 4 ? "nouns, verbs and commas" : year <= 6 ? "complex sentences and dialogue" : "clauses, cohesion and register";
        String vocab = year <= 2 ? "high-frequency words" : year <= 4 ? "word families and synonyms" : year <= 6 ? "context clues and morphology" : "academic and figurative vocabulary";
        String oral = year <= 2 ? "sharing news and listening" : year <= 4 ? "group discussion" : year <= 6 ? "presenting with evidence" : "formal speaking and debate";

        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.ENGLISH, 1, "Reading: " + reading, "Reading",
                "Readers make meaning from print. Year " + year + " focuses on " + reading + ".",
                new String[]{"Preview the title and pictures.", "Read for gist, then reread for details.", "Use evidence from the text when you answer."},
                "If two answers seem right, choose the one the text actually supports.",
                "Inference means reading between the lines — but it still needs a clue in the text.",
                "Read once for the story, again for the evidence.",
                "READING"));
        out.add(spec(year, NzSubject.ENGLISH, 2, "Writing: " + writing, "Writing",
                "Writers plan, draft and improve. Year " + year + " focuses on " + writing + ".",
                new String[]{"Know your purpose and audience.", "Plan ideas before you draft.", "Read it aloud and improve one thing at a time."},
                "A paragraph: topic sentence → example → explanation → link.",
                "One paragraph, one main idea. Start a new paragraph when the idea changes.",
                "Plan, write, then polish — don't try to do all three at once.",
                "WRITING"));
        out.add(spec(year, NzSubject.ENGLISH, 3, "Grammar and punctuation: " + grammar, "Language",
                "Grammar helps readers understand you. Year " + year + " focuses on " + grammar + ".",
                new String[]{"Every sentence needs a subject and a verb.", "Use punctuation to show pauses and meaning.", "Check agreement: she runs, they run."},
                "\"Let's eat, Grandma!\" is kind. \"Let's eat Grandma!\" is not.",
                "A run-on sentence is two complete ideas jammed together. Split or join them properly.",
                "Clear sentences use complete ideas and careful punctuation.",
                "GRAMMAR"));
        out.add(spec(year, NzSubject.ENGLISH, 4, "Vocabulary: " + vocab, "Language",
                "Word knowledge grows from reading and word-building. Year " + year + " focuses on " + vocab + ".",
                new String[]{"Use the words around an unknown word as clues.", "Look for prefixes, roots and suffixes.", "Try a synonym and check the sentence still makes sense."},
                "Un- + happy + -ness → unhappiness (the state of not being happy).",
                "The best word is the precise one, not always the longest one.",
                "Context + word parts = a powerful decoding toolkit.",
                "VOCAB"));
        out.add(spec(year, NzSubject.ENGLISH, 5, "Speaking and listening: " + oral, "Oral language",
                "Talk is thinking out loud. Year " + year + " focuses on " + oral + ".",
                new String[]{"Listen to understand, not just to reply.", "Take turns and build on others' ideas.", "Support opinions with a reason or example."},
                "I agree with Ana because the text says…",
                "Eye contact, a clear voice and a pause at the end help listeners.",
                "Respectful talk uses reasons, evidence and turn-taking.",
                "ORAL"));
        return out;
    }

    private static List<NzLessonSpec> scienceLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.SCIENCE, 1, "Investigating like a scientist", "Nature of science",
                "Scientists ask questions, test fairly, and change their minds when evidence says so. Year " + year + " investigations match the class's tools and safety.",
                new String[]{"Ask a testable question.", "Change only one variable in a fair test.", "Record observations, then conclude from evidence."},
                "To test which paper towel is strongest, keep the water amount the same and change only the brand.",
                "A fair test keeps everything the same except the one thing you are testing.",
                "Question → method → data → conclusion. Evidence first.",
                "INVESTIGATE"));
        out.add(spec(year, NzSubject.SCIENCE, 2, year <= 4 ? "Living things around us" : "Living world and ecosystems", "Living world",
                "Living things grow, need energy, and depend on their environment. Year " + year + " looks at habitats, life cycles and food connections in Aotearoa.",
                new String[]{"Name needs of living things (food, water, air, shelter).", "Trace a simple food chain.", "Describe how a feature helps survival."},
                "A kiwi's long beak helps it find food in leaf litter — an adaptation to its habitat.",
                "An ecosystem is like a team: if one part is missing, others feel it.",
                "Living things are connected through habitats, food and adaptation.",
                "LIVING"));
        out.add(spec(year, NzSubject.SCIENCE, 3, year <= 4 ? "Materials and their properties" : "Matter and materials", "Material world",
                "Stuff around us is solid, liquid or gas, and can change. Year " + year + " explores properties, mixing and changes of state.",
                new String[]{"Sort materials by properties (hard, flexible, waterproof).", "Describe melting, freezing, evaporating and condensing.", "Decide if a change is reversible."},
                "Ice → water → steam is reversible. Burning toast is not.",
                "Particles in a solid are packed and vibrate; in a gas they move freely.",
                "Properties and particle behaviour explain everyday materials.",
                "MATTER"));
        out.add(spec(year, NzSubject.SCIENCE, 4, year <= 4 ? "Pushes, pulls and movement" : "Forces, energy and motion", "Physical world",
                "Pushes and pulls change how things move. Year " + year + " connects forces, friction, gravity and simple energy ideas.",
                new String[]{"Identify a push or a pull in a situation.", "Name friction and gravity in everyday examples.", "Explain how a simple machine makes work easier."},
                "A rough ramp has more friction than a smooth one, so a toy car travels a shorter distance.",
                "Forces have size and direction. Unbalanced forces change motion.",
                "Forces explain starts, stops, turns and falls.",
                "FORCES"));
        out.add(spec(year, NzSubject.SCIENCE, 5, year <= 4 ? "Earth, sky and weather" : "Planet Earth and beyond", "Planet Earth & space",
                "Earth is a system: land, water, air and space. Year " + year + " explores day and night, seasons, weather and our place in the solar system.",
                new String[]{"Explain day and night using Earth's rotation.", "Connect seasons to Earth's tilt and orbit.", "Read simple weather measures (temperature, rainfall, wind)."},
                "It is daytime on the side of Earth facing the Sun.",
                "Seasons are not caused by Earth being closer to the Sun — tilt is the key.",
                "Earth's motion and atmosphere create the patterns we live in.",
                "EARTH"));
        return out;
    }

    private static List<NzLessonSpec> socialLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.SOCIAL_SCIENCES, 1, "Identity, culture and belonging", "Identity",
                "We all have identities shaped by family, place and culture. Year " + year + " explores belonging in Aotearoa New Zealand, including Māori and Pacific perspectives.",
                new String[]{"Name groups you belong to (whānau, class, community).", "Respect different cultural practices.", "Use the correct names for people and places."},
                "Pepeha and introductions locate a person in people and place — mountain, river, waka, iwi.",
                "Culture is lived every day, not only on special occasions.",
                "Knowing who we are helps us understand others.",
                "IDENTITY"));
        out.add(spec(year, NzSubject.SOCIAL_SCIENCES, 2, "Places and environments", "Place",
                "Places have natural and human features. Year " + year + " reads maps, compares environments, and thinks about how people use land and water.",
                new String[]{"Use a map key, compass and simple scale.", "Describe a local place with natural and built features.", "Explain how people change an environment."},
                "Aotearoa's long coastline means many communities live with the sea.",
                "A map is a view from above. Always check the key.",
                "Places can be described, compared and cared for.",
                "PLACE"));
        out.add(spec(year, NzSubject.SOCIAL_SCIENCES, 3, year <= 4 ? "Then and now" : "History and stories of Aotearoa", "History",
                "The past is known through stories, artefacts and records. Year " + year + " sequences events and considers whose voices are heard.",
                new String[]{"Put events in time order.", "Use more than one source (photo, story, object).", "Ask: whose story is this, and whose is missing?"},
                "Māori arrival, European contact, the Treaty of Waitangi (1840), and later migrations all shape today's Aotearoa.",
                "A single source is never the whole story.",
                "History is interpreted from evidence — and evidence can be incomplete.",
                "HISTORY"));
        out.add(spec(year, NzSubject.SOCIAL_SCIENCES, 4, year <= 4 ? "Needs, wants and work" : "Resources and the economy", "Economy",
                "People use resources to meet needs and wants. Year " + year + " connects work, trade, sustainability and choices.",
                new String[]{"Sort needs from wants.", "Explain a simple producer → consumer chain.", "Consider how using a resource affects others and the environment."},
                "A dairy farmer produces milk; a shop sells it; a family consumes it.",
                "Needs are essential (food, shelter). Wants are extra.",
                "Economic choices have people and planet consequences.",
                "ECONOMY"));
        out.add(spec(year, NzSubject.SOCIAL_SCIENCES, 5, "Communities and citizenship", "Citizenship",
                "Communities make rules so people can live together. Year " + year + " explores rights, responsibilities and how decisions are made — from class treaty to local government.",
                new String[]{"Give an example of a fair rule and why it exists.", "Name a way people can participate (vote, volunteer, speak up).", "Describe a local issue and two possible responses."},
                "A class treaty works when everyone helps create it and keep it.",
                "Rights come with responsibilities to others.",
                "Active citizens notice, discuss, and take fair action.",
                "CIVICS"));
        return out;
    }

    private static List<NzLessonSpec> techLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.TECHNOLOGY, 1, "Design thinking for people", "Design",
                "Technology starts with a need. Year " + year + " students identify users, generate ideas, and improve a solution.",
                new String[]{"Name the user and the problem.", "Sketch more than one idea.", "Test, get feedback, then improve."},
                "A lunchbox that leaks is a brief: keep food dry and easy to carry.",
                "The first idea is rarely the best — iteration is the skill.",
                "Empathise, ideate, prototype, test.",
                "DESIGN"));
        out.add(spec(year, NzSubject.TECHNOLOGY, 2, "Digital technologies", "Digital",
                "Digital systems store, process and share information. Year " + year + " covers algorithms, patterns, and being a kind, safe digital citizen.",
                new String[]{"Give step-by-step instructions a computer could follow.", "Spot a repeating pattern in data or code.", "Choose a safe, respectful online action."},
                "An algorithm for toast: bread in → select time → start → remove when done.",
                "Computers only do what instructions say — be precise.",
                "Algorithms plus digital citizenship keep technology useful and safe.",
                "DIGITAL"));
        out.add(spec(year, NzSubject.TECHNOLOGY, 3, "Materials and making", "Making",
                "Makers choose materials for their properties. Year " + year + " plans, measures, and constructs with care and safety.",
                new String[]{"Match material to purpose (strong, waterproof, flexible).", "Measure twice, cut once.", "Work safely with tools and tidy the space."},
                "Card is easy to fold; corrugated card is stronger for a bridge span.",
                "A prototype can be rough — it is for learning, not for show.",
                "Good making is purposeful, safe and improved after testing.",
                "MAKING"));
        out.add(spec(year, NzSubject.TECHNOLOGY, 4, year <= 4 ? "Steps, sequences and food tech" : "Computational thinking and systems", "Systems",
                "Systems have inputs, processes and outputs. Year " + year + " traces how a product or program works end to end.",
                new String[]{"Identify input, process and output.", "Break a big task into smaller steps.", "Find a bug and fix one thing at a time."},
                "Recipe: ingredients (input) → mix and bake (process) → muffin (output).",
                "Debugging is expected. The skill is isolating the error.",
                "Think in systems: what goes in, what happens, what comes out.",
                "COMPUTE"));
        out.add(spec(year, NzSubject.TECHNOLOGY, 5, "Evaluating outcomes", "Evaluate",
                "Did the outcome meet the brief? Year " + year + " judges fitness for purpose, impact on people, and next improvements.",
                new String[]{"Re-read the brief before judging.", "Test with a real user if you can.", "Name one strength and one next step."},
                "If the brief was 'easy for Year 2 hands', a tiny fiddly latch fails even if it looks smart.",
                "Fit for purpose beats 'looks cool' when you evaluate.",
                "Evaluate against the brief, then plan the next iteration.",
                "EVALUATE"));
        return out;
    }

    private static List<NzLessonSpec> artsLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.THE_ARTS, 1, "Visual arts: seeing and making", "Visual",
                "Artists use line, colour, shape, texture and space. Year " + year + " experiments with media and looks closely at artworks, including work from Aotearoa.",
                new String[]{"Name an element you can see (line, colour, texture…).", "Try a technique, then vary one thing.", "Talk about what you notice, not only what you like."},
                "Warm colours (red, orange, yellow) can make a picture feel energetic.",
                "Looking carefully is a skill — describe before you judge.",
                "See, try, reflect. Visual language can be learned.",
                "VISUAL"));
        out.add(spec(year, NzSubject.THE_ARTS, 2, "Music: sound, beat and expression", "Music",
                "Music organises sound in time. Year " + year + " keeps a beat, explores pitch and dynamics, and sings or plays with others.",
                new String[]{"Find the beat by tapping along.", "Describe high/low, loud/soft, fast/slow.", "Listen to others when you perform together."},
                "A steady beat is the heartbeat of a piece; rhythm is the pattern of long and short sounds.",
                "Listening is half of musicianship.",
                "Beat, pitch and expression help us perform and appreciate music.",
                "MUSIC"));
        out.add(spec(year, NzSubject.THE_ARTS, 3, "Drama: role, space and story", "Drama",
                "Drama is making meaning with body, voice and imagination. Year " + year + " steps into roles and builds simple scenes.",
                new String[]{"Use body and voice to show a character.", "Stay in role until the scene ends.", "Accept others' ideas ('yes, and…')."},
                "If your character is shy, smaller movements and a quieter voice can show that.",
                "Drama needs focus: look, listen, and commit to the scene.",
                "Role, space and story work together on stage.",
                "DRAMA"));
        out.add(spec(year, NzSubject.THE_ARTS, 4, "Dance: body, space and time", "Dance",
                "Dance is movement with purpose. Year " + year + " explores body shapes, pathways, energy and dancing with others.",
                new String[]{"Make a still shape, then travel through space.", "Change level (low, middle, high) and speed.", "Copy, contrast, and dance safely in the space."},
                "A motif is a movement idea you can repeat and vary.",
                "Safe dancing means control, space awareness and landing softly.",
                "Body, space, time and energy are the building blocks of dance.",
                "DANCE"));
        out.add(spec(year, NzSubject.THE_ARTS, 5, "Responding to the arts", "Respond",
                "We respond to art with noticing, feeling and evidence. Year " + year + " uses respectful language to talk about their own and others' work.",
                new String[]{"Describe what you see/hear first.", "Connect it to a feeling or idea.", "Give a specific, kind suggestion."},
                "I notice repeating triangles, which makes the picture feel busy and energetic.",
                "\"I like it\" is a start — add because…",
                "Good responses are specific, respectful and evidence-based.",
                "RESPOND"));
        return out;
    }

    private static List<NzLessonSpec> hpeLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.HEALTH_PE, 1, "Movement skills and play", "Movement",
                "Skilled movement is learned with practice. Year " + year + " develops locomotor, stability and object-control skills in games and play.",
                new String[]{"Watch a model, then try.", "Focus on one cue at a time (eyes on the ball).", "Play fairly and include others."},
                "To catch: eyes on the ball, hands ready, soft hands, bring it in.",
                "Practice with a purpose beats random repetition.",
                "Skills grow with cues, practice and fair play.",
                "MOVE"));
        out.add(spec(year, NzSubject.HEALTH_PE, 2, "Hauora and healthy habits", "Hauora",
                "Hauora is a Māori view of wellbeing with taha tinana (body), taha hinengaro (mind), taha whānau (relationships) and taha wairua (spirit). Year " + year + " applies this to daily habits.",
                new String[]{"Name the four taha of hauora.", "Give a habit that supports each taha.", "Notice when one taha is out of balance."},
                "Sleep, kai, friendship, and time in nature all feed different parts of hauora.",
                "Wellbeing is more than not being sick.",
                "Look after all four taha — they work together.",
                "HAUORA"));
        out.add(spec(year, NzSubject.HEALTH_PE, 3, "Relationships and communication", "Relationships",
                "Healthy relationships use respect, consent and clear communication. Year " + year + " practises friendship skills and asking for help.",
                new String[]{"Use I-statements (I feel… when…).", "Ask before you touch or borrow.", "Know trusted adults you can talk to."},
                "Instead of \"You're mean\", try \"I felt left out when the game started without me.\"",
                "Consent can be withdrawn. Stop if someone says no.",
                "Respect, consent and kind honesty keep relationships safe.",
                "RELATE"));
        out.add(spec(year, NzSubject.HEALTH_PE, 4, "Safety and risk", "Safety",
                "We identify hazards and choose safer actions. Year " + year + " covers water, road, sun, online and emergency basics.",
                new String[]{"Spot the hazard.", "Choose a safer option.", "Know when to get an adult or call 111."},
                "At the beach: swim between the flags, never swim alone.",
                "Being brave is not the same as taking an unsafe risk.",
                "Notice, choose, and get help when needed.",
                "SAFETY"));
        out.add(spec(year, NzSubject.HEALTH_PE, 5, "Healthy communities", "Community",
                "Wellbeing is personal and collective. Year " + year + " explores how schools, sports and neighbourhoods help everyone participate.",
                new String[]{"Name a way your school supports hauora.", "Suggest one inclusive change to a game or activity.", "Connect personal choices to community effects."},
                "A playground buddy bench helps someone who needs a friend — a small design with a big social effect.",
                "Inclusion is a skill, not an extra.",
                "Healthy communities make it easier for everyone to belong and move.",
                "COMMUNITY"));
        return out;
    }

    private static List<NzLessonSpec> languageLessons(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(spec(year, NzSubject.LEARNING_LANGUAGES, 1, "Greetings and introductions in te reo Māori", "Communicate",
                "Languages open relationships. Year " + year + " practises greetings, farewells and simple introductions in te reo Māori.",
                new String[]{"Use kia ora and tēnā koe in the right situation.", "Introduce yourself with a simple sentence.", "Respond when someone greets you."},
                "Kia ora is a friendly hello. Tēnā koe greets one person more formally. Tēnā koutou greets a group.",
                "Pronounce macron vowels carefully — they change meaning.",
                "Greet, introduce, respond — the first loop of any language.",
                "GREETINGS"));
        out.add(spec(year, NzSubject.LEARNING_LANGUAGES, 2, "Everyday words and numbers", "Vocabulary",
                "High-frequency words build confidence. Year " + year + " learns numbers, colours, kai, whānau words and classroom phrases.",
                new String[]{"Learn a small set of words deeply.", "Use them in a real sentence the same day.", "Listen for the same words in waiata or stories."},
                "Tahi, rua, toru, whā, rima, ono, whitu, waru, iwa, tekau (1–10).",
                "A word you can say in a sentence is a word you own.",
                "Numbers, colours and classroom talk are the daily toolkit.",
                "WORDS"));
        out.add(spec(year, NzSubject.LEARNING_LANGUAGES, 3, "Listening and speaking", "Oral",
                "We understand more than we can say at first. Year " + year + " trains the ear, then the voice, with short exchanges.",
                new String[]{"Listen for a key word before you reply.", "Repeat a model sentence, then swap one word.", "Keep going even if you make a mistake."},
                "Kei te pēhea koe? — Kei te pai, kia ora.",
                "Mistakes are data. Fluency grows from trying.",
                "Listen first, then speak in short, true sentences.",
                "LISTEN"));
        out.add(spec(year, NzSubject.LEARNING_LANGUAGES, 4, "Reading simple texts", "Literacy",
                "Print supports oral language. Year " + year + " reads signs, labels, simple sentences and dual-language texts.",
                new String[]{"Use pictures and known words as anchors.", "Read aloud to hear the sounds.", "Guess meaning, then check."},
                "A classroom label 'tēpu' next to a table is a text you can read on day one.",
                "You do not need every word to get the gist.",
                "Simple texts recycle the words you are learning.",
                "READLANG"));
        out.add(spec(year, NzSubject.LEARNING_LANGUAGES, 5, "Culture, tikanga and respect", "Culture",
                "Language and culture travel together. Year " + year + " learns why tikanga matters — karakia, pōwhiri, manaakitanga — and how to participate respectfully.",
                new String[]{"Name one tikanga and its purpose.", "Use te reo with respect, not as a joke.", "Notice when English and te reo sit together in Aotearoa life."},
                "Removing shoes before entering some spaces shows respect for the people and the place.",
                "Knowing a greeting is not the same as understanding the culture — keep learning both.",
                "Use the language with care for the people it belongs to.",
                "TIKANGA"));
        return out;
    }

    private static NzLessonSpec spec(int year, NzSubject subject, int order, String title, String strand,
                                    String intro, String[] steps, String example, String tip, String recap, String kind) {
        String html = "<p>" + intro + "</p>"
                + Doc.key("Year " + year + " · " + strand)
                + Doc.steps(steps)
                + Doc.example(example)
                + Doc.tip(tip)
                + Doc.recap(recap);
        String strategy = "<p>Use this routine on every " + strand.toLowerCase() + " task.</p>"
                + Doc.steps(
                "Read what is asked before you look at the options.",
                "Underline the key idea, number, word or clue.",
                "Eliminate answers that cannot be true.",
                "Check that your choice matches the question, not a nearby fact.")
                + Doc.tip("If you are stuck, use the Show hint button — it will not give the answer away.");
        return new NzLessonSpec(order, order + ". " + title, strand, html,
                practiceKey(year, subject, order), strategy, kind);
    }

    public record YearSubject(int year, NzSubject subject) {
    }
}
