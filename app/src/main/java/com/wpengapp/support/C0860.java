package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.wpengapp.support.ٱ */
/* compiled from: LinkedBlockingDeque */
public class C0860<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    public static final long serialVersionUID = -387911632671998426L;

    /* renamed from: ֏ */
    public transient C0863<E> f2328;

    /* renamed from: ؠ */
    public transient C0863<E> f2329;

    /* renamed from: ހ */
    public transient int f2330;

    /* renamed from: ށ */
    public final int f2331 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: ނ */
    public final ReentrantLock f2332 = new ReentrantLock();

    /* renamed from: ރ */
    public final Condition f2333 = this.f2332.newCondition();

    /* renamed from: ބ */
    public final Condition f2334 = this.f2332.newCondition();

    /* renamed from: com.wpengapp.support.ٱ$֏ */
    /* compiled from: LinkedBlockingDeque */
    private abstract class C0861 implements Iterator<E> {

        /* renamed from: ֏ */
        public C0863<E> f2335;

        /* renamed from: ؠ */
        public E f2336;

        /* renamed from: ހ */
        public C0863<E> f2337;

        public C0861() {
            ReentrantLock reentrantLock = C0860.this.f2332;
            reentrantLock.lock();
            try {
                this.f2335 = C0860.this.f2328;
                this.f2336 = this.f2335 == null ? null : this.f2335.f2340;
            } finally {
                reentrantLock.unlock();
            }
        }

        public boolean hasNext() {
            return this.f2335 != null;
        }

        public E next() {
            C0863<E> r3;
            E e;
            C0863<E> r0 = this.f2335;
            if (r0 != null) {
                this.f2337 = r0;
                E e2 = this.f2336;
                ReentrantLock reentrantLock = C0860.this.f2332;
                reentrantLock.lock();
                try {
                    C0863<E> r2 = this.f2335;
                    while (true) {
                        C0862 r32 = (C0862) this;
                        r3 = r2.f2342;
                        e = null;
                        if (r3 == null) {
                            r3 = null;
                            break;
                        } else if (r3.f2340 != null) {
                            break;
                        } else if (r3 == r2) {
                            r3 = mo8813();
                            break;
                        } else {
                            r2 = r3;
                        }
                    }
                    this.f2335 = r3;
                    if (this.f2335 != null) {
                        e = this.f2335.f2340;
                    }
                    this.f2336 = e;
                    return e2;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            C0863<E> r0 = this.f2337;
            if (r0 != null) {
                this.f2337 = null;
                ReentrantLock reentrantLock = C0860.this.f2332;
                reentrantLock.lock();
                try {
                    if (r0.f2340 != null) {
                        C0860.this.mo8809(r0);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }

        /* renamed from: ֏ */
        public abstract C0863<E> mo8813();
    }

    /* renamed from: com.wpengapp.support.ٱ$ؠ */
    /* compiled from: LinkedBlockingDeque */
    private class C0862 extends C0860<E>.֏ {
        public /* synthetic */ C0862(LinkedBlockingDeque r2) {
            super();
        }

        /* renamed from: ֏ */
        public C0863<E> mo8813() {
            return C0860.this.f2328;
        }
    }

    /* renamed from: com.wpengapp.support.ٱ$ހ */
    /* compiled from: LinkedBlockingDeque */
    static final class C0863<E> {

        /* renamed from: ֏ */
        public E f2340;

        /* renamed from: ؠ */
        public C0863<E> f2341;

        /* renamed from: ހ */
        public C0863<E> f2342;

        public C0863(E e) {
            this.f2340 = e;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f2330 = 0;
        this.f2328 = null;
        this.f2329 = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C0863<E> r1 = this.f2328; r1 != null; r1 = r1.f2342) {
                objectOutputStream.writeObject(r1.f2340);
            }
            objectOutputStream.writeObject((Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            C0863<E> r1 = this.f2328;
            while (r1 != null) {
                r1.f2340 = null;
                C0863<E> r3 = r1.f2342;
                r1.f2341 = null;
                r1.f2342 = null;
                r1 = r3;
            }
            this.f2329 = null;
            this.f2328 = null;
            this.f2330 = 0;
            this.f2334.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            for (C0863<E> r2 = this.f2328; r2 != null; r2 = r2.f2342) {
                if (obj.equals(r2.f2340)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new C0862((LinkedBlockingDeque) null);
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offerLast(E e) {
        if (e != null) {
            C0863 r0 = new C0863(e);
            ReentrantLock reentrantLock = this.f2332;
            reentrantLock.lock();
            try {
                return mo8808(r0);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            return this.f2328 == null ? null : this.f2328.f2340;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            return mo8807();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(E e) {
        putLast(e);
    }

    public void putLast(E e) {
        if (e != null) {
            C0863 r0 = new C0863(e);
            ReentrantLock reentrantLock = this.f2332;
            reentrantLock.lock();
            while (!mo8808(r0)) {
                try {
                    this.f2334.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            return this.f2331 - this.f2330;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            for (C0863<E> r2 = this.f2328; r2 != null; r2 = r2.f2342) {
                if (obj.equals(r2.f2340)) {
                    mo8809(r2);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            return this.f2330;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        return takeFirst();
    }

    public E takeFirst() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        while (true) {
            try {
                E r1 = mo8807();
                if (r1 != null) {
                    return r1;
                }
                this.f2333.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f2330];
            int i = 0;
            C0863<E> r3 = this.f2328;
            while (r3 != null) {
                int i2 = i + 1;
                objArr[i] = r3.f2340;
                r3 = r3.f2342;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            C0863<E> r1 = this.f2328;
            if (r1 == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e = r1.f2340;
                if (e == this) {
                    e = "(this Collection)";
                }
                sb.append(e);
                r1 = r1.f2342;
                if (r1 == null) {
                    sb.append(']');
                    String sb2 = sb.toString();
                    reentrantLock.unlock();
                    return sb2;
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: ֏ */
    public final boolean mo8808(C0863<E> r3) {
        if (this.f2330 >= this.f2331) {
            return false;
        }
        C0863<E> r0 = this.f2329;
        r3.f2341 = r0;
        this.f2329 = r3;
        if (this.f2328 == null) {
            this.f2328 = r3;
        } else {
            r0.f2342 = r3;
        }
        this.f2330++;
        this.f2333.signal();
        return true;
    }

    /* renamed from: ؠ */
    public void mo8809(C0863<E> r4) {
        C0863<E> r0 = r4.f2341;
        C0863<E> r1 = r4.f2342;
        if (r0 == null) {
            mo8807();
        } else if (r1 == null) {
            C0863<E> r42 = this.f2329;
            if (r42 != null) {
                C0863<E> r02 = r42.f2341;
                E e = r42.f2340;
                r42.f2340 = null;
                r42.f2341 = r42;
                this.f2329 = r02;
                if (r02 == null) {
                    this.f2328 = null;
                } else {
                    r02.f2342 = null;
                }
                this.f2330--;
                this.f2334.signal();
            }
        } else {
            r0.f2342 = r1;
            r1.f2341 = r0;
            r4.f2340 = null;
            this.f2330--;
            this.f2334.signal();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection != this) {
            ReentrantLock reentrantLock = this.f2332;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.f2330);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.f2328.f2340);
                    mo8807();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E pollFirst(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E r0 = mo8807();
                if (r0 != null) {
                    reentrantLock.unlock();
                    return r0;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.f2333.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        boolean z;
        if (e != null) {
            C0863 r0 = new C0863(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.f2332;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (mo8808(r0)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.f2334.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f2332;
        reentrantLock.lock();
        try {
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < this.f2330) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2330);
            }
            int i = 0;
            C0863<E> r2 = this.f2328;
            while (r2 != null) {
                tArr2[i] = r2.f2340;
                r2 = r2.f2342;
                i++;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            return tArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: ֏ */
    public final E mo8807() {
        C0863<E> r0 = this.f2328;
        if (r0 == null) {
            return null;
        }
        C0863<E> r2 = r0.f2342;
        E e = r0.f2340;
        r0.f2340 = null;
        r0.f2342 = r0;
        this.f2328 = r2;
        if (r2 == null) {
            this.f2329 = null;
        } else {
            r2.f2341 = null;
        }
        this.f2330--;
        this.f2334.signal();
        return e;
    }
}
