package com.wpengapp.lightstart.activity.adaptor;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AppShortcut;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0774;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0892;
import com.wpengapp.support.C0958;
import com.wpengapp.support.C1025;
import com.wpengapp.support.Image;

public class CreateTileAdaptor extends BaseRecyclerCommonAdapter<AppShortcut> {

    /* renamed from: ކ */
    public int f479;

    public class Item_ViewBinding<T extends Item> implements Unbinder {
        @UiThread
        public Item_ViewBinding(T t, View view) {
            t.mImgIcon = (ImageView) C0958.m2538(view, 2131165311, "field 'mImgIcon'", ImageView.class);
            t.mTvName = (TextView) C0958.m2538(view, 2131165529, "field 'mTvName'", TextView.class);
            t.mSw = (SwitchButton) C0958.m2538(view, 2131165475, "field 'mSw'", SwitchButton.class);
            t.mBottomLine = C0958.m2537(view, 2131165240, "field 'mBottomLine'");
        }
    }

    public CreateTileAdaptor(Context context, int i) {
        super(context);
        this.f479 = i;
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<AppShortcut> mo7698(Object obj) {
        return new Item();
    }

    class Item extends BaseItem<AppShortcut> {
        public View mBottomLine;
        public ImageView mImgIcon;
        public SwitchButton mSw;
        public TextView mTvName;

        public Item() {
        }

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_create_tile;
        }

        /* renamed from: ֏ */
        public void mo7704(Object obj, int i) {
            AppShortcut r4 = (AppShortcut) obj;
            Bitmap r0 = C0774.m2081(r4);
            if (r0 != null) {
                this.mImgIcon.setImageBitmap(r0);
            } else if (!TextUtils.isEmpty(r4.f940)) {
                this.mImgIcon.setImageResource(2131099733);
                Image.m3366().mo8349(r4.f940, this.mImgIcon);
            } else {
                int i2 = r4.f943;
                if (i2 != -1) {
                    this.mImgIcon.setImageResource(i2);
                } else {
                    this.mImgIcon.setImageResource(2131099733);
                }
            }
            this.mTvName.setText(r4.f938);
            this.mBottomLine.setVisibility(i == CreateTileAdaptor.this.getItemCount() - 1 ? 4 : 0);
            if (CreateTileAdaptor.this.f479 == 0) {
                this.mSw.setChecked(r4.f944.booleanValue());
                this.mSw.setOnCheckedChangeListener(new C1025(this, r4));
            } else if (CreateTileAdaptor.this.f479 == 1) {
                this.mSw.setChecked(r4.f945.booleanValue());
                this.mSw.setOnCheckedChangeListener(new C0892(r4));
            }
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7705(AppShortcut r4, CompoundButton compoundButton, boolean z) {
            if (z) {
                int i = 0;
                for (Model model : CreateTileAdaptor.this.f2806) {
                    if (model.f944.booleanValue()) {
                        i++;
                    }
                }
                if (i >= 4) {
                    C0826.m2179(R$string.shortcut_count_limit_tips, 4);
                    this.mSw.mo7525(false, false);
                    r4.f944 = false;
                    return;
                }
            }
            r4.f944 = Boolean.valueOf(z);
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
        }
    }
}
