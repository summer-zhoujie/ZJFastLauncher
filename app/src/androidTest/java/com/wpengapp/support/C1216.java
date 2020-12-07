package com.wpengapp.support;

import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.view.View;
import com.wpengapp.support.activity.WechatSubscriptionActivity;

/* renamed from: com.wpengapp.support.ຕ */
/* compiled from: WechatSubscriptionActivity */
class C1216 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ WechatSubscriptionActivity f3472;

    public C1216(WechatSubscriptionActivity wechatSubscriptionActivity) {
        this.f3472 = wechatSubscriptionActivity;
    }

    public void onClick(View view) {
        if (!CountLimitHelper.m997("oneKey", ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS)) {
            this.f3472.mo7848();
        }
    }
}
