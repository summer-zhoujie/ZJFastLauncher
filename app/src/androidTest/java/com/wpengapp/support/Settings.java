package com.wpengapp.support;

import android.support.p000v4.internal.view.SupportMenu;

/* renamed from: com.wpengapp.support.შ */
public final class Settings {

    /* renamed from: ֏ */
    public int f3799;

    /* renamed from: ؠ */
    public final int[] f3800 = new int[10];

    /* renamed from: ֏ */
    public Settings mo9621(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f3800;
            if (i < iArr.length) {
                this.f3799 = (1 << i) | this.f3799;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* renamed from: ֏ */
    public void mo9622(Settings r6) {
        for (int i = 0; i < 10; i++) {
            boolean z = true;
            if (((1 << i) & r6.f3799) == 0) {
                z = false;
            }
            if (z) {
                mo9621(i, r6.f3800[i]);
            }
        }
    }

    /* renamed from: ֏ */
    public int mo9620() {
        return (this.f3799 & 128) != 0 ? this.f3800[7] : SupportMenu.USER_MASK;
    }
}
