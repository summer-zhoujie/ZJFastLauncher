package com.wpengapp.support;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.wpengapp.support.ɕ */
public final class InflaterSource implements Source {

    /* renamed from: ֏ */
    public final BufferedSource f1230;

    /* renamed from: ؠ */
    public final Inflater f1231;

    /* renamed from: ހ */
    public int f1232;

    /* renamed from: ށ */
    public boolean f1233;

    public InflaterSource(BufferedSource r1, Inflater inflater) {
        if (r1 == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f1230 = r1;
            this.f1231 = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public void close() {
        if (!this.f1233) {
            this.f1231.end();
            this.f1233 = true;
            this.f1230.close();
        }
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r7, long j) {
        Segment r0;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f1233) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean z = false;
                if (this.f1231.needsInput()) {
                    mo8198();
                    if (this.f1231.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f1230.mo8493()) {
                        z = true;
                    } else {
                        Segment r02 = this.f1230.mo8487().f2996;
                        int i2 = r02.f3330;
                        int i3 = r02.f3329;
                        this.f1232 = i2 - i3;
                        this.f1231.setInput(r02.f3328, i3, this.f1232);
                    }
                }
                try {
                    r0 = r7.mo9195(1);
                    int inflate = this.f1231.inflate(r0.f3328, r0.f3330, (int) Math.min(j, (long) (8192 - r0.f3330)));
                    if (inflate > 0) {
                        r0.f3330 += inflate;
                        long j2 = (long) inflate;
                        r7.f2997 += j2;
                        return j2;
                    } else if (this.f1231.finished()) {
                        break;
                    } else if (this.f1231.needsDictionary()) {
                        break;
                    } else if (z) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            mo8198();
            if (r0.f3329 != r0.f3330) {
                return -1;
            }
            r7.f2996 = r0.mo9380();
            SegmentPool.m1854(r0);
            return -1;
        }
    }

    /* renamed from: އ */
    public final void mo8198() {
        int i = this.f1232;
        if (i != 0) {
            int remaining = i - this.f1231.getRemaining();
            this.f1232 -= remaining;
            this.f1230.skip((long) remaining);
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f1230.mo7988();
    }
}
