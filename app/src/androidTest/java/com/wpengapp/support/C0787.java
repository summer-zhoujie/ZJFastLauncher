package com.wpengapp.support;

import android.text.TextUtils;

/* renamed from: com.wpengapp.support.Ս */
/* compiled from: WpAlipay */
public class C0787 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ C1305 f2050;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0787(C1305 r1, String str) {
        super(str);
        this.f2050 = r1;
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C1305 r4 = this.f2050;
        r4.f3733.mo8503(false, r4.f3717.getString(R$string.wpengpay_error_wp_connect_fail));
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r5, ErrorCode r6) {
        if (TextUtils.isEmpty(r5.f3519)) {
            C1305 r52 = this.f2050;
            r52.f3733.mo8503(false, r52.f3717.getString(R$string.wpengpay_error_wp_server_busy, new Object[]{"1"}));
            return;
        }
        this.f2050.mo9570(r5.f3519);
    }
}
