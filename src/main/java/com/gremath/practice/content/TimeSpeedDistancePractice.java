/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class TimeSpeedDistancePractice {
    private static final String TOPIC = "time-speed-distance";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom"};
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";
    private static final int[][] HM_PAIRS = new int[][]{{40, 60}, {30, 60}, {20, 30}, {10, 40}, {20, 80}, {15, 30}, {12, 24}, {45, 30}, {60, 30}, {50, 30}};

    private TimeSpeedDistancePractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(TimeSpeedDistancePractice.basics());
        reg.add(TimeSpeedDistancePractice.units());
        reg.add(TimeSpeedDistancePractice.averageSpeed());
        reg.add(TimeSpeedDistancePractice.relative());
        reg.add(TimeSpeedDistancePractice.boats());
    }

    private static String s(int v) {
        return Integer.toString(v);
    }

    private static LessonPractice basics() {
        LessonPractice lp = new LessonPractice("tsd-basics", TOPIC, "The one relationship behind everything");
        lp.concept(rng -> {
            int speed = QBuilder.pick(rng, 40, 45, 50, 60, 70, 80);
            int time = QBuilder.range(rng, 2, 8);
            int dist = speed * time;
            return QBuilder.build(rng, "A car travels " + dist + " km in " + time + " hours. What is its speed?", speed + " km/h", "Speed = distance \u00f7 time = " + dist + " \u00f7 " + time + " = " + speed + " km/h.", "EASY", EX, speed + 5 + " km/h", speed - 5 + " km/h", dist / (time + 1) + " km/h", speed + 10 + " km/h");
        }, rng -> {
            int speed = QBuilder.pick(rng, 30, 40, 50, 60, 75);
            int time = QBuilder.range(rng, 2, 9);
            int dist = speed * time;
            return QBuilder.build(rng, "Travelling at " + speed + " km/h for " + time + " hours, how far do you go?", dist + " km", "Distance = speed \u00d7 time = " + speed + " \u00d7 " + time + " = " + dist + " km.", "EASY", EX, speed + time + " km", dist + speed + " km", dist - speed + " km", speed * (time + 1) + " km");
        }, rng -> {
            int speed = QBuilder.pick(rng, 20, 25, 40, 50, 60);
            int time = QBuilder.range(rng, 2, 8);
            int dist = speed * time;
            return QBuilder.build(rng, "How long does it take to travel " + dist + " km at " + speed + " km/h?", time + " hours", "Time = distance \u00f7 speed = " + dist + " \u00f7 " + speed + " = " + time + " hours.", "EASY", EX, time + 1 + " hours", time - 1 + " hours", dist + " hours", time + 2 + " hours");
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int speed = QBuilder.pick(rng, 4, 5, 6, 8);
            int time = QBuilder.range(rng, 2, 6);
            int dist = speed * time;
            return QBuilder.build(rng, name + " walks at " + speed + " km/h for " + time + " hours. How far does " + name + " walk?", dist + " km", "Distance = " + speed + " \u00d7 " + time + " = " + dist + " km.", "EASY", WP, speed + time + " km", dist + speed + " km", dist - speed + " km", dist + time + " km");
        }, rng -> {
            int s1 = QBuilder.pick(rng, 40, 50, 60);
            int t1 = QBuilder.range(rng, 1, 3);
            int s2 = QBuilder.pick(rng, 60, 70, 80);
            int t2 = QBuilder.range(rng, 1, 3);
            int dist = s1 * t1 + s2 * t2;
            int totalTime = t1 + t2;
            return QBuilder.build(rng, "A bus runs " + t1 + " h at " + s1 + " km/h, then " + t2 + " h at " + s2 + " km/h. What total distance does it cover?", dist + " km", "Distance = " + s1 + "\u00d7" + t1 + " + " + s2 + "\u00d7" + t2 + " = " + s1 * t1 + " + " + s2 * t2 + " = " + dist + " km.", "HARD", CWP, dist / totalTime + " km", dist + s1 + " km", (s1 + s2) * totalTime + " km", dist - s1 + " km");
        });
        lp.classicConcept(new GeneratedQuestion("A car travels 150 km in 3 hours. Its speed is:", List.of("50 km/h", "45 km/h", "60 km/h", "75 km/h"), 0, "Speed = 150 \u00f7 3 = 50 km/h.", "EASY", EX), new GeneratedQuestion("At 60 km/h, the distance covered in 2.5 hours is:", List.of("150 km", "120 km", "180 km", "125 km"), 0, "Distance = 60 \u00d7 2.5 = 150 km.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A train covers 240 km in 4 hours. How far in 7 hours at the same speed?", List.of("420 km", "360 km", "480 km", "400 km"), 0, "Speed = 60 km/h, so 7 h \u2192 420 km.", "MEDIUM", WP), new GeneratedQuestion("A cyclist rides 2 h at 15 km/h and 3 h at 20 km/h. Total distance:", List.of("90 km", "75 km", "100 km", "85 km"), 0, "30 + 60 = 90 km.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice units() {
        LessonPractice lp = new LessonPractice("tsd-units", TOPIC, "Converting units (km/h \u2194 m/s)");
        lp.concept(rng -> {
            int kmh = QBuilder.pick(rng, 18, 36, 54, 72, 90, 108);
            int ms = kmh * 5 / 18;
            return QBuilder.build(rng, "Convert " + kmh + " km/h to m/s.", ms + " m/s", kmh + " \u00d7 5/18 = " + ms + " m/s.", "EASY", EX, ms + 5 + " m/s", ms - 5 + " m/s", kmh / 2 + " m/s", ms + 2 + " m/s");
        }, rng -> {
            int ms = QBuilder.pick(rng, 5, 10, 15, 20, 25, 30);
            int kmh = ms * 18 / 5;
            return QBuilder.build(rng, "Convert " + ms + " m/s to km/h.", kmh + " km/h", ms + " \u00d7 18/5 = " + kmh + " km/h.", "EASY", EX, kmh + 5 + " km/h", kmh - 5 + " km/h", ms * 5 + " km/h", kmh + 10 + " km/h");
        }, rng -> {
            int kmh = QBuilder.pick(rng, 36, 72, 90, 54);
            int ms = kmh * 5 / 18;
            return QBuilder.build(rng, "A vehicle moves at " + kmh + " km/h. Its speed in metres per second is:", ms + " m/s", "Multiply by 5/18: " + kmh + " \u00d7 5/18 = " + ms + " m/s.", "MEDIUM", EX, ms + 1 + " m/s", ms - 1 + " m/s", kmh / 3 + " m/s", ms + 4 + " m/s");
        });
        lp.word(rng -> {
            int kmh = QBuilder.pick(rng, 36, 54, 72, 90);
            int ms = kmh * 5 / 18;
            return QBuilder.build(rng, "A train runs at " + kmh + " km/h. How many metres does it cover in one second?", ms + " m", "Speed in m/s = " + kmh + " \u00d7 5/18 = " + ms + " m, i.e. " + ms + " m each second.", "MEDIUM", WP, ms + 2 + " m", ms - 2 + " m", kmh + " m", ms + 5 + " m");
        }, rng -> {
            int kmh = QBuilder.pick(rng, 36, 54, 72);
            int ms = kmh * 5 / 18;
            int secs = QBuilder.pick(rng, 10, 20, 30);
            int dist = ms * secs;
            return QBuilder.build(rng, "A car travels at " + kmh + " km/h. How far (in metres) does it go in " + secs + " seconds?", dist + " m", "Speed = " + ms + " m/s, so distance = " + ms + " \u00d7 " + secs + " = " + dist + " m.", "HARD", CWP, dist + ms + " m", kmh * secs + " m", dist - ms + " m", ms + secs + " m");
        });
        lp.classicConcept(new GeneratedQuestion("Convert 72 km/h to m/s.", List.of("20 m/s", "15 m/s", "25 m/s", "30 m/s"), 0, "72 \u00d7 5/18 = 20 m/s.", "EASY", EX), new GeneratedQuestion("Convert 25 m/s to km/h.", List.of("90 km/h", "75 km/h", "100 km/h", "60 km/h"), 0, "25 \u00d7 18/5 = 90 km/h.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A sprinter runs at 36 km/h. In m/s this is:", List.of("10 m/s", "12 m/s", "9 m/s", "6 m/s"), 0, "36 \u00d7 5/18 = 10 m/s.", "MEDIUM", WP), new GeneratedQuestion("Light traffic moves at 54 km/h. Distance in 20 s is:", List.of("300 m", "270 m", "320 m", "250 m"), 0, "54 km/h = 15 m/s; 15 \u00d7 20 = 300 m.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice averageSpeed() {
        LessonPractice lp = new LessonPractice("tsd-average-speed", TOPIC, "Average speed (a famous trap)");
        lp.concept(rng -> {
            int[] pr = HM_PAIRS[rng.nextInt(HM_PAIRS.length)];
            int a = pr[0];
            int b = pr[1];
            int hm = 2 * a * b / (a + b);
            return QBuilder.build(rng, "A trip is covered half the distance at " + a + " km/h and half at " + b + " km/h. What is the average speed for the whole trip?", hm + " km/h", "For equal distances, average = 2ab/(a+b) = 2\u00d7" + a + "\u00d7" + b + " \u00f7 " + (a + b) + " = " + hm + " km/h.", "HARD", EX, (a + b) / 2 + " km/h", hm + 2 + " km/h", hm - 2 + " km/h", a + b + " km/h");
        }, rng -> {
            int s1 = QBuilder.pick(rng, 20, 30, 40, 50);
            int t1 = QBuilder.range(rng, 1, 4);
            int s2 = QBuilder.pick(rng, 60, 70, 80, 45);
            int t2 = QBuilder.range(rng, 1, 4);
            int d1 = s1 * t1;
            int d2 = s2 * t2;
            int totalDist = d1 + d2;
            int totalTime = t1 + t2;
            return QBuilder.build(rng, "A van covers " + d1 + " km at " + s1 + " km/h (" + t1 + " h), then " + d2 + " km at " + s2 + " km/h (" + t2 + " h). What is the total time of the journey?", totalTime + " h", "Total time = " + t1 + " + " + t2 + " = " + totalTime + " h (and total distance = " + totalDist + " km).", "MEDIUM", EX, totalTime + 1 + " h", totalTime - 1 + " h", totalDist / totalTime + " h", totalTime + 2 + " h");
        });
        lp.word(rng -> {
            int[] pr = HM_PAIRS[rng.nextInt(HM_PAIRS.length)];
            int a = pr[0];
            int b = pr[1];
            int hm = 2 * a * b / (a + b);
            return QBuilder.build(rng, "A man drives to a town at " + a + " km/h and returns along the same road at " + b + " km/h. What is his average speed for the round trip?", hm + " km/h", "Same distance each way \u2192 average = 2ab/(a+b) = " + hm + " km/h (not the simple average).", "HARD", WP, (a + b) / 2 + " km/h", hm + 2 + " km/h", hm - 2 + " km/h", a + b + " km/h");
        }, rng -> {
            int a = QBuilder.pick(rng, 30, 40, 50, 60);
            int b = QBuilder.pick(rng, 20, 60, 70, 80);
            if ((a + b) % 2 != 0) {
                b = a;
            }
            int t = QBuilder.range(rng, 1, 3);
            int avg = (a + b) / 2;
            return QBuilder.build(rng, "A driver travels for " + t + " hours at " + a + " km/h and another " + t + " hours at " + b + " km/h. What is the average speed? (Equal times!)", avg + " km/h", "With EQUAL times, the average is the simple mean: (" + a + " + " + b + ")/2 = " + avg + " km/h (the 2ab/(a+b) trap only applies to equal distances).", "HARD", CWP, 2 * a * b / (a + b) + " km/h", avg + 5 + " km/h", avg - 5 + " km/h", a + b + " km/h");
        });
        lp.classicConcept(new GeneratedQuestion("Half a journey at 40 km/h and half at 60 km/h gives an average speed of:", List.of("48 km/h", "50 km/h", "52 km/h", "45 km/h"), 0, "2\u00d740\u00d760/(40+60) = 4800/100 = 48 km/h.", "HARD", EX), new GeneratedQuestion("A car goes 100 km at 50 km/h and 100 km at 25 km/h. Average speed:", List.of("33.3 km/h", "37.5 km/h", "40 km/h", "35 km/h"), 0, "Times 2 h + 4 h = 6 h for 200 km \u2192 200/6 \u2248 33.3 km/h.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A man walks to school at 3 km/h and back at 6 km/h. His average speed is:", List.of("4 km/h", "4.5 km/h", "5 km/h", "3.5 km/h"), 0, "2\u00d73\u00d76/(3+6) = 36/9 = 4 km/h.", "HARD", WP), new GeneratedQuestion("A bus covers 120 km in 3 h of driving plus a 1 h halt. Average over the whole trip:", List.of("30 km/h", "40 km/h", "24 km/h", "36 km/h"), 0, "120 \u00f7 (3+1) = 30 km/h.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice relative() {
        LessonPractice lp = new LessonPractice("tsd-relative", TOPIC, "Relative speed (two moving objects)");
        lp.concept(rng -> {
            int s1 = QBuilder.pick(rng, 30, 40, 50, 60);
            int s2 = QBuilder.pick(rng, 20, 35, 45, 55);
            int closing = s1 + s2;
            int gap = closing * QBuilder.range(rng, 1, 4);
            int time = gap / closing;
            return QBuilder.build(rng, "Two trains " + gap + " km apart move towards each other at " + s1 + " and " + s2 + " km/h. In how many hours do they meet?", time + " h", "Closing speed = " + s1 + " + " + s2 + " = " + closing + " km/h; time = " + gap + " \u00f7 " + closing + " = " + time + " h.", "MEDIUM", EX, time + 1 + " h", time - 1 + " h", gap / s1 + " h", time + 2 + " h");
        }, rng -> {
            int fast = QBuilder.pick(rng, 50, 60, 70, 80);
            int slow = QBuilder.pick(rng, 20, 30, 40);
            int diff = fast - slow;
            int gap = diff * QBuilder.range(rng, 1, 4);
            int time = gap / diff;
            return QBuilder.build(rng, "A car at " + fast + " km/h chases another at " + slow + " km/h that is " + gap + " km ahead. How long to catch up?", time + " h", "Gap closes at " + fast + " \u2212 " + slow + " = " + diff + " km/h; time = " + gap + " \u00f7 " + diff + " = " + time + " h.", "MEDIUM", EX, time + 1 + " h", time - 1 + " h", gap / fast + " h", time + 2 + " h");
        }, rng -> {
            int kmh = QBuilder.pick(rng, 36, 54, 72);
            int ms = kmh * 5 / 18;
            int len = ms * QBuilder.pick(rng, 5, 8, 10, 12);
            int time = len / ms;
            return QBuilder.build(rng, "A " + len + " m long train runs at " + kmh + " km/h. How many seconds to pass a pole?", time + " s", "Speed = " + ms + " m/s; passing a pole means covering its own length: " + len + " \u00f7 " + ms + " = " + time + " s.", "HARD", EX, time + 2 + " s", time - 2 + " s", len + " s", time + 5 + " s");
        });
        lp.word(rng -> {
            int s1 = QBuilder.pick(rng, 4, 5, 6);
            int s2 = QBuilder.pick(rng, 3, 4, 5);
            int closing = s1 + s2;
            int gap = closing * QBuilder.range(rng, 1, 5);
            int time = gap / closing;
            return QBuilder.build(rng, "Two friends " + gap + " km apart walk towards each other at " + s1 + " and " + s2 + " km/h. After how many hours do they meet?", time + " h", "Closing speed = " + closing + " km/h; time = " + gap + " \u00f7 " + closing + " = " + time + " h.", "MEDIUM", WP, time + 1 + " h", time - 1 + " h", gap / s1 + " h", time + 2 + " h");
        }, rng -> {
            int kmh = QBuilder.pick(rng, 36, 54, 72);
            int ms = kmh * 5 / 18;
            int trainLen = ms * QBuilder.pick(rng, 8, 10);
            int platform = ms * QBuilder.pick(rng, 5, 6, 7);
            int total = trainLen + platform;
            int time = total / ms;
            return QBuilder.build(rng, "A " + trainLen + " m train at " + kmh + " km/h crosses a " + platform + " m platform. How many seconds does it take?", time + " s", "Distance = train + platform = " + trainLen + " + " + platform + " = " + total + " m; speed = " + ms + " m/s; time = " + total + " \u00f7 " + ms + " = " + time + " s.", "HARD", CWP, trainLen / ms + " s", time + 2 + " s", time - 2 + " s", total + " s");
        });
        lp.classicConcept(new GeneratedQuestion("Two trains 80 km apart move towards each other at 30 and 50 km/h. They meet in:", List.of("1 hour", "1.5 hours", "2 hours", "0.5 hour"), 0, "Closing speed = 80 km/h; 80 \u00f7 80 = 1 hour.", "MEDIUM", EX), new GeneratedQuestion("A 150 m train at 54 km/h passes a pole in:", List.of("10 s", "12 s", "15 s", "9 s"), 0, "54 km/h = 15 m/s; 150 \u00f7 15 = 10 s.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A police car at 80 km/h chases a thief at 60 km/h who is 40 km ahead. Catch-up time:", List.of("2 h", "1 h", "3 h", "4 h"), 0, "Gap closes at 20 km/h; 40 \u00f7 20 = 2 h.", "MEDIUM", WP), new GeneratedQuestion("A 200 m train at 72 km/h crosses a 100 m bridge in:", List.of("15 s", "10 s", "20 s", "12 s"), 0, "72 km/h = 20 m/s; (200+100) \u00f7 20 = 15 s.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice boats() {
        LessonPractice lp = new LessonPractice("tsd-boats", TOPIC, "Boats and streams");
        lp.concept(rng -> {
            int boat = QBuilder.pick(rng, 8, 10, 12, 15, 20);
            int stream = QBuilder.pick(rng, 2, 3, 4, 5);
            return QBuilder.build(rng, "A boat's speed in still water is " + boat + " km/h and the stream flows at " + stream + " km/h. What is its downstream speed?", boat + stream + " km/h", "Downstream = boat + stream = " + boat + " + " + stream + " = " + (boat + stream) + " km/h.", "EASY", EX, boat - stream + " km/h", boat + " km/h", boat + 2 * stream + " km/h", boat + stream + 1 + " km/h");
        }, rng -> {
            int boat = QBuilder.pick(rng, 10, 12, 15, 18, 20);
            int stream = QBuilder.pick(rng, 2, 3, 4, 5);
            return QBuilder.build(rng, "A boat does " + boat + " km/h in still water against a " + stream + " km/h current. What is its upstream speed?", boat - stream + " km/h", "Upstream = boat \u2212 stream = " + boat + " \u2212 " + stream + " = " + (boat - stream) + " km/h.", "EASY", EX, boat + stream + " km/h", boat + " km/h", boat - 2 * stream + " km/h", boat - stream - 1 + " km/h");
        }, rng -> {
            int boat = QBuilder.pick(rng, 10, 12, 15, 18);
            int stream = QBuilder.pick(rng, 2, 3, 4, 5);
            int down = boat + stream;
            int up = boat - stream;
            return QBuilder.build(rng, "A boat goes " + down + " km/h downstream and " + up + " km/h upstream. What is the speed of the boat in still water?", boat + " km/h", "Boat speed = (down + up)/2 = (" + down + " + " + up + ")/2 = " + boat + " km/h.", "MEDIUM", EX, stream + " km/h", boat + 1 + " km/h", down + " km/h", boat - 1 + " km/h");
        });
        lp.word(rng -> {
            int boat = QBuilder.pick(rng, 8, 10, 12, 15);
            int stream = QBuilder.pick(rng, 2, 3, 4);
            int down = boat + stream;
            int hours = QBuilder.range(rng, 2, 5);
            int dist = down * hours;
            return QBuilder.build(rng, "A boat with still-water speed " + boat + " km/h rows downstream for " + hours + " hours in a " + stream + " km/h current. How far does it travel?", dist + " km", "Downstream speed = " + down + " km/h; distance = " + down + " \u00d7 " + hours + " = " + dist + " km.", "MEDIUM", WP, (boat - stream) * hours + " km", boat * hours + " km", dist + stream + " km", dist - stream + " km");
        }, rng -> {
            int down = QBuilder.pick(rng, 16, 18, 20, 24);
            int up = QBuilder.pick(rng, 8, 10, 12);
            int stream = (down - up) / 2;
            if ((down - up) % 2 != 0) {
                down = 18;
                up = 12;
                stream = 3;
            }
            return QBuilder.build(rng, "A boat covers a river stretch at " + down + " km/h downstream and " + up + " km/h upstream. What is the speed of the current?", stream + " km/h", "Stream = (down \u2212 up)/2 = (" + down + " \u2212 " + up + ")/2 = " + stream + " km/h.", "HARD", CWP, (down + up) / 2 + " km/h", stream + 1 + " km/h", down - up + " km/h", stream + 2 + " km/h");
        });
        lp.classicConcept(new GeneratedQuestion("Boat 12 km/h in still water, stream 3 km/h. Downstream speed:", List.of("15 km/h", "9 km/h", "12 km/h", "18 km/h"), 0, "12 + 3 = 15 km/h.", "EASY", EX), new GeneratedQuestion("Downstream 18 km/h, upstream 12 km/h. Boat speed in still water:", List.of("15 km/h", "3 km/h", "6 km/h", "30 km/h"), 0, "(18 + 12)/2 = 15 km/h.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A boat rows 10 km/h in still water down a 2 km/h stream for 3 hours. Distance:", List.of("36 km", "24 km", "30 km", "33 km"), 0, "Downstream = 12 km/h; 12 \u00d7 3 = 36 km.", "MEDIUM", WP), new GeneratedQuestion("Downstream 20 km/h, upstream 10 km/h. The current's speed is:", List.of("5 km/h", "10 km/h", "15 km/h", "3 km/h"), 0, "(20 \u2212 10)/2 = 5 km/h.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

