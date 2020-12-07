package com.wpengapp.support;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.wpengapp.support.й */
public class NetworkUtils {

    /* renamed from: ֏ */
    public static final String f1813 = "й";

    /* renamed from: ֏ */
    public static boolean m1800() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppUtils.m1153("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            String str = f1813;
            e.getMessage();
            return false;
        }
    }
}
