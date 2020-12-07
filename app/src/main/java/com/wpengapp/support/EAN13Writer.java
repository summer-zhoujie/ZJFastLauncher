package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၶ */
public final class EAN13Writer extends UPCEANWriter {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.EAN_13) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = outline.m2543(str, UPCEANReader.m3490(str));
            } catch (FormatException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 13) {
            try {
                if (!UPCEANReader.m3489(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = EAN13Reader.f3680[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int r5 = OneDimensionalCodeWriter.m3484(zArr, 0, UPCEANReader.f3685, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int digit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                digit += 10;
            }
            r5 += OneDimensionalCodeWriter.m3484(zArr, r5, UPCEANReader.f3689[digit], false);
        }
        int r0 = OneDimensionalCodeWriter.m3484(zArr, r5, UPCEANReader.f3686, false) + r5;
        for (int i3 = 7; i3 <= 12; i3++) {
            r0 += OneDimensionalCodeWriter.m3484(zArr, r0, UPCEANReader.f3688[Character.digit(str.charAt(i3), 10)], true);
        }
        OneDimensionalCodeWriter.m3484(zArr, r0, UPCEANReader.f3685, true);
        return zArr;
    }
}
