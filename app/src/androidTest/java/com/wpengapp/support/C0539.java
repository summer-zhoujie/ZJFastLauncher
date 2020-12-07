package com.wpengapp.support;

import android.support.p000v4.view.ViewPager;
import android.view.View;
import com.wpengapp.baseui.widget.ImageGuideView;

/* renamed from: com.wpengapp.support.Ȉ */
/* compiled from: ImageGuideView */
class C0539 implements View.OnClickListener {

    /* renamed from: ֏ */
    public final /* synthetic */ ImageGuideView f1051;

    public C0539(ImageGuideView imageGuideView) {
        this.f1051 = imageGuideView;
    }

    public void onClick(View view) {
        if (this.f1051.f306.getCurrentItem() < this.f1051.f306.getAdapter().getCount() - 1) {
            ViewPager viewPager = this.f1051.f306;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }
}
