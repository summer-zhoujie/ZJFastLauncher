package com.wpengapp.support;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.umeng.analytics.MobclickAgent;
import com.wpengapp.lightstart.TheApplication;
import com.wpengapp.support.activity.LauncherActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ɦ */
public class UMengManager {

    /* renamed from: ֏ */
    public static ValCallback<Void, Map<String, String>> f1245;

    /* renamed from: ؠ */
    public static Application.ActivityLifecycleCallbacks f1246 = new C1060();

    /* renamed from: ֏ */
    public static void m1403(BaseEvent r4) {
        String str;
        if (r4 instanceof BaseCountEvent) {
            GzhEvent r42 = (GzhEvent) r4;
            String r0 = r42.mo8272();
            if (r42.f1613 == null) {
                str = r42.mo8273();
            } else {
                str = r42.mo8273() + "_" + String.valueOf(r42.f1613);
            }
            m1405(r0, str);
        } else if (r4 instanceof BaseValueEvent) {
            BaseValueEvent r43 = (BaseValueEvent) r4;
            MobclickAgent.onEventValue(AppUtils.getApplication(), r43.mo8272(), (Map<String, String>) null, r43.mo8473());
            "report event: " + r43.mo8272() + " - " + r43.mo8473();
        }
    }

    /* renamed from: ֏ */
    public static void m1406(String str, Map<String, String> map) {
        MobclickAgent.onEvent((Context) AppUtils.getApplication(), str, map);
        "report event: " + str + ", " + map;
    }

    /* renamed from: ֏ */
    public static void m1405(String str, String str2) {
        MobclickAgent.onEvent((Context) AppUtils.getApplication(), str, str2);
        "report event: " + str + " - " + str2;
    }

    /* renamed from: ֏ */
    public static void m1407(Throwable th) {
        MobclickAgent.f70b.mo7287a((Context) AppUtils.getApplication(), th);
    }

    /* renamed from: ֏ */
    public static void m1401() {
        MobclickAgent.onPageStart(AppUtils.getApplication().getClass().getSimpleName());
        MobclickAgent.onResume(AppUtils.getApplication());
        if (!BaseApplication.f562) {
            HashMap hashMap = new HashMap();
            hashMap.put("buildnum", BaseApplication.m705());
            hashMap.put("fullv", String.valueOf(SyncPayStatus.m1962()));
            hashMap.put("is_admin", String.valueOf(DeviceAdminHelper.m724()));
            PowerManager powerManager = (PowerManager) AppUtils.m1153("power");
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                hashMap.put("is_ignore_battery", String.valueOf(powerManager.isIgnoringBatteryOptimizations(AppUtils.m1163())));
            }
            hashMap.put("exclude_recents", String.valueOf(LauncherActivity.f635));
            hashMap.put("brand", Build.BRAND);
            hashMap.put("device", C0719.m1816());
            ValCallback<Void, Map<String, String>> r1 = f1245;
            if (r1 != null) {
                hashMap.putAll((Map) ((TheApplication.C0435) r1).mo7563((Object) null));
            }
            m1406("app_status", (Map<String, String>) hashMap);
        }
    }

    /* renamed from: ֏ */
    public static void m1404(Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", obj.getClass().getSimpleName());
        m1406("_pv_", (Map<String, String>) hashMap);
    }

    /* renamed from: ֏ */
    public static void m1402(Context context) {
        MobclickAgent.f70b.mo7305d(context.getApplicationContext());
    }
}
