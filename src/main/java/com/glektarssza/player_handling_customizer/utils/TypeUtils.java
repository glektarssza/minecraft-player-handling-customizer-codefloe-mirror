package com.glektarssza.player_handling_customizer.utils;

import com.glektarssza.player_handling_customizer.api.annotations.NotNull;
import com.glektarssza.player_handling_customizer.api.annotations.Nullable;

/**
 * A class which provides various utilities for working with classes and types.
 */
public final class TypeUtils {
    /**
     * Ensure that the given value is not a {@code null} value.
     *
     * @param <T> The type of the value to check.
     * @param value The value to check.
     * @param errorMessage The error message to produce a
     *        {@link NullPointerException} with if the {@code value} is
     *        {@code null}.
     *
     * @return The {@code value} if it is not {@code null}.
     *
     * @throws NullPointerException Thrown if the {@code value} is {@code null}.
     */
    @NotNull
    public static <T> T ensureNotNull(
        @Nullable T value,
        @NotNull String errorMessage
    ) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException(errorMessage);
        }
        return value;
    }

    /**
     * Ensure that the given value is not a {@code null} value.
     *
     * @param <T> The type of the value to check.
     * @param value The value to check.
     *
     * @return The {@code value} if it is not {@code null}.
     *
     * @throws NullPointerException Thrown if the {@code value} is {@code null}.
     */
    @NotNull
    public static <T> T ensureNotNull(
        @Nullable T value
    ) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException(
                "Expected value to be not null but got a null value"
            );
        }
        return value;
    }
}
