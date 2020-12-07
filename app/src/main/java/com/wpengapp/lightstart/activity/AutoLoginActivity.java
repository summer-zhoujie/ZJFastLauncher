package com.wpengapp.lightstart.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.config.DefaultConfig;
import com.wpengapp.support.AppConfig;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.AutoLoginConfig;
import com.wpengapp.support.C0564;
import com.wpengapp.support.C0567;
import com.wpengapp.support.C0625;
import com.wpengapp.support.C0823;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0981;
import com.wpengapp.support.C0982;
import com.wpengapp.support.C1057;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1116;
import com.wpengapp.support.C1121;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1249;
import com.wpengapp.support.C1258;
import com.wpengapp.support.C1259;
import com.wpengapp.support.C1323;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.PageConfig;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.activity.FeedbackActivity;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.outline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class AutoLoginActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public C1114 f429;

    /* renamed from: com.wpengapp.lightstart.activity.AutoLoginActivity$֏ */
    private static class C0438 {

        /* renamed from: ֏ */
        public String f430;

        /* renamed from: ؠ */
        public Drawable f431;

        /* renamed from: ހ */
        public String f432;

        public C0438(String str, Drawable drawable, String str2) {
            this.f430 = str;
            if (drawable == null) {
                this.f431 = AppUtils.getApplication().getDrawable(2131099733);
            } else {
                this.f431 = drawable;
            }
            if (TextUtils.isEmpty(str2)) {
                this.f432 = str;
            } else {
                this.f432 = str2;
            }
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ boolean m408(CompoundButton compoundButton, boolean z) {
        T t = (AutoLoginConfig) C1057.f3020.mo9612();
        if (t == null) {
            t = new AutoLoginConfig();
        }
        t.f3552 = z;
        C1323<AutoLoginConfig> r2 = C1057.f3020;
        r2.f3785 = t;
        r2.f3791 = true;
        outline.m2551((C1323) r2, (Object) t);
        return false;
    }

    /* renamed from: ؠ */
    public static /* synthetic */ boolean m410(CompoundButton compoundButton, boolean z) {
        T t = (AutoLoginConfig) C1057.f3020.mo9612();
        if (t == null) {
            t = new AutoLoginConfig();
        }
        t.f3553 = z;
        C1323<AutoLoginConfig> r2 = C1057.f3020;
        r2.f3785 = t;
        r2.f3791 = true;
        outline.m2551((C1323) r2, (Object) t);
        return false;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_auto_login);
        mo7434().setBackgroundColor(0);
        findViewById(2131165487).setVisibility(4);
        this.f429 = new C1114(this);
        findViewById(2131165518).setOnClickListener(new C1258(this));
        findViewById(R$id.tv_feedback).setOnClickListener(new C1116(this));
        ItemView itemView = (ItemView) findViewById(R$id.item_locked);
        AutoLoginConfig r1 = C1057.f3020.mo9612();
        if (r1 == null) {
            z = false;
        } else {
            z = r1.f3552;
        }
        itemView.setChecked(z);
        itemView.setOnCheckedChangeListener(C0982.f2752);
        ItemView itemView2 = (ItemView) findViewById(R$id.item_toast);
        AutoLoginConfig r12 = C1057.f3020.mo9612();
        if (r12 == null) {
            z2 = true;
        } else {
            z2 = r12.f3553;
        }
        itemView2.setChecked(z2);
        itemView2.setOnCheckedChangeListener(C0564.f1197);
        findViewById(R$id.item_sync_msg).setOnClickListener(C0625.f1594);
        findViewById(R$id.item_support_more).setOnClickListener(new C1249(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0438("com.tencent.mm", ContextCompat.getDrawable(this, 2131099795), getString(R$string.auto_login_wechat)));
        arrayList.add(new C0438("com.tencent.mobileqq", ContextCompat.getDrawable(this, 2131099792), getString(R$string.auto_login_qq)));
        DefaultConfig r13 = C1149.m3083();
        if (!CollectionUtils.m1658((Map) r13.configData)) {
            for (Map.Entry next : r13.configData.entrySet()) {
                String str = (String) next.getKey();
                AppConfig r2 = (AppConfig) next.getValue();
                if (!"com.tencent.mm".equals(str) && !"com.tencent.mobileqq".equals(str) && r2 != null && !CollectionUtils.m1658((Map) r2.f3019)) {
                    Iterator<PageConfig> it = r2.f3019.values().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().mo9158()) {
                                arrayList.add(new C0438(str, SystemUtils.m3508(str), SystemUtils.m3519(str)));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.layout_content);
        linearLayout.removeAllViews();
        for (int i = 0; i < arrayList.size(); i++) {
            C0438 r22 = (C0438) arrayList.get(i);
            View inflate = View.inflate(this, R$layout.item_auto_login, (ViewGroup) null);
            ((ImageView) inflate.findViewById(2131165311)).setImageDrawable(r22.f431);
            ((TextView) inflate.findViewById(2131165554)).setText(r22.f432);
            SwitchButton switchButton = (SwitchButton) inflate.findViewById(2131165475);
            switchButton.setChecked(C1057.m2854(r22.f430));
            inflate.setOnClickListener(new C0823(switchButton));
            switchButton.setOnCheckedChangeListener(new C1121(this, r22, switchButton));
            linearLayout.addView(inflate, -1, -2);
        }
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7604(View view) {
        mo7420((Class<?>) AutoLoginGuideActivity.class);
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7605(View view) {
        FeedbackActivity.m795(this);
    }

    /* renamed from: ރ */
    public /* synthetic */ void mo7606(View view) {
        mo7420((Class<?>) CustomActivity.class);
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

    /* renamed from: ֏ */
    public /* synthetic */ void mo7603(C0438 r3, SwitchButton switchButton, CompoundButton compoundButton, boolean z) {
        String str = r3.f430;
        T t = (AutoLoginConfig) C1057.f3020.mo9612();
        if (t == null) {
            t = new AutoLoginConfig();
        }
        if (t.f3551 == null) {
            t.f3551 = new ArrayMap<>();
        }
        "setAutoLogin " + str + ": " + z;
        AutoLoginConfig.C1256 r0 = new AutoLoginConfig.C1256();
        r0.f3554 = z;
        t.f3551.put(str, r0);
        C1323<AutoLoginConfig> r32 = C1057.f3020;
        r32.f3785 = t;
        r32.f3791 = true;
        outline.m2551((C1323) r32, (Object) t);
        if (z) {
            AppUtils.m1146((Runnable) new C0567(this, switchButton));
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7601(SwitchButton switchButton) {
        this.f429.mo9299(false, false, false, (QueryCallback) new C0981(this, switchButton));
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7602(SwitchButton switchButton, C1114 r2, boolean z, boolean z2, int i) {
        if (!z2 && switchButton.isChecked()) {
            switchButton.setChecked(false);
            C0915 r1 = new C0915(this);
            r1.mo8909(2131493337);
            r1.mo8902((CharSequence) getString(2131493346, new Object[]{SystemUtils.m3519(getPackageName())}), 19);
            r1.mo8898(2131493347);
            r1.mo8906(2131493370, (OnDialogClickListener) C1259.f3557);
            r1.mo8910();
        }
    }
}
