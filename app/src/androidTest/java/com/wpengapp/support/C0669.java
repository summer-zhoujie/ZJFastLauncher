package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ϩ */
/* compiled from: StatisticsManager */
public final class C0669 implements Runnable {

    /* renamed from: ֏ */
    public Runnable f1731 = this;

    /* renamed from: ؠ */
    public final /* synthetic */ long f1732;

    public C0669(long j) {
        this.f1732 = j;
    }

    public void run() {
        if (!StatisticsManager.f584) {
            StatisticsManager.m732();
            AppUtils.m1147(this.f1731, this.f1732);
        }
    }
}
