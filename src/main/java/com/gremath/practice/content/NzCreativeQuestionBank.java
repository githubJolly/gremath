package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.curriculum.SubjectFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/** Technology, arts, HPE and languages — varied stems, diagrams, unique hints. */
final class NzCreativeQuestionBank {

    private NzCreativeQuestionBank() {
    }

    static QuestionTemplate[] design(int year, boolean word) {
        return eight(
                fig(word, "A design brief should name…", "the user and the problem to solve",
                        SubjectFigures.designBrief("User, problem, then ideas."),
                        "Start with people.", "only the colours you like", "a random object with no purpose", "the longest word",
                        "Write who it is for and what is broken before you sketch."),
                q("Improving a design after testing is called…", "iteration",
                        "First idea is rarely best.", "giving up", "copying without thinking", "hiding the brief",
                        "Test, change one thing, test again."),
                q("Why sketch more than one idea?", "so you can compare and choose a better fit for the user",
                        "Options help.", "to waste paper only", "because one idea is illegal", "sketches are never useful",
                        "Three rough ideas beat one precious drawing you will not change."),
                q(year <= 4 ? "A good first question is…" : "Success criteria should be…",
                        year <= 4 ? "Who will use this and what must it do?" : "checkable, not only ‘look nice’",
                        "Users first.", year <= 4 ? "What is my favourite colour?" : "secret from the user",
                        "How long is the title?", "Can I skip the problem?",
                        "If you cannot tick it, it is not a criterion."),
                q("A prototype is…", "an early model made to test and learn",
                        "Learning object.", "the final unused idea", "a rule you must never change", "a type of graph",
                        "Make it rough on purpose so you dare to change it."),
                q(word ? "If Year 2 hands cannot work the latch, the design fails because it is not…"
                        : "Materials should be chosen because they…",
                        word ? "fit for the intended user" : "match the job (strong, waterproof, light…)",
                        "Fit for purpose.", word ? "painted gold" : "look expensive only",
                        "heavy enough", "from a famous brand",
                        "Name the user and the job. Then pick the material."),
                q("Feedback is useful when it is…", "specific and names a next change",
                        "Because…", "only ‘I like it’", "rude and vague", "copied from a random site",
                        "Say what to change and why."),
                q("Technology in the NZC starts with…", "people and a problem, not a gadget first",
                        "Need before app.", "the newest phone only", "skipping users", "hiding the brief",
                        "Ask who hurts if this is not solved.")
        );
    }

    static QuestionTemplate[] digital(int year, boolean word) {
        return eight(
                q("An algorithm is…", "a clear sequence of steps to complete a task",
                        "Step-by-step.", "a type of fruit", "a random guess", "a musical instrument",
                        "If a robot followed it, would it finish the job?"),
                q("A kind digital citizen would…", "be respectful and protect personal information",
                        "Safety and kindness.", "share a classmate's password", "post unkind comments", "click every unknown link",
                        "Names, photos and passwords stay private."),
                q("Computers follow instructions…", "exactly as written, even if there is a mistake",
                        "Be precise.", "by reading minds", "only on Tuesdays", "by ignoring bugs",
                        "The computer does what you typed, not what you meant."),
                q(word ? "If a website asks for your address, you should…" : "A password should be…",
                        word ? "check with a trusted adult before sharing" : "long, secret, and not your name",
                        "Ask first.", word ? "type it because the site looks colourful" : "your pet’s name on a sticker",
                        "post it in a chat", "reuse a friend’s login",
                        "Adult first. Never trade a password for a game item."),
                q("Debugging means you…", "find the mistake and change one thing at a time",
                        "Patient fixes.", "rewrite everything with no test", "blame the computer’s feelings", "delete the brief",
                        "Change one line, then run it again."),
                q("Online, a safer choice is to…", "keep personal details private and tell an adult about unkind contact",
                        "Digital safety.", "share your address with strangers", "click every pop-up", "use a friend’s password",
                        "If a message feels weird, show an adult — do not reply alone."),
                q(year >= 6 ? "A search result at the top is…" : "An icon on a screen is useful when it…",
                        year >= 6 ? "not automatically the truest source" : "matches a job you recognise",
                        "Rank ≠ truth.", year >= 6 ? "always written by a teacher" : "is a random scribble",
                        "proof you can skip the date", "a reason to share your PIN",
                        year >= 6 ? "Ask who wrote it and when." : "Match the picture to the job."),
                q("Decomposition in computing is…", "breaking a big task into smaller steps",
                        "A computational thinking skill.", "ignoring the task", "memorising a poem only", "painting",
                        "List tiny jobs. Solve one tiny job.")
        );
    }

    static QuestionTemplate[] making(int year, boolean word) {
        return eight(
                q("You need a waterproof cover. A sensible material is…", "plastic or coated fabric",
                        "Match property to purpose.", "tissue paper", "open weave cotton only", "dry sand",
                        "Will water get through? That is the test."),
                q("A safe making habit is…", "use tools as taught and tidy the workspace",
                        "Safety first.", "run with scissors", "leave spills", "ignore instructions",
                        "Tools stay how the teacher showed. Floor stays clear."),
                q("Measuring before you cut helps because…", "a wrong length wastes material",
                        "Measure twice.", "rulers are illegal", "guessing is always faster and better", "glue replaces length",
                        "Mark, check, then cut."),
                q(word ? "A joint that keeps falling apart needs…" : "A prototype can be made of…",
                        word ? "a stronger join or a different method" : "card, scrap or cheap stuff you can change",
                        "Fix the join.", word ? "more paint only" : "only gold",
                        "hiding the brief", "never testing",
                        "If it fails, change the join — not only the colour."),
                q("Finish quality means…", "edges and surfaces are safe and match the brief",
                        "Look and feel.", "leaving splinters", "hiding sharp bits with stickers only", "skipping sanding on wood",
                        "Run a finger (carefully) — would a user get hurt?"),
                q("When you choose a tool you should first ask…", "what job it does and how to hold it safely",
                        "Right tool.", "which is shiniest", "which is heaviest", "whether you can run with it",
                        "Name the job, then the tool that matches."),
                q("Recycling offcuts is part of…", "caring for materials and reducing waste",
                        "Kaitiakitanga of stuff.", "throwing everything away first", "hiding the brief", "skipping the user",
                        "Keep usable bits. Bin only what cannot be used."),
                q("A labelled diagram of your make should show…", "parts, materials and how they join",
                        "Others can rebuild it.", "only a scribble of your name", "the lunch menu", "a secret code",
                        "Arrows + names. Someone else should understand it.")
        );
    }

    static QuestionTemplate[] compute(int year, boolean word) {
        return eight(
                q("In a system, flour, mixing and a cake are examples of…", "input, process and output",
                        "IPO model.", "three random nouns", "only outputs", "only inputs",
                        "What goes in, what happens, what comes out."),
                q("When code does not work, you should…", "find the bug and change one thing at a time",
                        "Debug patiently.", "rewrite everything at once with no test", "blame the computer's feelings", "delete the brief",
                        "One change, then test."),
                q("A loop is useful when you…", "need the same step repeated",
                        "Repeat without rewriting.", "want to stop the program forever", "hide the input", "delete the output",
                        "Ask: what repeats, and when does it stop?"),
                q(word ? "A branching decision in a game is like…" : "True/false in a program is a…",
                        word ? "if the player has the key, open the door" : "condition",
                        "If / then.", word ? "always opening every door" : "type of fruit",
                        "a random colour", "the author’s age",
                        "Name the yes-path and the no-path."),
                q("A system has parts that…", "work together toward a purpose",
                        "Parts + purpose.", "never connect", "are only decorations", "cannot have an output",
                        "If you remove a part, what stops working?"),
                q("An input device example is a…", "keyboard or sensor that sends data in",
                        "Into the system.", "speaker only", "printer only", "the finished cake only",
                        "Does it send information in, or show a result out?"),
                q(year >= 6 ? "A variable in code stores…" : "Following steps in order is…",
                        year >= 6 ? "a value that can change while the program runs" : "a sequence / algorithm",
                        "Name it, then change it.", year >= 6 ? "only the programmer’s birthday" : "a random jumble",
                        "a type of paint", "the room number",
                        year >= 6 ? "A box with a name, holding a number or word." : "Do step 1, then 2, then 3."),
                q("Testing a program means you…", "try normal and unexpected inputs",
                        "Break it on purpose, kindly.", "only click the happy path once", "never record a bug", "hide the brief",
                        "What if they type 0? What if they click twice?")
        );
    }

    static QuestionTemplate[] evaluate(int year, boolean word) {
        return eight(
                q("To judge a product you should first…", "re-read the brief and success criteria",
                        "Fit for purpose.", "only check if it looks fashionable", "ask a stranger's favourite colour", "ignore the user",
                        "Tick the brief, not your mood."),
                q("A useful evaluation names…", "one strength and one next improvement",
                        "Specific feedback.", "nothing at all", "only insults", "a random number",
                        "Keep + change. Both."),
                q(word ? "If a latch is too fiddly for Year 2 hands, it fails because it is not…"
                        : "Impact on people or the environment should be…",
                        word ? "fit for the intended user" : "named honestly in the evaluation",
                        "Users and planet.", word ? "painted gold" : "hidden if it looks bad",
                        "heavy enough", "from a famous brand",
                        "Who is helped, who is harmed, what waste is left?"),
                q("Comparing two ideas is fairer when you…", "use the same criteria for both",
                        "Same ruler.", "change the rules mid-way", "only keep your favourite", "ignore the user",
                        "Write the criteria first. Then score both."),
                q("A survey of users is useful because…", "you hear whether the design actually works for them",
                        "Evidence, not hope.", "you can skip the brief", "fonts decide success", "the lunch menu replaces data",
                        "Ask the user to try it. Watch. Note."),
                q("Iteration after evaluation means…", "you change the design and test again",
                        "Loop of improve.", "you publish and freeze forever", "you delete the brief", "you only change the title",
                        "Evaluation is a door back into making."),
                q("A product can look great and still fail if…", "it does not solve the user’s problem",
                        "Pretty ≠ useful.", "the font is large", "the box is recycled", "the name is short",
                        "Go back to the problem sentence."),
                q("Honest evaluation includes…", "what you would do differently next time",
                        "Learning log.", "pretending nothing went wrong", "blaming a classmate only", "hiding the criteria",
                        "Write the next experiment, not a slogan.")
        );
    }

    static QuestionTemplate[] visual(int year, boolean word) {
        return eight(
                fig(word, "Line, colour, shape and texture are…", "visual art elements",
                        SubjectFigures.designBrief("Building blocks you can point to."),
                        "Building blocks of art.", "types of sport", "map directions", "only used in maths",
                        "Point to one element in the work before you say you like it."),
                q("Warm colours include…", "red, orange and yellow",
                        "Warm vs cool.", "only black", "blue and green only", "transparent water",
                        "Think fire and sun, not sea and leaf."),
                q("Before saying you like an artwork, first…", "describe what you notice",
                        "Look carefully.", "cover your eyes", "change the artist's name", "count to 1000",
                        "See → describe → then respond."),
                q(word ? "A repeating pattern in kōwhaiwhai is using…" : "Contrast is strong when you…",
                        word ? "line, shape and rhythm" : "put light against dark or busy against calm",
                        "Elements at work.", word ? "only a sports score" : "use one grey smudge",
                        "the lunch menu", "a PIN",
                        "Name the element that repeats or clashes."),
                q("Texture in art can be…", "how a surface looks or feels (rough, smooth, fluffy)",
                        "Touch or look of touch.", "only a number", "a type of verb", "the page number",
                        "Would your fingers notice a difference?"),
                q("A composition is stronger when…", "your eye has a path and a place to rest",
                        "Arrange on purpose.", "everything is the same size in a muddle", "you hide the subject", "you use no contrast",
                        "Big shape, then smaller helpers."),
                q("Māori and Pacific visual languages should be used…", "with respect for meaning, not as random decoration",
                        "Mana of pattern.", "as a joke border", "copied from a tattoo you do not understand", "instead of asking",
                        "Learn the story of a pattern before you borrow it."),
                q("A viewfinder or crop helps you…", "choose what to include and what to leave out",
                        "Frame the idea.", "add every object in the room", "delete colour forever", "skip looking",
                        "Decide the edges. That is composing.")
        );
    }

    static QuestionTemplate[] music(int year, boolean word) {
        return eight(
                fig(word, "The steady pulse you can tap along to is the…", "beat",
                        SubjectFigures.musicNotes("Beat is the heartbeat you can tap."),
                        "Heartbeat of the music.", "lyrics only", "costume", "stage light",
                        "Tap your foot. That pulse is the beat."),
                q("Pitch is about whether a sound is…", "high or low",
                        "High/low.", "only loud", "only slow", "a colour",
                        "Slide your voice up and down. That is pitch."),
                q("Dynamics describe…", "how loud or soft the music is",
                        "Volume.", "the composer's age", "the colour of the piano", "the room number",
                        "Piano / forte language is about loudness."),
                q(word ? "A waiata is stronger in a group when…" : "Tempo is…",
                        word ? "people listen for the beat and blend" : "how fast or slow the music goes",
                        "Ensemble ears.", word ? "everyone shouts a different song" : "only the lyrics",
                        "the costume only", "the stand’s colour",
                        word ? "Match the pulse. Soften if you are louder than the group." : "Speed of the beat, not how high."),
                q("Silence or a rest is useful because…", "it gives the music shape and the listener a breath",
                        "Space is music too.", "it means you failed", "notes are illegal", "beat disappears forever",
                        "Count the rest. Do not rush to fill it."),
                q("Timbre / tone colour is…", "what makes a guitar sound different from a flute",
                        "Which instrument-voice.", "only the lyrics", "only the tempo", "the page number",
                        "Close your eyes. Which instrument is it?"),
                q("A ostinato or repeated pattern helps you…", "hold the groove while something else changes",
                        "Repeat + contrast.", "delete the beat", "hide the words", "stop listening",
                        "Keep the pattern steady. Layer a new idea on top."),
                q("Listening with a purpose means you…", "hunt one element (beat, lyric, instrument) on each play",
                        "One ear-job at a time.", "talk through the whole track", "skip the second listen", "only watch the lights",
                        "First play: beat. Second: words. Third: a new sound.")
        );
    }

    static QuestionTemplate[] drama(int year, boolean word) {
        return eight(
                q("Staying in role means…", "keeping the character's voice and actions until the scene ends",
                        "Commit to the scene.", "checking your phone mid-scene", "telling jokes as yourself only", "leaving the space",
                        "The scene is a bubble. Stay inside it."),
                q("A shy character might use…", "smaller movements and a quieter voice",
                        "Body and voice show character.", "always shouting", "no face at all", "standing still forever with no choice",
                        "Turn the volume and size of the body down."),
                q("'Yes, and…' in drama means…", "accept a partner's idea and add to it",
                        "Build together.", "say no to every idea", "ignore your partner", "only copy film credits",
                        "Catch their offer. Add one new fact."),
                q(word ? "To show you are listening on stage you…" : "Space between actors can show…",
                        word ? "face them and react with your face and body" : "relationship — close for friends, far for strangers",
                        "Audience can see listen.", word ? "look at the back wall only" : "only the lighting brand",
                        "leave the space", "read a phone",
                        "The audience reads bodies. Point your chest at the speaker."),
                q("A freeze-frame should…", "hold a clear story in still bodies",
                        "Still + readable.", "wiggle and talk", "hide faces", "face the back wall only",
                        "Can a visitor name who, where, what from the still?"),
                q("Voice in drama includes…", "pace, pitch, volume and pause",
                        "Four voice tools.", "costume only", "the script font", "the room number",
                        "Change one tool at a time so the character is clear."),
                q("Safe drama includes…", "agreed stop-words and looking after bodies",
                        "Look after people.", "pushing for a laugh", "ignoring a no", "running with props",
                        "If someone is uncomfortable, stop. That is the rule."),
                q("A scene has tension when…", "someone wants something and something blocks them",
                        "Want + block.", "everyone agrees instantly", "there is no goal", "the lights are pretty only",
                        "Name the want. Name the obstacle.")
        );
    }

    static QuestionTemplate[] dance(int year, boolean word) {
        return eight(
                q("A dance motif is…", "a movement idea you can repeat and vary",
                        "Theme movement.", "a type of shoe only", "the audience count", "a frozen lunch",
                        "One move-family. Repeat it bigger, smaller, faster."),
                q("Changing from a low shape to a high jump is a change of…", "level",
                        "Low, middle, high.", "colour", "spelling", "temperature",
                        "Where is the body in space — floor or air?"),
                q("Safe dancing includes…", "control, space awareness and soft landings",
                        "Look after bodies.", "pushing others", "landing locked-kneed from a height", "closing your eyes and sprinting",
                        "Bend knees. See the space. Land quiet."),
                q(word ? "Unison is when dancers…" : "A pathway on the floor is…",
                        word ? "do the same movement at the same time" : "the track your feet travel",
                        "Together or travel.", word ? "each invent a private dance" : "only the costume",
                        "the music stand", "a PIN",
                        word ? "Match timing. Watch a leader’s count." : "Draw the floor path first, then dance it."),
                q("Energy in dance can be…", "sharp, smooth, sudden or sustained",
                        "How the move feels.", "only the shoe brand", "the room number", "a spelling rule",
                        "Same shape, different energy — that is contrast."),
                q("Canon is when…", "the same motif starts at different times",
                        "A round of movement.", "everyone freezes forever", "music is banned", "levels disappear",
                        "Person 1, then 2, then 3 — same phrase."),
                q("Aotearoa dance contexts include…", "kapa haka and other cultural forms taught with respect",
                        "Culture + permission.", "only copying a random video", "using a haka as a joke", "skipping the meaning",
                        "Learn from people who hold the form. Meaning first."),
                q("Choreography means you…", "choose and order movements on purpose",
                        "Design the dance.", "only improvise forever with no choice", "hide from the music", "ignore space",
                        "Select, order, repeat. That is a dance sentence.")
        );
    }

    static QuestionTemplate[] respond(int year, boolean word) {
        return eight(
                q("A strong arts response starts with…", "what you notice (see or hear)",
                        "Describe first.", "an insult", "changing the work secretly", "silence only",
                        "List three things that are actually there."),
                q("Kind, useful feedback is…", "specific and respectful, with a next step",
                        "Because…", "only 'I like it' with no reason", "rude and vague", "copied from a random website",
                        "I notice… I wonder… Next time try…"),
                q("Connecting an artwork to a feeling should still mention…", "a detail in the work that led you there",
                        "Evidence.", "nothing from the work", "only the weather outside", "a secret code",
                        "Feeling + the line/colour/sound that caused it."),
                q(word ? "A response to a waiata can include…" : "Interpreting is different from describing because you…",
                        word ? "what the words and the sound made you think" : "say what it might mean, after you describe",
                        "Describe, then interpret.", word ? "only the hall’s paint colour" : "skip looking",
                        "the lunch menu", "a PIN",
                        "First what is there. Then what it might be saying."),
                q("Comparing two works is clearer when you…", "use the same elements (line, beat, role) for both",
                        "Same lens.", "change the rules halfway", "only pick a favourite with no reason", "ignore one work",
                        "Element by element, not vibe vs vibe."),
                q("Respectful response to cultural work means…", "you learn context and do not mock sacred forms",
                        "Mana of the work.", "using it as a joke", "copying a tattoo you do not understand", "skipping the artist’s name",
                        "Name the people and the purpose before you judge."),
                q("A caption under your own work should…", "tell a viewer what to look or listen for",
                        "Guide the audience.", "be a secret", "only a scribble", "the lunch menu",
                        "One sentence: I want you to notice…"),
                q("Revising a response after a second look often…", "adds evidence you missed the first time",
                        "Second look is richer.", "deletes all detail", "proves looking once is enough", "hides the work",
                        "Play or look again. Add one new noticed thing.")
        );
    }

    static QuestionTemplate[] move(int year, boolean word) {
        return eight(
                fig(word, "A useful catching cue is…", "eyes on the ball and hands ready",
                        SubjectFigures.moveSkill("See it. Hands ready. Soft catch."),
                        "One cue at a time.", "look at the sky only", "hands in pockets", "turn your back",
                        "Watch the ball into your hands."),
                q("Locomotor skills include…", "running, jumping and skipping",
                        "Moving from place to place.", "only sitting", "sleeping", "holding your breath",
                        "Did your feet travel? That is locomotor."),
                q("Fair play means…", "including others and following agreed rules",
                        "Everyone can join in.", "cheating to win", "leaving people out", "arguing with the referee always",
                        "Rules + welcome. Winning is second."),
                q(word ? "A warm-up is useful because…" : "Sending a ball is more accurate when you…",
                        word ? "muscles and brains get ready, and injury risk drops" : "step in, eyes on the target, follow through",
                        "Prepare, then send.", word ? "you skip it to start the game faster" : "close your eyes",
                        "you stay cold", "you throw as hard as you can with no aim",
                        word ? "Raise heat slowly. Then play." : "Body points at the target. Then the ball goes there."),
                q("Space awareness in a game means…", "seeing gaps, teammates and the sideline",
                        "Heads up.", "staring only at your feet", "clustering in one corner always", "ignoring the ball",
                        "Scan: ball, people, space."),
                q("A skill cue should be…", "one short phrase you can remember in the moment",
                        "One cue.", "a whole essay", "an insult", "a secret",
                        "‘Soft hands’ beats a paragraph mid-catch."),
                q("Modified games help because…", "rules can change so more people can succeed",
                        "Inclusion by design.", "only the fastest may play", "new people are removed", "the game stays secret",
                        "If someone cannot join, change a rule — not the person."),
                q("Cool-down after hard play is for…", "slowing the body and reducing stiffness",
                        "Land the plane.", "sprinting out the gate", "skipping water", "ignoring breath",
                        "Walk, stretch, water.")
        );
    }

    static QuestionTemplate[] hauora(int year, boolean word) {
        return eight(
                fig(word, "Taha tinana refers to…", "physical wellbeing (the body)",
                        SubjectFigures.hauoraTaha("Four taha sit together."),
                        "Four taha of hauora.", "only money", "map drawing", "spelling tests only",
                        "Tinana = the body taha. Name the other three if you can."),
                q("Taha whānau is about…", "relationships and belonging with others",
                        "Family/social.", "only isolated exercise", "ignoring friends", "the colour blue",
                        "Who do you belong with? That is whānau taha."),
                q("Hauora is best described as…", "a whole view of wellbeing, not only 'not being sick'",
                        "Holistic.", "a type of ball sport only", "a maths formula", "a computer brand",
                        "All four taha. Not just a thermometer."),
                q(word ? "Sleep and food mainly support…" : "Taha hinengaro includes…",
                        word ? "taha tinana (and they affect the other taha too)" : "thoughts and feelings",
                        "Body and mind link.", word ? "only map drawing" : "only money",
                        "a computer brand", "a sports score only",
                        word ? "Rest and kai are body care that also lift mood." : "What you think and feel is hinengaro."),
                q("Taha wairua is often about…", "values, meaning and what gives you a sense of spirit",
                        "Meaning, not a test score.", "only the lunch menu", "a PIN", "skipping belonging",
                        "What matters deeply to you — faith, whenua, values."),
                q("A balanced day for hauora might include…", "move, connect, rest and something that matters to you",
                        "Four taha in a timetable.", "only screens", "skipping food", "never talking to anyone",
                        "Tick one action for each taha."),
                q("Asking for help is part of hauora because…", "whānau and hinengaro taha include support",
                        "Help-seeking is strength.", "you must hide every feeling", "doctors are only for maps", "friends cannot help",
                        "A trusted adult is a hauora tool."),
                q("Hauora is not only sport because…", "wellbeing includes mind, people and spirit as well as body",
                        "Wider than PE.", "PE is the only taha", "feelings do not count", "belonging is optional",
                        "If only the body is cared for, three taha are hungry.")
        );
    }

    static QuestionTemplate[] relate(int year, boolean word) {
        return eight(
                q("An I-statement sounds like…", "I felt left out when the game started without me",
                        "Feelings + situation.", "You're mean", "Whatever", "I win",
                        "I feel ___ when ___. No name-calling."),
                q("Consent means…", "a clear yes that can also be withdrawn",
                        "Ask first. Stop if no.", "guessing someone agrees", "never asking", "ignoring a no",
                        "Yes can become no. Then you stop."),
                q("If a problem feels too big you should…", "talk to a trusted adult",
                        "Help-seeking.", "keep it a forever secret no matter what", "post it to strangers only", "blame yourself in silence",
                        "Name one adult you can tell."),
                q(word ? "A friendship repair might start with…" : "Respect in a group looks like…",
                        word ? "sorry, what I did, and what I will do next" : "listening and using people’s correct names",
                        "Repair is specific.", word ? "Whatever" : "talking over everyone",
                        "You're mean", "I win",
                        word ? "Name the harm. Name the next action." : "Names and turns. That is respect you can see."),
                q("Boundaries are…", "lines you set about what is okay for you",
                        "Your yes and no.", "rules only teachers have", "a type of ball", "the lunch menu",
                        "You can say no to a hug, a joke, or a dare."),
                q("Online, a kind friend would…", "not share a private photo or chat without asking",
                        "Consent online too.", "forward a secret for laughs", "guess a password", "post an unkind nickname",
                        "Ask before you share someone else’s image or words."),
                q("Stereotypes in friendship are unhelpful because…", "they replace a real person with a label",
                        "See the person.", "they make planning easier and kinder", "names do not matter", "listening is optional",
                        "Ask them. Do not assume from a group label."),
                q("A cool-down after a clash is useful so you…", "can talk when your body is calmer",
                        "Regulate, then repair.", "shout while you are hottest", "never return", "hide the problem forever",
                        "Water, walk, then the I-statement.")
        );
    }

    static QuestionTemplate[] safety(int year, boolean word) {
        return eight(
                fig(word, "At the beach you should swim…", "between the flags, and never alone",
                        SubjectFigures.safetyFlags("Red-and-yellow flags mark the safe patrol area."),
                        "Water safety.", "as far as you like with no plan", "in a rip on purpose", "at night with no adults",
                        "Find the flags. Stay inside. A buddy stays with you."),
                q("In an emergency in New Zealand you can call…", "111",
                        "Get help fast.", "000 only (that's another country)", "123456", "the weather channel",
                        "111. Say where you are and what is wrong."),
                q("Online, a safer choice is to…", "keep personal details private and tell an adult about unkind contact",
                        "Digital safety.", "share your address with strangers", "click every pop-up", "use a friend's password",
                        "Adult first. Details stay offline."),
                q(word ? "If someone is injured and you are not sure what to do…" : "Sun safety includes…",
                        word ? "call 111 and follow the adult / operator" : "hat, shade, and slip-slop-slap habits",
                        "Help without becoming a second patient.", word ? "move them roughly" : "no hat at noon",
                        "post it first", "ignore them",
                        word ? "Scene safe. Call. Then simple first aid you have been taught." : "Cover skin when the sun is strong."),
                q("A rip current is safer if you…", "stay calm, float, and signal — do not fight it straight in",
                        "Rip plan.", "swim against it until exhausted", "hide from patrol", "go further out alone",
                        "Float. Wave. Swim parallel when you can — as taught."),
                q("Household hazards include…", "hot pots, medicines and chemicals stored up high",
                        "Home scan.", "leaving bleach with kai", "running with knives", "unlabelled bottles",
                        "If it can burn, poison or cut — adult storage."),
                q("Road crossing is safer when you…", "stop, look, listen, and use a crossing if there is one",
                        "Kerbcraft habits.", "dash from between cars", "look at a phone", "assume cars will stop",
                        "Eyes up. Wait. Then walk, don’t run into traffic."),
                q("Telling an adult is not ‘dobbing’ when…", "someone is unsafe or being hurt",
                        "Safety over secrets.", "you just want someone in trouble for fun", "it is only about a game score", "you skipped homework",
                        "Hurt, scared, secret that feels wrong — tell.")
        );
    }

    static QuestionTemplate[] community(int year, boolean word) {
        return eight(
                q("A buddy bench is an example of…", "a small design that helps people belong",
                        "Inclusive community.", "a type of maths test", "a punishment", "a secret code",
                        "Ask: who feels left out, and what tiny change helps?"),
                q("An inclusive game change might be…", "adjusting rules so more people can take part",
                        "Everyone can play.", "removing anyone who is new", "making the game secret", "only the fastest may play",
                        "Change the rule, not the person."),
                q("Personal choices can affect a community when…", "lots of people do the same thing, like recycling or including others",
                        "Collective effect.", "nothing anyone does ever matters", "only famous people matter", "communities have no people",
                        "Your one action + many others = a culture."),
                q(word ? "A community issue is best tackled by…" : "Health promotion is…",
                        word ? "noticing, asking who is affected, then a small action" : "helping a group make a healthier, fairer choice",
                        "Notice → ask → act.", word ? "ignoring the people involved" : "only a poster with no action",
                        "hiding the problem", "blaming one kid forever",
                        "Who is affected? What small action can we check later?"),
                q("Belonging at school can grow when…", "names are used and new people are invited in",
                        "Welcome is a skill.", "groups stay closed on purpose", "nicknames they hate are used", "new students sit alone",
                        "Say the name. Make a space. Invite."),
                q("A class action (planting, collecting kai) works better with…", "a plan, roles, and a way to check it worked",
                        "Project, not vibe.", "no roles", "no check", "a secret from the people it helps",
                        "Who does what by when? How will we know it helped?"),
                q("Respecting a place (marae, reserve) includes…", "following the kawa or rules of that place",
                        "Place has tikanga.", "leaving rubbish", "running on gardens", "ignoring a rāhui",
                        "Ask what this place expects. Then do that."),
                q("Speaking up about an unfair rule is community action when you…", "use respectful, agreed pathways",
                        "Voice + process.", "break things for attention only", "hide forever", "blame one person in secret",
                        "Petition, meeting, adult ally — not sabotage first.")
        );
    }

    static QuestionTemplate[] greetings(int year, boolean word) {
        return eight(
                fig(word, "A friendly everyday hello in te reo Māori is…", "Kia ora",
                        SubjectFigures.greetingKiaOra("Kia ora is widely friendly. Tēnā koe greets one person."),
                        "Common greeting.", "Goodbye only", "Tekau", "Whero",
                        "Kia ora works almost everywhere as a warm hello."),
                q("Tēnā koe is typically used to greet…", "one person",
                        "Koe = you (singular).", "a sports team of 15 all at once as the only form", "a mountain", "a number",
                        "Count the people. One → koe."),
                q("Tēnā koutou greets…", "a group of people",
                        "Koutou = you plural.", "only one baby", "a colour", "the number two",
                        "Three or more? Koutou is the usual classroom form."),
                q(word ? "Tēnā kōrua is for…" : "A macron matters because it can…",
                        word ? "two people" : "change the meaning of a word",
                        "Number + sound.", word ? "a colour" : "never change meaning",
                        "tekau", "a PIN",
                        word ? "Two people → kōrua." : "keke vs kēkē is the classroom warning."),
                q("A greeting loop is…", "greet, introduce or respond, then listen",
                        "Do not stop at hello.", "say kia ora and walk off every time", "use only English forever", "skip listening",
                        "Hello + how are you + listen to the reply."),
                q("Macrons in writing help a reader…", "say the vowel length correctly",
                        "Length is meaning.", "skip the word", "change it into English", "count the letters only",
                        "A line over a vowel means hold it longer."),
                q("Tēnā koe is a little more…", "formal than kia ora for one person",
                        "Match the situation.", "a colour", "a number", "a goodbye only",
                        "Kia ora = friendly. Tēnā koe = one person, a touch more formal."),
                q("Using te reo in a greeting shows…", "respect for the language of this place",
                        "Citizenship in sound.", "a maths formula", "a sports score", "a secret code",
                        "One greeting done well is a real use, not a worksheet.")
        );
    }

    static QuestionTemplate[] words(int year, boolean word) {
        return eight(
                q("Rua means…", "two",
                        "tahi 1, rua 2, toru 3.", "ten", "red", "water",
                        "Count on your fingers: tahi, rua…"),
                q("Whero is a colour meaning…", "red",
                        "whero red, kōwhai yellow, kikorangi blue.", "seven", "family", "food",
                        "Link the colour word to something red you can see."),
                q("Whānau most nearly means…", "family / extended family",
                        "People you belong with.", "a type of rock", "the number eight", "a bus ticket",
                        "Who belongs with you? That is close to whānau."),
                q("Kai means…", "food",
                        "Everyday vocab.", "shoe", "cloud", "five",
                        "Put it in a sentence: Kei te hiahia kai ahau."),
                q(word ? "Tekau means…" : "Tahi means…",
                        word ? "ten" : "one",
                        "Number kupu.", word ? "red" : "ten",
                        "family", "food",
                        "Keep a number line of kupu on the wall in your head."),
                q("Pukapuka is a classroom word for…", "book",
                        "Label the object.", "shoe", "seven", "a mountain",
                        "Point to the book as you say it."),
                q("A word you own is one you can…", "put in a sentence the same day",
                        "Use it or lose it.", "only tick on a list", "never say aloud", "translate the page number only",
                        "Say it to a person today."),
                q("Kōwhai as a colour is…", "yellow",
                        "Colour set.", "two", "family", "book",
                        "The kōwhai flower is the memory hook.")
        );
    }

    static QuestionTemplate[] listen(int year, boolean word) {
        return eight(
                q("Kei te pēhea koe? is asking…", "How are you?",
                        "Common exchange.", "What time is it?", "Where is the bus?", "How old is the mountain?",
                        "A feeling question. Reply with kei te…"),
                q("A useful reply to Kei te pēhea koe? is…", "Kei te pai",
                        "I'm good / I'm well.", "Tekau anake", "Whero whero", "111",
                        "Kei te pai is the friendly default."),
                q("When you are learning to speak, a smart strategy is to…", "copy a model sentence and change one word",
                        "Scaffold speaking.", "never speak until perfect", "use only English forever", "skip listening",
                        "Keep the frame. Swap one kupu."),
                q(word ? "You will often understand more than you can say. That means you should…"
                        : "Listening first helps because…",
                        word ? "keep listening and borrow phrases you heard" : "your ear builds the pattern before your mouth",
                        "Input before output.", word ? "give up speaking" : "you can skip all models",
                        "cover your ears", "only write numbers",
                        "Listen twice. Then try the sentence."),
                q("Kei te ngenge means you are…", "tired",
                        "Feeling vocab.", "ten", "red", "a book",
                        "Match the feeling word to your body."),
                q("A repair phrase when you did not catch a word is…", "asking for a repeat (can you say that again / anō)",
                        "Stay in the conversation.", "pretending forever", "switching off", "laughing at the speaker",
                        "Ask again. That is how speakers grow."),
                q("Stress and pace in a model sentence tell you…", "which words to hold and where to breathe",
                        "Copy the music of the line.", "only the spelling", "the page number", "a PIN",
                        "Hum the rhythm, then put words on it."),
                q("Mistakes while speaking are…", "data you can use, not a reason to stop",
                        "Fluency grows from trying.", "proof you should stay silent", "illegal in class", "the same as rudeness",
                        "Say it. Fix one sound. Say it again.")
        );
    }

    static QuestionTemplate[] readLang(int year, boolean word) {
        return eight(
                q("A classroom label tēpu on a table helps you…", "connect a written word to a real object",
                        "Print + meaning.", "solve a quadratic", "measure rainfall", "skip reading",
                        "Touch the table. Say tēpu. See the letters."),
                q("If you do not know every word in a short text you should…", "use pictures and known words to get the gist",
                        "Gist first.", "give up immediately", "cover the pictures", "translate the page numbers only",
                        "Circle words you know. Guess the movie of the page."),
                q("Reading a bilingual book can help because…", "you can check meaning in the language you know",
                        "Dual language support.", "it removes all pictures forever", "it hides the story", "it is only for maths",
                        "Use the side you know as a key, not a crutch forever."),
                q(word ? "Māori vowels are helpful because they…" : "Reading aloud in te reo helps you…",
                        word ? "are more consistent than many English vowels" : "hear vowel length and macrons",
                        "Sound + print.", word ? "change every time" : "skip macrons",
                        "hide the letters", "replace listening",
                        "Say the five vowels slowly. Keep them pure."),
                q("A caption under a picture is useful because…", "it ties a short text to something you can see",
                        "Print with meaning.", "it hides the picture", "it is only a page number", "it replaces all talk",
                        "Read the caption. Point to the part it names."),
                q("Scanning a te reo label wall is a way to…", "recycle high-frequency kupu every day",
                        "Environment as teacher.", "avoid the language", "only learn English", "skip speaking",
                        "Find today’s word on the wall. Use it once."),
                q("You do not need every word to…", "follow the gist of a short, supported text",
                        "Gist over perfection.", "sit the exam of every dictionary", "skip the pictures", "cover known words",
                        "Who, where, what — even with holes."),
                q("A dual-language sign at a reserve is there so…", "more people can read the care message",
                        "Language as access.", "English is banned", "macrons are illegal", "maps disappear",
                        "Both languages carry the same job: look after the place.")
        );
    }

    static QuestionTemplate[] tikanga(int year, boolean word) {
        return eight(
                q("Tikanga is best described as…", "correct cultural practices and protocols",
                        "The right way of doing things in a Māori context.", "a type of fraction", "a computer error", "a sports score",
                        "Ask what is the right way here — that is close to tikanga."),
                q("Manaakitanga is about…", "care, hospitality and looking after people",
                        "Kindness in action.", "ignoring guests", "winning an argument", "measuring area",
                        "How are guests looked after? Food, welcome, dignity."),
                q("Using te reo Māori respectfully means…", "taking care with pronunciation and not using it as a joke",
                        "Language and people together.", "making fun of words", "never learning any words", "mixing it with passwords",
                        "Say it carefully. Do not use it as a chant without meaning."),
                q(word ? "Removing shoes on a marae (when that is the kawa) shows…" : "Kawa of a place is…",
                        word ? "you are following the tikanga of that place" : "the local protocol for that marae or event",
                        "Place has rules.", word ? "you dislike the building" : "the same in every building in the world",
                        "a maths formula", "a sports score",
                        "Ask the local people. Follow what they say."),
                q("Karakia as practised in a community has…", "a purpose of gathering, thanks or safety — treat it as real",
                        "Not a joke transition.", "no meaning", "only a way to start PE faster", "a secret PIN",
                        "Stillness and listen. That is respect you can show."),
                q("Not sitting on tables is a common tikanga reminder because…", "tables are for kai — sitting on them can be seen as noa/tapu mix-up",
                        "Food surfaces matter.", "chairs are illegal", "maths needs the floor", "shoes must stay on tables",
                        "Kai surfaces stay for kai."),
                q("Copying a mihi from the internet that belongs to another iwi is a problem because…", "it can claim a belonging that is not yours",
                        "Identity is not copy-paste.", "all mihi are identical and free to grab", "iwi do not matter", "macrons are optional jokes",
                        "Write a true introduction for you. Do not steal someone else’s pepeha."),
                q("Learning language and tikanga together matters because…", "words sit inside living practices and people",
                        "Not vocabulary only.", "tikanga is a spelling test only", "language has no people", "jokes replace meaning",
                        "Every greeting has a people and a place behind it.")
        );
    }

    private static QuestionTemplate[] eight(QuestionTemplate... items) {
        return items;
    }

    private static QuestionTemplate q(String text, String correct, String expl, String d1, String d2, String d3, String hint) {
        return rng -> hint(QBuilder.build(rng, text, correct, expl, "MEDIUM", "skill-check", d1, d2, d3), hint);
    }

    private static QuestionTemplate fig(boolean word, String text, String correct, String figure,
                                        String expl, String d1, String d2, String d3, String hint) {
        return rng -> hint(QBuilder.build(rng, MathFigures.ask(text, figure), correct, expl,
                "EASY", word ? "word problem" : "visual pattern", d1, d2, d3), hint);
    }

    private static GeneratedQuestion hint(GeneratedQuestion q, String hint) {
        return q.withHint(hint);
    }
}
