package com.wpengapp.support;

import java.nio.ByteBuffer;

/* renamed from: com.wpengapp.support.ӱ */
public abstract class TProtocol {

    /* renamed from: ֏ */
    public TTransport f1948;

    public TProtocol(TTransport r1) {
        this.f1948 = r1;
    }

    /* renamed from: ֏ */
    public abstract ByteBuffer mo8572();

    /* renamed from: ֏ */
    public abstract void mo8573(int i);

    /* renamed from: ֏ */
    public abstract void mo8574(long j);

    /* renamed from: ֏ */
    public abstract void mo8575(TStruct r1);

    /* renamed from: ֏ */
    public abstract void mo8576(TField r1);

    /* renamed from: ֏ */
    public abstract void mo8577(TList r1);

    /* renamed from: ֏ */
    public abstract void mo8578(TMap r1);

    /* renamed from: ֏ */
    public abstract void mo8579(String str);

    /* renamed from: ֏ */
    public abstract void mo8580(ByteBuffer byteBuffer);

    /* renamed from: ؠ */
    public void mo8581() {
    }

    /* renamed from: ހ */
    public Class<? extends IScheme> mo8582() {
        return StandardScheme.class;
    }

    /* renamed from: ށ */
    public abstract void mo8583();

    /* renamed from: ނ */
    public abstract void mo8584();

    /* renamed from: ރ */
    public abstract void mo8585();

    /* renamed from: ބ */
    public abstract void mo8586();

    /* renamed from: ޅ */
    public abstract void mo8587();

    /* renamed from: ކ */
    public abstract TStruct mo8588();

    /* renamed from: އ */
    public abstract void mo8589();

    /* renamed from: ވ */
    public abstract TField mo8590();

    /* renamed from: މ */
    public abstract void mo8591();

    /* renamed from: ފ */
    public abstract TMap mo8592();

    /* renamed from: ދ */
    public abstract void mo8593();

    /* renamed from: ތ */
    public abstract TList mo8594();

    /* renamed from: ލ */
    public abstract void mo8595();

    /* renamed from: ގ */
    public abstract TSet mo8596();

    /* renamed from: ޏ */
    public abstract void mo8597();

    /* renamed from: ސ */
    public abstract boolean mo8598();

    /* renamed from: ޑ */
    public abstract byte mo8599();

    /* renamed from: ޒ */
    public abstract short mo8600();

    /* renamed from: ޓ */
    public abstract int mo8601();

    /* renamed from: ޔ */
    public abstract long mo8602();

    /* renamed from: ޕ */
    public abstract double mo8603();

    /* renamed from: ޖ */
    public abstract String mo8604();
}
