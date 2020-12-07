package com.wpengapp.support;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ञ */
/* compiled from: Imprint */
public class C1009 implements Serializable, Cloneable, TBase<C1009, C1014> {

    /* renamed from: ֏ */
    public static final TStruct f2898 = new TStruct("Imprint");

    /* renamed from: ؠ */
    public static final TField f2899 = new TField("property", (byte) 13, 1);

    /* renamed from: ހ */
    public static final TField f2900 = new TField("version", (byte) 8, 2);

    /* renamed from: ށ */
    public static final TField f2901 = new TField("checksum", (byte) 11, 3);

    /* renamed from: ނ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f2902 = new HashMap();

    /* renamed from: ރ */
    public static final Map<C1014, FieldMetaData> f2903;

    /* renamed from: ބ */
    public Map<String, C1179> f2904;

    /* renamed from: ޅ */
    public int f2905;

    /* renamed from: ކ */
    public String f2906;

    /* renamed from: އ */
    public byte f2907 = 0;

    /* renamed from: com.wpengapp.support.ञ$֏ */
    /* compiled from: Imprint */
    private static class C1010 extends StandardScheme<C1009> {
        public /* synthetic */ C1010(Imprint r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r5, TBase r6) {
            C1009 r62 = (C1009) r6;
            r62.mo9119();
            r5.mo8575(C1009.f2898);
            if (r62.f2904 != null) {
                r5.mo8576(C1009.f2899);
                r5.mo8578(new TMap((byte) 11, (byte) 12, r62.f2904.size()));
                for (Map.Entry next : r62.f2904.entrySet()) {
                    r5.mo8579((String) next.getKey());
                    ((C1179) next.getValue()).mo9122(r5);
                }
                r5.mo8586();
                r5.mo8584();
            }
            r5.mo8576(C1009.f2900);
            r5.mo8573(r62.f2905);
            r5.mo8584();
            if (r62.f2906 != null) {
                r5.mo8576(C1009.f2901);
                r5.mo8579(r62.f2906);
                r5.mo8584();
            }
            r5.mo8585();
            r5.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r7, TBase r8) {
            C1009 r82 = (C1009) r8;
            r7.mo8588();
            while (true) {
                TField r0 = r7.mo8590();
                byte b = r0.f959;
                if (b == 0) {
                    break;
                }
                short s = r0.f960;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                        } else if (b == 11) {
                            r82.f2906 = r7.mo8604();
                            r82.mo9124(true);
                        } else {
                            TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 8) {
                        r82.f2905 = r7.mo8601();
                        r82.mo9123(true);
                    } else {
                        TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                    }
                } else if (b == 13) {
                    TMap r02 = r7.mo8592();
                    r82.f2904 = new HashMap(r02.f3637 * 2);
                    for (int i = 0; i < r02.f3637; i++) {
                        String r1 = r7.mo8604();
                        C1179 r4 = new C1179();
                        r4.mo9120(r7);
                        r82.f2904.put(r1, r4);
                    }
                    r7.mo8593();
                    r82.mo9121(true);
                } else {
                    TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                }
                r7.mo8591();
            }
            r7.mo8589();
            if (Utils.m1879(r82.f2907, 0)) {
                r82.mo9119();
                return;
            }
            throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'version' was not found in serialized data! Struct: ")));
        }
    }

    /* renamed from: com.wpengapp.support.ञ$ؠ */
    /* compiled from: Imprint */
    private static class C1011 implements SchemeFactory {
        public /* synthetic */ C1011(Imprint r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1010((Imprint) null);
        }
    }

    /* renamed from: com.wpengapp.support.ञ$ހ */
    /* compiled from: Imprint */
    private static class C1012 extends TupleScheme<C1009> {
        public /* synthetic */ C1012(Imprint r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r4, TBase r5) {
            C1009 r52 = (C1009) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r42.mo8573(r52.f2904.size());
            for (Map.Entry next : r52.f2904.entrySet()) {
                r42.mo8579((String) next.getKey());
                ((C1179) next.getValue()).mo9122((TProtocol) r42);
            }
            r42.mo8573(r52.f2905);
            r42.mo8579(r52.f2906);
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r6, TBase r7) {
            C1009 r72 = (C1009) r7;
            TTupleProtocol r62 = (TTupleProtocol) r6;
            int r0 = r62.mo8601();
            r72.f2904 = new HashMap(r0 * 2);
            for (int i = 0; i < r0; i++) {
                String r2 = r62.mo8604();
                C1179 r3 = new C1179();
                r3.mo9120((TProtocol) r62);
                r72.f2904.put(r2, r3);
            }
            r72.mo9121(true);
            r72.f2905 = r62.mo8601();
            r72.mo9123(true);
            r72.f2906 = r62.mo8604();
            r72.mo9124(true);
        }
    }

    /* renamed from: com.wpengapp.support.ञ$ށ */
    /* compiled from: Imprint */
    private static class C1013 implements SchemeFactory {
        public /* synthetic */ C1013(Imprint r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1012((Imprint) null);
        }
    }

    /* renamed from: com.wpengapp.support.ञ$ނ */
    /* compiled from: Imprint */
    public enum C1014 implements TFieldIdEnum {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: ށ */
        public static final Map<String, C1014> f2911 = null;

        /* renamed from: ރ */
        public final String f2913;

        static {
            f2911 = new HashMap();
            Iterator it = EnumSet.allOf(C1014.class).iterator();
            while (it.hasNext()) {
                C1014 r1 = (C1014) it.next();
                f2911.put(r1.f2913, r1);
            }
        }

        /* access modifiers changed from: public */
        C1014(short s, String str) {
            this.f2913 = str;
        }
    }

    static {
        f2902.put(StandardScheme.class, new C1011((Imprint) null));
        f2902.put(TupleScheme.class, new C1013((Imprint) null));
        EnumMap enumMap = new EnumMap(C1014.class);
        enumMap.put(C1014.PROPERTY, new FieldMetaData("property", (byte) 1, new MapMetaData((byte) 13, new FieldValueMetaData((byte) 11, false), new StructMetaData((byte) 12, C1179.class))));
        enumMap.put(C1014.VERSION, new FieldMetaData("version", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        enumMap.put(C1014.CHECKSUM, new FieldMetaData("checksum", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        f2903 = Collections.unmodifiableMap(enumMap);
        Map<C1014, FieldMetaData> map = f2903;
        FieldMetaData.f1830.put(C1009.class, map);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, C1179> map = this.f2904;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f2905);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f2906;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9121(boolean z) {
        if (!z) {
            this.f2904 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9123(boolean z) {
        this.f2907 = Utils.m1855(this.f2907, 0, z);
    }

    /* renamed from: ހ */
    public void mo9124(boolean z) {
        if (!z) {
            this.f2906 = null;
        }
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f2902.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f2902.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }

    /* renamed from: ֏ */
    public void mo9119() {
        if (this.f2904 == null) {
            StringBuilder r1 = outline.m2549("Required field 'property' was not present! Struct: ");
            r1.append(toString());
            throw new TProtocolException(r1.toString());
        } else if (this.f2906 == null) {
            StringBuilder r12 = outline.m2549("Required field 'checksum' was not present! Struct: ");
            r12.append(toString());
            throw new TProtocolException(r12.toString());
        }
    }
}
