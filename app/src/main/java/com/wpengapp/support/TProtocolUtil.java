package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ⴚ */
public class TProtocolUtil {

    /* renamed from: ֏ */
    public static int f3741 = Integer.MAX_VALUE;

    /* renamed from: ֏ */
    public static void m3568(TProtocol r3, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    r3.mo8598();
                    return;
                case 3:
                    r3.mo8599();
                    return;
                case 4:
                    r3.mo8603();
                    return;
                case 6:
                    r3.mo8600();
                    return;
                case 8:
                    r3.mo8601();
                    return;
                case 10:
                    r3.mo8602();
                    return;
                case 11:
                    r3.mo8572();
                    return;
                case 12:
                    r3.mo8588();
                    while (true) {
                        byte b2 = r3.mo8590().f959;
                        if (b2 == 0) {
                            r3.mo8589();
                            return;
                        } else {
                            m3568(r3, b2, i - 1);
                            r3.mo8591();
                        }
                    }
                case 13:
                    TMap r4 = r3.mo8592();
                    while (i2 < r4.f3637) {
                        int i3 = i - 1;
                        m3568(r3, r4.f3635, i3);
                        m3568(r3, r4.f3636, i3);
                        i2++;
                    }
                    r3.mo8593();
                    return;
                case 14:
                    TSet r42 = r3.mo8596();
                    while (i2 < r42.f880) {
                        m3568(r3, r42.f879, i - 1);
                        i2++;
                    }
                    r3.mo8597();
                    return;
                case 15:
                    TList r43 = r3.mo8594();
                    while (i2 < r43.f3356) {
                        m3568(r3, r43.f3355, i - 1);
                        i2++;
                    }
                    r3.mo8595();
                    return;
                default:
                    return;
            }
        } else {
            throw new TException("Maximum skip depth exceeded");
        }
    }
}
