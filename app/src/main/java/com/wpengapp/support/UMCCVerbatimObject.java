package com.wpengapp.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.μ */
public class UMCCVerbatimObject implements Serializable {

    /* renamed from: ֏ */
    public List<String> f1673 = new ArrayList();

    /* renamed from: ؠ */
    public String f1674;

    /* renamed from: ހ */
    public long f1675;

    /* renamed from: ށ */
    public long f1676;

    public UMCCVerbatimObject(List<String> list, long j, String str, long j2) {
        this.f1673 = list;
        this.f1675 = j;
        this.f1674 = str;
        this.f1676 = j2;
        Utils.m1865(this.f1676);
    }

    /* renamed from: ֏ */
    public String mo8402() {
        return this.f1674;
    }

    /* renamed from: ؠ */
    public long mo8403() {
        return this.f1675;
    }
}
