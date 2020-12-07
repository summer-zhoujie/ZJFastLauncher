package com.wpengapp.lightstart.activity;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.baseui.widget.ChoiceAppListView;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$layout;
import com.wpengapp.lightstart.R$menu;
import com.wpengapp.lightstart.R$string;
import com.wpengapp.support.AppConfig;
import com.wpengapp.support.C0471;
import com.wpengapp.support.C0719;
import com.wpengapp.support.C0887;
import com.wpengapp.support.C0889;
import com.wpengapp.support.C0913;
import com.wpengapp.support.C0915;
import com.wpengapp.support.C0961;
import com.wpengapp.support.C1003;
import com.wpengapp.support.C1219;
import com.wpengapp.support.C1257;
import com.wpengapp.support.OnDialogClickListener;
import com.wpengapp.support.PageConfig;
import com.wpengapp.support.activity.WPengBaseActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class AppReportActivity extends WPengBaseActivity {

    /* renamed from: ֏ */
    public ChoiceAppListView f408;

    /* renamed from: com.wpengapp.lightstart.activity.AppReportActivity$֏ */
    private class C0436 extends C0961 {
        public C0436(Context context) {
            super(context);
        }

        /* renamed from: ֏ */
        public void mo7564(int i, View view, C0962 r3, AppWrapper appWrapper) {
            super.mo7564(i, view, r3, appWrapper);
            view.setOnClickListener(new C0938(this, appWrapper));
        }

        /* renamed from: ؠ */
        public int mo7565() {
            return R$layout.item_setup_app_list;
        }
    }

    /* renamed from: ֏ */
    public static void m353(Context context, String str) {
        boolean z;
        AppConfig r3;
        Map<String, PageConfig> map;
        C0471.m1025(str);
        if (C0719.m1832() && (r3 = C1219.m3271(str)) != null && (map = r3.f3019) != null) {
            Iterator<PageConfig> it = map.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!TextUtils.isEmpty(it.next().f2979)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (z) {
            C0915 r32 = new C0915(context);
            r32.mo8905(R$string.app_report_confirm_jump);
            r32.mo8906(2131493116, (OnDialogClickListener) C0887.f2403);
            r32.mo8910();
            return;
        }
        C0915 r33 = new C0915(context);
        r33.mo8905(R$string.app_report_custom);
        r33.mo8898(2131493077);
        r33.mo8906((int) R$string.app_report_custom_right, (OnDialogClickListener) new C1257(context));
        r33.mo8910();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R$layout.activity_choose_app);
        this.f408 = (ChoiceAppListView) findViewById(R$id.list_app);
        this.f408.setAdapter(new C0436(this));
        this.f408.setExcludePackages(Collections.singletonList(getPackageName()));
        this.f408.mo7475();
        mo7434().setLayoutTransition(new LayoutTransition());
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131165220) {
            return false;
        }
        View inflate = View.inflate(this, R$layout.toolbar_input_text, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R$id.et_input);
        editText.setHint(R$string.app_search_hint);
        inflate.findViewById(R$id.tv_cancel).setOnClickListener(new C0889(this));
        editText.addTextChangedListener(new com.wpengapp.support.AppReportActivity(this, new C0913(this, editText)));
        setToolBarCustomView(inflate);
        editText.post(new C1003(this, editText));
        return false;
    }

    /* renamed from: ބ */
    public int mo7437() {
        return R$menu.activity_app_setup_list;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getString(R$string.app_report_select);
    }
}
