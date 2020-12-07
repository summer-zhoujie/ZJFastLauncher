package com.wpengapp.support;

import java.util.ArrayList;

/* renamed from: com.wpengapp.support.ξ */
/* compiled from: UserManager */
class C0652 extends SyncUserInfoListener {

    /* renamed from: ֏ */
    public final /* synthetic */ boolean f1678;

    public C0652(boolean z) {
        this.f1678 = z;
    }

    /* renamed from: ֏ */
    public void mo8405(String str, UserInfo r5) {
        ArrayList<SyncUserInfoListener> arrayList;
        Runnable runnable;
        RemoteSP.m1206("spstnca1l1", (Object) false, false);
        RemoteSP.m1206("spltineerr", (Object) false, false);
        C0536.m1302(str, r5);
        if (r5.mo8705()) {
            C0536.m1324();
        } else if (this.f1678 && (runnable = C0536.f1044) != null) {
            runnable.run();
        }
        int i = r5.f2124;
        if (i > 0) {
            C0536.m1300(i);
        }
        synchronized (C0536.f1034) {
            C0536.f1036 = false;
            arrayList = new ArrayList<>(C0536.f1034);
            C0536.f1034.clear();
        }
        for (SyncUserInfoListener r0 : arrayList) {
            r0.mo8101(r5);
        }
    }

    /* renamed from: ֏ */
    public void mo8100(int i) {
        ArrayList<SyncUserInfoListener> arrayList;
        int i2;
        UserInfo r0 = C0536.m1309();
        if (r0 != null && (i2 = r0.f2124) > 0) {
            C0536.m1300(i2);
        }
        synchronized (C0536.f1034) {
            C0536.f1036 = false;
            arrayList = new ArrayList<>(C0536.f1034);
            C0536.f1034.clear();
        }
        for (SyncUserInfoListener r1 : arrayList) {
            r1.mo8100(i);
        }
    }
}
