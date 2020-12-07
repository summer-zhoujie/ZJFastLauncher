package com.wpengapp.support.model;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.wpengapp.support.C1063;
import com.wpengapp.support.GsonUtil;

@Keep
public class GzhConfig {
    public static final C1063.C1065 LISTENER = new GzhConfig();
    public static GzhConfig sGzhConfig;
    public boolean about;
    public boolean appCode;
    public String icon;
    public String intro;
    public boolean main;
    public String name;
    public boolean oneKey;

    /* renamed from: qr */
    public String f702qr;
    public String search;
    public boolean update;

    static {
        C1063.C1065 r0 = LISTENER;
        C1063.f3038.put(r0, r0);
    }

    public static GzhConfig getConfig() {
        GzhConfig gzhConfig = sGzhConfig;
        if (gzhConfig != null) {
            return gzhConfig;
        }
        String r0 = C1063.m2859("gzh", (String) null);
        if (TextUtils.isEmpty(r0)) {
            return new GzhConfig();
        }
        try {
            GzhConfig gzhConfig2 = (GzhConfig) GsonUtil.m2740(r0, GzhConfig.class);
            if (TextUtils.isEmpty(gzhConfig2.search)) {
                gzhConfig2.search = gzhConfig2.name;
            }
            sGzhConfig = gzhConfig2;
            return gzhConfig2;
        } catch (Exception e) {
            e.getMessage();
            return new GzhConfig();
        }
    }
}
