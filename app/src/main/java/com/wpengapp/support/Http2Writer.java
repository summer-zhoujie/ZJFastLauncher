package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.wpengapp.support.แ */
public final class Http2Writer implements Closeable {

    /* renamed from: ֏ */
    public static final Logger f3449 = Logger.getLogger(Http2.class.getName());

    /* renamed from: ؠ */
    public final BufferedSink f3450;

    /* renamed from: ހ */
    public final boolean f3451;

    /* renamed from: ށ */
    public final Buffer f3452 = new Buffer();

    /* renamed from: ނ */
    public int f3453 = 16384;

    /* renamed from: ރ */
    public boolean f3454;

    /* renamed from: ބ */
    public final Hpack.C0636 f3455 = new Hpack.C0636(this.f3452);

    public Http2Writer(BufferedSink r1, boolean z) {
        this.f3450 = r1;
        this.f3451 = z;
    }

    public synchronized void close() {
        this.f3454 = true;
        this.f3450.close();
    }

    public synchronized void flush() {
        if (!this.f3454) {
            this.f3450.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9452(Settings r5) {
        if (!this.f3454) {
            int i = this.f3453;
            if ((r5.f3799 & 32) != 0) {
                i = r5.f3800[5];
            }
            this.f3453 = i;
            int i2 = -1;
            if (((r5.f3799 & 2) != 0 ? r5.f3800[1] : -1) != -1) {
                Hpack.C0636 r0 = this.f3455;
                if ((r5.f3799 & 2) != 0) {
                    i2 = r5.f3800[1];
                }
                r0.mo8388(i2);
            }
            mo9447(0, 0, (byte) 4, (byte) 1);
            this.f3450.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ؠ */
    public synchronized void mo9458(Settings r7) {
        if (!this.f3454) {
            mo9447(0, Integer.bitCount(r7.f3799) * 6, (byte) 4, (byte) 0);
            int i = 0;
            while (i < 10) {
                boolean z = true;
                if (((1 << i) & r7.f3799) == 0) {
                    z = false;
                }
                if (z) {
                    this.f3450.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f3450.writeInt(r7.f3800[i]);
                }
                i++;
            }
            this.f3450.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: އ */
    public synchronized void mo9459() {
        if (this.f3454) {
            throw new IOException("closed");
        } else if (this.f3451) {
            if (f3449.isLoggable(Level.FINE)) {
                f3449.fine(Util.m937(">> CONNECTION %s", Http2.f1794.mo7999()));
            }
            this.f3450.write(Http2.f1794.mo8004());
            this.f3450.flush();
        }
    }

    /* renamed from: ؠ */
    public final void mo9457(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f3453, j);
            long j2 = (long) min;
            j -= j2;
            mo9447(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f3450.mo7985(this.f3452, j2);
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9448(int i, int i2, List<Header> list) {
        if (!this.f3454) {
            this.f3455.mo8387(list);
            long j = this.f3452.f2997;
            int min = (int) Math.min((long) (this.f3453 - 4), j);
            long j2 = (long) min;
            int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            mo9447(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.f3450.writeInt(i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f3450.mo7985(this.f3452, j2);
            if (i3 > 0) {
                mo9457(i, j - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9454(boolean z, int i, int i2, List<Header> list) {
        if (!this.f3454) {
            mo9456(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9450(int i, C1193 r5) {
        if (this.f3454) {
            throw new IOException("closed");
        } else if (r5.f3406 != -1) {
            mo9447(i, 4, (byte) 3, (byte) 0);
            this.f3450.writeInt(r5.f3406);
            this.f3450.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9455(boolean z, int i, Buffer r5, int i2) {
        if (!this.f3454) {
            mo9447(i, i2, (byte) 0, z ? (byte) 1 : 0);
            if (i2 > 0) {
                this.f3450.mo7985(r5, (long) i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9453(boolean z, int i, int i2) {
        if (!this.f3454) {
            mo9447(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f3450.writeInt(i);
            this.f3450.writeInt(i2);
            this.f3450.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9451(int i, C1193 r5, byte[] bArr) {
        if (this.f3454) {
            throw new IOException("closed");
        } else if (r5.f3406 != -1) {
            mo9447(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f3450.writeInt(i);
            this.f3450.writeInt(r5.f3406);
            if (bArr.length > 0) {
                this.f3450.write(bArr);
            }
            this.f3450.flush();
        } else {
            Http2.m1760("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    /* renamed from: ֏ */
    public synchronized void mo9449(int i, long j) {
        if (this.f3454) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            Http2.m1760("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            mo9447(i, 4, (byte) 8, (byte) 0);
            this.f3450.writeInt((int) j);
            this.f3450.flush();
        }
    }

    /* renamed from: ֏ */
    public void mo9447(int i, int i2, byte b, byte b2) {
        if (f3449.isLoggable(Level.FINE)) {
            f3449.fine(Http2.m1761(false, i, i2, b, b2));
        }
        int i3 = this.f3453;
        if (i2 > i3) {
            Http2.m1760("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            BufferedSink r0 = this.f3450;
            r0.writeByte((i2 >>> 16) & 255);
            r0.writeByte((i2 >>> 8) & 255);
            r0.writeByte(i2 & 255);
            this.f3450.writeByte(b & 255);
            this.f3450.writeByte(b2 & 255);
            this.f3450.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        } else {
            Http2.m1760("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: ֏ */
    public void mo9456(boolean z, int i, List<Header> list) {
        if (!this.f3454) {
            this.f3455.mo8387(list);
            long j = this.f3452.f2997;
            int min = (int) Math.min((long) this.f3453, j);
            long j2 = (long) min;
            int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo9447(i, min, (byte) 1, b);
            this.f3450.mo7985(this.f3452, j2);
            if (i2 > 0) {
                mo9457(i, j - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
