package com.glektarssza.player_handling_customizer.api.functional.suppliers;

/**
 * An interface which defines a function that accepts one argument and returns a
 * value.
 *
 * @param <T1> The type of the first argument.
 * @param <R> The type of the return value.
 */
public interface UnarySupplier<T1, R> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     *
     * @return The return value.
     */
    public R call(T1 first);
}
