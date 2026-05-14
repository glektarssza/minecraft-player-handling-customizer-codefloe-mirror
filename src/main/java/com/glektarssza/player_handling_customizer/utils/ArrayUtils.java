package com.glektarssza.player_handling_customizer.utils;

/**
 * A collection of utilities for working with arrays.
 */
public final class ArrayUtils {
    /**
     * Join the elements of an array together into a string, connected by the
     * given joiner string.
     *
     * @param <T> The type of the elements in the array.
     * @param array The array to join the elements of.
     * @param joiner The string to join the array elements with.
     *
     * @return The joined array elements, as a string.
     */
    public static <T> String join(T[] array, String joiner) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        if (++i < array.length) {
            sb.append(array[i].toString());
        }
        while (++i < array.length) {
            sb.append(joiner);
            sb.append(array[i].toString());
        }
        return sb.toString();
    }
}
