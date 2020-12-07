package com.wpengapp.lightstart.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.wpengapp.lightstart.R$drawable;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.CustomAppAdaptor;
import com.wpengapp.support.C0640;
import com.wpengapp.support.C0660;
import com.wpengapp.support.C0664;
import com.wpengapp.support.C0724;
import com.wpengapp.support.C0817;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0850;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0936;
import com.wpengapp.support.C1032;
import com.wpengapp.support.C1038;
import com.wpengapp.support.C1114;
import com.wpengapp.support.C1149;
import com.wpengapp.support.C1253;
import com.wpengapp.support.C1254;
import com.wpengapp.support.C1281;
import com.wpengapp.support.CountLimitHelper;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.QueryCallback;
import com.wpengapp.support.SystemUtils;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.activity.FeedbackActivity;
import com.wpengapp.support.activity.WPengBaseActivity;
import com.wpengapp.support.permission.ServicePermissionActivity;
import java.util.List;

public class CustomActivity extends WPengBaseActivity {
    public RecyclerView mRecyclerView;

    /* renamed from: ֏ */
    public CustomAppAdaptor f433;

    /* renamed from: ؠ */
    public TextView f434;

    /* renamed from: ހ */
    public TextView f435;

    /* renamed from: ށ */
    public C1114 f436;

    /* renamed from: ނ */
    public boolean f437;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_custom_rule);
        mo7434().setBackgroundColor(-570425345);
        findViewById(2131165487).setVisibility(4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.f433 = new CustomAppAdaptor(this);
        View r5 = this.f433.mo9176(R$layout.view_custom_rule_header, this.mRecyclerView);
        this.mRecyclerView.setAdapter(this.f433);
        this.f434 = (TextView) r5.findViewById(R$id.tv_create);
        this.f435 = (TextView) r5.findViewById(2131165552);
        findViewById(R$id.tv_feedback).setOnClickListener(new C0817(this));
        findViewById(2131165518).setOnClickListener(new C0640(this));
        this.f436 = new C1114(this);
        this.f436.mo9299(true, false, false, (QueryCallback) null);
        this.f437 = getIntent().getBooleanExtra("autostart", false);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mo7621();
    }

    public void onResume() {
        super.onResume();
        mo7621();
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7609(List list) {
        this.f433.mo9058(list);
    }

    /* renamed from: ؠ */
    public /* synthetic */ void mo7610(View view) {
        mo7623();
    }

    /* renamed from: ހ */
    public /* synthetic */ void mo7611(View view) {
        FeedbackActivity.m795(this);
    }

    /* renamed from: ށ */
    public /* synthetic */ void mo7612(View view) {
        mo7420((Class<?>) CustomGuideActivity.class);
    }

    /* renamed from: ނ */
    public /* synthetic */ void mo7613(View view) {
        if (!CountLimitHelper.m997("mTvCreate", 600)) {
            mo7617();
        }
    }

    /* renamed from: ރ */
    public /* synthetic */ void mo7614(View view) {
        if (!CountLimitHelper.m997("mTvCreate", 600)) {
            mo7623();
        }
    }

    /* renamed from: ބ */
    public /* synthetic */ void mo7615(View view) {
        mo7617();
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, 2131099746);
    }

    /* renamed from: ކ */
    public /* synthetic */ boolean mo7616(View view) {
        mo7622();
        return false;
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
    public final void mo7617() {
        C1032.m2756();
        this.f434.setBackgroundResource(R$drawable.bg_create_rule);
        this.f434.setText(R$string.custom_float_enable);
        this.f434.setOnClickListener(new C0660(this));
        this.f435.setVisibility(8);
    }

    /* renamed from: ޏ */
    public final void mo7618() {
        if (!ServicePermissionActivity.m913()) {
            C0936.m2467(ServicePermissionActivity.m907((Context) this));
        } else if (C1032.m2769()) {
            C0915 r0 = new C0915(this);
            r0.f2469 = false;
            r0.mo8905(R$string.custom_screencap_tips);
            r0.mo8900(2131493077, (OnDialogClickListener) null);
            r0.mo8906(2131493159, (OnDialogClickListener) new C1254(this));
            r0.mo8910();
        } else {
            mo7622();
        }
    }

    /* renamed from: ސ */
    public /* synthetic */ void mo7619() {
        this.f434.performClick();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b4, code lost:
        if ((r4.f484.getIntrinsicHeight() * r3.getIntrinsicWidth()) > 250000) goto L_0x00b6;
     */
    /* renamed from: ޑ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void mo7620() {
        /*
            r8 = this;
            com.wpengapp.support.ϯ r0 = com.wpengapp.support.C0909.m2390()
            java.util.Map<java.lang.String, com.wpengapp.support.ۈ> r0 = r0.f1747
            boolean r1 = r8.f437
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r8.f437 = r2
            com.wpengapp.support.ĵ r1 = new com.wpengapp.support.ĵ
            r1.<init>(r8)
            r8.runOnUiThread(r1)
        L_0x0015:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00c4
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            if (r4 == 0) goto L_0x0022
            java.lang.Object r4 = r3.getValue()
            com.wpengapp.support.ۈ r4 = (com.wpengapp.support.CustomAppConfig) r4
            java.util.Map<java.lang.String, java.util.List<com.wpengapp.support.և>> r4 = r4.f2437
            boolean r4 = com.wpengapp.support.CollectionUtils.m1658((java.util.Map) r4)
            if (r4 == 0) goto L_0x0043
            goto L_0x0022
        L_0x0043:
            java.lang.Object r4 = r3.getValue()
            com.wpengapp.support.ۈ r4 = (com.wpengapp.support.CustomAppConfig) r4
            java.util.Map<java.lang.String, java.util.List<com.wpengapp.support.և>> r4 = r4.f2437
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
        L_0x0054:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0073
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getValue()
            if (r7 == 0) goto L_0x0054
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            int r6 = r6.size()
            int r6 = r6 + r5
            r5 = r6
            goto L_0x0054
        L_0x0073:
            if (r5 > 0) goto L_0x0076
            goto L_0x0022
        L_0x0076:
            com.wpengapp.lightstart.activity.adaptor.CustomAppAdaptor$֏ r4 = new com.wpengapp.lightstart.activity.adaptor.CustomAppAdaptor$֏
            r4.<init>()
            java.lang.Object r3 = r3.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r4.f482 = r3
            java.lang.String r3 = r4.f482
            java.lang.String r3 = com.wpengapp.support.SystemUtils.m3519((java.lang.String) r3)
            r4.f483 = r3
            java.lang.String r3 = r4.f483
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0097
            java.lang.String r3 = r4.f482
            r4.f483 = r3
        L_0x0097:
            r4.f485 = r5
            java.lang.String r3 = r4.f482     // Catch:{ OutOfMemoryError -> 0x00a1 }
            android.graphics.drawable.Drawable r3 = com.wpengapp.support.SystemUtils.m3508((java.lang.String) r3)     // Catch:{ OutOfMemoryError -> 0x00a1 }
            r4.f484 = r3     // Catch:{ OutOfMemoryError -> 0x00a1 }
        L_0x00a1:
            android.graphics.drawable.Drawable r3 = r4.f484
            if (r3 == 0) goto L_0x00b6
            int r3 = r3.getIntrinsicWidth()
            android.graphics.drawable.Drawable r5 = r4.f484
            int r5 = r5.getIntrinsicHeight()
            int r5 = r5 * r3
            r3 = 250000(0x3d090, float:3.50325E-40)
            if (r5 <= r3) goto L_0x00bf
        L_0x00b6:
            r3 = 2131099733(0x7f060055, float:1.7811828E38)
            android.graphics.drawable.Drawable r3 = android.support.p000v4.content.ContextCompat.getDrawable(r8, r3)
            r4.f484 = r3
        L_0x00bf:
            r1.add(r4)
            goto L_0x0022
        L_0x00c4:
            java.util.Collections.sort(r1)
            com.wpengapp.support.ঽ r0 = new com.wpengapp.support.ঽ
            r0.<init>(r8, r1)
            r8.runOnUiThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.activity.CustomActivity.mo7620():void");
    }

    /* renamed from: ޒ */
    public final void mo7621() {
        if (C1032.m2761()) {
            this.f435.setVisibility(0);
            this.f434.setBackgroundResource(R$drawable.bg_create_rule_stop);
            this.f434.setText(R$string.custom_float_disable);
            this.f434.setOnClickListener(new C1038(this));
            this.f437 = false;
        } else {
            this.f435.setVisibility(8);
            this.f434.setBackgroundResource(R$drawable.bg_create_rule);
            this.f434.setText(R$string.custom_float_enable);
            this.f434.setOnClickListener(new C1281(this));
        }
        TaskManager.m2715((Runnable) new C0850(this));
    }

    /* renamed from: ޓ */
    public final void mo7622() {
        if (!C1032.m2770()) {
            C0826.m2172((int) R$string.custom_enable_fail, new Object[0]);
            return;
        }
        this.f434.setBackgroundResource(R$drawable.bg_create_rule_stop);
        this.f434.setText(R$string.custom_float_disable);
        this.f434.setOnClickListener(new C0724(this));
        this.f435.setVisibility(0);
    }

    /* renamed from: ޔ */
    public final void mo7623() {
        if (!C0909.m2387()) {
            mo7618();
        } else {
            this.f436.mo9299(false, false, false, (QueryCallback) new C1253(this));
        }
    }

    /* renamed from: ֏ */
    public /* synthetic */ void mo7608(C1114 r1, boolean z, boolean z2, int i) {
        if (z2) {
            mo7618();
        } else {
            m425((Context) this);
        }
    }

    /* renamed from: ֏ */
    public static void m425(Context context) {
        C0915 r0 = new C0915(context);
        r0.f2464 = context.getString(R$string.limit_custom, new Object[]{Integer.valueOf(C1149.m3082())});
        r0.mo8902((CharSequence) context.getString(2131493346, new Object[]{SystemUtils.m3519(context.getPackageName())}), 19);
        r0.mo8898(2131493347);
        r0.mo8906(2131493370, (OnDialogClickListener) C0664.f1727);
        r0.mo8910();
    }
}
