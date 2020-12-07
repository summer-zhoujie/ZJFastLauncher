package com.wpengapp.lightstart.config;

import android.support.annotation.Keep;
import com.wpengapp.support.AppConfig;
import com.wpengapp.support.outline;
import java.util.HashMap;

@Keep
public class DefaultConfig {
    public HashMap<String, AppConfig> configData;
    public int dataLen;
    public Integer type;
    public int version;

    public String toString() {
        StringBuilder r0 = outline.m2549("DefaultConfig{version=");
        r0.append(this.version);
        r0.append(", dataLen=");
        r0.append(this.dataLen);
        r0.append(", type=");
        r0.append(this.type);
        r0.append('}');
        return r0.toString();
    }
}
