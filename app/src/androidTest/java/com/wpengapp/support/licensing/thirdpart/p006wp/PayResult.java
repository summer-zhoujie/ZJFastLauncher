package com.wpengapp.support.licensing.thirdpart.p006wp;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.wpengapp.support.outline;

@Keep
/* renamed from: com.wpengapp.support.licensing.thirdpart.wp.PayResult */
public class PayResult {
    public static final String STATUS_CANCEL = "6001";
    public static final String STATUS_FAILED = "4000";
    public static final String STATUS_NET_ERROR = "6002";
    public static final String STATUS_PAYING = "8000";
    public static final String STATUS_SUCCESS = "9000";
    public String memo;
    public String result;
    public String resultStatus;

    private String gatValue(String str, String str2) {
        String r3 = outline.m2556(str2, "={");
        return str.substring(r3.length() + str.indexOf(r3), str.lastIndexOf("}"));
    }

    public void parseAlipay(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (str2.startsWith("resultStatus")) {
                    this.resultStatus = gatValue(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.result = gatValue(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.memo = gatValue(str2, "memo");
                }
            }
        }
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("PayResult{resultStatus='");
        r0.append(this.resultStatus);
        r0.append('\'');
        r0.append(", result='");
        r0.append(this.result);
        r0.append('\'');
        r0.append(", memo='");
        r0.append(this.memo);
        r0.append('\'');
        r0.append('}');
        return r0.toString();
    }
}
