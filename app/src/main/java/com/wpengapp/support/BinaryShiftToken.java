package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ޣ */
public final class BinaryShiftToken extends Token {

    /* renamed from: ހ */
    public final short f2662;

    /* renamed from: ށ */
    public final short f2663;

    public BinaryShiftToken(Token r1, int i, int i2) {
        super(r1);
        this.f2662 = (short) i;
        this.f2663 = (short) i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f2662);
        sb.append("::");
        sb.append((this.f2662 + this.f2663) - 1);
        sb.append('>');
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9004(BitArray r6, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.f2663;
            if (i < s) {
                if (i == 0 || (i == 31 && s <= 62)) {
                    r6.mo9082(31, 5);
                    short s2 = this.f2663;
                    if (s2 > 62) {
                        r6.mo9082(s2 - 31, 16);
                    } else if (i == 0) {
                        r6.mo9082(Math.min(s2, 31), 5);
                    } else {
                        r6.mo9082(s2 - 31, 5);
                    }
                }
                r6.mo9082(bArr[this.f2662 + i], 8);
                i++;
            } else {
                return;
            }
        }
    }
}
