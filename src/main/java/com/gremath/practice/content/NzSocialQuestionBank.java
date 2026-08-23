package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.curriculum.SubjectFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/**
 * Distinct social-sciences stems with diagrams and per-item hints that never state the answer.
 */
final class NzSocialQuestionBank {

    private NzSocialQuestionBank() {
    }

    static QuestionTemplate[] identity(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "A pepeha often names a mountain and a river. Those places show…"
                                                : "Maunga and awa in a pepeha are mainly about…",
                                        SubjectFigures.identityPlaces("Place names locate a person in whenua.")),
                                word ? "connection to place and people" : "connections to people and places",
                                "Identity sits in land and relationships, not only a favourite colour.",
                                "EASY", tag(word, "visual pattern"),
                                "only a favourite colour", "a bank PIN", "a sports score"),
                        "Ask which layer of belonging the picture names: mountain, river, people."),
                rng -> hint(QBuilder.build(rng, "Culture is…",
                                "Lived practices, languages and values of a group of people",
                                "Everyday life, not only holidays.",
                                "MEDIUM", "skill-check",
                                "Only food on holidays", "The same as climate", "A type of map"),
                        "List ordinary things people do and believe — not just a festival photo."),
                rng -> hint(QBuilder.build(rng, "Respecting someone's identity includes…",
                                "Using their correct name and listening to their story",
                                "Names and listening matter.",
                                "EASY", "skill-check",
                                "Ignoring them", "Changing their name without asking", "Speaking over them"),
                        "Start with the name they use and the story they choose to share."),
                rng -> hint(QBuilder.build(rng, year <= 3
                                        ? "Whānau, class and a sports team are all examples of…"
                                        : "A stereotype is harmful because it…",
                                year <= 3 ? "groups you can belong to" : "treats a whole group as if they were all the same",
                                year <= 3 ? "Belonging has many layers." : "One story cannot stand for everyone.",
                                "MEDIUM", "skill-check",
                                year <= 3 ? "types of weather" : "celebrates every person’s own story",
                                year <= 3 ? "map keys only" : "is the same as a pepeha",
                                year <= 3 ? "bank PINs" : "is only about climate"),
                        year <= 3
                                ? "Name the group and how it helps someone feel they belong."
                                : "If one label is glued onto everyone, someone’s real story got erased."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A new student can share a respectful introduction without a Māori pepeha by…"
                                        : "Not every learner will have a Māori pepeha. Everyone can still…",
                                word ? "naming people and places that matter to them, if they wish"
                                        : "practise a respectful introduction that names places that matter to them",
                                "Identity is invited, not forced.",
                                "MEDIUM", tag(word),
                                "copying someone else’s iwi without asking", "demanding private family facts", "inventing a PIN as a name"),
                        "Invitation, not interrogation. People choose what they share."),
                rng -> hint(QBuilder.build(rng, "Language is part of identity because it…",
                                "carries stories, humour and ways of seeing the world",
                                "Words are not only labels.",
                                "MEDIUM", "skill-check",
                                "is only a spelling test", "never belongs to a people", "is the same as climate"),
                        "Ask what a language lets people say about who they are."),
                rng -> hint(QBuilder.build(rng, "Diversity in a class means people…",
                                "bring different stories, languages and experiences",
                                "Difference is ordinary.",
                                "EASY", "skill-check",
                                "must all like the same food", "cannot have names", "share one identical history"),
                        "Look for more than one story in the room — that is diversity."),
                rng -> hint(QBuilder.build(rng, year >= 7
                                        ? "A national identity story can leave people out when it…"
                                        : "Personal identity is different from group identity because it…",
                                year >= 7 ? "tells only one group’s version as if it were everyone’s"
                                        : "is the story of one person, not the whole group",
                                year >= 7 ? "Ask whose voice is centred." : "Layers: me, then the groups I belong to.",
                                "HARD", "skill-check",
                                year >= 7 ? "includes many voices on purpose" : "is always a map key",
                                year >= 7 ? "is only about weather" : "cannot include family",
                                year >= 7 ? "never uses dates" : "is a bank PIN"),
                        year >= 7
                                ? "Ask who is named as ‘we’ and who is missing from that ‘we’."
                                : "‘I’ is not automatically ‘everyone in my iwi / class / country’."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "If a classmate’s name is hard for you to say, a respectful next step is to…"
                                        : "Listening to someone’s story first helps because…",
                                word ? "practise it and ask them to say it again" : "you hear how they name themselves",
                                "Effort shows respect.",
                                "EASY", tag(word),
                                word ? "give them a nickname they did not choose" : "you can overwrite their name",
                                "ignore the macrons on purpose", "speak over them"),
                        "The owner of the name is the expert. Ask, listen, try again."),
                rng -> hint(QBuilder.build(rng, "Faith, sport, hapū and class can all shape identity. The careful habit is to…",
                                "let people name their own groups",
                                "Do not assign a label they reject.",
                                "MEDIUM", "skill-check",
                                "guess and announce it to the class", "use a stereotype as a shortcut", "copy a PIN"),
                        "Wait for the person to say which groups they claim.")
        };
    }

    static QuestionTemplate[] place(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "A visitor reads this key before walking the reserve. The green circle stands for…"
                                                : "On this map key, the green circle means…",
                                        SubjectFigures.mapKey("Always read the key before the colours.")),
                                "forest",
                                "The key, not a guess from a pretty colour.",
                                "EASY", tag(word, "visual pattern"),
                                "lake", "a motorway", "tomorrow’s lunch"),
                        "Match the symbol on the key to the word beside it. Do not invent a meaning."),
                rng -> hint(QBuilder.build(rng, "A natural feature is…",
                                "A mountain, river or forest",
                                "Not human-built.",
                                "EASY", "skill-check",
                                "A motorway", "A shopping mall", "A rugby stadium"),
                        "Ask: did people build it, or was it already part of the whenua?"),
                rng -> hint(QBuilder.build(rng, "Aotearoa New Zealand has a very long…",
                                "Coastline",
                                "Islands in the Pacific.",
                                "MEDIUM", "skill-check",
                                "Sahara desert border", "Land border with Brazil", "Underground subway in every town"),
                        "Picture the islands in the ocean. The edge that meets the sea is the coast."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "People drain a wetland to build houses. That is an example of…"
                                        : "A built feature is…",
                                word ? "people changing a place" : "something people constructed, like a road or marae",
                                "Places are physical and human.",
                                "MEDIUM", tag(word),
                                word ? "a weather measurement only" : "a river that no person shaped",
                                "a type of fraction", "a food chain"),
                        word
                                ? "Name what the land was, then what people did to it."
                                : "If people poured concrete or raised a building, it is built."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "North on a map is usually toward the…"
                                        : "A map scale is useful because it…",
                                year <= 4 ? "top of the map (unless the compass rose says otherwise)"
                                        : "lets you convert a map length into a real distance",
                                year <= 4 ? "Check the compass rose." : "Scale is a ratio.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "always the bottom-left corner" : "tells you the author’s favourite book",
                                year <= 4 ? "the colour blue only" : "replaces the need for a key",
                                year <= 4 ? "a food chain" : "measures only temperature"),
                        year <= 4
                                ? "Find the compass rose first. Do not assume without checking."
                                : "Measure on the map, then use the scale sentence to find the real km."),
                rng -> hint(QBuilder.build(rng, "Urban and rural places differ mainly in…",
                                "how densely people live and the kinds of work and services",
                                "City and countryside patterns.",
                                "MEDIUM", "skill-check",
                                "whether gravity works", "whether the Sun rises", "whether maps are illegal"),
                        "Think houses-per-hectare, jobs and services — not whether the place ‘has weather’."),
                rng -> hint(QBuilder.build(rng, "A lake on a map is a…",
                                "natural water feature (unless the key says reservoir)",
                                "Read the key if it might be human-made.",
                                "EASY", "skill-check",
                                "motorway", "shopping mall", "bank PIN"),
                        "Water body first. Then check whether people dammed it."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "Sustainability in a place means using resources so that…"
                                        : "A river (awa) is a natural feature that…",
                                year >= 6 ? "people now and later can still meet their needs"
                                        : "shapes the land and can be a taonga for iwi",
                                year >= 6 ? "Now and later, not only now." : "Water, land and people connect.",
                                "HARD", "skill-check",
                                year >= 6 ? "the next generation gets nothing" : "is always a motorway",
                                year >= 6 ? "maps become illegal" : "cannot appear on a pepeha",
                                year >= 6 ? "climate stops existing" : "is a type of stadium"),
                        year >= 6
                                ? "Ask whether tomorrow’s people still have the resource."
                                : "Name what the river does for land and for people."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A tramp map without a key is hard to use because…"
                                        : "The first thing to read on an unfamiliar map is the…",
                                word ? "you cannot be sure what the symbols mean" : "key (legend) and the compass rose",
                                "Key before colour guesses.",
                                "EASY", tag(word),
                                word ? "north is illegal" : "author’s favourite novel",
                                "lunch menu", "who won a game"),
                        "Key and north arrow unlock the rest of the map."),
                rng -> hint(QBuilder.build(rng, "Pacific neighbours matter to Aotearoa because of…",
                                "ocean, migration, language and shared histories",
                                "We are a Pacific nation.",
                                "MEDIUM", "skill-check",
                                "a land border with Brazil", "the Sahara being next door", "the complete absence of coastline"),
                        "Think ocean routes and people movement, not a desert border.")
        };
    }

    static QuestionTemplate[] history(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Which mark on this line is the year Te Tiriti was first signed?"
                                                : "Putting events in time order is called…",
                                        SubjectFigures.timeline("c. 1250 voyaging, 1840 Te Tiriti, then today.")),
                                word ? "1840" : "Sequencing (chronology)",
                                word ? "Read the year under the mark." : "Then and now need an order.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "today" : "Rhyming",
                                word ? "c. 1250 only" : "Measuring mass",
                                "Coding"),
                        word
                                ? "Match the date the question names to the label under a dot."
                                : "Chronology is the queue of dates — earliest on the left here."),
                rng -> hint(QBuilder.build(rng, "The Treaty of Waitangi / Te Tiriti o Waitangi was first signed in…",
                                "1840",
                                "A founding document of Aotearoa New Zealand.",
                                "MEDIUM", "skill-check",
                                "2010", "1066", "1770 only in Australia"),
                        "Hold the century in your head: mid-1800s, not medieval Europe and not last decade."),
                rng -> hint(QBuilder.build(rng, "A good historian asks…",
                                "Whose voice is in this source, and whose is missing?",
                                "Sources are partial.",
                                "MEDIUM", "skill-check",
                                "Is this the longest paragraph?", "What colour is the page?", "Can I skip evidence?"),
                        "Name the speaker, the date, and who never got to speak."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "Then-and-now photos of a street help you see…"
                                        : "A primary source is usually…",
                                year <= 4 ? "what changed and what stayed" : "something made at the time you are studying",
                                year <= 4 ? "Continuity and change." : "A letter from 1840, not a 2020 textbook about 1840.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "only the weather on Mars" : "always a textbook written yesterday",
                                year <= 4 ? "a type of fraction" : "a sports score with no date",
                                year <= 4 ? "bank PINs" : "the colour of the classroom wall"),
                        year <= 4
                                ? "Point to one thing that is new and one thing that is still there."
                                : "Ask when the source was made. ‘At the time’ is primary."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Māori ancestors reached Aotearoa by waka. On a timeline that voyaging sits…"
                                        : "c. 1250 on a New Zealand timeline usually marks…",
                                word ? "centuries before 1840" : "early Māori settlement (voyaging period)",
                                "Voyaging is earlier than Te Tiriti.",
                                "MEDIUM", tag(word),
                                word ? "after today" : "the invention of the smartphone",
                                "the same year as 2010", "a type of climate only"),
                        "c. means about. Place it left of 1840 on a left-to-right timeline."),
                rng -> hint(QBuilder.build(rng, "Two accounts of the same event can disagree because…",
                                "people stood in different places and had different purposes",
                                "History is argued from evidence, not one slogan.",
                                "HARD", "skill-check",
                                "dates are illegal", "maps cannot exist", "only one person ever lived"),
                        "Ask what each writer wanted the reader to believe."),
                rng -> hint(QBuilder.build(rng, "Using a slogan instead of a date and a source is a weak history habit because…",
                                "claims need evidence you can check",
                                "A catchphrase is not a footnote.",
                                "EASY", "skill-check",
                                "slogans are the only legal evidence", "dates confuse everyone", "sources are never useful"),
                        "Swap the slogan for a who / when / what-document sentence."),
                rng -> hint(QBuilder.build(rng, year >= 7
                                        ? "Colonisation in Aotearoa is best studied by…"
                                        : "A community ‘then and now’ study should include…",
                                year >= 7 ? "comparing Māori and Crown actions, Te Tiriti texts, and later consequences"
                                        : "what people remember and what sources show",
                                year >= 7 ? "More than one archive." : "Memory plus evidence.",
                                "HARD", "skill-check",
                                year >= 7 ? "ignoring Te Tiriti as irrelevant" : "only the colour of a page",
                                year >= 7 ? "using only a sports score" : "skipping all photos",
                                year >= 7 ? "skipping dates" : "a bank PIN"),
                        year >= 7
                                ? "Hold several sources together: texts, land, and later effects."
                                : "Pair a memory with something you can point to (photo, map, object)."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Why might a museum label and an iwi oral history differ?"
                                        : "Oral history is valuable because it…",
                                word ? "They can emphasise different people and purposes"
                                        : "carries knowledge that was spoken and remembered",
                                "Different forms, both evidence if you ask questions of them.",
                                "MEDIUM", tag(word),
                                word ? "Oral history is never allowed" : "replaces the need for any date",
                                "Museums never have a point of view", "Timelines are illegal"),
                        "Ask who made each account and what they wanted remembered."),
                rng -> hint(QBuilder.build(rng, "Chronology helps you because…",
                                "cause and effect only make sense in time order",
                                "Later events cannot cause earlier ones.",
                                "EASY", "skill-check",
                                "rhyming is the same skill", "mass is measured in years", "coding replaces dates"),
                        "Put the cards in date order before you tell the story of why.")
        };
    }

    static QuestionTemplate[] economy(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Which card is a need you must have to live?"
                                                : "A need is something…",
                                        SubjectFigures.needsWants("Needs keep you alive. Wants are extras.")),
                                word ? "food" : "You must have to live, like food or shelter",
                                "Needs vs wants.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "the game" : "You want for fun only",
                                "That is always a video game", "That cannot be used"),
                        "Ask: would someone be unsafe or unwell without it?"),
                rng -> hint(QBuilder.build(rng, "A producer is someone who…",
                                "Makes or grows goods or provides a service",
                                "Producer → consumer.",
                                "EASY", "skill-check",
                                "Only watches TV", "Hides resources", "Never works"),
                        "Name the job: grow, make, or serve. That person is a producer."),
                rng -> hint(QBuilder.build(rng, "Using a resource carefully because it can run out is part of…",
                                "Sustainability",
                                "People and planet.",
                                "MEDIUM", "skill-check",
                                "Ignoring waste", "Using everything as fast as possible", "Never sharing ideas"),
                        "If it can run out, the careful question is how to leave some for later."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A dairy farmer sells milk and a café sells hot chocolate. The café is mainly a…"
                                        : "A consumer is someone who…",
                                word ? "consumer of milk (and a producer of drinks)" : "uses goods or services",
                                "Roles can stack.",
                                "MEDIUM", tag(word),
                                word ? "a type of climate" : "hides every resource",
                                "never uses anything", "a map key only"),
                        "Follow the milk: who makes it, who buys it, who changes it into something else."),
                rng -> hint(QBuilder.build(rng, "Trade happens when people…",
                                "exchange goods or services because they cannot make everything themselves",
                                "Exchange solves ‘I have this, you have that’.",
                                "EASY", "skill-check",
                                "refuse to share any idea ever", "delete all maps", "stop using resources"),
                        "Each side gives something and gets something."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "A teacher, a bus driver and a nurse all provide a…"
                                        : "Scarcity means…",
                                year <= 4 ? "service" : "there is not enough of a resource for every want",
                                year <= 4 ? "Services are work you cannot hold." : "Choices appear when stuff is limited.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "type of rock" : "everything is unlimited",
                                year <= 4 ? "map north" : "needs and wants are the same word",
                                year <= 4 ? "climate only" : "trade is illegal"),
                        year <= 4
                                ? "If you cannot put it in a bag, it may still be work — a service."
                                : "If everyone cannot have all they want, someone must choose."),
                rng -> hint(QBuilder.build(rng, "Recycling and repairing are economic habits because they…",
                                "keep materials in use and reduce waste",
                                "Less take, more care.",
                                "EASY", "skill-check",
                                "make resources vanish faster on purpose", "ban all jobs", "remove the idea of needs"),
                        "Ask what happens to the material next — bin, or another use."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "An imported good travelled from another country. A local good…"
                                        : "Money is useful in trade because it…",
                                year >= 6 ? "was made or grown closer to home" : "is a widely accepted way to pay, so barter is not required",
                                year >= 6 ? "Distance is part of the story." : "A common go-between.",
                                "MEDIUM", "skill-check",
                                year >= 6 ? "cannot be food" : "is the same as climate",
                                year >= 6 ? "is always a river" : "cannot buy a service",
                                year >= 6 ? "has no producer" : "replaces all needs"),
                        year >= 6
                                ? "Ask where it was made, then how far it travelled."
                                : "Money lets you trade without swapping a fish for a haircut directly."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A family chooses rice instead of a new game because food is a…"
                                        : "When wants clash with a small budget, people…",
                                word ? "need" : "prioritise some wants and go without others",
                                "Budgets force an order.",
                                "HARD", tag(word),
                                word ? "want only" : "can buy every want at once",
                                "type of map", "type of force"),
                        "Needs usually jump the queue when money is short."),
                rng -> hint(QBuilder.build(rng, "Looking after a shared resource (a beach, a forest) is part of…",
                                "kaitiakitanga / guardianship and sustainable use",
                                "Care now so it remains.",
                                "MEDIUM", "skill-check",
                                "using it up as fast as possible", "pretending it has no people", "banning all maps"),
                        "Shared places need rules and care, not only ‘take more’.")
        };
    }

    static QuestionTemplate[] civics(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "A fair classroom treaty should balance…"
                                                : "Rights work best when people also accept…",
                                        SubjectFigures.civicRules("Rights and duties travel together.")),
                                word ? "rights and responsibilities" : "Responsibilities to others",
                                "Rights + duties.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "only one person’s wishes" : "No duties at all",
                                "A secret rule with no purpose", "Silence forever"),
                        "If someone has a right, ask what duty sits beside it."),
                rng -> hint(QBuilder.build(rng, "A fair classroom rule should…",
                                "Help people stay safe and be able to learn",
                                "Rules have purposes.",
                                "EASY", "skill-check",
                                "Help only one person", "Be a secret", "Change every minute with no reason"),
                        "Name who is kept safe or able to learn. If you cannot, the rule is shaky."),
                rng -> hint(QBuilder.build(rng, "A citizen can participate by…",
                                "Voting, volunteering or speaking up about an issue",
                                "Participation is action.",
                                "MEDIUM", "skill-check",
                                "Never noticing problems", "Breaking rules for fun", "Hiding from the community"),
                        "List a real action: vote, help, speak — not ‘ignore’."),
                rng -> hint(QBuilder.build(rng, year <= 4
                                        ? "Class voting is practice for…"
                                        : "Parliament makes laws. A citizen’s job includes…",
                                year <= 4 ? "having a say and accepting a group decision" : "knowing the law and using legal ways to change it",
                                year <= 4 ? "Voice plus fairness." : "Know, follow, and campaign within the rules.",
                                "MEDIUM", "skill-check",
                                year <= 4 ? "keeping the result a secret from the class" : "only breaking laws for fun",
                                year <= 4 ? "letting one person decide every time in secret" : "never noticing an issue",
                                year <= 4 ? "banning all rules" : "hiding from every vote"),
                        year <= 4
                                ? "A vote is a turn-taking tool, not a way to silence the minority forever."
                                : "Changing a law still uses the law’s own pathways."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "A local council decision about a playground affects…"
                                        : "Local government is the level that often decides…",
                                word ? "families who use that park" : "parks, rubbish and local roads",
                                "Scale: local issues, local decision.",
                                "MEDIUM", tag(word),
                                word ? "only a country on the other side of the world" : "the motion of the planets",
                                "only the colour of the Sun", "whether gravity exists"),
                        "Ask who lives near the decision and uses the place."),
                rng -> hint(QBuilder.build(rng, "In a disagreement, a civic habit is to…",
                                "listen, give a reason, and stay respectful",
                                "Disagreement is allowed; contempt is not the lesson.",
                                "EASY", "skill-check",
                                "shout until others stop talking", "hide the rule that applies", "invent a secret law"),
                        "Reasons plus listening. Volume is not a source."),
                rng -> hint(QBuilder.build(rng, "Laws are different from class rules mainly because they…",
                                "apply more widely and are made through government processes",
                                "Scale and process.",
                                "HARD", "skill-check",
                                "never have a purpose", "are always secret", "only apply to one desk"),
                        "Ask how far the rule reaches and who officially made it."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "Active citizenship includes noticing an unfair rule and then…"
                                        : "A secret rule that nobody can know is unfair because…",
                                year >= 6 ? "using peaceful, legal ways to argue for change"
                                        : "people cannot follow a rule they were never told",
                                year >= 6 ? "Voice plus process." : "Fairness needs publicity.",
                                "MEDIUM", "skill-check",
                                year >= 6 ? "breaking it secretly for fun only" : "secrets make rules stronger",
                                year >= 6 ? "ignoring everyone affected" : "nobody needs safety",
                                year >= 6 ? "never voting" : "learning is optional for rules"),
                        year >= 6
                                ? "Name a legal pathway: petition, vote, meeting — not sabotage as the first tool."
                                : "A rule you cannot hear is a trap, not guidance."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Why might a class treaty be written together rather than by one person?"
                                        : "Who is affected is a civic question because…",
                                word ? "More people can own the rules and see they are fair"
                                        : "decisions land on real people, not only on a page",
                                "Consent and impact.",
                                "MEDIUM", tag(word),
                                word ? "so the rules can stay secret" : "impact never matters",
                                "so only one person is safe", "so learning stops"),
                        "The people who must live under a rule should help shape it."),
                rng -> hint(QBuilder.build(rng, "Rights (like being heard) come with the duty to…",
                                "let others be heard too",
                                "Your turn, then theirs.",
                                "EASY", "skill-check",
                                "silence everyone else", "hide from the group", "change names without asking"),
                        "If you claim a right, give the same right to the next person.")
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
