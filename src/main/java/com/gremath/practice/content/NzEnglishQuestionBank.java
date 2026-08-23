package com.gremath.practice.content;

import com.gremath.curriculum.MathFigures;
import com.gremath.curriculum.SubjectFigures;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QBuilder;
import com.gremath.practice.QuestionTemplate;

/** Distinct English stems with diagrams and per-item hints. */
final class NzEnglishQuestionBank {

    private NzEnglishQuestionBank() {
    }

    static QuestionTemplate[] reading(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "You open this story once for the overall idea. That first read is for…"
                                                : "The first read of a story is mainly for…",
                                        SubjectFigures.storyBook("First pass: gist. Second pass: evidence.")),
                                "the gist or main idea",
                                "First reading is for overall meaning.",
                                "EASY", tag(word, "visual pattern"),
                                "every tiny detail", "only the last sentence", "the author's full biography"),
                        "Ask what the whole page is about before you hunt one word."),
                rng -> hint(QBuilder.build(rng, "Two answers look possible. You should…",
                                "choose the one best supported by the text",
                                "Evidence in the text decides.",
                                "MEDIUM", "skill-check",
                                "pick the longest answer", "guess the author's feelings only", "choose the first option"),
                        "Underline the sentence that actually proves the option."),
                rng -> hint(QBuilder.build(rng, year <= 3
                                        ? "A retell should include…"
                                        : "Inference means…",
                                year <= 3 ? "who, where and what happened, in order"
                                        : "using clues in the text to work out something not stated directly",
                                year <= 3 ? "Beginning, middle and end." : "Inference still needs text clues.",
                                "MEDIUM", "skill-check",
                                year <= 3 ? "only the title in a random order" : "ignoring the text and using only your opinion",
                                "copying one sentence word for word", "reading only the title"),
                        year <= 3
                                ? "Who, where, what — in the order it happened."
                                : "Point to the clue. If there is no clue, it is a guess."),
                rng -> hint(QBuilder.build(rng, "A heading in an information text mainly helps you…",
                                "predict what the next section is about",
                                "Headings are signposts.",
                                "EASY", "skill-check",
                                "count the vowels", "skip the pictures forever", "change the author's name"),
                        "Read the heading as a promise of the next chunk."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "When two characters disagree, a good reader asks…"
                                        : "A fact can be checked. An opinion…",
                                word ? "what each character wants and why"
                                        : "is a view that can be agreed with or not",
                                word ? "Motive sits under the argument." : "Fact vs opinion.",
                                "MEDIUM", tag(word),
                                word ? "which font is larger" : "is always false",
                                "whether the page is even-numbered", "how many commas appear"),
                        word
                                ? "Name each character’s want, then the reason."
                                : "If you can prove it with a check, it is closer to a fact."),
                rng -> hint(QBuilder.build(rng, year >= 9
                                        ? "A news headline says ‘chaos’ but the article describes a permitted hīkoi. The headline is mainly…"
                                        : "Pictures and captions in a junior text help you…",
                                year >= 9 ? "positioning the reader before they meet the evidence"
                                        : "lock in who, where and what before the hard words",
                                year >= 9 ? "Diction in headlines is a design choice." : "Images are part of the meaning.",
                                "HARD", "skill-check",
                                year >= 9 ? "proof that the march was illegal" : "replace the need to read anything",
                                year >= 9 ? "a spelling rule" : "hide the story",
                                "unrelated to audience"),
                        year >= 9
                                ? "Ask who wrote the headline and what they want you to feel."
                                : "Match the picture to a sentence. Then read on."),
                rng -> hint(QBuilder.build(rng, "A metaphor should be analysed by stating…",
                                year >= 7 ? "the image and the effect on a reader" : "what it compares and why that helps the idea",
                                "Technique without effect is name-dropping.",
                                "MEDIUM", "skill-check",
                                "only the page number", "that all metaphors are errors", "the author's favourite colour"),
                        "Name the picture the words make, then what it does to you."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Critical reading of a poster should first ask…"
                                        : "If a sentence is not in the text, a safe move is to…",
                                word ? "who made this, for whom, and what is missing"
                                        : "not treat it as a stated fact",
                                word ? "Maker, audience, omission." : "Stay inside the page.",
                                "HARD", tag(word),
                                word ? "which font is prettiest" : "add it anyway because it sounds true",
                                "can I skip the date", "is this the longest paragraph"),
                        word
                                ? "Maker → audience → what got left out."
                                : "If you cannot point to the line, do not pick that option."),
                rng -> hint(QBuilder.build(rng, "Skimming is useful when you need to…",
                                "find the overall topic quickly",
                                "Skim first, scan later for a detail.",
                                "EASY", "skill-check",
                                "memorise every comma", "skip the title", "change the author’s name"),
                        "Skim = fast map. Scan = hunt one fact."),
                rng -> hint(QBuilder.build(rng, "A character’s action is best explained by…",
                                "what they want and what stands in the way",
                                "Want + obstacle = reason.",
                                "MEDIUM", "skill-check",
                                "the page number only", "the font size", "how many adjectives appear"),
                        "Ask: what do they want, and what stops them?")
        };
    }

    static QuestionTemplate[] writing(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "Before you draft a letter, the plan should name…"
                                                : "A paragraph should usually have…",
                                        SubjectFigures.designBrief("Purpose, audience, then one idea per box.")),
                                word ? "who will read it and why you are writing" : "one main idea with supporting details",
                                word ? "Plan purpose and audience." : "One idea per paragraph.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "only the colours you like" : "as many unrelated ideas as possible",
                                "a random object with no purpose", "a list of random words"),
                        word
                                ? "Write ‘to ___ so that ___’ at the top of the plan."
                                : "If a sentence starts a new idea, it wants a new paragraph."),
                rng -> hint(QBuilder.build(rng, "The best first step before drafting is to…",
                                "plan your purpose, audience and ideas",
                                "Plan before you write.",
                                "MEDIUM", "skill-check",
                                "start with the last sentence", "ignore who will read it", "copy a friend"),
                        "Purpose and audience first. Draft second."),
                rng -> hint(QBuilder.build(rng, "A topic sentence usually…",
                                "states the main point of the paragraph",
                                "It tells the reader the focus.",
                                "EASY", "skill-check",
                                "is always a question mark only", "lists every fact in the whole text", "has no meaning"),
                        "The first line should name the one idea of this paragraph."),
                rng -> hint(QBuilder.build(rng, "The best way to end a piece of writing is to…",
                                "close the idea so the reader feels finished",
                                "A conclusion is not a new random topic.",
                                "MEDIUM", "skill-check",
                                "start a brand-new story in the last line", "stop mid-word", "repeat the title ten times"),
                        "Echo the purpose. Do not open a second story."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "Choosing words for a younger audience means you should…"
                                        : "Revising is different from proofreading because revising…",
                                word ? "keep sentences clear and explain new words"
                                        : "improves ideas, order and clarity first",
                                word ? "Audience changes vocabulary." : "Proofreading later catches spelling.",
                                "MEDIUM", tag(word),
                                word ? "use only university words" : "only changes the font",
                                "remove all full stops", "delete the audience"),
                        word
                                ? "Picture the reader. If they are younger, shorten and explain."
                                : "Revise the thinking. Then hunt spelling."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "A strong verb is better than…"
                                        : "A recount is usually told in…",
                                year >= 6 ? "a weak verb plus a pile of adverbs" : "the order events happened",
                                year >= 6 ? "Show with the verb." : "Time order keeps a listener with you.",
                                "EASY", "skill-check",
                                year >= 6 ? "deleting all verbs" : "a random jumble",
                                year >= 6 ? "only adjectives" : "future tense only",
                                "a secret code"),
                        year >= 6
                                ? "Swap ‘walked slowly’ for one sharper verb if you can."
                                : "First, next, then, finally — that is a recount spine."),
                rng -> hint(QBuilder.build(rng, "A writing checklist should include…",
                                "purpose, paragraphing, and a reread aloud",
                                "Ears catch what eyes skip.",
                                "MEDIUM", "skill-check",
                                "only the font", "deleting the audience", "never rereading"),
                        "Read it out. If you run out of breath, the sentence is too long."),
                rng -> hint(QBuilder.build(rng, "Showing not telling means you…",
                                "give actions and details instead of only a label",
                                "‘She slammed the bag’ shows anger better than ‘she was angry’.",
                                "HARD", "skill-check",
                                "use no verbs", "only write the word happy", "delete all nouns"),
                        "Replace the feeling-word with what the body or voice does.")
        };
    }

    static QuestionTemplate[] grammar(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, "Which sentence is punctuated correctly?",
                                "The kiwi is nocturnal.",
                                "Capital to start, full stop to end.",
                                "EASY", "skill-check",
                                "the kiwi is nocturnal", "The kiwi is nocturnal", "the Kiwi Is nocturnal."),
                        "Check the first letter and the last mark."),
                rng -> hint(QBuilder.build(rng, "Which sentence is a run-on that should be split or joined properly?",
                                "We went to the beach it was hot.",
                                "Two complete ideas need a join or a stop.",
                                "MEDIUM", "skill-check",
                                "We went to the beach because it was hot.", "It was hot at the beach.", "The beach was hot."),
                        "If you can hear two full sentences, split or join them on purpose."),
                rng -> hint(QBuilder.build(rng, "Choose the verb that agrees: She ____ to school.",
                                "walks",
                                "Singular she takes walks.",
                                "EASY", "skill-check",
                                "walk", "walking", "walked to"),
                        "She / he / it often adds -s on a present verb."),
                rng -> hint(QBuilder.build(rng, "Which needs a question mark?",
                                "When does the bus leave",
                                "A question asks something.",
                                "EASY", "skill-check",
                                "The bus leaves at 3.", "Leave the bus.", "Bus, leave now."),
                        "If it asks, it wants ? — even if the capital is missing in the option."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "An apostrophe of possession is correct in…"
                                        : "Which is a complete sentence?",
                                word ? "the student's bag" : "Tāne kicked the ball.",
                                word ? "Owner then apostrophe then belonging." : "Subject + verb + complete idea.",
                                "MEDIUM", tag(word),
                                word ? "the students bag's" : "Kicked the ball.",
                                word ? "the students' bag's hat's" : "The ball.",
                                word ? "students bag" : "Because the wind."),
                        word
                                ? "Who owns it? Put the apostrophe after that owner."
                                : "Name who did what. Fragments miss one of those."),
                rng -> hint(QBuilder.build(rng, year >= 5
                                        ? "A comma is useful when you…"
                                        : "A proper noun should have…",
                                year >= 5 ? "mark a pause in a list or after an opener" : "a capital letter",
                                year >= 5 ? "Lists and openers." : "Names of people and places.",
                                "EASY", "skill-check",
                                year >= 5 ? "replace every full stop" : "no capitals ever",
                                year >= 5 ? "hide the verb" : "a question mark in the middle",
                                "delete the subject"),
                        year >= 5
                                ? "Use a comma to help the reader breathe — not instead of a full stop."
                                : "Aotearoa, Tāne, Monday — those names take a capital."),
                rng -> hint(QBuilder.build(rng, "Its (no apostrophe) means…",
                                "belonging to it",
                                "It's = it is. Its = belonging.",
                                "HARD", "skill-check",
                                "it is", "a plural of it", "a question"),
                        "Swap in ‘it is’. If that sounds wrong, you want its."),
                rng -> hint(QBuilder.build(rng, "Speech marks go around…",
                                "the exact words someone said",
                                "Quoted talk, not the reporting clause.",
                                "MEDIUM", "skill-check",
                                "the whole paragraph always", "only the full stop", "the author's surname"),
                        "Mark the spoken words. Leave he said outside if that is how you were taught.")
        };
    }

    static QuestionTemplate[] vocab(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, "The prefix un- in unhappy most nearly means…",
                                "not",
                                "un- often means not.",
                                "EASY", "skill-check",
                                "again", "full of", "before"),
                        "Cover the prefix. Happy vs un-happy."),
                rng -> hint(QBuilder.build(rng, "A synonym for enormous is…",
                                "huge",
                                "Synonyms mean nearly the same.",
                                "EASY", "skill-check",
                                "tiny", "slow", "quiet"),
                        "Same-ish meaning, not the opposite."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "You meet an unknown word. A smart first move is to…"
                                        : "An antonym of arrive is…",
                                word ? "use the words around it as context clues" : "leave",
                                word ? "Context + word parts." : "Opposite meaning.",
                                "MEDIUM", tag(word),
                                word ? "skip the whole book" : "come",
                                "change the author's name", "count the letters only"),
                        word
                                ? "Read the sentence with a blank. What would fit?"
                                : "Antonym = opposite. Arrive’s opposite is leave."),
                rng -> hint(QBuilder.build(rng, "The suffix -ful in careful most nearly means…",
                                "full of / having",
                                "care + ful.",
                                "EASY", "skill-check",
                                "without", "again", "before"),
                        "Split the word. The tail often names ‘full of’."),
                rng -> hint(QBuilder.build(rng, year >= 6
                                        ? "A root like ‘struct’ (construct, structure) is about…"
                                        : "A compound word is two words joined, such as…",
                                year >= 6 ? "building" : "sunshine",
                                year >= 6 ? "Roots travel across a word family." : "sun + shine.",
                                "MEDIUM", "skill-check",
                                year >= 6 ? "only colour" : "cat",
                                year >= 6 ? "weather only" : "run",
                                "a full stop"),
                        year >= 6
                                ? "Collect the family: construct, structure, instructor."
                                : "Say the two smaller words you can hear."),
                rng -> hint(QBuilder.build(rng, "Morphology is useful because…",
                                "word parts give meaning even when the whole word is new",
                                "Prefix, root, suffix.",
                                "HARD", "skill-check",
                                "it replaces reading", "fonts decide meaning", "page numbers are morphology"),
                        "Chop the word into parts you already know."),
                rng -> hint(QBuilder.build(rng, "A precise noun is better than a vague one. Prefer…",
                                "kererū rather than only bird",
                                "Specific names paint a clearer picture.",
                                "MEDIUM", "skill-check",
                                "thing rather than kererū", "stuff rather than kete", "it rather than always naming"),
                        "Swap ‘thing’ for the real name if you know it."),
                rng -> hint(QBuilder.build(rng, "Re- in rewrite most nearly means…",
                                "again",
                                "re- often means again.",
                                "EASY", "skill-check",
                                "not", "full of", "after"),
                        "re- + write = write again.")
        };
    }

    static QuestionTemplate[] oral(int year, boolean word) {
        return new QuestionTemplate[]{
                rng -> hint(QBuilder.build(rng, MathFigures.ask(
                                        word ? "In a discussion you should…"
                                                : "A respectful opinion sounds like…",
                                        SubjectFigures.speechTurn("Listen, then add a reason.")),
                                word ? "listen to understand, then add a reason" : "I think… because…",
                                word ? "Turn-taking and reasons." : "Opinions need reasons.",
                                "EASY", tag(word, "visual pattern"),
                                word ? "talk over others" : "I'm right and that's it",
                                "ignore everyone", "only shout"),
                        "Wait for the end of their sentence. Then because."),
                rng -> hint(QBuilder.build(rng, "When presenting, it helps to…",
                                "speak clearly and pause at the end of ideas",
                                "Voice and pace help listeners.",
                                "MEDIUM", "skill-check",
                                "mumble at the floor", "read so fast nobody can follow", "never look up"),
                        "One idea, then a breath. Look up once."),
                rng -> hint(QBuilder.build(rng, year <= 3
                                        ? "Taking turns in news time means…"
                                        : "A challenge in a formal discussion should still…",
                                year <= 3 ? "one speaker, then a listener’s question" : "stay on the idea and stay respectful",
                                year <= 3 ? "Share the airtime." : "Disagree with the claim, not the person.",
                                "MEDIUM", "skill-check",
                                year <= 3 ? "shouting the same story over someone" : "insult the speaker",
                                year <= 3 ? "never listening" : "change the topic to recess",
                                "hiding"),
                        year <= 3
                                ? "Eyes on the speaker. Your turn comes after."
                                : "Name the idea you disagree with. Keep the person safe."),
                rng -> hint(QBuilder.build(rng, word
                                        ? "If you did not hear, a useful question is…"
                                        : "Body language that helps a speaker is…",
                                word ? "Can you say that again, please?" : "facing them and staying still enough to listen",
                                word ? "Repair the listen." : "Listen with your body.",
                                "EASY", tag(word),
                                word ? "Whatever" : "turning your back",
                                "You're wrong, full stop", "checking a phone"),
                        word
                                ? "Polite repair keeps the talk going."
                                : "Face, still hands, eyes — that is listening they can see."),
                rng -> hint(QBuilder.build(rng, "A short talk needs…",
                                "an opening, two points, and a close",
                                "Shape the speech.",
                                "MEDIUM", "skill-check",
                                "only a title and a giggle", "twenty unconnected facts", "no ending"),
                        "Start, two because-points, finish."),
                rng -> hint(QBuilder.build(rng, "Building on someone’s idea sounds like…",
                                "Yes, and… plus a new reason",
                                "Add, do not just copy or block.",
                                "EASY", "skill-check",
                                "No, and I will not listen", "Whatever", "You are wrong, full stop"),
                        "Keep their idea, then add one new brick."),
                rng -> hint(QBuilder.build(rng, year >= 7
                                        ? "Rhetoric in a speech is mainly about…"
                                        : "A podcast listener needs you to…",
                                year >= 7 ? "how language is shaped for an audience and purpose"
                                        : "say names and steps clearly without a picture",
                                year >= 7 ? "Audience, purpose, tone." : "Audio has no facial clues.",
                                "HARD", "skill-check",
                                year >= 7 ? "only the microphone brand" : "whisper every word",
                                year >= 7 ? "skipping the audience" : "never pause",
                                "reading so fast the idea vanishes"),
                        year >= 7
                                ? "Who is listening, and what should they do or feel?"
                                : "Paint the step with words. Pause so they can follow."),
                rng -> hint(QBuilder.build(rng, "Evidence in talk is…",
                                "a fact, quote or example that supports the claim",
                                "Claim + because + evidence.",
                                "MEDIUM", "skill-check",
                                "a louder voice only", "a longer pause only", "changing the topic"),
                        "After because, give a thing they can check.")
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
