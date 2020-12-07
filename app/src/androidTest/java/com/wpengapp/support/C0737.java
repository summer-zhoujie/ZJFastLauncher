package com.wpengapp.support;

import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.Ұ */
/* compiled from: WPengVersionActivity */
class C0737 implements UseAppCodeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ C1211 f1907;

    public C0737(C1211 r1) {
        this.f1907 = r1;
    }

    /* renamed from: ֏ */
    public void mo8519(boolean z, String str, ErrorCode r3) {
        if (z) {
            WPengVersionActivity wPengVersionActivity = this.f1907.f3469;
            wPengVersionActivity.mo7844(wPengVersionActivity.f657.f3172);
        } else if (r3 == ErrorCode.APP_CODE_USED) {
            this.f1907.f3469.mo7846();
        }
    }
}
