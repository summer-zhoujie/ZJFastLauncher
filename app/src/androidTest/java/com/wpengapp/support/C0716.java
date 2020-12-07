package com.wpengapp.support;

import android.view.View;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.support.C0961;

/* renamed from: com.wpengapp.support.і */
/* compiled from: ChoiceAppListAdapter */
class C0716 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AppWrapper f1843;

    /* renamed from: ؠ */
    public final /* synthetic */ C0961.C0962 f1844;

    /* renamed from: ހ */
    public final /* synthetic */ C0961 f1845;

    public C0716(C0961 r1, AppWrapper appWrapper, C0961.C0962 r3) {
        this.f1845 = r1;
        this.f1843 = appWrapper;
        this.f1844 = r3;
    }

    public void onClick(View view) {
        if (this.f1845.f2675) {
            this.f1845.f2672.clear();
            this.f1845.f2672.add(this.f1843);
            if (this.f1845.f2678 != null) {
                this.f1845.f2678.mo7476(true, this.f1843);
                return;
            }
            return;
        }
        this.f1844.f2681.toggle();
    }
}
