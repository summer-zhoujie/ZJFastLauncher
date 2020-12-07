package com.wpengapp.support;

import android.app.Activity;

/* renamed from: com.wpengapp.support.Σ */
/* compiled from: CheckDeviceManager */
class C0638 extends SyncUserInfoListener {

    /* renamed from: ֏ */
    public final /* synthetic */ Runnable f1640;

    /* renamed from: ؠ */
    public final /* synthetic */ Activity f1641;

    public C0638(Runnable runnable, Activity activity) {
        this.f1640 = runnable;
        this.f1641 = activity;
    }

    /* renamed from: ֏ */
    public void mo8101(UserInfo r3) {
        if (C0536.m1313(r3) || C0536.m1322()) {
            C1307.m3565();
            this.f1640.run();
            return;
        }
        C1307.m3556(this.f1641, r3, this.f1640);
    }

    /* renamed from: ֏ */
    public void mo8100(int i) {
        this.f1640.run();
    }
}
