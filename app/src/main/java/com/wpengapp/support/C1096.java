package com.wpengapp.support;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* renamed from: com.wpengapp.support.ઉ */
/* compiled from: CrashHandler */
public class C1096 implements Thread.UncaughtExceptionHandler {

    /* renamed from: ֏ */
    public Thread.UncaughtExceptionHandler f3117;

    /* renamed from: ؠ */
    public OnAppCrashHandler f3118;

    public C1096() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.f3117 = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f3118.mo7293a(th);
        } else {
            this.f3118.mo7293a((Throwable) null);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3117;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != Thread.getDefaultUncaughtExceptionHandler()) {
            this.f3117.uncaughtException(thread, th);
        }
    }
}
