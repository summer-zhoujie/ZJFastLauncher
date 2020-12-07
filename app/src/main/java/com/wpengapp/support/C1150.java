package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.எ */
/* compiled from: WechatSubscriptionActivity */
class C1150 implements View.OnLongClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ GzhConfig f3277;

    /* renamed from: ؠ */
    public final /* synthetic */ WechatSubscriptionActivity f3278;

    public C1150(WechatSubscriptionActivity wechatSubscriptionActivity, GzhConfig gzhConfig) {
        this.f3278 = wechatSubscriptionActivity;
        this.f3277 = gzhConfig;
    }

    public boolean onLongClick(View view) {
        SystemUtils.m3513((CharSequence) this.f3277.name);
        C0826.m2180((CharSequence) this.f3278.getString(R$string.pw_copy_success) + "\n" + this.f3277.name);
        return false;
    }
}
