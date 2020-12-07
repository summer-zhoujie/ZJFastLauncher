package com.wpengapp.support;

import android.view.View;

/* renamed from: com.wpengapp.support.ཤ */
public class NotifyRecordActivity implements View.OnClickListener {

    /* renamed from: ֏ */
    public int f3574;

    /* renamed from: ؠ */
    public long f3575;

    public NotifyRecordActivity(com.wpengapp.lightstart.activity.NotifyRecordActivity notifyRecordActivity) {
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3575 > 1000) {
            this.f3574 = 1;
        } else {
            this.f3574++;
        }
        this.f3575 = currentTimeMillis;
        if (this.f3574 == 2) {
            this.f3574 = 0;
            this.f3575 = 0;
            C0488.m1087();
        }
    }
}
