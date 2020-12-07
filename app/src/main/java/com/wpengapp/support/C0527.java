package com.wpengapp.support;

import android.text.TextUtils;
import com.wpengapp.support.backup.p005ui.RestoreActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* renamed from: com.wpengapp.support.ǘ */
/* compiled from: RestoreActivity */
public class C0527 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ String f984;

    /* renamed from: ؠ */
    public final /* synthetic */ RestoreActivity f985;

    public C0527(RestoreActivity restoreActivity, String str) {
        this.f985 = restoreActivity;
        this.f984 = str;
    }

    public void run() {
        RestoreActivity restoreActivity = this.f985;
        byte[] r1 = FileUtils.m1138(new File(this.f984));
        BackupPackage r2 = null;
        if (r1 != null) {
            try {
                String r12 = C1279.m3401(r1, C1279.f3606.mo8863());
                if (!TextUtils.isEmpty(r12)) {
                    try {
                        r2 = (BackupPackage) GsonUtil.m2740(r12, BackupPackage.class);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            } catch (UnsupportedEncodingException e2) {
                e2.getMessage();
            }
        }
        restoreActivity.f673 = r2;
        RestoreActivity restoreActivity2 = this.f985;
        BackupPackage r13 = restoreActivity2.f673;
        if (r13 == null) {
            restoreActivity2.mo7430();
            this.f985.finish();
            C0826.m2172(R$string.pw_restore_read_fail, new Object[0]);
        } else if (!C1279.f3606.mo8861(r13)) {
            this.f985.mo7430();
            this.f985.finish();
            C0826.m2172(R$string.pw_restore_check_fail, new Object[0]);
        } else {
            this.f985.runOnUiThread(new C0528(this));
        }
    }
}
