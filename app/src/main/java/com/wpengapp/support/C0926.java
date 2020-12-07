package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ܯ */
/* compiled from: WechatSubscriptionActivity */
class C0926 extends RemoteMethod {
    public C0926(String str) {
        super(str);
    }

    /* renamed from: ؠ */
    public Bundle mo7979(@Nullable Bundle bundle) {
        C0840.m2250(new SubscribeTaskGroup(GzhConfig.getConfig().search), new C0667(this, System.currentTimeMillis()));
        return null;
    }
}
