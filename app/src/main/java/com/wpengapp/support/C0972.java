package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.http.RequestHelper;
import java.util.HashMap;

/* renamed from: com.wpengapp.support.ߕ */
/* compiled from: UserManager */
public final class C0972 implements Runnable {
    public void run() {
        String str;
        try {
            HashMap hashMap = new HashMap();
            try {
                str = RequestHelper.m338(GsonUtil.m2742(Utils.m1900()));
            } catch (Exception e) {
                e.getMessage();
                str = BidiFormatter.EMPTY_STRING;
            }
            hashMap.put("di", str);
            new C1023(this, "POST", ApiConstant.f2724, hashMap, (String) null).mo8757(true);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
