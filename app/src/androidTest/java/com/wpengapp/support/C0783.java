package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.Շ */
/* compiled from: BaseApplication */
class C0783 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ֏ */
    public final /* synthetic */ BaseApplication f2031;

    public C0783(BaseApplication baseApplication) {
        this.f2031 = baseApplication;
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if (RemoteSP.m1201(this.f2031.getString(R$string.pw_gohom), 0) > 0) {
            this.f2031.mo7790((Context) activity.getApplication());
            activity.finish();
        }
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
