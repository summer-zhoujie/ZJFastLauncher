package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.Т */
/* compiled from: WPengServer */
class C0694 extends HttpGsonRequest<Map<String, String>> {
    public C0694(String str) {
        super(str);
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 157 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7980(com.wpengapp.support.HttpResponse<Map<String, String>> r4, com.wpengapp.support.ErrorCode r5) {
        /*
            r3 = this;
            boolean r5 = r5.mo8157()
            r0 = 0
            if (r5 == 0) goto L_0x0095
            T r4 = r4.f3518
            java.util.Map r4 = (java.util.Map) r4
            if (r4 == 0) goto L_0x001e
            java.lang.String r5 = "mt"
            boolean r5 = r4.containsKey(r5)
            if (r5 == 0) goto L_0x001e
            com.wpengapp.support.ř$ؠ r5 = com.wpengapp.support.WPengServer.f851
            if (r5 == 0) goto L_0x001e
            com.wpengapp.support.ऎ r5 = (com.wpengapp.support.C1004) r5
            r5.mo9114()
        L_0x001e:
            if (r4 == 0) goto L_0x0095
            java.lang.String r5 = "s"
            boolean r5 = r4.containsKey(r5)
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = "t"
            boolean r5 = r4.containsKey(r5)
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = "s"
            java.lang.Object r5 = r4.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            com.wpengapp.support.WPengServer.f845 = r5
            java.lang.String r5 = "t"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x004f }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x004f }
            com.wpengapp.support.WPengServer.f846 = r4     // Catch:{ Exception -> 0x004f }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x004f }
            com.wpengapp.support.WPengServer.f847 = r4     // Catch:{ Exception -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r4 = move-exception
            r4.getMessage()
        L_0x0053:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List<com.wpengapp.support.ř$ހ> r5 = com.wpengapp.support.WPengServer.f848
            monitor-enter(r5)
            com.wpengapp.support.WPengServer.f849 = r0     // Catch:{ all -> 0x0093 }
            java.util.List<com.wpengapp.support.ř$ހ> r0 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x0093 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0093 }
        L_0x0063:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0073
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0093 }
            com.wpengapp.support.ř$ހ r1 = (com.wpengapp.support.WPengServer.C0486) r1     // Catch:{ all -> 0x0093 }
            r4.add(r1)     // Catch:{ all -> 0x0093 }
            goto L_0x0063
        L_0x0073:
            java.util.List<com.wpengapp.support.ř$ހ> r0 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x0093 }
            r0.clear()     // Catch:{ all -> 0x0093 }
            monitor-exit(r5)     // Catch:{ all -> 0x0093 }
            java.util.Iterator r4 = r4.iterator()
        L_0x007d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0090
            java.lang.Object r5 = r4.next()
            r0 = 1
            java.lang.String r1 = com.wpengapp.support.WPengServer.f845
            com.wpengapp.support.ί r5 = (com.wpengapp.support.HttpBaseRequest) r5
            r5.mo8394(r0, r1)
            goto L_0x007d
        L_0x0090:
            return
        L_0x0091:
            monitor-exit(r5)     // Catch:{ all -> 0x0093 }
            throw r4
        L_0x0093:
            r4 = move-exception
            goto L_0x0091
        L_0x0095:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List<com.wpengapp.support.ř$ހ> r5 = com.wpengapp.support.WPengServer.f848
            monitor-enter(r5)
            com.wpengapp.support.WPengServer.f849 = r0     // Catch:{ all -> 0x00d3 }
            java.util.List<com.wpengapp.support.ř$ހ> r1 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x00d3 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00d3 }
        L_0x00a5:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x00b5
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00d3 }
            com.wpengapp.support.ř$ހ r2 = (com.wpengapp.support.WPengServer.C0486) r2     // Catch:{ all -> 0x00d3 }
            r4.add(r2)     // Catch:{ all -> 0x00d3 }
            goto L_0x00a5
        L_0x00b5:
            java.util.List<com.wpengapp.support.ř$ހ> r1 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x00d3 }
            r1.clear()     // Catch:{ all -> 0x00d3 }
            monitor-exit(r5)     // Catch:{ all -> 0x00d3 }
            java.util.Iterator r4 = r4.iterator()
        L_0x00bf:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d0
            java.lang.Object r5 = r4.next()
            r1 = 0
            com.wpengapp.support.ί r5 = (com.wpengapp.support.HttpBaseRequest) r5
            r5.mo8394(r0, r1)
            goto L_0x00bf
        L_0x00d0:
            return
        L_0x00d1:
            monitor-exit(r5)     // Catch:{ all -> 0x00d3 }
            throw r4
        L_0x00d3:
            r4 = move-exception
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0694.mo7980(com.wpengapp.support.ໂ, com.wpengapp.support.ȓ):void");
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 121 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7981(Exception r5) {
        /*
            r4 = this;
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List<com.wpengapp.support.ř$ހ> r0 = com.wpengapp.support.WPengServer.f848
            monitor-enter(r0)
            r1 = 0
            com.wpengapp.support.WPengServer.f849 = r1     // Catch:{ all -> 0x003f }
            java.util.List<com.wpengapp.support.ř$ހ> r2 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x003f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x003f }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0021
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x003f }
            com.wpengapp.support.ř$ހ r3 = (com.wpengapp.support.WPengServer.C0486) r3     // Catch:{ all -> 0x003f }
            r5.add(r3)     // Catch:{ all -> 0x003f }
            goto L_0x0011
        L_0x0021:
            java.util.List<com.wpengapp.support.ř$ހ> r2 = com.wpengapp.support.WPengServer.f848     // Catch:{ all -> 0x003f }
            r2.clear()     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            java.util.Iterator r5 = r5.iterator()
        L_0x002b:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r5.next()
            r2 = 0
            com.wpengapp.support.ί r0 = (com.wpengapp.support.HttpBaseRequest) r0
            r0.mo8394(r1, r2)
            goto L_0x002b
        L_0x003c:
            return
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x003f:
            r5 = move-exception
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0694.mo7981(java.lang.Exception):void");
    }
}
