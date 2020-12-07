package com.wpengapp.support;

import android.graphics.Bitmap;
import com.wpengapp.support.accservice.BaseAccessibilityService;

/* renamed from: com.wpengapp.support.Օ */
/* compiled from: CustomManager */
class C0793 implements RetCallback<Bitmap> {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseAccessibilityService f2059;

    public C0793(BaseAccessibilityService baseAccessibilityService) {
        this.f2059 = baseAccessibilityService;
    }

    /* renamed from: ֏ */
    public void mo7931(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        StringBuilder r0 = outline.m2549("screencap success ");
        r0.append(bitmap.getWidth());
        r0.append(", ");
        r0.append(bitmap.getHeight());
        r0.toString();
        TaskManager.m2715((Runnable) new C1123(this.f2059, bitmap));
    }

    /* renamed from: ֏ */
    public void mo7932(String str) {
        outline.m2555("screencap error ", str);
        TaskManager.m2715((Runnable) new C1123(this.f2059, (Bitmap) null));
    }
}
