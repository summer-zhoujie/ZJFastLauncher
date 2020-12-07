package com.wpengapp.xposed.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.wpengapp.support.C0731;
import com.wpengapp.support.SystemApi;

public class LaunchService extends Service {

    /* renamed from: ֏ */
    public static boolean f3844;

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!f3844) {
            f3844 = true;
            SystemApi.f1981.mo7962();
        }
        new Handler().post(new C0731(this));
        return super.onStartCommand(intent, i, i2);
    }
}
