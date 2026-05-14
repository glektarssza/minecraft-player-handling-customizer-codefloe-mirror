package com.glektarssza.player_handling_customizer.api.functional.suppliers;

/**
 * An interface which defines a function that accepts no arguments and returns a
 * value.
 *
 * @param <R> The type of the return value.
 */
public interface VoidSupplier<R> {
    /**
     * Call the function.
     *
     * @return The return value.
     */
    public R call();
}
