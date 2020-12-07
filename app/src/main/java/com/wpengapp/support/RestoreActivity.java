package com.wpengapp.support;

import android.view.View;
import java.util.Set;

/* renamed from: com.wpengapp.support.Ƹ */
class RestoreActivity implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ Set f961;

    /* renamed from: ؠ */
    public final /* synthetic */ com.wpengapp.support.backup.p005ui.RestoreActivity f962;

    public RestoreActivity(com.wpengapp.support.backup.p005ui.RestoreActivity restoreActivity, Set set) {
        this.f962 = restoreActivity;
        this.f961 = set;
    }

    public boolean onClick(View view) {
        this.f962.mo7853((Set<String>) this.f961);
        return false;
    }
}
