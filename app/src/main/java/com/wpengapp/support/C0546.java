package com.wpengapp.support;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.wpengapp.support.ȱ */
/* compiled from: Okio */
public final class C0546 extends AsyncTimeout {

    /* renamed from: ވ */
    public final /* synthetic */ Socket f1098;

    public C0546(Socket socket) {
        this.f1098 = socket;
    }

    /* renamed from: ֏ */
    public IOException mo8136(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* renamed from: ކ */
    public void mo7905() {
        try {
            this.f1098.close();
        } catch (Exception e) {
            Logger logger = C0745.f1920;
            Level level = Level.WARNING;
            StringBuilder r0 = outline.m2549("Failed to close timed out socket ");
            r0.append(this.f1098);
            logger.log(level, r0.toString(), e);
        } catch (AssertionError e2) {
            if (C0745.m1953(e2)) {
                Logger logger2 = C0745.f1920;
                Level level2 = Level.WARNING;
                StringBuilder r02 = outline.m2549("Failed to close timed out socket ");
                r02.append(this.f1098);
                logger2.log(level2, r02.toString(), e2);
                return;
            }
            throw e2;
        }
    }
}
