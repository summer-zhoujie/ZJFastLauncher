package com.wpengapp.support;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.view.View;
import com.wpengapp.lightstart.service.AccService;
import java.util.Calendar;

/* renamed from: com.wpengapp.support.৳ */
/* compiled from: FullRuleChecker */
public class C1079 {

    /* renamed from: ֏ */
    public boolean f3058;

    /* renamed from: ؠ */
    public long f3059;

    /* renamed from: ހ */
    public Context f3060;

    /* renamed from: ށ */
    public SP<Integer> f3061 = new IntSP("tdsf2k218fhyt111", 0);

    /* renamed from: ނ */
    public SP<Integer> f3062 = new IntSP("tdd2d213sytl11", 0);

    /* renamed from: ރ */
    public SP<Integer> f3063 = new IntSP("tdd112l13sytl11", 0);

    public C1079(AccService accService) {
        new C0891(this);
        this.f3060 = accService;
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m2881(FloatWindow r3, View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new C1220(view));
        ofFloat.setDuration(200);
        ofFloat.addListener(new C0788(r3));
        ofFloat.start();
    }

    /* renamed from: ֏ */
    public void mo9253() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!SyncPayStatus.m1962()) {
            FullRule r2 = C1149.m3084();
            SP<Integer> r3 = this.f3063;
            r3.mo8105(Integer.valueOf(r3.mo8104().intValue() + 1));
            if (this.f3063.mo8104().intValue() < 0 || this.f3063.mo8104().intValue() >= r2.f2071) {
                long j = this.f3059;
                if (j <= 0 || elapsedRealtime - j >= r2.f2073) {
                    int i = Calendar.getInstance().get(5);
                    if (this.f3062.mo8104().intValue() != i) {
                        this.f3061.mo8105(0);
                    }
                    int intValue = this.f3061.mo8104().intValue();
                    if (intValue >= r2.f2072) {
                        "TodayShowTimes " + intValue;
                        return;
                    }
                    this.f3062.mo8105(Integer.valueOf(i));
                    this.f3061.mo8105(Integer.valueOf(intValue + 1));
                    this.f3059 = elapsedRealtime;
                    this.f3063.mo8105(0);
                    if (Utils.m1893()) {
                        AppUtils.m1147((Runnable) new C1283(this), (long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                        return;
                    }
                    return;
                }
                return;
            }
            StringBuilder r0 = outline.m2549("ST ");
            r0.append(this.f3063.mo8104());
            r0.toString();
        }
    }
}
