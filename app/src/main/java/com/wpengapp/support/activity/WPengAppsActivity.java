package com.wpengapp.support.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.wpengapp.support.ApiConstant;
import com.wpengapp.support.C0792;
import com.wpengapp.support.C0875;
import com.wpengapp.support.C0915;
import com.wpengapp.support.Image;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.R$drawable;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;
import com.wpengapp.support.R$string;
import com.wpengapp.support.model.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WPengAppsActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public ListView f641;

    /* renamed from: ؠ */
    public C0451 f642;

    /* renamed from: com.wpengapp.support.activity.WPengAppsActivity$֏ */
    private static class C0451 extends BaseAdapter {

        /* renamed from: ֏ */
        public Context f643;

        /* renamed from: ؠ */
        public List<App> f644 = new ArrayList();

        /* renamed from: com.wpengapp.support.activity.WPengAppsActivity$֏$֏ */
        private static class C0452 {

            /* renamed from: ֏ */
            public TextView f645;

            /* renamed from: ؠ */
            public TextView f646;

            /* renamed from: ހ */
            public ImageView f647;

            public C0452() {
            }

            public /* synthetic */ C0452(C0819 r1) {
            }
        }

        public C0451(Context context) {
            this.f643 = context;
        }

        public int getCount() {
            return this.f644.size();
        }

        public Object getItem(int i) {
            return this.f644.get(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C0452 r6;
            if (view == null || view.getTag() == null) {
                view = View.inflate(this.f643, R$layout.pw_item_wpengapp, (ViewGroup) null);
                r6 = new C0452((C0819) null);
                r6.f645 = (TextView) view.findViewById(R$id.tv_title);
                r6.f646 = (TextView) view.findViewById(R$id.tv_des);
                r6.f647 = (ImageView) view.findViewById(R$id.img_icon);
                view.findViewById(R$id.btn_download);
                view.setTag(r6);
            } else {
                r6 = (C0452) view.getTag();
            }
            App app = this.f644.get(i);
            r6.f645.setText(app.name);
            if (app.mark) {
                r6.f645.setCompoundDrawablesWithIntrinsicBounds(R$drawable.pw_icon_new, 0, 0, 0);
            } else {
                r6.f645.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            r6.f646.setText(app.des);
            r6.f647.setImageResource(R$drawable.baseui_default_app_icon);
            Image.m3366().mo8349(app.iconUrl, r6.f647);
            view.setOnClickListener(new WPengAppsActivity(this, app));
            return view;
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m816(WPengAppsActivity wPengAppsActivity) {
        if (!wPengAppsActivity.mo7442()) {
            C0915 r0 = new C0915(wPengAppsActivity);
            r0.f2469 = false;
            r0.mo8905(R$string.pw_load_fail);
            r0.mo8900(R$string.pw_cancel, (OnDialogClickListener) new C0792(wPengAppsActivity));
            r0.mo8906(R$string.pw_retry, (OnDialogClickListener) new C0875(wPengAppsActivity));
            r0.mo8896().show();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.baseui_activity_listview_nodivider);
        this.f641 = (ListView) findViewById(R$id.list);
        this.f642 = new C0451(this);
        this.f641.setAdapter(this.f642);
        mo7836();
    }

    /* renamed from: ގ */
    public final void mo7836() {
        mo7421(getString(R$string.pw_loading));
        new C0819(this, ApiConstant.f2708, (Map) null, "apps").mo8757(false);
    }
}
