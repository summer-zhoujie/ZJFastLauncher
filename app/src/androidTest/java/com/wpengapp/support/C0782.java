package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Յ */
/* compiled from: AccTaskManager */
class C0782 implements Runnable {
    public void run() {
        AccTask poll;
        if ((C0840.f2224 != null && !C0840.f2224.mo8878()) || (poll = C0840.f2223.poll()) == null) {
            return;
        }
        if (poll.mo8878()) {
            C0840.m2251();
            return;
        }
        C0840.f2224 = poll;
        C0840.f2226 = System.currentTimeMillis();
        C0990 r1 = new C0990(this, poll);
        C1151 r2 = new C1151(this, poll);
        C0840.f2225.postDelayed(new C0629(poll), poll.f2429);
        poll.f2431 = r2;
        poll.mo8876();
        poll.mo8203(r1);
        C0840.m2249(poll);
    }
}
