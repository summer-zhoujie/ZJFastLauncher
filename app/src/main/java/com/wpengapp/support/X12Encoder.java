package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ၛ */
public final class X12Encoder extends C40Encoder {
    /* renamed from: ֏ */
    public int mo9387() {
        return 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        r7.mo9523();
        r1 = r7.f3591.f3628 - r7.mo9516();
        r7.f3589 -= r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        if (r7.mo9521() > 1) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r1 > 1) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (r7.mo9521() == r1) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        r7.f3588.append(254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        if (r7.f3590 >= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
        r7.f3590 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9379(com.wpengapp.support.EncoderContext r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r7.mo9522()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0074
            char r1 = r7.mo9520()
            int r4 = r7.f3589
            int r4 = r4 + r3
            r7.f3589 = r4
            r4 = 13
            r5 = 3
            if (r1 == r4) goto L_0x005b
            r4 = 32
            if (r1 == r4) goto L_0x0057
            r4 = 42
            if (r1 == r4) goto L_0x0053
            r4 = 62
            if (r1 == r4) goto L_0x004e
            r4 = 48
            if (r1 < r4) goto L_0x0038
            r4 = 57
            if (r1 > r4) goto L_0x0038
            int r1 = r1 + -48
            int r1 = r1 + 4
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x005e
        L_0x0038:
            r4 = 65
            if (r1 < r4) goto L_0x0049
            r4 = 90
            if (r1 > r4) goto L_0x0049
            int r1 = r1 + -65
            int r1 = r1 + 14
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x005e
        L_0x0049:
            com.wpengapp.support.C1279.m3406((char) r1)
            r7 = 0
            throw r7
        L_0x004e:
            r1 = 2
            r0.append(r1)
            goto L_0x005e
        L_0x0053:
            r0.append(r3)
            goto L_0x005e
        L_0x0057:
            r0.append(r5)
            goto L_0x005e
        L_0x005b:
            r0.append(r2)
        L_0x005e:
            int r1 = r0.length()
            int r1 = r1 % r5
            if (r1 != 0) goto L_0x0005
            com.wpengapp.support.C40Encoder.m3155(r7, r0)
            java.lang.String r1 = r7.f3584
            int r4 = r7.f3589
            int r1 = com.wpengapp.support.C1279.m3385((java.lang.CharSequence) r1, (int) r4, (int) r5)
            if (r1 == r5) goto L_0x0005
            r7.f3590 = r2
        L_0x0074:
            r7.mo9523()
            com.wpengapp.support.ဢ r1 = r7.f3591
            int r1 = r1.f3628
            int r4 = r7.mo9516()
            int r1 = r1 - r4
            int r0 = r0.length()
            int r4 = r7.f3589
            int r4 = r4 - r0
            r7.f3589 = r4
            int r0 = r7.mo9521()
            if (r0 > r3) goto L_0x0097
            if (r1 > r3) goto L_0x0097
            int r0 = r7.mo9521()
            if (r0 == r1) goto L_0x009e
        L_0x0097:
            r0 = 254(0xfe, float:3.56E-43)
            java.lang.StringBuilder r1 = r7.f3588
            r1.append(r0)
        L_0x009e:
            int r0 = r7.f3590
            if (r0 >= 0) goto L_0x00a4
            r7.f3590 = r2
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.X12Encoder.mo9379(com.wpengapp.support.ྈ):void");
    }

    /* renamed from: ֏ */
    public int mo9388(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            C1279.m3406(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* renamed from: ֏ */
    public void mo9390(EncoderContext r3, StringBuilder sb) {
        r3.mo9523();
        int r0 = r3.f3591.f3628 - r3.mo9516();
        r3.f3589 -= sb.length();
        if (r3.mo9521() > 1 || r0 > 1 || r3.mo9521() != r0) {
            r3.f3588.append(254);
        }
        if (r3.f3590 < 0) {
            r3.f3590 = 0;
        }
    }
}
