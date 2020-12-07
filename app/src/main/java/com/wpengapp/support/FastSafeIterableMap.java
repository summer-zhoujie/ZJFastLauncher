package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.wpengapp.support.C0946;
import java.util.HashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.wpengapp.support.ރ */
public class FastSafeIterableMap<K, V> extends C0946<K, V> {

    /* renamed from: ނ */
    public HashMap<K, C0949<K, V>> f2585 = new HashMap<>();

    public boolean contains(K k) {
        return this.f2585.containsKey(k);
    }

    public V remove(@NonNull K k) {
        C0949 r0 = mo8960(k);
        V v = null;
        if (r0 != null) {
            this.f2589--;
            if (!this.f2588.isEmpty()) {
                for (C0952<K, V> r3 : this.f2588.keySet()) {
                    r3.mo8977(r0);
                }
            }
            C0949<K, V> r2 = r0.f2593;
            if (r2 != null) {
                r2.f2592 = r0.f2592;
            } else {
                this.f2586 = r0.f2592;
            }
            C0949<K, V> r22 = r0.f2592;
            if (r22 != null) {
                r22.f2593 = r0.f2593;
            } else {
                this.f2587 = r0.f2593;
            }
            r0.f2592 = null;
            r0.f2593 = null;
            v = r0.f2591;
        }
        this.f2585.remove(k);
        return v;
    }

    /* renamed from: ֏ */
    public C0949<K, V> mo8960(K k) {
        return this.f2585.get(k);
    }

    /* renamed from: ؠ */
    public V mo8961(@NonNull K k, @NonNull V v) {
        C0949 r0 = this.f2585.get(k);
        if (r0 != null) {
            return r0.f2591;
        }
        this.f2585.put(k, mo8966(k, v));
        return null;
    }
}
