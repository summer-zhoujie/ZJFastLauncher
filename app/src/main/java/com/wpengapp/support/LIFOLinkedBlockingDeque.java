package com.wpengapp.support;

import com.wpengapp.support.C0860;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.wpengapp.support.آ */
public class LIFOLinkedBlockingDeque<T> extends C0860<T> {
    public static final long serialVersionUID = -4114786347960826192L;

    public boolean offer(T t) {
        if (t != null) {
            C0863<E> r0 = new C0863<>(t);
            ReentrantLock reentrantLock = this.f2332;
            reentrantLock.lock();
            try {
                boolean z = true;
                if (this.f2330 >= this.f2331) {
                    z = false;
                } else {
                    C0863<E> r1 = this.f2328;
                    r0.f2342 = r1;
                    this.f2328 = r0;
                    if (this.f2329 == null) {
                        this.f2329 = r0;
                    } else {
                        r1.f2341 = r0;
                    }
                    this.f2330++;
                    this.f2333.signal();
                }
                return z;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public T remove() {
        T pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }
}
