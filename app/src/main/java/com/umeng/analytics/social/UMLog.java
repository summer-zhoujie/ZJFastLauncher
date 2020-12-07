package com.umeng.analytics.social;

import com.wpengapp.support.outline;

/* renamed from: com.umeng.analytics.social.b */
public class UMLog {
    /* renamed from: a */
    public static void m202a(String str, String str2) {
        boolean z = UMSocialConstants.f263v;
    }

    /* renamed from: b */
    public static void m204b(String str, String str2) {
        boolean z = UMSocialConstants.f263v;
    }

    /* renamed from: c */
    public static void m206c(String str, String str2) {
        boolean z = UMSocialConstants.f263v;
    }

    /* renamed from: d */
    public static void m208d(String str, String str2) {
        boolean z = UMSocialConstants.f263v;
    }

    /* renamed from: e */
    public static void m210e(String str, String str2) {
        boolean z = UMSocialConstants.f263v;
    }

    /* renamed from: a */
    public static void m203a(String str, String str2, Exception exc) {
        if (UMSocialConstants.f263v) {
            exc.toString() + ":  [" + str2 + "]";
        }
    }

    /* renamed from: b */
    public static void m205b(String str, String str2, Exception exc) {
        if (UMSocialConstants.f263v) {
            exc.toString() + ":  [" + str2 + "]";
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                StringBuilder r1 = outline.m2549("        at\t ");
                r1.append(stackTraceElement.toString());
                r1.toString();
            }
        }
    }

    /* renamed from: c */
    public static void m207c(String str, String str2, Exception exc) {
        if (UMSocialConstants.f263v) {
            exc.toString() + ":  [" + str2 + "]";
        }
    }

    /* renamed from: d */
    public static void m209d(String str, String str2, Exception exc) {
        if (UMSocialConstants.f263v) {
            exc.toString() + ":  [" + str2 + "]";
        }
    }

    /* renamed from: e */
    public static void m211e(String str, String str2, Exception exc) {
        if (UMSocialConstants.f263v) {
            exc.toString() + ":  [" + str2 + "]";
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                StringBuilder r1 = outline.m2549("        at\t ");
                r1.append(stackTraceElement.toString());
                r1.toString();
            }
        }
    }
}
