package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ҍ */
/* compiled from: CheckDeviceManager */
public final class C0725 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f1881;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0725(String str, String str2, Map map, String str3, RetCallback r5) {
        super(str, str2, map, str3);
        this.f1881 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r2, ErrorCode r3) {
        if (!r3.mo8157()) {
            StringBuilder r22 = outline.m2549("transferOldUser error: ");
            r22.append(r3.f1083);
            r22.toString();
            this.f1881.mo7932(r3.f1083);
            return;
        }
        C1307.m3565();
        this.f1881.mo7931(true);
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        StringBuilder r0 = outline.m2549("transferOldUser error: ");
        r0.append(exc.getMessage());
        r0.toString();
        this.f1881.mo7932(exc.getMessage());
    }
}
