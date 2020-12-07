package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.UMEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.മ */
/* compiled from: EventTracker */
public class C1174 {

    /* renamed from: ֏ */
    public Context f3342;

    /* renamed from: ؠ */
    public C1112 f3343;

    public C1174(Context context) {
        if (context != null) {
            this.f3342 = context.getApplicationContext();
            this.f3343 = C1112.m2993(this.f3342);
            return;
        }
        throw new RuntimeException("Context is null, can't track event");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r12 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cd  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9395(java.util.List<String> r12, int r13, String r14) {
        /*
            r11 = this;
            com.wpengapp.support.ਤ r0 = com.wpengapp.support.C1086.C1087.f3084
            r1 = 1
            if (r12 != 0) goto L_0x000c
            java.lang.String r12 = "cklist is null!"
            com.wpengapp.support.MLog.m1776(r12)
            goto L_0x0132
        L_0x000c:
            int r2 = r12.size()
            r3 = 0
            if (r2 > 0) goto L_0x0019
            java.lang.String r12 = "the KeyList is null!"
            com.wpengapp.support.MLog.m1776(r12)
            return r3
        L_0x0019:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r12)
            java.lang.Object r12 = r2.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = r0.mo9262(r12)
            if (r12 != 0) goto L_0x0030
            java.lang.String r12 = "Primary key Invalid!"
            com.wpengapp.support.MLog.m1776(r12)
            return r3
        L_0x0030:
            int r12 = r2.size()
            r4 = 8
            r5 = 48
            java.lang.String r6 = "illegal"
            java.lang.String r7 = "__cc"
            if (r12 <= r4) goto L_0x0052
            java.lang.Object r12 = r2.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            r2.clear()
            r2.add(r12)
            r2.add(r7)
            r2.add(r6)
            goto L_0x00ef
        L_0x0052:
            int r12 = r2.size()
            if (r12 <= r1) goto L_0x007d
            r12 = 1
        L_0x0059:
            int r4 = r2.size()
            if (r12 >= r4) goto L_0x007d
            java.lang.Object r4 = r2.get(r12)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x006d
        L_0x006b:
            r12 = 0
            goto L_0x007e
        L_0x006d:
            java.lang.Object r4 = r2.get(r12)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r0.mo9263(r4, r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x006b
        L_0x007a:
            int r12 = r12 + 1
            goto L_0x0059
        L_0x007d:
            r12 = 1
        L_0x007e:
            if (r12 != 0) goto L_0x0093
            java.lang.Object r12 = r2.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            r2.clear()
            r2.add(r12)
            r2.add(r7)
            r2.add(r6)
            goto L_0x00ef
        L_0x0093:
            int r12 = r2.size()
            if (r12 <= 0) goto L_0x00b7
            java.util.Iterator r12 = r2.iterator()
            r4 = 0
        L_0x009e:
            boolean r8 = r12.hasNext()
            if (r8 == 0) goto L_0x00b1
            java.lang.Object r8 = r12.next()
            java.lang.String r8 = (java.lang.String) r8
            byte[] r8 = r8.getBytes()
            int r8 = r8.length
            int r4 = r4 + r8
            goto L_0x009e
        L_0x00b1:
            r12 = 256(0x100, float:3.59E-43)
            if (r4 >= r12) goto L_0x00b7
            r12 = 1
            goto L_0x00b8
        L_0x00b7:
            r12 = 0
        L_0x00b8:
            if (r12 != 0) goto L_0x00cd
            java.lang.Object r12 = r2.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            r2.clear()
            r2.add(r12)
            r2.add(r7)
            r2.add(r6)
            goto L_0x00ef
        L_0x00cd:
            r12 = 0
        L_0x00ce:
            int r4 = r2.size()
            if (r12 >= r4) goto L_0x00ef
            java.lang.Object r4 = r2.get(r12)
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            r7 = 16
            if (r6 <= r7) goto L_0x00ec
            r2.remove(r12)
            java.lang.String r4 = r4.substring(r3, r7)
            r2.add(r12, r4)
        L_0x00ec:
            int r12 = r12 + 1
            goto L_0x00ce
        L_0x00ef:
            java.lang.String r12 = ""
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x00f9
        L_0x00f7:
            r3 = 1
            goto L_0x010c
        L_0x00f9:
            if (r14 != 0) goto L_0x00fc
            goto L_0x010c
        L_0x00fc:
            byte[] r12 = r14.getBytes()
            int r12 = r12.length
            r4 = 160(0xa0, float:2.24E-43)
            if (r12 >= r4) goto L_0x010c
            boolean r12 = r0.mo9263(r14, r5)
            if (r12 == 0) goto L_0x010c
            goto L_0x00f7
        L_0x010c:
            if (r3 != 0) goto L_0x0115
            java.lang.String r12 = "label  Invalid!"
            com.wpengapp.support.MLog.m1776(r12)
            java.lang.String r14 = "__illegal"
        L_0x0115:
            r8 = r14
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            com.wpengapp.support.μ r14 = new com.wpengapp.support.μ
            long r6 = (long) r13
            long r9 = java.lang.System.currentTimeMillis()
            r4 = r14
            r5 = r2
            r4.<init>(r5, r6, r8, r9)
            r12.put(r2, r14)
            com.wpengapp.support.ড় r13 = new com.wpengapp.support.ড়
            r13.<init>(r11, r12)
            com.umeng.analytics.QueuedWork.m120b(r13)
        L_0x0132:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C1174.mo9395(java.util.List, int, java.lang.String):boolean");
    }

    /* renamed from: ؠ */
    public final boolean mo9397(String str) {
        if (str == null || str.trim().getBytes().length <= 256) {
            return true;
        }
        MLog.m1776("Event label or value is empty or too long in tracking Event");
        return false;
    }

    /* renamed from: ֏ */
    public void mo9393(String str, Map<String, Object> map, long j) {
        try {
            if (mo9394(str) && mo9396(map)) {
                UMEntry.C0556 r0 = new UMEntry.C0556();
                r0.f1127 = str;
                r0.f1128 = System.currentTimeMillis();
                if (j > 0) {
                    r0.f1129 = j;
                }
                r0.f1125 = 1;
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry next = it.next();
                    r0.f1130.put(next.getKey(), next.getValue());
                }
                if (r0.f1126 == null) {
                    r0.f1126 = SessionTracker.m1840(this.f3342);
                }
                this.f3343.mo8612((IProtocol) r0);
            }
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    /* renamed from: ֏ */
    public void mo9391(String str, String str2, long j, int i) {
        if (mo9394(str) && mo9397(str2)) {
            new HashMap().put(str, str2 == null ? BidiFormatter.EMPTY_STRING : str2);
            UMEntry.C0556 r9 = new UMEntry.C0556();
            r9.f1127 = str;
            r9.f1128 = System.currentTimeMillis();
            if (j > 0) {
                r9.f1129 = j;
            }
            r9.f1125 = 1;
            Map<String, Object> map = r9.f1130;
            if (str2 == null) {
                str2 = BidiFormatter.EMPTY_STRING;
            }
            map.put(str, str2);
            if (r9.f1126 == null) {
                r9.f1126 = SessionTracker.m1840(this.f3342);
            }
            this.f3343.mo8612((IProtocol) r9);
        }
    }

    /* renamed from: ֏ */
    public void mo9392(String str, Map<String, Object> map) {
        try {
            if (mo9394(str)) {
                UMEntry.C0556 r0 = new UMEntry.C0556();
                r0.f1127 = str;
                r0.f1128 = System.currentTimeMillis();
                r0.f1129 = 0;
                r0.f1125 = 2;
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry next = it.next();
                    r0.f1130.put(next.getKey(), next.getValue());
                }
                if (r0.f1126 == null) {
                    r0.f1126 = SessionTracker.m1840(this.f3342);
                }
                this.f3343.mo8612((IProtocol) r0);
            }
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    /* renamed from: ֏ */
    public final boolean mo9394(String str) {
        int length;
        if (str != null && (length = str.trim().getBytes().length) > 0 && length <= 128) {
            return true;
        }
        MLog.m1776("Event id is empty or too long in tracking Event");
        return false;
    }

    /* renamed from: ֏ */
    public final boolean mo9396(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            MLog.m1776("map is null or empty in onEvent");
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!mo9394((String) next.getKey()) || next.getValue() == null) {
                return false;
            }
            if ((next.getValue() instanceof String) && !mo9397(next.getValue().toString())) {
                return false;
            }
        }
        return true;
    }
}
