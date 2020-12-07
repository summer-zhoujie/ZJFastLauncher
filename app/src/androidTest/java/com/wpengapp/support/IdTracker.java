package com.wpengapp.support;

import android.content.Context;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.wpengapp.support.Ę */
public class IdTracker {

    /* renamed from: ֏ */
    public static IdTracker f775;

    /* renamed from: ؠ */
    public File f776;

    /* renamed from: ހ */
    public C1187 f777 = null;

    /* renamed from: ށ */
    public long f778;

    /* renamed from: ނ */
    public long f779;

    /* renamed from: ރ */
    public Set<AbstractIdTracker> f780 = new HashSet();

    /* renamed from: ބ */
    public C0463 f781 = null;

    /* renamed from: com.wpengapp.support.Ę$֏ */
    /* compiled from: IdTracker */
    public static class C0463 {

        /* renamed from: ֏ */
        public Context f782;

        /* renamed from: ؠ */
        public Set<String> f783 = new HashSet();

        public C0463(Context context) {
            this.f782 = context;
        }
    }

    public IdTracker(Context context) {
        String[] split;
        this.f776 = new File(context.getFilesDir(), "umeng_it.cache");
        this.f779 = AnalyticsConstants.f107j;
        this.f781 = new C0463(context);
        C0463 r6 = this.f781;
        String string = Utils.m1861(r6.f782).getString("invld_id", (String) null);
        if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    r6.f783.add(str);
                }
            }
        }
    }

    /* renamed from: ֏ */
    public static synchronized IdTracker m984(Context context) {
        IdTracker r3;
        synchronized (IdTracker.class) {
            if (f775 == null) {
                f775 = new IdTracker(context);
                f775.mo7936((AbstractIdTracker) new ImeiTracker(context));
                f775.mo7936((AbstractIdTracker) new AndroidIdTracker(context));
                f775.mo7936((AbstractIdTracker) new UTDIdTracker(context));
                f775.mo7936((AbstractIdTracker) new UMIdTracker(context));
                f775.mo7936((AbstractIdTracker) new IDFATracker(context));
                f775.mo7936((AbstractIdTracker) new MacTracker(context));
                f775.mo7936((AbstractIdTracker) new SerialTracker());
                f775.mo7936((AbstractIdTracker) new UUIDTracker(context));
                f775.mo7938();
            }
            r3 = f775;
        }
        return r3;
    }

    /* renamed from: ؠ */
    public void mo7937() {
        List<IdJournal> list;
        boolean z = false;
        for (AbstractIdTracker next : this.f780) {
            if (next.mo8027() && (list = next.f886) != null && !list.isEmpty()) {
                next.f886 = null;
                z = true;
            }
        }
        if (z) {
            this.f777.mo9424(false);
            C1187 r0 = this.f777;
            if (r0 != null) {
                mo7935(r0);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.wpengapp.support.น} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* renamed from: ހ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7938() {
        /*
            r6 = this;
            java.io.File r0 = r6.f776
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            goto L_0x0034
        L_0x000a:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            java.io.File r2 = r6.f776     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            byte[] r2 = com.wpengapp.support.HelperUtils.m2473((java.io.InputStream) r0)     // Catch:{ Exception -> 0x0027 }
            com.wpengapp.support.น r3 = new com.wpengapp.support.น     // Catch:{ Exception -> 0x0027 }
            r3.<init>()     // Catch:{ Exception -> 0x0027 }
            com.wpengapp.support.କ r4 = new com.wpengapp.support.କ     // Catch:{ Exception -> 0x0027 }
            r4.<init>()     // Catch:{ Exception -> 0x0027 }
            r4.mo9309(r3, r2)     // Catch:{ Exception -> 0x0027 }
            com.wpengapp.support.HelperUtils.m2474(r0)
            r1 = r3
            goto L_0x0034
        L_0x0027:
            r2 = move-exception
            goto L_0x002e
        L_0x0029:
            r0 = move-exception
            goto L_0x0088
        L_0x002b:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x002e:
            r2.printStackTrace()     // Catch:{ all -> 0x0084 }
            com.wpengapp.support.HelperUtils.m2474(r0)
        L_0x0034:
            if (r1 != 0) goto L_0x0037
            return
        L_0x0037:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.Set<com.wpengapp.support.Ű> r2 = r6.f780
            int r2 = r2.size()
            r0.<init>(r2)
            monitor-enter(r6)
            r6.f777 = r1     // Catch:{ all -> 0x0081 }
            java.util.Set<com.wpengapp.support.Ű> r1 = r6.f780     // Catch:{ all -> 0x0081 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0081 }
        L_0x004b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0081 }
            com.wpengapp.support.Ű r2 = (com.wpengapp.support.AbstractIdTracker) r2     // Catch:{ all -> 0x0081 }
            com.wpengapp.support.น r3 = r6.f777     // Catch:{ all -> 0x0081 }
            r2.mo8026(r3)     // Catch:{ all -> 0x0081 }
            boolean r3 = r2.mo8027()     // Catch:{ all -> 0x0081 }
            if (r3 != 0) goto L_0x004b
            r0.add(r2)     // Catch:{ all -> 0x0081 }
            goto L_0x004b
        L_0x0066:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0081 }
        L_0x006a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x007c
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0081 }
            com.wpengapp.support.Ű r1 = (com.wpengapp.support.AbstractIdTracker) r1     // Catch:{ all -> 0x0081 }
            java.util.Set<com.wpengapp.support.Ű> r2 = r6.f780     // Catch:{ all -> 0x0081 }
            r2.remove(r1)     // Catch:{ all -> 0x0081 }
            goto L_0x006a
        L_0x007c:
            monitor-exit(r6)     // Catch:{ all -> 0x0081 }
            r6.mo7939()
            return
        L_0x0081:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0081 }
            throw r0
        L_0x0084:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0088:
            com.wpengapp.support.HelperUtils.m2474(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.IdTracker.mo7938():void");
    }

    /* renamed from: ށ */
    public final void mo7939() {
        C1187 r0 = new C1187();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AbstractIdTracker next : this.f780) {
            if (next.mo8027()) {
                C1088 r5 = next.f887;
                if (r5 != null) {
                    hashMap.put(next.f885, r5);
                }
                List<IdJournal> list = next.f886;
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(next.f886);
                }
            }
        }
        r0.f3386 = arrayList;
        r0.f3385 = hashMap;
        synchronized (this) {
            this.f777 = r0;
        }
    }

    /* renamed from: ֏ */
    public boolean mo7936(AbstractIdTracker r3) {
        C0463 r0 = this.f781;
        if (!r0.f783.contains(r3.f885)) {
            return this.f780.add(r3);
        }
        return false;
    }

    /* renamed from: ֏ */
    public void mo7934() {
        String str;
        int i;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f778 >= this.f779) {
            boolean z2 = false;
            for (AbstractIdTracker next : this.f780) {
                if (next.mo8027()) {
                    C1088 r7 = next.f887;
                    String str2 = null;
                    if (r7 == null) {
                        str = null;
                    } else {
                        str = r7.f3091;
                    }
                    if (r7 == null) {
                        i = 0;
                    } else {
                        i = r7.f3093;
                    }
                    String r11 = next.mo8028();
                    if (r11 != null) {
                        String trim = r11.trim();
                        if (trim.length() != 0 && !"0".equals(trim) && !EnvironmentCompat.MEDIA_UNKNOWN.equals(trim.toLowerCase(Locale.US))) {
                            str2 = trim;
                        }
                    }
                    if (str2 == null || str2.equals(str)) {
                        z = false;
                    } else {
                        if (r7 == null) {
                            r7 = new C1088();
                        }
                        r7.f3091 = str2;
                        r7.f3092 = System.currentTimeMillis();
                        r7.mo9269(true);
                        r7.f3093 = i + 1;
                        r7.mo9270(true);
                        IdJournal r10 = new IdJournal();
                        r10.f3072 = next.f885;
                        r10.f3074 = str2;
                        r10.f3073 = str;
                        r10.f3075 = r7.f3092;
                        r10.mo9260(true);
                        if (next.f886 == null) {
                            next.f886 = new ArrayList(2);
                        }
                        next.f886.add(r10);
                        if (next.f886.size() > 10) {
                            next.f886.remove(0);
                        }
                        next.f887 = r7;
                        z = true;
                    }
                    if (z) {
                        if (!next.mo8027()) {
                            this.f781.f783.add(next.f885);
                        }
                        z2 = true;
                    }
                }
            }
            if (z2) {
                mo7939();
                C0463 r2 = this.f781;
                if (!r2.f783.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (String append : r2.f783) {
                        sb.append(append);
                        sb.append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    Utils.m1861(r2.f782).edit().putString("invld_id", sb.toString()).commit();
                }
                C1187 r22 = this.f777;
                if (r22 != null) {
                    mo7935(r22);
                }
            }
            this.f778 = currentTimeMillis;
        }
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 119 */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7935(C1187 r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0031
            monitor-enter(r3)     // Catch:{ Exception -> 0x002d }
            com.wpengapp.support.ຜ$֏ r0 = new com.wpengapp.support.ຜ$֏     // Catch:{ all -> 0x002b }
            r0.<init>()     // Catch:{ all -> 0x002b }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x002b }
            r1.<init>()     // Catch:{ all -> 0x002b }
            com.wpengapp.support.Ԑ r2 = new com.wpengapp.support.Ԑ     // Catch:{ all -> 0x002b }
            r2.<init>(r1)     // Catch:{ all -> 0x002b }
            com.wpengapp.support.ӱ r0 = r0.mo9274(r2)     // Catch:{ all -> 0x002b }
            r1.reset()     // Catch:{ all -> 0x002b }
            r4.mo9122(r0)     // Catch:{ all -> 0x002b }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x002b }
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            if (r4 == 0) goto L_0x0031
            java.io.File r0 = r3.f776     // Catch:{ Exception -> 0x002d }
            com.wpengapp.support.HelperUtils.m2471((java.io.File) r0, (byte[]) r4)     // Catch:{ Exception -> 0x002d }
            goto L_0x0031
        L_0x0029:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r4     // Catch:{ Exception -> 0x002d }
        L_0x002b:
            r4 = move-exception
            goto L_0x0029
        L_0x002d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.IdTracker.mo7935(com.wpengapp.support.น):void");
    }
}
