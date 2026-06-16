/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Fmt {
    private Fmt() {
    }

    public static String num(double value) {
        BigDecimal bd = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
        return bd.toPlainString();
    }

    public static String pct(double value) {
        return Fmt.num(value) + "%";
    }

    public static String money(double value) {
        return "\u20b9" + Fmt.num(value);
    }
}

