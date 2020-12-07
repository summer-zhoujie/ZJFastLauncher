package com.wpengapp.support;

import android.support.annotation.IdRes;
import android.util.TypedValue;
import android.view.View;

/* renamed from: com.wpengapp.support.ޗ */
/* compiled from: Utils */
public final class C0958 {
    static {
        try {
            Class.forName("android.support.v4.graphics.drawable.DrawableCompat");
        } catch (ClassNotFoundException | VerifyError unused) {
        }
        new TypedValue();
    }

    /* renamed from: ֏ */
    public static View m2537(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String r3 = m2539(view, i);
        StringBuilder sb = new StringBuilder();
        sb.append("Required view '");
        sb.append(r3);
        sb.append("' with ID ");
        sb.append(i);
        sb.append(" for ");
        throw new IllegalStateException(outline.m2548(sb, str, " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."));
    }

    /* renamed from: ֏ */
    public static <T> T m2538(View view, @IdRes int i, String str, Class<T> cls) {
        View r3 = m2537(view, i, str);
        try {
            return cls.cast(r3);
        } catch (ClassCastException e) {
            String r32 = m2539(r3, i);
            StringBuilder sb = new StringBuilder();
            sb.append("View '");
            sb.append(r32);
            sb.append("' with ID ");
            sb.append(i);
            sb.append(" for ");
            throw new IllegalStateException(outline.m2548(sb, str, " was of the wrong type. See cause for more info."), e);
        }
    }

    /* renamed from: ֏ */
    public static String m2539(View view, @IdRes int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }
}
