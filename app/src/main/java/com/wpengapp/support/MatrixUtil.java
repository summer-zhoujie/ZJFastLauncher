package com.wpengapp.support;

import android.support.p000v4.widget.SwipeRefreshLayout;

/* renamed from: com.wpengapp.support.ࠨ */
public final class MatrixUtil {

    /* renamed from: ֏ */
    public static final int[][] f2795 = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: ؠ */
    public static final int[][] f2796 = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: ހ */
    public static final int[][] f2797 = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, SwipeRefreshLayout.SCALE_DOWN_DURATION}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: ށ */
    public static final int[][] f2798 = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0241, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0243, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0244, code lost:
        if (r15 == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0246, code lost:
        if (r13 != false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0248, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x024a, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0210, code lost:
        r15 = r15 + r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x023d, code lost:
        r15 = r15 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x023f, code lost:
        if (r15 != 0) goto L_0x0243;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2635(BitArray r21, com.wpengapp.support.ErrorCorrectionLevel r22, Version r23, int r24, ByteMatrix r25) {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r25
            byte[][] r4 = r3.f1501
            int r5 = r4.length
            r6 = 0
            r7 = 0
        L_0x000d:
            r8 = -1
            if (r7 >= r5) goto L_0x0018
            r9 = r4[r7]
            java.util.Arrays.fill(r9, r8)
            int r7 = r7 + 1
            goto L_0x000d
        L_0x0018:
            int[][] r4 = f2795
            r4 = r4[r6]
            int r4 = r4.length
            m2636(r6, r6, r3)
            int r5 = r3.f1502
            int r5 = r5 - r4
            m2636(r5, r6, r3)
            int r5 = r3.f1502
            int r5 = r5 - r4
            m2636(r6, r5, r3)
            r4 = 7
            m2634(r6, r4, r3)
            int r5 = r3.f1502
            int r5 = r5 + -8
            m2634(r5, r4, r3)
            int r5 = r3.f1502
            int r5 = r5 + -8
            m2634(r6, r5, r3)
            m2638(r4, r6, r3)
            int r5 = r3.f1503
            int r5 = r5 - r4
            int r5 = r5 + r8
            m2638(r5, r6, r3)
            int r5 = r3.f1503
            int r5 = r5 - r4
            m2638(r4, r5, r3)
            int r5 = r3.f1503
            r7 = 8
            int r5 = r5 - r7
            byte r5 = r3.mo8340(r7, r5)
            if (r5 == 0) goto L_0x02c5
            int r5 = r3.f1503
            int r5 = r5 - r7
            r9 = 1
            r3.mo8341((int) r7, (int) r5, (int) r9)
            int r5 = r1.f2351
            r10 = 5
            r11 = 2
            if (r5 >= r11) goto L_0x0067
            goto L_0x00c1
        L_0x0067:
            int r5 = r5 + r8
            int[][] r12 = f2797
            r5 = r12[r5]
            int r12 = r5.length
            r13 = 0
        L_0x006e:
            if (r13 >= r12) goto L_0x00c1
            r14 = r5[r13]
            if (r14 < 0) goto L_0x00b6
            int r15 = r5.length
            r8 = 0
        L_0x0076:
            if (r8 >= r15) goto L_0x00b6
            r11 = r5[r8]
            if (r11 < 0) goto L_0x00ac
            byte r18 = r3.mo8340(r11, r14)
            boolean r18 = m2637(r18)
            if (r18 == 0) goto L_0x00ac
            int r11 = r11 + -2
            int r18 = r14 + -2
            r4 = 0
        L_0x008b:
            if (r4 >= r10) goto L_0x00ac
            int[][] r19 = f2796
            r19 = r19[r4]
            r9 = 0
        L_0x0092:
            if (r9 >= r10) goto L_0x00a4
            int r6 = r11 + r9
            int r10 = r18 + r4
            r7 = r19[r9]
            r3.mo8341((int) r6, (int) r10, (int) r7)
            int r9 = r9 + 1
            r6 = 0
            r7 = 8
            r10 = 5
            goto L_0x0092
        L_0x00a4:
            int r4 = r4 + 1
            r6 = 0
            r7 = 8
            r9 = 1
            r10 = 5
            goto L_0x008b
        L_0x00ac:
            int r8 = r8 + 1
            r4 = 7
            r6 = 0
            r7 = 8
            r9 = 1
            r10 = 5
            r11 = 2
            goto L_0x0076
        L_0x00b6:
            int r13 = r13 + 1
            r4 = 7
            r6 = 0
            r7 = 8
            r8 = -1
            r9 = 1
            r10 = 5
            r11 = 2
            goto L_0x006e
        L_0x00c1:
            r4 = 8
        L_0x00c3:
            int r5 = r3.f1502
            r6 = 8
            int r5 = r5 - r6
            r6 = 6
            if (r4 >= r5) goto L_0x00eb
            int r5 = r4 + 1
            int r7 = r5 % 2
            byte r8 = r3.mo8340(r4, r6)
            boolean r8 = m2637(r8)
            if (r8 == 0) goto L_0x00dc
            r3.mo8341((int) r4, (int) r6, (int) r7)
        L_0x00dc:
            byte r8 = r3.mo8340(r6, r4)
            boolean r8 = m2637(r8)
            if (r8 == 0) goto L_0x00e9
            r3.mo8341((int) r6, (int) r4, (int) r7)
        L_0x00e9:
            r4 = r5
            goto L_0x00c3
        L_0x00eb:
            com.wpengapp.support.ࢤ r4 = new com.wpengapp.support.ࢤ
            r4.<init>()
            if (r2 < 0) goto L_0x00f8
            r5 = 8
            if (r2 >= r5) goto L_0x00f8
            r5 = 1
            goto L_0x00f9
        L_0x00f8:
            r5 = 0
        L_0x00f9:
            if (r5 == 0) goto L_0x02bd
            r5 = r22
            int r5 = r5.f1511
            r7 = 3
            int r5 = r5 << r7
            r5 = r5 | r2
            r8 = 5
            r4.mo9082(r5, r8)
            r8 = 1335(0x537, float:1.871E-42)
            int r5 = m2633(r5, r8)
            r8 = 10
            r4.mo9082(r5, r8)
            com.wpengapp.support.ࢤ r5 = new com.wpengapp.support.ࢤ
            r5.<init>()
            r8 = 21522(0x5412, float:3.0159E-41)
            r9 = 15
            r5.mo9082(r8, r9)
            int r8 = r4.f2829
            int r10 = r5.f2829
            if (r8 != r10) goto L_0x02b5
            r8 = 0
        L_0x0124:
            int[] r10 = r4.f2828
            int r11 = r10.length
            if (r8 >= r11) goto L_0x0135
            r11 = r10[r8]
            int[] r12 = r5.f2828
            r12 = r12[r8]
            r11 = r11 ^ r12
            r10[r8] = r11
            int r8 = r8 + 1
            goto L_0x0124
        L_0x0135:
            int r5 = r4.f2829
            java.lang.String r8 = "should not happen but we got: "
            if (r5 != r9) goto L_0x02a1
            r5 = 0
        L_0x013c:
            int r9 = r4.f2829
            if (r5 >= r9) goto L_0x016d
            int r9 = r9 + -1
            int r9 = r9 - r5
            boolean r9 = r4.mo9085(r9)
            int[][] r10 = f2798
            r10 = r10[r5]
            r11 = 0
            r12 = r10[r11]
            r13 = 1
            r10 = r10[r13]
            r3.mo8342((int) r12, (int) r10, (boolean) r9)
            r10 = 8
            if (r5 >= r10) goto L_0x0160
            int r12 = r3.f1502
            int r12 = r12 - r5
            int r12 = r12 - r13
            r3.mo8342((int) r12, (int) r10, (boolean) r9)
            goto L_0x016a
        L_0x0160:
            int r12 = r3.f1503
            int r12 = r12 + -7
            int r13 = r5 + -8
            int r13 = r13 + r12
            r3.mo8342((int) r10, (int) r13, (boolean) r9)
        L_0x016a:
            int r5 = r5 + 1
            goto L_0x013c
        L_0x016d:
            r11 = 0
            int r4 = r1.f2351
            r5 = 7
            if (r4 >= r5) goto L_0x0174
            goto L_0x01b9
        L_0x0174:
            com.wpengapp.support.ࢤ r4 = new com.wpengapp.support.ࢤ
            r4.<init>()
            int r5 = r1.f2351
            r4.mo9082(r5, r6)
            int r1 = r1.f2351
            r5 = 7973(0x1f25, float:1.1173E-41)
            int r1 = m2633(r1, r5)
            r5 = 12
            r4.mo9082(r1, r5)
            int r1 = r4.f2829
            r5 = 18
            if (r1 != r5) goto L_0x028d
            r1 = 17
            r1 = 0
            r5 = 17
        L_0x0196:
            if (r1 >= r6) goto L_0x01b9
            r8 = r5
            r5 = 0
        L_0x019a:
            if (r5 >= r7) goto L_0x01b5
            boolean r9 = r4.mo9085(r8)
            int r8 = r8 + -1
            int r10 = r3.f1503
            int r10 = r10 + -11
            int r10 = r10 + r5
            r3.mo8342((int) r1, (int) r10, (boolean) r9)
            int r10 = r3.f1503
            int r10 = r10 + -11
            int r10 = r10 + r5
            r3.mo8342((int) r10, (int) r1, (boolean) r9)
            int r5 = r5 + 1
            goto L_0x019a
        L_0x01b5:
            int r1 = r1 + 1
            r5 = r8
            goto L_0x0196
        L_0x01b9:
            int r1 = r3.f1502
            r4 = 1
            int r1 = r1 - r4
            int r5 = r3.f1503
            int r5 = r5 - r4
            r4 = 0
            r8 = -1
        L_0x01c2:
            if (r1 <= 0) goto L_0x026a
            if (r1 != r6) goto L_0x01c8
            int r1 = r1 + -1
        L_0x01c8:
            if (r5 < 0) goto L_0x0260
            int r9 = r3.f1503
            if (r5 >= r9) goto L_0x0260
            r9 = r4
            r4 = 0
            r10 = 2
        L_0x01d1:
            if (r4 >= r10) goto L_0x0259
            int r12 = r1 - r4
            byte r13 = r3.mo8340(r12, r5)
            boolean r13 = m2637(r13)
            if (r13 == 0) goto L_0x0252
            int r13 = r0.f2829
            if (r9 >= r13) goto L_0x01ea
            boolean r13 = r0.mo9085(r9)
            int r9 = r9 + 1
            goto L_0x01eb
        L_0x01ea:
            r13 = 0
        L_0x01eb:
            r14 = -1
            if (r2 == r14) goto L_0x024c
            switch(r2) {
                case 0: goto L_0x0239;
                case 1: goto L_0x0235;
                case 2: goto L_0x0230;
                case 3: goto L_0x022a;
                case 4: goto L_0x021f;
                case 5: goto L_0x0215;
                case 6: goto L_0x020b;
                case 7: goto L_0x0201;
                default: goto L_0x01f1;
            }
        L_0x01f1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r24)
            java.lang.String r2 = "Invalid mask pattern: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x0201:
            int r15 = r5 * r12
            int r15 = r15 % r7
            int r16 = r5 + r12
            r17 = 1
            r16 = r16 & 1
            goto L_0x0210
        L_0x020b:
            int r15 = r5 * r12
            r16 = r15 & 1
            int r15 = r15 % r7
        L_0x0210:
            int r15 = r15 + r16
            r20 = 1
            goto L_0x023d
        L_0x0215:
            int r15 = r5 * r12
            r16 = r15 & 1
            int r15 = r15 % r7
            int r15 = r15 + r16
            r20 = 1
            goto L_0x023f
        L_0x021f:
            int r15 = r5 / 2
            int r16 = r12 / 3
            int r16 = r16 + r15
            r20 = 1
            r15 = r16 & 1
            goto L_0x023f
        L_0x022a:
            r20 = 1
            int r15 = r5 + r12
            int r15 = r15 % r7
            goto L_0x023f
        L_0x0230:
            r20 = 1
            int r15 = r12 % 3
            goto L_0x023f
        L_0x0235:
            r20 = 1
            r15 = r5
            goto L_0x023d
        L_0x0239:
            r20 = 1
            int r15 = r5 + r12
        L_0x023d:
            r15 = r15 & 1
        L_0x023f:
            if (r15 != 0) goto L_0x0243
            r15 = 1
            goto L_0x0244
        L_0x0243:
            r15 = 0
        L_0x0244:
            if (r15 == 0) goto L_0x024e
            if (r13 != 0) goto L_0x024a
            r13 = 1
            goto L_0x024e
        L_0x024a:
            r13 = 0
            goto L_0x024e
        L_0x024c:
            r20 = 1
        L_0x024e:
            r3.mo8342((int) r12, (int) r5, (boolean) r13)
            goto L_0x0255
        L_0x0252:
            r14 = -1
            r20 = 1
        L_0x0255:
            int r4 = r4 + 1
            goto L_0x01d1
        L_0x0259:
            r14 = -1
            r20 = 1
            int r5 = r5 + r8
            r4 = r9
            goto L_0x01c8
        L_0x0260:
            r10 = 2
            r14 = -1
            r20 = 1
            int r8 = -r8
            int r5 = r5 + r8
            int r1 = r1 + -2
            goto L_0x01c2
        L_0x026a:
            int r1 = r0.f2829
            if (r4 != r1) goto L_0x026f
            return
        L_0x026f:
            com.wpengapp.support.ޠ r1 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Not all bits consumed: "
            r2.<init>(r3)
            r2.append(r4)
            r3 = 47
            r2.append(r3)
            int r0 = r0.f2829
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x028d:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            int r2 = r4.f2829
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02a1:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            int r2 = r4.f2829
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02b5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Sizes don't match"
            r0.<init>(r1)
            throw r0
        L_0x02bd:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Invalid mask pattern"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02c5:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.MatrixUtil.m2635(com.wpengapp.support.ࢤ, com.wpengapp.support.ˊ, com.wpengapp.support.ٴ, int, com.wpengapp.support.ˇ):void");
    }

    /* renamed from: ؠ */
    public static void m2636(int i, int i2, ByteMatrix r10) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f2795[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                r10.mo8341(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: ؠ */
    public static boolean m2637(int i) {
        return i == -1;
    }

    /* renamed from: ހ */
    public static void m2638(int i, int i2, ByteMatrix r6) {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (m2637(r6.f1501[i4][i])) {
                r6.f1501[i4][i] = (byte) 0;
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: ֏ */
    public static int m2632(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: ֏ */
    public static int m2633(int i, int i2) {
        if (i2 != 0) {
            int r0 = m2632(i2);
            int i3 = i << (r0 - 1);
            while (m2632(i3) >= r0) {
                i3 ^= i2 << (m2632(i3) - r0);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: ֏ */
    public static void m2634(int i, int i2, ByteMatrix r6) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (m2637(r6.mo8340(i4, i2))) {
                r6.mo8341(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }
}
