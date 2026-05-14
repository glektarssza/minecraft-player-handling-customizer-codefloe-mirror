package com.glektarssza.player_handling_customizer.api.functional.suppliers;

/**
 * An interface which defines a function that accepts three arguments and
 * returns a value.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <T3> The type of the third argument.
 * @param <R> The type of the return value.
 */
public interface TrinarySupplier<T1, T2, T3, R> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     * @param second The second argument.
     * @param third The third argument.
     *
     * @return The return value.
     */
    public R call(T1 first, T2 second, T3 third);
}
