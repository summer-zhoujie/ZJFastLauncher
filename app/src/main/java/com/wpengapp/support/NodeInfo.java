package com.wpengapp.support;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.support.accservice.AccNodeSelector;

/* renamed from: com.wpengapp.support.ন */
public class NodeInfo {

    /* renamed from: ֏ */
    public AccessibilityNodeInfo f3028;

    /* renamed from: ؠ */
    public AccNodeSelector f3029;

    /* renamed from: ހ */
    public Rect f3030;

    /* renamed from: ށ */
    public float f3031;

    /* renamed from: ނ */
    public CharSequence f3032;

    /* renamed from: ރ */
    public String f3033;

    public NodeInfo(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, float f, AccNodeSelector accNodeSelector, CharSequence charSequence, String str) {
        this.f3028 = accessibilityNodeInfo;
        this.f3030 = rect;
        this.f3031 = f;
        this.f3029 = accNodeSelector;
        this.f3032 = charSequence;
        this.f3033 = str;
    }

    @NonNull
    public String toString() {
        return this.f3028.toString();
    }
}
