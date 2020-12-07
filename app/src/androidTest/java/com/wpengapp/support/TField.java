package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ƴ */
public class TField {

    /* renamed from: ֏ */
    public final String f958;

    /* renamed from: ؠ */
    public final byte f959;

    /* renamed from: ހ */
    public final short f960;

    public TField(String str, byte b, short s) {
        this.f958 = str;
        this.f959 = b;
        this.f960 = s;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("<TField name:'");
        r0.append(this.f958);
        r0.append("' type:");
        r0.append(this.f959);
        r0.append(" field-id:");
        r0.append(this.f960);
        r0.append(">");
        return r0.toString();
    }
}
