package com.wpengapp.support;

import java.nio.charset.StandardCharsets;

/* renamed from: com.wpengapp.support.ྈ */
public final class EncoderContext {

    /* renamed from: ֏ */
    public final String f3584;

    /* renamed from: ؠ */
    public SymbolShapeHint f3585;

    /* renamed from: ހ */
    public Dimension f3586;

    /* renamed from: ށ */
    public Dimension f3587;

    /* renamed from: ނ */
    public final StringBuilder f3588;

    /* renamed from: ރ */
    public int f3589;

    /* renamed from: ބ */
    public int f3590;

    /* renamed from: ޅ */
    public SymbolInfo f3591;

    /* renamed from: ކ */
    public int f3592;

    public EncoderContext(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                sb.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f3584 = sb.toString();
        this.f3585 = SymbolShapeHint.FORCE_NONE;
        this.f3588 = new StringBuilder(str.length());
        this.f3590 = -1;
    }

    /* renamed from: ֏ */
    public void mo9517(int i) {
        this.f3592 = i;
    }

    /* renamed from: ؠ */
    public StringBuilder mo9518() {
        return this.f3588;
    }

    /* renamed from: ހ */
    public char mo9520() {
        return this.f3584.charAt(this.f3589);
    }

    /* renamed from: ށ */
    public int mo9521() {
        return (this.f3584.length() - this.f3592) - this.f3589;
    }

    /* renamed from: ނ */
    public boolean mo9522() {
        return this.f3589 < this.f3584.length() - this.f3592;
    }

    /* renamed from: ރ */
    public void mo9523() {
        mo9519(mo9516());
    }

    /* renamed from: ֏ */
    public int mo9516() {
        return this.f3588.length();
    }

    /* renamed from: ؠ */
    public void mo9519(int i) {
        SymbolInfo r0 = this.f3591;
        if (r0 == null || i > r0.f3628) {
            this.f3591 = SymbolInfo.m3447(i, this.f3585, this.f3586, this.f3587, true);
        }
    }
}
