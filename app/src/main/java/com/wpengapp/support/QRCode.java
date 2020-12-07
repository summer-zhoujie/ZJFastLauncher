package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ࠤ */
public final class QRCode {

    /* renamed from: ֏ */
    public Mode f2790;

    /* renamed from: ؠ */
    public ErrorCorrectionLevel f2791;

    /* renamed from: ހ */
    public Version f2792;

    /* renamed from: ށ */
    public int f2793 = -1;

    /* renamed from: ނ */
    public ByteMatrix f2794;

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f2790);
        sb.append("\n ecLevel: ");
        sb.append(this.f2791);
        sb.append("\n version: ");
        sb.append(this.f2792);
        sb.append("\n maskPattern: ");
        sb.append(this.f2793);
        if (this.f2794 == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f2794);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
