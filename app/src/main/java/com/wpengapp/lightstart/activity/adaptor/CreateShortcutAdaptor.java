package com.wpengapp.lightstart.activity.adaptor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p000v4.content.p001pm.ShortcutInfoCompat;
import android.support.p000v4.content.p001pm.ShortcutManagerCompat;
import android.support.p000v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AppShortcut;
import com.wpengapp.support.AppUtils;
import com.wpengapp.support.BaseItem;
import com.wpengapp.support.BaseRecyclerCommonAdapter;
import com.wpengapp.support.C0583;
import com.wpengapp.support.C0710;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0738;
import com.wpengapp.support.C0774;
import com.wpengapp.support.C0826;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0958;
import com.wpengapp.support.C1206;
import com.wpengapp.support.Image;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.TaskManager;
import com.wpengapp.support.Utils;
import com.wpengapp.support.outline;

public class CreateShortcutAdaptor extends BaseRecyclerCommonAdapter<AppShortcut> {

    public class Item_ViewBinding<T extends Item> implements Unbinder {
        @UiThread
        public Item_ViewBinding(T t, View view) {
            t.mImgIcon = (ImageView) C0958.m2538(view, 2131165311, "field 'mImgIcon'", ImageView.class);
            t.mTvName = (TextView) C0958.m2538(view, 2131165529, "field 'mTvName'", TextView.class);
            t.mTvCreate = C0958.m2537(view, R$id.tv_create, "field 'mTvCreate'");
            t.mBottomLine = C0958.m2537(view, 2131165240, "field 'mBottomLine'");
        }
    }

    public CreateShortcutAdaptor(Context context) {
        super(context);
    }

    @NonNull
    /* renamed from: ֏ */
    public BaseItem<AppShortcut> mo7698(Object obj) {
        return new Item();
    }

    /* renamed from: ށ */
    public final void mo7699() {
        C0915 r0 = new C0915(this.f2805);
        r0.f2469 = false;
        r0.mo8899((int) R$string.need_shortcut_permission, 17);
        r0.mo8900(2131493077, (OnDialogClickListener) null);
        r0.mo8906(2131493159, (OnDialogClickListener) C1206.f3457);
        r0.mo8910();
    }

    class Item extends BaseItem<AppShortcut> {
        public View mBottomLine;
        public ImageView mImgIcon;
        public View mTvCreate;
        public TextView mTvName;

        public Item() {
        }

        /* renamed from: ֏ */
        public int mo7700() {
            return R$layout.item_create_launcher_shortcut;
        }

        /* renamed from: ֏ */
        public void mo7704(Object obj, int i) {
            AppShortcut r5 = (AppShortcut) obj;
            Bitmap r0 = C0774.m2081(r5);
            if (r0 != null) {
                this.mImgIcon.setImageBitmap(r0);
            } else if (!TextUtils.isEmpty(r5.f940)) {
                this.mImgIcon.setImageResource(2131099733);
                Image.m3366().mo8349(r5.f940, this.mImgIcon);
            } else {
                int i2 = r5.f943;
                if (i2 != -1) {
                    this.mImgIcon.setImageResource(i2);
                } else {
                    this.mImgIcon.setImageResource(2131099733);
                }
            }
            this.mTvName.setText(r5.f938);
            this.mBottomLine.setVisibility(i == CreateShortcutAdaptor.this.getItemCount() + -1 ? 4 : 0);
            this.mTvCreate.setOnClickListener(new C0710(this, r5));
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7703(AppShortcut r1, View view) {
            TaskManager.m2715((Runnable) new C0583(this, r1));
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo7702(AppShortcut r9) {
            boolean z;
            boolean z2 = true;
            if (!(!C0719.m1832() || Utils.m1856(10017) == 0)) {
                AppUtils.m1146((Runnable) new C0738(CreateShortcutAdaptor.this));
                return;
            }
            Bitmap r0 = r9.mo8070();
            if (r0 == null) {
                C0826.m2179(R$string.create_error_img, new Object[0]);
                return;
            }
            StringBuilder r3 = outline.m2549("laun_");
            r3.append(r9.f936);
            String sb = r3.toString();
            String str = r9.f938;
            Intent r92 = C0774.m2080(r9.f936, "launcher");
            Application r5 = AppUtils.getApplication();
            if (ShortcutManagerCompat.isRequestPinShortcutSupported(r5)) {
                if (TextUtils.isEmpty(r92.getAction())) {
                    r92.setAction("android.intent.action.VIEW");
                }
                z = ShortcutManagerCompat.requestPinShortcut(r5, new ShortcutInfoCompat.Builder(r5, sb).setIcon(IconCompat.createWithBitmap(r0)).setShortLabel(str).setLongLabel(str).setIntent(r92).build(), (IntentSender) null);
            } else {
                z = false;
            }
            if (!z) {
                Application r32 = AppUtils.getApplication();
                if (TextUtils.isEmpty(r92.getAction())) {
                    r92.setAction("android.intent.action.VIEW");
                }
                Intent intent = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
                intent.putExtra("android.intent.extra.shortcut.NAME", str);
                intent.putExtra("android.intent.extra.shortcut.ICON", r0);
                intent.putExtra("android.intent.extra.shortcut.INTENT", r92);
                r32.sendBroadcast(intent);
                if (Build.VERSION.SDK_INT >= 26) {
                    z2 = false;
                }
            }
            if (!z2) {
                C0826.m2177((CharSequence) AppUtils.m1141((int) R$string.quick_if_fail, new Object[0]) + AppUtils.m1141((int) R$string.need_shortcut_permission, new Object[0]));
            } else if (Build.VERSION.SDK_INT < 26 || C0719.m1832()) {
                C0826.m2179(R$string.created, new Object[0]);
            }
        }

        /* renamed from: ֏ */
        public void mo7701(View view) {
            ButterKnife.m31(this, view);
        }
    }
}
