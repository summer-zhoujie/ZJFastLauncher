package com.wpengapp.support;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.licensing.activity.InputContactActivity;

/* renamed from: com.wpengapp.support.ય */
/* compiled from: AppOrderHandler */
public class C1114 implements OnUserInfoChangedListener {

    /* renamed from: ֏ */
    public ProgressDialog f3169;

    /* renamed from: ؠ */
    public Context f3170;

    /* renamed from: ހ */
    public int f3171 = -1;

    /* renamed from: ށ */
    public UserInfo f3172;

    /* renamed from: ނ */
    public C1114 f3173 = this;

    public C1114(Context context) {
        this.f3170 = context;
        C0536.f1035.put(this, OnUserInfoChangedListener.class);
    }

    /* renamed from: ֏ */
    public void mo8475(UserInfo r1) {
        this.f3172 = r1;
    }

    /* renamed from: ؠ */
    public void mo9300(String str, UseAppCodeListener r10) {
        if (str == null || str.trim().isEmpty()) {
            C0826.m2179(R$string.wpengpay_app_code_input_error, new Object[0]);
            r10.mo8519(false, BidiFormatter.EMPTY_STRING, ErrorCode.FAILED);
            return;
        }
        String trim = str.trim();
        if (trim.isEmpty() || trim.length() > 50) {
            C0826.m2179(R$string.wpengpay_app_code_input_error, new Object[0]);
            r10.mo8519(false, BidiFormatter.EMPTY_STRING, ErrorCode.FAILED);
        } else if (!NetworkUtils.m1800()) {
            C0826.m2179(R$string.pw_network_error, new Object[0]);
            r10.mo8519(false, BidiFormatter.EMPTY_STRING, ErrorCode.FAILED);
        } else {
            UserInfo r2 = this.f3172;
            if (r2 != null && !r2.f2127) {
                long currentTimeMillis = System.currentTimeMillis();
                UserInfo r4 = this.f3172;
                if (currentTimeMillis - r4.f2117 <= 300000) {
                    if (C0536.m1313(r4) || C0536.m1322()) {
                        C0826.m2179(R$string.wpengpay_app_code_use_success, new Object[0]);
                        r10.mo8519(true, BidiFormatter.EMPTY_STRING, ErrorCode.SUCCESS);
                        return;
                    }
                    mo9298(trim, r10);
                    return;
                }
            }
            mo9299(false, false, false, (QueryCallback) new C1125(this, r10, trim));
        }
    }

    /* renamed from: ֏ */
    public void mo9299(boolean z, boolean z2, boolean z3, QueryCallback r5) {
        C1115 r0 = new C1115(r5);
        if (z) {
            m3000(z2, z3, (SyncUserInfoListener) r0, (Runnable) null);
        } else {
            m3000(z2, z3, (SyncUserInfoListener) r0, (Runnable) new C0744(this));
        }
    }

    /* renamed from: ֏ */
    public final void mo9298(String str, UseAppCodeListener r8) {
        Context context = this.f3170;
        InputContactActivity.m862(context, context.getString(R$string.wpengpay_input_contact_tips), false, 0, 0, new C0747(this, str, r8));
    }

    /* renamed from: ֏ */
    public final void mo9296(InputContactActivity inputContactActivity, UseAppCodeListener r5) {
        C0915 r0 = new C0915(inputContactActivity);
        r0.mo8905(R$string.error_app_code_used);
        r0.f2469 = false;
        r0.mo8898(R$string.pw_cancel);
        r0.mo8906(R$string.pw_ok, (OnDialogClickListener) new AppOrderHandler(this, inputContactActivity, r5));
        r0.mo8910();
    }

    /* renamed from: ֏ */
    public void mo9297(OnDialogClickListener r9, OnDialogClickListener r10) {
        String str;
        int i = this.f3171;
        if (i >= 0) {
            Context context = this.f3170;
            C0915 r2 = new C0915(context);
            r2.f2469 = false;
            r2.mo8909(R$string.wpengpay_sync_error_title);
            r2.mo8900(R$string.pw_cancel, r9);
            int i2 = R$string.wpengpay_dialog_text;
            Object[] objArr = new Object[3];
            if (i == 0) {
                str = Utils.m1864(R$string.wpengpay_sync_error_default, new Object[0]);
            } else if (i == 1) {
                str = Utils.m1864(R$string.wpengpay_sync_error_server, new Object[0]);
            } else if (i == 2) {
                str = Utils.m1864(R$string.wpengpay_sync_error_network, new Object[0]);
            } else if (i == 3) {
                str = Utils.m1864(R$string.wpengpay_sync_error_user_id, new Object[0]);
            } else if (i != 4) {
                str = BidiFormatter.EMPTY_STRING;
            } else {
                str = Utils.m1864(R$string.error_maintain, new Object[0]);
            }
            objArr[0] = str;
            objArr[1] = C0771.m2071();
            objArr[2] = C0771.m2075();
            r2.mo8902((CharSequence) context.getString(i2, objArr), 19);
            if (r10 != null) {
                r2.mo8906(R$string.wpengpay_retry, r10);
            }
            C0936.m2467(r2.mo8896());
        }
    }

    /* renamed from: com.wpengapp.support.ય$֏ */
    /* compiled from: AppOrderHandler */
    private class C1115 extends SyncUserInfoListener {

        /* renamed from: ֏ */
        public QueryCallback f3174;

        public C1115(QueryCallback r2) {
            this.f3174 = r2;
        }

        /* renamed from: ֏ */
        public void mo8101(UserInfo r5) {
            ProgressDialog progressDialog = C1114.this.f3169;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            C1114 r0 = C1114.this;
            r0.f3171 = -1;
            r0.f3172 = r5;
            if (this.f3174 != null) {
                if (C0536.m1313(r5)) {
                    this.f3174.mo8024(C1114.this.f3173, true, true, 0);
                    return;
                }
                int r52 = C0536.m1308(r5);
                if (r52 > 0) {
                    this.f3174.mo8024(C1114.this.f3173, true, false, r52);
                } else {
                    this.f3174.mo8024(C1114.this.f3173, true, false, 0);
                }
            }
        }

        /* renamed from: ֏ */
        public void mo8100(int i) {
            ProgressDialog progressDialog = C1114.this.f3169;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            C1114 r0 = C1114.this;
            r0.f3171 = i;
            r0.f3172 = null;
            QueryCallback r3 = this.f3174;
            if (r3 != null) {
                r3.mo8024(r0.f3173, false, false, 0);
            }
        }
    }

    /* renamed from: ؠ */
    public static String m3001(UserInfo r6) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (C0536.m1313(r6) || C0536.m1322()) {
            str = Utils.m1864(R$string.wpengpay_version_pro, new Object[0]);
        } else {
            str = Utils.m1864(R$string.wpengpay_version_normal, new Object[0]);
        }
        sb.append(Utils.m1864(R$string.wpengpay_pay_info_state, str));
        sb.append("   ");
        sb.append(Utils.m1864(R$string.wpengpay_pay_info_order, r6 == null ? Utils.m1864(R$string.wpengpay_pay_info_load_fail, new Object[0]) : r6.f2120));
        return sb.toString();
    }

    /* renamed from: ֏ */
    public static void m3000(boolean z, boolean z2, SyncUserInfoListener r4, Runnable runnable) {
        if (r4 != null) {
            if (!z) {
                UserInfo r2 = C0536.m1309();
                if (((z2 || !NetworkUtils.m1800()) && C0536.m1307(r2)) || C0536.m1313(r2)) {
                    r4.mo8101(r2);
                    return;
                } else if (C0536.m1308(r2) > 0 || C0536.m1322()) {
                    r4.mo8101(r2);
                    C0536.m1306(true, (SyncUserInfoListener) null);
                    return;
                }
            }
            if (runnable != null) {
                runnable.run();
            }
            C0536.m1306(false, r4);
        }
    }

    /* renamed from: ֏ */
    public static void m2999(Context context, String str) {
        C0915 r0 = new C0915(context);
        r0.f2469 = false;
        r0.mo8909(R$string.wpengpay_pay_fail);
        r0.mo8902((CharSequence) context.getString(R$string.wpengpay_dialog_text, new Object[]{str, C0771.m2071(), C0771.m2075()}), 19);
        r0.mo8898(R$string.pw_ok);
        C0936.m2467(r0.mo8896());
    }
}
