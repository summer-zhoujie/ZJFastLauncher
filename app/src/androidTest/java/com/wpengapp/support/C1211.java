package com.wpengapp.support;

import android.view.View;
import android.widget.EditText;
import com.wpengapp.support.activity.WPengVersionActivity;

/* renamed from: com.wpengapp.support.ຄ */
/* compiled from: WPengVersionActivity */
public class C1211 implements OnDialogClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ EditText f3468;

    /* renamed from: ؠ */
    public final /* synthetic */ WPengVersionActivity f3469;

    public C1211(WPengVersionActivity wPengVersionActivity, EditText editText) {
        this.f3469 = wPengVersionActivity;
        this.f3468 = editText;
    }

    public boolean onClick(View view) {
        this.f3469.f657.mo9300(this.f3468.getText().toString(), new C0737(this));
        return false;
    }
}
