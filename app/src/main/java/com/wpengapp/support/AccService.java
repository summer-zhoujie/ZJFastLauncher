package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* renamed from: com.wpengapp.support.ј */
class AccService extends BroadcastReceiver {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.service.AccService f1848;

    public AccService(com.wpengapp.lightstart.service.AccService accService) {
        this.f1848 = accService;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            RemoteSP.m1206(new String(Base64.decode(C0536.f1032, 0), StandardCharsets.UTF_8), (Object) Long.valueOf(System.currentTimeMillis()), false);
            SpHandler.f1750.mo8105(false);
            C0536.m1311(intent.getStringExtra(this.f1848.getPackageName()));
            C1219.m3283();
            SystemUtils.m3527(C1279.m3439());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
