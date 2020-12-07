package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.support.accservice.BaseAccessibilityService;

/* renamed from: com.wpengapp.support.و */
class EngineManager extends RemoteMethod {
    public EngineManager(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m2281() {
        boolean r0 = C0919.m2424();
        AccService accService = (AccService) BaseAccessibilityService.f600;
        if (accService != null) {
            accService.mo7723(2, r0);
        }
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("TAG");
        if ("stsc".equals(string)) {
            AccService accService = AccService.f500;
            if (accService != null) {
                AccServiceHelper.m2013((AccessibilityService) accService);
            }
            AccService accService2 = AccService.f501;
            if (accService2 != null) {
                AccServiceHelper.m2013((AccessibilityService) accService2);
            }
        } else if ("htshnl".equals(string)) {
            AccService accService3 = (AccService) BaseAccessibilityService.f600;
            if (accService3 != null) {
                accService3.mo7723(0, false);
            }
        } else if ("htshxp".equals(string)) {
            TaskManager.m2715((Runnable) C0899.f2422);
        }
        return null;
    }
}
