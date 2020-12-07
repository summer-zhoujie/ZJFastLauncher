package com.wpengapp.support;

import android.os.Bundle;
import android.view.View;
import com.wpengapp.support.accservice.BaseAccessibilityService;
import com.wpengapp.support.permission.KeepAlivePermissionView;
import com.wpengapp.support.permission.ServicePermissionActivity;

/* renamed from: com.wpengapp.support.ڭ */
/* compiled from: KeepAlivePermissionView */
class C0894 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ KeepAlivePermissionView f2416;

    public C0894(KeepAlivePermissionView keepAlivePermissionView) {
        this.f2416 = keepAlivePermissionView;
    }

    public void onClick(View view) {
        if (AccServiceHelper.m2017(ServicePermissionActivity.f713.mo7899())) {
            RemoteMethod r3 = BaseAccessibilityService.f603;
            C1146.m3071(r3.f1927, (Bundle) null, new C1104(this));
            return;
        }
        C0826.m2179(R$string.pw_permission_quick_setup_not_support, new Object[0]);
    }
}
