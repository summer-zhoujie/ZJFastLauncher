package com.wpengapp.baseui;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import com.wpengapp.support.CollectionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class AppWrapper implements Comparable<AppWrapper> {
    public static final String KEY_APP_ACTIVITY_NAME = "acti";
    public static final String KEY_APP_PACKAGE_NAME = "pkg";
    public static final String TAG = "AppWrapper";
    public String className;
    public WeakReference<Drawable> icon;
    public CharSequence name;
    public String packageName;
    public ResolveInfo resolveInfo;

    public static List<AppWrapper> json2list(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                AppWrapper appWrapper = new AppWrapper();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                appWrapper.packageName = jSONObject.getString(KEY_APP_PACKAGE_NAME);
                appWrapper.className = jSONObject.getString(KEY_APP_ACTIVITY_NAME);
                arrayList.add(appWrapper);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static String list2json(List<AppWrapper> list) {
        if (list == null) {
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (AppWrapper next : list) {
            try {
                jSONArray.put(new JSONObject().put(KEY_APP_PACKAGE_NAME, next.packageName).put(KEY_APP_ACTIVITY_NAME, next.className));
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppWrapper.class != obj.getClass()) {
            return false;
        }
        AppWrapper appWrapper = (AppWrapper) obj;
        String str = this.className;
        if (str == null ? appWrapper.className != null : !str.equals(appWrapper.className)) {
            return false;
        }
        String str2 = this.packageName;
        if (str2 != null) {
            return str2.equals(appWrapper.packageName);
        }
        if (appWrapper.packageName == null) {
            return true;
        }
        return false;
    }

    public Drawable getCachedIcon() {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.icon;
        if (weakReference == null || (drawable = (Drawable) weakReference.get()) == null) {
            return null;
        }
        return drawable;
    }

    public Drawable getIcon(Context context) {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.icon;
        if (weakReference != null) {
            drawable = (Drawable) weakReference.get();
            if (drawable != null) {
                return drawable;
            }
        } else {
            drawable = null;
        }
        try {
            drawable = this.resolveInfo.loadIcon(context.getPackageManager());
        } catch (Throwable th) {
            th.getMessage();
        }
        if (drawable != null) {
            if (drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() <= 250000) {
                this.icon = new WeakReference<>(drawable);
                return drawable;
            }
        }
        return null;
    }

    public int hashCode() {
        String str = this.className;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.packageName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public int compareTo(AppWrapper appWrapper) {
        CharSequence charSequence;
        if (appWrapper == null || (charSequence = appWrapper.name) == null) {
            return -1;
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 == null) {
            return 1;
        }
        return CollectionUtils.f1665.compare(charSequence2, charSequence);
    }
}
