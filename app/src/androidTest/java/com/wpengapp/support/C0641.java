package com.wpengapp.support;

import android.support.annotation.NonNull;
import android.support.p000v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wpengapp.baseui.R$id;
import com.wpengapp.baseui.widget.ImageGuideView;
import java.util.List;

/* renamed from: com.wpengapp.support.Ϊ */
/* compiled from: ImageGuideView */
class C0641 extends PagerAdapter {

    /* renamed from: ֏ */
    public final /* synthetic */ List f1643;

    /* renamed from: ؠ */
    public final /* synthetic */ List f1644;

    public C0641(ImageGuideView imageGuideView, List list, List list2) {
        this.f1643 = list;
        this.f1644 = list2;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.f1643.size();
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View view = (View) this.f1644.get(i);
        viewGroup.addView(view);
        Image.m3366().mo8350((String) this.f1643.get(i), (ImageView) view.findViewById(R$id.img_content), (SimpleImageLoadingListener) new ImageGuideView(this, view));
        return view;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
