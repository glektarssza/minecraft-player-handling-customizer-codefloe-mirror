package com.glektarssza.player_handling_customizer.api.functional.consumers;

/**
 * An interface which defines a function that accepts three arguments and
 * returns no value.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <T3> The type of the third argument.
 */
public interface TrinaryConsumer<T1, T2, T3> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     * @param second The second argument.
     * @param third The third argument.
     */
    public void call(T1 first, T2 second, T3 third);
}
