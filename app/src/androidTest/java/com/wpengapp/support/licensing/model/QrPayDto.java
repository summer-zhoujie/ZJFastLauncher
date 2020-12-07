package com.wpengapp.support.licensing.model;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import com.wpengapp.support.outline;
import java.io.Serializable;

@Keep
public class QrPayDto implements Serializable {
    public int biz;
    public int needPayAmount;
    public String qrContent;
    public boolean supportSaveQr;
    public int timeout;

    @NonNull
    public String toString() {
        StringBuilder r0 = outline.m2549("QrPayDto{qrContent='");
        r0.append(this.qrContent);
        r0.append('\'');
        r0.append(", needPayAmount=");
        r0.append(this.needPayAmount);
        r0.append(", supportSaveQr=");
        r0.append(this.supportSaveQr);
        r0.append(", timeout=");
        r0.append(this.timeout);
        r0.append('}');
        return r0.toString();
    }
}
