package com.wpengapp.support;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.wpengapp.support.C0946;
import com.wpengapp.support.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.wpengapp.support.ދ */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: ֏ */
    public FastSafeIterableMap<LifecycleObserver, C0957> f2612 = new FastSafeIterableMap<>();

    /* renamed from: ؠ */
    public C0956 f2613;

    /* renamed from: ހ */
    public final WeakReference<LifecycleOwner> f2614;

    /* renamed from: ށ */
    public int f2615 = 0;

    /* renamed from: ނ */
    public boolean f2616 = false;

    /* renamed from: ރ */
    public boolean f2617 = false;

    /* renamed from: ބ */
    public ArrayList<C0956> f2618 = new ArrayList<>();

    /* renamed from: com.wpengapp.support.ދ$֏ */
    /* compiled from: LifecycleRegistry */
    static class C0957 {

        /* renamed from: ֏ */
        public C0956 f2619;

        /* renamed from: ؠ */
        public GenericLifecycleObserver f2620;

        public C0957(LifecycleObserver r1, C0956 r2) {
            this.f2620 = Lifecycling.m2532((Object) r1);
            this.f2619 = r2;
        }

        /* renamed from: ֏ */
        public void mo8994(LifecycleOwner r3, C0955 r4) {
            C0956 r0 = LifecycleRegistry.m2522(r4);
            this.f2619 = LifecycleRegistry.m2523(this.f2619, r0);
            this.f2620.mo1(r3, r4);
            this.f2619 = r0;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner r2) {
        this.f2614 = new WeakReference<>(r2);
        this.f2613 = C0956.INITIALIZED;
    }

    /* renamed from: ֏ */
    public final void mo8991(C0956 r2) {
        if (this.f2613 != r2) {
            this.f2613 = r2;
            if (this.f2616 || this.f2615 != 0) {
                this.f2617 = true;
                return;
            }
            this.f2616 = true;
            mo8992();
            this.f2616 = false;
        }
    }

    /* renamed from: ؠ */
    public void mo8993(@NonNull C0955 r1) {
        mo8991(m2522(r1));
    }

    /* renamed from: ؠ */
    public static C0955 m2524(C0956 r2) {
        int ordinal = r2.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return C0955.ON_CREATE;
        }
        if (ordinal == 2) {
            return C0955.ON_START;
        }
        if (ordinal == 3) {
            return C0955.ON_RESUME;
        }
        if (ordinal != 4) {
            throw new IllegalArgumentException(outline.m2554("Unexpected state value ", (Object) r2));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ֏ */
    public final C0956 mo8989(LifecycleObserver r4) {
        FastSafeIterableMap<LifecycleObserver, C0957> r0 = this.f2612;
        C0956 r2 = null;
        C0946.C0949<K, V> r42 = r0.f2585.containsKey(r4) ? r0.f2585.get(r4).f2593 : null;
        C0956 r43 = r42 != null ? ((C0957) r42.getValue()).f2619 : null;
        if (!this.f2618.isEmpty()) {
            ArrayList<C0956> arrayList = this.f2618;
            r2 = arrayList.get(arrayList.size() - 1);
        }
        return m2523(m2523(this.f2613, r43), r2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r1 = ((com.wpengapp.support.LifecycleRegistry.C0957) r1.f2586.getValue()).f2619;
        r2 = ((com.wpengapp.support.LifecycleRegistry.C0957) r8.f2612.f2587.getValue()).f2619;
     */
    /* renamed from: ؠ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8992() {
        /*
            r8 = this;
            java.lang.ref.WeakReference<com.wpengapp.support.ފ> r0 = r8.f2614
            java.lang.Object r0 = r0.get()
            com.wpengapp.support.ފ r0 = (com.wpengapp.support.LifecycleOwner) r0
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r1 = r8.f2612
            int r2 = r1.f2589
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0014
            goto L_0x0030
        L_0x0014:
            com.wpengapp.support.ޅ$ހ<K, V> r1 = r1.f2586
            java.lang.Object r1 = r1.getValue()
            com.wpengapp.support.ދ$֏ r1 = (com.wpengapp.support.LifecycleRegistry.C0957) r1
            com.wpengapp.support.ވ$ؠ r1 = r1.f2619
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r2 = r8.f2612
            com.wpengapp.support.ޅ$ހ<K, V> r2 = r2.f2587
            java.lang.Object r2 = r2.getValue()
            com.wpengapp.support.ދ$֏ r2 = (com.wpengapp.support.LifecycleRegistry.C0957) r2
            com.wpengapp.support.ވ$ؠ r2 = r2.f2619
            if (r1 != r2) goto L_0x0032
            com.wpengapp.support.ވ$ؠ r1 = r8.f2613
            if (r1 != r2) goto L_0x0032
        L_0x0030:
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            if (r1 != 0) goto L_0x0128
            r8.f2617 = r3
            com.wpengapp.support.ވ$ؠ r1 = r8.f2613
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r2 = r8.f2612
            com.wpengapp.support.ޅ$ހ<K, V> r2 = r2.f2586
            java.lang.Object r2 = r2.getValue()
            com.wpengapp.support.ދ$֏ r2 = (com.wpengapp.support.LifecycleRegistry.C0957) r2
            com.wpengapp.support.ވ$ؠ r2 = r2.f2619
            int r1 = r1.compareTo(r2)
            if (r1 >= 0) goto L_0x00c4
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r1 = r8.f2612
            java.util.Iterator r1 = r1.descendingIterator()
        L_0x0051:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c4
            boolean r2 = r8.f2617
            if (r2 != 0) goto L_0x00c4
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.wpengapp.support.ދ$֏ r3 = (com.wpengapp.support.LifecycleRegistry.C0957) r3
        L_0x0067:
            com.wpengapp.support.ވ$ؠ r5 = r3.f2619
            com.wpengapp.support.ވ$ؠ r6 = r8.f2613
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto L_0x0051
            boolean r5 = r8.f2617
            if (r5 != 0) goto L_0x0051
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r5 = r8.f2612
            java.lang.Object r6 = r2.getKey()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x0051
            com.wpengapp.support.ވ$ؠ r5 = r3.f2619
            int r6 = r5.ordinal()
            if (r6 == 0) goto L_0x00be
            if (r6 == r4) goto L_0x00b8
            r7 = 2
            if (r6 == r7) goto L_0x00a6
            r7 = 3
            if (r6 == r7) goto L_0x00a3
            r7 = 4
            if (r6 != r7) goto L_0x0097
            com.wpengapp.support.ވ$֏ r5 = com.wpengapp.support.Lifecycle.C0955.ON_PAUSE
            goto L_0x00a8
        L_0x0097:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unexpected state value "
            java.lang.String r1 = com.wpengapp.support.outline.m2554((java.lang.String) r1, (java.lang.Object) r5)
            r0.<init>(r1)
            throw r0
        L_0x00a3:
            com.wpengapp.support.ވ$֏ r5 = com.wpengapp.support.Lifecycle.C0955.ON_STOP
            goto L_0x00a8
        L_0x00a6:
            com.wpengapp.support.ވ$֏ r5 = com.wpengapp.support.Lifecycle.C0955.ON_DESTROY
        L_0x00a8:
            com.wpengapp.support.ވ$ؠ r6 = m2522((com.wpengapp.support.Lifecycle.C0955) r5)
            java.util.ArrayList<com.wpengapp.support.ވ$ؠ> r7 = r8.f2618
            r7.add(r6)
            r3.mo8994(r0, r5)
            r8.mo8990()
            goto L_0x0067
        L_0x00b8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x00be:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x00c4:
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r1 = r8.f2612
            com.wpengapp.support.ޅ$ހ<K, V> r1 = r1.f2587
            boolean r2 = r8.f2617
            if (r2 != 0) goto L_0x000b
            if (r1 == 0) goto L_0x000b
            com.wpengapp.support.ވ$ؠ r2 = r8.f2613
            java.lang.Object r1 = r1.getValue()
            com.wpengapp.support.ދ$֏ r1 = (com.wpengapp.support.LifecycleRegistry.C0957) r1
            com.wpengapp.support.ވ$ؠ r1 = r1.f2619
            int r1 = r2.compareTo(r1)
            if (r1 <= 0) goto L_0x000b
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r1 = r8.f2612
            com.wpengapp.support.ޅ$ށ r1 = r1.mo8967()
        L_0x00e4:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x000b
            boolean r2 = r8.f2617
            if (r2 != 0) goto L_0x000b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.wpengapp.support.ދ$֏ r3 = (com.wpengapp.support.LifecycleRegistry.C0957) r3
        L_0x00fa:
            com.wpengapp.support.ވ$ؠ r4 = r3.f2619
            com.wpengapp.support.ވ$ؠ r5 = r8.f2613
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L_0x00e4
            boolean r4 = r8.f2617
            if (r4 != 0) goto L_0x00e4
            com.wpengapp.support.ރ<com.wpengapp.support.މ, com.wpengapp.support.ދ$֏> r4 = r8.f2612
            java.lang.Object r5 = r2.getKey()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x00e4
            com.wpengapp.support.ވ$ؠ r4 = r3.f2619
            java.util.ArrayList<com.wpengapp.support.ވ$ؠ> r5 = r8.f2618
            r5.add(r4)
            com.wpengapp.support.ވ$ؠ r4 = r3.f2619
            com.wpengapp.support.ވ$֏ r4 = m2524((com.wpengapp.support.Lifecycle.C0956) r4)
            r3.mo8994(r0, r4)
            r8.mo8990()
            goto L_0x00fa
        L_0x0128:
            r8.f2617 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.LifecycleRegistry.mo8992():void");
    }

    /* renamed from: ֏ */
    public final void mo8990() {
        ArrayList<C0956> arrayList = this.f2618;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: ֏ */
    public static C0956 m2522(C0955 r2) {
        int ordinal = r2.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return C0956.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return C0956.DESTROYED;
                        }
                        throw new IllegalArgumentException(outline.m2554("Unexpected event value ", (Object) r2));
                    }
                }
            }
            return C0956.STARTED;
        }
        return C0956.CREATED;
    }

    /* renamed from: ֏ */
    public static C0956 m2523(@NonNull C0956 r1, @Nullable C0956 r2) {
        return (r2 == null || r2.compareTo(r1) >= 0) ? r1 : r2;
    }
}
