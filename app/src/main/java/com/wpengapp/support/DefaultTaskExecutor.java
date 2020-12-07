package com.wpengapp.support;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.wpengapp.support.ށ */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: ֏ */
    public final Object f2582 = new Object();

    /* renamed from: ؠ */
    public ExecutorService f2583 = Executors.newFixedThreadPool(2);
    @Nullable

    /* renamed from: ހ */
    public volatile Handler f2584;

    /* renamed from: ֏ */
    public void mo8955(Runnable runnable) {
        this.f2583.execute(runnable);
    }

    /* renamed from: ؠ */
    public void mo8957(Runnable runnable) {
        if (this.f2584 == null) {
            synchronized (this.f2582) {
                if (this.f2584 == null) {
                    this.f2584 = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f2584.post(runnable);
    }

    /* renamed from: ֏ */
    public boolean mo8956() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
