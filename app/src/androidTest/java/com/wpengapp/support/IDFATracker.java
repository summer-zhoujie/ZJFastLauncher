package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.text.BidiFormatter;

/* renamed from: com.wpengapp.support.ӯ */
public class IDFATracker extends AbstractIdTracker {

    /* renamed from: ށ */
    public Context f1947;

    public IDFATracker(Context context) {
        super("idfa");
        this.f1947 = context;
    }

    /* renamed from: ؠ */
    public String mo8028() {
        String str;
        try {
            str = Utils.m1890(this.f1947).f3012;
        } catch (Exception unused) {
            str = null;
        }
        return str == null ? BidiFormatter.EMPTY_STRING : str;
    }
}
