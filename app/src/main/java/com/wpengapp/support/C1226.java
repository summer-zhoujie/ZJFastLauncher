package com.wpengapp.support;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.ຣ */
/* compiled from: WechatBarcodeAction */
class C1226 implements TaskCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ long f3498;

    public C1226(WechatBarcodeAction r1, long j) {
        this.f3498 = j;
    }

    public void error() {
        StringBuilder r0 = outline.m2549("WechatBarcodeTask fail ");
        r0.append(System.currentTimeMillis() - this.f3498);
        r0.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("WECHAT_BARCODE_ACTION", "error");
        hashMap.put("ver", String.valueOf(AppUtils.m1158()));
        hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("device", C0719.m1816());
        UMengManager.m1406("WECHAT_BARCODE_ACTION", (Map<String, String>) hashMap);
    }

    /* renamed from: ֏ */
    public void mo8185() {
        "WechatBarcodeTask success " + (System.currentTimeMillis() - this.f3498);
        HashMap hashMap = new HashMap();
        hashMap.put("WECHAT_BARCODE_ACTION", "success");
        UMengManager.m1406("WECHAT_BARCODE_ACTION", (Map<String, String>) hashMap);
    }
}
