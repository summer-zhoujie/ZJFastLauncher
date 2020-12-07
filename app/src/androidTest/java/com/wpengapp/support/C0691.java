package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.К */
/* compiled from: QrPayActivity */
public class C0691 implements Runnable {

    /* renamed from: ֏ */
    public StringBuilder f1790 = new StringBuilder();

    /* renamed from: ؠ */
    public final /* synthetic */ QrPayActivity f1791;

    public C0691(QrPayActivity qrPayActivity) {
        this.f1791 = qrPayActivity;
    }

    public void run() {
        if (this.f1791.f685 || this.f1791.mo7442() || this.f1791.isFinishing()) {
            this.f1791.f686.setText(BidiFormatter.EMPTY_STRING);
            return;
        }
        this.f1790.append(".");
        this.f1791.f686.setText(this.f1790.toString());
        if (this.f1790.length() > 2) {
            this.f1790 = new StringBuilder();
        }
        AppUtils.m1147((Runnable) this, 600);
    }
}
