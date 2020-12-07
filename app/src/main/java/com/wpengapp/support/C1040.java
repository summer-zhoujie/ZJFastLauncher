package com.wpengapp.support;

import com.wpengapp.support.RemoteSP;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.wpengapp.support.ढ़ */
/* compiled from: UserManager */
class C1040 implements RemoteSP.C0507 {
    /* renamed from: ֏ */
    public void mo9161(String str, Object obj) {
        if (obj != null) {
            if (C0536.m1316().equals(str)) {
                UserInfo r3 = C0536.m1298(String.valueOf(obj));
                if (r3 != null) {
                    C0536.f1037 = r3;
                    WPengServer.m1073(String.valueOf(C0536.f1037.f2110));
                    Iterator it = new HashSet(C0536.f1035.keySet()).iterator();
                    while (it.hasNext()) {
                        OnUserInfoChangedListener r4 = (OnUserInfoChangedListener) it.next();
                        if (r4 != null) {
                            try {
                                r4.mo8475(C0536.f1037);
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        }
                    }
                }
                C0536.m1305(false);
            } else if (C0536.m1318().equals(str)) {
                "Pay time changed，data: " + obj;
                C0536.m1305(false);
            }
        }
    }
}
