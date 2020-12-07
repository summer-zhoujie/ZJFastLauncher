package android.support.p000v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.TypedValue;
import com.wpengapp.support.outline;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public final class ResourcesCompat {
    public static final String TAG = "ResourcesCompat";

    /* renamed from: android.support.v4.content.res.ResourcesCompat$FontCallback */
    public static abstract class FontCallback {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void callbackFailAsync(final int i, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i, theme);
        }
        return resources.getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        return resources.getColorStateList(i);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) {
        int i2 = Build.VERSION.SDK_INT;
        return resources.getDrawable(i, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) {
        int i3 = Build.VERSION.SDK_INT;
        return resources.getDrawableForDensity(i, i2, theme);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, (FontCallback) null, (Handler) null, false);
    }

    public static Typeface loadFont(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z);
        if (loadFont != null || fontCallback != null) {
            return loadFont;
        }
        StringBuilder r10 = outline.m2549("Font resource ID #0x");
        r10.append(Integer.toHexString(i));
        r10.append(" could not be retrieved.");
        throw new Resources.NotFoundException(r10.toString());
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull FontCallback fontCallback, @Nullable Handler handler) {
        if (fontCallback == null) {
            throw new NullPointerException();
        } else if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Typeface loadFont(@android.support.annotation.NonNull Context r13, Resources r14, TypedValue r15, int r16, int r17, @android.support.annotation.Nullable ResourcesCompat.FontCallback r18, @android.support.annotation.Nullable Handler r19, boolean r20) {
        /*
            r2 = r14
            r0 = r15
            r3 = r16
            r4 = r17
            r8 = r18
            r9 = r19
            java.lang.CharSequence r1 = r0.string
            if (r1 == 0) goto L_0x007d
            java.lang.String r10 = r1.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r10.startsWith(r0)
            r11 = 0
            r12 = -3
            if (r0 != 0) goto L_0x0022
            if (r8 == 0) goto L_0x0021
            r8.callbackFailAsync(r12, r9)
        L_0x0021:
            return r11
        L_0x0022:
            android.graphics.Typeface r0 = android.support.p000v4.graphics.TypefaceCompat.findFromCache(r14, r3, r4)
            if (r0 == 0) goto L_0x002e
            if (r8 == 0) goto L_0x002d
            r8.callbackSuccessAsync(r0, r9)
        L_0x002d:
            return r0
        L_0x002e:
            java.lang.String r0 = r10.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            if (r0 == 0) goto L_0x005b
            android.content.res.XmlResourceParser r0 = r14.getXml(r3)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            android.support.v4.content.res.FontResourcesParserCompat$FamilyResourceEntry r1 = android.support.p000v4.content.res.FontResourcesParserCompat.parse(r0, r14)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            if (r1 != 0) goto L_0x004a
            if (r8 == 0) goto L_0x0049
            r8.callbackFailAsync(r12, r9)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
        L_0x0049:
            return r11
        L_0x004a:
            r0 = r13
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            android.graphics.Typeface r0 = android.support.p000v4.graphics.TypefaceCompat.createFromResourcesFamilyXml(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            return r0
        L_0x005b:
            r0 = r13
            android.graphics.Typeface r0 = android.support.p000v4.graphics.TypefaceCompat.createFromResourcesFontFile(r13, r14, r3, r10, r4)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            if (r8 == 0) goto L_0x006b
            if (r0 == 0) goto L_0x0068
            r8.callbackSuccessAsync(r0, r9)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
            goto L_0x006b
        L_0x0068:
            r8.callbackFailAsync(r12, r9)     // Catch:{ XmlPullParserException -> 0x0072, IOException -> 0x006c }
        L_0x006b:
            return r0
        L_0x006c:
            java.lang.String r0 = "Failed to read xml resource "
            com.wpengapp.support.outline.m2555((java.lang.String) r0, (java.lang.String) r10)
            goto L_0x0077
        L_0x0072:
            java.lang.String r0 = "Failed to parse xml resource "
            com.wpengapp.support.outline.m2555((java.lang.String) r0, (java.lang.String) r10)
        L_0x0077:
            if (r8 == 0) goto L_0x007c
            r8.callbackFailAsync(r12, r9)
        L_0x007c:
            return r11
        L_0x007d:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.String r4 = "Resource \""
            java.lang.StringBuilder r4 = com.wpengapp.support.outline.m2549(r4)
            java.lang.String r2 = r14.getResourceName(r3)
            r4.append(r2)
            java.lang.String r2 = "\" ("
            r4.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r16)
            r4.append(r2)
            java.lang.String r2 = ") is not a Font: "
            r4.append(r2)
            r4.append(r15)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, (Handler) null, true);
    }
}
