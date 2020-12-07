package com.wpengapp.support;

import android.content.Context;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.wpengapp.support.ࡅ */
public abstract class BaseRecyclerAdapter<Model, Holder extends ViewHolder> extends RecyclerView.Adapter<Holder> {

    /* renamed from: ֏ */
    public Context f2805;

    /* renamed from: ؠ */
    public List<Model> f2806 = new ArrayList();

    public BaseRecyclerAdapter(Context context) {
        this.f2805 = context;
    }

    public Model getItem(int i) {
        if (i < 0 || i >= this.f2806.size()) {
            return null;
        }
        return this.f2806.get(i);
    }

    public int getItemCount() {
        return mo9057();
    }

    public long getItemId(int i) {
        if (i == this.f2806.size()) {
            return 0;
        }
        return (long) i;
    }

    /* renamed from: ֏ */
    public void mo9058(List<? extends Model> list) {
        List<Model> list2 = this.f2806;
        if (list2 != list) {
            list2.clear();
            if (CollectionUtils.m1659((Collection) list)) {
                this.f2806.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: ֏ */
    public int mo9057() {
        return this.f2806.size();
    }
}
