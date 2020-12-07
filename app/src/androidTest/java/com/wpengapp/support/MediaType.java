package com.wpengapp.support;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.wpengapp.support.ظ */
public final class MediaType {

    /* renamed from: ֏ */
    public static final Pattern f2308 = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: ؠ */
    public static final Pattern f2309 = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: ހ */
    public final String f2310;

    /* renamed from: ށ */
    public final String f2311;

    public MediaType(String str, String str2, String str3, String str4) {
        this.f2310 = str;
        this.f2311 = str4;
    }

    /* renamed from: ֏ */
    public static MediaType m2278(String str) {
        Matcher matcher = f2308.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f2309.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 == null) {
                            group2 = matcher2.group(3);
                        } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                            group2 = group2.substring(1, group2.length() - 1);
                        }
                        if (str2 == null || group2.equalsIgnoreCase(str2)) {
                            str2 = group2;
                        } else {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                        }
                    }
                    end = matcher2.end();
                } else {
                    StringBuilder r3 = outline.m2549("Parameter is not formatted correctly: \"");
                    r3.append(str.substring(end));
                    r3.append("\" for: \"");
                    r3.append(str);
                    r3.append('\"');
                    throw new IllegalArgumentException(r3.toString());
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    /* renamed from: ؠ */
    public static MediaType m2279(String str) {
        try {
            return m2278(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f2310.equals(this.f2310);
    }

    public int hashCode() {
        return this.f2310.hashCode();
    }

    public String toString() {
        return this.f2310;
    }

    /* renamed from: ֏ */
    public Charset mo8765(Charset charset) {
        try {
            return this.f2311 != null ? Charset.forName(this.f2311) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
