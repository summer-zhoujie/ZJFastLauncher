package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.licensing.activity.QrPayActivity;

/* renamed from: com.wpengapp.support.Ӵ */
/* compiled from: QrPayActivity */
class C0756 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ QrPayActivity f1953;

    public C0756(QrPayActivity qrPayActivity) {
        this.f1953 = qrPayActivity;
    }

    public boolean onClick(View view) {
        this.f1953.finish();
        return false;
    }
}
