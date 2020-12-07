package com.umeng.analytics;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.f */
public class QueuedWork {

    /* renamed from: a */
    public static List<WeakReference<ScheduledFuture<?>>> f146a = new ArrayList();

    /* renamed from: b */
    public static ExecutorService f147b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public static long f148c = 5;

    /* renamed from: d */
    public static ScheduledExecutorService f149d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: a */
    public static void m118a(Runnable runnable) {
        if (f147b.isShutdown()) {
            f147b = Executors.newSingleThreadExecutor();
        }
        f147b.execute(runnable);
    }

    /* renamed from: b */
    public static synchronized void m120b(Runnable runnable) {
        synchronized (QueuedWork.class) {
            if (f149d.isShutdown()) {
                f149d = Executors.newSingleThreadScheduledExecutor();
            }
            f149d.execute(runnable);
        }
    }

    /* renamed from: c */
    public static synchronized void m121c(Runnable runnable) {
        synchronized (QueuedWork.class) {
            if (f149d.isShutdown()) {
                f149d = Executors.newSingleThreadScheduledExecutor();
            }
            try {
                f149d.submit(runnable).get(5, TimeUnit.SECONDS);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m117a() {
        try {
            for (WeakReference<ScheduledFuture<?>> weakReference : f146a) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) weakReference.get();
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            f146a.clear();
            if (!f147b.isShutdown()) {
                f147b.shutdown();
            }
            if (!f149d.isShutdown()) {
                f149d.shutdown();
            }
            f147b.awaitTermination(f148c, TimeUnit.SECONDS);
            f149d.awaitTermination(f148c, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static synchronized void m119a(Runnable runnable, long j) {
        synchronized (QueuedWork.class) {
            if (f149d.isShutdown()) {
                f149d = Executors.newSingleThreadScheduledExecutor();
            }
            f146a.add(new WeakReference(f149d.schedule(runnable, j, TimeUnit.MILLISECONDS)));
        }
    }
}
