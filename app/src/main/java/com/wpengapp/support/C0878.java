package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.QueuedWork;
import com.umeng.analytics.ReportPolicy;
import com.umeng.analytics.StoreHelper;
import com.wpengapp.support.ImprintHandler;
import com.wpengapp.support.UMEntry;
import java.util.List;

/* renamed from: com.wpengapp.support.ڄ */
/* compiled from: CacheImpl */
public final class C0878 implements ICacheService, OnImprintChangedListener {

    /* renamed from: ֏ */
    public static Context f2378;

    /* renamed from: ؠ */
    public MemoCache f2379 = null;

    /* renamed from: ހ */
    public StoreHelper f2380 = null;

    /* renamed from: ށ */
    public StatTracer f2381 = null;

    /* renamed from: ނ */
    public Defcon f2382 = null;

    /* renamed from: ރ */
    public ABTest f2383 = null;

    /* renamed from: ބ */
    public ImLatent f2384 = null;

    /* renamed from: ޅ */
    public C0879 f2385 = null;

    /* renamed from: ކ */
    public ImprintHandler.C0654 f2386 = null;

    /* renamed from: އ */
    public int f2387 = 10;

    /* renamed from: ވ */
    public long f2388 = 0;

    /* renamed from: މ */
    public int f2389 = 0;

    /* renamed from: ފ */
    public int f2390 = 0;

    public C0878(Context context) {
        f2378 = context;
        this.f2379 = new MemoCache(context);
        this.f2381 = new StatTracer(context);
        this.f2380 = StoreHelper.m156a(context);
        this.f2386 = ImprintHandler.m1668(context).f1682;
        this.f2385 = new C0879();
        this.f2383 = ABTest.m2129(f2378);
        this.f2382 = Defcon.m1237(f2378);
        this.f2384 = ImLatent.m1835(f2378, this.f2381);
        SharedPreferences r5 = Utils.m1861(f2378);
        this.f2388 = r5.getLong("thtstart", 0);
        this.f2389 = r5.getInt("gkvc", 0);
        this.f2390 = r5.getInt("ekvc", 0);
    }

    /* renamed from: a */
    public void mo8609a() {
        if (DeviceConfig.m2329(f2378)) {
            mo8843();
            return;
        }
        String str = MLog.f1805;
        boolean z = MLog.f1804;
    }

    /* renamed from: b */
    public void mo8610b() {
        if (this.f2379.mo8556() > 0) {
            try {
                this.f2380.mo7337a(mo8838(new int[0]));
            } catch (Throwable th) {
                MLog.m1772(th);
                if (th instanceof OutOfMemoryError) {
                    this.f2380.mo7351h();
                }
                th.printStackTrace();
            }
        }
        Utils.m1861(f2378).edit().putLong("thtstart", this.f2388).putInt("gkvc", this.f2389).putInt("ekvc", this.f2390).commit();
    }

    /* renamed from: ؠ */
    public void mo8613(IProtocol r2) {
        this.f2379.mo8558(r2);
    }

    /* renamed from: ހ */
    public final boolean mo8844() {
        int i;
        ImprintHandler.C0654 r0 = this.f2386;
        int i2 = r0.f1687;
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            i = r0.f1687;
        } else {
            i = -1;
        }
        if (i == -1) {
            return AnalyticsConfig.sEncrypt;
        }
        if (i == 0 || i != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8612(com.wpengapp.support.IProtocol r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            com.wpengapp.support.ҽ r0 = r10.f2379
            r0.mo8558((com.wpengapp.support.IProtocol) r11)
        L_0x0007:
            boolean r11 = r11 instanceof com.wpengapp.support.UMEntry.C0561
            com.wpengapp.support.ɒ r0 = r10.f2381
            boolean r0 = r0.mo8192()
            if (r0 == 0) goto L_0x0022
            com.wpengapp.support.ɒ r1 = r10.f2381
            boolean r2 = r1.mo8195()
            if (r2 == 0) goto L_0x001e
            long r1 = java.lang.System.currentTimeMillis()
            goto L_0x0020
        L_0x001e:
            long r1 = r1.f1227
        L_0x0020:
            com.wpengapp.support.UMEntry.f1101 = r1
        L_0x0022:
            android.content.Context r1 = f2378
            boolean r1 = com.wpengapp.support.DeviceConfig.m2329(r1)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0033
            java.lang.String r11 = com.wpengapp.support.MLog.f1805
            boolean r11 = com.wpengapp.support.MLog.f1804
            r11 = 0
            goto L_0x0180
        L_0x0033:
            com.wpengapp.support.ɒ r1 = r10.f2381
            boolean r1 = r1.mo8192()
            if (r1 == 0) goto L_0x003e
            r11 = 1
            goto L_0x0180
        L_0x003e:
            com.wpengapp.support.ڄ$֏ r1 = r10.f2385
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ǁ r4 = r4.f2382
            boolean r4 = r4.mo8092()
            if (r4 == 0) goto L_0x0071
            com.umeng.analytics.ReportPolicy$i r4 = r1.f2391
            boolean r5 = r4 instanceof com.umeng.analytics.ReportPolicy.C0380b
            if (r5 == 0) goto L_0x005a
            boolean r4 = r4.mo7272a()
            if (r4 == 0) goto L_0x005a
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            if (r4 == 0) goto L_0x0060
            com.umeng.analytics.ReportPolicy$i r4 = r1.f2391
            goto L_0x006d
        L_0x0060:
            com.umeng.analytics.ReportPolicy$b r4 = new com.umeng.analytics.ReportPolicy$b
            com.wpengapp.support.ڄ r5 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ɒ r6 = r5.f2381
            com.wpengapp.support.ǁ r5 = r5.f2382
            r4.<init>(r6, r5)
        L_0x006d:
            r1.f2391 = r4
            goto L_0x0160
        L_0x0071:
            com.umeng.analytics.ReportPolicy$i r4 = r1.f2391
            boolean r5 = r4 instanceof com.umeng.analytics.ReportPolicy.C0381c
            if (r5 == 0) goto L_0x007f
            boolean r4 = r4.mo7272a()
            if (r4 == 0) goto L_0x007f
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r4 != 0) goto L_0x0160
            if (r11 == 0) goto L_0x00e9
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.Ҍ r4 = r4.f2384
            com.umeng.analytics.h r5 = r4.f1875
            boolean r5 = r5.mo7352i()
            if (r5 == 0) goto L_0x0091
            goto L_0x00c8
        L_0x0091:
            com.wpengapp.support.ɒ r5 = r4.f1876
            boolean r5 = r5.mo8192()
            if (r5 == 0) goto L_0x009a
            goto L_0x00c8
        L_0x009a:
            long r5 = java.lang.System.currentTimeMillis()
            com.wpengapp.support.ɒ r7 = r4.f1876
            long r7 = r7.mo8196()
            long r5 = r5 - r7
            long r7 = r4.f1877
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00bb
            android.content.Context r5 = r4.f1880
            java.lang.String r5 = com.wpengapp.support.Envelope.m3063(r5)
            int r6 = r4.f1878
            int r5 = com.umeng.analytics.DataHelper.m57a((int) r6, (java.lang.String) r5)
            long r5 = (long) r5
            r4.f1879 = r5
            goto L_0x00c6
        L_0x00bb:
            r7 = 129600000(0x7b98a00, double:6.40309077E-316)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c8
            r5 = 0
            r4.f1879 = r5
        L_0x00c6:
            r4 = 1
            goto L_0x00c9
        L_0x00c8:
            r4 = 0
        L_0x00c9:
            if (r4 == 0) goto L_0x00e9
            com.umeng.analytics.ReportPolicy$c r4 = new com.umeng.analytics.ReportPolicy$c
            com.wpengapp.support.ڄ r5 = com.wpengapp.support.C0878.this
            com.wpengapp.support.Ҍ r5 = r5.f2384
            long r5 = r5.mo8533()
            int r6 = (int) r5
            r4.<init>(r6)
            r1.f2391 = r4
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.Ҍ r5 = r4.f2384
            long r5 = r5.mo8533()
            int r6 = (int) r5
            r4.mo8839((int) r6)
            goto L_0x0160
        L_0x00e9:
            boolean r4 = com.wpengapp.support.MLog.f1804
            if (r4 == 0) goto L_0x010a
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ρ$֏ r4 = r4.f2386
            int r4 = r4.f1693
            if (r4 != r2) goto L_0x00f7
            r4 = 1
            goto L_0x00f8
        L_0x00f7:
            r4 = 0
        L_0x00f8:
            if (r4 == 0) goto L_0x010a
            java.lang.String r4 = com.wpengapp.support.MLog.f1805
            boolean r4 = com.wpengapp.support.MLog.f1804
            com.umeng.analytics.ReportPolicy$a r4 = new com.umeng.analytics.ReportPolicy$a
            com.wpengapp.support.ڄ r5 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ɒ r5 = r5.f2381
            r4.<init>(r5)
            r1.f2391 = r4
            goto L_0x0160
        L_0x010a:
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.դ r4 = r4.f2383
            boolean r5 = r4.f2063
            r6 = -1
            if (r5 == 0) goto L_0x014f
            java.lang.String r5 = com.wpengapp.support.MLog.f1805
            boolean r5 = com.wpengapp.support.MLog.f1804
            int r4 = r4.mo8681()
            r5 = 6
            if (r4 != r5) goto L_0x013f
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ρ$֏ r4 = r4.f2386
            int r4 = r4.f1691
            if (r4 == r6) goto L_0x0128
            r4 = 1
            goto L_0x0129
        L_0x0128:
            r4 = 0
        L_0x0129:
            if (r4 == 0) goto L_0x0137
            com.wpengapp.support.ڄ r4 = com.wpengapp.support.C0878.this
            com.wpengapp.support.ρ$֏ r4 = r4.f2386
            r5 = 90000(0x15f90, float:1.26117E-40)
            int r4 = r4.mo8413((int) r5)
            goto L_0x0140
        L_0x0137:
            int r4 = r1.f2393
            if (r4 <= 0) goto L_0x013c
            goto L_0x0140
        L_0x013c:
            int r4 = r1.f2395
            goto L_0x0140
        L_0x013f:
            r4 = 0
        L_0x0140:
            com.wpengapp.support.ڄ r5 = com.wpengapp.support.C0878.this
            com.wpengapp.support.դ r5 = r5.f2383
            int r5 = r5.mo8681()
            com.umeng.analytics.ReportPolicy$i r4 = r1.mo8845(r5, r4)
            r1.f2391 = r4
            goto L_0x0160
        L_0x014f:
            int r4 = r1.f2394
            int r5 = r1.f2395
            int r7 = r1.f2392
            if (r7 == r6) goto L_0x015a
            int r5 = r1.f2393
            r4 = r7
        L_0x015a:
            com.umeng.analytics.ReportPolicy$i r4 = r1.mo8845(r4, r5)
            r1.f2391 = r4
        L_0x0160:
            java.lang.String r4 = "Report policy : "
            java.lang.StringBuilder r4 = com.wpengapp.support.outline.m2549(r4)
            com.umeng.analytics.ReportPolicy$i r5 = r1.f2391
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            r4.toString()
            java.lang.String r4 = com.wpengapp.support.MLog.f1805
            boolean r4 = com.wpengapp.support.MLog.f1804
            com.umeng.analytics.ReportPolicy$i r1 = r1.f2391
            boolean r11 = r1.mo7271a(r11)
        L_0x0180:
            if (r11 == 0) goto L_0x0186
            r10.mo8843()
            goto L_0x01df
        L_0x0186:
            if (r0 != 0) goto L_0x0196
            com.wpengapp.support.ҽ r11 = r10.f2379
            int r11 = r11.mo8556()
            int r0 = r10.f2387
            if (r11 <= r0) goto L_0x0193
            goto L_0x0194
        L_0x0193:
            r2 = 0
        L_0x0194:
            if (r2 == 0) goto L_0x01df
        L_0x0196:
            com.wpengapp.support.ҽ r11 = r10.f2379
            int r11 = r11.mo8556()
            if (r11 <= 0) goto L_0x01ba
            com.umeng.analytics.h r11 = r10.f2380     // Catch:{ Throwable -> 0x01aa }
            int[] r0 = new int[r3]     // Catch:{ Throwable -> 0x01aa }
            com.wpengapp.support.ȴ r0 = r10.mo8838((int[]) r0)     // Catch:{ Throwable -> 0x01aa }
            r11.mo7337a((com.wpengapp.support.UMEntry) r0)     // Catch:{ Throwable -> 0x01aa }
            goto L_0x01ba
        L_0x01aa:
            r11 = move-exception
            com.wpengapp.support.MLog.m1772((java.lang.Throwable) r11)
            boolean r0 = r11 instanceof java.lang.OutOfMemoryError
            if (r0 == 0) goto L_0x01b7
            com.umeng.analytics.h r0 = r10.f2380
            r0.mo7351h()
        L_0x01b7:
            r11.printStackTrace()
        L_0x01ba:
            android.content.Context r11 = f2378
            android.content.SharedPreferences r11 = com.wpengapp.support.Utils.m1861((android.content.Context) r11)
            android.content.SharedPreferences$Editor r11 = r11.edit()
            long r0 = r10.f2388
            java.lang.String r2 = "thtstart"
            android.content.SharedPreferences$Editor r11 = r11.putLong(r2, r0)
            int r0 = r10.f2389
            java.lang.String r1 = "gkvc"
            android.content.SharedPreferences$Editor r11 = r11.putInt(r1, r0)
            int r0 = r10.f2390
            java.lang.String r1 = "ekvc"
            android.content.SharedPreferences$Editor r11 = r11.putInt(r1, r0)
            r11.commit()
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0878.mo8612(com.wpengapp.support.ӄ):void");
    }

    /* renamed from: ؠ */
    public final void mo8843() {
        try {
            if (this.f2380.mo7352i()) {
                Sender r0 = new Sender(f2378, this.f2381);
                r0.f761.f1681 = this;
                if (this.f2382.mo8092()) {
                    r0.f766 = true;
                }
                r0.mo7927();
                return;
            }
            boolean z = false;
            UMEntry r2 = mo8838(new int[0]);
            if (r2 != null) {
                UMEntry.C0560 r3 = r2.f1102;
                if ((r3.f1165 == null || r3.f1164 == null || r3.f1163 == null || r3.f1146 == null || r3.f1147 == null || r3.f1151 == null || r3.f1150 == null || r3.f1149 == null) ? false : true) {
                    z = true;
                }
            }
            if (z) {
                Sender r02 = new Sender(f2378, this.f2381);
                r02.f761.f1681 = this;
                if (this.f2382.mo8092()) {
                    r02.f766 = true;
                }
                mo8842(r2);
                r02.f764 = r2;
                r02.f765 = mo8844();
                r02.mo7927();
            }
        } catch (Throwable th) {
            boolean z2 = th instanceof OutOfMemoryError;
            th.printStackTrace();
        }
    }

    /* renamed from: com.wpengapp.support.ڄ$֏ */
    /* compiled from: CacheImpl */
    public class C0879 {

        /* renamed from: ֏ */
        public ReportPolicy.C0387i f2391;

        /* renamed from: ؠ */
        public int f2392 = -1;

        /* renamed from: ހ */
        public int f2393 = -1;

        /* renamed from: ށ */
        public int f2394 = -1;

        /* renamed from: ނ */
        public int f2395 = -1;

        public C0879() {
            int[] r2 = C0878.this.f2386.mo8417(-1, -1);
            this.f2392 = r2[0];
            this.f2393 = r2[1];
        }

        /* renamed from: ֏ */
        public final ReportPolicy.C0387i mo8845(int i, int i2) {
            if (i == 0) {
                ReportPolicy.C0387i iVar = this.f2391;
                return iVar instanceof ReportPolicy.C0386h ? iVar : new ReportPolicy.C0386h();
            } else if (i == 1) {
                ReportPolicy.C0387i iVar2 = this.f2391;
                if (iVar2 instanceof ReportPolicy.C0382d) {
                    return iVar2;
                }
                return new ReportPolicy.C0382d();
            } else if (i == 4) {
                ReportPolicy.C0387i iVar3 = this.f2391;
                if (iVar3 instanceof ReportPolicy.C0385g) {
                    return iVar3;
                }
                return new ReportPolicy.C0385g(C0878.this.f2381);
            } else if (i == 5) {
                ReportPolicy.C0387i iVar4 = this.f2391;
                if (iVar4 instanceof ReportPolicy.C0388j) {
                    return iVar4;
                }
                return new ReportPolicy.C0388j(C0878.f2378);
            } else if (i == 6) {
                ReportPolicy.C0387i iVar5 = this.f2391;
                if (!(iVar5 instanceof ReportPolicy.C0383e)) {
                    return new ReportPolicy.C0383e(C0878.this.f2381, (long) i2);
                }
                ((ReportPolicy.C0383e) iVar5).mo7273a((long) i2);
                return iVar5;
            } else if (i != 8) {
                ReportPolicy.C0387i iVar6 = this.f2391;
                if (iVar6 instanceof ReportPolicy.C0382d) {
                    return iVar6;
                }
                return new ReportPolicy.C0382d();
            } else {
                ReportPolicy.C0387i iVar7 = this.f2391;
                if (iVar7 instanceof ReportPolicy.C0389k) {
                    return iVar7;
                }
                return new ReportPolicy.C0389k(C0878.this.f2381);
            }
        }

        /* renamed from: ֏ */
        public void mo8846(ImprintHandler.C0654 r2) {
            int[] r22 = r2.mo8417(-1, -1);
            this.f2392 = r22[0];
            this.f2393 = r22[1];
        }
    }

    /* renamed from: ؠ */
    public final UMEntry mo8842(UMEntry r11) {
        int i;
        int i2;
        if (r11.f1103.f1136 != null) {
            i = 0;
            for (int i3 = 0; i3 < r11.f1103.f1136.size(); i3++) {
                i += r11.f1103.f1136.get(i3).f1121.size();
            }
        } else {
            i = 0;
        }
        if (r11.f1103.f1137 != null) {
            for (int i4 = 0; i4 < r11.f1103.f1137.size(); i4++) {
                i += r11.f1103.f1137.get(i4).f1121.size();
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = 5000;
        if (currentTimeMillis - this.f2388 > 28800000) {
            int i6 = i - 5000;
            if (i6 > 0) {
                mo8840(-5000, i6, r11);
            }
            this.f2389 = 0;
            if (i6 <= 0) {
                i5 = i;
            }
            this.f2390 = i5;
            this.f2388 = currentTimeMillis;
        } else {
            int i7 = this.f2389;
            int i8 = i7 > 5000 ? 0 : (i7 + 0) - 5000;
            int i9 = this.f2390;
            int i10 = i9 > 5000 ? i : (i9 + i) - 5000;
            if (i8 > 0 || i10 > 0) {
                mo8840(i8, i10, r11);
            }
            if (i8 > 0) {
                i2 = 5000;
            } else {
                i2 = 0 + this.f2389;
            }
            this.f2389 = i2;
            if (i10 <= 0) {
                i5 = this.f2390 + i;
            }
            this.f2390 = i5;
        }
        return r11;
    }

    /* renamed from: ֏ */
    public void mo8611() {
        mo8841(mo8838(new int[0]));
    }

    /* renamed from: ֏ */
    public final void mo8839(int i) {
        mo8841(mo8838(i, (int) (System.currentTimeMillis() - this.f2381.mo8196())));
        QueuedWork.m119a(new CacheImpl(this), (long) i);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|(4:12|(1:14)(1:15)|16|18)(1:11)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b A[Catch:{ Exception -> 0x0082 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c A[Catch:{ Exception -> 0x0082 }] */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8841(com.wpengapp.support.UMEntry r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0082
            android.content.Context r0 = f2378     // Catch:{ Exception -> 0x0082 }
            com.wpengapp.support.Ę r0 = com.wpengapp.support.IdTracker.m984((android.content.Context) r0)     // Catch:{ Exception -> 0x0082 }
            r0.mo7934()     // Catch:{ Exception -> 0x0082 }
            com.wpengapp.support.น r1 = r0.f777     // Catch:{ Exception -> 0x0033 }
            com.wpengapp.support.ຜ$֏ r2 = new com.wpengapp.support.ຜ$֏     // Catch:{ Exception -> 0x0033 }
            r2.<init>()     // Catch:{ Exception -> 0x0033 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0033 }
            r3.<init>()     // Catch:{ Exception -> 0x0033 }
            com.wpengapp.support.Ԑ r4 = new com.wpengapp.support.Ԑ     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0033 }
            com.wpengapp.support.ӱ r2 = r2.mo9274(r4)     // Catch:{ Exception -> 0x0033 }
            r3.reset()     // Catch:{ Exception -> 0x0033 }
            r1.mo9122(r2)     // Catch:{ Exception -> 0x0033 }
            byte[] r1 = r3.toByteArray()     // Catch:{ Exception -> 0x0033 }
            com.wpengapp.support.ȴ$ފ r2 = r6.f1102     // Catch:{ Exception -> 0x0033 }
            r3 = 0
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)     // Catch:{ Exception -> 0x0033 }
            r2.f1186 = r1     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            android.content.Context r1 = f2378     // Catch:{ Exception -> 0x0082 }
            com.umeng.analytics.h r1 = com.umeng.analytics.StoreHelper.m156a((android.content.Context) r1)     // Catch:{ Exception -> 0x0082 }
            r5.mo8842((com.wpengapp.support.UMEntry) r6)     // Catch:{ Exception -> 0x0082 }
            byte[] r6 = r1.mo7344b((com.wpengapp.support.UMEntry) r6)     // Catch:{ Exception -> 0x0082 }
            if (r6 != 0) goto L_0x0043
            return
        L_0x0043:
            android.content.Context r1 = f2378     // Catch:{ Exception -> 0x0082 }
            boolean r1 = com.umeng.analytics.DataHelper.m60a((android.content.Context) r1, (byte[]) r6)     // Catch:{ Exception -> 0x0082 }
            if (r1 == 0) goto L_0x004c
            return
        L_0x004c:
            boolean r1 = r5.mo8844()     // Catch:{ Exception -> 0x0082 }
            if (r1 == 0) goto L_0x005f
            android.content.Context r1 = f2378     // Catch:{ Exception -> 0x0082 }
            android.content.Context r2 = f2378     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getAppkey(r2)     // Catch:{ Exception -> 0x0082 }
            com.wpengapp.support.ଡ଼ r6 = com.wpengapp.support.Envelope.m3064(r1, r2, r6)     // Catch:{ Exception -> 0x0082 }
            goto L_0x006b
        L_0x005f:
            android.content.Context r1 = f2378     // Catch:{ Exception -> 0x0082 }
            android.content.Context r2 = f2378     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.getAppkey(r2)     // Catch:{ Exception -> 0x0082 }
            com.wpengapp.support.ଡ଼ r6 = com.wpengapp.support.Envelope.m3062(r1, r2, r6)     // Catch:{ Exception -> 0x0082 }
        L_0x006b:
            byte[] r6 = r6.mo9340()     // Catch:{ Exception -> 0x0082 }
            android.content.Context r1 = f2378     // Catch:{ Exception -> 0x0082 }
            com.umeng.analytics.h r1 = com.umeng.analytics.StoreHelper.m156a((android.content.Context) r1)     // Catch:{ Exception -> 0x0082 }
            r1.mo7351h()     // Catch:{ Exception -> 0x0082 }
            r1.mo7340a((byte[]) r6)     // Catch:{ Exception -> 0x0082 }
            r0.mo7937()     // Catch:{ Exception -> 0x0082 }
            r0 = 0
            com.wpengapp.support.UMEntry.f1101 = r0     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.C0878.mo8841(com.wpengapp.support.ȴ):void");
    }

    /* renamed from: ֏ */
    public UMEntry mo8838(int... iArr) {
        try {
            if (TextUtils.isEmpty(AnalyticsConfig.getAppkey(f2378))) {
                MLog.m1776("Appkey is missing ,Please check AndroidManifest.xml");
                return null;
            }
            UMEntry g = StoreHelper.m156a(f2378).mo7350g();
            if (g == null && this.f2379.mo8556() == 0) {
                return null;
            }
            if (g == null) {
                g = new UMEntry();
            }
            this.f2379.mo8557(g);
            if (g.f1103.f1138 != null && MLog.f1804 && g.f1103.f1138.size() > 0) {
                boolean z = false;
                for (UMEntry.C0561 r6 : g.f1103.f1138) {
                    if (r6.f1191.size() > 0) {
                        z = true;
                    }
                }
                if (!z) {
                    MLog.m1773("missing Activities or PageViews");
                }
            }
            this.f2382.mo8090(g, f2378);
            if (iArr != null && iArr.length == 2) {
                g.f1103.f1140.f1117 = Integer.valueOf(iArr[0] / 1000);
                g.f1103.f1140.f1118 = (long) iArr[1];
                g.f1103.f1140.f1119 = true;
            }
            return g;
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Fail to construct message ...", e);
            StoreHelper.m156a(f2378).mo7351h();
            MLog.m1772((Throwable) e);
            return null;
        }
    }

    /* renamed from: ֏ */
    public final void mo8840(int i, int i2, UMEntry r5) {
        if (i > 0) {
            List<UMEntry.C0554> list = r5.f1103.f1137;
            if (list.size() >= i) {
                int size = list.size() - i;
                for (int size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
            } else {
                list.size();
                list.clear();
            }
        }
        if (i2 > 0) {
            List<UMEntry.C0554> list2 = r5.f1103.f1136;
            if (list2.size() >= i2) {
                int size3 = list2.size() - i2;
                for (int size4 = list2.size() - 1; size4 >= size3; size4--) {
                    list2.remove(size4);
                }
                return;
            }
            list2.size();
            list2.clear();
        }
    }

    /* renamed from: ֏ */
    public void mo8091(ImprintHandler.C0654 r2) {
        this.f2383.mo8091(r2);
        this.f2382.mo8091(r2);
        this.f2384.mo8091(r2);
        this.f2385.mo8846(r2);
    }
}
