package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.wpengapp.support.ଦ */
/* compiled from: RemoteSP */
class C1136 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (RemoteSP.f918.getPackageName().equals(intent.getPackage()) && !C1146.m3072()) {
            try {
                if (RemoteSP.f919 == intent.getIntExtra("sender_pid", -1)) {
                    return;
                }
            } catch (Exception e) {
                e.getMessage();
            }
            try {
                ArrayList arrayList = (ArrayList) intent.getSerializableExtra("sp_data");
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        SPData r5 = (SPData) it.next();
                        if (r5.f3022 == null) {
                            RemoteSP.f917.remove(r5.f3021);
                        } else {
                            RemoteSP.f917.put(r5.f3021, r5.f3022);
                        }
                        RemoteSP.m1205(r5.f3021, (Object) r5.f3022);
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}
