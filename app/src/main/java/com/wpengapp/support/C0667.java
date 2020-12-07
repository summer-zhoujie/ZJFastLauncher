package com.wpengapp.support;

import android.os.Build;
import com.wpengapp.support.model.GzhConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ϥ */
/* compiled from: WechatSubscriptionActivity */
class C0667 implements TaskCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ long f1730;

    public C0667(C0926 r1, long j) {
        this.f1730 = j;
    }

    public void error() {
        StringBuilder r0 = outline.m2549("Subscribe fail ");
        r0.append(System.currentTimeMillis() - this.f1730);
        r0.toString();
        C0826.m2172(R$string.pw_subscript_gzh_fail, GzhConfig.getConfig().name);
        HashMap hashMap = new HashMap();
        hashMap.put("gzh_onekey", "Fail");
        hashMap.put("ver", String.valueOf(AppUtils.m1158()));
        hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("device", C0719.m1816());
        UMengManager.m1406("gzh_onekey", (Map<String, String>) hashMap);
    }

    /* renamed from: ֏ */
    public void mo8185() {
        "Subscribe success " + (System.currentTimeMillis() - this.f1730);
        AppUtils.m1147((Runnable) new C1101(this), 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("gzh_onekey", "Success");
        UMengManager.m1406("gzh_onekey", (Map<String, String>) hashMap);
    }
}
