package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.ł */
/* compiled from: FilePickerDialog */
class C0478 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ C0584 f815;

    public C0478(C0584 r1) {
        this.f815 = r1;
    }

    public void onClick(View view) {
        this.f815.dismiss();
        if (this.f815.f1272 != null) {
            this.f815.f1272.mo7459(this.f815.f1268.getDir());
        }
    }
}
