package com.wpengapp.support;

import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.Կ */
/* compiled from: lambda */
public final /* synthetic */ class C0780 implements Runnable {

    /* renamed from: ֏ */
    private final /* synthetic */ AccService f2004;

    /* renamed from: ؠ */
    private final /* synthetic */ AccessibilityNodeInfo f2005;

    /* renamed from: ހ */
    private final /* synthetic */ String f2006;

    /* renamed from: ށ */
    private final /* synthetic */ String f2007;

    /* renamed from: ނ */
    private final /* synthetic */ String f2008;

    /* renamed from: ރ */
    private final /* synthetic */ boolean f2009;

    public /* synthetic */ C0780(AccService accService, AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2, String str3, boolean z) {
        this.f2004 = accService;
        this.f2005 = accessibilityNodeInfo;
        this.f2006 = str;
        this.f2007 = str2;
        this.f2008 = str3;
        this.f2009 = z;
    }

    public final void run() {
        this.f2004.mo7725(this.f2005, this.f2006, this.f2007, this.f2008, this.f2009);
    }
}
