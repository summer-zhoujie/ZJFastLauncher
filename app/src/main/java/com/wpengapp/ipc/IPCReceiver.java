package com.wpengapp.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wpengapp.support.IPCManager;

public abstract class IPCReceiver extends BroadcastReceiver {

    /* renamed from: ֏ */
    public String f406;

    public IPCReceiver(String str) {
        this.f406 = str;
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra(".OO0O0O00.EXTRA_MSG_ID", 0);
            if (intent.getBooleanExtra(".OO0O0O00.EXTRA_OK_MSG", false)) {
                IPCManager.C0655 r9 = IPCManager.f1699.get(Integer.valueOf(intExtra));
                if (r9 != null) {
                    IPCManager.f1701.removeCallbacks(r9.f1705);
                    IPCManager.f1701.postDelayed(r9.f1705, 10000);
                }
            } else if (intent.getBooleanExtra(".OO0O0O00.EXTRA_CALLBACK_MSG", false)) {
                Bundle bundleExtra = intent.getBundleExtra(".OO0O0O00.EXTRA_PARAMS");
                IPCManager.C0655 r10 = IPCManager.f1699.get(Integer.valueOf(intExtra));
                if (r10 != null) {
                    r10.mo7910(bundleExtra, false);
                    IPCManager.f1701.removeCallbacks(r10.f1705);
                    IPCManager.f1699.remove(Integer.valueOf(intExtra));
                }
            } else {
                String stringExtra = intent.getStringExtra(".OO0O0O00.EXTRA_SENDER_PKG");
                String stringExtra2 = intent.getStringExtra(".OO0O0O00.EXTRA_SENDER_ACTION");
                boolean booleanExtra = intent.getBooleanExtra(".OO0O0O00.EXTRA_NEED_CALLBACK", false);
                if (booleanExtra) {
                    IPCManager.m1688(stringExtra, stringExtra2, intExtra);
                }
                IPCManager.f1701.post(new com.wpengapp.support.IPCReceiver(this, intent, stringExtra, booleanExtra, stringExtra2, intExtra));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public abstract Bundle mo7553(int i, Bundle bundle, String str);
}
