package com.wpengapp.support;

import android.os.Bundle;
import com.wpengapp.support.IPCManager;

/* renamed from: com.wpengapp.support.ߔ */
/* compiled from: IPCManager */
class C0971 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Bundle f2727;

    /* renamed from: ؠ */
    public final /* synthetic */ boolean f2728;

    /* renamed from: ހ */
    public final /* synthetic */ IPCManager.C0655 f2729;

    public C0971(IPCManager.C0655 r1, Bundle bundle, boolean z) {
        this.f2729 = r1;
        this.f2727 = bundle;
        this.f2728 = z;
    }

    public void run() {
        try {
            this.f2729.f1704.mo7910(this.f2727, this.f2728);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
