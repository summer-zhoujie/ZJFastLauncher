package com.wpengapp.lightstart.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import com.wpengapp.baseui.widget.SwitchButton;
import com.wpengapp.lightstart.R$id;
import com.wpengapp.lightstart.activity.CustomRuleEditActivity;
import com.wpengapp.support.C0958;

public class CustomRuleEditActivity_ViewBinding<T extends CustomRuleEditActivity> implements Unbinder {
    @UiThread
    public CustomRuleEditActivity_ViewBinding(T t, View view) {
        t.mTvApp = (TextView) C0958.m2538(view, R$id.tv_app, "field 'mTvApp'", TextView.class);
        t.mTvPage = (TextView) C0958.m2538(view, R$id.tv_page, "field 'mTvPage'", TextView.class);
        t.mEtNote = (EditText) C0958.m2538(view, 2131165286, "field 'mEtNote'", EditText.class);
        t.mRadioGroupAction = (RadioGroup) C0958.m2538(view, R$id.radio_group_action, "field 'mRadioGroupAction'", RadioGroup.class);
        t.mEtDelay = (EditText) C0958.m2538(view, R$id.et_delay, "field 'mEtDelay'", EditText.class);
        t.mEtBtnText = (EditText) C0958.m2538(view, R$id.et_btn_text, "field 'mEtBtnText'", EditText.class);
        t.mSwitchButton = (SwitchButton) C0958.m2538(view, 2131165475, "field 'mSwitchButton'", SwitchButton.class);
        t.mTvStatus = (TextView) C0958.m2538(view, 2131165548, "field 'mTvStatus'", TextView.class);
        t.mCbLoop = (CheckBox) C0958.m2538(view, R$id.cb_loop, "field 'mCbLoop'", CheckBox.class);
        t.mCbDaily = (CheckBox) C0958.m2538(view, R$id.cb_daily, "field 'mCbDaily'", CheckBox.class);
    }
}
