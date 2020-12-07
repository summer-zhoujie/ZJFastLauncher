package com.wpengapp.support;

import android.os.Looper;
import android.os.Process;
import com.wpengapp.support.licensing.model.AppDevice;
import java.io.Closeable;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.wpengapp.support.ߜ */
/* compiled from: CrashHandler */
public class C0975 implements Thread.UncaughtExceptionHandler {

    /* renamed from: ֏ */
    public Thread.UncaughtExceptionHandler f2742;

    public C0975(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f2742 = uncaughtExceptionHandler;
    }

    /* renamed from: ֏ */
    public static void m2602(Throwable th) {
        m2601(Thread.currentThread(), th, !BaseApplication.f562, (Map<String, String>) null);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            m2601(thread, th, false, (Map<String, String>) null);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2742;
            if (!(uncaughtExceptionHandler == null || uncaughtExceptionHandler == this)) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
            if (!C1146.m3072() || thread == Looper.getMainLooper().getThread()) {
                BaseApplication.f561.mo7792();
            }
        }
    }

    /* renamed from: ֏ */
    public static void m2601(Thread thread, Throwable th, boolean z, Map<String, String> map) {
        String str;
        String str2;
        if (map == null) {
            map = new HashMap<>();
        }
        if (thread == null) {
            str = null;
        } else {
            str = thread.getName();
        }
        map.put("thread", str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("build", BaseApplication.m705());
            jSONObject.put("uid", WPengServer.f841);
            jSONObject.put("did", WPengServer.f840);
            jSONObject.put("root", C0719.m1828());
            jSONObject.put("proc", AppUtils.m1165());
            jSONObject.put("curr_act", AppUtils.m1168());
            jSONObject.put("recent_act", AppUtils.f901);
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            str2 = jSONObject.toString();
        } catch (Exception e) {
            e.getMessage();
            str2 = null;
        }
        try {
            Field declaredField = Throwable.class.getDeclaredField("detailMessage");
            declaredField.setAccessible(true);
            declaredField.set(th, th.getMessage() + "\n***********Extra Start***********\n" + str2 + "\n***********Extra End*************");
        } catch (Throwable th2) {
            th2.getMessage();
        }
        File r10 = FileManager.m1200();
        String r1 = FileManager.m1196();
        StringBuilder sb = new StringBuilder();
        AppDevice r3 = Utils.m1900();
        r3.buildInfo = null;
        sb.append(r1);
        sb.append("\n");
        sb.append("process: ");
        sb.append(AppUtils.m1165());
        sb.append("(");
        sb.append(Process.myPid());
        sb.append(")");
        sb.append("\n");
        sb.append("version: ");
        sb.append(AppUtils.m1159());
        sb.append("(");
        sb.append(AppUtils.m1158());
        sb.append(")");
        sb.append("\n");
        sb.append("device: ");
        sb.append(GsonUtil.m2742(r3));
        sb.append("\n");
        sb.append("extra: ");
        sb.append(str2);
        sb.append("\n");
        sb.append("************\n\n");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        sb.append(stringWriter.toString());
        FileUtils.close((Closeable) stringWriter);
        FileUtils.close((Closeable) printWriter);
        File file = new File(r10, r1);
        FileUtils.m1127(file, sb.toString());
        "Save crash log: " + file.getPath();
        if (z) {
            UMengManager.m1407(th);
        }
    }

    /* renamed from: ֏ */
    public static File[] m2603() {
        File r0 = FileManager.m1200();
        if (!r0.exists()) {
            return null;
        }
        return r0.listFiles(new C0872());
    }
}
