package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.view.View;
import com.wpengapp.support.permission.KeepAlivePermissionView;

/* renamed from: com.wpengapp.support.ݟ */
/* compiled from: KeepAlivePermissionView */
class C0934 implements View.OnClickListener {
    public C0934(KeepAlivePermissionView keepAlivePermissionView) {
    }

    public void onClick(View view) {
        boolean z;
        PowerManager powerManager;
        try {
            z = true;
            if (!Utils.m1896(Utils.m1905().mo8223())) {
                if (Build.VERSION.SDK_INT >= 23 && (powerManager = (PowerManager) AppUtils.m1153("power")) != null) {
                    if (powerManager.isIgnoringBatteryOptimizations(AppUtils.m1163())) {
                        C0826.m2179(R$string.pw_permission_granted, new Object[0]);
                    } else {
                        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                        intent.setData(Uri.parse("package:" + AppUtils.m1163()));
                        SystemUtils.m3510((Context) null, intent);
                    }
                }
                z = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (!z) {
            C0826.m2179(R$string.pw_permission_quick_setup_not_support, new Object[0]);
        }
    }
}
