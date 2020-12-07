package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wpengapp.lightstart.activity.MainActivity;

/* renamed from: com.wpengapp.support.ະ */
/* compiled from: MainActivity */
class C1233 extends BroadcastReceiver {

    /* renamed from: ֏ */
    public final /* synthetic */ MainActivity f3505;

    public C1233(MainActivity mainActivity) {
        this.f3505 = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        AppUtils.m1146((Runnable) new C1287(this));
    }
}
