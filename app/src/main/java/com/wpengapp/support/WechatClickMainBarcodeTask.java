package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.ۆ */
public class WechatClickMainBarcodeTask extends AccTask {
    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r4) {
        AccessibilityNodeInfo r0 = C1279.m3436();
        if (r0 == null || !TextUtils.equals("com.tencent.mm", r0.getPackageName())) {
            r4.error();
            return;
        }
        AccessibilityNodeInfo r02 = C1279.m3392(r0, "收付款", "Money");
        if (r02 == null) {
            r4.error();
        } else if (C1279.m3429(r02)) {
            r4.mo8185();
        } else {
            r4.error();
        }
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r4) {
        AccessibilityNodeInfo r2;
        if (accessibilityNodeInfo == null) {
            accessibilityNodeInfo = C1279.m3436();
        }
        if (accessibilityNodeInfo != null && TextUtils.equals("com.tencent.mm", accessibilityNodeInfo.getPackageName())) {
            String str = ForegroundAppManager.f1240;
            if ((str != null && str.endsWith("WalletOfflineCoinPurseUI")) || ((r2 = C1279.m3392(accessibilityNodeInfo, "向商家付款")) != null && C1279.m3416(r2))) {
                r4.mo8185();
            }
        }
    }
}