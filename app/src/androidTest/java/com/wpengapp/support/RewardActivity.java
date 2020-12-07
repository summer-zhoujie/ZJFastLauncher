package com.wpengapp.support;

import android.widget.ImageView;

/* renamed from: com.wpengapp.support.Ն */
public class RewardActivity implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ ImageView f2029;

    /* renamed from: ؠ */
    public final /* synthetic */ String f2030;

    public RewardActivity(com.wpengapp.support.activity.RewardActivity rewardActivity, ImageView imageView, String str) {
        this.f2029 = imageView;
        this.f2030 = str;
    }

    public void run() {
        ImageView imageView = this.f2029;
        imageView.setImageBitmap(QRCodeEncoder.m3204(this.f2030, imageView.getWidth()));
    }
}
