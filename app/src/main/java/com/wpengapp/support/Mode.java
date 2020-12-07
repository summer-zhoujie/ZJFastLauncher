package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ˋ */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: މ */
    public final int[] f1523;

    /* renamed from: ފ */
    public final int f1524;

    /* access modifiers changed from: public */
    Mode(int[] iArr, int i) {
        this.f1523 = iArr;
        this.f1524 = i;
    }

    /* renamed from: ֏ */
    public int mo8344(Version r2) {
        int i = r2.f2351;
        return this.f1523[i <= 9 ? 0 : i <= 26 ? (char) 1 : 2];
    }
}
