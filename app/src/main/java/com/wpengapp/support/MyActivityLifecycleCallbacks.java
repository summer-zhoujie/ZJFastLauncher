package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/* renamed from: com.wpengapp.support.य़ */
/* compiled from: AppUtils */
public final class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AppUtils.f902.put(activity, activity);
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8043(bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (AppUtils.C0503 r1 : AppUtils.m1143(activity)) {
            r1.mo8042();
        }
        AppUtils.removeActivity(activity);
        AppUtils.f902.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8044();
        }
    }

    public void onActivityResumed(Activity activity) {
        AppUtils.f900 = new WeakReference<>(activity);
        AppUtils.f901 = activity.getClass().getName();
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8046();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8045(bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8047();
        }
    }

    public void onActivityStopped(Activity activity) {
        for (AppUtils.C0503 r0 : AppUtils.m1143(activity)) {
            r0.mo8048();
        }
    }
}
