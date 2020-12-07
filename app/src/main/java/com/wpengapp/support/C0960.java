package com.wpengapp.support;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.wpengapp.support.ޱ */
/* compiled from: HighLevelEncoder */
public final class C0960 {

    /* renamed from: ֏ */
    public static final String[] f2665 = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: ؠ */
    public static final int[][] f2666 = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: ހ */
    public static final int[][] f2667;

    /* renamed from: ށ */
    public static final int[][] f2668;

    /* renamed from: ނ */
    public final byte[] f2669;

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, 256});
        f2667 = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            f2667[0][i] = (i - 65) + 2;
        }
        f2667[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            f2667[1][i2] = (i2 - 97) + 2;
        }
        f2667[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            f2667[2][i3] = (i3 - 48) + 2;
        }
        int[][] iArr2 = f2667;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            f2667[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            if (iArr4[i5] > 0) {
                f2667[4][iArr4[i5]] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        f2668 = iArr5;
        for (int[] fill : iArr5) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr6 = f2668;
        iArr6[0][4] = 0;
        iArr6[1][4] = 0;
        iArr6[1][0] = 28;
        iArr6[3][4] = 0;
        iArr6[2][4] = 0;
        iArr6[2][0] = 15;
    }

    public C0960(byte[] bArr) {
        this.f2669 = bArr;
    }

    /* renamed from: ֏ */
    public static Collection<State> m2566(Iterable<State> iterable) {
        LinkedList linkedList = new LinkedList();
        for (State next : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                State r4 = (State) it.next();
                if (r4.mo9071(next)) {
                    z = false;
                    break;
                } else if (next.mo9071(r4)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }
}
