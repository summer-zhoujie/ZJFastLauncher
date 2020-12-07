package com.wpengapp.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.permission.ServicePermissionActivity;

/* renamed from: com.wpengapp.support.š */
class EnableTileService extends BroadcastReceiver {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.lightstart.service.EnableTileService f868;

    public EnableTileService(com.wpengapp.lightstart.service.EnableTileService enableTileService) {
        this.f868 = enableTileService;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f868.f533) {
            boolean unused = this.f868.f533 = false;
            if (ServicePermissionActivity.m913()) {
                SpHandler.f1750.mo8105(true);
                this.f868.mo7769();
                C0826.m2179(R$string.is_enabled, new Object[0]);
            }
        }
    }
}
