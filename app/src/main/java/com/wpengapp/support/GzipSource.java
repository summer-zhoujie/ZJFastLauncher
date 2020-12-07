package com.wpengapp.support;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: com.wpengapp.support.ѝ */
public final class GzipSource implements Source {

    /* renamed from: ֏ */
    public int f1849 = 0;

    /* renamed from: ؠ */
    public final BufferedSource f1850;

    /* renamed from: ހ */
    public final Inflater f1851;

    /* renamed from: ށ */
    public final InflaterSource f1852;

    /* renamed from: ނ */
    public final CRC32 f1853 = new CRC32();

    public GzipSource(Source r3) {
        if (r3 != null) {
            this.f1851 = new Inflater(true);
            this.f1850 = C0745.m1951(r3);
            this.f1852 = new InflaterSource(this.f1850, this.f1851);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void close() {
        InflaterSource r0 = this.f1852;
        if (!r0.f1233) {
            r0.f1231.end();
            r0.f1233 = true;
            r0.f1230.close();
        }
    }

    /* renamed from: ֏ */
    public final void mo8526(Buffer r6, long j, long j2) {
        Segment r62 = r6.f2996;
        while (true) {
            int i = r62.f3330;
            int i2 = r62.f3329;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            r62 = r62.f3333;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) r62.f3329) + j);
            int min = (int) Math.min((long) (r62.f3330 - i3), j2);
            this.f1853.update(r62.f3328, i3, min);
            j2 -= (long) min;
            r62 = r62.f3333;
            j = 0;
        }
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r21, long j) {
        long j2;
        Buffer r7 = r21;
        long j3 = j;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j3);
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f1849 == 0) {
                this.f1850.mo8496(10);
                byte r13 = this.f1850.mo8487().mo9199(3);
                boolean z = ((r13 >> 1) & 1) == 1;
                if (z) {
                    mo8526(this.f1850.mo8487(), 0, 10);
                }
                mo8527("ID1ID2", 8075, (int) this.f1850.readShort());
                this.f1850.skip(8);
                if (((r13 >> 2) & 1) == 1) {
                    this.f1850.mo8496(2);
                    if (z) {
                        mo8526(this.f1850.mo8487(), 0, 2);
                    }
                    long r4 = (long) this.f1850.mo8487().mo8498();
                    this.f1850.mo8496(r4);
                    if (z) {
                        j2 = r4;
                        mo8526(this.f1850.mo8487(), 0, r4);
                    } else {
                        j2 = r4;
                    }
                    this.f1850.skip(j2);
                }
                if (((r13 >> 3) & 1) == 1) {
                    long r18 = this.f1850.mo8484((byte) 0);
                    if (r18 != -1) {
                        if (z) {
                            mo8526(this.f1850.mo8487(), 0, r18 + 1);
                        }
                        this.f1850.skip(r18 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((r13 >> 4) & 1) == 1) {
                    long r132 = this.f1850.mo8484((byte) 0);
                    if (r132 != -1) {
                        if (z) {
                            mo8526(this.f1850.mo8487(), 0, r132 + 1);
                        }
                        this.f1850.skip(r132 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    mo8527("FHCRC", (int) this.f1850.mo8498(), (int) (short) ((int) this.f1853.getValue()));
                    this.f1853.reset();
                }
                this.f1849 = 1;
            }
            if (this.f1849 == 1) {
                long j4 = r7.f2997;
                long r8 = this.f1852.mo8055(r7, j3);
                if (r8 != -1) {
                    mo8526(r21, j4, r8);
                    return r8;
                }
                this.f1849 = 2;
            }
            if (this.f1849 == 2) {
                mo8527("CRC", this.f1850.mo8497(), (int) this.f1853.getValue());
                mo8527("ISIZE", this.f1850.mo8497(), (int) this.f1851.getBytesWritten());
                this.f1849 = 3;
                if (!this.f1850.mo8493()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: ֏ */
    public final void mo8527(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f1850.mo7988();
    }
}
