package com.wpengapp.support;

import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.support.p003v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.lightstart.TheApplication;
import com.wpengapp.lightstart.config.DefaultConfig;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.wpengapp.support.ஈ */
/* compiled from: DefaultConfigManager */
public class C1149 {

    /* renamed from: ֏ */
    public static final C1323<DefaultConfig> f3269 = C1323.m3615("defcfg", new C0707().getType(), (String) null, "defcfg123");

    /* renamed from: ؠ */
    public static int f3270;

    /* renamed from: ހ */
    public static FullRule f3271;

    /* renamed from: ށ */
    public static Float f3272;

    /* renamed from: ނ */
    public static Integer f3273;

    /* renamed from: ރ */
    public static Integer f3274;

    /* renamed from: ބ */
    public static OnFileChangeListener f3275 = C0985.f2759;

    /* renamed from: ޅ */
    public static C1063.C1065 f3276 = new C1026();

    /* renamed from: ֏ */
    public static void m3076(DefaultConfig defaultConfig, boolean z) {
        Integer num = defaultConfig.type;
        if (num != null && num.equals(1)) {
            AppUtils.m1147((Runnable) C0770.f1988, (long) AnalyticsConstants.f108k);
        }
        if (z) {
            C1323<DefaultConfig> r5 = f3269;
            r5.f3785 = defaultConfig;
            r5.f3791 = true;
            outline.m2551((C1323) r5, (Object) defaultConfig);
            return;
        }
        T defaultConfig2 = new DefaultConfig();
        defaultConfig2.version = defaultConfig.version;
        defaultConfig2.type = defaultConfig.type;
        defaultConfig2.configData = f3269.mo9612().configData;
        if (defaultConfig2.configData == null) {
            defaultConfig2.configData = new HashMap<>();
        }
        HashMap<String, AppConfig> hashMap = defaultConfig.configData;
        if (hashMap != null) {
            defaultConfig2.configData.putAll(hashMap);
        }
        C1323<DefaultConfig> r4 = f3269;
        r4.f3785 = defaultConfig2;
        r4.f3791 = true;
        outline.m2551((C1323) r4, (Object) defaultConfig2);
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m3081(boolean z) {
        if (z) {
            TaskManager.m2715((Runnable) C1241.f3527);
        }
    }

    /* renamed from: ހ */
    public static int m3082() {
        Integer num = f3273;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Utils.m1857(C1063.m2859("skad_cslmt", (String) null), 2));
        f3273 = valueOf;
        return valueOf.intValue();
    }

    @NonNull
    /* renamed from: ށ */
    public static DefaultConfig m3083() {
        DefaultConfig r0 = f3269.mo9612();
        if (r0 == null) {
            r0 = new DefaultConfig();
        }
        if (r0.configData == null) {
            HashMap<String, AppConfig> hashMap = new HashMap<>();
            r0.version = 0;
            r0.configData = hashMap;
        }
        return r0;
    }

    /* renamed from: ނ */
    public static FullRule m3084() {
        FullRule r0 = f3271;
        if (r0 != null) {
            return r0;
        }
        try {
            r0 = (FullRule) GsonUtil.m2740(C1063.m2859("skad_full_rule", (String) null), FullRule.class);
        } catch (Exception e) {
            e.getMessage();
        }
        if (r0 == null) {
            r0 = new FullRule();
            r0.f2071 = 10;
            r0.f2073 = 36000000;
            r0.f2072 = 1;
        }
        f3271 = r0;
        outline.m2552("init FullRule: ", (Object) r0);
        return r0;
    }

    /* renamed from: ރ */
    public static long m3085() {
        return WPengServer.m1070();
    }

    /* renamed from: ބ */
    public static int m3086() {
        Integer num = f3274;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Utils.m1857(C1063.m2859("skad_tx_len", (String) null), 10));
        f3274 = valueOf;
        return valueOf.intValue();
    }

    /* renamed from: ޅ */
    public static void m3087() {
        DefaultConfig r0 = m3083();
        HashMap<String, AppConfig> hashMap = new HashMap<>();
        for (String put : m3075(true)) {
            AppConfig r5 = new AppConfig();
            r5.f3016 = true;
            r5.f3018 = true;
            hashMap.put(put, r5);
        }
        r0.configData = hashMap;
        r0.version = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        m3076(r0, true);
    }

    /* renamed from: ކ */
    public static void m3088() {
        C1323<DefaultConfig> r0 = f3269;
        OnFileChangeListener r1 = f3275;
        r0.f3792.put(r1, r1);
        C1323<DefaultConfig> r02 = f3269;
        r02.getClass();
        TaskManager.m2720(new C0715(r02));
        C1063.C1065 r03 = f3276;
        C1063.f3038.put(r03, r03);
        AppUtils.m1147((Runnable) C0570.f1216, (long) AnalyticsConstants.f108k);
    }

    /* renamed from: އ */
    public static /* synthetic */ void m3089() {
        try {
            String[] list = new File(AppUtils.getApplication().getApplicationInfo().nativeLibraryDir).list();
            if (list != null) {
                String str = new String(Base64.decode(C0678.f1768, 0), "UTF-8");
                String str2 = new String(Base64.decode(C0678.f1769, 0), "UTF-8");
                int length = list.length;
                int i = 0;
                while (i < length) {
                    String str3 = list[i];
                    if (!str3.toLowerCase().contains(str)) {
                        if (!str3.toLowerCase().contains(str2)) {
                            i++;
                        }
                    }
                    RemoteSP.m1206(new String(Base64.decode(C0536.f1032, 0), "UTF-8"), (Object) Long.valueOf(System.currentTimeMillis()), false);
                    SpHandler.f1750.mo8105(false);
                    C0536.m1311("1");
                    C1219.m3283();
                    SystemUtils.m3527(C1279.m3439());
                    return;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ވ */
    public static /* synthetic */ void m3090() {
        try {
            C0909.m2388();
            TheApplication.m343();
        } catch (Exception unused) {
        }
    }

    /* renamed from: މ */
    public static boolean m3091() {
        return Boolean.parseBoolean(C1063.m2859("skad_ask_all_page", Boolean.TRUE.toString()));
    }

    /* renamed from: ފ */
    public static void m3092() {
        SpHandler.f1757.mo8105(Long.valueOf(WPengServer.m1070()));
    }

    /* renamed from: ދ */
    public static boolean m3093() {
        return WPengServer.m1070() - SpHandler.f1757.mo8104().longValue() > 2592000000L;
    }

    /* renamed from: ؠ */
    public static float m3080() {
        Float f = f3272;
        if (f != null) {
            return f.floatValue();
        }
        String r0 = C1063.m2859("skad_arelmt", (String) null);
        float f2 = 1.0f;
        if (!TextUtils.isEmpty(r0)) {
            try {
                f2 = Float.parseFloat(r0);
            } catch (NumberFormatException unused) {
            }
        }
        Float valueOf = Float.valueOf(f2);
        f3272 = valueOf;
        return valueOf.floatValue();
    }

    /* renamed from: ֏ */
    public static void m3077(RetCallback<DefaultConfig> r2) {
        new DefaultConfigManager(Api.f1342, r2).mo8757(true);
    }

    /* renamed from: ֏ */
    public static Set<String> m3075(boolean z) {
        List<PackageInfo> r0 = SystemUtils.m3525();
        HashSet hashSet = new HashSet();
        if (CollectionUtils.m1657((Collection) r0)) {
            return hashSet;
        }
        DefaultConfig r2 = m3083();
        boolean z2 = z || CollectionUtils.m1658((Map) r2.configData);
        for (PackageInfo next : r0) {
            if (next != null) {
                String str = next.packageName;
                if (!TextUtils.isEmpty(str) && (z2 || !r2.configData.containsKey(str))) {
                    hashSet.add(str);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m3078(Set set, boolean z, RetCallback r11) {
        HashMap hashMap = new HashMap();
        if (CollectionUtils.m1659((Collection) set)) {
            hashMap.put("localVersion", String.valueOf(m3083().version));
            hashMap.put("pkgList", TextUtils.join(",", set));
        }
        UserInfo r0 = C0536.m1309();
        if (r0 != null) {
            hashMap.put("app_uid", String.valueOf(r0.f2110));
        }
        hashMap.put("app_uid2", C0536.m1313(r0) ? "134" : "799");
        new C1155("POST", Api.f1341, hashMap, (String) null, r11, set, z).mo8757(true);
    }

    /* renamed from: ֏ */
    public static boolean m3079() {
        return Boolean.TRUE.toString().equals(C1063.m2859("skad_ctrcd", "false"));
    }
}
