package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p000v4.text.BidiFormatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.activity.ToastRecordActivity;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0958;
import com.wpengapp.support.DateUtils;
import com.wpengapp.support.ToastRecord;
import java.util.Date;

public class ToastRecordAdaptor extends BaseRecyclerCommonAdapter<ToastRecord> {

    public class AppItem_ViewBinding<T extends AppItem> implements Unbinder {
        @UiThread
        public AppItem_ViewBinding(T t, View view) {
            t.mImgIcon = (ImageView) C0958.m2538(view, 2131165311, "field 'mImgIcon'", ImageView.class);
            t.mTvTitle = (TextView) C0958.m2538(view, 2131165554, "field 'mTvTitle'", TextView.class);
            t.mTvDes = (TextView) C0958.m2538(view, 2131165511, "field 'mTvDes'", TextView.class);
            t.mTvTime = (TextView) C0958.m2538(view, R$id.tv_time, "field 'mTvTime'", TextView.class);
        }
    }

    public ToastRecordAdaptor(Context context) {
        super(context);
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<ToastRecord> mo7698(Object obj) {
        return new AppItem();
    }

    /* renamed from: ֏ */
    public static String m615(Long l) {
        if (l == null) {
            return BidiFormatter.EMPTY_STRING;
        }
        if (l.longValue() >= DateUtils.m2701().getTime()) {
            return DateUtils.m2699(new Date(l.longValue()), "HH:mm");
        }
        return DateUtils.m2699(new Date(l.longValue()), "yyyy-MM-dd HH:mm");
    }

    static class AppItem extends BaseItem<ToastRecord> {
        public ImageView mImgIcon;
        public TextView mTvDes;
        public TextView mTvTime;
        public TextView mTvTitle;

        /* renamed from: ֏ */
        public View f497;

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_toast_record;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo7704(Object r7, int r8) {
            /*
                r6 = this;
                com.wpengapp.support.Ρ r7 = (com.wpengapp.support.ToastRecord) r7
                java.lang.String r0 = r7.f1637
                android.graphics.drawable.Drawable r0 = com.wpengapp.support.SystemUtils.m3508((java.lang.String) r0)
                if (r0 == 0) goto L_0x0020
                int r1 = r0.getIntrinsicWidth()
                int r2 = r0.getIntrinsicHeight()
                int r2 = r2 * r1
                r1 = 250000(0x3d090, float:3.50325E-40)
                if (r2 <= r1) goto L_0x001a
                goto L_0x0020
            L_0x001a:
                android.widget.ImageView r1 = r6.mImgIcon
                r1.setImageDrawable(r0)
                goto L_0x0028
            L_0x0020:
                android.widget.ImageView r0 = r6.mImgIcon
                r1 = 2131099733(0x7f060055, float:1.7811828E38)
                r0.setImageResource(r1)
            L_0x0028:
                java.lang.String r0 = r7.f1637
                java.lang.String r0 = com.wpengapp.support.SystemUtils.m3519((java.lang.String) r0)
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto L_0x0036
                java.lang.String r0 = r7.f1637
            L_0x0036:
                android.widget.TextView r1 = r6.mTvTitle
                r1.setText(r0)
                java.lang.String r0 = r7.f1638
                r1 = 0
                java.lang.String r2 = "\n"
                if (r0 != 0) goto L_0x004c
                r0 = 2131493277(0x7f0c019d, float:1.861003E38)
                java.lang.Object[] r3 = new java.lang.Object[r1]
                java.lang.String r0 = com.wpengapp.support.AppUtils.m1141((int) r0, (java.lang.Object[]) r3)
                goto L_0x0056
            L_0x004c:
                java.lang.String r3 = ""
                java.lang.String r0 = r0.replace(r2, r3)
                java.lang.String r0 = r0.trim()
            L_0x0056:
                boolean r3 = r7 instanceof com.wpengapp.support.AppToastRecord
                if (r3 == 0) goto L_0x0087
                r3 = 2131493282(0x7f0c01a2, float:1.861004E38)
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]
                r5 = r7
                com.wpengapp.support.ڙ r5 = (com.wpengapp.support.AppToastRecord) r5
                int r5 = r5.f2413
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r4[r1] = r5
                java.lang.String r1 = com.wpengapp.support.AppUtils.m1141((int) r3, (java.lang.Object[]) r4)
                android.widget.TextView r3 = r6.mTvDes
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r1)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.setText(r0)
                goto L_0x008c
            L_0x0087:
                android.widget.TextView r1 = r6.mTvDes
                r1.setText(r0)
            L_0x008c:
                android.widget.TextView r0 = r6.mTvTime
                java.lang.Long r1 = r7.f1639
                java.lang.String r1 = com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor.m615((java.lang.Long) r1)
                r0.setText(r1)
                android.view.View r0 = r6.f497
                com.wpengapp.support.ץ r1 = new com.wpengapp.support.ץ
                r1.<init>(r6, r7, r8)
                r0.setOnClickListener(r1)
                android.view.View r0 = r6.f497
                com.wpengapp.support.ձ r1 = new com.wpengapp.support.ձ
                r1.<init>(r6, r7, r8)
                r0.setOnLongClickListener(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor.AppItem.mo7704(java.lang.Object, int):void");
        }

        /* renamed from: ؠ */
        public /* synthetic */ boolean mo7714(ToastRecord r2, int i, View view) {
            if (!(view.getContext() instanceof ToastRecordActivity)) {
                return false;
            }
            ((ToastRecordActivity) view.getContext()).mo7673(this.f497, r2, i);
            return false;
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7713(ToastRecord r2, int i, View view) {
            if (view.getContext() instanceof ToastRecordActivity) {
                ((ToastRecordActivity) view.getContext()).mo7674(r2);
            } else {
                ((ToastRecordActivity) view.getContext()).mo7673(this.f497, r2, i);
            }
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
            this.f497 = view;
        }
    }
}
