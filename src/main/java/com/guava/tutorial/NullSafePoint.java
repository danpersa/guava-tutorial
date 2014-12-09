package com.guava.tutorial;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;

/**
 * @author  dpersa
 */
public class NullSafePoint implements Point {

    private final Integer x;
    private final Integer y;

    public static NullSafePoint from(@Nonnull final Integer x, @Nonnull final Integer y) {
        return new NullSafePoint(x, y);
    }

    private NullSafePoint(@Nonnull final Integer x, @Nonnull final Integer y) {
        this.x = Preconditions.checkNotNull(x, "x should not be null");
        this.y = Preconditions.checkNotNull(y, "y should not be null");
    }

    @Nonnull
    public Integer getX() {
        return x;
    }

    @Nonnull
    public Integer getY() {
        return y;
    }
}
