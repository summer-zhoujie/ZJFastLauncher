package com.wpengapp.support;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.wpengapp.support.ႀ */
public final class PDF417Writer implements Writer {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r8, int i, int i2, Map<EncodeHintType, ?> map) {
        boolean z;
        if (r8 == BarcodeFormat.PDF_417) {
            PDF417 r82 = new PDF417();
            int i3 = 30;
            int i4 = 2;
            if (map != null) {
                if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                    r82.f3829 = Boolean.valueOf(map.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue();
                }
                if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                    r82.f3830 = Compaction.valueOf(map.get(EncodeHintType.PDF417_COMPACTION).toString());
                }
                if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                    Dimensions r2 = (Dimensions) map.get(EncodeHintType.PDF417_DIMENSIONS);
                    int i5 = r2.f3778;
                    int i6 = r2.f3777;
                    int i7 = r2.f3780;
                    int i8 = r2.f3779;
                    r82.f3833 = i5;
                    r82.f3832 = i6;
                    r82.f3834 = i7;
                    r82.f3835 = i8;
                }
                if (map.containsKey(EncodeHintType.MARGIN)) {
                    i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                }
                if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    i4 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                    r82.f3831 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
                }
            }
            r82.mo9642(str, i4);
            byte[][] r7 = r82.mo9641().mo9552(1, 4);
            if ((i2 > i) != (r7[0].length < r7.length)) {
                r7 = m3496(r7);
                z = true;
            } else {
                z = false;
            }
            int length = i / r7[0].length;
            int length2 = i2 / r7.length;
            if (length >= length2) {
                length = length2;
            }
            if (length <= 1) {
                return m3495(r7, i3);
            }
            byte[][] r72 = r82.mo9641().mo9552(length, length << 2);
            if (z) {
                r72 = m3496(r72);
            }
            return m3495(r72, i3);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(r8)));
    }

    /* renamed from: ֏ */
    public static BitMatrix m3495(byte[][] bArr, int i) {
        int i2 = i * 2;
        BitMatrix r0 = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        int length = r0.f2833.length;
        for (int i3 = 0; i3 < length; i3++) {
            r0.f2833[i3] = 0;
        }
        int i4 = (r0.f2831 - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    r0.mo9094(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return r0;
    }

    /* renamed from: ֏ */
    public static byte[][] m3496(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
