package com.wpengapp.support;

import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ŭ */
/* compiled from: UMCCAggregatedManager */
public class C0495 extends Callback {

    /* renamed from: a */
    public final /* synthetic */ C1315 f882a;

    public C0495(C1315 r1) {
        this.f882a = r1;
    }

    /* renamed from: a */
    public void mo7310a(Object obj, boolean z) {
        if (obj.equals("success")) {
            C1315 r3 = this.f882a;
            for (Map.Entry<List<String>, UMCCAggregatedObject> key : r3.f3759.f912.entrySet()) {
                List list = (List) key.getKey();
                if (!r3.f3765.contains(list)) {
                    r3.f3765.add(Utils.m1869((List<String>) list));
                }
            }
            if (r3.f3765.size() > 0) {
                r3.f3760.mo8033(new Callback(), r3.f3765);
            }
        }
    }
}
