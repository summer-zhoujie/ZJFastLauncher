package com.wpengapp.support;

import com.wpengapp.support.StatisticsManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.wpengapp.support.ঠ */
/* compiled from: StatisticsManager */
class C1055 implements Runnable {
    public void run() {
        if (!StatisticsManager.f584) {
            List<StatisticsManager.EventModel> list = StatisticsManager.f582;
            if (CollectionUtils.m1657((Collection) list) || !NetworkUtils.m1800()) {
                AppUtils.m1152(StatisticsManager.f590);
                AppUtils.m1147(StatisticsManager.f590, StatisticsManager.f586);
                return;
            }
            StringBuilder r1 = outline.m2549("Request Report, event count ");
            r1.append(list.size());
            r1.toString();
            StatisticsManager.f582 = new CopyOnWriteArrayList();
            TaskManager.m2715((Runnable) new C1298(list));
        }
    }
}
