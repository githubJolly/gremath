/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class ProbabilityPractice {
    private static final String TOPIC = "probability";
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private ProbabilityPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(ProbabilityPractice.basics());
        reg.add(ProbabilityPractice.complement());
        reg.add(ProbabilityPractice.andOr());
        reg.add(ProbabilityPractice.conditional());
    }

    private static String frac(int a, int b) {
        int g = ProbabilityPractice.gcd(a, b);
        return a / g + "/" + b / g;
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a == 0 ? 1 : a;
    }

    private static LessonPractice basics() {
        LessonPractice lp = new LessonPractice("prob-basics", TOPIC, "What is probability?");
        lp.concept(rng -> {
            int sides = QBuilder.pick(rng, 4, 6, 8, 10);
            int fav = QBuilder.range(rng, 1, sides - 1);
            return QBuilder.build(rng, "An experiment has " + sides + " equally likely outcomes, and " + fav + " are favourable. What is the probability of success?", ProbabilityPractice.frac(fav, sides), "P = favourable/total = " + fav + "/" + sides + " = " + ProbabilityPractice.frac(fav, sides) + ".", "EASY", EX, ProbabilityPractice.frac(sides - fav, sides), ProbabilityPractice.frac(fav + 1, sides), ProbabilityPractice.frac(fav, sides + 1), ProbabilityPractice.frac(fav, sides - 1));
        }, rng -> {
            int fav = QBuilder.pick(rng, 1, 2, 3, 4);
            int total = fav + QBuilder.pick(rng, 4, 5, 6, 7);
            return QBuilder.build(rng, "If probability of event A is " + ProbabilityPractice.frac(fav, total) + ", which range must every probability satisfy?", "Between 0 and 1 inclusive", "All probabilities lie in [0, 1].", "EASY", EX, "Less than 0", "Greater than 1", "Between -1 and 1 only");
        });
        lp.word(rng -> {
            int total = 52;
            int fav = QBuilder.pick(rng, 4, 13, 26);
            String event = fav == 4 ? "a king" : (fav == 13 ? "a heart" : "a red card");
            return QBuilder.build(rng, "One card is drawn from a standard deck. Probability of drawing " + event + " is:", ProbabilityPractice.frac(fav, total), event + " has " + fav + " favourable cards out of 52 total.", "EASY", WP, ProbabilityPractice.frac(total - fav, total), ProbabilityPractice.frac(fav + 1, total), ProbabilityPractice.frac(fav, total + 1), "1/2");
        }, rng -> {
            int red = QBuilder.range(rng, 3, 7);
            int blue = QBuilder.range(rng, 2, 6);
            int total = red + blue;
            return QBuilder.build(rng, "A bag has " + red + " red and " + blue + " blue balls. One ball is drawn at random. What is P(red)?", ProbabilityPractice.frac(red, total), "Favourable red outcomes = " + red + ", total = " + total + ", so P(red) = " + ProbabilityPractice.frac(red, total) + ".", "MEDIUM", CWP, ProbabilityPractice.frac(blue, total), ProbabilityPractice.frac(red + 1, total), ProbabilityPractice.frac(red, total + 1), ProbabilityPractice.frac(red, blue));
        });
        lp.classicConcept(new GeneratedQuestion("A fair die is rolled. P(getting an even number) is:", List.of("1/2", "1/3", "1/6", "2/3"), 0, "Even outcomes {2,4,6}: 3 of 6, so 1/2.", "EASY", EX), new GeneratedQuestion("A card is drawn from 52. P(it is a king) is:", List.of("1/13", "1/26", "1/4", "4/13"), 0, "4 kings among 52 cards gives 4/52 = 1/13.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A spinner has 8 equal sectors, 3 of which are blue. P(blue) is:", List.of("3/8", "5/8", "1/2", "3/5"), 0, "Favourable sectors / total sectors = 3/8.", "EASY", WP), new GeneratedQuestion("A jar has 5 green, 3 yellow and 2 black marbles. P(not black) is:", List.of("4/5", "1/5", "3/10", "7/10"), 0, "Not black means 8 out of 10, i.e. 4/5.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice complement() {
        LessonPractice lp = new LessonPractice("prob-complement", TOPIC, "The complement: probability of 'not'");
        lp.concept(rng -> {
            int a = QBuilder.range(rng, 1, 7);
            int b = 10;
            return QBuilder.build(rng, "If P(A) = " + a + "/" + b + ", what is P(not A)?", ProbabilityPractice.frac(b - a, b), "Complement rule: P(not A) = 1 - P(A) = " + (b - a) + "/" + b + ".", "EASY", EX, ProbabilityPractice.frac(a, b), ProbabilityPractice.frac(a + 1, b), ProbabilityPractice.frac(b - a - 1, b), ProbabilityPractice.frac(b - a, b + 1));
        }, rng -> {
            int tosses = 2;
            int noHeadNum = 1;
            int noHeadDen = 1 << tosses;
            return QBuilder.build(rng, "Two fair coins are tossed. What is P(at least one head)?", ProbabilityPractice.frac(noHeadDen - noHeadNum, noHeadDen), "Use complement: P(at least one head) = 1 - P(no heads) = 1 - 1/4 = 3/4.", "MEDIUM", EX, "1/4", "1/2", "1", "2/3");
        });
        lp.word(rng -> {
            int boxes = QBuilder.pick(rng, 8, 10, 12);
            int defective = QBuilder.range(rng, 1, boxes / 2);
            return QBuilder.build(rng, "In a lot of " + boxes + " bulbs, " + defective + " are defective. If one bulb is picked randomly, what is P(not defective)?", ProbabilityPractice.frac(boxes - defective, boxes), "Good bulbs = " + (boxes - defective) + " out of " + boxes + ", so probability = " + ProbabilityPractice.frac(boxes - defective, boxes) + ".", "MEDIUM", WP, ProbabilityPractice.frac(defective, boxes), ProbabilityPractice.frac(boxes - defective - 1, boxes), ProbabilityPractice.frac(boxes - defective, boxes + 1), "1/2");
        }, rng -> {
            int days = 7;
            int rain = QBuilder.range(rng, 1, 5);
            return QBuilder.build(rng, "Weather data shows rain probability on a day is " + rain + "/" + days + ". What is probability of no rain?", ProbabilityPractice.frac(days - rain, days), "P(no rain) = 1 - " + rain + "/" + days + " = " + ProbabilityPractice.frac(days - rain, days) + ".", "EASY", CWP, ProbabilityPractice.frac(rain, days), ProbabilityPractice.frac(days - rain - 1, days), ProbabilityPractice.frac(days - rain, days + 1), "1/2");
        });
        lp.classicConcept(new GeneratedQuestion("Two coins are tossed. P(at least one head) is:", List.of("3/4", "1/4", "1/2", "1"), 0, "Complement: 1 - P(no head) = 1 - 1/4 = 3/4.", "MEDIUM", EX), new GeneratedQuestion("If P(A)=0.35, then P(not A) is:", List.of("0.65", "0.35", "0.75", "0.55"), 0, "1 - 0.35 = 0.65.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("In a class, 18 of 30 students wear glasses. P(a random student does not wear glasses) is:", List.of("2/5", "3/5", "1/5", "4/5"), 0, "Not wearing glasses = 12/30 = 2/5.", "MEDIUM", WP), new GeneratedQuestion("A machine makes 4% defective items. Probability an item is not defective is:", List.of("96%", "4%", "94%", "92%"), 0, "Complement: 100% - 4% = 96%.", "EASY", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice andOr() {
        LessonPractice lp = new LessonPractice("prob-and-or", TOPIC, "Combining events: AND vs OR");
        lp.concept(rng -> {
            int aNum = QBuilder.pick(rng, 1, 2, 3);
            int aDen = QBuilder.pick(rng, 4, 5, 6);
            int bNum = QBuilder.pick(rng, 1, 2, 3);
            int bDen = QBuilder.pick(rng, 4, 5, 6);
            int num = aNum * bNum;
            int den = aDen * bDen;
            return QBuilder.build(rng, "If two events are independent with P(A)=" + aNum + "/" + aDen + " and P(B)=" + bNum + "/" + bDen + ", what is P(A and B)?", ProbabilityPractice.frac(num, den), "Independent AND rule: multiply probabilities.", "MEDIUM", EX, ProbabilityPractice.frac(aNum + bNum, aDen + bDen), ProbabilityPractice.frac(num + 1, den), ProbabilityPractice.frac(num, den + 1), ProbabilityPractice.frac(aNum, aDen));
        }, rng -> {
            int total = 52;
            int kings = 4;
            int hearts = 13;
            int overlap = 1;
            int num = kings + hearts - overlap;
            return QBuilder.build(rng, "From a 52-card deck, P(card is King OR Heart) equals:", ProbabilityPractice.frac(num, total), "OR rule: P(K)+P(H)-P(K and H) = (4+13-1)/52 = 16/52 = 4/13.", "HARD", EX, ProbabilityPractice.frac(kings + hearts, total), ProbabilityPractice.frac(overlap, total), ProbabilityPractice.frac(hearts, total), ProbabilityPractice.frac(kings, total));
        });
        lp.word(rng -> QBuilder.build(rng, "A fair coin is tossed twice. What is probability of getting head on both tosses?", "1/4", "P(H and H)=1/2 \u00d7 1/2 = 1/4 (independent events).", "EASY", WP, "1/2", "3/4", "1/8", "1"), rng -> {
            int total = 30;
            int cricket = QBuilder.pick(rng, 12, 15, 18);
            int football = QBuilder.pick(rng, 10, 12, 14);
            int both = QBuilder.pick(rng, 5, 6, 7, 8);
            int or = cricket + football - both;
            return QBuilder.build(rng, "In a group of " + total + " students, " + cricket + " like cricket, " + football + " like football, and " + both + " like both. Probability a random student likes at least one?", ProbabilityPractice.frac(or, total), "At least one = cricket OR football = " + cricket + "+" + football + "-" + both + " = " + or + " out of " + total + ".", "HARD", CWP, ProbabilityPractice.frac(cricket + football, total), ProbabilityPractice.frac(both, total), ProbabilityPractice.frac(total - or, total), ProbabilityPractice.frac(cricket, total));
        });
        lp.classicConcept(new GeneratedQuestion("If P(A)=1/3 and P(B)=1/2 for independent events, P(A and B) is:", List.of("1/6", "5/6", "1/5", "2/3"), 0, "AND for independent events means multiply: 1/3 \u00d7 1/2 = 1/6.", "MEDIUM", EX), new GeneratedQuestion("P(A)=0.4, P(B)=0.3 and P(A and B)=0.1. Then P(A or B)=?", List.of("0.6", "0.7", "0.8", "0.2"), 0, "OR rule gives 0.4 + 0.3 - 0.1 = 0.6.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A die and coin are used. Probability of getting an even number and a head is:", List.of("1/4", "1/2", "1/3", "1/6"), 0, "P(even)=1/2 and P(head)=1/2, so AND = 1/4.", "EASY", WP), new GeneratedQuestion("A card is drawn. Probability of a queen or a spade is:", List.of("4/13", "1/4", "1/13", "1/2"), 0, "4 queens + 13 spades - 1 queen of spades = 16 cards, so 16/52 = 4/13.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice conditional() {
        LessonPractice lp = new LessonPractice("prob-conditional", TOPIC, "Conditional probability and Bayes intuition");
        lp.concept(rng -> {
            int total = 30;
            int b = QBuilder.pick(rng, 12, 15, 18);
            int aAndB = QBuilder.pick(rng, 6, 8, 9);
            if (aAndB > b) {
                aAndB = b - 1;
            }
            return QBuilder.build(rng, "If P(B)=" + b + "/" + total + " and P(A and B)=" + aAndB + "/" + total + ", what is P(A|B)?", ProbabilityPractice.frac(aAndB, b), "P(A|B)=P(A and B)/P(B)=(" + aAndB + "/" + total + ")/(" + b + "/" + total + ") = " + aAndB + "/" + b + " = " + ProbabilityPractice.frac(aAndB, b) + ".", "HARD", EX, ProbabilityPractice.frac(b, total), ProbabilityPractice.frac(aAndB, total), ProbabilityPractice.frac(aAndB + 1, b), ProbabilityPractice.frac(aAndB, b + 1));
        }, rng -> QBuilder.build(rng, "In a standard deck, given that a card drawn is a face card, probability it is a king is:", "1/3", "Face cards are J, Q, K: 12 cards. Kings among face cards: 4. So 4/12 = 1/3.", "MEDIUM", EX, "1/13", "1/4", "3/4", "1/12"));
        lp.word(rng -> {
            int total = 40;
            int girls = QBuilder.pick(rng, 16, 20, 24);
            int girlsMath = QBuilder.pick(rng, 8, 10, 12);
            if (girlsMath > girls) {
                girlsMath = girls - 2;
            }
            return QBuilder.build(rng, "In a class of " + total + ", there are " + girls + " girls. " + girlsMath + " girls like Math. If a randomly chosen student is known to be a girl, what is the probability she likes Math?", ProbabilityPractice.frac(girlsMath, girls), "Conditioning on being a girl reduces sample space to girls only: " + girlsMath + "/" + girls + ".", "HARD", WP, ProbabilityPractice.frac(girlsMath, total), ProbabilityPractice.frac(girls, total), ProbabilityPractice.frac(girlsMath + 1, girls), ProbabilityPractice.frac(girlsMath, girls + 1));
        }, rng -> {
            int boxA = QBuilder.pick(rng, 2, 3, 4);
            int boxB = QBuilder.pick(rng, 6, 7, 8);
            int total = boxA + boxB;
            return QBuilder.build(rng, "A machine produces " + boxA + " defective and " + boxB + " good parts. If a selected part is known to be from this machine's output set, probability it is defective is:", ProbabilityPractice.frac(boxA, total), "Conditional context doesn't change here; defective fraction remains " + boxA + "/" + total + ".", "MEDIUM", CWP, ProbabilityPractice.frac(boxB, total), ProbabilityPractice.frac(boxA + 1, total), ProbabilityPractice.frac(boxA, total + 1), "1/2");
        });
        lp.classicConcept(new GeneratedQuestion("Given a card is red, probability it is a king is:", List.of("1/13", "1/26", "1/4", "1/2"), 0, "Red cards = 26, red kings = 2, so 2/26 = 1/13.", "HARD", EX), new GeneratedQuestion("If P(A)=0.5, P(B)=0.4 and P(A and B)=0.2, then P(A|B)=:", List.of("0.5", "0.4", "0.2", "0.8"), 0, "P(A|B)=0.2/0.4=0.5.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A class has 12 boys and 8 girls. If 5 girls wear spectacles, then given a student is a girl, probability she wears spectacles is:", List.of("5/8", "5/20", "8/20", "3/8"), 0, "Conditional on being a girl: favourable=5 out of 8 girls.", "MEDIUM", WP), new GeneratedQuestion("A bag has 5 red and 7 blue balls. One ball is known to be non-blue. Probability it is red is:", List.of("1", "5/12", "7/12", "5/7"), 0, "Non-blue means red in this bag, so probability is 1.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

