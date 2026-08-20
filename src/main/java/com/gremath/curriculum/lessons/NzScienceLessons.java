package com.gremath.curriculum.lessons;

import com.gremath.curriculum.LessonHtml;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Science Years 1–10 using Nature of Science plus the four contextual strands from the NZC,
 * with year-appropriate knowledge (until the full 2027 learning-area refresh).
 */
public final class NzScienceLessons {

    private NzScienceLessons() {
    }

    public static List<NzLessonSpec> forYear(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(s(year, 1, nosTitle(year), "Nature of science", "INVESTIGATE", nos(year)));
        out.add(s(year, 2, livingTitle(year), "Living world", "LIVING", living(year)));
        out.add(s(year, 3, matterTitle(year), "Material world", "MATTER", matter(year)));
        out.add(s(year, 4, physTitle(year), "Physical world", "FORCES", physical(year)));
        out.add(s(year, 5, earthTitle(year), "Planet Earth and beyond", "EARTH", earth(year)));
        out.add(s(year, 6, aotearoaTitle(year), "Science in Aotearoa", "INVESTIGATE", aotearoa(year)));
        return out;
    }

    private static NzLessonSpec s(int year, int order, String title, String strand, String kind, String html) {
        return new NzLessonSpec(order, order + ". " + title, strand, html,
                "nz-" + year + "-" + NzSubject.SCIENCE.slug() + "-" + order,
                LessonHtml.strategy(strand.toLowerCase(),
                        new String[]{"Read what is being asked (a definition, a fair test, or an application).",
                                "Use the Year " + year + " idea, not a more advanced word you cannot explain.",
                                "Give an Aotearoa or everyday example.",
                                "Check that evidence, not hope, supports the claim."},
                        "stating a conclusion that the method could not actually test"),
                kind);
    }

    private static String nosTitle(int y) {
        return switch (y) {
            case 1, 2 -> "Noticing, wondering and testing safely";
            case 3, 4 -> "Fair tests: change one thing";
            case 5, 6 -> "Variables, measurement and evidence-based claims";
            case 7, 8 -> "Models, uncertainty and peer checking";
            default -> "Investigative design, validity and communicating science";
        };
    }

    private static String livingTitle(int y) {
        return switch (y) {
            case 1 -> "Living or non-living, and what living things need";
            case 2 -> "Plants, animals and local habitats";
            case 3 -> "Life cycles of familiar animals and plants";
            case 4 -> "Features that help survival (adaptation)";
            case 5 -> "Food chains and interdependence";
            case 6 -> "Ecosystems in Aotearoa, including native species";
            case 7 -> "Cells as the basic units of life";
            case 8 -> "Body systems and staying in balance";
            case 9 -> "Genetics, variation and natural selection (introductory)";
            default -> "Ecology, human impact and biodiversity in Aotearoa";
        };
    }

    private static String matterTitle(int y) {
        return switch (y) {
            case 1, 2 -> "Materials we can see and feel: hard, soft, waterproof";
            case 3, 4 -> "Solids, liquids, gases and melting/freezing";
            case 5, 6 -> "Mixtures, dissolving and reversible vs irreversible change";
            case 7, 8 -> "Particles, pure substances and chemical vs physical change";
            default -> "Atoms, elements, simple reactions and conservation ideas";
        };
    }

    private static String physTitle(int y) {
        return switch (y) {
            case 1, 2 -> "Pushes, pulls and making things move or stop";
            case 3, 4 -> "Friction, magnets and simple machines";
            case 5, 6 -> "Forces, gravity, energy we can see and hear";
            case 7, 8 -> "Unbalanced forces, energy transfers and electricity basics";
            default -> "Motion, energy conservation and electrical circuits";
        };
    }

    private static String earthTitle(int y) {
        return switch (y) {
            case 1, 2 -> "Day, night, weather we can feel";
            case 3, 4 -> "Seasons, the Moon, and land/water around us";
            case 5, 6 -> "Earth's tilt, water cycle and our place in the solar system";
            case 7, 8 -> "Plate tectonics, Aotearoa's geology and climate systems";
            default -> "Earth systems, climate change science and space beyond the solar system";
        };
    }

    private static String aotearoaTitle(int y) {
        return switch (y) {
            case 1, 2 -> "Scientists and kaitiaki in our community";
            case 3, 4 -> "Mātauranga Māori and careful observation of te taiao";
            case 5, 6 -> "Native species, biosecurity and restoration";
            case 7, 8 -> "Hazards in Aotearoa: quakes, volcanoes, floods";
                    default -> "Socio-scientific issues: climate, water, and informed citizenship";
        };
    }

    private static String nos(int y) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Nature of science",
                new String[]{"Ask a question that could be tested or carefully observed.",
                        y <= 4 ? "Change only one thing in a fair comparison." : "Name independent, dependent and controlled variables.",
                        "Conclude only from the evidence you actually collected."},
                LessonHtml.p("Science is a way of producing trustworthy knowledge: questions, methods, data, claims that can be checked. Year " + y + " investigations should match the tools and safety of the class.")
                        + LessonHtml.p("A fair test keeps everything the same except the one factor you are testing. If you test paper towels and change both brand and amount of water, you will not know which mattered.")
                        + LessonHtml.p(y >= 7 ? "Models (particle diagrams, climate graphs) are useful and incomplete. Uncertainty is not failure — repeating trials and showing a range is honest science."
                        : "Scientists change their minds when evidence says so. That is strength, not weakness."),
                "Measuring rainfall in a school gauge, or asking kaumātua about seasonal signs, can sit together: different knowledge systems, shared respect for careful observation.",
                new String[]{"Write a testable question.", "Plan what you will change, measure and keep the same.", "Record in a table.", "Claim + evidence + uncertainty."},
                "Fair test",
                "Which towel holds more water? Same volume of water, same time, only the brand changes.",
                "A non-testable question",
                "'Are plants nicer than rocks?' cannot be measured. 'Which plant grows taller in 10 days in the same light?' can.",
                null,
                "Writing the conclusion before the method — that is a hope, not an investigation.",
                "If results surprise you, check the method before you throw the data away.",
                "Question → fair method → data → claim with evidence. Year " + y + ".",
                "fair test, variable, evidence, trial, model, uncertainty");
    }

    private static String living(int y) {
        String meaning = switch (y) {
            case 1, 2 -> "Living things grow, need energy and produce waste. Non-living things (rocks, water, plastic) do not carry out life processes. Local habitats — school garden, rocky shore, bush remnant — supply food, water, shelter and space.";
            case 3, 4 -> "Life cycles (egg–larva–pupa–adult; seed–seedling–plant) show change over time. Adaptations are features that help survival: a kiwi's long beak for forest-floor invertebrates, a tūī's brush tongue for nectar.";
            case 5, 6 -> "Food chains show energy flowing from the sun to producers (plants) to consumers. If one species is removed, others feel it. Aotearoa's islands evolved without land mammals (except bats), so introduced mammals are a biosecurity story.";
            case 7, 8 -> "Cells are the basic units of life. Microscopes reveal that plants and animals are built from cells with some shared and some different parts (cell wall, chloroplasts in plants). Body systems (digestive, circulatory, respiratory) work together to keep conditions stable.";
            default -> "Variation in a species is the raw material for natural selection: individuals with traits that fit the current environment tend to leave more offspring. Genes are instructions in DNA (introductory). Ecology studies relationships; biodiversity in Aotearoa is taonga under pressure from habitat loss and predators.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Living world",
                new String[]{"Name needs or processes of living things at Year " + y + " level.",
                        "Give an Aotearoa example (kiwi, tūī, harakeke, rocky shore).",
                        y >= 5 ? "Trace a food-chain or ecosystem relationship." : "Sort living/non-living or sequence a simple life cycle."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Avoid cartoon biology: mushrooms are not plants; whales are mammals not fish; kiwi cannot fly — that is an evolutionary story, not a failure.")
                        + LessonHtml.p("Kaitiakitanga (guardianship) is a values frame that can sit beside ecological science without replacing evidence."),
                "A kiwi's nocturnal, flightless life is an adaptation to an island with few mammalian predators — until humans brought new ones. That is Living World plus history.",
                new String[]{"Identify the organism and its habitat.", "Name a need or a feature.", "Explain how the feature helps.", "Connect to a food or life-cycle diagram if asked."},
                "Food chain (from Year 5)",
                "Harakeke (producer) → insect → fantail (pīwakawaka). Arrows mean 'is eaten by' / energy flow — draw them toward the eater.",
                "Adaptation",
                "Tūī have a brush-tipped tongue for nectar. That feature matches flax and kōwhai flowers in their habitat.",
                null,
                "Drawing arrows the wrong way on a food chain (pointing at the plant as if it eats the bird).",
                "Name the local species if you can; 'a bird' is weaker than 'tūī'.",
                "Living things are connected through needs, features, food and habitat. Year " + y + ".",
                "habitat, adaptation, producer, consumer, cell, ecosystem, biodiversity");
    }

    private static String matter(int y) {
        String meaning = switch (y) {
            case 1, 2, 3, 4 -> "Stuff is solid, liquid or gas in everyday life. Ice, water and steam are the same water in different states. Melting and freezing are reversible; burning toast is not. We sort materials by properties: hard, flexible, waterproof, transparent.";
            case 5, 6 -> "Mixtures can often be separated (sieving, filtering, evaporating salt water). Dissolving is not disappearing — the solute is still there. Irreversible changes make new materials (cooking, rusting).";
            case 7, 8 -> "A particle model: solids packed and vibrating; liquids sliding; gases far apart and fast. Physical changes rearrange particles; chemical changes make new substances with new properties. Indicators and simple reactions (acid + base) appear in many Year 7–8 programmes.";
            default -> "Elements are substances made of one type of atom. Compounds combine elements. Chemical equations must balance atoms (conservation of mass). Rates depend on temperature, surface area and concentration — particle explanations again.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Material world",
                new String[]{"Describe a property or a change of state in everyday language, then scientific language.",
                        "Decide if a change is likely reversible.",
                        y >= 7 ? "Use a particle idea to explain." : "Sort or choose a material for a purpose."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Temperature is not the same as heat in later physics, but in junior years 'hotter means particles move more' is a useful seed.")
                        + LessonHtml.p("Safety: taste is not a science test. Some school chemicals and kitchen cleaners are hazardous."),
                "Hāngī stones, boiling water in a kettle, and salt drying on a summer deck are material-world moments in Aotearoa life.",
                new String[]{"Name the material and the property.", "Describe the change (what you saw).", "Classify reversible/irreversible.", "Explain with particles if you are in Year 7+."},
                "Ice → water → steam",
                "Reversible with cooling. Burning bread is not reversible in the classroom.",
                "Waterproof coat",
                "Choose a material that water beads on. Tissue fails the purpose even if it is soft.",
                null,
                "Saying sugar 'vanishes' in tea. It dissolved — taste (if safe) or evaporate the water to see it again.",
                "Property first, then name. 'Metal' is a category; 'conducts electricity' is a property.",
                "Properties and changes of materials, with Year " + y + " particle ideas as appropriate.",
                "solid, liquid, gas, melt, dissolve, reversible, particle, atom");
    }

    private static String physical(int y) {
        String meaning = switch (y) {
            case 1, 2, 3, 4 -> "Pushes and pulls are forces. They can start, stop, speed up, slow down or change direction of movement. Friction with a rough mat slows a toy car. Magnets pull some metals without touching. Ramps, levers and wheels are simple machines that change how a force feels.";
            case 5, 6 -> "Forces have size and direction. Gravity pulls toward Earth's centre. Unbalanced forces change motion; balanced forces can keep a still object still or a steady speed in a simple model. Sound and light transfer energy — we hear vibration, we see when light reaches our eyes.";
            default -> "Newton's first idea in school form: things keep doing what they are doing unless a net force acts. Speed = distance/time. Electricity in simple series circuits needs a loop. Energy is transferred or transformed (not 'used up'); efficiency is how much useful energy you get out.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Physical world",
                new String[]{"Identify a force or energy transfer in a situation.",
                        "Say what changes (speed, direction, temperature, brightness).",
                        y >= 7 ? "Use a quantity (N, m/s) if given." : "Give a fair-test idea (smooth vs rough ramp)."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Weight and mass get mixed up: mass is how much stuff; weight is the gravitational force on it. On the Moon mass is the same, weight is less.")
                        + LessonHtml.p("Never experiment with mains electricity. Battery circuits only, as your teacher allows."),
                "A rugby tackle is a force pair; a waka moving through water fights drag; a steel-roof magnet board in a classroom is everyday magnetism.",
                new String[]{"Name push/pull or the energy form.", "Draw an arrow for direction if useful.", "Link to friction, gravity or a simple machine.", "Predict what happens if you change one variable."},
                "Rough vs smooth ramp",
                "Same toy car, same height: more friction on carpet, shorter roll. Change only the surface.",
                "Why we don't float off Earth",
                "Gravity pulls us toward the centre of Earth. That's a force, not a 'lack of space'.",
                null,
                "Thinking there is no force on a still book. Gravity and the table's support can balance.",
                "Arrows on force diagrams should show direction; label them.",
                "Forces change motion; energy changes form. Year " + y + ".",
                "force, friction, gravity, energy, circuit, balanced, unbalanced");
    }

    private static String earth(int y) {
        String meaning = switch (y) {
            case 1, 2, 3, 4 -> "Day and night happen because Earth rotates. The Sun does not 'go to bed'. Weather is the mix of temperature, wind, rain you feel this week; seasons are a longer pattern. The Moon's shape in the sky changes over a month (maramataka is a lunar calendar).";
            case 5, 6 -> "Seasons are caused mainly by Earth's tilt as it orbits the Sun — not by Earth being much closer in summer (NZ is actually closer in southern summer, which is a useful myth-buster). The water cycle: evaporate, condense, precipitate. The solar system is the Sun plus orbiting worlds; Earth is third.";
            default -> "Aotearoa sits on the Pacific Ring of Fire: earthquakes and volcanoes come from plate movement. Climate is long-term; weather is short-term. Climate change science is about greenhouse gases changing Earth's energy balance — measurable, not a vibe. Beyond the solar system, stars are distant suns; a light-year is a distance.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Planet Earth and beyond",
                new String[]{"Explain day/night or seasons without the common myth for this year.",
                        "Read a simple weather or Earth-system measure.",
                        y >= 7 ? "Connect Aotearoa hazards to plate tectonics." : "Describe land, water or sky in the local environment."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Models (torch and ball for day/night) are not the real sizes — say so. Scale in space is unintuitive: if Earth is a pea, the Moon is a seed a short walk away, the Sun a big ball across the field (order-of-magnitude only).")
                        + LessonHtml.p("Maramataka Māori and scientific lunar phases can be taught as parallel observations of the same Moon."),
                "Living with earthquakes, alpine weather and a long coastline is Planet Earth in Aotearoa — preparedness is applied science.",
                new String[]{"State the model (rotation, tilt, plates).", "Say what it explains.", "Name one thing the model leaves out.", "Use a local example."},
                "Day and night",
                "It is daytime on the side of Earth facing the Sun. Rotation takes about 24 hours.",
                "Season myth",
                "Summer is not 'because we are closer'. Tilt changes how directly sunlight hits a hemisphere.",
                null,
                "Drawing the Sun going around Earth for day/night (unless you are contrasting geocentric history).",
                "Always add 'in this model' when sizes are wrong on purpose.",
                "Earth's motion, water, weather/climate and (later) plates. Year " + y + ".",
                "rotation, orbit, tilt, weather, climate, tectonic, maramataka");
    }

    private static String aotearoa(int y) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Science in Aotearoa",
                new String[]{"Give one example of science or mātauranga connected to this place.",
                        "Explain a local environmental issue at Year " + y + " level.",
                        "Suggest a care action that matches evidence (not just a poster slogan)."},
                LessonHtml.p("Science in Aotearoa includes Crown research institutes, kura investigations, farmers, meteorologists, and iwi environmental scientists. Mātauranga Māori is a knowledge system with its own methods of observation — it is not a mascot for a Western unit.")
                        + LessonHtml.p(y <= 4
                        ? "Kaitiaki look after a place. You can be a kaitiaki of a stream by not dumping rubbish and by noticing what lives there — then checking your ideas."
                        : y <= 8
                        ? "Biosecurity (kauri dieback, myrtle rust, stoats) is applied ecology. Restoration planting only works if the right species go in the right place."
                        : "Socio-scientific issues (freshwater, climate adaptation, mining, genetic technologies) have scientific and social parts. Citizenship means reading both.")
                        + LessonHtml.p("Drop, Cover, Hold is Earth-science plus civic practice. Know why: falling objects and collapsing fittings cause many injuries."),
                "Your local awa, maunga or coastline is the primary 'lab'. National examples (Kermadecs, Southern Alps, Hauraki Gulf) wait until the local is seen.",
                new String[]{"Name the place or species.", "State the observation or data.", "Name a human effect.", "Propose an action that could be checked later."},
                "Kauri dieback",
                "A soil-borne pathogen spreads on shoes. Cleaning stations are a method matched to the evidence of how it spreads.",
                "Drop, Cover, Hold",
                "Earthquakes cannot be stopped; harm can be reduced. That is hazard science.",
                null,
                "Treating mātauranga as 'myth time' before 'real science'. Both deserve accurate teaching.",
                "Pick one action you could actually do this term, not ten slogans.",
                "Place-based science, kaitiakitanga, and evidence-shaped action. Year " + y + ".",
                "mātauranga, kaitiaki, biosecurity, hazard, restoration, socio-scientific");
    }
}
