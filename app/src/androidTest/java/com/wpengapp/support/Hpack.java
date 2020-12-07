package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.widget.ActivityChooserView;
import com.umeng.analytics.social.UMSocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Η */
public final class Hpack {

    /* renamed from: ֏ */
    public static final Header[] f1614 = {new Header(Header.f2923, BidiFormatter.EMPTY_STRING), new Header(Header.f2920, "GET"), new Header(Header.f2920, "POST"), new Header(Header.f2921, "/"), new Header(Header.f2921, "/index.html"), new Header(Header.f2922, "http"), new Header(Header.f2922, "https"), new Header(Header.f2919, "200"), new Header(Header.f2919, "204"), new Header(Header.f2919, "206"), new Header(Header.f2919, "304"), new Header(Header.f2919, "400"), new Header(Header.f2919, "404"), new Header(Header.f2919, "500"), new Header("accept-charset", (String) BidiFormatter.EMPTY_STRING), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", (String) BidiFormatter.EMPTY_STRING), new Header("accept-ranges", (String) BidiFormatter.EMPTY_STRING), new Header("accept", (String) BidiFormatter.EMPTY_STRING), new Header("access-control-allow-origin", (String) BidiFormatter.EMPTY_STRING), new Header("age", (String) BidiFormatter.EMPTY_STRING), new Header("allow", (String) BidiFormatter.EMPTY_STRING), new Header("authorization", (String) BidiFormatter.EMPTY_STRING), new Header("cache-control", (String) BidiFormatter.EMPTY_STRING), new Header("content-disposition", (String) BidiFormatter.EMPTY_STRING), new Header("content-encoding", (String) BidiFormatter.EMPTY_STRING), new Header("content-language", (String) BidiFormatter.EMPTY_STRING), new Header("content-length", (String) BidiFormatter.EMPTY_STRING), new Header("content-location", (String) BidiFormatter.EMPTY_STRING), new Header("content-range", (String) BidiFormatter.EMPTY_STRING), new Header("content-type", (String) BidiFormatter.EMPTY_STRING), new Header("cookie", (String) BidiFormatter.EMPTY_STRING), new Header((String) UMSocialConstants.f253l, (String) BidiFormatter.EMPTY_STRING), new Header("etag", (String) BidiFormatter.EMPTY_STRING), new Header("expect", (String) BidiFormatter.EMPTY_STRING), new Header("expires", (String) BidiFormatter.EMPTY_STRING), new Header("from", (String) BidiFormatter.EMPTY_STRING), new Header("host", (String) BidiFormatter.EMPTY_STRING), new Header("if-match", (String) BidiFormatter.EMPTY_STRING), new Header("if-modified-since", (String) BidiFormatter.EMPTY_STRING), new Header("if-none-match", (String) BidiFormatter.EMPTY_STRING), new Header("if-range", (String) BidiFormatter.EMPTY_STRING), new Header("if-unmodified-since", (String) BidiFormatter.EMPTY_STRING), new Header("last-modified", (String) BidiFormatter.EMPTY_STRING), new Header("link", (String) BidiFormatter.EMPTY_STRING), new Header("location", (String) BidiFormatter.EMPTY_STRING), new Header("max-forwards", (String) BidiFormatter.EMPTY_STRING), new Header("proxy-authenticate", (String) BidiFormatter.EMPTY_STRING), new Header("proxy-authorization", (String) BidiFormatter.EMPTY_STRING), new Header("range", (String) BidiFormatter.EMPTY_STRING), new Header("referer", (String) BidiFormatter.EMPTY_STRING), new Header("refresh", (String) BidiFormatter.EMPTY_STRING), new Header("retry-after", (String) BidiFormatter.EMPTY_STRING), new Header("server", (String) BidiFormatter.EMPTY_STRING), new Header("set-cookie", (String) BidiFormatter.EMPTY_STRING), new Header("strict-transport-security", (String) BidiFormatter.EMPTY_STRING), new Header("transfer-encoding", (String) BidiFormatter.EMPTY_STRING), new Header("user-agent", (String) BidiFormatter.EMPTY_STRING), new Header("vary", (String) BidiFormatter.EMPTY_STRING), new Header("via", (String) BidiFormatter.EMPTY_STRING), new Header("www-authenticate", (String) BidiFormatter.EMPTY_STRING)};

    /* renamed from: ؠ */
    public static final Map<ByteString, Integer> f1615;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1614.length);
        while (true) {
            Header[] r1 = f1614;
            if (i < r1.length) {
                if (!linkedHashMap.containsKey(r1[i].f2924)) {
                    linkedHashMap.put(f1614[i].f2924, Integer.valueOf(i));
                }
                i++;
            } else {
                f1615 = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    /* renamed from: ֏ */
    public static ByteString m1621(ByteString r4) {
        int r0 = r4.mo8002();
        int i = 0;
        while (i < r0) {
            byte r2 = r4.mo7992(i);
            if (r2 < 65 || r2 > 90) {
                i++;
            } else {
                StringBuilder r1 = outline.m2549("PROTOCOL_ERROR response malformed: mixed case name: ");
                r1.append(r4.mo8005());
                throw new IOException(r1.toString());
            }
        }
        return r4;
    }

    /* renamed from: com.wpengapp.support.Η$֏ */
    /* compiled from: Hpack */
    static final class C0635 {

        /* renamed from: ֏ */
        public final List<Header> f1616 = new ArrayList();

        /* renamed from: ؠ */
        public final BufferedSource f1617;

        /* renamed from: ހ */
        public final int f1618;

        /* renamed from: ށ */
        public int f1619;

        /* renamed from: ނ */
        public Header[] f1620 = new Header[8];

        /* renamed from: ރ */
        public int f1621 = (this.f1620.length - 1);

        /* renamed from: ބ */
        public int f1622 = 0;

        /* renamed from: ޅ */
        public int f1623 = 0;

        public C0635(int i, Source r3) {
            this.f1618 = i;
            this.f1619 = i;
            this.f1617 = C0745.m1951(r3);
        }

        /* renamed from: ֏ */
        public final void mo8375() {
            Arrays.fill(this.f1620, (Object) null);
            this.f1621 = this.f1620.length - 1;
            this.f1622 = 0;
            this.f1623 = 0;
        }

        /* renamed from: ؠ */
        public final int mo8377(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f1620.length;
                while (true) {
                    length--;
                    if (length < this.f1621 || i <= 0) {
                        Header[] r5 = this.f1620;
                        int i3 = this.f1621;
                        System.arraycopy(r5, i3 + 1, r5, i3 + 1 + i2, this.f1622);
                        this.f1621 += i2;
                    } else {
                        Header[] r2 = this.f1620;
                        i -= r2[length].f2926;
                        this.f1623 -= r2[length].f2926;
                        this.f1622--;
                        i2++;
                    }
                }
                Header[] r52 = this.f1620;
                int i32 = this.f1621;
                System.arraycopy(r52, i32 + 1, r52, i32 + 1 + i2, this.f1622);
                this.f1621 += i2;
            }
            return i2;
        }

        /* renamed from: ހ */
        public final ByteString mo8380(int i) {
            if (i >= 0 && i <= Hpack.f1614.length + -1) {
                return Hpack.f1614[i].f2924;
            }
            int r0 = mo8373(i - Hpack.f1614.length);
            if (r0 >= 0) {
                Header[] r1 = this.f1620;
                if (r0 < r1.length) {
                    return r1[r0].f2924;
                }
            }
            StringBuilder r12 = outline.m2549("Header index too large ");
            r12.append(i + 1);
            throw new IOException(r12.toString());
        }

        /* renamed from: ށ */
        public final boolean mo8381(int i) {
            return i >= 0 && i <= Hpack.f1614.length - 1;
        }

        /* renamed from: ֏ */
        public final int mo8373(int i) {
            return this.f1621 + 1 + i;
        }

        /* renamed from: ֏ */
        public final void mo8376(int i, Header r7) {
            this.f1616.add(r7);
            int i2 = r7.f2926;
            if (i != -1) {
                i2 -= this.f1620[(this.f1621 + 1) + i].f2926;
            }
            int i3 = this.f1619;
            if (i2 > i3) {
                mo8375();
                return;
            }
            int r2 = mo8377((this.f1623 + i2) - i3);
            if (i == -1) {
                int i4 = this.f1622 + 1;
                Header[] r1 = this.f1620;
                if (i4 > r1.length) {
                    Header[] r6 = new Header[(r1.length * 2)];
                    System.arraycopy(r1, 0, r6, r1.length, r1.length);
                    this.f1621 = this.f1620.length - 1;
                    this.f1620 = r6;
                }
                int i5 = this.f1621;
                this.f1621 = i5 - 1;
                this.f1620[i5] = r7;
                this.f1622++;
            } else {
                this.f1620[this.f1621 + 1 + i + r2 + i] = r7;
            }
            this.f1623 += i2;
        }

        /* renamed from: ؠ */
        public List<Header> mo8378() {
            ArrayList arrayList = new ArrayList(this.f1616);
            this.f1616.clear();
            return arrayList;
        }

        /* renamed from: ހ */
        public ByteString mo8379() {
            byte readByte = this.f1617.readByte() & 255;
            boolean z = (readByte & 128) == 128;
            int r0 = mo8374((int) readByte, 127);
            if (z) {
                return ByteString.m2187(Huffman.f992.mo8116(this.f1617.mo8494((long) r0)));
            }
            return this.f1617.mo8486((long) r0);
        }

        /* renamed from: ֏ */
        public int mo8374(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte readByte = this.f1617.readByte() & 255;
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & Byte.MAX_VALUE) << i4;
                i4 += 7;
            }
        }
    }

    /* renamed from: com.wpengapp.support.Η$ؠ */
    /* compiled from: Hpack */
    static final class C0636 {

        /* renamed from: ֏ */
        public final Buffer f1624;

        /* renamed from: ؠ */
        public final boolean f1625 = true;

        /* renamed from: ހ */
        public int f1626 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

        /* renamed from: ށ */
        public boolean f1627;

        /* renamed from: ނ */
        public int f1628 = 4096;

        /* renamed from: ރ */
        public Header[] f1629 = new Header[8];

        /* renamed from: ބ */
        public int f1630 = (this.f1629.length - 1);

        /* renamed from: ޅ */
        public int f1631 = 0;

        /* renamed from: ކ */
        public int f1632 = 0;

        public C0636(Buffer r2) {
            this.f1624 = r2;
        }

        /* renamed from: ֏ */
        public final void mo8383() {
            Arrays.fill(this.f1629, (Object) null);
            this.f1630 = this.f1629.length - 1;
            this.f1631 = 0;
            this.f1632 = 0;
        }

        /* renamed from: ؠ */
        public void mo8388(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f1628;
            if (i2 != min) {
                if (min < i2) {
                    this.f1626 = Math.min(this.f1626, min);
                }
                this.f1627 = true;
                this.f1628 = min;
                int i3 = this.f1628;
                int i4 = this.f1632;
                if (i3 >= i4) {
                    return;
                }
                if (i3 == 0) {
                    mo8383();
                } else {
                    mo8382(i4 - i3);
                }
            }
        }

        /* renamed from: ֏ */
        public final int mo8382(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f1629.length;
                while (true) {
                    length--;
                    if (length < this.f1630 || i <= 0) {
                        Header[] r5 = this.f1629;
                        int i3 = this.f1630;
                        System.arraycopy(r5, i3 + 1, r5, i3 + 1 + i2, this.f1631);
                        Header[] r52 = this.f1629;
                        int i4 = this.f1630;
                        Arrays.fill(r52, i4 + 1, i4 + 1 + i2, (Object) null);
                        this.f1630 += i2;
                    } else {
                        Header[] r2 = this.f1629;
                        i -= r2[length].f2926;
                        this.f1632 -= r2[length].f2926;
                        this.f1631--;
                        i2++;
                    }
                }
                Header[] r53 = this.f1629;
                int i32 = this.f1630;
                System.arraycopy(r53, i32 + 1, r53, i32 + 1 + i2, this.f1631);
                Header[] r522 = this.f1629;
                int i42 = this.f1630;
                Arrays.fill(r522, i42 + 1, i42 + 1 + i2, (Object) null);
                this.f1630 += i2;
            }
            return i2;
        }

        /* renamed from: ֏ */
        public final void mo8386(Header r7) {
            int i = r7.f2926;
            int i2 = this.f1628;
            if (i > i2) {
                mo8383();
                return;
            }
            mo8382((this.f1632 + i) - i2);
            int i3 = this.f1631 + 1;
            Header[] r2 = this.f1629;
            if (i3 > r2.length) {
                Header[] r1 = new Header[(r2.length * 2)];
                System.arraycopy(r2, 0, r1, r2.length, r2.length);
                this.f1630 = this.f1629.length - 1;
                this.f1629 = r1;
            }
            int i4 = this.f1630;
            this.f1630 = i4 - 1;
            this.f1629[i4] = r7;
            this.f1631++;
            this.f1632 += i;
        }

        /* renamed from: ֏ */
        public void mo8387(List<Header> list) {
            int i;
            int i2;
            if (this.f1627) {
                int i3 = this.f1626;
                if (i3 < this.f1628) {
                    mo8384(i3, 31, 32);
                }
                this.f1627 = false;
                this.f1626 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                mo8384(this.f1628, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header r3 = list.get(i4);
                ByteString r4 = r3.f2924.mo8003();
                ByteString r5 = r3.f2925;
                Integer num = Hpack.f1615.get(r4);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (Util.m950((Object) Hpack.f1614[i2 - 1].f2925, (Object) r5)) {
                            i = i2;
                        } else if (Util.m950((Object) Hpack.f1614[i2].f2925, (Object) r5)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f1630 + 1;
                    int length = this.f1629.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Util.m950((Object) this.f1629[i5].f2924, (Object) r4)) {
                            if (Util.m950((Object) this.f1629[i5].f2925, (Object) r5)) {
                                i2 = Hpack.f1614.length + (i5 - this.f1630);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f1630) + Hpack.f1614.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    mo8384(i2, 127, 128);
                } else if (i == -1) {
                    this.f1624.writeByte(64);
                    mo8385(r4);
                    mo8385(r5);
                    mo8386(r3);
                } else if (!r4.mo8724(Header.f2918) || Header.f2923.equals(r4)) {
                    mo8384(i, 63, 64);
                    mo8385(r5);
                    mo8386(r3);
                } else {
                    mo8384(i, 15, 0);
                    mo8385(r5);
                }
            }
        }

        /* renamed from: ֏ */
        public void mo8384(int i, int i2, int i3) {
            if (i < i2) {
                this.f1624.writeByte(i | i3);
                return;
            }
            this.f1624.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f1624.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f1624.writeByte(i4);
        }

        /* renamed from: ֏ */
        public void mo8385(ByteString r4) {
            if (!this.f1625 || Huffman.f992.mo8114(r4) >= r4.mo8002()) {
                mo8384(r4.mo8002(), 127, 0);
                this.f1624.mo9192(r4);
                return;
            }
            Buffer r0 = new Buffer();
            Huffman.f992.mo8115(r4, r0);
            ByteString r42 = r0.mo9202();
            mo8384(r42.mo8002(), 127, 128);
            this.f1624.mo9192(r42);
        }
    }
}
