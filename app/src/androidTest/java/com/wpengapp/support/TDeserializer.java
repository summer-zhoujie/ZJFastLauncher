package com.wpengapp.support;

/* renamed from: com.wpengapp.support.କ */
public class TDeserializer {

    /* renamed from: ֏ */
    public final TProtocol f3191;

    /* renamed from: ؠ */
    public final TMemoryInputTransport f3192;

    public TDeserializer() {
        this.f3192 = new TMemoryInputTransport();
        this.f3191 = new TCompactProtocol(this.f3192, -1);
    }

    /* renamed from: ֏ */
    public void mo9309(TBase r3, byte[] bArr) {
        try {
            this.f3192.mo9278(bArr);
            r3.mo9120(this.f3191);
        } finally {
            this.f3192.f3111 = null;
            this.f3191.mo8581();
        }
    }

    public TDeserializer(TProtocolFactory r2) {
        this.f3192 = new TMemoryInputTransport();
        this.f3191 = r2.mo9274(this.f3192);
    }
}
