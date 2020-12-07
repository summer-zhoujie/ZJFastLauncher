package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ၼ */
public abstract class UPCEANReader extends OneDReader {

    /* renamed from: ֏ */
    public static final int[] f3685 = {1, 1, 1};

    /* renamed from: ؠ */
    public static final int[] f3686 = {1, 1, 1, 1, 1};

    /* renamed from: ހ */
    public static final int[] f3687 = {1, 1, 1, 1, 1, 1};

    /* renamed from: ށ */
    public static final int[][] f3688 = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: ނ */
    public static final int[][] f3689 = new int[20][];

    static {
        System.arraycopy(f3688, 0, f3689, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f3688[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f3689[i] = iArr2;
        }
    }

    /* renamed from: ֏ */
    public static boolean m3489(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return m3490(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    /* renamed from: ؠ */
    public static int m3490(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.m2557();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.m2557();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }
}
