package com.wpengapp.support.accservice;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import com.wpengapp.support.AccTask;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0786;
import com.wpengapp.support.C0840;
import com.wpengapp.support.C1146;
import com.wpengapp.support.C1324;
import com.wpengapp.support.ForegroundAppManager;
import com.wpengapp.support.RemoteMethod;
import java.util.WeakHashMap;

public class BaseAccessibilityService extends AccessibilityService {

    /* renamed from: ֏ */
    public static BaseAccessibilityService f600;

    /* renamed from: ؠ */
    public static final WeakHashMap<C0448, Object> f601 = new WeakHashMap<>();

    /* renamed from: ހ */
    public static RemoteMethod f602 = new C0718("acctest");

    /* renamed from: ށ */
    public static RemoteMethod f603 = new BaseAccessibilityService("open_recent");

    /* renamed from: com.wpengapp.support.accservice.BaseAccessibilityService$֏ */
    public interface C0448 {
        void onAccessibilityEvent(AccessibilityEvent accessibilityEvent);
    }

    static {
        if (C1146.m3072()) {
            f603.mo8565();
        }
        if (BaseApplication.f562) {
            if (C1146.m3072()) {
                f602.mo8565();
            }
        }
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ForegroundAppManager.m1394(accessibilityEvent);
        AccTask r0 = C0840.f2224;
        if (r0 != null) {
            C0840.f2225.post(new C1324(r0, AccessibilityEvent.obtain(accessibilityEvent)));
        }
        for (C0448 onAccessibilityEvent : f601.keySet()) {
            try {
                onAccessibilityEvent.onAccessibilityEvent(accessibilityEvent);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f600 = null;
    }

    public void onInterrupt() {
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        C0786.m2105((Context) this, new Intent("com.wpengapp.bas.open"), true);
        f600 = this;
    }
}
