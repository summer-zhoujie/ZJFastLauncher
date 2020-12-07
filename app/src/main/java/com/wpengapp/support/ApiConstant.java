package com.wpengapp.support;

import android.text.TextUtils;

/* renamed from: com.wpengapp.support.ߓ */
public class ApiConstant {

    /* renamed from: ֏ */
    public static String f2707 = outline.m2547(new StringBuilder(), "/ds");

    /* renamed from: ؠ */
    public static String f2708 = outline.m2547(new StringBuilder(), "/app");

    /* renamed from: ހ */
    public static String f2709 = outline.m2547(new StringBuilder(), "/app/version");

    /* renamed from: ށ */
    public static String f2710 = outline.m2547(new StringBuilder(), "/cfg");

    /* renamed from: ނ */
    public static String f2711 = outline.m2547(new StringBuilder(), "/stat");

    /* renamed from: ރ */
    public static String f2712 = outline.m2547(new StringBuilder(), "/appuser");

    /* renamed from: ބ */
    public static String f2713 = outline.m2547(new StringBuilder(), "/appuser/bind/check_device");

    /* renamed from: ޅ */
    public static String f2714 = outline.m2547(new StringBuilder(), "/appuser/bind/transfer");

    /* renamed from: ކ */
    public static String f2715 = outline.m2547(new StringBuilder(), "/appuser/bind/try_recovery");

    /* renamed from: އ */
    public static String f2716 = outline.m2547(new StringBuilder(), "/appuser/bind/confirm_recovery");

    /* renamed from: ވ */
    public static String f2717 = outline.m2547(new StringBuilder(), "/appuser/pay/qrwechat");

    /* renamed from: މ */
    public static String f2718 = outline.m2547(new StringBuilder(), "/appuser/pay/qralipay");

    /* renamed from: ފ */
    public static String f2719 = outline.m2547(new StringBuilder(), "/appuser/pay/wanpu");

    /* renamed from: ދ */
    public static String f2720 = outline.m2547(new StringBuilder(), "/appuser/upgrade/pay/qrwechat");

    /* renamed from: ތ */
    public static String f2721 = outline.m2547(new StringBuilder(), "/appuser/upgrade/pay/qralipay");

    /* renamed from: ލ */
    public static String f2722 = outline.m2547(new StringBuilder(), "/appuser/upgrade/pay/wanpu");

    /* renamed from: ގ */
    public static String f2723 = outline.m2547(new StringBuilder(), "/appuser/usecode");

    /* renamed from: ޏ */
    public static String f2724 = outline.m2547(new StringBuilder(), "/appuser/di");

    /* renamed from: ސ */
    public static String f2725 = outline.m2547(new StringBuilder(), "/appuser/dc");

    /* renamed from: ޑ */
    public static String f2726 = outline.m2547(new StringBuilder(), "/appuser/find");

    /* renamed from: ֏ */
    public static String m2593() {
        if (!WPengServer.f836) {
            return "https://wpengapp.com";
        }
        if (TextUtils.isEmpty(WPengServer.f843)) {
            return "http://192.168.1.103:8080";
        }
        return WPengServer.f843;
    }

    /* renamed from: ؠ */
    public static String m2595() {
        return m2593() + "/api";
    }

    /* renamed from: ֏ */
    public static boolean m2594(String str) {
        return !TextUtils.isEmpty(str) && str.contains(m2595());
    }
}
