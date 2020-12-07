package com.wpengapp.support;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wpengapp.support.ߴ */
public class DefaultConfigurationFactory implements ThreadFactory {

    /* renamed from: ֏ */
    public static final AtomicInteger f2762 = new AtomicInteger(1);

    /* renamed from: ؠ */
    public final ThreadGroup f2763;

    /* renamed from: ހ */
    public final AtomicInteger f2764 = new AtomicInteger(1);

    /* renamed from: ށ */
    public final String f2765;

    /* renamed from: ނ */
    public final int f2766;

    public DefaultConfigurationFactory(int i, String str) {
        this.f2766 = i;
        this.f2763 = Thread.currentThread().getThreadGroup();
        StringBuilder r3 = outline.m2549(str);
        r3.append(f2762.getAndIncrement());
        r3.append("-thread-");
        this.f2765 = r3.toString();
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f2763;
        Thread thread = new Thread(threadGroup, runnable, this.f2765 + this.f2764.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.f2766);
        return thread;
    }
}
