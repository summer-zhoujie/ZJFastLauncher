package com.wpengapp.support;

import android.os.SystemClock;
import com.wpengapp.support.accservice.SafeAccService;

/* renamed from: com.wpengapp.support.Ⴙ */
/* compiled from: SafeAccService */
class C1308 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ SafeAccService f3740;

    public C1308(SafeAccService safeAccService) {
        this.f3740 = safeAccService;
    }

    public void run() {
        while (this.f3740.f607) {
            long r0 = this.f3740.f608;
            if (this.f3740.f612 && r0 > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - r0;
                long r2 = elapsedRealtime - this.f3740.f613;
                if (j > 20000 && r2 > 20000) {
                    SafeAccService.m754(this.f3740);
                }
            }
            try {
                Thread.sleep(8000);
            } catch (InterruptedException unused) {
            }
        }
    }
}
