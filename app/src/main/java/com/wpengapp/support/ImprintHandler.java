package com.wpengapp.support;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.ReportPolicy;
import com.wpengapp.support.TCompactProtocol;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.wpengapp.support.ρ */
public class ImprintHandler {

    /* renamed from: ֏ */
    public static final byte[] f1679 = "pbl0".getBytes();

    /* renamed from: ؠ */
    public static ImprintHandler f1680;

    /* renamed from: ހ */
    public OnImprintChangedListener f1681;

    /* renamed from: ށ */
    public C0654 f1682 = new C0654();

    /* renamed from: ނ */
    public C1009 f1683 = null;

    /* renamed from: ރ */
    public Context f1684;

    public ImprintHandler(Context context) {
        this.f1684 = context;
    }

    /* renamed from: ֏ */
    public static synchronized ImprintHandler m1668(Context context) {
        ImprintHandler r2;
        synchronized (ImprintHandler.class) {
            if (f1680 == null) {
                f1680 = new ImprintHandler(context);
                f1680.mo8409();
            }
            r2 = f1680;
        }
        return r2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8409() {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r4.f1684
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = ".imprint"
            r0.<init>(r1, r2)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            r0 = 0
            android.content.Context r1 = r4.f1684     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            byte[] r0 = com.wpengapp.support.HelperUtils.m2473((java.io.InputStream) r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002f
        L_0x0020:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x004e
        L_0x0025:
            r2 = move-exception
            goto L_0x002c
        L_0x0027:
            r1 = move-exception
            goto L_0x004e
        L_0x0029:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002c:
            r2.printStackTrace()     // Catch:{ all -> 0x0020 }
        L_0x002f:
            com.wpengapp.support.HelperUtils.m2474(r1)
            if (r0 == 0) goto L_0x004d
            com.wpengapp.support.ञ r1 = new com.wpengapp.support.ञ     // Catch:{ Exception -> 0x0049 }
            r1.<init>()     // Catch:{ Exception -> 0x0049 }
            com.wpengapp.support.କ r2 = new com.wpengapp.support.କ     // Catch:{ Exception -> 0x0049 }
            r2.<init>()     // Catch:{ Exception -> 0x0049 }
            r2.mo9309(r1, r0)     // Catch:{ Exception -> 0x0049 }
            r4.f1683 = r1     // Catch:{ Exception -> 0x0049 }
            com.wpengapp.support.ρ$֏ r0 = r4.f1682     // Catch:{ Exception -> 0x0049 }
            r0.mo8416((com.wpengapp.support.C1009) r1)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004d:
            return
        L_0x004e:
            com.wpengapp.support.HelperUtils.m2474(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ImprintHandler.mo8409():void");
    }

    /* renamed from: ހ */
    public final C1009 mo8411(C1009 r6) {
        Map<String, C1179> map = r6.f2904;
        ArrayList<String> arrayList = new ArrayList<>(map.size() / 2);
        for (Map.Entry next : map.entrySet()) {
            if (!((C1179) next.getValue()).mo9414()) {
                arrayList.add(next.getKey());
            }
        }
        for (String remove : arrayList) {
            map.remove(remove);
        }
        return r6;
    }

    /* renamed from: ֏ */
    public String mo8408(C1009 r6) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(r6.f2904).entrySet()) {
            sb.append((String) entry.getKey());
            if (((C1179) entry.getValue()).mo9414()) {
                sb.append(((C1179) entry.getValue()).f3366);
            }
            sb.append(((C1179) entry.getValue()).f3367);
            sb.append(((C1179) entry.getValue()).f3368);
        }
        sb.append(r6.f2905);
        return HelperUtils.m2469(sb.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: com.wpengapp.support.ρ$֏ */
    /* compiled from: ImprintHandler */
    public static class C0654 {

        /* renamed from: ֏ */
        public int f1685 = -1;

        /* renamed from: ؠ */
        public int f1686 = -1;

        /* renamed from: ހ */
        public int f1687 = -1;

        /* renamed from: ށ */
        public int f1688 = -1;

        /* renamed from: ނ */
        public int f1689 = -1;

        /* renamed from: ރ */
        public String f1690 = null;

        /* renamed from: ބ */
        public int f1691 = -1;

        /* renamed from: ޅ */
        public String f1692 = null;

        /* renamed from: ކ */
        public int f1693 = -1;

        /* renamed from: އ */
        public int f1694 = -1;

        /* renamed from: ވ */
        public String f1695 = null;

        /* renamed from: ֏ */
        public final int mo8414(C1009 r2, String str) {
            C1179 r22;
            if (r2 == null) {
                return -1;
            }
            if (!(r2.f2904 != null) || (r22 = r2.f2904.get(str)) == null || TextUtils.isEmpty(r22.f3366)) {
                return -1;
            }
            try {
                return Integer.parseInt(r22.f3366.trim());
            } catch (Exception unused) {
                return -1;
            }
        }

        /* renamed from: ؠ */
        public final String mo8418(C1009 r2, String str) {
            C1179 r22;
            if (r2 == null) {
                return null;
            }
            if ((r2.f2904 != null) && (r22 = r2.f2904.get(str)) != null && !TextUtils.isEmpty(r22.f3366)) {
                return r22.f3366;
            }
            return null;
        }

        /* renamed from: ֏ */
        public void mo8416(C1009 r2) {
            if (r2 != null) {
                this.f1685 = mo8414(r2, "defcon");
                this.f1686 = mo8414(r2, "latent");
                this.f1687 = mo8414(r2, "codex");
                this.f1688 = mo8414(r2, "report_policy");
                this.f1689 = mo8414(r2, "report_interval");
                this.f1690 = mo8418(r2, "client_test");
                this.f1691 = mo8414(r2, "test_report_interval");
                this.f1692 = mo8418(r2, "umid");
                this.f1693 = mo8414(r2, "integrated_test");
                this.f1694 = mo8414(r2, "latent_hours");
                this.f1695 = mo8418(r2, "country");
                mo8418(r2, "domain_p");
                mo8418(r2, "domain_s");
            }
        }

        /* renamed from: ֏ */
        public int[] mo8417(int i, int i2) {
            int i3 = this.f1688;
            if (i3 == -1 || !ReportPolicy.m39a(i3)) {
                return new int[]{i, i2};
            }
            int i4 = this.f1689;
            if (i4 == -1 || i4 < 90 || i4 > 86400) {
                this.f1689 = 90;
            }
            return new int[]{this.f1688, this.f1689 * 1000};
        }

        /* renamed from: ֏ */
        public String mo8415(String str) {
            int parseInt;
            String str2 = this.f1690;
            if (str2 == null) {
                return str;
            }
            boolean z = false;
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("\\|");
                if (split.length == 6 && ((split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) || (split[0].startsWith("FIXED") && split[5].split(",").length >= (parseInt = Integer.parseInt(split[1])) && parseInt >= 1))) {
                    z = true;
                }
            }
            return !z ? str : this.f1690;
        }

        /* renamed from: ֏ */
        public int mo8413(int i) {
            int i2 = this.f1691;
            return (i2 == -1 || i2 < 90 || i2 > 86400) ? i : i2 * 1000;
        }
    }

    /* renamed from: ހ */
    public void mo8412() {
        if (this.f1683 != null) {
            try {
                TCompactProtocol.C1221 r0 = new TCompactProtocol.C1221();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TProtocol r02 = r0.mo9274(new TIOStreamTransport(byteArrayOutputStream));
                C1009 r2 = this.f1683;
                byteArrayOutputStream.reset();
                r2.mo9122(r02);
                HelperUtils.m2471(new File(this.f1684.getFilesDir(), ".imprint"), byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8410(C1009 r13) {
        /*
            r12 = this;
            if (r13 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r13.f2906
            java.lang.String r1 = r12.mo8408((com.wpengapp.support.C1009) r13)
            boolean r0 = r0.equals(r1)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0067
        L_0x0014:
            java.util.Map<java.lang.String, com.wpengapp.support.ฉ> r0 = r13.f2904
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0066
            java.lang.Object r4 = r0.next()
            com.wpengapp.support.ฉ r4 = (com.wpengapp.support.C1179) r4
            java.lang.String r5 = r4.mo9417()
            byte[] r5 = com.umeng.analytics.DataHelper.m61a((java.lang.String) r5)
            r6 = 8
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)
            r6.order(r1)
            long r7 = r4.mo9415()
            r6.putLong(r7)
            byte[] r4 = r6.array()
            byte[] r6 = f1679
            r7 = 4
            byte[] r8 = new byte[r7]
            r9 = 0
        L_0x004c:
            if (r9 >= r7) goto L_0x0059
            byte r10 = r4[r9]
            byte r11 = r6[r9]
            r10 = r10 ^ r11
            byte r10 = (byte) r10
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x004c
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 >= r7) goto L_0x001e
            byte r6 = r5[r4]
            byte r9 = r8[r4]
            if (r6 == r9) goto L_0x0063
            goto L_0x0012
        L_0x0063:
            int r4 = r4 + 1
            goto L_0x005a
        L_0x0066:
            r0 = 1
        L_0x0067:
            if (r0 != 0) goto L_0x006a
            return
        L_0x006a:
            monitor-enter(r12)
            com.wpengapp.support.ञ r0 = r12.f1683     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            java.lang.String r1 = r0.f2906     // Catch:{ all -> 0x00a6 }
        L_0x0072:
            if (r0 != 0) goto L_0x0078
            r12.mo8411(r13)     // Catch:{ all -> 0x00a6 }
            goto L_0x007c
        L_0x0078:
            r12.mo8407(r0, r13)     // Catch:{ all -> 0x00a6 }
            r13 = r0
        L_0x007c:
            r12.f1683 = r13     // Catch:{ all -> 0x00a6 }
            java.lang.String r13 = r13.f2906     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0088
            if (r13 == 0) goto L_0x0086
            r13 = 0
            goto L_0x008c
        L_0x0086:
            r13 = 1
            goto L_0x008c
        L_0x0088:
            boolean r13 = r1.equals(r13)     // Catch:{ all -> 0x00a6 }
        L_0x008c:
            if (r13 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = 0
        L_0x0090:
            monitor-exit(r12)     // Catch:{ all -> 0x00a6 }
            com.wpengapp.support.ञ r13 = r12.f1683
            if (r13 == 0) goto L_0x00a5
            if (r2 == 0) goto L_0x00a5
            com.wpengapp.support.ρ$֏ r0 = r12.f1682
            r0.mo8416((com.wpengapp.support.C1009) r13)
            com.wpengapp.support.श r13 = r12.f1681
            if (r13 == 0) goto L_0x00a5
            com.wpengapp.support.ρ$֏ r0 = r12.f1682
            r13.mo8091(r0)
        L_0x00a5:
            return
        L_0x00a6:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00a6 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.ImprintHandler.mo8410(com.wpengapp.support.ञ):void");
    }

    /* renamed from: ֏ */
    public final C1009 mo8407(C1009 r5, C1009 r6) {
        if (r6 == null) {
            return r5;
        }
        Map<String, C1179> map = r5.f2904;
        for (Map.Entry next : r6.f2904.entrySet()) {
            if (((C1179) next.getValue()).mo9414()) {
                map.put(next.getKey(), next.getValue());
            } else {
                map.remove(next.getKey());
            }
        }
        r5.f2905 = r6.f2905;
        r5.mo9123(true);
        r5.f2906 = mo8408(r5);
        return r5;
    }

    /* renamed from: ֏ */
    public synchronized C1009 mo8406() {
        return this.f1683;
    }
}
