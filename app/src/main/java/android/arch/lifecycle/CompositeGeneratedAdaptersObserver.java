package android.arch.lifecycle;

import android.support.annotation.RestrictTo;
import com.wpengapp.support.GeneratedAdapter;
import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleOwner;
import com.wpengapp.support.MethodCallsLogger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* renamed from: ֏ */
    public final GeneratedAdapter[] f0;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] r1) {
        this.f0 = r1;
    }

    /* renamed from: ֏ */
    public void mo1(LifecycleOwner r7, Lifecycle.C0955 r8) {
        MethodCallsLogger r0 = new MethodCallsLogger();
        for (GeneratedAdapter r5 : this.f0) {
            r5.mo8988(r7, r8, false, r0);
        }
        for (GeneratedAdapter r4 : this.f0) {
            r4.mo8988(r7, r8, true, r0);
        }
    }
}
