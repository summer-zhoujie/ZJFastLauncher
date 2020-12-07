package com.wpengapp.support;

import java.util.Map;

/* renamed from: com.wpengapp.support.ၻ */
public final class UPCAWriter implements Writer {

    /* renamed from: ֏ */
    public final EAN13Writer f3684 = new EAN13Writer();

    /* renamed from: ֏ */
    public BitMatrix mo9001(String str, BarcodeFormat r9, int i, int i2, Map<EncodeHintType, ?> map) {
        if (r9 == BarcodeFormat.UPC_A) {
            return this.f3684.mo9001("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(r9)));
    }
}
