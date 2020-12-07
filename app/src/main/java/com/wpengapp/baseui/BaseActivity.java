package com.wpengapp.baseui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.text.BidiFormatter;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.view.menu.MenuBuilder;
import android.support.p003v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import butterknife.ButterKnife;
import com.wpengapp.baseui.widget.ListenTouchLayout;
import com.wpengapp.support.C0826;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BaseActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    /* renamed from: ֏ */
    public static WeakReference<BaseActivity> f266;

    /* renamed from: ؠ */
    public boolean f267 = false;

    /* renamed from: ހ */
    public ListenTouchLayout f268;

    /* renamed from: ށ */
    public Toolbar f269;

    /* renamed from: ނ */
    public View f270;

    /* renamed from: ރ */
    public View f271;

    /* renamed from: ބ */
    public View f272;

    /* renamed from: ޅ */
    public ProgressDialog f273;

    /* renamed from: ކ */
    public ViewGroup f274;

    /* renamed from: އ */
    public boolean f275;

    /* renamed from: ވ */
    public Set<C0419> f276 = new CopyOnWriteArraySet();

    /* renamed from: މ */
    public int f277;

    /* renamed from: com.wpengapp.baseui.BaseActivity$֏ */
    public static class C0419 {
        /* renamed from: ֏ */
        public void mo7447() {
        }

        /* renamed from: ֏ */
        public void mo7448(int i, int i2, Intent intent) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (C0419 next : this.f276) {
            if (next != null) {
                try {
                    next.mo7448(i, i2, intent);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                getWindow().getDecorView().setImportantForAutofill(8);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            declaredField.setAccessible(true);
            declaredField.setBoolean(viewConfiguration, false);
        } catch (Exception unused) {
        }
        this.f268 = (ListenTouchLayout) View.inflate(this, R$layout.baseui_activity_base, (ViewGroup) null);
        this.f269 = (Toolbar) this.f268.findViewById(R$id.toolbar);
        this.f270 = this.f268.findViewById(R$id.toolbarLine);
        this.f275 = mo7423();
        if (this.f275) {
            this.f274 = (ScrollView) this.f268.findViewById(R$id.base_scroll_content);
        } else {
            this.f274 = (RelativeLayout) this.f268.findViewById(R$id.base_content);
        }
        this.f274.setVisibility(0);
        setSupportActionBar(this.f269);
        mo7445();
        this.f267 = false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f277 != 0) {
            getMenuInflater().inflate(this.f277, menu);
        }
        int i = Build.VERSION.SDK_INT;
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f267 = true;
        WeakReference<BaseActivity> weakReference = f266;
        if (weakReference != null && weakReference.get() == this) {
            f266 = null;
        }
        for (C0419 next : this.f276) {
            if (next != null) {
                try {
                    next.mo7447();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        this.f276.clear();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Toolbar toolbar;
        if (i != 82 || keyEvent.getRepeatCount() != 0 || (toolbar = this.f269) == null || !toolbar.canShowOverflowMenu()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Toolbar toolbar;
        if (i != 82 || keyEvent.getRepeatCount() != 0 || (toolbar = this.f269) == null || !toolbar.canShowOverflowMenu()) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.f269.isOverflowMenuShowing()) {
            this.f269.hideOverflowMenu();
            return true;
        }
        this.f269.showOverflowMenu();
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null && MenuBuilder.TAG.equals(menu.getClass().getSimpleName())) {
            try {
                Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", new Class[]{Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(menu, new Object[]{true});
            } catch (Exception unused) {
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    public void onResume() {
        super.onResume();
        for (C0419 next : this.f276) {
        }
    }

    public void onStart() {
        super.onStart();
        f266 = new WeakReference<>(this);
    }

    public void setContentView(@LayoutRes int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    public void setToolBarCustomView(View view) {
        mo7417(view);
        if (view == null) {
            mo7445();
        }
    }

    /* renamed from: ֏ */
    public void mo7422(boolean z) {
        int i = 0;
        this.f269.setVisibility(z ? 0 : 8);
        View view = this.f270;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* renamed from: ֏ */
    public boolean mo7423() {
        return false;
    }

    /* renamed from: ؠ */
    public void mo7425(Drawable drawable) {
        this.f269.setNavigationIcon(drawable);
        if (drawable != null) {
            this.f269.setNavigationContentDescription(R$string.baseui_back_page);
        }
        this.f269.setNavigationOnClickListener(new BaseActivity(this));
    }

    /* renamed from: ހ */
    public void mo7432(Drawable drawable) {
        this.f269.setOverflowIcon(drawable);
    }

    /* renamed from: ށ */
    public Toolbar mo7434() {
        return this.f269;
    }

    /* renamed from: ނ */
    public View mo7435() {
        return null;
    }

    /* renamed from: ރ */
    public Drawable mo7436() {
        return null;
    }

    /* renamed from: ބ */
    public int mo7437() {
        return 0;
    }

    /* renamed from: ޅ */
    public Drawable mo7438() {
        return ContextCompat.getDrawable(this, R$drawable.baseui_icon_toolbar_back);
    }

    /* renamed from: ކ */
    public Drawable mo7439() {
        return null;
    }

    /* renamed from: އ */
    public CharSequence mo7440() {
        return getTitle();
    }

    /* renamed from: ވ */
    public void mo7441() {
        this.f274.setVisibility(4);
    }

    /* renamed from: މ */
    public boolean mo7442() {
        try {
            int i = Build.VERSION.SDK_INT;
            return this.f267 || super.isDestroyed();
        } catch (Throwable th) {
            th.getMessage();
            return this.f267;
        }
    }

    /* renamed from: ފ */
    public boolean mo7443() {
        return true;
    }

    /* renamed from: ދ */
    public boolean mo7444() {
        return false;
    }

    /* renamed from: ތ */
    public void mo7445() {
        if (mo7443()) {
            if (this.f272 == null) {
                View r0 = mo7435();
                this.f272 = r0;
                if (r0 == null) {
                    mo7417((View) null);
                    mo7425(mo7438());
                    mo7415(mo7436());
                    mo7427(mo7440());
                    mo7414(mo7437(), this);
                    if (mo7439() != null) {
                        mo7432(mo7439());
                    }
                    mo7422(true);
                }
            }
            mo7417(this.f272);
            mo7422(true);
        } else {
            mo7417((View) null);
            mo7422(false);
        }
        mo7428(mo7444());
    }

    /* renamed from: ލ */
    public void mo7446() {
        this.f274.setVisibility(0);
    }

    public void setContentView(View view) {
        if (this.f275) {
            this.f274.addView(view, new FrameLayout.LayoutParams(-1, -2));
        } else {
            this.f274.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
        super.setContentView((View) this.f268);
        ButterKnife.m30((Activity) this);
    }

    /* renamed from: ހ */
    public void mo7433(CharSequence charSequence) {
        C0826.m2180(charSequence);
    }

    /* renamed from: ֏ */
    public final void mo7417(View view) {
        View view2 = this.f271;
        if (view2 != null) {
            this.f269.removeView(view2);
        }
        this.f271 = view;
        if (view != null) {
            mo7425((Drawable) null);
            mo7415((Drawable) null);
            mo7427((CharSequence) BidiFormatter.EMPTY_STRING);
            mo7414(0, (Toolbar.OnMenuItemClickListener) null);
            this.f269.addView(view, new Toolbar.LayoutParams(-1, -1));
        }
    }

    /* renamed from: ހ */
    public void mo7431(int i) {
        mo7421(getString(i));
    }

    /* renamed from: ؠ */
    public void mo7427(CharSequence charSequence) {
        setTitle(charSequence);
    }

    /* renamed from: ހ */
    public void mo7430() {
        runOnUiThread(new C0648(this));
    }

    /* renamed from: ؠ */
    public void mo7428(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f274.getLayoutParams();
        if (z || this.f269.getVisibility() == 8) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = this.f269.getLayoutParams().height;
        }
        this.f274.setLayoutParams(layoutParams);
    }

    /* renamed from: ؠ */
    public boolean mo7429() {
        return !mo7442() && !isFinishing();
    }

    /* renamed from: ֏ */
    public void mo7415(Drawable drawable) {
        this.f269.setLogo(drawable);
    }

    /* renamed from: ؠ */
    public void mo7424(int i) {
        mo7433((CharSequence) getString(i));
    }

    /* renamed from: ֏ */
    public void mo7414(int i, Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.f277 = i;
        if (i == 0) {
            mo7416((Toolbar.OnMenuItemClickListener) null);
        } else {
            mo7416(onMenuItemClickListener);
        }
        invalidateOptionsMenu();
    }

    /* renamed from: ؠ */
    public void mo7426(C0419 r2) {
        this.f276.remove(r2);
    }

    /* renamed from: ֏ */
    public void mo7413(int i) {
        mo7419((CharSequence) getString(i));
    }

    /* renamed from: ֏ */
    public void mo7419(CharSequence charSequence) {
        C0826.m2177(charSequence);
    }

    /* renamed from: ֏ */
    public void mo7416(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        Toolbar toolbar = this.f269;
        if (toolbar != null) {
            toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        }
    }

    /* renamed from: ֏ */
    public void mo7418(C0419 r2) {
        this.f276.add(r2);
    }

    /* renamed from: ֏ */
    public void mo7421(String str) {
        runOnUiThread(new C0814(this, str));
    }

    /* renamed from: ֏ */
    public void mo7420(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
