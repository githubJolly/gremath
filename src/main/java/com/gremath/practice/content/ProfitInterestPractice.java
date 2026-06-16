/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice.content;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QBuilder;
import java.util.List;

public final class ProfitInterestPractice {
    private static final String TOPIC = "profit-loss-interest";
    private static final String EX = "exam-style";
    private static final String WP = "word problem";
    private static final String CWP = "complex word problem";

    private ProfitInterestPractice() {
    }

    public static void register(PracticeRegistry reg) {
        reg.add(ProfitInterestPractice.cpSp());
        reg.add(ProfitInterestPractice.percent());
        reg.add(ProfitInterestPractice.simpleInterest());
        reg.add(ProfitInterestPractice.compoundInterest());
        reg.add(ProfitInterestPractice.discount());
    }

    private static LessonPractice cpSp() {
        LessonPractice lp = new LessonPractice("pli-cp-sp", TOPIC, "Cost price, selling price, profit & loss");
        lp.concept(rng -> {
            int cp = QBuilder.pick(rng, 200, 250, 300, 400, 500);
            int profit = QBuilder.pick(rng, 20, 30, 40, 50, 60);
            int sp = cp + profit;
            return QBuilder.build(rng, "If CP = " + cp + " and SP = " + sp + ", what is the profit?", Integer.toString(profit), "Profit = SP - CP = " + sp + " - " + cp + " = " + profit + ".", "EASY", EX, Integer.toString(cp - profit), Integer.toString(sp - profit), Integer.toString(profit + 10), Integer.toString(profit - 10));
        }, rng -> {
            int cp = QBuilder.pick(rng, 300, 400, 500, 600);
            int loss = QBuilder.pick(rng, 20, 30, 40, 50);
            int sp = cp - loss;
            return QBuilder.build(rng, "If CP = " + cp + " and SP = " + sp + ", what is the loss?", Integer.toString(loss), "Loss = CP - SP = " + cp + " - " + sp + " = " + loss + ".", "EASY", EX, Integer.toString(cp + loss), Integer.toString(sp + loss), Integer.toString(loss + 10), Integer.toString(loss - 10));
        });
        lp.word(rng -> {
            int cp = QBuilder.pick(rng, 180, 220, 260, 300);
            int sp = cp + QBuilder.pick(rng, 30, 40, 50);
            return QBuilder.build(rng, "A shopkeeper buys a toy for " + cp + " and sells it for " + sp + ". What is the profit amount?", Integer.toString(sp - cp), "Profit amount = SP - CP = " + (sp - cp) + ".", "EASY", WP, Integer.toString(cp - (sp - cp)), Integer.toString(sp), Integer.toString(cp), Integer.toString(sp - cp + 5));
        }, rng -> {
            int cp = QBuilder.pick(rng, 500, 600, 700);
            int sp = cp - QBuilder.pick(rng, 50, 60, 70, 80);
            return QBuilder.build(rng, "An article bought at " + cp + " is sold at " + sp + ". How much is the loss?", Integer.toString(cp - sp), "Loss = CP - SP = " + (cp - sp) + ".", "MEDIUM", CWP, Integer.toString(sp - cp), Integer.toString(cp), Integer.toString(sp), Integer.toString(cp - sp + 10));
        });
        lp.classicConcept(new GeneratedQuestion("If CP is 350 and SP is 420, profit equals:", List.of("70", "30", "50", "80"), 0, "Profit = 420 - 350 = 70.", "EASY", EX), new GeneratedQuestion("If CP > SP, the transaction results in:", List.of("Loss", "Profit", "No change", "Interest"), 0, "Selling below cost causes loss.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A pen bought for 40 is sold for 55. Profit is:", List.of("15", "10", "20", "5"), 0, "55 - 40 = 15.", "EASY", WP), new GeneratedQuestion("A phone bought for 12000 is sold for 11400. Loss is:", List.of("600", "500", "700", "400"), 0, "12000 - 11400 = 600.", "MEDIUM", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice percent() {
        LessonPractice lp = new LessonPractice("pli-profit-loss-pct", TOPIC, "Profit % and loss % (always on cost price)");
        lp.concept(rng -> {
            int cp = QBuilder.pick(rng, 200, 300, 400, 500);
            int profit = QBuilder.pick(rng, 20, 30, 40, 50, 60, 75);
            int pct = profit * 100 / cp;
            if (profit * 100 % cp != 0) {
                cp = 200;
                profit = 50;
                pct = 25;
            }
            int sp = cp + profit;
            return QBuilder.build(rng, "An item has CP " + cp + " and SP " + sp + ". Profit percent is:", pct + "%", "Profit% = (profit/CP)\u00d7100 = (" + profit + "/" + cp + ")\u00d7100 = " + pct + "%.", "MEDIUM", EX, pct + 5 + "%", pct - 5 + "%", profit + "%", 100 - pct + "%");
        }, rng -> {
            int cp = QBuilder.pick(rng, 250, 400, 500, 800);
            int lossPct = QBuilder.pick(rng, 10, 12, 15, 20);
            int sp = cp * (100 - lossPct) / 100;
            return QBuilder.build(rng, "An article costs " + cp + " and is sold at " + lossPct + "% loss. SP is:", Integer.toString(sp), "SP = CP\u00d7(1 - loss%) = " + cp + "\u00d7(" + (100 - lossPct) + "/100) = " + sp + ".", "MEDIUM", EX, Integer.toString(cp), Integer.toString(cp + sp), Integer.toString(sp + 10), Integer.toString(sp - 10));
        });
        lp.word(rng -> {
            int cp = QBuilder.pick(rng, 400, 500, 600);
            int p = QBuilder.pick(rng, 10, 15, 20, 25);
            int sp = cp * (100 + p) / 100;
            return QBuilder.build(rng, "A watch bought for " + cp + " is sold at " + p + "% profit. Selling price?", Integer.toString(sp), "SP = CP\u00d7(100+" + p + ")/100 = " + sp + ".", "MEDIUM", WP, Integer.toString(cp), Integer.toString(sp + 20), Integer.toString(sp - 20), Integer.toString(cp * p / 100));
        }, rng -> {
            int sp = QBuilder.pick(rng, 540, 720, 810);
            int p = QBuilder.pick(rng, 20, 25, 35);
            int cp = sp * 100 / (100 + p);
            if (sp * 100 % (100 + p) != 0) {
                sp = 540;
                p = 20;
                cp = 450;
            }
            return QBuilder.build(rng, "An item is sold for " + sp + " at " + p + "% profit. What was the CP?", Integer.toString(cp), "CP = SP\u00d7100/(100+p) = " + sp + "\u00d7100/" + (100 + p) + " = " + cp + ".", "HARD", CWP, Integer.toString(sp), Integer.toString(cp + 20), Integer.toString(cp - 20), Integer.toString(sp - cp));
        });
        lp.classicConcept(new GeneratedQuestion("An item costs 200 and sells for 250. The profit percent is:", List.of("25%", "20%", "50%", "15%"), 0, "Profit = 50 on CP 200, so profit% = 25%.", "EASY", EX), new GeneratedQuestion("Sold at 10% loss on CP 500. SP is:", List.of("450", "550", "490", "460"), 0, "SP = 500\u00d70.9 = 450.", "EASY", EX));
        lp.classicWord(new GeneratedQuestion("A shirt sold for 960 gives 20% profit. CP equals:", List.of("800", "840", "880", "760"), 0, "CP = 960/1.2 = 800.", "MEDIUM", WP), new GeneratedQuestion("A bike sold for 8500 at 15% loss. CP is:", List.of("10000", "9500", "9000", "11000"), 0, "CP = 8500/0.85 = 10000.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice simpleInterest() {
        LessonPractice lp = new LessonPractice("pli-simple-interest", TOPIC, "Simple interest");
        lp.concept(rng -> {
            int p = QBuilder.pick(rng, 1000, 1500, 2000, 2500);
            int r = QBuilder.pick(rng, 5, 6, 8, 10);
            int t = QBuilder.pick(rng, 2, 3, 4);
            int si = p * r * t / 100;
            return QBuilder.build(rng, "Find SI on " + p + " at " + r + "% for " + t + " years.", Integer.toString(si), "SI = P\u00d7R\u00d7T/100 = " + p + "\u00d7" + r + "\u00d7" + t + "/100 = " + si + ".", "EASY", EX, Integer.toString(si + 50), Integer.toString(si - 50), Integer.toString(p + si), Integer.toString(r * t));
        }, rng -> {
            int p = QBuilder.pick(rng, 1200, 2000, 3000);
            int r = QBuilder.pick(rng, 5, 10, 12);
            int t = QBuilder.pick(rng, 2, 3);
            int si = p * r * t / 100;
            int amount = p + si;
            return QBuilder.build(rng, "Principal = " + p + ", rate = " + r + "%, time = " + t + " years under simple interest. Amount after time is:", Integer.toString(amount), "Amount = Principal + SI = " + p + " + " + si + " = " + amount + ".", "MEDIUM", EX, Integer.toString(si), Integer.toString(amount + 100), Integer.toString(amount - 100), Integer.toString(p * t));
        });
        lp.word(rng -> {
            int p = QBuilder.pick(rng, 2500, 3000, 4000);
            int r = QBuilder.pick(rng, 5, 8, 10);
            int t = QBuilder.pick(rng, 2, 3, 4);
            int si = p * r * t / 100;
            return QBuilder.build(rng, "A sum of " + p + " is invested at " + r + "% p.a. simple interest for " + t + " years. Interest earned is:", Integer.toString(si), "Using SI formula gives " + si + ".", "MEDIUM", WP, Integer.toString(si + 40), Integer.toString(si - 40), Integer.toString(p + si), Integer.toString(p * r / 100));
        }, rng -> {
            int r = QBuilder.pick(rng, 5, 8, 10);
            int t = QBuilder.pick(rng, 2, 3, 4);
            int si = QBuilder.pick(rng, 200, 240, 300, 400);
            int p = si * 100 / (r * t);
            if (si * 100 % (r * t) != 0) {
                r = 10;
                t = 2;
                si = 400;
                p = 2000;
            }
            return QBuilder.build(rng, "Simple interest is " + si + " at rate " + r + "% for " + t + " years. Principal is:", Integer.toString(p), "P = SI\u00d7100/(R\u00d7T) = " + si + "\u00d7100/(" + r + "\u00d7" + t + ") = " + p + ".", "HARD", CWP, Integer.toString(p + 100), Integer.toString(p - 100), Integer.toString(si), Integer.toString(p + si));
        });
        lp.classicConcept(new GeneratedQuestion("Simple interest on 1000 at 5% per year for 3 years is:", List.of("150", "100", "200", "50"), 0, "SI = 1000\u00d75\u00d73/100 = 150.", "EASY", EX), new GeneratedQuestion("If SI is 240 on principal 1200 for 4 years, rate is:", List.of("5%", "4%", "6%", "8%"), 0, "R = SI\u00d7100/(P\u00d7T) = 240\u00d7100/(1200\u00d74) = 5%.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("A person borrows 5000 at 8% simple interest for 2 years. Total amount payable:", List.of("5800", "5400", "5600", "6000"), 0, "SI=800, amount=5000+800=5800.", "MEDIUM", WP), new GeneratedQuestion("SI on a sum at 10% for 3 years is 900. The sum is:", List.of("3000", "2700", "2500", "3500"), 0, "P = 900\u00d7100/(10\u00d73) = 3000.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice compoundInterest() {
        LessonPractice lp = new LessonPractice("pli-compound-interest", TOPIC, "Compound interest");
        lp.concept(rng -> {
            int p = QBuilder.pick(rng, 1000, 2000, 3000, 5000);
            int r = QBuilder.pick(rng, 5, 10, 20);
            int t = QBuilder.pick(rng, 2, 3);
            int amount = (int)Math.round((double)p * Math.pow(1.0 + (double)r / 100.0, t));
            return QBuilder.build(rng, "Find compound amount on " + p + " at " + r + "% for " + t + " years.", Integer.toString(amount), "Amount = P(1+R/100)^T = " + p + "(1+" + r + "/100)^" + t + " = " + amount + ".", "MEDIUM", EX, Integer.toString(amount + 50), Integer.toString(amount - 50), Integer.toString(p + p * r * t / 100), Integer.toString(p + p * r / 100));
        }, rng -> {
            int p = QBuilder.pick(rng, 1000, 2000, 4000);
            int r = QBuilder.pick(rng, 10, 20);
            int t = 2;
            int amount = (int)Math.round((double)p * Math.pow(1.0 + (double)r / 100.0, t));
            int ci = amount - p;
            return QBuilder.build(rng, "Principal " + p + " grows at " + r + "% compounded annually for 2 years. Compound interest is:", Integer.toString(ci), "CI = Amount - Principal = " + amount + " - " + p + " = " + ci + ".", "MEDIUM", EX, Integer.toString(amount), Integer.toString(ci + 20), Integer.toString(ci - 20), Integer.toString(p * r * t / 100));
        });
        lp.word(rng -> {
            int p = QBuilder.pick(rng, 2000, 3000, 5000);
            int r = QBuilder.pick(rng, 10, 20);
            int t = 2;
            int amount = (int)Math.round((double)p * Math.pow(1.0 + (double)r / 100.0, t));
            return QBuilder.build(rng, "A deposit of " + p + " at " + r + "% compounded annually for " + t + " years becomes:", Integer.toString(amount), "Apply compound amount formula directly.", "MEDIUM", WP, Integer.toString(amount + 100), Integer.toString(amount - 100), Integer.toString(p + p * r * t / 100), Integer.toString(p + p * r / 100));
        }, rng -> {
            int p = QBuilder.pick(rng, 1000, 2000, 4000);
            int r = QBuilder.pick(rng, 10, 20);
            int t = 2;
            int amount = (int)Math.round((double)p * Math.pow(1.0 + (double)r / 100.0, t));
            int si = p * r * t / 100;
            int diff = amount - (p + si);
            return QBuilder.build(rng, "For principal " + p + ", rate " + r + "% and time 2 years, how much more is compound amount than simple-interest amount?", Integer.toString(diff), "Compute both amounts and subtract: CI amount " + amount + ", SI amount " + (p + si) + ", difference = " + diff + ".", "HARD", CWP, Integer.toString(diff + 10), Integer.toString(diff - 10), Integer.toString(si), Integer.toString(amount - p));
        });
        lp.classicConcept(new GeneratedQuestion("The compound amount on 2000 at 10% per annum for 2 years is:", List.of("2420", "2400", "2200", "2410"), 0, "2000\u00d71.1\u00b2 = 2420.", "MEDIUM", EX), new GeneratedQuestion("If principal is 1000 at 20% p.a. for 2 years compounded annually, amount is:", List.of("1440", "1400", "1480", "1420"), 0, "1000\u00d71.2\u00b2 = 1440.", "MEDIUM", EX));
        lp.classicWord(new GeneratedQuestion("An FD of 5000 at 10% compounded annually for 2 years yields amount:", List.of("6050", "6000", "6100", "5950"), 0, "5000\u00d71.1\u00b2 = 6050.", "MEDIUM", WP), new GeneratedQuestion("For 2000 at 10% for 2 years, CI exceeds SI by:", List.of("20", "40", "10", "30"), 0, "CI amount 2420, SI amount 2400, difference 20.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }

    private static LessonPractice discount() {
        LessonPractice lp = new LessonPractice("pli-discount", TOPIC, "Discounts, marked price and successive changes");
        lp.concept(rng -> {
            int mp = QBuilder.pick(rng, 500, 800, 1000, 1200);
            int d = QBuilder.pick(rng, 10, 15, 20, 25);
            int sp = mp * (100 - d) / 100;
            return QBuilder.build(rng, "Marked price is " + mp + ". Discount is " + d + "%. Selling price is:", Integer.toString(sp), "SP = MP\u00d7(100-d)/100 = " + mp + "\u00d7" + (100 - d) + "/100 = " + sp + ".", "EASY", EX, Integer.toString(mp), Integer.toString(sp + 20), Integer.toString(sp - 20), Integer.toString(mp - sp + sp));
        }, rng -> {
            int mp = QBuilder.pick(rng, 1000, 1200, 1500);
            int d1 = QBuilder.pick(rng, 10, 20, 25);
            int d2 = QBuilder.pick(rng, 5, 10, 15);
            int sp = mp * (100 - d1) * (100 - d2) / 10000;
            int net = 100 - (100 - d1) * (100 - d2) / 100;
            return QBuilder.build(rng, "A shop offers successive discounts of " + d1 + "% and " + d2 + "%. What is the net discount percent?", net + "%", "Net factor = (" + (100 - d1) + "/100)\u00d7(" + (100 - d2) + "/100). Equivalent discount = " + net + "%.", "HARD", EX, d1 + d2 + "%", net + 2 + "%", net - 2 + "%", Integer.toString(sp));
        });
        lp.word(rng -> {
            int mp = QBuilder.pick(rng, 1000, 1500, 2000);
            int d1 = QBuilder.pick(rng, 10, 20);
            int d2 = QBuilder.pick(rng, 10, 15);
            int sp = mp * (100 - d1) * (100 - d2) / 10000;
            return QBuilder.build(rng, "A jacket marked " + mp + " has discounts " + d1 + "% then " + d2 + "%. Final selling price is:", Integer.toString(sp), "Apply discounts successively as multipliers on MP: final SP = " + sp + ".", "HARD", WP, Integer.toString(mp * (100 - (d1 + d2)) / 100), Integer.toString(sp + 30), Integer.toString(sp - 30), Integer.toString(mp - sp));
        }, rng -> {
            int mp = QBuilder.pick(rng, 800, 1000, 1200);
            int d = QBuilder.pick(rng, 20, 25, 30);
            int sp = mp * (100 - d) / 100;
            int tax = QBuilder.pick(rng, 5, 10, 12);
            int bill = sp * (100 + tax) / 100;
            return QBuilder.build(rng, "An item has MP " + mp + ", discount " + d + "%, then GST " + tax + "% on discounted price. Final bill amount is:", Integer.toString(bill), "Discount first gives SP " + sp + ", then tax: " + sp + "\u00d7(" + (100 + tax) + "/100) = " + bill + ".", "HARD", CWP, Integer.toString(sp), Integer.toString(mp * (100 + tax) / 100), Integer.toString(bill + 20), Integer.toString(bill - 20));
        });
        lp.classicConcept(new GeneratedQuestion("Marked price 1000 with 20% discount gives SP:", List.of("800", "820", "780", "900"), 0, "SP = 1000\u00d70.8 = 800.", "EASY", EX), new GeneratedQuestion("Successive discounts 20% and 10% are equivalent to:", List.of("28%", "30%", "26%", "25%"), 0, "Net factor = 0.8\u00d70.9=0.72, so discount = 28%.", "HARD", EX));
        lp.classicWord(new GeneratedQuestion("A shirt marked 2000 is sold at 25% discount. SP is:", List.of("1500", "1600", "1400", "1700"), 0, "SP = 2000\u00d70.75 = 1500.", "MEDIUM", WP), new GeneratedQuestion("Marked 1200, discount 20%, then 10% tax on discounted price. Final price is:", List.of("1056", "960", "1080", "1152"), 0, "After discount: 960. Add 10% tax: 1056.", "HARD", CWP));
        return lp.sheets(20, 10, 20);
    }
}

