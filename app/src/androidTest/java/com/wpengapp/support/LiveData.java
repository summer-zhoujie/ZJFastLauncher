package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ގ */
class LiveData implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ android.arch.lifecycle.LiveData f2623;

    public LiveData(android.arch.lifecycle.LiveData liveData) {
        this.f2623 = liveData;
    }

    public void run() {
        Object access$100;
        synchronized (this.f2623.mDataLock) {
            access$100 = this.f2623.mPendingData;
            Object unused = this.f2623.mPendingData = android.arch.lifecycle.LiveData.NOT_SET;
        }
        this.f2623.setValue(access$100);
    }
}
