package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.მ */
/* compiled from: RequestPermissionHelper */
class C1325 implements RequestPermissionHelper.C0458 {

    /* renamed from: ֏ */
    public final /* synthetic */ RequestPermissionHelper.C0458 f3795;

    /* renamed from: ؠ */
    public final /* synthetic */ RequestPermissionHelper f3796;

    public C1325(RequestPermissionHelper requestPermissionHelper, RequestPermissionHelper.C0458 r2) {
        this.f3796 = requestPermissionHelper;
        this.f3795 = r2;
    }

    /* renamed from: ֏ */
    public void mo7894(@NonNull String[] strArr, @NonNull String[] strArr2) {
        this.f3796.finish();
        RequestPermissionHelper.C0458 r0 = this.f3795;
        if (r0 != null) {
            r0.mo7894(strArr, strArr2);
        }
    }
}
