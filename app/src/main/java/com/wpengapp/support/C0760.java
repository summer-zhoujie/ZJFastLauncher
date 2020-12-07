package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ӿ */
/* compiled from: AboutActivity */
public class C0760 implements View.OnClickListener {

    /* renamed from: ֏ */
    public int f1957;

    /* renamed from: ؠ */
    public long f1958;

    /* renamed from: ހ */
    public final /* synthetic */ AboutActivity f1959;

    public C0760(AboutActivity aboutActivity) {
        this.f1959 = aboutActivity;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1958 > 1000) {
            this.f1957 = 1;
        } else {
            this.f1957++;
        }
        this.f1958 = currentTimeMillis;
        if (this.f1957 == 5) {
            this.f1957 = 0;
            this.f1958 = 0;
            this.f1959.mo7820();
        }
    }
}
