package com.wpengapp.support;

import android.os.Process;

/* renamed from: com.wpengapp.support.ջ */
/* compiled from: AppUtils */
public final class C0809 extends Thread {
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException unused) {
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
