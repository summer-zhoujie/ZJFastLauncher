package com.wpengapp.support;

import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.WPengServer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ƽ */
/* compiled from: BaseApplication */
public class C0520 implements WPengServer.C0484 {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseApplication.C0444 f965;

    public C0520(BaseApplication.C0444 r1) {
        this.f965 = r1;
    }

    /* renamed from: ֏ */
    public Map<String, String> mo8085() {
        HashMap hashMap = new HashMap();
        hashMap.put("atime", BaseApplication.this.mo7793());
        return hashMap;
    }
}
