package com.wpengapp.support;

import android.support.p000v4.app.NotificationCompat;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.wpengapp.support.Ⴀ */
/* compiled from: StatisticsManager */
public final class C1298 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ List f3697;

    public C1298(List list) {
        this.f3697 = list;
    }

    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        Exception e;
        HashMap hashMap = new HashMap();
        String r0 = GsonUtil.m2742(this.f3697);
        int length = r0.length();
        if (length > 100) {
            if (r0.length() != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream.write(r0.getBytes("UTF-8"));
                            gZIPOutputStream.finish();
                            r0 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.getMessage();
                                FileUtils.close((Closeable) gZIPOutputStream);
                                FileUtils.close((Closeable) byteArrayOutputStream);
                                "Compress event " + length + " to " + r0.length();
                                hashMap.put("cps", "1");
                                hashMap.put(NotificationCompat.CATEGORY_EVENT, r0);
                                new C0510(this, "POST", ApiConstant.f2711, hashMap, (String) null).mo8757(true);
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream;
                                gZIPOutputStream2 = gZIPOutputStream;
                                FileUtils.close((Closeable) gZIPOutputStream2);
                                FileUtils.close((Closeable) byteArrayOutputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        Exception exc = e3;
                        gZIPOutputStream = null;
                        e = exc;
                        e.getMessage();
                        FileUtils.close((Closeable) gZIPOutputStream);
                        FileUtils.close((Closeable) byteArrayOutputStream);
                        "Compress event " + length + " to " + r0.length();
                        hashMap.put("cps", "1");
                        hashMap.put(NotificationCompat.CATEGORY_EVENT, r0);
                        new C0510(this, "POST", ApiConstant.f2711, hashMap, (String) null).mo8757(true);
                    } catch (Throwable th2) {
                        th = th2;
                        FileUtils.close((Closeable) gZIPOutputStream2);
                        FileUtils.close((Closeable) byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    gZIPOutputStream = null;
                    e = e4;
                    byteArrayOutputStream = null;
                    e.getMessage();
                    FileUtils.close((Closeable) gZIPOutputStream);
                    FileUtils.close((Closeable) byteArrayOutputStream);
                    "Compress event " + length + " to " + r0.length();
                    hashMap.put("cps", "1");
                    hashMap.put(NotificationCompat.CATEGORY_EVENT, r0);
                    new C0510(this, "POST", ApiConstant.f2711, hashMap, (String) null).mo8757(true);
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    FileUtils.close((Closeable) gZIPOutputStream2);
                    FileUtils.close((Closeable) byteArrayOutputStream);
                    throw th;
                }
                FileUtils.close((Closeable) gZIPOutputStream);
                FileUtils.close((Closeable) byteArrayOutputStream);
            }
            "Compress event " + length + " to " + r0.length();
            hashMap.put("cps", "1");
        }
        hashMap.put(NotificationCompat.CATEGORY_EVENT, r0);
        new C0510(this, "POST", ApiConstant.f2711, hashMap, (String) null).mo8757(true);
    }
}
