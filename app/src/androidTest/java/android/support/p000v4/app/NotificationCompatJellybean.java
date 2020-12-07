package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.p000v4.app.NotificationCompat;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
/* renamed from: android.support.v4.app.NotificationCompatJellybean */
public class NotificationCompatJellybean {
    public static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    public static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    public static final String KEY_ACTION_INTENT = "actionIntent";
    public static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    public static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    public static final String KEY_CHOICES = "choices";
    public static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    public static final String KEY_EXTRAS = "extras";
    public static final String KEY_ICON = "icon";
    public static final String KEY_LABEL = "label";
    public static final String KEY_REMOTE_INPUTS = "remoteInputs";
    public static final String KEY_RESULT_KEY = "resultKey";
    public static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    public static Class<?> sActionClass;
    public static Field sActionIconField;
    public static Field sActionIntentField;
    public static Field sActionTitleField;
    public static boolean sActionsAccessFailed;
    public static Field sActionsField;
    public static final Object sActionsLock = new Object();
    public static Field sExtrasField;
    public static boolean sExtrasFieldAccessFailed;
    public static final Object sExtrasLock = new Object();

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                sActionClass = Class.forName("android.app.Notification$Action");
                sActionIconField = sActionClass.getDeclaredField(KEY_ICON);
                sActionTitleField = sActionClass.getDeclaredField(KEY_TITLE);
                sActionIntentField = sActionClass.getDeclaredField(KEY_ACTION_INTENT);
                sActionsField = Notification.class.getDeclaredField(NotificationCompat.WearableExtender.KEY_ACTIONS);
                sActionsField.setAccessible(true);
            }
        } catch (ClassNotFoundException unused) {
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException unused2) {
            sActionsAccessFailed = true;
        }
        return true ^ sActionsAccessFailed;
    }

    public static RemoteInput fromBundle(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString(KEY_RESULT_KEY), bundle.getCharSequence(KEY_LABEL), bundle.getCharSequenceArray(KEY_CHOICES), bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), bundle.getBundle("extras"), hashSet);
    }

    public static RemoteInput[] fromBundleArray(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i = 0; i < bundleArr.length; i++) {
            remoteInputArr[i] = fromBundle(bundleArr[i]);
        }
        return remoteInputArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r5 = r5.getSparseParcelableArray(android.support.p000v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static NotificationCompat.Action getAction(Notification r5, int r6) {
        /*
            java.lang.Object r0 = sActionsLock
            monitor-enter(r0)
            r1 = 0
            java.lang.Object[] r2 = getActionObjectsLocked(r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r2 == 0) goto L_0x0043
            r2 = r2[r6]     // Catch:{ IllegalAccessException -> 0x0040 }
            android.os.Bundle r5 = getExtras(r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r5 == 0) goto L_0x0021
            java.lang.String r3 = "android.support.actionExtras"
            android.util.SparseArray r5 = r5.getSparseParcelableArray(r3)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r5 == 0) goto L_0x0021
            java.lang.Object r5 = r5.get(r6)     // Catch:{ IllegalAccessException -> 0x0040 }
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch:{ IllegalAccessException -> 0x0040 }
            goto L_0x0022
        L_0x0021:
            r5 = r1
        L_0x0022:
            java.lang.reflect.Field r6 = sActionIconField     // Catch:{ IllegalAccessException -> 0x0040 }
            int r6 = r6.getInt(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.reflect.Field r3 = sActionTitleField     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.reflect.Field r4 = sActionIntentField     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2     // Catch:{ IllegalAccessException -> 0x0040 }
            android.support.v4.app.NotificationCompat$Action r5 = readAction(r6, r3, r2, r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r5
        L_0x003e:
            r5 = move-exception
            goto L_0x0045
        L_0x0040:
            r5 = 1
            sActionsAccessFailed = r5     // Catch:{ all -> 0x003e }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r1
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompatJellybean.getAction(android.app.Notification, int):android.support.v4.app.NotificationCompat$Action");
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (sActionsLock) {
            Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
        }
        return length;
    }

    public static NotificationCompat.Action getActionFromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        return new NotificationCompat.Action(bundle.getInt(KEY_ICON), bundle.getCharSequence(KEY_TITLE), (PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle("extras"), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS)), bundle2 != null ? bundle2.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false) : false);
    }

    public static Object[] getActionObjectsLocked(Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) sActionsField.get(notification);
                return objArr;
            } catch (IllegalAccessException unused) {
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    public static Bundle getBundleForAction(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(KEY_ICON, action.getIcon());
        bundle2.putCharSequence(KEY_TITLE, action.getTitle());
        bundle2.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
        return bundle2;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                Bundle bundle = (Bundle) sExtrasField.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sExtrasField.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action readAction(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        if (bundle != null) {
            remoteInputArr2 = fromBundleArray(getBundleArrayFromBundle(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr = fromBundleArray(getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS));
            z = bundle.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
        } else {
            remoteInputArr2 = null;
            remoteInputArr = null;
            z = false;
        }
        return new NotificationCompat.Action(i, charSequence, pendingIntent, bundle, remoteInputArr2, remoteInputArr, z);
    }

    public static Bundle toBundle(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
        bundle.putCharSequence(KEY_LABEL, remoteInput.getLabel());
        bundle.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
        bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList arrayList = new ArrayList(allowedDataTypes.size());
            for (String add : allowedDataTypes) {
                arrayList.add(add);
            }
            bundle.putStringArrayList(KEY_ALLOWED_DATA_TYPES, arrayList);
        }
        return bundle;
    }

    public static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = toBundle(remoteInputArr[i]);
        }
        return bundleArr;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        return bundle;
    }
}