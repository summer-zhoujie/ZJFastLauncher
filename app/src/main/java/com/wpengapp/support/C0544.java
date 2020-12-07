package com.wpengapp.support;

import com.wpengapp.support.licensing.model.CheckDeviceDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.ȝ */
/* compiled from: CheckDeviceManager */
class C0544 extends HttpGsonRequest<CheckDeviceDto> {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f1089;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0544(String str, String str2, Map map, String str3, RetCallback r5) {
        super(str, str2, map, str3);
        this.f1089 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<CheckDeviceDto> r2, ErrorCode r3) {
        if (!r3.mo8157() || r2.f3518 == null) {
            StringBuilder r22 = outline.m2549("checkDevice error: ");
            r22.append(r3.f1083);
            r22.toString();
            if (r3 == ErrorCode.USER_ALREADY_PAID) {
                C1307.m3565();
            }
            this.f1089.mo7932(r3.f1083);
            return;
        }
        StringBuilder r32 = outline.m2549("checkDevice needTransfer: ");
        r32.append(((CheckDeviceDto) r2.f3518).needTransfer);
        r32.toString();
        T t = r2.f3518;
        if (!((CheckDeviceDto) t).needTransfer && !((CheckDeviceDto) t).deviceHasPaid) {
            C1307.m3565();
        }
        this.f1089.mo7931(r2.f3518);
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        StringBuilder r0 = outline.m2549("checkDevice error: ");
        r0.append(exc.getMessage());
        r0.toString();
        this.f1089.mo7932(exc.getMessage());
    }
}
