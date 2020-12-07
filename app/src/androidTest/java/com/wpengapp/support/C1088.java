package com.wpengapp.support;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ਦ */
/* compiled from: IdSnapshot */
public class C1088 implements Serializable, Cloneable, TBase<C1088, C1093> {

    /* renamed from: ֏ */
    public static final TStruct f3085 = new TStruct("IdSnapshot");

    /* renamed from: ؠ */
    public static final TField f3086 = new TField("identity", (byte) 11, 1);

    /* renamed from: ހ */
    public static final TField f3087 = new TField("ts", (byte) 10, 2);

    /* renamed from: ށ */
    public static final TField f3088 = new TField("version", (byte) 8, 3);

    /* renamed from: ނ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3089 = new HashMap();

    /* renamed from: ރ */
    public static final Map<C1093, FieldMetaData> f3090;

    /* renamed from: ބ */
    public String f3091;

    /* renamed from: ޅ */
    public long f3092;

    /* renamed from: ކ */
    public int f3093;

    /* renamed from: އ */
    public byte f3094 = 0;

    /* renamed from: com.wpengapp.support.ਦ$֏ */
    /* compiled from: IdSnapshot */
    private static class C1089 extends StandardScheme<C1088> {
        public /* synthetic */ C1089(IdSnapshot r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r3, TBase r4) {
            C1088 r42 = (C1088) r4;
            r42.mo9267();
            r3.mo8575(C1088.f3085);
            if (r42.f3091 != null) {
                r3.mo8576(C1088.f3086);
                r3.mo8579(r42.f3091);
                r3.mo8584();
            }
            r3.mo8576(C1088.f3087);
            r3.mo8574(r42.f3092);
            r3.mo8584();
            r3.mo8576(C1088.f3088);
            r3.mo8573(r42.f3093);
            r3.mo8584();
            r3.mo8585();
            r3.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r5, TBase r6) {
            C1088 r62 = (C1088) r6;
            r5.mo8588();
            while (true) {
                TField r0 = r5.mo8590();
                byte b = r0.f959;
                if (b == 0) {
                    break;
                }
                short s = r0.f960;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                        } else if (b == 8) {
                            r62.f3093 = r5.mo8601();
                            r62.mo9270(true);
                        } else {
                            TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 10) {
                        r62.f3092 = r5.mo8602();
                        r62.mo9269(true);
                    } else {
                        TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                    }
                } else if (b == 11) {
                    r62.f3091 = r5.mo8604();
                    r62.mo9268(true);
                } else {
                    TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                }
                r5.mo8591();
            }
            r5.mo8589();
            if (!Utils.m1879(r62.f3094, 0)) {
                throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'ts' was not found in serialized data! Struct: ")));
            } else if (Utils.m1879(r62.f3094, 1)) {
                r62.mo9267();
            } else {
                throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'version' was not found in serialized data! Struct: ")));
            }
        }
    }

    /* renamed from: com.wpengapp.support.ਦ$ؠ */
    /* compiled from: IdSnapshot */
    private static class C1090 implements SchemeFactory {
        public /* synthetic */ C1090(IdSnapshot r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1089((IdSnapshot) null);
        }
    }

    /* renamed from: com.wpengapp.support.ਦ$ހ */
    /* compiled from: IdSnapshot */
    private static class C1091 extends TupleScheme<C1088> {
        public /* synthetic */ C1091(IdSnapshot r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r3, TBase r4) {
            C1088 r42 = (C1088) r4;
            TTupleProtocol r32 = (TTupleProtocol) r3;
            r32.mo8579(r42.f3091);
            r32.mo8574(r42.f3092);
            r32.mo8573(r42.f3093);
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r4, TBase r5) {
            C1088 r52 = (C1088) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r52.f3091 = r42.mo8604();
            r52.mo9268(true);
            r52.f3092 = r42.mo8602();
            r52.mo9269(true);
            r52.f3093 = r42.mo8601();
            r52.mo9270(true);
        }
    }

    /* renamed from: com.wpengapp.support.ਦ$ށ */
    /* compiled from: IdSnapshot */
    private static class C1092 implements SchemeFactory {
        public /* synthetic */ C1092(IdSnapshot r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1091((IdSnapshot) null);
        }
    }

    /* renamed from: com.wpengapp.support.ਦ$ނ */
    /* compiled from: IdSnapshot */
    public enum C1093 implements TFieldIdEnum {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: ށ */
        public static final Map<String, C1093> f3098 = null;

        /* renamed from: ރ */
        public final String f3100;

        static {
            f3098 = new HashMap();
            Iterator it = EnumSet.allOf(C1093.class).iterator();
            while (it.hasNext()) {
                C1093 r1 = (C1093) it.next();
                f3098.put(r1.f3100, r1);
            }
        }

        /* access modifiers changed from: public */
        C1093(short s, String str) {
            this.f3100 = str;
        }
    }

    static {
        f3089.put(StandardScheme.class, new C1090((IdSnapshot) null));
        f3089.put(TupleScheme.class, new C1092((IdSnapshot) null));
        EnumMap enumMap = new EnumMap(C1093.class);
        enumMap.put(C1093.IDENTITY, new FieldMetaData("identity", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1093.TS, new FieldMetaData("ts", (byte) 1, new FieldValueMetaData((byte) 10, false)));
        enumMap.put(C1093.VERSION, new FieldMetaData("version", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        f3090 = Collections.unmodifiableMap(enumMap);
        Map<C1093, FieldMetaData> map = f3090;
        FieldMetaData.f1830.put(C1088.class, map);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f3091;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f3092);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f3093);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9268(boolean z) {
        if (!z) {
            this.f3091 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9269(boolean z) {
        this.f3094 = Utils.m1855(this.f3094, 0, z);
    }

    /* renamed from: ހ */
    public void mo9270(boolean z) {
        this.f3094 = Utils.m1855(this.f3094, 1, z);
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3089.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3089.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }

    /* renamed from: ֏ */
    public void mo9267() {
        if (this.f3091 == null) {
            StringBuilder r1 = outline.m2549("Required field 'identity' was not present! Struct: ");
            StringBuilder sb = new StringBuilder("IdSnapshot(");
            sb.append("identity:");
            String str = this.f3091;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", ");
            sb.append("ts:");
            sb.append(this.f3092);
            sb.append(", ");
            sb.append("version:");
            sb.append(this.f3093);
            sb.append(")");
            r1.append(sb.toString());
            throw new TProtocolException(r1.toString());
        }
    }
}
