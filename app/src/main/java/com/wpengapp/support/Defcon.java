package com.wpengapp.support;

import android.content.Context;
import com.wpengapp.support.ImprintHandler;
import com.wpengapp.support.UMEntry;
import java.util.List;

/* renamed from: com.wpengapp.support.ǁ */
public class Defcon implements OnImprintChangedListener {

    /* renamed from: ֏ */
    public static Defcon f970;

    /* renamed from: ؠ */
    public int f971 = 0;

    /* renamed from: ֏ */
    public static synchronized Defcon m1237(Context context) {
        Defcon r3;
        synchronized (Defcon.class) {
            if (f970 == null) {
                f970 = new Defcon();
                int i = 0;
                int i2 = ImprintHandler.m1668(context).f1682.f1685;
                if (i2 != -1) {
                    if (i2 <= 3) {
                        if (i2 >= 0) {
                            i = i2;
                        }
                    }
                }
                f970.mo8089(i);
            }
            r3 = f970;
        }
        return r3;
    }

    /* renamed from: ֏ */
    public void mo8090(UMEntry r8, Context context) {
        int i = this.f971;
        if (i == 1) {
            UMEntry.C0559 r82 = r8.f1103;
            r82.f1144 = null;
            r82.f1136 = null;
            r82.f1137 = null;
            r82.f1143 = null;
        } else if (i == 2) {
            r8.f1103.f1138.clear();
            List<UMEntry.C0561> list = r8.f1103.f1138;
            UMEntry.C0561 r2 = new UMEntry.C0561();
            r2.f1187 = SessionTracker.m1840(context);
            long currentTimeMillis = System.currentTimeMillis();
            r2.f1188 = currentTimeMillis;
            r2.f1189 = currentTimeMillis + 60000;
            r2.f1190 = 60000;
            list.add(r2);
            UMEntry.C0559 r83 = r8.f1103;
            r83.f1144 = null;
            r83.f1136 = null;
            r83.f1137 = null;
            r83.f1143 = null;
        } else if (i == 3) {
            UMEntry.C0559 r84 = r8.f1103;
            r84.f1138 = null;
            r84.f1144 = null;
            r84.f1136 = null;
            r84.f1137 = null;
            r84.f1143 = null;
        }
    }

    /* renamed from: ֏ */
    public void mo8089(int i) {
        if (i >= 0 && i <= 3) {
            this.f971 = i;
        }
    }

    /* renamed from: ֏ */
    public boolean mo8092() {
        return this.f971 != 0;
    }

    /* renamed from: ֏ */
    public void mo8091(ImprintHandler.C0654 r3) {
        int i = r3.f1685;
        int i2 = 0;
        if (i != -1 && i <= 3 && i >= 0) {
            i2 = i;
        }
        mo8089(i2);
    }
}
