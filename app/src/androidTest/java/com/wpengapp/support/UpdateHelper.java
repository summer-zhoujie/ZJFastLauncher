package com.wpengapp.support;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.App;
import com.wpengapp.support.model.GzhConfig;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;
import java.util.HashMap;

public class UpdateHelper {

    /* renamed from: ֏ */
    public static boolean f594 = false;

    /* renamed from: ؠ */
    public static String f595 = null;

    /* renamed from: ހ */
    public static int f596 = 0;

    /* renamed from: ށ */
    public static String f597 = null;

    /* renamed from: ނ */
    public static boolean f598 = false;

    /* renamed from: ރ */
    public static long f599 = 604800000;

    public static class NotificationClickService extends Service {
        @Nullable
        public IBinder onBind(Intent intent) {
            return null;
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            AppUtils.m1147((Runnable) new C1218(this), 500);
            try {
                App.AppVersion appVersion = (App.AppVersion) intent.getParcelableExtra("version");
                if (appVersion == null) {
                    return 2;
                }
                UpdateHelper.m736(appVersion);
                return 2;
            } catch (Exception e) {
                e.getMessage();
                SystemUtils.m3527("http://wpengapp.com");
            }
        }
    }

    /* renamed from: com.wpengapp.support.UpdateHelper$֏ */
    public interface C0447 {
        /* renamed from: ֏ */
        void mo7806();
    }

    /* renamed from: ֏ */
    public static void m740(boolean z, long j, C0447 r7) {
        if (System.currentTimeMillis() - RemoteSP.m1201("check_date", 0) >= j || RemoteSP.m1210("forceUpdate", false)) {
            m741(false, z, r7);
        }
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m744(App.AppVersion appVersion) {
        SharedPreferences r0 = AppUtils.m1149("update_version");
        if (appVersion == null) {
            r0.edit().remove("ver").apply();
            RemoteSP.m1206("forceUpdate", (Object) false, false);
            return;
        }
        r0.edit().putString("ver", GsonUtil.m2742(appVersion)).apply();
        RemoteSP.m1206("forceUpdate", (Object) Boolean.valueOf(appVersion.forceUpdate), false);
    }

    /* renamed from: ހ */
    public static boolean m745() {
        if (!GzhConfig.getConfig().update) {
            return false;
        }
        UserInfo r0 = C0536.m1309();
        if (r0 == null) {
            return true;
        }
        return !r0.mo8705();
    }

    /* renamed from: ֏ */
    public static void m738(RetCallback<App.AppVersion> r5) {
        if (!NetworkUtils.m1800()) {
            App.AppVersion r0 = m743();
            if (r0 == null) {
                r5.mo7932(AppUtils.m1141(R$string.pw_network_error, new Object[0]));
            } else {
                r5.mo7931(r0);
            }
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("id", AppUtils.m1163());
            new C0741(ApiConstant.f2709, hashMap, "version", r5).mo8757(false);
        }
    }

    /* renamed from: ؠ */
    public static App.AppVersion m743() {
        SharedPreferences r0 = AppUtils.m1149("update_version");
        String string = r0.getString("ver", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            App.AppVersion appVersion = (App.AppVersion) GsonUtil.m2740(string, App.AppVersion.class);
            if (appVersion.versionCode > AppUtils.m1158()) {
                return appVersion;
            }
            r0.edit().remove("ver").apply();
            return null;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: ֏ */
    public static void m739(String str) {
        RemoteSP.m1206("ignore", (Object) str, false);
    }

    /* renamed from: ֏ */
    public static void m741(boolean z, boolean z2, C0447 r4) {
        if (m742()) {
            if (z) {
                C0826.m2179(R$string.pw_update_checking, new Object[0]);
            }
            if (!f594) {
                f594 = true;
                m738((RetCallback<App.AppVersion>) new C1335(z, z2, r4));
            }
        }
    }

    /* renamed from: ֏ */
    public static void m737(App.AppVersion appVersion, C0447 r6, TextView textView) {
        StringBuilder sb = new StringBuilder();
        sb.append(SystemUtils.m3519(AppUtils.m1163()));
        sb.append("_");
        if (C1017.m2726(appVersion.dlUrl, outline.m2548(sb, appVersion.versionName, ".apk"), true, new C0753(appVersion, r6, textView)) < 0) {
            f594 = false;
            if (appVersion.forceUpdate && textView != null) {
                textView.setEnabled(true);
                textView.setClickable(true);
                try {
                    textView.setText(R$string.pw_update_now);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static boolean m742() {
        return !"googleplay".equals(Utils.m1901((Context) AppUtils.getApplication()));
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m736(App.AppVersion appVersion) {
        if (!appVersion.gzh || !m745() || !WechatSubscriptionActivity.m839(AppUtils.getApplication(), "Update")) {
            if (appVersion.versionCode == f596) {
                File file = new File(f595);
                if (TextUtils.equals(f597, MD5Utils.m1341(file)) && FileManager.m1197(file)) {
                    f594 = false;
                    return;
                }
            }
            if (!TextUtils.isEmpty(appVersion.exDlUrl)) {
                SystemUtils.m3527(appVersion.exDlUrl);
                f594 = false;
            } else if (!RequestPermissionHelper.m899("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
                SystemUtils.m3527(appVersion.dlUrl);
                f594 = false;
            } else {
                C0826.m2179(R$string.pw_update_downloading, new Object[0]);
                m737(appVersion, (C0447) null, (TextView) null);
            }
        } else {
            f594 = false;
        }
    }
}
