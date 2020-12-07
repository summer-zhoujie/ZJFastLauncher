package com.wpengapp.support;

import com.wpengapp.support.Version;

/* renamed from: com.wpengapp.support.ˉ */
public final class Encoder {

    /* renamed from: ֏ */
    public static final int[] f1505 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: ֏ */
    public static boolean m1579(int i, Version r2, ErrorCorrectionLevel r3) {
        int i2 = r2.f2353;
        Version.C0868 r22 = r2.f2352[r3.ordinal()];
        return i2 - (r22.mo8820() * r22.f2356) >= (i + 7) / 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0138 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0129 A[LOOP:2: B:73:0x00f7->B:87:0x0129, LOOP_END] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static QRCode m1577(String r25, com.wpengapp.support.ErrorCorrectionLevel r26, java.util.Map<com.wpengapp.support.EncodeHintType, ?> r27) {
        /*
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0014
            com.wpengapp.support.ޛ r5 = com.wpengapp.support.EncodeHintType.CHARACTER_SET
            boolean r5 = r2.containsKey(r5)
            if (r5 == 0) goto L_0x0014
            r5 = 1
            goto L_0x0015
        L_0x0014:
            r5 = 0
        L_0x0015:
            if (r5 == 0) goto L_0x0022
            com.wpengapp.support.ޛ r6 = com.wpengapp.support.EncodeHintType.CHARACTER_SET
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = r6.toString()
            goto L_0x0024
        L_0x0022:
            java.lang.String r6 = "ISO-8859-1"
        L_0x0024:
            java.lang.String r7 = "Shift_JIS"
            boolean r8 = r7.equals(r6)
            r9 = -1
            if (r8 == 0) goto L_0x005a
            byte[] r8 = r0.getBytes(r7)     // Catch:{ UnsupportedEncodingException -> 0x0054 }
            int r10 = r8.length
            int r11 = r10 % 2
            if (r11 == 0) goto L_0x0037
            goto L_0x0054
        L_0x0037:
            r11 = 0
        L_0x0038:
            if (r11 >= r10) goto L_0x0052
            byte r12 = r8[r11]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r13 = 129(0x81, float:1.81E-43)
            if (r12 < r13) goto L_0x0046
            r13 = 159(0x9f, float:2.23E-43)
            if (r12 <= r13) goto L_0x004f
        L_0x0046:
            r13 = 224(0xe0, float:3.14E-43)
            if (r12 < r13) goto L_0x0054
            r13 = 235(0xeb, float:3.3E-43)
            if (r12 <= r13) goto L_0x004f
            goto L_0x0054
        L_0x004f:
            int r11 = r11 + 2
            goto L_0x0038
        L_0x0052:
            r8 = 1
            goto L_0x0055
        L_0x0054:
            r8 = 0
        L_0x0055:
            if (r8 == 0) goto L_0x005a
            com.wpengapp.support.ˋ r8 = com.wpengapp.support.Mode.KANJI
            goto L_0x008a
        L_0x005a:
            r8 = 0
            r10 = 0
            r11 = 0
        L_0x005d:
            int r12 = r25.length()
            if (r8 >= r12) goto L_0x007e
            char r12 = r0.charAt(r8)
            r13 = 48
            if (r12 < r13) goto L_0x0071
            r13 = 57
            if (r12 > r13) goto L_0x0071
            r11 = 1
            goto L_0x0078
        L_0x0071:
            int r10 = m1575(r12)
            if (r10 == r9) goto L_0x007b
            r10 = 1
        L_0x0078:
            int r8 = r8 + 1
            goto L_0x005d
        L_0x007b:
            com.wpengapp.support.ˋ r8 = com.wpengapp.support.Mode.BYTE
            goto L_0x008a
        L_0x007e:
            if (r10 == 0) goto L_0x0083
            com.wpengapp.support.ˋ r8 = com.wpengapp.support.Mode.ALPHANUMERIC
            goto L_0x008a
        L_0x0083:
            if (r11 == 0) goto L_0x0088
            com.wpengapp.support.ˋ r8 = com.wpengapp.support.Mode.NUMERIC
            goto L_0x008a
        L_0x0088:
            com.wpengapp.support.ˋ r8 = com.wpengapp.support.Mode.BYTE
        L_0x008a:
            com.wpengapp.support.ࢤ r10 = new com.wpengapp.support.ࢤ
            r10.<init>()
            com.wpengapp.support.ˋ r11 = com.wpengapp.support.Mode.BYTE
            r12 = 4
            r13 = 8
            if (r8 != r11) goto L_0x00b0
            if (r5 == 0) goto L_0x00b0
            java.util.Map<java.lang.String, com.wpengapp.support.ࢦ> r5 = com.wpengapp.support.CharacterSetECI.f2862
            java.lang.Object r5 = r5.get(r6)
            com.wpengapp.support.ࢦ r5 = (com.wpengapp.support.CharacterSetECI) r5
            if (r5 == 0) goto L_0x00b0
            com.wpengapp.support.ˋ r11 = com.wpengapp.support.Mode.ECI
            int r11 = r11.f1524
            r10.mo9082(r11, r12)
            int[] r5 = r5.f2864
            r5 = r5[r3]
            r10.mo9082(r5, r13)
        L_0x00b0:
            if (r2 == 0) goto L_0x00bc
            com.wpengapp.support.ޛ r5 = com.wpengapp.support.EncodeHintType.GS1_FORMAT
            boolean r5 = r2.containsKey(r5)
            if (r5 == 0) goto L_0x00bc
            r5 = 1
            goto L_0x00bd
        L_0x00bc:
            r5 = 0
        L_0x00bd:
            if (r5 == 0) goto L_0x00d8
            com.wpengapp.support.ޛ r5 = com.wpengapp.support.EncodeHintType.GS1_FORMAT
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = r5.toString()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00d8
            com.wpengapp.support.ˋ r5 = com.wpengapp.support.Mode.FNC1_FIRST_POSITION
            m1578((com.wpengapp.support.Mode) r5, (com.wpengapp.support.BitArray) r10)
        L_0x00d8:
            m1578((com.wpengapp.support.Mode) r8, (com.wpengapp.support.BitArray) r10)
            com.wpengapp.support.ࢤ r5 = new com.wpengapp.support.ࢤ
            r5.<init>()
            int r11 = r8.ordinal()
            r14 = 7
            r15 = 10
            if (r11 == r4) goto L_0x01ab
            r3 = 6
            r4 = 2
            if (r11 == r4) goto L_0x0170
            if (r11 == r12) goto L_0x0158
            if (r11 != r3) goto L_0x0148
            byte[] r3 = r0.getBytes(r7)     // Catch:{ UnsupportedEncodingException -> 0x0140 }
            int r4 = r3.length
            r6 = 0
        L_0x00f7:
            if (r6 >= r4) goto L_0x01ec
            byte r7 = r3[r6]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r11 = r6 + 1
            byte r11 = r3[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r13
            r7 = r7 | r11
            r11 = 33088(0x8140, float:4.6366E-41)
            if (r7 < r11) goto L_0x0113
            r11 = 40956(0x9ffc, float:5.7392E-41)
            if (r7 > r11) goto L_0x0113
            r18 = 33088(0x8140, float:4.6366E-41)
            goto L_0x0123
        L_0x0113:
            r11 = 57408(0xe040, float:8.0446E-41)
            if (r7 < r11) goto L_0x0126
            r11 = 60351(0xebbf, float:8.457E-41)
            if (r7 > r11) goto L_0x0126
            r11 = 49472(0xc140, float:6.9325E-41)
            r18 = 49472(0xc140, float:6.9325E-41)
        L_0x0123:
            int r7 = r7 - r18
            goto L_0x0127
        L_0x0126:
            r7 = -1
        L_0x0127:
            if (r7 == r9) goto L_0x0138
            int r11 = r7 >> 8
            int r11 = r11 * 192
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r11 = r11 + r7
            r7 = 13
            r5.mo9082(r11, r7)
            int r6 = r6 + 2
            goto L_0x00f7
        L_0x0138:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Invalid byte sequence"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0140:
            r0 = move-exception
            r1 = r0
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x0148:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = java.lang.String.valueOf(r8)
            java.lang.String r2 = "Invalid mode: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0158:
            byte[] r3 = r0.getBytes(r6)     // Catch:{ UnsupportedEncodingException -> 0x0168 }
            int r4 = r3.length
            r6 = 0
        L_0x015e:
            if (r6 >= r4) goto L_0x01ec
            byte r7 = r3[r6]
            r5.mo9082(r7, r13)
            int r6 = r6 + 1
            goto L_0x015e
        L_0x0168:
            r0 = move-exception
            r1 = r0
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x0170:
            int r4 = r25.length()
            r6 = 0
        L_0x0175:
            if (r6 >= r4) goto L_0x01ec
            char r7 = r0.charAt(r6)
            int r7 = m1575(r7)
            if (r7 == r9) goto L_0x01a5
            int r11 = r6 + 1
            if (r11 >= r4) goto L_0x01a0
            char r11 = r0.charAt(r11)
            int r11 = m1575(r11)
            if (r11 == r9) goto L_0x019a
            int r7 = r7 * 45
            int r7 = r7 + r11
            r11 = 11
            r5.mo9082(r7, r11)
            int r6 = r6 + 2
            goto L_0x0175
        L_0x019a:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            r0.<init>()
            throw r0
        L_0x01a0:
            r5.mo9082(r7, r3)
            r6 = r11
            goto L_0x0175
        L_0x01a5:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            r0.<init>()
            throw r0
        L_0x01ab:
            int r3 = r25.length()
            r4 = 0
        L_0x01b0:
            if (r4 >= r3) goto L_0x01ec
            char r6 = r0.charAt(r4)
            int r6 = r6 + -48
            int r7 = r4 + 2
            if (r7 >= r3) goto L_0x01d6
            int r11 = r4 + 1
            char r11 = r0.charAt(r11)
            int r11 = r11 + -48
            char r7 = r0.charAt(r7)
            int r7 = r7 + -48
            int r6 = r6 * 100
            int r11 = r11 * 10
            int r11 = r11 + r6
            int r11 = r11 + r7
            r5.mo9082(r11, r15)
            int r4 = r4 + 3
            goto L_0x01b0
        L_0x01d6:
            int r4 = r4 + 1
            if (r4 >= r3) goto L_0x01e8
            char r4 = r0.charAt(r4)
            int r4 = r4 + -48
            int r6 = r6 * 10
            int r6 = r6 + r4
            r5.mo9082(r6, r14)
            r4 = r7
            goto L_0x01b0
        L_0x01e8:
            r5.mo9082(r6, r12)
            goto L_0x01b0
        L_0x01ec:
            if (r2 == 0) goto L_0x0221
            com.wpengapp.support.ޛ r3 = com.wpengapp.support.EncodeHintType.QR_VERSION
            boolean r3 = r2.containsKey(r3)
            if (r3 == 0) goto L_0x0221
            com.wpengapp.support.ޛ r3 = com.wpengapp.support.EncodeHintType.QR_VERSION
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = r2.toString()
            int r2 = java.lang.Integer.parseInt(r2)
            com.wpengapp.support.ٴ r2 = com.wpengapp.support.Version.m2292(r2)
            int r3 = r10.f2829
            int r4 = r8.mo8344(r2)
            int r4 = r4 + r3
            int r3 = r5.f2829
            int r4 = r4 + r3
            boolean r3 = m1579((int) r4, (com.wpengapp.support.Version) r2, (com.wpengapp.support.ErrorCorrectionLevel) r1)
            if (r3 == 0) goto L_0x0219
            goto L_0x0242
        L_0x0219:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Data too big for requested version"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0221:
            r2 = 1
            com.wpengapp.support.ٴ r3 = com.wpengapp.support.Version.m2292(r2)
            int r2 = r10.f2829
            int r3 = r8.mo8344(r3)
            int r3 = r3 + r2
            int r2 = r5.f2829
            int r3 = r3 + r2
            com.wpengapp.support.ٴ r2 = m1576((int) r3, (com.wpengapp.support.ErrorCorrectionLevel) r1)
            int r3 = r10.f2829
            int r2 = r8.mo8344(r2)
            int r2 = r2 + r3
            int r3 = r5.f2829
            int r2 = r2 + r3
            com.wpengapp.support.ٴ r2 = m1576((int) r2, (com.wpengapp.support.ErrorCorrectionLevel) r1)
        L_0x0242:
            com.wpengapp.support.ࢤ r3 = new com.wpengapp.support.ࢤ
            r3.<init>()
            r3.mo9083((com.wpengapp.support.BitArray) r10)
            com.wpengapp.support.ˋ r4 = com.wpengapp.support.Mode.BYTE
            if (r8 != r4) goto L_0x0253
            int r0 = r5.mo9080()
            goto L_0x0257
        L_0x0253:
            int r0 = r25.length()
        L_0x0257:
            int r4 = r8.mo8344(r2)
            r6 = 1
            int r7 = r6 << r4
            if (r0 >= r7) goto L_0x05f8
            r3.mo9082(r0, r4)
            r3.mo9083((com.wpengapp.support.BitArray) r5)
            com.wpengapp.support.ٴ$ؠ[] r0 = r2.f2352
            int r4 = r26.ordinal()
            r0 = r0[r4]
            int r4 = r2.f2353
            int r5 = r0.f2356
            int r6 = r0.mo8820()
            int r6 = r6 * r5
            int r4 = r4 - r6
            int r5 = r4 << 3
            int r6 = r3.f2829
            if (r6 > r5) goto L_0x05da
            r6 = 0
        L_0x0280:
            if (r6 >= r12) goto L_0x028d
            int r7 = r3.f2829
            if (r7 >= r5) goto L_0x028d
            r7 = 0
            r3.mo9084((boolean) r7)
            int r6 = r6 + 1
            goto L_0x0280
        L_0x028d:
            r7 = 0
            int r6 = r3.f2829
            r6 = r6 & r14
            if (r6 <= 0) goto L_0x029c
        L_0x0293:
            if (r6 >= r13) goto L_0x029c
            r3.mo9084((boolean) r7)
            int r6 = r6 + 1
            r7 = 0
            goto L_0x0293
        L_0x029c:
            int r6 = r3.mo9080()
            int r6 = r4 - r6
            r7 = 0
        L_0x02a3:
            if (r7 >= r6) goto L_0x02b4
            r11 = r7 & 1
            if (r11 != 0) goto L_0x02ac
            r10 = 236(0xec, float:3.31E-43)
            goto L_0x02ae
        L_0x02ac:
            r10 = 17
        L_0x02ae:
            r3.mo9082(r10, r13)
            int r7 = r7 + 1
            goto L_0x02a3
        L_0x02b4:
            int r6 = r3.f2829
            if (r6 != r5) goto L_0x05d2
            int r5 = r2.f2353
            int r0 = r0.mo8820()
            int r6 = r3.mo9080()
            if (r6 != r4) goto L_0x05ca
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r0)
            r7 = 0
            r9 = 0
            r11 = 0
            r15 = 0
        L_0x02cd:
            if (r7 >= r0) goto L_0x03be
            r10 = 1
            int[] r12 = new int[r10]
            int[] r14 = new int[r10]
            if (r7 >= r0) goto L_0x03b6
            int r10 = r5 % r0
            int r13 = r0 - r10
            int r21 = r5 / r0
            int r22 = r21 + 1
            int r23 = r4 / r0
            int r24 = r23 + 1
            r27 = r2
            int r2 = r21 - r23
            r21 = r8
            int r8 = r22 - r24
            if (r2 != r8) goto L_0x03ae
            int r1 = r13 + r10
            if (r0 != r1) goto L_0x03a6
            int r1 = r23 + r2
            int r1 = r1 * r13
            int r22 = r24 + r8
            int r22 = r22 * r10
            int r1 = r22 + r1
            if (r5 != r1) goto L_0x039e
            if (r7 >= r13) goto L_0x0304
            r1 = 0
            r12[r1] = r23
            r14[r1] = r2
            goto L_0x0309
        L_0x0304:
            r1 = 0
            r12[r1] = r24
            r14[r1] = r8
        L_0x0309:
            r2 = r12[r1]
            byte[] r1 = new byte[r2]
            int r8 = r11 << 3
            r10 = r8
            r8 = 0
        L_0x0311:
            if (r8 >= r2) goto L_0x0344
            r22 = r0
            r23 = r5
            r0 = r10
            r5 = 8
            r10 = 0
            r13 = 0
        L_0x031c:
            if (r10 >= r5) goto L_0x0336
            boolean r5 = r3.mo9085(r0)
            if (r5 == 0) goto L_0x032e
            r5 = 7
            int r20 = 7 - r10
            r17 = 1
            int r20 = r17 << r20
            r13 = r13 | r20
            goto L_0x032f
        L_0x032e:
            r5 = 7
        L_0x032f:
            int r0 = r0 + 1
            int r10 = r10 + 1
            r5 = 8
            goto L_0x031c
        L_0x0336:
            r5 = 7
            int r10 = r8 + 0
            byte r13 = (byte) r13
            r1[r10] = r13
            int r8 = r8 + 1
            r10 = r0
            r0 = r22
            r5 = r23
            goto L_0x0311
        L_0x0344:
            r22 = r0
            r23 = r5
            r0 = 0
            r5 = 7
            r8 = r14[r0]
            int r0 = r1.length
            int r10 = r0 + r8
            int[] r10 = new int[r10]
            r13 = 0
        L_0x0352:
            if (r13 >= r0) goto L_0x035d
            byte r14 = r1[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r10[r13] = r14
            int r13 = r13 + 1
            goto L_0x0352
        L_0x035d:
            com.wpengapp.support.ࢩ r13 = new com.wpengapp.support.ࢩ
            com.wpengapp.support.ࢧ r14 = com.wpengapp.support.GenericGF.f2870
            r13.<init>(r14)
            r13.mo9106(r10, r8)
            byte[] r13 = new byte[r8]
            r14 = 0
        L_0x036a:
            if (r14 >= r8) goto L_0x0377
            int r20 = r0 + r14
            r5 = r10[r20]
            byte r5 = (byte) r5
            r13[r14] = r5
            int r14 = r14 + 1
            r5 = 7
            goto L_0x036a
        L_0x0377:
            com.wpengapp.support.ˆ r0 = new com.wpengapp.support.ˆ
            r0.<init>(r1, r13)
            r6.add(r0)
            int r15 = java.lang.Math.max(r15, r2)
            int r0 = r13.length
            int r9 = java.lang.Math.max(r9, r0)
            r0 = 0
            r1 = r12[r0]
            int r11 = r11 + r1
            int r7 = r7 + 1
            r1 = r26
            r2 = r27
            r8 = r21
            r0 = r22
            r5 = r23
            r12 = 4
            r13 = 8
            r14 = 7
            goto L_0x02cd
        L_0x039e:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Total bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03a6:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "RS blocks mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03ae:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "EC bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03b6:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Block ID too large"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03be:
            r27 = r2
            r23 = r5
            r21 = r8
            if (r4 != r11) goto L_0x05c2
            com.wpengapp.support.ࢤ r0 = new com.wpengapp.support.ࢤ
            r0.<init>()
            r1 = 0
        L_0x03cc:
            if (r1 >= r15) goto L_0x03ee
            java.util.Iterator r2 = r6.iterator()
        L_0x03d2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03eb
            java.lang.Object r3 = r2.next()
            com.wpengapp.support.ˆ r3 = (com.wpengapp.support.BlockPair) r3
            byte[] r3 = r3.f1499
            int r4 = r3.length
            if (r1 >= r4) goto L_0x03d2
            byte r3 = r3[r1]
            r4 = 8
            r0.mo9082(r3, r4)
            goto L_0x03d2
        L_0x03eb:
            int r1 = r1 + 1
            goto L_0x03cc
        L_0x03ee:
            r1 = 0
        L_0x03ef:
            if (r1 >= r9) goto L_0x0411
            java.util.Iterator r2 = r6.iterator()
        L_0x03f5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x040e
            java.lang.Object r3 = r2.next()
            com.wpengapp.support.ˆ r3 = (com.wpengapp.support.BlockPair) r3
            byte[] r3 = r3.f1500
            int r4 = r3.length
            if (r1 >= r4) goto L_0x03f5
            byte r3 = r3[r1]
            r4 = 8
            r0.mo9082(r3, r4)
            goto L_0x03f5
        L_0x040e:
            int r1 = r1 + 1
            goto L_0x03ef
        L_0x0411:
            int r1 = r0.mo9080()
            r2 = r23
            if (r2 != r1) goto L_0x059c
            com.wpengapp.support.ࠤ r1 = new com.wpengapp.support.ࠤ
            r1.<init>()
            r2 = r26
            r1.f2791 = r2
            r8 = r21
            r1.f2790 = r8
            r3 = r27
            r1.f2792 = r3
            int r4 = r3.f2351
            r5 = 4
            int r4 = r4 * 4
            r5 = 17
            int r4 = r4 + r5
            com.wpengapp.support.ˇ r5 = new com.wpengapp.support.ˇ
            r5.<init>(r4, r4)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r4 = 0
            r6 = -1
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x043f:
            r8 = 8
            if (r4 >= r8) goto L_0x058e
            com.wpengapp.support.MatrixUtil.m2635(r0, r2, r3, r4, r5)
            r9 = 1
            int r10 = com.wpengapp.support.C1279.m3383((com.wpengapp.support.ByteMatrix) r5, (boolean) r9)
            r9 = 0
            int r11 = com.wpengapp.support.C1279.m3383((com.wpengapp.support.ByteMatrix) r5, (boolean) r9)
            int r11 = r11 + r10
            byte[][] r10 = r5.f1501
            int r12 = r5.f1502
            int r13 = r5.f1503
            r14 = 0
            r15 = 0
            r16 = -1
        L_0x045b:
            int r8 = r13 + -1
            if (r14 >= r8) goto L_0x048f
            r8 = r10[r14]
            r19 = r15
            r15 = 0
        L_0x0464:
            int r9 = r12 + -1
            if (r15 >= r9) goto L_0x0487
            byte r9 = r8[r15]
            int r20 = r15 + 1
            r21 = r12
            byte r12 = r8[r20]
            if (r9 != r12) goto L_0x0482
            int r12 = r14 + 1
            r22 = r10[r12]
            byte r15 = r22[r15]
            if (r9 != r15) goto L_0x0482
            r12 = r10[r12]
            byte r12 = r12[r20]
            if (r9 != r12) goto L_0x0482
            int r19 = r19 + 1
        L_0x0482:
            r15 = r20
            r12 = r21
            goto L_0x0464
        L_0x0487:
            r21 = r12
            int r14 = r14 + 1
            r15 = r19
            r9 = 0
            goto L_0x045b
        L_0x048f:
            int r15 = r15 * 3
            int r15 = r15 + r11
            byte[][] r8 = r5.f1501
            int r9 = r5.f1502
            int r10 = r5.f1503
            r11 = 0
            r12 = 0
        L_0x049a:
            if (r11 >= r10) goto L_0x054a
            r13 = r12
            r12 = 0
        L_0x049e:
            if (r12 >= r9) goto L_0x053f
            r14 = r8[r11]
            r25 = r0
            int r0 = r12 + 6
            if (r0 >= r9) goto L_0x04e6
            r19 = r9
            byte r9 = r14[r12]
            r2 = 1
            if (r9 != r2) goto L_0x04e8
            int r9 = r12 + 1
            byte r9 = r14[r9]
            if (r9 != 0) goto L_0x04e8
            int r9 = r12 + 2
            byte r9 = r14[r9]
            if (r9 != r2) goto L_0x04e8
            int r9 = r12 + 3
            byte r9 = r14[r9]
            if (r9 != r2) goto L_0x04e8
            int r9 = r12 + 4
            byte r9 = r14[r9]
            if (r9 != r2) goto L_0x04e8
            int r9 = r12 + 5
            byte r9 = r14[r9]
            if (r9 != 0) goto L_0x04e8
            byte r0 = r14[r0]
            if (r0 != r2) goto L_0x04e8
            int r0 = r12 + -4
            boolean r0 = com.wpengapp.support.C1279.m3420((byte[]) r14, (int) r0, (int) r12)
            if (r0 != 0) goto L_0x04e3
            int r0 = r12 + 7
            int r2 = r12 + 11
            boolean r0 = com.wpengapp.support.C1279.m3420((byte[]) r14, (int) r0, (int) r2)
            if (r0 == 0) goto L_0x04e8
        L_0x04e3:
            int r13 = r13 + 1
            goto L_0x04e8
        L_0x04e6:
            r19 = r9
        L_0x04e8:
            int r0 = r11 + 6
            if (r0 >= r10) goto L_0x0535
            r2 = r8[r11]
            byte r2 = r2[r12]
            r9 = 1
            if (r2 != r9) goto L_0x0535
            int r2 = r11 + 1
            r2 = r8[r2]
            byte r2 = r2[r12]
            if (r2 != 0) goto L_0x0535
            int r2 = r11 + 2
            r2 = r8[r2]
            byte r2 = r2[r12]
            if (r2 != r9) goto L_0x0535
            int r2 = r11 + 3
            r2 = r8[r2]
            byte r2 = r2[r12]
            if (r2 != r9) goto L_0x0535
            int r2 = r11 + 4
            r2 = r8[r2]
            byte r2 = r2[r12]
            if (r2 != r9) goto L_0x0535
            int r2 = r11 + 5
            r2 = r8[r2]
            byte r2 = r2[r12]
            if (r2 != 0) goto L_0x0535
            r0 = r8[r0]
            byte r0 = r0[r12]
            if (r0 != r9) goto L_0x0535
            int r0 = r11 + -4
            boolean r0 = com.wpengapp.support.C1279.m3422((byte[][]) r8, (int) r12, (int) r0, (int) r11)
            if (r0 != 0) goto L_0x0533
            int r0 = r11 + 7
            int r2 = r11 + 11
            boolean r0 = com.wpengapp.support.C1279.m3422((byte[][]) r8, (int) r12, (int) r0, (int) r2)
            if (r0 == 0) goto L_0x0535
        L_0x0533:
            int r13 = r13 + 1
        L_0x0535:
            int r12 = r12 + 1
            r0 = r25
            r2 = r26
            r9 = r19
            goto L_0x049e
        L_0x053f:
            r25 = r0
            r19 = r9
            int r11 = r11 + 1
            r2 = r26
            r12 = r13
            goto L_0x049a
        L_0x054a:
            r25 = r0
            int r12 = r12 * 40
            int r12 = r12 + r15
            byte[][] r0 = r5.f1501
            int r2 = r5.f1502
            int r8 = r5.f1503
            r9 = 0
            r10 = 0
        L_0x0557:
            if (r9 >= r8) goto L_0x056d
            r11 = r0[r9]
            r13 = r10
            r10 = 0
        L_0x055d:
            if (r10 >= r2) goto L_0x0569
            byte r14 = r11[r10]
            r15 = 1
            if (r14 != r15) goto L_0x0566
            int r13 = r13 + 1
        L_0x0566:
            int r10 = r10 + 1
            goto L_0x055d
        L_0x0569:
            int r9 = r9 + 1
            r10 = r13
            goto L_0x0557
        L_0x056d:
            int r0 = r5.f1503
            int r2 = r5.f1502
            int r0 = r0 * r2
            int r2 = r10 << 1
            int r2 = r2 - r0
            int r2 = java.lang.Math.abs(r2)
            r8 = 10
            int r2 = r2 * 10
            int r2 = r2 / r0
            int r2 = r2 * 10
            int r2 = r2 + r12
            if (r2 >= r7) goto L_0x0586
            r7 = r2
            r6 = r4
        L_0x0586:
            int r4 = r4 + 1
            r0 = r25
            r2 = r26
            goto L_0x043f
        L_0x058e:
            r25 = r0
            r1.f2793 = r6
            r4 = r25
            r0 = r26
            com.wpengapp.support.MatrixUtil.m2635(r4, r0, r3, r6, r5)
            r1.f2794 = r5
            return r1
        L_0x059c:
            r4 = r0
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Interleaving error: "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = " and "
            r1.append(r2)
            int r2 = r4.mo9080()
            r1.append(r2)
            java.lang.String r2 = " differ."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05c2:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Data bytes does not match offset"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05ca:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Number of bits and data bytes does not match"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05d2:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.String r1 = "Bits size does not equal capacity"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05da:
            com.wpengapp.support.ޠ r0 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "data bits cannot fit in the QR Code"
            r1.<init>(r2)
            int r2 = r3.f2829
            r1.append(r2)
            java.lang.String r2 = " > "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05f8:
            com.wpengapp.support.ޠ r1 = new com.wpengapp.support.ޠ
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " is bigger than "
            r2.append(r0)
            r0 = 1
            int r7 = r7 - r0
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Encoder.m1577(java.lang.String, com.wpengapp.support.ˊ, java.util.Map):com.wpengapp.support.ࠤ");
    }

    /* renamed from: ֏ */
    public static void m1578(Mode r1, BitArray r2) {
        r2.mo9082(r1.f1524, 4);
    }

    /* renamed from: ֏ */
    public static int m1575(int i) {
        int[] iArr = f1505;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    /* renamed from: ֏ */
    public static Version m1576(int i, ErrorCorrectionLevel r4) {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version r1 = Version.m2292(i2);
            if (m1579(i, r1, r4)) {
                return r1;
            }
        }
        throw new WriterException("Data too big");
    }
}
