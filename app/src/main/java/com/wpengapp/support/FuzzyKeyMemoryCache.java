package com.wpengapp.support;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.wpengapp.support.ˡ */
public class FuzzyKeyMemoryCache implements MemoryCache {

    /* renamed from: ֏ */
    public final MemoryCache f1544;

    /* renamed from: ؠ */
    public final Comparator<String> f1545;

    public FuzzyKeyMemoryCache(MemoryCache r1, Comparator<String> comparator) {
        this.f1544 = r1;
        this.f1545 = comparator;
    }

    public Bitmap remove(String str) {
        return this.f1544.remove(str);
    }

    /* renamed from: ֏ */
    public boolean mo8298(String str, Bitmap bitmap) {
        synchronized (this.f1544) {
            String str2 = null;
            Iterator<String> it = this.f1544.mo8296().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.f1545.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f1544.remove(str2);
            }
        }
        return this.f1544.mo8298(str, bitmap);
    }

    /* renamed from: ֏ */
    public Bitmap mo8295(String str) {
        return this.f1544.mo8295(str);
    }

    /* renamed from: ֏ */
    public Collection<String> mo8296() {
        return this.f1544.mo8296();
    }
}
