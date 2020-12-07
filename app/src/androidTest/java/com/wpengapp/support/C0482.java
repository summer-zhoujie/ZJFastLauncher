package com.wpengapp.support;

import android.view.View;
import com.wpengapp.baseui.widget.dialog.DialogView;

/* renamed from: com.wpengapp.support.ŕ */
/* compiled from: DialogBuilder */
class C0482 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ DialogView f832;

    /* renamed from: ؠ */
    public final /* synthetic */ C0915 f833;

    public C0482(C0915 r1, DialogView dialogView) {
        this.f833 = r1;
        this.f832 = dialogView;
    }

    public void onClick(View view) {
        OnDialogClickListener r0 = this.f833.f2468;
        boolean z = true;
        if (r0 != null) {
            z = true ^ r0.onClick(view);
        }
        if (z) {
            this.f832.f403.dismiss();
        }
    }
}
