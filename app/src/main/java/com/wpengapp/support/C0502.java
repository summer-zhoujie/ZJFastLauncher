package com.wpengapp.support;

import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ź */
/* compiled from: lambda */
public final /* synthetic */ class C0502 implements C1156 {

    /* renamed from: ֏ */
    private final /* synthetic */ Float f894;

    /* renamed from: ؠ */
    private final /* synthetic */ Integer f895;

    public /* synthetic */ C0502(Float f, Integer num) {
        this.f894 = f;
        this.f895 = num;
    }

    /* renamed from: ֏ */
    public final boolean mo8009(AccessibilityNodeInfo accessibilityNodeInfo) {
        return AccService.m639(this.f894, this.f895, accessibilityNodeInfo);
    }
}
