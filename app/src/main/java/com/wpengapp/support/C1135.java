package com.wpengapp.support;

import com.wpengapp.support.C0586;
import java.io.IOException;

/* renamed from: com.wpengapp.support.ଡ */
/* compiled from: Http2Connection */
class C1135 extends NamedRunnable {

    /* renamed from: ؠ */
    public final /* synthetic */ Http2Stream f3221;

    /* renamed from: ހ */
    public final /* synthetic */ C0586.C0590 f3222;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1135(C0586.C0590 r1, String str, Object[] objArr, Http2Stream r4) {
        super(str, objArr);
        this.f3222 = r1;
        this.f3221 = r4;
    }

    /* renamed from: ֏ */
    public void mo8071() {
        try {
            C0586.this.f1280.mo8245(this.f3221);
        } catch (IOException e) {
            Platform r1 = Platform.f1792;
            StringBuilder r3 = outline.m2549("Http2Connection.Listener failure for ");
            r3.append(C0586.this.f1282);
            r1.mo8437(4, r3.toString(), (Throwable) e);
            try {
                this.f3221.mo8121(C1193.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
