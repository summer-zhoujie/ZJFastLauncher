package com.wpengapp.support;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.wpengapp.support.ߑ */
/* compiled from: BaseRequest */
public abstract class C0968<T> {

    /* renamed from: ֏ */
    public static final ExecutorService f2694 = Executors.newFixedThreadPool(20);

    /* renamed from: ؠ */
    public Call f2695;

    /* renamed from: ހ */
    public String f2696;

    /* renamed from: ށ */
    public String f2697;

    /* renamed from: ނ */
    public long f2698;

    public C0968(String str, String str2) {
        this.f2697 = str;
        this.f2696 = str2;
    }

    /* renamed from: ֏ */
    public abstract C0968 mo8757(boolean z);

    /* renamed from: ֏ */
    public abstract HttpResponse<T> mo8758(Response r1);

    /* renamed from: ֏ */
    public abstract void mo8759(HttpResponse<T> r1);

    /* renamed from: ֏ */
    public abstract void mo7981(Exception exc);
}
