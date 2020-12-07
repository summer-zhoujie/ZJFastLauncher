package com.wpengapp.support;

import com.wpengapp.support.licensing.model.TryRecoveryDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.ڵ */
/* compiled from: UserRecoveryManager */
public final class C0895 extends HttpGsonRequest<TryRecoveryDto> {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f2417;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0895(String str, String str2, Map map, String str3, RetCallback r5) {
        super(str, str2, map, str3);
        this.f2417 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<TryRecoveryDto> r2, ErrorCode r3) {
        T t;
        if (!r3.mo8157() || (t = r2.f3518) == null) {
            StringBuilder r22 = outline.m2549("tryRecovery error: ");
            r22.append(r3.f1083);
            r22.toString();
            this.f2417.mo7932(r3.f1083);
            return;
        }
        this.f2417.mo7931(t);
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        StringBuilder r0 = outline.m2549("tryRecovery error: ");
        r0.append(exc.getMessage());
        r0.toString();
        this.f2417.mo7932(AppUtils.m1141(R$string.pw_network_error, new Object[0]));
    }
}
