/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

public enum SheetType {
    CONCEPT,
    WORD;


    public static SheetType from(String value) {
        return "WORD".equalsIgnoreCase(value) ? WORD : CONCEPT;
    }
}

