package com.wpengapp.support;

import com.umeng.analytics.SafeRunnable;
import com.wpengapp.support.C1315;
import java.util.Map;

/* renamed from: com.wpengapp.support.ড় */
/* compiled from: EventTracker */
class C1075 extends SafeRunnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Map f3051;

    /* renamed from: ؠ */
    public final /* synthetic */ C1174 f3052;

    public C1075(C1174 r1, Map map) {
        this.f3052 = r1;
        this.f3051 = map;
    }

    /* renamed from: a */
    public void mo7309a() {
        C1315.f3758 = this.f3052.f3342;
        C1315.C1317.f3769.mo9585(new EventTracker(this), this.f3051);
    }
}
