package com.wpengapp.support;

import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.support.StatisticsManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.wpengapp.support.မ */
/* compiled from: StatisticsManager */
public final class C1290 implements Runnable {
    public void run() {
        if (StatisticsManager.f588) {
            List<StatisticsManager.EventModel> list = StatisticsManager.f582;
            StatisticsManager.f582 = new CopyOnWriteArrayList();
            long r1 = WPengServer.m1070();
            for (StatisticsManager.EventModel next : list) {
                if (r1 - next.time < AnalyticsConstants.f107j) {
                    StatisticsManager.f582.add(next);
                }
            }
            StatisticsManager.C0446 r0 = new StatisticsManager.C0446((C1099) null);
            r0.f592 = StatisticsManager.f583;
            r0.f593 = StatisticsManager.f582;
            StringBuilder r12 = outline.m2549("saveDiskCache...");
            r12.append(StatisticsManager.f582.size());
            r12.toString();
            StatisticsManager.f581.mo9611(GsonUtil.m2742(r0));
            StatisticsManager.f581.mo9609();
            StatisticsManager.f588 = false;
        }
    }
}
