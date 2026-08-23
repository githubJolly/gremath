package com.gremath.dto;

public class SubjectScore {
    private final String subject;
    private final int averagePercent;
    private final int sessions;
    private final String latestLesson;

    public SubjectScore(String subject, int averagePercent, int sessions, String latestLesson) {
        this.subject = subject;
        this.averagePercent = averagePercent;
        this.sessions = sessions;
        this.latestLesson = latestLesson;
    }

    public String getSubject() {
        return subject;
    }

    public int getAveragePercent() {
        return averagePercent;
    }

    public int getSessions() {
        return sessions;
    }

    public String getLatestLesson() {
        return latestLesson;
    }
}
