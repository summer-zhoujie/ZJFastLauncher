package com.zj.fastlauncher.utils;

import com.zj.fastlauncher.db.entities.ActCanJump;

import java.util.List;

public class PrintUtils {
    public static <T> String getArrayString(T[] array) {
        if (array == null || array.length <= 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder("[ ");
        for (T t : array) {
            sb.append(t + "; ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static <T> String getListString(List<T> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder("\n[\n ");
        for (T t : list) {
            sb.append(t + ";\n ");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
