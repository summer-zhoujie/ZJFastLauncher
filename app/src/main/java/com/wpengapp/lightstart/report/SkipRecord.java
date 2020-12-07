package com.wpengapp.lightstart.report;

import android.support.annotation.Keep;
import com.wpengapp.support.outline;
import java.util.Map;

@Keep
public class SkipRecord {
    public Map<String, Integer> appRecord;
    public Map<String, Integer> pageRecord;

    public String toString() {
        StringBuilder r0 = outline.m2549("SkipRecord{appRecord=");
        r0.append(this.appRecord);
        r0.append(", pageRecord=");
        r0.append(this.pageRecord);
        r0.append('}');
        return r0.toString();
    }
}
