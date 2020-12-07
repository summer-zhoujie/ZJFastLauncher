package com.wpengapp.support;

/* renamed from: com.wpengapp.support.С */
public abstract class BaseValueEvent implements BaseEvent {

    /* renamed from: ֏ */
    public int f1802;

    public String toString() {
        StringBuilder r0 = outline.m2549("ValueEvent{mValue=");
        r0.append(this.f1802);
        r0.append(",mEventId=");
        r0.append(mo8272());
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: ؠ */
    public int mo8473() {
        return this.f1802;
    }
}
