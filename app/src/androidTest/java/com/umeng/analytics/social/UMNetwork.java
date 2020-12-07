package com.umeng.analytics.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.umeng.analytics.social.c */
public abstract class UMNetwork {
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0133  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m213a(String r7) {
        /*
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0.nextInt(r1)
            r1 = 0
            java.lang.String r2 = "line.separator"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            int r3 = r7.length()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r4 = 1
            if (r3 > r4) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r2.<init>()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r2.append(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r3 = ":  Invalid baseUrl."
            r2.append(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r2.toString()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            boolean r7 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            return r1
        L_0x002c:
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r3.<init>(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r4 = 10000(0x2710, float:1.4013E-41)
            r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x010a }
            r4 = 20000(0x4e20, float:2.8026E-41)
            r3.setReadTimeout(r4)     // Catch:{ Exception -> 0x010a }
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch:{ Exception -> 0x010a }
            java.lang.String r4 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x010a }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x010a }
            r5 = 8
            if (r4 >= r5) goto L_0x0057
            java.lang.String r4 = "http.keepAlive"
            java.lang.String r5 = "false"
            java.lang.System.setProperty(r4, r5)     // Catch:{ Exception -> 0x010a }
        L_0x0057:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r4.<init>()     // Catch:{ Exception -> 0x010a }
            r4.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = ": GET_URL: "
            r4.append(r5)     // Catch:{ Exception -> 0x010a }
            r4.append(r7)     // Catch:{ Exception -> 0x010a }
            r4.toString()     // Catch:{ Exception -> 0x010a }
            boolean r4 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010a }
            int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x010a }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00f1
            java.io.InputStream r4 = r3.getInputStream()     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r5 = r3.getHeaderField(r5)     // Catch:{ Exception -> 0x010a }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x010a }
            if (r6 != 0) goto L_0x00a4
            java.lang.String r6 = "gzip"
            boolean r6 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x010a }
            if (r6 == 0) goto L_0x00a4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r5.<init>()     // Catch:{ Exception -> 0x010a }
            r5.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "  Use GZIPInputStream get data...."
            r5.append(r6)     // Catch:{ Exception -> 0x010a }
            r5.toString()     // Catch:{ Exception -> 0x010a }
            boolean r5 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010a }
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x010a }
            r5.<init>(r4)     // Catch:{ Exception -> 0x010a }
            goto L_0x00cb
        L_0x00a4:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x010a }
            if (r6 != 0) goto L_0x00ca
            java.lang.String r6 = "deflate"
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x010a }
            if (r5 == 0) goto L_0x00ca
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r5.<init>()     // Catch:{ Exception -> 0x010a }
            r5.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "  Use InflaterInputStream get data...."
            r5.append(r6)     // Catch:{ Exception -> 0x010a }
            r5.toString()     // Catch:{ Exception -> 0x010a }
            boolean r5 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010a }
            java.util.zip.InflaterInputStream r5 = new java.util.zip.InflaterInputStream     // Catch:{ Exception -> 0x010a }
            r5.<init>(r4)     // Catch:{ Exception -> 0x010a }
            goto L_0x00cb
        L_0x00ca:
            r5 = r4
        L_0x00cb:
            java.lang.String r4 = m212a((java.io.InputStream) r5)     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r5.<init>()     // Catch:{ Exception -> 0x010a }
            r5.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = ":  response: "
            r5.append(r6)     // Catch:{ Exception -> 0x010a }
            r5.append(r2)     // Catch:{ Exception -> 0x010a }
            r5.append(r4)     // Catch:{ Exception -> 0x010a }
            r5.toString()     // Catch:{ Exception -> 0x010a }
            boolean r7 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010a }
            if (r4 != 0) goto L_0x00ed
            r3.disconnect()
            return r1
        L_0x00ed:
            r3.disconnect()
            return r4
        L_0x00f1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r2.<init>()     // Catch:{ Exception -> 0x010a }
            r2.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r4 = ":  Failed to get message."
            r2.append(r4)     // Catch:{ Exception -> 0x010a }
            r2.append(r7)     // Catch:{ Exception -> 0x010a }
            r2.toString()     // Catch:{ Exception -> 0x010a }
            boolean r7 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010a }
            r3.disconnect()
            return r1
        L_0x010a:
            r2 = move-exception
            goto L_0x0111
        L_0x010c:
            r7 = move-exception
            r3 = r1
            goto L_0x0131
        L_0x010f:
            r2 = move-exception
            r3 = r1
        L_0x0111:
            java.lang.String r4 = "MobclickAgent"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r5.<init>()     // Catch:{ all -> 0x0130 }
            r5.append(r0)     // Catch:{ all -> 0x0130 }
            java.lang.String r0 = ":  Exception,Failed to send message."
            r5.append(r0)     // Catch:{ all -> 0x0130 }
            r5.append(r7)     // Catch:{ all -> 0x0130 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0130 }
            com.umeng.analytics.social.UMLog.m207c(r4, r7, r2)     // Catch:{ all -> 0x0130 }
            if (r3 == 0) goto L_0x012f
            r3.disconnect()
        L_0x012f:
            return r1
        L_0x0130:
            r7 = move-exception
        L_0x0131:
            if (r3 == 0) goto L_0x0136
            r3.disconnect()
        L_0x0136:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.social.UMNetwork.m213a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m212a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8192);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + "\n");
                } else {
                    try {
                        inputStream.close();
                        return sb.toString();
                    } catch (IOException e) {
                        UMLog.m205b("MobclickAgent", "Caught IOException in convertStreamToString()", e);
                        return null;
                    }
                }
            } catch (IOException e2) {
                UMLog.m205b("MobclickAgent", "Caught IOException in convertStreamToString()", e2);
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e3) {
                    UMLog.m205b("MobclickAgent", "Caught IOException in convertStreamToString()", e3);
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e4) {
                    UMLog.m205b("MobclickAgent", "Caught IOException in convertStreamToString()", e4);
                    return null;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0138  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m214a(String r7, String r8) {
        /*
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0.nextInt(r1)
            r1 = 0
            java.lang.String r2 = "line.separator"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r4 = 10000(0x2710, float:1.4013E-41)
            r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x010f }
            r4 = 20000(0x4e20, float:2.8026E-41)
            r3.setReadTimeout(r4)     // Catch:{ Exception -> 0x010f }
            r4 = 1
            r3.setDoOutput(r4)     // Catch:{ Exception -> 0x010f }
            r3.setDoInput(r4)     // Catch:{ Exception -> 0x010f }
            r4 = 0
            r3.setUseCaches(r4)     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ Exception -> 0x010f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r4.<init>()     // Catch:{ Exception -> 0x010f }
            r4.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r5 = ": POST_URL: "
            r4.append(r5)     // Catch:{ Exception -> 0x010f }
            r4.append(r7)     // Catch:{ Exception -> 0x010f }
            r4.toString()     // Catch:{ Exception -> 0x010f }
            boolean r4 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x010f }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x010f }
            r5 = 8
            if (r4 >= r5) goto L_0x005d
            java.lang.String r4 = "http.keepAlive"
            java.lang.String r5 = "false"
            java.lang.System.setProperty(r4, r5)     // Catch:{ Exception -> 0x010f }
        L_0x005d:
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x010f }
            if (r4 != 0) goto L_0x00aa
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r4.<init>()     // Catch:{ Exception -> 0x010f }
            r4.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r5 = ": POST_BODY: "
            r4.append(r5)     // Catch:{ Exception -> 0x010f }
            r4.append(r8)     // Catch:{ Exception -> 0x010f }
            r4.toString()     // Catch:{ Exception -> 0x010f }
            boolean r4 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x010f }
            r4.<init>()     // Catch:{ Exception -> 0x010f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r5.<init>()     // Catch:{ Exception -> 0x010f }
            java.lang.String r6 = "data="
            r5.append(r6)     // Catch:{ Exception -> 0x010f }
            r5.append(r8)     // Catch:{ Exception -> 0x010f }
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x010f }
            r4.add(r8)     // Catch:{ Exception -> 0x010f }
            java.io.OutputStream r8 = r3.getOutputStream()     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = java.net.URLEncoder.encode(r4)     // Catch:{ Exception -> 0x010f }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x010f }
            r8.write(r4)     // Catch:{ Exception -> 0x010f }
            r8.flush()     // Catch:{ Exception -> 0x010f }
            r8.close()     // Catch:{ Exception -> 0x010f }
        L_0x00aa:
            int r8 = r3.getResponseCode()     // Catch:{ Exception -> 0x010f }
            r4 = 200(0xc8, float:2.8E-43)
            if (r8 != r4) goto L_0x00f6
            java.io.InputStream r8 = r3.getInputStream()     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r4 = r3.getHeaderField(r4)     // Catch:{ Exception -> 0x010f }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x010f }
            if (r5 != 0) goto L_0x00d0
            java.lang.String r5 = "gzip"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x010f }
            if (r4 == 0) goto L_0x00d0
            java.util.zip.InflaterInputStream r4 = new java.util.zip.InflaterInputStream     // Catch:{ Exception -> 0x010f }
            r4.<init>(r8)     // Catch:{ Exception -> 0x010f }
            r8 = r4
        L_0x00d0:
            java.lang.String r8 = m212a((java.io.InputStream) r8)     // Catch:{ Exception -> 0x010f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r4.<init>()     // Catch:{ Exception -> 0x010f }
            r4.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r5 = ":  response: "
            r4.append(r5)     // Catch:{ Exception -> 0x010f }
            r4.append(r2)     // Catch:{ Exception -> 0x010f }
            r4.append(r8)     // Catch:{ Exception -> 0x010f }
            r4.toString()     // Catch:{ Exception -> 0x010f }
            boolean r7 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010f }
            if (r8 != 0) goto L_0x00f2
            r3.disconnect()
            return r1
        L_0x00f2:
            r3.disconnect()
            return r8
        L_0x00f6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r8.<init>()     // Catch:{ Exception -> 0x010f }
            r8.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r2 = ":  Failed to send message."
            r8.append(r2)     // Catch:{ Exception -> 0x010f }
            r8.append(r7)     // Catch:{ Exception -> 0x010f }
            r8.toString()     // Catch:{ Exception -> 0x010f }
            boolean r7 = com.umeng.analytics.social.UMSocialConstants.f263v     // Catch:{ Exception -> 0x010f }
            r3.disconnect()
            return r1
        L_0x010f:
            r8 = move-exception
            goto L_0x0116
        L_0x0111:
            r7 = move-exception
            r3 = r1
            goto L_0x0136
        L_0x0114:
            r8 = move-exception
            r3 = r1
        L_0x0116:
            java.lang.String r2 = "MobclickAgent"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r4.<init>()     // Catch:{ all -> 0x0135 }
            r4.append(r0)     // Catch:{ all -> 0x0135 }
            java.lang.String r0 = ":  Exception,Failed to send message."
            r4.append(r0)     // Catch:{ all -> 0x0135 }
            r4.append(r7)     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0135 }
            com.umeng.analytics.social.UMLog.m207c(r2, r7, r8)     // Catch:{ all -> 0x0135 }
            if (r3 == 0) goto L_0x0134
            r3.disconnect()
        L_0x0134:
            return r1
        L_0x0135:
            r7 = move-exception
        L_0x0136:
            if (r3 == 0) goto L_0x013b
            r3.disconnect()
        L_0x013b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.social.UMNetwork.m214a(java.lang.String, java.lang.String):java.lang.String");
    }
}
