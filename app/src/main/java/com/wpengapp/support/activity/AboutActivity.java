package com.wpengapp.support.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.support.ApiConstant;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseApplication;
import com.wpengapp.support.C0536;
import com.wpengapp.support.C0760;
import com.wpengapp.support.C0771;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C1063;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1138;
import com.wpengapp.support.C1279;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$menu;
import com.wpengapp.support.R$string;
import com.wpengapp.support.RetCallback;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.UpdateHelper;
import com.wpengapp.support.UserInfo;
import com.wpengapp.support.Utils;
import com.wpengapp.support.model.App;
import com.wpengapp.support.model.GzhConfig;
import com.wpengapp.support.outline;
import com.wpengapp.support.permission.RequestPermissionHelper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class AboutActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public static C0450 f616;

    /* renamed from: ؠ */
    public ItemView f617;

    /* renamed from: ހ */
    public TextView f618;

    /* renamed from: ށ */
    public TextView f619;

    /* renamed from: ނ */
    public View f620;

    /* renamed from: ރ */
    public View f621;

    /* renamed from: ބ */
    public UserInfo f622;

    /* renamed from: ޅ */
    public C1114 f623;

    /* renamed from: com.wpengapp.support.activity.AboutActivity$֏ */
    public static class C0450 {
        /* renamed from: ֏ */
        public List<File> mo7558() {
            throw null;
        }

        /* renamed from: ؠ */
        public Drawable mo7559() {
            throw null;
        }

        /* renamed from: ހ */
        public String mo7560() {
            throw null;
        }

        /* renamed from: ށ */
        public String mo7561() {
            throw null;
        }

        /* renamed from: ނ */
        public void mo7821() {
        }

        /* renamed from: ރ */
        public void mo7822() {
        }

        /* renamed from: ބ */
        public boolean mo7562() {
            throw null;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        boolean z = false;
        if (id == R$id.item_user_id) {
            UserInfo r7 = this.f622;
            if (r7 == null) {
                mo7819(false);
                return;
            }
            SystemUtils.m3513((CharSequence) r7.f2120);
            C0826.m2180((CharSequence) getString(R$string.pw_copy_success) + "\n" + this.f622.f2120);
        } else if (id == R$id.tv_version_info || id == R$id.layout_top) {
            if (this.f622 == null) {
                mo7819(false);
                return;
            }
            boolean equals = "true".equals(C1063.m2859("enable_user_upgrade", "true"));
            if ("1".equals(C1063.m2859("sp_fullpycd", "1")) && equals && this.f622.mo8705() && !this.f622.f2125) {
                z = true;
            }
            if (z) {
                mo7420((Class<?>) UserUpgradeActivity.class);
            } else {
                mo7420((Class<?>) WPengVersionActivity.class);
            }
        } else if (id == R$id.item_check_update) {
            if (UpdateHelper.m742()) {
                UpdateHelper.m741(true, false, (UpdateHelper.C0447) new C1231(this));
            } else {
                C0771.m2076(this);
            }
        } else if (id == R$id.item_version_intro) {
            CommonWebActivity.m783(this, ApiConstant.m2593() + "/" + C1279.m3425().toLowerCase() + "/v", (String) null);
        } else if (id == R$id.item_grade) {
            C0771.m2076(this);
        } else if (id == R$id.item_email) {
            C0771.m2065(this);
        } else if (id == R$id.item_qq) {
            C0771.m2074(this);
        } else if (id == R$id.item_gzh) {
            WechatSubscriptionActivity.m839(this, "About");
        } else if (id == R$id.item_send_log) {
            if (!RequestPermissionHelper.m902()) {
                mo7431(R$string.pw_wait);
                TaskManager.m2715((Runnable) new C0663(this));
            }
        } else if (id == R$id.item_privacy) {
            int r0 = C0826.m2168(180.0f);
            CharSequence[] charSequenceArr = {getString(R$string.pw_privacy2), getString(R$string.pw_privacy1)};
            C0915 r2 = new C0915(this);
            C1138 r3 = new C1138(this);
            r2.f2474 = Arrays.asList(charSequenceArr);
            r2.f2475 = r3;
            r2.f2476 = -1;
            r2.f2481 = r0;
            r2.mo8908().showAsDropDown(view, (view.getWidth() - r0) - C0826.m2168(4.0f), ((-view.getHeight()) / 2) - C0826.m2168(16.0f));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_about);
        int i = 0;
        mo7434().setBackgroundColor(0);
        findViewById(R$id.toolbarLine).setVisibility(4);
        ImageView imageView = (ImageView) findViewById(R$id.img_app);
        C0450 r1 = f616;
        imageView.setImageDrawable(r1 == null ? SystemUtils.m3508(AppUtils.m1163()) : r1.mo7559());
        ((TextView) findViewById(R$id.tv_app_name)).setText(SystemUtils.m3519(getPackageName()) + " - V" + AppUtils.m1159());
        this.f618 = (TextView) findViewById(R$id.tv_version_info);
        this.f619 = (TextView) findViewById(R$id.tv_contact);
        this.f619.setOnClickListener(new C1178(this));
        this.f620 = findViewById(R$id.layout_user_upgrade);
        this.f621 = findViewById(R$id.view_user_upgrade_dot);
        this.f617 = (ItemView) findViewById(R$id.item_user_id);
        ((TextView) findViewById(R$id.tv_copyright)).setText(C1063.m2859("app_copyright", getString(R$string.pw_copyright)));
        ((ItemView) findViewById(R$id.item_qq)).setDes((CharSequence) C0771.m2075());
        ((ItemView) findViewById(R$id.item_email)).setDes((CharSequence) C0771.m2071());
        ItemView itemView = (ItemView) findViewById(R$id.item_gzh);
        if (GzhConfig.getConfig().about) {
            itemView.setVisibility(0);
            itemView.setDes((CharSequence) GzhConfig.getConfig().intro);
            itemView.setTitle((CharSequence) getString(R$string.pw_gzh) + ": " + GzhConfig.getConfig().name);
        } else {
            itemView.setVisibility(8);
        }
        View findViewById = findViewById(R$id.item_version_intro);
        C0450 r12 = f616;
        findViewById.setVisibility((r12 == null || !r12.mo7562()) ? 8 : 0);
        View findViewById2 = findViewById(R$id.item_privacy);
        if (!BaseApplication.f561.mo7555()) {
            i = 8;
        }
        findViewById2.setVisibility(i);
        this.f623 = new C1114(this);
        if ("anzhi".equals(Utils.m1901((Context) this))) {
            this.f618.setVisibility(8);
        }
        findViewById(R$id.img_app).setOnClickListener(new C0760(this));
        if (UpdateHelper.m743() != null) {
            ((ItemView) findViewById(R$id.item_check_update)).setEnterIcon(R$drawable.pw_icon_new);
        } else {
            UpdateHelper.m738((RetCallback<App.AppVersion>) new com.wpengapp.support.AboutActivity(this));
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        C0771.m2067((Context) this, (C0771.C0772) new C1274(this));
        return false;
    }

    public void onResume() {
        super.onResume();
        mo7819(true);
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return true;
    }

    /* renamed from: ހ */
    public final void mo7819(boolean z) {
        this.f617.setDes(R$string.wpengpay_pay_info_loading);
        this.f618.setText(R$string.wpengpay_pay_info_loading);
        this.f622 = C0536.m1309();
        UserInfo r0 = this.f622;
        if (r0 == null) {
            this.f623.mo9299(z, false, false, (QueryCallback) new C1209(this, z));
        } else {
            mo7817(r0);
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
    public final void mo7820() {
        StringBuilder r0 = outline.m2549("Channel: ");
        r0.append(Utils.m1901((Context) this));
        r0.append("\nBuild: ");
        r0.append(BaseApplication.m705());
        r0.append("\nTrial: ");
        r0.append(C0536.m1308(this.f622));
        String sb = r0.toString();
        C0915 r1 = new C0915(this);
        r1.f2470 = false;
        r1.mo8902((CharSequence) sb, 19);
        r1.mo8910();
    }

    /* renamed from: ֏ */
    public static void m760(Context context) {
        SystemUtils.m3510(context, new Intent(context, AboutActivity.class));
    }

    /* renamed from: ֏ */
    public final void mo7817(UserInfo r6) {
        String str;
        this.f617.setDes((CharSequence) r6.f2120);
        TextView textView = this.f618;
        int i = 0;
        if (C0536.m1313(r6) || C0536.m1322()) {
            str = Utils.m1864(R$string.wpengpay_is_full, new Object[0]);
            if (r6.f2125) {
                StringBuilder r1 = outline.m2550(str, " ");
                r1.append(Utils.m1864(R$string.wpengpay_can_change_device, new Object[0]));
                str = r1.toString();
            }
        } else {
            str = Utils.m1864(R$string.wpengpay_unlock_full, new Object[0]);
        }
        textView.setText(str);
        mo7818(r6.f2126, false);
        boolean z = "1".equals(C1063.m2859("sp_fullpycd", "1")) && "true".equals(C1063.m2859("enable_user_upgrade", "true")) && r6.mo8705() && !r6.f2125;
        View view = this.f620;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        if (z) {
            C0536.m1323();
            this.f621.setVisibility(8);
        }
    }

    /* renamed from: ֏ */
    public final void mo7818(String str, boolean z) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            this.f619.setVisibility(8);
            return;
        }
        this.f619.setVisibility(0);
        if (!z) {
            str2 = C0826.m2171(str) + " " + getString(R$string.pw_clear_show);
        } else {
            str2 = str;
        }
        if (C0826.m2181(str)) {
            str3 = getString(R$string.pw_bind_mail, new Object[]{str2});
        } else {
            str3 = getString(R$string.pw_bind_mobile, new Object[]{str2});
        }
        this.f619.setText(str3);
    }
}
