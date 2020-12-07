package com.wpengapp.support;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.Թ */
/* compiled from: DialogUtils */
class C0775 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        WeakHashMap remove = C0936.f2543.remove(activity);
        if (remove != null) {
            for (DialogInterface dialogInterface : remove.keySet()) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
