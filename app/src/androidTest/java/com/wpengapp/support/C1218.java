package com.wpengapp.support;

import com.wpengapp.support.UpdateHelper;

/* renamed from: com.wpengapp.support.ນ */
/* compiled from: UpdateHelper */
class C1218 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ UpdateHelper.NotificationClickService f3476;

    public C1218(UpdateHelper.NotificationClickService notificationClickService) {
        this.f3476 = notificationClickService;
    }

    public void run() {
        this.f3476.stopSelf();
    }
}
