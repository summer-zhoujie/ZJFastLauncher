package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.RecyclerView;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* renamed from: com.wpengapp.support.উ */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: ֏ */
    public static final byte[] f2995 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: ؠ */
    public Segment f2996;

    /* renamed from: ހ */
    public long f2997;

    public Object clone() {
        Buffer r0 = new Buffer();
        if (this.f2997 != 0) {
            r0.f2996 = this.f2996.mo9384();
            Segment r1 = r0.f2996;
            r1.f3334 = r1;
            r1.f3333 = r1;
            Segment r12 = this.f2996;
            while (true) {
                r12 = r12.f3333;
                if (r12 == this.f2996) {
                    break;
                }
                r0.f2996.f3334.mo9382(r12.mo9384());
            }
            r0.f2997 = this.f2997;
        }
        return r0;
    }

    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer r14 = (Buffer) obj;
        long j = this.f2997;
        if (j != r14.f2997) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment r1 = this.f2996;
        Segment r142 = r14.f2996;
        int i = r1.f3329;
        int i2 = r142.f3329;
        while (j2 < this.f2997) {
            long min = (long) Math.min(r1.f3330 - i, r142.f3330 - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (r1.f3328[i4] != r142.f3328[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == r1.f3330) {
                r1 = r1.f3333;
                i = r1.f3329;
            } else {
                i = i4;
            }
            if (i3 == r142.f3330) {
                r142 = r142.f3333;
                i2 = r142.f3329;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public void flush() {
    }

    public int hashCode() {
        Segment r0 = this.f2996;
        if (r0 == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = r0.f3330;
            for (int i3 = r0.f3329; i3 < i2; i3++) {
                i = (i * 31) + r0.f3328[i3];
            }
            r0 = r0.f3333;
        } while (r0 != this.f2996);
        return i;
    }

    public boolean isOpen() {
        return true;
    }

    public int read(ByteBuffer byteBuffer) {
        Segment r0 = this.f2996;
        if (r0 == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), r0.f3330 - r0.f3329);
        byteBuffer.put(r0.f3328, r0.f3329, min);
        r0.f3329 += min;
        this.f2997 -= (long) min;
        if (r0.f3329 == r0.f3330) {
            this.f2996 = r0.mo9380();
            SegmentPool.m1854(r0);
        }
        return min;
    }

    public byte readByte() {
        long j = this.f2997;
        if (j != 0) {
            Segment r2 = this.f2996;
            int i = r2.f3329;
            int i2 = r2.f3330;
            int i3 = i + 1;
            byte b = r2.f3328[i];
            this.f2997 = j - 1;
            if (i3 == i2) {
                this.f2996 = r2.mo9380();
                SegmentPool.m1854(r2);
            } else {
                r2.f3329 = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int r1 = mo9189(bArr, i, bArr.length - i);
            if (r1 != -1) {
                i += r1;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        long j = this.f2997;
        if (j >= 4) {
            Segment r4 = this.f2996;
            int i = r4.f3329;
            int i2 = r4.f3330;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = r4.f3328;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f2997 = j - 4;
            if (i6 == i2) {
                this.f2996 = r4.mo9380();
                SegmentPool.m1854(r4);
            } else {
                r4.f3329 = i6;
            }
            return b3;
        }
        StringBuilder r1 = outline.m2549("size < 4: ");
        r1.append(this.f2997);
        throw new IllegalStateException(r1.toString());
    }

    public short readShort() {
        long j = this.f2997;
        if (j >= 2) {
            Segment r4 = this.f2996;
            int i = r4.f3329;
            int i2 = r4.f3330;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = r4.f3328;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f2997 = j - 2;
            if (i4 == i2) {
                this.f2996 = r4.mo9380();
                SegmentPool.m1854(r4);
            } else {
                r4.f3329 = i4;
            }
            return (short) b;
        }
        StringBuilder r1 = outline.m2549("size < 2: ");
        r1.append(this.f2997);
        throw new IllegalStateException(r1.toString());
    }

    public void skip(long j) {
        while (j > 0) {
            Segment r0 = this.f2996;
            if (r0 != null) {
                int min = (int) Math.min(j, (long) (r0.f3330 - r0.f3329));
                long j2 = (long) min;
                this.f2997 -= j2;
                j -= j2;
                Segment r02 = this.f2996;
                r02.f3329 += min;
                if (r02.f3329 == r02.f3330) {
                    this.f2996 = r02.mo9380();
                    SegmentPool.m1854(r02);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public String toString() {
        ByteString r0;
        long j = this.f2997;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                r0 = ByteString.f2163;
            } else {
                r0 = new SegmentedByteString(this, i);
            }
            return r0.toString();
        }
        StringBuilder r1 = outline.m2549("size > Integer.MAX_VALUE: ");
        r1.append(this.f2997);
        throw new IllegalArgumentException(r1.toString());
    }

    /* renamed from: ֏ */
    public Buffer mo8487() {
        return this;
    }

    /* renamed from: ؠ */
    public String mo8490(long j) {
        if (j >= 0) {
            long j2 = RecyclerView.FOREVER_NS;
            if (j != RecyclerView.FOREVER_NS) {
                j2 = j + 1;
            }
            long r4 = mo9190((byte) 10, 0, j2);
            if (r4 != -1) {
                return mo9200(r4);
            }
            if (j2 < this.f2997 && mo9199(j2 - 1) == 13 && mo9199(j2) == 10) {
                return mo9200(j2);
            }
            Buffer r6 = new Buffer();
            mo9193(r6, 0, Math.min(32, this.f2997));
            StringBuilder r1 = outline.m2549("\\n not found: limit=");
            r1.append(Math.min(this.f2997, j));
            r1.append(" content=");
            r1.append(r6.mo9202().mo7999());
            r1.append(8230);
            throw new EOFException(r1.toString());
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* renamed from: ށ */
    public boolean mo8493() {
        return this.f2997 == 0;
    }

    /* renamed from: ނ */
    public void mo8496(long j) {
        if (this.f2997 < j) {
            throw new EOFException();
        }
    }

    /* renamed from: ރ */
    public final byte mo9199(long j) {
        int i;
        C0751.m1966(this.f2997, j, 1);
        long j2 = this.f2997;
        if (j2 - j > j) {
            Segment r0 = this.f2996;
            while (true) {
                int i2 = r0.f3330;
                int i3 = r0.f3329;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return r0.f3328[i3 + ((int) j)];
                }
                j -= j3;
                r0 = r0.f3333;
            }
        } else {
            long j4 = j - j2;
            Segment r02 = this.f2996;
            do {
                r02 = r02.f3334;
                int i4 = r02.f3330;
                i = r02.f3329;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return r02.f3328[i + ((int) j4)];
        }
    }

    /* renamed from: ބ */
    public short mo8498() {
        return C0751.m1965(readShort());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r8 != r9) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        r15.f2996 = r6.mo9380();
        com.wpengapp.support.SegmentPool.m1854(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r6.f3329 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r0 != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[SYNTHETIC] */
    /* renamed from: ޅ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo8499() {
        /*
            r15 = this;
            long r0 = r15.f2997
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a1
            r0 = 0
            r1 = 0
            r4 = r2
        L_0x000b:
            com.wpengapp.support.ഒ r6 = r15.f2996
            byte[] r7 = r6.f3328
            int r8 = r6.f3329
            int r9 = r6.f3330
        L_0x0013:
            if (r8 >= r9) goto L_0x0086
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0039
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -97
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006b
            r11 = 70
            if (r10 > r11) goto L_0x006b
            int r11 = r10 + -65
        L_0x0037:
            int r11 = r11 + 10
        L_0x0039:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0049
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0049:
            com.wpengapp.support.উ r0 = new com.wpengapp.support.উ
            r0.<init>()
            r0.mo8113((long) r4)
            r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = com.wpengapp.support.outline.m2549(r2)
            java.lang.String r0 = r0.mo9203()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006b:
            if (r1 == 0) goto L_0x006f
            r0 = 1
            goto L_0x0086
        L_0x006f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = com.wpengapp.support.outline.m2549(r1)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0086:
            if (r8 != r9) goto L_0x0092
            com.wpengapp.support.ഒ r7 = r6.mo9380()
            r15.f2996 = r7
            com.wpengapp.support.SegmentPool.m1854(r6)
            goto L_0x0094
        L_0x0092:
            r6.f3329 = r8
        L_0x0094:
            if (r0 != 0) goto L_0x009a
            com.wpengapp.support.ഒ r6 = r15.f2996
            if (r6 != 0) goto L_0x000b
        L_0x009a:
            long r2 = r15.f2997
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f2997 = r2
            return r4
        L_0x00a1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Buffer.mo8499():long");
    }

    /* renamed from: ކ */
    public InputStream mo8500() {
        return new C1162(this);
    }

    /* renamed from: އ */
    public final void mo9201() {
        try {
            skip(this.f2997);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: ވ */
    public ByteString mo9202() {
        return new ByteString(mo8492());
    }

    /* renamed from: މ */
    public String mo9203() {
        try {
            return mo9196(this.f2997, C0751.f1936);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            mo9198(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer writeByte(int i) {
        Segment r0 = mo9195(1);
        byte[] bArr = r0.f3328;
        int i2 = r0.f3330;
        r0.f3330 = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2997++;
        return this;
    }

    public Buffer writeInt(int i) {
        Segment r0 = mo9195(4);
        byte[] bArr = r0.f3328;
        int i2 = r0.f3330;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        r0.f3330 = i5 + 1;
        this.f2997 += 4;
        return this;
    }

    public Buffer writeShort(int i) {
        Segment r0 = mo9195(2);
        byte[] bArr = r0.f3328;
        int i2 = r0.f3330;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        r0.f3330 = i3 + 1;
        this.f2997 += 2;
        return this;
    }

    /* renamed from: ֏ */
    public final Buffer mo9193(Buffer r9, long j, long j2) {
        if (r9 != null) {
            C0751.m1966(this.f2997, j, j2);
            if (j2 == 0) {
                return this;
            }
            r9.f2997 += j2;
            Segment r2 = this.f2996;
            while (true) {
                int i = r2.f3330;
                int i2 = r2.f3329;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                r2 = r2.f3333;
            }
            while (j2 > 0) {
                Segment r3 = r2.mo9384();
                r3.f3329 = (int) (((long) r3.f3329) + j);
                r3.f3330 = Math.min(r3.f3329 + ((int) j2), r3.f3330);
                Segment r10 = r9.f2996;
                if (r10 == null) {
                    r3.f3334 = r3;
                    r3.f3333 = r3;
                    r9.f2996 = r3;
                } else {
                    r10.f3334.mo9382(r3);
                }
                j2 -= (long) (r3.f3330 - r3.f3329);
                r2 = r2.f3333;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: ހ */
    public byte[] mo8492() {
        try {
            return mo8494(this.f2997);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: ށ */
    public byte[] mo8494(long j) {
        C0751.m1966(this.f2997, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* renamed from: ނ */
    public String mo8495() {
        long r0 = mo9190((byte) 10, 0, (long) RecyclerView.FOREVER_NS);
        if (r0 != -1) {
            return mo9200(r0);
        }
        if (RecyclerView.FOREVER_NS < this.f2997 && mo9199(9223372036854775806L) == 13 && mo9199(RecyclerView.FOREVER_NS) == 10) {
            return mo9200(RecyclerView.FOREVER_NS);
        }
        Buffer r02 = new Buffer();
        mo9193(r02, 0, Math.min(32, this.f2997));
        StringBuilder r2 = outline.m2549("\\n not found: limit=");
        r2.append(Math.min(this.f2997, RecyclerView.FOREVER_NS));
        r2.append(" content=");
        r2.append(r02.mo9202().mo7999());
        r2.append(8230);
        throw new EOFException(r2.toString());
    }

    /* renamed from: ބ */
    public String mo9200(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (mo9199(j2) == 13) {
                String r7 = mo9196(j2, C0751.f1936);
                skip(2);
                return r7;
            }
        }
        String r72 = mo9196(j, C0751.f1936);
        skip(1);
        return r72;
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment r2 = mo9195(1);
                int min = Math.min(i, 8192 - r2.f3330);
                byteBuffer.get(r2.f3328, r2.f3330, min);
                i -= min;
                r2.f3330 += min;
            }
            this.f2997 += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: ހ */
    public Buffer m2817(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment r2 = mo9195(numberOfTrailingZeros);
        byte[] bArr = r2.f3328;
        int i = r2.f3330;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f2995[(int) (15 & j)];
            j >>>= 4;
        }
        r2.f3330 += numberOfTrailingZeros;
        this.f2997 += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: ރ */
    public int mo8497() {
        return C0751.m1964(readInt());
    }

    /* renamed from: ؠ */
    public Buffer mo9197(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            StringBuilder r1 = outline.m2549("Unexpected code point: ");
            r1.append(Integer.toHexString(i));
            throw new IllegalArgumentException(r1.toString());
        }
        return this;
    }

    /* renamed from: ֏ */
    public ByteString mo8486(long j) {
        return new ByteString(mo8494(j));
    }

    /* renamed from: ֏ */
    public String mo8488(Charset charset) {
        try {
            return mo9196(this.f2997, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: ֏ */
    public String mo9196(long j, Charset charset) {
        C0751.m1966(this.f2997, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return BidiFormatter.EMPTY_STRING;
        } else {
            Segment r0 = this.f2996;
            int i = r0.f3329;
            if (((long) i) + j > ((long) r0.f3330)) {
                return new String(mo8494(j), charset);
            }
            String str = new String(r0.f3328, i, (int) j, charset);
            r0.f3329 = (int) (((long) r0.f3329) + j);
            this.f2997 -= j;
            if (r0.f3329 == r0.f3330) {
                this.f2996 = r0.mo9380();
                SegmentPool.m1854(r0);
            }
            return str;
        }
    }

    /* renamed from: ؠ */
    public Buffer mo9198(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C0751.m1966((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment r0 = mo9195(1);
                int min = Math.min(i3 - i, 8192 - r0.f3330);
                System.arraycopy(bArr, i, r0.f3328, r0.f3330, min);
                i += min;
                r0.f3330 += min;
            }
            this.f2997 += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: ֏ */
    public int mo9189(byte[] bArr, int i, int i2) {
        C0751.m1966((long) bArr.length, (long) i, (long) i2);
        Segment r0 = this.f2996;
        if (r0 == null) {
            return -1;
        }
        int min = Math.min(i2, r0.f3330 - r0.f3329);
        System.arraycopy(r0.f3328, r0.f3329, bArr, i, min);
        r0.f3329 += min;
        this.f2997 -= (long) min;
        if (r0.f3329 == r0.f3330) {
            this.f2996 = r0.mo9380();
            SegmentPool.m1854(r0);
        }
        return min;
    }

    /* renamed from: ؠ */
    public long mo8055(Buffer r6, long j) {
        if (r6 == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f2997;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            r6.mo7985(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* renamed from: ؠ */
    public C1166 mo7988() {
        return C1166.f3323;
    }

    /* renamed from: ֏ */
    public Buffer mo9192(ByteString r2) {
        if (r2 != null) {
            r2.mo7995(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: ֏ */
    public Buffer m2804(String str) {
        mo9194(str, 0, str.length());
        return this;
    }

    /* renamed from: ֏ */
    public Buffer mo9194(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException(outline.m2543("beginIndex < 0: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    Segment r2 = mo9195(1);
                    byte[] bArr = r2.f3328;
                    int i3 = r2.f3330 - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = r2.f3330;
                            int i6 = (i3 + i) - i5;
                            r2.f3330 = i5 + i6;
                            this.f2997 += (long) i6;
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = r2.f3330;
                    int i62 = (i3 + i) - i52;
                    r2.f3330 = i52 + i62;
                    this.f2997 += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        writeByte((charAt2 >> 6) | 192);
                        writeByte((int) (charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        writeByte((charAt2 >> 12) | 224);
                        writeByte(((charAt2 >> 6) & 63) | 128);
                        writeByte((int) (charAt2 & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    /* renamed from: ֏ */
    public long mo9191(Source r8) {
        if (r8 != null) {
            long j = 0;
            while (true) {
                long r2 = r8.mo8055(this, 8192);
                if (r2 == -1) {
                    return j;
                }
                j += r2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: ֏ */
    public Segment mo9195(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment r1 = this.f2996;
        if (r1 == null) {
            this.f2996 = SegmentPool.m1853();
            Segment r4 = this.f2996;
            r4.f3334 = r4;
            r4.f3333 = r4;
            return r4;
        }
        Segment r12 = r1.f3334;
        if (r12.f3330 + i <= 8192 && r12.f3332) {
            return r12;
        }
        Segment r42 = SegmentPool.m1853();
        r12.mo9382(r42);
        return r42;
    }

    /* renamed from: ֏ */
    public void mo7985(Buffer r9, long j) {
        int i;
        if (r9 == null) {
            throw new IllegalArgumentException("source == null");
        } else if (r9 != this) {
            C0751.m1966(r9.f2997, 0, j);
            while (j > 0) {
                Segment r0 = r9.f2996;
                int i2 = 0;
                if (j < ((long) (r0.f3330 - r0.f3329))) {
                    Segment r02 = this.f2996;
                    Segment r03 = r02 != null ? r02.f3334 : null;
                    if (r03 != null && r03.f3332) {
                        long j2 = ((long) r03.f3330) + j;
                        if (r03.f3331) {
                            i = 0;
                        } else {
                            i = r03.f3329;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            r9.f2996.mo9383(r03, (int) j);
                            r9.f2997 -= j;
                            this.f2997 += j;
                            return;
                        }
                    }
                    r9.f2996 = r9.f2996.mo9381((int) j);
                }
                Segment r04 = r9.f2996;
                long j3 = (long) (r04.f3330 - r04.f3329);
                r9.f2996 = r04.mo9380();
                Segment r1 = this.f2996;
                if (r1 == null) {
                    this.f2996 = r04;
                    Segment r05 = this.f2996;
                    r05.f3334 = r05;
                    r05.f3333 = r05;
                } else {
                    r1.f3334.mo9382(r04);
                    Segment r12 = r04.f3334;
                    if (r12 == r04) {
                        throw new IllegalStateException();
                    } else if (r12.f3332) {
                        int i3 = r04.f3330 - r04.f3329;
                        int i4 = 8192 - r12.f3330;
                        if (!r12.f3331) {
                            i2 = r12.f3329;
                        }
                        if (i3 <= i4 + i2) {
                            r04.mo9383(r04.f3334, i3);
                            r04.mo9380();
                            SegmentPool.m1854(r04);
                        }
                    }
                }
                r9.f2997 -= j3;
                this.f2997 += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: ֏ */
    public long mo8484(byte b) {
        return mo9190(b, 0, (long) RecyclerView.FOREVER_NS);
    }

    /* renamed from: ֏ */
    public long mo9190(byte b, long j, long j2) {
        Segment r7;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f2997), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f2997;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (r7 = this.f2996) == null) {
            return -1;
        }
        long j5 = this.f2997;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (r7.f3330 - r7.f3329)) + j5;
                if (j3 >= j) {
                    break;
                }
                r7 = r7.f3333;
            }
        } else {
            while (j5 > j) {
                r7 = r7.f3334;
                j5 -= (long) (r7.f3330 - r7.f3329);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = r7.f3328;
            int min = (int) Math.min((long) r7.f3330, (((long) r7.f3329) + j4) - j5);
            for (int i = (int) ((((long) r7.f3329) + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - r7.f3329)) + j5;
                }
            }
            byte b2 = b;
            j6 = ((long) (r7.f3330 - r7.f3329)) + j5;
            r7 = r7.f3333;
            j5 = j6;
        }
        return -1;
    }

    /* renamed from: ֏ */
    public boolean mo8489(long j, ByteString r10) {
        int r0 = r10.mo8002();
        if (j < 0 || r0 < 0 || this.f2997 - j < ((long) r0) || r10.mo8002() - 0 < r0) {
            return false;
        }
        for (int i = 0; i < r0; i++) {
            if (mo9199(((long) i) + j) != r10.mo7992(0 + i)) {
                return false;
            }
        }
        return true;
    }
}
