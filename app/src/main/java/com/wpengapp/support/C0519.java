package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.wpengapp.support.Ʒ */
/* compiled from: UserManager */
public final class C0519 implements Runnable {
    public void run() {
        UserInfo r0 = C0536.m1309();
        if (r0 == null && (C0536.m1313((UserInfo) null) || C0536.m1322())) {
            Intent intent = new Intent(AppUtils.m1163() + AppUtils.m1159());
            intent.putExtra(AppUtils.m1163(), "4");
            C0786.m2105((Context) AppUtils.getApplication(), intent, true);
        } else if (r0 != null && r0.f2116 != 1) {
            if (C0536.m1313(r0) || r0.mo8705()) {
                Intent intent2 = new Intent(AppUtils.m1163() + AppUtils.m1159());
                intent2.putExtra(AppUtils.m1163(), "5");
                C0786.m2105((Context) AppUtils.getApplication(), intent2, true);
            }
        }
    }
}
