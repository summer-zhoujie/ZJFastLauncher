package com.wpengapp.support;

import java.util.Set;

/* renamed from: com.wpengapp.support.ၒ */
/* compiled from: lambda */
public final /* synthetic */ class C1294 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ C1155 f3644;

    /* renamed from: ؠ */
    private final /* synthetic */ HttpResponse f3645;

    /* renamed from: ހ */
    private final /* synthetic */ Set f3646;

    /* renamed from: ށ */
    private final /* synthetic */ boolean f3647;

    /* renamed from: ނ */
    private final /* synthetic */ RetCallback f3648;

    public /* synthetic */ C1294(C1155 r1, HttpResponse r2, Set set, boolean z, RetCallback r5) {
        this.f3644 = r1;
        this.f3645 = r2;
        this.f3646 = set;
        this.f3647 = z;
        this.f3648 = r5;
    }

    public final void run() {
        this.f3644.mo9349(this.f3645, this.f3646, this.f3647, this.f3648);
    }
}
