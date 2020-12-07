package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၸ */
public final class ITFWriter extends OneDimensionalCodeWriter {

    /* renamed from: ֏ */
    public static final int[] f3681 = {1, 1, 1, 1};

    /* renamed from: ؠ */
    public static final int[] f3682 = {3, 1, 1};

    /* renamed from: ހ */
    public static final int[][] f3683 = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.ITF) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int r5 = OneDimensionalCodeWriter.m3484(zArr, 0, f3681, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[10];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    int[][] iArr2 = f3683;
                    iArr[i3] = iArr2[digit][i2];
                    iArr[i3 + 1] = iArr2[digit2][i2];
                }
                r5 += OneDimensionalCodeWriter.m3484(zArr, r5, iArr, true);
            }
            OneDimensionalCodeWriter.m3484(zArr, r5, f3682, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
    }
}
