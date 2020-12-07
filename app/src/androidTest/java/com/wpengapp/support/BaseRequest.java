package com.wpengapp.support;

import android.os.SystemClock;

/* renamed from: com.wpengapp.support.ϊ */
public class BaseRequest implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C0968 f1712;

    public BaseRequest(C0968 r1) {
        this.f1712 = r1;
    }

    public void run() {
        try {
            Response r0 = ((C1140) this.f1712.f2695).mo9320();
            HttpResponse r1 = this.f1712.mo8758(r0);
            r1.f3513 = this.f1712.f2696;
            C1279.m3407(r0.f1351, this.f1712.f2696, r1.f3519, SystemClock.elapsedRealtime() - this.f1712.f2698);
            AppUtils.m1146((Runnable) new C1238(this, r1));
        } catch (Exception e) {
            AppUtils.m1146((Runnable) new C0964(this, e));
        }
    }
}
