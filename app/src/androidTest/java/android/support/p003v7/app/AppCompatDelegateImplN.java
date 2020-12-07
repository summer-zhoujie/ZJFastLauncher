package android.support.p003v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.p003v7.app.AppCompatDelegateImplV23;
import android.support.p003v7.app.AppCompatDelegateImplV9;
import android.support.p003v7.view.menu.MenuBuilder;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

@RequiresApi(24)
/* renamed from: android.support.v7.app.AppCompatDelegateImplN */
public class AppCompatDelegateImplN extends AppCompatDelegateImplV23 {

    /* renamed from: android.support.v7.app.AppCompatDelegateImplN$AppCompatWindowCallbackN */
    class AppCompatWindowCallbackN extends AppCompatDelegateImplV23.AppCompatWindowCallbackV23 {
        public AppCompatWindowCallbackN(Window.Callback callback) {
            super(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            AppCompatDelegateImplV9.PanelFeatureState panelState = AppCompatDelegateImplN.this.getPanelState(0, true);
            if (panelState == null || (menuBuilder = panelState.menu) == null) {
                this.mWrapped.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                this.mWrapped.onProvideKeyboardShortcuts(list, menuBuilder, i);
            }
        }
    }

    public AppCompatDelegateImplN(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public Window.Callback wrapWindowCallback(Window.Callback callback) {
        return new AppCompatWindowCallbackN(callback);
    }
}
