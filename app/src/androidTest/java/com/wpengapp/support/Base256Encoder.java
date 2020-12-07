package com.wpengapp.support;

import android.support.p000v4.view.InputDeviceCompat;

/* renamed from: com.wpengapp.support.ೲ */
public final class Base256Encoder implements C1239 {
    /* renamed from: ֏ */
    public void mo9379(EncoderContext r8) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!r8.mo9522()) {
                break;
            }
            sb.append(r8.mo9520());
            r8.f3589++;
            if (C1279.m3385((CharSequence) r8.f3584, r8.f3589, 5) != 5) {
                r8.f3590 = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        int r4 = r8.mo9516() + length + 1;
        r8.mo9519(r4);
        boolean z = r8.f3591.f3628 - r4 > 0;
        if (r8.mo9522() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            int r5 = (((r8.mo9516() + 1) * 149) % 255) + 1 + sb.charAt(i);
            if (r5 > 255) {
                r5 += InputDeviceCompat.SOURCE_ANY;
            }
            r8.f3588.append((char) r5);
        }
    }
}
