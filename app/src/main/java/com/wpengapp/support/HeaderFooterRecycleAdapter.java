package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.util.SparseArrayCompat;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wpengapp.baseui.R$id;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ॽ */
public abstract class HeaderFooterRecycleAdapter<Model> extends BaseRecyclerAdapter<Model, ViewHolder> {

    /* renamed from: ހ */
    public int f2991 = -100000;

    /* renamed from: ށ */
    public int f2992 = -200000;

    /* renamed from: ނ */
    public SparseArrayCompat<View> f2993 = new SparseArrayCompat<>(10);

    /* renamed from: ރ */
    public SparseArrayCompat<View> f2994 = new SparseArrayCompat<>(10);

    public HeaderFooterRecycleAdapter(Context context) {
        super(context);
    }

    public int getItemCount() {
        return mo9175() + mo9179() + mo9057();
    }

    public int getItemViewType(int i) {
        boolean z = true;
        if (i < mo9179()) {
            return this.f2993.keyAt(i);
        }
        if (i < getItemCount() - mo9175()) {
            z = false;
        }
        if (z) {
            return this.f2994.keyAt(mo9175() + (i - getItemCount()));
        }
        BaseRecyclerCommonAdapter r0 = (BaseRecyclerCommonAdapter) this;
        r0.getItem(i - mo9179());
        r0.f1846 = -1;
        TypeUtil r5 = r0.f1847;
        Object obj = r0.f1846;
        Integer num = r5.f1052.get(obj);
        if (num == null) {
            num = Integer.valueOf(r5.f1052.size());
            r5.f1052.put(obj, num);
        }
        return num.intValue();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder r3 = (ViewHolder) viewHolder;
        if (mo9178(i) || mo9174(i)) {
            ViewGroup.LayoutParams layoutParams = r3.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
                return;
            }
            return;
        }
        int r4 = i - mo9179();
        BaseRecyclerCommonAdapter r0 = (BaseRecyclerCommonAdapter) this;
        BaseItem r32 = (BaseItem) r3.itemView.getTag(R$id.baseui_tag_item);
        if (r32 != null) {
            Object item = r0.getItem(r4);
            Object obj = r0.f1846;
            r32.mo7704(item, r4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = this.f2993.get(i);
        if (view != null) {
            return new ViewHolder(view);
        }
        View view2 = this.f2994.get(i);
        if (view2 != null) {
            return new ViewHolder(view2);
        }
        BaseRecyclerCommonAdapter r5 = (BaseRecyclerCommonAdapter) this;
        BaseItem r0 = r5.mo7698(r5.f1846);
        View inflate = LayoutInflater.from(r5.f2805).inflate(r0.mo7700(), viewGroup, false);
        inflate.setTag(R$id.baseui_tag_item, r0);
        r0.mo7701(inflate);
        return new ViewHolder(inflate);
    }

    /* renamed from: ֏ */
    public boolean mo9174(int i) {
        return i >= getItemCount() - mo9175();
    }

    /* renamed from: ؠ */
    public boolean mo9178(int i) {
        return i < mo9179();
    }

    /* renamed from: ހ */
    public int mo9179() {
        return this.f2993.size();
    }

    /* renamed from: ֏ */
    public void mo9173(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.f2993;
        int i = this.f2991 - 1;
        this.f2991 = i;
        sparseArrayCompat.put(i, view);
        notifyItemInserted(this.f2993.size() - 1);
    }

    /* renamed from: ؠ */
    public View mo9176(int i, RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(this.f2805).inflate(i, recyclerView, false);
        mo9173(inflate);
        return inflate;
    }

    /* renamed from: ֏ */
    public View mo9171(int i, RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(this.f2805).inflate(i, recyclerView, false);
        SparseArrayCompat<View> sparseArrayCompat = this.f2994;
        int i2 = this.f2992 - 1;
        this.f2992 = i2;
        sparseArrayCompat.put(i2, inflate);
        notifyItemInserted(getItemCount() - 1);
        return inflate;
    }

    /* renamed from: ؠ */
    public int mo9175() {
        return this.f2994.size();
    }

    /* renamed from: ؠ */
    public void mo9177(List<? extends Model> list) {
        if (list != null) {
            this.f2806.addAll(list);
            notifyItemRangeInserted((this.f2806.size() + mo9179()) - list.size(), list.size());
        }
    }

    /* renamed from: ֏ */
    public void mo9172(int i, int i2) {
        if (i >= 0 && i < this.f2806.size() && i2 > 0) {
            if (i + i2 > this.f2806.size()) {
                i2 = this.f2806.size() - i;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f2806.size(); i3++) {
                if (i3 < i || i3 >= i + i2) {
                    arrayList.add(this.f2806.get(i3));
                }
            }
            this.f2806.clear();
            this.f2806.addAll(arrayList);
            notifyItemRangeRemoved(mo9179() + i, i2);
        }
    }
}
