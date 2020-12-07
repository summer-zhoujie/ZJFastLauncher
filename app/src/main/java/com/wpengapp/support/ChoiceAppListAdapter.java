package com.wpengapp.support;

import com.wpengapp.baseui.AppWrapper;
import java.util.Comparator;

/* renamed from: com.wpengapp.support.ľ */
class ChoiceAppListAdapter implements Comparator<AppWrapper> {

    /* renamed from: ֏ */
    public final /* synthetic */ C0961 f807;

    public ChoiceAppListAdapter(C0961 r1) {
        this.f807 = r1;
    }

    public int compare(Object obj, Object obj2) {
        AppWrapper appWrapper = (AppWrapper) obj;
        AppWrapper appWrapper2 = (AppWrapper) obj2;
        boolean contains = this.f807.f2672.contains(appWrapper);
        boolean contains2 = this.f807.f2672.contains(appWrapper2);
        if (contains && !contains2) {
            return -1;
        }
        if ((contains || !contains2) && appWrapper != null) {
            return appWrapper.compareTo(appWrapper2);
        }
        return 1;
    }
}
