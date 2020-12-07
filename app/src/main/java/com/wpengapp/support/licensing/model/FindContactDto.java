package com.wpengapp.support.licensing.model;

import android.support.annotation.Keep;
import java.io.Serializable;

@Keep
public class FindContactDto implements Serializable {
    public String appName;
    public String appPkg;
    public boolean canLogin;
    public boolean changeDevice;
    public String contact;
    public String device;
    public boolean exist;
}
