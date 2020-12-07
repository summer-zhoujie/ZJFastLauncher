package com.wpengapp.support;

import com.wpengapp.support.activity.CommonWebActivity;

/* renamed from: com.wpengapp.support.Ύ */
/* compiled from: CommonWebActivity */
class C0631 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ CommonWebActivity f1608;

    public C0631(CommonWebActivity commonWebActivity) {
        this.f1608 = commonWebActivity;
    }

    public void run() {
        if (!this.f1608.isFinishing() && !this.f1608.mo7442() && this.f1608.f630 <= this.f1608.f631) {
            CommonWebActivity.m788(this.f1608);
            if (this.f1608.f630 <= 100) {
                this.f1608.f625.setProgress(this.f1608.f630);
            } else {
                this.f1608.mo7824(false);
            }
            AppUtils.m1147((Runnable) this, 5);
        }
    }
}
