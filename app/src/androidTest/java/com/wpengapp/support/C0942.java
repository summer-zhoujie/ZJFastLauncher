package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ݹ */
/* compiled from: CustomManager */
class C0942 extends RemoteMethod {
    public C0942(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("TAG");
        if ("showCustomFloat".equals(string)) {
            return RemoteMethod.m1957(C1032.m2770());
        }
        if ("dismissCustomFloat".equals(string)) {
            C1032.m2756();
            return null;
        } else if ("isShowingCustomFloat".equals(string)) {
            return RemoteMethod.m1957(C1032.m2761());
        } else {
            if ("needRequestMediaProjection".equals(string)) {
                return RemoteMethod.m1957(C1032.m2769());
            }
            return null;
        }
    }
}
