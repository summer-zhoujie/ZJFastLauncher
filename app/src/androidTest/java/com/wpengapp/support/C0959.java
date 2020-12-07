package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ޤ */
/* compiled from: Encoder */
public final class C0959 {

    /* renamed from: ֏ */
    public static final int[] f2664 = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: ֏ */
    public static BitArray m2564(BitArray r11, int i, int i2) {
        GenericGF r2;
        int i3 = r11.f2829 / i2;
        if (i2 == 4) {
            r2 = GenericGF.f2869;
        } else if (i2 == 6) {
            r2 = GenericGF.f2868;
        } else if (i2 == 8) {
            r2 = GenericGF.f2871;
        } else if (i2 == 10) {
            r2 = GenericGF.f2867;
        } else if (i2 == 12) {
            r2 = GenericGF.f2866;
        } else {
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
        }
        ReedSolomonEncoder r1 = new ReedSolomonEncoder(r2);
        int i4 = i / i2;
        int[] iArr = new int[i4];
        int i5 = r11.f2829 / i2;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                i7 |= r11.mo9085((i6 * i2) + i8) ? 1 << ((i2 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        r1.mo9106(iArr, i4 - i3);
        BitArray r112 = new BitArray();
        r112.mo9082(0, i % i2);
        for (int r0 : iArr) {
            r112.mo9082(r0, i2);
        }
        return r112;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r4 != 32) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wpengapp.support.AztecCode m2562(byte[] r20, int r21, int r22) {
        /*
            com.wpengapp.support.ޱ r0 = new com.wpengapp.support.ޱ
            r1 = r20
            r0.<init>(r1)
            com.wpengapp.support.ࢢ r1 = com.wpengapp.support.State.f2821
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r2 = 0
            r3 = r1
            r1 = 0
        L_0x0010:
            byte[] r4 = r0.f2669
            int r5 = r4.length
            r7 = 32
            r8 = 10
            r9 = 3
            r10 = 4
            r11 = 5
            r12 = 2
            r13 = 1
            if (r1 >= r5) goto L_0x011f
            int r5 = r1 + 1
            int r14 = r4.length
            if (r5 >= r14) goto L_0x0026
            byte r4 = r4[r5]
            goto L_0x0027
        L_0x0026:
            r4 = 0
        L_0x0027:
            byte[] r14 = r0.f2669
            byte r14 = r14[r1]
            r15 = 13
            if (r14 == r15) goto L_0x0047
            r8 = 44
            if (r14 == r8) goto L_0x0043
            r8 = 46
            if (r14 == r8) goto L_0x003f
            r8 = 58
            if (r14 == r8) goto L_0x003c
            goto L_0x004b
        L_0x003c:
            if (r4 != r7) goto L_0x004b
            goto L_0x004c
        L_0x003f:
            if (r4 != r7) goto L_0x004b
            r11 = 3
            goto L_0x004c
        L_0x0043:
            if (r4 != r7) goto L_0x004b
            r11 = 4
            goto L_0x004c
        L_0x0047:
            if (r4 != r8) goto L_0x004b
            r11 = 2
            goto L_0x004c
        L_0x004b:
            r11 = 0
        L_0x004c:
            if (r11 <= 0) goto L_0x00a2
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0057:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x009a
            java.lang.Object r6 = r3.next()
            com.wpengapp.support.ࢢ r6 = (com.wpengapp.support.State) r6
            com.wpengapp.support.ࢢ r7 = r6.mo9072(r1)
            com.wpengapp.support.ࢢ r8 = r7.mo9069(r10, r11)
            r4.add(r8)
            int r8 = r6.f2822
            if (r8 == r10) goto L_0x0079
            com.wpengapp.support.ࢢ r8 = r7.mo9073(r10, r11)
            r4.add(r8)
        L_0x0079:
            if (r11 == r9) goto L_0x007d
            if (r11 != r10) goto L_0x008a
        L_0x007d:
            int r8 = 16 - r11
            com.wpengapp.support.ࢢ r7 = r7.mo9069(r12, r8)
            com.wpengapp.support.ࢢ r7 = r7.mo9069(r12, r13)
            r4.add(r7)
        L_0x008a:
            int r7 = r6.f2824
            if (r7 <= 0) goto L_0x0057
            com.wpengapp.support.ࢢ r6 = r6.mo9068((int) r1)
            com.wpengapp.support.ࢢ r6 = r6.mo9068((int) r5)
            r4.add(r6)
            goto L_0x0057
        L_0x009a:
            java.util.Collection r1 = com.wpengapp.support.C0960.m2566(r4)
            r3 = r1
            r1 = r5
            goto L_0x011c
        L_0x00a2:
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x00ab:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0118
            java.lang.Object r5 = r3.next()
            com.wpengapp.support.ࢢ r5 = (com.wpengapp.support.State) r5
            byte[] r7 = r0.f2669
            byte r7 = r7[r1]
            r7 = r7 & 255(0xff, float:3.57E-43)
            char r7 = (char) r7
            int[][] r8 = com.wpengapp.support.C0960.f2667
            int r9 = r5.f2822
            r8 = r8[r9]
            r8 = r8[r7]
            if (r8 <= 0) goto L_0x00ca
            r8 = 1
            goto L_0x00cb
        L_0x00ca:
            r8 = 0
        L_0x00cb:
            r9 = 0
            r11 = 0
        L_0x00cd:
            if (r9 > r10) goto L_0x0102
            int[][] r14 = com.wpengapp.support.C0960.f2667
            r14 = r14[r9]
            r14 = r14[r7]
            if (r14 <= 0) goto L_0x00ff
            if (r11 != 0) goto L_0x00dd
            com.wpengapp.support.ࢢ r11 = r5.mo9072(r1)
        L_0x00dd:
            if (r8 == 0) goto L_0x00e5
            int r15 = r5.f2822
            if (r9 == r15) goto L_0x00e5
            if (r9 != r12) goto L_0x00ec
        L_0x00e5:
            com.wpengapp.support.ࢢ r15 = r11.mo9069(r9, r14)
            r4.add(r15)
        L_0x00ec:
            if (r8 != 0) goto L_0x00ff
            int[][] r15 = com.wpengapp.support.C0960.f2668
            int r6 = r5.f2822
            r6 = r15[r6]
            r6 = r6[r9]
            if (r6 < 0) goto L_0x00ff
            com.wpengapp.support.ࢢ r6 = r11.mo9073(r9, r14)
            r4.add(r6)
        L_0x00ff:
            int r9 = r9 + 1
            goto L_0x00cd
        L_0x0102:
            int r6 = r5.f2824
            if (r6 > 0) goto L_0x0110
            int[][] r6 = com.wpengapp.support.C0960.f2667
            int r8 = r5.f2822
            r6 = r6[r8]
            r6 = r6[r7]
            if (r6 != 0) goto L_0x00ab
        L_0x0110:
            com.wpengapp.support.ࢢ r5 = r5.mo9068((int) r1)
            r4.add(r5)
            goto L_0x00ab
        L_0x0118:
            java.util.Collection r3 = com.wpengapp.support.C0960.m2566(r4)
        L_0x011c:
            int r1 = r1 + r13
            goto L_0x0010
        L_0x011f:
            com.wpengapp.support.ޥ r1 = new com.wpengapp.support.ޥ
            r1.<init>(r0)
            java.lang.Object r1 = java.util.Collections.min(r3, r1)
            com.wpengapp.support.ࢢ r1 = (com.wpengapp.support.State) r1
            byte[] r0 = r0.f2669
            com.wpengapp.support.ࢤ r0 = r1.mo9070((byte[]) r0)
            int r1 = r0.f2829
            int r3 = r1 * r21
            int r3 = r3 / 100
            r4 = 11
            int r3 = r3 + r4
            int r1 = r1 + r3
            if (r22 == 0) goto L_0x0198
            if (r22 >= 0) goto L_0x0140
            r1 = 1
            goto L_0x0141
        L_0x0140:
            r1 = 0
        L_0x0141:
            int r6 = java.lang.Math.abs(r22)
            if (r1 == 0) goto L_0x0148
            r7 = 4
        L_0x0148:
            if (r6 > r7) goto L_0x0184
            if (r1 == 0) goto L_0x014f
            r5 = 88
            goto L_0x0151
        L_0x014f:
            r5 = 112(0x70, float:1.57E-43)
        L_0x0151:
            int r7 = r6 << 4
            int r5 = r5 + r7
            int r5 = r5 * r6
            int[] r7 = f2664
            r7 = r7[r6]
            int r9 = r5 % r7
            int r9 = r5 - r9
            com.wpengapp.support.ࢤ r0 = m2563(r0, r7)
            int r14 = r0.f2829
            int r3 = r3 + r14
            if (r3 > r9) goto L_0x017c
            if (r1 == 0) goto L_0x0176
            int r3 = r7 << 6
            if (r14 > r3) goto L_0x016e
            goto L_0x0176
        L_0x016e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data to large for user specified layer"
            r0.<init>(r1)
            throw r0
        L_0x0176:
            r14 = r0
            r16 = r1
            r2 = r5
            r15 = r7
            goto L_0x01e0
        L_0x017c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data to large for user specified layer"
            r0.<init>(r1)
            throw r0
        L_0x0184:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r1[r2] = r3
            java.lang.String r2 = "Illegal value %s for layers"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x0198:
            r6 = 0
            r14 = 0
            r15 = 0
        L_0x019b:
            if (r6 > r7) goto L_0x03a4
            if (r6 > r9) goto L_0x01a2
            r16 = 1
            goto L_0x01a4
        L_0x01a2:
            r16 = 0
        L_0x01a4:
            if (r16 == 0) goto L_0x01a9
            int r17 = r6 + 1
            goto L_0x01ab
        L_0x01a9:
            r17 = r6
        L_0x01ab:
            if (r16 == 0) goto L_0x01b0
            r18 = 88
            goto L_0x01b2
        L_0x01b0:
            r18 = 112(0x70, float:1.57E-43)
        L_0x01b2:
            int r19 = r17 << 4
            int r18 = r18 + r19
            int r2 = r18 * r17
            if (r1 > r2) goto L_0x0396
            if (r14 == 0) goto L_0x01c2
            int[] r18 = f2664
            r5 = r18[r17]
            if (r15 == r5) goto L_0x01cb
        L_0x01c2:
            int[] r5 = f2664
            r5 = r5[r17]
            com.wpengapp.support.ࢤ r14 = m2563(r0, r5)
            r15 = r5
        L_0x01cb:
            int r5 = r2 % r15
            int r5 = r2 - r5
            if (r16 == 0) goto L_0x01d7
            int r7 = r14.f2829
            int r9 = r15 << 6
            if (r7 > r9) goto L_0x0396
        L_0x01d7:
            int r7 = r14.f2829
            int r7 = r7 + r3
            if (r7 <= r5) goto L_0x01de
            goto L_0x0396
        L_0x01de:
            r6 = r17
        L_0x01e0:
            com.wpengapp.support.ࢤ r0 = m2564((com.wpengapp.support.BitArray) r14, (int) r2, (int) r15)
            int r1 = r14.f2829
            int r1 = r1 / r15
            com.wpengapp.support.ࢤ r2 = new com.wpengapp.support.ࢤ
            r2.<init>()
            if (r16 == 0) goto L_0x0200
            int r3 = r6 + -1
            r2.mo9082(r3, r12)
            int r1 = r1 + -1
            r3 = 6
            r2.mo9082(r1, r3)
            r1 = 28
            com.wpengapp.support.ࢤ r1 = m2564((com.wpengapp.support.BitArray) r2, (int) r1, (int) r10)
            goto L_0x0210
        L_0x0200:
            int r3 = r6 + -1
            r2.mo9082(r3, r11)
            int r1 = r1 + -1
            r2.mo9082(r1, r4)
            r1 = 40
            com.wpengapp.support.ࢤ r1 = m2564((com.wpengapp.support.BitArray) r2, (int) r1, (int) r10)
        L_0x0210:
            if (r16 == 0) goto L_0x0213
            goto L_0x0215
        L_0x0213:
            r4 = 14
        L_0x0215:
            int r2 = r6 << 2
            int r4 = r4 + r2
            int[] r2 = new int[r4]
            if (r16 == 0) goto L_0x0227
            r3 = 0
        L_0x021d:
            int r5 = r2.length
            if (r3 >= r5) goto L_0x0225
            r2[r3] = r3
            int r3 = r3 + 1
            goto L_0x021d
        L_0x0225:
            r3 = r4
            goto L_0x024b
        L_0x0227:
            int r3 = r4 + 1
            int r5 = r4 / 2
            int r7 = r5 + -1
            int r7 = r7 / 15
            int r7 = r7 * 2
            int r3 = r3 + r7
            int r7 = r3 / 2
            r9 = 0
        L_0x0235:
            if (r9 >= r5) goto L_0x024b
            int r10 = r9 / 15
            int r10 = r10 + r9
            int r14 = r5 - r9
            int r14 = r14 - r13
            int r15 = r7 - r10
            int r15 = r15 - r13
            r2[r14] = r15
            int r14 = r5 + r9
            int r10 = r10 + r7
            int r10 = r10 + r13
            r2[r14] = r10
            int r9 = r9 + 1
            goto L_0x0235
        L_0x024b:
            com.wpengapp.support.ࢥ r5 = new com.wpengapp.support.ࢥ
            r5.<init>(r3, r3)
            r7 = 0
            r9 = 0
        L_0x0252:
            if (r7 >= r6) goto L_0x02e1
            int r10 = r6 - r7
            int r10 = r10 << r12
            if (r16 == 0) goto L_0x025c
            r14 = 9
            goto L_0x025e
        L_0x025c:
            r14 = 12
        L_0x025e:
            int r10 = r10 + r14
            r14 = 0
        L_0x0260:
            if (r14 >= r10) goto L_0x02d7
            int r15 = r14 << 1
            r13 = 0
        L_0x0265:
            if (r13 >= r12) goto L_0x02d1
            int r18 = r9 + r15
            int r12 = r18 + r13
            boolean r12 = r0.mo9085(r12)
            if (r12 == 0) goto L_0x027d
            int r12 = r7 << 1
            int r18 = r12 + r13
            r11 = r2[r18]
            int r12 = r12 + r14
            r12 = r2[r12]
            r5.mo9094(r11, r12)
        L_0x027d:
            int r11 = r10 << 1
            int r11 = r11 + r9
            int r11 = r11 + r15
            int r11 = r11 + r13
            boolean r11 = r0.mo9085(r11)
            if (r11 == 0) goto L_0x0299
            int r11 = r7 << 1
            int r12 = r11 + r14
            r12 = r2[r12]
            int r18 = r4 + -1
            int r18 = r18 - r11
            int r18 = r18 - r13
            r11 = r2[r18]
            r5.mo9094(r12, r11)
        L_0x0299:
            int r11 = r10 << 2
            int r11 = r11 + r9
            int r11 = r11 + r15
            int r11 = r11 + r13
            boolean r11 = r0.mo9085(r11)
            if (r11 == 0) goto L_0x02b3
            int r11 = r4 + -1
            int r12 = r7 << 1
            int r11 = r11 - r12
            int r12 = r11 - r13
            r12 = r2[r12]
            int r11 = r11 - r14
            r11 = r2[r11]
            r5.mo9094(r12, r11)
        L_0x02b3:
            int r11 = r10 * 6
            int r11 = r11 + r9
            int r11 = r11 + r15
            int r11 = r11 + r13
            boolean r11 = r0.mo9085(r11)
            if (r11 == 0) goto L_0x02cc
            int r11 = r4 + -1
            int r12 = r7 << 1
            int r11 = r11 - r12
            int r11 = r11 - r14
            r11 = r2[r11]
            int r12 = r12 + r13
            r12 = r2[r12]
            r5.mo9094(r11, r12)
        L_0x02cc:
            int r13 = r13 + 1
            r11 = 5
            r12 = 2
            goto L_0x0265
        L_0x02d1:
            int r14 = r14 + 1
            r11 = 5
            r12 = 2
            r13 = 1
            goto L_0x0260
        L_0x02d7:
            int r10 = r10 << 3
            int r9 = r9 + r10
            int r7 = r7 + 1
            r11 = 5
            r12 = 2
            r13 = 1
            goto L_0x0252
        L_0x02e1:
            int r0 = r3 / 2
            r2 = 7
            if (r16 == 0) goto L_0x0321
            r6 = 0
        L_0x02e7:
            if (r6 >= r2) goto L_0x035f
            int r7 = r0 + -3
            int r7 = r7 + r6
            boolean r8 = r1.mo9085(r6)
            if (r8 == 0) goto L_0x02f7
            int r8 = r0 + -5
            r5.mo9094(r7, r8)
        L_0x02f7:
            int r8 = r6 + 7
            boolean r8 = r1.mo9085(r8)
            if (r8 == 0) goto L_0x0304
            int r8 = r0 + 5
            r5.mo9094(r8, r7)
        L_0x0304:
            int r8 = 20 - r6
            boolean r8 = r1.mo9085(r8)
            if (r8 == 0) goto L_0x0311
            int r8 = r0 + 5
            r5.mo9094(r7, r8)
        L_0x0311:
            int r8 = 27 - r6
            boolean r8 = r1.mo9085(r8)
            if (r8 == 0) goto L_0x031e
            int r8 = r0 + -5
            r5.mo9094(r8, r7)
        L_0x031e:
            int r6 = r6 + 1
            goto L_0x02e7
        L_0x0321:
            r6 = 0
        L_0x0322:
            if (r6 >= r8) goto L_0x035f
            int r7 = r0 + -5
            int r7 = r7 + r6
            int r9 = r6 / 5
            int r9 = r9 + r7
            boolean r7 = r1.mo9085(r6)
            if (r7 == 0) goto L_0x0335
            int r7 = r0 + -7
            r5.mo9094(r9, r7)
        L_0x0335:
            int r7 = r6 + 10
            boolean r7 = r1.mo9085(r7)
            if (r7 == 0) goto L_0x0342
            int r7 = r0 + 7
            r5.mo9094(r7, r9)
        L_0x0342:
            int r7 = 29 - r6
            boolean r7 = r1.mo9085(r7)
            if (r7 == 0) goto L_0x034f
            int r7 = r0 + 7
            r5.mo9094(r9, r7)
        L_0x034f:
            int r7 = 39 - r6
            boolean r7 = r1.mo9085(r7)
            if (r7 == 0) goto L_0x035c
            int r7 = r0 + -7
            r5.mo9094(r7, r9)
        L_0x035c:
            int r6 = r6 + 1
            goto L_0x0322
        L_0x035f:
            if (r16 == 0) goto L_0x0366
            r7 = 5
            m2565((com.wpengapp.support.BitMatrix) r5, (int) r0, (int) r7)
            goto L_0x038e
        L_0x0366:
            m2565((com.wpengapp.support.BitMatrix) r5, (int) r0, (int) r2)
            r1 = 0
            r2 = 0
            r9 = 2
        L_0x036c:
            int r6 = r4 / 2
            r11 = 1
            int r6 = r6 - r11
            if (r1 >= r6) goto L_0x038e
            r6 = r0 & 1
        L_0x0374:
            if (r6 >= r3) goto L_0x0389
            int r7 = r0 - r2
            r5.mo9094(r7, r6)
            int r8 = r0 + r2
            r5.mo9094(r8, r6)
            r5.mo9094(r6, r7)
            r5.mo9094(r6, r8)
            int r6 = r6 + 2
            goto L_0x0374
        L_0x0389:
            int r1 = r1 + 15
            int r2 = r2 + 16
            goto L_0x036c
        L_0x038e:
            com.wpengapp.support.ޢ r0 = new com.wpengapp.support.ޢ
            r0.<init>()
            r0.f2661 = r5
            return r0
        L_0x0396:
            r7 = 5
            r9 = 2
            r11 = 1
            int r6 = r6 + 1
            r2 = 0
            r7 = 32
            r9 = 3
            r11 = 5
            r12 = 2
            r13 = 1
            goto L_0x019b
        L_0x03a4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data too large for an Aztec code"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0959.m2562(byte[], int, int):com.wpengapp.support.ޢ");
    }

    /* renamed from: ֏ */
    public static void m2565(BitMatrix r4, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                r4.mo9094(i5, i4);
                r4.mo9094(i5, i6);
                r4.mo9094(i4, i5);
                r4.mo9094(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        r4.mo9094(i7, i7);
        int i8 = i7 + 1;
        r4.mo9094(i8, i7);
        r4.mo9094(i7, i8);
        int i9 = i + i2;
        r4.mo9094(i9, i7);
        r4.mo9094(i9, i8);
        r4.mo9094(i9, i9 - 1);
    }

    /* renamed from: ֏ */
    public static BitArray m2563(BitArray r9, int i) {
        BitArray r0 = new BitArray();
        int i2 = r9.f2829;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = i4 + i6;
                if (i7 >= i2 || r9.mo9085(i7)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                r0.mo9082(i8, i);
            } else if (i8 == 0) {
                r0.mo9082(i5 | 1, i);
            } else {
                r0.mo9082(i5, i);
                i4 += i;
            }
            i4--;
            i4 += i;
        }
        return r0;
    }
}
