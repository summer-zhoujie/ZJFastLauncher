package com.wpengapp.support;

import android.os.Looper;

/* renamed from: com.wpengapp.support.չ */
public class SafeHandlerThread implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1076 f2092;

    public SafeHandlerThread(C1076 r1) {
        this.f2092 = r1;
    }

    public void run() {
        while (true) {
            try {
                Looper.loop();
                return;
            } catch (Exception e) {
                this.f2092.mo9251(e);
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
