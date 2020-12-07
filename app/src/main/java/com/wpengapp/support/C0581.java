package com.wpengapp.support;

import android.view.View;
import com.wpengapp.baseui.widget.ClearEditText;
import com.wpengapp.lightstart.activity.AppSetupListActivity;

/* renamed from: com.wpengapp.support.ɹ */
/* compiled from: lambda */
public final /* synthetic */ class C0581 implements OnDialogClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ AppSetupListActivity f1261;

    /* renamed from: ؠ */
    private final /* synthetic */ ClearEditText f1262;

    public /* synthetic */ C0581(AppSetupListActivity appSetupListActivity, ClearEditText clearEditText) {
        this.f1261 = appSetupListActivity;
        this.f1262 = clearEditText;
    }

    public final boolean onClick(View view) {
        return this.f1261.mo7577(this.f1262, view);
    }
}
