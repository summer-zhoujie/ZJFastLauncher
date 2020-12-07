package com.wpengapp.support;

import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.wpengapp.support.ࡄ */
public final class RouteDatabase {

    /* renamed from: ֏ */
    public final Set<Route> f2804 = new LinkedHashSet();

    /* renamed from: ֏ */
    public synchronized void mo9053(Route r2) {
        this.f2804.remove(r2);
    }

    /* renamed from: ؠ */
    public synchronized void mo9054(Route r2) {
        this.f2804.add(r2);
    }

    /* renamed from: ހ */
    public synchronized boolean mo9055(Route r2) {
        return this.f2804.contains(r2);
    }
}
