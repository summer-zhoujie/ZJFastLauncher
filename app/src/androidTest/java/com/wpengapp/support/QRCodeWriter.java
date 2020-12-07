package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ॱ */
public final class QRCodeWriter implements Writer {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r9, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (r9 != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(r9)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            ErrorCorrectionLevel r92 = ErrorCorrectionLevel.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    r92 = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(EncodeHintType.MARGIN)) {
                    i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                }
            }
            ByteMatrix r8 = Encoder.m1577(str, r92, map).f2794;
            if (r8 != null) {
                int i4 = r8.f1502;
                int i5 = r8.f1503;
                int i6 = i3 << 1;
                int i7 = i4 + i6;
                int i8 = i6 + i5;
                int max = Math.max(i, i7);
                int max2 = Math.max(i2, i8);
                int min = Math.min(max / i7, max2 / i8);
                int r2 = outline.m2540(i4, min, max, 2);
                int r3 = outline.m2540(i5, min, max2, 2);
                BitMatrix r4 = new BitMatrix(max, max2);
                int i9 = 0;
                while (i9 < i5) {
                    int i10 = 0;
                    int i11 = r2;
                    while (i10 < i4) {
                        if (r8.mo8340(i10, i9) == 1) {
                            r4.mo9091(i11, r3, min, min);
                        }
                        i10++;
                        i11 += min;
                    }
                    i9++;
                    r3 += min;
                }
                return r4;
            }
            throw new IllegalStateException();
        }
    }
}
