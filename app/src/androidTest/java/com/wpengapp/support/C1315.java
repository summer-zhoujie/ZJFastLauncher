package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.view.PointerIconCompat;
import com.wpengapp.support.C1086;
import com.wpengapp.support.UMCCStorageManager;
import com.wpengapp.support.UMEntry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.Ⴟ */
/* compiled from: UMCCAggregatedManager */
public class C1315 {

    /* renamed from: ֏ */
    public static Context f3758;

    /* renamed from: ؠ */
    public UMCCAggregatedListObject f3759 = null;

    /* renamed from: ހ */
    public UMCCStorageManager f3760 = null;

    /* renamed from: ށ */
    public UMCCSystemBufferManager f3761 = null;

    /* renamed from: ނ */
    public boolean f3762 = false;

    /* renamed from: ރ */
    public boolean f3763 = false;

    /* renamed from: ބ */
    public long f3764 = 0;

    /* renamed from: ޅ */
    public List<String> f3765 = new ArrayList();

    /* renamed from: ކ */
    public C1316 f3766 = null;

    /* renamed from: އ */
    public final Thread f3767 = new Thread(new C1145(this));

    /* renamed from: com.wpengapp.support.Ⴟ$֏ */
    /* compiled from: UMCCAggregatedManager */
    private static class C1316 extends Handler {

        /* renamed from: ֏ */
        public final WeakReference<C1315> f3768;

        public C1316(C1315 r2) {
            this.f3768 = new WeakReference<>(r2);
        }

        public void handleMessage(Message message) {
            if (this.f3768 != null) {
                int i = message.what;
                if (i == 48) {
                    sendEmptyMessageDelayed(48, Utils.m1858(System.currentTimeMillis(), (int) PointerIconCompat.TYPE_CONTEXT_MENU));
                    C1315.f3758 = C1315.f3758;
                    C1317.f3769.mo9588();
                } else if (i == 49) {
                    sendEmptyMessageDelayed(49, Utils.m1858(System.currentTimeMillis(), (int) PointerIconCompat.TYPE_HAND));
                    C1315.f3758 = C1315.f3758;
                    C1317.f3769.mo9587();
                }
            }
        }
    }

    /* renamed from: com.wpengapp.support.Ⴟ$ؠ */
    /* compiled from: UMCCAggregatedManager */
    private static class C1317 {

        /* renamed from: ֏ */
        public static final C1315 f3769 = new C1315((C1145) null);
    }

    public /* synthetic */ C1315(C1145 r3) {
        if (f3758 != null) {
            if (this.f3759 == null) {
                this.f3759 = new UMCCAggregatedListObject();
            }
            if (this.f3760 == null) {
                UMCCStorageManager.f888 = f3758;
                this.f3760 = UMCCStorageManager.C0499.f889;
            }
            if (this.f3761 == null) {
                this.f3761 = new UMCCSystemBufferManager();
            }
        }
        this.f3767.start();
    }

    /* renamed from: ֏ */
    public final void mo9582() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3766.sendEmptyMessageDelayed(48, Utils.m1858(currentTimeMillis, (int) PointerIconCompat.TYPE_CONTEXT_MENU));
        this.f3766.sendEmptyMessageDelayed(49, Utils.m1858(currentTimeMillis, (int) PointerIconCompat.TYPE_HAND));
    }

    /* renamed from: ؠ */
    public final void mo9586() {
        SharedPreferences r0 = Utils.m1861(f3758);
        this.f3763 = r0.getBoolean("main_fest_mode", false);
        this.f3764 = r0.getLong("main_fest_timestamp", 0);
    }

    /* renamed from: ހ */
    public final void mo9587() {
        try {
            if (this.f3759.f912.size() > 0) {
                this.f3760.mo8039(new C1185(this), this.f3759.f912);
            }
            if (this.f3761.f3665.size() > 0) {
                this.f3760.mo8038(new C1223(this), this.f3761.f3665);
            }
            if (this.f3765.size() > 0) {
                this.f3760.mo8033(new Callback(), this.f3765);
            }
        } catch (Throwable th) {
            StringBuilder r1 = outline.m2549("converyMemoryToDataTable happen error: ");
            r1.append(th.toString());
            r1.toString();
            String str = MLog.f1805;
            boolean z = MLog.f1804;
        }
    }

    /* renamed from: ށ */
    public final void mo9588() {
        try {
            if (this.f3759.f912.size() > 0) {
                this.f3760.mo8034((Callback) new C1172(this), this.f3759.f912);
            }
            if (this.f3761.f3665.size() > 0) {
                this.f3760.mo8038(new C0683(this), this.f3761.f3665);
            }
            if (this.f3765.size() > 0) {
                this.f3760.mo8033(new Callback(), this.f3765);
            }
        } catch (Throwable th) {
            StringBuilder r1 = outline.m2549("convertMemoryToCacheTable happen error: ");
            r1.append(th.toString());
            r1.toString();
            String str = MLog.f1805;
            boolean z = MLog.f1804;
        }
    }

    /* renamed from: ֏ */
    public void mo9585(Callback r6, Map<List<String>, UMCCVerbatimObject> map) {
        UMCCVerbatimObject r7 = (UMCCVerbatimObject) map.values().toArray()[0];
        List<String> list = r7.f1673;
        if (this.f3765.size() > 0 && this.f3765.contains(Utils.m1869(list))) {
            this.f3759.mo8057((Callback) new C1306(this, r6), r7);
        } else if (this.f3763) {
            this.f3759.mo8059(new C0563(this), r7, list, this.f3765);
        } else {
            int size = this.f3765.size();
            C1086.C1087.f3084.mo9265();
            if (size < 512) {
                String r62 = Utils.m1869(list);
                if (!this.f3765.contains(r62)) {
                    this.f3765.add(r62);
                }
                this.f3759.mo8060((Callback) new C0767(this), list, r7);
                return;
            }
            this.f3759.mo8059(new C0563(this), r7, list, this.f3765);
            SharedPreferences r63 = Utils.m1861(f3758);
            if (!r63.getBoolean("main_fest_mode", false)) {
                this.f3763 = true;
                SharedPreferences.Editor edit = r63.edit();
                edit.putBoolean("main_fest_mode", true);
                edit.putLong("main_fest_timestamp", System.currentTimeMillis());
                edit.commit();
            }
        }
    }

    /* renamed from: ֏ */
    public void mo9584(UMEntry r7) {
        UMEntry.C0550 r0 = r7.f1103.f1143;
        if (r0 != null) {
            Map<String, List<UMEntry.C0551>> r1 = this.f3760.mo8030();
            HashMap hashMap = new HashMap();
            if (r1 == null || r1.size() <= 0) {
                hashMap = null;
            } else {
                for (String next : this.f3765) {
                    if (r1.containsKey(next)) {
                        hashMap.put(next, r1.get(next));
                    }
                }
            }
            r0.f1107 = hashMap;
            UMEntry.C0550 r72 = r7.f1103.f1143;
            if (this.f3761.f3665.size() > 0) {
                this.f3760.mo8038(new UMCCAggregatedManager(this), this.f3761.f3665);
            }
            r72.f1108 = this.f3760.mo8037(new Callback());
        }
    }

    /* renamed from: ֏ */
    public void mo9583(long j, long j2, String str) {
        this.f3760.mo8032(new C0800(this), str, j, j2);
    }
}
