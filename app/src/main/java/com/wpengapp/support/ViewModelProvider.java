package com.wpengapp.support;

import android.support.annotation.NonNull;

/* renamed from: com.wpengapp.support.ޔ */
public interface ViewModelProvider {
    @NonNull
    <T extends ViewModel> T create(@NonNull Class<T> cls);
}
