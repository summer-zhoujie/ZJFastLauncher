package com.wpengapp.support;

import android.view.View;
import android.widget.EditText;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.Չ */
/* compiled from: WPengVersionActivity */
public class C0784 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ EditText f2032;

    public C0784(WPengVersionActivity wPengVersionActivity, EditText editText) {
        this.f2032 = editText;
    }

    public void run() {
        this.f2032.requestFocus();
        C0826.m2174((View) this.f2032);
    }
}
