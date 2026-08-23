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
    void tensFrameAndBalanceScaleRender() {
        String frame = MathFigures.tensFrame(8, "Eight on a tens frame");
        assertTrue(frame.contains("<svg"));
        assertTrue(frame.contains("circle"));
        assertTrue(frame.contains("Eight on a tens frame"));
        String scale = MathFigures.balanceScale("7 + □", "12", "Both sides balance");
        assertTrue(scale.contains("<svg"));
        assertTrue(scale.contains("7 +"));
        assertTrue(scale.contains("Both sides balance"));
    }

    @Test
    void subjectFiguresAreInlineSvgWithCaptions() {
        String fig = SubjectFigures.foodChain("Energy moves along the arrows.");
        assertTrue(fig.contains("<svg"));
        assertTrue(fig.contains("pīwakawaka") || fig.contains("piwakawaka") || fig.contains("harakeke"));
        assertTrue(fig.contains("Energy moves along the arrows."));
        assertFalse(fig.contains("<script"));
    }

    @Test
    void illustratedStemsCanExceedOldVarcharLimit() {
        String stem = MathFigures.ask("Which point is marked?",
                MathFigures.coordinatePoint(6, 8, "Along x first, then up y."));
        assertTrue(stem.length() > 2000,
                "Illustrated stems must be stored as CLOB, len=" + stem.length());
    }

    @Test
    void extraSubjectFiguresRender() {
        assertTrue(SubjectFigures.plantParts("Name the parts").contains("<svg"));
        assertTrue(SubjectFigures.waterCycle("Sea to cloud").contains("<svg"));
        assertTrue(SubjectFigures.circuit("Complete loop").contains("<svg"));
        assertTrue(SubjectFigures.storyMountain("Start, problem, end").contains("<svg"));
        assertTrue(SubjectFigures.sentenceParts("Who did what").contains("<svg"));
    }
}
