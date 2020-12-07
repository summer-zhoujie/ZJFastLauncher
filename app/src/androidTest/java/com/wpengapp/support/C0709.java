package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.у */
/* compiled from: UserManager */
public final class C0709 extends HttpSimpleRequest {

    /* renamed from: ދ */
    public final /* synthetic */ SyncUserInfoListener f1827;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0709(String str, String str2, Map map, String str3, SyncUserInfoListener r5) {
        super(str, str2, map, str3);
        this.f1827 = r5;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<String> r3, ErrorCode r4) {
        if (!r4.mo8157()) {
            SyncUserInfoListener r32 = this.f1827;
            if (r32 == null) {
                return;
            }
            if (r4 == ErrorCode.MAINTAIN) {
                r32.mo8100(4);
            } else {
                r32.mo8100(1);
            }
        } else {
            String str = (String) r3.f3518;
            UserInfo r42 = C0536.m1298(str);
            if (r42 == null) {
                SyncUserInfoListener r33 = this.f1827;
                if (r33 != null) {
                    r33.mo8100(1);
                    return;
                }
                return;
            }
            SyncUserInfoListener r0 = this.f1827;
            if (r0 != null) {
                r0.mo8405(str, r42);
                this.f1827.mo8101(r42);
            }
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        SyncUserInfoListener r0 = this.f1827;
        if (r0 == null) {
            return;
        }
        if (exc instanceof MaintainException) {
            r0.mo8100(4);
        } else {
            r0.mo8100(2);
        }
    }
}
