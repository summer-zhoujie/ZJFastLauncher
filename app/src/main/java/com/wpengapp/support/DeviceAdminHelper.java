package com.wpengapp.support;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.wpengapp.baseui.BaseActivity;
import java.lang.ref.WeakReference;

public class DeviceAdminHelper extends BaseActivity {

    /* renamed from: ފ */
    public static WeakReference<C0445> f574;

    /* renamed from: ދ */
    public boolean f575 = true;

    /* renamed from: com.wpengapp.support.DeviceAdminHelper$֏ */
    public interface C0445 {
        /* renamed from: ֏ */
        void mo7801(boolean z);
    }

    /* renamed from: ֏ */
    public static void m721(Context context) {
        Intent intent = new Intent(context, DeviceAdminHelper.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        f574 = null;
    }

    /* renamed from: ؠ */
    public static void m722(Context context) {
        try {
            ((DevicePolicyManager) context.getSystemService("device_policy")).removeActiveAdmin(new ComponentName(AppUtils.getApplication(), DeviceAdminReceiver.class));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ހ */
    public static void m723(boolean z) {
        PackageManager packageManager = AppUtils.getApplication().getPackageManager();
        ComponentName componentName = new ComponentName(AppUtils.getApplication(), DeviceAdminReceiver.class);
        if (z) {
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } else {
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        }
    }

    /* renamed from: ގ */
    public static boolean m724() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) AppUtils.getApplication().getSystemService("device_policy");
        if (devicePolicyManager == null) {
            return false;
        }
        return devicePolicyManager.isAdminActive(new ComponentName(AppUtils.getApplication(), DeviceAdminReceiver.class));
    }

    /* renamed from: ޏ */
    public static boolean m725() {
        return AppUtils.getApplication().getPackageManager().getComponentEnabledSetting(new ComponentName(AppUtils.getApplication(), DeviceAdminReceiver.class)) == 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentName componentName = new ComponentName(this, DeviceAdminReceiver.class);
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        f574 = null;
    }

    public void onResume() {
        super.onResume();
        if (this.f575) {
            this.f575 = false;
            return;
        }
        finish();
        WeakReference<C0445> weakReference = f574;
        if (weakReference != null && weakReference.get() != null) {
            ((C0445) f574.get()).mo7801(m724());
            f574 = null;
        }
    }
}
