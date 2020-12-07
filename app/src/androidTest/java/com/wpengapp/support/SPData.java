package com.wpengapp.support;

import java.io.Serializable;

/* renamed from: com.wpengapp.support.ত */
public class SPData implements Serializable {
    public static final long serialVersionUID = -6376078803512394312L;

    /* renamed from: ֏ */
    public String f3021;

    /* renamed from: ؠ */
    public Serializable f3022;

    public SPData(String str, Serializable serializable) {
        this.f3021 = str;
        this.f3022 = serializable;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("SPData{key='");
        r0.append(this.f3021);
        r0.append('\'');
        r0.append(", value=");
        r0.append(this.f3022);
        r0.append('}');
        return r0.toString();
    }
}
