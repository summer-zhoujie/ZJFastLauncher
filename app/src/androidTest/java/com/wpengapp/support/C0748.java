package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.permission.KeepAlivePermissionView;

/* renamed from: com.wpengapp.support.ә */
/* compiled from: KeepAlivePermissionView */
class C0748 implements View.OnClickListener {
    public C0748(KeepAlivePermissionView keepAlivePermissionView) {
    }

    public void onClick(View view) {
        if (!Utils.m1896(Utils.m1905().mo8224())) {
            C0826.m2179(R$string.pw_permission_quick_setup_not_support, new Object[0]);
        }
    }
}
