package com.glektarssza.player_handling_customizer.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that declares a class, field, method return value, method
 * parameter, or local variable as able to hold a {@code null} value.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({
    ElementType.TYPE,
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.PARAMETER,
    ElementType.LOCAL_VARIABLE
})
public @interface Nullable {}
