package com.wpengapp.support;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.wpengapp.support.ი */
/* compiled from: AccTaskManager */
public final class C1324 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ AccTask f3793;

    /* renamed from: ؠ */
    public final /* synthetic */ AccessibilityEvent f3794;

    public C1324(AccTask r1, AccessibilityEvent accessibilityEvent) {
        this.f3793 = r1;
        this.f3794 = accessibilityEvent;
    }

    public void run() {
        AccessibilityNodeInfo accessibilityNodeInfo;
        try {
            AccTask r0 = this.f3793;
            AccessibilityEvent accessibilityEvent = this.f3794;
            if (!r0.mo8878() && accessibilityEvent != null) {
                accessibilityNodeInfo = accessibilityEvent.getSource();
                AccessibilityNodeInfo r2 = C1279.m3443(accessibilityNodeInfo);
                if (r2 != null) {
                    r0.mo8202(accessibilityEvent, r2, r0.f2431);
                }
            }
        } catch (Exception e) {
            e.getMessage();
            accessibilityNodeInfo = null;
        } catch (Throwable th) {
            this.f3794.recycle();
            throw th;
        }
        this.f3794.recycle();
    }
}
