package com.wpengapp.support;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.ࢩ */
public final class ReedSolomonEncoder {

    /* renamed from: ֏ */
    public final GenericGF f2880;

    /* renamed from: ؠ */
    public final List<GenericGFPoly> f2881 = new ArrayList();

    public ReedSolomonEncoder(GenericGF r6) {
        this.f2880 = r6;
        this.f2881.add(new GenericGFPoly(r6, new int[]{1}));
    }

    /* renamed from: ֏ */
    public void mo9106(int[] iArr, int i) {
        int[] iArr2 = iArr;
        int i2 = i;
        if (i2 != 0) {
            int length = iArr2.length - i2;
            if (length > 0) {
                int i3 = 2;
                int i4 = 0;
                int i5 = 1;
                if (i2 >= this.f2881.size()) {
                    List<GenericGFPoly> list = this.f2881;
                    GenericGFPoly r4 = list.get(list.size() - 1);
                    int size = this.f2881.size();
                    while (size <= i2) {
                        GenericGF r10 = this.f2880;
                        int[] iArr3 = new int[i3];
                        iArr3[i4] = i5;
                        iArr3[i5] = r10.f2872[(size - 1) + r10.f2877];
                        if (iArr3.length != 0) {
                            int length2 = iArr3.length;
                            if (length2 > i5 && iArr3[i4] == 0) {
                                int i6 = 1;
                                while (i6 < length2 && iArr3[i6] == 0) {
                                    i6++;
                                }
                                if (i6 == length2) {
                                    iArr3 = new int[i5];
                                    iArr3[i4] = i4;
                                } else {
                                    int[] iArr4 = new int[(length2 - i6)];
                                    System.arraycopy(iArr3, i6, iArr4, i4, iArr4.length);
                                    iArr3 = iArr4;
                                }
                            }
                            if (r4.f2878.equals(r10)) {
                                if (!r4.mo9105()) {
                                    if (!(iArr3[i4] == 0)) {
                                        int[] iArr5 = r4.f2879;
                                        int length3 = iArr5.length;
                                        int length4 = iArr3.length;
                                        int[] iArr6 = new int[((length3 + length4) - 1)];
                                        for (int i7 = 0; i7 < length3; i7++) {
                                            int i8 = iArr5[i7];
                                            int i9 = 0;
                                            while (i9 < length4) {
                                                int i10 = i7 + i9;
                                                iArr6[i10] = GenericGF.m2675(iArr6[i10], r4.f2878.mo9099(i8, iArr3[i9]));
                                                i9++;
                                                iArr5 = iArr5;
                                                length3 = length3;
                                            }
                                            int[] iArr7 = iArr5;
                                            int i11 = length3;
                                        }
                                        r4 = new GenericGFPoly(r4.f2878, iArr6);
                                        this.f2881.add(r4);
                                        size++;
                                        i3 = 2;
                                        i4 = 0;
                                        i5 = 1;
                                    }
                                }
                                r4 = r4.f2878.f2874;
                                this.f2881.add(r4);
                                size++;
                                i3 = 2;
                                i4 = 0;
                                i5 = 1;
                            } else {
                                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                GenericGFPoly r42 = this.f2881.get(i2);
                int[] iArr8 = new int[length];
                System.arraycopy(iArr2, 0, iArr8, 0, length);
                GenericGF r8 = this.f2880;
                if (iArr8.length != 0) {
                    int length5 = iArr8.length;
                    if (length5 > 1 && iArr8[0] == 0) {
                        int i12 = 1;
                        while (i12 < length5 && iArr8[i12] == 0) {
                            i12++;
                        }
                        if (i12 == length5) {
                            iArr8 = new int[]{0};
                        } else {
                            int[] iArr9 = new int[(length5 - i12)];
                            System.arraycopy(iArr8, i12, iArr9, 0, iArr9.length);
                            iArr8 = iArr9;
                        }
                    }
                    if (i2 >= 0) {
                        int length6 = iArr8.length;
                        int[] iArr10 = new int[(i2 + length6)];
                        for (int i13 = 0; i13 < length6; i13++) {
                            iArr10[i13] = r8.mo9099(iArr8[i13], 1);
                        }
                        GenericGFPoly r6 = new GenericGFPoly(r8, iArr10);
                        if (!r6.f2878.equals(r42.f2878)) {
                            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                        } else if (!r42.mo9105()) {
                            GenericGFPoly r5 = r6.f2878.f2874;
                            int r7 = r6.f2878.mo9096(r42.mo9102(r42.mo9101()));
                            GenericGFPoly r82 = r5;
                            GenericGFPoly r52 = r6;
                            while (r52.mo9101() >= r42.mo9101() && !r52.mo9105()) {
                                int r9 = r52.mo9101() - r42.mo9101();
                                int r102 = r6.f2878.mo9099(r52.mo9102(r52.mo9101()), r7);
                                GenericGFPoly r11 = r42.mo9103(r9, r102);
                                r82 = r82.mo9104(r6.f2878.mo9098(r9, r102));
                                r52 = r52.mo9104(r11);
                            }
                            int[] iArr11 = new GenericGFPoly[]{r82, r52}[1].f2879;
                            int length7 = i2 - iArr11.length;
                            for (int i14 = 0; i14 < length7; i14++) {
                                iArr2[length + i14] = 0;
                            }
                            System.arraycopy(iArr11, 0, iArr2, length + length7, iArr11.length);
                        } else {
                            throw new IllegalArgumentException("Divide by 0");
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException("No data bytes provided");
            }
        } else {
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
