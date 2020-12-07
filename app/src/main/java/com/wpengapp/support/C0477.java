package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.baseui.AppWrapper;

/* renamed from: com.wpengapp.support.ŀ */
/* compiled from: ChoiceAppListAdapter */
class C0477 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AppWrapper f813;

    /* renamed from: ؠ */
    public final /* synthetic */ C0961 f814;

    public C0477(C0961 r1, AppWrapper appWrapper) {
        this.f814 = r1;
        this.f813 = appWrapper;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z == this.f814.f2673) {
            this.f814.f2672.add(this.f813);
        } else {
            this.f814.f2672.remove(this.f813);
        }
        if (this.f814.f2678 != null) {
            this.f814.f2678.mo7476(z, this.f813);
        }
    }
}
