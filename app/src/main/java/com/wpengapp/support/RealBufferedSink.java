package com.wpengapp.support;

import java.nio.ByteBuffer;

/* renamed from: com.wpengapp.support.Ќ */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: ֏ */
    public final Buffer f1783 = new Buffer();

    /* renamed from: ؠ */
    public final Sink f1784;

    /* renamed from: ހ */
    public boolean f1785;

    public RealBufferedSink(Sink r2) {
        if (r2 != null) {
            this.f1784 = r2;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public void close() {
        if (!this.f1785) {
            try {
                if (this.f1783.f2997 > 0) {
                    this.f1784.mo7985(this.f1783, this.f1783.f2997);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f1784.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f1785 = true;
            if (th != null) {
                C0751.m1967(th);
                throw null;
            }
        }
    }

    public void flush() {
        if (!this.f1785) {
            Buffer r0 = this.f1783;
            long j = r0.f2997;
            if (j > 0) {
                this.f1784.mo7985(r0, j);
            }
            this.f1784.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f1785;
    }

    public String toString() {
        return outline.m2546(outline.m2549("buffer("), (Object) this.f1784, ")");
    }

    public BufferedSink write(byte[] bArr) {
        if (!this.f1785) {
            this.f1783.write(bArr);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeByte(int i) {
        if (!this.f1785) {
            this.f1783.writeByte(i);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i) {
        if (!this.f1785) {
            this.f1783.writeInt(i);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i) {
        if (!this.f1785) {
            this.f1783.writeShort(i);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: ֏ */
    public Buffer mo8112() {
        return this.f1783;
    }

    /* renamed from: ؠ */
    public C1166 mo7986() {
        return this.f1784.mo7986();
    }

    /* renamed from: ހ */
    public BufferedSink mo8113(long j) {
        if (!this.f1785) {
            this.f1783.mo8113(j);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: ֏ */
    public void mo7985(Buffer r2, long j) {
        if (!this.f1785) {
            this.f1783.mo7985(r2, j);
            mo8463();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.f1785) {
            int write = this.f1783.write(byteBuffer);
            mo8463();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: ހ */
    public BufferedSink mo8463() {
        if (!this.f1785) {
            Buffer r0 = this.f1783;
            long j = r0.f2997;
            if (j == 0) {
                j = 0;
            } else {
                Segment r02 = r0.f2996.f3334;
                int i = r02.f3330;
                if (i < 8192 && r02.f3332) {
                    j -= (long) (i - r02.f3329);
                }
            }
            if (j > 0) {
                this.f1784.mo7985(this.f1783, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: ֏ */
    public BufferedSink mo8111(String str) {
        if (!this.f1785) {
            this.f1783.mo8111(str);
            mo8463();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
