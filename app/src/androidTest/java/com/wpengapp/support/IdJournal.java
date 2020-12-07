package com.wpengapp.support;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ਞ */
public class IdJournal implements Serializable, Cloneable, TBase<IdJournal, C1085> {

    /* renamed from: ֏ */
    public static final TStruct f3065 = new TStruct("IdJournal");

    /* renamed from: ؠ */
    public static final TField f3066 = new TField("domain", (byte) 11, 1);

    /* renamed from: ހ */
    public static final TField f3067 = new TField("old_id", (byte) 11, 2);

    /* renamed from: ށ */
    public static final TField f3068 = new TField("new_id", (byte) 11, 3);

    /* renamed from: ނ */
    public static final TField f3069 = new TField("ts", (byte) 10, 4);

    /* renamed from: ރ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3070 = new HashMap();

    /* renamed from: ބ */
    public static final Map<C1085, FieldMetaData> f3071;

    /* renamed from: ޅ */
    public String f3072;

    /* renamed from: ކ */
    public String f3073;

    /* renamed from: އ */
    public String f3074;

    /* renamed from: ވ */
    public long f3075;

    /* renamed from: މ */
    public byte f3076 = 0;

    /* renamed from: com.wpengapp.support.ਞ$֏ */
    /* compiled from: IdJournal */
    private static class C1081 extends StandardScheme<IdJournal> {
        public /* synthetic */ C1081(C1143 r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r3, TBase r4) {
            IdJournal r42 = (IdJournal) r4;
            r42.mo9257();
            r3.mo8575(IdJournal.f3065);
            if (r42.f3072 != null) {
                r3.mo8576(IdJournal.f3066);
                r3.mo8579(r42.f3072);
                r3.mo8584();
            }
            if (r42.f3073 != null && r42.mo9256()) {
                r3.mo8576(IdJournal.f3067);
                r3.mo8579(r42.f3073);
                r3.mo8584();
            }
            if (r42.f3074 != null) {
                r3.mo8576(IdJournal.f3068);
                r3.mo8579(r42.f3074);
                r3.mo8584();
            }
            r3.mo8576(IdJournal.f3069);
            r3.mo8574(r42.f3075);
            r3.mo8584();
            r3.mo8585();
            r3.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r6, TBase r7) {
            IdJournal r72 = (IdJournal) r7;
            r6.mo8588();
            while (true) {
                TField r0 = r6.mo8590();
                byte b = r0.f959;
                if (b == 0) {
                    break;
                }
                short s = r0.f960;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                            } else if (b == 10) {
                                r72.f3075 = r6.mo8602();
                                r72.mo9260(true);
                            } else {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                            }
                        } else if (b == 11) {
                            r72.f3074 = r6.mo8604();
                            r72.mo9259(true);
                        } else {
                            TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 11) {
                        r72.f3073 = r6.mo8604();
                        r72.mo9258(true);
                    } else {
                        TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                    }
                } else if (b == 11) {
                    r72.f3072 = r6.mo8604();
                    r72.mo9255(true);
                } else {
                    TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                }
                r6.mo8591();
            }
            r6.mo8589();
            if (Utils.m1879(r72.f3076, 0)) {
                r72.mo9257();
                return;
            }
            throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'ts' was not found in serialized data! Struct: ")));
        }
    }

    /* renamed from: com.wpengapp.support.ਞ$ؠ */
    /* compiled from: IdJournal */
    private static class C1082 implements SchemeFactory {
        public /* synthetic */ C1082(C1143 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1081((C1143) null);
        }
    }

    /* renamed from: com.wpengapp.support.ਞ$ހ */
    /* compiled from: IdJournal */
    private static class C1083 extends TupleScheme<IdJournal> {
        public /* synthetic */ C1083(C1143 r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r3, TBase r4) {
            IdJournal r42 = (IdJournal) r4;
            TTupleProtocol r32 = (TTupleProtocol) r3;
            r32.mo8579(r42.f3072);
            r32.mo8579(r42.f3074);
            r32.mo8574(r42.f3075);
            BitSet bitSet = new BitSet();
            if (r42.mo9256()) {
                bitSet.set(0);
            }
            r32.mo9428(bitSet, 1);
            if (r42.mo9256()) {
                r32.mo8579(r42.f3073);
            }
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r4, TBase r5) {
            IdJournal r52 = (IdJournal) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r52.f3072 = r42.mo8604();
            r52.mo9255(true);
            r52.f3074 = r42.mo8604();
            r52.mo9259(true);
            r52.f3075 = r42.mo8602();
            r52.mo9260(true);
            if (r42.mo9429(1).get(0)) {
                r52.f3073 = r42.mo8604();
                r52.mo9258(true);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ਞ$ށ */
    /* compiled from: IdJournal */
    private static class C1084 implements SchemeFactory {
        public /* synthetic */ C1084(C1143 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1083((C1143) null);
        }
    }

    /* renamed from: com.wpengapp.support.ਞ$ނ */
    /* compiled from: IdJournal */
    public enum C1085 implements TFieldIdEnum {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: ނ */
        public static final Map<String, C1085> f3081 = null;

        /* renamed from: ބ */
        public final String f3083;

        static {
            f3081 = new HashMap();
            Iterator it = EnumSet.allOf(C1085.class).iterator();
            while (it.hasNext()) {
                C1085 r1 = (C1085) it.next();
                f3081.put(r1.f3083, r1);
            }
        }

        /* access modifiers changed from: public */
        C1085(short s, String str) {
            this.f3083 = str;
        }
    }

    static {
        f3070.put(StandardScheme.class, new C1082((C1143) null));
        f3070.put(TupleScheme.class, new C1084((C1143) null));
        EnumMap enumMap = new EnumMap(C1085.class);
        enumMap.put(C1085.DOMAIN, new FieldMetaData("domain", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1085.OLD_ID, new FieldMetaData("old_id", (byte) 2, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1085.NEW_ID, new FieldMetaData("new_id", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1085.TS, new FieldMetaData("ts", (byte) 1, new FieldValueMetaData((byte) 10, false)));
        f3071 = Collections.unmodifiableMap(enumMap);
        Map<C1085, FieldMetaData> map = f3071;
        FieldMetaData.f1830.put(IdJournal.class, map);
    }

    public IdJournal() {
        new C1085[1][0] = C1085.OLD_ID;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f3072;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (mo9256()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f3073;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f3074;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f3075);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9255(boolean z) {
        if (!z) {
            this.f3072 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9258(boolean z) {
        if (!z) {
            this.f3073 = null;
        }
    }

    /* renamed from: ހ */
    public void mo9259(boolean z) {
        if (!z) {
            this.f3074 = null;
        }
    }

    /* renamed from: ށ */
    public void mo9260(boolean z) {
        this.f3076 = Utils.m1855(this.f3076, 0, z);
    }

    /* renamed from: ֏ */
    public boolean mo9256() {
        return this.f3073 != null;
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3070.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3070.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9257() {
        if (this.f3072 == null) {
            StringBuilder r1 = outline.m2549("Required field 'domain' was not present! Struct: ");
            r1.append(toString());
            throw new TProtocolException(r1.toString());
        } else if (this.f3074 == null) {
            StringBuilder r12 = outline.m2549("Required field 'new_id' was not present! Struct: ");
            r12.append(toString());
            throw new TProtocolException(r12.toString());
        }
    }
}
