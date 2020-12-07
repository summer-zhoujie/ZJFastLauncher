package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ઠ */
/* compiled from: KeepAlivePermissionView */
class C1104 implements RemoteCallback {

    /* renamed from: ֏ */
    public final /* synthetic */ C0894 f3137;

    public C1104(C0894 r1) {
        this.f3137 = r1;
    }

    /* renamed from: ֏ */
    public void mo9289(RemoteResult r4) {
        if (!r4.f3115 || !r4.f3116.getBoolean("ret", false)) {
            C0826.m2179(R$string.pw_permission_quick_setup_not_support, new Object[0]);
            return;
        }
        C0826.m2172(R$string.pw_permission_lock_recent_des, SystemUtils.m3519(this.f3137.f2416.getContext().getPackageName()));
    }
}
