package android.arch.lifecycle;

import android.support.annotation.RestrictTo;
import com.wpengapp.support.GeneratedAdapter;
import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleOwner;
import com.wpengapp.support.MethodCallsLogger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* renamed from: ֏ */
    public final GeneratedAdapter f10;

    public SingleGeneratedAdapterObserver(GeneratedAdapter r1) {
        this.f10 = r1;
    }

    /* renamed from: ֏ */
    public void mo1(LifecycleOwner r4, Lifecycle.C0955 r5) {
        this.f10.mo8988(r4, r5, false, (MethodCallsLogger) null);
        this.f10.mo8988(r4, r5, true, (MethodCallsLogger) null);
    }
}
