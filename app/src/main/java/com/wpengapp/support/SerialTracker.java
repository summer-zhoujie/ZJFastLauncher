package com.wpengapp.support;

import android.os.Build;

/* renamed from: com.wpengapp.support.ଷ */
public class SerialTracker extends AbstractIdTracker {
    public SerialTracker() {
        super("serial");
    }

    /* renamed from: ؠ */
    public String mo8028() {
        int i = Build.VERSION.SDK_INT;
        return Build.SERIAL;
    }
}
