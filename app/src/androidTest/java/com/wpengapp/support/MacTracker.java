package com.wpengapp.support;

import android.content.Context;
import com.umeng.analytics.social.UMSocialConstants;

/* renamed from: com.wpengapp.support.ў */
public class MacTracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public Context f1854;

    public MacTracker(Context context) {
        super(UMSocialConstants.f259r);
        this.f1854 = context;
    }

    /* renamed from: ؠ */
    public String mo8028() {
        try {
            return DeviceConfig.m2334(this.f1854);
        } catch (Exception unused) {
            return null;
        }
    }
}
