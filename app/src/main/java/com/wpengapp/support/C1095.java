package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.LauncherActivity;

/* renamed from: com.wpengapp.support.ઇ */
/* compiled from: LauncherActivity */
class C1095 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ LauncherActivity f3114;

    public C1095(LauncherActivity launcherActivity) {
        this.f3114 = launcherActivity;
    }

    public boolean onClick(View view) {
        this.f3114.finish();
        BaseApplication.f561.mo7792();
        return false;
    }
}
