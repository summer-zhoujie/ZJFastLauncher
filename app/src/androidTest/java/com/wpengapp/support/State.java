package com.wpengapp.support;

import java.util.LinkedList;

/* renamed from: com.wpengapp.support.ࢢ */
public final class State {

    /* renamed from: ֏ */
    public static final State f2821 = new State(Token.f2826, 0, 0, 0);

    /* renamed from: ؠ */
    public final int f2822;

    /* renamed from: ހ */
    public final Token f2823;

    /* renamed from: ށ */
    public final int f2824;

    /* renamed from: ނ */
    public final int f2825;

    public State(Token r1, int i, int i2, int i3) {
        this.f2823 = r1;
        this.f2822 = i;
        this.f2824 = i2;
        this.f2825 = i3;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{C0960.f2665[this.f2822], Integer.valueOf(this.f2825), Integer.valueOf(this.f2824)});
    }

    /* renamed from: ֏ */
    public int mo9067() {
        return this.f2825;
    }

    /* renamed from: ؠ */
    public State mo9073(int i, int i2) {
        Token r0 = this.f2823;
        int i3 = this.f2822 == 2 ? 4 : 5;
        return new State(new SimpleToken(r0.mo9074(C0960.f2668[this.f2822][i], i3), i2, 5), this.f2822, 0, this.f2825 + i3 + 5);
    }

    /* renamed from: ֏ */
    public State mo9069(int i, int i2) {
        int i3 = this.f2825;
        Token r1 = this.f2823;
        int i4 = this.f2822;
        if (i != i4) {
            int i5 = C0960.f2666[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            r1 = r1.mo9074(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new State(r1.mo9074(i2, i8), i, 0, i3 + i8);
    }

    /* renamed from: ؠ */
    public State mo9072(int i) {
        int i2 = this.f2824;
        if (i2 == 0) {
            return this;
        }
        return new State(this.f2823.mo9075(i - i2, i2), this.f2822, 0, this.f2825);
    }

    /* renamed from: ֏ */
    public State mo9068(int i) {
        Token r0 = this.f2823;
        int i2 = this.f2822;
        int i3 = this.f2825;
        if (i2 == 4 || i2 == 2) {
            int i4 = C0960.f2666[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            r0 = r0.mo9074(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.f2824;
        State r4 = new State(r0, i2, this.f2824 + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return r4.f2824 == 2078 ? r4.mo9072(i + 1) : r4;
    }

    /* renamed from: ֏ */
    public boolean mo9071(State r4) {
        int i;
        int i2 = this.f2825 + (C0960.f2666[this.f2822][r4.f2822] >> 16);
        int i3 = r4.f2824;
        if (i3 > 0 && ((i = this.f2824) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= r4.f2825;
    }

    /* renamed from: ֏ */
    public BitArray mo9070(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList<>();
        for (Token r1 = mo9072(bArr.length).f2823; r1 != null; r1 = r1.f2827) {
            linkedList.addFirst(r1);
        }
        BitArray r12 = new BitArray();
        for (Token r2 : linkedList) {
            r2.mo9004(r12, bArr);
        }
        return r12;
    }
}
