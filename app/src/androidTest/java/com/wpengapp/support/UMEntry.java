package com.wpengapp.support;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.wpengapp.support.ȴ */
public class UMEntry implements Serializable {

    /* renamed from: ֏ */
    public static long f1101;

    /* renamed from: ؠ */
    public C0560 f1102 = new C0560();

    /* renamed from: ހ */
    public C0559 f1103 = new C0559();

    /* renamed from: com.wpengapp.support.ȴ$֏ */
    /* compiled from: UMEntry */
    public static class C0548 implements Serializable {

        /* renamed from: ֏ */
        public long f1104 = 0;
    }

    /* renamed from: com.wpengapp.support.ȴ$ؠ */
    /* compiled from: UMEntry */
    public static class C0549 implements Serializable {

        /* renamed from: ֏ */
        public String f1105 = null;

        /* renamed from: ؠ */
        public String f1106 = null;
    }

    /* renamed from: com.wpengapp.support.ȴ$ހ */
    /* compiled from: UMEntry */
    public static class C0550 implements Serializable {

        /* renamed from: ֏ */
        public Map<String, List<C0551>> f1107 = new HashMap();

        /* renamed from: ؠ */
        public Map<String, List<C0552>> f1108 = new HashMap();
    }

    /* renamed from: com.wpengapp.support.ȴ$ށ */
    /* compiled from: UMEntry */
    public static class C0551 implements Serializable {

        /* renamed from: ֏ */
        public long f1109 = 0;

        /* renamed from: ؠ */
        public long f1110 = 0;

        /* renamed from: ހ */
        public int f1111 = 0;

        /* renamed from: ށ */
        public int f1112 = 0;

        /* renamed from: ނ */
        public List<String> f1113 = new ArrayList();
    }

    /* renamed from: com.wpengapp.support.ȴ$ނ */
    /* compiled from: UMEntry */
    public static final class C0552 implements Serializable {

        /* renamed from: ֏ */
        public int f1114 = 0;

        /* renamed from: ؠ */
        public long f1115 = 0;

        /* renamed from: ހ */
        public String f1116 = null;
    }

    /* renamed from: com.wpengapp.support.ȴ$ރ */
    /* compiled from: UMEntry */
    public static class C0553 implements Serializable {

        /* renamed from: ֏ */
        public Integer f1117 = 0;

        /* renamed from: ؠ */
        public long f1118 = 0;

        /* renamed from: ހ */
        public boolean f1119 = false;
    }

    /* renamed from: com.wpengapp.support.ȴ$ބ */
    /* compiled from: UMEntry */
    public static class C0554 implements Serializable {

        /* renamed from: ֏ */
        public String f1120 = null;

        /* renamed from: ؠ */
        public List<C0556> f1121 = new ArrayList();
    }

    /* renamed from: com.wpengapp.support.ȴ$ޅ */
    /* compiled from: UMEntry */
    public static class C0555 implements Serializable, IProtocol {

        /* renamed from: ֏ */
        public long f1122 = 0;

        /* renamed from: ؠ */
        public long f1123 = 0;

        /* renamed from: ހ */
        public String f1124 = null;

        /* renamed from: ֏ */
        public void mo8167(UMEntry r1) {
            List<C0555> list = r1.f1103.f1144;
            if (list != null) {
                list.add(this);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ȴ$ކ */
    /* compiled from: UMEntry */
    public static class C0556 implements Serializable, IProtocol {

        /* renamed from: ֏ */
        public int f1125 = 0;

        /* renamed from: ؠ */
        public String f1126 = null;

        /* renamed from: ހ */
        public String f1127 = null;

        /* renamed from: ށ */
        public long f1128 = 0;

        /* renamed from: ނ */
        public long f1129 = 0;

        /* renamed from: ރ */
        public Map<String, Object> f1130 = new HashMap();

        /* renamed from: ֏ */
        public void mo8167(UMEntry r7) {
            if (this.f1126 == null) {
                try {
                    if (SessionTracker.f1889 == null) {
                        SessionTracker.f1889 = Utils.m1861(SessionTracker.f1890).getString("session_id", (String) null);
                    }
                } catch (Exception unused) {
                }
                this.f1126 = SessionTracker.f1889;
            }
            List<C0554> list = r7.f1103.f1136;
            int i = 0;
            if (list != null) {
                try {
                    if (this.f1125 == 1) {
                        int size = list.size();
                        if (size > 0) {
                            int i2 = 0;
                            while (i2 < size) {
                                C0554 r3 = r7.f1103.f1136.get(i2);
                                if (TextUtils.isEmpty(r3.f1120) || !r3.f1120.equals(this.f1126)) {
                                    i2++;
                                } else {
                                    r7.f1103.f1136.remove(r3);
                                    r3.f1121.add(this);
                                    r7.f1103.f1136.add(r3);
                                    return;
                                }
                            }
                            C0554 r0 = new C0554();
                            r0.f1120 = this.f1126;
                            r0.f1121.add(this);
                            if (!r7.f1103.f1136.contains(r0)) {
                                r7.f1103.f1136.add(r0);
                            }
                        } else {
                            C0554 r02 = new C0554();
                            r02.f1120 = this.f1126;
                            r02.f1121.add(this);
                            r7.f1103.f1136.add(r02);
                        }
                    }
                } catch (Throwable th) {
                    MLog.m1772(th);
                }
            }
            List<C0554> list2 = r7.f1103.f1137;
            if (list2 != null) {
                try {
                    if (this.f1125 == 2) {
                        int size2 = list2.size();
                        if (size2 > 0) {
                            while (i < size2) {
                                C0554 r2 = r7.f1103.f1137.get(i);
                                if (TextUtils.isEmpty(r2.f1120) || !r2.f1120.equals(this.f1126)) {
                                    i++;
                                } else {
                                    r7.f1103.f1137.remove(r2);
                                    r2.f1121.add(this);
                                    r7.f1103.f1137.add(r2);
                                    return;
                                }
                            }
                            C0554 r03 = new C0554();
                            r03.f1120 = this.f1126;
                            r03.f1121.add(this);
                            r7.f1103.f1137.add(r03);
                            return;
                        }
                        C0554 r04 = new C0554();
                        r04.f1120 = this.f1126;
                        r04.f1121.add(this);
                        r7.f1103.f1137.add(r04);
                    }
                } catch (Throwable th2) {
                    MLog.m1772(th2);
                }
            }
        }
    }

    /* renamed from: com.wpengapp.support.ȴ$އ */
    /* compiled from: UMEntry */
    public static final class C0557 implements Serializable {

        /* renamed from: ֏ */
        public double f1131 = 0.0d;

        /* renamed from: ؠ */
        public double f1132 = 0.0d;

        /* renamed from: ހ */
        public long f1133 = 0;
    }

    /* renamed from: com.wpengapp.support.ȴ$ވ */
    /* compiled from: UMEntry */
    public static final class C0558 implements Serializable {

        /* renamed from: ֏ */
        public String f1134 = null;

        /* renamed from: ؠ */
        public long f1135 = 0;
    }

    /* renamed from: com.wpengapp.support.ȴ$މ */
    /* compiled from: UMEntry */
    public static class C0559 implements Serializable {

        /* renamed from: ֏ */
        public List<C0554> f1136 = new ArrayList();

        /* renamed from: ؠ */
        public List<C0554> f1137 = new ArrayList();

        /* renamed from: ހ */
        public List<C0561> f1138 = new ArrayList();

        /* renamed from: ށ */
        public C0548 f1139 = new C0548();

        /* renamed from: ނ */
        public C0553 f1140 = new C0553();

        /* renamed from: ރ */
        public Map<String, Integer> f1141 = new HashMap();

        /* renamed from: ބ */
        public C0549 f1142 = new C0549();

        /* renamed from: ޅ */
        public C0550 f1143 = new C0550();

        /* renamed from: ކ */
        public List<C0555> f1144 = new ArrayList();

        /* renamed from: އ */
        public String f1145 = null;
    }

    /* renamed from: com.wpengapp.support.ȴ$ފ */
    /* compiled from: UMEntry */
    public static class C0560 implements Serializable {

        /* renamed from: ֏ */
        public String f1146 = null;

        /* renamed from: ؠ */
        public String f1147 = null;

        /* renamed from: ހ */
        public String f1148 = null;

        /* renamed from: ށ */
        public String f1149 = null;

        /* renamed from: ނ */
        public String f1150 = null;

        /* renamed from: ރ */
        public String f1151 = null;

        /* renamed from: ބ */
        public String f1152 = null;

        /* renamed from: ޅ */
        public int f1153 = 0;

        /* renamed from: ކ */
        public String f1154 = AnalyticsConfig.mWrapperType;

        /* renamed from: އ */
        public String f1155 = AnalyticsConfig.mWrapperVersion;

        /* renamed from: ވ */
        public String f1156 = "Android";

        /* renamed from: މ */
        public String f1157 = null;

        /* renamed from: ފ */
        public int f1158 = 0;

        /* renamed from: ދ */
        public String f1159 = null;

        /* renamed from: ތ */
        public String f1160 = DeviceConfig.m2308();

        /* renamed from: ލ */
        public String f1161 = "Android";

        /* renamed from: ގ */
        public String f1162 = Build.VERSION.RELEASE;

        /* renamed from: ޏ */
        public String f1163 = null;

        /* renamed from: ސ */
        public String f1164 = null;

        /* renamed from: ޑ */
        public String f1165 = null;

        /* renamed from: ޒ */
        public String f1166 = Build.MODEL;

        /* renamed from: ޓ */
        public String f1167 = Build.BOARD;

        /* renamed from: ޔ */
        public String f1168 = Build.BRAND;

        /* renamed from: ޕ */
        public long f1169 = Build.TIME;

        /* renamed from: ޖ */
        public String f1170 = Build.MANUFACTURER;

        /* renamed from: ޗ */
        public String f1171 = Build.ID;

        /* renamed from: ޘ */
        public String f1172 = Build.DEVICE;

        /* renamed from: ޙ */
        public String f1173 = null;

        /* renamed from: ޚ */
        public String f1174 = null;

        /* renamed from: ޛ */
        public long f1175 = 8;

        /* renamed from: ޜ */
        public String f1176 = null;

        /* renamed from: ޝ */
        public String f1177 = null;

        /* renamed from: ޞ */
        public String f1178 = null;

        /* renamed from: ޟ */
        public String f1179 = null;

        /* renamed from: ޠ */
        public String f1180 = null;

        /* renamed from: ޡ */
        public String f1181 = null;

        /* renamed from: ޢ */
        public long f1182 = 0;

        /* renamed from: ޣ */
        public long f1183 = 0;

        /* renamed from: ޤ */
        public long f1184 = 0;

        /* renamed from: ޥ */
        public String f1185 = null;

        /* renamed from: ޱ */
        public String f1186 = null;
    }

    /* renamed from: com.wpengapp.support.ȴ$ދ */
    /* compiled from: UMEntry */
    public static class C0561 implements Serializable, IProtocol {

        /* renamed from: ֏ */
        public String f1187 = null;

        /* renamed from: ؠ */
        public long f1188 = 0;

        /* renamed from: ހ */
        public long f1189 = 0;

        /* renamed from: ށ */
        public long f1190 = 0;

        /* renamed from: ނ */
        public List<C0558> f1191 = new ArrayList();

        /* renamed from: ރ */
        public C0562 f1192 = new C0562();

        /* renamed from: ބ */
        public C0557 f1193 = new C0557();

        static {
            new HashMap();
        }

        /* renamed from: ֏ */
        public void mo8167(UMEntry r1) {
            List<C0561> list = r1.f1103.f1138;
            if (list != null) {
                list.add(this);
            }
        }
    }

    /* renamed from: com.wpengapp.support.ȴ$ތ */
    /* compiled from: UMEntry */
    public static final class C0562 implements Serializable {

        /* renamed from: ֏ */
        public long f1194 = 0;

        /* renamed from: ؠ */
        public long f1195 = 0;
    }
}
