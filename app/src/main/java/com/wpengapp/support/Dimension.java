package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ޚ */
public final class Dimension {

    /* renamed from: ֏ */
    public final int f2643;

    /* renamed from: ؠ */
    public final int f2644;

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension r4 = (Dimension) obj;
            if (this.f2643 == r4.f2643 && this.f2644 == r4.f2644) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f2643 * 32713) + this.f2644;
    }

    public String toString() {
        return this.f2643 + "x" + this.f2644;
    }
}
