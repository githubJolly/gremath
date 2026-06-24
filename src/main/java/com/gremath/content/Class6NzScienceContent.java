package com.gremath.content;

import com.gremath.model.Lesson;
import com.gremath.model.Topic;

public class Class6NzScienceContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-science",
                "Class 6 Science (New Zealand Curriculum)",
                "Scientific thinking, living world, physical world, material world and Earth-space concepts for Year 6 learners.",
                "CLASS6_NZ",
                3
        );

        t.addLesson(new Lesson(
                "1. Scientific investigation skills",
                "<p>Science starts with questions, fair tests, careful observations and evidence-based conclusions.</p>"
                        + Doc.steps(
                        "Ask a testable question.",
                        "Change one variable at a time in a fair test.",
                        "Record data in a table and conclude from evidence."
                )
                        + Doc.key("A fair test keeps everything the same except one variable."),
                1
        ));

        t.addLesson(new Lesson(
                "2. Living things and ecosystems",
                "<p>Explore food chains, habitats, adaptation and how organisms depend on each other.</p>"
                        + Doc.analogy("An ecosystem is like a team where every role matters."),
                2
        ));

        t.addLesson(new Lesson(
                "3. States of matter and changes",
                "<p>Learn solids, liquids and gases, and reversible/irreversible changes.</p>"
                        + Doc.formula("Heating can cause melting/evaporation; cooling can cause condensation/freezing.")
                        + Doc.tip("Particle spacing and movement explain state changes."),
                3
        ));

        t.addLesson(new Lesson(
                "4. Forces and motion",
                "<p>Push, pull, friction, gravity and simple machines explain movement in everyday life.</p>"
                        + Doc.example("Friction", "A rough surface creates more friction than a smooth one."),
                4
        ));

        t.addLesson(new Lesson(
                "5. Earth, space and climate patterns",
                "<p>Understand day/night, seasons, weather variables and basic climate awareness.</p>"
                        + Doc.recap("Earth's rotation causes day and night; Earth's tilt around the Sun influences seasons."),
                5
        ));

        return t;
    }
}

