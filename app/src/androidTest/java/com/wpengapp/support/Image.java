package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ཬ */
public class Image {

    /* renamed from: ֏ */
    public static final C0619 f3581 = C0619.m1588();

    /* renamed from: ؠ */
    public static final long f3582 = Runtime.getRuntime().maxMemory();

    /* renamed from: ހ */
    public static final int f3583 = ((int) (f3582 / 4));

    /* renamed from: ֏ */
    public static C0619 m3366() {
        boolean z = true;
        if (!(f3581.f1548 != null)) {
            synchronized (Image.class) {
                if (f3581.f1548 == null) {
                    z = false;
                }
                if (!z) {
                    f3581.mo8348(m3365(AppUtils.getApplication()));
                }
            }
        }
        return f3581;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.wpengapp.support.ˀ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.wpengapp.support.ˀ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.wpengapp.support.ʻ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: com.wpengapp.support.ˀ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.wpengapp.support.ˀ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: com.wpengapp.support.ˀ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: com.wpengapp.support.ʻ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: com.wpengapp.support.ˀ} */
    /* JADX WARNING: type inference failed for: r7v3, types: [com.wpengapp.support.ʽ] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static C0608 m3365(android.content.Context r17) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565
            r0.inPreferredConfig = r1
            r1 = 1
            r0.inSampleSize = r1
            com.wpengapp.support.ʺ$֏ r2 = new com.wpengapp.support.ʺ$֏
            r3 = r17
            r2.<init>(r3)
            java.util.concurrent.Executor r4 = r2.f1436
            r5 = 0
            java.lang.String r6 = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls."
            if (r4 != 0) goto L_0x001e
            java.util.concurrent.Executor r4 = r2.f1437
            if (r4 == 0) goto L_0x0023
        L_0x001e:
            java.lang.Object[] r4 = new java.lang.Object[r5]
            com.wpengapp.support.L.m2162(r6, r4)
        L_0x0023:
            r4 = 4
            r2.f1441 = r4
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            int r4 = r4.availableProcessors()
            int r4 = r4 + r1
            java.util.concurrent.Executor r7 = r2.f1436
            if (r7 != 0) goto L_0x0037
            java.util.concurrent.Executor r7 = r2.f1437
            if (r7 == 0) goto L_0x003c
        L_0x0037:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.wpengapp.support.L.m2162(r6, r7)
        L_0x003c:
            r2.f1440 = r4
            com.wpengapp.support.ـ r4 = com.wpengapp.support.QueueProcessingType.LIFO
            java.util.concurrent.Executor r7 = r2.f1436
            if (r7 != 0) goto L_0x0048
            java.util.concurrent.Executor r7 = r2.f1437
            if (r7 == 0) goto L_0x004d
        L_0x0048:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.wpengapp.support.L.m2162(r6, r7)
        L_0x004d:
            r2.f1443 = r4
            java.io.File r3 = com.wpengapp.support.C1279.m3424((android.content.Context) r17)
            com.wpengapp.support.ʼ r4 = new com.wpengapp.support.ʼ
            r4.<init>()
            r6 = 0
            com.wpengapp.support.ˀ r7 = new com.wpengapp.support.ˀ     // Catch:{ IOException -> 0x0067 }
            r12 = 33554432(0x2000000, double:1.6578092E-316)
            r14 = 0
            r8 = r7
            r9 = r3
            r10 = r3
            r11 = r4
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ IOException -> 0x0067 }
            goto L_0x0068
        L_0x0067:
            r7 = r6
        L_0x0068:
            if (r7 != 0) goto L_0x006f
            com.wpengapp.support.ʻ r7 = new com.wpengapp.support.ʻ
            r7.<init>(r3, r3, r4)
        L_0x006f:
            long r3 = r2.f1445
            r8 = 0
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x007b
            int r3 = r2.f1446
            if (r3 <= 0) goto L_0x0082
        L_0x007b:
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r4 = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other"
            com.wpengapp.support.L.m2162(r4, r3)
        L_0x0082:
            com.wpengapp.support.ʹ r3 = r2.f1449
            if (r3 == 0) goto L_0x008d
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r4 = "diskCache() and diskCacheFileNameGenerator() calls overlap each other"
            com.wpengapp.support.L.m2162(r4, r3)
        L_0x008d:
            r2.f1448 = r7
            com.wpengapp.support.ʴ r3 = new com.wpengapp.support.ʴ
            int r4 = f3583
            r3.<init>(r4)
            int r4 = r2.f1444
            if (r4 == 0) goto L_0x00a1
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r7 = "memoryCache() and memoryCacheSize() calls overlap each other"
            com.wpengapp.support.L.m2162(r7, r4)
        L_0x00a1:
            r2.f1447 = r3
            com.wpengapp.support.ˮ$֏ r3 = new com.wpengapp.support.ˮ$֏
            r3.<init>()
            r3.f1579 = r1
            r3.f1580 = r1
            com.wpengapp.support.ˏ r4 = com.wpengapp.support.ImageScaleType.EXACTLY
            r3.f1581 = r4
            r3.mo8356((android.graphics.BitmapFactory.Options) r0)
            r3.f1584 = r5
            com.wpengapp.support.ˮ r0 = r3.mo8358()
            r2.f1452 = r0
            java.util.concurrent.Executor r0 = r2.f1436
            if (r0 != 0) goto L_0x00cc
            int r0 = r2.f1440
            int r3 = r2.f1441
            com.wpengapp.support.ـ r4 = r2.f1443
            java.util.concurrent.Executor r0 = com.wpengapp.support.C1279.m3404((int) r0, (int) r3, (com.wpengapp.support.QueueProcessingType) r4)
            r2.f1436 = r0
            goto L_0x00ce
        L_0x00cc:
            r2.f1438 = r1
        L_0x00ce:
            java.util.concurrent.Executor r0 = r2.f1437
            if (r0 != 0) goto L_0x00df
            int r0 = r2.f1440
            int r3 = r2.f1441
            com.wpengapp.support.ـ r4 = r2.f1443
            java.util.concurrent.Executor r0 = com.wpengapp.support.C1279.m3404((int) r0, (int) r3, (com.wpengapp.support.QueueProcessingType) r4)
            r2.f1437 = r0
            goto L_0x00e1
        L_0x00df:
            r2.f1439 = r1
        L_0x00e1:
            com.wpengapp.support.ʽ r0 = r2.f1448
            if (r0 != 0) goto L_0x0134
            com.wpengapp.support.ʹ r0 = r2.f1449
            if (r0 != 0) goto L_0x00f0
            com.wpengapp.support.ʹ r0 = new com.wpengapp.support.ʹ
            r0.<init>()
            r2.f1449 = r0
        L_0x00f0:
            android.content.Context r3 = r2.f1431
            com.wpengapp.support.ʹ r4 = r2.f1449
            long r14 = r2.f1445
            int r0 = r2.f1446
            java.io.File r7 = com.wpengapp.support.C1279.m3396((android.content.Context) r3, (boolean) r5)
            java.io.File r10 = new java.io.File
            java.lang.String r11 = "uil-images"
            r10.<init>(r7, r11)
            boolean r11 = r10.exists()
            if (r11 != 0) goto L_0x010f
            boolean r11 = r10.mkdir()
            if (r11 == 0) goto L_0x0110
        L_0x010f:
            r7 = r10
        L_0x0110:
            int r10 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x0116
            if (r0 <= 0) goto L_0x0129
        L_0x0116:
            java.io.File r11 = com.wpengapp.support.C1279.m3424((android.content.Context) r3)
            com.wpengapp.support.ˀ r8 = new com.wpengapp.support.ˀ     // Catch:{ IOException -> 0x0125 }
            r10 = r8
            r12 = r7
            r13 = r4
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r16)     // Catch:{ IOException -> 0x0125 }
            goto L_0x0132
        L_0x0125:
            r0 = move-exception
            com.wpengapp.support.L.m2160(r0)
        L_0x0129:
            java.io.File r0 = com.wpengapp.support.C1279.m3396((android.content.Context) r3, (boolean) r1)
            com.wpengapp.support.ʻ r8 = new com.wpengapp.support.ʻ
            r8.<init>(r0, r7, r4)
        L_0x0132:
            r2.f1448 = r8
        L_0x0134:
            com.wpengapp.support.ˤ r0 = r2.f1447
            if (r0 != 0) goto L_0x016a
            android.content.Context r0 = r2.f1431
            int r3 = r2.f1444
            if (r3 != 0) goto L_0x0163
            java.lang.String r3 = "activity"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            int r4 = r3.getMemoryClass()
            int r7 = android.os.Build.VERSION.SDK_INT
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.flags
            r7 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r7
            if (r0 == 0) goto L_0x0158
            goto L_0x0159
        L_0x0158:
            r1 = 0
        L_0x0159:
            if (r1 == 0) goto L_0x015f
            int r4 = r3.getLargeMemoryClass()
        L_0x015f:
            int r4 = r4 * r7
            int r3 = r4 / 8
        L_0x0163:
            com.wpengapp.support.ʴ r0 = new com.wpengapp.support.ʴ
            r0.<init>(r3)
            r2.f1447 = r0
        L_0x016a:
            boolean r0 = r2.f1442
            if (r0 == 0) goto L_0x017c
            com.wpengapp.support.ˡ r0 = new com.wpengapp.support.ˡ
            com.wpengapp.support.ˤ r1 = r2.f1447
            com.wpengapp.support.ӏ r3 = new com.wpengapp.support.ӏ
            r3.<init>()
            r0.<init>(r1, r3)
            r2.f1447 = r0
        L_0x017c:
            com.wpengapp.support.ۦ r0 = r2.f1450
            if (r0 != 0) goto L_0x0189
            android.content.Context r0 = r2.f1431
            com.wpengapp.support.ǃ r1 = new com.wpengapp.support.ǃ
            r1.<init>(r0)
            r2.f1450 = r1
        L_0x0189:
            com.wpengapp.support.ͺ r0 = r2.f1451
            if (r0 != 0) goto L_0x0196
            boolean r0 = r2.f1453
            com.wpengapp.support.ٲ r1 = new com.wpengapp.support.ٲ
            r1.<init>(r0)
            r2.f1451 = r1
        L_0x0196:
            com.wpengapp.support.ˮ r0 = r2.f1452
            if (r0 != 0) goto L_0x01a5
            com.wpengapp.support.ˮ$֏ r0 = new com.wpengapp.support.ˮ$֏
            r0.<init>()
            com.wpengapp.support.ˮ r0 = r0.mo8358()
            r2.f1452 = r0
        L_0x01a5:
            com.wpengapp.support.ʺ r0 = new com.wpengapp.support.ʺ
            r0.<init>(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Image.m3365(android.content.Context):com.wpengapp.support.ʺ");
    }
}
