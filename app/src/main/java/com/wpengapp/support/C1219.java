package com.wpengapp.support;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.p003v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.lightstart.TheApplication;
import com.wpengapp.lightstart.config.DefaultConfig;
import com.wpengapp.support.accservice.AccNodeSelector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.wpengapp.support.ບ */
/* compiled from: UserConfigManager */
public class C1219 {

    /* renamed from: ֏ */
    public static final C1323<HashMap<String, AppConfig>> f3477 = C1323.m3615("usrcfg", new C0939().getType(), (String) null, "usrcfg345");

    /* renamed from: ؠ */
    public static volatile Set<String> f3478;

    /* renamed from: ֏ */
    public static AppConfig m3271(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m3276().get(str);
    }

    @NonNull
    /* renamed from: ؠ */
    public static HashMap<String, AppConfig> m3276() {
        HashMap<String, AppConfig> r0 = f3477.mo9612();
        return r0 == null ? new HashMap<>() : r0;
    }

    /* renamed from: ހ */
    public static boolean m3280(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f3478 == null) {
            synchronized (C1219.class) {
                if (f3478 == null) {
                    m3286();
                }
            }
        }
        return f3478.contains(str);
    }

    /* renamed from: ށ */
    public static Set<String> m3281() {
        HashMap<String, AppConfig> r0 = m3276();
        HashSet hashSet = new HashSet();
        if (CollectionUtils.m1658((Map) r0)) {
            return hashSet;
        }
        for (Map.Entry next : r0.entrySet()) {
            if (next.getValue() != null && ((AppConfig) next.getValue()).f3016) {
                hashSet.add(next.getKey());
            }
        }
        return hashSet;
    }

    /* renamed from: ނ */
    public static void m3283() {
        HashMap hashMap = new HashMap();
        for (String put : C1149.m3075(true)) {
            AppConfig r4 = new AppConfig();
            r4.f3016 = true;
            r4.f3018 = true;
            r4.f3017 = true;
            hashMap.put(put, r4);
        }
        m3275((HashMap<String, AppConfig>) hashMap);
        C0909.m2388();
        TheApplication.m343();
        C1149.m3087();
    }

    /* renamed from: ރ */
    public static /* synthetic */ void m3284() {
        try {
            C1323 r2 = C1323.m3615("ic1", new UserConfigManager().getType(), (String) null, "usrcfg345");
            T hashMap = new HashMap();
            for (String put : C1149.m3075(true)) {
                AppConfig r6 = new AppConfig();
                r6.f3016 = true;
                r6.f3018 = true;
                hashMap.put(put, r6);
            }
            r2.f3785 = hashMap;
            r2.f3791 = true;
            TaskManager.m2720(new C0761(r2, hashMap));
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            C1323 r0 = C1323.m3615("ic2", new C0797().getType(), (String) null, "defcfg123");
            T defaultConfig = new DefaultConfig();
            HashMap<String, AppConfig> hashMap2 = new HashMap<>();
            for (String put2 : C1149.m3075(true)) {
                AppConfig r62 = new AppConfig();
                r62.f3016 = true;
                r62.f3018 = true;
                hashMap2.put(put2, r62);
            }
            defaultConfig.configData = hashMap2;
            defaultConfig.version = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            r0.f3785 = defaultConfig;
            r0.f3791 = true;
            TaskManager.m2720(new C0761(r0, defaultConfig));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* renamed from: ބ */
    public static /* synthetic */ void m3285() {
        try {
            C0909.m2388();
            TheApplication.m343();
        } catch (Exception unused) {
        }
    }

    /* renamed from: ޅ */
    public static void m3286() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = AppUtils.getApplication().getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null) {
            queryIntentActivities = new ArrayList<>();
        }
        f3478 = new HashSet();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            f3478.add(ForegroundAppManager.m1393(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
    }

    /* renamed from: ކ */
    public static void m3287() {
        if (C1149.m3083().configData == null) {
            m3275((HashMap<String, AppConfig>) null);
            return;
        }
        HashMap<String, AppConfig> r0 = m3276();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : C1149.m3083().configData.entrySet()) {
            if (next.getValue() != null) {
                AppConfig r4 = r0.get(next.getKey());
                if (r4 == null) {
                    r4 = new AppConfig();
                }
                r4.mo9231((AppConfig) next.getValue());
                hashMap.put(next.getKey(), r4);
            }
        }
        m3275((HashMap<String, AppConfig>) hashMap);
    }

    /* renamed from: އ */
    public static void m3288() {
        m3277(m3276());
    }

    /* renamed from: ֏ */
    public static PageConfig m3270(String str, String str2) {
        AppConfig r2;
        Map<String, PageConfig> map;
        if (TextUtils.isEmpty(str2) || (r2 = m3271(str)) == null || (map = r2.f3019) == null) {
            return null;
        }
        return map.get(str2);
    }

    /* renamed from: ؠ */
    public static boolean m3278(String str) {
        AppConfig r0 = m3271(str);
        if (r0 == null) {
            return false;
        }
        return r0.f3016;
    }

    /* renamed from: ؠ */
    public static void m3277(HashMap<String, AppConfig> hashMap) {
        HashMap hashMap2;
        PageConfig r8;
        DefaultConfig r0 = C1149.m3083();
        Integer num = r0.type;
        if (num == null || !num.equals(1)) {
            HashMap hashMap3 = new HashMap();
            if (!CollectionUtils.m1658((Map) hashMap)) {
                for (Map.Entry next : hashMap.entrySet()) {
                    AppConfig r5 = (AppConfig) next.getValue();
                    if (r5 != null && r5.f3017) {
                        AppConfig r6 = new AppConfig();
                        r6.f3017 = true;
                        r6.f3016 = r5.f3016;
                        hashMap3.put(next.getKey(), r6);
                        if (!CollectionUtils.m1658((Map) r5.f3019)) {
                            r6.f3019 = new HashMap();
                            for (Map.Entry next2 : r5.f3019.entrySet()) {
                                if (next2.getValue() != null && (((PageConfig) next2.getValue()).f2974 != 0 || ((PageConfig) next2.getValue()).mo9159())) {
                                    r6.f3019.put(next2.getKey(), next2.getValue());
                                }
                            }
                            if (CollectionUtils.m1658((Map) r6.f3019)) {
                                r6.f3019 = null;
                            }
                        }
                    }
                }
            }
            hashMap2 = hashMap3;
        } else {
            hashMap2 = new HashMap();
        }
        HashMap<String, AppConfig> hashMap4 = r0.configData;
        if (!CollectionUtils.m1658((Map) hashMap4)) {
            for (Map.Entry next3 : hashMap4.entrySet()) {
                AppConfig r52 = (AppConfig) next3.getValue();
                if (r52 != null) {
                    if (!(!r52.f3016 && !r52.f3018 && CollectionUtils.m1658((Map) r52.f3019) && !r52.f3017)) {
                        AppConfig r62 = (AppConfig) hashMap2.get(next3.getKey());
                        if (r62 == null) {
                            hashMap2.put(next3.getKey(), new AppConfig(r52));
                        } else {
                            r62.f3018 = r52.f3018;
                            if (!CollectionUtils.m1658((Map) r52.f3019)) {
                                if (CollectionUtils.m1658((Map) r62.f3019)) {
                                    r62.mo9232(r52.f3019);
                                    hashMap2.put(next3.getKey(), r62);
                                } else {
                                    for (Map.Entry next4 : r52.f3019.entrySet()) {
                                        if (next4.getValue() != null && ((r8 = r62.f3019.get(next4.getKey())) == null || !r8.mo9159())) {
                                            r62.f3019.put(next4.getKey(), new PageConfig((PageConfig) next4.getValue()));
                                        }
                                    }
                                    hashMap2.put(next3.getKey(), r62);
                                }
                            }
                        }
                    }
                }
            }
        }
        m3275((HashMap<String, AppConfig>) hashMap2);
        Integer num2 = r0.type;
        if (num2 != null && num2.equals(1)) {
            AppUtils.m1147((Runnable) C0994.f2799, (long) AnalyticsConstants.f108k);
        }
    }

    /* renamed from: ֏ */
    public static void m3273(String str, String str2, boolean z, String str3, AccNodeSelector accNodeSelector, String str4) {
        PageConfig r0 = new PageConfig();
        r0.f2973 = z;
        r0.f2974 = 1;
        r0.f2977 = accNodeSelector;
        r0.f2978 = str3;
        r0.f2982 = str4;
        AppConfig r4 = m3271(str);
        if (r4 == null) {
            r4 = new AppConfig();
            r4.f3016 = false;
        }
        r4.f3017 = true;
        if (r4.f3019 == null) {
            r4.f3019 = new HashMap();
        }
        r4.f3019.put(str2, r0);
        HashMap<String, AppConfig> r3 = m3276();
        r3.put(str, r4);
        m3275(r3);
        "addPageConfig: " + str2 + ", " + r0;
    }

    /* renamed from: ށ */
    public static void m3282(String str) {
        AppConfig r0 = C1149.m3083().configData.get(str);
        "resetAppConfigs " + str + ", " + r0;
        HashMap<String, AppConfig> r1 = m3276();
        AppConfig r2 = r1.get(str);
        if (r0 == null) {
            r1.put(str, (Object) null);
        } else {
            if (r2 == null) {
                r2 = new AppConfig();
            }
            r2.mo9231(r0);
            r1.put(str, r2);
        }
        m3275(r1);
    }

    /* renamed from: ހ */
    public static HashMap<String, AppConfig> m3279() {
        HashMap<String, AppConfig> hashMap = new HashMap<>();
        for (Map.Entry next : m3276().entrySet()) {
            if (next.getValue() != null && ((AppConfig) next.getValue()).f3017) {
                AppConfig r3 = new AppConfig((AppConfig) next.getValue());
                hashMap.put(next.getKey(), r3);
                if (!CollectionUtils.m1658((Map) r3.f3019)) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry next2 : r3.f3019.entrySet()) {
                        if (next2.getValue() != null && ((PageConfig) next2.getValue()).mo9159()) {
                            hashMap2.put(next2.getKey(), next2.getValue());
                        }
                    }
                    r3.f3019 = hashMap2;
                }
            }
        }
        return hashMap;
    }

    /* renamed from: ֏ */
    public static void m3274(String str, boolean z) {
        "setBlackApp: " + str + ", " + z;
        AppConfig r0 = m3271(str);
        if (r0 == null) {
            r0 = new AppConfig();
        }
        r0.f3016 = z;
        r0.f3017 = true;
        HashMap<String, AppConfig> r3 = m3276();
        r3.put(str, r0);
        m3275(r3);
    }

    /* renamed from: ֏ */
    public static void m3275(HashMap<String, AppConfig> hashMap) {
        C1323<HashMap<String, AppConfig>> r0 = f3477;
        r0.f3785 = hashMap;
        r0.f3791 = true;
        outline.m2551((C1323) r0, (Object) hashMap);
    }

    /* renamed from: ֏ */
    public static void m3272() {
        TaskManager.m2715((Runnable) C0637.f1634);
    }
}
