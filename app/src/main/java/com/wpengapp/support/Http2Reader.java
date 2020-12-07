package com.wpengapp.support;

import android.support.p003v7.widget.ActivityChooserView;
import com.wpengapp.support.C0586;
import com.wpengapp.support.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.wpengapp.support.এ */
public final class Http2Reader implements Closeable {

    /* renamed from: ֏ */
    public static final Logger f2999 = Logger.getLogger(Http2.class.getName());

    /* renamed from: ؠ */
    public final BufferedSource f3000;

    /* renamed from: ހ */
    public final C1046 f3001 = new C1046(this.f3000);

    /* renamed from: ށ */
    public final boolean f3002;

    /* renamed from: ނ */
    public final Hpack.C0635 f3003 = new Hpack.C0635(4096, this.f3001);

    /* renamed from: com.wpengapp.support.এ$ؠ */
    /* compiled from: Http2Reader */
    interface C1047 {
    }

    public Http2Reader(BufferedSource r2, boolean z) {
        this.f3000 = r2;
        this.f3002 = z;
    }

    public void close() {
        this.f3000.close();
    }

    /* renamed from: ֏ */
    public void mo9206(C1047 r7) {
        if (!this.f3002) {
            ByteString r72 = this.f3000.mo8486((long) Http2.f1794.mo8002());
            if (f2999.isLoggable(Level.FINE)) {
                f2999.fine(Util.m937("<< CONNECTION %s", r72.mo7999()));
            }
            if (!Http2.f1794.equals(r72)) {
                Http2.m1762("Expected a connection header but was %s", r72.mo8005());
                throw null;
            }
        } else if (!mo9208(true, r7)) {
            Http2.m1762("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9208(boolean r12, C1047 r13) {
        /*
            r11 = this;
            r0 = 0
            com.wpengapp.support.ਟ r1 = r11.f3000     // Catch:{ IOException -> 0x02fd }
            r2 = 9
            r1.mo8496(r2)     // Catch:{ IOException -> 0x02fd }
            com.wpengapp.support.ਟ r1 = r11.f3000
            int r1 = m2833((com.wpengapp.support.BufferedSource) r1)
            r2 = 1
            r3 = 0
            if (r1 < 0) goto L_0x02ef
            r4 = 16384(0x4000, float:2.2959E-41)
            if (r1 > r4) goto L_0x02ef
            com.wpengapp.support.ਟ r5 = r11.f3000
            byte r5 = r5.readByte()
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            r6 = 4
            if (r12 == 0) goto L_0x0033
            if (r5 != r6) goto L_0x0025
            goto L_0x0033
        L_0x0025:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Byte r13 = java.lang.Byte.valueOf(r5)
            r12[r0] = r13
            java.lang.String r13 = "Expected a SETTINGS frame but was %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0033:
            com.wpengapp.support.ਟ r12 = r11.f3000
            byte r12 = r12.readByte()
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = (byte) r12
            com.wpengapp.support.ਟ r7 = r11.f3000
            int r7 = r7.readInt()
            r8 = 2147483647(0x7fffffff, float:NaN)
            r7 = r7 & r8
            java.util.logging.Logger r9 = f2999
            java.util.logging.Level r10 = java.util.logging.Level.FINE
            boolean r9 = r9.isLoggable(r10)
            if (r9 == 0) goto L_0x0059
            java.util.logging.Logger r9 = f2999
            java.lang.String r10 = com.wpengapp.support.Http2.m1761(r2, r7, r1, r5, r12)
            r9.fine(r10)
        L_0x0059:
            r9 = 8
            switch(r5) {
                case 0: goto L_0x027e;
                case 1: goto L_0x0247;
                case 2: goto L_0x0227;
                case 3: goto L_0x01d5;
                case 4: goto L_0x014b;
                case 5: goto L_0x011a;
                case 6: goto L_0x00e9;
                case 7: goto L_0x009c;
                case 8: goto L_0x0066;
                default: goto L_0x005e;
            }
        L_0x005e:
            com.wpengapp.support.ਟ r12 = r11.f3000
            long r0 = (long) r1
            r12.skip(r0)
            goto L_0x02ee
        L_0x0066:
            if (r1 != r6) goto L_0x008e
            com.wpengapp.support.ਟ r12 = r11.f3000
            int r12 = r12.readInt()
            long r4 = (long) r12
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = r4 & r8
            r8 = 0
            int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0080
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8248((int) r7, (long) r4)
            goto L_0x02ee
        L_0x0080:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Long r13 = java.lang.Long.valueOf(r4)
            r12[r0] = r13
            java.lang.String r13 = "windowSizeIncrement was 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x008e:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_WINDOW_UPDATE length !=4: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x009c:
            if (r1 < r9) goto L_0x00db
            if (r7 != 0) goto L_0x00d3
            com.wpengapp.support.ਟ r12 = r11.f3000
            int r12 = r12.readInt()
            com.wpengapp.support.ਟ r4 = r11.f3000
            int r4 = r4.readInt()
            int r1 = r1 - r9
            com.wpengapp.support.ภ r5 = com.wpengapp.support.C1193.m3222(r4)
            if (r5 == 0) goto L_0x00c5
            com.wpengapp.support.ק r0 = com.wpengapp.support.ByteString.f2163
            if (r1 <= 0) goto L_0x00be
            com.wpengapp.support.ਟ r0 = r11.f3000
            long r3 = (long) r1
            com.wpengapp.support.ק r0 = r0.mo8486((long) r3)
        L_0x00be:
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8249((int) r12, (com.wpengapp.support.C1193) r5, (com.wpengapp.support.ByteString) r0)
            goto L_0x02ee
        L_0x00c5:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_GOAWAY unexpected error code: %d"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x00d3:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "TYPE_GOAWAY streamId != 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x00db:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_GOAWAY length < 8: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x00e9:
            if (r1 != r9) goto L_0x010c
            if (r7 != 0) goto L_0x0104
            com.wpengapp.support.ਟ r1 = r11.f3000
            int r1 = r1.readInt()
            com.wpengapp.support.ਟ r3 = r11.f3000
            int r3 = r3.readInt()
            r12 = r12 & r2
            if (r12 == 0) goto L_0x00fd
            r0 = 1
        L_0x00fd:
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8250((boolean) r0, (int) r1, (int) r3)
            goto L_0x02ee
        L_0x0104:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "TYPE_PING streamId != 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x010c:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_PING length != 8: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x011a:
            if (r7 == 0) goto L_0x0143
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0129
            com.wpengapp.support.ਟ r0 = r11.f3000
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0129:
            com.wpengapp.support.ਟ r3 = r11.f3000
            int r3 = r3.readInt()
            r3 = r3 & r8
            int r1 = r1 + -4
            int r1 = m2832(r1, r12, r0)
            java.util.List r12 = r11.mo9205(r1, r0, r12, r7)
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            com.wpengapp.support.ʂ r13 = com.wpengapp.support.C0586.this
            r13.mo8231((int) r3, (java.util.List<com.wpengapp.support.Header>) r12)
            goto L_0x02ee
        L_0x0143:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x014b:
            if (r7 != 0) goto L_0x01cd
            r12 = r12 & r2
            if (r12 == 0) goto L_0x0161
            if (r1 != 0) goto L_0x0159
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8253()
            goto L_0x02ee
        L_0x0159:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "FRAME_SIZE_ERROR ack frame should be empty!"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0161:
            int r12 = r1 % 6
            if (r12 != 0) goto L_0x01bf
            com.wpengapp.support.შ r12 = new com.wpengapp.support.შ
            r12.<init>()
            r5 = 0
        L_0x016b:
            if (r5 >= r1) goto L_0x01b8
            com.wpengapp.support.ਟ r7 = r11.f3000
            short r7 = r7.readShort()
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            com.wpengapp.support.ਟ r8 = r11.f3000
            int r8 = r8.readInt()
            switch(r7) {
                case 1: goto L_0x01b2;
                case 2: goto L_0x01a5;
                case 3: goto L_0x01a3;
                case 4: goto L_0x0197;
                case 5: goto L_0x0181;
                case 6: goto L_0x01b2;
                default: goto L_0x0180;
            }
        L_0x0180:
            goto L_0x01b2
        L_0x0181:
            if (r8 < r4) goto L_0x0189
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            if (r8 > r9) goto L_0x0189
            goto L_0x01b2
        L_0x0189:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r12[r0] = r13
            java.lang.String r13 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0197:
            r7 = 7
            if (r8 < 0) goto L_0x019b
            goto L_0x01b2
        L_0x019b:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x01a3:
            r7 = 4
            goto L_0x01b2
        L_0x01a5:
            if (r8 == 0) goto L_0x01b2
            if (r8 != r2) goto L_0x01aa
            goto L_0x01b2
        L_0x01aa:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x01b2:
            r12.mo9621(r7, r8)
            int r5 = r5 + 6
            goto L_0x016b
        L_0x01b8:
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8254(r0, r12)
            goto L_0x02ee
        L_0x01bf:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_SETTINGS length %% 6 != 0: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x01cd:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "TYPE_SETTINGS streamId != 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x01d5:
            if (r1 != r6) goto L_0x0219
            if (r7 == 0) goto L_0x0211
            com.wpengapp.support.ਟ r12 = r11.f3000
            int r12 = r12.readInt()
            com.wpengapp.support.ภ r1 = com.wpengapp.support.C1193.m3222(r12)
            if (r1 == 0) goto L_0x0203
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
            boolean r12 = r12.mo8239((int) r7)
            if (r12 == 0) goto L_0x01f6
            com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
            r12.mo8230((int) r7, (com.wpengapp.support.C1193) r1)
            goto L_0x02ee
        L_0x01f6:
            com.wpengapp.support.ʂ r12 = com.wpengapp.support.C0586.this
            com.wpengapp.support.ȁ r12 = r12.mo8240(r7)
            if (r12 == 0) goto L_0x02ee
            r12.mo8127(r1)
            goto L_0x02ee
        L_0x0203:
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13[r0] = r12
            java.lang.String r12 = "TYPE_RST_STREAM unexpected error code: %d"
            com.wpengapp.support.Http2.m1762(r12, r13)
            throw r3
        L_0x0211:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "TYPE_RST_STREAM streamId == 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0219:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_RST_STREAM length: %d != 4"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0227:
            r12 = 5
            if (r1 != r12) goto L_0x0239
            if (r7 == 0) goto L_0x0231
            r11.mo9207((com.wpengapp.support.Http2Reader.C1047) r13, (int) r7)
            goto L_0x02ee
        L_0x0231:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "TYPE_PRIORITY streamId == 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0239:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "TYPE_PRIORITY length: %d != 5"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x0247:
            if (r7 == 0) goto L_0x0276
            r3 = r12 & 1
            if (r3 == 0) goto L_0x024f
            r3 = 1
            goto L_0x0250
        L_0x024f:
            r3 = 0
        L_0x0250:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x025d
            com.wpengapp.support.ਟ r0 = r11.f3000
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x025d:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x0266
            r11.mo9207((com.wpengapp.support.Http2Reader.C1047) r13, (int) r7)
            int r1 = r1 + -5
        L_0x0266:
            int r1 = m2832(r1, r12, r0)
            java.util.List r12 = r11.mo9205(r1, r0, r12, r7)
            r0 = -1
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            r13.mo8251((boolean) r3, (int) r7, (int) r0, (java.util.List<com.wpengapp.support.Header>) r12)
            goto L_0x02ee
        L_0x0276:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x027e:
            if (r7 == 0) goto L_0x02e6
            r4 = r12 & 1
            if (r4 == 0) goto L_0x0286
            r4 = 1
            goto L_0x0287
        L_0x0286:
            r4 = 0
        L_0x0287:
            r5 = r12 & 32
            if (r5 == 0) goto L_0x028d
            r5 = 1
            goto L_0x028e
        L_0x028d:
            r5 = 0
        L_0x028e:
            if (r5 != 0) goto L_0x02de
            r3 = r12 & 8
            if (r3 == 0) goto L_0x029d
            com.wpengapp.support.ਟ r0 = r11.f3000
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x029d:
            int r12 = m2832(r1, r12, r0)
            com.wpengapp.support.ਟ r1 = r11.f3000
            com.wpengapp.support.ʂ$ށ r13 = (com.wpengapp.support.C0586.C0590) r13
            com.wpengapp.support.ʂ r3 = com.wpengapp.support.C0586.this
            boolean r3 = r3.mo8239((int) r7)
            if (r3 == 0) goto L_0x02b3
            com.wpengapp.support.ʂ r13 = com.wpengapp.support.C0586.this
            r13.mo8229((int) r7, (com.wpengapp.support.BufferedSource) r1, (int) r12, (boolean) r4)
            goto L_0x02d7
        L_0x02b3:
            com.wpengapp.support.ʂ r3 = com.wpengapp.support.C0586.this
            com.wpengapp.support.ȁ r3 = r3.mo8226((int) r7)
            if (r3 != 0) goto L_0x02cc
            com.wpengapp.support.ʂ r3 = com.wpengapp.support.C0586.this
            com.wpengapp.support.ภ r4 = com.wpengapp.support.C1193.PROTOCOL_ERROR
            r3.mo8237(r7, r4)
            com.wpengapp.support.ʂ r13 = com.wpengapp.support.C0586.this
            long r3 = (long) r12
            r13.mo8241(r3)
            r1.skip(r3)
            goto L_0x02d7
        L_0x02cc:
            com.wpengapp.support.ȁ$ؠ r13 = r3.f1010
            long r5 = (long) r12
            r13.mo8134(r1, r5)
            if (r4 == 0) goto L_0x02d7
            r3.mo8130()
        L_0x02d7:
            com.wpengapp.support.ਟ r12 = r11.f3000
            long r0 = (long) r0
            r12.skip(r0)
            goto L_0x02ee
        L_0x02de:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x02e6:
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.String r13 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x02ee:
            return r2
        L_0x02ef:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12[r0] = r13
            java.lang.String r13 = "FRAME_SIZE_ERROR: %s"
            com.wpengapp.support.Http2.m1762(r13, r12)
            throw r3
        L_0x02fd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.Http2Reader.mo9208(boolean, com.wpengapp.support.এ$ؠ):boolean");
    }

    /* renamed from: com.wpengapp.support.এ$֏ */
    /* compiled from: Http2Reader */
    static final class C1046 implements Source {

        /* renamed from: ֏ */
        public final BufferedSource f3004;

        /* renamed from: ؠ */
        public int f3005;

        /* renamed from: ހ */
        public byte f3006;

        /* renamed from: ށ */
        public int f3007;

        /* renamed from: ނ */
        public int f3008;

        /* renamed from: ރ */
        public short f3009;

        public C1046(BufferedSource r1) {
            this.f3004 = r1;
        }

        public void close() {
        }

        /* renamed from: ؠ */
        public long mo8055(Buffer r9, long j) {
            int i;
            do {
                int i2 = this.f3008;
                if (i2 == 0) {
                    this.f3004.skip((long) this.f3009);
                    this.f3009 = 0;
                    if ((this.f3006 & 4) != 0) {
                        return -1;
                    }
                    i = this.f3007;
                    int r2 = Http2Reader.m2833(this.f3004);
                    this.f3008 = r2;
                    this.f3005 = r2;
                    byte readByte = (byte) (this.f3004.readByte() & 255);
                    this.f3006 = (byte) (this.f3004.readByte() & 255);
                    if (Http2Reader.f2999.isLoggable(Level.FINE)) {
                        Http2Reader.f2999.fine(Http2.m1761(true, this.f3007, this.f3005, readByte, this.f3006));
                    }
                    this.f3007 = this.f3004.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    if (readByte != 9) {
                        Http2.m1762("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                        throw null;
                    }
                } else {
                    long r92 = this.f3004.mo8055(r9, Math.min(j, (long) i2));
                    if (r92 == -1) {
                        return -1;
                    }
                    this.f3008 = (int) (((long) this.f3008) - r92);
                    return r92;
                }
            } while (this.f3007 == i);
            Http2.m1762("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        /* renamed from: ؠ */
        public C1166 mo7988() {
            return this.f3004.mo7988();
        }
    }

    /* renamed from: ֏ */
    public final List<Header> mo9205(int i, short s, byte b, int i2) {
        C1046 r0 = this.f3001;
        r0.f3008 = i;
        r0.f3005 = i;
        r0.f3009 = s;
        r0.f3006 = b;
        r0.f3007 = i2;
        Hpack.C0635 r2 = this.f3003;
        while (!r2.f1617.mo8493()) {
            byte readByte = r2.f1617.readByte() & 255;
            if (readByte == 128) {
                throw new IOException("index == 0");
            } else if ((readByte & 128) == 128) {
                int r3 = r2.mo8374((int) readByte, 127) - 1;
                if (r2.mo8381(r3)) {
                    r2.f1616.add(Hpack.f1614[r3]);
                } else {
                    int r4 = r2.mo8373(r3 - Hpack.f1614.length);
                    if (r4 >= 0) {
                        Header[] r5 = r2.f1620;
                        if (r4 < r5.length) {
                            r2.f1616.add(r5[r4]);
                        }
                    }
                    StringBuilder r42 = outline.m2549("Header index too large ");
                    r42.append(r3 + 1);
                    throw new IOException(r42.toString());
                }
            } else if (readByte == 64) {
                ByteString r32 = r2.mo8379();
                Hpack.m1621(r32);
                r2.mo8376(-1, new Header(r32, r2.mo8379()));
            } else if ((readByte & 64) == 64) {
                r2.mo8376(-1, new Header(r2.mo8380(r2.mo8374((int) readByte, 63) - 1), r2.mo8379()));
            } else if ((readByte & 32) == 32) {
                r2.f1619 = r2.mo8374((int) readByte, 31);
                int i3 = r2.f1619;
                if (i3 < 0 || i3 > r2.f1618) {
                    StringBuilder r43 = outline.m2549("Invalid dynamic table size update ");
                    r43.append(r2.f1619);
                    throw new IOException(r43.toString());
                }
                int i4 = r2.f1623;
                if (i3 < i4) {
                    if (i3 == 0) {
                        r2.mo8375();
                    } else {
                        r2.mo8377(i4 - i3);
                    }
                }
            } else if (readByte == 16 || readByte == 0) {
                ByteString r33 = r2.mo8379();
                Hpack.m1621(r33);
                r2.f1616.add(new Header(r33, r2.mo8379()));
            } else {
                r2.f1616.add(new Header(r2.mo8380(r2.mo8374((int) readByte, 15) - 1), r2.mo8379()));
            }
        }
        return this.f3003.mo8378();
    }

    /* renamed from: ֏ */
    public final void mo9207(C1047 r5, int i) {
        int readInt = this.f3000.readInt();
        ((C0586.C0590) r5).mo8247(i, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f3000.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: ֏ */
    public static int m2833(BufferedSource r2) {
        return (r2.readByte() & 255) | ((r2.readByte() & 255) << 16) | ((r2.readByte() & 255) << 8);
    }

    /* renamed from: ֏ */
    public static int m2832(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.m1762("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
