package com.wpengapp.support;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.p000v4.app.NotificationCompat;
import com.umeng.analytics.AnalyticsConstants;
import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ପ */
/* compiled from: UserManager */
class C1139 extends SyncUserInfoListener {
    public C1139(UserManager r1) {
    }

    /* renamed from: ֏ */
    public void mo8101(UserInfo r3) {
        C0536.f1033 = 1800000;
        C0536.m1305(false);
    }

    /* renamed from: ֏ */
    public void mo8100(int i) {
        C0678.f1767.postDelayed(new C0720(this), C0536.f1033);
        C0536.f1033 += 1800000;
        if (C0536.f1033 > AnalyticsConstants.f107j) {
            C0536.f1033 = AnalyticsConstants.f107j;
        }
        UserInfo r6 = C0536.m1309();
        if (r6 != null && r6.mo8705() && (r6.f2118 + r6.f2117) - System.currentTimeMillis() <= 0 && C1146.m3072()) {
            RemoteSP.m1206("spltineerr", (Object) true, false);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(AppUtils.getApplication(), "defch");
            String r2 = AppUtils.m1141(R$string.wpengpay_user_expire_title, SystemUtils.m3519(AppUtils.m1163()));
            builder.setContentTitle(r2);
            builder.setLargeIcon(Utils.m1862(SystemUtils.m3508(AppUtils.m1163())));
            builder.setSmallIcon(R$drawable.pw_icon_notify_download);
            builder.setTicker(r2);
            builder.setAutoCancel(true);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(AppUtils.m1141(R$string.wpengpay_user_expire_des, new Object[0])));
            builder.setContentIntent(PendingIntent.getActivity(AppUtils.getApplication(), 200, new Intent(AppUtils.getApplication(), AboutActivity.class), 268435456));
            ((NotificationManager) AppUtils.m1153("notification")).notify(728181813, builder.build());
        }
    }
}
