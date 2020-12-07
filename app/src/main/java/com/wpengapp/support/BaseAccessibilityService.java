package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ϓ */
class BaseAccessibilityService extends RemoteMethod {
    public BaseAccessibilityService(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        com.wpengapp.support.accservice.BaseAccessibilityService baseAccessibilityService = com.wpengapp.support.accservice.BaseAccessibilityService.f600;
        Bundle bundle2 = new Bundle();
        if (baseAccessibilityService == null) {
            bundle2.putBoolean("ret", false);
        } else {
            bundle2.putBoolean("ret", baseAccessibilityService.performGlobalAction(3));
        }
        return bundle2;
    }
}
