package com.wpengapp.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wpengapp.baseui.BaseActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.wpengapp.support.ߒ */
/* compiled from: ShareAdapter */
public abstract class C0969 extends BaseAdapter {

    /* renamed from: ֏ */
    public List<C0970> f2699 = new ArrayList();

    /* renamed from: ؠ */
    public Context f2700;

    /* renamed from: ހ */
    public C0771.C0772 f2701;

    /* renamed from: com.wpengapp.support.ߒ$֏ */
    /* compiled from: ShareAdapter */
    private static class C0970 {

        /* renamed from: ֏ */
        public boolean f2702;

        /* renamed from: ؠ */
        public Drawable f2703;

        /* renamed from: ހ */
        public String f2704;

        /* renamed from: ށ */
        public ComponentName f2705;

        /* renamed from: ނ */
        public ResolveInfo f2706;

        public C0970() {
        }

        public /* synthetic */ C0970(C0869 r1) {
        }
    }

    public C0969(Context context) {
        this.f2700 = context;
        C0763 r0 = (C0763) this;
        List<ComponentName> r02 = C0771.m2064();
        if (r02 == null || r02.isEmpty()) {
            mo9022();
            return;
        }
        for (ComponentName componentName : r02) {
            if (SystemUtils.m3517(mo8616(componentName.getPackageName(), componentName.getClassName(), false))) {
                C0970 r3 = new C0970((C0869) null);
                if (!"com.tencent.mm".equals(componentName.getPackageName()) || !"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(componentName.getClassName())) {
                    r3.f2704 = SystemUtils.m3519(componentName.getPackageName());
                    r3.f2703 = SystemUtils.m3508(componentName.getPackageName());
                } else {
                    r3.f2704 = Utils.m1864(R$string.pw_share_timeline, new Object[0]);
                    r3.f2703 = ContextCompat.getDrawable(context, R$drawable.pw_ic_timeline);
                }
                r3.f2705 = componentName;
                this.f2699.add(r3);
            }
        }
        if (this.f2699.size() > 0) {
            C0970 r03 = new C0970((C0869) null);
            r03.f2704 = context.getString(R$string.pw_share_more);
            r03.f2703 = ContextCompat.getDrawable(context, R$drawable.pw_shape_share_more);
            r03.f2702 = true;
            this.f2699.add(r03);
            return;
        }
        mo9022();
    }

    public int getCount() {
        return this.f2699.size();
    }

    public Object getItem(int i) {
        return this.f2699.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ResolveInfo resolveInfo;
        if (view == null) {
            view = View.inflate(this.f2700, R$layout.pw_item_share, (ViewGroup) null);
        }
        C0970 r3 = this.f2699.get(i);
        ImageView imageView = (ImageView) view.findViewById(R$id.img_icon);
        if (r3.f2703 == null && (resolveInfo = r3.f2706) != null) {
            try {
                r3.f2703 = resolveInfo.loadIcon(SystemUtils.m3526());
            } catch (Throwable unused) {
                r3.f2703 = ContextCompat.getDrawable(AppUtils.getApplication(), R$drawable.baseui_default_app_icon);
            }
        }
        imageView.setImageDrawable(r3.f2703);
        ((TextView) view.findViewById(R$id.tv_name)).setText(r3.f2704);
        view.setOnClickListener(new C0869(this, r3));
        return view;
    }

    /* renamed from: ֏ */
    public abstract Intent mo8616(String str, String str2, boolean z);

    /* renamed from: ֏ */
    public final void mo9022() {
        List<ResolveInfo> r1 = SystemUtils.m3521(mo8616((String) null, (String) null, false));
        if (r1 != null && r1.size() != 0) {
            HashSet hashSet = new HashSet();
            for (C0970 r4 : this.f2699) {
                hashSet.add(r4.f2705.getPackageName());
            }
            for (ResolveInfo next : r1) {
                if (!hashSet.contains(next.activityInfo.packageName)) {
                    C0970 r42 = new C0970((C0869) null);
                    r42.f2704 = SystemUtils.m3519(next.activityInfo.packageName);
                    r42.f2706 = next;
                    r42.f2705 = new ComponentName(next.activityInfo.packageName, next.activityInfo.name);
                    this.f2699.add(r42);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public final void mo9023(C0970 r4) {
        if (r4.f2702) {
            List<C0970> list = this.f2699;
            list.remove(list.size() - 1);
            notifyDataSetChanged();
            TaskManager.m2715((Runnable) new C0890(this));
            return;
        }
        ComponentName componentName = r4.f2705;
        if (componentName != null) {
            Intent r0 = mo8616(componentName.getPackageName(), r4.f2705.getClassName(), true);
            Context context = this.f2700;
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).mo7418((BaseActivity.C0419) new C0842(this, r4));
            } else {
                C0771.C0772 r1 = this.f2701;
                if (r1 != null) {
                    r1.mo8216(r4.f2705.getPackageName(), r4.f2705.getClassName());
                }
            }
            C0771.m2066(this.f2700, r0);
        }
    }
}
