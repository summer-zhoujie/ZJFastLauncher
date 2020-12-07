package com.wpengapp.support;

import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ચ */
/* compiled from: WechatSubscriptionActivity */
class C1101 implements Runnable {
    public C1101(C0667 r1) {
    }

    public void run() {
        C0826.m2177((CharSequence) AppUtils.m1141(R$string.pw_subscript_gzh_success, GzhConfig.getConfig().name));
    }
}
