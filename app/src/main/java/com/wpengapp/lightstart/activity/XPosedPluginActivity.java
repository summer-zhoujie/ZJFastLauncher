package com.wpengapp.lightstart.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.ViewCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.C0604;
import com.wpengapp.support.C0977;
import com.wpengapp.support.FileManager;
import com.wpengapp.support.FileUtils;
import com.wpengapp.support.SystemApi;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.io.File;

public class XPosedPluginActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public int f476;

    /* renamed from: ؠ */
    public TextView f477;

    /* renamed from: ֏ */
    public static void m568(Activity activity, int i) {
        Intent intent = new Intent(activity, XPosedPluginActivity.class);
        intent.putExtra(NotificationCompat.CATEGORY_STATUS, i);
        activity.startActivity(intent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_xposed_plugin);
        mo7434().setBackgroundColor(0);
        findViewById(2131165487).setVisibility(4);
        this.f476 = getIntent().getIntExtra(NotificationCompat.CATEGORY_STATUS, 1);
        if (this.f476 == 0) {
            finish();
            return;
        }
        findViewById(R$id.tv_i_know).setOnClickListener(new C0604(this));
        TextView textView = (TextView) findViewById(2131165554);
        int i = this.f476;
        if (i == 1) {
            textView.setText(R$string.xposed_plugin_title_ins);
        } else if (i == 2) {
            textView.setText(R$string.xposed_plugin_title_upt);
        } else if (i == 3) {
            textView.setText(R$string.xposed_plugin_title_act);
        }
        this.f477 = (TextView) findViewById(R$id.tv_install);
        TextView textView2 = (TextView) findViewById(R$id.tv_act_tips);
        String r2 = SystemUtils.m3519(SystemApi.m2052());
        if (TextUtils.isEmpty(r2)) {
            r2 = getString(R$string.xposed_systemui_app_name);
        }
        textView2.setText(Html.fromHtml(getString(R$string.xposed_plugin_act, new Object[]{r2})));
    }

    public void onStart() {
        super.onStart();
        int r0 = SystemApi.m2044((Context) this);
        if (r0 == 1 || r0 == 2) {
            this.f477.setOnClickListener(new C0977(this));
            this.f477.setText(R$string.xposed_plugin_ins);
            this.f477.setTextColor(-1);
            this.f477.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f477.setTextSize(14.0f);
            return;
        }
        this.f477.setOnClickListener((View.OnClickListener) null);
        this.f477.setText(R$string.xposed_plugin_installed);
        this.f477.setTextColor(ContextCompat.getColor(this, 2130968753));
        this.f477.setBackgroundColor(0);
        this.f477.setTextSize(18.0f);
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7696(View view) {
        findViewById(R$id.layout_warning).setVisibility(8);
        findViewById(R$id.layout_install).setVisibility(0);
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7697(View view) {
        try {
            File file = new File(FileManager.m1198(), "xp.apk");
            if (file.exists()) {
                file.delete();
            }
            FileUtils.m1129(getAssets().open(SystemApi.m2053()), file);
            FileManager.m1197(file);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, 2131099746);
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return null;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }
}
