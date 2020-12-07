package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.Č */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: ޅ */
    public final String f756;

    /* access modifiers changed from: public */
    Protocol(String str) {
        this.f756 = str;
    }

    /* renamed from: ֏ */
    public static Protocol m977(String str) {
        if (str.equals(HTTP_1_0.f756)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f756)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.f756)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.f756)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f756)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f756)) {
            return QUIC;
        }
        throw new IOException(outline.m2556("Unexpected protocol: ", str));
    }

    public String toString() {
        return this.f756;
    }
}
