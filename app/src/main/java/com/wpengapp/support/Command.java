package com.wpengapp.support;

import java.io.Serializable;
import java.util.HashMap;

@Deprecated
/* renamed from: com.wpengapp.support.ݕ */
public class Command implements Serializable {
    public static final long serialVersionUID = 7123815032741362648L;

    /* renamed from: ֏ */
    public String f2520;

    /* renamed from: ؠ */
    public HashMap<String, Serializable> f2521;

    public String toString() {
        StringBuilder r0 = outline.m2549("Command [cmd=");
        r0.append(this.f2520);
        r0.append(", args=");
        return outline.m2546(r0, (Object) this.f2521, "]");
    }
}
