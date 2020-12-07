package com.wpengapp.support;

import com.wpengapp.support.permission.ServicePermissionActivity;

/* renamed from: com.wpengapp.support.Ϲ */
/* compiled from: ServicePermissionActivity */
class C0677 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ ServicePermissionActivity f1764;

    public C0677(ServicePermissionActivity servicePermissionActivity) {
        this.f1764 = servicePermissionActivity;
    }

    public void run() {
        boolean r0 = ServicePermissionActivity.m913();
        ServicePermissionActivity servicePermissionActivity = this.f1764;
        if ((!servicePermissionActivity.f721) && r0) {
            servicePermissionActivity.mo7897();
        }
        ServicePermissionActivity servicePermissionActivity2 = this.f1764;
        servicePermissionActivity2.f721 = r0;
        servicePermissionActivity2.mo7896();
    }
}
