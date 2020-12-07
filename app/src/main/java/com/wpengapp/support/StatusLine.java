package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import java.net.ProtocolException;

/* renamed from: com.wpengapp.support.ଥ */
public final class StatusLine {

    /* renamed from: ֏ */
    public final Protocol f3225;

    /* renamed from: ؠ */
    public final int f3226;

    /* renamed from: ހ */
    public final String f3227;

    public StatusLine(Protocol r1, int i, String str) {
        this.f3225 = r1;
        this.f3226 = i;
        this.f3227 = str;
    }

    /* renamed from: ֏ */
    public static StatusLine m3036(String str) {
        Protocol r0;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                r0 = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                r0 = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
            }
        } else if (str.startsWith("ICY ")) {
            r0 = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = BidiFormatter.EMPTY_STRING;
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
                }
                return new StatusLine(r0, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
            }
        } else {
            throw new ProtocolException(outline.m2556("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3225 == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f3226);
        if (this.f3227 != null) {
            sb.append(' ');
            sb.append(this.f3227);
        }
        return sb.toString();
    }
}
