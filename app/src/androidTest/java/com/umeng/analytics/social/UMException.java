package com.umeng.analytics.social;

import android.support.p000v4.text.BidiFormatter;

/* renamed from: com.umeng.analytics.social.a */
public class UMException extends RuntimeException {

    /* renamed from: b */
    public static final long f235b = -4656673116019167471L;

    /* renamed from: a */
    public int f236a = 5000;

    /* renamed from: c */
    public String f237c = BidiFormatter.EMPTY_STRING;

    public UMException(int i, String str) {
        super(str);
        this.f236a = i;
        this.f237c = str;
    }

    /* renamed from: a */
    public int mo7394a() {
        return this.f236a;
    }

    public String getMessage() {
        return this.f237c;
    }

    public UMException(String str, Throwable th) {
        super(str, th);
        this.f237c = str;
    }

    public UMException(String str) {
        super(str);
        this.f237c = str;
    }
}
