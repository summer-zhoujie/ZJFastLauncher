package com.wpengapp.support;

import android.support.p000v4.app.NotificationCompat;
import java.util.HashMap;

/* renamed from: com.wpengapp.support.е */
/* compiled from: UserManager */
class C0700 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Exception f1810;

    public C0700(Exception exc) {
        this.f1810 = exc;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_ERROR, this.f1810.toString());
        StatisticsManager.m733(NotificationCompat.CATEGORY_ERROR, "get_lid", hashMap);
    }
}
