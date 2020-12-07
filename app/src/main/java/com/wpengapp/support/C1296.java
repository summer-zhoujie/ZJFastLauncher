package com.wpengapp.support;

import android.accessibilityservice.AccessibilityService;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.lightstart.service.AccService;
import com.wpengapp.support.AccServiceHelper;

/* renamed from: com.wpengapp.support.ၔ */
/* compiled from: AccService */
class C1296 implements Runnable {

    /* renamed from: ֏ */
    public boolean f3650;

    /* renamed from: ؠ */
    public String f3651;

    /* renamed from: ހ */
    public Float f3652;

    /* renamed from: ށ */
    public final /* synthetic */ String f3653;

    /* renamed from: ނ */
    public final /* synthetic */ PageConfig f3654;

    /* renamed from: ރ */
    public final /* synthetic */ boolean f3655;

    /* renamed from: ބ */
    public final /* synthetic */ String f3656;

    /* renamed from: ޅ */
    public final /* synthetic */ int f3657;

    /* renamed from: ކ */
    public final /* synthetic */ boolean f3658;

    /* renamed from: އ */
    public final /* synthetic */ long f3659;

    /* renamed from: ވ */
    public final /* synthetic */ int f3660;

    /* renamed from: މ */
    public final /* synthetic */ boolean f3661;

    /* renamed from: ފ */
    public final /* synthetic */ boolean f3662;

    /* renamed from: ދ */
    public final /* synthetic */ long f3663;

    /* renamed from: ތ */
    public final /* synthetic */ AccService f3664;

    public C1296(AccService accService, String str, PageConfig r3, boolean z, String str2, int i, boolean z2, long j, int i2, boolean z3, boolean z4, long j2) {
        this.f3664 = accService;
        this.f3653 = str;
        this.f3654 = r3;
        this.f3655 = z;
        this.f3656 = str2;
        this.f3657 = i;
        this.f3658 = z2;
        this.f3659 = j;
        this.f3660 = i2;
        this.f3661 = z3;
        this.f3662 = z4;
        this.f3663 = j2;
    }

    public void run() {
        String str = null;
        if (!this.f3664.mo7743(this.f3653, this.f3654.mo9158())) {
            if (!this.f3655) {
                return;
            }
            if (this.f3650) {
                this.f3664.mo7734(this.f3653, this.f3656, "loop", this.f3657, this.f3651, this.f3652, this.f3654);
                return;
            }
            StringBuilder r0 = outline.m2549("Skip fail 1: ");
            r0.append(this.f3653);
            r0.toString();
            C0471.m1018(this.f3653, false, (String) null, (Float) null);
        } else if (this.f3658 || System.currentTimeMillis() - this.f3659 <= ((long) this.f3660)) {
            AccServiceHelper.C0755 r02 = AccServiceHelper.m2010((AccessibilityService) this.f3664, (CharSequence) this.f3656);
            AccessibilityNodeInfo accessibilityNodeInfo = r02.f1950;
            if (!(accessibilityNodeInfo == null || accessibilityNodeInfo == r02.f1951)) {
                if (TextUtils.equals("com.miui.systemAdSolution", accessibilityNodeInfo.getPackageName())) {
                    str = "com.miui.systemAdSolution";
                } else if (TextUtils.equals("com.opos.ads", r02.f1950.getPackageName())) {
                    str = "com.opos.ads";
                }
            }
            if (!this.f3661) {
                AccService.C0442 r1 = this.f3664.mo7745(r02.f1951, this.f3653, this.f3656, this.f3654);
                if (str != null) {
                    AccService accService = this.f3664;
                    r1 = accService.mo7745(r02.f1950, this.f3653, str, accService.f512);
                }
                if (!TextUtils.isEmpty(r1.f530)) {
                    if (!this.f3650) {
                        long unused = this.f3664.f506 = 0;
                        if (this.f3654.mo9158()) {
                            this.f3664.mo7731(this.f3656);
                        } else {
                            this.f3664.mo7748(this.f3656);
                        }
                    }
                    this.f3650 = true;
                    this.f3651 = r1.f531;
                    this.f3652 = r1.f532;
                }
                if (this.f3655 || !this.f3650) {
                    if (this.f3655) {
                        StringBuilder r03 = outline.m2549("Skip Loop, skipType: ");
                        r03.append(r1.f530);
                        r03.append(", ");
                        r03.append(this.f3653);
                        r03.toString();
                    } else {
                        StringBuilder r04 = outline.m2549("Skip fail: ");
                        r04.append(this.f3653);
                        r04.toString();
                    }
                    this.f3664.f503.postDelayed(this, this.f3663);
                    return;
                }
                this.f3664.mo7734(this.f3653, this.f3656, r1.f530, this.f3657, r1.f531, r1.f532, this.f3654);
            } else if (!this.f3664.mo7742(r02.f1951, this.f3653, this.f3656, this.f3662, false)) {
                if (str == null || !this.f3664.mo7742(r02.f1950, this.f3653, this.f3656, this.f3662, false)) {
                    this.f3664.f503.postDelayed(this, this.f3663);
                }
            }
        } else if (this.f3655 && this.f3650) {
            this.f3664.mo7734(this.f3653, this.f3656, "loop", this.f3657, this.f3651, this.f3652, this.f3654);
        } else if (!this.f3661) {
            StringBuilder r05 = outline.m2549("Skip fail 2: ");
            r05.append(this.f3653);
            r05.toString();
            C0471.m1018(this.f3653, false, (String) null, (Float) null);
        }
    }
}
