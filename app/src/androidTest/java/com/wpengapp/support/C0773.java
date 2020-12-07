package com.wpengapp.support;

import android.widget.CompoundButton;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.Է */
/* compiled from: InputContactActivity */
class C0773 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ InputContactActivity f1992;

    public C0773(InputContactActivity inputContactActivity) {
        this.f1992 = inputContactActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1992.f681.setChecked(!z);
    }
}
