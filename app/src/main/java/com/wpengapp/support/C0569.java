package com.wpengapp.support;

import java.util.List;

/* renamed from: com.wpengapp.support.Ɉ */
/* compiled from: AccTaskManager */
class C0569 implements TaskCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ AccTask f1214;

    /* renamed from: ؠ */
    public final /* synthetic */ AccTaskGroup f1215;

    public C0569(AccTask r1, AccTaskGroup r2) {
        this.f1214 = r1;
        this.f1215 = r2;
    }

    public void error() {
        this.f1215.mo8877();
    }

    /* renamed from: ֏ */
    public void mo8185() {
        AccTask r0 = this.f1214;
        List<AccTask> list = this.f1215.f1243;
        if (r0 == list.get(list.size() - 1)) {
            this.f1215.mo8879();
        }
    }
}
