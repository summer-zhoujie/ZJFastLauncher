package com.umeng.analytics;

/* renamed from: com.umeng.analytics.g */
public abstract class SafeRunnable implements Runnable {
    /* renamed from: a */
    public abstract void mo7309a();

    public void run() {
        try {
            mo7309a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
