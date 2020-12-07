package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ݖ */
/* compiled from: ActivityKiller */
class C0928 implements Runnable {
    public void run() {
        if (!AppUtils.m1170()) {
            StringBuilder r0 = outline.m2549("exit app, activity num is ");
            r0.append(AppUtils.m1154().size());
            r0.toString();
            BaseApplication.f561.mo7792();
        }
    }
}
