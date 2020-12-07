package com.wpengapp.support;

import com.wpengapp.support.backup.p005ui.BackupActivity;
import java.io.File;
import java.util.List;

/* renamed from: com.wpengapp.support.ɐ */
/* compiled from: BackupActivity */
public class C0572 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ String f1219;

    /* renamed from: ؠ */
    public final /* synthetic */ List f1220;

    /* renamed from: ހ */
    public final /* synthetic */ BackupActivity f1221;

    public C0572(BackupActivity backupActivity, String str, List list) {
        this.f1221 = backupActivity;
        this.f1219 = str;
        this.f1220 = list;
    }

    public void run() {
        File r0 = C1279.m3397(this.f1219, (List<String>) this.f1220, this.f1221.f667);
        if (r0 == null) {
            C0826.m2179(R$string.pw_backup_fail, new Object[0]);
            return;
        }
        C0826.m2177((CharSequence) this.f1221.getString(R$string.pw_backup_success) + "\n" + r0.getPath());
        this.f1221.finish();
    }
}
