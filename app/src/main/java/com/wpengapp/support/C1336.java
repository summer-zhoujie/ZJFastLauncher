package com.wpengapp.support;

import android.graphics.Bitmap;
import android.os.Handler;
import com.wpengapp.support.C0621;
import com.wpengapp.support.FailReason;
import com.wpengapp.support.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.wpengapp.support.ჼ */
/* compiled from: LoadAndDisplayImageTask */
public final class C1336 implements Runnable, IoUtils {

    /* renamed from: ֏ */
    public final C0607 f3811;

    /* renamed from: ؠ */
    public final ImageLoadingInfo f3812;

    /* renamed from: ހ */
    public final Handler f3813;

    /* renamed from: ށ */
    public final C0608 f3814;

    /* renamed from: ނ */
    public final ImageDownloader f3815;

    /* renamed from: ރ */
    public final ImageDownloader f3816;

    /* renamed from: ބ */
    public final ImageDownloader f3817;

    /* renamed from: ޅ */
    public final ImageDecoder f3818;

    /* renamed from: ކ */
    public final String f3819;

    /* renamed from: އ */
    public final String f3820;

    /* renamed from: ވ */
    public final ImageAware f3821;

    /* renamed from: މ */
    public final ImageSize f3822;

    /* renamed from: ފ */
    public final C0621 f3823;

    /* renamed from: ދ */
    public final SimpleImageLoadingListener f3824;

    /* renamed from: ތ */
    public final boolean f3825;

    /* renamed from: ލ */
    public LoadedFrom f3826 = LoadedFrom.NETWORK;

    /* renamed from: com.wpengapp.support.ჼ$֏ */
    /* compiled from: LoadAndDisplayImageTask */
    class C1337 extends Exception {
        public C1337(C1336 r1) {
        }
    }

    public C1336(C0607 r2, ImageLoadingInfo r3, Handler handler) {
        this.f3811 = r2;
        this.f3812 = r3;
        this.f3813 = handler;
        this.f3814 = r2.f1392;
        C0608 r22 = this.f3814;
        this.f3815 = r22.f1425;
        this.f3816 = r22.f1428;
        this.f3817 = r22.f1429;
        this.f3818 = r22.f1426;
        this.f3819 = r3.f1402;
        this.f3820 = r3.f1403;
        this.f3821 = r3.f1404;
        this.f3822 = r3.f1405;
        this.f3823 = r3.f1406;
        this.f3824 = r3.f1407;
        ImageLoadingProgressListener r23 = r3.f1408;
        this.f3825 = this.f3823.f1571;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ef, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f9, code lost:
        if (r6.f3825 == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ff, code lost:
        if (mo9634() != false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0102, code lost:
        m3642(new com.wpengapp.support.C0606(r6), false, r6.f3813, r6.f3811);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0112, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f7 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e9 A[SYNTHETIC, Splitter:B:42:0x00e9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            boolean r0 = r6.mo9640()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.wpengapp.support.ˮ r0 = r6.f3823
            int r0 = r0.f1566
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0044
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.wpengapp.support.ˮ r3 = r6.f3823
            int r3 = r3.f1566
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0[r1] = r3
            java.lang.String r3 = r6.f3820
            r0[r2] = r3
            java.lang.String r3 = "Delay %d ms before loading...  [%s]"
            com.wpengapp.support.L.m2159(r3, r0)
            com.wpengapp.support.ˮ r0 = r6.f3823     // Catch:{ InterruptedException -> 0x0037 }
            int r0 = r0.f1566     // Catch:{ InterruptedException -> 0x0037 }
            long r3 = (long) r0     // Catch:{ InterruptedException -> 0x0037 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0037 }
            boolean r0 = r6.mo9635()
            goto L_0x0045
        L_0x0037:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = r6.f3820
            r0[r1] = r3
            java.lang.String r3 = "Task was interrupted [%s]"
            com.wpengapp.support.L.m2161(r3, r0)
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            return
        L_0x0048:
            com.wpengapp.support.ʸ r0 = r6.f3812
            java.util.concurrent.locks.ReentrantLock r0 = r0.f1409
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r6.f3820
            r3[r1] = r4
            java.lang.String r4 = "Start display image task [%s]"
            com.wpengapp.support.L.m2159(r4, r3)
            boolean r3 = r0.isLocked()
            if (r3 == 0) goto L_0x0068
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r6.f3820
            r3[r1] = r4
            java.lang.String r4 = "Image already is loading. Waiting... [%s]"
            com.wpengapp.support.L.m2159(r4, r3)
        L_0x0068:
            r0.lock()
            r6.mo9629()     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.ʺ r3 = r6.f3814     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.ˤ r3 = r3.f1423     // Catch:{ ֏ -> 0x00f7 }
            java.lang.String r4 = r6.f3820     // Catch:{ ֏ -> 0x00f7 }
            android.graphics.Bitmap r3 = r3.mo8295(r4)     // Catch:{ ֏ -> 0x00f7 }
            if (r3 == 0) goto L_0x0091
            boolean r4 = r3.isRecycled()     // Catch:{ ֏ -> 0x00f7 }
            if (r4 == 0) goto L_0x0081
            goto L_0x0091
        L_0x0081:
            com.wpengapp.support.ء r4 = com.wpengapp.support.LoadedFrom.MEMORY_CACHE     // Catch:{ ֏ -> 0x00f7 }
            r6.f3826 = r4     // Catch:{ ֏ -> 0x00f7 }
            java.lang.String r4 = "...Get cached bitmap from memory after waiting. [%s]"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ ֏ -> 0x00f7 }
            java.lang.String r5 = r6.f3820     // Catch:{ ֏ -> 0x00f7 }
            r2[r1] = r5     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.L.m2159(r4, r2)     // Catch:{ ֏ -> 0x00f7 }
            goto L_0x00c3
        L_0x0091:
            android.graphics.Bitmap r3 = r6.mo9639()     // Catch:{ ֏ -> 0x00f7 }
            if (r3 != 0) goto L_0x009b
            r0.unlock()
            return
        L_0x009b:
            r6.mo9629()     // Catch:{ ֏ -> 0x00f7 }
            boolean r4 = r6.mo9634()     // Catch:{ ֏ -> 0x00f7 }
            if (r4 != 0) goto L_0x00f1
            com.wpengapp.support.ˮ r4 = r6.f3823     // Catch:{ ֏ -> 0x00f7 }
            r4.mo8355()     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.ˮ r4 = r6.f3823     // Catch:{ ֏ -> 0x00f7 }
            boolean r4 = r4.f1562     // Catch:{ ֏ -> 0x00f7 }
            if (r4 == 0) goto L_0x00c3
            java.lang.String r4 = "Cache image in memory [%s]"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ ֏ -> 0x00f7 }
            java.lang.String r5 = r6.f3820     // Catch:{ ֏ -> 0x00f7 }
            r2[r1] = r5     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.L.m2159(r4, r2)     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.ʺ r2 = r6.f3814     // Catch:{ ֏ -> 0x00f7 }
            com.wpengapp.support.ˤ r2 = r2.f1423     // Catch:{ ֏ -> 0x00f7 }
            java.lang.String r4 = r6.f3820     // Catch:{ ֏ -> 0x00f7 }
            r2.mo8298(r4, r3)     // Catch:{ ֏ -> 0x00f7 }
        L_0x00c3:
            com.wpengapp.support.ˮ r2 = r6.f3823     // Catch:{ ֏ -> 0x00f7 }
            r2.mo8354()     // Catch:{ ֏ -> 0x00f7 }
            r6.mo9629()     // Catch:{ ֏ -> 0x00f7 }
            boolean r2 = r6.mo9634()     // Catch:{ ֏ -> 0x00f7 }
            if (r2 != 0) goto L_0x00e9
            r0.unlock()
            com.wpengapp.support.ߵ r0 = new com.wpengapp.support.ߵ
            com.wpengapp.support.ʸ r1 = r6.f3812
            com.wpengapp.support.ʶ r2 = r6.f3811
            com.wpengapp.support.ء r4 = r6.f3826
            r0.<init>(r3, r1, r2, r4)
            boolean r1 = r6.f3825
            android.os.Handler r2 = r6.f3813
            com.wpengapp.support.ʶ r3 = r6.f3811
            m3642(r0, r1, r2, r3)
            return
        L_0x00e9:
            com.wpengapp.support.ჼ$֏ r2 = new com.wpengapp.support.ჼ$֏     // Catch:{ ֏ -> 0x00f7 }
            r2.<init>(r6)     // Catch:{ ֏ -> 0x00f7 }
            throw r2     // Catch:{ ֏ -> 0x00f7 }
        L_0x00ef:
            r1 = move-exception
            goto L_0x0112
        L_0x00f1:
            com.wpengapp.support.ჼ$֏ r2 = new com.wpengapp.support.ჼ$֏     // Catch:{ ֏ -> 0x00f7 }
            r2.<init>(r6)     // Catch:{ ֏ -> 0x00f7 }
            throw r2     // Catch:{ ֏ -> 0x00f7 }
        L_0x00f7:
            boolean r2 = r6.f3825     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x010e
            boolean r2 = r6.mo9634()     // Catch:{ all -> 0x00ef }
            if (r2 == 0) goto L_0x0102
            goto L_0x010e
        L_0x0102:
            com.wpengapp.support.ʵ r2 = new com.wpengapp.support.ʵ     // Catch:{ all -> 0x00ef }
            r2.<init>(r6)     // Catch:{ all -> 0x00ef }
            android.os.Handler r3 = r6.f3813     // Catch:{ all -> 0x00ef }
            com.wpengapp.support.ʶ r4 = r6.f3811     // Catch:{ all -> 0x00ef }
            m3642(r2, r1, r3, r4)     // Catch:{ all -> 0x00ef }
        L_0x010e:
            r0.unlock()
            return
        L_0x0112:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1336.run():void");
    }

    /* renamed from: ؠ */
    public final boolean mo9632() {
        InputStream r0 = mo9633().mo8094(this.f3819, this.f3823.f1568);
        if (r0 == null) {
            L.m2161("No stream for image [%s]", this.f3820);
            return false;
        }
        try {
            return this.f3814.f1424.mo8307(this.f3819, r0, this);
        } finally {
            try {
                r0.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ހ */
    public final ImageDownloader mo9633() {
        if (this.f3811.f1399.get()) {
            return this.f3816;
        }
        if (this.f3811.f1400.get()) {
            return this.f3817;
        }
        return this.f3815;
    }

    /* renamed from: ށ */
    public final boolean mo9634() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.m2159("Task was interrupted [%s]", this.f3820);
        return true;
    }

    /* renamed from: ނ */
    public final boolean mo9635() {
        return mo9636() || mo9637();
    }

    /* renamed from: ރ */
    public final boolean mo9636() {
        if (!this.f3821.mo7956()) {
            return false;
        }
        L.m2159("ImageAware was collected by GC. Task is cancelled. [%s]", this.f3820);
        return true;
    }

    /* renamed from: ބ */
    public final boolean mo9637() {
        C0607 r0 = this.f3811;
        ImageAware r1 = this.f3821;
        if (!(!this.f3820.equals(r0.f1396.get(Integer.valueOf(r1.getId()))))) {
            return false;
        }
        L.m2159("ImageAware is reused for another image. Task is cancelled. [%s]", this.f3820);
        return true;
    }

    /* renamed from: ޅ */
    public final boolean mo9638() {
        L.m2159("Cache image on disk [%s]", this.f3820);
        try {
            boolean r1 = mo9632();
            if (!r1) {
                return r1;
            }
            int i = this.f3814.f1413;
            int i2 = this.f3814.f1414;
            if (i <= 0 && i2 <= 0) {
                return r1;
            }
            L.m2159("Resize image in disk cache [%s]", this.f3820);
            mo9631(i, i2);
            return r1;
        } catch (IOException e) {
            L.m2160(e);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r1.getHeight() > 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
        r9 = r1;
        r1 = null;
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
        r9 = r1;
        r1 = null;
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        r9 = r1;
        r1 = null;
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r1 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[ExcHandler: ֏ (r0v1 'e' com.wpengapp.support.ჼ$֏ A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* renamed from: ކ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bitmap mo9639() {
        /*
            r10 = this;
            r0 = 0
            com.wpengapp.support.ʺ r1 = r10.f3814     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            com.wpengapp.support.ʽ r1 = r1.f1424     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            java.lang.String r2 = r10.f3819     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            java.io.File r1 = r1.mo8305(r2)     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0040
            boolean r4 = r1.exists()     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            if (r4 == 0) goto L_0x0040
            long r4 = r1.length()     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0040
            java.lang.String r4 = "Load image from disk cache [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            java.lang.String r6 = r10.f3820     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            r5[r2] = r6     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            com.wpengapp.support.L.m2159(r4, r5)     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            com.wpengapp.support.ء r4 = com.wpengapp.support.LoadedFrom.DISC_CACHE     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            r10.f3826 = r4     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            r10.mo9629()     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            com.wpengapp.support.ۦ$֏ r4 = com.wpengapp.support.ImageDownloader.C0912.FILE     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            java.lang.String r1 = r4.mo8893(r1)     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            android.graphics.Bitmap r1 = r10.mo9628((java.lang.String) r1)     // Catch:{ IllegalStateException -> 0x00cc, ֏ -> 0x00ca, IOException -> 0x00bd, OutOfMemoryError -> 0x00b0, Throwable -> 0x00a3 }
            goto L_0x0041
        L_0x0040:
            r1 = r0
        L_0x0041:
            if (r1 == 0) goto L_0x004f
            int r4 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r4 <= 0) goto L_0x004f
            int r4 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r4 > 0) goto L_0x00d2
        L_0x004f:
            java.lang.String r4 = "Load image from network [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.lang.String r5 = r10.f3820     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            r3[r2] = r5     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            com.wpengapp.support.L.m2159(r4, r3)     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            com.wpengapp.support.ء r2 = com.wpengapp.support.LoadedFrom.NETWORK     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            r10.f3826 = r2     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.lang.String r2 = r10.f3819     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            com.wpengapp.support.ˮ r3 = r10.f3823     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            boolean r3 = r3.f1563     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r3 == 0) goto L_0x0082
            boolean r3 = r10.mo9638()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r3 == 0) goto L_0x0082
            com.wpengapp.support.ʺ r3 = r10.f3814     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            com.wpengapp.support.ʽ r3 = r3.f1424     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.lang.String r4 = r10.f3819     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.io.File r3 = r3.mo8305(r4)     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r3 == 0) goto L_0x0082
            com.wpengapp.support.ۦ$֏ r2 = com.wpengapp.support.ImageDownloader.C0912.FILE     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            java.lang.String r2 = r2.mo8893(r3)     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
        L_0x0082:
            r10.mo9629()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            android.graphics.Bitmap r1 = r10.mo9628((java.lang.String) r2)     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r1 == 0) goto L_0x0097
            int r2 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r2 <= 0) goto L_0x0097
            int r2 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            if (r2 > 0) goto L_0x00d2
        L_0x0097:
            com.wpengapp.support.י$֏ r2 = com.wpengapp.support.FailReason.C0821.DECODING_ERROR     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            r10.mo9630((com.wpengapp.support.FailReason.C0821) r2, (java.lang.Throwable) r0)     // Catch:{ IllegalStateException -> 0x00cd, ֏ -> 0x00ca, IOException -> 0x00a1, OutOfMemoryError -> 0x009f, Throwable -> 0x009d }
            goto L_0x00d2
        L_0x009d:
            r0 = move-exception
            goto L_0x00a7
        L_0x009f:
            r0 = move-exception
            goto L_0x00b4
        L_0x00a1:
            r0 = move-exception
            goto L_0x00c1
        L_0x00a3:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x00a7:
            com.wpengapp.support.L.m2160(r0)
            com.wpengapp.support.י$֏ r2 = com.wpengapp.support.FailReason.C0821.UNKNOWN
            r10.mo9630((com.wpengapp.support.FailReason.C0821) r2, (java.lang.Throwable) r0)
            goto L_0x00d2
        L_0x00b0:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x00b4:
            com.wpengapp.support.L.m2160(r0)
            com.wpengapp.support.י$֏ r2 = com.wpengapp.support.FailReason.C0821.OUT_OF_MEMORY
            r10.mo9630((com.wpengapp.support.FailReason.C0821) r2, (java.lang.Throwable) r0)
            goto L_0x00d2
        L_0x00bd:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x00c1:
            com.wpengapp.support.L.m2160(r0)
            com.wpengapp.support.י$֏ r2 = com.wpengapp.support.FailReason.C0821.IO_ERROR
            r10.mo9630((com.wpengapp.support.FailReason.C0821) r2, (java.lang.Throwable) r0)
            goto L_0x00d2
        L_0x00ca:
            r0 = move-exception
            throw r0
        L_0x00cc:
            r1 = r0
        L_0x00cd:
            com.wpengapp.support.י$֏ r2 = com.wpengapp.support.FailReason.C0821.NETWORK_DENIED
            r10.mo9630((com.wpengapp.support.FailReason.C0821) r2, (java.lang.Throwable) r0)
        L_0x00d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1336.mo9639():android.graphics.Bitmap");
    }

    /* renamed from: އ */
    public final boolean mo9640() {
        AtomicBoolean atomicBoolean = this.f3811.f1398;
        if (atomicBoolean.get()) {
            synchronized (this.f3811.f1401) {
                if (atomicBoolean.get()) {
                    L.m2159("ImageLoader is paused. Waiting...  [%s]", this.f3820);
                    try {
                        this.f3811.f1401.wait();
                        L.m2159(".. Resume loading [%s]", this.f3820);
                    } catch (InterruptedException unused) {
                        L.m2161("Task was interrupted [%s]", this.f3820);
                        return true;
                    }
                }
            }
        }
        return mo9635();
    }

    /* renamed from: ֏ */
    public final Bitmap mo9628(String str) {
        String str2 = str;
        return ((BaseImageDecoder) this.f3818).mo8814(new ImageDecodingInfo(this.f3820, str2, this.f3819, this.f3822, this.f3821.mo7957(), mo9633(), this.f3823));
    }

    /* renamed from: ֏ */
    public final boolean mo9631(int i, int i2) {
        File r0 = this.f3814.f1424.mo8305(this.f3819);
        if (r0 == null || !r0.exists()) {
            return false;
        }
        ImageSize r7 = new ImageSize(i, i2);
        C0621.C0622 r12 = new C0621.C0622();
        r12.mo8357(this.f3823);
        r12.f1581 = ImageScaleType.IN_SAMPLE_INT;
        Bitmap r122 = ((BaseImageDecoder) this.f3818).mo8814(new ImageDecodingInfo(this.f3820, ImageDownloader.C0912.FILE.mo8893(r0.getAbsolutePath()), this.f3819, r7, ViewScaleType.FIT_INSIDE, mo9633(), r12.mo8358()));
        if (!(r122 == null || this.f3814.f1415 == null)) {
            L.m2159("Process image before cache on disk [%s]", this.f3820);
            r122 = this.f3814.f1415.mo8099(r122);
            if (r122 == null) {
                L.m2161("Bitmap processor for disk cache returned null [%s]", this.f3820);
            }
        }
        if (r122 == null) {
            return false;
        }
        boolean r1 = this.f3814.f1424.mo8306(this.f3819, r122);
        r122.recycle();
        return r1;
    }

    /* renamed from: ֏ */
    public final void mo9630(FailReason.C0821 r3, Throwable th) {
        if (!this.f3825 && !mo9634() && !mo9635()) {
            m3642(new LoadAndDisplayImageTask(this, r3, th), false, this.f3813, this.f3811);
        }
    }

    /* renamed from: ֏ */
    public final void mo9629() {
        if (mo9636()) {
            throw new C1337(this);
        } else if (mo9637()) {
            throw new C1337(this);
        }
    }

    /* renamed from: ֏ */
    public static void m3642(Runnable runnable, boolean z, Handler handler, C0607 r3) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            r3.f1395.execute(runnable);
        } else {
            handler.post(runnable);
        }
    }
}
