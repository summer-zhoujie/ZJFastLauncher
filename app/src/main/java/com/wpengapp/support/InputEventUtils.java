package com.wpengapp.support;

import android.support.p000v4.view.InputDeviceCompat;
import android.view.InputDevice;

/* renamed from: com.wpengapp.support.ࡕ */
public class InputEventUtils {

    /* renamed from: ֏ */
    public static final int f2810;

    /* renamed from: ؠ */
    public static final int f2811;

    static {
        int i;
        int i2 = 0;
        try {
            i = Class.forName("android.hardware.input.InputManager").getField("INJECT_INPUT_EVENT_MODE_ASYNC").getInt((Object) null);
        } catch (Exception e) {
            e.getMessage();
            i = 0;
        }
        f2810 = i;
        try {
            Class.forName("android.hardware.input.InputManager").getField("INJECT_INPUT_EVENT_MODE_WAIT_FOR_RESULT").getInt((Object) null);
        } catch (Exception e2) {
            e2.getMessage();
        }
        try {
            Class.forName("android.hardware.input.InputManager").getField("INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH").getInt((Object) null);
        } catch (Exception e3) {
            e3.getMessage();
        }
        int[] deviceIds = InputDevice.getDeviceIds();
        int length = deviceIds.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i4 = deviceIds[i3];
            if (InputDevice.getDevice(i4).supportsSource(InputDeviceCompat.SOURCE_TOUCHSCREEN)) {
                i2 = i4;
                break;
            }
            i3++;
        }
        f2811 = i2;
    }
}
