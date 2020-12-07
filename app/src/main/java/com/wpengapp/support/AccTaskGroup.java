package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ɢ */
public class AccTaskGroup extends AccTask {

    /* renamed from: ކ */
    public List<AccTask> f1243 = new ArrayList();

    /* renamed from: ֏ */
    public AccTaskGroup mo8201(AccTask r2) {
        if (r2 instanceof AccTaskGroup) {
            throw new IllegalArgumentException("do not support add AccTaskGroup");
        } else if (!this.f2432) {
            r2.f2434 = this;
            this.f1243.add(r2);
            return this;
        } else {
            throw new IllegalStateException("AccTaskGroup has submitted");
        }
    }

    /* renamed from: ֏ */
    public void mo8202(@Nullable AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo, @NonNull TaskCallback r3) {
    }

    /* renamed from: ֏ */
    public void mo8203(@NonNull TaskCallback r1) {
    }
}
