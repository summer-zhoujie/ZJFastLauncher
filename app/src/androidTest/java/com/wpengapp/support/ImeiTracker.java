package com.wpengapp.support;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.social.UMSocialConstants;

/* renamed from: com.wpengapp.support.ϻ */
public class ImeiTracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public Context f1765;

    public ImeiTracker(Context context) {
        super(UMSocialConstants.f258q);
        this.f1765 = context;
    }

    /* renamed from: ؠ */
    public String mo8028() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f1765.getSystemService("phone");
        try {
            if (DeviceConfig.m2313(this.f1765, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getDeviceId();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
