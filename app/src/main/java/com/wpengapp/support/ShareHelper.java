package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import com.wpengapp.support.activity.FeedbackActivity;

/* renamed from: com.wpengapp.support.я */
class ShareHelper implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AlertDialog f1837;

    /* renamed from: ؠ */
    public final /* synthetic */ Context f1838;

    public ShareHelper(AlertDialog r1, Context context) {
        this.f1837 = r1;
        this.f1838 = context;
    }

    public void onClick(View view) {
        this.f1837.dismiss();
        FeedbackActivity.m795(this.f1838);
    }
}
