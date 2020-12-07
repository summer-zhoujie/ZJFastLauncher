package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import com.wpengapp.support.C0678;

/* renamed from: com.wpengapp.support.ח */
class PayActivity implements C0678.C0680 {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.licensing.handler.PayActivity f2136;

    public PayActivity(com.wpengapp.support.licensing.handler.PayActivity payActivity) {
        this.f2136 = payActivity;
    }

    /* renamed from: ֏ */
    public void mo8029(UserInfo r3, boolean z, String str) {
        Intent intent = new Intent("PayActivity.ACTION_CALLBACK");
        intent.putExtra("pay_success", z);
        intent.putExtra("pay_msg", str);
        intent.putExtra("pay_order", GsonUtil.m2742(r3));
        C0786.m2105((Context) this.f2136.getApplication(), intent, true);
        this.f2136.finish();
    }
}
