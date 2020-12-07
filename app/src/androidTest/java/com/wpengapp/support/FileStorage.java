package com.wpengapp.support;

import java.util.HashSet;

/* renamed from: com.wpengapp.support.Ǯ */
public class FileStorage implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f998;

    /* renamed from: ؠ */
    public final /* synthetic */ C1323 f999;

    public FileStorage(C1323 r1, boolean z) {
        this.f999 = r1;
        this.f998 = z;
    }

    public void run() {
        for (OnFileChangeListener r1 : new HashSet(this.f999.f3792.keySet())) {
            try {
                r1.mo8530(this.f998);
            } catch (Exception unused) {
            }
        }
    }
}
