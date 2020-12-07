package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࠋ */
/* compiled from: AccTaskManager */
class C0990 implements TaskCallback {

    /* renamed from: ֏ */
    public boolean f2778 = true;

    /* renamed from: ؠ */
    public final /* synthetic */ AccTask f2779;

    public C0990(C0782 r1, AccTask r2) {
        this.f2779 = r2;
    }

    public void error() {
        if (this.f2778) {
            this.f2778 = false;
            C0840.f2225.postDelayed(new C1255(this, this), 200);
            return;
        }
        this.f2779.mo8877();
        C0840.m2248();
    }

    /* renamed from: ֏ */
    public void mo8185() {
        this.f2779.mo8876();
    }
}
