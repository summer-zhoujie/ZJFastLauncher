package com.wpengapp.support;

import android.support.p000v4.text.BidiFormatter;
import android.text.InputFilter;
import android.text.Spanned;
import com.wpengapp.support.backup.p005ui.BackupActivity;
import java.util.regex.Pattern;

/* renamed from: com.wpengapp.support.વ */
/* compiled from: BackupActivity */
class C1118 implements InputFilter {
    public C1118(BackupActivity backupActivity) {
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Pattern.compile("[a-zA-Z|0-9|一-龥]+").matcher(charSequence.toString()).matches()) {
            return BidiFormatter.EMPTY_STRING;
        }
        return null;
    }
}
