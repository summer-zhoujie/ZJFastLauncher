package com.wpengapp.support;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.wpengapp.support.C0621;

/* renamed from: com.wpengapp.support.ˣ */
/* compiled from: ImageLoader */
public class C0619 {

    /* renamed from: ֏ */
    public static final String f1546 = "ˣ";

    /* renamed from: ؠ */
    public static volatile C0619 f1547;

    /* renamed from: ހ */
    public C0608 f1548;

    /* renamed from: ށ */
    public C0607 f1549;

    /* renamed from: ނ */
    public SimpleImageLoadingListener f1550 = new SimpleImageLoadingListener();

    /* renamed from: com.wpengapp.support.ˣ$֏ */
    /* compiled from: ImageLoader */
    private static class C0620 extends SimpleImageLoadingListener {

        /* renamed from: ֏ */
        public Bitmap f1551;

        public /* synthetic */ C0620(ImageLoader r1) {
        }

        /* renamed from: ֏ */
        public void mo7943(String str, View view, Bitmap bitmap) {
            this.f1551 = bitmap;
        }
    }

    /* renamed from: ؠ */
    public static C0619 m1588() {
        if (f1547 == null) {
            synchronized (C0619.class) {
                if (f1547 == null) {
                    f1547 = new C0619();
                }
            }
        }
        return f1547;
    }

    /* renamed from: ֏ */
    public synchronized void mo8348(C0608 r3) {
        if (r3 == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.f1548 == null) {
            L.m2159("Initialize ImageLoader with configuration", new Object[0]);
            this.f1549 = new C0607(r3);
            this.f1548 = r3;
        } else {
            L.m2162("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    /* renamed from: ֏ */
    public static Handler m1587(C0621 r2) {
        Handler handler = r2.f1570;
        if (r2.f1571) {
            return null;
        }
        return (handler == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handler;
    }

    /* renamed from: ֏ */
    public void mo8349(String str, ImageView imageView) {
        mo8352(str, new ImageViewAware(imageView), (C0621) null, (SimpleImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    /* renamed from: ֏ */
    public void mo8351(String str, ImageView imageView, C0621 r9) {
        mo8352(str, new ImageViewAware(imageView), r9, (SimpleImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    /* renamed from: ֏ */
    public void mo8350(String str, ImageView imageView, SimpleImageLoadingListener r9) {
        mo8352(str, new ImageViewAware(imageView), (C0621) null, r9, (ImageLoadingProgressListener) null);
    }

    /* renamed from: ֏ */
    public Bitmap mo8346(String str) {
        C0621 r0 = this.f1548.f1427;
        C0621.C0622 r1 = new C0621.C0622();
        r1.mo8357(r0);
        r1.f1588 = true;
        C0621 r5 = r1.mo8358();
        C0620 r02 = new C0620((ImageLoader) null);
        mo8347();
        mo8352(str, new NonViewAware(str, this.f1548.mo8304(), ViewScaleType.CROP), r5, r02, (ImageLoadingProgressListener) null);
        return r02.f1551;
    }

    /* renamed from: ֏ */
    public final void mo8347() {
        if (this.f1548 == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:92|93|(2:95|(1:97)(1:98))) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x022a, code lost:
        r12.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x022d, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0207, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0211, code lost:
        if (r11.f3825 == false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0217, code lost:
        if (r11.mo9634() != false) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x021a, code lost:
        com.wpengapp.support.C1336.m3642(new com.wpengapp.support.C0606(r11), false, r11.f3813, r11.f3811);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x020f */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0201 A[SYNTHETIC, Splitter:B:85:0x0201] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8352(String r11, com.wpengapp.support.ImageAware r12, com.wpengapp.support.C0621 r13, com.wpengapp.support.SimpleImageLoadingListener r14, com.wpengapp.support.ImageLoadingProgressListener r15) {
        /*
            r10 = this;
            com.wpengapp.support.ʺ r15 = r10.f1548
            if (r15 == 0) goto L_0x0243
            if (r12 == 0) goto L_0x023b
            if (r14 != 0) goto L_0x000a
            com.wpengapp.support.ĩ r14 = r10.f1550
        L_0x000a:
            r6 = r14
            if (r13 != 0) goto L_0x0011
            com.wpengapp.support.ʺ r13 = r10.f1548
            com.wpengapp.support.ˮ r13 = r13.f1427
        L_0x0011:
            boolean r14 = android.text.TextUtils.isEmpty(r11)
            r15 = 0
            r8 = 0
            r9 = 1
            if (r14 == 0) goto L_0x005a
            com.wpengapp.support.ʶ r14 = r10.f1549
            java.util.Map<java.lang.Integer, java.lang.String> r14 = r14.f1396
            int r0 = r12.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.remove(r0)
            android.view.View r14 = r12.mo7952()
            r6.mo7945(r11, r14)
            android.graphics.drawable.Drawable r14 = r13.f1559
            if (r14 != 0) goto L_0x0038
            int r14 = r13.f1556
            if (r14 == 0) goto L_0x0039
        L_0x0038:
            r8 = 1
        L_0x0039:
            if (r8 == 0) goto L_0x004e
            com.wpengapp.support.ʺ r14 = r10.f1548
            android.content.res.Resources r14 = r14.f1410
            int r0 = r13.f1556
            if (r0 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r13 = r14.getDrawable(r0)
            goto L_0x004a
        L_0x0048:
            android.graphics.drawable.Drawable r13 = r13.f1559
        L_0x004a:
            r12.mo7954((android.graphics.drawable.Drawable) r13)
            goto L_0x0051
        L_0x004e:
            r12.mo7954((android.graphics.drawable.Drawable) r15)
        L_0x0051:
            android.view.View r12 = r12.mo7952()
            r6.mo7943((java.lang.String) r11, (android.view.View) r12, (android.graphics.Bitmap) r15)
            goto L_0x023a
        L_0x005a:
            com.wpengapp.support.ʺ r14 = r10.f1548
            com.wpengapp.support.ا r14 = r14.mo8304()
            com.wpengapp.support.ا r3 = com.wpengapp.support.ImageSizeUtils.m1640(r12, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r11)
            java.lang.String r0 = "_"
            r14.append(r0)
            int r0 = r3.f2221
            r14.append(r0)
            java.lang.String r0 = "x"
            r14.append(r0)
            int r0 = r3.f2222
            r14.append(r0)
            java.lang.String r4 = r14.toString()
            com.wpengapp.support.ʶ r14 = r10.f1549
            java.util.Map<java.lang.Integer, java.lang.String> r14 = r14.f1396
            int r0 = r12.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.put(r0, r4)
            android.view.View r14 = r12.mo7952()
            r6.mo7945(r11, r14)
            com.wpengapp.support.ʺ r14 = r10.f1548
            com.wpengapp.support.ˤ r14 = r14.f1423
            android.graphics.Bitmap r14 = r14.mo8295(r4)
            if (r14 == 0) goto L_0x00c3
            boolean r0 = r14.isRecycled()
            if (r0 != 0) goto L_0x00c3
            java.lang.Object[] r15 = new java.lang.Object[r9]
            r15[r8] = r4
            java.lang.String r0 = "Load image from memory cache [%s]"
            com.wpengapp.support.L.m2159(r0, r15)
            r13.mo8354()
            com.wpengapp.support.ٵ r13 = r13.f1569
            com.wpengapp.support.ء r15 = com.wpengapp.support.LoadedFrom.MEMORY_CACHE
            r13.mo8821(r14, r12, r15)
            android.view.View r12 = r12.mo7952()
            r6.mo7943((java.lang.String) r11, (android.view.View) r12, (android.graphics.Bitmap) r14)
            goto L_0x023a
        L_0x00c3:
            android.graphics.drawable.Drawable r14 = r13.f1558
            if (r14 != 0) goto L_0x00ce
            int r14 = r13.f1555
            if (r14 == 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r14 = 0
            goto L_0x00cf
        L_0x00ce:
            r14 = 1
        L_0x00cf:
            if (r14 == 0) goto L_0x00e4
            com.wpengapp.support.ʺ r14 = r10.f1548
            android.content.res.Resources r14 = r14.f1410
            int r15 = r13.f1555
            if (r15 == 0) goto L_0x00de
            android.graphics.drawable.Drawable r14 = r14.getDrawable(r15)
            goto L_0x00e0
        L_0x00de:
            android.graphics.drawable.Drawable r14 = r13.f1558
        L_0x00e0:
            r12.mo7954((android.graphics.drawable.Drawable) r14)
            goto L_0x00eb
        L_0x00e4:
            boolean r14 = r13.f1561
            if (r14 == 0) goto L_0x00eb
            r12.mo7954((android.graphics.drawable.Drawable) r15)
        L_0x00eb:
            com.wpengapp.support.ʸ r14 = new com.wpengapp.support.ʸ
            com.wpengapp.support.ʶ r15 = r10.f1549
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r0 = r15.f1397
            java.lang.Object r0 = r0.get(r11)
            java.util.concurrent.locks.ReentrantLock r0 = (java.util.concurrent.locks.ReentrantLock) r0
            if (r0 != 0) goto L_0x0103
            java.util.concurrent.locks.ReentrantLock r0 = new java.util.concurrent.locks.ReentrantLock
            r0.<init>()
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r15 = r15.f1397
            r15.put(r11, r0)
        L_0x0103:
            r7 = r0
            r0 = r14
            r1 = r11
            r2 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            com.wpengapp.support.ჼ r11 = new com.wpengapp.support.ჼ
            com.wpengapp.support.ʶ r12 = r10.f1549
            android.os.Handler r15 = m1587((com.wpengapp.support.C0621) r13)
            r11.<init>(r12, r14, r15)
            boolean r12 = r13.f1571
            if (r12 == 0) goto L_0x022e
            boolean r12 = r11.mo9640()
            if (r12 == 0) goto L_0x0122
            goto L_0x023a
        L_0x0122:
            com.wpengapp.support.ˮ r12 = r11.f3823
            int r12 = r12.f1566
            if (r12 <= 0) goto L_0x012a
            r12 = 1
            goto L_0x012b
        L_0x012a:
            r12 = 0
        L_0x012b:
            if (r12 == 0) goto L_0x015d
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            com.wpengapp.support.ˮ r13 = r11.f3823
            int r13 = r13.f1566
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12[r8] = r13
            java.lang.String r13 = r11.f3820
            r12[r9] = r13
            java.lang.String r13 = "Delay %d ms before loading...  [%s]"
            com.wpengapp.support.L.m2159(r13, r12)
            com.wpengapp.support.ˮ r12 = r11.f3823     // Catch:{ InterruptedException -> 0x0150 }
            int r12 = r12.f1566     // Catch:{ InterruptedException -> 0x0150 }
            long r12 = (long) r12     // Catch:{ InterruptedException -> 0x0150 }
            java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x0150 }
            boolean r12 = r11.mo9635()
            goto L_0x015e
        L_0x0150:
            java.lang.Object[] r12 = new java.lang.Object[r9]
            java.lang.String r13 = r11.f3820
            r12[r8] = r13
            java.lang.String r13 = "Task was interrupted [%s]"
            com.wpengapp.support.L.m2161(r13, r12)
            r12 = 1
            goto L_0x015e
        L_0x015d:
            r12 = 0
        L_0x015e:
            if (r12 == 0) goto L_0x0162
            goto L_0x023a
        L_0x0162:
            com.wpengapp.support.ʸ r12 = r11.f3812
            java.util.concurrent.locks.ReentrantLock r12 = r12.f1409
            java.lang.Object[] r13 = new java.lang.Object[r9]
            java.lang.String r14 = r11.f3820
            r13[r8] = r14
            java.lang.String r14 = "Start display image task [%s]"
            com.wpengapp.support.L.m2159(r14, r13)
            boolean r13 = r12.isLocked()
            if (r13 == 0) goto L_0x0182
            java.lang.Object[] r13 = new java.lang.Object[r9]
            java.lang.String r14 = r11.f3820
            r13[r8] = r14
            java.lang.String r14 = "Image already is loading. Waiting... [%s]"
            com.wpengapp.support.L.m2159(r14, r13)
        L_0x0182:
            r12.lock()
            r11.mo9629()     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.ʺ r13 = r11.f3814     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.ˤ r13 = r13.f1423     // Catch:{ ֏ -> 0x020f }
            java.lang.String r14 = r11.f3820     // Catch:{ ֏ -> 0x020f }
            android.graphics.Bitmap r13 = r13.mo8295(r14)     // Catch:{ ֏ -> 0x020f }
            if (r13 == 0) goto L_0x01ab
            boolean r14 = r13.isRecycled()     // Catch:{ ֏ -> 0x020f }
            if (r14 == 0) goto L_0x019b
            goto L_0x01ab
        L_0x019b:
            com.wpengapp.support.ء r14 = com.wpengapp.support.LoadedFrom.MEMORY_CACHE     // Catch:{ ֏ -> 0x020f }
            r11.f3826 = r14     // Catch:{ ֏ -> 0x020f }
            java.lang.String r14 = "...Get cached bitmap from memory after waiting. [%s]"
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ ֏ -> 0x020f }
            java.lang.String r0 = r11.f3820     // Catch:{ ֏ -> 0x020f }
            r15[r8] = r0     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.L.m2159(r14, r15)     // Catch:{ ֏ -> 0x020f }
            goto L_0x01db
        L_0x01ab:
            android.graphics.Bitmap r13 = r11.mo9639()     // Catch:{ ֏ -> 0x020f }
            if (r13 != 0) goto L_0x01b3
            goto L_0x0226
        L_0x01b3:
            r11.mo9629()     // Catch:{ ֏ -> 0x020f }
            boolean r14 = r11.mo9634()     // Catch:{ ֏ -> 0x020f }
            if (r14 != 0) goto L_0x0209
            com.wpengapp.support.ˮ r14 = r11.f3823     // Catch:{ ֏ -> 0x020f }
            r14.mo8355()     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.ˮ r14 = r11.f3823     // Catch:{ ֏ -> 0x020f }
            boolean r14 = r14.f1562     // Catch:{ ֏ -> 0x020f }
            if (r14 == 0) goto L_0x01db
            java.lang.String r14 = "Cache image in memory [%s]"
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ ֏ -> 0x020f }
            java.lang.String r0 = r11.f3820     // Catch:{ ֏ -> 0x020f }
            r15[r8] = r0     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.L.m2159(r14, r15)     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.ʺ r14 = r11.f3814     // Catch:{ ֏ -> 0x020f }
            com.wpengapp.support.ˤ r14 = r14.f1423     // Catch:{ ֏ -> 0x020f }
            java.lang.String r15 = r11.f3820     // Catch:{ ֏ -> 0x020f }
            r14.mo8298(r15, r13)     // Catch:{ ֏ -> 0x020f }
        L_0x01db:
            com.wpengapp.support.ˮ r14 = r11.f3823     // Catch:{ ֏ -> 0x020f }
            r14.mo8354()     // Catch:{ ֏ -> 0x020f }
            r11.mo9629()     // Catch:{ ֏ -> 0x020f }
            boolean r14 = r11.mo9634()     // Catch:{ ֏ -> 0x020f }
            if (r14 != 0) goto L_0x0201
            r12.unlock()
            com.wpengapp.support.ߵ r12 = new com.wpengapp.support.ߵ
            com.wpengapp.support.ʸ r14 = r11.f3812
            com.wpengapp.support.ʶ r15 = r11.f3811
            com.wpengapp.support.ء r0 = r11.f3826
            r12.<init>(r13, r14, r15, r0)
            boolean r13 = r11.f3825
            android.os.Handler r14 = r11.f3813
            com.wpengapp.support.ʶ r11 = r11.f3811
            com.wpengapp.support.C1336.m3642(r12, r13, r14, r11)
            goto L_0x023a
        L_0x0201:
            com.wpengapp.support.ჼ$֏ r13 = new com.wpengapp.support.ჼ$֏     // Catch:{ ֏ -> 0x020f }
            r13.<init>(r11)     // Catch:{ ֏ -> 0x020f }
            throw r13     // Catch:{ ֏ -> 0x020f }
        L_0x0207:
            r11 = move-exception
            goto L_0x022a
        L_0x0209:
            com.wpengapp.support.ჼ$֏ r13 = new com.wpengapp.support.ჼ$֏     // Catch:{ ֏ -> 0x020f }
            r13.<init>(r11)     // Catch:{ ֏ -> 0x020f }
            throw r13     // Catch:{ ֏ -> 0x020f }
        L_0x020f:
            boolean r13 = r11.f3825     // Catch:{ all -> 0x0207 }
            if (r13 != 0) goto L_0x0226
            boolean r13 = r11.mo9634()     // Catch:{ all -> 0x0207 }
            if (r13 == 0) goto L_0x021a
            goto L_0x0226
        L_0x021a:
            com.wpengapp.support.ʵ r13 = new com.wpengapp.support.ʵ     // Catch:{ all -> 0x0207 }
            r13.<init>(r11)     // Catch:{ all -> 0x0207 }
            android.os.Handler r14 = r11.f3813     // Catch:{ all -> 0x0207 }
            com.wpengapp.support.ʶ r11 = r11.f3811     // Catch:{ all -> 0x0207 }
            com.wpengapp.support.C1336.m3642(r13, r8, r14, r11)     // Catch:{ all -> 0x0207 }
        L_0x0226:
            r12.unlock()
            goto L_0x023a
        L_0x022a:
            r12.unlock()
            throw r11
        L_0x022e:
            com.wpengapp.support.ʶ r12 = r10.f1549
            java.util.concurrent.Executor r13 = r12.f1395
            com.wpengapp.support.ʰ r14 = new com.wpengapp.support.ʰ
            r14.<init>(r12, r11)
            r13.execute(r14)
        L_0x023a:
            return
        L_0x023b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)"
            r11.<init>(r12)
            throw r11
        L_0x0243:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "ImageLoader must be init with configuration before using"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0619.mo8352(java.lang.String, com.wpengapp.support.ı, com.wpengapp.support.ˮ, com.wpengapp.support.ĩ, com.wpengapp.support.ī):void");
    }
}
