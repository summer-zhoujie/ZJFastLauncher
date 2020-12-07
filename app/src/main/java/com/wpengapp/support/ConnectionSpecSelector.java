package com.wpengapp.support;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.wpengapp.support.ༀ */
public final class ConnectionSpecSelector {

    /* renamed from: ֏ */
    public final List<ConnectionSpec> f3522;

    /* renamed from: ؠ */
    public int f3523 = 0;

    /* renamed from: ހ */
    public boolean f3524;

    /* renamed from: ށ */
    public boolean f3525;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f3522 = list;
    }

    /* renamed from: ֏ */
    public ConnectionSpec mo9489(SSLSocket sSLSocket) {
        boolean z;
        ConnectionSpec r3;
        int i = this.f3523;
        int size = this.f3522.size();
        while (true) {
            z = true;
            if (i >= size) {
                r3 = null;
                break;
            }
            r3 = this.f3522.get(i);
            if (r3.mo9138(sSLSocket)) {
                this.f3523 = i + 1;
                break;
            }
            i++;
        }
        if (r3 != null) {
            int i2 = this.f3523;
            while (true) {
                if (i2 >= this.f3522.size()) {
                    z = false;
                    break;
                } else if (this.f3522.get(i2).mo9138(sSLSocket)) {
                    break;
                } else {
                    i2++;
                }
            }
            this.f3524 = z;
            Internal.f1914.mo7919(r3, sSLSocket, this.f3525);
            return r3;
        }
        StringBuilder r1 = outline.m2549("Unable to find acceptable protocols. isFallback=");
        r1.append(this.f3525);
        r1.append(", modes=");
        r1.append(this.f3522);
        r1.append(", supported protocols=");
        r1.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(r1.toString());
    }
}
