package com.wpengapp.support;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.wpengapp.lightstart.R$drawable;
import com.wpengapp.lightstart.activity.MoreSettingsActivity;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.lightstart.service.AccService24;
import com.wpengapp.support.accservice.BaseAccessibilityService;

/* renamed from: com.wpengapp.support.ཧ */
/* compiled from: StatusNotificationManager */
public class C1273 {

    /* renamed from: ֏ */
    public static final RemoteMethod f3578 = new StatusNotificationManager("SNMENB");

    /* renamed from: ֏ */
    public static void m3360() {
        if (C1146.m3072()) {
            f3578.mo8565();
        }
    }

    /* renamed from: ֏ */
    public static void m3362(boolean z) {
        if (!C1146.m3072()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z);
            C1146.m3071(f3578.f1927, bundle, (RemoteCallback) null);
            return;
        }
        BaseAccessibilityService baseAccessibilityService = BaseAccessibilityService.f600;
        if (baseAccessibilityService != null) {
            if (z) {
                try {
                    if (AccServiceHelper.m2016(AccService.class, AccService24.class)) {
                        m3361((Service) baseAccessibilityService);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            } else {
                baseAccessibilityService.stopForeground(true);
            }
        }
    }

    /* renamed from: ֏ */
    public static void m3361(Service service) {
        ForegroundServiceHelper.m728(service, R$drawable.ic_tile, AppUtils.m1141(2131493191, new Object[0]), PendingIntent.getActivity(AppUtils.getApplication(), 200, new Intent(service, MoreSettingsActivity.class), 268435456));
    }
}
