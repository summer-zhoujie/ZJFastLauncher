package com.wpengapp.support;

import java.util.Set;

/* renamed from: com.wpengapp.support.ΰ */
/* compiled from: RemoteSP */
class C0644 implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ Set f1650;

    /* renamed from: ؠ */
    public final /* synthetic */ String f1651;

    /* renamed from: ހ */
    public final /* synthetic */ Object f1652;

    public C0644(Set set, String str, Object obj) {
        this.f1650 = set;
        this.f1651 = str;
        this.f1652 = obj;
    }

    public void run() {
        for (C1040 r1 : this.f1650) {
            try {
                r1.mo9161(this.f1651, this.f1652);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
