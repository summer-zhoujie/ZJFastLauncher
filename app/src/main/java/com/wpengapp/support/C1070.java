package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ষ */
/* compiled from: WechatSubscriptionActivity */
class C1070 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ GzhConfig f3044;

    /* renamed from: ؠ */
    public final /* synthetic */ WechatSubscriptionActivity f3045;

    public C1070(WechatSubscriptionActivity wechatSubscriptionActivity, GzhConfig gzhConfig) {
        this.f3045 = wechatSubscriptionActivity;
        this.f3044 = gzhConfig;
    }

    public void onClick(View view) {
        SystemUtils.m3513((CharSequence) this.f3044.name);
        C0826.m2180((CharSequence) this.f3045.getString(R$string.pw_copy_success) + "\n" + this.f3044.name);
    }
}
