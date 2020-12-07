package com.wpengapp.support;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserManager;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.http.RequestHelper;
import com.wpengapp.support.activity.LauncherActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;

public abstract class BaseApplication extends Application {

    /* renamed from: ֏ */
    public static BaseApplication f561;

    /* renamed from: ؠ */
    public static boolean f562;

    /* renamed from: ހ */
    public static String f563;

    /* renamed from: ށ */
    public boolean f564;

    /* renamed from: ނ */
    public volatile boolean f565;

    /* renamed from: ރ */
    public ActivityLifecycleCallbacks f566;

    /* renamed from: ބ */
    public final LongSP f567 = new LongSP("matainttt", 0L);

    /* renamed from: ޅ */
    public C1114 f568;

    /* renamed from: ކ */
    public boolean f569;

    /* renamed from: އ */
    public long f570;

    /* renamed from: ނ */
    public static String m705() {
        if (TextUtils.isEmpty(f563)) {
            return AppUtils.m1159();
        }
        return AppUtils.m1159() + "." + f563;
    }

    public void attachBaseContext(Context context) {
        String str;
        f561 = this;
        SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(new NotificationChannel("defch", context.getString(R$string.pw_default_channel_name), 4));
        }
        String str2 = BidiFormatter.EMPTY_STRING;
        try {
            String r4 = MD5Utils.m1342(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toCharsString());
            str = RequestHelper.getAppSign(context);
            str2 = r4;
        } catch (Exception e) {
            e.getMessage();
            str = str2;
        }
        if (!str2.equals(str) || (!str2.equals("9371b39892df3b212e15cffc564cc4f2") && !str2.equals("5d975cd6e7dd2e5db97eb3ccd9d74d61"))) {
            mo7790(context);
        }
        super.attachBaseContext(context);
        mo7791("attachBaseContext");
    }

    public void onCreate() {
        mo7791("App.onCreate START");
        AppUtils.init((Application) this);
        super.onCreate();
        if (AppUtils.m1169()) {
            try {
                Reflect.create((Class<?>) UserManager.class).getMethod("get", this);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        mo7791("App.onCreate START 2");
        if (!mo7795()) {
            mo7796();
        } else {
            this.f566 = new C0790(this);
            registerActivityLifecycleCallbacks(this.f566);
        }
        registerActivityLifecycleCallbacks(new C0783(this));
    }

    /* renamed from: ֏ */
    public void mo7791(String str) {
    }

    /* renamed from: ֏ */
    public boolean mo7555() {
        return false;
    }

    /* renamed from: ހ */
    public String mo7793() {
        BaseApplication baseApplication;
        if (this.f568 == null && (baseApplication = f561) != null) {
            this.f568 = new C1114(baseApplication);
        }
        boolean z = true;
        if (this.f568 != null && ((double) (System.currentTimeMillis() - this.f570)) > 6876000.0d) {
            this.f570 = System.currentTimeMillis();
            this.f568.mo9299(true, false, true, (QueryCallback) new C1280(this));
        }
        if (!this.f569 && !C0536.m1313(C0536.m1309())) {
            z = false;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = z ? "6" : "5";
        return valueOf.substring(0, valueOf.length() - 3) + str + valueOf.substring(valueOf.length() - 2);
    }

    /* renamed from: ށ */
    public abstract String[] mo7556();

    /* renamed from: ރ */
    public boolean mo7794() {
        return this.f565;
    }

    /* renamed from: ބ */
    public boolean mo7795() {
        if (Build.VERSION.SDK_INT >= 23 && AppUtils.getApplication().getApplicationInfo().targetSdkVersion >= 23 && AppUtils.m1169() && !RequestPermissionHelper.m899(mo7556()) && SystemUtils.m3507(AppUtils.m1163(), LauncherActivity.class.getName()) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: ޅ */
    public abstract void mo7557();

    /* renamed from: ކ */
    public final void mo7796() {
        if (!this.f564) {
            this.f564 = true;
            ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f566;
            if (activityLifecycleCallbacks != null) {
                unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                this.f566 = null;
            }
            if (AppUtils.m1169()) {
                FileManager.m1193();
            }
            mo7557();
            AppUtils.m1146((Runnable) new C1036(this));
        }
    }

    /* renamed from: އ */
    public void mo7797() {
        C1063.m2861((C1063.C1064) new C1016(this), new String[0]);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000a */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000a A[LOOP:0: B:5:0x000a->B:17:0x000a, LOOP_START, SYNTHETIC] */
    /* renamed from: ވ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7798() {
        /*
            r2 = this;
            boolean r0 = r2.mo7794()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "BaseApplication"
            monitor-enter(r0)
        L_0x000a:
            boolean r1 = r2.mo7794()     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = "BaseApplication"
            r1.wait()     // Catch:{ InterruptedException -> 0x000a }
            goto L_0x000a
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.BaseApplication.mo7798():void");
    }

    /* renamed from: ֏ */
    public void mo7790(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, (String) null);
        String string = context.getString(R$string.pw_sign_error);
        String string2 = context.getString(R$string.pw_sign_error2);
        String r3 = C1279.m3439();
        AppUtils.m1146((Runnable) new C0594(this, r3));
        C0826.m2180((CharSequence) string);
        builder.setContentTitle(string);
        builder.setContentText(string2);
        try {
            builder.setLargeIcon(Utils.m1862(getPackageManager().getApplicationIcon(getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo)));
        } catch (Exception unused) {
        }
        builder.setSmallIcon(R$drawable.pw_icon_notify_download);
        builder.setTicker(string);
        builder.setAutoCancel(true);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(r3));
        builder.setContentIntent(PendingIntent.getActivity(context, 200, intent, 268435456));
        builder.setChannelId("defch");
        ((NotificationManager) context.getSystemService("notification")).notify(1, builder.build());
        AppUtils.m1144();
        new C0809().start();
    }

    /* renamed from: ؠ */
    public void mo7792() {
        Intent intent = new Intent("ACTION_EXIT_PROCESS");
        intent.putExtra("fromPid", Process.myPid());
        C0786.m2105((Context) this, intent, true);
        UMengManager.m1402((Context) this);
        StatisticsManager.f584 = true;
        StatisticsManager.m735();
        AppUtils.m1144();
        new C0809().start();
    }

    /* renamed from: com.wpengapp.support.BaseApplication$֏ */
    public class C0444 {

        /* renamed from: ֏ */
        public Application f571;

        /* renamed from: ؠ */
        public String f572 = null;

        public C0444(Application application) {
            this.f571 = application;
        }

        /* renamed from: ֏ */
        public final boolean mo7800() {
            if (AppUtils.m1157("leakcanary")) {
                return false;
            }
            String str = this.f572;
            if (str == null) {
                return true;
            }
            if (str.equals(BidiFormatter.EMPTY_STRING)) {
                return AppUtils.m1169();
            }
            return AppUtils.m1157(this.f572);
        }

        /* renamed from: ֏ */
        public C0444 mo7799(Runnable runnable) {
            if (mo7800()) {
                runnable.run();
                BaseApplication.this.mo7791("initCustom");
            }
            return this;
        }
    }

    /* renamed from: ֏ */
    public C0444 mo7789(boolean z, String str) {
        f562 = z;
        f563 = str;
        return new C0444(this);
    }
}
