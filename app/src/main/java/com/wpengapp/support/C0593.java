package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.activity.ToastRecordActivity;

/* renamed from: com.wpengapp.support.ʇ */
/* compiled from: ToastRecordActivity */
public class C0593 implements View.OnClickListener {

    /* renamed from: ֏ */
    public int f1333;

    /* renamed from: ؠ */
    public long f1334;

    public C0593(ToastRecordActivity toastRecordActivity) {
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1334 > 1000) {
            this.f1333 = 1;
        } else {
            this.f1333++;
        }
        this.f1334 = currentTimeMillis;
        if (this.f1333 == 2) {
            this.f1333 = 0;
            this.f1334 = 0;
            C0488.m1087();
        }
    }
}
