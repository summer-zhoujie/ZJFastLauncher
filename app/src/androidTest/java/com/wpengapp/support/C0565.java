package com.wpengapp.support;

import com.wpengapp.support.backup.p005ui.RestoreActivity;
import java.util.Set;

/* renamed from: com.wpengapp.support.Ⱦ */
/* compiled from: RestoreActivity */
class C0565 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Set f1200;

    /* renamed from: ؠ */
    public final /* synthetic */ RestoreActivity f1201;

    public C0565(RestoreActivity restoreActivity, Set set) {
        this.f1201 = restoreActivity;
        this.f1200 = set;
    }

    public void run() {
        try {
            if (!C1279.f3606.mo8862(this.f1201.f673, this.f1200)) {
                C0826.m2172(R$string.pw_restore_fail, new Object[0]);
                return;
            }
            C0826.m2172(R$string.pw_restore_success, new Object[0]);
            this.f1201.finish();
        } catch (Exception e) {
            e.getMessage();
            C0826.m2172(R$string.pw_restore_fail, new Object[0]);
        }
    }
}
