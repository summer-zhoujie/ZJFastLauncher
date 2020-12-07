package com.wpengapp.support;

import android.os.Handler;

/* renamed from: com.wpengapp.support.য */
/* compiled from: Task */
public abstract class C1066<Result> implements Runnable {
    public final void run() {
        try {
            mo9244();
        } finally {
            Task r2 = new Task(this, (Object) null);
            TaskManager.m2717();
            Handler handler = TaskManager.f2915;
            if (handler != null) {
                handler.post(r2);
            }
        }
    }

    /* renamed from: ֏ */
    public abstract Result mo9244();

    /* renamed from: ֏ */
    public void mo9245(Result result) {
    }
}
