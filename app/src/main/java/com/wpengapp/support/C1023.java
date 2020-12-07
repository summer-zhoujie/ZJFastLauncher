package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ध */
/* compiled from: UserManager */
class C1023 extends HttpSimpleRequestImpl {
    public C1023(C0972 r1, String str, String str2, Map map, String str3) {
        super(str, str2, map, str3);
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r2, ErrorCode r3) {
        if (r3.mo8157()) {
            RemoteSP.m1206("regdi", (Object) C0719.m1820(), false);
        }
    }
}
