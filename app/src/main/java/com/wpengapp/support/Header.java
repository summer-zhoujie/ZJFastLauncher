package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ण */
public final class Header {

    /* renamed from: ֏ */
    public static final ByteString f2918 = ByteString.m2188(":");

    /* renamed from: ؠ */
    public static final ByteString f2919 = ByteString.m2188(":status");

    /* renamed from: ހ */
    public static final ByteString f2920 = ByteString.m2188(":method");

    /* renamed from: ށ */
    public static final ByteString f2921 = ByteString.m2188(":path");

    /* renamed from: ނ */
    public static final ByteString f2922 = ByteString.m2188(":scheme");

    /* renamed from: ރ */
    public static final ByteString f2923 = ByteString.m2188(":authority");

    /* renamed from: ބ */
    public final ByteString f2924;

    /* renamed from: ޅ */
    public final ByteString f2925;

    /* renamed from: ކ */
    public final int f2926;

    public Header(String str, String str2) {
        this(ByteString.m2188(str), ByteString.m2188(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header r4 = (Header) obj;
        if (!this.f2924.equals(r4.f2924) || !this.f2925.equals(r4.f2925)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f2925.hashCode() + ((this.f2924.hashCode() + 527) * 31);
    }

    public String toString() {
        return Util.m937("%s: %s", this.f2924.mo8005(), this.f2925.mo8005());
    }

    public Header(ByteString r1, String str) {
        this(r1, ByteString.m2188(str));
    }

    public Header(ByteString r1, ByteString r2) {
        this.f2924 = r1;
        this.f2925 = r2;
        this.f2926 = r2.mo8002() + r1.mo8002() + 32;
    }
}
