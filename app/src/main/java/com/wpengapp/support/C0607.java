package com.wpengapp.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.wpengapp.support.ʶ */
/* compiled from: ImageLoaderEngine */
public class C0607 {

    /* renamed from: ֏ */
    public final C0608 f1392;

    /* renamed from: ؠ */
    public Executor f1393;

    /* renamed from: ހ */
    public Executor f1394;

    /* renamed from: ށ */
    public Executor f1395;

    /* renamed from: ނ */
    public final Map<Integer, String> f1396 = Collections.synchronizedMap(new HashMap());

    /* renamed from: ރ */
    public final Map<String, ReentrantLock> f1397 = new WeakHashMap();

    /* renamed from: ބ */
    public final AtomicBoolean f1398 = new AtomicBoolean(false);

    /* renamed from: ޅ */
    public final AtomicBoolean f1399 = new AtomicBoolean(false);

    /* renamed from: ކ */
    public final AtomicBoolean f1400 = new AtomicBoolean(false);

    /* renamed from: އ */
    public final Object f1401 = new Object();

    public C0607(C0608 r3) {
        this.f1392 = r3;
        this.f1393 = r3.f1416;
        this.f1394 = r3.f1417;
        this.f1395 = Executors.newCachedThreadPool(C1279.m3405(5, "uil-pool-d-"));
    }

    /* renamed from: ֏ */
    public final void mo8301() {
        if (!this.f1392.f1418 && ((ExecutorService) this.f1393).isShutdown()) {
            C0608 r0 = this.f1392;
            this.f1393 = C1279.m3404(r0.f1420, r0.f1421, r0.f1422);
        }
        if (!this.f1392.f1419 && ((ExecutorService) this.f1394).isShutdown()) {
            C0608 r02 = this.f1392;
            this.f1394 = C1279.m3404(r02.f1420, r02.f1421, r02.f1422);
        }
    }
}
