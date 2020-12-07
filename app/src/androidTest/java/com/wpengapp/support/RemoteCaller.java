package com.wpengapp.support;

import android.os.Bundle;

/* renamed from: com.wpengapp.support.ݦ */
class RemoteCaller implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ String f2533;

    /* renamed from: ؠ */
    public final /* synthetic */ Bundle f2534;

    /* renamed from: ހ */
    public final /* synthetic */ RemoteCallback f2535;

    public RemoteCaller(String str, Bundle bundle, RemoteCallback r3) {
        this.f2533 = str;
        this.f2534 = bundle;
        this.f2535 = r3;
    }

    public void run() {
        RemoteResult r0 = C1146.m3069(this.f2533, this.f2534);
        RemoteCallback r1 = this.f2535;
        if (r1 != null) {
            ((C1104) r1).mo9289(r0);
        }
    }
}
