package com.wpengapp.lightstart.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import com.wpengapp.lightstart.activity.MainActivity;
import com.wpengapp.support.SpHandler;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.permission.ServicePermissionActivity;

@RequiresApi(api = 24)
public class EnableTileService extends TileService {

    /* renamed from: ֏ */
    public boolean f533;

    /* renamed from: ؠ */
    public BroadcastReceiver f534 = new EnableTileService(this);

    public IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public void onClick() {
        if (MainActivity.m455()) {
            SpHandler.f1750.mo8105(false);
            mo7769();
        } else if (ServicePermissionActivity.m913()) {
            SpHandler.f1750.mo8105(true);
            mo7769();
        } else {
            try {
                showDialog(ServicePermissionActivity.m907((Context) this));
                this.f533 = true;
            } catch (Exception e) {
                e.getMessage();
                try {
                    SystemUtils.m3510((Context) this, new Intent(this, MainActivity.class));
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        registerReceiver(this.f534, new IntentFilter(ServicePermissionActivity.f712));
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f534);
    }

    public void onStartListening() {
        mo7769();
    }

    /* renamed from: ֏ */
    public final void mo7769() {
        try {
            if (MainActivity.m455()) {
                getQsTile().setState(2);
            } else {
                getQsTile().setState(1);
            }
            getQsTile().updateTile();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
