package com.wpengapp.lightstart.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import com.wpengapp.lightstart.activity.CustomActivity;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.C0524;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C1032;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.permission.ServicePermissionActivity;

@RequiresApi(api = 24)
public class CreateRuleTileService extends TileService {
    public IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public void onClick() {
        AppUtils.m1147((Runnable) new C0524(this), (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        if (C1032.m2761()) {
            SystemUtils.m3509();
            C1032.m2756();
        } else if (!ServicePermissionActivity.m913()) {
            showDialog(ServicePermissionActivity.m907((Context) this));
        } else {
            SystemUtils.m3509();
            if (C0909.m2387()) {
                Intent intent = new Intent(this, CustomActivity.class);
                intent.putExtra("autostart", true);
                SystemUtils.m3510((Context) this, intent);
                return;
            }
            C1032.m2770();
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStartListening() {
        mo7763();
    }

    /* renamed from: ֏ */
    public final void mo7763() {
        try {
            if (C1032.m2761()) {
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
