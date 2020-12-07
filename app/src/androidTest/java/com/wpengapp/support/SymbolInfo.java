package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ဢ */
public class SymbolInfo {

    /* renamed from: ֏ */
    public static SymbolInfo[] f3626 = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};

    /* renamed from: ؠ */
    public final boolean f3627;

    /* renamed from: ހ */
    public final int f3628;

    /* renamed from: ށ */
    public final int f3629;

    /* renamed from: ނ */
    public final int f3630;

    /* renamed from: ރ */
    public final int f3631;

    /* renamed from: ބ */
    public final int f3632;

    /* renamed from: ޅ */
    public final int f3633;

    /* renamed from: ކ */
    public final int f3634;

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    /* renamed from: ֏ */
    public static SymbolInfo m3447(int i, SymbolShapeHint r7, Dimension r8, Dimension r9, boolean z) {
        for (SymbolInfo r3 : f3626) {
            if ((r7 != SymbolShapeHint.FORCE_SQUARE || !r3.f3627) && ((r7 != SymbolShapeHint.FORCE_RECTANGLE || r3.f3627) && ((r8 == null || (r3.mo9543() >= r8.f2643 && r3.mo9542() >= r8.f2644)) && ((r9 == null || (r3.mo9543() <= r9.f2643 && r3.mo9542() <= r9.f2644)) && i <= r3.f3628)))) {
                return r3;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3627 ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f3630);
        sb.append('x');
        sb.append(this.f3631);
        sb.append(", symbol size ");
        sb.append(mo9543());
        sb.append('x');
        sb.append(mo9542());
        sb.append(", symbol data size ");
        sb.append(mo9541());
        sb.append('x');
        sb.append(mo9540());
        sb.append(", codewords ");
        sb.append(this.f3628);
        sb.append('+');
        sb.append(this.f3629);
        return sb.toString();
    }

    /* renamed from: ؠ */
    public int mo9403() {
        return this.f3628 / this.f3633;
    }

    /* renamed from: ހ */
    public final int mo9540() {
        return mo9544() * this.f3631;
    }

    /* renamed from: ށ */
    public final int mo9541() {
        return mo9539() * this.f3630;
    }

    /* renamed from: ނ */
    public final int mo9542() {
        return mo9540() + (mo9544() << 1);
    }

    /* renamed from: ރ */
    public final int mo9543() {
        return mo9541() + (mo9539() << 1);
    }

    /* renamed from: ބ */
    public final int mo9544() {
        int i = this.f3632;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f3627 = z;
        this.f3628 = i;
        this.f3629 = i2;
        this.f3630 = i3;
        this.f3631 = i4;
        this.f3632 = i5;
        this.f3633 = i6;
        this.f3634 = i7;
    }

    /* renamed from: ֏ */
    public final int mo9539() {
        int i = this.f3632;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 4)) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    /* renamed from: ֏ */
    public int mo9402(int i) {
        return this.f3633;
    }
}
