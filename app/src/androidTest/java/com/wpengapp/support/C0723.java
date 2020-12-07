package com.wpengapp.support;

import android.support.annotation.NonNull;
import com.wpengapp.support.permission.RequestPermissionHelper;

/* renamed from: com.wpengapp.support.Ҁ */
/* compiled from: UpdateHelper */
class C0723 implements RequestPermissionHelper.C0458 {

    /* renamed from: ֏ */
    public final /* synthetic */ String[] f1872;

    public C0723(C1288 r1, String[] strArr) {
        this.f1872 = strArr;
    }

    /* renamed from: ֏ */
    public void mo7894(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (!RequestPermissionHelper.m899(this.f1872)) {
            C0826.m2172(R$string.pw_permission_storage, new Object[0]);
        }
    }
}
