package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.compat.C0003R;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.v4.app.NotificationCompat */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* renamed from: android.support.v4.app.NotificationCompat$Action */
    public static class Action {
        public PendingIntent actionIntent;
        public int icon;
        public boolean mAllowGeneratedReplies;
        public final RemoteInput[] mDataOnlyRemoteInputs;
        public final Bundle mExtras;
        public final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Builder */
        public static final class Builder {
            public boolean mAllowGeneratedReplies;
            public final Bundle mExtras;
            public final int mIcon;
            public final PendingIntent mIntent;
            public ArrayList<RemoteInput> mRemoteInputs;
            public final CharSequence mTitle;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true);
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Action build() {
                /*
                    r12 = this;
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList<android.support.v4.app.RemoteInput> r2 = r12.mRemoteInputs
                    if (r2 == 0) goto L_0x002c
                    java.util.Iterator r2 = r2.iterator()
                L_0x0012:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x002c
                    java.lang.Object r3 = r2.next()
                    android.support.v4.app.RemoteInput r3 = (android.support.p000v4.app.RemoteInput) r3
                    boolean r4 = r3.isDataOnly()
                    if (r4 == 0) goto L_0x0028
                    r0.add(r3)
                    goto L_0x0012
                L_0x0028:
                    r1.add(r3)
                    goto L_0x0012
                L_0x002c:
                    boolean r2 = r0.isEmpty()
                    r3 = 0
                    if (r2 == 0) goto L_0x0035
                    r10 = r3
                    goto L_0x0042
                L_0x0035:
                    int r2 = r0.size()
                    android.support.v4.app.RemoteInput[] r2 = new android.support.p000v4.app.RemoteInput[r2]
                    java.lang.Object[] r0 = r0.toArray(r2)
                    android.support.v4.app.RemoteInput[] r0 = (android.support.p000v4.app.RemoteInput[]) r0
                    r10 = r0
                L_0x0042:
                    boolean r0 = r1.isEmpty()
                    if (r0 == 0) goto L_0x0049
                    goto L_0x0056
                L_0x0049:
                    int r0 = r1.size()
                    android.support.v4.app.RemoteInput[] r0 = new android.support.p000v4.app.RemoteInput[r0]
                    java.lang.Object[] r0 = r1.toArray(r0)
                    r3 = r0
                    android.support.v4.app.RemoteInput[] r3 = (android.support.p000v4.app.RemoteInput[]) r3
                L_0x0056:
                    r9 = r3
                    android.support.v4.app.NotificationCompat$Action r0 = new android.support.v4.app.NotificationCompat$Action
                    int r5 = r12.mIcon
                    java.lang.CharSequence r6 = r12.mTitle
                    android.app.PendingIntent r7 = r12.mIntent
                    android.os.Bundle r8 = r12.mExtras
                    boolean r11 = r12.mAllowGeneratedReplies
                    r4 = r0
                    r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompat.Action.Builder.build():android.support.v4.app.NotificationCompat$Action");
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.mAllowGeneratedReplies = z;
                return this;
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies());
            }

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z) {
                ArrayList<RemoteInput> arrayList;
                this.mAllowGeneratedReplies = true;
                this.mIcon = i;
                this.mTitle = Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputArr));
                }
                this.mRemoteInputs = arrayList;
                this.mAllowGeneratedReplies = z;
            }
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Extender */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$WearableExtender */
        public static final class WearableExtender implements Extender {
            public static final int DEFAULT_FLAGS = 1;
            public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            public static final int FLAG_AVAILABLE_OFFLINE = 1;
            public static final int FLAG_HINT_DISPLAY_INLINE = 4;
            public static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            public static final String KEY_CANCEL_LABEL = "cancelLabel";
            public static final String KEY_CONFIRM_LABEL = "confirmLabel";
            public static final String KEY_FLAGS = "flags";
            public static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            public CharSequence mCancelLabel;
            public CharSequence mConfirmLabel;
            public int mFlags = 1;
            public CharSequence mInProgressLabel;

            public WearableExtender() {
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags = i | this.mFlags;
                    return;
                }
                this.mFlags = (~i) & this.mFlags;
            }

            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.mFlags;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                CharSequence charSequence2 = this.mConfirmLabel;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                }
                CharSequence charSequence3 = this.mCancelLabel;
                if (charSequence3 != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                setFlag(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                setFlag(2, z);
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            public WearableExtender(Action action) {
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.mFlags = bundle.getInt("flags", 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z) {
            this.icon = i;
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$BadgeIconType */
    public @interface BadgeIconType {
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigPictureStyle */
    public static class BigPictureStyle extends Style {
        public Bitmap mBigLargeIcon;
        public boolean mBigLargeIconSet;
        public Bitmap mPicture;

        public BigPictureStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
            if (this.mBigLargeIconSet) {
                bigPicture.bigLargeIcon(this.mBigLargeIcon);
            }
            if (this.mSummaryTextSet) {
                bigPicture.setSummaryText(this.mSummaryText);
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigTextStyle */
    public static class BigTextStyle extends Style {
        public CharSequence mBigText;

        public BigTextStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                bigText.setSummaryText(this.mSummaryText);
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Builder */
    public static class Builder {
        public static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ArrayList<Action> mActions;
        public int mBadgeIcon;
        public RemoteViews mBigContentView;
        public String mCategory;
        public String mChannelId;
        public int mColor;
        public boolean mColorized;
        public boolean mColorizedSet;
        public CharSequence mContentInfo;
        public PendingIntent mContentIntent;
        public CharSequence mContentText;
        public CharSequence mContentTitle;
        public RemoteViews mContentView;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Context mContext;
        public Bundle mExtras;
        public PendingIntent mFullScreenIntent;
        public int mGroupAlertBehavior;
        public String mGroupKey;
        public boolean mGroupSummary;
        public RemoteViews mHeadsUpContentView;
        public Bitmap mLargeIcon;
        public boolean mLocalOnly;
        public Notification mNotification;
        public int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        public int mPriority;
        public int mProgress;
        public boolean mProgressIndeterminate;
        public int mProgressMax;
        public Notification mPublicVersion;
        public CharSequence[] mRemoteInputHistory;
        public String mShortcutId;
        public boolean mShowWhen;
        public String mSortKey;
        public Style mStyle;
        public CharSequence mSubText;
        public RemoteViews mTickerView;
        public long mTimeout;
        public boolean mUseChronometer;
        public int mVisibility;

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mNotification = new Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
        }

        public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, MAX_CHARSEQUENCE_LENGTH) : charSequence;
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                Notification notification = this.mNotification;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.mNotification;
            notification2.flags = (~i) & notification2.flags;
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.mExtras;
                if (bundle2 == null) {
                    this.mExtras = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0;
        }

        public Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        public Builder setBadgeIconType(int i) {
            this.mBadgeIcon = i;
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setChannelId(@NonNull String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public Builder setColorized(boolean z) {
            this.mColorized = z;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        public Builder setDefaults(int i) {
            Notification notification = this.mNotification;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.mGroupKey = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i) {
            this.mGroupAlertBehavior = i;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(@ColorInt int i, int i2, int i3) {
            Notification notification = this.mNotification;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            int i4 = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.mNotification;
            notification2.flags = i4 | (notification2.flags & -2);
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        public Builder setShortcutId(String str) {
            this.mShortcutId = str;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public Builder setSortKey(String str) {
            this.mSortKey = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            int i = Build.VERSION.SDK_INT;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                Style style2 = this.mStyle;
                if (style2 != null) {
                    style2.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTimeoutAfter(long j) {
            this.mTimeout = j;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            Notification notification = this.mNotification;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i;
            int i2 = Build.VERSION.SDK_INT;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, (String) null);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$DecoratedCustomViewStyle */
    public static class DecoratedCustomViewStyle extends Style {
        public static final int MAX_ACTION_BUTTONS = 3;

        private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z) {
            ArrayList<Action> arrayList;
            int min;
            boolean z2 = true;
            int i = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, C0003R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(C0003R.C0005id.actions);
            if (!z || (arrayList = this.mBuilder.mActions) == null || (min = Math.min(arrayList.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i2 = 0; i2 < min; i2++) {
                    applyStandardTemplate.addView(C0003R.C0005id.actions, generateActionButton(this.mBuilder.mActions.get(i2)));
                }
            }
            if (!z2) {
                i = 8;
            }
            applyStandardTemplate.setViewVisibility(C0003R.C0005id.actions, i);
            applyStandardTemplate.setViewVisibility(C0003R.C0005id.action_divider, i);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), z ? C0003R.layout.notification_action_tombstone : C0003R.layout.notification_action);
            remoteViews.setImageViewBitmap(C0003R.C0005id.action_image, createColoredBitmap(action.getIcon(), this.mBuilder.mContext.getResources().getColor(C0003R.color.notification_action_color_filter)));
            remoteViews.setTextViewText(C0003R.C0005id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(C0003R.C0005id.action_container, action.actionIntent);
            }
            int i = Build.VERSION.SDK_INT;
            remoteViews.setContentDescription(C0003R.C0005id.action_container, action.title);
            return remoteViews;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return createRemoteViews(bigContentView, true);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            if (headsUpContentView != null) {
                remoteViews = headsUpContentView;
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (headsUpContentView == null) {
                return null;
            }
            return createRemoteViews(remoteViews, true);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Extender */
    public interface Extender {
        Builder extend(Builder builder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$GroupAlertBehavior */
    public @interface GroupAlertBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationVisibility */
    public @interface NotificationVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$StreamType */
    public @interface StreamType {
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Style */
    public static abstract class Style {
        public CharSequence mBigContentTitle;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder mBuilder;
        public CharSequence mSummaryText;
        public boolean mSummaryTextSet = false;

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0003R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0003R.dimen.notification_top_pad_large_text);
            float constrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round((constrain * ((float) dimensionPixelSize2)) + ((1.0f - constrain) * ((float) dimensionPixelSize)));
        }

        public static float constrain(float f, float f2, float f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }

        private Bitmap createIconWithBackground(int i, int i2, int i3, int i4) {
            int i5 = C0003R.C0004drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap createColoredBitmap = createColoredBitmap(i5, i4, i2);
            Canvas canvas = new Canvas(createColoredBitmap);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return createColoredBitmap;
        }

        private void hideNormalContent(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(C0003R.C0005id.title, 8);
            remoteViews.setViewVisibility(C0003R.C0005id.text2, 8);
            remoteViews.setViewVisibility(C0003R.C0005id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void addCompatExtras(Bundle bundle) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x012f  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0155  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0194  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0199  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01a5  */
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RemoteViews applyStandardTemplate(boolean r12, int r13, boolean r14) {
            /*
                r11 = this;
                android.support.v4.app.NotificationCompat$Builder r0 = r11.mBuilder
                android.content.Context r0 = r0.mContext
                android.content.res.Resources r0 = r0.getResources()
                android.widget.RemoteViews r7 = new android.widget.RemoteViews
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                android.content.Context r1 = r1.mContext
                java.lang.String r1 = r1.getPackageName()
                r7.<init>(r1, r13)
                android.support.v4.app.NotificationCompat$Builder r13 = r11.mBuilder
                int r13 = r13.getPriority()
                r1 = -1
                int r13 = android.os.Build.VERSION.SDK_INT
                android.support.v4.app.NotificationCompat$Builder r13 = r11.mBuilder
                android.graphics.Bitmap r1 = r13.mLargeIcon
                r8 = 0
                if (r1 == 0) goto L_0x0068
                int r13 = android.support.compat.C0003R.C0005id.icon
                r7.setViewVisibility(r13, r8)
                int r13 = android.support.compat.C0003R.C0005id.icon
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                android.graphics.Bitmap r1 = r1.mLargeIcon
                r7.setImageViewBitmap(r13, r1)
                if (r12 == 0) goto L_0x009d
                android.support.v4.app.NotificationCompat$Builder r12 = r11.mBuilder
                android.app.Notification r12 = r12.mNotification
                int r12 = r12.icon
                if (r12 == 0) goto L_0x009d
                int r12 = android.support.compat.C0003R.dimen.notification_right_icon_size
                int r12 = r0.getDimensionPixelSize(r12)
                int r13 = android.support.compat.C0003R.dimen.notification_small_icon_background_padding
                int r13 = r0.getDimensionPixelSize(r13)
                int r13 = r13 * 2
                int r13 = r12 - r13
                int r1 = android.os.Build.VERSION.SDK_INT
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                android.app.Notification r2 = r1.mNotification
                int r2 = r2.icon
                int r1 = r1.getColor()
                android.graphics.Bitmap r12 = r11.createIconWithBackground(r2, r12, r13, r1)
                int r13 = android.support.compat.C0003R.C0005id.right_icon
                r7.setImageViewBitmap(r13, r12)
                int r12 = android.support.compat.C0003R.C0005id.right_icon
                r7.setViewVisibility(r12, r8)
                goto L_0x009d
            L_0x0068:
                if (r12 == 0) goto L_0x009d
                android.app.Notification r12 = r13.mNotification
                int r12 = r12.icon
                if (r12 == 0) goto L_0x009d
                int r12 = android.support.compat.C0003R.C0005id.icon
                r7.setViewVisibility(r12, r8)
                int r12 = android.os.Build.VERSION.SDK_INT
                int r12 = android.support.compat.C0003R.dimen.notification_large_icon_width
                int r12 = r0.getDimensionPixelSize(r12)
                int r13 = android.support.compat.C0003R.dimen.notification_big_circle_margin
                int r13 = r0.getDimensionPixelSize(r13)
                int r12 = r12 - r13
                int r13 = android.support.compat.C0003R.dimen.notification_small_icon_size_as_large
                int r13 = r0.getDimensionPixelSize(r13)
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                android.app.Notification r2 = r1.mNotification
                int r2 = r2.icon
                int r1 = r1.getColor()
                android.graphics.Bitmap r12 = r11.createIconWithBackground(r2, r12, r13, r1)
                int r13 = android.support.compat.C0003R.C0005id.icon
                r7.setImageViewBitmap(r13, r12)
            L_0x009d:
                android.support.v4.app.NotificationCompat$Builder r12 = r11.mBuilder
                java.lang.CharSequence r12 = r12.mContentTitle
                if (r12 == 0) goto L_0x00a8
                int r13 = android.support.compat.C0003R.C0005id.title
                r7.setTextViewText(r13, r12)
            L_0x00a8:
                android.support.v4.app.NotificationCompat$Builder r12 = r11.mBuilder
                java.lang.CharSequence r12 = r12.mContentText
                r13 = 1
                if (r12 == 0) goto L_0x00b6
                int r1 = android.support.compat.C0003R.C0005id.text
                r7.setTextViewText(r1, r12)
                r12 = 1
                goto L_0x00b7
            L_0x00b6:
                r12 = 0
            L_0x00b7:
                int r1 = android.os.Build.VERSION.SDK_INT
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                java.lang.CharSequence r2 = r1.mContentInfo
                r9 = 8
                if (r2 == 0) goto L_0x00ce
                int r12 = android.support.compat.C0003R.C0005id.info
                r7.setTextViewText(r12, r2)
                int r12 = android.support.compat.C0003R.C0005id.info
                r7.setViewVisibility(r12, r8)
            L_0x00cb:
                r12 = 1
                r10 = 1
                goto L_0x0108
            L_0x00ce:
                int r1 = r1.mNumber
                if (r1 <= 0) goto L_0x0102
                int r12 = android.support.compat.C0003R.integer.status_bar_notification_info_maxnum
                int r12 = r0.getInteger(r12)
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                int r1 = r1.mNumber
                if (r1 <= r12) goto L_0x00ea
                int r12 = android.support.compat.C0003R.C0005id.info
                int r1 = android.support.compat.C0003R.string.status_bar_notification_info_overflow
                java.lang.String r1 = r0.getString(r1)
                r7.setTextViewText(r12, r1)
                goto L_0x00fc
            L_0x00ea:
                java.text.NumberFormat r12 = java.text.NumberFormat.getIntegerInstance()
                int r1 = android.support.compat.C0003R.C0005id.info
                android.support.v4.app.NotificationCompat$Builder r2 = r11.mBuilder
                int r2 = r2.mNumber
                long r2 = (long) r2
                java.lang.String r12 = r12.format(r2)
                r7.setTextViewText(r1, r12)
            L_0x00fc:
                int r12 = android.support.compat.C0003R.C0005id.info
                r7.setViewVisibility(r12, r8)
                goto L_0x00cb
            L_0x0102:
                int r1 = android.support.compat.C0003R.C0005id.info
                r7.setViewVisibility(r1, r9)
                r10 = 0
            L_0x0108:
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                java.lang.CharSequence r1 = r1.mSubText
                if (r1 == 0) goto L_0x012c
                int r2 = android.os.Build.VERSION.SDK_INT
                int r2 = android.support.compat.C0003R.C0005id.text
                r7.setTextViewText(r2, r1)
                android.support.v4.app.NotificationCompat$Builder r1 = r11.mBuilder
                java.lang.CharSequence r1 = r1.mContentText
                if (r1 == 0) goto L_0x0127
                int r2 = android.support.compat.C0003R.C0005id.text2
                r7.setTextViewText(r2, r1)
                int r1 = android.support.compat.C0003R.C0005id.text2
                r7.setViewVisibility(r1, r8)
                r1 = 1
                goto L_0x012d
            L_0x0127:
                int r1 = android.support.compat.C0003R.C0005id.text2
                r7.setViewVisibility(r1, r9)
            L_0x012c:
                r1 = 0
            L_0x012d:
                if (r1 == 0) goto L_0x0149
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r14 == 0) goto L_0x013f
                int r14 = android.support.compat.C0003R.dimen.notification_subtext_size
                int r14 = r0.getDimensionPixelSize(r14)
                float r14 = (float) r14
                int r0 = android.support.compat.C0003R.C0005id.text
                r7.setTextViewTextSize(r0, r8, r14)
            L_0x013f:
                int r2 = android.support.compat.C0003R.C0005id.line1
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r1 = r7
                r1.setViewPadding(r2, r3, r4, r5, r6)
            L_0x0149:
                android.support.v4.app.NotificationCompat$Builder r14 = r11.mBuilder
                long r0 = r14.getWhenIfShowing()
                r2 = 0
                int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r14 == 0) goto L_0x0194
                android.support.v4.app.NotificationCompat$Builder r14 = r11.mBuilder
                boolean r14 = r14.mUseChronometer
                if (r14 == 0) goto L_0x0181
                int r14 = android.os.Build.VERSION.SDK_INT
                int r14 = android.support.compat.C0003R.C0005id.chronometer
                r7.setViewVisibility(r14, r8)
                int r14 = android.support.compat.C0003R.C0005id.chronometer
                android.support.v4.app.NotificationCompat$Builder r0 = r11.mBuilder
                long r0 = r0.getWhenIfShowing()
                long r2 = android.os.SystemClock.elapsedRealtime()
                long r4 = java.lang.System.currentTimeMillis()
                long r2 = r2 - r4
                long r2 = r2 + r0
                java.lang.String r0 = "setBase"
                r7.setLong(r14, r0, r2)
                int r14 = android.support.compat.C0003R.C0005id.chronometer
                java.lang.String r0 = "setStarted"
                r7.setBoolean(r14, r0, r13)
                goto L_0x0195
            L_0x0181:
                int r14 = android.support.compat.C0003R.C0005id.time
                r7.setViewVisibility(r14, r8)
                int r14 = android.support.compat.C0003R.C0005id.time
                android.support.v4.app.NotificationCompat$Builder r0 = r11.mBuilder
                long r0 = r0.getWhenIfShowing()
                java.lang.String r2 = "setTime"
                r7.setLong(r14, r2, r0)
                goto L_0x0195
            L_0x0194:
                r13 = r10
            L_0x0195:
                int r14 = android.support.compat.C0003R.C0005id.right_side
                if (r13 == 0) goto L_0x019b
                r13 = 0
                goto L_0x019d
            L_0x019b:
                r13 = 8
            L_0x019d:
                r7.setViewVisibility(r14, r13)
                int r13 = android.support.compat.C0003R.C0005id.line3
                if (r12 == 0) goto L_0x01a5
                goto L_0x01a7
            L_0x01a5:
                r8 = 8
            L_0x01a7:
                r7.setViewVisibility(r13, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            hideNormalContent(remoteViews);
            remoteViews.removeAllViews(C0003R.C0005id.notification_main_column);
            remoteViews.addView(C0003R.C0005id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(C0003R.C0005id.notification_main_column, 0);
            int i = Build.VERSION.SDK_INT;
            remoteViews.setViewPadding(C0003R.C0005id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bitmap createColoredBitmap(int i, int i2) {
            return createColoredBitmap(i, i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void restoreFromCompatExtras(Bundle bundle) {
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                Builder builder2 = this.mBuilder;
                if (builder2 != null) {
                    builder2.setStyle(this);
                }
            }
        }

        private Bitmap createColoredBitmap(int i, int i2, int i3) {
            Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(i);
            int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            drawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            }
            drawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$WearableExtender */
    public static final class WearableExtender implements Extender {
        public static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        public static final int DEFAULT_FLAGS = 1;
        public static final int DEFAULT_GRAVITY = 80;
        public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        public static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        public static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        public static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        public static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        public static final int FLAG_HINT_HIDE_ICON = 2;
        public static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        public static final int FLAG_START_SCROLL_BOTTOM = 8;
        public static final String KEY_ACTIONS = "actions";
        public static final String KEY_BACKGROUND = "background";
        public static final String KEY_BRIDGE_TAG = "bridgeTag";
        public static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        public static final String KEY_CONTENT_ICON = "contentIcon";
        public static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        public static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        public static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        public static final String KEY_DISMISSAL_ID = "dismissalId";
        public static final String KEY_DISPLAY_INTENT = "displayIntent";
        public static final String KEY_FLAGS = "flags";
        public static final String KEY_GRAVITY = "gravity";
        public static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        public static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        public ArrayList<Action> mActions = new ArrayList<>();
        public Bitmap mBackground;
        public String mBridgeTag;
        public int mContentActionIndex = -1;
        public int mContentIcon;
        public int mContentIconGravity = 8388613;
        public int mCustomContentHeight;
        public int mCustomSizePreset = 0;
        public String mDismissalId;
        public PendingIntent mDisplayIntent;
        public int mFlags = 1;
        public int mGravity = 80;
        public int mHintScreenTimeout;
        public ArrayList<Notification> mPages = new ArrayList<>();

        public WearableExtender() {
        }

        @RequiresApi(20)
        public static Notification.Action getActionFromActionCompat(Action action) {
            Bundle bundle;
            Notification.Action.Builder builder = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
            if (action.getExtras() != null) {
                bundle = new Bundle(action.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (RemoteInput addRemoteInput : RemoteInput.fromCompat(remoteInputs)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            return builder.build();
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags = i | this.mFlags;
                return;
            }
            this.mFlags = (~i) & this.mFlags;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                int i = Build.VERSION.SDK_INT;
                ArrayList arrayList = new ArrayList(this.mActions.size());
                Iterator<Action> it = this.mActions.iterator();
                while (it.hasNext()) {
                    int i2 = Build.VERSION.SDK_INT;
                    arrayList.add(getActionFromActionCompat(it.next()));
                }
                bundle.putParcelableArrayList(KEY_ACTIONS, arrayList);
            }
            int i3 = this.mFlags;
            if (i3 != 1) {
                bundle.putInt("flags", i3);
            }
            PendingIntent pendingIntent = this.mDisplayIntent;
            if (pendingIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
            }
            if (!this.mPages.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.mPages;
                bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.mBackground;
            if (bitmap != null) {
                bundle.putParcelable(KEY_BACKGROUND, bitmap);
            }
            int i4 = this.mContentIcon;
            if (i4 != 0) {
                bundle.putInt(KEY_CONTENT_ICON, i4);
            }
            int i5 = this.mContentIconGravity;
            if (i5 != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i5);
            }
            int i6 = this.mContentActionIndex;
            if (i6 != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, i6);
            }
            int i7 = this.mCustomSizePreset;
            if (i7 != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i7);
            }
            int i8 = this.mCustomContentHeight;
            if (i8 != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i8);
            }
            int i9 = this.mGravity;
            if (i9 != 80) {
                bundle.putInt(KEY_GRAVITY, i9);
            }
            int i10 = this.mHintScreenTimeout;
            if (i10 != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i10);
            }
            String str = this.mDismissalId;
            if (str != null) {
                bundle.putString(KEY_DISMISSAL_ID, str);
            }
            String str2 = this.mBridgeTag;
            if (str2 != null) {
                bundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.mBridgeTag = str;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        public WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.mDismissalId = str;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        public WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public WearableExtender setHintAmbientBigPicture(boolean z) {
            setFlag(32, z);
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            setFlag(64, z);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList<>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList<>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        public WearableExtender(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_ACTIONS);
                int i = Build.VERSION.SDK_INT;
                if (parcelableArrayList != null) {
                    Action[] actionArr = new Action[parcelableArrayList.size()];
                    for (int i2 = 0; i2 < actionArr.length; i2++) {
                        int i3 = Build.VERSION.SDK_INT;
                        actionArr[i2] = NotificationCompat.getActionCompatFromAction((Notification.Action) parcelableArrayList.get(i2));
                    }
                    Collections.addAll(this.mActions, actionArr);
                }
                this.mFlags = bundle.getInt("flags", 1);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }
    }

    public static Action getAction(Notification notification, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return getActionCompatFromAction(notification.actions[i]);
    }

    @RequiresApi(20)
    public static Action getActionCompatFromAction(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        boolean z2 = false;
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i = 0; i < remoteInputs.length; i++) {
                RemoteInput remoteInput = remoteInputs[i];
                remoteInputArr2[i] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), (Set<String>) null);
            }
            remoteInputArr = remoteInputArr2;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (action.getExtras().getBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES) || action.getAllowGeneratedReplies()) {
                z2 = true;
            }
            z = z2;
        } else {
            z = action.getExtras().getBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES);
        }
        return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z);
    }

    public static int getActionCount(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static String getCategory(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static Bundle getExtras(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return notification.getGroup();
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    public static boolean getLocalOnly(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return (notification.flags & 256) != 0;
    }

    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            notificationArr[i] = (Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static String getSortKey(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return notification.getSortKey();
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        return (notification.flags & 512) != 0;
    }

    /* renamed from: android.support.v4.app.NotificationCompat$CarExtender */
    public static final class CarExtender implements Extender {
        public static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        public static final String EXTRA_COLOR = "app_color";
        public static final String EXTRA_CONVERSATION = "car_conversation";
        public static final String EXTRA_LARGE_ICON = "large_icon";
        public static final String KEY_AUTHOR = "author";
        public static final String KEY_MESSAGES = "messages";
        public static final String KEY_ON_READ = "on_read";
        public static final String KEY_ON_REPLY = "on_reply";
        public static final String KEY_PARTICIPANTS = "participants";
        public static final String KEY_REMOTE_INPUT = "remote_input";
        public static final String KEY_TEXT = "text";
        public static final String KEY_TIMESTAMP = "timestamp";
        public int mColor = 0;
        public Bitmap mLargeIcon;
        public UnreadConversation mUnreadConversation;

        /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation */
        public static class UnreadConversation {
            public final long mLatestTimestamp;
            public final String[] mMessages;
            public final String[] mParticipants;
            public final PendingIntent mReadPendingIntent;
            public final RemoteInput mRemoteInput;
            public final PendingIntent mReplyPendingIntent;

            /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder */
            public static class Builder {
                public long mLatestTimestamp;
                public final List<String> mMessages = new ArrayList();
                public final String mParticipant;
                public PendingIntent mReadPendingIntent;
                public RemoteInput mRemoteInput;
                public PendingIntent mReplyPendingIntent;

                public Builder(String str) {
                    this.mParticipant = str;
                }

                public Builder addMessage(String str) {
                    this.mMessages.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.mMessages;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }

            public UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String[] strArr = this.mParticipants;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
        }

        @RequiresApi(21)
        public static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            Parcelable[] parcelableArr = new Parcelable[unreadConversation.getMessages().length];
            for (int i = 0; i < parcelableArr.length; i++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i]);
                bundle2.putString(KEY_AUTHOR, str);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable(KEY_REMOTE_INPUT, new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
            bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
            bundle.putLong(KEY_TIMESTAMP, unreadConversation.getLatestTimestamp());
            return bundle;
        }

        @RequiresApi(21)
        public static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle bundle) {
            String[] strArr;
            Bundle bundle2 = bundle;
            RemoteInput remoteInput = null;
            if (bundle2 == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle2.getParcelableArray(KEY_MESSAGES);
            if (parcelableArray != null) {
                String[] strArr2 = new String[parcelableArray.length];
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= strArr2.length) {
                        z = true;
                        break;
                    } else if (!(parcelableArray[i] instanceof Bundle)) {
                        break;
                    } else {
                        strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                        if (strArr2[i] == null) {
                            break;
                        }
                        i++;
                    }
                }
                if (!z) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(KEY_ON_READ);
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable(KEY_ON_REPLY);
            RemoteInput remoteInput2 = (RemoteInput) bundle2.getParcelable(KEY_REMOTE_INPUT);
            String[] stringArray = bundle2.getStringArray(KEY_PARTICIPANTS);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput2 != null) {
                remoteInput = new RemoteInput(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), remoteInput2.getExtras(), (Set<String>) null);
            }
            return new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle2.getLong(KEY_TIMESTAMP));
        }

        public Builder extend(Builder builder) {
            int i = Build.VERSION.SDK_INT;
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
            }
            int i2 = this.mColor;
            if (i2 != 0) {
                bundle.putInt(EXTRA_COLOR, i2);
            }
            UnreadConversation unreadConversation = this.mUnreadConversation;
            if (unreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(unreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        public CarExtender(Notification notification) {
            Bundle bundle;
            int i = Build.VERSION.SDK_INT;
            if (NotificationCompat.getExtras(notification) == null) {
                bundle = null;
            } else {
                bundle = NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            }
            if (bundle != null) {
                this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$InboxStyle */
    public static class InboxStyle extends Style {
        public ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                bigContentTitle.setSummaryText(this.mSummaryText);
            }
            Iterator<CharSequence> it = this.mTexts.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$MessagingStyle */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        public CharSequence mConversationTitle;
        public List<Message> mMessages = new ArrayList();
        public CharSequence mUserDisplayName;

        /* renamed from: android.support.v4.app.NotificationCompat$MessagingStyle$Message */
        public static final class Message {
            public static final String KEY_DATA_MIME_TYPE = "type";
            public static final String KEY_DATA_URI = "uri";
            public static final String KEY_EXTRAS_BUNDLE = "extras";
            public static final String KEY_SENDER = "sender";
            public static final String KEY_TEXT = "text";
            public static final String KEY_TIMESTAMP = "time";
            public String mDataMimeType;
            public Uri mDataUri;
            public Bundle mExtras = new Bundle();
            public final CharSequence mSender;
            public final CharSequence mText;
            public final long mTimestamp;

            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this.mText = charSequence;
                this.mTimestamp = j;
                this.mSender = charSequence2;
            }

            public static Bundle[] getBundleArrayForMessages(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).toBundle();
                }
                return bundleArr;
            }

            public static Message getMessageFromBundle(Bundle bundle) {
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey("time")) {
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.getCharSequence(KEY_SENDER));
                            if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                                message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri) bundle.getParcelable(KEY_DATA_URI));
                            }
                            if (bundle.containsKey("extras")) {
                                message.getExtras().putAll(bundle.getBundle("extras"));
                            }
                            return message;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List<Message> getMessagesFromBundleArray(Parcelable[] parcelableArr) {
                Message messageFromBundle;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i = 0; i < parcelableArr.length; i++) {
                    if ((parcelableArr[i] instanceof Bundle) && (messageFromBundle = getMessageFromBundle(parcelableArr[i])) != null) {
                        arrayList.add(messageFromBundle);
                    }
                }
                return arrayList;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.mTimestamp);
                CharSequence charSequence2 = this.mSender;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_SENDER, charSequence2);
                }
                String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, str);
                }
                Uri uri = this.mDataUri;
                if (uri != null) {
                    bundle.putParcelable(KEY_DATA_URI, uri);
                }
                Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public CharSequence getSender() {
                return this.mSender;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String str, Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }
        }

        public MessagingStyle() {
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)) {
                return null;
            }
            try {
                MessagingStyle messagingStyle = new MessagingStyle();
                messagingStyle.restoreFromCompatExtras(extras);
                return messagingStyle;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = this.mMessages.get(size);
                if (!TextUtils.isEmpty(message.getSender())) {
                    return message;
                }
            }
            if (this.mMessages.isEmpty()) {
                return null;
            }
            List<Message> list = this.mMessages;
            return list.get(list.size() - 1);
        }

        private boolean hasMessagesWithoutSender() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                if (this.mMessages.get(size).getSender() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int i) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i), (ColorStateList) null);
        }

        private CharSequence makeMessageLine(Message message) {
            BidiFormatter instance = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i = Build.VERSION.SDK_INT;
            int i2 = 1 != 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence sender = message.getSender();
            boolean isEmpty = TextUtils.isEmpty(message.getSender());
            CharSequence charSequence = BidiFormatter.EMPTY_STRING;
            if (isEmpty) {
                sender = this.mUserDisplayName;
                if (sender == null) {
                    sender = charSequence;
                }
                if (!(1 == 0 || this.mBuilder.getColor() == 0)) {
                    i2 = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = instance.unicodeWrap(sender);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(i2), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence = message.getText();
            }
            spannableStringBuilder.append("  ").append(instance.unicodeWrap(charSequence));
            return spannableStringBuilder;
        }

        public void addCompatExtras(Bundle bundle) {
            CharSequence charSequence = this.mUserDisplayName;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, charSequence);
            }
            CharSequence charSequence2 = this.mConversationTitle;
            if (charSequence2 != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, charSequence2);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.mMessages.add(new Message(charSequence, j, charSequence2));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence charSequence;
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.MessagingStyle conversationTitle = new Notification.MessagingStyle(this.mUserDisplayName).setConversationTitle(this.mConversationTitle);
                for (Message next : this.mMessages) {
                    Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message(next.getText(), next.getTimestamp(), next.getSender());
                    if (next.getDataMimeType() != null) {
                        message.setData(next.getDataMimeType(), next.getDataUri());
                    }
                    conversationTitle.addMessage(message);
                }
                conversationTitle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message findLatestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (findLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(findLatestIncomingMessage.getSender());
            }
            if (findLatestIncomingMessage != null) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                if (this.mConversationTitle != null) {
                    charSequence = makeMessageLine(findLatestIncomingMessage);
                } else {
                    charSequence = findLatestIncomingMessage.getText();
                }
                builder.setContentText(charSequence);
            }
            int i = Build.VERSION.SDK_INT;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = this.mConversationTitle != null || hasMessagesWithoutSender();
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message2 = this.mMessages.get(size);
                CharSequence makeMessageLine = z ? makeMessageLine(message2) : message2.getText();
                if (size != this.mMessages.size() - 1) {
                    spannableStringBuilder.insert(0, "\n");
                }
                spannableStringBuilder.insert(0, makeMessageLine);
            }
            new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle((CharSequence) null).bigText(spannableStringBuilder);
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public CharSequence getUserDisplayName() {
            return this.mUserDisplayName;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void restoreFromCompatExtras(Bundle bundle) {
            this.mMessages.clear();
            this.mUserDisplayName = bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            this.mConversationTitle = bundle.getString(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages = Message.getMessagesFromBundleArray(parcelableArray);
            }
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.mUserDisplayName = charSequence;
        }

        public MessagingStyle addMessage(Message message) {
            this.mMessages.add(message);
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }
    }
}
