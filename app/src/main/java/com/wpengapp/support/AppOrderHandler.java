package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.view.View;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ư */
class AppOrderHandler implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ InputContactActivity f955;

    /* renamed from: ؠ */
    public final /* synthetic */ UseAppCodeListener f956;

    public AppOrderHandler(C1114 r1, InputContactActivity inputContactActivity, UseAppCodeListener r3) {
        this.f955 = inputContactActivity;
        this.f956 = r3;
    }

    public boolean onClick(View view) {
        this.f955.finish();
        this.f956.mo8519(false, BidiFormatter.EMPTY_STRING, ErrorCode.APP_CODE_USED);
        return false;
    }
}
