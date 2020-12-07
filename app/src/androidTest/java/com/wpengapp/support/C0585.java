package com.wpengapp.support;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.C0678;
import com.wpengapp.support.licensing.model.WanpuPayDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.ʀ */
/* compiled from: PayManager */
class C0585 extends HttpGsonRequest<WanpuPayDto> {

    /* renamed from: ދ */
    public final /* synthetic */ ProgressDialog f1274;

    /* renamed from: ތ */
    public final /* synthetic */ C0678.C0680 f1275;

    /* renamed from: ލ */
    public final /* synthetic */ Activity f1276;

    /* renamed from: ގ */
    public final /* synthetic */ UserInfo f1277;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0585(String str, String str2, Map map, String str3, ProgressDialog progressDialog, C0678.C0680 r6, Activity activity, UserInfo r8) {
        super(str, str2, map, str3);
        this.f1274 = progressDialog;
        this.f1275 = r6;
        this.f1276 = activity;
        this.f1277 = r8;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<WanpuPayDto> r3, ErrorCode r4) {
        C0936.m2465(this.f1274);
        if (r4 == ErrorCode.USER_ALREADY_CAN_CHANGE_DEVICE) {
            C0678.m1731(true, BidiFormatter.EMPTY_STRING, this.f1275);
        } else if (!r4.mo8157() || r3.f3518 == null) {
            C0826.m2177((CharSequence) r4.f1083);
        } else {
            C0678.m1727(this.f1276, String.valueOf(this.f1277.f2110), (WanpuPayDto) r3.f3518, (WpAlipayCallback) new C1225(this));
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C0936.m2465(this.f1274);
        exc.getMessage();
        C0826.m2180((CharSequence) ErrorCode.FAILED.f1083);
        C0678.m1731(false, ErrorCode.FAILED.f1083, this.f1275);
    }
}
