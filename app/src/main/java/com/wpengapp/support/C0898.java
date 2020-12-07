package com.wpengapp.support;

import com.wpengapp.support.licensing.activity.QrPayActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ں */
/* compiled from: QrPayActivity */
class C0898 implements QrPayActivity.C0454 {

    /* renamed from: ֏ */
    public final /* synthetic */ AtomicInteger f2419;

    /* renamed from: ؠ */
    public final /* synthetic */ QrPayActivity.C0454 f2420;

    public C0898(AtomicInteger atomicInteger, QrPayActivity.C0454 r2) {
        this.f2419 = atomicInteger;
        this.f2420 = r2;
    }

    /* renamed from: ֏ */
    public void mo7862(boolean z, String str) {
        ObjectCache.m1663(this.f2419.get());
        QrPayActivity.C0454 r0 = this.f2420;
        if (r0 != null) {
            r0.mo7862(z, str);
        }
    }
}
