package com.wpengapp.support;

import com.wpengapp.support.backup.p005ui.BackupActivity;
import java.util.List;

/* renamed from: com.wpengapp.support.ხ */
/* compiled from: BackupActivity */
public class C1331 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ String f3802;

    /* renamed from: ؠ */
    public final /* synthetic */ List f3803;

    public C1331(BackupActivity backupActivity, String str, List list) {
        this.f3802 = str;
        this.f3803 = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f3802
            java.util.List r1 = r4.f3803
            java.io.File r2 = com.wpengapp.support.FileManager.m1198()
            java.lang.String r2 = r2.getAbsolutePath()
            java.io.File r0 = com.wpengapp.support.C1279.m3397((java.lang.String) r0, (java.util.List<java.lang.String>) r1, (java.lang.String) r2)
            r1 = 0
            if (r0 == 0) goto L_0x0045
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0045
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "android.intent.action.SEND"
            r2.setAction(r3)
            java.lang.String r3 = "*/*"
            r2.setType(r3)
            android.net.Uri r0 = com.wpengapp.support.FileManager.m1192((java.io.File) r0)
            String r3 = "android.intent.extra.STREAM"
            r2.putExtra(r3, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r0 < r3) goto L_0x003b
            r0 = 3
            r2.addFlags(r0)
        L_0x003b:
            r0 = 0
            com.wpengapp.support.SystemUtils.m3510((android.content.Context) r0, (android.content.Intent) r2)     // Catch:{ Exception -> 0x0041 }
            r0 = 1
            goto L_0x0046
        L_0x0041:
            r0 = move-exception
            r0.getMessage()
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r0 != 0) goto L_0x004f
            int r0 = com.wpengapp.support.R$string.pw_backup_fail
            Object[] r1 = new Object[r1]
            C0826.m2179(r0, r1)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1331.run():void");
    }
}
