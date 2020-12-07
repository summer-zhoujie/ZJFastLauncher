package com.wpengapp.support;

import android.content.Context;
import android.provider.Settings;
import com.umeng.analytics.social.UMSocialConstants;

/* renamed from: com.wpengapp.support.ӳ */
public class AndroidIdTracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public Context f1952;

    public AndroidIdTracker(Context context) {
        super(UMSocialConstants.f260s);
        this.f1952 = context;
    }

    /* renamed from: ؠ */
    public String mo8028() {
        try {
            return Settings.Secure.getString(this.f1952.getContentResolver(), UMSocialConstants.f260s);
        } catch (Exception unused) {
            return null;
        }
    }
}
