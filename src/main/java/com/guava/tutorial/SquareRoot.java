package com.guava.tutorial;

import com.google.common.base.Preconditions;

/**
 * @author dpersa
 */
public class SquareRoot {

    /**
     * Returns the positive square root of the given value.
     *
     * @throws IllegalArgumentException if the value is negative
     */
    public static double sqrt(double value) {
        Preconditions.checkArgument(value >= 0.0, "negative value: %s", value);
        // calculate the square root
        return sqrt(value);
    }
}
