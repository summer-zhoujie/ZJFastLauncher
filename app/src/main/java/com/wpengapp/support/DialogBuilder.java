package com.wpengapp.support;

import android.view.View;
import android.widget.AdapterView;
import com.wpengapp.baseui.widget.dialog.DialogView;

/* renamed from: com.wpengapp.support.Ī */
class DialogBuilder implements AdapterView.OnItemClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ SimpleListAdapter f792;

    /* renamed from: ؠ */
    public final /* synthetic */ DialogView f793;

    /* renamed from: ހ */
    public final /* synthetic */ C0915 f794;

    public DialogBuilder(C0915 r1, SimpleListAdapter r2, DialogView dialogView) {
        this.f794 = r1;
        this.f792 = r2;
        this.f793 = dialogView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SimpleListAdapter r0 = this.f792;
        r0.f2289 = i;
        r0.notifyDataSetChanged();
        AdapterView.OnItemClickListener onItemClickListener = this.f794.f2475;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i, j);
        }
        this.f793.f403.dismiss();
    }
}
