package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Κ */
public class BooleanSP extends SP<Boolean> {
    public BooleanSP(String str, Boolean bool) {
        super(str, bool);
    }

    /* renamed from: ֏ */
    public void mo8105(Object obj) {
        RemoteSP.m1204((SP<?>) this, (Object) (Boolean) obj, false);
    }

    /* renamed from: ؠ */
    public void mo8106(Object obj) {
        RemoteSP.m1204((SP<?>) this, (Object) (Boolean) obj, true);
    }

    /* renamed from: ֏ */
    public Object mo8104() {
        return Boolean.valueOf(RemoteSP.m1209((SP<Boolean>) this));
    }
}
