package com.wpengapp.support;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ۏ */
/* compiled from: CustomConfigManager */
public class C0909 {

    /* renamed from: ֏ */
    public static final C1323<CustomConfig> f2440 = C1323.m3615("cscfg", new CustomConfigManager().getType(), (String) null, "cscfg345");

    /* renamed from: ؠ */
    public static final String f2441 = (DateUtils.m2699(new Date(), "yyMMddHHmmss") + (AppUtils.m1169() ^ true ? 1 : 0));

    /* renamed from: ހ */
    public static final AtomicInteger f2442 = new AtomicInteger();

    /* renamed from: ֏ */
    public static void m2385(CustomConfig r5) {
        if (r5 != null && CollectionUtils.m1660((Map) r5.f1747)) {
            for (Map.Entry next : r5.f1747.entrySet()) {
                if (!CollectionUtils.m1658((Map) ((CustomAppConfig) next.getValue()).f2437)) {
                    for (Map.Entry<String, List<CustomPageConfig>> value : ((CustomAppConfig) next.getValue()).f2437.entrySet()) {
                        for (CustomPageConfig r3 : (List) value.getValue()) {
                            r3.f2105 = m2389();
                        }
                    }
                }
            }
        }
        C1323<CustomConfig> r0 = f2440;
        r0.f3785 = r5;
        r0.f3791 = true;
        outline.m2551((C1323) r0, (Object) r5);
    }

    /* renamed from: ؠ */
    public static void m2388() {
        T r0 = m2390();
        r0.f1747 = new HashMap();
        C1323<CustomConfig> r1 = f2440;
        r1.f3785 = r0;
        r1.f3791 = true;
        outline.m2551((C1323) r1, (Object) r0);
    }

    /* renamed from: ހ */
    public static String m2389() {
        return f2441 + f2442.getAndIncrement();
    }

    /* renamed from: ށ */
    public static CustomConfig m2390() {
        T t = (CustomConfig) f2440.mo9612();
        if (t == null) {
            synchronized (C0909.class) {
                t = (CustomConfig) f2440.mo9612();
                if (t == null) {
                    t = new CustomConfig();
                    t.f1748 = 1;
                    t.f1747 = new HashMap();
                    C1323<CustomConfig> r4 = f2440;
                    r4.f3785 = t;
                    r4.f3791 = true;
                    TaskManager.m2720(new C0761(r4, t));
                }
            }
        }
        Integer num = t.f1748;
        if (num == null || num.intValue() < 1) {
            Integer num2 = t.f1748;
            if ((num2 == null ? 0 : num2.intValue()) == 0 && CollectionUtils.m1660((Map) t.f1747)) {
                for (Map.Entry next : t.f1747.entrySet()) {
                    if (!CollectionUtils.m1658((Map) ((CustomAppConfig) next.getValue()).f2437)) {
                        for (Map.Entry<String, List<CustomPageConfig>> value : ((CustomAppConfig) next.getValue()).f2437.entrySet()) {
                            for (CustomPageConfig r6 : (List) value.getValue()) {
                                r6.f2105 = m2389();
                            }
                        }
                    }
                }
            }
            t.f1748 = 1;
            C1323<CustomConfig> r2 = f2440;
            r2.f3785 = t;
            r2.f3791 = true;
            outline.m2551((C1323) r2, (Object) t);
        }
        return t;
    }

    /* renamed from: ֏ */
    public static void m2386(String str, String str2, CustomPageConfig r6) {
        T r0 = m2390();
        CustomAppConfig r4 = r0.f1747.get(str);
        if (r4 != null && !CollectionUtils.m1658((Map) r4.f2437)) {
            List list = r4.f2437.get(str2);
            if (!CollectionUtils.m1657((Collection) list)) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(r6.f2105, ((CustomPageConfig) list.get(i)).f2105)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    list.set(i, r6);
                    C1323<CustomConfig> r42 = f2440;
                    r42.f3785 = r0;
                    r42.f3791 = true;
                    outline.m2551((C1323) r42, (Object) r0);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static boolean m2387() {
        int i;
        if (CollectionUtils.m1658((Map) m2390().f1747)) {
            i = 0;
        } else {
            i = 0;
            for (Map.Entry next : m2390().f1747.entrySet()) {
                if (!CollectionUtils.m1658((Map) ((CustomAppConfig) next.getValue()).f2437)) {
                    for (Map.Entry<String, List<CustomPageConfig>> value : ((CustomAppConfig) next.getValue()).f2437.entrySet()) {
                        for (CustomPageConfig r5 : (List) value.getValue()) {
                            Boolean bool = r5.f2108;
                            if (bool == null || bool.booleanValue()) {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        if (i < C1149.m3082()) {
            return false;
        }
        return !C0536.m1313(C0536.m1309());
    }
}
