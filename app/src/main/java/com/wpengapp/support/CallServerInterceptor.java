package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ƙ */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: ֏ */
    public final boolean f929;

    /* renamed from: com.wpengapp.support.Ƙ$֏ */
    /* compiled from: CallServerInterceptor */
    static final class C0513 extends ForwardingSink {

        /* renamed from: ؠ */
        public long f930;

        public C0513(Sink r1) {
            super(r1);
        }

        /* renamed from: ֏ */
        public void mo7985(Buffer r3, long j) {
            this.f2421.mo7985(r3, j);
            this.f930 += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f929 = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0119, code lost:
        if ("close".equalsIgnoreCase(r0) != false) goto L_0x011b;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Response mo7909(C1094 r13) {
        /*
            r12 = this;
            com.wpengapp.support.ய r13 = (com.wpengapp.support.RealInterceptorChain) r13
            com.wpengapp.support.ຊ r0 = r13.f3284
            com.wpengapp.support.ܥ r1 = r13.f3283
            com.wpengapp.support.Ռ r2 = r13.f3285
            com.wpengapp.support.ټ r3 = r13.f3287
            long r4 = java.lang.System.currentTimeMillis()
            com.wpengapp.support.Ⴠ r6 = r13.f3289
            com.wpengapp.support.ॾ r7 = r13.f3288
            r6.mo9605(r7)
            r0.mo8622((com.wpengapp.support.Request) r3)
            com.wpengapp.support.Ⴠ r6 = r13.f3289
            com.wpengapp.support.ॾ r7 = r13.f3288
            r6.mo9593((com.wpengapp.support.Call) r7, (com.wpengapp.support.Request) r3)
            java.lang.String r6 = r3.f2365
            boolean r6 = com.wpengapp.support.Utils.m1895((java.lang.String) r6)
            r7 = 0
            if (r6 == 0) goto L_0x0085
            com.wpengapp.support.ݨ r6 = r3.f2367
            if (r6 == 0) goto L_0x0085
            com.wpengapp.support.Ʌ r6 = r3.f2366
            java.lang.String r8 = "Expect"
            java.lang.String r6 = r6.mo8178((java.lang.String) r8)
            java.lang.String r8 = "100-continue"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x004c
            r0.mo8623()
            com.wpengapp.support.Ⴠ r6 = r13.f3289
            com.wpengapp.support.ॾ r8 = r13.f3288
            r6.mo9607(r8)
            r6 = 1
            com.wpengapp.support.ʚ$֏ r6 = r0.mo8618((boolean) r6)
            goto L_0x004d
        L_0x004c:
            r6 = r7
        L_0x004d:
            if (r6 != 0) goto L_0x007b
            com.wpengapp.support.Ⴠ r2 = r13.f3289
            com.wpengapp.support.ॾ r8 = r13.f3288
            r2.mo9604(r8)
            com.wpengapp.support.ݨ r2 = r3.f2367
            long r8 = r2.mo8941()
            com.wpengapp.support.Ƙ$֏ r2 = new com.wpengapp.support.Ƙ$֏
            com.wpengapp.support.อ r8 = r0.mo8620(r3, r8)
            r2.<init>(r8)
            com.wpengapp.support.ǡ r8 = com.wpengapp.support.C0745.m1950((com.wpengapp.support.Sink) r2)
            com.wpengapp.support.ݨ r9 = r3.f2367
            r9.mo8942(r8)
            r8.close()
            com.wpengapp.support.Ⴠ r8 = r13.f3289
            com.wpengapp.support.ॾ r9 = r13.f3288
            long r10 = r2.f930
            r8.mo9591((com.wpengapp.support.Call) r9, (long) r10)
            goto L_0x0086
        L_0x007b:
            boolean r2 = r2.mo8662()
            if (r2 != 0) goto L_0x0086
            r1.mo8928()
            goto L_0x0086
        L_0x0085:
            r6 = r7
        L_0x0086:
            r0.mo8621()
            r2 = 0
            if (r6 != 0) goto L_0x0097
            com.wpengapp.support.Ⴠ r6 = r13.f3289
            com.wpengapp.support.ॾ r8 = r13.f3288
            r6.mo9607(r8)
            com.wpengapp.support.ʚ$֏ r6 = r0.mo8618((boolean) r2)
        L_0x0097:
            r6.f1361 = r3
            com.wpengapp.support.Ռ r8 = r1.mo8927()
            com.wpengapp.support.ǎ r8 = r8.f2040
            r6.f1365 = r8
            r6.f1371 = r4
            long r8 = java.lang.System.currentTimeMillis()
            r6.f1372 = r8
            com.wpengapp.support.ʚ r6 = r6.mo8279()
            int r8 = r6.f1351
            r9 = 100
            if (r8 != r9) goto L_0x00cf
            com.wpengapp.support.ʚ$֏ r2 = r0.mo8618((boolean) r2)
            r2.f1361 = r3
            com.wpengapp.support.Ռ r3 = r1.mo8927()
            com.wpengapp.support.ǎ r3 = r3.f2040
            r2.f1365 = r3
            r2.f1371 = r4
            long r3 = java.lang.System.currentTimeMillis()
            r2.f1372 = r3
            com.wpengapp.support.ʚ r6 = r2.mo8279()
            int r8 = r6.f1351
        L_0x00cf:
            com.wpengapp.support.Ⴠ r2 = r13.f3289
            com.wpengapp.support.ॾ r13 = r13.f3288
            r2.mo9592((com.wpengapp.support.Call) r13, (com.wpengapp.support.Response) r6)
            boolean r13 = r12.f929
            if (r13 == 0) goto L_0x00eb
            r13 = 101(0x65, float:1.42E-43)
            if (r8 != r13) goto L_0x00eb
            com.wpengapp.support.ʚ$֏ r13 = r6.mo8276()
            com.wpengapp.support.ம r0 = com.wpengapp.support.Util.f731
            r13.f1367 = r0
            com.wpengapp.support.ʚ r13 = r13.mo8279()
            goto L_0x00f9
        L_0x00eb:
            com.wpengapp.support.ʚ$֏ r13 = r6.mo8276()
            com.wpengapp.support.ம r0 = r0.mo8619((com.wpengapp.support.Response) r6)
            r13.f1367 = r0
            com.wpengapp.support.ʚ r13 = r13.mo8279()
        L_0x00f9:
            com.wpengapp.support.ټ r0 = r13.f1349
            com.wpengapp.support.Ʌ r0 = r0.f2366
            java.lang.String r2 = "Connection"
            java.lang.String r0 = r0.mo8178((java.lang.String) r2)
            java.lang.String r3 = "close"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x011b
            com.wpengapp.support.Ʌ r0 = r13.f1354
            java.lang.String r0 = r0.mo8178((java.lang.String) r2)
            if (r0 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r0 = r7
        L_0x0115:
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x011e
        L_0x011b:
            r1.mo8928()
        L_0x011e:
            r0 = 204(0xcc, float:2.86E-43)
            if (r8 == r0) goto L_0x0126
            r0 = 205(0xcd, float:2.87E-43)
            if (r8 != r0) goto L_0x0132
        L_0x0126:
            com.wpengapp.support.ம r0 = r13.f1355
            long r0 = r0.mo7906()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0133
        L_0x0132:
            return r13
        L_0x0133:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "HTTP "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)
            com.wpengapp.support.ம r13 = r13.f1355
            long r2 = r13.mo7906()
            r1.append(r2)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.CallServerInterceptor.mo7909(com.wpengapp.support.ਮ$֏):com.wpengapp.support.ʚ");
    }
}
