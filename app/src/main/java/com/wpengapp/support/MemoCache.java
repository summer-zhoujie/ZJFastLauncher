package com.wpengapp.support;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ҽ */
public class MemoCache {

    /* renamed from: ֏ */
    public List<IProtocol> f1916 = new ArrayList();

    /* renamed from: ؠ */
    public Context f1917 = null;

    public MemoCache(Context context) {
        this.f1917 = context;
    }

    /* renamed from: ֏ */
    public synchronized int mo8556() {
        int size;
        size = this.f1916.size();
        if (UMEntry.f1101 != 0) {
            size++;
        }
        return size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        r0 = com.wpengapp.support.UMEntry.f1101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r0 == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r6.f1103.f1139.f1104 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        com.wpengapp.support.C1315.f3758 = r5.f1917;
        com.wpengapp.support.C1315.C1317.f3769.mo9584(r6);
        r0 = com.umeng.analytics.InternalConfig.m115a(r5.f1917);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (android.text.TextUtils.isEmpty(r0[0]) != false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (android.text.TextUtils.isEmpty(r0[1]) != false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        r3 = r6.f1103.f1142;
        r3.f1105 = r0[0];
        r3.f1106 = r0[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r0 = com.wpengapp.support.ABTest.m2129(r5.f1917);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r0.f2063 != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
        r6.f1103.f1141.put("client_test", java.lang.Integer.valueOf(r0.f2066));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8559(UMEntry r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.List<com.wpengapp.support.ӄ> r0 = r5.f1916     // Catch:{ all -> 0x0091 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0091 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0017
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0091 }
            com.wpengapp.support.ӄ r1 = (com.wpengapp.support.IProtocol) r1     // Catch:{ all -> 0x0091 }
            r1.mo8167(r6)     // Catch:{ all -> 0x0091 }
            goto L_0x0007
        L_0x0017:
            android.content.Context r0 = r5.f1917     // Catch:{ all -> 0x0091 }
            android.content.SharedPreferences r0 = com.wpengapp.support.Utils.m1861((android.content.Context) r0)     // Catch:{ all -> 0x0091 }
            if (r0 != 0) goto L_0x0021
            monitor-exit(r5)     // Catch:{ all -> 0x0091 }
            return
        L_0x0021:
            java.lang.String r1 = "userlevel"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ all -> 0x0091 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x0033
            com.wpengapp.support.ȴ$މ r1 = r6.f1103     // Catch:{ all -> 0x0091 }
            r1.f1145 = r0     // Catch:{ all -> 0x0091 }
        L_0x0033:
            java.util.List<com.wpengapp.support.ӄ> r0 = r5.f1916     // Catch:{ all -> 0x0091 }
            r0.clear()     // Catch:{ all -> 0x0091 }
            monitor-exit(r5)     // Catch:{ all -> 0x0091 }
            long r0 = com.wpengapp.support.UMEntry.f1101
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0047
            com.wpengapp.support.ȴ$މ r2 = r6.f1103
            com.wpengapp.support.ȴ$֏ r2 = r2.f1139
            r2.f1104 = r0
        L_0x0047:
            android.content.Context r0 = r5.f1917
            com.wpengapp.support.C1315.f3758 = r0
            com.wpengapp.support.Ⴟ r0 = com.wpengapp.support.C1315.C1317.f3769
            r0.mo9584(r6)
            android.content.Context r0 = r5.f1917
            java.lang.String[] r0 = com.umeng.analytics.InternalConfig.m115a(r0)
            if (r0 == 0) goto L_0x0076
            r1 = 0
            r2 = r0[r1]
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0076
            r2 = 1
            r3 = r0[r2]
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0076
            com.wpengapp.support.ȴ$މ r3 = r6.f1103
            com.wpengapp.support.ȴ$ؠ r3 = r3.f1142
            r1 = r0[r1]
            r3.f1105 = r1
            r0 = r0[r2]
            r3.f1106 = r0
        L_0x0076:
            android.content.Context r0 = r5.f1917
            com.wpengapp.support.դ r0 = com.wpengapp.support.ABTest.m2129((android.content.Context) r0)
            boolean r1 = r0.f2063
            if (r1 != 0) goto L_0x0081
            goto L_0x0090
        L_0x0081:
            com.wpengapp.support.ȴ$މ r6 = r6.f1103
            java.util.Map<java.lang.String, java.lang.Integer> r6 = r6.f1141
            int r0 = r0.f2066
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "client_test"
            r6.put(r1, r0)
        L_0x0090:
            return
        L_0x0091:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0091 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.MemoCache.mo8559(com.wpengapp.support.ȴ):void");
    }

    /* renamed from: ֏ */
    public synchronized void mo8558(IProtocol r2) {
        this.f1916.add(r2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:76|77|78|(1:80)(1:81)|82|84) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0275 */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0281 A[Catch:{ Exception -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0287 A[Catch:{ Exception -> 0x02a8 }] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8557(UMEntry r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f1917
            java.lang.String r0 = com.wpengapp.support.SessionTracker.m1840(r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r0 = "ro.miui.ui.version.name"
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getAppkey(r2)
            r1.f1146 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getChannel(r2)
            r1.f1147 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getSecretKey(r2)
            java.lang.String r2 = com.wpengapp.support.HelperUtils.m2469((java.lang.String) r2)
            r1.f1148 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            int r2 = com.umeng.analytics.AnalyticsConfig.getVerticalType(r2)
            r1.f1158 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getSDKVersion(r2)
            r1.f1157 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2337(r2)
            r1.f1150 = r2
            android.content.Context r1 = r8.f1917
            java.lang.String r1 = com.wpengapp.support.DeviceConfig.m2322(r1)
            int r1 = java.lang.Integer.parseInt(r1)
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2323(r2)
            android.content.Context r3 = r8.f1917
            android.content.SharedPreferences r3 = com.wpengapp.support.Utils.m1861((android.content.Context) r3)
            java.lang.String r4 = ""
            r5 = 0
            if (r3 != 0) goto L_0x006d
            com.wpengapp.support.ȴ$ފ r3 = r9.f1102
            r3.f1153 = r1
            r3.f1149 = r2
            goto L_0x0081
        L_0x006d:
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = "versioncode"
            int r2 = r3.getInt(r2, r5)
            r1.f1153 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = "versionname"
            java.lang.String r2 = r3.getString(r2, r4)
            r1.f1149 = r2
        L_0x0081:
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2309((android.content.Context) r2)
            r1.f1151 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2317(r2)
            r1.f1152 = r2
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.mWrapperType
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.mWrapperVersion
            if (r1 == 0) goto L_0x00a7
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.mWrapperType
            r1.f1154 = r2
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.mWrapperVersion
            r1.f1155 = r2
        L_0x00a7:
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2324(r2)
            r1.f1165 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2324(r2)
            java.lang.String r2 = com.wpengapp.support.HelperUtils.m2472((java.lang.String) r2)
            r1.f1159 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2334(r2)
            r1.f1164 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.util.Properties r2 = com.wpengapp.support.DeviceConfig.m2318()
            r3 = 0
            java.lang.String r6 = r2.getProperty(r0)     // Catch:{ Exception -> 0x00f7 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00f7 }
            if (r7 == 0) goto L_0x00f4
            boolean r7 = com.wpengapp.support.DeviceConfig.m2320()     // Catch:{ Exception -> 0x00f7 }
            if (r7 == 0) goto L_0x00e5
            java.lang.String r2 = "Flyme"
            goto L_0x00fc
        L_0x00e5:
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2311((java.util.Properties) r2)     // Catch:{ Exception -> 0x00f7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00f7 }
            if (r2 != 0) goto L_0x00f2
            java.lang.String r2 = "YunOS"
            goto L_0x00fc
        L_0x00f2:
            r2 = r6
            goto L_0x00fc
        L_0x00f4:
            java.lang.String r2 = "MIUI"
            goto L_0x00fc
        L_0x00f7:
            r2 = move-exception
            r2.printStackTrace()
            r2 = r3
        L_0x00fc:
            r1.f1173 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.util.Properties r2 = com.wpengapp.support.DeviceConfig.m2318()
            java.lang.String r0 = r2.getProperty(r0)     // Catch:{ Exception -> 0x013d }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0142
            boolean r6 = com.wpengapp.support.DeviceConfig.m2320()     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0136
            java.lang.String r0 = "ro.build.display.id"
            java.lang.String r0 = r2.getProperty(r0)     // Catch:{ Exception -> 0x0141 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "flyme os"
            boolean r2 = r0.contains(r2)     // Catch:{ Exception -> 0x0141 }
            if (r2 == 0) goto L_0x0141
            java.lang.String r2 = " "
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0141 }
            r2 = 2
            r0 = r0[r2]     // Catch:{ Exception -> 0x0141 }
            goto L_0x0142
        L_0x0136:
            java.lang.String r0 = com.wpengapp.support.DeviceConfig.m2311((java.util.Properties) r2)     // Catch:{ Exception -> 0x013b }
            goto L_0x0142
        L_0x013b:
            goto L_0x0142
        L_0x013d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0141:
            r0 = r3
        L_0x0142:
            r1.f1174 = r0
            android.content.Context r0 = r8.f1917
            int[] r0 = com.wpengapp.support.DeviceConfig.m2335(r0)
            r1 = 1
            if (r0 == 0) goto L_0x0169
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = r0[r1]
            r6.append(r7)
            java.lang.String r7 = "*"
            r6.append(r7)
            r0 = r0[r5]
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.f1163 = r0
        L_0x0169:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.GPU_RENDERER
            if (r0 == 0) goto L_0x016f
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.GPU_VENDER
        L_0x016f:
            android.content.Context r0 = r8.f1917
            java.lang.String[] r0 = com.wpengapp.support.DeviceConfig.m2327(r0)
            r2 = r0[r5]
            java.lang.String r6 = "Wi-Fi"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0186
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            java.lang.String r6 = "wifi"
            r2.f1179 = r6
            goto L_0x019b
        L_0x0186:
            r2 = r0[r5]
            java.lang.String r6 = "2G/3G"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0195
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            r2.f1179 = r6
            goto L_0x019b
        L_0x0195:
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            java.lang.String r6 = "unknow"
            r2.f1179 = r6
        L_0x019b:
            r2 = r0[r1]
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x01a9
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            r0 = r0[r1]
            r2.f1180 = r0
        L_0x01a9:
            android.content.Context r0 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2325(r0)
            if (r2 != 0) goto L_0x01b2
            goto L_0x01f1
        L_0x01b2:
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.mcc
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.mnc
            if (r2 == 0) goto L_0x01f1
            java.lang.String r3 = java.lang.String.valueOf(r0)
            r4 = 10
            if (r0 >= r4) goto L_0x01de
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r5] = r0
            java.lang.String r0 = "%02d"
            java.lang.String r3 = java.lang.String.format(r0, r3)
        L_0x01de:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.append(r2)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x01f1:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x01fb
            com.wpengapp.support.ȴ$ފ r0 = r9.f1102
            r0.f1181 = r3
        L_0x01fb:
            com.wpengapp.support.ȴ$ފ r0 = r9.f1102
            android.content.Context r2 = r8.f1917
            java.lang.String r2 = com.wpengapp.support.DeviceConfig.m2326(r2)
            r0.f1178 = r2
            android.content.Context r0 = r8.f1917
            java.lang.String[] r0 = com.wpengapp.support.DeviceConfig.m2332(r0)
            com.wpengapp.support.ȴ$ފ r2 = r9.f1102
            r3 = r0[r5]
            r2.f1177 = r3
            r0 = r0[r1]
            r2.f1176 = r0
            android.content.Context r0 = r8.f1917
            int r0 = com.wpengapp.support.DeviceConfig.m2330(r0)
            long r0 = (long) r0
            r2.f1175 = r0
            android.content.Context r0 = r8.f1917
            java.lang.String r1 = "umeng_general_config"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r5)
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = "failed_requests "
            int r2 = r0.getInt(r2, r5)
            long r2 = (long) r2
            r1.f1183 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = "successful_request"
            int r2 = r0.getInt(r2, r5)
            long r2 = (long) r2
            r1.f1182 = r2
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102
            java.lang.String r2 = "last_request_spent_ms"
            int r0 = r0.getInt(r2, r5)
            long r2 = (long) r0
            r1.f1184 = r2
            r0 = -1
            android.content.Context r2 = r8.f1917     // Catch:{ Exception -> 0x0275 }
            com.wpengapp.support.Ę r2 = com.wpengapp.support.IdTracker.m984((android.content.Context) r2)     // Catch:{ Exception -> 0x0275 }
            com.wpengapp.support.น r2 = r2.f777     // Catch:{ Exception -> 0x0275 }
            if (r2 != 0) goto L_0x0254
            goto L_0x02a8
        L_0x0254:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0275 }
            r3.<init>()     // Catch:{ Exception -> 0x0275 }
            com.wpengapp.support.Ԑ r4 = new com.wpengapp.support.Ԑ     // Catch:{ Exception -> 0x0275 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0275 }
            com.wpengapp.support.ຜ r6 = new com.wpengapp.support.ຜ     // Catch:{ Exception -> 0x0275 }
            r6.<init>(r4, r0)     // Catch:{ Exception -> 0x0275 }
            r3.reset()     // Catch:{ Exception -> 0x0275 }
            r2.mo9122((com.wpengapp.support.TProtocol) r6)     // Catch:{ Exception -> 0x0275 }
            byte[] r2 = r3.toByteArray()     // Catch:{ Exception -> 0x0275 }
            com.wpengapp.support.ȴ$ފ r3 = r9.f1102     // Catch:{ Exception -> 0x0275 }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r5)     // Catch:{ Exception -> 0x0275 }
            r3.f1186 = r2     // Catch:{ Exception -> 0x0275 }
        L_0x0275:
            android.content.Context r2 = r8.f1917     // Catch:{ Exception -> 0x02a8 }
            com.wpengapp.support.ρ r2 = com.wpengapp.support.ImprintHandler.m1668((android.content.Context) r2)     // Catch:{ Exception -> 0x02a8 }
            com.wpengapp.support.ञ r2 = r2.mo8406()     // Catch:{ Exception -> 0x02a8 }
            if (r2 != 0) goto L_0x0287
            java.lang.String r0 = "trans the imprint is null"
            com.wpengapp.support.MLog.m1776(r0)     // Catch:{ Exception -> 0x02a8 }
            goto L_0x02a8
        L_0x0287:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x02a8 }
            r3.<init>()     // Catch:{ Exception -> 0x02a8 }
            com.wpengapp.support.Ԑ r4 = new com.wpengapp.support.Ԑ     // Catch:{ Exception -> 0x02a8 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x02a8 }
            com.wpengapp.support.ຜ r6 = new com.wpengapp.support.ຜ     // Catch:{ Exception -> 0x02a8 }
            r6.<init>(r4, r0)     // Catch:{ Exception -> 0x02a8 }
            r3.reset()     // Catch:{ Exception -> 0x02a8 }
            r2.mo9122((com.wpengapp.support.TProtocol) r6)     // Catch:{ Exception -> 0x02a8 }
            byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x02a8 }
            com.wpengapp.support.ȴ$ފ r1 = r9.f1102     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ Exception -> 0x02a8 }
            r1.f1185 = r0     // Catch:{ Exception -> 0x02a8 }
        L_0x02a8:
            r8.mo8559(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.MemoCache.mo8557(com.wpengapp.support.ȴ):void");
    }
}
