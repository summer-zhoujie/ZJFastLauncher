package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၰ */
public class Code93Writer extends OneDimensionalCodeWriter {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.CODE_93) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            m3475(Code93Reader.f3679[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            m3474(zArr, 0, iArr);
            int i = 9;
            for (int i2 = 0; i2 < length; i2++) {
                m3475(Code93Reader.f3679["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                m3474(zArr, i, iArr);
                i += 9;
            }
            int r0 = m3473(str, 20);
            m3475(Code93Reader.f3679[r0], iArr);
            m3474(zArr, i, iArr);
            int i3 = i + 9;
            StringBuilder r11 = outline.m2549(str);
            r11.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(r0));
            m3475(Code93Reader.f3679[m3473(r11.toString(), 15)], iArr);
            m3474(zArr, i3, iArr);
            int i4 = i3 + 9;
            m3475(Code93Reader.f3679[47], iArr);
            m3474(zArr, i4, iArr);
            zArr[i4 + 9] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    /* renamed from: ֏ */
    public static void m3475(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: ֏ */
    public static int m3474(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    /* renamed from: ֏ */
    public static int m3473(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
