package com.wpengapp.support;

import com.wpengapp.support.licensing.model.FindContactDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.ݿ */
/* compiled from: UserRecoveryManager */
public final class C0944 extends HttpGsonRequest<FindContactDto> {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f2578;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0944(String str, Map map, RetCallback r3) {
        super(str, map);
        this.f2578 = r3;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<FindContactDto> r2, ErrorCode r3) {
        T t;
        if (!r3.mo8157() || (t = r2.f3518) == null) {
            this.f2578.mo7932(r3.f1083);
        } else {
            this.f2578.mo7931(t);
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        exc.getMessage();
        this.f2578.mo7932(AppUtils.m1141(R$string.pw_network_error, new Object[0]));
    }
}
