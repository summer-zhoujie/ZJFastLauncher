package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.wpengapp.support.ˁ */
public final class DiskLruCache implements Closeable {

    /* renamed from: ֏ */
    public static final Pattern f1468 = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: ؠ */
    public static final OutputStream f1469 = new C0794();

    /* renamed from: ހ */
    public final File f1470;

    /* renamed from: ށ */
    public final File f1471;

    /* renamed from: ނ */
    public final File f1472;

    /* renamed from: ރ */
    public final File f1473;

    /* renamed from: ބ */
    public final int f1474;

    /* renamed from: ޅ */
    public long f1475;

    /* renamed from: ކ */
    public int f1476;

    /* renamed from: އ */
    public final int f1477;

    /* renamed from: ވ */
    public long f1478 = 0;

    /* renamed from: މ */
    public int f1479 = 0;

    /* renamed from: ފ */
    public Writer f1480;

    /* renamed from: ދ */
    public final LinkedHashMap<String, C0616> f1481 = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: ތ */
    public int f1482;

    /* renamed from: ލ */
    public long f1483 = 0;

    /* renamed from: ގ */
    public final ThreadPoolExecutor f1484 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: ޏ */
    public final Callable<Void> f1485 = new C0618(this);

    /* renamed from: com.wpengapp.support.ˁ$ހ */
    /* compiled from: DiskLruCache */
    public final class C0617 implements Closeable {

        /* renamed from: ֏ */
        public File[] f1497;

        /* renamed from: ؠ */
        public final InputStream[] f1498;

        public /* synthetic */ C0617(DiskLruCache r1, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, C0618 r8) {
            this.f1497 = fileArr;
            this.f1498 = inputStreamArr;
        }

        public void close() {
            for (InputStream r3 : this.f1498) {
                C0613.m1533((Closeable) r3);
            }
        }
    }

    public DiskLruCache(File file, int i, int i2, long j, int i3) {
        File file2 = file;
        this.f1470 = file2;
        this.f1474 = i;
        this.f1471 = new File(file2, "journal");
        this.f1472 = new File(file2, "journal.tmp");
        this.f1473 = new File(file2, "journal.bkp");
        this.f1477 = i2;
        this.f1475 = j;
        this.f1476 = i3;
    }

    public synchronized void close() {
        if (this.f1480 != null) {
            Iterator it = new ArrayList(this.f1481.values()).iterator();
            while (it.hasNext()) {
                C0616 r1 = (C0616) it.next();
                if (r1.f1494 != null) {
                    r1.f1494.mo8327();
                }
            }
            mo8325();
            mo8324();
            this.f1480.close();
            this.f1480 = null;
        }
    }

    /* renamed from: އ */
    public final void mo8319() {
        if (this.f1480 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: ވ */
    public final boolean mo8320() {
        int i = this.f1482;
        return i >= 2000 && i >= this.f1481.size();
    }

    /* renamed from: މ */
    public final void mo8321() {
        m1543(this.f1472);
        Iterator<C0616> it = this.f1481.values().iterator();
        while (it.hasNext()) {
            C0616 next = it.next();
            int i = 0;
            if (next.f1494 == null) {
                while (i < this.f1477) {
                    this.f1478 += next.f1492[i];
                    this.f1479++;
                    i++;
                }
            } else {
                next.f1494 = null;
                while (i < this.f1477) {
                    m1543(next.mo8333(i));
                    m1543(next.mo8336(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f1482 = r0 - r9.f1481.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x006c=Splitter:B:20:0x006c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: ފ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8322() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.wpengapp.support.ʾ r1 = new com.wpengapp.support.ʾ
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f1471
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.wpengapp.support.C0613.f1461
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.mo8310()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = r1.mo8310()     // Catch:{ all -> 0x009a }
            java.lang.String r4 = r1.mo8310()     // Catch:{ all -> 0x009a }
            java.lang.String r5 = r1.mo8310()     // Catch:{ all -> 0x009a }
            java.lang.String r6 = r1.mo8310()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            int r7 = r9.f1474     // Catch:{ all -> 0x009a }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x009a }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            int r4 = r9.f1477     // Catch:{ all -> 0x009a }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x009a }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.mo8310()     // Catch:{ EOFException -> 0x005f }
            r9.mo8316((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r2 = r9.f1481     // Catch:{ all -> 0x009a }
            int r2 = r2.size()     // Catch:{ all -> 0x009a }
            int r0 = r0 - r2
            r9.f1482 = r0     // Catch:{ all -> 0x009a }
            com.wpengapp.support.C0613.m1533((java.io.Closeable) r1)
            return
        L_0x006c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r7.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x009a }
            r7.append(r2)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r3)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r5)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r6)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x009a }
            r4.<init>(r0)     // Catch:{ all -> 0x009a }
            throw r4     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            com.wpengapp.support.C0613.m1533((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.mo8322():void");
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ދ */
    public final synchronized void mo8323() {
        if (this.f1480 != null) {
            this.f1480.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1472), C0613.f1461));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f1474));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f1477));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0616 next : this.f1481.values()) {
                if (next.f1494 != null) {
                    bufferedWriter.write("DIRTY " + next.f1491 + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f1491 + next.mo8335() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f1471.exists()) {
                m1544(this.f1471, this.f1473, true);
            }
            m1544(this.f1472, this.f1471, false);
            this.f1473.delete();
            this.f1480 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1471, true), C0613.f1461));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: ތ */
    public final void mo8324() {
        while (this.f1479 > this.f1476) {
            mo8317((String) this.f1481.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: ލ */
    public final void mo8325() {
        while (this.f1478 > this.f1475) {
            mo8317((String) this.f1481.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: com.wpengapp.support.ˁ$֏ */
    /* compiled from: DiskLruCache */
    public final class C0614 {

        /* renamed from: ֏ */
        public final C0616 f1486;

        /* renamed from: ؠ */
        public final boolean[] f1487;

        /* renamed from: ހ */
        public boolean f1488;

        public /* synthetic */ C0614(C0616 r2, C0618 r3) {
            boolean[] zArr;
            this.f1486 = r2;
            if (r2.f1493) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.f1477];
            }
            this.f1487 = zArr;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public OutputStream mo8326(int r4) {
            /*
                r3 = this;
                com.wpengapp.support.ˁ r0 = com.wpengapp.support.DiskLruCache.this
                monitor-enter(r0)
                com.wpengapp.support.ˁ$ؠ r1 = r3.f1486     // Catch:{ all -> 0x0040 }
                com.wpengapp.support.ˁ$֏ r1 = r1.f1494     // Catch:{ all -> 0x0040 }
                if (r1 != r3) goto L_0x003a
                com.wpengapp.support.ˁ$ؠ r1 = r3.f1486     // Catch:{ all -> 0x0040 }
                boolean r1 = r1.f1493     // Catch:{ all -> 0x0040 }
                if (r1 != 0) goto L_0x0014
                boolean[] r1 = r3.f1487     // Catch:{ all -> 0x0040 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0040 }
            L_0x0014:
                com.wpengapp.support.ˁ$ؠ r1 = r3.f1486     // Catch:{ all -> 0x0040 }
                java.io.File r4 = r1.mo8336((int) r4)     // Catch:{ all -> 0x0040 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0020 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0020 }
                goto L_0x002e
            L_0x0020:
                com.wpengapp.support.ˁ r1 = com.wpengapp.support.DiskLruCache.this     // Catch:{ all -> 0x0040 }
                java.io.File r1 = r1.f1470     // Catch:{ all -> 0x0040 }
                r1.mkdirs()     // Catch:{ all -> 0x0040 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0036 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0036 }
            L_0x002e:
                com.wpengapp.support.ˁ$֏$֏ r4 = new com.wpengapp.support.ˁ$֏$֏     // Catch:{ all -> 0x0040 }
                r2 = 0
                r4.<init>(r1, r2)     // Catch:{ all -> 0x0040 }
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                return r4
            L_0x0036:
                java.io.OutputStream r4 = com.wpengapp.support.DiskLruCache.f1469     // Catch:{ all -> 0x0040 }
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                return r4
            L_0x003a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0040 }
                r4.<init>()     // Catch:{ all -> 0x0040 }
                throw r4     // Catch:{ all -> 0x0040 }
            L_0x0040:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.C0614.mo8326(int):java.io.OutputStream");
        }

        /* renamed from: ؠ */
        public void mo8328() {
            if (this.f1488) {
                DiskLruCache.this.mo8314(this, false);
                DiskLruCache.this.mo8317(this.f1486.f1491);
                return;
            }
            DiskLruCache.this.mo8314(this, true);
        }

        /* renamed from: com.wpengapp.support.ˁ$֏$֏ */
        /* compiled from: DiskLruCache */
        private class C0615 extends FilterOutputStream {
            public /* synthetic */ C0615(OutputStream outputStream, C0618 r3) {
                super(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0614.this.f1488 = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0614.this.f1488 = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0614.this.f1488 = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0614.this.f1488 = true;
                }
            }
        }

        /* renamed from: ֏ */
        public void mo8327() {
            DiskLruCache.this.mo8314(this, false);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r12.f1482++;
        r12.f1480.append("READ " + r13 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (mo8320() == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r12.f1484.submit(r12.f1485);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return new com.wpengapp.support.DiskLruCache.C0617(r12, r13, r0.f1495, r8, r9, r0.f1492, (com.wpengapp.support.C0618) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized C0617 mo8315(String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r12.mo8319()     // Catch:{ all -> 0x0087 }
            r12.mo8318((java.lang.String) r13)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r0 = r12.f1481     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x0087 }
            com.wpengapp.support.ˁ$ؠ r0 = (com.wpengapp.support.DiskLruCache.C0616) r0     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r12)
            return r1
        L_0x0014:
            boolean r2 = r0.f1493     // Catch:{ all -> 0x0087 }
            if (r2 != 0) goto L_0x001a
            monitor-exit(r12)
            return r1
        L_0x001a:
            int r2 = r12.f1477     // Catch:{ all -> 0x0087 }
            java.io.File[] r8 = new java.io.File[r2]     // Catch:{ all -> 0x0087 }
            int r2 = r12.f1477     // Catch:{ all -> 0x0087 }
            java.io.InputStream[] r9 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0087 }
            r2 = 0
            r3 = 0
        L_0x0024:
            int r4 = r12.f1477     // Catch:{ FileNotFoundException -> 0x0075 }
            if (r3 >= r4) goto L_0x0038
            java.io.File r4 = r0.mo8333((int) r3)     // Catch:{ FileNotFoundException -> 0x0075 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0075 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0075 }
            r9[r3] = r5     // Catch:{ FileNotFoundException -> 0x0075 }
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0038:
            int r1 = r12.f1482     // Catch:{ all -> 0x0087 }
            int r1 = r1 + 1
            r12.f1482 = r1     // Catch:{ all -> 0x0087 }
            java.io.Writer r1 = r12.f1480     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r13)     // Catch:{ all -> 0x0087 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            boolean r1 = r12.mo8320()     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0066
            java.util.concurrent.ThreadPoolExecutor r1 = r12.f1484     // Catch:{ all -> 0x0087 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r12.f1485     // Catch:{ all -> 0x0087 }
            r1.submit(r2)     // Catch:{ all -> 0x0087 }
        L_0x0066:
            com.wpengapp.support.ˁ$ހ r1 = new com.wpengapp.support.ˁ$ހ     // Catch:{ all -> 0x0087 }
            long r6 = r0.f1495     // Catch:{ all -> 0x0087 }
            long[] r10 = r0.f1492     // Catch:{ all -> 0x0087 }
            r11 = 0
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r8, r9, r10, r11)     // Catch:{ all -> 0x0087 }
            monitor-exit(r12)
            return r1
        L_0x0075:
            int r13 = r12.f1477     // Catch:{ all -> 0x0087 }
            if (r2 >= r13) goto L_0x0085
            r13 = r9[r2]     // Catch:{ all -> 0x0087 }
            if (r13 == 0) goto L_0x0085
            r13 = r9[r2]     // Catch:{ all -> 0x0087 }
            com.wpengapp.support.C0613.m1533((java.io.Closeable) r13)     // Catch:{ all -> 0x0087 }
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0085:
            monitor-exit(r12)
            return r1
        L_0x0087:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.mo8315(java.lang.String):com.wpengapp.support.ˁ$ހ");
    }

    /* renamed from: ހ */
    public final void mo8316(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f1481.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C0616 r5 = this.f1481.get(str2);
            if (r5 == null) {
                r5 = new C0616(str2, (C0618) null);
                this.f1481.put(str2, r5);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                r5.f1493 = true;
                r5.f1494 = null;
                r5.mo8337(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                r5.f1494 = new C0614(r5, (C0618) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException(outline.m2556("unexpected journal line: ", str));
            }
        } else {
            throw new IOException(outline.m2556("unexpected journal line: ", str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return false;
     */
    /* renamed from: ށ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo8317(String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.mo8319()     // Catch:{ all -> 0x0090 }
            r8.mo8318((java.lang.String) r9)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r0 = r8.f1481     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0090 }
            com.wpengapp.support.ˁ$ؠ r0 = (com.wpengapp.support.DiskLruCache.C0616) r0     // Catch:{ all -> 0x0090 }
            r1 = 0
            if (r0 == 0) goto L_0x008e
            com.wpengapp.support.ˁ$֏ r2 = r0.f1494     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0018
            goto L_0x008e
        L_0x0018:
            int r2 = r8.f1477     // Catch:{ all -> 0x0090 }
            r3 = 1
            if (r1 >= r2) goto L_0x005a
            java.io.File r2 = r0.mo8333((int) r1)     // Catch:{ all -> 0x0090 }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0045
            boolean r4 = r2.delete()     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x002e
            goto L_0x0045
        L_0x002e:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r0.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0090 }
            r0.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0090 }
            r9.<init>(r0)     // Catch:{ all -> 0x0090 }
            throw r9     // Catch:{ all -> 0x0090 }
        L_0x0045:
            long r4 = r8.f1478     // Catch:{ all -> 0x0090 }
            long[] r2 = r0.f1492     // Catch:{ all -> 0x0090 }
            r6 = r2[r1]     // Catch:{ all -> 0x0090 }
            long r4 = r4 - r6
            r8.f1478 = r4     // Catch:{ all -> 0x0090 }
            int r4 = r8.f1479     // Catch:{ all -> 0x0090 }
            int r4 = r4 - r3
            r8.f1479 = r4     // Catch:{ all -> 0x0090 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0090 }
            int r1 = r1 + 1
            goto L_0x0018
        L_0x005a:
            int r0 = r8.f1482     // Catch:{ all -> 0x0090 }
            int r0 = r0 + r3
            r8.f1482 = r0     // Catch:{ all -> 0x0090 }
            java.io.Writer r0 = r8.f1480     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r1.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "REMOVE "
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            r1.append(r9)     // Catch:{ all -> 0x0090 }
            r2 = 10
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            r0.append(r1)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r0 = r8.f1481     // Catch:{ all -> 0x0090 }
            r0.remove(r9)     // Catch:{ all -> 0x0090 }
            boolean r9 = r8.mo8320()     // Catch:{ all -> 0x0090 }
            if (r9 == 0) goto L_0x008c
            java.util.concurrent.ThreadPoolExecutor r9 = r8.f1484     // Catch:{ all -> 0x0090 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r8.f1485     // Catch:{ all -> 0x0090 }
            r9.submit(r0)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            monitor-exit(r8)
            return r3
        L_0x008e:
            monitor-exit(r8)
            return r1
        L_0x0090:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.mo8317(java.lang.String):boolean");
    }

    /* renamed from: ނ */
    public final void mo8318(String str) {
        if (!f1468.matcher(str).matches()) {
            throw new IllegalArgumentException(outline.m2545("keys must match regex [a-z0-9_-]{1,64}: \"", str, "\""));
        }
    }

    /* renamed from: com.wpengapp.support.ˁ$ؠ */
    /* compiled from: DiskLruCache */
    private final class C0616 {

        /* renamed from: ֏ */
        public final String f1491;

        /* renamed from: ؠ */
        public final long[] f1492;

        /* renamed from: ހ */
        public boolean f1493;

        /* renamed from: ށ */
        public C0614 f1494;

        /* renamed from: ނ */
        public long f1495;

        public /* synthetic */ C0616(String str, C0618 r3) {
            this.f1491 = str;
            this.f1492 = new long[DiskLruCache.this.f1477];
        }

        /* renamed from: ֏ */
        public String mo8335() {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f1492) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* renamed from: ؠ */
        public final void mo8337(String[] strArr) {
            if (strArr.length == DiskLruCache.this.f1477) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f1492[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        mo8334(strArr);
                        throw null;
                    }
                }
                return;
            }
            mo8334(strArr);
            throw null;
        }

        /* renamed from: ֏ */
        public final IOException mo8334(String[] strArr) {
            StringBuilder r1 = outline.m2549("unexpected journal line: ");
            r1.append(Arrays.toString(strArr));
            throw new IOException(r1.toString());
        }

        /* renamed from: ֏ */
        public File mo8333(int i) {
            File r1 = DiskLruCache.this.f1470;
            return new File(r1, this.f1491 + BidiFormatter.EMPTY_STRING + i);
        }

        /* renamed from: ؠ */
        public File mo8336(int i) {
            File r1 = DiskLruCache.this.f1470;
            return new File(r1, this.f1491 + BidiFormatter.EMPTY_STRING + i + ".tmp");
        }
    }

    /* renamed from: ֏ */
    public static DiskLruCache m1540(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m1544(file2, file3, false);
                }
            }
            DiskLruCache r3 = new DiskLruCache(file, i, i2, j, i3);
            if (r3.f1471.exists()) {
                try {
                    r3.mo8322();
                    r3.mo8321();
                    r3.f1480 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r3.f1471, true), C0613.f1461));
                    return r3;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    r3.close();
                    C0613.m1534(r3.f1470);
                }
            }
            file.mkdirs();
            DiskLruCache r1 = new DiskLruCache(file, i, i2, j, i3);
            r1.mo8323();
            return r1;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: ֏ */
    public static void m1543(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: ֏ */
    public static void m1544(File file, File file2, boolean z) {
        if (z) {
            m1543(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return null;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized C0614 mo8313(String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mo8319()     // Catch:{ all -> 0x005c }
            r5.mo8318((java.lang.String) r6)     // Catch:{ all -> 0x005c }
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r0 = r5.f1481     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005c }
            com.wpengapp.support.ˁ$ؠ r0 = (com.wpengapp.support.DiskLruCache.C0616) r0     // Catch:{ all -> 0x005c }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0020
            if (r0 == 0) goto L_0x001e
            long r1 = r0.f1495     // Catch:{ all -> 0x005c }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0020
        L_0x001e:
            monitor-exit(r5)
            return r3
        L_0x0020:
            if (r0 != 0) goto L_0x002d
            com.wpengapp.support.ˁ$ؠ r0 = new com.wpengapp.support.ˁ$ؠ     // Catch:{ all -> 0x005c }
            r0.<init>(r6, r3)     // Catch:{ all -> 0x005c }
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r7 = r5.f1481     // Catch:{ all -> 0x005c }
            r7.put(r6, r0)     // Catch:{ all -> 0x005c }
            goto L_0x0033
        L_0x002d:
            com.wpengapp.support.ˁ$֏ r7 = r0.f1494     // Catch:{ all -> 0x005c }
            if (r7 == 0) goto L_0x0033
            monitor-exit(r5)
            return r3
        L_0x0033:
            com.wpengapp.support.ˁ$֏ r7 = new com.wpengapp.support.ˁ$֏     // Catch:{ all -> 0x005c }
            r7.<init>(r0, r3)     // Catch:{ all -> 0x005c }
            r0.f1494 = r7     // Catch:{ all -> 0x005c }
            java.io.Writer r8 = r5.f1480     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r0.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x005c }
            r0.append(r6)     // Catch:{ all -> 0x005c }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x005c }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x005c }
            r8.write(r6)     // Catch:{ all -> 0x005c }
            java.io.Writer r6 = r5.f1480     // Catch:{ all -> 0x005c }
            r6.flush()     // Catch:{ all -> 0x005c }
            monitor-exit(r5)
            return r7
        L_0x005c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.mo8313(java.lang.String, long):com.wpengapp.support.ˁ$֏");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fd, code lost:
        return;
     */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo8314(C0614 r11, boolean r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.wpengapp.support.ˁ$ؠ r0 = r11.f1486     // Catch:{ all -> 0x0104 }
            com.wpengapp.support.ˁ$֏ r1 = r0.f1494     // Catch:{ all -> 0x0104 }
            if (r1 != r11) goto L_0x00fe
            r1 = 0
            if (r12 == 0) goto L_0x0045
            boolean r2 = r0.f1493     // Catch:{ all -> 0x0104 }
            if (r2 != 0) goto L_0x0045
            r2 = 0
        L_0x000f:
            int r3 = r10.f1477     // Catch:{ all -> 0x0104 }
            if (r2 >= r3) goto L_0x0045
            boolean[] r3 = r11.f1487     // Catch:{ all -> 0x0104 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0104 }
            if (r3 == 0) goto L_0x002b
            java.io.File r3 = r0.mo8336((int) r2)     // Catch:{ all -> 0x0104 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0104 }
            if (r3 != 0) goto L_0x0028
            r11.mo8327()     // Catch:{ all -> 0x0104 }
            monitor-exit(r10)
            return
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002b:
            r11.mo8327()     // Catch:{ all -> 0x0104 }
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0104 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r12.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r12.append(r0)     // Catch:{ all -> 0x0104 }
            r12.append(r2)     // Catch:{ all -> 0x0104 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0104 }
            r11.<init>(r12)     // Catch:{ all -> 0x0104 }
            throw r11     // Catch:{ all -> 0x0104 }
        L_0x0045:
            int r11 = r10.f1477     // Catch:{ all -> 0x0104 }
            r2 = 1
            if (r1 >= r11) goto L_0x007b
            java.io.File r11 = r0.mo8336((int) r1)     // Catch:{ all -> 0x0104 }
            if (r12 == 0) goto L_0x0075
            boolean r3 = r11.exists()     // Catch:{ all -> 0x0104 }
            if (r3 == 0) goto L_0x0078
            java.io.File r3 = r0.mo8333((int) r1)     // Catch:{ all -> 0x0104 }
            r11.renameTo(r3)     // Catch:{ all -> 0x0104 }
            long[] r11 = r0.f1492     // Catch:{ all -> 0x0104 }
            r4 = r11[r1]     // Catch:{ all -> 0x0104 }
            long r6 = r3.length()     // Catch:{ all -> 0x0104 }
            long[] r11 = r0.f1492     // Catch:{ all -> 0x0104 }
            r11[r1] = r6     // Catch:{ all -> 0x0104 }
            long r8 = r10.f1478     // Catch:{ all -> 0x0104 }
            long r8 = r8 - r4
            long r8 = r8 + r6
            r10.f1478 = r8     // Catch:{ all -> 0x0104 }
            int r11 = r10.f1479     // Catch:{ all -> 0x0104 }
            int r11 = r11 + r2
            r10.f1479 = r11     // Catch:{ all -> 0x0104 }
            goto L_0x0078
        L_0x0075:
            m1543((java.io.File) r11)     // Catch:{ all -> 0x0104 }
        L_0x0078:
            int r1 = r1 + 1
            goto L_0x0045
        L_0x007b:
            int r11 = r10.f1482     // Catch:{ all -> 0x0104 }
            int r11 = r11 + r2
            r10.f1482 = r11     // Catch:{ all -> 0x0104 }
            r11 = 0
            r0.f1494 = r11     // Catch:{ all -> 0x0104 }
            boolean r11 = r0.f1493     // Catch:{ all -> 0x0104 }
            r11 = r11 | r12
            r1 = 10
            if (r11 == 0) goto L_0x00ba
            r0.f1493 = r2     // Catch:{ all -> 0x0104 }
            java.io.Writer r11 = r10.f1480     // Catch:{ all -> 0x0104 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r2.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = "CLEAN "
            r2.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = r0.f1491     // Catch:{ all -> 0x0104 }
            r2.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = r0.mo8335()     // Catch:{ all -> 0x0104 }
            r2.append(r3)     // Catch:{ all -> 0x0104 }
            r2.append(r1)     // Catch:{ all -> 0x0104 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0104 }
            r11.write(r1)     // Catch:{ all -> 0x0104 }
            if (r12 == 0) goto L_0x00dc
            long r11 = r10.f1483     // Catch:{ all -> 0x0104 }
            r1 = 1
            long r1 = r1 + r11
            r10.f1483 = r1     // Catch:{ all -> 0x0104 }
            r0.f1495 = r11     // Catch:{ all -> 0x0104 }
            goto L_0x00dc
        L_0x00ba:
            java.util.LinkedHashMap<java.lang.String, com.wpengapp.support.ˁ$ؠ> r11 = r10.f1481     // Catch:{ all -> 0x0104 }
            java.lang.String r12 = r0.f1491     // Catch:{ all -> 0x0104 }
            r11.remove(r12)     // Catch:{ all -> 0x0104 }
            java.io.Writer r11 = r10.f1480     // Catch:{ all -> 0x0104 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r12.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r2 = "REMOVE "
            r12.append(r2)     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = r0.f1491     // Catch:{ all -> 0x0104 }
            r12.append(r0)     // Catch:{ all -> 0x0104 }
            r12.append(r1)     // Catch:{ all -> 0x0104 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0104 }
            r11.write(r12)     // Catch:{ all -> 0x0104 }
        L_0x00dc:
            java.io.Writer r11 = r10.f1480     // Catch:{ all -> 0x0104 }
            r11.flush()     // Catch:{ all -> 0x0104 }
            long r11 = r10.f1478     // Catch:{ all -> 0x0104 }
            long r0 = r10.f1475     // Catch:{ all -> 0x0104 }
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f5
            int r11 = r10.f1479     // Catch:{ all -> 0x0104 }
            int r12 = r10.f1476     // Catch:{ all -> 0x0104 }
            if (r11 > r12) goto L_0x00f5
            boolean r11 = r10.mo8320()     // Catch:{ all -> 0x0104 }
            if (r11 == 0) goto L_0x00fc
        L_0x00f5:
            java.util.concurrent.ThreadPoolExecutor r11 = r10.f1484     // Catch:{ all -> 0x0104 }
            java.util.concurrent.Callable<java.lang.Void> r12 = r10.f1485     // Catch:{ all -> 0x0104 }
            r11.submit(r12)     // Catch:{ all -> 0x0104 }
        L_0x00fc:
            monitor-exit(r10)
            return
        L_0x00fe:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0104 }
            r11.<init>()     // Catch:{ all -> 0x0104 }
            throw r11     // Catch:{ all -> 0x0104 }
        L_0x0104:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.DiskLruCache.mo8314(com.wpengapp.support.ˁ$֏, boolean):void");
    }
}
