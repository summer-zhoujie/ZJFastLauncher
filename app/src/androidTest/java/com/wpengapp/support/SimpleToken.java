package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࢠ */
public final class SimpleToken extends Token {

    /* renamed from: ހ */
    public final short f2819;

    /* renamed from: ށ */
    public final short f2820;

    public SimpleToken(Token r1, int i, int i2) {
        super(r1);
        this.f2819 = (short) i;
        this.f2820 = (short) i2;
    }

    public String toString() {
        short s = this.f2819;
        short s2 = this.f2820;
        short s3 = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(s3 | (1 << this.f2820)).substring(1) + '>';
    }

    /* renamed from: ֏ */
    public void mo9004(BitArray r2, byte[] bArr) {
        r2.mo9082(this.f2819, this.f2820);
    }
}
