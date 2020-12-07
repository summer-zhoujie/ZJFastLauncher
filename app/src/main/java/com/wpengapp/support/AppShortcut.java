package com.wpengapp.support;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.wpengapp.support.ƨ */
public class AppShortcut {
    @SerializedName("id")

    /* renamed from: ֏ */
    public String f936;
    @SerializedName("pkg")

    /* renamed from: ؠ */
    public String f937;
    @SerializedName("name")

    /* renamed from: ހ */
    public String f938;
    @SerializedName("ints")

    /* renamed from: ށ */
    public String[] f939;
    @SerializedName("icon")

    /* renamed from: ނ */
    public String f940;
    @SerializedName("type")

    /* renamed from: ރ */
    public int f941 = 0;
    @SerializedName("icbg")

    /* renamed from: ބ */
    public Integer f942;
    @Expose(deserialize = false, serialize = false)
    @DrawableRes

    /* renamed from: ޅ */
    public int f943 = -1;
    @Expose(deserialize = false, serialize = false)

    /* renamed from: ކ */
    public Boolean f944;
    @Expose(deserialize = false, serialize = false)

    /* renamed from: އ */
    public Boolean f945;

    /* renamed from: ֏ */
    public Bitmap mo8070() {
        Bitmap r0;
        try {
            r0 = C0774.m2081(this);
            if (r0 == null) {
                if (!TextUtils.isEmpty(this.f940)) {
                    r0 = Image.m3366().mo8346(this.f940);
                } else if (this.f943 != -1) {
                    r0 = Utils.m1862(AppUtils.getApplication().getDrawable(this.f943));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
        if (r0 == null) {
            if (this.f937.equals("com.tencent.mm")) {
                r0 = Utils.m1862(AppUtils.getApplication().getDrawable(2131099795));
            } else if (this.f937.equals("com.eg.android.AlipayGphone")) {
                r0 = Utils.m1862(AppUtils.getApplication().getDrawable(2131099790));
            } else {
                r0 = Utils.m1862(AppUtils.getApplication().getDrawable(2131099733));
            }
        }
        if (r0.getWidth() * r0.getHeight() * 4 <= 943718) {
            return r0;
        }
        float min = (float) Math.min(C0826.m2168(64.0f), 480);
        Matrix matrix = new Matrix();
        matrix.postScale(min / ((float) r0.getWidth()), min / ((float) r0.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(r0, 0, 0, r0.getWidth(), r0.getHeight(), matrix, true);
        return createBitmap != null ? createBitmap : r0;
    }
}
