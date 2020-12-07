package com.wpengapp.support;

import com.wpengapp.baseui.filepicker.FilePicker;
import java.io.File;

/* renamed from: com.wpengapp.support.ǒ */
class BackupActivity implements FilePicker.C0422 {

    /* renamed from: ֏ */
    public final /* synthetic */ com.wpengapp.support.backup.p005ui.BackupActivity f981;

    public BackupActivity(com.wpengapp.support.backup.p005ui.BackupActivity backupActivity) {
        this.f981 = backupActivity;
    }

    /* renamed from: ֏ */
    public void mo7459(File file) {
        this.f981.f667 = file.getAbsolutePath();
        com.wpengapp.support.backup.p005ui.BackupActivity backupActivity = this.f981;
        backupActivity.f665.setText(FilePicker.m267(backupActivity.f667));
        CommonSP.m1229().putString("bkdir", this.f981.f667).apply();
    }
}
