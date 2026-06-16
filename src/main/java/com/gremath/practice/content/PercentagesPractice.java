/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.Fmt;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class PercentagesPractice {
    private static final String TOPIC = "percentages";
    private static final String[] NAMES = new String[]{"Asha", "Ravi", "Meera", "John", "Sara", "Amit", "Lily", "Tom", "Neha", "Sam"};

    private PercentagesPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(PercentagesPractice.lessonMeaning());
        reg.add(PercentagesPractice.lessonPercentOf());
        reg.add(PercentagesPractice.lessonChange());
        reg.add(PercentagesPractice.lessonSuccessive());
    }

    private static LessonPractice lessonMeaning() {
        LessonPractice lp = new LessonPractice("percent-meaning", TOPIC, "What does \u201cpercent\u201d mean?");
        lp.concept(rng -> {
            int p = QBuilder.pick(rng, 5, 8, 12, 24, 30, 35, 45, 60, 72, 90, 6, 48);
            double correct = (double)p / 100.0;
            String exp = "Percent means \u2018out of 100\u2019, so divide by 100 \u2014 i.e. move the decimal point two places left: " + p + "% = " + p + "/100 = " + Fmt.num(correct) + ".";
            return QBuilder.build(rng, "Write " + p + "% as a decimal.", Fmt.num(correct), exp, "EASY", "exam-style", Fmt.num((double)p / 10.0), Fmt.num(p), Fmt.num((double)p / 1000.0));
        }, rng -> {
            double d = QBuilder.pick(rng, 0.3, 0.07, 0.125, 0.4, 0.05, 0.9, 0.6, 0.08, 0.45, 0.02);
            double correct = d * 100.0;
            String exp = "To turn a decimal into a percent, multiply by 100 (move the point two places right): " + Fmt.num(d) + " \u00d7 100 = " + Fmt.pct(correct) + ".";
            return QBuilder.build(rng, "Write the decimal " + Fmt.num(d) + " as a percent.", Fmt.pct(correct), exp, "EASY", "exam-style", Fmt.pct(d), Fmt.pct(correct * 10.0), Fmt.pct(correct / 10.0));
        }, rng -> {
            String[] fr = new String[]{"1/2", "1/4", "3/4", "1/5", "2/5", "3/5", "1/10", "3/10", "1/8", "1/20"};
            double[] pc = new double[]{50.0, 25.0, 75.0, 20.0, 40.0, 60.0, 10.0, 30.0, 12.5, 5.0};
            int i = rng.nextInt(fr.length);
            String exp = "A fraction becomes a percent when you multiply by 100: " + fr[i] + " \u00d7 100 = " + Fmt.pct(pc[i]) + ".";
            return QBuilder.build(rng, "Express the fraction " + fr[i] + " as a percent.", Fmt.pct(pc[i]), exp, "EASY", "exam-style", Fmt.pct(pc[i] / 2.0), Fmt.pct(100.0 - pc[i]), Fmt.pct(pc[i] * 2.0));
        }, rng -> {
            String[] fr = new String[]{"1/2", "1/4", "1/5", "3/4", "1/10", "2/5", "3/5"};
            double[] pc = new double[]{50.0, 25.0, 20.0, 75.0, 10.0, 40.0, 60.0};
            int i = rng.nextInt(fr.length);
            String exp = Fmt.pct(pc[i]) + " = " + Fmt.num(pc[i]) + "/100, which simplifies to " + fr[i] + ".";
            return QBuilder.build(rng, "Which fraction is equal to " + Fmt.pct(pc[i]) + "?", fr[i], exp, "MEDIUM", "exam-style", "1/3", "2/3", "1/8", "3/10");
        });
        lp.word(rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int b = QBuilder.pick(rng, 20, 25, 40, 50);
            int pctv = QBuilder.pick(rng, 60, 72, 80, 84, 90, 96);
            int a = pctv * b / 100;
            String exp = name + " got " + a + " out of " + b + ". As a percent that is (" + a + " \u00f7 " + b + ") \u00d7 100 = " + Fmt.pct(pctv) + ".";
            return QBuilder.build(rng, "In a test, " + name + " scored " + a + " marks out of " + b + ". What percent did " + name + " score?", Fmt.pct(pctv), exp, "EASY", "word problem", Fmt.pct(a), Fmt.pct(pctv + 10), Fmt.pct(b - a));
        }, rng -> {
            int total = QBuilder.pick(rng, 40, 50, 80, 200, 120);
            int pctv = QBuilder.pick(rng, 10, 15, 20, 25, 30, 35);
            int wear = pctv * total / 100;
            String exp = wear + " of " + total + " wear glasses \u2192 (" + wear + " \u00f7 " + total + ") \u00d7 100 = " + Fmt.pct(pctv) + ".";
            return QBuilder.build(rng, "Out of " + total + " students, " + wear + " wear glasses. What percentage wear glasses?", Fmt.pct(pctv), exp, "EASY", "word problem", Fmt.pct(wear), Fmt.pct(pctv * 2), Fmt.pct(100 - pctv));
        }, rng -> {
            String[] ctx = new String[]{"cricket matches", "chess games", "free throws"};
            String c = QBuilder.pick(rng, ctx);
            int b = QBuilder.pick(rng, 12, 20, 25, 40);
            int pctv = QBuilder.pick(rng, 25, 50, 75, 60, 80);
            int won = pctv * b / 100;
            String exp = "Winning " + won + " of " + b + " is (" + won + " \u00f7 " + b + ") \u00d7 100 = " + Fmt.pct(pctv) + ".";
            return QBuilder.build(rng, "A team won " + won + " of its " + b + " " + c + ". What percent did they win?", Fmt.pct(pctv), exp, "MEDIUM", "word problem", Fmt.pct(b - won), Fmt.pct(pctv + 20), Fmt.pct(won));
        });
        lp.classicConcept(new GeneratedQuestion("Which of the following is the largest?", List.of("0.6", "60%", "3/5", "All are equal"), 3, "0.6 = 60% = 3/5 = 0.6. All three are exactly the same value \u2014 a classic GRE quantitative-comparison trap.", "MEDIUM", "exam-style"), new GeneratedQuestion("If 0.5% of a number is 2, what is the number?", List.of("400", "40", "4", "1000"), 0, "0.5% = 0.005. So 0.005 \u00d7 N = 2 \u2192 N = 2 \u00f7 0.005 = 400. (Note 0.5% is one-half of one percent, not 5%.)", "HARD", "exam-style"), new GeneratedQuestion("Express 0.125 as a percent.", List.of("1.25%", "12.5%", "125%", "0.125%"), 1, "Multiply a decimal by 100 to get a percent: 0.125 \u00d7 100 = 12.5%. (0.125 also equals the fraction 1/8.)", "EASY", "exam-style"));
        lp.classicWord(new GeneratedQuestion("In a class, 18 of the 24 students passed an exam. What percent passed?", List.of("75%", "72%", "60%", "80%"), 0, "(18 \u00f7 24) \u00d7 100 = 0.75 \u00d7 100 = 75%.", "EASY", "word problem"), new GeneratedQuestion("A jar holds 200 marbles, of which 30 are red. What percent are NOT red?", List.of("85%", "70%", "15%", "30%"), 0, "Red = 30/200 = 15%, so not-red = 100% \u2212 15% = 85%. Reading 'NOT' carefully is the key.", "MEDIUM", "word problem"));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice lessonPercentOf() {
        LessonPractice lp = new LessonPractice("percent-of", TOPIC, "Finding a percent of a number");
        lp.concept(rng -> {
            int p = QBuilder.pick(rng, 5, 10, 15, 20, 25, 40, 50, 60, 75, 80);
            int n = QBuilder.pick(rng, 20, 40, 60, 80, 120, 200, 160, 240, 300, 140);
            double correct = (double)(p * n) / 100.0;
            String exp = "\u2018Of\u2019 means multiply: " + p + "% of " + n + " = (" + p + " \u00f7 100) \u00d7 " + n + " = " + Fmt.num(correct) + ".";
            return QBuilder.build(rng, "What is " + p + "% of " + n + "?", Fmt.num(correct), exp, "EASY", "exam-style", Fmt.num(correct + (double)n / 10.0), Fmt.num(correct / 10.0), Fmt.num((double)n - correct));
        }, rng -> {
            int p = QBuilder.pick(rng, 5, 10, 20, 25, 40, 50);
            int base = QBuilder.pick(rng, 20, 40, 60, 80, 120, 200, 160, 240);
            int x = p * base / 100;
            String exp = "If " + x + " is " + p + "% of the number, then 1% is " + x + " \u00f7 " + p + " = " + Fmt.num((double)x / (double)p) + ", and 100% is that \u00d7 100 = " + base + ".";
            return QBuilder.build(rng, x + " is " + p + "% of what number?", Fmt.num(base), exp, "MEDIUM", "exam-style", Fmt.num((double)(x * p) / 100.0), Fmt.num((double)base / 2.0), Fmt.num((double)x * 100.0 / (double)(p + 10)));
        }, rng -> {
            int p = QBuilder.pick(rng, 10, 20, 25, 40, 50, 60, 75, 80);
            int b = QBuilder.pick(rng, 20, 40, 60, 80, 120, 200);
            int a = p * b / 100;
            String exp = "What percent is " + a + " of " + b + "? Compute (" + a + " \u00f7 " + b + ") \u00d7 100 = " + Fmt.pct(p) + ".";
            return QBuilder.build(rng, "What percent of " + b + " is " + a + "?", Fmt.pct(p), exp, "MEDIUM", "exam-style", Fmt.pct(a), Fmt.pct(p + 10), Fmt.pct(100 - p));
        }, rng -> {
            double p = QBuilder.pick(rng, 12.5, 37.5, 62.5, 87.5);
            int n = QBuilder.pick(rng, 80, 160, 240, 320, 400, 800);
            double correct = p * (double)n / 100.0;
            String exp = Fmt.num(p) + "% = " + (p == 12.5 ? "1/8" : (p == 37.5 ? "3/8" : (p == 62.5 ? "5/8" : "7/8"))) + ", so " + Fmt.num(p) + "% of " + n + " = " + Fmt.num(correct) + " (using the friendly eighths).";
            return QBuilder.build(rng, "What is " + Fmt.num(p) + "% of " + n + "?", Fmt.num(correct), exp, "HARD", "exam-style", Fmt.num(correct + (double)n / 8.0), Fmt.num(correct - (double)n / 8.0), Fmt.num((double)n / 2.0));
        });
        lp.word(rng -> {
            int n = QBuilder.pick(rng, 40, 50, 80, 200, 120, 240);
            int p = QBuilder.pick(rng, 10, 15, 20, 25, 40, 60);
            int passed = p * n / 100;
            String exp = p + "% of " + n + " = (" + p + " \u00f7 100) \u00d7 " + n + " = " + passed + " students.";
            return QBuilder.build(rng, "In a class of " + n + " students, " + p + "% passed. How many students passed?", Fmt.num(passed), exp, "EASY", "word problem", Fmt.num(n - passed), Fmt.num((double)passed / 2.0), Fmt.num(p));
        }, rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int salary = QBuilder.pick(rng, 20000, 30000, 40000, 25000, 50000);
            int p = QBuilder.pick(rng, 10, 15, 20, 25, 30, 40);
            int rent = p * salary / 100;
            String exp = name + " spends " + p + "% of " + Fmt.money(salary) + " = (" + p + " \u00f7 100) \u00d7 " + salary + " = " + Fmt.money(rent) + " on rent.";
            return QBuilder.build(rng, name + " earns " + Fmt.money(salary) + " a month and spends " + p + "% on rent. How much is the rent?", Fmt.money(rent), exp, "EASY", "word problem", Fmt.money(salary - rent), Fmt.money(rent / 2), Fmt.money(p));
        }, rng -> {
            int price = QBuilder.pick(rng, 400, 600, 800, 1200, 1500, 2000);
            int p = QBuilder.pick(rng, 10, 15, 20, 25, 30, 40);
            int disc = p * price / 100;
            String exp = "Discount = " + p + "% of " + Fmt.money(price) + " = " + Fmt.money(disc) + ". (The question asks for the discount amount, not the final price.)";
            return QBuilder.build(rng, "A shop offers " + p + "% off a " + Fmt.money(price) + " item. How much is the discount?", Fmt.money(disc), exp, "MEDIUM", "word problem", Fmt.money(price - disc), Fmt.money(disc * 2), Fmt.money(p));
        }, rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int p = QBuilder.pick(rng, 5, 10, 20, 25, 40);
            int total = QBuilder.pick(rng, 200, 400, 500, 800, 1000);
            int part = p * total / 100;
            String exp = "If " + part + " students are " + p + "% of the school, then 1% = " + part + " \u00f7 " + p + " = " + Fmt.num((double)part / (double)p) + " and the total (100%) = " + total + ".";
            return QBuilder.build(rng, "At a school, " + part + " students play a sport, which is " + p + "% of all students. How many students are there in total?", Fmt.num(total), exp, "HARD", "word problem", Fmt.num((double)(part * p) / 100.0), Fmt.num((double)total / 2.0), Fmt.num(total + part));
        });
        lp.classicConcept(new GeneratedQuestion("What is 20% of 30% of 500?", List.of("30", "60", "150", "100"), 0, "Work inside out: 30% of 500 = 150, then 20% of 150 = 30. Percents of percents multiply: 0.20 \u00d7 0.30 \u00d7 500 = 30.", "MEDIUM", "exam-style"), new GeneratedQuestion("If 40% of a number is 56, what is the number?", List.of("140", "22.4", "96", "160"), 0, "40% \u2192 56, so 1% = 56 \u00f7 40 = 1.4, and 100% = 140. Check: 40% of 140 = 56.", "EASY", "exam-style"));
        lp.classicWord(new GeneratedQuestion("A laptop costs \u20b940,000. A buyer pays 18% GST on top. How much GST is paid?", List.of("\u20b97,200", "\u20b94,000", "\u20b97,800", "\u20b96,000"), 0, "GST = 18% of 40,000 = 0.18 \u00d7 40,000 = \u20b97,200.", "EASY", "word problem"), new GeneratedQuestion("In a town, 60% of people own a phone. If 1,200 people own a phone, what is the town's population?", List.of("2,000", "720", "1,800", "3,000"), 0, "1,200 is 60%, so 1% = 20 and 100% = 2,000 people.", "MEDIUM", "word problem"));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice lessonChange() {
        LessonPractice lp = new LessonPractice("percent-change", TOPIC, "Percentage increase and decrease");
        lp.concept(rng -> {
            int a = QBuilder.pick(rng, 20, 40, 50, 60, 80, 100, 120, 200);
            int p = QBuilder.pick(rng, 10, 20, 25, 50, 75, 5, 15);
            int b = a + a * p / 100;
            String exp = "Increase = " + (b - a) + " on the original " + a + ": (" + (b - a) + " \u00f7 " + a + ") \u00d7 100 = " + Fmt.pct(p) + ". (% change always uses the OLD value as the base.)";
            return QBuilder.build(rng, "A value rises from " + a + " to " + b + ". What is the percentage increase?", Fmt.pct(p), exp, "MEDIUM", "exam-style", Fmt.pct((double)(b - a) * 100.0 / (double)b), Fmt.pct(b - a), Fmt.pct(p + 5));
        }, rng -> {
            int a = QBuilder.pick(rng, 40, 50, 60, 80, 100, 120, 200, 160);
            int p = QBuilder.pick(rng, 10, 20, 25, 40, 50, 75);
            int b = a - a * p / 100;
            String exp = "Decrease = " + (a - b) + " on the original " + a + ": (" + (a - b) + " \u00f7 " + a + ") \u00d7 100 = " + Fmt.pct(p) + ".";
            return QBuilder.build(rng, "A value falls from " + a + " to " + b + ". What is the percentage decrease?", Fmt.pct(p), exp, "MEDIUM", "exam-style", Fmt.pct((double)(a - b) * 100.0 / (double)b), Fmt.pct(a - b), Fmt.pct(p + 10));
        }, rng -> {
            int n = QBuilder.pick(rng, 20, 40, 60, 80, 120, 200, 160, 240);
            int p = QBuilder.pick(rng, 5, 10, 15, 20, 25, 50, 75);
            double correct = (double)n * (1.0 + (double)p / 100.0);
            String exp = "Increase by " + p + "% \u2192 multiply by " + Fmt.num(1.0 + (double)p / 100.0) + ": " + n + " \u00d7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + Fmt.num(correct) + ".";
            return QBuilder.build(rng, "Increase " + n + " by " + p + "%. What is the new value?", Fmt.num(correct), exp, "EASY", "exam-style", Fmt.num((double)(n * p) / 100.0), Fmt.num((double)n * (1.0 - (double)p / 100.0)), Fmt.num(n + p));
        }, rng -> {
            int n = QBuilder.pick(rng, 40, 60, 80, 120, 200, 160, 240, 100);
            int p = QBuilder.pick(rng, 10, 20, 25, 40, 50);
            double correct = (double)n * (1.0 - (double)p / 100.0);
            String exp = "Decrease by " + p + "% \u2192 multiply by " + Fmt.num(1.0 - (double)p / 100.0) + ": " + n + " \u00d7 " + Fmt.num(1.0 - (double)p / 100.0) + " = " + Fmt.num(correct) + ".";
            return QBuilder.build(rng, "Decrease " + n + " by " + p + "%. What is the new value?", Fmt.num(correct), exp, "EASY", "exam-style", Fmt.num((double)(n * p) / 100.0), Fmt.num((double)n * (1.0 + (double)p / 100.0)), Fmt.num(n - p));
        }, rng -> {
            int original = QBuilder.pick(rng, 40, 60, 80, 120, 200, 160, 240);
            int p = QBuilder.pick(rng, 20, 25, 50, 10);
            int b = original + original * p / 100;
            String exp = "After a " + p + "% rise the value is original \u00d7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + b + ". So original = " + b + " \u00f7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + original + ".";
            return QBuilder.build(rng, "After a " + p + "% increase, a price becomes " + b + ". What was the original price?", Fmt.num(original), exp, "HARD", "exam-style", Fmt.num((double)b * (1.0 - (double)p / 100.0)), Fmt.num(b - b * p / 100), Fmt.num((double)b / 2.0));
        });
        lp.word(rng -> {
            int a = QBuilder.pick(rng, 2000, 4000, 5000, 8000, 10000, 20000);
            int p = QBuilder.pick(rng, 10, 20, 25, 50, 15);
            int b = a + a * p / 100;
            String exp = "Growth = " + (b - a) + " on " + a + ": (" + (b - a) + " \u00f7 " + a + ") \u00d7 100 = " + Fmt.pct(p) + ".";
            return QBuilder.build(rng, "A town's population grew from " + a + " to " + b + ". What is the percentage increase?", Fmt.pct(p), exp, "MEDIUM", "word problem", Fmt.pct((double)(b - a) * 100.0 / (double)b), Fmt.pct(p + 5), Fmt.pct(b - a));
        }, rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int salary = QBuilder.pick(rng, 20000, 30000, 40000, 25000, 50000);
            int p = QBuilder.pick(rng, 5, 10, 15, 20, 25);
            int newSal = salary + salary * p / 100;
            String exp = "New salary = " + Fmt.money(salary) + " \u00d7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + Fmt.money(newSal) + ".";
            return QBuilder.build(rng, name + "'s salary of " + Fmt.money(salary) + " is increased by " + p + "%. What is the new salary?", Fmt.money(newSal), exp, "EASY", "word problem", Fmt.money(salary * p / 100), Fmt.money(salary - salary * p / 100), Fmt.money(newSal + salary));
        }, rng -> {
            int price = QBuilder.pick(rng, 800, 1000, 1200, 1500, 2000, 2500);
            int p = QBuilder.pick(rng, 10, 20, 25, 30, 40);
            int sale = price - price * p / 100;
            String exp = "Sale price = " + Fmt.money(price) + " \u00d7 " + Fmt.num(1.0 - (double)p / 100.0) + " = " + Fmt.money(sale) + ".";
            return QBuilder.build(rng, "A " + Fmt.money(price) + " jacket is on a " + p + "% off sale. What is the sale price?", Fmt.money(sale), exp, "EASY", "word problem", Fmt.money(price * p / 100), Fmt.money(price + price * p / 100), Fmt.money(sale - 100));
        }, rng -> {
            int original = QBuilder.pick(rng, 400, 600, 800, 1200, 2000);
            int p = QBuilder.pick(rng, 20, 25, 50, 10);
            int b = original + original * p / 100;
            String exp = "After a " + p + "% rise, price = original \u00d7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + Fmt.money(b) + ". So original = " + Fmt.money(b) + " \u00f7 " + Fmt.num(1.0 + (double)p / 100.0) + " = " + Fmt.money(original) + ".";
            return QBuilder.build(rng, "After a " + p + "% price hike, a ticket costs " + Fmt.money(b) + ". What was the original price?", Fmt.money(original), exp, "HARD", "word problem", Fmt.money(b - b * p / 100), Fmt.money(b / 2), Fmt.money(b * p / 100));
        });
        lp.classicConcept(new GeneratedQuestion("A number is increased by 25%. By what percent must the result be decreased to return to the original number?", List.of("20%", "25%", "30%", "22.5%"), 0, "Say the number is 100 \u2192 125 after +25%. To return to 100, decrease 25 from 125: (25 \u00f7 125) \u00d7 100 = 20%.", "HARD", "exam-style"), new GeneratedQuestion("If the price of sugar increases by 25%, by what percent should a family cut consumption to keep spending unchanged?", List.of("20%", "25%", "15%", "33.3%"), 0, "Spending = price \u00d7 quantity. To keep it fixed when price \u00d71.25, quantity must \u00d7(1/1.25) = 0.8, i.e. a 20% cut.", "HARD", "exam-style"));
        lp.classicWord(new GeneratedQuestion("A shirt priced at \u20b91,200 is reduced by 15% in a sale. What is the sale price?", List.of("\u20b91,020", "\u20b91,380", "\u20b9180", "\u20b91,050"), 0, "Reduce by 15% \u2192 multiply by 0.85: 1,200 \u00d7 0.85 = \u20b91,020.", "EASY", "word problem"), new GeneratedQuestion("A company's revenue rose from \u20b980 lakh to \u20b9100 lakh. What is the percentage increase?", List.of("25%", "20%", "22%", "30%"), 0, "Increase = 20 on the original 80: (20 \u00f7 80) \u00d7 100 = 25%.", "MEDIUM", "word problem"));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice lessonSuccessive() {
        LessonPractice lp = new LessonPractice("percent-successive", TOPIC, "Successive (back-to-back) changes");
        lp.concept(rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30, 40, 50);
            int b = QBuilder.pick(rng, 10, 20, 30, 40, 50);
            double net = (double)(a + b) + (double)(a * b) / 100.0;
            String exp = "Net% = a + b + ab/100 = " + a + " + " + b + " + (" + a + "\u00d7" + b + ")/100 = " + Fmt.num(net) + "%. (You cannot simply add the two percents.)";
            return QBuilder.build(rng, "A quantity is increased by " + a + "% and then by " + b + "%. What is the net percentage change?", Fmt.pct(net), exp, "MEDIUM", "exam-style", Fmt.pct(a + b), Fmt.pct((double)(a + b) - (double)(a * b) / 100.0), Fmt.pct(net + 5.0));
        }, rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30, 40, 50);
            int b = QBuilder.pick(rng, 10, 20, 30, 40);
            double net = (double)(a - b) - (double)(a * b) / 100.0;
            String word = net >= 0.0 ? "increase" : "decrease";
            String exp = "Net% = a \u2212 b \u2212 ab/100 = " + a + " \u2212 " + b + " \u2212 (" + a + "\u00d7" + b + ")/100 = " + Fmt.num(net) + "%, i.e. a net " + word + " of " + Fmt.num(Math.abs(net)) + "%.";
            return QBuilder.build(rng, "A quantity is increased by " + a + "% and then decreased by " + b + "%. What is the net percentage change?", Fmt.pct(net), exp, "HARD", "exam-style", Fmt.pct(a - b), Fmt.pct(a + b), Fmt.pct(-(b - a)));
        }, rng -> {
            int n = QBuilder.pick(rng, 800, 1000, 1200, 1500, 2000, 2500);
            int a = QBuilder.pick(rng, 10, 20, 30);
            int b = QBuilder.pick(rng, 10, 20, 30);
            double correct = (double)n * (1.0 + (double)a / 100.0) * (1.0 - (double)b / 100.0);
            String exp = n + " \u00d7 (1 + " + a + "/100) \u00d7 (1 \u2212 " + b + "/100) = " + n + " \u00d7 " + Fmt.num(1.0 + (double)a / 100.0) + " \u00d7 " + Fmt.num(1.0 - (double)b / 100.0) + " = " + Fmt.num(correct) + ".";
            return QBuilder.build(rng, "A price of " + n + " is increased by " + a + "% and then decreased by " + b + "%. What is the final price?", Fmt.num(correct), exp, "HARD", "exam-style", Fmt.num(n), Fmt.num((double)n * (1.0 + (double)(a - b) / 100.0)), Fmt.num((double)n * (1.0 - (double)b / 100.0)));
        }, rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30);
            double net = (double)(2 * a) + (double)(a * a) / 100.0;
            String exp = "Two increases of " + a + "%: net% = a + a + a\u00b2/100 = " + 2 * a + " + " + Fmt.num((double)(a * a) / 100.0) + " = " + Fmt.num(net) + "%.";
            return QBuilder.build(rng, "A number is increased by " + a + "% twice in succession. What is the overall percentage increase?", Fmt.pct(net), exp, "MEDIUM", "exam-style", Fmt.pct(2 * a), Fmt.pct(a), Fmt.pct(net + 4.0));
        }, rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30, 40, 50);
            double net = (double)(-(a * a)) / 100.0;
            String exp = "Up a% then down a% always loses: net% = \u2212a\u00b2/100 = \u2212" + Fmt.num((double)(a * a) / 100.0) + "%, i.e. a " + Fmt.num(Math.abs(net)) + "% decrease (the base grew before the drop).";
            return QBuilder.build(rng, "A price is increased by " + a + "% and then decreased by " + a + "%. What is the net percentage change?", Fmt.pct(net), exp, "HARD", "exam-style", Fmt.pct(0.0), Fmt.pct(a), Fmt.pct(net - 2.0));
        });
        lp.word(rng -> {
            int price = QBuilder.pick(rng, 800, 1000, 1200, 1500, 2000);
            int a = QBuilder.pick(rng, 10, 20, 30);
            int b = QBuilder.pick(rng, 10, 20, 30);
            double correct = (double)price * (1.0 + (double)a / 100.0) * (1.0 - (double)b / 100.0);
            String exp = "Marked up: " + price + " \u00d7 " + Fmt.num(1.0 + (double)a / 100.0) + ". Then " + b + "% off: \u00d7 " + Fmt.num(1.0 - (double)b / 100.0) + ". Final = " + Fmt.money(correct) + ".";
            return QBuilder.build(rng, "A shopkeeper raises a " + Fmt.money(price) + " price by " + a + "% and then offers a " + b + "% discount. What is the final price?", Fmt.money(correct), exp, "HARD", "word problem", Fmt.money(price), Fmt.money((double)price * (1.0 + (double)(a - b) / 100.0)), Fmt.money((double)price * (1.0 - (double)b / 100.0)));
        }, rng -> {
            String name = QBuilder.pick(rng, NAMES);
            int a = QBuilder.pick(rng, 10, 20, 30);
            int b = QBuilder.pick(rng, 10, 20);
            double net = (double)(a + b) + (double)(a * b) / 100.0;
            String exp = "Net% = " + a + " + " + b + " + (" + a + "\u00d7" + b + ")/100 = " + Fmt.num(net) + "% \u2014 multiply the multipliers, don't just add.";
            return QBuilder.build(rng, name + "'s salary rose " + a + "% one year and " + b + "% the next. What is the overall percentage increase?", Fmt.pct(net), exp, "MEDIUM", "word problem", Fmt.pct(a + b), Fmt.pct(net + 3.0), Fmt.pct((double)(a + b) - (double)(a * b) / 100.0));
        }, rng -> {
            int a = QBuilder.pick(rng, 10, 20, 30);
            int b = QBuilder.pick(rng, 10, 20, 30);
            double net = (double)(a - b) - (double)(a * b) / 100.0;
            String word = net >= 0.0 ? "increase" : "decrease";
            String exp = "Net% = " + a + " \u2212 " + b + " \u2212 (" + a + "\u00d7" + b + ")/100 = " + Fmt.num(net) + "%, a net " + word + " of " + Fmt.num(Math.abs(net)) + "%.";
            return QBuilder.build(rng, "A town's population grew " + a + "% in 2020 then fell " + b + "% in 2021. What was the net percentage change?", Fmt.pct(net), exp, "HARD", "word problem", Fmt.pct(a - b), Fmt.pct(-(b - a)), Fmt.pct(a + b));
        });
        lp.classicConcept(new GeneratedQuestion("The length of a rectangle is increased by 20% and the width decreased by 20%. How does the area change?", List.of("Decreases by 4%", "No change", "Increases by 4%", "Decreases by 40%"), 0, "Area multiplier = 1.20 \u00d7 0.80 = 0.96, a 4% decrease. Up-then-down by the same percent always loses (\u2212a\u00b2/100).", "HARD", "exam-style"), new GeneratedQuestion("A salary is increased by 10% and then by 20%. What is the single equivalent percentage increase?", List.of("32%", "30%", "30.5%", "28%"), 0, "Multipliers: 1.10 \u00d7 1.20 = 1.32, i.e. a 32% increase \u2014 not 30%.", "MEDIUM", "exam-style"));
        lp.classicWord(new GeneratedQuestion("A \u20b92,000 item is marked up 20% and then sold at a 10% discount. What is the selling price?", List.of("\u20b92,160", "\u20b92,200", "\u20b92,000", "\u20b92,100"), 0, "2,000 \u00d7 1.20 = 2,400, then \u00d7 0.90 = \u20b92,160.", "MEDIUM", "word problem"), new GeneratedQuestion("A shopkeeper offers two successive discounts of 10% and 10%. What single discount is this equal to?", List.of("19%", "20%", "18%", "21%"), 0, "Remaining = 0.90 \u00d7 0.90 = 0.81, so 19% is taken off overall \u2014 less than the naive 20%.", "MEDIUM", "word problem"));
        return lp.sheets(20, 10, 20);
    }
}

