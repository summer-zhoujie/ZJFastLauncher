package com.wpengapp.support;

import android.view.View;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.п */
/* compiled from: lambda */
public final /* synthetic */ class C0706 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ AccService f1819;

    /* renamed from: ؠ */
    private final /* synthetic */ String f1820;

    /* renamed from: ހ */
    private final /* synthetic */ String f1821;

    /* renamed from: ށ */
    private final /* synthetic */ boolean f1822;

    public /* synthetic */ C0706(AccService accService, String str, String str2, boolean z) {
        this.f1819 = accService;
        this.f1820 = str;
        this.f1821 = str2;
        this.f1822 = z;
    }

    public final void onClick(View view) {
        this.f1819.mo7738(this.f1820, this.f1821, this.f1822, view);
    }
}
