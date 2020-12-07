package com.wpengapp.lightstart.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.C0903;
import com.wpengapp.support.C1063;
import com.wpengapp.support.activity.FeedbackActivity;
import com.wpengapp.support.activity.WPengBaseActivity;

public class AutoLoginGuideActivity extends WPengBaseActivity {
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_auto_login_guide);
        mo7434().setBackgroundColor(0);
        findViewById(2131165487).setVisibility(4);
        TextView textView = (TextView) findViewById(2131165552);
        String r0 = C1063.m2859("skad_auto_login_tips", (String) null);
        if (TextUtils.isEmpty(r0)) {
            textView.setText(R$string.auto_login_tips_des);
        } else {
            textView.setText(r0);
        }
        findViewById(R$id.tv_feedback).setOnClickListener(new C0903(this));
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7607(View view) {
        FeedbackActivity.m795(this);
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
