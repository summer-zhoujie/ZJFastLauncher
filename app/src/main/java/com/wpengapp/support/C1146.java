package com.wpengapp.support;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ୡ */
/* compiled from: RemoteCaller */
public class C1146 {

    /* renamed from: ֏ */
    public static final String f3264 = (AppUtils.m1163() + ".rcp");

    /* renamed from: ؠ */
    public static final Uri f3265 = new Uri.Builder().scheme("content").authority(f3264).build();

    /* renamed from: ހ */
    public static final Map<String, RemoteMethod> f3266;

    /* renamed from: ށ */
    public static Boolean f3267;

    static {
        if (m3072()) {
            f3266 = new HashMap();
        } else {
            f3266 = null;
        }
    }

    /* renamed from: ֏ */
    public static boolean m3072() {
        if (f3267 == null) {
            f3267 = Boolean.valueOf(AppUtils.m1157(AppUtils.m1141(R$string.process_service, new Object[0])));
        }
        return f3267.booleanValue();
    }

    /* renamed from: ؠ */
    public static boolean m3074() {
        String str = AppUtils.m1163() + AppUtils.m1141(R$string.process_service, new Object[0]);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : AppUtils.m1167()) {
            String str2 = runningAppProcessInfo.processName;
            if (str2 != null && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    /* renamed from: ֏ */
    public static RemoteResult m3069(@NonNull String str, @Nullable Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        "Remote Call [" + str + "]";
        Bundle bundle2 = null;
        try {
            bundle2 = AppUtils.getApplication().getContentResolver().call(f3265, str, (String) null, bundle);
        } catch (Exception e) {
            e.getMessage();
        }
        RemoteResult r6 = new RemoteResult();
        r6.f3116 = bundle2;
        boolean z = false;
        if (bundle2 != null && bundle2.getBoolean("call_success", false)) {
            z = true;
        }
        r6.f3115 = z;
        "Remote Return [" + str + "] " + (System.currentTimeMillis() - currentTimeMillis) + "ms, " + m3070(r6.f3116);
        return r6;
    }

    /* renamed from: ؠ */
    public static Bundle m3073(@NonNull String str, @Nullable Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        BaseApplication.f561.mo7798();
        if (Binder.getCallingUid() != Process.myUid()) {
            "Invoke [" + str + "][Permission denied!] " + m3070(bundle);
            return null;
        }
        "Invoke [" + str + "] " + m3070(bundle);
        RemoteMethod r2 = f3266.get(str);
        if (r2 == null) {
            bundle2 = new Bundle();
            bundle2.putBoolean("call_success", false);
            "Invoke [" + str + "] The method has not register";
        } else {
            try {
                bundle2 = r2.mo7979(bundle);
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("call_success", true);
            } catch (Exception e) {
                e.getMessage();
                bundle2 = new Bundle();
                bundle2.putBoolean("call_success", false);
            }
        }
        "Invoke Return [" + str + "] " + (System.currentTimeMillis() - currentTimeMillis) + "ms";
        return bundle2;
    }

    /* renamed from: ֏ */
    public static void m3071(@NonNull String str, @Nullable Bundle bundle, @Nullable RemoteCallback r3) {
        TaskManager.m2715((Runnable) new RemoteCaller(str, bundle, r3));
    }

    /* renamed from: ֏ */
    public static String m3070(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        if (!BaseApplication.f562) {
            return "bundle";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(str);
            sb.append(": ");
            sb.append(bundle.get(str));
            sb.append(", ");
        }
        return sb.toString();
    }
}
