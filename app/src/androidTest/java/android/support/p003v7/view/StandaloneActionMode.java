package android.support.p003v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.view.menu.MenuBuilder;
import android.support.p003v7.view.menu.MenuPopupHelper;
import android.support.p003v7.view.menu.SubMenuBuilder;
import android.support.p003v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v7.view.StandaloneActionMode */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    public Callback mCallback;
    public Context mContext;
    public ActionBarContextView mContextView;
    public WeakReference<View> mCustomView;
    public boolean mFinished;
    public boolean mFocusable;
    public MenuBuilder mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, Callback callback, boolean z) {
        this.mContext = context;
        this.mContextView = actionBarContextView;
        this.mCallback = callback;
        this.mMenu = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.mMenu.setCallback(this);
        this.mFocusable = z;
    }

    public void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.mContextView.sendAccessibilityEvent(32);
            this.mCallback.onDestroyActionMode(this);
        }
    }

    public View getCustomView() {
        WeakReference<View> weakReference = this.mCustomView;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
    }

    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.mContextView.getContext(), subMenuBuilder).show();
        return true;
    }

    public void setCustomView(View view) {
        this.mContextView.setCustomView(view);
        this.mCustomView = view != null ? new WeakReference<>(view) : null;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.mTitleOptionalHint = z;
        this.mContextView.setTitleOptional(z);
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.mContext.getString(i));
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.mContext.getString(i));
    }
}
