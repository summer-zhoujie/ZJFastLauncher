package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.စ */
public class ClickMainSearchTask extends AccTask {
    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r4) {
        AccessibilityNodeInfo r0 = C1279.m3436();
        if (r0 == null || !TextUtils.equals("com.tencent.mm", r0.getPackageName())) {
            r4.error();
            return;
        }
        AccessibilityNodeInfo r02 = C1279.m3392(r0, "搜索");
        if (r02 == null) {
            r4.error();
        } else if (C1279.m3429(r02)) {
            r4.mo8185();
        } else {
            r4.error();
        }
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r3) {
        if (accessibilityNodeInfo == null) {
            accessibilityNodeInfo = C1279.m3436();
        }
        if (accessibilityNodeInfo != null && TextUtils.equals("com.tencent.mm", accessibilityNodeInfo.getPackageName()) && "com.tencent.mm.plugin.fts.ui.FTSMainUI".equals(ForegroundAppManager.f1240)) {
            r3.mo8185();
        }
    }
}
