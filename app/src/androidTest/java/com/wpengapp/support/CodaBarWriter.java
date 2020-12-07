package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ၝ */
public final class CodaBarWriter extends OneDimensionalCodeWriter {

    /* renamed from: ֏ */
    public static final char[] f3668 = {'A', 'B', 'C', 'D'};

    /* renamed from: ؠ */
    public static final char[] f3669 = {'T', 'N', '*', 'E'};

    /* renamed from: ހ */
    public static final char[] f3670 = {'/', ':', '+', '.'};

    /* renamed from: ށ */
    public static final char f3671 = f3668[0];

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int i;
        if (str.length() < 2) {
            str = f3671 + str + f3671;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean r4 = CodaBarReader.m3465(f3668, upperCase);
            boolean r5 = CodaBarReader.m3465(f3668, upperCase2);
            boolean r0 = CodaBarReader.m3465(f3669, upperCase);
            boolean r3 = CodaBarReader.m3465(f3669, upperCase2);
            if (r4) {
                if (!r5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (r0) {
                if (!r3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (r5 || r3) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            } else {
                str = f3671 + str + f3671;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (CodaBarReader.m3465(f3670, str.charAt(i3))) {
                i2 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
            }
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i2)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr = CodaBarReader.f3666;
                if (i6 >= cArr.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == cArr[i6]) {
                    i = CodaBarReader.f3667[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i7] = z;
                    i7++;
                    if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
