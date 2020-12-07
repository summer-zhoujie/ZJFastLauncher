package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import java.util.List;

/* renamed from: com.wpengapp.support.د */
public class SimpleListAdapter extends BaseAdapter {

    /* renamed from: ֏ */
    public int f2289 = -1;

    /* renamed from: ؠ */
    public Context f2290;

    /* renamed from: ހ */
    public List<CharSequence> f2291;

    /* renamed from: ށ */
    public int f2292;

    /* renamed from: com.wpengapp.support.د$֏ */
    /* compiled from: SimpleListAdapter */
    private static class C0848 {

        /* renamed from: ֏ */
        public TextView f2293;

        /* renamed from: ؠ */
        public CheckBox f2294;

        public C0848() {
        }

        public /* synthetic */ C0848(C0911 r1) {
        }
    }

    public SimpleListAdapter(Context context, List<CharSequence> list, int i) {
        this.f2289 = i;
        this.f2290 = context;
        this.f2291 = list;
    }

    public int getCount() {
        return this.f2291.size();
    }

    public Object getItem(int i) {
        return this.f2291.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0848 r5;
        if (view == null) {
            view = View.inflate(this.f2290, R$layout.baseui_item_dialog_list, (ViewGroup) null);
            r5 = new C0848((C0911) null);
            r5.f2293 = (TextView) view.findViewById(R$id.tv_msg);
            r5.f2294 = (CheckBox) view.findViewById(R$id.checkbox);
            if (this.f2289 < 0) {
                r5.f2294.setVisibility(8);
            }
            view.setTag(r5);
            this.f2292 = r5.f2293.getCurrentTextColor();
        } else {
            r5 = (C0848) view.getTag();
        }
        r5.f2293.setText(this.f2291.get(i));
        r5.f2293.setTextColor(this.f2289 == i ? this.f2292 : ViewCompat.MEASURED_STATE_MASK);
        r5.f2294.setChecked(this.f2289 == i);
        return view;
    }
}
