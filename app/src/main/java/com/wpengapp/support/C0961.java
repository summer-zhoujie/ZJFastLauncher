package com.wpengapp.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.baseui.R$drawable;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.baseui.widget.ChoiceAppListView;
import com.wpengapp.baseui.widget.SwitchButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.wpengapp.support.ߊ */
/* compiled from: ChoiceAppListAdapter */
public class C0961 extends BaseAdapter {

    /* renamed from: ֏ */
    public Context f2670;

    /* renamed from: ؠ */
    public List<AppWrapper> f2671;

    /* renamed from: ހ */
    public Set<AppWrapper> f2672;

    /* renamed from: ށ */
    public boolean f2673 = true;

    /* renamed from: ނ */
    public Handler f2674;

    /* renamed from: ރ */
    public boolean f2675;

    /* renamed from: ބ */
    public int f2676;

    /* renamed from: ޅ */
    public boolean f2677;

    /* renamed from: ކ */
    public ChoiceAppListView.C0424 f2678;

    /* renamed from: com.wpengapp.support.ߊ$֏ */
    /* compiled from: ChoiceAppListAdapter */
    public static class C0962 implements Runnable {

        /* renamed from: ֏ */
        public TextView f2679;

        /* renamed from: ؠ */
        public ImageView f2680;

        /* renamed from: ހ */
        public SwitchButton f2681;

        /* renamed from: ށ */
        public AppWrapper f2682;

        public void run() {
            Drawable icon;
            AppWrapper appWrapper = this.f2682;
            if (appWrapper != null && (icon = appWrapper.getIcon(AppUtils.getApplication())) != null) {
                this.f2680.setImageDrawable(icon);
            }
        }
    }

    public C0961(Context context) {
        this.f2670 = context;
        this.f2674 = new Handler();
        this.f2671 = new ArrayList();
        this.f2672 = new HashSet();
    }

    public int getCount() {
        if (this.f2677) {
            return 1;
        }
        return this.f2671.size();
    }

    public Object getItem(int i) {
        return this.f2671.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0962 r5;
        if (this.f2677) {
            return View.inflate(this.f2670, R$layout.baseui_item_choice_app_list_empty, (ViewGroup) null);
        }
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.f2670, mo7565(), (ViewGroup) null);
            r5 = new C0962();
            r5.f2679 = (TextView) view.findViewById(R$id.tv_name);
            r5.f2681 = (SwitchButton) view.findViewById(R$id.switch_button);
            r5.f2680 = (ImageView) view.findViewById(R$id.img_icon);
            view.setTag(r5);
            int i2 = this.f2676;
            view.setPadding(i2, 0, i2, 0);
        } else {
            r5 = (C0962) view.getTag();
        }
        mo7564(i, view, r5, this.f2671.get(i));
        return view;
    }

    public void notifyDataSetChanged() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.notifyDataSetChanged();
        } else {
            this.f2674.post(new C0699(this));
        }
    }

    @LayoutRes
    /* renamed from: ؠ */
    public int mo7565() {
        throw null;
    }

    /* renamed from: ֏ */
    public void mo9011(List<AppWrapper> list) {
        this.f2677 = false;
        this.f2671.clear();
        this.f2671.addAll(list);
        Comparator<AppWrapper> r3 = mo7599();
        if (r3 != null && this.f2671.size() > 0) {
            Collections.sort(this.f2671, r3);
        }
        for (int min = Math.min(8, this.f2671.size()) - 1; min >= 0; min--) {
            this.f2671.get(min).getIcon(AppUtils.getApplication());
        }
        notifyDataSetChanged();
    }

    /* renamed from: ֏ */
    public Comparator<AppWrapper> mo7599() {
        return new ChoiceAppListAdapter(this);
    }

    /* renamed from: ֏ */
    public void mo7564(int i, View view, C0962 r6, AppWrapper appWrapper) {
        r6.f2679.setText(appWrapper.name);
        r6.f2681.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f2675) {
            r6.f2681.setVisibility(8);
        } else {
            boolean z = false;
            r6.f2681.setVisibility(0);
            SwitchButton switchButton = r6.f2681;
            if (this.f2673 == this.f2672.contains(appWrapper)) {
                z = true;
            }
            switchButton.setChecked(z);
            r6.f2681.setOnCheckedChangeListener(new C0477(this, appWrapper));
        }
        view.setOnClickListener(new C0716(this, appWrapper, r6));
        r6.f2680.removeCallbacks(r6);
        Drawable cachedIcon = appWrapper.getCachedIcon();
        if (cachedIcon != null) {
            r6.f2680.setImageDrawable(cachedIcon);
            return;
        }
        r6.f2680.setImageResource(R$drawable.baseui_default_app_icon);
        AppWrapper unused = r6.f2682 = appWrapper;
        r6.f2680.postDelayed(r6, 600);
    }
}
