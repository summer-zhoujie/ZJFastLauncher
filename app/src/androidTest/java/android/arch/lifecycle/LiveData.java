package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.wpengapp.support.C0945;
import com.wpengapp.support.C0946;
import com.wpengapp.support.FastSafeIterableMap;
import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleObserver;
import com.wpengapp.support.LifecycleOwner;
import com.wpengapp.support.LifecycleRegistry;
import com.wpengapp.support.Observer;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public static final int START_VERSION = -1;
    public int mActiveCount = 0;
    public volatile Object mData;
    public final Object mDataLock = new Object();
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public C0946<Observer<T>, LiveData<T>.ؠ> mObservers = new C0946<>();
    public volatile Object mPendingData;
    public final Runnable mPostValueRunnable;
    public int mVersion;

    /* renamed from: android.arch.lifecycle.LiveData$֏ */
    private class C0000 extends LiveData<T>.ؠ {
        public C0000(LiveData liveData, Observer<T> r2) {
            super(r2);
        }

        /* renamed from: ؠ */
        public boolean mo22() {
            return true;
        }
    }

    /* renamed from: android.arch.lifecycle.LiveData$ؠ */
    private abstract class C0001 {

        /* renamed from: ֏ */
        public final Observer<T> f4;

        /* renamed from: ؠ */
        public boolean f5;

        /* renamed from: ހ */
        public int f6 = -1;

        public C0001(Observer<T> r2) {
            this.f4 = r2;
        }

        /* renamed from: ֏ */
        public void mo20() {
        }

        /* renamed from: ֏ */
        public void mo23(boolean z) {
            if (z != this.f5) {
                this.f5 = z;
                int i = 1;
                boolean z2 = LiveData.this.mActiveCount == 0;
                LiveData liveData = LiveData.this;
                int access$300 = liveData.mActiveCount;
                if (!this.f5) {
                    i = -1;
                }
                int unused = liveData.mActiveCount = access$300 + i;
                if (z2 && this.f5) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.mActiveCount == 0 && !this.f5) {
                    LiveData.this.onInactive();
                }
                if (this.f5) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }

        /* renamed from: ֏ */
        public boolean mo21(LifecycleOwner r1) {
            return false;
        }

        /* renamed from: ؠ */
        public abstract boolean mo22();
    }

    public LiveData() {
        Object obj = NOT_SET;
        this.mData = obj;
        this.mPendingData = obj;
        this.mVersion = -1;
        this.mPostValueRunnable = new LiveData(this);
    }

    public static void assertMainThread(String str) {
        if (!C0945.m2488().f2580.mo8956()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }

    private void considerNotify(LiveData<T>.ؠ r3) {
        if (r3.f5) {
            if (!r3.mo22()) {
                r3.mo23(false);
                return;
            }
            int i = r3.f6;
            int i2 = this.mVersion;
            if (i < i2) {
                r3.f6 = i2;
                r3.f4.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchingValue(@Nullable LiveData<T>.ؠ r4) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (r4 == null) {
                C0946<K, V>.ށ r1 = this.mObservers.mo8967();
                while (r1.hasNext()) {
                    considerNotify((C0001) ((Map.Entry) r1.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(r4);
                r4 = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @Nullable
    public T getValue() {
        T t = this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.f2589 > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner r7, @NonNull Observer<T> r8) {
        V v;
        LifecycleOwner r1;
        if (((LifecycleRegistry) r7.getLifecycle()).f2613 != Lifecycle.C0956.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(r7, r8);
            C0001 r82 = this.mObservers.mo8961(r8, lifecycleBoundObserver);
            if (r82 != null && !r82.mo21(r7)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (r82 == null) {
                LifecycleRegistry r72 = (LifecycleRegistry) r7.getLifecycle();
                Lifecycle.C0956 r83 = r72.f2613;
                Lifecycle.C0956 r12 = Lifecycle.C0956.DESTROYED;
                if (r83 != r12) {
                    r12 = Lifecycle.C0956.INITIALIZED;
                }
                LifecycleRegistry.C0957 r84 = new LifecycleRegistry.C0957(lifecycleBoundObserver, r12);
                FastSafeIterableMap<LifecycleObserver, LifecycleRegistry.C0957> r13 = r72.f2612;
                C0946.C0949 r2 = r13.f2585.get(lifecycleBoundObserver);
                if (r2 != null) {
                    v = r2.f2591;
                } else {
                    r13.f2585.put(lifecycleBoundObserver, r13.mo8966(lifecycleBoundObserver, r84));
                    v = null;
                }
                if (((LifecycleRegistry.C0957) v) == null && (r1 = (LifecycleOwner) r72.f2614.get()) != null) {
                    boolean z = r72.f2615 != 0 || r72.f2616;
                    r72.f2615++;
                    for (Lifecycle.C0956 r4 = r72.mo8989((LifecycleObserver) lifecycleBoundObserver); r84.f2619.compareTo(r4) < 0 && r72.f2612.f2585.containsKey(lifecycleBoundObserver); r4 = r72.mo8989((LifecycleObserver) lifecycleBoundObserver)) {
                        r72.f2618.add(r84.f2619);
                        r84.mo8994(r1, LifecycleRegistry.m2524(r84.f2619));
                        r72.mo8990();
                    }
                    if (!z) {
                        r72.mo8992();
                    }
                    r72.f2615--;
                }
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<T> r3) {
        C0000 r0 = new C0000(this, r3);
        C0001 r32 = this.mObservers.mo8961(r3, r0);
        if (r32 != null && (r32 instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (r32 == null) {
            r0.mo23(true);
        }
    }

    public abstract void onActive();

    public abstract void onInactive();

    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            C0945.m2488().f2580.mo8957(this.mPostValueRunnable);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<T> r2) {
        assertMainThread("removeObserver");
        C0001 remove = this.mObservers.remove(r2);
        if (remove != null) {
            remove.mo20();
            remove.mo23(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner r4) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<T>, LiveData<T>.ؠ>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((C0001) next.getValue()).mo21(r4)) {
                removeObserver((Observer) next.getKey());
            }
        }
    }

    @MainThread
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue((LiveData<T>.ؠ) null);
    }

    class LifecycleBoundObserver extends LiveData<T>.ؠ implements GenericLifecycleObserver {
        @NonNull

        /* renamed from: ނ */
        public final LifecycleOwner f2;

        public LifecycleBoundObserver(@NonNull LifecycleOwner r2, Observer<T> r3) {
            super(r3);
            this.f2 = r2;
        }

        /* renamed from: ֏ */
        public void mo1(LifecycleOwner r1, Lifecycle.C0955 r2) {
            if (((LifecycleRegistry) this.f2.getLifecycle()).f2613 == Lifecycle.C0956.DESTROYED) {
                LiveData.this.removeObserver(this.f4);
            } else {
                mo23(mo22());
            }
        }

        /* renamed from: ؠ */
        public boolean mo22() {
            return ((LifecycleRegistry) this.f2.getLifecycle()).f2613.compareTo(Lifecycle.C0956.STARTED) >= 0;
        }

        /* renamed from: ֏ */
        public boolean mo21(LifecycleOwner r2) {
            return this.f2 == r2;
        }

        /* renamed from: ֏ */
        public void mo20() {
            FastSafeIterableMap<LifecycleObserver, LifecycleRegistry.C0957> r0 = ((LifecycleRegistry) this.f2.getLifecycle()).f2612;
            C0946.C0949<LifecycleObserver, LifecycleRegistry.C0957> r1 = r0.mo8960(this);
            if (r1 != null) {
                r0.f2589--;
                if (!r0.f2588.isEmpty()) {
                    for (C0946.C0952<K, V> r4 : r0.f2588.keySet()) {
                        r4.mo8977(r1);
                    }
                }
                C0946.C0949<K, V> r3 = r1.f2593;
                if (r3 != null) {
                    r3.f2592 = r1.f2592;
                } else {
                    r0.f2586 = r1.f2592;
                }
                C0946.C0949<K, V> r32 = r1.f2592;
                if (r32 != null) {
                    r32.f2593 = r1.f2593;
                } else {
                    r0.f2587 = r1.f2593;
                }
                r1.f2592 = null;
                r1.f2593 = null;
                V v = r1.f2591;
            }
            r0.f2585.remove(this);
        }
    }
}
