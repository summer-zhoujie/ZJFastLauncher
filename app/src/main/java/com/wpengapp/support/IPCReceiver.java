package com.wpengapp.support;

import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.wpengapp.support.ཇ */
public class IPCReceiver implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Intent f3532;

    /* renamed from: ؠ */
    public final /* synthetic */ String f3533;

    /* renamed from: ހ */
    public final /* synthetic */ boolean f3534;

    /* renamed from: ށ */
    public final /* synthetic */ String f3535;

    /* renamed from: ނ */
    public final /* synthetic */ int f3536;

    /* renamed from: ރ */
    public final /* synthetic */ com.wpengapp.ipc.IPCReceiver f3537;

    public IPCReceiver(com.wpengapp.ipc.IPCReceiver iPCReceiver, Intent intent, String str, boolean z, String str2, int i) {
        this.f3537 = iPCReceiver;
        this.f3532 = intent;
        this.f3533 = str;
        this.f3534 = z;
        this.f3535 = str2;
        this.f3536 = i;
    }

    public void run() {
        try {
            Bundle r0 = this.f3537.mo7553(this.f3532.getIntExtra(".OO0O0O00.EXTRA_WHAT", 0), this.f3532.getBundleExtra(".OO0O0O00.EXTRA_PARAMS"), this.f3533);
            if (this.f3534) {
                IPCManager.m1689(this.f3533, this.f3535, this.f3536, r0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
