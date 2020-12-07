package com.wpengapp.support;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.support.C0678;
import com.wpengapp.support.licensing.activity.InputContactActivity;
import com.wpengapp.support.licensing.activity.QrPayActivity;
import com.wpengapp.support.licensing.model.QrPayDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ŝ */
public final class PayManager extends HttpGsonRequest<QrPayDto> {

    /* renamed from: ދ */
    public final /* synthetic */ ProgressDialog f854;

    /* renamed from: ތ */
    public final /* synthetic */ InputContactActivity f855;

    /* renamed from: ލ */
    public final /* synthetic */ UserInfo f856;

    /* renamed from: ގ */
    public final /* synthetic */ C0678.C0680 f857;

    /* renamed from: ޏ */
    public final /* synthetic */ Activity f858;

    /* renamed from: ސ */
    public final /* synthetic */ boolean f859;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayManager(String str, String str2, Map map, String str3, ProgressDialog progressDialog, InputContactActivity inputContactActivity, UserInfo r7, C0678.C0680 r8, Activity activity, boolean z) {
        super(str, str2, map, str3);
        this.f854 = progressDialog;
        this.f855 = inputContactActivity;
        this.f856 = r7;
        this.f857 = r8;
        this.f858 = activity;
        this.f859 = z;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<QrPayDto> r3, ErrorCode r4) {
        T t;
        C0936.m2465(this.f854);
        if (r4 == ErrorCode.USER_ALREADY_PAID) {
            this.f855.finish();
            C0678.m1732(true, BidiFormatter.EMPTY_STRING, this.f856, this.f857);
        } else if (!r4.mo8157() || (t = r3.f3518) == null || TextUtils.isEmpty(((QrPayDto) t).qrContent)) {
            C0826.m2177((CharSequence) r4.f1083);
        } else {
            T t2 = r3.f3518;
            ((QrPayDto) t2).biz = 1;
            QrPayActivity.m865(this.f858, this.f859, (QrPayDto) t2, new C1100(this));
            this.f855.finish();
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C0936.m2465(this.f854);
        exc.getMessage();
        C0826.m2180((CharSequence) ErrorCode.FAILED.f1083);
        C0678.m1732(false, ErrorCode.FAILED.f1083, this.f856, this.f857);
    }
}
