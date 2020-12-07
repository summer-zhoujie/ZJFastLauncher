package com.wpengapp.support;

import com.wpengapp.support.C1086;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wpengapp.support.શ */
public class UMCCAggregatedObject implements Serializable {

    /* renamed from: ֏ */
    public List<String> f3178 = new ArrayList();

    /* renamed from: ؠ */
    public List<String> f3179 = new ArrayList();

    /* renamed from: ހ */
    public long f3180 = 0;

    /* renamed from: ށ */
    public long f3181 = 0;

    /* renamed from: ނ */
    public long f3182 = 0;

    /* renamed from: ރ */
    public String f3183 = null;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[key: ");
        stringBuffer.append(this.f3178);
        stringBuffer.append("] [label: ");
        stringBuffer.append(this.f3179);
        stringBuffer.append("][ totalTimeStamp");
        stringBuffer.append(this.f3183);
        stringBuffer.append("][ value");
        stringBuffer.append(this.f3181);
        stringBuffer.append("][ count");
        stringBuffer.append(this.f3182);
        stringBuffer.append("][ timeWindowNum");
        stringBuffer.append(this.f3183);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* renamed from: ֏ */
    public void mo9304(String str) {
        try {
            int size = this.f3179.size();
            C1086.C1087.f3084.mo9261();
            if (size < 8) {
                this.f3179.add(str);
            } else {
                this.f3179.remove(this.f3179.get(0));
                this.f3179.add(str);
            }
            int size2 = this.f3179.size();
            C1086.C1087.f3084.mo9261();
            if (size2 > 8) {
                int i = 0;
                while (true) {
                    int size3 = this.f3179.size();
                    C1086.C1087.f3084.mo9261();
                    if (i < size3 - 8) {
                        this.f3179.remove(this.f3179.get(0));
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
