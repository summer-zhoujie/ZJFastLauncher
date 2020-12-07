package com.wpengapp.support;

import android.support.p000v4.view.PointerIconCompat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.wpengapp.support.Ǩ */
public class Huffman {

    /* renamed from: ֏ */
    public static final int[] f990 = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: ؠ */
    public static final byte[] f991 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: ހ */
    public static final Huffman f992 = new Huffman();

    /* renamed from: ށ */
    public final C0529 f993 = new C0529();

    public Huffman() {
        int i = 0;
        while (true) {
            byte[] bArr = f991;
            if (i < bArr.length) {
                int i2 = f990[i];
                byte b = bArr[i];
                C0529 r3 = new C0529(i, b);
                C0529 r4 = this.f993;
                while (b > 8) {
                    b = (byte) (b - 8);
                    int i3 = (i2 >>> b) & 255;
                    C0529[] r6 = r4.f994;
                    if (r6 != null) {
                        if (r6[i3] == null) {
                            r6[i3] = new C0529();
                        }
                        r4 = r4.f994[i3];
                    } else {
                        throw new IllegalStateException("invalid dictionary: prefix not unique");
                    }
                }
                int i4 = 8 - b;
                int i5 = (i2 << i4) & 255;
                int i6 = 1 << i4;
                for (int i7 = i5; i7 < i5 + i6; i7++) {
                    r4.f994[i7] = r3;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8115(com.wpengapp.support.ByteString r9, com.wpengapp.support.BufferedSink r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = 0
        L_0x0005:
            int r4 = r9.mo8002()
            r5 = 8
            r6 = 255(0xff, float:3.57E-43)
            if (r0 >= r4) goto L_0x002e
            byte r4 = r9.mo7992((int) r0)
            r4 = r4 & r6
            int[] r6 = f990
            r6 = r6[r4]
            byte[] r7 = f991
            byte r4 = r7[r4]
            long r2 = r2 << r4
            long r6 = (long) r6
            long r2 = r2 | r6
            int r1 = r1 + r4
        L_0x0020:
            if (r1 < r5) goto L_0x002b
            int r1 = r1 + -8
            long r6 = r2 >> r1
            int r4 = (int) r6
            r10.writeByte(r4)
            goto L_0x0020
        L_0x002b:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x002e:
            if (r1 <= 0) goto L_0x003a
            int r5 = r5 - r1
            long r2 = r2 << r5
            int r9 = r6 >>> r1
            long r0 = (long) r9
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.writeByte(r9)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Huffman.mo8115(com.wpengapp.support.ק, com.wpengapp.support.ǡ):void");
    }

    /* renamed from: com.wpengapp.support.Ǩ$֏ */
    /* compiled from: Huffman */
    private static final class C0529 {

        /* renamed from: ֏ */
        public final C0529[] f994;

        /* renamed from: ؠ */
        public final int f995;

        /* renamed from: ހ */
        public final int f996;

        public C0529() {
            this.f994 = new C0529[256];
            this.f995 = 0;
            this.f996 = 0;
        }

        public C0529(int i, int i2) {
            this.f994 = null;
            this.f995 = i;
            int i3 = i2 & 7;
            this.f996 = i3 == 0 ? 8 : i3;
        }
    }

    /* renamed from: ֏ */
    public int mo8114(ByteString r6) {
        long j = 0;
        for (int i = 0; i < r6.mo8002(); i++) {
            j += (long) f991[r6.mo7992(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    /* renamed from: ֏ */
    public byte[] mo8116(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0529 r4 = this.f993;
        byte b = 0;
        int i = 0;
        for (byte b2 : bArr) {
            b = (b << 8) | (b2 & 255);
            i += 8;
            while (i >= 8) {
                r4 = r4.f994[(b >>> (i - 8)) & 255];
                if (r4.f994 == null) {
                    byteArrayOutputStream.write(r4.f995);
                    i -= r4.f996;
                    r4 = this.f993;
                } else {
                    i -= 8;
                }
            }
        }
        while (i > 0) {
            C0529 r8 = r4.f994[(b << (8 - i)) & 255];
            if (r8.f994 != null || r8.f996 > i) {
                break;
            }
            byteArrayOutputStream.write(r8.f995);
            i -= r8.f996;
            r4 = this.f993;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
