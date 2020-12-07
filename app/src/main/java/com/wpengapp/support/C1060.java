package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ধ */
/* compiled from: UMengManager */
class C1060 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        UMengManager.m1404((Object) activity);
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
    }

    public void onActivityResumed(@NonNull Activity activity) {
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
    }

    public void onActivityStopped(@NonNull Activity activity) {
    }
}
