package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ۅ */
/* compiled from: UserRecoveryManager */
public final class C0905 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f2428;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0905(String str, String str2, Map map, String str3, RetCallback r5) {
        super(str, str2, map, str3);
        this.f2428 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r2, ErrorCode r3) {
        if (!r3.mo8157()) {
            StringBuilder r22 = outline.m2549("confirmRecovery error: ");
            r22.append(r3.f1083);
            r22.toString();
            this.f2428.mo7932(r3.f1083);
            return;
        }
        this.f2428.mo7931(null);
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        StringBuilder r0 = outline.m2549("confirmRecovery error: ");
        r0.append(exc.getMessage());
        r0.toString();
        this.f2428.mo7932(AppUtils.m1141(R$string.pw_network_error, new Object[0]));
    }
}
