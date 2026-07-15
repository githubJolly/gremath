package com.gremath.dto;

import java.util.List;

public class ParentProgressSnapshot {
    private final int overallPercent;
    private final int practiceSessions;
    private final int strongAreas;
    private final int focusAreasCount;
    private final String summary;
    private final List<FocusArea> needsFocus;
    private final List<FocusArea> goingWell;

    public ParentProgressSnapshot(int overallPercent, int practiceSessions, int strongAreas, int focusAreasCount,
                                  String summary, List<FocusArea> needsFocus, List<FocusArea> goingWell) {
        this.overallPercent = overallPercent;
        this.practiceSessions = practiceSessions;
        this.strongAreas = strongAreas;
        this.focusAreasCount = focusAreasCount;
        this.summary = summary;
        this.needsFocus = needsFocus;
        this.goingWell = goingWell;
    }

    public int getOverallPercent() {
        return overallPercent;
    }

    public int getPracticeSessions() {
        return practiceSessions;
    }

    public int getStrongAreas() {
        return strongAreas;
    }

    public int getFocusAreasCount() {
        return focusAreasCount;
    }

    public String getSummary() {
        return summary;
    }

    public List<FocusArea> getNeedsFocus() {
        return needsFocus;
    }

    public List<FocusArea> getGoingWell() {
        return goingWell;
    }
}
