package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.wpengapp.support.ޅ */
/* compiled from: SafeIterableMap */
public class C0946<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: ֏ */
    public C0949<K, V> f2586;

    /* renamed from: ؠ */
    public C0949<K, V> f2587;

    /* renamed from: ހ */
    public WeakHashMap<C0952<K, V>, Boolean> f2588 = new WeakHashMap<>();

    /* renamed from: ށ */
    public int f2589 = 0;

    /* renamed from: com.wpengapp.support.ޅ$֏ */
    /* compiled from: SafeIterableMap */
    static class C0947<K, V> extends C0951<K, V> {
        public C0947(C0949<K, V> r1, C0949<K, V> r2) {
            super(r1, r2);
        }

        /* renamed from: ؠ */
        public C0949<K, V> mo8968(C0949<K, V> r1) {
            return r1.f2593;
        }

        /* renamed from: ހ */
        public C0949<K, V> mo8969(C0949<K, V> r1) {
            return r1.f2592;
        }
    }

    /* renamed from: com.wpengapp.support.ޅ$ؠ */
    /* compiled from: SafeIterableMap */
    private static class C0948<K, V> extends C0951<K, V> {
        public C0948(C0949<K, V> r1, C0949<K, V> r2) {
            super(r1, r2);
        }

        /* renamed from: ؠ */
        public C0949<K, V> mo8968(C0949<K, V> r1) {
            return r1.f2592;
        }

        /* renamed from: ހ */
        public C0949<K, V> mo8969(C0949<K, V> r1) {
            return r1.f2593;
        }
    }

    /* renamed from: com.wpengapp.support.ޅ$ހ */
    /* compiled from: SafeIterableMap */
    static class C0949<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: ֏ */
        public final K f2590;
        @NonNull

        /* renamed from: ؠ */
        public final V f2591;

        /* renamed from: ހ */
        public C0949<K, V> f2592;

        /* renamed from: ށ */
        public C0949<K, V> f2593;

        public C0949(@NonNull K k, @NonNull V v) {
            this.f2590 = k;
            this.f2591 = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0949)) {
                return false;
            }
            C0949 r5 = (C0949) obj;
            if (!this.f2590.equals(r5.f2590) || !this.f2591.equals(r5.f2591)) {
                return false;
            }
            return true;
        }

        @NonNull
        public K getKey() {
            return this.f2590;
        }

        @NonNull
        public V getValue() {
            return this.f2591;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2590 + "=" + this.f2591;
        }
    }

    /* renamed from: com.wpengapp.support.ޅ$ށ */
    /* compiled from: SafeIterableMap */
    private class C0950 implements Iterator<Map.Entry<K, V>>, C0952<K, V> {

        /* renamed from: ֏ */
        public C0949<K, V> f2594;

        /* renamed from: ؠ */
        public boolean f2595 = true;

        public /* synthetic */ C0950(SafeIterableMap r2) {
        }

        public boolean hasNext() {
            if (!this.f2595) {
                C0949<K, V> r0 = this.f2594;
                if (r0 == null || r0.f2592 == null) {
                    return false;
                }
                return true;
            } else if (C0946.this.f2586 != null) {
                return true;
            } else {
                return false;
            }
        }

        public Object next() {
            if (this.f2595) {
                this.f2595 = false;
                this.f2594 = C0946.this.f2586;
            } else {
                C0949<K, V> r0 = this.f2594;
                this.f2594 = r0 != null ? r0.f2592 : null;
            }
            return this.f2594;
        }

        /* renamed from: ֏ */
        public void mo8977(@NonNull C0949<K, V> r2) {
            C0949<K, V> r0 = this.f2594;
            if (r2 == r0) {
                this.f2594 = r0.f2593;
                this.f2595 = this.f2594 == null;
            }
        }
    }

    /* renamed from: com.wpengapp.support.ޅ$ރ */
    /* compiled from: SafeIterableMap */
    interface C0952<K, V> {
        /* renamed from: ֏ */
        void mo8977(@NonNull C0949<K, V> r1);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0948 r0 = new C0948(this.f2587, this.f2586);
        this.f2588.put(r0, false);
        return r0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0946)) {
            return false;
        }
        C0946 r6 = (C0946) obj;
        if (this.f2589 != r6.f2589) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = r6.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        C0947 r0 = new C0947(this.f2586, this.f2587);
        this.f2588.put(r0, false);
        return r0;
    }

    public V remove(@NonNull K k) {
        C0949 r4 = mo8960(k);
        if (r4 == null) {
            return null;
        }
        this.f2589--;
        if (!this.f2588.isEmpty()) {
            for (C0952<K, V> r2 : this.f2588.keySet()) {
                r2.mo8977(r4);
            }
        }
        C0949<K, V> r1 = r4.f2593;
        if (r1 != null) {
            r1.f2592 = r4.f2592;
        } else {
            this.f2586 = r4.f2592;
        }
        C0949<K, V> r12 = r4.f2592;
        if (r12 != null) {
            r12.f2593 = r4.f2593;
        } else {
            this.f2587 = r4.f2593;
        }
        r4.f2592 = null;
        r4.f2593 = null;
        return r4.f2591;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            r0.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                r0.append(", ");
            }
        }
        r0.append("]");
        return r0.toString();
    }

    /* renamed from: ؠ */
    public V mo8961(@NonNull K k, @NonNull V v) {
        C0949 r0 = mo8960(k);
        if (r0 != null) {
            return r0.f2591;
        }
        mo8966(k, v);
        return null;
    }

    /* renamed from: ֏ */
    public C0949<K, V> mo8960(K k) {
        C0949<K, V> r0 = this.f2586;
        while (r0 != null && !r0.f2590.equals(k)) {
            r0 = r0.f2592;
        }
        return r0;
    }

    /* renamed from: ֏ */
    public C0949<K, V> mo8966(@NonNull K k, @NonNull V v) {
        C0949<K, V> r0 = new C0949<>(k, v);
        this.f2589++;
        C0949<K, V> r2 = this.f2587;
        if (r2 == null) {
            this.f2586 = r0;
            this.f2587 = this.f2586;
            return r0;
        }
        r2.f2592 = r0;
        r0.f2593 = r2;
        this.f2587 = r0;
        return r0;
    }

    /* renamed from: com.wpengapp.support.ޅ$ނ */
    /* compiled from: SafeIterableMap */
    private static abstract class C0951<K, V> implements Iterator<Map.Entry<K, V>>, C0952<K, V> {

        /* renamed from: ֏ */
        public C0949<K, V> f2597;

        /* renamed from: ؠ */
        public C0949<K, V> f2598;

        public C0951(C0949<K, V> r1, C0949<K, V> r2) {
            this.f2597 = r2;
            this.f2598 = r1;
        }

        public boolean hasNext() {
            return this.f2598 != null;
        }

        public Object next() {
            C0949<K, V> r0 = this.f2598;
            this.f2598 = mo8980();
            return r0;
        }

        /* renamed from: ֏ */
        public void mo8977(@NonNull C0949<K, V> r3) {
            C0949<K, V> r1 = null;
            if (this.f2597 == r3 && r3 == this.f2598) {
                this.f2598 = null;
                this.f2597 = null;
            }
            C0949<K, V> r0 = this.f2597;
            if (r0 == r3) {
                this.f2597 = mo8968(r0);
            }
            C0949<K, V> r02 = this.f2598;
            if (r02 == r3) {
                C0949<K, V> r32 = this.f2597;
                if (!(r02 == r32 || r32 == null)) {
                    r1 = mo8969(r02);
                }
                this.f2598 = r1;
            }
        }

        /* renamed from: ؠ */
        public abstract C0949<K, V> mo8968(C0949<K, V> r1);

        /* renamed from: ހ */
        public abstract C0949<K, V> mo8969(C0949<K, V> r1);

        /* renamed from: ֏ */
        public final C0949<K, V> mo8980() {
            C0949<K, V> r0 = this.f2598;
            C0949<K, V> r1 = this.f2597;
            if (r0 == r1 || r1 == null) {
                return null;
            }
            return mo8969(r0);
        }
    }

    /* renamed from: ֏ */
    public C0946<K, V>.ށ mo8967() {
        C0946<K, V>.ށ r0 = new C0950((SafeIterableMap) null);
        this.f2588.put(r0, false);
        return r0;
    }
}
