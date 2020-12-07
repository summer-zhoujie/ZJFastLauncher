package com.wpengapp.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ƌ */
public class UMCCAggregatedListObject implements Serializable {

    /* renamed from: ֏ */
    public Map<List<String>, UMCCAggregatedObject> f912 = new HashMap();

    /* renamed from: ֏ */
    public void mo8057(Callback r8, UMCCVerbatimObject r9) {
        try {
            List<String> list = r9.f1673;
            Map<List<String>, UMCCAggregatedObject> map = this.f912;
            if (map != null && map.containsKey(list)) {
                UMCCAggregatedObject r0 = this.f912.get(r9.f1673);
                if (r0 != null) {
                    C1058 r1 = new C1058(this, r8);
                    r0.mo9304(r9.f1674);
                    r0.f3182++;
                    r0.f3181 = r9.f1675 + r0.f3181;
                    r0.f3180 += r9.f1676;
                    r1.mo7310a(r0, false);
                    return;
                }
                mo8060(r8, r9.f1673, r9);
                return;
            }
            mo8060(r8, r9.f1673, r9);
        } catch (Exception unused) {
            MLog.m1776("aggregated faild!");
        }
    }

    /* renamed from: ֏ */
    public void mo8060(Callback r4, List<String> list, UMCCVerbatimObject r6) {
        UMCCAggregatedObject r0 = new UMCCAggregatedObject();
        r0.f3182 = 1;
        r0.f3178 = r6.f1673;
        r0.mo9304(r6.mo8402());
        r0.f3181 = r6.mo8403();
        r0.f3180 = System.currentTimeMillis();
        r0.f3183 = Utils.m1865(System.currentTimeMillis());
        this.f912.put(list, r0);
        r4.mo7310a(this, false);
    }

    /* renamed from: ֏ */
    public final void mo8058(Callback r2, UMCCVerbatimObject r3, List<String> list) {
        Map<List<String>, UMCCAggregatedObject> map = this.f912;
        if (map != null && map.containsKey(list)) {
            mo8057(r2, r3);
        } else {
            mo8060(r2, list, r3);
        }
    }

    /* renamed from: ֏ */
    public boolean mo8061(List<String> list, List<String> list2) {
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() - 1; i++) {
            arrayList.add(Utils.m1871(list.get(i)));
        }
        if (list.size() == 0) {
            return false;
        }
        return arrayList.contains(list2);
    }

    /* renamed from: ֏ */
    public void mo8059(Callback r3, UMCCVerbatimObject r4, List<String> list, List<String> list2) {
        while (list.size() >= 1) {
            try {
                if (list.size() == 1) {
                    if (!mo8061(list2, list)) {
                        r3.mo7310a(false, false);
                        return;
                    } else {
                        mo8058(r3, r4, list);
                        return;
                    }
                } else if (mo8061(list2, list)) {
                    mo8058(r3, r4, list);
                    return;
                } else {
                    list.remove(list.size() - 1);
                }
            } catch (Exception unused) {
                MLog.m1776("overFlowAggregated faild");
                return;
            }
        }
    }
}
