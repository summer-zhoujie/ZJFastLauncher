package com.wpengapp.support;

import android.text.TextUtils;
import com.wpengapp.support.activity.WPengAppsActivity;
import com.wpengapp.support.model.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.ה */
/* compiled from: WPengAppsActivity */
class C0819 extends HttpGsonRequest<List<App>> {

    /* renamed from: ދ */
    public final /* synthetic */ WPengAppsActivity f2133;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0819(WPengAppsActivity wPengAppsActivity, String str, Map map, String str2) {
        super(str, map, str2);
        this.f2133 = wPengAppsActivity;
    }

    /* renamed from: ֏ */
    public void mo7981(Exception exc) {
        this.f2133.mo7430();
        WPengAppsActivity.m816(this.f2133);
    }

    /* renamed from: ֏ */
    public void mo7980(HttpResponse<List<App>> r3, ErrorCode r4) {
        this.f2133.mo7430();
        List list = r3.f3518;
        if (list != null) {
            List list2 = list;
            if (!SmartBarUtils.m2774()) {
                list2 = new ArrayList();
                for (App app : (List) r3.f3518) {
                    if (!app.isMeizuApp() || !TextUtils.isEmpty(app.indexUrl)) {
                        list2.add(app);
                    }
                }
            }
            WPengAppsActivity.C0451 r32 = this.f2133.f642;
            r32.f644.clear();
            r32.f644.addAll(list2);
            r32.notifyDataSetChanged();
            C1063.m2864();
            return;
        }
        WPengAppsActivity.m816(this.f2133);
    }
}
