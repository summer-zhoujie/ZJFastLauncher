package com.wpengapp.support.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C1110;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.permission.RequestPermissionHelper;

public class LauncherActivity extends Activity {

    /* renamed from: ֏ */
    public static boolean f635;

    /* renamed from: ؠ */
    public static Class<? extends Activity> f636;

    /* renamed from: ހ */
    public static int f637;

    /* renamed from: ށ */
    public static long f638;

    /* renamed from: ނ */
    public long f639;

    public void onCreate(Bundle bundle) {
        BaseApplication.f561.mo7791("Launcher.onCreate");
        this.f639 = System.currentTimeMillis();
        super.onCreate(bundle);
        boolean r6 = BaseApplication.f561.mo7795();
        boolean r0 = C1110.m2991();
        if (r6 || r0) {
            Window window = getWindow();
            if (window != null) {
                int i = f637;
                int i2 = R$layout.pw_activity_starting;
                if (i == i2) {
                    setContentView(i2);
                    window.setLayout(-1, -1);
                    ((ImageView) findViewById(R$id.img_logo)).setImageDrawable(SystemUtils.m3508(getPackageName()));
                } else {
                    int i3 = f637;
                    if (i3 > 0) {
                        setContentView(i3);
                        window.setLayout(-1, -1);
                    }
                }
            }
            if (r6) {
                LauncherActivity r62 = new LauncherActivity(this, r0);
                RequestPermissionHelper.m898(BaseApplication.f561.mo7556(), AppUtils.m1141(R$string.pw_permission_rationale_launch, SystemUtils.m3519(AppUtils.m1163())), r62);
                return;
            }
            AppUtils.m1146((Runnable) new C0712(this, r0));
            return;
        }
        BaseApplication.f561.mo7796();
        mo7829();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: ހ */
    public final void mo7831() {
        Intent intent = new Intent(this, f636);
        intent.addFlags(268500992);
        if (f635) {
            intent.addFlags(8388608);
        }
        int i = Build.VERSION.SDK_INT;
        AppUtils.m1148(f635, Integer.valueOf(getTaskId()));
        startActivity(intent);
        AppUtils.m1147((Runnable) new C0992(this), 1000);
        BaseApplication.f561.mo7791("Launcher.toMain");
    }

    /* renamed from: ؠ */
    public static void m799() {
        AppUtils.m1144();
        AppUtils.m1147((Runnable) new C1214(), 100);
    }

    /* renamed from: ֏ */
    public final void mo7829() {
        BaseApplication.f561.mo7791("Launcher.delayToMain");
        long currentTimeMillis = f638 - (System.currentTimeMillis() - this.f639);
        if (currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis <= 0) {
            mo7831();
        } else {
            AppUtils.m1147((Runnable) new C0855(this), currentTimeMillis);
        }
    }

    /* renamed from: ֏ */
    public final void mo7830(boolean z) {
        if (!z) {
            mo7829();
        } else {
            C1110.m2990(this, new C1095(this), new C1250(this));
        }
    }
}
