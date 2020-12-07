package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ζ */
class ShareAdapter implements Runnable {

    /* renamed from: ֏ */
    public final /* synthetic */ C0890 f1664;

    public ShareAdapter(C0890 r1) {
        this.f1664 = r1;
    }

    public void run() {
        this.f1664.f2407.notifyDataSetChanged();
    }
}
