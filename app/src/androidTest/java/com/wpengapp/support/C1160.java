package com.wpengapp.support;

import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.support.C1063;
import java.util.Map;

/* renamed from: com.wpengapp.support.ఽ */
/* compiled from: ConfigManager */
class C1160 implements C1063.C1064 {

    /* renamed from: ֏ */
    public final /* synthetic */ C1171 f3299;

    public C1160(C1171 r1) {
        this.f3299 = r1;
    }

    /* renamed from: ֏ */
    public void mo9129(Map<String, String> map, boolean z) {
        AppUtils.m1147(this.f3299.f3339, (long) AnalyticsConstants.f107j);
        this.f3299.f3340 = 1800000;
    }

    /* renamed from: ֏ */
    public void mo9128() {
        C1171 r0 = this.f3299;
        AppUtils.m1147(r0.f3339, r0.f3340);
        C1171 r02 = this.f3299;
        r02.f3340 += 1800000;
        if (r02.f3340 > AnalyticsConstants.f107j) {
            r02.f3340 = AnalyticsConstants.f107j;
        }
    }
}
