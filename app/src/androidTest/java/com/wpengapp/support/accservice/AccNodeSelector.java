package com.wpengapp.support.accservice;

import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.wpengapp.support.AccServiceHelper;
import com.wpengapp.support.outline;
import java.io.Serializable;
import java.util.Objects;

@Keep
public class AccNodeSelector implements Serializable {
    public static final String TAG = "AccNodeSelector";
    public static final long serialVersionUID = -7755162995496909498L;
    public String classList;
    public boolean clickable;
    public String indexList;
    public String packageName;

    public AccNodeSelector() {
    }

    public static int getChildIndex(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo2.equals(accessibilityNodeInfo.getChild(i))) {
                return i;
            }
        }
        return -1;
    }

    public static AccessibilityNodeInfo getNode(AccessibilityNodeInfo accessibilityNodeInfo, AccNodeSelector accNodeSelector) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.equals(accNodeSelector.packageName, accessibilityNodeInfo.getPackageName())) {
                return null;
            }
            String[] split = accNodeSelector.indexList.split(",");
            String[] split2 = accNodeSelector.classList.split(",");
            if (!TextUtils.equals(accessibilityNodeInfo.getClassName(), split2[0])) {
                return null;
            }
            int i = 1;
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
            while (true) {
                if (i >= split.length) {
                    break;
                }
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt < 0) {
                    break;
                } else if (parseInt >= accessibilityNodeInfo2.getChildCount()) {
                    break;
                } else {
                    accessibilityNodeInfo2 = accessibilityNodeInfo2.getChild(parseInt);
                    if (accessibilityNodeInfo2 == null) {
                        break;
                    } else if (!TextUtils.equals(accessibilityNodeInfo2.getClassName(), split2[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            accessibilityNodeInfo2 = null;
            if (accessibilityNodeInfo2 != null) {
                System.currentTimeMillis();
                return accessibilityNodeInfo2;
            }
            "getNodeBySelector.classList " + (System.currentTimeMillis() - currentTimeMillis) + "ms";
            return getNodeByClassList(accessibilityNodeInfo, split2, 0);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static AccessibilityNodeInfo getNodeByClassList(AccessibilityNodeInfo accessibilityNodeInfo, String[] strArr, int i) {
        if (!TextUtils.equals(strArr[i], accessibilityNodeInfo.getClassName())) {
            return null;
        }
        int i2 = i + 1;
        if (strArr.length == i2) {
            return accessibilityNodeInfo;
        }
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            AccessibilityNodeInfo nodeByClassList = getNodeByClassList(accessibilityNodeInfo.getChild(i3), strArr, i2);
            if (nodeByClassList != null) {
                return nodeByClassList;
            }
        }
        return null;
    }

    public static AccNodeSelector getSelector(AccessibilityNodeInfo accessibilityNodeInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        AccNodeSelector accNodeSelector = new AccNodeSelector();
        try {
            accNodeSelector.packageName = String.valueOf(accessibilityNodeInfo.getPackageName());
            accNodeSelector.clickable = accessibilityNodeInfo.isClickable();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
            while (true) {
                if (accessibilityNodeInfo2 == null) {
                    break;
                }
                AccessibilityNodeInfo parent = accessibilityNodeInfo2.getParent();
                if (AccServiceHelper.m2007(i, accessibilityNodeInfo2, parent) != null) {
                    break;
                }
                i++;
                int childIndex = getChildIndex(parent, accessibilityNodeInfo2);
                if (sb.length() == 0) {
                    sb.insert(0, childIndex);
                    sb2.insert(0, accessibilityNodeInfo2.getClassName());
                } else {
                    sb.insert(0, childIndex + ",");
                    sb2.insert(0, accessibilityNodeInfo2.getClassName() + ",");
                }
                accessibilityNodeInfo2 = parent;
            }
            accNodeSelector.indexList = sb.toString();
            accNodeSelector.classList = sb2.toString();
            AccessibilityNodeInfo node = getNode(AccServiceHelper.m2008(accessibilityNodeInfo), accNodeSelector);
            System.currentTimeMillis();
            if (accessibilityNodeInfo.equals(node)) {
                return accNodeSelector;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        "getSelector fail[" + (System.currentTimeMillis() - currentTimeMillis) + "ms]: " + accNodeSelector;
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AccNodeSelector.class != obj.getClass()) {
            return false;
        }
        AccNodeSelector accNodeSelector = (AccNodeSelector) obj;
        if (this.clickable != accNodeSelector.clickable || !Objects.equals(this.packageName, accNodeSelector.packageName) || !Objects.equals(this.indexList, accNodeSelector.indexList) || !Objects.equals(this.classList, accNodeSelector.classList)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.packageName, Boolean.valueOf(this.clickable), this.indexList, this.classList});
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("AccNodeSelector{packageName='");
        r0.append(this.packageName);
        r0.append('\'');
        r0.append(", clickable=");
        r0.append(this.clickable);
        r0.append(", indexList='");
        r0.append(this.indexList);
        r0.append('\'');
        r0.append(", classList='");
        r0.append(this.classList);
        r0.append('\'');
        r0.append('}');
        return r0.toString();
    }

    public AccNodeSelector(AccNodeSelector accNodeSelector) {
        this.packageName = accNodeSelector.packageName;
        this.clickable = accNodeSelector.clickable;
        this.indexList = accNodeSelector.indexList;
        this.classList = accNodeSelector.classList;
    }
}
