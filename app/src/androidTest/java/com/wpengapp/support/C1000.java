package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.StreamAllocation;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wpengapp.support.ࡖ */
/* compiled from: ConnectionPool */
public final class C1000 {

    /* renamed from: ֏ */
    public static final Executor f2812 = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m943("OkHttp ConnectionPool", true));

    /* renamed from: ؠ */
    public final int f2813 = 5;

    /* renamed from: ހ */
    public final long f2814;

    /* renamed from: ށ */
    public final Runnable f2815 = new ConnectionPool(this);

    /* renamed from: ނ */
    public final Deque<RealConnection> f2816 = new ArrayDeque();

    /* renamed from: ރ */
    public final RouteDatabase f2817 = new RouteDatabase();

    /* renamed from: ބ */
    public boolean f2818;

    public C1000() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.f2814 = timeUnit.toNanos(5);
    }

    /* renamed from: ֏ */
    public boolean mo9064(RealConnection r2) {
        if (r2.f2045 || this.f2813 == 0) {
            this.f2816.remove(r2);
            return true;
        }
        notifyAll();
        return false;
    }

    /* renamed from: ֏ */
    public long mo9063(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            RealConnection r5 = null;
            int i = 0;
            int i2 = 0;
            for (RealConnection next : this.f2816) {
                if (mo9062(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.f2049;
                    if (j3 > j2) {
                        r5 = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f2814) {
                if (i <= this.f2813) {
                    if (i > 0) {
                        long j4 = this.f2814 - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f2814;
                        return j5;
                    } else {
                        this.f2818 = false;
                        return -1;
                    }
                }
            }
            this.f2816.remove(r5);
            Util.m947(r5.f2039);
            return 0;
        }
    }

    /* renamed from: ֏ */
    public final int mo9062(RealConnection r8, long j) {
        List<Reference<StreamAllocation>> list = r8.f2048;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.f1792.mo8438(outline.m2546(outline.m2549("A connection to "), (Object) r8.f2037.f952.f2018, " was leaked. Did you forget to close a response body?"), ((StreamAllocation.C0923) reference).f2509);
                list.remove(i);
                r8.f2045 = true;
                if (list.isEmpty()) {
                    r8.f2049 = j - this.f2814;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
