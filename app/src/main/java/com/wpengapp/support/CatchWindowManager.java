package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ň */
class CatchWindowManager extends RemoteMethod {
    public CatchWindowManager(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (bundle.getBoolean("itd")) {
            C0488.m1087();
            return null;
        }
        TaskManager.m2720(new C0750(bundle));
        return null;
    }
}
