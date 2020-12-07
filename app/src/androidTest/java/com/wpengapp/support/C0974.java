package com.wpengapp.support;

import android.view.View;
import com.wpengapp.baseui.widget.dialog.DialogView;

/* renamed from: com.wpengapp.support.ߙ */
/* compiled from: DialogBuilder */
class C0974 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ DialogView f2740;

    /* renamed from: ؠ */
    public final /* synthetic */ C0915 f2741;

    public C0974(C0915 r1, DialogView dialogView) {
        this.f2741 = r1;
        this.f2740 = dialogView;
    }

    public void onClick(View view) {
        OnDialogClickListener r0 = this.f2741.f2467;
        boolean z = true;
        if (r0 != null) {
            z = true ^ r0.onClick(view);
        }
        if (z) {
            this.f2740.f403.dismiss();
        }
    }
}
