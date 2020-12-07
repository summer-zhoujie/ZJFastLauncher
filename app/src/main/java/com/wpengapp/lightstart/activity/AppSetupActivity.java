package com.wpengapp.lightstart.activity;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.widget.ItemView;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor;
import com.wpengapp.support.AppConfig;
import com.wpengapp.support.C0471;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C1219;
import com.wpengapp.support.C1320;
import com.wpengapp.support.CollectionUtils;
import com.wpengapp.support.CustomAppConfig;
import com.wpengapp.support.CustomPageConfig;
import com.wpengapp.support.DateUtils;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AppSetupActivity extends WPengBaseActivity {
    public RecyclerView mRecyclerView;

    /* renamed from: ֏ */
    public ImageView f410;

    /* renamed from: ؠ */
    public TextView f411;

    /* renamed from: ހ */
    public TextView f412;

    /* renamed from: ށ */
    public TextView f413;

    /* renamed from: ނ */
    public ItemView f414;

    /* renamed from: ރ */
    public View f415;

    /* renamed from: ބ */
    public CustomPageAdaptor f416;

    /* renamed from: ޅ */
    public String f417;

    /* renamed from: ކ */
    public boolean f418;

    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131165356) {
            C1219.m3282(this.f417);
            mo7569();
            C0826.m2179(R$string.app_reset_success, new Object[0]);
        } else if (id != 2131165355) {
        } else {
            if (this.f418) {
                Intent intent = new Intent(this, AppSetupListActivity.class);
                intent.putExtra("GUIDE_ENGINE", true);
                startActivity(intent);
                finish();
                return;
            }
            String str = this.f417;
            this.f411.getText();
            AppReportActivity.m353((Context) this, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            r7 = 2131296298(0x7f09002a, float:1.8210509E38)
            r6.setContentView((int) r7)
            butterknife.ButterKnife.m30((android.app.Activity) r6)
            android.support.v7.widget.Toolbar r7 = r6.mo7434()
            r0 = 0
            r7.setBackgroundColor(r0)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r1 = "EXTRA_PKG"
            java.lang.String r7 = r7.getStringExtra(r1)
            r6.f417 = r7
            java.lang.String r7 = r6.f417
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x002c
            r6.finish()
            return
        L_0x002c:
            android.support.v7.widget.LinearLayoutManager r7 = new android.support.v7.widget.LinearLayoutManager
            r1 = 1
            r7.<init>(r6, r1, r0)
            r7.setOrientation(r1)
            android.support.v7.widget.RecyclerView r2 = r6.mRecyclerView
            r2.setLayoutManager(r7)
            com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor r7 = new com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor
            java.lang.String r2 = r6.f417
            r7.<init>(r6, r2)
            r6.f416 = r7
            com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor r7 = r6.f416
            r2 = 2131296375(0x7f090077, float:1.8210665E38)
            android.support.v7.widget.RecyclerView r3 = r6.mRecyclerView
            android.view.View r7 = r7.mo9176(r2, r3)
            android.support.v7.widget.RecyclerView r2 = r6.mRecyclerView
            com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor r3 = r6.f416
            r2.setAdapter(r3)
            r2 = 2131165305(0x7f070079, float:1.7944823E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r6.f410 = r2
            r2 = 2131165496(0x7f070138, float:1.794521E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r6.f411 = r2
            r2 = 2131165497(0x7f070139, float:1.7945213E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r6.f412 = r2
            r2 = 2131165495(0x7f070137, float:1.7945209E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r6.f413 = r2
            r2 = 2131165330(0x7f070092, float:1.7944874E38)
            android.view.View r2 = r7.findViewById(r2)
            com.wpengapp.baseui.widget.ItemView r2 = (com.wpengapp.baseui.widget.ItemView) r2
            r6.f414 = r2
            r2 = 2131165508(0x7f070144, float:1.7945235E38)
            android.view.View r2 = r7.findViewById(r2)
            r6.f415 = r2
            java.lang.String r2 = r6.f417
            android.graphics.drawable.Drawable r2 = com.wpengapp.support.SystemUtils.m3508((java.lang.String) r2)
            if (r2 != 0) goto L_0x00a4
            r2 = 2131099733(0x7f060055, float:1.7811828E38)
            android.graphics.drawable.Drawable r2 = android.support.p000v4.content.ContextCompat.getDrawable(r6, r2)
        L_0x00a4:
            android.widget.ImageView r3 = r6.f410
            r3.setImageDrawable(r2)
            android.widget.TextView r2 = r6.f411
            java.lang.String r3 = r6.f417
            java.lang.String r3 = com.wpengapp.support.SystemUtils.m3519((java.lang.String) r3)
            r2.setText(r3)
            java.lang.String r2 = r6.f417
            int r2 = com.wpengapp.support.C0471.m1011((java.lang.String) r2)
            if (r2 <= 0) goto L_0x00dc
            boolean r3 = com.wpengapp.support.C1149.m3079()
            if (r3 == 0) goto L_0x00dc
            android.widget.TextView r3 = r6.f412
            r4 = 2131492924(0x7f0c003c, float:1.8609314E38)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r5[r0] = r2
            java.lang.String r2 = r6.getString(r4, r5)
            r3.setText(r2)
            android.widget.TextView r2 = r6.f412
            r2.setVisibility(r0)
            goto L_0x00e3
        L_0x00dc:
            android.widget.TextView r2 = r6.f412
            r3 = 8
            r2.setVisibility(r3)
        L_0x00e3:
            int r2 = com.wpengapp.support.C0919.m2416()
            if (r2 != 0) goto L_0x0133
            java.lang.String r2 = r6.f417
            com.wpengapp.support.ঢ r2 = com.wpengapp.support.C1219.m3271((java.lang.String) r2)
            if (r2 != 0) goto L_0x00f3
        L_0x00f1:
            r2 = 0
            goto L_0x0130
        L_0x00f3:
            java.util.Map<java.lang.String, com.wpengapp.support.ग़> r3 = r2.f3019
            boolean r3 = com.wpengapp.support.CollectionUtils.m1658((java.util.Map) r3)
            if (r3 == 0) goto L_0x00fc
            goto L_0x00f1
        L_0x00fc:
            java.util.Map<java.lang.String, com.wpengapp.support.ग़> r2 = r2.f3019
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0106:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00f1
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            if (r4 == 0) goto L_0x0106
            java.lang.Object r4 = r3.getValue()
            com.wpengapp.support.ग़ r4 = (com.wpengapp.support.PageConfig) r4
            boolean r4 = r4.f2973
            if (r4 == 0) goto L_0x0123
            goto L_0x0106
        L_0x0123:
            java.lang.Object r3 = r3.getValue()
            com.wpengapp.support.ग़ r3 = (com.wpengapp.support.PageConfig) r3
            boolean r3 = r3.mo9157()
            if (r3 == 0) goto L_0x0106
            r2 = 1
        L_0x0130:
            if (r2 == 0) goto L_0x0133
            r0 = 1
        L_0x0133:
            r6.f418 = r0
            boolean r0 = r6.f418
            if (r0 == 0) goto L_0x014e
            r0 = 2131165355(0x7f0700ab, float:1.7944925E38)
            android.view.View r7 = r7.findViewById(r0)
            com.wpengapp.baseui.widget.ItemView r7 = (com.wpengapp.baseui.widget.ItemView) r7
            r0 = 2131493272(0x7f0c0198, float:1.861002E38)
            r7.setTitle((int) r0)
            r0 = 2131493192(0x7f0c0148, float:1.8609857E38)
            r7.setRightText((int) r0)
        L_0x014e:
            r6.mo7569()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.activity.AppSetupActivity.onCreate(android.os.Bundle):void");
    }

    public void onResume() {
        super.onResume();
        mo7568();
    }

    /* renamed from: ֏ */
    public /* synthetic */ boolean mo7567(CompoundButton compoundButton, boolean z) {
        C1219.m3274(this.f417, !z);
        C0471.m1017(this.f417, !z);
        this.f413.setVisibility(0);
        mo7568();
        return false;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return BidiFormatter.EMPTY_STRING;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return true;
    }

    /* renamed from: ގ */
    public final void mo7568() {
        CustomAppConfig r0 = C0909.m2390().f1747.get(this.f417);
        if (r0 == null || CollectionUtils.m1658((Map) r0.f2437)) {
            this.f416.mo9058((List) null);
            this.f415.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : r0.f2437.entrySet()) {
            List list = (List) next.getValue();
            if (!CollectionUtils.m1657((Collection) list)) {
                for (int i = 0; i < list.size(); i++) {
                    CustomPageConfig r8 = (CustomPageConfig) list.get(i);
                    CustomPageAdaptor.C0440 r9 = new CustomPageAdaptor.C0440();
                    r9.f489 = (String) next.getKey();
                    Boolean bool = r8.f2108;
                    r9.f494 = bool == null || bool.booleanValue();
                    r9.f493 = r8;
                    r9.f490 = r8.f2107;
                    r9.f492 = DateUtils.m2698(new Date(r8.f2106));
                    String str = r9.f489;
                    r9.f491 = str.substring(str.lastIndexOf(".") + 1);
                    arrayList.add(r9);
                }
            }
        }
        if (arrayList.size() <= 0) {
            this.f416.mo9058((List) null);
            this.f415.setVisibility(8);
            return;
        }
        Collections.sort(arrayList);
        this.f416.mo9058(arrayList);
    }

    /* renamed from: ޏ */
    public final void mo7569() {
        this.f414.setOnCheckedChangeListener((ItemView.C0425) null);
        boolean z = true;
        this.f414.setChecked(!C1219.m3278(this.f417));
        this.f414.setOnCheckedChangeListener(new C1320(this));
        AppConfig r0 = C1219.m3271(this.f417);
        int i = 0;
        if (r0 == null || !r0.f3017) {
            z = false;
        }
        TextView textView = this.f413;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
