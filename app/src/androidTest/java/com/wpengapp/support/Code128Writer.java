package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၥ */
public final class Code128Writer extends OneDimensionalCodeWriter {

    /* renamed from: com.wpengapp.support.ၥ$֏ */
    /* compiled from: Code128Writer */
    private enum C1297 {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r3, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r3 == BarcodeFormat.CODE_128) {
            return super.mo9001(str, r3, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(r3)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        if (m3467(r0, r5 + 3) == com.wpengapp.support.Code128Writer.C1297.f3675) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        if (r10 == com.wpengapp.support.Code128Writer.C1297.f3674) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b0, code lost:
        if (r10 == com.wpengapp.support.Code128Writer.C1297.f3675) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0037 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0111  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] mo9549(String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            if (r1 <= 0) goto L_0x015e
            r2 = 80
            if (r1 > r2) goto L_0x015e
            r3 = 0
        L_0x000d:
            if (r3 >= r1) goto L_0x002d
            char r4 = r0.charAt(r3)
            switch(r4) {
                case 241: goto L_0x001a;
                case 242: goto L_0x001a;
                case 243: goto L_0x001a;
                case 244: goto L_0x001a;
                default: goto L_0x0016;
            }
        L_0x0016:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 > r5) goto L_0x001d
        L_0x001a:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x001d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "Bad character in input: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1
        L_0x0037:
            r9 = 103(0x67, float:1.44E-43)
            if (r5 >= r1) goto L_0x0115
            com.wpengapp.support.ၥ$֏ r10 = m3467(r0, r5)
            com.wpengapp.support.ၥ$֏ r11 = com.wpengapp.support.Code128Writer.C1297.ONE_DIGIT
            r12 = 96
            r13 = 32
            r14 = 100
            r15 = 101(0x65, float:1.42E-43)
            if (r10 != r11) goto L_0x004f
        L_0x004b:
            r11 = 100
            goto L_0x00b4
        L_0x004f:
            com.wpengapp.support.ၥ$֏ r11 = com.wpengapp.support.Code128Writer.C1297.UNCODABLE
            if (r10 != r11) goto L_0x0066
            int r10 = r17.length()
            if (r5 >= r10) goto L_0x004b
            char r10 = r0.charAt(r5)
            if (r10 < r13) goto L_0x0063
            if (r7 != r15) goto L_0x004b
            if (r10 >= r12) goto L_0x004b
        L_0x0063:
            r11 = 101(0x65, float:1.42E-43)
            goto L_0x00b4
        L_0x0066:
            r11 = 99
            if (r7 != r11) goto L_0x006b
            goto L_0x00b4
        L_0x006b:
            if (r7 != r14) goto L_0x00a4
            com.wpengapp.support.ၥ$֏ r2 = com.wpengapp.support.Code128Writer.C1297.FNC_1
            if (r10 != r2) goto L_0x0072
            goto L_0x004b
        L_0x0072:
            int r2 = r5 + 2
            com.wpengapp.support.ၥ$֏ r2 = m3467(r0, r2)
            com.wpengapp.support.ၥ$֏ r10 = com.wpengapp.support.Code128Writer.C1297.UNCODABLE
            if (r2 == r10) goto L_0x004b
            com.wpengapp.support.ၥ$֏ r10 = com.wpengapp.support.Code128Writer.C1297.ONE_DIGIT
            if (r2 != r10) goto L_0x0081
            goto L_0x004b
        L_0x0081:
            com.wpengapp.support.ၥ$֏ r10 = com.wpengapp.support.Code128Writer.C1297.FNC_1
            if (r2 != r10) goto L_0x0090
            int r2 = r5 + 3
            com.wpengapp.support.ၥ$֏ r2 = m3467(r0, r2)
            com.wpengapp.support.ၥ$֏ r10 = com.wpengapp.support.Code128Writer.C1297.TWO_DIGITS
            if (r2 != r10) goto L_0x004b
            goto L_0x00b4
        L_0x0090:
            int r2 = r5 + 4
        L_0x0092:
            com.wpengapp.support.ၥ$֏ r10 = m3467(r0, r2)
            com.wpengapp.support.ၥ$֏ r11 = com.wpengapp.support.Code128Writer.C1297.TWO_DIGITS
            if (r10 != r11) goto L_0x009f
            int r2 = r2 + 2
            r11 = 99
            goto L_0x0092
        L_0x009f:
            com.wpengapp.support.ၥ$֏ r2 = com.wpengapp.support.Code128Writer.C1297.ONE_DIGIT
            if (r10 != r2) goto L_0x00b2
            goto L_0x004b
        L_0x00a4:
            com.wpengapp.support.ၥ$֏ r2 = com.wpengapp.support.Code128Writer.C1297.FNC_1
            if (r10 != r2) goto L_0x00ae
            int r2 = r5 + 1
            com.wpengapp.support.ၥ$֏ r10 = m3467(r0, r2)
        L_0x00ae:
            com.wpengapp.support.ၥ$֏ r2 = com.wpengapp.support.Code128Writer.C1297.TWO_DIGITS
            if (r10 != r2) goto L_0x004b
        L_0x00b2:
            r11 = 99
        L_0x00b4:
            if (r11 != r7) goto L_0x00f0
            char r2 = r0.charAt(r5)
            switch(r2) {
                case 241: goto L_0x00c9;
                case 242: goto L_0x00c6;
                case 243: goto L_0x00ee;
                case 244: goto L_0x00be;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            goto L_0x00cc
        L_0x00be:
            if (r7 != r15) goto L_0x00c3
            r12 = 101(0x65, float:1.42E-43)
            goto L_0x00ee
        L_0x00c3:
            r12 = 100
            goto L_0x00ee
        L_0x00c6:
            r12 = 97
            goto L_0x00ee
        L_0x00c9:
            r12 = 102(0x66, float:1.43E-43)
            goto L_0x00ee
        L_0x00cc:
            if (r7 == r14) goto L_0x00e8
            if (r7 == r15) goto L_0x00dd
            int r2 = r5 + 2
            java.lang.String r2 = r0.substring(r5, r2)
            int r12 = java.lang.Integer.parseInt(r2)
            int r5 = r5 + 1
            goto L_0x00ee
        L_0x00dd:
            char r2 = r0.charAt(r5)
            int r12 = r2 + -32
            if (r12 >= 0) goto L_0x00ee
            int r12 = r12 + 96
            goto L_0x00ee
        L_0x00e8:
            char r2 = r0.charAt(r5)
            int r12 = r2 + -32
        L_0x00ee:
            int r5 = r5 + r4
            goto L_0x0105
        L_0x00f0:
            if (r7 != 0) goto L_0x0103
            if (r11 == r14) goto L_0x00fe
            if (r11 == r15) goto L_0x00fb
            r9 = 105(0x69, float:1.47E-43)
            r12 = 105(0x69, float:1.47E-43)
            goto L_0x0104
        L_0x00fb:
            r12 = 103(0x67, float:1.44E-43)
            goto L_0x0104
        L_0x00fe:
            r9 = 104(0x68, float:1.46E-43)
            r12 = 104(0x68, float:1.46E-43)
            goto L_0x0104
        L_0x0103:
            r12 = r11
        L_0x0104:
            r7 = r11
        L_0x0105:
            int[][] r2 = com.wpengapp.support.Code128Reader.f3672
            r2 = r2[r12]
            r3.add(r2)
            int r12 = r12 * r8
            int r6 = r6 + r12
            if (r5 == 0) goto L_0x0037
            int r8 = r8 + 1
            goto L_0x0037
        L_0x0115:
            int r6 = r6 % r9
            int[][] r0 = com.wpengapp.support.Code128Reader.f3672
            r0 = r0[r6]
            r3.add(r0)
            int[][] r0 = com.wpengapp.support.Code128Reader.f3672
            r1 = 106(0x6a, float:1.49E-43)
            r0 = r0[r1]
            r3.add(r0)
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x012b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0144
            java.lang.Object r2 = r0.next()
            int[] r2 = (int[]) r2
            int r5 = r2.length
            r6 = r1
            r1 = 0
        L_0x013a:
            if (r1 >= r5) goto L_0x0142
            r7 = r2[r1]
            int r6 = r6 + r7
            int r1 = r1 + 1
            goto L_0x013a
        L_0x0142:
            r1 = r6
            goto L_0x012b
        L_0x0144:
            boolean[] r0 = new boolean[r1]
            java.util.Iterator r1 = r3.iterator()
            r2 = 0
        L_0x014b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x015d
            java.lang.Object r3 = r1.next()
            int[] r3 = (int[]) r3
            int r3 = com.wpengapp.support.OneDimensionalCodeWriter.m3484(r0, r2, r3, r4)
            int r2 = r2 + r3
            goto L_0x014b
        L_0x015d:
            return r0
        L_0x015e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Contents length should be between 1 and 80 characters, but got "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Code128Writer.mo9549(java.lang.String):boolean[]");
    }

    /* renamed from: ֏ */
    public static C1297 m3467(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return C1297.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return C1297.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return C1297.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return C1297.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return C1297.ONE_DIGIT;
        }
        return C1297.TWO_DIGITS;
    }
}
