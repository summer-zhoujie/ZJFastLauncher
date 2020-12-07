package com.wpengapp.support;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ဒ */
/* compiled from: lambda */
public final /* synthetic */ class C1285 implements View.OnClickListener {

    /* renamed from: ֏ */
    private final /* synthetic */ AccService f3614;

    /* renamed from: ؠ */
    private final /* synthetic */ AccessibilityNodeInfo f3615;

    /* renamed from: ހ */
    private final /* synthetic */ String f3616;

    /* renamed from: ށ */
    private final /* synthetic */ String f3617;

    /* renamed from: ނ */
    private final /* synthetic */ String f3618;

    /* renamed from: ރ */
    private final /* synthetic */ boolean f3619;

    public /* synthetic */ C1285(AccService accService, AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z) {
        this.f3614 = accService;
        this.f3615 = accessibilityNodeInfo;
        this.f3616 = str;
        this.f3617 = str2;
        this.f3618 = str3;
        this.f3619 = z;
    }

    public final void onClick(View view) {
        this.f3614.mo7726(this.f3615, this.f3616, this.f3617, this.f3618, this.f3619, view);
    }
}
