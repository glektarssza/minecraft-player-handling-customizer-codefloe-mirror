package com.glektarssza.player_handling_customizer.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that declares a package or class as having all parameters
 * within its scope being annotated with the {@link NotNull} annotation.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({
    ElementType.PACKAGE,
    ElementType.TYPE,
})
public @interface ParametersNotNullByDefault {

}
