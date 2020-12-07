package com.wpengapp.support;

import android.content.Intent;
import android.support.p003v7.widget.TooltipCompatHandler;

/* renamed from: com.wpengapp.support.થ */
/* compiled from: SystemApi */
class C1108 extends Thread {
    public C1108(C0880 r1) {
    }

    public void run() {
        boolean z = false;
        for (int i = 0; i < 3 && !(z = SystemApi.m2048()); i++) {
            try {
                Thread.sleep(TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
            } catch (InterruptedException unused) {
            }
        }
        SystemApi.f1981.mo7965(z);
        Intent intent = SystemApi.f1985;
        if (intent != null) {
            SystemApi.m2045(SystemApi.f1984, intent);
        }
    }
}
