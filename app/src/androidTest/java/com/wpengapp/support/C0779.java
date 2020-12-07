package com.wpengapp.support;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.C0678;
import com.wpengapp.support.licensing.activity.InputContactActivity;
import com.wpengapp.support.licensing.model.WanpuPayDto;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ծ */
/* compiled from: PayManager */
public final class C0779 extends HttpGsonRequest<WanpuPayDto> {

    /* renamed from: ދ */
    public final /* synthetic */ ProgressDialog f1999;

    /* renamed from: ތ */
    public final /* synthetic */ InputContactActivity f2000;

    /* renamed from: ލ */
    public final /* synthetic */ UserInfo f2001;

    /* renamed from: ގ */
    public final /* synthetic */ C0678.C0680 f2002;

    /* renamed from: ޏ */
    public final /* synthetic */ Activity f2003;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0779(String str, String str2, Map map, String str3, ProgressDialog progressDialog, InputContactActivity inputContactActivity, UserInfo r7, C0678.C0680 r8, Activity activity) {
        super(str, str2, map, str3);
        this.f1999 = progressDialog;
        this.f2000 = inputContactActivity;
        this.f2001 = r7;
        this.f2002 = r8;
        this.f2003 = activity;
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<WanpuPayDto> r3, ErrorCode r4) {
        C0936.m2465(this.f1999);
        if (r4 == ErrorCode.USER_ALREADY_PAID) {
            this.f2000.finish();
            C0678.m1732(true, BidiFormatter.EMPTY_STRING, this.f2001, this.f2002);
        } else if (!r4.mo8157() || r3.f3518 == null) {
            C0826.m2177((CharSequence) r4.f1083);
        } else {
            C0678.m1727(this.f2003, String.valueOf(this.f2001.f2110), (WanpuPayDto) r3.f3518, (WpAlipayCallback) new C0896(this));
            this.f2000.finish();
        }
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        C0936.m2465(this.f1999);
        exc.getMessage();
        C0826.m2180((CharSequence) ErrorCode.FAILED.f1083);
        C0678.m1732(false, ErrorCode.FAILED.f1083, this.f2001, this.f2002);
    }
}
