package com.wpengapp.support;

import com.wpengapp.support.Lifecycle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.wpengapp.support.ޒ */
public @interface OnLifecycleEvent {
    Lifecycle.C0955 value();
}
