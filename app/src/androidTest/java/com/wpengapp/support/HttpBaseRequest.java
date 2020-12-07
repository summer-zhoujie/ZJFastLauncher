package com.wpengapp.support;

import com.wpengapp.http.R$string;
import com.wpengapp.support.WPengServer;

/* renamed from: com.wpengapp.support.ί */
public class HttpBaseRequest implements WPengServer.C0486 {

    /* renamed from: ֏ */
    public final /* synthetic */ C0849 f1649;

    public HttpBaseRequest(C0849 r1) {
        this.f1649 = r1;
    }

    /* renamed from: ֏ */
    public void mo8394(boolean z, String str) {
        boolean z2;
        Call r9 = this.f1649.f2695;
        if (r9 == null) {
            z2 = false;
        } else {
            z2 = ((C1140) r9).mo9323();
        }
        if (!z2) {
            if (z) {
                C0849 r8 = this.f1649;
                String r3 = r8.f2697;
                String r4 = this.f1649.f2301;
                C0849 r1 = this.f1649;
                C0849 unused = r8.f2299 = new C1080(this, r3, r4, r1.f2296, r1.f2295);
                boolean unused2 = this.f1649.f2299.f2297 = false;
                this.f1649.f2299.mo8757(this.f1649.f2302);
                return;
            }
            this.f1649.f2300.mo7981(new Exception(WPengServer.m1071(R$string.error_refresh_ds)));
        }
    }
}
