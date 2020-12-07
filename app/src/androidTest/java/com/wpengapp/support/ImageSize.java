package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ا */
public class ImageSize {

    /* renamed from: ֏ */
    public final int f2221;

    /* renamed from: ؠ */
    public final int f2222;

    public ImageSize(int i, int i2) {
        this.f2221 = i;
        this.f2222 = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f2221);
        sb.append("x");
        sb.append(this.f2222);
        return sb.toString();
    }

    /* renamed from: ֏ */
    public ImageSize mo8739(int i) {
        return new ImageSize(this.f2221 / i, this.f2222 / i);
    }

    public ImageSize(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f2221 = i;
            this.f2222 = i2;
            return;
        }
        this.f2221 = i2;
        this.f2222 = i;
    }
}
