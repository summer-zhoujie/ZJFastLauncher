package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.wpengapp.support.ຜ */
public class TCompactProtocol extends TProtocol {

    /* renamed from: ؠ */
    public static final TStruct f3480 = new TStruct(BidiFormatter.EMPTY_STRING);

    /* renamed from: ހ */
    public static final TField f3481 = new TField(BidiFormatter.EMPTY_STRING, (byte) 0, 0);

    /* renamed from: ށ */
    public static final byte[] f3482 = new byte[16];

    /* renamed from: ނ */
    public ShortStack f3483 = new ShortStack(15);

    /* renamed from: ރ */
    public short f3484 = 0;

    /* renamed from: ބ */
    public Boolean f3485 = null;

    /* renamed from: ޅ */
    public final long f3486;

    /* renamed from: ކ */
    public byte[] f3487 = new byte[5];

    /* renamed from: އ */
    public byte[] f3488 = new byte[10];

    /* renamed from: ވ */
    public byte[] f3489 = new byte[1];

    /* renamed from: މ */
    public byte[] f3490 = new byte[1];

    /* renamed from: com.wpengapp.support.ຜ$֏ */
    /* compiled from: TCompactProtocol */
    public static class C1221 implements TProtocolFactory {

        /* renamed from: ֏ */
        public final long f3491 = -1;

        /* renamed from: ֏ */
        public TProtocol mo9274(TTransport r4) {
            return new TCompactProtocol(r4, this.f3491);
        }
    }

    static {
        byte[] bArr = f3482;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public TCompactProtocol(TTransport r2, long j) {
        super(r2);
        this.f3486 = j;
    }

    /* renamed from: ֏ */
    public void mo8575(TStruct r2) {
        this.f3483.mo8954(this.f3484);
        this.f3484 = 0;
    }

    /* renamed from: ؠ */
    public void mo8581() {
        this.f3483.f2574 = -1;
        this.f3484 = 0;
    }

    /* renamed from: ހ */
    public final int mo9473(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: ށ */
    public void mo8583() {
        ShortStack r0 = this.f3483;
        short[] sArr = r0.f2573;
        int i = r0.f2574;
        r0.f2574 = i - 1;
        this.f3484 = sArr[i];
    }

    /* renamed from: ނ */
    public final int mo9475(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: ނ */
    public void mo8584() {
    }

    /* renamed from: ރ */
    public void mo8585() {
        mo9470((byte) 0);
    }

    /* renamed from: ބ */
    public void mo8586() {
    }

    /* renamed from: ޅ */
    public void mo8587() {
    }

    /* renamed from: ކ */
    public TStruct mo8588() {
        this.f3483.mo8954(this.f3484);
        this.f3484 = 0;
        return f3480;
    }

    /* renamed from: އ */
    public void mo8589() {
        ShortStack r0 = this.f3483;
        short[] sArr = r0.f2573;
        int i = r0.f2574;
        r0.f2574 = i - 1;
        this.f3484 = sArr[i];
    }

    /* renamed from: ވ */
    public TField mo8590() {
        short s;
        byte r0 = mo8599();
        if (r0 == 0) {
            return f3481;
        }
        short s2 = (short) ((r0 & 240) >> 4);
        if (s2 == 0) {
            s = (short) mo9475(mo9476());
        } else {
            s = (short) (this.f3484 + s2);
        }
        byte b = r0 & 15;
        byte b2 = (byte) b;
        TField r2 = new TField(BidiFormatter.EMPTY_STRING, mo9472(b2), s);
        if (b == 1 || b == 2) {
            this.f3485 = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f3484 = r2.f960;
        return r2;
    }

    /* renamed from: މ */
    public void mo8591() {
    }

    /* renamed from: ފ */
    public TMap mo8592() {
        byte b;
        int r0 = mo9476();
        if (r0 == 0) {
            b = 0;
        } else {
            b = mo8599();
        }
        return new TMap(mo9472((byte) (b >> 4)), mo9472((byte) (b & 15)), r0);
    }

    /* renamed from: ދ */
    public void mo8593() {
    }

    /* renamed from: ތ */
    public TList mo8594() {
        byte r0 = mo8599();
        int i = (r0 >> 4) & 15;
        if (i == 15) {
            i = mo9476();
        }
        return new TList(mo9472(r0), i);
    }

    /* renamed from: ލ */
    public void mo8595() {
    }

    /* renamed from: ގ */
    public TSet mo8596() {
        byte r1 = mo8599();
        int i = (r1 >> 4) & 15;
        if (i == 15) {
            i = mo9476();
        }
        return new TSet(mo9472(r1), i);
    }

    /* renamed from: ޏ */
    public void mo8597() {
    }

    /* renamed from: ސ */
    public boolean mo8598() {
        Boolean bool = this.f3485;
        if (bool == null) {
            return mo8599() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f3485 = null;
        return booleanValue;
    }

    /* renamed from: ޑ */
    public byte mo8599() {
        if (this.f1948.mo8021() > 0) {
            byte b = this.f1948.mo8018()[this.f1948.mo8019()];
            this.f1948.mo8016(1);
            return b;
        }
        this.f1948.mo8022(this.f3490, 0, 1);
        return this.f3490[0];
    }

    /* renamed from: ޒ */
    public short mo8600() {
        int r0 = mo9476();
        return (short) ((-(r0 & 1)) ^ (r0 >>> 1));
    }

    /* renamed from: ޓ */
    public int mo8601() {
        int r0 = mo9476();
        return (-(r0 & 1)) ^ (r0 >>> 1);
    }

    /* renamed from: ޔ */
    public long mo8602() {
        long j = 0;
        int i = 0;
        if (this.f1948.mo8021() >= 10) {
            byte[] r0 = this.f1948.mo8018();
            int r4 = this.f1948.mo8019();
            long j2 = 0;
            int i2 = 0;
            while (true) {
                byte b = r0[r4 + i];
                j2 |= ((long) (b & Byte.MAX_VALUE)) << i2;
                if ((b & 128) != 128) {
                    break;
                }
                i2 += 7;
                i++;
            }
            this.f1948.mo8016(i + 1);
            j = j2;
        } else {
            while (true) {
                byte r02 = mo8599();
                j |= ((long) (r02 & Byte.MAX_VALUE)) << i;
                if ((r02 & 128) != 128) {
                    break;
                }
                i += 7;
            }
        }
        return (j >>> 1) ^ (-(j & 1));
    }

    /* renamed from: ޕ */
    public double mo8603() {
        byte[] bArr = new byte[8];
        this.f1948.mo8022(bArr, 0, 8);
        return Double.longBitsToDouble((((long) bArr[0]) & 255) | ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8));
    }

    /* renamed from: ޖ */
    public String mo8604() {
        byte[] bArr;
        int r0 = mo9476();
        mo9474(r0);
        if (r0 == 0) {
            return BidiFormatter.EMPTY_STRING;
        }
        try {
            if (this.f1948.mo8021() >= r0) {
                String str = new String(this.f1948.mo8018(), this.f1948.mo8019(), r0, "UTF-8");
                this.f1948.mo8016(r0);
                return str;
            }
            if (r0 == 0) {
                bArr = new byte[0];
            } else {
                byte[] bArr2 = new byte[r0];
                this.f1948.mo8022(bArr2, 0, r0);
                bArr = bArr2;
            }
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    /* renamed from: ޗ */
    public final int mo9476() {
        int i = 0;
        if (this.f1948.mo8021() >= 5) {
            byte[] r0 = this.f1948.mo8018();
            int r3 = this.f1948.mo8019();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = r0[r3 + i];
                i2 |= (b & Byte.MAX_VALUE) << i3;
                if ((b & 128) != 128) {
                    this.f1948.mo8016(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte r32 = mo8599();
                i |= (r32 & Byte.MAX_VALUE) << i4;
                if ((r32 & 128) != 128) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8576(TField r4) {
        int i;
        byte b = r4.f959;
        if (b != 2) {
            byte b2 = f3482[b];
            short s = r4.f960;
            short s2 = this.f3484;
            if (s <= s2 || (i = s - s2) > 15) {
                mo9470(b2);
                mo9429(mo9473(r4.f960));
            } else {
                mo9470((byte) (b2 | (i << 4)));
            }
            this.f3484 = r4.f960;
        }
    }

    /* renamed from: ؠ */
    public final void mo9429(int i) {
        int i2 = 0;
        while ((i & -128) != 0) {
            this.f3487[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        byte[] bArr = this.f3487;
        bArr[i2] = (byte) i;
        this.f1948.mo8020(bArr, 0, i2 + 1);
    }

    /* renamed from: ށ */
    public final void mo9474(int i) {
        if (i >= 0) {
            long j = this.f3486;
            if (j != -1 && ((long) i) > j) {
                throw new TProtocolException(outline.m2543("Length exceeded max allowed: ", i));
            }
            return;
        }
        throw new TProtocolException(outline.m2543("Negative length: ", i));
    }

    /* renamed from: ؠ */
    public final byte mo9472(byte b) {
        byte b2 = (byte) (b & 15);
        switch (b2) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return 11;
            case 9:
                return 15;
            case 10:
                return 14;
            case 11:
                return 13;
            case 12:
                return 12;
            default:
                throw new TProtocolException(outline.m2543("don't know what type: ", (int) b2));
        }
    }

    /* renamed from: ֏ */
    public void mo8578(TMap r3) {
        int i = r3.f3637;
        if (i == 0) {
            mo9470((byte) 0);
            return;
        }
        mo9429(i);
        byte b = r3.f3635;
        byte[] bArr = f3482;
        mo9470((byte) (bArr[r3.f3636] | (bArr[b] << 4)));
    }

    /* renamed from: ֏ */
    public void mo8577(TList r3) {
        byte b = r3.f3355;
        int i = r3.f3356;
        if (i <= 14) {
            mo9470((byte) ((i << 4) | f3482[b]));
            return;
        }
        mo9470((byte) (f3482[b] | 240));
        mo9429(i);
    }

    /* renamed from: ֏ */
    public void mo8573(int i) {
        mo9429((i >> 31) ^ (i << 1));
    }

    /* renamed from: ֏ */
    public void mo8579(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            mo9429(length);
            this.f1948.mo8020(bytes, 0, length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    /* renamed from: ֏ */
    public void mo8580(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        mo9429(limit);
        this.f1948.mo8020(array, arrayOffset, limit);
    }

    /* renamed from: ֏ */
    public final void mo9471(byte[] bArr, int i, int i2) {
        mo9429(i2);
        this.f1948.mo8020(bArr, i, i2);
    }

    /* renamed from: ֏ */
    public void mo8574(long j) {
        long j2 = (j >> 63) ^ (j << 1);
        int i = 0;
        while ((-128 & j2) != 0) {
            this.f3488[i] = (byte) ((int) ((127 & j2) | 128));
            j2 >>>= 7;
            i++;
        }
        byte[] bArr = this.f3488;
        bArr[i] = (byte) ((int) j2);
        this.f1948.mo8020(bArr, 0, i + 1);
    }

    /* renamed from: ֏ */
    public final void mo9470(byte b) {
        byte[] bArr = this.f3489;
        bArr[0] = b;
        this.f1948.mo8017(bArr);
    }

    /* renamed from: ֏ */
    public ByteBuffer mo8572() {
        int r0 = mo9476();
        mo9474(r0);
        if (r0 == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[r0];
        this.f1948.mo8022(bArr, 0, r0);
        return ByteBuffer.wrap(bArr);
    }
}
