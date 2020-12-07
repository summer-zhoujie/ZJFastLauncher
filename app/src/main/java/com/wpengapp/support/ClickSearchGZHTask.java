package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.Ո */
public class ClickSearchGZHTask extends AccTask {
    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r6) {
        AccessibilityNodeInfo r0 = C1279.m3436();
        if (r0 == null || !TextUtils.equals("com.tencent.mm", r0.getPackageName())) {
            r6.error();
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        for (int i = 0; i < 3 && (accessibilityNodeInfo = C1279.m3392(r0, "搜一搜")) == null; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException unused) {
            }
        }
        if (accessibilityNodeInfo == null) {
            r6.error();
        } else if (C1279.m3429(accessibilityNodeInfo)) {
            r6.mo8185();
        } else {
            r6.error();
        }
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r3) {
        if (accessibilityNodeInfo == null) {
            accessibilityNodeInfo = C1279.m3436();
        }
        if (accessibilityNodeInfo != null && TextUtils.equals("com.tencent.mm", accessibilityNodeInfo.getPackageName())) {
            String str = ForegroundAppManager.f1240;
            if ("com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI".equals(str) || "com.tencent.mm.plugin.fts.ui.FTSMainUI".equals(str)) {
                r3.mo8185();
            }
        }
    }
}
