package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ʎ */
public class UnpaidCountLimit {

    /* renamed from: ֏ */
    public int f1339;

    /* renamed from: ؠ */
    public int f1340;

    public UnpaidCountLimit(int i) {
        this.f1339 = i;
    }

    /* renamed from: ֏ */
    public void mo8263() {
        this.f1340--;
    }

    /* renamed from: ؠ */
    public boolean mo8264() {
        if (SyncPayStatus.m1962()) {
            return false;
        }
        this.f1340++;
        if (this.f1340 < this.f1339) {
            return false;
        }
        this.f1340 = 0;
        return true;
    }
}
