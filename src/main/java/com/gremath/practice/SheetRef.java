/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import com.gremath.practice.SheetType;

public record SheetRef(SheetType type, int number, String label, int questionCount, boolean classic) {
    public String typeName() {
        return this.type.name();
    }
}

