package com.wpengapp.support;

import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.ๆ */
/* compiled from: QrPayActivity */
class C1208 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ QrPayActivity f3465;

    public C1208(QrPayActivity qrPayActivity) {
        this.f3465 = qrPayActivity;
    }

    public void run() {
        if (!this.f3465.mo7442() && !this.f3465.isFinishing()) {
            if (this.f3465.f685) {
                this.f3465.finish();
            } else if (this.f3465.f684 != null) {
                int i = this.f3465.f687.biz;
                C0925 r1 = new C0925(this);
                C0505 r2 = new C0505(this);
                IPayResultChecker r0 = C0678.f1771.get(i);
                if (r0 == null) {
                    r2.run();
                } else {
                    r0.mo8392(r1, r2);
                }
            }
        }
    }
}
