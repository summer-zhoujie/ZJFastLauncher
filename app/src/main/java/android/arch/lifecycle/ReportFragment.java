package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import com.wpengapp.support.Lifecycle;
import com.wpengapp.support.LifecycleOwner;
import com.wpengapp.support.LifecycleRegistry;
import com.wpengapp.support.LifecycleRegistryOwner;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ReportFragment extends Fragment {
    /* renamed from: ֏ */
    public static void m19(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        mo30(Lifecycle.C0955.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        mo30(Lifecycle.C0955.ON_DESTROY);
    }

    public void onPause() {
        super.onPause();
        mo30(Lifecycle.C0955.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        mo30(Lifecycle.C0955.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        mo30(Lifecycle.C0955.ON_START);
    }

    public void onStop() {
        super.onStop();
        mo30(Lifecycle.C0955.ON_STOP);
    }

    /* renamed from: ֏ */
    public final void mo30(Lifecycle.C0955 r3) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().mo8993(r3);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).mo8993(r3);
            }
        }
    }
}
