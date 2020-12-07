package com.wpengapp.support;

import android.content.Context;

/* renamed from: com.wpengapp.support.ȗ */
public class UMIdTracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public Context f1085;

    public UMIdTracker(Context context) {
        super("idmd5");
        this.f1085 = context;
    }

    /* renamed from: ؠ */
    public String mo8028() {
        return HelperUtils.m2472(DeviceConfig.m2324(this.f1085));
    }
}
