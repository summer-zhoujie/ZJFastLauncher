package com.wpengapp.support;

import android.os.Parcel;
import android.os.Parcelable;
import com.wpengapp.baseui.widget.HtmlTextHelper$ClickURLSpan;

/* renamed from: com.wpengapp.support.ࡉ */
/* compiled from: HtmlTextHelper */
class C0998 implements Parcelable.Creator<HtmlTextHelper$ClickURLSpan> {
    public Object createFromParcel(Parcel parcel) {
        return new HtmlTextHelper$ClickURLSpan(parcel);
    }

    public Object[] newArray(int i) {
        return new HtmlTextHelper$ClickURLSpan[i];
    }
}
