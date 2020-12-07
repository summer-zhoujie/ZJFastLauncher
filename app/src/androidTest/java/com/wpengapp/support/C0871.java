package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.wpengapp.support.activity.RewardActivity;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ٹ */
/* compiled from: ShareHelper */
class C0871 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AlertDialog f2362;

    /* renamed from: ؠ */
    public final /* synthetic */ Context f2363;

    public C0871(AlertDialog r1, Context context) {
        this.f2362 = r1;
        this.f2363 = context;
    }

    public void onClick(View view) {
        this.f2362.dismiss();
        if (SyncPayStatus.m1962()) {
            RewardActivity.m804(this.f2363);
            return;
        }
        Context context = this.f2363;
        SystemUtils.m3510(context, new Intent(context, WPengVersionActivity.class));
    }
}
