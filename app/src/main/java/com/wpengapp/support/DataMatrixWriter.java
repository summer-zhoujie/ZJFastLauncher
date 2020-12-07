package com.wpengapp.support;

import java.lang.reflect.Array;
import java.util.Map;

/* renamed from: com.wpengapp.support.ࢪ */
public final class DataMatrixWriter implements Writer {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r18, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension r6;
        int i3;
        int i4;
        int i5;
        BitMatrix r5;
        String str2 = str;
        int i6 = i;
        int i7 = i2;
        Map<EncodeHintType, ?> map2 = map;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (r18 != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(r18)));
        } else if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i6 + 'x' + i7);
        } else {
            SymbolShapeHint r4 = SymbolShapeHint.FORCE_NONE;
            Dimension r52 = null;
            if (map2 != null) {
                SymbolShapeHint r62 = (SymbolShapeHint) map2.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (r62 != null) {
                    r4 = r62;
                }
                r6 = (Dimension) map2.get(EncodeHintType.MIN_SIZE);
                if (r6 == null) {
                    r6 = null;
                }
                Dimension r3 = (Dimension) map2.get(EncodeHintType.MAX_SIZE);
                if (r3 != null) {
                    r52 = r3;
                }
            } else {
                r6 = null;
            }
            int i8 = 0;
            C1239[] r32 = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
            EncoderContext r7 = new EncoderContext(str2);
            r7.f3585 = r4;
            r7.f3586 = r6;
            r7.f3587 = r52;
            if (str2.startsWith("[)>\u001e05\u001d") && str2.endsWith("\u001e\u0004")) {
                r7.f3588.append(236);
                r7.mo9517(2);
                r7.f3589 += 7;
            } else if (str2.startsWith("[)>\u001e06\u001d") && str2.endsWith("\u001e\u0004")) {
                r7.f3588.append(237);
                r7.mo9517(2);
                r7.f3589 += 7;
            }
            int i9 = 0;
            while (r7.mo9522()) {
                r32[i9].mo9379(r7);
                int i10 = r7.f3590;
                if (i10 >= 0) {
                    r7.f3590 = -1;
                    i9 = i10;
                }
            }
            int r33 = r7.mo9516();
            r7.mo9523();
            int i11 = r7.f3591.f3628;
            if (!(r33 >= i11 || i9 == 0 || i9 == 5 || i9 == 4)) {
                r7.f3588.append(254);
            }
            StringBuilder r0 = r7.mo9518();
            if (r0.length() < i11) {
                r0.append(129);
            }
            while (r0.length() < i11) {
                int length = (((r0.length() + 1) * 149) % 253) + 1 + 129;
                if (length > 254) {
                    length -= 254;
                }
                r0.append((char) length);
            }
            String sb = r7.mo9518().toString();
            SymbolInfo r34 = SymbolInfo.m3447(sb.length(), r4, r6, r52, true);
            DefaultPlacement r42 = new DefaultPlacement(ErrorCorrection.m3376(sb, r34), r34.mo9541(), r34.mo9540());
            int i12 = 4;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int i15 = r42.f3350;
                if (i12 == i15 && i13 == 0) {
                    i3 = i14 + 1;
                    r42.mo9405(i15 - 1, i8, i14, 1);
                    r42.mo9405(r42.f3350 - 1, 1, i14, 2);
                    r42.mo9405(r42.f3350 - 1, 2, i14, 3);
                    r42.mo9405(i8, r42.f3351 - 2, i14, 4);
                    r42.mo9405(i8, r42.f3351 - 1, i14, 5);
                    r42.mo9405(1, r42.f3351 - 1, i14, 6);
                    r42.mo9405(2, r42.f3351 - 1, i14, 7);
                    r42.mo9405(3, r42.f3351 - 1, i14, 8);
                } else {
                    i3 = i14;
                }
                int i16 = r42.f3350;
                if (i12 == i16 - 2 && i13 == 0 && r42.f3351 % 4 != 0) {
                    r42.mo9405(i16 - 3, i8, i3, 1);
                    r42.mo9405(r42.f3350 - 2, i8, i3, 2);
                    r42.mo9405(r42.f3350 - 1, i8, i3, 3);
                    r42.mo9405(i8, r42.f3351 - 4, i3, 4);
                    r42.mo9405(i8, r42.f3351 - 3, i3, 5);
                    r42.mo9405(i8, r42.f3351 - 2, i3, 6);
                    r42.mo9405(i8, r42.f3351 - 1, i3, 7);
                    r42.mo9405(1, r42.f3351 - 1, i3, 8);
                    i3++;
                }
                int i17 = r42.f3350;
                if (i12 == i17 - 2 && i13 == 0 && r42.f3351 % 8 == 4) {
                    r42.mo9405(i17 - 3, i8, i3, 1);
                    r42.mo9405(r42.f3350 - 2, i8, i3, 2);
                    r42.mo9405(r42.f3350 - 1, i8, i3, 3);
                    r42.mo9405(i8, r42.f3351 - 2, i3, 4);
                    r42.mo9405(i8, r42.f3351 - 1, i3, 5);
                    r42.mo9405(1, r42.f3351 - 1, i3, 6);
                    r42.mo9405(2, r42.f3351 - 1, i3, 7);
                    r42.mo9405(3, r42.f3351 - 1, i3, 8);
                    i3++;
                }
                int i18 = r42.f3350;
                if (i12 == i18 + 4 && i13 == 2 && r42.f3351 % 8 == 0) {
                    r42.mo9405(i18 - 1, i8, i3, 1);
                    r42.mo9405(r42.f3350 - 1, r42.f3351 - 1, i3, 2);
                    r42.mo9405(i8, r42.f3351 - 3, i3, 3);
                    r42.mo9405(i8, r42.f3351 - 2, i3, 4);
                    r42.mo9405(i8, r42.f3351 - 1, i3, 5);
                    r42.mo9405(1, r42.f3351 - 3, i3, 6);
                    r42.mo9405(1, r42.f3351 - 2, i3, 7);
                    r42.mo9405(1, r42.f3351 - 1, i3, 8);
                    i3++;
                }
                do {
                    if (i12 < r42.f3350 && i13 >= 0 && !r42.mo9407(i13, i12)) {
                        r42.mo9404(i12, i13, i3);
                        i3++;
                    }
                    i12 -= 2;
                    i13 += 2;
                    if (i12 < 0 || i13 >= r42.f3351) {
                        int i19 = i12 + 1;
                        int i20 = i13 + 3;
                    }
                    r42.mo9404(i12, i13, i3);
                    i3++;
                    i12 -= 2;
                    i13 += 2;
                    break;
                } while (i13 >= r42.f3351);
                int i192 = i12 + 1;
                int i202 = i13 + 3;
                do {
                    if (i192 >= 0 && i202 < r42.f3351 && !r42.mo9407(i202, i192)) {
                        r42.mo9404(i192, i202, i3);
                        i3++;
                    }
                    i192 += 2;
                    i202 -= 2;
                    if (i192 >= r42.f3350) {
                        break;
                    }
                } while (i202 >= 0);
                i12 = i192 + 3;
                i13 = i202 + 1;
                i4 = r42.f3350;
                if (i12 >= i4 && i13 >= (i5 = r42.f3351)) {
                    break;
                }
                i8 = 0;
                i14 = i3;
            }
            if (!r42.mo9407(i5 - 1, i4 - 1)) {
                r42.mo9406(r42.f3351 - 1, r42.f3350 - 1, true);
                r42.mo9406(r42.f3351 - 2, r42.f3350 - 2, true);
            }
            int r02 = r34.mo9541();
            int r53 = r34.mo9540();
            int r63 = r34.mo9543();
            int r72 = r34.mo9542();
            byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{r72, r63});
            int i21 = 0;
            for (int i22 = 0; i22 < r53; i22++) {
                if (i22 % r34.f3631 == 0) {
                    int i23 = 0;
                    for (int i24 = 0; i24 < r34.mo9543(); i24++) {
                        bArr[i21][i23] = (byte) (i24 % 2 == 0 ? 1 : 0);
                        i23++;
                    }
                    i21++;
                }
                int i25 = 0;
                for (int i26 = 0; i26 < r02; i26++) {
                    if (i26 % r34.f3630 == 0) {
                        bArr[i21][i25] = (byte) 1;
                        i25++;
                    }
                    bArr[i21][i25] = (byte) (r42.f3352[(r42.f3351 * i22) + i26] == 1 ? 1 : 0);
                    i25++;
                    int i27 = r34.f3630;
                    if (i26 % i27 == i27 - 1) {
                        bArr[i21][i25] = (byte) (i22 % 2 == 0 ? 1 : 0);
                        i25++;
                    }
                }
                i21++;
                int i28 = r34.f3631;
                if (i22 % i28 == i28 - 1) {
                    int i29 = 0;
                    for (int i30 = 0; i30 < r34.mo9543(); i30++) {
                        bArr[i21][i29] = (byte) 1;
                        i29++;
                    }
                    i21++;
                }
            }
            int max = Math.max(i6, r63);
            int max2 = Math.max(i7, r72);
            int min = Math.min(max / r63, max2 / r72);
            int r03 = outline.m2540(r63, min, max, 2);
            int r35 = outline.m2540(r72, min, max2, 2);
            if (i7 < r72 || i6 < r63) {
                r5 = new BitMatrix(r63, r72);
                r35 = 0;
                r03 = 0;
            } else {
                r5 = new BitMatrix(i6, i7);
            }
            r5.mo9090();
            int i31 = 0;
            while (i31 < r72) {
                int i32 = 0;
                int i33 = r03;
                while (i32 < r63) {
                    if (bArr[i31][i32] == 1) {
                        r5.mo9091(i33, r35, min, min);
                    }
                    i32++;
                    i33 += min;
                }
                i31++;
                r35 += min;
            }
            return r5;
        }
    }
}
