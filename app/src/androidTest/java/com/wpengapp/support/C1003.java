package com.wpengapp.support;

import android.view.View;
import android.widget.EditText;
import com.wpengapp.lightstart.activity.AppReportActivity;

/* renamed from: com.wpengapp.support.उ */
/* compiled from: AppReportActivity */
public class C1003 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ EditText f2887;

    public C1003(AppReportActivity appReportActivity, EditText editText) {
        this.f2887 = editText;
    }

    public void run() {
        this.f2887.requestFocus();
        C0826.m2174((View) this.f2887);
    }
}
