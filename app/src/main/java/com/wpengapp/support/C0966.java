package com.wpengapp.support;

import android.widget.ImageView;
import com.wpengapp.support.licensing.activity.QrPayActivity;
import com.wpengapp.support.licensing.model.QrPayDto;

/* renamed from: com.wpengapp.support.ߎ */
/* compiled from: QrPayActivity */
public class C0966 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ ImageView f2687;

    /* renamed from: ؠ */
    public final /* synthetic */ QrPayDto f2688;

    public C0966(QrPayActivity qrPayActivity, ImageView imageView, QrPayDto qrPayDto) {
        this.f2687 = imageView;
        this.f2688 = qrPayDto;
    }

    public void run() {
        ImageView imageView = this.f2687;
        imageView.setImageBitmap(QRCodeEncoder.m3204(this.f2688.qrContent, imageView.getWidth()));
    }
}
