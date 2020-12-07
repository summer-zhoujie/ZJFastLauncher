package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ƒ */
/* compiled from: StatisticsManager */
class C0510 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ C1298 f926;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0510(C1298 r1, String str, String str2, Map map, String str3) {
        super(str, str2, map, str3);
        this.f926 = r1;
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        StatisticsManager.f586 = 10800000;
        StatisticsManager.f582.addAll(this.f926.f3697);
        StatisticsManager.f588 = true;
        AppUtils.m1152(StatisticsManager.f590);
        AppUtils.m1147(StatisticsManager.f590, StatisticsManager.f586);
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r3, ErrorCode r4) {
        if (r4.mo8156()) {
            StatisticsManager.f586 = 10800000;
            StatisticsManager.f582.addAll(this.f926.f3697);
            StatisticsManager.f588 = true;
            AppUtils.m1152(StatisticsManager.f590);
            AppUtils.m1147(StatisticsManager.f590, StatisticsManager.f586);
            return;
        }
        StatisticsManager.f586 = StatisticsManager.f587;
        StatisticsManager.f583 = System.currentTimeMillis();
        StatisticsManager.f588 = true;
        StatisticsManager.m732();
        AppUtils.m1152(StatisticsManager.f590);
        AppUtils.m1147(StatisticsManager.f590, StatisticsManager.f586);
    }
}
