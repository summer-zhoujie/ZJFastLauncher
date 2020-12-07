package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ū */
class WPengVersionActivity implements QueryCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.activity.WPengVersionActivity f881;

    public WPengVersionActivity(com.wpengapp.support.activity.WPengVersionActivity wPengVersionActivity) {
        this.f881 = wPengVersionActivity;
    }

    /* renamed from: ֏ */
    public void mo8024(C1114 r1, boolean z, boolean z2, int i) {
        if (z) {
            this.f881.mo7844(r1.f3172);
            return;
        }
        this.f881.mo7424(R$string.pw_load_fail);
        this.f881.finish();
    }
}
