package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၺ */
public abstract class OneDimensionalCodeWriter implements Writer {
    /* renamed from: ֏ */
    public int mo9550() {
        return 10;
    }

    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r6, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int r62 = mo9550();
            if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
                r62 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
            boolean[] r5 = mo9549(str);
            int length = r5.length;
            int i3 = r62 + length;
            int max = Math.max(i, i3);
            int max2 = Math.max(1, i2);
            int i4 = max / i3;
            int r0 = outline.m2540(length, i4, max, 2);
            BitMatrix r1 = new BitMatrix(max, max2);
            int i5 = 0;
            while (i5 < length) {
                if (r5[i5]) {
                    r1.mo9091(r0, 0, i4, max2);
                }
                i5++;
                r0 += i4;
            }
            return r1;
        }
    }

    /* renamed from: ֏ */
    public abstract boolean[] mo9549(String str);

    /* renamed from: ֏ */
    public static int m3484(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i2;
            int i7 = 0;
            while (i7 < i5) {
                zArr[i6] = z2;
                i7++;
                i6++;
            }
            i4 += i5;
            z2 = !z2;
            i3++;
            i2 = i6;
        }
        return i4;
    }
}
