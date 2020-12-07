package com.wpengapp.support;

import android.support.p000v4.app.NotificationCompat;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ⴞ */
/* compiled from: Response */
public class C1309 implements Serializable, Cloneable, TBase<C1309, C1314> {

    /* renamed from: ֏ */
    public static final TStruct f3742 = new TStruct("Response");

    /* renamed from: ؠ */
    public static final TField f3743 = new TField("resp_code", (byte) 8, 1);

    /* renamed from: ހ */
    public static final TField f3744 = new TField(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);

    /* renamed from: ށ */
    public static final TField f3745 = new TField("imprint", (byte) 12, 3);

    /* renamed from: ނ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3746 = new HashMap();

    /* renamed from: ރ */
    public static final Map<C1314, FieldMetaData> f3747;

    /* renamed from: ބ */
    public int f3748;

    /* renamed from: ޅ */
    public String f3749;

    /* renamed from: ކ */
    public C1009 f3750;

    /* renamed from: އ */
    public byte f3751 = 0;

    /* renamed from: com.wpengapp.support.Ⴞ$֏ */
    /* compiled from: Response */
    private static class C1310 extends StandardScheme<C1309> {
        public /* synthetic */ C1310(C0859 r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r2, TBase r3) {
            C1309 r32 = (C1309) r3;
            r32.mo9580();
            r2.mo8575(C1309.f3742);
            r2.mo8576(C1309.f3743);
            r2.mo8573(r32.f3748);
            r2.mo8584();
            if (r32.f3749 != null && r32.mo9577()) {
                r2.mo8576(C1309.f3744);
                r2.mo8579(r32.f3749);
                r2.mo8584();
            }
            if (r32.f3750 != null && r32.mo9579()) {
                r2.mo8576(C1309.f3745);
                r32.f3750.mo9122(r2);
                r2.mo8584();
            }
            r2.mo8585();
            r2.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r5, TBase r6) {
            C1309 r62 = (C1309) r6;
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
                        } else if (b == 12) {
                            r62.f3750 = new C1009();
                            r62.f3750.mo9120(r5);
                            r62.mo9581(true);
                        } else {
                            TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 11) {
                        r62.f3749 = r5.mo8604();
                        r62.mo9578(true);
                    } else {
                        TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                    }
                } else if (b == 8) {
                    r62.f3748 = r5.mo8601();
                    r62.mo9576(true);
                } else {
                    TProtocolUtil.m3568(r5, b, TProtocolUtil.f3741);
                }
                r5.mo8591();
            }
            r5.mo8589();
            if (Utils.m1879(r62.f3751, 0)) {
                r62.mo9580();
                return;
            }
            throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'resp_code' was not found in serialized data! Struct: ")));
        }
    }

    /* renamed from: com.wpengapp.support.Ⴞ$ؠ */
    /* compiled from: Response */
    private static class C1311 implements SchemeFactory {
        public /* synthetic */ C1311(C0859 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1310((C0859) null);
        }
    }

    /* renamed from: com.wpengapp.support.Ⴞ$ހ */
    /* compiled from: Response */
    private static class C1312 extends TupleScheme<C1309> {
        public /* synthetic */ C1312(C0859 r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r3, TBase r4) {
            C1309 r42 = (C1309) r4;
            TTupleProtocol r32 = (TTupleProtocol) r3;
            r32.mo8573(r42.f3748);
            BitSet bitSet = new BitSet();
            if (r42.mo9577()) {
                bitSet.set(0);
            }
            if (r42.mo9579()) {
                bitSet.set(1);
            }
            r32.mo9428(bitSet, 2);
            if (r42.mo9577()) {
                r32.mo8579(r42.f3749);
            }
            if (r42.mo9579()) {
                r42.f3750.mo9122((TProtocol) r32);
            }
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r4, TBase r5) {
            C1309 r52 = (C1309) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r52.f3748 = r42.mo8601();
            r52.mo9576(true);
            BitSet r1 = r42.mo9429(2);
            if (r1.get(0)) {
                r52.f3749 = r42.mo8604();
                r52.mo9578(true);
            }
            if (r1.get(1)) {
                r52.f3750 = new C1009();
                r52.f3750.mo9120((TProtocol) r42);
                r52.mo9581(true);
            }
        }
    }

    /* renamed from: com.wpengapp.support.Ⴞ$ށ */
    /* compiled from: Response */
    private static class C1313 implements SchemeFactory {
        public /* synthetic */ C1313(C0859 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1312((C0859) null);
        }
    }

    /* renamed from: com.wpengapp.support.Ⴞ$ނ */
    /* compiled from: Response */
    public enum C1314 implements TFieldIdEnum {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, "imprint");
        

        /* renamed from: ށ */
        public static final Map<String, C1314> f3755 = null;

        /* renamed from: ރ */
        public final String f3757;

        static {
            f3755 = new HashMap();
            Iterator it = EnumSet.allOf(C1314.class).iterator();
            while (it.hasNext()) {
                C1314 r1 = (C1314) it.next();
                f3755.put(r1.f3757, r1);
            }
        }

        /* access modifiers changed from: public */
        C1314(short s, String str) {
            this.f3757 = str;
        }
    }

    static {
        f3746.put(StandardScheme.class, new C1311((C0859) null));
        f3746.put(TupleScheme.class, new C1313((C0859) null));
        EnumMap enumMap = new EnumMap(C1314.class);
        enumMap.put(C1314.RESP_CODE, new FieldMetaData("resp_code", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        enumMap.put(C1314.MSG, new FieldMetaData(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1314.IMPRINT, new FieldMetaData("imprint", (byte) 2, new StructMetaData((byte) 12, C1009.class)));
        f3747 = Collections.unmodifiableMap(enumMap);
        Map<C1314, FieldMetaData> map = f3747;
        FieldMetaData.f1830.put(C1309.class, map);
    }

    public C1309() {
        C1314[] r1 = {C1314.MSG, C1314.IMPRINT};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.f3748);
        if (mo9577()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.f3749;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (mo9579()) {
            sb.append(", ");
            sb.append("imprint:");
            C1009 r1 = this.f3750;
            if (r1 == null) {
                sb.append("null");
            } else {
                sb.append(r1);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9576(boolean z) {
        this.f3751 = Utils.m1855(this.f3751, 0, z);
    }

    /* renamed from: ؠ */
    public void mo9578(boolean z) {
        if (!z) {
            this.f3749 = null;
        }
    }

    /* renamed from: ހ */
    public void mo9581(boolean z) {
        if (!z) {
            this.f3750 = null;
        }
    }

    /* renamed from: ֏ */
    public boolean mo9577() {
        return this.f3749 != null;
    }

    /* renamed from: ؠ */
    public boolean mo9579() {
        return this.f3750 != null;
    }

    /* renamed from: ހ */
    public void mo9580() {
        C1009 r0 = this.f3750;
        if (r0 != null) {
            r0.mo9119();
        }
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3746.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3746.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }
}
