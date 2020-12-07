package com.wpengapp.xposed.sdk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.p000v4.app.NotificationCompat;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import com.wpengapp.support.C1148;

public class BootService extends Service {

    /* renamed from: ֏ */
    public static String f3843;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        mo9648(this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        mo9648(this);
        startService(new Intent(this, LaunchService.class));
        stopSelf();
        new Handler().postDelayed(C1148.f3268, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: ֏ */
    public final void mo9648(Service service) {
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(service, mo9647());
            builder.setAutoCancel(true);
            builder.setShowWhen(true);
            builder.setOnlyAlertOnce(true);
            builder.setSound((Uri) null);
            service.startForeground(11111, builder.build());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public final String mo9647() {
        if (f3843 != null || Build.VERSION.SDK_INT < 26) {
            return f3843;
        }
        f3843 = BootService.class.getName();
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(f3843, "BootService", 1));
        return f3843;
    }
}
