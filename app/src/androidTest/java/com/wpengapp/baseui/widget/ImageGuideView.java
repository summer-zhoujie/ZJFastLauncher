package com.wpengapp.baseui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.R$layout;
import com.wpengapp.support.C0826;
import java.util.ArrayList;
import java.util.List;

public class ImageGuideView extends FrameLayout {

    /* renamed from: ֏ */
    public ViewPager f306;

    public ImageGuideView(@NonNull Context context) {
        super(context);
        mo7490();
    }

    public void setImages(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(View.inflate(getContext(), R$layout.baseui_image_guide_item, (ViewGroup) null));
        }
        this.f306.setAdapter(new C0641(this, list, arrayList));
    }

    /* renamed from: ֏ */
    public final void mo7490() {
        FrameLayout.inflate(getContext(), R$layout.baseui_image_guide, this);
        View findViewById = findViewById(R$id.img_next);
        findViewById.setAlpha(0.5f);
        findViewById.setOnClickListener(new C0539(this));
        this.f306 = (ViewPager) findViewById(R$id.pager);
        this.f306.setOffscreenPageLimit(2);
        this.f306.setPageMargin(C0826.m2168(8.0f));
        this.f306.addOnPageChangeListener(new C0686(this, findViewById));
    }

    public ImageGuideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mo7490();
    }

    public ImageGuideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo7490();
    }
}
