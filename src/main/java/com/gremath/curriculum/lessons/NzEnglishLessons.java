package com.gremath.curriculum.lessons;

import com.gremath.curriculum.LessonHtml;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * English Years 1–10 aligned to the 2025 NZC strands: oral language, reading and writing
 * (Years 0–8), then text studies and language studies (Years 9–10), with structured literacy.
 */
public final class NzEnglishLessons {

    private NzEnglishLessons() {
    }

    public static List<NzLessonSpec> forYear(int year) {
        List<NzLessonSpec> out = new ArrayList<>();
        out.add(lesson(year, 1, oralTitle(year), "Oral language", "ORAL", oral(year), oralStrat(year)));
        out.add(lesson(year, 2, readWordTitle(year), year <= 8 ? "Reading · word recognition" : "Text studies · literature",
                "READING", readWord(year), readStrat(year)));
        out.add(lesson(year, 3, readMeanTitle(year), year <= 8 ? "Reading · comprehension" : "Text studies · non-fiction & media",
                "READING", readMean(year), readStrat(year)));
        out.add(lesson(year, 4, writeTransTitle(year), year <= 8 ? "Writing · transcription" : "Language studies · written craft",
                "WRITING", writeTrans(year), writeStrat(year)));
        out.add(lesson(year, 5, writeCompTitle(year), year <= 8 ? "Writing · composition" : "Language studies · oral & visual",
                "WRITING", writeComp(year), writeStrat(year)));
        out.add(lesson(year, 6, langTitle(year), year <= 8 ? "Language conventions" : "Language studies · critical literacy",
                "GRAMMAR", language(year), langStrat(year)));
        return out;
    }

    private static NzLessonSpec lesson(int year, int order, String title, String strand, String kind, String html, String strat) {
        return new NzLessonSpec(order, order + ". " + title, strand, html,
                "nz-" + year + "-" + NzSubject.ENGLISH.slug() + "-" + order, strat, kind);
    }

    private static String oralTitle(int y) {
        return switch (y) {
            case 1 -> "Listening, taking turns and sharing news";
            case 2 -> "Asking questions and retelling in order";
            case 3 -> "Group discussion: building on others' ideas";
            case 4 -> "Explaining a process so a listener can follow";
            case 5 -> "Discussion with evidence from a text";
            case 6 -> "Presenting a short talk with a clear purpose";
            case 7 -> "Formal discussion and respectful challenge";
            case 8 -> "Seminar talk: claim, evidence, response";
            case 9 -> "Rhetoric in speech: audience, purpose, tone";
            default -> "Oral texts: speeches, podcasts and performance";
        };
    }

    private static String readWordTitle(int y) {
        return switch (y) {
            case 1 -> "Letters, sounds and blending (structured literacy)";
            case 2 -> "Grapheme–phoneme correspondences and fluency";
            case 3 -> "Longer words: morphology beginning (un-, -ing, -ed)";
            case 4 -> "Syllables, prefixes and fluent decoding";
            case 5 -> "Morphology: roots, prefixes and suffixes";
            case 6 -> "Academic word families and morphology";
            case 7 -> "Etymology and subject-specific vocabulary in texts";
            case 8 -> "Reading complex sentences without losing the subject";
            case 9 -> "Literary tradition: how stories echo other stories";
            default -> "New Zealand and world literature: context and craft";
        };
    }

    private static String readMeanTitle(int y) {
        return switch (y) {
            case 1 -> "Making meaning from pictures, captions and simple stories";
            case 2 -> "Retelling: characters, setting and what happened";
            case 3 -> "Main idea and key details in short texts";
            case 4 -> "Inference: using clues the author left";
            case 5 -> "Purpose, audience and point of view";
            case 6 -> "Comparing two texts on a similar idea";
            case 7 -> "Analysing how structure and language shape meaning";
            case 8 -> "Evaluating arguments and finding bias";
            case 9 -> "Non-fiction and media: how texts position you";
            default -> "Critical reading of digital, visual and print media";
        };
    }

    private static String writeTransTitle(int y) {
        return switch (y) {
            case 1 -> "Letter formation, finger spaces and full stops";
            case 2 -> "Encoding sounds, high-frequency words and handwriting fluency";
            case 3 -> "Spelling patterns and sentence boundaries";
            case 4 -> "Paragraphing and accurate punctuation in drafts";
            case 5 -> "Complex sentences and dialogue punctuation";
            case 6 -> "Cohesion: pronouns, connectives and tense control";
            case 7 -> "Control of clause types and academic spelling";
            case 8 -> "Register: matching spelling and punctuation to purpose";
            case 9 -> "Crafting sentences for effect: rhythm, emphasis, economy";
            default -> "Style, voice and editing for a public audience";
        };
    }

    private static String writeCompTitle(int y) {
        return switch (y) {
            case 1 -> "Captions, lists and a complete sentence about a picture";
            case 2 -> "Recounts: beginning, middle and end";
            case 3 -> "Simple explanations and descriptions";
            case 4 -> "Paragraphs with a topic sentence";
            case 5 -> "Persuasion with reasons and examples";
            case 6 -> "Explanations and arguments with evidence";
            case 7 -> "Text types: recount, report, argument, narrative craft";
            case 8 -> "Sustained writing with planning and revision cycles";
            case 9 -> "Literary and transactional writing for audience";
            default -> "Crafting texts across written, oral and visual modes";
        };
    }

    private static String langTitle(int y) {
        return switch (y) {
            case 1 -> "Capitals, full stops and the idea of a sentence";
            case 2 -> "Nouns, verbs and question marks";
            case 3 -> "Adjectives, commas in lists and agreement";
            case 4 -> "Apostrophes, speech marks and compound sentences";
            case 5 -> "Clauses, commas for meaning and tense";
            case 6 -> "Passive voice beginning, cohesive devices, nuance";
            case 7 -> "Nominalisation and academic sentence combining";
            case 8 -> "Rhetoric at sentence level: parallelism, contrast";
            case 9 -> "Stylistic analysis: how grammar creates voice";
            default -> "Critical literacy: who is speaking, who is silenced";
        };
    }

    private static String oral(int y) {
        String extra = y <= 3
                ? LessonHtml.p("In Years 0–3, oral language is a foundation of the English learning area: children learn shared codes (turn-taking, asking, retelling) that later support reading and writing. NZSL and AAC are valid oral-language modes.")
                : y <= 6
                ? LessonHtml.p("Years 4–6 use talk to build knowledge: discussion is not a rest from literacy. You practise putting evidence into speech ('the text says…') so writing later has the same habit.")
                : y <= 8
                ? LessonHtml.p("Years 7–8 move toward subject-English talk: claims, counter-claims, and listening that is active (paraphrase, then respond). Formal presentations need a structure the audience can hear.")
                : LessonHtml.p("Years 9–10 treat speeches, debates, podcasts and performance as texts you both study and create. Audience, purpose and kairos (the right moment) matter as much as volume.");
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Oral language",
                new String[]{"Listen to understand, then add a reason or example.",
                        y <= 2 ? "Take turns and use a strong speaking voice." : "Adapt tone and vocabulary to audience and purpose.",
                        y >= 6 ? "Support opinions with evidence from a text or experience." : "Retell in a clear order so a listener can follow."},
                LessonHtml.p("Talk is thinking made public. A good speaker also listens: you cannot build on an idea you did not hear. Year " + y + " talk should match the classroom's purpose — news, discussion, explanation or debate.")
                        + extra
                        + LessonHtml.p("I-statements and because-clauses keep disagreement respectful: 'I think the ending is sad because the last line repeats the first.' Eye contact, pace and a pause at the end help listeners in Aotearoa classrooms that include many first languages."),
                "Pepeha, mihi and waiata are oral texts with tikanga. Learn the purpose (who is addressed, what is offered) rather than treating te reo as decoration.",
                new String[]{"Know your purpose (share, explain, persuade, perform).",
                        "Listen fully before you reply.",
                        "Add a reason, example or quotation.",
                        "Check the audience understood — watch faces, invite a question."},
                "A strong discussion move",
                "I agree with Ana because page 4 says the river was 'angry' — that word makes the storm feel alive.",
                y <= 3 ? "Sharing news" : "A 60-second talk",
                y <= 3 ? "Start with who/what, then one event, then how you felt. Three sentences can be enough if they are complete."
                        : "Opening hook, two points with evidence, one-sentence close. Practise aloud once before presenting.",
                null,
                "Waiting to talk instead of listening — you will repeat someone or miss the idea you needed.",
                "Record yourself for 20 seconds. If you cannot hear the ends of words, slow down.",
                "Listen, add evidence, match the talk to the audience. Year " + y + " oral language is a curriculum strand, not a side activity.",
                y <= 3 ? "turn-taking, retell, question, listen, because" : "audience, purpose, evidence, register, rebuttal");
    }

    private static String readWord(int y) {
        if (y >= 9) {
            return LessonHtml.teach(LessonHtml.phaseLabel(y), "Text studies · literature",
                    new String[]{"Identify literary features (image, motif, structure, narrative voice).",
                            "Connect a text to historical, cultural or social context, including Aotearoa voices.",
                            "Explain how a technique shapes a reader's response."},
                    LessonHtml.p("Text Studies in Years 9–10 expands literary and non-fiction forms. Literature uses recurring features — metaphor, juxtaposition, unreliable narrators — that later writers echo (literary tradition).")
                            + LessonHtml.p("New Zealand's bicultural and multicultural heritage is not an optional extra. Reading Patricia Grace, Witi Ihimaera, Hone Tuwhare, or contemporary Pasifika and Asian NZ writers alongside Shakespeare or a global novel shows how place and language shape story.")
                            + LessonHtml.p("Technique without effect is name-dropping. Always finish: the metaphor of the river as ancestor makes the land feel alive, so the reader feels the cost of the dam."),
                    "Aotearoa texts often sit on whenua and whakapapa. Notice how setting is not backdrop — it can be a character.",
                    new String[]{"Read once for story, again for craft.", "Annotate a technique and a quotation.", "Link to context (when, who, for whom).", "State the effect on a reader."},
                    "Motif",
                    "A repeated image (birds, fences, the sea) gathers meaning. Track three appearances and what has changed.",
                    "Context",
                    "A 1970s story about urban Māori migration reads differently if you know the 'urban drift' history — context is not a spoiler, it is a lens.",
                    null,
                    "Listing techniques (alliteration, simile) with no effect. Markers reward analysis, not spotting.",
                    "Use short quotations. A three-word phrase you unpack beats a copied paragraph.",
                    "Literature: craft + context + effect, with Aotearoa voices in the mix.",
                    "motif, narrative voice, context, literary tradition, effect");
        }
        String morph = y <= 2
                ? "Year " + y + " emphasises phoneme–grapheme correspondences, blending and segmenting, and high-frequency words taught explicitly — not guessed from pictures alone."
                : y <= 6
                ? "Morphology (prefixes, roots, suffixes) becomes a decoding and vocabulary engine. un- + happy + -ness is a readable structure, not a mystery string."
                : "By Year " + y + " you still decode, but the bottleneck is usually syntax and vocabulary in long sentences. Chunk the sentence: find the subject and the main verb first.";
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Reading · word recognition",
                new String[]{y <= 3 ? "Blend phonemes to read words and segment to spell." : "Use morphology and syllables to attack unfamiliar words.",
                        "Read with increasing fluency so working memory is free for meaning.",
                        "Use a structured strategy when a word looks unfamiliar (sound, word parts, then check meaning)."},
                LessonHtml.p("The 2025 English learning area is explicit: word recognition is taught through structured literacy approaches. Pictures help meaning; they should not replace sounding out in the early years.")
                        + LessonHtml.p(morph)
                        + LessonHtml.p("Fluency is accuracy + automaticity + expression. A student who 'reads' fast but invents words is not fluent. Year " + y + " practice is rereading familiar text as well as tackling new text."),
                "Many te reo Māori loanwords in English (kia ora, whānau, mahi) need correct pronunciation. Macrons change meaning — that is phonology too.",
                new String[]{"Look at all the letters (or syllables), not just the first.",
                        "Blend or break into prefix / root / suffix.",
                        "Check: does it make sense in the sentence?",
                        "Reread the sentence smoothly."},
                y <= 3 ? "Blending" : "Morphology",
                y <= 3 ? "s-t-o-p → stop. If you say 'spot', you used the letters in the wrong order. Point under each grapheme."
                        : "Unhappiness = un- + happy + -ness (the state of not being happy). The parts give both pronunciation and meaning.",
                "Fluency check",
                "If you cannot answer a meaning question, it may be a decoding issue. Slow down, decode, then reread for meaning.",
                null,
                "Guessing from the picture and skipping the printed word. That habit collapses in books with fewer pictures.",
                "When stuck, cover the word, reveal grapheme by grapheme (or syllable by syllable).",
                "Structured decoding plus fluency frees the mind to comprehend. Year " + y + ".",
                y <= 3 ? "phoneme, grapheme, blend, segment, fluency" : "morphology, prefix, suffix, root, syllable, etymology");
    }

    private static String readMean(int y) {
        if (y >= 9) {
            return LessonHtml.teach(LessonHtml.phaseLabel(y), "Text studies · non-fiction & media",
                    new String[]{"Identify how a news, advertising or digital text is constructed.",
                            "Explain how selection, omission and framing position an audience.",
                            "Compare two non-fiction treatments of the same event or issue."},
                    LessonHtml.p("Media and digital texts are designed. Headlines, thumbnails, music, comments and algorithms all shape what you notice. Critical reading asks: who made this, for whom, what is missing?")
                            + LessonHtml.p("Aotearoa media include Māori Television/Whakaata Māori, student journalism, and social posts about local issues (water, housing, sport). The same event can be a 'protest' in one outlet and a 'hīkoi' in another — diction is a choice.")
                            + LessonHtml.p("Non-fiction still uses literary techniques (anecdote, statistic, expert voice). Evaluate evidence quality: sample size, date, conflict of interest."),
                    "Te Tiriti stories in textbooks vs iwi accounts are a comparison task: whose voice is centred?",
                    new String[]{"Identify form (news, advert, vlog, infographic).", "List three design choices.", "Ask what is omitted.", "Judge the claim against evidence."},
                    "Headline vs article",
                    "If the headline says 'chaos' and the article describes a permitted march, the headline is positioning you before you read.",
                    "Two reports, one event",
                    "Highlight verbs: 'claimed' vs 'showed'. Verbs encode how much the writer trusts the source.",
                    null,
                    "Treating the first Google result as neutral. Search order is not a truth ranking.",
                    "Write the maker, date and purpose at the top of your notes before you quote.",
                    "Media literacy is text studies: construction, positioning, evidence.",
                    "framing, omission, audience, positioning, bias, evidence");
        }
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Reading · comprehension",
                new String[]{"Read once for gist, again for details and evidence.",
                        y <= 3 ? "Retell who, where and what happened." : "Infer using clues in the text, not only your life.",
                        y >= 5 ? "Comment on purpose, audience or point of view." : "Answer with a word or sentence from the text when asked."},
                LessonHtml.p("Comprehension is making meaning. It is not a memory test of random facts. Year " + y + " readers preview title and pictures, read for gist, then reread to hunt evidence.")
                        + LessonHtml.p(y <= 4
                        ? "Literal questions are answered in the words of the text. Inferential questions need a clue plus your reasoning: the author did not say 'sad' but the character 'stared at the empty flax kete'."
                        : "As texts get denser, track pronoun reference (who is 'they'?), time shifts, and implied attitude. Purpose might be to entertain, explain, persuade or a mix.")
                        + LessonHtml.p("If two multiple-choice answers look right, choose the one the text actually supports. Your world knowledge helps, but it cannot replace a missing clue."),
                "Stories set on a beach, in the bush, or in a city suburb of Aotearoa should be read with local knowledge — but still quote the page, not only 'I know because I live here'.",
                new String[]{"Preview title, headings and pictures.", "Read for gist.", "Reread the relevant paragraph for the question.", "Answer with a quotation or a close paraphrase."},
                "Gist vs detail",
                "Gist: the story is about a lost dog coming home. Detail: it came home at dusk, wet, with a torn collar — that detail might later explain a later event.",
                "Inference",
                "The windows were dark and the milk bottles were still out. You can infer the family is away — the text did not say 'holiday' in those words.",
                null,
                "Answering from your own experience when the question said 'according to the text'.",
                "Underline the sentence that proves your answer before you write it.",
                "Gist, evidence, then inference. Year " + y + " comprehension is a reread, not a lucky skim.",
                "gist, literal, inference, evidence, purpose, point of view");
    }

    private static String writeTrans(int y) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), y <= 8 ? "Writing · transcription" : "Language studies · written craft",
                new String[]{y <= 2 ? "Form letters, leave spaces, end with a full stop." : "Spell and punctuate so a reader is not working against you.",
                        y <= 6 ? "Control sentence boundaries: one main idea, a subject and a verb." : "Use clause control and punctuation for rhythm and clarity.",
                        "Edit in a second pass — do not try to invent and proofread in one breath."},
                LessonHtml.p("Transcription is the motor skill and encoding side of writing: handwriting or keyboarding, spelling, punctuation. Composition (ideas) suffers if transcription is overloaded. Year " + y + " still needs automaticity.")
                        + LessonHtml.p(y <= 3
                        ? "A sentence starts with a capital and ends with . ? or !  Finger spaces show where words end. Encoding uses the same grapheme–phoneme knowledge as reading."
                        : y <= 8
                        ? "Run-ons (two sentences jammed together) and fragments (missing a verb) are the main Year 4–8 boundary errors. Dialogue needs speech marks and a new line for a new speaker in most school styles."
                        : "Craft is punctuation as meaning: a dash for interruption, a colon to introduce proof, a semicolon to balance two close ideas. Voice is partly grammar.")
                        + LessonHtml.p("Spellcheckers miss homophones (their/there/they're) and names. Read aloud: your ear hears the missing full stop."),
                "Māori words in English sentences keep macrons where they belong (Māori, Tāmaki Makaurau). That is accuracy, not decoration.",
                new String[]{"Draft for ideas first if stuck, but leave space to edit.", "Read aloud, pointing at each stop.", "Fix one category at a time (stops, then capitals, then spelling).", "Check names, macrons and homophones."},
                "Run-on",
                "Wrong: We went to the beach it was hot. Right: We went to the beach. It was hot. / We went to the beach because it was hot.",
                y <= 4 ? "Capital letters" : "A crafted sentence",
                y <= 4 ? "Names, I, and sentence starts take capitals. 'Kia ora' at the start of a sentence still needs a capital K in English-sentence context as taught in your class."
                        : "Short sentences punch. Long sentences need a backbone: subject, verb, then carefully attached clauses.",
                null,
                "Editing while drafting every word — fluency dies. Park spelling with a squiggle and return.",
                "The 'read it backwards sentence by sentence' trick catches missing stops.",
                "Transcription accuracy is respect for the reader. Year " + y + ".",
                y <= 3 ? "capital, full stop, space, encoding, letter formation" : "clause, cohesion, homophone, register, macron");
    }

    private static String writeComp(int y) {
        return LessonHtml.teach(LessonHtml.phaseLabel(y), y <= 8 ? "Writing · composition" : "Language studies · multimodal",
                new String[]{"Know purpose and audience before you draft.",
                        y <= 3 ? "Sequence ideas: beginning, middle, end (or first, then, last)." : "Plan paragraphs or sections, each with one job.",
                        "Improve one thing in a rewrite: clearer opening, stronger evidence, or tighter ending."},
                LessonHtml.p("Composition is choosing ideas and organising them. Year " + y + " writers plan — even a three-box sketch counts. Audience might be a classmate, whānau, a principal, or a public blog.")
                        + LessonHtml.p(y <= 4
                        ? "Recounts use time order. Descriptions zoom in on senses. A caption is a tiny text with a job: tell what the picture does not."
                        : y <= 8
                        ? "A paragraph: topic sentence, evidence or example, explanation, optional link. Arguments need reasons, not volume. Narratives need a change (something is different at the end)."
                        : "Years 9–10 create across modes: written essay, oral, visual storyboard, digital post. The same idea can be a speech or an editorial — form follows purpose.")
                        + LessonHtml.p("Revision is not copying out neatly. It is changing order, cutting repetition, and replacing vague words (nice, things, stuff) with precise ones."),
                "Writing about local places (awa, maunga, the school marae if you have one) is composing with whenua in mind — still plan for a reader who was not there.",
                new String[]{"Note purpose, audience, form.", "Jot 3–5 ideas and order them.", "Draft without stopping for perfection.", "Revise structure, then edit surface features."},
                "Topic sentence",
                "School lunches work better when students help plan the menu. That sentence tells the paragraph's job; examples follow.",
                y <= 3 ? "A three-sentence recount" : "One improvement pass",
                y <= 3 ? "We went to the rocky shore. We found paua shells. I was careful on the wet rocks."
                        : "Circle every 'very' and 'nice'. Replace two of them. If nothing changes, the writing had no precise nouns.",
                null,
                "Starting without knowing who will read it. Tone for a friend is not tone for a Board of Trustees letter.",
                "If stuck, talk the paragraph to a partner, then write what you said.",
                "Plan, draft, revise, edit. Purpose and audience first. Year " + y + ".",
                "purpose, audience, paragraph, recount, argue, revise");
    }

    private static String language(int y) {
        if (y >= 9) {
            return LessonHtml.teach(LessonHtml.phaseLabel(y), "Critical literacy",
                    new String[]{"Ask who is speaking, to whom, and who is left out.",
                            "Notice how grammar and diction encode power (passive voice hiding the actor).",
                            "Use that noticing in your own writing so you do not accidentally silence a group."},
                    LessonHtml.p("Critical literacy is not 'being negative'. It is reading how language constructs the world. 'Mistakes were made' hides who made them. 'Māori failed the test' vs 'the test failed to recognise te reo speakers' frames blame differently.")
                            + LessonHtml.p("Years 9–10 Language Studies include how texts participate in national conversations. Stereotypes of rural, urban, Pasifika, Asian, disabled, or rainbow communities can be reproduced in a single adjective.")
                            + LessonHtml.p("You still need accurate grammar — critique without control is just opinion. The two strands work together."),
                    "Reporting on Te Tiriti, climate, or sport in Aotearoa is a live critical-literacy field. Name sources; notice whose interview never appears.",
                    new String[]{"Highlight the verbs and who they attach to.", "List groups mentioned and groups absent.", "Rewrite one sentence to change the frame.", "Keep evidence; do not invent offence that is not in the text."},
                    "Passive voice",
                    "The whenua was taken. vs The Crown took the whenua. The second names an actor.",
                    "Loaded diction",
                    "Youths vs rangatahi vs kids — each word positions the reader.",
                    null,
                    "Attacking the writer instead of analysing the language. Stay on the text.",
                    "One rewritten sentence is a better exercise than a rant.",
                    "Critical literacy: language constructs reality; you can name how.",
                    "framing, diction, passive voice, positioning, silence, power");
        }
        return LessonHtml.teach(LessonHtml.phaseLabel(y), "Language conventions",
                new String[]{"Write complete sentences with subject–verb agreement.",
                        y <= 2 ? "Use capitals and end punctuation reliably." : "Choose punctuation that protects meaning (including commas and apostrophes as taught this year).",
                        "Build vocabulary with context clues and word parts."},
                LessonHtml.p("Grammar is a meaning tool, not a trap. 'Let's eat, Grandma' vs 'Let's eat Grandma' is a famous comma that saves a life. Year " + y + " conventions match the teaching sequence: start with sentence sense, then add the marks that show pauses and ownership.")
                        + LessonHtml.p("Agreement: she walks, they walk. Tense: stay in the same time unless you have a reason to shift. Vocabulary: the best word is the precise one, not the longest.")
                        + LessonHtml.p("Word-building: prefixes (un-, re-, mis-), suffixes (-less, -ful, -tion) and roots give you a dictionary inside the word."),
                "Bilingual puns and kupu hou (new words) in English–te reo classrooms are vocabulary too — ask what the word does, not only what it 'is in English'.",
                new String[]{"Find the subject and the verb.", "Check end punctuation.", "Check agreement and tense.", "Replace one vague word with a precise one."},
                "Agreement",
                "The tamariki are playing (plural). The child is playing (singular).",
                "Apostrophe (from Year 4)",
                "The dog's bowl (one dog). The dogs' park (many dogs). It's = it is; its = belonging to it.",
                null,
                "Sprinkling commas wherever you breathe. Commas are structure, not lung capacity.",
                "Read the sentence without the extra clause. If it still works, the grammar is probably sound.",
                "Complete sentences, agreement, and precise words. Year " + y + " conventions serve meaning.",
                "subject, verb, agreement, tense, apostrophe, morphology");
    }

    private static String oralStrat(int y) {
        return LessonHtml.strategy("oral language",
                new String[]{"Know the purpose of the talk.", "Listen before you add.", "Give a reason or example.", "Watch the audience and adjust pace."},
                "planning your reply instead of hearing the last speaker");
    }

    private static String readStrat(int y) {
        return LessonHtml.strategy("reading",
                new String[]{"Decode or annotate first so the words are actually the words.", "Gist, then evidence.", "Use a quotation or close paraphrase.", "Check the question asked for literal, inferential or evaluative meaning."},
                "choosing the answer that feels true in life but is not in the text");
    }

    private static String writeStrat(int y) {
        return LessonHtml.strategy("writing",
                new String[]{"Purpose and audience.", "Plan order.", "Draft.", "Revise ideas, then edit conventions."},
                "trying to invent, organise and proofread in a single pass");
    }

    private static String langStrat(int y) {
        return LessonHtml.strategy("language",
                new String[]{"Find subject and verb.", "Check stops and capitals.", "Check agreement/tense.", "Tighten one imprecise word."},
                "naming a technique without saying what it does to meaning");
    }
}
