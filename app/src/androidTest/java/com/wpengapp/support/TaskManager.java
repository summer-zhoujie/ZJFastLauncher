package com.wpengapp.support;

import android.os.Handler;
import android.os.Looper;
import android.support.p003v7.widget.ActivityChooserView;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ठ */
public class TaskManager {

    /* renamed from: ֏ */
    public static volatile Handler f2915;

    /* renamed from: ؠ */
    public static volatile ExecutorService f2916;

    /* renamed from: ހ */
    public static volatile ExecutorService f2917;

    /* renamed from: ֏ */
    public static void m2714() {
        if (f2916 == null) {
            synchronized (TaskManager.class) {
                if (f2916 == null) {
                    f2916 = new C1329(1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue());
                }
            }
        }
    }

    /* renamed from: ؠ */
    public static void m2717() {
        if (f2915 == null) {
            synchronized (TaskManager.class) {
                if (f2915 == null) {
                    f2915 = new Handler(Looper.getMainLooper());
                }
            }
        }
    }

    /* renamed from: ހ */
    public static void m2719() {
        if (f2917 == null) {
            synchronized (TaskManager.class) {
                if (f2917 == null) {
                    f2917 = Executors.newSingleThreadExecutor();
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static void m2715(Runnable runnable) {
        m2714();
        ExecutorService executorService = f2916;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }

    /* renamed from: ؠ */
    public static void m2718(Runnable runnable) {
        new Thread(new C1176(runnable)).start();
    }

    /* renamed from: ހ */
    public static void m2720(Runnable runnable) {
        m2719();
        ExecutorService executorService = f2917;
        if (executorService != null) {
            executorService.submit(new C1176(runnable));
        }
    }

    /* renamed from: ֏ */
    public static void m2716(Throwable th) {
        if (th != null) {
            th.getMessage();
            C0975.m2601(Thread.currentThread(), th, !BaseApplication.f562, (Map<String, String>) null);
        }
    }
}
