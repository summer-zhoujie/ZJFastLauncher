package butterknife;

import android.app.Activity;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.wpengapp.support.outline;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {

    /* renamed from: ֏ */
    public static boolean f47 = false;
    @VisibleForTesting

    /* renamed from: ؠ */
    public static final Map<Class<?>, Constructor<? extends Unbinder>> f48 = new LinkedHashMap();

    public interface Action<T extends View> {
    }

    public interface Setter<T extends View, V> {
    }

    public ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @UiThread
    @NonNull
    /* renamed from: ֏ */
    public static Unbinder m30(@NonNull Activity activity) {
        return m31(activity, activity.getWindow().getDecorView());
    }

    /* renamed from: ֏ */
    public static Unbinder m31(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (f47) {
            StringBuilder r2 = outline.m2549("Looking up binding for ");
            r2.append(cls.getName());
            r2.toString();
        }
        Constructor<? extends Unbinder> r1 = m32(cls);
        if (r1 == null) {
            return Unbinder.f60;
        }
        try {
            return (Unbinder) r1.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(outline.m2554("Unable to invoke ", (Object) r1), e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(outline.m2554("Unable to invoke ", (Object) r1), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    @UiThread
    @CheckResult
    @Nullable
    /* renamed from: ֏ */
    public static Constructor<? extends Unbinder> m32(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Constructor<? extends Unbinder> constructor2 = f48.get(cls);
        if (constructor2 != null) {
            boolean z = f47;
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            boolean z2 = f47;
            return null;
        }
        try {
            constructor = Class.forName(name + "_ViewBinding").getConstructor(new Class[]{cls, View.class});
            boolean z3 = f47;
        } catch (ClassNotFoundException unused) {
            if (f47) {
                StringBuilder r0 = outline.m2549("Not found. Trying superclass ");
                r0.append(cls.getSuperclass().getName());
                r0.toString();
            }
            constructor = m32((Class<?>) cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(outline.m2556("Unable to find binding constructor for ", name), e);
        }
        f48.put(cls, constructor);
        return constructor;
    }
}
