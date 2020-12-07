package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* renamed from: com.wpengapp.support.ϰ */
/* compiled from: UserManager */
class C0674 implements Runnable {
    public void run() {
        boolean z;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!C0536.m1322()) {
            C0536.f1039 = elapsedRealtime;
        } else if ((elapsedRealtime - C0536.f1039) - 1800000 > 9000000) {
            Intent intent = new Intent(AppUtils.m1163() + AppUtils.m1159());
            intent.putExtra(AppUtils.m1163(), "2");
            C0786.m2105((Context) AppUtils.getApplication(), intent, true);
            z = true;
            if (!z && "WPeng".equals(Utils.m1901((Context) AppUtils.getApplication()))) {
                Intent intent2 = new Intent(AppUtils.m1163() + AppUtils.m1159());
                intent2.putExtra(AppUtils.m1163(), "6");
                C0786.m2105((Context) AppUtils.getApplication(), intent2, true);
            }
            AppUtils.m1147((Runnable) this, 1800000);
        }
        z = false;
        Intent intent22 = new Intent(AppUtils.m1163() + AppUtils.m1159());
        intent22.putExtra(AppUtils.m1163(), "6");
        C0786.m2105((Context) AppUtils.getApplication(), intent22, true);
        AppUtils.m1147((Runnable) this, 1800000);
    }
}
