package com.wpengapp.support;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ฉ */
/* compiled from: ImprintValue */
public class C1179 implements Serializable, Cloneable, TBase<C1179, C1184> {

    /* renamed from: ֏ */
    public static final TStruct f3360 = new TStruct("ImprintValue");

    /* renamed from: ؠ */
    public static final TField f3361 = new TField("value", (byte) 11, 1);

    /* renamed from: ހ */
    public static final TField f3362 = new TField("ts", (byte) 10, 2);

    /* renamed from: ށ */
    public static final TField f3363 = new TField("guid", (byte) 11, 3);

    /* renamed from: ނ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3364 = new HashMap();

    /* renamed from: ރ */
    public static final Map<C1184, FieldMetaData> f3365;

    /* renamed from: ބ */
    public String f3366;

    /* renamed from: ޅ */
    public long f3367;

    /* renamed from: ކ */
    public String f3368;

    /* renamed from: އ */
    public byte f3369 = 0;

    /* renamed from: com.wpengapp.support.ฉ$֏ */
    /* compiled from: ImprintValue */
    private static class C1180 extends StandardScheme<C1179> {
        public /* synthetic */ C1180(ImprintValue r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r3, TBase r4) {
            C1179 r42 = (C1179) r4;
            r42.mo9419();
            r3.mo8575(C1179.f3360);
            if (r42.f3366 != null && r42.mo9414()) {
                r3.mo8576(C1179.f3361);
                r3.mo8579(r42.f3366);
                r3.mo8584();
            }
            r3.mo8576(C1179.f3362);
            r3.mo8574(r42.f3367);
            r3.mo8584();
            if (r42.f3368 != null) {
                r3.mo8576(C1179.f3363);
                r3.mo8579(r42.f3368);
                r3.mo8584();
            }
            r3.mo8585();
            r3.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r6, TBase r7) {
            C1179 r72 = (C1179) r7;
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
                            TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                        } else if (b == 11) {
                            r72.f3368 = r6.mo8604();
                            r72.mo9418(true);
                        } else {
                            TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 10) {
                        r72.f3367 = r6.mo8602();
                        r72.mo9416(true);
                    } else {
                        TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                    }
                } else if (b == 11) {
                    r72.f3366 = r6.mo8604();
                    r72.mo9413(true);
                } else {
                    TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                }
                r6.mo8591();
            }
            r6.mo8589();
            if (Utils.m1879(r72.f3369, 0)) {
                r72.mo9419();
                return;
            }
            throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'ts' was not found in serialized data! Struct: ")));
        }
    }

    /* renamed from: com.wpengapp.support.ฉ$ؠ */
    /* compiled from: ImprintValue */
    private static class C1181 implements SchemeFactory {
        public /* synthetic */ C1181(ImprintValue r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1180((ImprintValue) null);
        }
    }

    /* renamed from: com.wpengapp.support.ฉ$ހ */
    /* compiled from: ImprintValue */
    private static class C1182 extends TupleScheme<C1179> {
        public /* synthetic */ C1182(ImprintValue r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r3, TBase r4) {
            C1179 r42 = (C1179) r4;
            TTupleProtocol r32 = (TTupleProtocol) r3;
            r32.mo8574(r42.f3367);
            r32.mo8579(r42.f3368);
            BitSet bitSet = new BitSet();
            if (r42.mo9414()) {
                bitSet.set(0);
            }
            r32.mo9428(bitSet, 1);
            if (r42.mo9414()) {
                r32.mo8579(r42.f3366);
            }
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r4, TBase r5) {
            C1179 r52 = (C1179) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r52.f3367 = r42.mo8602();
            r52.mo9416(true);
            r52.f3368 = r42.mo8604();
            r52.mo9418(true);
            if (r42.mo9429(1).get(0)) {
                r52.f3366 = r42.mo8604();
                r52.mo9413(true);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ฉ$ށ */
    /* compiled from: ImprintValue */
    private static class C1183 implements SchemeFactory {
        public /* synthetic */ C1183(ImprintValue r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1182((ImprintValue) null);
        }
    }

    /* renamed from: com.wpengapp.support.ฉ$ނ */
    /* compiled from: ImprintValue */
    public enum C1184 implements TFieldIdEnum {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: ށ */
        public static final Map<String, C1184> f3373 = null;

        /* renamed from: ރ */
        public final String f3375;

        static {
            f3373 = new HashMap();
            Iterator it = EnumSet.allOf(C1184.class).iterator();
            while (it.hasNext()) {
                C1184 r1 = (C1184) it.next();
                f3373.put(r1.f3375, r1);
            }
        }

        /* access modifiers changed from: public */
        C1184(short s, String str) {
            this.f3375 = str;
        }
    }

    static {
        f3364.put(StandardScheme.class, new C1181((ImprintValue) null));
        f3364.put(TupleScheme.class, new C1183((ImprintValue) null));
        EnumMap enumMap = new EnumMap(C1184.class);
        enumMap.put(C1184.VALUE, new FieldMetaData("value", (byte) 2, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1184.TS, new FieldMetaData("ts", (byte) 1, new FieldValueMetaData((byte) 10, false)));
        enumMap.put(C1184.GUID, new FieldMetaData("guid", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        f3365 = Collections.unmodifiableMap(enumMap);
        Map<C1184, FieldMetaData> map = f3365;
        FieldMetaData.f1830.put(C1179.class, map);
    }

    public C1179() {
        new C1184[1][0] = C1184.VALUE;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (mo9414()) {
            sb.append("value:");
            String str = this.f3366;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f3367);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f3368;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public boolean mo9414() {
        return this.f3366 != null;
    }

    /* renamed from: ؠ */
    public long mo9415() {
        return this.f3367;
    }

    /* renamed from: ހ */
    public String mo9417() {
        return this.f3368;
    }

    /* renamed from: ށ */
    public void mo9419() {
        boolean z;
        if (this.f3368 == null) {
            StringBuilder r1 = outline.m2549("Required field 'guid' was not present! Struct: ");
            StringBuilder sb = new StringBuilder("ImprintValue(");
            if (mo9414()) {
                sb.append("value:");
                String str = this.f3366;
                if (str == null) {
                    sb.append("null");
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(", ");
            }
            sb.append("ts:");
            sb.append(this.f3367);
            sb.append(", ");
            sb.append("guid:");
            String str2 = this.f3368;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            sb.append(")");
            r1.append(sb.toString());
            throw new TProtocolException(r1.toString());
        }
    }

    /* renamed from: ֏ */
    public void mo9413(boolean z) {
        if (!z) {
            this.f3366 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9416(boolean z) {
        this.f3369 = Utils.m1855(this.f3369, 0, z);
    }

    /* renamed from: ހ */
    public void mo9418(boolean z) {
        if (!z) {
            this.f3368 = null;
        }
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3364.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3364.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }
}
