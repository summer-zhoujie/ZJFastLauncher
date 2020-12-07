package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.CustomActivity;
import com.wpengapp.lightstart.activity.CustomRuleEditActivity;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0483;
import com.wpengapp.support.C0810;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0909;
import com.wpengapp.support.C0958;
import com.wpengapp.support.C1152;
import com.wpengapp.support.C1219;
import com.wpengapp.support.CustomPageConfig;

public class CustomPageAdaptor extends BaseRecyclerCommonAdapter<C0440> {

    /* renamed from: ކ */
    public String f486;

    public class AppItem_ViewBinding<T extends AppItem> implements Unbinder {
        @UiThread
        public AppItem_ViewBinding(T t, View view) {
            t.mTvName = (TextView) C0958.m2538(view, 2131165529, "field 'mTvName'", TextView.class);
            t.mTvDes = (TextView) C0958.m2538(view, 2131165511, "field 'mTvDes'", TextView.class);
            t.mBottomLine = C0958.m2537(view, 2131165240, "field 'mBottomLine'");
            t.mSwitchButton = (SwitchButton) C0958.m2538(view, 2131165475, "field 'mSwitchButton'", SwitchButton.class);
            t.mLayoutSwitch = (LinearLayout) C0958.m2538(view, R$id.layout_switch, "field 'mLayoutSwitch'", LinearLayout.class);
        }
    }

    /* renamed from: com.wpengapp.lightstart.activity.adaptor.CustomPageAdaptor$֏ */
    public static class C0440 implements Comparable<C0440> {

        /* renamed from: ֏ */
        public String f489;

        /* renamed from: ؠ */
        public String f490;

        /* renamed from: ހ */
        public String f491;

        /* renamed from: ށ */
        public String f492;

        /* renamed from: ނ */
        public CustomPageConfig f493;

        /* renamed from: ރ */
        public boolean f494;

        public int compareTo(@NonNull Object obj) {
            return ((C0440) obj).f492.compareTo(this.f492);
        }
    }

    public CustomPageAdaptor(Context context, String str) {
        super(context);
        this.f486 = str;
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<C0440> mo7698(Object obj) {
        return new AppItem();
    }

    class AppItem extends BaseItem<C0440> {
        public View mBottomLine;
        public LinearLayout mLayoutSwitch;
        public SwitchButton mSwitchButton;
        public TextView mTvDes;
        public TextView mTvName;

        /* renamed from: ֏ */
        public View f487;

        public AppItem() {
        }

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_custom_page;
        }

        /* renamed from: ֏ */
        public void mo7704(Object obj, int i) {
            C0440 r5 = (C0440) obj;
            if (TextUtils.isEmpty(r5.f490)) {
                this.mTvName.setText(r5.f492);
            } else {
                this.mTvName.setText(r5.f490);
            }
            this.mTvDes.setText(r5.f491);
            boolean z = true;
            this.mBottomLine.setVisibility(i == CustomPageAdaptor.this.mo9057() - 1 ? 4 : 0);
            this.mSwitchButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            SwitchButton switchButton = this.mSwitchButton;
            if (!r5.f494 || C1219.m3278(CustomPageAdaptor.this.f486)) {
                z = false;
            }
            switchButton.setChecked(z);
            this.mSwitchButton.setOnCheckedChangeListener(new C0483(this, r5));
            this.f487.setOnClickListener(new C0810(this, r5));
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo7710(View view) {
            this.mSwitchButton.toggle();
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7709(C0440 r2, CompoundButton compoundButton, boolean z) {
            if (C1219.m3278(CustomPageAdaptor.this.f486)) {
                this.mSwitchButton.mo7525(false, false);
                C0826.m2179(R$string.custom_app_black, new Object[0]);
            } else if (!z || !C0909.m2387()) {
                if (z) {
                    r2.f493.f2108 = null;
                } else {
                    r2.f493.f2108 = false;
                }
                C0909.m2386(CustomPageAdaptor.this.f486, r2.f489, r2.f493);
            } else {
                CustomActivity.m425(CustomPageAdaptor.this.f2805);
                this.mSwitchButton.mo7525(false, false);
            }
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7708(C0440 r3, View view) {
            CustomRuleEditActivity.m447(this.f487.getContext(), CustomPageAdaptor.this.f486, r3.f489, r3.f493);
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
            this.f487 = view;
            this.mLayoutSwitch.setOnClickListener(new C1152(this));
        }
    }
}
