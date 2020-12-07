package com.wpengapp.support;

import java.util.List;

/* renamed from: com.wpengapp.support.इ */
public final class FormBody extends RequestBody {

    /* renamed from: ֏ */
    public static final MediaType f2884 = MediaType.m2278("application/x-www-form-urlencoded");

    /* renamed from: ؠ */
    public final List<String> f2885;

    /* renamed from: ހ */
    public final List<String> f2886;

    public FormBody(List<String> list, List<String> list2) {
        this.f2885 = Util.m940(list);
        this.f2886 = Util.m940(list2);
    }

    /* renamed from: ֏ */
    public long mo8941() {
        return mo9109((BufferedSink) null, true);
    }

    /* renamed from: ؠ */
    public MediaType mo8943() {
        return f2884;
    }

    /* renamed from: ֏ */
    public void mo8942(BufferedSink r2) {
        mo9109(r2, false);
    }

    /* renamed from: ֏ */
    public final long mo9109(BufferedSink r4, boolean z) {
        Buffer r42;
        if (z) {
            r42 = new Buffer();
        } else {
            r42 = r4.mo8112();
        }
        int size = this.f2885.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                r42.writeByte(38);
            }
            r42.mo8111(this.f2885.get(i));
            r42.writeByte(61);
            r42.mo8111(this.f2886.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = r42.f2997;
        r42.mo9201();
        return j;
    }
}
