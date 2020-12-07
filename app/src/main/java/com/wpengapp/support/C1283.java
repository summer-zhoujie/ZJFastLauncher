package com.wpengapp.support;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;

/* renamed from: com.wpengapp.support.ဇ */
/* compiled from: FullRuleChecker */
public class C1283 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C1079 f3610;

    public C1283(C1079 r1) {
        this.f3610 = r1;
    }

    public void run() {
        Context context = this.f3610.f3060;
        C1103 r1 = new C1103(this);
        C0649 r2 = new C0649(this);
        FloatWindow r3 = new FloatWindow(context, new WindowManager.LayoutParams(-1, -2, 2003, 8, -2), (int) R$layout.dialog_full_limit);
        View findViewById = r3.f2735.findViewById(2131165440);
        ((TextView) findViewById.findViewById(2131165528)).setText(AppUtils.m1141(2131493346, SystemUtils.m3519(AppUtils.m1163())));
        findViewById.findViewById(R$id.tv_unlock).setOnClickListener(new C0650(context, r3, findViewById));
        findViewById.findViewById(R$id.tv_cancel).setOnClickListener(new C0530(r3, findViewById));
        findViewById.addOnAttachStateChangeListener(new C0967(r1, r2));
        findViewById.setTranslationY((float) (-C0826.m2169().f2153));
        r3.mo9028(0, 0);
        findViewById.post(new C0704(findViewById));
    }
}
