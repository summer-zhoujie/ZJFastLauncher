package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.wpengapp.support.ڑ */
class MainActivity extends BroadcastReceiver {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.activity.MainActivity f2405;

    public MainActivity(com.wpengapp.lightstart.activity.MainActivity mainActivity) {
        this.f2405 = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (com.wpengapp.lightstart.activity.MainActivity.m455() && !this.f2405.mItemAppEnable.mo7505()) {
            this.f2405.mItemAppEnable.setChecked(true);
        }
    }
}
