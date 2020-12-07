package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

/* renamed from: com.wpengapp.support.ܢ */
public class InputGZHTask extends AccTask {

    /* renamed from: ކ */
    public String f2494;

    public InputGZHTask(String str) {
        this.f2494 = str;
    }

    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r11) {
        AccessibilityNodeInfo r0 = C1279.m3436();
        if (r0 == null || !TextUtils.equals("com.tencent.mm", r0.getPackageName())) {
            r11.error();
            return;
        }
        AccessibilityNodeInfo r1 = C1279.m3389(r0, EditText.class.getName());
        if (r1 == null) {
            r11.error();
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            String str = this.f2494;
            try {
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
                z2 = r1.performAction(2097152, bundle);
            } catch (Exception e) {
                e.getMessage();
                z2 = false;
            }
            if (z2) {
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException unused) {
            }
        }
        if (!z2) {
            r11.error();
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        AccessibilityNodeInfo accessibilityNodeInfo2 = r0;
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException unused2) {
            }
            if (C1279.m3392(accessibilityNodeInfo2, "搜一搜") != null) {
                z = true;
                break;
            }
            accessibilityNodeInfo2 = C1279.m3436();
            if (accessibilityNodeInfo == null) {
                accessibilityNodeInfo = C1279.m3389(accessibilityNodeInfo2, ListView.class.getName());
            }
            if (accessibilityNodeInfo == null) {
                accessibilityNodeInfo = C1279.m3389(accessibilityNodeInfo2, RecyclerView.class.getName());
            }
            if (accessibilityNodeInfo == null) {
                accessibilityNodeInfo = C1279.m3389(accessibilityNodeInfo2, ScrollView.class.getName());
            }
            if (accessibilityNodeInfo != null) {
                try {
                    accessibilityNodeInfo.performAction(4096);
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            i2++;
        }
        if (!z) {
            AccServiceHelper.m2014((AccessibilityService) AccServiceHelper.m2019(), 1);
        }
        r11.mo8185();
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r4) {
        AccessibilityNodeInfo r2;
        if (accessibilityNodeInfo == null) {
            accessibilityNodeInfo = C1279.m3436();
        }
        if (accessibilityNodeInfo != null && TextUtils.equals("com.tencent.mm", accessibilityNodeInfo.getPackageName()) && (r2 = C1279.m3392(accessibilityNodeInfo, "搜一搜")) != null && C1279.m3416(r2)) {
            r4.mo8185();
        }
    }
}
