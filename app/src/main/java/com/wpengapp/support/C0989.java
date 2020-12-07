package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.wpengapp.support.ࠃ */
/* compiled from: UserManager */
class C0989 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ UseAppCodeListener f2777;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0989(String str, String str2, Map map, String str3, UseAppCodeListener r5) {
        super(str, str2, map, str3);
        this.f2777 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r4, ErrorCode r5) {
        if (r5.mo8157()) {
            C0536.m1326();
            this.f2777.mo8519(true, BidiFormatter.EMPTY_STRING, r5);
            C0536.m1306(true, (SyncUserInfoListener) null);
        } else if (r5 == ErrorCode.FAILED || TextUtils.isEmpty(r5.f1083)) {
            this.f2777.mo8519(false, Utils.m1864(R$string.wpengpay_app_code_use_fail, new Object[0]), r5);
        } else {
            this.f2777.mo8519(false, r5.f1083, r5);
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        this.f2777.mo8519(false, Utils.m1864(R$string.wpengpay_app_code_use_fail, new Object[0]), ErrorCode.FAILED);
    }
}
