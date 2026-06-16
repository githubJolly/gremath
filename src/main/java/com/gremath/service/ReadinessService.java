/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Service
 */
package com.gremath.service;

import com.gremath.dto.ReadinessSnapshot;
import com.gremath.model.PracticeAttempt;
import com.gremath.model.SheetAttempt;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReadinessService {
    public ReadinessSnapshot estimate(List<PracticeAttempt> topicHistory, List<SheetAttempt> sheetHistory) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        topicHistory.forEach(a -> scores.add(a.getPercentage()));
        sheetHistory.forEach(a -> scores.add(a.getPercentage()));
        if (scores.isEmpty()) {
            return new ReadinessSnapshot(5, 3, 0, 0, 0, 0, 0, 0, 0, 0, "Build foundation");
        }
        int attempts = scores.size();
        int average = Math.round((float)scores.stream().mapToInt(Integer::intValue).sum() / (float)attempts);
        int recent = this.recentAverage(scores, 10);
        int best = scores.stream().mapToInt(Integer::intValue).max().orElse(0);
        double consistency = this.consistencyScore(scores);
        double completion = Math.min(1.0, (double)attempts / 120.0);
        double accuracySignal = ((double)average * 0.5 + (double)recent * 0.3 + (double)best * 0.2) / 100.0;
        double readiness = 100.0 * (0.65 * accuracySignal + 0.2 * completion + 0.15 * (consistency / 100.0));
        int readinessScore = this.clamp((int)Math.round(readiness), 0, 100);
        int accuracyComponent = this.clamp((int)Math.round(accuracySignal * 100.0), 0, 100);
        int consistencyComponent = this.clamp((int)Math.round(consistency), 0, 100);
        int completionComponent = this.clamp((int)Math.round(completion * 100.0), 0, 100);
        int greProbability = this.clamp((int)Math.round(5.0 + (double)readinessScore * 0.82), 5, 92);
        int catProbability = this.clamp((int)Math.round(3.0 + (double)readinessScore * 0.74), 3, 86);
        int confidence = this.clamp((int)Math.round(Math.min(100.0, (double)attempts * 2.2)), 0, 100);
        return new ReadinessSnapshot(greProbability, catProbability, readinessScore, confidence, attempts, average, recent, accuracyComponent, consistencyComponent, completionComponent, this.band(readinessScore));
    }

    private int recentAverage(List<Integer> scores, int window) {
        int n = scores.size();
        int from = Math.max(0, n - window);
        int sum = 0;
        for (int i = from; i < n; ++i) {
            sum += scores.get(i).intValue();
        }
        return Math.round((float)sum / (float)(n - from));
    }

    private double consistencyScore(List<Integer> scores) {
        if (scores.size() < 2) {
            return 60.0;
        }
        double avg = scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double variance = 0.0;
        for (int s : scores) {
            double d = (double)s - avg;
            variance += d * d;
        }
        double std = Math.sqrt(variance /= (double)scores.size());
        return Math.max(0.0, 100.0 - std * 2.2);
    }

    private int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    private String band(int score) {
        if (score >= 80) {
            return "Exam-ready";
        }
        if (score >= 65) {
            return "Strong progress";
        }
        if (score >= 45) {
            return "Developing";
        }
        return "Build foundation";
    }
}

