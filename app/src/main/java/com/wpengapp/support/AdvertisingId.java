package com.wpengapp.support;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.wpengapp.support.ܠ */
public final class AdvertisingId implements ServiceConnection {

    /* renamed from: ֏ */
    public boolean f2492 = false;

    /* renamed from: ؠ */
    public final LinkedBlockingQueue<IBinder> f2493 = new LinkedBlockingQueue<>(1);

    public /* synthetic */ AdvertisingId(C1068 r2) {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f2493.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    /* renamed from: ֏ */
    public IBinder mo8916() {
        if (!this.f2492) {
            this.f2492 = true;
            return this.f2493.take();
        }
        throw new IllegalStateException();
    }
}
