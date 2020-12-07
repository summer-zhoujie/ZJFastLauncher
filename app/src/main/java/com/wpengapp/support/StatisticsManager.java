package com.wpengapp.support;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.wpengapp.support.C1063;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class StatisticsManager {

    /* renamed from: ֏ */
    public static final C1323<String> f581;

    /* renamed from: ؠ */
    public static List<EventModel> f582 = new CopyOnWriteArrayList();

    /* renamed from: ހ */
    public static long f583;

    /* renamed from: ށ */
    public static volatile boolean f584;

    /* renamed from: ނ */
    public static String f585;

    /* renamed from: ރ */
    public static long f586;

    /* renamed from: ބ */
    public static long f587;

    /* renamed from: ޅ */
    public static boolean f588;

    /* renamed from: ކ */
    public static Map<String, StatTablePolicy> f589 = new HashMap();

    /* renamed from: އ */
    public static Runnable f590 = new C1055();

    /* renamed from: ވ */
    public static C1063.C1065 f591 = new C1157();

    @Keep
    private static class EventModel {
        public String biz;
        public String eventId;
        public Map<String, String> params;
        public long time;

        public EventModel() {
        }

        public /* synthetic */ EventModel(C1099 r1) {
        }
    }

    @Keep
    private class StatTablePolicy {
        public Boolean intercept;
        public final /* synthetic */ StatisticsManager this$0;

        public StatTablePolicy(StatisticsManager statisticsManager) {
        }
    }

    /* renamed from: com.wpengapp.support.StatisticsManager$֏ */
    private static class C0446 {

        /* renamed from: ֏ */
        public long f592;

        /* renamed from: ؠ */
        public List<EventModel> f593;

        public C0446() {
        }

        public /* synthetic */ C0446(C1099 r1) {
        }
    }

    static {
        StringBuilder r0 = outline.m2549("stat_");
        r0.append(AppUtils.m1166());
        f581 = C1323.m3615(r0.toString(), (Type) null, (String) null, "stsatlais1");
    }

    /* renamed from: ֏ */
    public static /* synthetic */ void m732() {
        if (f588) {
            TaskManager.m2720(new C1290());
        }
    }

    /* renamed from: ؠ */
    public static void m734() {
        String r0 = C1063.m2859("server_stat_table_policy", (String) null);
        if (TextUtils.isEmpty(r0)) {
            f589 = new HashMap();
            return;
        }
        try {
            f589 = (Map) GsonUtil.m2741(r0, new C0754().getType());
        } catch (Exception unused) {
            f589 = new HashMap();
        }
    }

    /* renamed from: ހ */
    public static synchronized void m735() {
        synchronized (StatisticsManager.class) {
            AppUtils.m1152(f590);
            f590.run();
        }
    }

    /* renamed from: ֏ */
    public static void m733(String str, String str2, Map<String, String> map) {
        Boolean bool;
        Map<String, StatTablePolicy> map2 = f589;
        StringBuilder r1 = outline.m2550(TextUtils.isEmpty(str) ? "def" : str, "_");
        r1.append(str2.trim().replace(" ", "_"));
        StatTablePolicy statTablePolicy = map2.get(r1.toString().toLowerCase());
        if ((statTablePolicy == null || (bool = statTablePolicy.intercept) == null) ? false : bool.booleanValue()) {
            "report intercept " + str + "_" + str2;
            return;
        }
        "report " + str2 + ", params " + map;
        EventModel eventModel = new EventModel((C1099) null);
        eventModel.biz = str;
        eventModel.eventId = str2;
        eventModel.params = map;
        eventModel.time = WPengServer.m1070();
        f582.add(eventModel);
        f588 = true;
        if (f582.size() >= 10 && f588) {
            TaskManager.m2720(new C1290());
        }
    }
}
