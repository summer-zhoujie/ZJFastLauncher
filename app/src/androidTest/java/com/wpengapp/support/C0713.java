package com.wpengapp.support;

import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.ё */
/* compiled from: RequestPermissionHelper */
class C0713 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ RequestPermissionHelper.C0458 f1839;

    /* renamed from: ؠ */
    public final /* synthetic */ String[] f1840;

    public C0713(RequestPermissionHelper.C0458 r1, String[] strArr) {
        this.f1839 = r1;
        this.f1840 = strArr;
    }

    public void run() {
        RequestPermissionHelper.C0458 r0 = this.f1839;
        if (r0 != null) {
            r0.mo7894(this.f1840, new String[0]);
        }
    }
}
