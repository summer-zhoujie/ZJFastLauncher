package com.umeng.analytics.social;

import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.outline;

/* renamed from: com.umeng.analytics.social.d */
public class UMResult {

    /* renamed from: a */
    public int f238a = -1;

    /* renamed from: b */
    public String f239b = BidiFormatter.EMPTY_STRING;

    /* renamed from: c */
    public String f240c = BidiFormatter.EMPTY_STRING;

    /* renamed from: d */
    public Exception f241d = null;

    public UMResult(int i) {
        this.f238a = i;
    }

    /* renamed from: a */
    public Exception mo7396a() {
        return this.f241d;
    }

    /* renamed from: b */
    public int mo7399b() {
        return this.f238a;
    }

    /* renamed from: c */
    public String mo7401c() {
        return this.f239b;
    }

    /* renamed from: d */
    public String mo7402d() {
        return this.f240c;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("status=");
        r0.append(this.f238a);
        r0.append("\r\n");
        r0.append("msg:  ");
        r0.append(this.f239b);
        r0.append("\r\n");
        r0.append("data:  ");
        r0.append(this.f240c);
        return r0.toString();
    }

    /* renamed from: a */
    public void mo7397a(int i) {
        this.f238a = i;
    }

    /* renamed from: b */
    public void mo7400b(String str) {
        this.f240c = str;
    }

    /* renamed from: a */
    public void mo7398a(String str) {
        this.f239b = str;
    }

    public UMResult(int i, Exception exc) {
        this.f238a = i;
        this.f241d = exc;
    }
}
