package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.app.NotificationCompatJellybean;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.umeng.analytics.social.UMSocialConstants;
import com.wpengapp.support.C1315;
import com.wpengapp.support.DeviceConfig;
import com.wpengapp.support.HelperUtils;
import com.wpengapp.support.MLog;
import com.wpengapp.support.UMEntry;
import com.wpengapp.support.Utils;
import com.wpengapp.support.outline;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.h */
public final class StoreHelper {

    /* renamed from: a */
    public static StoreHelper f200a = null;

    /* renamed from: b */
    public static Context f201b = null;

    /* renamed from: c */
    public static String f202c = null;

    /* renamed from: e */
    public static long f203e = 1209600000;

    /* renamed from: f */
    public static long f204f = 2097152;

    /* renamed from: g */
    public static final String f205g = "mobclick_agent_user_";

    /* renamed from: h */
    public static final String f206h = "mobclick_agent_header_";

    /* renamed from: i */
    public static final String f207i = "mobclick_agent_update_";

    /* renamed from: j */
    public static final String f208j = "mobclick_agent_state_";

    /* renamed from: k */
    public static final String f209k = "mobclick_agent_cached_";

    /* renamed from: d */
    public C0402a f210d;

    /* renamed from: com.umeng.analytics.h$a */
    /* compiled from: StoreHelper */
    public static class C0402a {

        /* renamed from: a */
        public final int f218a;

        /* renamed from: b */
        public File f219b;

        /* renamed from: c */
        public FilenameFilter f220c;

        public C0402a(Context context) {
            this(context, ".um");
        }

        /* renamed from: a */
        public boolean mo7359a() {
            File[] listFiles = this.f219b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        /* renamed from: b */
        public void mo7360b() {
            File[] listFiles = this.f219b.listFiles(this.f220c);
            if (listFiles != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        /* renamed from: c */
        public int mo7361c() {
            File[] listFiles = this.f219b.listFiles(this.f220c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }

        public C0402a(Context context, String str) {
            this.f218a = 10;
            this.f220c = new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith("um");
                }
            };
            this.f219b = new File(context.getFilesDir(), str);
            if (!this.f219b.exists() || !this.f219b.isDirectory()) {
                this.f219b.mkdir();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            r3 = r0[r1];
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo7357a(C0405b r6) {
            /*
                r5 = this;
                java.io.File r0 = r5.f219b
                java.io.FilenameFilter r1 = r5.f220c
                java.io.File[] r0 = r0.listFiles(r1)
                r1 = 0
                if (r0 == 0) goto L_0x0028
                int r2 = r0.length
                r3 = 10
                if (r2 < r3) goto L_0x0028
                java.util.Arrays.sort(r0)
                int r2 = r0.length
                int r2 = r2 - r3
                com.umeng.analytics.h$a$1 r3 = new com.umeng.analytics.h$a$1
                r3.<init>(r2)
                com.umeng.analytics.QueuedWork.m120b(r3)
                r3 = 0
            L_0x001e:
                if (r3 >= r2) goto L_0x0028
                r4 = r0[r3]
                r4.delete()
                int r3 = r3 + 1
                goto L_0x001e
            L_0x0028:
                if (r0 == 0) goto L_0x004f
                int r2 = r0.length
                if (r2 <= 0) goto L_0x004f
                java.io.File r2 = r5.f219b
                r6.mo7364a(r2)
                int r2 = r0.length
            L_0x0033:
                if (r1 >= r2) goto L_0x004a
                r3 = r0[r1]     // Catch:{ Throwable -> 0x0042, all -> 0x0040 }
                boolean r3 = r6.mo7365b(r3)     // Catch:{ Throwable -> 0x0042, all -> 0x0040 }
                if (r3 == 0) goto L_0x0047
                r3 = r0[r1]
                goto L_0x0044
            L_0x0040:
                r6 = move-exception
                throw r6
            L_0x0042:
                r3 = r0[r1]
            L_0x0044:
                r3.delete()
            L_0x0047:
                int r1 = r1 + 1
                goto L_0x0033
            L_0x004a:
                java.io.File r0 = r5.f219b
                r6.mo7366c(r0)
            L_0x004f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.StoreHelper.C0402a.mo7357a(com.umeng.analytics.h$b):void");
        }

        /* renamed from: a */
        public void mo7358a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    HelperUtils.m2471(new File(this.f219b, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.umeng.analytics.h$b */
    /* compiled from: StoreHelper */
    public interface C0405b {
        /* renamed from: a */
        void mo7364a(File file);

        /* renamed from: b */
        boolean mo7365b(File file);

        /* renamed from: c */
        void mo7366c(File file);
    }

    public StoreHelper(Context context) {
        this.f210d = new C0402a(context, ".um");
    }

    /* renamed from: o */
    private SharedPreferences m163o() {
        Context context = f201b;
        StringBuilder r1 = outline.m2549(f205g);
        r1.append(f202c);
        return context.getSharedPreferences(r1.toString(), 0);
    }

    /* renamed from: p */
    private String m164p() {
        StringBuilder r0 = outline.m2549(f206h);
        r0.append(f202c);
        return r0.toString();
    }

    /* renamed from: q */
    private String m165q() {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            int i = r0.getInt(AnalyticsConstants.f122y, 0);
            int parseInt = Integer.parseInt(DeviceConfig.m2322(f201b));
            if (i == 0 || parseInt == i) {
                StringBuilder r02 = outline.m2549(f209k);
                r02.append(f202c);
                r02.append(DeviceConfig.m2322(f201b));
                return r02.toString();
            }
            StringBuilder r1 = outline.m2549(f209k);
            r1.append(f202c);
            r1.append(i);
            return r1.toString();
        }
        StringBuilder r03 = outline.m2549(f209k);
        r03.append(f202c);
        r03.append(DeviceConfig.m2322(f201b));
        return r03.toString();
    }

    /* renamed from: c */
    public String mo7345c() {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            return r0.getString("appkey", (String) null);
        }
        return null;
    }

    /* renamed from: d */
    public String mo7347d() {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            return r0.getString(UMSocialConstants.f254m, (String) null);
        }
        return null;
    }

    /* renamed from: e */
    public String mo7348e() {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            return r0.getString("st", (String) null);
        }
        return null;
    }

    /* renamed from: f */
    public int mo7349f() {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            return r0.getInt("vt", 0);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0062 A[SYNTHETIC, Splitter:B:40:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006c A[SYNTHETIC, Splitter:B:46:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0078 A[SYNTHETIC, Splitter:B:53:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0082 A[SYNTHETIC, Splitter:B:59:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wpengapp.support.UMEntry mo7350g() {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.m165q()     // Catch:{ Exception -> 0x008b }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x008b }
            android.content.Context r3 = f201b     // Catch:{ Exception -> 0x008b }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x008b }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ Exception -> 0x008b }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x008b }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x008b }
            boolean r1 = m159a((java.io.File) r2)     // Catch:{ Exception -> 0x008b }
            if (r1 == 0) goto L_0x0022
            r2.delete()     // Catch:{ Exception -> 0x008b }
            return r0
        L_0x0022:
            boolean r1 = r2.exists()     // Catch:{ Exception -> 0x008b }
            if (r1 != 0) goto L_0x0029
            return r0
        L_0x0029:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.Object r3 = r2.readObject()     // Catch:{ Exception -> 0x004e }
            com.wpengapp.support.ȴ r3 = (com.wpengapp.support.UMEntry) r3     // Catch:{ Exception -> 0x004e }
            r2.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x003d:
            r1 = move-exception
            r0 = r3
            goto L_0x008c
        L_0x0040:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x003d }
        L_0x0044:
            r1.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x003d }
        L_0x004c:
            r0 = r3
            goto L_0x0093
        L_0x004e:
            r3 = move-exception
            goto L_0x005d
        L_0x0050:
            r3 = move-exception
            r2 = r0
            goto L_0x0076
        L_0x0053:
            r3 = move-exception
            r2 = r0
            goto L_0x005d
        L_0x0056:
            r3 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0076
        L_0x005a:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x005d:
            r3.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x008b }
        L_0x006a:
            if (r1 == 0) goto L_0x0093
            r1.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0093
        L_0x0070:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x008b }
            goto L_0x0093
        L_0x0075:
            r3 = move-exception
        L_0x0076:
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x008b }
        L_0x0080:
            if (r1 == 0) goto L_0x008a
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x008b }
        L_0x008a:
            throw r3     // Catch:{ Exception -> 0x008b }
        L_0x008b:
            r1 = move-exception
        L_0x008c:
            boolean r2 = com.wpengapp.support.MLog.f1804
            if (r2 == 0) goto L_0x0093
            com.wpengapp.support.MLog.m1772((java.lang.Throwable) r1)
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.StoreHelper.mo7350g():com.wpengapp.support.ȴ");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0042  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7351h() {
        /*
            r9 = this;
            android.content.Context r0 = f201b
            java.lang.String r1 = r9.m164p()
            r0.deleteFile(r1)
            android.content.Context r0 = f201b
            java.lang.String r1 = r9.m165q()
            r0.deleteFile(r1)
            android.content.Context r0 = f201b
            com.wpengapp.support.C1315.f3758 = r0
            com.wpengapp.support.Ⴟ r0 = com.wpengapp.support.C1315.C1317.f3769
            com.umeng.analytics.h$1 r1 = new com.umeng.analytics.h$1
            r1.<init>()
            boolean r1 = r0.f3763
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x003f
            long r5 = r0.f3764
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002d
            r0.mo9586()
        L_0x002d:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.f3764
            int r1 = com.wpengapp.support.Utils.m1888((long) r5)
            int r5 = com.wpengapp.support.Utils.m1888((long) r7)
            if (r1 != r5) goto L_0x003f
            r1 = 1
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            if (r1 != 0) goto L_0x0060
            android.content.Context r5 = com.wpengapp.support.C1315.f3758
            android.content.SharedPreferences r5 = com.wpengapp.support.Utils.m1861((android.content.Context) r5)
            android.content.SharedPreferences$Editor r5 = r5.edit()
            java.lang.String r6 = "main_fest_mode"
            r5.putBoolean(r6, r4)
            java.lang.String r6 = "main_fest_timestamp"
            r5.putLong(r6, r2)
            r5.commit()
            r0.f3763 = r4
            java.util.List<java.lang.String> r2 = r0.f3765
            r2.clear()
        L_0x0060:
            com.wpengapp.support.ၕ r2 = r0.f3761
            java.util.Map<java.lang.String, com.wpengapp.support.ಓ> r2 = r2.f3665
            r2.clear()
            com.wpengapp.support.ų r2 = r0.f3760
            com.wpengapp.support.Ŭ r3 = new com.wpengapp.support.Ŭ
            r3.<init>(r0)
            r2.mo8035((com.wpengapp.support.Callback) r3, (boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.StoreHelper.mo7351h():void");
    }

    /* renamed from: i */
    public boolean mo7352i() {
        return this.f210d.mo7359a();
    }

    /* renamed from: j */
    public C0402a mo7353j() {
        return this.f210d;
    }

    /* renamed from: k */
    public SharedPreferences mo7354k() {
        Context context = f201b;
        StringBuilder r1 = outline.m2549(f206h);
        r1.append(f202c);
        return context.getSharedPreferences(r1.toString(), 0);
    }

    /* renamed from: l */
    public SharedPreferences mo7355l() {
        Context context = f201b;
        StringBuilder r1 = outline.m2549(f207i);
        r1.append(f202c);
        return context.getSharedPreferences(r1.toString(), 0);
    }

    /* renamed from: m */
    public SharedPreferences mo7356m() {
        Context context = f201b;
        StringBuilder r1 = outline.m2549(f208j);
        r1.append(f202c);
        return context.getSharedPreferences(r1.toString(), 0);
    }

    /* renamed from: a */
    public static synchronized StoreHelper m156a(Context context) {
        StoreHelper hVar;
        synchronized (StoreHelper.class) {
            f201b = context.getApplicationContext();
            f202c = context.getPackageName();
            if (f200a == null) {
                f200a = new StoreHelper(context);
            }
            hVar = f200a;
        }
        return hVar;
    }

    /* renamed from: b */
    public void mo7342b() {
        m163o().edit().remove("au_p").remove("au_u").commit();
    }

    /* renamed from: c */
    public void mo7346c(String str) {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            r0.edit().putString("st", str).commit();
        }
    }

    /* renamed from: b */
    public void mo7343b(String str) {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            r0.edit().putString(UMSocialConstants.f254m, str).commit();
        }
    }

    /* renamed from: b */
    public byte[] mo7344b(final UMEntry r5) {
        try {
            JSONObject jSONObject = new JSONObject();
            final StringBuilder sb = new StringBuilder();
            jSONObject.put(AnalyticsConstants.f121x, new JSONObject() {
                {
                    StoreHelper.this.m158a(r5, this, sb);
                }
            });
            C04013 r2 = new JSONObject() {
                {
                    StoreHelper.this.m161b(r5, this, sb);
                }
            };
            if (r2.length() > 0) {
                jSONObject.put(AnalyticsConstants.f120w, r2);
            }
            "serialize entry:" + String.valueOf(sb);
            String str = MLog.f1805;
            boolean z = MLog.f1804;
            return String.valueOf(jSONObject).getBytes();
        } catch (Exception e) {
            MLog.m1777(MLog.f1805, "Fail to serialize log ...", e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m159a(File file) {
        long length = file.length();
        if (!file.exists() || length <= f204f) {
            return false;
        }
        C1315.f3758 = f201b;
        C1315.C1317.f3769.mo9583(length, System.currentTimeMillis(), AnalyticsConstants.f116s);
        return true;
    }

    /* renamed from: a */
    public void mo7339a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = m163o().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m161b(UMEntry r17, JSONObject jSONObject, StringBuilder sb) {
        Map<String, List<UMEntry.C0552>> map;
        Map<String, List<UMEntry.C0551>> map2;
        UMEntry r0 = r17;
        JSONObject jSONObject2 = jSONObject;
        StringBuilder sb2 = sb;
        JSONObject jSONObject3 = new JSONObject();
        UMEntry.C0550 r4 = r0.f1103.f1143;
        if (!(r4 == null || (map2 = r4.f1107) == null || map2.size() <= 0)) {
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry next : r0.f1103.f1143.f1107.entrySet()) {
                String str = (String) next.getKey();
                List list = (List) next.getValue();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    UMEntry.C0551 r11 = (UMEntry.C0551) list.get(i);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("v_sum", r11.f1109);
                    jSONObject5.put("ts_sum", r11.f1110);
                    jSONObject5.put("tw_num", r11.f1111);
                    jSONObject5.put("count", r11.f1112);
                    jSONObject5.put("labels", new JSONArray(r11.f1113));
                    jSONArray.put(jSONObject5);
                }
                jSONObject4.put(str, jSONArray);
            }
            jSONObject3.put("ag", jSONObject4);
        }
        UMEntry.C0550 r42 = r0.f1103.f1143;
        if (!(r42 == null || (map = r42.f1108) == null || map.size() <= 0)) {
            JSONObject jSONObject6 = new JSONObject();
            for (Map.Entry next2 : r0.f1103.f1143.f1108.entrySet()) {
                String str2 = (String) next2.getKey();
                List list2 = (List) next2.getValue();
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    UMEntry.C0552 r12 = (UMEntry.C0552) list2.get(i2);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("value", r12.f1114);
                    jSONObject7.put("ts", r12.f1115);
                    jSONObject7.put(NotificationCompatJellybean.KEY_LABEL, r12.f1116);
                    jSONArray2.put(jSONObject7);
                }
                jSONObject6.put(str2, jSONArray2);
            }
            jSONObject3.put("ve_meta", jSONObject6);
        }
        if (jSONObject3.length() > 0) {
            jSONObject2.put("cc", jSONObject3);
            sb2.append("; cc: ");
            sb2.append(jSONObject3.toString());
        }
        List<UMEntry.C0554> list3 = r0.f1103.f1136;
        if (list3 != null && list3.size() > 0) {
            JSONArray jSONArray3 = new JSONArray();
            for (int i3 = 0; i3 < r0.f1103.f1136.size(); i3++) {
                UMEntry.C0554 r9 = r0.f1103.f1136.get(i3);
                JSONArray jSONArray4 = new JSONArray();
                for (int i4 = 0; i4 < r9.f1121.size(); i4++) {
                    JSONObject jSONObject8 = new JSONObject();
                    UMEntry.C0556 r13 = r9.f1121.get(i4);
                    jSONObject8.put("id", r13.f1127);
                    jSONObject8.put("ts", r13.f1128);
                    jSONObject8.put("du", r13.f1129);
                    for (Map.Entry next3 : r13.f1130.entrySet()) {
                        Object value = next3.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject8.put((String) next3.getKey(), next3.getValue());
                        }
                    }
                    jSONArray4.put(jSONObject8);
                }
                if (r9.f1120 != null && jSONArray4.length() > 0) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(r9.f1120, jSONArray4);
                    jSONArray3.put(jSONObject9);
                }
            }
            if (jSONArray3.length() > 0) {
                jSONObject2.put("ekv", jSONArray3);
                sb2.append(";ekv:");
                sb2.append(jSONArray3.toString());
            }
        }
        List<UMEntry.C0554> list4 = r0.f1103.f1137;
        if (list4 != null && list4.size() > 0) {
            JSONArray jSONArray5 = new JSONArray();
            for (int i5 = 0; i5 < r0.f1103.f1137.size(); i5++) {
                UMEntry.C0554 r8 = r0.f1103.f1137.get(i5);
                JSONArray jSONArray6 = new JSONArray();
                for (int i6 = 0; i6 < r8.f1121.size(); i6++) {
                    UMEntry.C0556 r112 = r8.f1121.get(i6);
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("id", r112.f1127);
                    jSONObject10.put("ts", r112.f1128);
                    jSONObject10.put("du", r112.f1129);
                    for (Map.Entry next4 : r112.f1130.entrySet()) {
                        Object value2 = next4.getValue();
                        if ((value2 instanceof String) || (value2 instanceof Integer) || (value2 instanceof Long)) {
                            jSONObject10.put((String) next4.getKey(), next4.getValue());
                        }
                    }
                    jSONArray6.put(jSONObject10);
                }
                if (r8.f1120 != null && jSONArray6.length() > 0) {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put(r8.f1120, jSONArray6);
                    jSONArray5.put(jSONObject11);
                }
            }
            if (jSONArray5.length() > 0) {
                jSONObject2.put("gkv", jSONArray5);
                sb2.append("; gkv:");
                sb2.append(jSONArray5.toString());
            }
        }
        List<UMEntry.C0555> list5 = r0.f1103.f1144;
        if (list5 != null && list5.size() > 0) {
            JSONArray jSONArray7 = new JSONArray();
            for (int i7 = 0; i7 < r0.f1103.f1144.size(); i7++) {
                UMEntry.C0555 r5 = r0.f1103.f1144.get(i7);
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("ts", r5.f1122);
                jSONObject12.put("error_source", r5.f1123);
                jSONObject12.put("context", r5.f1124);
                jSONArray7.put(jSONObject12);
            }
            jSONObject2.put("error", jSONArray7);
        }
        List<UMEntry.C0561> list6 = r0.f1103.f1138;
        long j = 0;
        if (list6 != null && list6.size() > 0) {
            JSONArray jSONArray8 = new JSONArray();
            int i8 = 0;
            while (i8 < r0.f1103.f1138.size()) {
                UMEntry.C0561 r92 = r0.f1103.f1138.get(i8);
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", r92.f1187);
                jSONObject13.put("start_time", r92.f1188);
                jSONObject13.put("end_time", r92.f1189);
                jSONObject13.put("duration", r92.f1190);
                UMEntry.C0562 r113 = r92.f1192;
                if (!(r113.f1194 == j && r113.f1195 == j)) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("download_traffic", r92.f1192.f1194);
                    jSONObject14.put("upload_traffic", r92.f1192.f1195);
                    jSONObject13.put("traffic", jSONObject14);
                }
                if (r92.f1191.size() > 0) {
                    JSONArray jSONArray9 = new JSONArray();
                    for (UMEntry.C0558 next5 : r92.f1191) {
                        JSONObject jSONObject15 = new JSONObject();
                        jSONObject15.put("page_name", next5.f1134);
                        jSONObject15.put("duration", next5.f1135);
                        jSONArray9.put(jSONObject15);
                    }
                    jSONObject13.put(NotificationCompat.WearableExtender.KEY_PAGES, jSONArray9);
                }
                if (r92.f1193.f1133 != 0) {
                    JSONArray jSONArray10 = new JSONArray();
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put("lat", r92.f1193.f1131);
                    jSONObject16.put("lng", r92.f1193.f1132);
                    jSONObject16.put("ts", r92.f1193.f1133);
                    jSONArray10.put(jSONObject16);
                    jSONObject13.put("locations", jSONArray10);
                }
                jSONArray8.put(jSONObject13);
                i8++;
                j = 0;
            }
            if (jSONArray8.length() > 0) {
                jSONObject2.put("sessions", jSONArray8);
                sb2.append("; sessions:");
                sb2.append(jSONArray8.toString());
            }
        }
        if (r0.f1103.f1139.f1104 != 0) {
            JSONObject jSONObject17 = new JSONObject();
            jSONObject17.put("ts", r0.f1103.f1139.f1104);
            if (jSONObject17.length() > 0) {
                jSONObject2.put("activate_msg", jSONObject17);
                sb2.append("; active_msg: ");
                sb2.append(jSONObject17.toString());
            }
        }
        if (r0.f1103.f1140.f1119) {
            JSONObject jSONObject18 = new JSONObject();
            JSONObject jSONObject19 = new JSONObject();
            jSONObject19.put("interval", r0.f1103.f1140.f1118);
            jSONObject19.put("latency", r0.f1103.f1140.f1117);
            jSONObject18.put("latent", jSONObject19);
            if (jSONObject18.length() > 0) {
                jSONObject2.put("control_policy", jSONObject18);
                sb2.append("; control_policy: ");
                sb2.append(jSONObject18.toString());
            }
        }
        if (r0.f1103.f1141.size() > 0) {
            JSONObject jSONObject20 = new JSONObject();
            for (Map.Entry next6 : r0.f1103.f1141.entrySet()) {
                jSONObject20.put((String) next6.getKey(), next6.getValue());
            }
            jSONObject2.put("group_info", jSONObject20);
        }
        UMEntry.C0549 r3 = r0.f1103.f1142;
        if (!(r3.f1105 == null && r3.f1106 == null)) {
            JSONObject jSONObject21 = new JSONObject();
            jSONObject21.put("provider", r0.f1103.f1142.f1105);
            jSONObject21.put("puid", r0.f1103.f1142.f1106);
            if (jSONObject21.length() > 0) {
                jSONObject2.put("active_user", jSONObject21);
                sb2.append("; active_user: ");
                sb2.append(jSONObject21.toString());
            }
        }
        String str3 = r0.f1103.f1145;
        if (str3 != null) {
            jSONObject2.put(AnalyticsConstants.f97A, str3);
        }
    }

    /* renamed from: a */
    public String[] mo7341a() {
        SharedPreferences o = m163o();
        String string = o.getString("au_p", (String) null);
        String string2 = o.getString("au_u", (String) null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    /* renamed from: a */
    public void mo7338a(String str) {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            r0.edit().putString("appkey", str).commit();
        }
    }

    /* renamed from: a */
    public void mo7336a(int i) {
        SharedPreferences r0 = Utils.m1861(f201b);
        if (r0 != null) {
            r0.edit().putInt("vt", i).commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[SYNTHETIC, Splitter:B:25:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053 A[SYNTHETIC, Splitter:B:30:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005f A[SYNTHETIC, Splitter:B:36:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0069 A[SYNTHETIC, Splitter:B:41:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7337a(com.wpengapp.support.UMEntry r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.m165q()
            java.io.File r1 = new java.io.File
            android.content.Context r2 = f201b
            android.content.Context r2 = r2.getApplicationContext()
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r2 = r2.getAbsolutePath()
            r1.<init>(r2, r0)
            r0 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x003a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x003a }
            r1.writeObject(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r1.flush()     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r1.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0030:
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0034:
            r4 = move-exception
            r0 = r1
            goto L_0x005d
        L_0x0037:
            r4 = move-exception
            r0 = r1
            goto L_0x0041
        L_0x003a:
            r4 = move-exception
            goto L_0x0041
        L_0x003c:
            r4 = move-exception
            r2 = r0
            goto L_0x005d
        L_0x003f:
            r4 = move-exception
            r2 = r0
        L_0x0041:
            com.wpengapp.support.MLog.m1772((java.lang.Throwable) r4)     // Catch:{ all -> 0x005c }
            r4.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0051:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005b:
            return
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0067:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.StoreHelper.mo7337a(com.wpengapp.support.ȴ):void");
    }

    /* renamed from: a */
    public void mo7340a(byte[] bArr) {
        this.f210d.mo7358a(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m158a(UMEntry r4, JSONObject jSONObject, StringBuilder sb) {
        jSONObject.put("appkey", r4.f1102.f1146);
        jSONObject.put(UMSocialConstants.f254m, r4.f1102.f1147);
        String str = r4.f1102.f1148;
        if (str != null) {
            jSONObject.put("secret", str);
        }
        jSONObject.put("app_version", r4.f1102.f1149);
        jSONObject.put("display_name", r4.f1102.f1152);
        jSONObject.put("package_name", r4.f1102.f1150);
        jSONObject.put("app_signature", r4.f1102.f1151);
        jSONObject.put("version_code", r4.f1102.f1153);
        jSONObject.put("wrapper_type", r4.f1102.f1154);
        jSONObject.put("wrapper_version", r4.f1102.f1155);
        jSONObject.put("sdk_type", r4.f1102.f1156);
        jSONObject.put("sdk_version", r4.f1102.f1157);
        jSONObject.put("vertical_type", r4.f1102.f1158);
        jSONObject.put("idmd5", r4.f1102.f1159);
        jSONObject.put("cpu", r4.f1102.f1160);
        jSONObject.put("os", r4.f1102.f1161);
        jSONObject.put("os_version", r4.f1102.f1162);
        jSONObject.put("resolution", r4.f1102.f1163);
        jSONObject.put("mc", r4.f1102.f1164);
        jSONObject.put("device_id", r4.f1102.f1165);
        jSONObject.put("device_model", r4.f1102.f1166);
        jSONObject.put("device_board", r4.f1102.f1167);
        jSONObject.put("device_brand", r4.f1102.f1168);
        jSONObject.put("device_manutime", r4.f1102.f1169);
        jSONObject.put("device_manufacturer", r4.f1102.f1170);
        jSONObject.put("device_manuid", r4.f1102.f1171);
        jSONObject.put("device_name", r4.f1102.f1172);
        String str2 = r4.f1102.f1173;
        if (str2 != null) {
            jSONObject.put("sub_os_name", str2);
        }
        String str3 = r4.f1102.f1174;
        if (str3 != null) {
            jSONObject.put("sub_os_version", str3);
        }
        jSONObject.put("timezone", r4.f1102.f1175);
        jSONObject.put("language", r4.f1102.f1176);
        jSONObject.put("country", r4.f1102.f1177);
        jSONObject.put("carrier", r4.f1102.f1178);
        jSONObject.put("access", r4.f1102.f1179);
        jSONObject.put("access_subtype", r4.f1102.f1180);
        String str4 = r4.f1102.f1181;
        if (str4 == null) {
            str4 = BidiFormatter.EMPTY_STRING;
        }
        jSONObject.put("mccmnc", str4);
        jSONObject.put("successful_requests", r4.f1102.f1182);
        jSONObject.put("failed_requests", r4.f1102.f1183);
        jSONObject.put("req_time", r4.f1102.f1184);
        jSONObject.put("imprint", r4.f1102.f1185);
        jSONObject.put("id_tracking", r4.f1102.f1186);
        sb.append("sdk_version:");
        sb.append(r4.f1102.f1157);
        sb.append(";device_id:");
        sb.append(r4.f1102.f1165);
        sb.append(";device_manufacturer:");
        sb.append(r4.f1102.f1170);
        sb.append(";device_board:");
        sb.append(r4.f1102.f1167);
        sb.append(";device_brand:");
        sb.append(r4.f1102.f1168);
        sb.append(";os_version:");
        sb.append(r4.f1102.f1162);
    }
}
