package com.wpengapp.support;

import android.view.View;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ŭ */
/* compiled from: WPengVersionActivity */
class C0496 implements View.OnLongClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ WPengVersionActivity f883;

    public C0496(WPengVersionActivity wPengVersionActivity) {
        this.f883 = wPengVersionActivity;
    }

    public boolean onLongClick(View view) {
        C0536.m1324();
        if (this.f883.f659 == null) {
            return false;
        }
        WPengVersionActivity wPengVersionActivity = this.f883;
        wPengVersionActivity.mo7844(wPengVersionActivity.f659);
        return false;
    }
}
