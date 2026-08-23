package com.gremath.curriculum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathFiguresTest {

    @Test
    void diagramsAreInlineSvgWithCaptions() {
        String fig = MathFigures.rectangle(8, 5, "A labelled rectangle");
        assertTrue(fig.contains("<svg"));
        assertTrue(fig.contains("8 cm"));
        assertTrue(fig.contains("A labelled rectangle"));
        assertFalse(fig.contains("<script"));
    }

    @Test
    void askWrapsPromptAndFigure() {
        String html = MathFigures.ask("Find the area.", MathFigures.rightTriangle(6, 4, null, "Right triangle"));
        assertTrue(html.contains("q-stem"));
        assertTrue(html.contains("Find the area."));
        assertTrue(html.contains("<svg"));
    }

    @Test
    void subjectFiguresAreInlineSvgWithCaptions() {
        String fig = SubjectFigures.foodChain("Energy moves along the arrows.");
        assertTrue(fig.contains("<svg"));
        assertTrue(fig.contains("pīwakawaka") || fig.contains("piwakawaka") || fig.contains("harakeke"));
        assertTrue(fig.contains("Energy moves along the arrows."));
        assertFalse(fig.contains("<script"));
    }
}
