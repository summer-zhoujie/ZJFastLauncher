package com.wpengapp.support;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ล */
public class UMEnvelope implements Serializable, Cloneable, TBase<UMEnvelope, C1199> {

    /* renamed from: ֏ */
    public static final TStruct f3408 = new TStruct("UMEnvelope");

    /* renamed from: ؠ */
    public static final TField f3409 = new TField("version", (byte) 11, 1);

    /* renamed from: ހ */
    public static final TField f3410 = new TField("address", (byte) 11, 2);

    /* renamed from: ށ */
    public static final TField f3411 = new TField("signature", (byte) 11, 3);

    /* renamed from: ނ */
    public static final TField f3412 = new TField("serial_num", (byte) 8, 4);

    /* renamed from: ރ */
    public static final TField f3413 = new TField("ts_secs", (byte) 8, 5);

    /* renamed from: ބ */
    public static final TField f3414 = new TField("length", (byte) 8, 6);

    /* renamed from: ޅ */
    public static final TField f3415 = new TField("entity", (byte) 11, 7);

    /* renamed from: ކ */
    public static final TField f3416 = new TField("guid", (byte) 11, 8);

    /* renamed from: އ */
    public static final TField f3417 = new TField("checksum", (byte) 11, 9);

    /* renamed from: ވ */
    public static final TField f3418 = new TField("codex", (byte) 8, 10);

    /* renamed from: މ */
    public static final Map<Class<? extends IScheme>, SchemeFactory> f3419 = new HashMap();

    /* renamed from: ފ */
    public static final Map<C1199, FieldMetaData> f3420;

    /* renamed from: ދ */
    public String f3421;

    /* renamed from: ތ */
    public String f3422;

    /* renamed from: ލ */
    public String f3423;

    /* renamed from: ގ */
    public int f3424;

    /* renamed from: ޏ */
    public int f3425;

    /* renamed from: ސ */
    public int f3426;

    /* renamed from: ޑ */
    public ByteBuffer f3427;

    /* renamed from: ޒ */
    public String f3428;

    /* renamed from: ޓ */
    public String f3429;

    /* renamed from: ޔ */
    public int f3430;

    /* renamed from: ޕ */
    public byte f3431 = 0;

    /* renamed from: com.wpengapp.support.ล$֏ */
    /* compiled from: UMEnvelope */
    private static class C1195 extends StandardScheme<UMEnvelope> {
        public /* synthetic */ C1195(C1201 r1) {
        }

        /* renamed from: ֏ */
        public /* synthetic */ void mo9125(TProtocol r2, TBase r3) {
            UMEnvelope r32 = (UMEnvelope) r3;
            r32.mo9433();
            r2.mo8575(UMEnvelope.f3408);
            if (r32.f3421 != null) {
                r2.mo8576(UMEnvelope.f3409);
                r2.mo8579(r32.f3421);
                r2.mo8584();
            }
            if (r32.f3422 != null) {
                r2.mo8576(UMEnvelope.f3410);
                r2.mo8579(r32.f3422);
                r2.mo8584();
            }
            if (r32.f3423 != null) {
                r2.mo8576(UMEnvelope.f3411);
                r2.mo8579(r32.f3423);
                r2.mo8584();
            }
            r2.mo8576(UMEnvelope.f3412);
            r2.mo8573(r32.f3424);
            r2.mo8584();
            r2.mo8576(UMEnvelope.f3413);
            r2.mo8573(r32.f3425);
            r2.mo8584();
            r2.mo8576(UMEnvelope.f3414);
            r2.mo8573(r32.f3426);
            r2.mo8584();
            if (r32.f3427 != null) {
                r2.mo8576(UMEnvelope.f3415);
                r2.mo8580(r32.f3427);
                r2.mo8584();
            }
            if (r32.f3428 != null) {
                r2.mo8576(UMEnvelope.f3416);
                r2.mo8579(r32.f3428);
                r2.mo8584();
            }
            if (r32.f3429 != null) {
                r2.mo8576(UMEnvelope.f3417);
                r2.mo8579(r32.f3429);
                r2.mo8584();
            }
            if (r32.mo9432()) {
                r2.mo8576(UMEnvelope.f3418);
                r2.mo8573(r32.f3430);
                r2.mo8584();
            }
            r2.mo8585();
            r2.mo8583();
        }

        /* renamed from: ؠ */
        public /* synthetic */ void mo9126(TProtocol r6, TBase r7) {
            UMEnvelope r72 = (UMEnvelope) r7;
            r6.mo8588();
            while (true) {
                TField r0 = r6.mo8590();
                byte b = r0.f959;
                if (b == 0) {
                    r6.mo8589();
                    if (!Utils.m1879(r72.f3431, 0)) {
                        throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'serial_num' was not found in serialized data! Struct: ")));
                    } else if (!Utils.m1879(r72.f3431, 1)) {
                        throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'ts_secs' was not found in serialized data! Struct: ")));
                    } else if (Utils.m1879(r72.f3431, 2)) {
                        r72.mo9433();
                        return;
                    } else {
                        throw new TProtocolException(outline.m2542((Object) this, outline.m2549("Required field 'length' was not found in serialized data! Struct: ")));
                    }
                } else {
                    switch (r0.f960) {
                        case 1:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3421 = r6.mo8604();
                                r72.mo9431(true);
                                break;
                            }
                        case 2:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3422 = r6.mo8604();
                                r72.mo9434(true);
                                break;
                            }
                        case 3:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3423 = r6.mo8604();
                                r72.mo9435(true);
                                break;
                            }
                        case 4:
                            if (b != 8) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3424 = r6.mo8601();
                                r72.mo9436(true);
                                break;
                            }
                        case 5:
                            if (b != 8) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3425 = r6.mo8601();
                                r72.mo9437(true);
                                break;
                            }
                        case 6:
                            if (b != 8) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3426 = r6.mo8601();
                                r72.mo9438(true);
                                break;
                            }
                        case 7:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3427 = r6.mo8572();
                                r72.mo9439(true);
                                break;
                            }
                        case 8:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3428 = r6.mo8604();
                                r72.mo9440(true);
                                break;
                            }
                        case 9:
                            if (b != 11) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3429 = r6.mo8604();
                                r72.mo9441(true);
                                break;
                            }
                        case 10:
                            if (b != 8) {
                                TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                                break;
                            } else {
                                r72.f3430 = r6.mo8601();
                                r72.mo9442(true);
                                break;
                            }
                        default:
                            TProtocolUtil.m3568(r6, b, TProtocolUtil.f3741);
                            break;
                    }
                    r6.mo8591();
                }
            }
        }
    }

    /* renamed from: com.wpengapp.support.ล$ؠ */
    /* compiled from: UMEnvelope */
    private static class C1196 implements SchemeFactory {
        public /* synthetic */ C1196(C1201 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1195((C1201) null);
        }
    }

    /* renamed from: com.wpengapp.support.ล$ހ */
    /* compiled from: UMEnvelope */
    private static class C1197 extends TupleScheme<UMEnvelope> {
        public /* synthetic */ C1197(C1201 r1) {
        }

        /* renamed from: ֏ */
        public void mo9125(TProtocol r5, TBase r6) {
            UMEnvelope r62 = (UMEnvelope) r6;
            TTupleProtocol r52 = (TTupleProtocol) r5;
            r52.mo8579(r62.f3421);
            r52.mo8579(r62.f3422);
            r52.mo8579(r62.f3423);
            r52.mo8573(r62.f3424);
            r52.mo8573(r62.f3425);
            r52.mo8573(r62.f3426);
            ByteBuffer byteBuffer = r62.f3427;
            int limit = byteBuffer.limit() - byteBuffer.position();
            r52.mo9471(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), limit);
            r52.mo8579(r62.f3428);
            r52.mo8579(r62.f3429);
            BitSet bitSet = new BitSet();
            if (r62.mo9432()) {
                bitSet.set(0);
            }
            r52.mo9428(bitSet, 1);
            if (r62.mo9432()) {
                r52.mo8573(r62.f3430);
            }
        }

        /* renamed from: ؠ */
        public void mo9126(TProtocol r6, TBase r7) {
            ByteBuffer byteBuffer;
            UMEnvelope r72 = (UMEnvelope) r7;
            TTupleProtocol r62 = (TTupleProtocol) r6;
            r72.f3421 = r62.mo8604();
            r72.mo9431(true);
            r72.f3422 = r62.mo8604();
            r72.mo9434(true);
            r72.f3423 = r62.mo8604();
            r72.mo9435(true);
            r72.f3424 = r62.mo8601();
            r72.mo9436(true);
            r72.f3425 = r62.mo8601();
            r72.mo9437(true);
            r72.f3426 = r62.mo8601();
            r72.mo9438(true);
            int r1 = r62.mo9476();
            r62.mo9474(r1);
            if (r1 == 0) {
                byteBuffer = ByteBuffer.wrap(new byte[0]);
            } else {
                byte[] bArr = new byte[r1];
                r62.f1948.mo8022(bArr, 0, r1);
                byteBuffer = ByteBuffer.wrap(bArr);
            }
            r72.f3427 = byteBuffer;
            r72.mo9439(true);
            r72.f3428 = r62.mo8604();
            r72.mo9440(true);
            r72.f3429 = r62.mo8604();
            r72.mo9441(true);
            if (r62.mo9429(1).get(0)) {
                r72.f3430 = r62.mo8601();
                r72.mo9442(true);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ล$ށ */
    /* compiled from: UMEnvelope */
    private static class C1198 implements SchemeFactory {
        public /* synthetic */ C1198(C1201 r1) {
        }

        /* renamed from: b */
        public /* synthetic */ IScheme mo9127b() {
            return new C1197((C1201) null);
        }
    }

    /* renamed from: com.wpengapp.support.ล$ނ */
    /* compiled from: UMEnvelope */
    public enum C1199 implements TFieldIdEnum {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: ވ */
        public static final Map<String, C1199> f3442 = null;

        /* renamed from: ފ */
        public final String f3444;

        static {
            f3442 = new HashMap();
            Iterator it = EnumSet.allOf(C1199.class).iterator();
            while (it.hasNext()) {
                C1199 r1 = (C1199) it.next();
                f3442.put(r1.f3444, r1);
            }
        }

        /* access modifiers changed from: public */
        C1199(short s, String str) {
            this.f3444 = str;
        }
    }

    static {
        f3419.put(StandardScheme.class, new C1196((C1201) null));
        f3419.put(TupleScheme.class, new C1198((C1201) null));
        EnumMap enumMap = new EnumMap(C1199.class);
        enumMap.put(C1199.VERSION, new FieldMetaData("version", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1199.ADDRESS, new FieldMetaData("address", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1199.SIGNATURE, new FieldMetaData("signature", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1199.SERIAL_NUM, new FieldMetaData("serial_num", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        enumMap.put(C1199.TS_SECS, new FieldMetaData("ts_secs", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        enumMap.put(C1199.LENGTH, new FieldMetaData("length", (byte) 1, new FieldValueMetaData((byte) 8, false)));
        enumMap.put(C1199.ENTITY, new FieldMetaData("entity", (byte) 1, new FieldValueMetaData((byte) 11, true)));
        enumMap.put(C1199.GUID, new FieldMetaData("guid", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1199.CHECKSUM, new FieldMetaData("checksum", (byte) 1, new FieldValueMetaData((byte) 11, false)));
        enumMap.put(C1199.CODEX, new FieldMetaData("codex", (byte) 2, new FieldValueMetaData((byte) 8, false)));
        f3420 = Collections.unmodifiableMap(enumMap);
        Map<C1199, FieldMetaData> map = f3420;
        FieldMetaData.f1830.put(UMEnvelope.class, map);
    }

    public UMEnvelope() {
        new C1199[1][0] = C1199.CODEX;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f3421;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f3422;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f3423;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f3424);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f3425);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f3426);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f3427;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            TBaseHelper.m1614(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f3428;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f3429;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (mo9432()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f3430);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ֏ */
    public void mo9431(boolean z) {
        if (!z) {
            this.f3421 = null;
        }
    }

    /* renamed from: ؠ */
    public void mo9434(boolean z) {
        if (!z) {
            this.f3422 = null;
        }
    }

    /* renamed from: ހ */
    public void mo9435(boolean z) {
        if (!z) {
            this.f3423 = null;
        }
    }

    /* renamed from: ށ */
    public void mo9436(boolean z) {
        this.f3431 = Utils.m1855(this.f3431, 0, z);
    }

    /* renamed from: ނ */
    public void mo9437(boolean z) {
        this.f3431 = Utils.m1855(this.f3431, 1, z);
    }

    /* renamed from: ރ */
    public void mo9438(boolean z) {
        this.f3431 = Utils.m1855(this.f3431, 2, z);
    }

    /* renamed from: ބ */
    public void mo9439(boolean z) {
        if (!z) {
            this.f3427 = null;
        }
    }

    /* renamed from: ޅ */
    public void mo9440(boolean z) {
        if (!z) {
            this.f3428 = null;
        }
    }

    /* renamed from: ކ */
    public void mo9441(boolean z) {
        if (!z) {
            this.f3429 = null;
        }
    }

    /* renamed from: އ */
    public void mo9442(boolean z) {
        this.f3431 = Utils.m1855(this.f3431, 3, z);
    }

    /* renamed from: ֏ */
    public boolean mo9432() {
        return Utils.m1879(this.f3431, 3);
    }

    /* renamed from: ؠ */
    public void mo9122(TProtocol r3) {
        f3419.get(r3.mo8582()).mo9127b().mo9125(r3, this);
    }

    /* renamed from: ֏ */
    public void mo9120(TProtocol r3) {
        f3419.get(r3.mo8582()).mo9127b().mo9126(r3, this);
    }

    /* renamed from: ؠ */
    public void mo9433() {
        if (this.f3421 == null) {
            StringBuilder r1 = outline.m2549("Required field 'version' was not present! Struct: ");
            r1.append(toString());
            throw new TProtocolException(r1.toString());
        } else if (this.f3422 == null) {
            StringBuilder r12 = outline.m2549("Required field 'address' was not present! Struct: ");
            r12.append(toString());
            throw new TProtocolException(r12.toString());
        } else if (this.f3423 == null) {
            StringBuilder r13 = outline.m2549("Required field 'signature' was not present! Struct: ");
            r13.append(toString());
            throw new TProtocolException(r13.toString());
        } else if (this.f3427 == null) {
            StringBuilder r14 = outline.m2549("Required field 'entity' was not present! Struct: ");
            r14.append(toString());
            throw new TProtocolException(r14.toString());
        } else if (this.f3428 == null) {
            StringBuilder r15 = outline.m2549("Required field 'guid' was not present! Struct: ");
            r15.append(toString());
            throw new TProtocolException(r15.toString());
        } else if (this.f3429 == null) {
            StringBuilder r16 = outline.m2549("Required field 'checksum' was not present! Struct: ");
            r16.append(toString());
            throw new TProtocolException(r16.toString());
        }
    }
}
