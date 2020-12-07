package com.wpengapp.support;

import com.wpengapp.support.DailyRecords;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ཞ */
/* compiled from: DailyRecordManager */
public class C1266 {

    /* renamed from: ֏ */
    public static final C1323<DailyRecords> f3566 = C1323.m3613("dyrcs", new DailyRecordManager().getType());

    /* renamed from: ֏ */
    public static boolean m3357(CustomPageConfig r6) {
        DailyRecords r0;
        DailyRecords.C1006 r2;
        Integer num = r6.f2109;
        if (num == null || num.intValue() == 0 || (r0 = f3566.mo9612()) == null || CollectionUtils.m1658((Map) r0.f2891) || (r2 = r0.f2891.get(r6.f2105)) == null || r2.f2892 < r6.f2109.intValue() || r0.f2890 != DateUtils.m2701().getTime()) {
            return false;
        }
        return true;
    }

    /* renamed from: ؠ */
    public static void m3358(CustomPageConfig r6) {
        Integer num = r6.f2109;
        if (num != null && num.intValue() != 0) {
            T t = (DailyRecords) f3566.mo9612();
            long time = DateUtils.m2701().getTime();
            if (t == null) {
                t = new DailyRecords();
                t.f2890 = time;
                t.f2891 = new HashMap();
            }
            if (t.f2890 != time) {
                t.f2890 = time;
                t.f2891 = new HashMap();
            }
            DailyRecords.C1006 r1 = t.f2891.get(r6.f2105);
            if (r1 == null) {
                r1 = new DailyRecords.C1006();
                t.f2891.put(r6.f2105, r1);
            }
            r1.f2892++;
            C1323<DailyRecords> r62 = f3566;
            r62.f3785 = t;
            r62.f3791 = true;
            outline.m2551((C1323) r62, (Object) t);
        }
    }
}
