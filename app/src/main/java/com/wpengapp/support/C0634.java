package com.wpengapp.support;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.wpengapp.baseui.AppWrapper;
import com.wpengapp.baseui.widget.ChoiceAppListView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.Γ */
/* compiled from: ChoiceAppListView */
public class C0634 extends Thread {

    /* renamed from: ֏ */
    public final /* synthetic */ ChoiceAppListView.C0423 f1611;

    /* renamed from: ؠ */
    public final /* synthetic */ ChoiceAppListView f1612;

    public C0634(ChoiceAppListView choiceAppListView, ChoiceAppListView.C0423 r2) {
        this.f1612 = choiceAppListView;
        this.f1611 = r2;
    }

    public void run() {
        try {
            setPriority(10);
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = this.f1612.getContext().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null) {
                queryIntentActivities = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                AppWrapper appWrapper = new AppWrapper();
                appWrapper.resolveInfo = resolveInfo;
                appWrapper.packageName = resolveInfo.activityInfo.packageName;
                appWrapper.className = resolveInfo.activityInfo.name;
                appWrapper.name = resolveInfo.loadLabel(this.f1612.getContext().getPackageManager());
                arrayList.add(appWrapper);
            }
            this.f1612.f290.addAll(arrayList);
            this.f1612.post(new C0921(this));
        } catch (Throwable th) {
            th.getMessage();
            ((ChoiceAppListView) this.f1611).mo8220();
        }
    }
}
