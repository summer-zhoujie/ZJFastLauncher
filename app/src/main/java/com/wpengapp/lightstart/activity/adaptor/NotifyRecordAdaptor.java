package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.activity.NotifyRecordActivity;
import com.wpengapp.lightstart.activity.NotifyRecordAppActivity;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0468;
import com.wpengapp.support.C0547;
import com.wpengapp.support.C0621;
import com.wpengapp.support.C0778;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0958;
import com.wpengapp.support.NotifyRecord;
import com.wpengapp.support.PopupDialog;
import com.wpengapp.support.SystemUtils;

public class NotifyRecordAdaptor extends BaseRecyclerCommonAdapter<NotifyRecord> {

    /* renamed from: ކ */
    public static C0621 f495;

    public class Item_ViewBinding<T extends Item> implements Unbinder {
        @UiThread
        public Item_ViewBinding(T t, View view) {
            t.mImgSmallIcon = (ImageView) C0958.m2538(view, R$id.img_small_icon, "field 'mImgSmallIcon'", ImageView.class);
            t.mTvAppName = (TextView) C0958.m2538(view, 2131165496, "field 'mTvAppName'", TextView.class);
            t.mTvTime = (TextView) C0958.m2538(view, R$id.tv_time, "field 'mTvTime'", TextView.class);
            t.mImgLargeIcon = (ImageView) C0958.m2538(view, R$id.img_large_icon, "field 'mImgLargeIcon'", ImageView.class);
            t.mTvTitle = (TextView) C0958.m2538(view, 2131165554, "field 'mTvTitle'", TextView.class);
            t.mTvDes = (TextView) C0958.m2538(view, 2131165511, "field 'mTvDes'", TextView.class);
        }
    }

    static {
        C0621.C0622 r0 = new C0621.C0622();
        r0.f1580 = false;
        f495 = r0.mo8358();
    }

    public NotifyRecordAdaptor(Context context) {
        super(context);
    }

    /* renamed from: ؠ */
    public static /* synthetic */ void m606(PopupDialog r0, NotifyRecord r1, View view) {
        r0.dismiss();
        SystemUtils.m3513((CharSequence) r1.f3461 + "\n" + r1.f3462);
    }

    /* renamed from: ހ */
    public static /* synthetic */ void m607(PopupDialog r0, NotifyRecord r1, View view) {
        r0.dismiss();
        m605(r1);
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<NotifyRecord> mo7698(Object obj) {
        return new Item();
    }

    /* renamed from: ֏ */
    public static void m605(NotifyRecord r4) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            if (TextUtils.isEmpty(r4.f3463)) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            } else {
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.CHANNEL_ID", r4.f3463);
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", r4.f3460);
        } else {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", r4.f3460, (String) null));
        }
        try {
            SystemUtils.m3510((Context) null, intent);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m603(View view, NotifyRecord r5, int i) {
        View inflate = View.inflate(view.getContext(), R$layout.dialog_notify_record, (ViewGroup) null);
        int r0 = C0826.m2168(120.0f);
        C0915 r1 = new C0915(view.getContext());
        r1.f2463 = inflate;
        r1.f2481 = r0;
        PopupDialog r12 = r1.mo8908();
        r12.showAsDropDown(view, (view.getWidth() - r0) - C0826.m2168(4.0f), ((-view.getHeight()) / 2) - C0826.m2168(16.0f));
        inflate.findViewById(R$id.tv_delete).setOnClickListener(new C0547(r12, r5));
        inflate.findViewById(R$id.tv_copy).setOnClickListener(new C0778(r12, r5));
        inflate.findViewById(R$id.tv_manager).setOnClickListener(new C0468(r12, r5));
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m604(PopupDialog r0, NotifyRecord r1, View view) {
        r0.dismiss();
        if (view.getContext() instanceof NotifyRecordActivity) {
            ((NotifyRecordActivity) view.getContext()).mo7656(r1);
        } else if (view.getContext() instanceof NotifyRecordAppActivity) {
            ((NotifyRecordAppActivity) view.getContext()).mo7656(r1);
        }
    }

    static class Item extends BaseItem<NotifyRecord> {
        public ImageView mImgLargeIcon;
        public ImageView mImgSmallIcon;
        public TextView mTvAppName;
        public TextView mTvDes;
        public TextView mTvTime;
        public TextView mTvTitle;

        /* renamed from: ֏ */
        public View f496;

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_notify_record;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8  */
        /* renamed from: ֏ */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo7704(Object r6, int r7) {
            /*
                r5 = this;
                com.wpengapp.support.ๅ r6 = (com.wpengapp.support.NotifyRecord) r6
                java.lang.String r0 = r6.f3460
                java.lang.String r0 = com.wpengapp.support.SystemUtils.m3519((java.lang.String) r0)
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto L_0x0010
                java.lang.String r0 = r6.f3460
            L_0x0010:
                android.widget.TextView r1 = r5.mTvAppName
                r1.setText(r0)
                java.lang.String r0 = r6.f3461
                java.lang.String r1 = ""
                if (r0 != 0) goto L_0x001c
                goto L_0x0026
            L_0x001c:
                java.lang.String r2 = "\n"
                java.lang.String r0 = r0.replace(r2, r1)
                java.lang.String r1 = r0.trim()
            L_0x0026:
                android.widget.TextView r0 = r5.mTvTitle
                r0.setText(r1)
                android.widget.TextView r0 = r5.mTvDes
                java.lang.String r1 = r6.f3462
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r2 = 0
                if (r1 == 0) goto L_0x0038
                r1 = 4
                goto L_0x0039
            L_0x0038:
                r1 = 0
            L_0x0039:
                r0.setVisibility(r1)
                android.widget.TextView r0 = r5.mTvDes
                java.lang.String r1 = r6.f3462
                r0.setText(r1)
                android.widget.TextView r0 = r5.mTvTime
                java.lang.Long r1 = r6.f3464
                java.lang.String r1 = com.wpengapp.lightstart.activity.adaptor.ToastRecordAdaptor.m615((java.lang.Long) r1)
                r0.setText(r1)
                java.lang.String r0 = r6.f3460
                android.graphics.drawable.Drawable r0 = com.wpengapp.support.SystemUtils.m3508((java.lang.String) r0)
                if (r0 == 0) goto L_0x006c
                int r1 = r0.getIntrinsicWidth()
                int r3 = r0.getIntrinsicHeight()
                int r3 = r3 * r1
                r1 = 250000(0x3d090, float:3.50325E-40)
                if (r3 <= r1) goto L_0x0066
                goto L_0x006c
            L_0x0066:
                android.widget.ImageView r1 = r5.mImgSmallIcon
                r1.setImageDrawable(r0)
                goto L_0x0074
            L_0x006c:
                android.widget.ImageView r0 = r5.mImgSmallIcon
                r1 = 2131099733(0x7f060055, float:1.7811828E38)
                r0.setImageResource(r1)
            L_0x0074:
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r6.f3460
                java.lang.Long r3 = r6.f3459
                long r3 = r3.longValue()
                java.lang.String r1 = com.wpengapp.support.NotifyImageManager.m1920(r1, r3)
                r0.<init>(r1)
                boolean r1 = r0.exists()
                if (r1 == 0) goto L_0x00a0
                com.wpengapp.support.ˣ r1 = com.wpengapp.support.Image.m3366()
                android.net.Uri r0 = android.net.Uri.fromFile(r0)
                java.lang.String r0 = r0.toString()
                android.widget.ImageView r3 = r5.mImgSmallIcon
                com.wpengapp.support.ˮ r4 = com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor.f495
                r1.mo8351((java.lang.String) r0, (android.widget.ImageView) r3, (com.wpengapp.support.C0621) r4)
            L_0x00a0:
                android.widget.ImageView r0 = r5.mImgLargeIcon
                r1 = 0
                r0.setImageDrawable(r1)
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r6.f3460
                java.lang.Long r3 = r6.f3459
                long r3 = r3.longValue()
                java.lang.String r1 = com.wpengapp.support.NotifyImageManager.m1916(r1, r3)
                r0.<init>(r1)
                boolean r1 = r0.exists()
                if (r1 == 0) goto L_0x00d8
                android.widget.ImageView r1 = r5.mImgLargeIcon
                r1.setVisibility(r2)
                com.wpengapp.support.ˣ r1 = com.wpengapp.support.Image.m3366()
                android.net.Uri r0 = android.net.Uri.fromFile(r0)
                java.lang.String r0 = r0.toString()
                android.widget.ImageView r2 = r5.mImgLargeIcon
                com.wpengapp.support.ˮ r3 = com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor.f495
                r1.mo8351((java.lang.String) r0, (android.widget.ImageView) r2, (com.wpengapp.support.C0621) r3)
                goto L_0x00df
            L_0x00d8:
                android.widget.ImageView r0 = r5.mImgLargeIcon
                r1 = 8
                r0.setVisibility(r1)
            L_0x00df:
                android.view.View r0 = r5.f496
                com.wpengapp.support.ວ r1 = new com.wpengapp.support.ວ
                r1.<init>(r6)
                r0.setOnClickListener(r1)
                android.view.View r0 = r5.f496
                com.wpengapp.support.ဎ r1 = new com.wpengapp.support.ဎ
                r1.<init>(r5, r6, r7)
                r0.setOnLongClickListener(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.lightstart.activity.adaptor.NotifyRecordAdaptor.Item.mo7704(java.lang.Object, int):void");
        }

        /* renamed from: ֏ */
        public static /* synthetic */ void m610(NotifyRecord r1, View view) {
            if (view.getContext() instanceof NotifyRecordActivity) {
                ((NotifyRecordActivity) view.getContext()).mo7660(r1);
            } else {
                NotifyRecordAdaptor.m605(r1);
            }
        }

        /* renamed from: ֏ */
        public /* synthetic */ boolean mo7712(NotifyRecord r1, int i, View view) {
            NotifyRecordAdaptor.m603(this.f496, r1, i);
            return false;
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
            this.f496 = view;
        }
    }
}
