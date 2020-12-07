package com.wpengapp.support;

import com.wpengapp.support.Headers;
import java.io.Closeable;

/* renamed from: com.wpengapp.support.ʚ */
public final class Response implements Closeable {

    /* renamed from: ֏ */
    public final Request f1349;

    /* renamed from: ؠ */
    public final Protocol f1350;

    /* renamed from: ހ */
    public final int f1351;

    /* renamed from: ށ */
    public final String f1352;

    /* renamed from: ނ */
    public final Handshake f1353;

    /* renamed from: ރ */
    public final Headers f1354;

    /* renamed from: ބ */
    public final C1154 f1355;

    /* renamed from: ޅ */
    public final Response f1356;

    /* renamed from: ކ */
    public final Response f1357;

    /* renamed from: އ */
    public final Response f1358;

    /* renamed from: ވ */
    public final long f1359;

    /* renamed from: މ */
    public final long f1360;

    /* renamed from: com.wpengapp.support.ʚ$֏ */
    /* compiled from: Response */
    public static class C0600 {

        /* renamed from: ֏ */
        public Request f1361;

        /* renamed from: ؠ */
        public Protocol f1362;

        /* renamed from: ހ */
        public int f1363;

        /* renamed from: ށ */
        public String f1364;

        /* renamed from: ނ */
        public Handshake f1365;

        /* renamed from: ރ */
        public Headers.C0568 f1366;

        /* renamed from: ބ */
        public C1154 f1367;

        /* renamed from: ޅ */
        public Response f1368;

        /* renamed from: ކ */
        public Response f1369;

        /* renamed from: އ */
        public Response f1370;

        /* renamed from: ވ */
        public long f1371;

        /* renamed from: މ */
        public long f1372;

        public C0600() {
            this.f1363 = -1;
            this.f1366 = new Headers.C0568();
        }

        /* renamed from: ֏ */
        public C0600 mo8277(Headers r1) {
            this.f1366 = r1.mo8174();
            return this;
        }

        /* renamed from: ֏ */
        public C0600 mo8278(Response r2) {
            if (r2 != null) {
                mo8280("cacheResponse", r2);
            }
            this.f1369 = r2;
            return this;
        }

        public C0600(Response r3) {
            this.f1363 = -1;
            this.f1361 = r3.f1349;
            this.f1362 = r3.f1350;
            this.f1363 = r3.f1351;
            this.f1364 = r3.f1352;
            this.f1365 = r3.f1353;
            this.f1366 = r3.f1354.mo8174();
            this.f1367 = r3.f1355;
            this.f1368 = r3.f1356;
            this.f1369 = r3.f1357;
            this.f1370 = r3.f1358;
            this.f1371 = r3.f1359;
            this.f1372 = r3.f1360;
        }

        /* renamed from: ֏ */
        public final void mo8280(String str, Response r3) {
            if (r3.f1355 != null) {
                throw new IllegalArgumentException(outline.m2556(str, ".body != null"));
            } else if (r3.f1356 != null) {
                throw new IllegalArgumentException(outline.m2556(str, ".networkResponse != null"));
            } else if (r3.f1357 != null) {
                throw new IllegalArgumentException(outline.m2556(str, ".cacheResponse != null"));
            } else if (r3.f1358 != null) {
                throw new IllegalArgumentException(outline.m2556(str, ".priorResponse != null"));
            }
        }

        /* renamed from: ֏ */
        public Response mo8279() {
            if (this.f1361 == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f1362 == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f1363 < 0) {
                StringBuilder r1 = outline.m2549("code < 0: ");
                r1.append(this.f1363);
                throw new IllegalStateException(r1.toString());
            } else if (this.f1364 != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    public Response(C0600 r3) {
        this.f1349 = r3.f1361;
        this.f1350 = r3.f1362;
        this.f1351 = r3.f1363;
        this.f1352 = r3.f1364;
        this.f1353 = r3.f1365;
        this.f1354 = r3.f1366.mo8181();
        this.f1355 = r3.f1367;
        this.f1356 = r3.f1368;
        this.f1357 = r3.f1369;
        this.f1358 = r3.f1370;
        this.f1359 = r3.f1371;
        this.f1360 = r3.f1372;
    }

    public void close() {
        C1154 r0 = this.f1355;
        if (r0 != null) {
            Util.m946((Closeable) r0.mo7908());
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("Response{protocol=");
        r0.append(this.f1350);
        r0.append(", code=");
        r0.append(this.f1351);
        r0.append(", message=");
        r0.append(this.f1352);
        r0.append(", url=");
        r0.append(this.f1349.f2364);
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: އ */
    public C0600 mo8276() {
        return new C0600(this);
    }
}
