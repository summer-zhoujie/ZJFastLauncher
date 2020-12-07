package com.wpengapp.lightstart.service.shortcut.tile;

import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.ShortcutActivity;
import com.wpengapp.support.C0774;
import com.wpengapp.support.C0826;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.UnpaidCountLimit;

@RequiresApi(api = 24)
public abstract class BaseSCTile extends TileService {
    public IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final void onClick() {
        if (ShortcutActivity.f461.mo8264()) {
            SystemUtils.m3509();
            C0826.m2172((int) R$string.trial_tips, new Object[0]);
            return;
        }
        Exception e = null;
        try {
            C0774.m2083(mo7786());
        } catch (Exception e2) {
            e = e2;
            e.toString();
            C0826.m2179(R$string.launch_error, new Object[0]);
            UnpaidCountLimit r1 = ShortcutActivity.f461;
            r1.f1340--;
        }
        SystemUtils.m3509();
        C0774.m2084(mo7786(), "tile", e);
    }

    public void onStartListening() {
        mo7787();
    }

    public void onTileAdded() {
        mo7787();
    }

    /* renamed from: ֏ */
    public abstract String mo7786();

    /* renamed from: ؠ */
    public final void mo7787() {
        try {
            getQsTile().setState(1);
            getQsTile().updateTile();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
