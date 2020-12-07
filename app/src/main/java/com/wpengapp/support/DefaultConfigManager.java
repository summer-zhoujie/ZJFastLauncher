package com.wpengapp.support;

import java.util.Collection;
import java.util.Set;

/* renamed from: com.wpengapp.support.ǰ */
class DefaultConfigManager extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ RetCallback f1000;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultConfigManager(String str, RetCallback r2) {
        super(str);
        this.f1000 = r2;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r2, ErrorCode r3) {
        T t;
        if (r3.mo8156() || (t = r2.f3518) == null) {
            RetCallback r22 = this.f1000;
            if (r22 != null) {
                r22.mo7932((String) null);
                return;
            }
            return;
        }
        int r23 = Utils.m1857((String) t, -1);
        if (r23 == -1 || r23 >= C1149.m3083().version) {
            boolean z = r23 != C1149.m3083().version;
            Set<String> r32 = C1149.m3075(z);
            if (CollectionUtils.m1657((Collection) r32)) {
                RetCallback r24 = this.f1000;
                if (r24 != null) {
                    r24.mo7931(C1149.m3083());
                }
                C1149.m3092();
                return;
            }
            C1149.m3078(r32, z, this.f1000);
            return;
        }
        C1149.m3092();
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        RetCallback r0 = this.f1000;
        if (r0 == null) {
            return;
        }
        if (exc instanceof MaintainException) {
            r0.mo7932(ErrorCode.MAINTAIN.f1083);
        } else {
            r0.mo7932((String) null);
        }
    }
}
