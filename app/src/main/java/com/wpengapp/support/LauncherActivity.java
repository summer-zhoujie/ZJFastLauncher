package com.wpengapp.support;

import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.ϭ */
class LauncherActivity implements RequestPermissionHelper.C0457 {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f1745;

    /* renamed from: ؠ */
    public final /* synthetic */ com.wpengapp.support.activity.LauncherActivity f1746;

    public LauncherActivity(com.wpengapp.support.activity.LauncherActivity launcherActivity, boolean z) {
        this.f1746 = launcherActivity;
        this.f1745 = z;
    }

    /* renamed from: ֏ */
    public void mo8449() {
        if (BaseApplication.f562) {
            C0826.m2177((CharSequence) "BasePermissionGranted");
        }
        BaseApplication.f561.mo7796();
        this.f1746.mo7830(this.f1745);
    }
}
