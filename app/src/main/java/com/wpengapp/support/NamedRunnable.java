package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ȧ */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: ֏ */
    public final String f1090;

    public NamedRunnable(String str, Object... objArr) {
        this.f1090 = Util.m937(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f1090);
        try {
            mo8071();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    /* renamed from: ֏ */
    public abstract void mo8071();
}
