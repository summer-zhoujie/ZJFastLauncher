package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ƫ */
public final class AccTaskManager implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ AccTask f948;

    public AccTaskManager(AccTask r1) {
        this.f948 = r1;
    }

    public void run() {
        if (!this.f948.mo8878()) {
            this.f948.mo8876();
            C0840.f2225.postDelayed(this, 300);
        }
    }
}
