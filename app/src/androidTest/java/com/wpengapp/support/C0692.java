package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.П */
/* compiled from: InputContactActivity */
class C0692 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ InputContactActivity f1798;

    public C0692(InputContactActivity inputContactActivity) {
        this.f1798 = inputContactActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1798.f682.setChecked(!z);
    }
}
