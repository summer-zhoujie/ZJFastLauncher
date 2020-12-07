package com.wpengapp.support;

import android.os.Handler;
import android.os.SystemClock;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.؋ */
/* compiled from: LocalTimeChecker */
public class C0833 {

    /* renamed from: ֏ */
    public static final WeakHashMap<C0834, Object> f2173 = new WeakHashMap<>();

    /* renamed from: ؠ */
    public static final Handler f2174 = AppUtils.m1171();

    /* renamed from: ހ */
    public static boolean f2175;

    /* renamed from: ށ */
    public static long f2176;

    /* renamed from: ނ */
    public static long f2177;

    /* renamed from: com.wpengapp.support.؋$֏ */
    /* compiled from: LocalTimeChecker */
    public interface C0834 {
    }

    /* renamed from: ֏ */
    public static void m2217(C0834 r4) {
        f2173.put(r4, C0833.class);
        if (!f2175) {
            f2175 = true;
            f2176 = System.currentTimeMillis();
            f2177 = SystemClock.elapsedRealtime();
            f2174.postDelayed(new C0906(), 1800000);
            if (f2176 < RemoteSP.m1201("S7em18373", 0)) {
                AppUtils.m1146((Runnable) new LocalTimeChecker());
            }
        }
    }

    /* renamed from: ؠ */
    public static void m2218() {
        for (Map.Entry<C0834, Object> key : f2173.entrySet()) {
            C0834 r1 = (C0834) key.getKey();
            if (r1 != null) {
                C0676 r12 = (C0676) r1;
                C0536.m1324();
                RemoteSP.m1206("spstnca1l1", (Object) true, false);
                C0536.m1306(true, (SyncUserInfoListener) null);
            }
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2216() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        long j = elapsedRealtime - f2177;
        long j2 = currentTimeMillis - f2176;
        f2177 = elapsedRealtime;
        f2176 = currentTimeMillis;
        if (j < 0 || j2 < 0) {
            m2218();
        } else if (Math.abs(j2 - j) > 5000) {
            m2218();
        } else if (j2 < 1800000 || j < 1800000) {
            m2218();
        }
        RemoteSP.m1206("S7em18373", (Object) Long.valueOf(currentTimeMillis), false);
    }
}
