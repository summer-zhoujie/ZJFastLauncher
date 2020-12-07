package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.p003v7.widget.TooltipCompatHandler;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ݛ */
/* compiled from: AccService */
class C0931 extends BroadcastReceiver {

    /* renamed from: ֏ */
    public final /* synthetic */ AccService f2528;

    public C0931(AccService accService) {
        this.f2528 = accService;
    }

    public void onReceive(Context context, Intent intent) {
        outline.m2555("Pkg changed: ", intent.getAction());
        this.f2528.f503.removeCallbacks(this.f2528.f520);
        this.f2528.f503.postDelayed(this.f2528.f520, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_SHORT_MS);
    }
}
