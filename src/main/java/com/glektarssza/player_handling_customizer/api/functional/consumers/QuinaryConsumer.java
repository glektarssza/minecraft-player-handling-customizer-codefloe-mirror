package com.glektarssza.player_handling_customizer.api.functional.consumers;

/**
 * An interface which defines a function that accepts five arguments and returns
 * no value.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <T3> The type of the third argument.
 * @param <T4> The type of the fourth argument.
 * @param <T5> The type of the fifth argument.
 */
public interface QuinaryConsumer<T1, T2, T3, T4, T5> {
    /**
     * Call the function.
     *
     * @param first The first argument.
     * @param second The second argument.
     * @param third The third argument.
     * @param fourth The fourth argument.
     * @param fifth The fifth argument.
     */
    public void call(T1 first, T2 second, T3 third, T4 fourth, T5 fifth);
}
