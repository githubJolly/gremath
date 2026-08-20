package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

public class Class6NzScienceContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-science",
                "Year 6 Science (New Zealand Curriculum)",
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
                1,
                NzCurriculumCatalog.practiceKey(6, NzSubject.SCIENCE, 1),
                strategy("Name the variable you change, and what you keep the same.")
        ));

        t.addLesson(new Lesson(
                "2. Living things and ecosystems",
                "<p>Explore food chains, habitats, adaptation and how organisms depend on each other.</p>"
                        + Doc.analogy("An ecosystem is like a team where every role matters."),
                2,
                NzCurriculumCatalog.practiceKey(6, NzSubject.SCIENCE, 2),
                strategy("Think habitat, food relationships, and useful features.")
        ));

        t.addLesson(new Lesson(
                "3. States of matter and changes",
                "<p>Learn solids, liquids and gases, and reversible/irreversible changes.</p>"
                        + Doc.formula("Heating can cause melting/evaporation; cooling can cause condensation/freezing.")
                        + Doc.tip("Particle spacing and movement explain state changes."),
                3,
                NzCurriculumCatalog.practiceKey(6, NzSubject.SCIENCE, 3),
                strategy("Is it a state change, a mix, or a new substance?")
        ));

        t.addLesson(new Lesson(
                "4. Forces and motion",
                "<p>Push, pull, friction, gravity and simple machines explain movement in everyday life.</p>"
                        + Doc.example("Friction", "A rough surface creates more friction than a smooth one."),
                4,
                NzCurriculumCatalog.practiceKey(6, NzSubject.SCIENCE, 4),
                strategy("Name the force and the direction it acts.")
        ));

        t.addLesson(new Lesson(
                "5. Earth, space and climate patterns",
                "<p>Understand day/night, seasons, weather variables and basic climate awareness.</p>"
                        + Doc.recap("Earth's rotation causes day and night; Earth's tilt around the Sun influences seasons."),
                5,
                NzCurriculumCatalog.practiceKey(6, NzSubject.SCIENCE, 5),
                strategy("Link the observation to Earth's motion or atmosphere.")
        ));

        return t;
    }

    private static String strategy(String lead) {
        return "<p>" + lead + "</p>"
                + Doc.steps(
                "Read the science idea in the question.",
                "Match it to a model (fair test, food chain, particles, force, Earth system).",
                "Eliminate answers that break the model.",
                "Check units and everyday sense.");
    }
}
