package com.wpengapp.support;

import android.support.p000v4.util.ArrayMap;
import com.wpengapp.support.AutoLoginConfig;

/* renamed from: com.wpengapp.support.ণ */
/* compiled from: AutoLoginManager */
public class C1057 {

    /* renamed from: ֏ */
    public static final C1323<AutoLoginConfig> f3020 = C1323.m3615("alcfg", new AutoLoginManager().getType(), (String) null, "alcfg345");

    /* renamed from: ֏ */
    public static boolean m2854(String str) {
        ArrayMap<String, AutoLoginConfig.C1256> arrayMap;
        AutoLoginConfig.C1256 r2;
        AutoLoginConfig r0 = f3020.mo9612();
        if (r0 == null || (arrayMap = r0.f3551) == null || (r2 = arrayMap.get(str)) == null) {
            return false;
        }
        return r2.f3554;
    }

    /* renamed from: ֏ */
    public static boolean m2853() {
        AutoLoginConfig r0 = f3020.mo9612();
        if (r0 == null) {
            return false;
        }
        return r0.f3552;
    }

    /* renamed from: ֏ */
    public static void m2852(AutoLoginConfig r2) {
        C1323<AutoLoginConfig> r0 = f3020;
        r0.f3785 = r2;
        r0.f3791 = true;
        outline.m2551((C1323) r0, (Object) r2);
    }
}
