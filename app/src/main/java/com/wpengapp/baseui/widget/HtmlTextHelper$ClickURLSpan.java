package com.wpengapp.baseui.widget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.URLSpan;
import android.view.View;
import com.wpengapp.support.HtmlTextHelper;
import com.wpengapp.support.outline;

public class HtmlTextHelper$ClickURLSpan extends URLSpan {
    public static final Creator<HtmlTextHelper$ClickURLSpan> CREATOR = new C0998();

    /* renamed from: ֏ */
    public String f303;

    /* renamed from: ؠ */
    public CharSequence f304;

    /* renamed from: ހ */
    public HtmlTextHelper f305;

    public HtmlTextHelper$ClickURLSpan(String str, CharSequence charSequence, HtmlTextHelper r3) {
        super(str);
        this.f303 = str;
        this.f304 = charSequence;
        this.f305 = r3;
    }

    public int describeContents() {
        return 0;
    }

    public void onClick(View view) {
        Uri parse = Uri.parse(this.f303);
        if ("click".equals(parse.getScheme())) {
            HtmlTextHelper r4 = this.f305;
            if (r4 != null) {
                r4.mo7949(parse.getHost(), this.f304);
                return;
            }
            return;
        }
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder r42 = outline.m2549("Actvity was not found for intent, ");
            r42.append(intent.toString());
            r42.toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f303);
    }

    public HtmlTextHelper$ClickURLSpan(Parcel parcel) {
        super(parcel);
        this.f303 = parcel.readString();
    }
}
