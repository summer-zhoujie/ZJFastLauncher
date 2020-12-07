package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ǖ */
/* compiled from: PayManager */
class C0526 extends SyncUserInfoListener {

    /* renamed from: ֏ */
    public final /* synthetic */ int f983;

    public C0526(int i) {
        this.f983 = i;
    }

    /* renamed from: ֏ */
    public void mo8101(UserInfo r4) {
        if (!C0536.m1313(r4) && this.f983 > 0) {
            C0678.f1767.postDelayed(new C1286(this), 10000);
        }
    }

    /* renamed from: ֏ */
    public void mo8100(int i) {
        if (this.f983 > 0) {
            C0678.f1767.postDelayed(new C1286(this), 10000);
        }
    }
}
