package com.wpengapp.support;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.ड */
public class LaunchMainTask extends AccTask {
    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r4) {
        try {
            Intent launchIntentForPackage = AppUtils.getApplication().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(335577088);
            intent.setComponent(launchIntentForPackage.getComponent());
            SystemUtils.m3510((Context) null, intent);
            r4.mo8185();
        } catch (Exception e) {
            e.getMessage();
            r4.error();
        }
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r3) {
        if (accessibilityNodeInfo == null) {
            accessibilityNodeInfo = C1279.m3436();
        }
        if (accessibilityNodeInfo != null && TextUtils.equals("com.tencent.mm", accessibilityNodeInfo.getPackageName()) && "com.tencent.mm.ui.LauncherUI".equals(ForegroundAppManager.f1240)) {
            r3.mo8185();
        }
    }
}
