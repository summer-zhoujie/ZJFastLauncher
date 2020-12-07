package com.wpengapp.support;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.text.BidiFormatter;

import com.wpengapp.support.model.App;

/* renamed from: com.wpengapp.support.ჺ */
/* compiled from: UpdateHelper */
class C1335 implements RetCallback<App.AppVersion> {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f3808;

    /* renamed from: ؠ */
    public final /* synthetic */ boolean f3809;

    /* renamed from: ހ */
    public final /* synthetic */ UpdateHelper.C0447 f3810;

    public C1335(boolean z, boolean z2, UpdateHelper.C0447 r3) {
        this.f3808 = z;
        this.f3809 = z2;
        this.f3810 = r3;
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        UpdateHelper.f594 = false;
        if (this.f3808) {
            C0826.m2179(R$string.pw_update_error, new Object[0]);
        }
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        App.AppVersion appVersion = (App.AppVersion) obj;
        RemoteSP.m1206("check_date", (Object) Long.valueOf(System.currentTimeMillis()), false);
        UpdateHelper.f599 = Utils.m1859(C1063.m2859("bg_update_time", (String) null), 604800000);
        boolean z = this.f3808;
        boolean z2 = this.f3809;
        UpdateHelper.C0447 r3 = this.f3810;
        if (appVersion == null) {
            if (z) {
                C0826.m2179(R$string.pw_update_is_new_version, new Object[0]);
            }
            UpdateHelper.f594 = false;
            return;
        }
        if (!z && !appVersion.forceUpdate) {
            if (!appVersion.needUpdate) {
                UpdateHelper.f594 = false;
                StringBuilder r0 = outline.m2549("Dose not need update version ");
                r0.append(appVersion.versionName);
                r0.toString();
                return;
            }
            String r4 = RemoteSP.m1202("ignore", BidiFormatter.EMPTY_STRING);
            if (appVersion.versionName.equals(r4)) {
                UpdateHelper.f594 = false;
                outline.m2555("Ignore version ", r4);
                return;
            }
        }
        if (z2) {
            UpdateHelper.f594 = false;
            Application r2 = AppUtils.getApplication();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(r2, "defch");
            String string = r2.getString(R$string.pw_notify_update_title, new Object[]{SystemUtils.m3519(AppUtils.m1163())});
            builder.setContentTitle(string);
            builder.setContentText(r2.getString(R$string.pw_notify_update_msg, new Object[]{appVersion.versionName}));
            builder.setLargeIcon(Utils.m1862(SystemUtils.m3508(AppUtils.m1163())));
            builder.setSmallIcon(R$drawable.pw_icon_notify_download);
            builder.setTicker(string);
            builder.setAutoCancel(true);
            Intent intent = new Intent(r2, UpdateHelper.NotificationClickService.class);
            intent.putExtra("version", appVersion);
            intent.putExtra("userAction", z);
            builder.setContentIntent(PendingIntent.getService(r2, 719, intent, 268435456));
            ((NotificationManager) AppUtils.m1153("notification")).notify(619, builder.build());
            UpdateHelper.m739(appVersion.versionName);
            return;
        }
        AppUtils.m1146((Runnable) new C0592(z, appVersion, r3));
    }
}
