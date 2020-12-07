package android.support.p000v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v4.app.BaseFragmentActivityApi16 */
public abstract class BaseFragmentActivityApi16 extends BaseFragmentActivityApi14 {
    public boolean mStartedActivityFromFragment;

    @RequiresApi(16)
    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            BaseFragmentActivityApi14.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @RequiresApi(16)
    public void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            BaseFragmentActivityApi14.checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}