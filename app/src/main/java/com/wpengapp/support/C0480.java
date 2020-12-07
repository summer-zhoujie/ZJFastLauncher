package com.wpengapp.support;

import com.wpengapp.support.C1063;
import java.util.Map;

/* renamed from: com.wpengapp.support.ŉ */
/* compiled from: ConfigManager */
class C0480 extends HttpGsonRequest<Map<String, String>> {

    /* renamed from: ދ */
    public final /* synthetic */ C1063.C1064 f824;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0480(String str, Map map, String str2, C1063.C1064 r4) {
        super(str, map, str2);
        this.f824 = r4;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<Map<String, String>> r2, ErrorCode r3) {
        if (r3.mo8157() && r2.f3518 != null) {
            C1063.f3040.clear();
            C1063.f3040.putAll((Map) r2.f3518);
            C1063.f3039.mo9611(r2.f3519);
            C1063.f3039.mo9609();
            C1063.C1064 r32 = this.f824;
            if (r32 == null) {
                C1063.m2862((Map) C1063.f3040);
                return;
            }
            r32.mo9129((Map) r2.f3518, false);
            C1063.m2862((Map) C1063.f3040);
        } else if (this.f824 != null) {
            Map<String, String> r22 = C1063.m2860();
            if (r22 != null) {
                this.f824.mo9129(r22, true);
            } else {
                this.f824.mo9128();
            }
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C1063.C1064 r1 = this.f824;
        if (r1 != null) {
            r1.mo9128();
        }
    }
}
