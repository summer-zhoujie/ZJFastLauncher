package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.གྷ */
/* compiled from: RequestPermissionHelper */
class C1242 implements RequestPermissionHelper.C0458 {

    /* renamed from: ֏ */
    public final /* synthetic */ String[] f3528;

    public C1242(String[] strArr) {
        this.f3528 = strArr;
    }

    /* renamed from: ֏ */
    public void mo7894(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (!RequestPermissionHelper.m899(this.f3528)) {
            C0826.m2172(R$string.pw_permission_storage, new Object[0]);
        }
    }
}
