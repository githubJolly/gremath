package com.gremath.curriculum.lessons;

import com.gremath.curriculum.LessonHtml;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.curriculum.SubjectFigures;

import java.util.ArrayList;
import java.util.List;

/**
 * Social Sciences (including Aotearoa NZ Histories), Technology, The Arts,
 * Health and PE, and Learning Languages — year-specific titles with detailed teaching.
 */
public final class NzHumanitiesLessons {

    private NzHumanitiesLessons() {
    }

    public static List<NzLessonSpec> social(int year) {
        return List.of(
                spec(year, NzSubject.SOCIAL_SCIENCES, 1, socialTitle(year, 1), "Identity", "IDENTITY", socialBody(year, 1)),
                spec(year, NzSubject.SOCIAL_SCIENCES, 2, socialTitle(year, 2), "Place", "PLACE", socialBody(year, 2)),
                spec(year, NzSubject.SOCIAL_SCIENCES, 3, socialTitle(year, 3), "Aotearoa NZ histories", "HISTORY", socialBody(year, 3)),
                spec(year, NzSubject.SOCIAL_SCIENCES, 4, socialTitle(year, 4), "Government & citizenship", "CIVICS", socialBody(year, 4)),
                spec(year, NzSubject.SOCIAL_SCIENCES, 5, socialTitle(year, 5), "Resources & economy", "ECONOMY", socialBody(year, 5)),
                spec(year, NzSubject.SOCIAL_SCIENCES, 6, socialTitle(year, 6), "Culture & global connections", "IDENTITY", socialBody(year, 6))
        );
    }

    public static List<NzLessonSpec> technology(int year) {
        return List.of(
                spec(year, NzSubject.TECHNOLOGY, 1, techTitle(year, 1), "Design", "DESIGN", techBody(year, 1)),
                spec(year, NzSubject.TECHNOLOGY, 2, techTitle(year, 2), "Digital technologies", "DIGITAL", techBody(year, 2)),
                spec(year, NzSubject.TECHNOLOGY, 3, techTitle(year, 3), "Materials & making", "MAKING", techBody(year, 3)),
                spec(year, NzSubject.TECHNOLOGY, 4, techTitle(year, 4), "Computational thinking", "COMPUTE", techBody(year, 4)),
                spec(year, NzSubject.TECHNOLOGY, 5, techTitle(year, 5), "Systems", "COMPUTE", techBody(year, 5)),
                spec(year, NzSubject.TECHNOLOGY, 6, techTitle(year, 6), "Evaluate & impact", "EVALUATE", techBody(year, 6))
        );
    }

    public static List<NzLessonSpec> arts(int year) {
        return List.of(
                spec(year, NzSubject.THE_ARTS, 1, artsTitle(year, 1), "Visual arts", "VISUAL", artsBody(year, 1)),
                spec(year, NzSubject.THE_ARTS, 2, artsTitle(year, 2), "Music", "MUSIC", artsBody(year, 2)),
                spec(year, NzSubject.THE_ARTS, 3, artsTitle(year, 3), "Drama", "DRAMA", artsBody(year, 3)),
                spec(year, NzSubject.THE_ARTS, 4, artsTitle(year, 4), "Dance", "DANCE", artsBody(year, 4)),
                spec(year, NzSubject.THE_ARTS, 5, artsTitle(year, 5), "Responding", "RESPOND", artsBody(year, 5)),
                spec(year, NzSubject.THE_ARTS, 6, artsTitle(year, 6), "Arts of Aotearoa", "RESPOND", artsBody(year, 6))
        );
    }

    public static List<NzLessonSpec> hpe(int year) {
        return List.of(
                spec(year, NzSubject.HEALTH_PE, 1, hpeTitle(year, 1), "Movement", "MOVE", hpeBody(year, 1)),
                spec(year, NzSubject.HEALTH_PE, 2, hpeTitle(year, 2), "Hauora", "HAUORA", hpeBody(year, 2)),
                spec(year, NzSubject.HEALTH_PE, 3, hpeTitle(year, 3), "Relationships", "RELATE", hpeBody(year, 3)),
                spec(year, NzSubject.HEALTH_PE, 4, hpeTitle(year, 4), "Safety", "SAFETY", hpeBody(year, 4)),
                spec(year, NzSubject.HEALTH_PE, 5, hpeTitle(year, 5), "Community", "COMMUNITY", hpeBody(year, 5)),
                spec(year, NzSubject.HEALTH_PE, 6, hpeTitle(year, 6), "Health promotion", "COMMUNITY", hpeBody(year, 6))
        );
    }

    public static List<NzLessonSpec> languages(int year) {
        return List.of(
                spec(year, NzSubject.LEARNING_LANGUAGES, 1, langTitle(year, 1), "Communicate", "GREETINGS", langBody(year, 1)),
                spec(year, NzSubject.LEARNING_LANGUAGES, 2, langTitle(year, 2), "Vocabulary", "WORDS", langBody(year, 2)),
                spec(year, NzSubject.LEARNING_LANGUAGES, 3, langTitle(year, 3), "Listening & speaking", "LISTEN", langBody(year, 3)),
                spec(year, NzSubject.LEARNING_LANGUAGES, 4, langTitle(year, 4), "Reading", "READLANG", langBody(year, 4)),
                spec(year, NzSubject.LEARNING_LANGUAGES, 5, langTitle(year, 5), "Creating in the language", "WORDS", langBody(year, 5)),
                spec(year, NzSubject.LEARNING_LANGUAGES, 6, langTitle(year, 6), "Tikanga & culture", "TIKANGA", langBody(year, 6))
        );
    }

    private static NzLessonSpec spec(int year, NzSubject subject, int order, String title, String strand,
                                     String kind, String html) {
        if (html != null && !html.contains("<svg")) {
            html = insertFigure(html, figureFor(kind));
        }
        return new NzLessonSpec(order, order + ". " + title, strand, html,
                "nz-" + year + "-" + subject.slug() + "-" + order,
                LessonHtml.strategy(strand.toLowerCase(),
                        new String[]{"Read the question for the key idea (people, place, rule, or process).",
                                "Use a Year " + year + " example from Aotearoa if you can.",
                                "Give a reason, not only a label.",
                                "Check names, dates and macronised words."},
                        "using a slogan instead of an explanation"),
                kind);
    }

    private static String socialTitle(int y, int n) {
        return switch (n) {
            case 1 -> y <= 3 ? "Whānau, class and belonging" : y <= 6 ? "Identity, culture and pepeha" : "Identity, diversity and stereotypes";
            case 2 -> y <= 3 ? "Our place: natural and built features" : y <= 6 ? "Maps, environments and how people change places" : "Geographic thinking: scale, sustainability, urban/rural";
            case 3 -> y <= 3 ? "Then and now in our community" : y <= 6 ? "Māori history, the Treaty, and whose story is told" : "Colonisation, Te Tiriti, and contested histories";
            case 4 -> y <= 3 ? "Rules that help us live together" : y <= 6 ? "Local government, voting and class treaties" : "Parliament, law, and active citizenship";
            case 5 -> y <= 3 ? "Needs, wants and jobs people do" : y <= 6 ? "Production, trade and looking after resources" : "Economic choices, inequality and sustainability";
            default -> y <= 6 ? "Cultures of the Pacific and our connections" : "Globalisation, media and Aotearoa in the world";
        };
    }

    private static String socialBody(int y, int n) {
        return switch (n) {
            case 1 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Identity",
                    new String[]{"Name groups you belong to and how they shape you.", "Use people's correct names and identities.", "Respect cultural practices you do not share."},
                    LessonHtml.p("Identity is made of stories, language, place and relationships. Year " + y + " social sciences starts with belonging — whānau, class, hapū, iwi, faith, sport — without forcing anyone to share private information.")
                            + LessonHtml.p("Pepeha locates a person in people and place (maunga, awa, waka, iwi). Not every learner will have a Māori pepeha; everyone can practise a respectful introduction that names places that matter to them.")
                            + LessonHtml.p(y >= 7 ? "Stereotypes flatten people. Critical citizenship notices when a joke, advert or textbook treats a group as one type." : "Culture is lived every day (food, greetings, holidays), not only on festival days."),
                    "Aotearoa is bicultural in its founding relationship (Māori and the Crown) and multicultural in its people. Both facts can be true at once.",
                    new String[]{"Listen to how someone names themselves.", "Use that name.", "Share your own belonging without comparing 'better' cultures.", "Ask before photographing or retelling someone else's story."},
                    "Pepeha / introduction", "Ko [maunga] te maunga, ko [awa] te awa… or: I belong to this school, this street, this team — here is what that means to me.",
                    "Respect", "Using a classmate's correct name and pronouns (as your school policy teaches) is identity work, not a side rule.",
                    null, "Copying a pepeha that is not yours as if it were a costume.", "Correct names are a minimum of manaakitanga.",
                    "Belonging is specific. Year " + y + " identity work is respect plus accurate naming.",
                    "whānau, pepeha, identity, culture, stereotype, mana");
            case 2 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Place",
                    new String[]{"Read a map key, direction and (from Year 4) simple scale.", "Describe natural and built features of a place.", "Explain one way people change an environment."},
                    LessonHtml.p("Places have natural features (maunga, awa, ngahere, coastline) and built features (marae, roads, farms, malls). Year " + y + " geography is looking from above (maps) and from the ground (fieldwork).")
                            + LessonHtml.p("Aotearoa's long coastline means many communities live with the sea — tsunami sirens, erosion, and mahinga kai are place issues.")
                            + LessonHtml.p(y >= 7 ? "Scale, sustainability and urban/rural differences need evidence: density, transport, water. 'The countryside is always healthier' is a stereotype, not a map." : "A map is a view from above. Always check the key and north."),
                    "Your local awa is a better first case study than the Amazon. Start here, then zoom out.",
                    new String[]{"Orient the map (north).", "Read the key.", "Name natural vs built.", "State a human change and who it affects."},
                    "Natural vs built", "Taranaki maunga is natural; SH3 is built. Both shape how people move.",
                    "People change places", "Draining a wetland for pasture increases farm land and can reduce flood storage and bird habitat.",
                    null, "Colouring a map without a key. Pretty is not geography.", "Compass: north is a direction, not 'up the page' unless the map says so.",
                    "Places can be described, compared and cared for. Year " + y + ".",
                    "map, key, scale, natural, built, environment, coastline");
            case 3 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Aotearoa New Zealand histories",
                    new String[]{"Sequence key events at Year " + y + " level.", "Use more than one type of source.", "Ask whose voice is in the story, and whose is missing."},
                    LessonHtml.p("The Aotearoa New Zealand histories curriculum has big ideas: Māori history is the foundational and continuous history of this place; colonisation and its consequences; the power of names, stories and symbols to connect or divide.")
                            + LessonHtml.p(y <= 4
                            ? "Then-and-now using photos, taonga, and family (with permission) stories. Time order matters: first, later, now."
                            : y <= 8
                            ? "Māori arrival (various waka traditions), te ao Māori, European contact, He Whakaputanga (1835) in some programmes, Te Tiriti o Waitangi (1840) — Māori and English texts are not identical, and that difference has consequences. Later migrations (Pacific, European, Asian) also shape today's communities."
                            : "Contested history means good historians disagree using evidence. The New Zealand Wars, raupatu (land confiscation), urbanisation, and the Waitangi Tribunal are Year 9–10 territory. Avoid a single 'progress' story.")
                            + LessonHtml.p("A single textbook paragraph is never the whole past. Oral history, whenua, archives and artefacts all count as sources — each with limits."),
                    "1840 is not 'when New Zealand began'. People, language and tikanga were already here. 1840 is when a treaty relationship was signed — and then often breached.",
                    new String[]{"Put events on a timeline.", "Name two sources.", "State what each source can and cannot tell you.", "Write whose perspective is centred."},
                    "Te Tiriti o Waitangi",
                    "First signed 6 February 1840 at Waitangi, then around the motu. The Māori text (Te Tiriti) and the English text (the Treaty) have important differences, including around kāwanatanga and tino rangatiratanga.",
                    "Whose story?",
                    "A painting of 'discovery' by a European artist may hide that the harbour already had a name and people. Ask what is outside the frame.",
                    null, "Treating 1840 as the start of all history here.", "Use the names Waitangi and Te Tiriti carefully — they are not slang.",
                    "History is interpreted from incomplete evidence. Year " + y + " asks whose voice we hear.",
                    "Te Tiriti, source, timeline, colonisation, tāngata whenua, perspective");
            case 4 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Citizenship",
                    new String[]{"Give a reason a rule exists.", "Name a way people participate (vote, submit, volunteer, protest peacefully).", "Describe a local issue and two possible responses."},
                    LessonHtml.p("Communities make rules so people can live together. Year " + y + " ranges from a class treaty to Parliament. Rights come with responsibilities.")
                            + LessonHtml.p("Aotearoa has a representative democracy, MMP at national elections (from Year 8–10 detail), local councils, and iwi/hapū authorities. The monarch is head of state in the current constitutional arrangement; day-to-day government is elected.")
                            + LessonHtml.p("Peaceful protest, petitions and select-committee submissions are legal participation. Violence is not 'more civic'. Know 111 for emergencies, not for opinions."),
                    "A class treaty co-created with students is citizenship in miniature — it only works if people keep it.",
                    new String[]{"Name the rule or institution.", "State its purpose.", "Give a participation example.", "Consider who is left out of the decision."},
                    "Why a road-crossing rule?", "So people are not hit by cars. Fairness is safety, not 'teachers being mean'.",
                    "Participation", "Voting in a school mock election, writing to a councillor about a playground, joining a beach clean-up.",
                    null, "Thinking 'politics' is only Parliament. School and iwi decisions are political too.", "Rights without responsibilities collapse trust.",
                    "Rules, representation, and taking fair action. Year " + y + ".",
                    "citizenship, vote, council, Parliament, rights, responsibilities, MMP");
            case 5 -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Economy",
                    new String[]{"Sort needs and wants.", "Follow a simple producer → consumer chain.", "Explain a trade-off (using a resource means not using it another way)."},
                    LessonHtml.p("People use scarce resources to meet needs (food, shelter, safety) and wants (extras). Year " + y + " economics is choices and consequences for people and te taiao.")
                            + LessonHtml.p("A dairy farmer produces milk; a factory processes it; a shop sells it; a whānau consumes it. Work is paid and unpaid (care at home is still work).")
                            + LessonHtml.p(y >= 7 ? "Markets set many prices; government taxes and provides public goods (hospitals, roads). Inequality means not everyone starts in the same place. Sustainability asks about tomorrow's people too." : "Money is a tool for trade. Saving is delayed spending. Advertising tries to turn wants into 'musts'."),
                    "Primary industries (dairy, meat, horticulture, tourism, film in some regions) still sit beside a large services economy in Aotearoa — local examples beat generic 'factories'.",
                    new String[]{"Identify need vs want in the story.", "Name producer and consumer.", "State a cost to people or environment.", "Suggest a more sustainable option if asked."},
                    "Need vs want", "A raincoat in a wet region is closer to a need than a fifth branded hoodie.",
                    "Trade-off", "Using river water for irrigation may reduce flow for fish. Both uses cannot always be maximised.",
                    null, "Calling everything a need. If you can live without it, it is likely a want.", "Follow the chain: who got paid, who did unpaid work, what waste was made?",
                    "Choices about resources have people and planet consequences. Year " + y + ".",
                    "need, want, producer, consumer, scarcity, trade-off, sustainability");
            default -> LessonHtml.teach(LessonHtml.phaseLabel(y), "Culture & connections",
                    new String[]{"Name a Pacific or global connection that shapes Aotearoa.", "Describe cultural exchange without treating people as exhibits.", "Use media critically when they portray other places."},
                    LessonHtml.p("Aotearoa is a Pacific nation. Moana Oceania connections (Samoa, Tonga, Cook Islands, Niue, Fiji and others) are family, language, church, sport and history — including New Zealand's own colonial role in the Pacific, which older years should not skip.")
                            + LessonHtml.p("Year " + y + " might study a festival, a migration story, or a trade/tourism link. The point is relationship, not a food day that never names people.")
                            + LessonHtml.p("Global media can stereotype. Compare a tourist advert with a resident's voice."),
                    "Pasifika Language Weeks and Polyfest are cultural production by students and communities — study them as living culture, not as a term-three activity only.",
                    new String[]{"Name the place and the link (whānau, language, trade, sport).", "Listen to an insider voice.", "Note power (who profits, who is named).", "Avoid costumes that mock."},
                    "Connection example", "Auckland–Apia flights, remittances, and rugby are economic and cultural ties.",
                    "Respect", "Learning a greeting in gagana Samoa is a start; claiming expertise after one song is not.",
                    null, "Reducing a whole people to one dance or one dish.", "Ask who is telling the story, and who is paid.",
                    "Aotearoa in the Pacific and the world — relationships with mana. Year " + y + ".",
                    "Pacific, migration, globalisation, media, respect, Moana");
        };
    }

    private static String techTitle(int y, int n) {
        return switch (n) {
            case 1 -> y <= 4 ? "Who is it for? A brief for a real user" : "Design thinking: empathise, ideate, prototype";
            case 2 -> y <= 4 ? "Steps a computer (or a person) can follow" : "Algorithms, data and digital citizenship";
            case 3 -> y <= 4 ? "Choosing materials and making safely" : "Resistant materials, food tech or textiles for purpose";
            case 4 -> y <= 4 ? "Breaking a job into steps" : "Decomposition, debugging and patterns in code";
            case 5 -> y <= 4 ? "Input, process, output in a recipe or machine" : "Systems: electronics, networks or production lines";
            default -> y <= 6 ? "Did it meet the brief? Test with a user" : "Impacts on people, equity and the environment";
        };
    }

    private static String techBody(int y, int n) {
        String strand = switch (n) {
            case 1 -> "Design";
            case 2 -> "Digital";
            case 3 -> "Making";
            case 4 -> "Computational thinking";
            case 5 -> "Systems";
            default -> "Evaluate";
        };
        String meaning = switch (n) {
            case 1 -> "Technology starts with a need, not a gadget. Year " + y + " students name the user, write a brief, sketch more than one idea, and iterate. The first idea is rarely the best.";
            case 2 -> "Digital systems store, process and share information. Algorithms are precise sequences. Digital citizenship in Aotearoa includes not sharing others' images without consent, and knowing the Privacy Act exists even if you do not quote it yet.";
            case 3 -> "Materials have properties (strength, flexibility, food-safety, insulation). Measure twice, cut once. Food technology is still technology: a process that transforms ingredients for a user.";
            case 4 -> "Computational thinking: decomposition (break it down), pattern, abstraction (ignore extra detail), algorithm, debugging. You can do this unplugged with cards before any language like Scratch or Python.";
            case 5 -> "Systems have inputs, processes, outputs and sometimes feedback (a thermostat). A school canteen, a bus network, or a simple circuit can be drawn the same way.";
            default -> "Fitness for purpose beats 'looks cool'. Test with a real user if you can. Impacts: who cannot use this? What waste does it make? Who profits?";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), strand,
                new String[]{"Name the user or the system.", "Describe a process in steps.", n == 6 ? "Judge against the brief and name a next iteration." : "Improve after a test or a bug."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Te ao Māori design values (manaakitanga, kaitiakitanga) can shape a brief: does this outcome look after people and place?")
                        + LessonHtml.p("Year " + y + " outcomes should be safe to make in a classroom — no mains wiring, no unsafe blades without training."),
                "A leaky lunchbox, a school-gate traffic problem, or a bilingual sign that nobody can read are authentic NZ briefs.",
                new String[]{"Write a one-sentence brief.", "Generate two ideas.", "Make a rough prototype or flowchart.", "Test, then change one thing."},
                "Brief", "Keep a Year 2 lunch dry and easy to open with small hands.",
                n == 2 ? "Algorithm" : "Evaluation",
                n == 2 ? "Toast: bread in → set time → start → remove when done. If you skip 'remove', you have a fire risk — precision matters."
                        : "If the brief was 'easy for small hands', a tiny fiddly latch fails even if it looks smart.",
                null, "Decorating first and never testing. Looks are not the brief unless the brief said so.",
                "Iteration is the skill. Keep a photo of version 1 so version 2 is honest.",
                strand + " for a real user, tested, then improved. Year " + y + ".",
                "brief, user, prototype, algorithm, debug, fitness for purpose");
    }

    private static String artsTitle(int y, int n) {
        return switch (n) {
            case 1 -> y <= 4 ? "Line, colour, shape and texture" : "Visual language, composition and media choices";
            case 2 -> y <= 4 ? "Beat, pitch and singing with others" : "Rhythm, melody, dynamics and ensemble";
            case 3 -> y <= 4 ? "Role, body and voice in a simple scene" : "Character, tension and dramatic structure";
            case 4 -> y <= 4 ? "Body shapes, levels and travelling" : "Motif, energy, choreographic devices";
            case 5 -> "Responding with evidence: I notice… because…";
            default -> "Māori, Pacific and NZ arts — see, hear, participate with respect";
        };
    }

    private static String artsBody(int y, int n) {
        String strand = switch (n) {
            case 1 -> "Visual";
            case 2 -> "Music";
            case 3 -> "Drama";
            case 4 -> "Dance";
            case 5 -> "Respond";
            default -> "Arts of Aotearoa";
        };
        String meaning = switch (n) {
            case 1 -> "Visual artists use line, colour, shape, texture, space and value. Year " + y + " experiments with media (pencil, paint, print, digital) and looks closely. Warm colours can feel energetic; contrast draws the eye. Composition is where you put things, not only what you draw.";
            case 2 -> "Music organises sound in time. Beat is the steady pulse; rhythm is the pattern of long and short. Pitch is high/low; dynamics loud/soft. Singing or playing with others requires listening — ensemble is a social skill.";
            case 3 -> "Drama makes meaning with body, voice, space and imagination. Stay in role until the scene ends. 'Yes, and…' keeps a scene alive. Status, pause and where you stand tell the audience who has power.";
            case 4 -> "Dance is movement with purpose. Motif is a movement idea you repeat and vary. Levels (low, middle, high), pathways and energy (sudden/sustained) are elements. Safe dancing means control, space awareness and soft landings.";
            case 5 -> "Responding is describing, interpreting and evaluating with evidence. 'I like it' is a start. 'I notice repeating triangles, which makes the picture feel busy' is a response. Kind, specific feedback helps makers.";
            default -> "Toi Māori, Pacific arts, and Pākehā/tauiwi NZ artists all belong in the classroom. Kapa haka is not a costume party; it has iwi, school and national contexts. Ask permission, name the artist or iwi when known, and do not invent 'Māori designs' by doodling koru without teaching meaning.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), strand,
                new String[]{"Use the language of the art form (line, beat, role, motif…).", "Make or perform with a purpose.", "Respond with a specific observation."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("The arts are knowledge-rich in the NZC, not a break from 'real' subjects. Year " + y + " should both make and respond.")
                        + LessonHtml.p("Looking/listening carefully is a skill — describe before you judge."),
                "A local mural, a school haka, a brass band at ANZAC, or a Pasifika choir are curriculum, not extras.",
                new String[]{"Warm up (voice, body, or seeing).", "Try, then vary one element.", "Share.", "Respond with 'I notice… because…'."},
                "Describe first", "I notice three thick black lines cutting the page — they feel like a fence.",
                "Vary one thing", "Same rhythm, quieter dynamics — the mood changes without new notes.",
                null, "Copying a Māori motif without knowing its meaning or the right to use it.",
                "One precise sentence of response is worth more than 'it's good'.",
                strand + ": make, vary, respond with evidence. Year " + y + ".",
                "line, beat, role, motif, describe, toi, ensemble");
    }

    private static String hpeTitle(int y, int n) {
        return switch (n) {
            case 1 -> y <= 4 ? "Locomotor, stability and object-control skills" : "Specialised movement sequences and game sense";
            case 2 -> "Hauora: taha tinana, hinengaro, whānau, wairua";
            case 3 -> y <= 4 ? "Friendship, sharing and asking for help" : "Consent, communication and healthy relationships";
            case 4 -> y <= 4 ? "Water, road, sun and asking an adult" : "Risk, first aid basics and online safety";
            case 5 -> "Inclusion, fair play and belonging in games and kura";
            default -> y <= 6 ? "Healthy kai, sleep and being active most days" : "Health promotion: changing a setting, not only a person";
        };
    }

    private static String hpeBody(int y, int n) {
        String strand = switch (n) {
            case 1 -> "Movement";
            case 2 -> "Hauora";
            case 3 -> "Relationships";
            case 4 -> "Safety";
            case 5 -> "Community";
            default -> "Health promotion";
        };
        String meaning = switch (n) {
            case 1 -> "Skilled movement is learned. Year " + y + " develops run, jump, throw, catch, balance, and then game sense (when to pass). One cue at a time: 'eyes on the ball'. Fair play is part of the skill, not an extra rule at the end.";
            case 2 -> "Hauora is a Māori model of wellbeing used across NZ HPE: taha tinana (body), taha hinengaro (mind/emotions), taha whānau (relationships), taha wairua (spirit/values). They work together — sleep affects mood; exclusion affects the body. Wellbeing is more than 'not sick'.";
            case 3 -> "Healthy relationships use respect, consent and clear communication. Consent can be withdrawn. Year " + y + " uses age-appropriate examples (asking before a hug or borrowing) and names trusted adults. I-statements: I feel… when… I need…";
            case 4 -> "Notice a hazard, choose a safer option, get help (adult or 111). Water: between the flags, never swim alone. Roads: see and be seen. Sun: slip, slop, slap as taught. Online: people can pretend; do not share images that could harm. Being brave is not the same as an unsafe dare.";
            case 5 -> "Inclusion is a skill. Modify a game so more people can play (smaller ball, walking softball, extra lives). A buddy bench or a multilingual welcome is design for belonging. Whānau and iwi contexts matter — sport is not the only community.";
            default -> "Health promotion changes environments (water fountains, shade, canteen options, anti-bullying processes), not only posters telling individuals to try harder. Year " + y + " can plan a small setting change and say how you would know it worked.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), strand,
                new String[]{"Apply a hauora or safety idea to a real situation.", "Show fair, inclusive behaviour in play or talk.", "Know when to get an adult or call 111."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("HPE in the NZC is four strands historically (personal health, movement, relationships, healthy communities) organised here for Year " + y + " teaching.")
                        + LessonHtml.p("Body comments, food shaming and 'no pain no gain' as humiliation are not acceptable pedagogy."),
                "Ki-o-rahi, waka ama, netball, rugby, kapa haka as physical culture — many ways to move in Aotearoa.",
                new String[]{"Watch a model or cue.", "Practise one focus.", "Include others.", "Reflect with hauora language."},
                "Catching cue", "Eyes on the ball, hands ready, soft hands, bring it in.",
                "Hauora check", "After a hard test: tinana (food, walk), hinengaro (talk), whānau (message home), wairua (what mattered to you today).",
                null, "Forcing a personal story in a circle. Sharing is invited, never extracted.",
                "One cue beats five shouted tips.",
                strand + " with hauora at the centre. Year " + y + ".",
                "hauora, taha, consent, hazard, inclusion, health promotion");
    }

    private static String langTitle(int y, int n) {
        return switch (n) {
            case 1 -> y <= 3 ? "Kia ora, tēnā koe, tēnā koutou — greetings that fit"
                    : y <= 6 ? "Mihi beginnings: greet, name yourself, greet the group"
                    : y <= 8 ? "Formal mihi: people, place and purpose"
                    : "Audience and occasion: mihi, pepeha and public talk";
            case 2 -> y <= 3 ? "Tahi–tekau, colours, kai and classroom kupu"
                    : y <= 6 ? "Word families: numbers, time, kai and classroom"
                    : y <= 8 ? "Building sentences from high-frequency kupu"
                    : "Precise kupu for academic and everyday topics";
            case 3 -> y <= 3 ? "Kei te pēhea koe? Short exchanges you can really say"
                    : y <= 6 ? "Questions and answers you can reuse all day"
                    : y <= 8 ? "Sustained conversation: ask, answer, add a reason"
                    : "Oral texts: interviews, podcasts and classroom debate";
            case 4 -> y <= 3 ? "Reading labels, signs, waiata lines and simple sentences"
                    : y <= 6 ? "Dual-language texts: gist, then key kupu"
                    : y <= 8 ? "Reading short authentic notices and waiata"
                    : "Reading longer te reo and bilingual non-fiction";
            case 5 -> y <= 3 ? "Writing or performing a caption, greeting or waiata line"
                    : y <= 6 ? "A short mihi, comic or classroom dialogue"
                    : y <= 8 ? "Crafting a paragraph or performance in te reo"
                    : "Publishing a short text for a real audience";
            default -> y <= 6 ? "Tikanga: pōwhiri, manaakitanga, and using te reo with respect"
                    : "Language and tikanga together — mana, occasion, audience";
        };
    }

    private static String langBody(int y, int n) {
        String strand = switch (n) {
            case 1 -> "Greetings";
            case 2 -> "Vocabulary";
            case 3 -> "Oral";
            case 4 -> "Literacy";
            case 5 -> "Creating";
            default -> "Tikanga";
        };
        String meaning = switch (n) {
            case 1 -> "Kia ora is a friendly greeting. Tēnā koe greets one person more formally; tēnā kōrua two; tēnā koutou a group. Macrons change meaning (keke cake vs kēkē armpit — a famous classroom warning). Year " + y + " practises the greeting loop: greet, introduce, respond.";
            case 2 -> "High-frequency kupu: numbers tahi–tekau, colours, kai, whānau words, classroom objects (pukapuka, pene). A word you can put in a sentence the same day is a word you own. Waiata recycle vocabulary.";
            case 3 -> "You will understand more than you can say. Listen for a key word, repeat a model, swap one word. Kei te pai; kei te ngenge. Mistakes are data. Fluency grows from trying, not from waiting to be perfect.";
            case 4 -> "Print supports oral language: signs, dual-language books, labels on the tēpu. You do not need every word to get the gist. Read aloud to hear vowel sounds — Māori vowels are more consistent than English ones.";
            case 5 -> "Create a tiny text: a caption, a two-line mihi, a comic speech bubble, a waiata verse with known kupu. Accuracy of a few words beats a long Google-translated paragraph you cannot pronounce.";
            default -> "Language and culture travel together. Tikanga (kawa of a marae, removing shoes, not sitting on tables, karakia as practised in your community) has purpose. Using te reo as a joke or a football chant without meaning can strip mana. Keep learning both language and tikanga.";
        };
        return LessonHtml.teach(LessonHtml.phaseLabel(y), strand,
                new String[]{"Use at least one accurate phrase in te reo Māori.", "Pronounce macron vowels carefully.", "Show respect for tikanga attached to the language."},
                LessonHtml.p(meaning)
                        + LessonHtml.p("Te reo Māori is an official language. Learning Languages in the NZC also includes other additional languages your school offers (French, Japanese, Samoan…). The habits — listen, repeat, respect — transfer.")
                        + LessonHtml.p("Year " + y + " success is a short, true sentence you can say to a person, not a worksheet of isolated words only."),
                "Use the language of this place. Even one greeting done well is citizenship.",
                new String[]{"Listen to a model.", "Repeat.", "Swap one word to make it yours.", "Use it the same day in a real greeting."},
                "Tēnā koe vs kia ora", "Tēnā koe for one person, slightly more formal; kia ora widely friendly. Match the situation.",
                "Numbers 1–5", "Tahi, rua, toru, whā, rima. Say them while counting objects on the table.",
                null, "Copying a mihi from the internet that belongs to another iwi as if it were yours.",
                "Five words in sentences beat twenty words in a list you cannot use.",
                "Greet, recycle kupu, respect tikanga. Year " + y + ".",
                "kia ora, tēnā koe, kupu, macron, tikanga, manaakitanga");
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

    private static String figureFor(String kind) {
        return switch (kind) {
            case "IDENTITY" -> SubjectFigures.identityPlaces(
                    "Maunga and awa locate a person in place — a pepeha names those connections.");
            case "PLACE" -> SubjectFigures.mapKey(
                    "Read the key before you guess what a colour or shape means.");
            case "HISTORY" -> SubjectFigures.timeline(
                    "Time order first: voyaging, Te Tiriti in 1840, then today.");
            case "ECONOMY" -> SubjectFigures.needsWants(
                    "A need keeps you alive. A want is an extra you can live without.");
            case "CIVICS" -> SubjectFigures.civicRules(
                    "Rights and responsibilities travel together.");
            case "DESIGN", "EVALUATE", "MAKING", "DIGITAL", "COMPUTE" -> SubjectFigures.designBrief(
                    "User, problem, idea — then test and improve.");
            case "VISUAL", "RESPOND" -> SubjectFigures.designBrief(
                    "Notice an element first: line, colour, shape or texture.");
            case "MUSIC" -> SubjectFigures.musicNotes("Beat, pitch and dynamics are things you can point to.");
            case "DRAMA", "DANCE" -> SubjectFigures.moveSkill("Body and voice tell the story. Stay in role.");
            case "MOVE" -> SubjectFigures.moveSkill("Eyes on the ball. Hands ready. Soft catch.");
            case "HAUORA", "RELATE", "COMMUNITY" -> SubjectFigures.hauoraTaha(
                    "Hauora is four taha together, not only ‘not being sick’.");
            case "SAFETY" -> SubjectFigures.safetyFlags("Between the flags. Never swim alone.");
            case "GREETINGS", "WORDS", "LISTEN", "READLANG", "TIKANGA" -> SubjectFigures.greetingKiaOra(
                    "Kia ora is a friendly hello. Tēnā koe greets one person.");
            default -> SubjectFigures.mapKey("Start with a picture of the idea, then the words.");
        };
    }
}
