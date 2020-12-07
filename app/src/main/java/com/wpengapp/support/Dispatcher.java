package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.C1140;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ϐ */
public final class Dispatcher {

    /* renamed from: ֏ */
    public int f1716 = 64;

    /* renamed from: ؠ */
    public int f1717 = 5;

    /* renamed from: ހ */
    public Runnable f1718;

    /* renamed from: ށ */
    public ExecutorService f1719;

    /* renamed from: ނ */
    public final Deque<C1140.C1141> f1720 = new ArrayDeque();

    /* renamed from: ރ */
    public final Deque<C1140.C1141> f1721 = new ArrayDeque();

    /* renamed from: ބ */
    public final Deque<C1140> f1722 = new ArrayDeque();

    /* renamed from: ֏ */
    public synchronized ExecutorService mo8422() {
        if (this.f1719 == null) {
            this.f1719 = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m943("OkHttp Dispatcher", false));
        }
        return this.f1719;
    }

    /* renamed from: ؠ */
    public final boolean mo8425() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<C1140.C1141> it = this.f1720.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                C1140.C1141 next = it.next();
                if (this.f1721.size() >= this.f1716) {
                    break;
                }
                for (C1140.C1141 next2 : this.f1721) {
                    if (!next2.f3240.f3238) {
                        if (next2.mo9326().equals(next.mo9326())) {
                            i++;
                        }
                    }
                }
                if (i < this.f1717) {
                    it.remove();
                    arrayList.add(next);
                    this.f1721.add(next);
                }
            }
            z = mo8426() > 0;
        }
        int size = arrayList.size();
        while (i < size) {
            ((C1140.C1141) arrayList.get(i)).mo9325(mo8422());
            i++;
        }
        return z;
    }

    /* renamed from: ހ */
    public synchronized int mo8426() {
        return this.f1721.size() + this.f1722.size();
    }

    /* renamed from: ֏ */
    public synchronized void mo8423(C1140 r2) {
        this.f1722.add(r2);
    }

    /* renamed from: ֏ */
    public final <T> void mo8424(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f1718;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!mo8425() && runnable != null) {
            runnable.run();
        }
    }
}
