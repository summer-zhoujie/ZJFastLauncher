package com.wpengapp.support;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.support.C0678;
import com.wpengapp.support.licensing.activity.QrPayActivity;
import com.wpengapp.support.licensing.model.QrPayDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ⴁ */
/* compiled from: PayManager */
class C1299 extends HttpGsonRequest<QrPayDto> {

    /* renamed from: ދ */
    public final /* synthetic */ ProgressDialog f3698;

    /* renamed from: ތ */
    public final /* synthetic */ C0678.C0680 f3699;

    /* renamed from: ލ */
    public final /* synthetic */ Activity f3700;

    /* renamed from: ގ */
    public final /* synthetic */ boolean f3701;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1299(String str, String str2, Map map, String str3, ProgressDialog progressDialog, C0678.C0680 r6, Activity activity, boolean z) {
        super(str, str2, map, str3);
        this.f3698 = progressDialog;
        this.f3699 = r6;
        this.f3700 = activity;
        this.f3701 = z;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<QrPayDto> r3, ErrorCode r4) {
        T t;
        C0936.m2465(this.f3698);
        if (r4 == ErrorCode.USER_ALREADY_CAN_CHANGE_DEVICE) {
            C0678.m1731(true, BidiFormatter.EMPTY_STRING, this.f3699);
        } else if (!r4.mo8157() || (t = r3.f3518) == null || TextUtils.isEmpty(((QrPayDto) t).qrContent)) {
            C0826.m2177((CharSequence) r4.f1083);
        } else {
            T t2 = r3.f3518;
            ((QrPayDto) t2).biz = 2;
            QrPayActivity.m865(this.f3700, this.f3701, (QrPayDto) t2, new C1133(this));
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C0936.m2465(this.f3698);
        exc.getMessage();
        C0826.m2180((CharSequence) ErrorCode.FAILED.f1083);
        C0678.m1731(false, ErrorCode.FAILED.f1083, this.f3699);
    }
}
