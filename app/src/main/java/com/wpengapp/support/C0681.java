package com.wpengapp.support;

/* renamed from: com.wpengapp.support.Ё */
/* compiled from: Remote */
class C0681 implements Runnable {
    public void run() {
        MainServiceProxy r0 = C0983.f2753;
        if (r0 != null) {
            try {
                if (!r0.asBinder().pingBinder()) {
                    C0983.m2616();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        C0983.f2756.postDelayed(this, 180000);
    }
}
