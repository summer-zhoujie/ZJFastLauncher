package android.support.p000v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.p000v4.content.res.FontResourcesParserCompat;
import com.wpengapp.support.outline;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v4.graphics.TypefaceCompatApi26Impl */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    public static final String ABORT_CREATION_METHOD = "abortCreation";
    public static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    public static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    public static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    public static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    public static final String FREEZE_METHOD = "freeze";
    public static final int RESOLVE_BY_FONT_TABLE = -1;
    public static final String TAG = "TypefaceCompatApi26Impl";
    public static final Method sAbortCreation;
    public static final Method sAddFontFromAssetManager;
    public static final Method sAddFontFromBuffer;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class sFontFamily;
    public static final Constructor sFontFamilyCtor;
    public static final Method sFreeze;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method4 = cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method3 = cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method2 = cls.getMethod(FREEZE_METHOD, new Class[0]);
            method = cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
            method5 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
            method5.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder r2 = outline.m2549("Unable to collect necessary methods for class ");
            r2.append(e.getClass().getName());
            r2.toString();
            cls = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontFromAssetManager = method4;
        sAddFontFromBuffer = method3;
        sFreeze = method2;
        sAbortCreation = method;
        sCreateFromFamiliesWithDefault = method5;
    }

    public static void abortCreation(Object obj) {
        try {
            sAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromAssetManager.invoke(obj, new Object[]{context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromBuffer.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean freeze(Object obj) {
        try {
            return ((Boolean) sFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFontFamilyPrivateAPIAvailable() {
        Method method = sAddFontFromAssetManager;
        return sAddFontFromAssetManager != null;
    }

    public static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0)) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r8 = r12;
        r12 = r11;
        r11 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Typeface createFromFontInfo(Context r10, @android.support.annotation.Nullable android.os.CancellationSignal r11, @android.support.annotation.NonNull android.support.p000v4.provider.FontsContractCompat.FontInfo[] r12, int r13) {
        /*
            r9 = this;
            int r0 = r12.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            boolean r0 = isFontFamilyPrivateAPIAvailable()
            if (r0 != 0) goto L_0x0060
            android.support.v4.provider.FontsContractCompat$FontInfo r12 = r9.findBestInfo(r12, r13)
            android.content.ContentResolver r10 = r10.getContentResolver()
            android.net.Uri r13 = r12.getUri()     // Catch:{ IOException -> 0x005f }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r10 = r10.openFileDescriptor(r13, r0, r11)     // Catch:{ IOException -> 0x005f }
            if (r10 != 0) goto L_0x0026
            if (r10 == 0) goto L_0x0025
            r10.close()     // Catch:{ IOException -> 0x005f }
        L_0x0025:
            return r2
        L_0x0026:
            android.graphics.Typeface$Builder r11 = new android.graphics.Typeface$Builder     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            java.io.FileDescriptor r13 = r10.getFileDescriptor()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r11.<init>(r13)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            int r13 = r12.getWeight()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            android.graphics.Typeface$Builder r11 = r11.setWeight(r13)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            boolean r12 = r12.isItalic()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            android.graphics.Typeface$Builder r11 = r11.setItalic(r12)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            android.graphics.Typeface r11 = r11.build()     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            r10.close()     // Catch:{ IOException -> 0x005f }
            return r11
        L_0x0047:
            r11 = move-exception
            r12 = r2
            goto L_0x0050
        L_0x004a:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x004c }
        L_0x004c:
            r12 = move-exception
            r8 = r12
            r12 = r11
            r11 = r8
        L_0x0050:
            if (r12 == 0) goto L_0x005b
            r10.close()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r10 = move-exception
            r12.addSuppressed(r10)     // Catch:{ IOException -> 0x005f }
            goto L_0x005e
        L_0x005b:
            r10.close()     // Catch:{ IOException -> 0x005f }
        L_0x005e:
            throw r11     // Catch:{ IOException -> 0x005f }
        L_0x005f:
            return r2
        L_0x0060:
            java.util.Map r10 = android.support.p000v4.provider.FontsContractCompat.prepareFontData(r10, r12, r11)
            java.lang.Object r11 = newFamily()
            int r0 = r12.length
            r3 = 0
            r4 = 0
        L_0x006b:
            if (r3 >= r0) goto L_0x0096
            r5 = r12[r3]
            android.net.Uri r6 = r5.getUri()
            java.lang.Object r6 = r10.get(r6)
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            if (r6 != 0) goto L_0x007c
            goto L_0x0093
        L_0x007c:
            int r4 = r5.getTtcIndex()
            int r7 = r5.getWeight()
            boolean r5 = r5.isItalic()
            boolean r4 = addFontFromBuffer(r11, r6, r4, r7, r5)
            if (r4 != 0) goto L_0x0092
            abortCreation(r11)
            return r2
        L_0x0092:
            r4 = 1
        L_0x0093:
            int r3 = r3 + 1
            goto L_0x006b
        L_0x0096:
            if (r4 != 0) goto L_0x009c
            abortCreation(r11)
            return r2
        L_0x009c:
            boolean r10 = freeze(r11)
            if (r10 != 0) goto L_0x00a3
            return r2
        L_0x00a3:
            android.graphics.Typeface r10 = createFromFamiliesWithDefault(r11)
            android.graphics.Typeface r10 = android.graphics.Typeface.create(r10, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }
}
