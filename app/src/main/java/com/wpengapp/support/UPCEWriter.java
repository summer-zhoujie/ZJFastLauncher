package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၿ */
public final class UPCEWriter extends UPCEANWriter {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.UPC_E) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(r3)));
    }

    /* renamed from: ֏ */
    public boolean[] mo9549(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = outline.m2543(str, UPCEANReader.m3490(UPCEReader.m3492(str)));
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
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i = UPCEReader.f3690[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int r5 = OneDimensionalCodeWriter.m3484(zArr, 0, UPCEANReader.f3685, true) + 0;
            for (int i2 = 1; i2 <= 6; i2++) {
                int digit2 = Character.digit(str.charAt(i2), 10);
                if (((i >> (6 - i2)) & 1) == 1) {
                    digit2 += 10;
                }
                r5 += OneDimensionalCodeWriter.m3484(zArr, r5, UPCEANReader.f3689[digit2], false);
            }
            OneDimensionalCodeWriter.m3484(zArr, r5, UPCEANReader.f3687, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
