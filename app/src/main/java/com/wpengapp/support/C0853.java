package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.wpengapp.support.ع */
/* compiled from: UserManager */
class C0853 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtils.m1800()) {
            C0536.m1305(false);
        }
    }
}
