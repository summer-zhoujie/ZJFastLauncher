package com.wpengapp.support;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.wpengapp.support.Ē */
/* compiled from: Remote */
class C0462 extends IPCCallback {

    /* renamed from: ؠ */
    public final /* synthetic */ AtomicReference f767;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0462(String str, AtomicReference atomicReference) {
        super(str);
        this.f767 = atomicReference;
    }

    /* renamed from: ֏ */
    public void mo7910(Bundle bundle, boolean z) {
        synchronized (this.f767) {
            if (!z && bundle != null) {
                this.f767.set(bundle.getBinder("plsbd"));
            }
            this.f767.notifyAll();
        }
    }
}
