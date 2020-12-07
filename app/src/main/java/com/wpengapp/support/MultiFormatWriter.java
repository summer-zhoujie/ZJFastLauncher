package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ޝ */
public final class MultiFormatWriter implements Writer {
    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r9, int i, int i2, Map<EncodeHintType, ?> map) {
        Writer r0;
        switch (r9.ordinal()) {
            case 0:
                r0 = new AztecWriter();
                break;
            case 1:
                r0 = new CodaBarWriter();
                break;
            case 2:
                r0 = new Code39Writer();
                break;
            case 3:
                r0 = new Code93Writer();
                break;
            case 4:
                r0 = new Code128Writer();
                break;
            case 5:
                r0 = new DataMatrixWriter();
                break;
            case 6:
                r0 = new EAN8Writer();
                break;
            case 7:
                r0 = new EAN13Writer();
                break;
            case 8:
                r0 = new ITFWriter();
                break;
            case 10:
                r0 = new PDF417Writer();
                break;
            case 11:
                r0 = new QRCodeWriter();
                break;
            case 14:
                r0 = new UPCAWriter();
                break;
            case 15:
                r0 = new UPCEWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(r9)));
        }
        return r0.mo9001(str, r9, i, i2, map);
    }
}
