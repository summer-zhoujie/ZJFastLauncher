package android.support.p003v7.text;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v7.text.AllCapsTransformationMethod */
public class AllCapsTransformationMethod implements TransformationMethod {
    public Locale mLocale;

    public AllCapsTransformationMethod(Context context) {
        this.mLocale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.mLocale);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
