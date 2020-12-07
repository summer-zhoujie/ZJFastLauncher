package com.wpengapp.support;

import android.graphics.Bitmap;
import android.view.View;
import com.wpengapp.baseui.R$id;

/* renamed from: com.wpengapp.support.Ĭ */
class ImageGuideView extends SimpleImageLoadingListener {

    /* renamed from: ֏ */
    public final /* synthetic */ View f795;

    public ImageGuideView(C0641 r1, View view) {
        this.f795 = view;
    }

    /* renamed from: ֏ */
    public void mo7943(String str, View view, Bitmap bitmap) {
        this.f795.findViewById(R$id.progress).setVisibility(8);
    }
}
