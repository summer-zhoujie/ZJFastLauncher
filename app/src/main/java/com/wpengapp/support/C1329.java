package com.wpengapp.support;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ჩ */
/* compiled from: TaskManager */
class C1329 extends ThreadPoolExecutor {
    public C1329(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    public void afterExecute(Runnable runnable, Throwable th) {
        if (th != null) {
            TaskManager.m2716(th);
        } else if (runnable instanceof FutureTask) {
            try {
                ((FutureTask) runnable).get();
            } catch (ExecutionException e) {
                TaskManager.m2716((Throwable) e);
            } catch (Exception unused) {
            }
        }
        super.afterExecute(runnable, th);
    }
}
