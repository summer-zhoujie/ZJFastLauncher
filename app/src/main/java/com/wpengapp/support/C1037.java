package com.wpengapp.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.स */
/* compiled from: UMCCAggregatedManager */
class C1037 extends Callback {

    /* renamed from: a */
    public final /* synthetic */ C0812 f2971a;

    public C1037(C0812 r1) {
        this.f2971a = r1;
    }

    /* renamed from: a */
    public void mo7310a(Object obj, boolean z) {
        if (obj instanceof Map) {
            Map<List<String>, UMCCAggregatedObject> map = (Map) obj;
            UMCCAggregatedListObject r11 = this.f2971a.f2098.f3759;
            if (r11.f912.size() <= 0) {
                r11.f912 = map;
            } else {
                new ArrayList();
                new ArrayList();
                Iterator<Map.Entry<List<String>, UMCCAggregatedObject>> it = r11.f912.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    List list = (List) next.getKey();
                    Iterator<Map.Entry<List<String>, UMCCAggregatedObject>> it2 = r11.f912.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next2 = it2.next();
                        List list2 = (List) next.getKey();
                        if (!list.equals(list2)) {
                            r11.f912.put(list2, next2.getValue());
                        } else {
                            UMCCAggregatedObject r4 = (UMCCAggregatedObject) next.getValue();
                            UMCCAggregatedObject r3 = (UMCCAggregatedObject) next2.getValue();
                            r3.f3182 += r4.f3182;
                            r3.f3181 += r4.f3181;
                            r3.f3180 += r4.f3180;
                            for (int i = 0; i < r4.f3179.size(); i++) {
                                r3.mo9304(r4.f3179.get(i));
                            }
                            r11.f912.remove(list);
                            r11.f912.put(list, r3);
                        }
                    }
                }
            }
        } else if (!(obj instanceof String)) {
            boolean z2 = obj instanceof Boolean;
        }
        this.f2971a.f2098.f3762 = true;
    }
}
