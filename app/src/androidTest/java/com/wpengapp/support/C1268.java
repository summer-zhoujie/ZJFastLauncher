package com.wpengapp.support;

import com.wpengapp.support.C0837;

/* renamed from: com.wpengapp.support.འ */
/* compiled from: FloatBall */
class C1268 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C0837 f3568;

    public C1268(C0837 r1) {
        this.f3568 = r1;
    }

    public void run() {
        if (this.f3568.f2212 == this.f3568.f2195) {
            this.f3568.mo8734(10);
            C0837.C0838 r0 = this.f3568.f2186;
            if (r0 != null) {
                if (this.f3568.f2212 == -1) {
                    C1044 r02 = (C1044) r0;
                    C1032.m2756();
                } else {
                    byte unused = this.f3568.f2212;
                    C1044 r03 = (C1044) r0;
                }
            }
            this.f3568.f2183.postDelayed(this.f3568.f2214, this.f3568.f2199);
        }
    }
}
