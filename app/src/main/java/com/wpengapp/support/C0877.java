package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import com.wpengapp.support.permission.ServicePermissionActivity;

/* renamed from: com.wpengapp.support.ڂ */
/* compiled from: ServicePermissionActivity */
class C0877 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ ServicePermissionActivity f2376;

    public C0877(ServicePermissionActivity servicePermissionActivity) {
        this.f2376 = servicePermissionActivity;
    }

    public void onClick(View view) {
        this.f2376.f720 = !AccServiceHelper.m2017(ServicePermissionActivity.f713.mo7899());
        AccServiceHelper.m2012((Context) this.f2376);
    }
}
