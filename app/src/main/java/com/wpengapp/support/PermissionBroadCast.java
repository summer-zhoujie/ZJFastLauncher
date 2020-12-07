package com.wpengapp.support;

import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.Ċ */
class PermissionBroadCast implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ WeakReference f748;

    public PermissionBroadCast(WeakReference weakReference) {
        this.f748 = weakReference;
    }

    public void run() {
        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) this.f748.get();
        if (broadcastReceiver != null) {
            C0786.m2102(AppUtils.getApplication(), broadcastReceiver);
        }
    }
}
