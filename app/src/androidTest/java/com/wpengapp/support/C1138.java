package com.wpengapp.support;

import android.view.View;
import android.widget.AdapterView;
import com.wpengapp.support.activity.AboutActivity;

/* renamed from: com.wpengapp.support.ନ */
/* compiled from: AboutActivity */
public class C1138 implements AdapterView.OnItemClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ AboutActivity f3232;

    public C1138(AboutActivity aboutActivity) {
        this.f3232 = aboutActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            C1110.m2992(this.f3232);
        } else {
            C1110.m2989(this.f3232);
        }
    }
}
