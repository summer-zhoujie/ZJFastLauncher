package com.wpengapp.support;

import android.view.ViewGroup;
import android.widget.TextView;
import com.wpengapp.lightstart.R$color;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.R$string;

/* renamed from: com.wpengapp.support.Ί */
public class FullVersionTag {

    /* renamed from: ֏ */
    public static final int f1606 = C0826.m2168(10.0f);

    /* renamed from: ؠ */
    public static final int f1607 = C0826.m2168(4.0f);

    /* renamed from: ֏ */
    public static void m1615(ViewGroup viewGroup) {
        if (viewGroup.findViewById(R$id.full_tag) == null) {
            TextView textView = new TextView(viewGroup.getContext());
            textView.setId(R$id.full_tag);
            textView.setText(R$string.fullv);
            textView.setBackgroundResource(R$color.app_color_primary_dark);
            textView.setTextColor(-1);
            textView.setTextSize(0, (float) f1606);
            int i = f1607;
            textView.setPadding(i, 0, i, 0);
            textView.setAlpha(0.0f);
            viewGroup.addView(textView, -2, -2);
            textView.post(new C0523(textView, viewGroup));
        }
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m1616(TextView textView, ViewGroup viewGroup) {
        textView.setX((float) ((viewGroup.getWidth() - textView.getWidth()) + 0));
        textView.setAlpha(0.9f);
    }
}
