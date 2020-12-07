package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ԥ */
/* compiled from: WpAlipay */
class C0768 implements WpAlipayCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ WpAlipayCallback f1976;

    /* renamed from: ؠ */
    public final /* synthetic */ C1305 f1977;

    public C0768(C1305 r1, WpAlipayCallback r2) {
        this.f1977 = r1;
        this.f1976 = r2;
    }

    /* renamed from: ֏ */
    public void mo8503(boolean z, String str) {
        AppUtils.m1146((Runnable) new WpAlipay(this, z, str));
    }
}
