package com.glektarssza.player_handling_customizer.api.functional.suppliers;

/**
 * An interface which defines a function that accepts two arguments and returns
 * a value.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <R> The type of the return value.
 */
public interface BinarySupplier<T1, T2, R> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     * @param second The second argument.
     *
     * @return The return value.
     */
    public void call(T1 first, T2 second);
}
