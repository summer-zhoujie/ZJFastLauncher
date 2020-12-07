package com.wpengapp.support;

import android.os.Build;
import android.view.KeyEvent;

/* renamed from: com.wpengapp.support.ह */
public class SmartBarUtils {
    static {
        try {
            KeyEvent.class.getField("KEYCODE_FINGERPRINT").getInt((Object) null);
        } catch (Exception unused) {
        }
    }

    /* renamed from: ֏ */
    public static boolean m2774() {
        boolean z;
        boolean z2;
        String str;
        String str2;
        try {
            z = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            if (Build.DEVICE.equals("mx2") || Build.DEVICE.equals("mx3")) {
                z = true;
            } else {
                if (!Build.DEVICE.equals("mx")) {
                    boolean equals = Build.DEVICE.equals("m9");
                }
                z = false;
            }
        }
        if (z) {
            return true;
        }
        String str3 = Build.BRAND;
        if ((str3 == null || !str3.toLowerCase().contains("meizu")) && (((str = Build.VERSION.INCREMENTAL) == null || !str.toLowerCase().contains("flyme")) && ((str2 = Build.DISPLAY) == null || !str2.toLowerCase().contains("flyme")))) {
            z2 = false;
        } else {
            z2 = true;
        }
        return z2 || Build.DEVICE.equals("mx2") || Build.DEVICE.equals("mx3") || Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9");
    }
}
