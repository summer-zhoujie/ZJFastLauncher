package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ຯ */
/* compiled from: MiadManager */
class C1232 extends RemoteMethod {
    public C1232(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        MiadManager.m2210(bundle.getBoolean("enable"));
        return null;
    }
}
