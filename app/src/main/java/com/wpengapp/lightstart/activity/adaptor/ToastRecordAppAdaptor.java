package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p000v4.text.BidiFormatter;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.ToastRecordAppActivity;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0958;
import com.wpengapp.support.C1059;
import com.wpengapp.support.ToastRecord;

public class ToastRecordAppAdaptor extends BaseRecyclerCommonAdapter<ToastRecord> {

    public class AppItem_ViewBinding<T extends AppItem> implements Unbinder {
        @UiThread
        public AppItem_ViewBinding(T t, View view) {
            t.mTvDes = (TextView) C0958.m2538(view, 2131165511, "field 'mTvDes'", TextView.class);
            t.mTvTime = (TextView) C0958.m2538(view, R$id.tv_time, "field 'mTvTime'", TextView.class);
        }
    }

    public ToastRecordAppAdaptor(Context context) {
        super(context);
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<ToastRecord> mo7698(Object obj) {
        return new AppItem();
    }

    static class AppItem extends BaseItem<ToastRecord> {
        public TextView mTvDes;
        public TextView mTvTime;

        /* renamed from: ֏ */
        public View f498;

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_toast_record_app;
        }

        /* renamed from: ֏ */
        public void mo7704(Object obj, int i) {
            ToastRecord r4 = (ToastRecord) obj;
            String str = r4.f1638;
            this.mTvDes.setText(str == null ? AppUtils.m1141((int) R$string.toast_record_empty, new Object[0]) : str.replace("\n", BidiFormatter.EMPTY_STRING).trim());
            this.mTvTime.setText(ToastRecordAdaptor.m615(r4.f1639));
            this.f498.setOnLongClickListener(new C1059(this, r4, i));
        }

        /* renamed from: ֏ */
        public /* synthetic */ boolean mo7715(ToastRecord r2, int i, View view) {
            if (!(view.getContext() instanceof ToastRecordAppActivity)) {
                return false;
            }
            ((ToastRecordAppActivity) view.getContext()).mo7688(this.f498, r2, i);
            return false;
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
            this.f498 = view;
        }
    }
}
