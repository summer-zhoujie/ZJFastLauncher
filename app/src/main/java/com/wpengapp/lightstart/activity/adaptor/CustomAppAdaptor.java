package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.lightstart.activity.AppSetupActivity;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0721;
import com.wpengapp.support.C0958;
import com.wpengapp.support.CollectionUtils;

public class CustomAppAdaptor extends BaseRecyclerCommonAdapter<C0439> {

    public class AppItem_ViewBinding<T extends AppItem> implements Unbinder {
        @UiThread
        public AppItem_ViewBinding(T t, View view) {
            t.mImgIcon = (ImageView) C0958.m2538(view, 2131165311, "field 'mImgIcon'", ImageView.class);
            t.mTvName = (TextView) C0958.m2538(view, 2131165529, "field 'mTvName'", TextView.class);
            t.mTvDes = (TextView) C0958.m2538(view, 2131165511, "field 'mTvDes'", TextView.class);
        }
    }

    /* renamed from: com.wpengapp.lightstart.activity.adaptor.CustomAppAdaptor$֏ */
    public static class C0439 implements Comparable<C0439> {

        /* renamed from: ֏ */
        public String f482;

        /* renamed from: ؠ */
        public String f483;

        /* renamed from: ހ */
        public Drawable f484;

        /* renamed from: ށ */
        public int f485;

        public int compareTo(@NonNull Object obj) {
            String str = ((C0439) obj).f483;
            if (str == null) {
                return -1;
            }
            String str2 = this.f483;
            if (str2 == null) {
                return 1;
            }
            return CollectionUtils.f1665.compare(str2, str);
        }
    }

    public CustomAppAdaptor(Context context) {
        super(context);
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<C0439> mo7698(Object obj) {
        return new AppItem();
    }

    static class AppItem extends BaseItem<C0439> {
        public ImageView mImgIcon;
        public TextView mTvDes;
        public TextView mTvName;

        /* renamed from: ֏ */
        public View f481;

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_custom_app;
        }

        /* renamed from: ֏ */
        public void mo7704(Object obj, int i) {
            C0439 r5 = (C0439) obj;
            Drawable drawable = r5.f484;
            if (drawable == null) {
                this.mImgIcon.setImageResource(2131099733);
            } else {
                this.mImgIcon.setImageDrawable(drawable);
            }
            this.mTvName.setText(r5.f483);
            this.mTvDes.setText(AppUtils.m1141((int) R$string.custom_app_count, Integer.valueOf(r5.f485)));
            this.f481.setOnClickListener(new C0721(this, r5));
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7706(C0439 r3, View view) {
            Intent intent = new Intent(this.f481.getContext(), AppSetupActivity.class);
            intent.putExtra("EXTRA_PKG", r3.f482);
            this.f481.getContext().startActivity(intent);
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
            this.f481 = view;
        }
    }
}
