package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࢣ */
public abstract class Token {

    /* renamed from: ֏ */
    public static final Token f2826 = new SimpleToken((Token) null, 0, 0);

    /* renamed from: ؠ */
    public final Token f2827;

    public Token(Token r1) {
        this.f2827 = r1;
    }

    /* renamed from: ֏ */
    public final Token mo9074(int i, int i2) {
        return new SimpleToken(this, i, i2);
    }

    /* renamed from: ֏ */
    public abstract void mo9004(BitArray r1, byte[] bArr);

    /* renamed from: ؠ */
    public final Token mo9075(int i, int i2) {
        return new BinaryShiftToken(this, i, i2);
    }
}
