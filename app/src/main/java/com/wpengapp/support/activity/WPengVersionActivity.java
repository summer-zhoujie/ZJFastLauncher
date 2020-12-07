package com.wpengapp.support.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.support.C0497;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0678;
import com.wpengapp.support.C0771;
import com.wpengapp.support.C0784;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0936;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1211;
import com.wpengapp.support.C1279;
import com.wpengapp.support.C1307;
import com.wpengapp.support.HtmlTextHelper;
import com.wpengapp.support.NetworkUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$menu;
import com.wpengapp.support.R$string;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.activity.AboutActivity;
import com.wpengapp.support.model.GzhConfig;
import com.wpengapp.support.outline;

public class WPengVersionActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public TextView f648;

    /* renamed from: ؠ */
    public TextView f649;

    /* renamed from: ހ */
    public TextView f650;

    /* renamed from: ށ */
    public TextView f651;

    /* renamed from: ނ */
    public TextView f652;

    /* renamed from: ރ */
    public TextView f653;

    /* renamed from: ބ */
    public View f654;

    /* renamed from: ޅ */
    public View f655;

    /* renamed from: ކ */
    public View f656;

    /* renamed from: އ */
    public C1114 f657;

    /* renamed from: ވ */
    public ItemView f658;

    /* renamed from: މ */
    public UserInfo f659;

    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.tv_alipay) {
            mo7845(7);
        } else if (id == R$id.tv_wechat) {
            mo7845(6);
        } else if (id == R$id.tv_app_code) {
            View inflate = View.inflate(this, R$layout.pw_dialog_app_code, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R$id.edit_app_code);
            C1279.m3412((TextView) inflate.findViewById(R$id.tv_msg), (CharSequence) getString(R$string.wpengpay_app_code_intro, new Object[]{C0771.m2073()}), (HtmlTextHelper) new C0497(this));
            C0915 r1 = new C0915(this);
            r1.f2463 = inflate;
            r1.mo8898(R$string.pw_cancel);
            r1.mo8906(R$string.wpengpay_app_code_use, (OnDialogClickListener) new C1211(this, editText));
            r1.mo8896().show();
            inflate.postDelayed(new C0784(this, editText), 100);
        } else if (id == R$id.item_email) {
            C0771.m2065(this);
        } else if (id == R$id.item_qq) {
            C0771.m2074(this);
        } else if (id == R$id.tv_newuser) {
            this.f651.setVisibility(8);
            this.f652.setVisibility(0);
            this.f653.setVisibility(0);
        } else if (id == R$id.tv_olduser) {
            mo7846();
        } else if (id == R$id.tv_gzh) {
            WechatSubscriptionActivity.m839(this, "AppCodeActivity");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Boolean.FALSE.toString().equals(C1063.m2859("enable_full", "true"))) {
            finish();
            return;
        }
        setContentView(R$layout.pw_activity_version_info);
        int i = 0;
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        this.f648 = (TextView) findViewById(R$id.tv_status);
        this.f654 = findViewById(R$id.item_title_detail);
        this.f655 = findViewById(R$id.layout_pay);
        this.f656 = findViewById(R$id.layout_pay_types);
        if ("0".equals(C1063.m2859("sp_fullpy", "1"))) {
            this.f656.setVisibility(8);
        }
        this.f650 = (TextView) findViewById(R$id.tv_full_notice);
        this.f649 = (TextView) findViewById(R$id.tv_notice);
        this.f651 = (TextView) findViewById(R$id.tv_newuser);
        this.f652 = (TextView) findViewById(R$id.tv_alipay);
        this.f653 = (TextView) findViewById(R$id.tv_wechat);
        if (getPackageName().equals("com.wpengapp.admin")) {
            this.f648.setOnLongClickListener(new C0496(this));
        }
        this.f659 = C0536.m1309();
        this.f657 = new C1114(this);
        UserInfo r5 = this.f659;
        if (r5 == null) {
            mo7441();
            this.f657.mo9299(false, true, false, (QueryCallback) new WPengVersionActivity(this));
        } else {
            mo7844(r5);
            this.f657.mo9299(true, true, false, (QueryCallback) new C0525(this));
        }
        this.f658 = (ItemView) findViewById(R$id.item_qq);
        this.f658.setDes((CharSequence) C0771.m2075());
        ((ItemView) findViewById(R$id.item_email)).setDes((CharSequence) C0771.m2071());
        View findViewById = findViewById(R$id.tv_gzh);
        if (!GzhConfig.getConfig().appCode) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        C0771.m2067((Context) this, (C0771.C0772) new C0807(this));
        return false;
    }

    public void onResume() {
        super.onResume();
        UserInfo r0 = this.f657.f3172;
        if (r0 != null) {
            mo7844(r0);
        }
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return true;
    }

    /* renamed from: ށ */
    public final void mo7845(int i) {
        UserInfo r0 = this.f657.f3172;
        if (r0 == null || r0.f2127 || System.currentTimeMillis() - r0.f2117 > 300000) {
            if (!NetworkUtils.m1800()) {
                mo7424(R$string.pw_network_error);
            } else {
                this.f657.mo9299(false, true, false, (QueryCallback) new C0988(this, i));
            }
        } else if (C0536.m1313(r0) || C0536.m1322()) {
            mo7844(r0);
            mo7413(R$string.wpengpay_pay_success);
        } else {
            mo7842(i, r0);
        }
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.share_dark;
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back_dark);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public final void mo7846() {
        UserInfo r0 = this.f657.f3172;
        if (r0 == null || r0.f2127 || System.currentTimeMillis() - r0.f2117 > 300000) {
            if (!NetworkUtils.m1800()) {
                mo7424(R$string.pw_network_error);
            } else {
                this.f657.mo9299(false, true, false, (QueryCallback) new C0515(this));
            }
        } else if (C0536.m1313(r0)) {
            mo7844(r0);
            mo7413(R$string.wpengpay_pay_success);
        } else {
            mo7843(r0);
        }
    }

    /* renamed from: ؠ */
    public final void mo7844(UserInfo r5) {
        String str;
        this.f659 = r5;
        mo7446();
        if (C0536.m1313(r5) || C0536.m1322()) {
            String string = getString(R$string.wpengpay_is_full);
            if (r5 != null && r5.f2125) {
                StringBuilder r52 = outline.m2550(string, " ");
                r52.append(getString(R$string.wpengpay_can_change_device));
                string = r52.toString();
            }
            this.f648.setText(string);
            this.f654.setVisibility(8);
            this.f655.setVisibility(8);
            this.f650.setVisibility(0);
            this.f650.setText(Html.fromHtml(getString(R$string.wpengpay_pro_notice_paid)));
            return;
        }
        this.f648.setText(R$string.wpengpay_upgrade_notice);
        this.f654.setVisibility(0);
        this.f655.setVisibility(0);
        this.f650.setVisibility(8);
        if (r5 == null) {
            str = "-2";
        } else {
            str = r5.f2120;
        }
        String string2 = getString(R$string.wpengpay_pro_notice, new Object[]{str});
        String r0 = C1063.m2859("special_full_intro", (String) null);
        if (r0 == null) {
            AboutActivity.C0450 r02 = AboutActivity.f616;
            r0 = r02 == null ? BidiFormatter.EMPTY_STRING : r02.mo7560();
        }
        if (!TextUtils.isEmpty(r0)) {
            string2 = outline.m2545(r0, "\n", string2);
        }
        this.f649.setText(string2);
    }

    /* renamed from: ֏ */
    public static void m821(Context context) {
        SystemUtils.m3510(context, new Intent(context, WPengVersionActivity.class));
    }

    /* renamed from: ֏ */
    public final void mo7843(UserInfo r3) {
        if (!C1307.m3564()) {
            C1279.m3410((Context) this, r3);
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R$string.pw_wait));
        progressDialog.setCancelable(false);
        C0936.m2467(progressDialog);
        C1307.m3560(new C1227(this, progressDialog, r3));
    }

    /* renamed from: ֏ */
    public final void mo7842(int i, UserInfo r5) {
        int i2;
        boolean r0 = r5.mo8706(i);
        if (!r0 && i == 7 && r5.mo8706(1)) {
            i = 1;
            r0 = true;
        }
        if (!r0) {
            int i3 = R$string.wpengpay_not_support;
            Object[] objArr = new Object[3];
            if (C0678.m1733(i)) {
                i2 = R$string.wpengpay_alipay;
            } else {
                i2 = R$string.wpengpay_wechat;
            }
            objArr[0] = getString(i2);
            objArr[1] = C0771.m2078();
            objArr[2] = C0771.m2073();
            String string = getString(i3, objArr);
            C0915 r52 = new C0915(this);
            r52.mo8902((CharSequence) string, 19);
            C1030 r4 = new C1030(this);
            r52.f2479 = true;
            r52.f2480 = r4;
            r52.mo8898(R$string.pw_ok);
            r52.mo8896().show();
            return;
        }
        C0678.m1725((Activity) this, i, r5, (C0678.C0680) new C1237(this));
    }
}
