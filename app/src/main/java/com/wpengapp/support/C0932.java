package com.wpengapp.support;

import java.net.URLEncoder;

/* renamed from: com.wpengapp.support.ݝ */
/* compiled from: WpAlipay */
public class C0932 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1305 f2529;

    public C0932(C1305 r1) {
        this.f2529 = r1;
    }

    public void run() {
        try {
            String r0 = this.f2529.mo9567();
            String encode = URLEncoder.encode(C1305.m3544(r0, this.f2529.f3731), "UTF-8");
            this.f2529.mo9568(this.f2529.mo9569(r0 + "&sign=\"" + encode + "\"&sign_type=\"RSA\""));
        } catch (Exception e) {
            e.getMessage();
            C1305 r02 = this.f2529;
            r02.f3733.mo8503(false, r02.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"6"}));
        }
    }
}
