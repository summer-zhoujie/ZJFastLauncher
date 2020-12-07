package com.wpengapp.support;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.lightstart.report.SkipRecord;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.Ĺ */
/* compiled from: ReportManager */
public class C0471 {

    /* renamed from: ֏ */
    public static final C1323<SkipRecord> f804 = C1323.m3613("skprcd", new ReportManager().getType());

    /* renamed from: ֏ */
    public static int m1011(String str) {
        m1021();
        SkipRecord r0 = f804.mo9612();
        if (r0 == null || CollectionUtils.m1658((Map) r0.appRecord)) {
            return 0;
        }
        Integer num = r0.appRecord.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    /* renamed from: ؠ */
    public static synchronized void m1021() {
        T t;
        synchronized (C0471.class) {
            String r1 = RemoteSP.m1202("SKIP_RECORD", (String) null);
            if (!TextUtils.isEmpty(r1)) {
                RemoteSP.m1206("SKIP_RECORD", (Object) null, false);
                try {
                    t = (SkipRecord) GsonUtil.m2740(r1, SkipRecord.class);
                } catch (Exception e) {
                    e.getMessage();
                    t = null;
                }
                if (t != null) {
                    C1323<SkipRecord> r2 = f804;
                    r2.f3785 = t;
                    r2.f3791 = true;
                    TaskManager.m2720(new C0761(r2, t));
                }
            }
        }
    }

    /* renamed from: ހ */
    public static void m1025(String str) {
        "reportApp " + str;
        HashMap hashMap = new HashMap();
        hashMap.put(AppWrapper.KEY_APP_PACKAGE_NAME, str);
        PackageInfo r1 = SystemUtils.m3524(str);
        if (r1 != null) {
            hashMap.put("name", r1.versionName);
            hashMap.put("ver", SystemUtils.m3519(str));
        }
        hashMap.put("device", C0719.m1816());
        StatisticsManager.m733(StatisticsManager.f585, "rp_app", hashMap);
    }

    /* renamed from: ށ */
    public static void m1026(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", ForegroundAppManager.m1392(str));
        StatisticsManager.m733(StatisticsManager.f585, "count_limit4", hashMap);
    }

    /* renamed from: ֏ */
    public static void m1017(String str, boolean z) {
        "[reportUserSetApp] " + str + ", " + z;
        HashMap hashMap = new HashMap();
        hashMap.put(AppWrapper.KEY_APP_PACKAGE_NAME, str);
        PackageInfo r1 = SystemUtils.m3524(str);
        if (r1 != null) {
            hashMap.put("name", r1.versionName);
            hashMap.put("ver", SystemUtils.m3519(str));
        }
        hashMap.put("device", C0719.m1816());
        hashMap.put("black", z ? "1" : "0");
        StatisticsManager.m733(StatisticsManager.f585, "rp_set_app", hashMap);
    }

    /* renamed from: ؠ */
    public static void m1022(String str) {
        m1021();
        T t = (SkipRecord) f804.mo9612();
        if (t == null) {
            t = new SkipRecord();
        }
        if (t.appRecord == null) {
            t.appRecord = new HashMap();
        }
        Integer num = t.appRecord.get(str);
        if (num == null || num.intValue() < 0) {
            num = 0;
        }
        t.appRecord.put(str, Integer.valueOf(num.intValue() + 1));
        C1323<SkipRecord> r4 = f804;
        r4.f3785 = t;
        r4.f3791 = true;
        outline.m2551((C1323) r4, (Object) t);
    }

    /* renamed from: ֏ */
    public static void m1016(String str, String str2, boolean z, String str3) {
        "[reportUserSetPage] " + str2 + ", " + z + ", " + str3;
        HashMap hashMap = new HashMap();
        hashMap.put(AppWrapper.KEY_APP_PACKAGE_NAME, str);
        PackageInfo r1 = SystemUtils.m3524(str);
        if (r1 != null) {
            hashMap.put("name", r1.versionName);
            hashMap.put("ver", SystemUtils.m3519(str));
        }
        hashMap.put("device", C0719.m1816());
        hashMap.put("bid", str3);
        hashMap.put("black", z ? "1" : "0");
        hashMap.put("page", ForegroundAppManager.m1392(str2));
        StatisticsManager.m733(StatisticsManager.f585, "rp_set_page", hashMap);
    }

    /* renamed from: ؠ */
    public static void m1024(String str, String str2, CustomPageConfig r3) {
        TaskManager.m2715((Runnable) new C0693(str, str2, r3));
    }

    /* renamed from: ֏ */
    public static void m1013(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, String str4) {
        if (!AppUtils.m1163().equals(str)) {
            String valueOf = String.valueOf(C1279.m3441(accessibilityNodeInfo));
            if (valueOf.length() > 20) {
                valueOf = valueOf.substring(0, 20) + "...(" + valueOf.length() + ")";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AppWrapper.KEY_APP_PACKAGE_NAME, str);
            hashMap.put("page", ForegroundAppManager.m1392(str2));
            hashMap.put("keyword", str3);
            hashMap.put("content", valueOf);
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("extra", str4);
            }
            StatisticsManager.m733(StatisticsManager.f585, "kw2", hashMap);
        }
    }

    /* renamed from: ؠ */
    public static void m1023(String str, String str2) {
        HashMap hashMap = new HashMap();
        m1019((Map<String, String>) hashMap);
        hashMap.put("fun", str);
        hashMap.put("log", str2);
        StatisticsManager.m733(StatisticsManager.f585, "xp_err", hashMap);
    }

    /* renamed from: ֏ */
    public static void m1018(String str, boolean z, String str2, Float f) {
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("v", String.valueOf(AppUtils.m1158()));
            hashMap.put("page", ForegroundAppManager.m1392(str));
            hashMap.put("ret", String.valueOf(z));
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("bid", str2);
            }
            if (f != null) {
                hashMap.put("area", f.toString());
            }
            StatisticsManager.m733(StatisticsManager.f585, "skip_result", hashMap);
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1015(String str, String str2, CustomPageConfig r6) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("app", str);
            hashMap.put("page", ForegroundAppManager.m1392(str2));
            JSONObject jSONObject = new JSONObject(GsonUtil.m2742(r6));
            jSONObject.remove("is_black");
            jSONObject.remove("lst");
            jSONObject.remove("user_modify");
            Object remove = jSONObject.remove("node_selector");
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2.length() > 1000) {
                jSONObject2 = jSONObject2.substring(0, 999);
            }
            hashMap.put("cfg", jSONObject2);
            if (remove != null) {
                String obj = remove.toString();
                if (obj.length() > 1000) {
                    obj = obj.substring(0, 999);
                }
                hashMap.put("selector", obj);
            }
            hashMap.put("share", SpHandler.f1759.mo8104().booleanValue() ? "1" : "0");
            StatisticsManager.m733(StatisticsManager.f585, "add_custom_rule", hashMap);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static void m1012() {
        HashMap hashMap = new HashMap();
        m1019((Map<String, String>) hashMap);
        StatisticsManager.m733(StatisticsManager.f585, "xp_boot", hashMap);
    }

    /* renamed from: ֏ */
    public static void m1020(boolean z, int i, long j, String str) {
        HashMap hashMap = new HashMap();
        m1019((Map<String, String>) hashMap);
        hashMap.put("ret", String.valueOf(z));
        hashMap.put("time", String.valueOf(j));
        hashMap.put("fm", String.valueOf(i));
        hashMap.put("log", str);
        StatisticsManager.m733(StatisticsManager.f585, "xp_connect", hashMap);
    }

    /* renamed from: ֏ */
    public static void m1014(String str, String str2) {
        if (!CountLimitHelper.m997("add_custom_err", 60000)) {
            HashMap hashMap = new HashMap();
            m1019((Map<String, String>) hashMap);
            hashMap.put(AppWrapper.KEY_APP_PACKAGE_NAME, str);
            hashMap.put("page", ForegroundAppManager.m1392(str2));
            StatisticsManager.m733(StatisticsManager.f585, "add_custom_err", hashMap);
        }
    }

    /* renamed from: ֏ */
    public static void m1019(Map<String, String> map) {
        map.put("ver", String.valueOf(AppUtils.m1158()));
        map.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        map.put("device", C0719.m1816());
    }
}
