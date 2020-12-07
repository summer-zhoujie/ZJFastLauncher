package com.wpengapp.support;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* renamed from: com.wpengapp.support.ჿ */
public final class PDF417HighLevelEncoder {

    /* renamed from: ֏ */
    public static final byte[] f3837 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: ؠ */
    public static final byte[] f3838 = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: ހ */
    public static final byte[] f3839 = new byte[128];

    /* renamed from: ށ */
    public static final byte[] f3840 = new byte[128];

    /* renamed from: ނ */
    public static final Charset f3841 = StandardCharsets.ISO_8859_1;

    static {
        Arrays.fill(f3839, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = f3837;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > 0) {
                f3839[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(f3840, (byte) -1);
        while (true) {
            byte[] bArr2 = f3838;
            if (i < bArr2.length) {
                byte b2 = bArr2[i];
                if (b2 > 0) {
                    f3840[b2] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: ֏ */
    public static String m3662(String str, Compaction r19, Charset charset) {
        int i;
        int i2;
        CharacterSetECI r5;
        String str2 = str;
        Charset charset2 = charset;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset2 == null) {
            charset2 = f3841;
        } else if (!f3841.equals(charset2) && (r5 = CharacterSetECI.f2862.get(charset.name())) != null) {
            int i3 = r5.f2864[0];
            if (i3 >= 0 && i3 < 900) {
                sb.append(927);
                sb.append((char) i3);
            } else if (i3 < 810900) {
                sb.append(926);
                sb.append((char) ((i3 / 900) - 1));
                sb.append((char) (i3 % 900));
            } else if (i3 < 811800) {
                sb.append(925);
                sb.append((char) (810900 - i3));
            } else {
                throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i3)));
            }
        }
        int length = str.length();
        int ordinal = r19.ordinal();
        if (ordinal == 1) {
            m3661((CharSequence) str2, 0, length, sb, 0);
        } else if (ordinal != 2) {
            char c = 902;
            if (ordinal != 3) {
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < length) {
                    int length2 = str.length();
                    if (i4 < length2) {
                        char charAt = str2.charAt(i4);
                        int i7 = i4;
                        i = 0;
                        while (m3667(charAt) && i7 < length2) {
                            i++;
                            i7++;
                            if (i7 < length2) {
                                charAt = str2.charAt(i7);
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (i >= 13) {
                        sb.append(c);
                        m3663(str2, i4, i, sb);
                        i4 += i;
                        i5 = 0;
                        i6 = 2;
                    } else {
                        int length3 = str.length();
                        int i8 = i4;
                        while (true) {
                            if (i8 >= length3) {
                                break;
                            }
                            char charAt2 = str2.charAt(i8);
                            int i9 = i8;
                            int i10 = 0;
                            while (i10 < 13 && m3667(charAt2) && i9 < length3) {
                                i10++;
                                i9++;
                                if (i9 < length3) {
                                    charAt2 = str2.charAt(i9);
                                }
                            }
                            if (i10 >= 13) {
                                i2 = (i9 - i4) - i10;
                                break;
                            } else if (i10 <= 0) {
                                char charAt3 = str2.charAt(i9);
                                if (!(charAt3 == 9 || charAt3 == 10 || charAt3 == 13 || (charAt3 >= ' ' && charAt3 <= '~'))) {
                                    i8 = i9;
                                    break;
                                }
                                i8 = i9 + 1;
                            } else {
                                i8 = i9;
                            }
                        }
                        i2 = i8 - i4;
                        if (i2 >= 5 || i == length) {
                            if (i6 != 0) {
                                sb.append(900);
                                i5 = 0;
                                i6 = 0;
                            }
                            i5 = m3661((CharSequence) str2, i4, i2, sb, i5);
                            i4 += i2;
                        } else {
                            CharsetEncoder newEncoder = charset2.newEncoder();
                            int length4 = str.length();
                            int i11 = i4;
                            while (i11 < length4) {
                                char charAt4 = str2.charAt(i11);
                                int i12 = 0;
                                while (i12 < 13 && m3667(charAt4)) {
                                    i12++;
                                    int i13 = i11 + i12;
                                    if (i13 >= length4) {
                                        break;
                                    }
                                    charAt4 = str2.charAt(i13);
                                }
                                if (i12 >= 13) {
                                    break;
                                }
                                char charAt5 = str2.charAt(i11);
                                if (newEncoder.canEncode(charAt5)) {
                                    i11++;
                                } else {
                                    throw new WriterException("Non-encodable character detected: " + charAt5 + " (Unicode: " + charAt5 + ')');
                                }
                            }
                            int i14 = i11 - i4;
                            if (i14 == 0) {
                                i14 = 1;
                            }
                            int i15 = i14 + i4;
                            byte[] bytes = str2.substring(i4, i15).getBytes(charset2);
                            if (bytes.length == 1 && i6 == 0) {
                                m3664(bytes, 0, 1, 0, sb);
                            } else {
                                m3664(bytes, 0, bytes.length, i6, sb);
                                i5 = 0;
                                i6 = 1;
                            }
                            i4 = i15;
                        }
                        c = 902;
                    }
                }
            } else {
                sb.append(902);
                m3663(str2, 0, length, sb);
            }
        } else {
            byte[] bytes2 = str2.getBytes(charset2);
            m3664(bytes2, 0, bytes2.length, 1, sb);
        }
        return sb.toString();
    }

    /* renamed from: ֏ */
    public static boolean m3665(char c) {
        if (c != ' ') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    /* renamed from: ؠ */
    public static boolean m3666(char c) {
        if (c != ' ') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    /* renamed from: ހ */
    public static boolean m3667(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: ށ */
    public static boolean m3668(char c) {
        return f3839[c] != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101 A[EDGE_INSN: B:75:0x0101->B:60:0x0101 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0011 A[SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m3661(CharSequence r16, int r17, int r18, StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r8 = r20
            r7 = 0
        L_0x0011:
            int r9 = r17 + r7
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r8 == 0) goto L_0x00c7
            if (r8 == r6) goto L_0x008e
            r11 = -1
            if (r8 == r4) goto L_0x0041
            byte[] r9 = f3840
            byte r9 = r9[r10]
            if (r9 == r11) goto L_0x0030
            r9 = 1
            goto L_0x0031
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r9 == 0) goto L_0x003d
            byte[] r9 = f3840
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x003d:
            r3.append(r15)
            goto L_0x005a
        L_0x0041:
            boolean r12 = m3668(r10)
            if (r12 == 0) goto L_0x0051
            byte[] r9 = f3839
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x0051:
            boolean r12 = m3666(r10)
            if (r12 == 0) goto L_0x005c
            r3.append(r13)
        L_0x005a:
            r8 = 0
            goto L_0x0011
        L_0x005c:
            boolean r12 = m3665(r10)
            if (r12 == 0) goto L_0x0067
            r3.append(r14)
            goto L_0x00e3
        L_0x0067:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x0081
            char r9 = r0.charAt(r9)
            byte[] r12 = f3840
            byte r9 = r12[r9]
            if (r9 == r11) goto L_0x0077
            r9 = 1
            goto L_0x0078
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 == 0) goto L_0x0081
            r8 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x0081:
            r3.append(r15)
            byte[] r9 = f3840
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x008e:
            boolean r9 = m3665(r10)
            if (r9 == 0) goto L_0x00a1
            if (r10 != r12) goto L_0x009a
            r3.append(r11)
            goto L_0x00fd
        L_0x009a:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00a1:
            boolean r9 = m3666(r10)
            if (r9 == 0) goto L_0x00b1
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00b1:
            boolean r9 = m3668(r10)
            if (r9 == 0) goto L_0x00bb
            r3.append(r13)
            goto L_0x00ef
        L_0x00bb:
            r3.append(r15)
            byte[] r9 = f3840
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x00c7:
            boolean r9 = m3666(r10)
            if (r9 == 0) goto L_0x00da
            if (r10 != r12) goto L_0x00d3
            r3.append(r11)
            goto L_0x00fd
        L_0x00d3:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00da:
            boolean r9 = m3665(r10)
            if (r9 == 0) goto L_0x00e6
            r3.append(r14)
        L_0x00e3:
            r8 = 1
            goto L_0x0011
        L_0x00e6:
            boolean r9 = m3668(r10)
            if (r9 == 0) goto L_0x00f2
            r3.append(r13)
        L_0x00ef:
            r8 = 2
            goto L_0x0011
        L_0x00f2:
            r3.append(r15)
            byte[] r9 = f3840
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x00fd:
            int r7 = r7 + 1
            if (r7 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = 0
            r7 = 0
        L_0x0107:
            if (r1 >= r0) goto L_0x0125
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x010f
            r9 = 1
            goto L_0x0110
        L_0x010f:
            r9 = 0
        L_0x0110:
            if (r9 == 0) goto L_0x011e
            int r7 = r7 * 30
            char r9 = r3.charAt(r1)
            int r9 = r9 + r7
            char r7 = (char) r9
            r2.append(r7)
            goto L_0x0122
        L_0x011e:
            char r7 = r3.charAt(r1)
        L_0x0122:
            int r1 = r1 + 1
            goto L_0x0107
        L_0x0125:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x012f
            int r7 = r7 * 30
            int r7 = r7 + r15
            char r0 = (char) r7
            r2.append(r0)
        L_0x012f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.PDF417HighLevelEncoder.m3661(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* renamed from: ֏ */
    public static void m3664(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    /* renamed from: ֏ */
    public static void m3663(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }
}
