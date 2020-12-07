package com.wpengapp.support;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import java.util.WeakHashMap;

/* renamed from: com.wpengapp.support.ݪ */
/* compiled from: DialogUtils */
public final class C0936 {

    /* renamed from: ֏ */
    public static volatile WeakHashMap<Activity, WeakHashMap<DialogInterface, Object>> f2543;

    /* renamed from: ֏ */
    public static void m2465(Dialog dialog) {
        if (dialog != null) {
            AppUtils.m1155((Runnable) new C0489(dialog));
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ؠ */
    public static boolean m2466(Dialog dialog) {
        Activity activity;
        Context context = dialog.getContext();
        if (!(context instanceof Activity)) {
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
            }
        } else {
            activity = (Activity) context;
        }
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        try {
            if (activity.isDestroyed()) {
                return false;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        m2464(activity, dialog);
        if (dialog.isShowing()) {
            return true;
        }
        AppUtils.m1155((Runnable) new DialogUtils(dialog));
        return true;
    }

    /* renamed from: ހ */
    public static boolean m2467(Dialog dialog) {
        try {
            if (m2466(dialog)) {
                return true;
            }
            AppUtils.m1155((Runnable) new C1186(dialog));
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: ֏ */
    public static void m2464(Activity activity, DialogInterface dialogInterface) {
        m2463();
        WeakHashMap weakHashMap = f2543.get(activity);
        if (weakHashMap == null) {
            synchronized (C0936.class) {
                weakHashMap = f2543.get(activity);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    f2543.put(activity, weakHashMap);
                }
            }
        }
        weakHashMap.put(dialogInterface, activity.getClass());
    }

    /* renamed from: ֏ */
    public static void m2463() {
        if (f2543 == null) {
            synchronized (C0936.class) {
                if (f2543 == null) {
                    f2543 = new WeakHashMap<>();
                    AppUtils.getApplication().registerActivityLifecycleCallbacks(new C0775());
                }
            }
        }
    }
}
