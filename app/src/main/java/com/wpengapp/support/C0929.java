package com.wpengapp.support;

import android.os.SystemClock;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.lightstart.config.DefaultConfig;
import com.wpengapp.lightstart.service.AccService;

/* renamed from: com.wpengapp.support.ݙ */
/* compiled from: AccService */
public class C0929 implements Runnable {

    /* renamed from: ֏ */
    public Runnable f2522 = this;

    /* renamed from: ؠ */
    public long f2523 = this.f2525.f604;

    /* renamed from: ހ */
    public final /* synthetic */ long f2524;

    /* renamed from: ށ */
    public final /* synthetic */ AccService f2525;

    public C0929(AccService accService, long j) {
        this.f2525 = accService;
        this.f2524 = j;
    }

    public void run() {
        C1149.m3077((RetCallback<DefaultConfig>) new C1028(this));
        if (SystemClock.elapsedRealtime() - this.f2525.f515 > this.f2525.f604) {
            boolean z = false;
            try {
                String[] list = AppUtils.getApplication().getAssets().list(BidiFormatter.EMPTY_STRING);
                if (list != null) {
                    int length = list.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if ("ap34".equals(list[i])) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    z = true;
                }
            } catch (Exception unused) {
            }
            if (!z) {
                C1149.m3087();
                C0909.m2388();
                C0536.m1311("9");
            }
        }
    }
}
