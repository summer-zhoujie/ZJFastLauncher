package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ഩ */
public class C40Encoder implements C1239 {
    /* renamed from: ؠ */
    public static void m3155(EncoderContext r6, StringBuilder sb) {
        char charAt = sb.charAt(0);
        int charAt2 = (sb.charAt(1) * '(') + (charAt * 1600) + sb.charAt(2) + 1;
        r6.f3588.append(new String(new char[]{(char) (charAt2 / 256), (char) (charAt2 % 256)}));
        sb.delete(0, 3);
    }

    /* renamed from: ֏ */
    public int mo9387() {
        return 1;
    }

    /* renamed from: ֏ */
    public void mo9379(EncoderContext r9) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!r9.mo9522()) {
                break;
            }
            char r1 = r9.mo9520();
            r9.f3589++;
            int r12 = mo9388(r1, sb);
            int r5 = r9.mo9516() + ((sb.length() / 3) << 1);
            r9.mo9519(r5);
            int i = r9.f3591.f3628 - r5;
            if (r9.mo9522()) {
                if (sb.length() % 3 == 0 && C1279.m3385((CharSequence) r9.f3584, r9.f3589, mo9387()) != mo9387()) {
                    r9.f3590 = 0;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i < 2 || i > 2)) {
                    r12 = mo9389(r9, sb, sb2, r12);
                }
                while (sb.length() % 3 == 1 && ((r12 <= 3 && i != 1) || r12 > 3)) {
                    r12 = mo9389(r9, sb, sb2, r12);
                }
            }
        }
        mo9390(r9, sb);
    }

    /* renamed from: ֏ */
    public final int mo9389(EncoderContext r2, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        r2.f3589--;
        int r3 = mo9388(r2.mo9520(), sb2);
        r2.f3591 = null;
        return r3;
    }

    /* renamed from: ֏ */
    public void mo9390(EncoderContext r8, StringBuilder sb) {
        int length = sb.length() % 3;
        int r4 = r8.mo9516() + ((sb.length() / 3) << 1);
        r8.mo9519(r4);
        int i = r8.f3591.f3628 - r4;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                m3155(r8, sb);
            }
            if (r8.mo9522()) {
                r8.f3588.append(254);
            }
        } else if (i == 1 && length == 1) {
            while (sb.length() >= 3) {
                m3155(r8, sb);
            }
            if (r8.mo9522()) {
                r8.f3588.append(254);
            }
            r8.f3589--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                m3155(r8, sb);
            }
            if (i > 0 || r8.mo9522()) {
                r8.f3588.append(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        r8.f3590 = 0;
    }

    /* renamed from: ֏ */
    public int mo9388(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return mo9388((char) (c - 128), sb) + 2;
        } else {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }
}
