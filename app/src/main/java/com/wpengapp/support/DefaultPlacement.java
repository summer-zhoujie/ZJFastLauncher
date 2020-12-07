package com.wpengapp.support;

import java.util.Arrays;

/* renamed from: com.wpengapp.support.ൎ */
public class DefaultPlacement {

    /* renamed from: ֏ */
    public final CharSequence f3349;

    /* renamed from: ؠ */
    public final int f3350;

    /* renamed from: ހ */
    public final int f3351;

    /* renamed from: ށ */
    public final byte[] f3352;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.f3349 = charSequence;
        this.f3351 = i;
        this.f3350 = i2;
        this.f3352 = new byte[(i * i2)];
        Arrays.fill(this.f3352, (byte) -1);
    }

    /* renamed from: ֏ */
    public final void mo9406(int i, int i2, boolean z) {
        this.f3352[(i2 * this.f3351) + i] = z ? (byte) 1 : 0;
    }

    /* renamed from: ֏ */
    public final boolean mo9407(int i, int i2) {
        return this.f3352[(i2 * this.f3351) + i] >= 0;
    }

    /* renamed from: ֏ */
    public final void mo9405(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f3350;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.f3351;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.f3349.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        mo9406(i2, i, z);
    }

    /* renamed from: ֏ */
    public final void mo9404(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        mo9405(i4, i5, i3, 1);
        int i6 = i2 - 1;
        mo9405(i4, i6, i3, 2);
        int i7 = i - 1;
        mo9405(i7, i5, i3, 3);
        mo9405(i7, i6, i3, 4);
        mo9405(i7, i2, i3, 5);
        mo9405(i, i5, i3, 6);
        mo9405(i, i6, i3, 7);
        mo9405(i, i2, i3, 8);
    }
}
