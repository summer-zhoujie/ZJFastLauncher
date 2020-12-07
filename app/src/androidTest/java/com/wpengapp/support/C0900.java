package com.wpengapp.support;

import android.os.Bundle;
import com.wpengapp.support.IPCManager;

/* renamed from: com.wpengapp.support.ۀ */
/* compiled from: IPCManager */
class C0900 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ int f2423;

    /* renamed from: ؠ */
    public final /* synthetic */ IPCManager.C0655 f2424;

    public C0900(IPCManager.C0655 r1, int i) {
        this.f2424 = r1;
        this.f2423 = i;
    }

    public void run() {
        IPCManager.f1699.remove(Integer.valueOf(this.f2423));
        this.f2424.mo7910((Bundle) null, true);
    }
}
