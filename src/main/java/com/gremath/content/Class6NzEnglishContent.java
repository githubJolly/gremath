package com.gremath.content;

import com.gremath.model.Lesson;
import com.gremath.model.Topic;

public class Class6NzEnglishContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-english",
                "Class 6 English (New Zealand Curriculum)",
                "Reading comprehension, writing structure, grammar, vocabulary and speaking/listening for Year 6 learners.",
                "CLASS6_NZ",
                2
        );

        t.addLesson(new Lesson(
                "1. Reading for meaning",
                "<p>Read closely to identify the main idea, key details and author purpose.</p>"
                        + Doc.steps(
                        "Read once for gist (overall meaning).",
                        "Read again and underline evidence.",
                        "Answer by quoting or paraphrasing specific lines."
                )
                        + Doc.tip("If two answers look right, pick the one best supported by text evidence."),
                1
        ));

        t.addLesson(new Lesson(
                "2. Building clear paragraphs",
                "<p>A strong paragraph has one main point, supporting details and a linking sentence.</p>"
                        + Doc.formula("Topic sentence -> Evidence/examples -> Explanation -> Link")
                        + Doc.example("Topic sentence", "Video games can help learning when used with purpose and limits."),
                2
        ));

        t.addLesson(new Lesson(
                "3. Grammar and punctuation essentials",
                "<p>Focus on sentence boundaries, capital letters, commas and subject-verb agreement.</p>"
                        + Doc.warn("Run-on sentences reduce clarity. Split long ideas into shorter complete sentences.")
                        + Doc.key("Every sentence needs a subject and a verb."),
                3
        ));

        t.addLesson(new Lesson(
                "4. Vocabulary and word choice",
                "<p>Use context clues and morphology (prefixes/suffixes) to decode unfamiliar words.</p>"
                        + Doc.steps(
                        "Look at words before and after the unknown word.",
                        "Identify roots, prefixes and suffixes.",
                        "Replace with a synonym and check if the sentence still makes sense."
                ),
                4
        ));

        t.addLesson(new Lesson(
                "5. Speaking and listening skills",
                "<p>Prepare ideas, speak clearly, and respond to others respectfully using evidence and reasons.</p>"
                        + Doc.recap("Listen to understand, then respond with reasons and examples."),
                5
        ));

        return t;
    }
}

