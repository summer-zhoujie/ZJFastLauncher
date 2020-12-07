package com.wpengapp.support;

import android.widget.ImageView;
import com.wpengapp.support.activity.WechatSubscriptionActivity;
import com.wpengapp.support.model.GzhConfig;

/* renamed from: com.wpengapp.support.ב */
/* compiled from: WechatSubscriptionActivity */
class C0816 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ ImageView f2129;

    /* renamed from: ؠ */
    public final /* synthetic */ GzhConfig f2130;

    public C0816(WechatSubscriptionActivity wechatSubscriptionActivity, ImageView imageView, GzhConfig gzhConfig) {
        this.f2129 = imageView;
        this.f2130 = gzhConfig;
    }

    public void run() {
        ImageView imageView = this.f2129;
        imageView.setImageBitmap(QRCodeEncoder.m3204(this.f2130.f702qr, imageView.getWidth()));
    }
}
