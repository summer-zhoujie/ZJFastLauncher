package com.wpengapp.support;

import android.graphics.Bitmap;
import android.support.p003v7.widget.ActivityChooserView;
import android.support.p003v7.widget.RecyclerView;
import com.wpengapp.support.DiskLruCache;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.wpengapp.support.ˀ */
public class LruDiskCache implements DiskCache {

    /* renamed from: ֏ */
    public static final Bitmap.CompressFormat f1462 = Bitmap.CompressFormat.PNG;

    /* renamed from: ؠ */
    public DiskLruCache f1463;

    /* renamed from: ހ */
    public final FileNameGenerator f1464;

    /* renamed from: ށ */
    public int f1465 = 32768;

    /* renamed from: ނ */
    public Bitmap.CompressFormat f1466 = f1462;

    /* renamed from: ރ */
    public int f1467 = 100;

    public LruDiskCache(File file, File file2, FileNameGenerator r9, long j, int i) {
        if (file != null) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
            } else if (i < 0) {
                throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
            } else if (r9 != null) {
                long j2 = i2 == 0 ? RecyclerView.FOREVER_NS : j;
                int i3 = i == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i;
                this.f1464 = r9;
                mo8311(file, file2, j2, i3);
            } else {
                throw new IllegalArgumentException("fileNameGenerator argument must be not null");
            }
        } else {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
    }

    /* renamed from: ֏ */
    public final void mo8311(File file, File file2, long j, int i) {
        try {
            this.f1463 = DiskLruCache.m1540(file, 1, 1, j, i);
        } catch (IOException e) {
            L.m2160(e);
            if (file2 != null) {
                mo8311(file2, (File) null, j, i);
            }
            if (this.f1463 == null) {
                throw e;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.wpengapp.support.ˁ$ހ} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0034, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0034  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public File mo8305(String r5) {
        /*
            r4 = this;
            r0 = 0
            com.wpengapp.support.ˁ r1 = r4.f1463     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            com.wpengapp.support.ʹ r2 = r4.f1464     // Catch:{ IOException -> 0x001f, all -> 0x0021 }
            java.lang.String r5 = r2.mo8303(r5)     // Catch:{ IOException -> 0x001f, all -> 0x0021 }
            com.wpengapp.support.ˁ$ހ r5 = r1.mo8315((java.lang.String) r5)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            if (r5 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r1 = 0
            java.io.File[] r2 = r5.f1497     // Catch:{ IOException -> 0x001b }
            r0 = r2[r1]     // Catch:{ IOException -> 0x001b }
        L_0x0015:
            if (r5 == 0) goto L_0x001a
            r5.close()
        L_0x001a:
            return r0
        L_0x001b:
            r1 = move-exception
            goto L_0x0025
        L_0x001d:
            r1 = r5
            goto L_0x0024
        L_0x001f:
            r5 = move-exception
            goto L_0x001d
        L_0x0021:
            r5 = move-exception
            goto L_0x0032
        L_0x0023:
            r1 = move-exception
        L_0x0024:
            r5 = r0
        L_0x0025:
            com.wpengapp.support.L.m2160(r1)     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x002d
            r5.close()
        L_0x002d:
            return r0
        L_0x002e:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.LruDiskCache.mo8305(java.lang.String):java.io.File");
    }

    /* renamed from: ֏ */
    public boolean mo8307(String str, InputStream inputStream, IoUtils r6) {
        DiskLruCache.C0614 r4 = this.f1463.mo8313(this.f1464.mo8303(str), -1);
        if (r4 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(r4.mo8326(0), this.f1465);
        try {
            boolean r5 = C1279.m3418(inputStream, (OutputStream) bufferedOutputStream, r6, this.f1465);
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
            if (r5) {
                r4.mo8328();
            } else {
                r4.mo8327();
            }
            return r5;
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Exception unused2) {
            }
            r4.mo8327();
            throw th;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8306(String str, Bitmap bitmap) {
        DiskLruCache.C0614 r4 = this.f1463.mo8313(this.f1464.mo8303(str), -1);
        if (r4 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(r4.mo8326(0), this.f1465);
        try {
            boolean compress = bitmap.compress(this.f1466, this.f1467, bufferedOutputStream);
            if (compress) {
                r4.mo8328();
            } else {
                r4.mo8327();
            }
            return compress;
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
