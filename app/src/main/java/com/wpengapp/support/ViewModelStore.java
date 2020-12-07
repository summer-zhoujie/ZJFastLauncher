package com.wpengapp.support;

import java.util.HashMap;

/* renamed from: com.wpengapp.support.ޕ */
public class ViewModelStore {

    /* renamed from: ֏ */
    public final HashMap<String, ViewModel> f2624 = new HashMap<>();

    /* renamed from: ֏ */
    public final void mo8997() {
        for (ViewModel onCleared : this.f2624.values()) {
            onCleared.onCleared();
        }
        this.f2624.clear();
    }
}
