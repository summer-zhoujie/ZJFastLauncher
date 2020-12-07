package com.wpengapp.support;

import java.util.BitSet;

/* renamed from: com.wpengapp.support.บ */
public final class TTupleProtocol extends TCompactProtocol {
    /* renamed from: ֏ */
    public void mo9428(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        for (byte b : bArr) {
            byte[] bArr2 = this.f3489;
            bArr2[0] = b;
            this.f1948.mo8017(bArr2);
        }
    }

    /* renamed from: ؠ */
    public BitSet mo9429(int i) {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo8599();
        }
        BitSet bitSet = new BitSet();
        for (int i3 = 0; i3 < bArr.length * 8; i3++) {
            if ((bArr[(bArr.length - (i3 / 8)) - 1] & (1 << (i3 % 8))) > 0) {
                bitSet.set(i3);
            }
        }
        return bitSet;
    }

    /* renamed from: ހ */
    public Class<? extends IScheme> mo8582() {
        return TupleScheme.class;
    }
}
