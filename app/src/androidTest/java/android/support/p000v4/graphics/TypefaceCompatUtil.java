package android.support.p000v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import com.wpengapp.support.outline;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v4.graphics.TypefaceCompatUtil */
public class TypefaceCompatUtil {
    public static final String CACHE_FILE_PREFIX = ".font";
    public static final String TAG = "TypefaceCompatUtil";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!copyToFile(tempFile, resources, i)) {
                return null;
            }
            ByteBuffer mmap = mmap(tempFile);
            tempFile.delete();
            return mmap;
        } finally {
            tempFile.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[SYNTHETIC, Splitter:B:23:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[SYNTHETIC, Splitter:B:28:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(File r4, java.io.InputStream r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0023 }
            r2.<init>(r4, r0)     // Catch:{ IOException -> 0x0023 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x001e, all -> 0x001b }
        L_0x000b:
            int r1 = r5.read(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            r3 = -1
            if (r1 == r3) goto L_0x0016
            r2.write(r4, r0, r1)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            goto L_0x000b
        L_0x0016:
            r4 = 1
            r2.close()     // Catch:{ IOException -> 0x001a }
        L_0x001a:
            return r4
        L_0x001b:
            r4 = move-exception
            r1 = r2
            goto L_0x003e
        L_0x001e:
            r4 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0021:
            r4 = move-exception
            goto L_0x003e
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r5.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "Error copying resource contents to temp file: "
            r5.append(r2)     // Catch:{ all -> 0x0021 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0021 }
            r5.append(r4)     // Catch:{ all -> 0x0021 }
            r5.toString()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x003d }
        L_0x003d:
            return r0
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.TypefaceCompatUtil.copyToFile(java.io.File, java.io.InputStream):boolean");
    }

    @Nullable
    public static File getTempFile(Context context) {
        StringBuilder r0 = outline.m2549(CACHE_FILE_PREFIX);
        r0.append(Process.myPid());
        r0.append("-");
        r0.append(Process.myTid());
        r0.append("-");
        String sb = r0.toString();
        int i = 0;
        while (i < 100) {
            File file = new File(context.getCacheDir(), outline.m2543(sb, i));
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r8 = r2;
        r2 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r2 = null;
     */
    @android.support.annotation.Nullable
    @android.support.annotation.RequiresApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ByteBuffer mmap(File r9) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0032 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x0032 }
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            long r6 = r2.size()     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            r1.close()     // Catch:{ IOException -> 0x0032 }
            return r9
        L_0x001a:
            r9 = move-exception
            r2 = r0
            goto L_0x0023
        L_0x001d:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x001f }
        L_0x001f:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L_0x0023:
            if (r2 == 0) goto L_0x002e
            r1.close()     // Catch:{ Throwable -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ IOException -> 0x0032 }
            goto L_0x0031
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0031:
            throw r9     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.TypefaceCompatUtil.mmap(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        r7 = r1;
        r1 = r10;
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0051, code lost:
        r7 = r10;
        r10 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[ExcHandler: all (th java.lang.Throwable)] */
    @android.support.annotation.Nullable
    @android.support.annotation.RequiresApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ByteBuffer mmap(Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch:{ IOException -> 0x0063 }
            if (r8 != 0) goto L_0x0013
            if (r8 == 0) goto L_0x0012
            r8.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            r9.<init>(r10)     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            long r5 = r1.size()     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            r9.close()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            r8.close()     // Catch:{ IOException -> 0x0063 }
            return r10
        L_0x0033:
            r10 = move-exception
            r1 = r0
            goto L_0x003c
        L_0x0036:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L_0x003c:
            if (r1 == 0) goto L_0x0047
            r9.close()     // Catch:{ Throwable -> 0x0042, all -> 0x004b }
            goto L_0x004a
        L_0x0042:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
            goto L_0x004a
        L_0x0047:
            r9.close()     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
        L_0x004a:
            throw r10     // Catch:{ Throwable -> 0x004e, all -> 0x004b }
        L_0x004b:
            r9 = move-exception
            r10 = r0
            goto L_0x0054
        L_0x004e:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0054:
            if (r10 == 0) goto L_0x005f
            r8.close()     // Catch:{ Throwable -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r8 = move-exception
            r10.addSuppressed(r8)     // Catch:{ IOException -> 0x0063 }
            goto L_0x0062
        L_0x005f:
            r8.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0062:
            throw r9     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(File r0, Resources r1, int r2) {
        /*
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ all -> 0x0010 }
            boolean r0 = copyToFile(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()     // Catch:{ IOException -> 0x000d }
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.TypefaceCompatUtil.copyToFile(java.io.File, android.content.res.Resources, int):boolean");
    }
}
