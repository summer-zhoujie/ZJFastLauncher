package com.wpengapp.baseui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ListView;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.support.C0634;
import com.wpengapp.support.C0961;
import com.wpengapp.support.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChoiceAppListView extends ListView {

    /* renamed from: ֏ */
    public C0961 f289;

    /* renamed from: ؠ */
    public List<AppWrapper> f290;

    /* renamed from: ހ */
    public Set<AppWrapper> f291;

    /* renamed from: ށ */
    public Set<String> f292;

    /* renamed from: ނ */
    public Set<String> f293;

    /* renamed from: ރ */
    public boolean f294;

    /* renamed from: ބ */
    public boolean f295 = false;

    /* renamed from: ޅ */
    public boolean f296 = false;

    /* renamed from: ކ */
    public String f297;

    /* renamed from: com.wpengapp.baseui.widget.ChoiceAppListView$֏ */
    private interface C0423 {
    }

    /* renamed from: com.wpengapp.baseui.widget.ChoiceAppListView$ؠ */
    public interface C0424 {
        /* renamed from: ֏ */
        void mo7476(boolean z, AppWrapper appWrapper);
    }

    public ChoiceAppListView(Context context) {
        super(context);
        mo7471();
    }

    public C0961 getAppListAdapter() {
        return this.f289;
    }

    public AppWrapper getChoiceApp() {
        C0961 r0 = this.f289;
        if (r0.f2672.size() > 0) {
            return r0.f2672.iterator().next();
        }
        return null;
    }

    public Set<AppWrapper> getMarkedAppList() {
        return this.f289.f2672;
    }

    public Set<String> getMarkedPkgList() {
        HashSet hashSet = new HashSet();
        for (AppWrapper appWrapper : getMarkedAppList()) {
            hashSet.add(appWrapper.packageName);
        }
        return hashSet;
    }

    public void setAdapter(C0961 r1) {
        this.f289 = r1;
        super.setAdapter(r1);
    }

    public void setExcludeAppList(Collection<AppWrapper> collection) {
        this.f291.clear();
        this.f291.addAll(collection);
    }

    public void setExcludePackages(Collection<String> collection) {
        this.f292.clear();
        this.f292.addAll(collection);
    }

    public void setOnAppMarkedChangedListener(C0424 r2) {
        this.f289.f2678 = r2;
    }

    public void setPadding(int i) {
        this.f289.f2676 = i;
    }

    public void setSingleChoice(boolean z) {
        this.f289.f2675 = z;
    }

    /* renamed from: ֏ */
    public final void mo7471() {
        this.f290 = new ArrayList();
        this.f291 = new HashSet();
        this.f292 = new HashSet();
    }

    /* renamed from: ؠ */
    public void mo7475() {
        this.f296 = false;
        if (this.f295) {
            this.f289.mo9011(m277(this.f290, this.f291, this.f292, this.f297));
            return;
        }
        ChoiceAppListView r0 = new ChoiceAppListView(this);
        if (!this.f295) {
            this.f290.clear();
            this.f295 = true;
            C0961 r2 = r0.f1273.f289;
            r2.f2677 = true;
            r2.notifyDataSetChanged();
            new C0634(this, r0).start();
        }
    }

    public ChoiceAppListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7471();
    }

    /* renamed from: ֏ */
    public void mo7472(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f297 = null;
        } else {
            this.f297 = str.trim().toLowerCase();
        }
        if (!this.f296) {
            mo7475();
        }
    }

    public ChoiceAppListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7471();
    }

    /* renamed from: ֏ */
    public static List<AppWrapper> m277(List<AppWrapper> list, Set<AppWrapper> set, Set<String> set2, String str) {
        ArrayList arrayList = new ArrayList();
        for (AppWrapper next : list) {
            if (!set.contains(next) && !set2.contains(next.packageName)) {
                if (TextUtils.isEmpty(str) || (!TextUtils.isEmpty(next.name) && next.name.toString().toLowerCase().contains(str))) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    @TargetApi(21)
    public ChoiceAppListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo7471();
    }

    /* renamed from: ֏ */
    public void mo7473(Collection<AppWrapper> collection, boolean z) {
        C0961 r0 = this.f289;
        r0.f2672.clear();
        r0.f2672.addAll(collection);
        r0.f2673 = z;
        r0.notifyDataSetChanged();
    }

    /* renamed from: ֏ */
    public void mo7474(Set<String> set, boolean z) {
        this.f293 = set;
        this.f294 = z;
        if (!CollectionUtils.m1657((Collection) this.f290)) {
            if (CollectionUtils.m1657((Collection) this.f293)) {
                mo7473((Collection<AppWrapper>) new HashSet(), z);
                return;
            }
            HashSet hashSet = new HashSet();
            for (AppWrapper next : this.f290) {
                if (set.contains(next.packageName)) {
                    hashSet.add(next);
                }
            }
            mo7473((Collection<AppWrapper>) hashSet, z);
        }
    }
}
