package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၮ */
public final class Code39Writer extends OneDimensionalCodeWriter {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.CODE_39) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length <= 80) {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i)) < 0) {
                    int length2 = str.length();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char charAt = str.charAt(i2);
                        if (charAt != 0) {
                            if (charAt != ' ') {
                                if (charAt == '@') {
                                    sb.append("%V");
                                } else if (charAt == '`') {
                                    sb.append("%W");
                                } else if (!(charAt == '-' || charAt == '.')) {
                                    if (charAt <= 26) {
                                        sb.append('$');
                                        sb.append((char) ((charAt - 1) + 65));
                                    } else if (charAt < ' ') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - 27) + 65));
                                    } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                                        sb.append('/');
                                        sb.append((char) ((charAt - '!') + 65));
                                    } else if (charAt <= '9') {
                                        sb.append((char) ((charAt - '0') + 48));
                                    } else if (charAt <= '?') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - ';') + 70));
                                    } else if (charAt <= 'Z') {
                                        sb.append((char) ((charAt - 'A') + 65));
                                    } else if (charAt <= '_') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - '[') + 75));
                                    } else if (charAt <= 'z') {
                                        sb.append('+');
                                        sb.append((char) ((charAt - 'a') + 65));
                                    } else if (charAt <= 127) {
                                        sb.append('%');
                                        sb.append((char) ((charAt - '{') + 80));
                                    } else {
                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i2) + "'");
                                    }
                                }
                            }
                            sb.append(charAt);
                        } else {
                            sb.append("%U");
                        }
                    }
                    str = sb.toString();
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i++;
                }
            }
            int[] iArr = new int[9];
            int i3 = length + 25;
            int i4 = 0;
            while (i4 < length) {
                m3470(Code39Reader.f3678["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i4))], iArr);
                int i5 = i3;
                for (int i6 = 0; i6 < 9; i6++) {
                    i5 += iArr[i6];
                }
                i4++;
                i3 = i5;
            }
            boolean[] zArr = new boolean[i3];
            m3470(148, iArr);
            int r7 = OneDimensionalCodeWriter.m3484(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int r9 = OneDimensionalCodeWriter.m3484(zArr, r7, iArr2, false) + r7;
            for (int i7 = 0; i7 < length; i7++) {
                m3470(Code39Reader.f3678["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i7))], iArr);
                int r10 = OneDimensionalCodeWriter.m3484(zArr, r9, iArr, true) + r9;
                r9 = OneDimensionalCodeWriter.m3484(zArr, r10, iArr2, false) + r10;
            }
            m3470(148, iArr);
            OneDimensionalCodeWriter.m3484(zArr, r9, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    /* renamed from: ֏ */
    public static void m3470(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }
}
