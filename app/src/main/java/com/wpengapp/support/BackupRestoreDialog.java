package com.wpengapp.support;

import android.app.Activity;
import android.content.Context;
import com.wpengapp.baseui.filepicker.FilePicker;
import com.wpengapp.support.backup.p005ui.BackupActivity;
import com.wpengapp.support.backup.p005ui.RestoreActivity;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;
import java.util.HashSet;

/* renamed from: com.wpengapp.support.Ś */
public class BackupRestoreDialog extends C0584 implements FilePicker.C0422 {

    /* renamed from: ރ */
    public boolean f852;

    public BackupRestoreDialog(Context context, boolean z) {
        super(context);
        this.f852 = z;
        this.f1268.setDir(BackupActivity.m848());
        HashSet hashSet = new HashSet();
        hashSet.add(C1279.f3606.mo8860());
        this.f1268.setSupportExts(hashSet);
        this.f1268.setOnFileClickListener(this);
        this.f1271.setText(AppUtils.m1141(R$string.pw_restore_select, new Object[0]));
    }

    /* renamed from: ֏ */
    public static void m1075(Activity activity, boolean z) {
        if (!RequestPermissionHelper.m902()) {
            C0936.m2466(new BackupRestoreDialog(activity, z));
        }
    }

    /* renamed from: ֏ */
    public void mo7459(File file) {
        RestoreActivity.m851(getContext(), this.f852, file.getAbsolutePath());
        dismiss();
    }
}
