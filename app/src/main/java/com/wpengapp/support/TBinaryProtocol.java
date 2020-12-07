package com.wpengapp.support;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.wpengapp.support.ખ */
public class TBinaryProtocol extends TProtocol {

    /* renamed from: ؠ */
    public static final TStruct f3120 = new TStruct();

    /* renamed from: ހ */
    public int f3121;

    /* renamed from: ށ */
    public boolean f3122 = false;

    /* renamed from: ނ */
    public byte[] f3123 = new byte[1];

    /* renamed from: ރ */
    public byte[] f3124 = new byte[2];

    /* renamed from: ބ */
    public byte[] f3125 = new byte[4];

    /* renamed from: ޅ */
    public byte[] f3126 = new byte[8];

    /* renamed from: ކ */
    public byte[] f3127 = new byte[1];

    /* renamed from: އ */
    public byte[] f3128 = new byte[2];

    /* renamed from: ވ */
    public byte[] f3129 = new byte[4];

    /* renamed from: މ */
    public byte[] f3130 = new byte[8];

    /* renamed from: com.wpengapp.support.ખ$֏ */
    /* compiled from: TBinaryProtocol */
    public static class C1098 implements TProtocolFactory {

        /* renamed from: ֏ */
        public boolean f3131;

        /* renamed from: ؠ */
        public boolean f3132;

        /* renamed from: ހ */
        public int f3133;

        public C1098() {
            this.f3131 = false;
            this.f3132 = true;
            this.f3131 = false;
            this.f3132 = true;
            this.f3133 = 0;
        }

        /* renamed from: ֏ */
        public TProtocol mo9274(TTransport r4) {
            TBinaryProtocol r0 = new TBinaryProtocol(r4, this.f3131, this.f3132);
            int i = this.f3133;
            if (i != 0) {
                r0.f3121 = i;
                r0.f3122 = true;
            }
            return r0;
        }
    }

    public TBinaryProtocol(TTransport r3, boolean z, boolean z2) {
        super(r3);
    }

    /* renamed from: ֏ */
    public void mo8575(TStruct r1) {
    }

    /* renamed from: ֏ */
    public void mo8576(TField r4) {
        mo9284(r4.f959);
        short s = r4.f960;
        byte[] bArr = this.f3124;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f1948.mo8020(bArr, 0, 2);
    }

    /* renamed from: ؠ */
    public void mo9285(int i) {
        if (i < 0) {
            throw new TProtocolException(outline.m2543("Negative length: ", i));
        } else if (this.f3122) {
            this.f3121 -= i;
            if (this.f3121 < 0) {
                throw new TProtocolException(outline.m2543("Message length exceeded: ", i));
            }
        }
    }

    /* renamed from: ށ */
    public void mo8583() {
    }

    /* renamed from: ނ */
    public void mo8584() {
    }

    /* renamed from: ރ */
    public void mo8585() {
        mo9284((byte) 0);
    }

    /* renamed from: ބ */
    public void mo8586() {
    }

    /* renamed from: ޅ */
    public void mo8587() {
    }

    /* renamed from: ކ */
    public TStruct mo8588() {
        return f3120;
    }

    /* renamed from: އ */
    public void mo8589() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: short} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ވ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TField mo8590() {
        /*
            r5 = this;
            byte r0 = r5.mo8599()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x0038
        L_0x0008:
            byte[] r2 = r5.f3128
            com.wpengapp.support.Ũ r3 = r5.f1948
            int r3 = r3.mo8021()
            r4 = 2
            if (r3 < r4) goto L_0x0025
            com.wpengapp.support.Ũ r1 = r5.f1948
            byte[] r2 = r1.mo8018()
            com.wpengapp.support.Ũ r1 = r5.f1948
            int r1 = r1.mo8019()
            com.wpengapp.support.Ũ r3 = r5.f1948
            r3.mo8016((int) r4)
            goto L_0x002a
        L_0x0025:
            byte[] r3 = r5.f3128
            r5.mo9283(r3, r1, r4)
        L_0x002a:
            byte r3 = r2[r1]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            int r1 = r1 + 1
            byte r1 = r2[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r3
            short r1 = (short) r1
        L_0x0038:
            com.wpengapp.support.ƴ r2 = new com.wpengapp.support.ƴ
            java.lang.String r3 = ""
            r2.<init>(r3, r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.TBinaryProtocol.mo8590():com.wpengapp.support.ƴ");
    }

    /* renamed from: މ */
    public void mo8591() {
    }

    /* renamed from: ފ */
    public TMap mo8592() {
        return new TMap(mo8599(), mo8599(), mo8601());
    }

    /* renamed from: ދ */
    public void mo8593() {
    }

    /* renamed from: ތ */
    public TList mo8594() {
        return new TList(mo8599(), mo8601());
    }

    /* renamed from: ލ */
    public void mo8595() {
    }

    /* renamed from: ގ */
    public TSet mo8596() {
        return new TSet(mo8599(), mo8601());
    }

    /* renamed from: ޏ */
    public void mo8597() {
    }

    /* renamed from: ސ */
    public boolean mo8598() {
        return mo8599() == 1;
    }

    /* renamed from: ޑ */
    public byte mo8599() {
        if (this.f1948.mo8021() >= 1) {
            byte b = this.f1948.mo8018()[this.f1948.mo8019()];
            this.f1948.mo8016(1);
            return b;
        }
        mo9283(this.f3127, 0, 1);
        return this.f3127[0];
    }

    /* renamed from: ޒ */
    public short mo8600() {
        byte[] bArr = this.f3128;
        int i = 0;
        if (this.f1948.mo8021() >= 2) {
            bArr = this.f1948.mo8018();
            i = this.f1948.mo8019();
            this.f1948.mo8016(2);
        } else {
            mo9283(this.f3128, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* renamed from: ޓ */
    public int mo8601() {
        byte[] bArr = this.f3129;
        int i = 0;
        if (this.f1948.mo8021() >= 4) {
            bArr = this.f1948.mo8018();
            i = this.f1948.mo8019();
            this.f1948.mo8016(4);
        } else {
            mo9283(this.f3129, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: ޔ */
    public long mo8602() {
        byte[] bArr = this.f3130;
        int i = 0;
        if (this.f1948.mo8021() >= 8) {
            bArr = this.f1948.mo8018();
            i = this.f1948.mo8019();
            this.f1948.mo8016(8);
        } else {
            mo9283(this.f3130, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    /* renamed from: ޕ */
    public double mo8603() {
        byte[] bArr = this.f3130;
        int i = 0;
        if (this.f1948.mo8021() >= 8) {
            bArr = this.f1948.mo8018();
            i = this.f1948.mo8019();
            this.f1948.mo8016(8);
        } else {
            mo9283(this.f3130, 0, 8);
        }
        return Double.longBitsToDouble(((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8));
    }

    /* renamed from: ޖ */
    public String mo8604() {
        int r0 = mo8601();
        if (this.f1948.mo8021() >= r0) {
            try {
                String str = new String(this.f1948.mo8018(), this.f1948.mo8019(), r0, "UTF-8");
                this.f1948.mo8016(r0);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            try {
                mo9285(r0);
                byte[] bArr = new byte[r0];
                this.f1948.mo8022(bArr, 0, r0);
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8578(TMap r2) {
        mo9284(r2.f3635);
        mo9284(r2.f3636);
        mo8573(r2.f3637);
    }

    /* renamed from: ֏ */
    public void mo8577(TList r2) {
        mo9284(r2.f3355);
        mo8573(r2.f3356);
    }

    /* renamed from: ֏ */
    public void mo9284(byte b) {
        byte[] bArr = this.f3123;
        bArr[0] = b;
        this.f1948.mo8020(bArr, 0, 1);
    }

    /* renamed from: ֏ */
    public void mo8573(int i) {
        byte[] bArr = this.f3125;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f1948.mo8020(bArr, 0, 4);
    }

    /* renamed from: ֏ */
    public void mo8574(long j) {
        byte[] bArr = this.f3126;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        this.f1948.mo8020(bArr, 0, 8);
    }

    /* renamed from: ֏ */
    public void mo8579(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo8573(bytes.length);
            this.f1948.mo8020(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: ֏ */
    public void mo8580(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo8573(limit);
        this.f1948.mo8020(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), limit);
    }

    /* renamed from: ֏ */
    public ByteBuffer mo8572() {
        int r0 = mo8601();
        mo9285(r0);
        if (this.f1948.mo8021() >= r0) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f1948.mo8018(), this.f1948.mo8019(), r0);
            this.f1948.mo8016(r0);
            return wrap;
        }
        byte[] bArr = new byte[r0];
        this.f1948.mo8022(bArr, 0, r0);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: ֏ */
    public final int mo9283(byte[] bArr, int i, int i2) {
        mo9285(i2);
        return this.f1948.mo8022(bArr, i, i2);
    }
}
