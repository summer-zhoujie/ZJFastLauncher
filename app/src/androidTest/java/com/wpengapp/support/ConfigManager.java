package com.wpengapp.support;

import com.wpengapp.support.C1063;
import java.util.HashSet;

/* renamed from: com.wpengapp.support.Ł */
public final class ConfigManager implements Runnable {
    public void run() {
        HashSet<C1063.C1065> hashSet = null;
        while (hashSet == null) {
            try {
                hashSet = new HashSet<>(C1063.f3038.keySet());
            } catch (Exception e) {
                e.getMessage();
            }
        }
        for (C1063.C1065 r1 : hashSet) {
            try {
                r1.mo8041();
            } catch (Exception unused) {
            }
        }
    }
}
