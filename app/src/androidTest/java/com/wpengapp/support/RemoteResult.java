package com.wpengapp.support;

import android.os.Bundle;
import android.support.annotation.NonNull;

/* renamed from: com.wpengapp.support.ઈ */
public class RemoteResult {

    /* renamed from: ֏ */
    public boolean f3115;

    /* renamed from: ؠ */
    public Bundle f3116;

    @NonNull
    public String toString() {
        StringBuilder r0 = outline.m2549("RemoteResult{success=");
        r0.append(this.f3115);
        r0.append(", bundle=");
        r0.append(this.f3116);
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: ֏ */
    public boolean mo9280() {
        return this.f3115 && this.f3116.getBoolean("RET");
    }
}
