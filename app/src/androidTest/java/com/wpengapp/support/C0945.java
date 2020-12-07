package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.wpengapp.support.ހ */
/* compiled from: ArchTaskExecutor */
public class C0945 extends TaskExecutor {

    /* renamed from: ֏ */
    public static volatile C0945 f2579;
    @NonNull

    /* renamed from: ؠ */
    public TaskExecutor f2580 = this.f2581;
    @NonNull

    /* renamed from: ހ */
    public TaskExecutor f2581 = new DefaultTaskExecutor();

    static {
        new ArchTaskExecutor();
        new C0835();
    }

    @NonNull
    /* renamed from: ؠ */
    public static C0945 m2488() {
        if (f2579 != null) {
            return f2579;
        }
        synchronized (C0945.class) {
            if (f2579 == null) {
                f2579 = new C0945();
            }
        }
        return f2579;
    }

    /* renamed from: ֏ */
    public void mo8955(Runnable runnable) {
        this.f2580.mo8955(runnable);
    }

    /* renamed from: ֏ */
    public boolean mo8956() {
        return this.f2580.mo8956();
    }

    /* renamed from: ؠ */
    public void mo8957(Runnable runnable) {
        this.f2580.mo8957(runnable);
    }
}
