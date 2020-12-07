package com.wpengapp.support;

import android.support.p003v7.widget.RecyclerView;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.Я */
/* compiled from: RealBufferedSource */
public final class C0697 implements BufferedSource {

    /* renamed from: ֏ */
    public final Buffer f1806 = new Buffer();

    /* renamed from: ؠ */
    public final Source f1807;

    /* renamed from: ހ */
    public boolean f1808;

    public C0697(Source r2) {
        if (r2 != null) {
            this.f1807 = r2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void close() {
        if (!this.f1808) {
            this.f1808 = true;
            this.f1807.close();
            this.f1806.mo9201();
        }
    }

    public boolean isOpen() {
        return !this.f1808;
    }

    public int read(ByteBuffer byteBuffer) {
        Buffer r0 = this.f1806;
        int i = -1;
        if (r0.f2997 == 0 && this.f1807.mo8055(r0, 8192) == -1) {
            return -1;
        }
        Buffer r02 = this.f1806;
        Segment r1 = r02.f2996;
        if (r1 != null) {
            i = Math.min(byteBuffer.remaining(), r1.f3330 - r1.f3329);
            byteBuffer.put(r1.f3328, r1.f3329, i);
            r1.f3329 += i;
            r02.f2997 -= (long) i;
            if (r1.f3329 == r1.f3330) {
                r02.f2996 = r1.mo9380();
                SegmentPool.m1854(r1);
            }
        }
        return i;
    }

    public byte readByte() {
        mo8496(1);
        return this.f1806.readByte();
    }

    public void readFully(byte[] bArr) {
        try {
            mo8496((long) bArr.length);
            this.f1806.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer r2 = this.f1806;
                long j = r2.f2997;
                if (j > 0) {
                    int r22 = r2.mo9189(bArr, i, (int) j);
                    if (r22 != -1) {
                        i += r22;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    public int readInt() {
        mo8496(4);
        return this.f1806.readInt();
    }

    public short readShort() {
        mo8496(2);
        return this.f1806.readShort();
    }

    public void skip(long j) {
        if (!this.f1808) {
            while (j > 0) {
                Buffer r2 = this.f1806;
                if (r2.f2997 == 0 && this.f1807.mo8055(r2, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f1806.f2997);
                this.f1806.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return outline.m2546(outline.m2549("buffer("), (Object) this.f1807, ")");
    }

    /* renamed from: ֏ */
    public Buffer mo8487() {
        return this.f1806;
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r7, long j) {
        if (r7 == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f1808) {
            Buffer r2 = this.f1806;
            if (r2.f2997 == 0 && this.f1807.mo8055(r2, 8192) == -1) {
                return -1;
            }
            return this.f1806.mo8055(r7, Math.min(j, this.f1806.f2997));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: ހ */
    public boolean mo8491(long j) {
        Buffer r0;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f1808) {
            do {
                r0 = this.f1806;
                if (r0.f2997 >= j) {
                    return true;
                }
            } while (this.f1807.mo8055(r0, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: ށ */
    public boolean mo8493() {
        if (!this.f1808) {
            return this.f1806.mo8493() && this.f1807.mo8055(this.f1806, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: ނ */
    public void mo8496(long j) {
        if (!mo8491(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: ރ */
    public int mo8497() {
        mo8496(4);
        return C0751.m1964(this.f1806.readInt());
    }

    /* renamed from: ބ */
    public short mo8498() {
        mo8496(2);
        return C0751.m1965(this.f1806.readShort());
    }

    /* renamed from: ޅ */
    public long mo8499() {
        byte b;
        byte b2;
        byte b3;
        int i;
        int i2;
        mo8496(1);
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            b = 102;
            b2 = 65;
            b3 = 57;
            if (!mo8491((long) i4)) {
                break;
            }
            byte r4 = this.f1806.mo9199((long) i3);
            if ((r4 >= 48 && r4 <= 57) || ((r4 >= 97 && r4 <= 102) || (r4 >= 65 && r4 <= 70))) {
                i3 = i4;
            } else if (i3 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(r4)}));
            }
        }
        Buffer r2 = this.f1806;
        long j = 0;
        if (r2.f2997 != 0) {
            int i5 = 0;
            while (true) {
                Segment r42 = r2.f2996;
                byte[] bArr = r42.f3328;
                int i6 = r42.f3329;
                int i7 = r42.f3330;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    byte b4 = bArr[i6];
                    if (b4 < 48 || b4 > b3) {
                        if (b4 >= 97 && b4 <= b) {
                            i2 = b4 - 97;
                        } else if (b4 >= b2 && b4 <= 70) {
                            i2 = b4 - 65;
                        } else if (i5 != 0) {
                            z = true;
                        } else {
                            StringBuilder r22 = outline.m2549("Expected leading [0-9a-fA-F] character but was 0x");
                            r22.append(Integer.toHexString(b4));
                            throw new NumberFormatException(r22.toString());
                        }
                        i = i2 + 10;
                    } else {
                        i = b4 - 48;
                    }
                    if ((j & -1152921504606846976L) == 0) {
                        j = (j << 4) | ((long) i);
                        i6++;
                        i5++;
                        b = 102;
                        b2 = 65;
                        b3 = 57;
                    } else {
                        Buffer r1 = new Buffer();
                        r1.mo8113(j);
                        r1.writeByte((int) b4);
                        StringBuilder r3 = outline.m2549("Number too large: ");
                        r3.append(r1.mo9203());
                        throw new NumberFormatException(r3.toString());
                    }
                }
                if (i6 == i7) {
                    r2.f2996 = r42.mo9380();
                    SegmentPool.m1854(r42);
                } else {
                    r42.f3329 = i6;
                }
                if (z || r2.f2996 == null) {
                    r2.f2997 -= (long) i5;
                } else {
                    b = 102;
                    b2 = 65;
                    b3 = 57;
                }
            }
            r2.f2997 -= (long) i5;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: ކ */
    public InputStream mo8500() {
        return new RealBufferedSource(this);
    }

    /* renamed from: ֏ */
    public ByteString mo8486(long j) {
        if (mo8491(j)) {
            return this.f1806.mo8486(j);
        }
        throw new EOFException();
    }

    /* renamed from: ނ */
    public String mo8495() {
        long r0 = mo8485((byte) 10, 0, RecyclerView.FOREVER_NS);
        if (r0 != -1) {
            return this.f1806.mo9200(r0);
        }
        Buffer r02 = new Buffer();
        Buffer r1 = this.f1806;
        r1.mo9193(r02, 0, Math.min(32, r1.f2997));
        StringBuilder r2 = outline.m2549("\\n not found: limit=");
        r2.append(Math.min(this.f1806.f2997, RecyclerView.FOREVER_NS));
        r2.append(" content=");
        r2.append(r02.mo9202().mo7999());
        r2.append(8230);
        throw new EOFException(r2.toString());
    }

    /* renamed from: ށ */
    public byte[] mo8494(long j) {
        if (mo8491(j)) {
            return this.f1806.mo8494(j);
        }
        throw new EOFException();
    }

    /* renamed from: ֏ */
    public String mo8488(Charset charset) {
        if (charset != null) {
            this.f1806.mo9191(this.f1807);
            return this.f1806.mo8488(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: ހ */
    public byte[] mo8492() {
        this.f1806.mo9191(this.f1807);
        return this.f1806.mo8492();
    }

    /* renamed from: ֏ */
    public long mo8484(byte b) {
        return mo8485(b, 0, RecyclerView.FOREVER_NS);
    }

    /* renamed from: ֏ */
    public long mo8485(byte b, long j, long j2) {
        if (this.f1808) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long r0 = this.f1806.mo9190(b, j, j2);
                if (r0 == -1) {
                    Buffer r02 = this.f1806;
                    long j3 = r02.f2997;
                    if (j3 >= j2 || this.f1807.mo8055(r02, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return r0;
                }
            }
            return -1;
        }
    }

    /* renamed from: ؠ */
    public String mo8490(long j) {
        if (j >= 0) {
            long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
            long r6 = mo8485((byte) 10, 0, j2);
            if (r6 != -1) {
                return this.f1806.mo9200(r6);
            }
            if (j2 < RecyclerView.FOREVER_NS && mo8491(j2) && this.f1806.mo9199(j2 - 1) == 13 && mo8491(1 + j2) && this.f1806.mo9199(j2) == 10) {
                return this.f1806.mo9200(j2);
            }
            Buffer r62 = new Buffer();
            Buffer r0 = this.f1806;
            r0.mo9193(r62, 0, Math.min(32, r0.f2997));
            StringBuilder r1 = outline.m2549("\\n not found: limit=");
            r1.append(Math.min(this.f1806.f2997, j));
            r1.append(" content=");
            r1.append(r62.mo9202().mo7999());
            r1.append(8230);
            throw new EOFException(r1.toString());
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* renamed from: ֏ */
    public boolean mo8489(long j, ByteString r11) {
        int r0 = r11.mo8002();
        if (this.f1808) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || r0 < 0 || r11.mo8002() - 0 < r0) {
            return false;
        } else {
            for (int i = 0; i < r0; i++) {
                long j2 = ((long) i) + j;
                if (!mo8491(1 + j2) || this.f1806.mo9199(j2) != r11.mo7992(0 + i)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return this.f1807.mo7988();
    }
}
