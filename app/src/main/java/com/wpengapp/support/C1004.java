package com.wpengapp.support;

import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.WPengServer;

/* renamed from: com.wpengapp.support.ऎ */
/* compiled from: BaseApplication */
public class C1004 implements WPengServer.C0485 {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseApplication.C0444 f2888;

    public C1004(BaseApplication.C0444 r1) {
        this.f2888 = r1;
    }

    /* renamed from: ֏ */
    public void mo9114() {
        long longValue = BaseApplication.this.f567.m1925().longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (longValue > currentTimeMillis || currentTimeMillis - longValue > 21600000) {
            BaseApplication.this.f567.mo8554(Long.valueOf(currentTimeMillis));
        }
    }
}
