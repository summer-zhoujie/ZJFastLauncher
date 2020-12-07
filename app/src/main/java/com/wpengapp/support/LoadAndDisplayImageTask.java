package com.wpengapp.support;

import android.content.res.Resources;
import com.wpengapp.support.FailReason;

/* renamed from: com.wpengapp.support.ʱ */
class LoadAndDisplayImageTask implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ FailReason.C0821 f1383;

    /* renamed from: ؠ */
    public final /* synthetic */ Throwable f1384;

    /* renamed from: ހ */
    public final /* synthetic */ C1336 f1385;

    public LoadAndDisplayImageTask(C1336 r1, FailReason.C0821 r2, Throwable th) {
        this.f1385 = r1;
        this.f1383 = r2;
        this.f1384 = th;
    }

    public void run() {
        C0621 r0 = this.f1385.f3823;
        if ((r0.f1560 == null && r0.f1557 == 0) ? false : true) {
            C1336 r02 = this.f1385;
            ImageAware r1 = r02.f3821;
            C0621 r2 = r02.f3823;
            Resources resources = r02.f3814.f1410;
            int i = r2.f1557;
            r1.mo7954(i != 0 ? resources.getDrawable(i) : r2.f1560);
        }
        C1336 r03 = this.f1385;
        r03.f3824.mo7944(r03.f3819, r03.f3821.mo7952(), new FailReason(this.f1383, this.f1384));
    }
}
