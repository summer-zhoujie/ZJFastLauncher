package com.wpengapp.support;

import android.os.Bundle;

/* renamed from: com.wpengapp.support.Ć */
class Remote extends IPCCallback {

    /* renamed from: ؠ */
    public final /* synthetic */ PluginRunningInfo f746;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Remote(String str, PluginRunningInfo r2) {
        super(str);
        this.f746 = r2;
    }

    /* renamed from: ֏ */
    public void mo7910(Bundle bundle, boolean z) {
        synchronized (this.f746) {
            if (z || bundle == null) {
                this.f746.f905 = -1;
            } else {
                this.f746.f905 = bundle.getInt("pplv", -1);
                this.f746.f906 = bundle.getInt("pppid", -1);
                this.f746.f907 = bundle.getIntegerArrayList("ppinst");
            }
            this.f746.notifyAll();
        }
    }
}
