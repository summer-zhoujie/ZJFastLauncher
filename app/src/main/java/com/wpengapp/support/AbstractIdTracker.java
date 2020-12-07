package com.wpengapp.support;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.Ű */
public abstract class AbstractIdTracker {

    /* renamed from: ֏ */
    public final String f885;

    /* renamed from: ؠ */
    public List<IdJournal> f886;

    /* renamed from: ހ */
    public C1088 f887;

    public AbstractIdTracker(String str) {
        this.f885 = str;
    }

    /* renamed from: ֏ */
    public boolean mo8027() {
        C1088 r0 = this.f887;
        return r0 == null || r0.f3093 <= 20;
    }

    /* renamed from: ؠ */
    public abstract String mo8028();

    /* renamed from: ֏ */
    public void mo8026(C1187 r4) {
        this.f887 = r4.f3385.get(this.f885);
        List<IdJournal> list = r4.f3386;
        if (list != null && list.size() > 0) {
            if (this.f886 == null) {
                this.f886 = new ArrayList();
            }
            for (IdJournal next : list) {
                if (this.f885.equals(next.f3072)) {
                    this.f886.add(next);
                }
            }
        }
    }
}
