package com.wpengapp.support;

import android.widget.EditText;
import com.wpengapp.lightstart.activity.AppReportActivity;

/* renamed from: com.wpengapp.support.ۯ */
/* compiled from: AppReportActivity */
public class C0913 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ EditText f2458;

    /* renamed from: ؠ */
    public final /* synthetic */ AppReportActivity f2459;

    public C0913(AppReportActivity appReportActivity, EditText editText) {
        this.f2459 = appReportActivity;
        this.f2458 = editText;
    }

    public void run() {
        this.f2459.f408.mo7472(this.f2458.getText().toString());
    }
}
