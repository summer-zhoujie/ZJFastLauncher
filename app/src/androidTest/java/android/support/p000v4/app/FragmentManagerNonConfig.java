package android.support.p000v4.app;

import com.wpengapp.support.ViewModelStore;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerNonConfig */
public class FragmentManagerNonConfig {
    public final List<FragmentManagerNonConfig> mChildNonConfigs;
    public final List<Fragment> mFragments;
    public final List<ViewModelStore> mViewModelStores;

    public FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2, List<ViewModelStore> list3) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
        this.mViewModelStores = list3;
    }

    public List<FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    public List<Fragment> getFragments() {
        return this.mFragments;
    }

    public List<ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }
}
