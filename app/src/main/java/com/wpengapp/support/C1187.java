package com.wpengapp.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.น */
/* compiled from: IdTracking */
public class C1187 implements Serializable, Cloneable, TBase<C1187, C1192> {

    /* renamed from: ֏ */
    public static final TStruct f3379 = new TStruct("IdTracking");

    /* renamed from: ؠ */
    public static final TField f3380 = new TField("snapshots", (byte) 13, 1);

    /* renamed from: ހ */
    public static final TField f3381 = new TField("journals", (byte) 15, 2);

    /* renamed from: ށ */
    public static final TField f3382 = new TField("checksum", (byte) 11, 3);

    /* renamed from: ނ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3383 = new HashMap();

    /* renamed from: ރ */
    public static final Map<C1192, FieldMetaData> f3384;

    /* renamed from: ބ */
    public Map<String, C1088> f3385;

    /* renamed from: ޅ */
    public List<IdJournal> f3386;

    /* renamed from: ކ */
    public String f3387;

    /* renamed from: com.wpengapp.support.น$֏ */
    /* compiled from: IdTracking */
    private static class C1188 extends StandardScheme<C1187> {
        public /* synthetic */ C1188(IdTracking r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r5, TBase r6) {
            C1187 r62 = (C1187) r6;
            r62.mo9426();
            r5.mo8575(C1187.f3379);
            if (r62.f3385 != null) {
                r5.mo8576(C1187.f3380);
                r5.mo8578(new TMap((byte) 11, (byte) 12, r62.f3385.size()));
                for (Map.Entry next : r62.f3385.entrySet()) {
                    r5.mo8579((String) next.getKey());
                    ((C1088) next.getValue()).mo9122(r5);
                }
                r5.mo8586();
                r5.mo8584();
            }
            if (r62.f3386 != null && r62.mo9423()) {
                r5.mo8576(C1187.f3381);
                r5.mo8577(new TList((byte) 12, r62.f3386.size()));
                for (IdJournal r1 : r62.f3386) {
                    r1.mo9122(r5);
                }
                r5.mo8587();
                r5.mo8584();
            }
            if (r62.f3387 != null && r62.mo9425()) {
                r5.mo8576(C1187.f3382);
                r5.mo8579(r62.f3387);
                r5.mo8584();
            }
            r5.mo8585();
            r5.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r7, TBase r8) {
            C1187 r82 = (C1187) r8;
            r7.mo8588();
            while (true) {
                TField r0 = r7.mo8590();
                byte b = r0.f959;
                if (b == 0) {
                    r7.mo8589();
                    r82.mo9426();
                    return;
                }
                short s = r0.f960;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                        } else if (b == 11) {
                            r82.f3387 = r7.mo8604();
                            r82.mo9427(true);
                        } else {
                            TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                        }
                    } else if (b == 15) {
                        TList r02 = r7.mo8594();
                        r82.f3386 = new ArrayList(r02.f3356);
                        while (i < r02.f3356) {
                            IdJournal r1 = new IdJournal();
                            r1.mo9120(r7);
                            r82.f3386.add(r1);
                            i++;
                        }
                        r7.mo8595();
                        r82.mo9424(true);
                    } else {
                        TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                    }
                } else if (b == 13) {
                    TMap r03 = r7.mo8592();
                    r82.f3385 = new HashMap(r03.f3637 * 2);
                    while (i < r03.f3637) {
                        String r12 = r7.mo8604();
                        C1088 r3 = new C1088();
                        r3.mo9120(r7);
                        r82.f3385.put(r12, r3);
                        i++;
                    }
                    r7.mo8593();
                    r82.mo9422(true);
                } else {
                    TProtocolUtil.m3568(r7, b, TProtocolUtil.f3741);
                }
                r7.mo8591();
            }
        }
    }

    /* renamed from: com.wpengapp.support.น$ؠ */
    /* compiled from: IdTracking */
    private static class C1189 implements SchemeFactory {
        public /* synthetic */ C1189(IdTracking r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1188((IdTracking) null);
        }
    }

    /* renamed from: com.wpengapp.support.น$ހ */
    /* compiled from: IdTracking */
    private static class C1190 extends TupleScheme<C1187> {
        public /* synthetic */ C1190(IdTracking r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r4, TBase r5) {
            C1187 r52 = (C1187) r5;
            TTupleProtocol r42 = (TTupleProtocol) r4;
            r42.mo8573(r52.f3385.size());
            for (Map.Entry next : r52.f3385.entrySet()) {
                r42.mo8579((String) next.getKey());
                ((C1088) next.getValue()).mo9122((TProtocol) r42);
            }
            BitSet bitSet = new BitSet();
            if (r52.mo9423()) {
                bitSet.set(0);
            }
            if (r52.mo9425()) {
                bitSet.set(1);
            }
            r42.mo9428(bitSet, 2);
            if (r52.mo9423()) {
                r42.mo8573(r52.f3386.size());
                for (IdJournal r1 : r52.f3386) {
                    r1.mo9122((TProtocol) r42);
                }
            }
            if (r52.mo9425()) {
                r42.mo8579(r52.f3387);
            }
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r7, TBase r8) {
            C1187 r82 = (C1187) r8;
            TTupleProtocol r72 = (TTupleProtocol) r7;
            int r0 = r72.mo8601();
            r82.f3385 = new HashMap(r0 * 2);
            for (int i = 0; i < r0; i++) {
                String r3 = r72.mo8604();
                C1088 r4 = new C1088();
                r4.mo9120((TProtocol) r72);
                r82.f3385.put(r3, r4);
            }
            r82.mo9422(true);
            BitSet r2 = r72.mo9429(2);
            if (r2.get(0)) {
                int r32 = r72.mo8601();
                r82.f3386 = new ArrayList(r32);
                for (int i2 = 0; i2 < r32; i2++) {
                    IdJournal r42 = new IdJournal();
                    r42.mo9120((TProtocol) r72);
                    r82.f3386.add(r42);
                }
                r82.mo9424(true);
            }
            if (r2.get(1)) {
                r82.f3387 = r72.mo8604();
                r82.mo9427(true);
            }
        }
    }

    /* renamed from: com.wpengapp.support.น$ށ */
    /* compiled from: IdTracking */
    private static class C1191 implements SchemeFactory {
        public /* synthetic */ C1191(IdTracking r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1190((IdTracking) null);
        }
    }

    /* renamed from: com.wpengapp.support.น$ނ */
    /* compiled from: IdTracking */
    public enum C1192 implements TFieldIdEnum {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: ށ */
        public static final Map<String, C1192> f3391 = null;

        /* renamed from: ރ */
        public final String f3393;

        static {
            f3391 = new HashMap();
            Iterator it = EnumSet.allOf(C1192.class).iterator();
            while (it.hasNext()) {
                C1192 r1 = (C1192) it.next();
                f3391.put(r1.f3393, r1);
            }
        }

        /* access modifiers changed from: public */
        C1192(short s, String str) {
            this.f3393 = str;
        }
    }

    static {
        f3383.put(StandardScheme.class, new C1189((IdTracking) null));
        f3383.put(TupleScheme.class, new C1191((IdTracking) null));
        EnumMap enumMap = new EnumMap(C1192.class);
        enumMap.put(C1192.SNAPSHOTS, new FieldMetaData("snapshots", (byte) 1, new MapMetaData((byte) 13, new FieldValueMetaData((byte) 11, false), new StructMetaData((byte) 12, C1088.class))));
        enumMap.put(C1192.JOURNALS, new FieldMetaData("journals", (byte) 2, new ListMetaData((byte) 15, new StructMetaData((byte) 12, IdJournal.class))));
        enumMap.put(C1192.CHECKSUM, new FieldMetaData("checksum", (byte) 2, new FieldValueMetaData((byte) 11, false)));
        f3384 = Collections.unmodifiableMap(enumMap);
        Map<C1192, FieldMetaData> map = f3384;
        FieldMetaData.f1830.put(C1187.class, map);
    }

    public C1187() {
        C1192[] r0 = {C1192.JOURNALS, C1192.CHECKSUM};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, C1088> map = this.f3385;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (mo9423()) {
            sb.append(", ");
            sb.append("journals:");
            List<IdJournal> list = this.f3386;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (mo9425()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f3387;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9422(boolean z) {
        if (!z) {
            this.f3385 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9424(boolean z) {
        if (!z) {
            this.f3386 = null;
        }
    }

    /* renamed from: ހ */
    public void mo9427(boolean z) {
        if (!z) {
            this.f3387 = null;
        }
    }

    /* renamed from: ֏ */
    public boolean mo9423() {
        return this.f3386 != null;
    }

    /* renamed from: ؠ */
    public boolean mo9425() {
        return this.f3387 != null;
    }

    /* renamed from: ހ */
    public void mo9426() {
        if (this.f3385 == null) {
            StringBuilder r1 = outline.m2549("Required field 'snapshots' was not present! Struct: ");
            StringBuilder sb = new StringBuilder("IdTracking(");
            sb.append("snapshots:");
            Map<String, C1088> map = this.f3385;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
            if (mo9423()) {
                sb.append(", ");
                sb.append("journals:");
                List<IdJournal> list = this.f3386;
                if (list == null) {
                    sb.append("null");
                } else {
                    sb.append(list);
                }
            }
            if (mo9425()) {
                sb.append(", ");
                sb.append("checksum:");
                String str = this.f3387;
                if (str == null) {
                    sb.append("null");
                } else {
                    sb.append(str);
                }
            }
            sb.append(")");
            r1.append(sb.toString());
            throw new TProtocolException(r1.toString());
        }
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3383.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3383.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }
}
