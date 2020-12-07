package com.wpengapp.support;

import java.io.IOException;

/* renamed from: com.wpengapp.support.ଵ */
/* compiled from: AsyncTimeout */
public class C1144 implements Sink {

    /* renamed from: ֏ */
    public final /* synthetic */ Sink f3244;

    /* renamed from: ؠ */
    public final /* synthetic */ AsyncTimeout f3245;

    public C1144(AsyncTimeout r1, Sink r2) {
        this.f3245 = r1;
        this.f3244 = r2;
    }

    public void close() {
        this.f3245.mo8139();
        try {
            this.f3244.close();
            this.f3245.mo8138(true);
        } catch (IOException e) {
            e = e;
            AsyncTimeout r1 = this.f3245;
            if (r1.mo8140()) {
                e = r1.mo8136(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f3245.mo8138(false);
            throw th;
        }
    }

    public void flush() {
        this.f3245.mo8139();
        try {
            this.f3244.flush();
            this.f3245.mo8138(true);
        } catch (IOException e) {
            e = e;
            AsyncTimeout r1 = this.f3245;
            if (r1.mo8140()) {
                e = r1.mo8136(e);
            }
            throw e;
        } catch (Throwable th) {
            this.f3245.mo8138(false);
            throw th;
        }
    }

    public String toString() {
        return outline.m2546(outline.m2549("AsyncTimeout.sink("), (Object) this.f3244, ")");
    }

    /* renamed from: ֏ */
    public void mo7985(Buffer r7, long j) {
        C0751.m1966(r7.f2997, 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                Segment r2 = r7.f2996;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += (long) (r2.f3330 - r2.f3329);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    r2 = r2.f3333;
                }
                this.f3245.mo8139();
                try {
                    this.f3244.mo7985(r7, j2);
                    j -= j2;
                    this.f3245.mo8138(true);
                } catch (IOException e) {
                    e = e;
                    AsyncTimeout r8 = this.f3245;
                    if (r8.mo8140()) {
                        e = r8.mo8136(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    this.f3245.mo8138(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7986() {
        return this.f3245;
    }
}
