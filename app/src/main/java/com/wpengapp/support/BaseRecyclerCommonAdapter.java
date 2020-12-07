package com.wpengapp.support;

import android.content.Context;
import android.support.annotation.NonNull;

/* renamed from: com.wpengapp.support.ї */
public abstract class BaseRecyclerCommonAdapter<Model> extends HeaderFooterRecycleAdapter<Model> {

    /* renamed from: ބ */
    public Object f1846;

    /* renamed from: ޅ */
    public TypeUtil f1847 = new TypeUtil();

    public BaseRecyclerCommonAdapter(Context context) {
        super(context);
    }

    @NonNull
    /* renamed from: ֏ */
    public abstract BaseItem<T> mo7698(Object obj);
}
