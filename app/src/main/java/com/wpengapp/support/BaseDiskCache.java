package com.wpengapp.support;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.wpengapp.support.ࠚ */
public abstract class BaseDiskCache implements DiskCache {

    /* renamed from: ֏ */
    public static final Bitmap.CompressFormat f2783 = Bitmap.CompressFormat.PNG;

    /* renamed from: ؠ */
    public final File f2784;

    /* renamed from: ހ */
    public final File f2785;

    /* renamed from: ށ */
    public final FileNameGenerator f2786;

    /* renamed from: ނ */
    public int f2787 = 32768;

    /* renamed from: ރ */
    public Bitmap.CompressFormat f2788 = f2783;

    /* renamed from: ބ */
    public int f2789 = 100;

    public BaseDiskCache(File file, File file2, FileNameGenerator r4) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (r4 != null) {
            this.f2784 = file;
            this.f2785 = file2;
            this.f2786 = r4;
        } else {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
    }

    /* renamed from: ֏ */
    public File mo8305(String str) {
        return mo9047(str);
    }

    /* renamed from: ؠ */
    public File mo9047(String str) {
        File file;
        String r3 = this.f2786.mo8303(str);
        File file2 = this.f2784;
        if (!file2.exists() && !this.f2784.mkdirs() && (file = this.f2785) != null && (file.exists() || this.f2785.mkdirs())) {
            file2 = this.f2785;
        }
        return new File(file2, r3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004a */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8307(String r6, java.io.InputStream r7, IoUtils r8) {
        /*
            r5 = this;
            java.io.File r6 = r5.mo9047(r6)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r6.getAbsolutePath()
            r1.append(r2)
            java.lang.String r2 = ".tmp"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x004b }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x004b }
            r3.<init>(r0)     // Catch:{ all -> 0x004b }
            int r4 = r5.f2787     // Catch:{ all -> 0x004b }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x004b }
            int r3 = r5.f2787     // Catch:{ all -> 0x0046 }
            boolean r7 = com.wpengapp.support.C1279.m3418((java.io.InputStream) r7, (java.io.OutputStream) r2, (com.wpengapp.support.IoUtils) r8, (int) r3)     // Catch:{ all -> 0x0046 }
            r2.close()     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            r8 = move-exception
            goto L_0x004d
        L_0x0037:
            if (r7 == 0) goto L_0x0040
            boolean r6 = r0.renameTo(r6)
            if (r6 != 0) goto L_0x0040
            r7 = 0
        L_0x0040:
            if (r7 != 0) goto L_0x0045
            r0.delete()
        L_0x0045:
            return r7
        L_0x0046:
            r7 = move-exception
            r2.close()     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            throw r7     // Catch:{ all -> 0x004b }
        L_0x004b:
            r8 = move-exception
            r7 = 0
        L_0x004d:
            if (r7 == 0) goto L_0x0056
            boolean r6 = r0.renameTo(r6)
            if (r6 != 0) goto L_0x0056
            r7 = 0
        L_0x0056:
            if (r7 != 0) goto L_0x005b
            r0.delete()
        L_0x005b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.BaseDiskCache.mo8307(java.lang.String, java.io.InputStream, com.wpengapp.support.ĺ):boolean");
    }

    /* renamed from: ֏ */
    public boolean mo8306(String str, Bitmap bitmap) {
        File r5 = mo9047(str);
        File file = new File(r5.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f2787);
        try {
            boolean compress = bitmap.compress(this.f2788, this.f2789, bufferedOutputStream);
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
            if (compress && !file.renameTo(r5)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Exception unused2) {
            }
            file.delete();
            throw th;
        }
    }
}
