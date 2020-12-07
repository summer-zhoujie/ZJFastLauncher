package com.wpengapp.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p000v4.text.BidiFormatter;
import android.text.TextUtils;
import com.wpengapp.support.UMEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.wpengapp.support.ʬ */
public class ViewPageTracker {

    /* renamed from: ֏ */
    public final Map<String, Long> f1379 = new HashMap();

    /* renamed from: ؠ */
    public final ArrayList<UMEntry.C0558> f1380 = new ArrayList<>();

    /* renamed from: ֏ */
    public void mo8286(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (this.f1380.size() > 0) {
            String string = sharedPreferences.getString("activities", BidiFormatter.EMPTY_STRING);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(string)) {
                sb.append(string);
                sb.append(";");
            }
            synchronized (this.f1380) {
                Iterator<UMEntry.C0558> it = this.f1380.iterator();
                while (it.hasNext()) {
                    UMEntry.C0558 next = it.next();
                    sb.append(String.format("[\"%s\",%d]", new Object[]{next.f1134, Long.valueOf(next.f1135)}));
                    sb.append(";");
                }
                this.f1380.clear();
            }
            sb.deleteCharAt(sb.length() - 1);
            edit.remove("activities");
            edit.putString("activities", sb.toString());
        }
        edit.commit();
    }

    /* renamed from: ؠ */
    public void mo8288(String str) {
        Long remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1379) {
                remove = this.f1379.remove(str);
            }
            if (remove == null) {
                MLog.m1778("please call 'onPageStart(%s)' before onPageEnd", str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - remove.longValue();
            synchronized (this.f1380) {
                UMEntry.C0558 r0 = new UMEntry.C0558();
                r0.f1134 = str;
                r0.f1135 = currentTimeMillis;
                this.f1380.add(r0);
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8287(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1379) {
                this.f1379.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: ֏ */
    public void mo8285() {
        String str;
        synchronized (this.f1379) {
            str = null;
            long j = 0;
            for (Map.Entry next : this.f1379.entrySet()) {
                if (((Long) next.getValue()).longValue() > j) {
                    long longValue = ((Long) next.getValue()).longValue();
                    str = (String) next.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            mo8288(str);
        }
    }
}
