package com.wpengapp.support;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.AnalyticsConstants;
import java.net.URLEncoder;

/* renamed from: com.wpengapp.support.ȫ */
public class NetworkHelper {

    /* renamed from: ֏ */
    public String f1091;

    /* renamed from: ؠ */
    public String f1092 = "10.0.0.172";

    /* renamed from: ހ */
    public int f1093 = 80;

    /* renamed from: ށ */
    public Context f1094;

    /* renamed from: ނ */
    public IRequestStat f1095;

    public NetworkHelper(Context context) {
        this.f1094 = context;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append("/");
        stringBuffer.append(AnalyticsConstants.f100c);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(DeviceConfig.m2316(context));
            stringBuffer2.append("/");
            stringBuffer2.append(DeviceConfig.m2323(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(Build.VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(HelperUtils.m2469(AnalyticsConfig.getAppkey(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1091 = stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fe, code lost:
        if (r7 != null) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0104 A[SYNTHETIC] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo8165(byte[] r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r3 = r0
            r2 = 0
        L_0x0004:
            java.lang.String[] r4 = com.umeng.analytics.AnalyticsConstants.f106i
            int r5 = r4.length
            if (r2 >= r5) goto L_0x012b
            r3 = r4[r2]
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "envelope/json"
            r6 = 1
            com.wpengapp.support.Ⴆ r7 = r12.f1095     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            if (r7 == 0) goto L_0x001b
            com.wpengapp.support.Ⴆ r7 = r12.f1095     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            com.wpengapp.support.ɒ r7 = (com.wpengapp.support.StatTracer) r7
            r7.mo8190()     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
        L_0x001b:
            boolean r7 = r12.mo8164()     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            if (r7 == 0) goto L_0x003d
            java.net.Proxy r7 = new java.net.Proxy     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.Proxy$Type r8 = java.net.Proxy.Type.HTTP     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.InetSocketAddress r9 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.lang.String r10 = r12.f1092     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            int r11 = r12.f1093     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.URLConnection r7 = r8.openConnection(r7)     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            goto L_0x0048
        L_0x003d:
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            r7.<init>(r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00f5, all -> 0x00f3 }
        L_0x0048:
            java.lang.String r8 = "X-Umeng-UTC"
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00f1 }
            r7.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = "X-Umeng-Sdk"
            java.lang.String r9 = r12.f1091     // Catch:{ Exception -> 0x00f1 }
            r7.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = "Msg-Type"
            r7.setRequestProperty(r8, r5)     // Catch:{ Exception -> 0x00f1 }
            r7.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x00f1 }
            r5 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00f1 }
            r5 = 30000(0x7530, float:4.2039E-41)
            r7.setReadTimeout(r5)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r5 = "POST"
            r7.setRequestMethod(r5)     // Catch:{ Exception -> 0x00f1 }
            r7.setDoOutput(r6)     // Catch:{ Exception -> 0x00f1 }
            r7.setDoInput(r6)     // Catch:{ Exception -> 0x00f1 }
            r7.setUseCaches(r1)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x00f1 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x00f1 }
            r8 = 8
            if (r5 >= r8) goto L_0x008d
            java.lang.String r5 = "http.keepAlive"
            java.lang.String r8 = "false"
            java.lang.System.setProperty(r5, r8)     // Catch:{ Exception -> 0x00f1 }
        L_0x008d:
            java.io.OutputStream r5 = r7.getOutputStream()     // Catch:{ Exception -> 0x00f1 }
            r5.write(r13)     // Catch:{ Exception -> 0x00f1 }
            r5.flush()     // Catch:{ Exception -> 0x00f1 }
            r5.close()     // Catch:{ Exception -> 0x00f1 }
            com.wpengapp.support.Ⴆ r5 = r12.f1095     // Catch:{ Exception -> 0x00f1 }
            if (r5 == 0) goto L_0x00a5
            com.wpengapp.support.Ⴆ r5 = r12.f1095     // Catch:{ Exception -> 0x00f1 }
            com.wpengapp.support.ɒ r5 = (com.wpengapp.support.StatTracer) r5
            r5.mo8191()     // Catch:{ Exception -> 0x00f1 }
        L_0x00a5:
            int r5 = r7.getResponseCode()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r4 = r7.getHeaderField(r4)     // Catch:{ Exception -> 0x00f1 }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00f1 }
            if (r8 != 0) goto L_0x00bd
            java.lang.String r8 = "application/thrift"
            boolean r4 = r4.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x00f1 }
            if (r4 == 0) goto L_0x00bd
            r4 = 1
            goto L_0x00be
        L_0x00bd:
            r4 = 0
        L_0x00be:
            r8 = 200(0xc8, float:2.8E-43)
            if (r5 != r8) goto L_0x00ed
            if (r4 == 0) goto L_0x00ed
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r4.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r5 = "Send message to "
            r4.append(r5)     // Catch:{ Exception -> 0x00f1 }
            r4.append(r3)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00f1 }
            com.wpengapp.support.MLog.m1769((java.lang.String) r3)     // Catch:{ Exception -> 0x00f1 }
            java.io.InputStream r3 = r7.getInputStream()     // Catch:{ Exception -> 0x00f1 }
            byte[] r4 = com.wpengapp.support.HelperUtils.m2473((java.io.InputStream) r3)     // Catch:{ all -> 0x00e8 }
            com.wpengapp.support.HelperUtils.m2474(r3)     // Catch:{ Exception -> 0x00f1 }
            r7.disconnect()
            r3 = r4
            goto L_0x0102
        L_0x00e8:
            r4 = move-exception
            com.wpengapp.support.HelperUtils.m2474(r3)     // Catch:{ Exception -> 0x00f1 }
            throw r4     // Catch:{ Exception -> 0x00f1 }
        L_0x00ed:
            r7.disconnect()
            goto L_0x0101
        L_0x00f1:
            r3 = move-exception
            goto L_0x00f7
        L_0x00f3:
            r13 = move-exception
            goto L_0x0125
        L_0x00f5:
            r3 = move-exception
            r7 = r0
        L_0x00f7:
            java.lang.String r4 = "IOException,Failed to send message."
            java.lang.String r5 = com.wpengapp.support.MLog.f1805     // Catch:{ all -> 0x0123 }
            com.wpengapp.support.MLog.m1777(r5, r4, r3)     // Catch:{ all -> 0x0123 }
            if (r7 == 0) goto L_0x0101
            goto L_0x00ed
        L_0x0101:
            r3 = r0
        L_0x0102:
            if (r3 == 0) goto L_0x0114
            com.wpengapp.support.Ⴆ r13 = r12.f1095
            if (r13 == 0) goto L_0x012b
            com.wpengapp.support.ɒ r13 = (com.wpengapp.support.StatTracer) r13
            int r0 = r13.f1222
            int r0 = r0 + r6
            r13.f1222 = r0
            long r0 = r13.f1226
            r13.f1225 = r0
            goto L_0x012b
        L_0x0114:
            com.wpengapp.support.Ⴆ r4 = r12.f1095
            if (r4 == 0) goto L_0x011f
            com.wpengapp.support.ɒ r4 = (com.wpengapp.support.StatTracer) r4
            int r5 = r4.f1223
            int r5 = r5 + r6
            r4.f1223 = r5
        L_0x011f:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0123:
            r13 = move-exception
            r0 = r7
        L_0x0125:
            if (r0 == 0) goto L_0x012a
            r0.disconnect()
        L_0x012a:
            throw r13
        L_0x012b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.NetworkHelper.mo8165(byte[]):byte[]");
    }

    /* renamed from: ֏ */
    public final boolean mo8164() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.f1094.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f1094.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f1094.getSystemService("connectivity");
            if (!DeviceConfig.m2313(this.f1094, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() == 1 || (extraInfo = activeNetworkInfo.getExtraInfo()) == null || (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap"))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
