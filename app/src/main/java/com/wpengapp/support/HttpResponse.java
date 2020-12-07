package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;

/* renamed from: com.wpengapp.support.ໂ */
public class HttpResponse<T> {

    /* renamed from: ֏ */
    public String f3513;

    /* renamed from: ؠ */
    public int f3514 = 400;

    /* renamed from: ހ */
    public int f3515 = -1;

    /* renamed from: ށ */
    public String f3516 = BidiFormatter.EMPTY_STRING;

    /* renamed from: ނ */
    public String f3517 = BidiFormatter.EMPTY_STRING;

    /* renamed from: ރ */
    public T f3518;

    /* renamed from: ބ */
    public String f3519 = BidiFormatter.EMPTY_STRING;

    public String toString() {
        StringBuilder r0 = outline.m2549("HttpResponse{url='");
        r0.append(this.f3513);
        r0.append('\'');
        r0.append(", statusCode=");
        r0.append(this.f3514);
        r0.append(", code=");
        r0.append(this.f3515);
        r0.append(", message='");
        r0.append(this.f3516);
        r0.append('\'');
        r0.append(", encrypt='");
        r0.append(this.f3517);
        r0.append('\'');
        r0.append(", data=");
        r0.append(this.f3518);
        r0.append('}');
        return r0.toString();
    }
}
