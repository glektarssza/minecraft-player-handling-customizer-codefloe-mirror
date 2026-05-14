package com.glektarssza.player_handling_customizer.api.functional.consumers;

/**
 * An interface which defines a function that accepts one argument and returns
 * no value.
 *
 * @param <T1> The type of the first argument.
 */
public interface UnaryConsumer<T1> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     */
    public void call(T1 first);
}
