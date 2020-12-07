package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: com.wpengapp.support.ӗ */
public abstract class RemoteMethod {

    /* renamed from: ֏ */
    public final String f1927;

    public RemoteMethod(String str) {
        this.f1927 = str;
    }

    @NonNull
    /* renamed from: ֏ */
    public RemoteResult mo8563(@Nullable Bundle bundle) {
        return C1146.m3069(this.f1927, bundle);
    }

    /* renamed from: ؠ */
    public abstract Bundle mo7979(@Nullable Bundle bundle);

    @NonNull
    /* renamed from: ֏ */
    public RemoteResult mo8564(@Nullable String str) {
        Bundle bundle = new Bundle();
        bundle.putString("TAG", str);
        return C1146.m3069(this.f1927, bundle);
    }

    /* renamed from: ֏ */
    public static Bundle m1957(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("RET", z);
        return bundle;
    }

    /* renamed from: ֏ */
    public void mo8565() {
        C1146.f3266.put(this.f1927, this);
    }
}
