package okhttp3.internal.publicsuffix;

import com.wpengapp.support.BufferedSource;
import com.wpengapp.support.C0745;
import com.wpengapp.support.GzipSource;
import com.wpengapp.support.Source;
import com.wpengapp.support.Util;
import java.io.Closeable;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {

    /* renamed from: ֏ */
    public static final byte[] f3846 = {42};

    /* renamed from: ؠ */
    public static final String[] f3847 = new String[0];

    /* renamed from: ހ */
    public static final String[] f3848 = {"*"};

    /* renamed from: ށ */
    public static final PublicSuffixDatabase f3849 = new PublicSuffixDatabase();

    /* renamed from: ނ */
    public final AtomicBoolean f3850 = new AtomicBoolean(false);

    /* renamed from: ރ */
    public final CountDownLatch f3851 = new CountDownLatch(1);

    /* renamed from: ބ */
    public byte[] f3852;

    /* renamed from: ޅ */
    public byte[] f3853;

    /* renamed from: ֏ */
    public String mo9652(String str) {
        int i;
        int i2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] r2 = mo9654(split);
            if (split.length == r2.length && r2[0].charAt(0) != '!') {
                return null;
            }
            if (r2[0].charAt(0) == '!') {
                i2 = split.length;
                i = r2.length;
            } else {
                i2 = split.length;
                i = r2.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i3 = i2 - i; i3 < split2.length; i3++) {
                sb.append(split2[i3]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0 != false) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097 A[LOOP:4: B:51:0x0097->B:55:0x00a4, LOOP_START, PHI: r1 
      PHI: (r1v3 int) = (r1v0 int), (r1v4 int) binds: [B:50:0x0095, B:55:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c2  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String[] mo9654(String[] r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f3850
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f3850
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x003d
            r0 = 0
        L_0x0013:
            r7.mo9653()     // Catch:{ InterruptedIOException -> 0x002e, IOException -> 0x0022 }
            if (r0 == 0) goto L_0x004a
        L_0x0018:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x004a
        L_0x0020:
            r8 = move-exception
            goto L_0x0033
        L_0x0022:
            r3 = move-exception
            com.wpengapp.support.Л r4 = com.wpengapp.support.Platform.f1792     // Catch:{ all -> 0x0020 }
            r5 = 5
            java.lang.String r6 = "Failed to read public suffix list"
            r4.mo8437((int) r5, (java.lang.String) r6, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x004a
            goto L_0x0018
        L_0x002e:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0020 }
            r0 = 1
            goto L_0x0013
        L_0x0033:
            if (r0 == 0) goto L_0x003c
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x003c:
            throw r8
        L_0x003d:
            java.util.concurrent.CountDownLatch r0 = r7.f3851     // Catch:{ InterruptedException -> 0x0043 }
            r0.await()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x004a
        L_0x0043:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x004a:
            monitor-enter(r7)
            byte[] r0 = r7.f3852     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00e6
            monitor-exit(r7)     // Catch:{ all -> 0x00ee }
            int r0 = r8.length
            byte[][] r0 = new byte[r0][]
            r3 = 0
        L_0x0054:
            int r4 = r8.length
            if (r3 >= r4) goto L_0x0064
            r4 = r8[r3]
            java.nio.charset.Charset r5 = com.wpengapp.support.Util.f737
            byte[] r4 = r4.getBytes(r5)
            r0[r3] = r4
            int r3 = r3 + 1
            goto L_0x0054
        L_0x0064:
            r8 = 0
        L_0x0065:
            int r3 = r0.length
            r4 = 0
            if (r8 >= r3) goto L_0x0075
            byte[] r3 = r7.f3852
            java.lang.String r3 = m3672(r3, r0, r8)
            if (r3 == 0) goto L_0x0072
            goto L_0x0076
        L_0x0072:
            int r8 = r8 + 1
            goto L_0x0065
        L_0x0075:
            r3 = r4
        L_0x0076:
            int r8 = r0.length
            if (r8 <= r2) goto L_0x0094
            java.lang.Object r8 = r0.clone()
            byte[][] r8 = (byte[][]) r8
            r5 = 0
        L_0x0080:
            int r6 = r8.length
            int r6 = r6 - r2
            if (r5 >= r6) goto L_0x0094
            byte[] r6 = f3846
            r8[r5] = r6
            byte[] r6 = r7.f3852
            java.lang.String r6 = m3672(r6, r8, r5)
            if (r6 == 0) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            int r5 = r5 + 1
            goto L_0x0080
        L_0x0094:
            r6 = r4
        L_0x0095:
            if (r6 == 0) goto L_0x00a7
        L_0x0097:
            int r8 = r0.length
            int r8 = r8 - r2
            if (r1 >= r8) goto L_0x00a7
            byte[] r8 = r7.f3853
            java.lang.String r8 = m3672(r8, r0, r1)
            if (r8 == 0) goto L_0x00a4
            goto L_0x00a8
        L_0x00a4:
            int r1 = r1 + 1
            goto L_0x0097
        L_0x00a7:
            r8 = r4
        L_0x00a8:
            if (r8 == 0) goto L_0x00c2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "!"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "\\."
            java.lang.String[] r8 = r8.split(r0)
            return r8
        L_0x00c2:
            if (r3 != 0) goto L_0x00c9
            if (r6 != 0) goto L_0x00c9
            java.lang.String[] r8 = f3848
            return r8
        L_0x00c9:
            if (r3 == 0) goto L_0x00d2
            java.lang.String r8 = "\\."
            java.lang.String[] r8 = r3.split(r8)
            goto L_0x00d4
        L_0x00d2:
            java.lang.String[] r8 = f3847
        L_0x00d4:
            if (r6 == 0) goto L_0x00dd
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r6.split(r0)
            goto L_0x00df
        L_0x00dd:
            java.lang.String[] r0 = f3847
        L_0x00df:
            int r1 = r8.length
            int r2 = r0.length
            if (r1 <= r2) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            r8 = r0
        L_0x00e5:
            return r8
        L_0x00e6:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            r8.<init>(r0)     // Catch:{ all -> 0x00ee }
            throw r8     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ee }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.mo9654(java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: ֏ */
    public static String m3672(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        byte b;
        int i3;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = (i4 + length) / 2;
            while (i5 > -1 && bArr3[i5] != 10) {
                i5--;
            }
            int i6 = i5 + 1;
            int i7 = 1;
            while (true) {
                i2 = i6 + i7;
                if (bArr3[i2] == 10) {
                    break;
                }
                i7++;
            }
            int i8 = i2 - i6;
            int i9 = i;
            boolean z = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (z) {
                    z = false;
                    b = 46;
                } else {
                    b = bArr4[i9][i10] & 255;
                }
                i3 = b - (bArr3[i6 + i11] & 255);
                if (i3 == 0) {
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length == i10) {
                        if (i9 == bArr4.length - 1) {
                            break;
                        }
                        i9++;
                        z = true;
                        i10 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i3 >= 0) {
                if (i3 <= 0) {
                    int i12 = i8 - i11;
                    int length2 = bArr4[i9].length - i10;
                    while (true) {
                        i9++;
                        if (i9 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i9].length;
                    }
                    if (length2 >= i12) {
                        if (length2 <= i12) {
                            return new String(bArr3, i6, i8, Util.f737);
                        }
                    }
                }
                i4 = i2 + 1;
            }
            length = i6 - 1;
        }
        return null;
    }

    /* renamed from: ֏ */
    public final void mo9653() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            BufferedSource r0 = C0745.m1951((Source) new GzipSource(C0745.m1948(resourceAsStream)));
            try {
                byte[] bArr = new byte[r0.readInt()];
                r0.readFully(bArr);
                byte[] bArr2 = new byte[r0.readInt()];
                r0.readFully(bArr2);
                synchronized (this) {
                    this.f3852 = bArr;
                    this.f3853 = bArr2;
                }
                this.f3851.countDown();
            } finally {
                Util.m946((Closeable) r0);
            }
        }
    }
}
