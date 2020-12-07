package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ၜ */
public final class CodaBarReader extends OneDReader {

    /* renamed from: ֏ */
    public static final char[] f3666 = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: ؠ */
    public static final int[] f3667 = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
    }

    /* renamed from: ֏ */
    public static boolean m3465(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
