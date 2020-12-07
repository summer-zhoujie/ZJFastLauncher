package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၷ */
public final class EAN8Writer extends UPCEANWriter {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.EAN_8) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = outline.m2543(str, UPCEANReader.m3490(str));
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!UPCEANReader.m3489(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[67];
        int r2 = OneDimensionalCodeWriter.m3484(zArr, 0, UPCEANReader.f3685, true) + 0;
        for (int i = 0; i <= 3; i++) {
            r2 += OneDimensionalCodeWriter.m3484(zArr, r2, UPCEANReader.f3688[Character.digit(str.charAt(i), 10)], false);
        }
        int r4 = OneDimensionalCodeWriter.m3484(zArr, r2, UPCEANReader.f3686, false) + r2;
        for (int i2 = 4; i2 <= 7; i2++) {
            r4 += OneDimensionalCodeWriter.m3484(zArr, r4, UPCEANReader.f3688[Character.digit(str.charAt(i2), 10)], true);
        }
        OneDimensionalCodeWriter.m3484(zArr, r4, UPCEANReader.f3685, true);
        return zArr;
    }
}
