package com.glektarssza.player_handling_customizer.api.functional.consumers;

/**
 * An interface which defines a function that accepts two arguments and returns
 * no value.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 */
public interface BinaryConsumer<T1, T2> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     * @param second The second argument.
     */
    public void call(T1 first, T2 second);
}
