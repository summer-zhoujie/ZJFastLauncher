package com.wpengapp.support;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;

public class ForegroundServiceHelper extends Service {

    /* renamed from: ֏ */
    public static String f576;

    /* renamed from: ֏ */
    public static void m728(Service service, int i, String str, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (pendingIntent == null) {
                Intent intent = new Intent();
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", service.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", m727());
                pendingIntent = PendingIntent.getActivity(AppUtils.getApplication(), 200, intent, 268435456);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(service, m727());
            builder.setContentTitle(str);
            builder.setContentText(AppUtils.m1141(R$string.pw_service_notification_des, new Object[0]));
            builder.setAutoCancel(true);
            builder.setShowWhen(true);
            builder.setOnlyAlertOnce(true);
            builder.setSound((Uri) null);
            builder.setSmallIcon(i);
            builder.setContentIntent(pendingIntent);
            service.startForeground(34343, builder.build());
            return;
        }
        service.startForeground(34343, new Notification());
        if (SystemUtils.f3711 >= 18) {
            try {
                service.startService(new Intent(service, ForegroundServiceHelper.class));
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        startForeground(34343, new Notification());
        stopSelf();
    }

    /* renamed from: ֏ */
    public static String m727() {
        if (f576 != null || Build.VERSION.SDK_INT < 26) {
            return f576;
        }
        f576 = "ForegroundService";
        ((NotificationManager) AppUtils.m1153("notification")).createNotificationChannel(new NotificationChannel(f576, AppUtils.m1141(R$string.pw_service_notification_channel_name, new Object[0]), 1));
        return f576;
    }
}
