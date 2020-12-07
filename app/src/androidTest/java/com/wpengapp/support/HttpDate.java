package com.wpengapp.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.wpengapp.support.Զ */
class HttpDate extends ThreadLocal<DateFormat> {
    public Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(Util.f742);
        return simpleDateFormat;
    }
}
