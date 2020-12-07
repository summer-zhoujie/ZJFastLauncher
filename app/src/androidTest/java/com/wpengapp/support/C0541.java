package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

/* renamed from: com.wpengapp.support.Ț */
/* compiled from: UpdateHelper */
public final class C0541 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int i = Calendar.getInstance().get(11);
        if (i >= 10 && i <= 21) {
            AppUtils.m1147((Runnable) new C1210(this), 10000);
        }
    }
}
