package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ʕ */
public final class Logger {

    /* renamed from: ֏ */
    public static boolean f1344 = true;

    /* renamed from: ֏ */
    public static void m1473(String str, String str2, int i) {
        if (f1344) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            StringBuilder r1 = outline.m2549("[");
            r1.append(stackTraceElement.getFileName());
            r1.append("(");
            r1.append(stackTraceElement.getLineNumber());
            r1.append(") ");
            r1.append(stackTraceElement.getMethodName());
            r1.append("] ");
            outline.m2555(r1.toString(), str2);
            if (i != 1 && i != 2 && i != 4) {
            }
        }
    }
}
