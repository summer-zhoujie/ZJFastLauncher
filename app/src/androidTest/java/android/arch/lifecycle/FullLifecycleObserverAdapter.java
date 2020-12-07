package android.arch.lifecycle;

import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleOwner;

public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: ֏ */
    public final FullLifecycleObserver f1;

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f1 = fullLifecycleObserver;
    }

    /* renamed from: ֏ */
    public void mo1(LifecycleOwner r1, Lifecycle.C0955 r2) {
        switch (r2.ordinal()) {
            case 0:
                this.f1.mo5(r1);
                return;
            case 1:
                this.f1.mo2(r1);
                return;
            case 2:
                this.f1.mo6(r1);
                return;
            case 3:
                this.f1.mo3(r1);
                return;
            case 4:
                this.f1.mo7(r1);
                return;
            case 5:
                this.f1.mo4(r1);
                return;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
