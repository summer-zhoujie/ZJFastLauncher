package com.wpengapp.support;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wpengapp.support.त */
/* compiled from: DownloadHelper */
public class C1017 {

    /* renamed from: ֏ */
    public static final Map<Long, C1020> f2927 = new HashMap();

    /* renamed from: ؠ */
    public static C1019 f2928;

    /* renamed from: com.wpengapp.support.त$֏ */
    /* compiled from: DownloadHelper */
    public interface C1018 {
    }

    /* renamed from: com.wpengapp.support.त$ؠ */
    /* compiled from: DownloadHelper */
    private static class C1019 extends BroadcastReceiver {
        public /* synthetic */ C1019(DownloadHelper r1) {
        }

        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            C1020 remove = C1017.f2927.remove(Long.valueOf(longExtra));
            if (remove != null) {
                DownloadManager downloadManager = (DownloadManager) AppUtils.m1153("download");
                if (C1017.m2725(downloadManager, longExtra) == 8) {
                    try {
                        Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(longExtra);
                        if (remove.f2930 && uriForDownloadedFile != null) {
                            FileManager.m1195(uriForDownloadedFile);
                        }
                        C1018 r6 = remove.f2929;
                        if (r6 != null) {
                            ((C0753) r6).mo8571(uriForDownloadedFile);
                        }
                    } catch (Exception e) {
                        e.getMessage();
                        C1018 r5 = remove.f2929;
                        if (r5 != null) {
                            ((C0753) r5).mo8570();
                        }
                    }
                } else {
                    C1018 r52 = remove.f2929;
                    if (r52 != null) {
                        ((C0753) r52).mo8570();
                    }
                }
            }
            synchronized (C1017.f2927) {
                if (C1017.f2927.size() == 0) {
                    try {
                        AppUtils.getApplication().unregisterReceiver(this);
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                    C1017.f2928 = null;
                }
            }
        }
    }

    /* renamed from: com.wpengapp.support.त$ހ */
    /* compiled from: DownloadHelper */
    private static class C1020 {

        /* renamed from: ֏ */
        public C1018 f2929;

        /* renamed from: ؠ */
        public boolean f2930;

        public C1020(C1018 r1, boolean z) {
            this.f2929 = r1;
            this.f2930 = z;
        }
    }

    /* renamed from: ֏ */
    public static long m2726(String str, String str2, boolean z, C1018 r7) {
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            if (!TextUtils.isEmpty(str2)) {
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str2);
            }
            long enqueue = ((DownloadManager) AppUtils.m1153("download")).enqueue(request);
            f2927.put(Long.valueOf(enqueue), new C1020(r7, z));
            synchronized (f2927) {
                if (f2928 == null) {
                    f2928 = new C1019((DownloadHelper) null);
                    try {
                        AppUtils.getApplication().registerReceiver(f2928, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
            return enqueue;
        } catch (Exception e2) {
            e2.getMessage();
            SystemUtils.m3527(str);
            return -1;
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ int m2725(DownloadManager downloadManager, long j) {
        int i = 16;
        try {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{j});
            Cursor query2 = downloadManager.query(query);
            if (query2 != null) {
                if (query2.moveToFirst()) {
                    i = query2.getInt(query2.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
                }
                query2.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return i;
    }
}
