package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ภ */
/* compiled from: ErrorCode */
public enum C1193 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: ފ */
    public final int f3406;

    /* access modifiers changed from: public */
    C1193(int i) {
        this.f3406 = i;
    }

    /* renamed from: ֏ */
    public static C1193 m3222(int i) {
        for (C1193 r3 : values()) {
            if (r3.f3406 == i) {
                return r3;
            }
        }
        return null;
    }
}
