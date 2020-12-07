package com.wpengapp.support;

import android.support.p000v4.view.ViewPager;
import android.view.View;
import com.wpengapp.baseui.widget.ImageGuideView;

/* renamed from: com.wpengapp.support.Ї */
/* compiled from: ImageGuideView */
class C0686 extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: ֏ */
    public final /* synthetic */ View f1780;

    /* renamed from: ؠ */
    public final /* synthetic */ ImageGuideView f1781;

    public C0686(ImageGuideView imageGuideView, View view) {
        this.f1781 = imageGuideView;
        this.f1780 = view;
    }

    public void onPageSelected(int i) {
        if (i == this.f1781.f306.getAdapter().getCount() - 1) {
            this.f1780.setVisibility(4);
        } else {
            this.f1780.setVisibility(0);
        }
    }
}
