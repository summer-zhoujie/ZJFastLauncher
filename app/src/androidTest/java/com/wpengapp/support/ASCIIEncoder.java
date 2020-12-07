package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ೱ */
public final class ASCIIEncoder implements C1239 {
    /* renamed from: ֏ */
    public void mo9379(EncoderContext r8) {
        int i;
        String str = r8.f3584;
        int i2 = r8.f3589;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (C1279.m3428(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        if (i >= 2) {
            char charAt2 = r8.f3584.charAt(r8.f3589);
            char charAt3 = r8.f3584.charAt(r8.f3589 + 1);
            if (!C1279.m3428(charAt2) || !C1279.m3428(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            r8.f3588.append((char) ((charAt3 - '0') + ((charAt2 - '0') * 10) + 130));
            r8.f3589 += 2;
            return;
        }
        char r2 = r8.mo9520();
        int r3 = C1279.m3385((CharSequence) r8.f3584, r8.f3589, 0);
        if (r3 != 0) {
            if (r3 == 1) {
                r8.f3588.append(230);
                r8.f3590 = 1;
            } else if (r3 == 2) {
                r8.f3588.append(239);
                r8.f3590 = 2;
            } else if (r3 == 3) {
                r8.f3588.append(238);
                r8.f3590 = 3;
            } else if (r3 == 4) {
                r8.f3588.append(240);
                r8.f3590 = 4;
            } else if (r3 == 5) {
                r8.f3588.append(231);
                r8.f3590 = 5;
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(r3)));
            }
        } else if (C1279.m3432(r2)) {
            r8.f3588.append(235);
            r8.f3588.append((char) ((r2 - 128) + 1));
            r8.f3589++;
        } else {
            r8.f3588.append((char) (r2 + 1));
            r8.f3589++;
        }
    }
}
