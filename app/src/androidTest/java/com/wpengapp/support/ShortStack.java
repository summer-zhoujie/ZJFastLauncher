package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ݻ */
public class ShortStack {

    /* renamed from: ֏ */
    public short[] f2573;

    /* renamed from: ؠ */
    public int f2574 = -1;

    public ShortStack(int i) {
        this.f2573 = new short[i];
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("<ShortStack vector:[");
        for (int i = 0; i < this.f2573.length; i++) {
            if (i != 0) {
                r0.append(" ");
            }
            if (i == this.f2574) {
                r0.append(">>");
            }
            r0.append(this.f2573[i]);
            if (i == this.f2574) {
                r0.append("<<");
            }
        }
        r0.append("]>");
        return r0.toString();
    }

    /* renamed from: ֏ */
    public void mo8954(short s) {
        short[] sArr = this.f2573;
        if (sArr.length == this.f2574 + 1) {
            short[] sArr2 = new short[(sArr.length * 2)];
            System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
            this.f2573 = sArr2;
        }
        short[] sArr3 = this.f2573;
        int i = this.f2574 + 1;
        this.f2574 = i;
        sArr3[i] = s;
    }
}
