package com.wpengapp.support;

import android.os.Looper;
import com.wpengapp.support.C1315;

/* renamed from: com.wpengapp.support.ଶ */
/* compiled from: UMCCAggregatedManager */
class C1145 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1315 f3246;

    public C1145(C1315 r1) {
        this.f3246 = r1;
    }

    public void run() {
        Looper.prepare();
        C1315 r0 = this.f3246;
        if (r0.f3766 == null) {
            r0.f3766 = new C1315.C1316(r0);
        }
        this.f3246.mo9582();
    }
}
