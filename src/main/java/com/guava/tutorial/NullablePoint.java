package com.guava.tutorial;

import javax.annotation.Nullable;

/**
 * @author  dpersa
 */
public class NullablePoint implements Point {

    private final Integer x;
    private final Integer y;

    public static NullablePoint from(@Nullable final Integer x, @Nullable final Integer y) {
        return new NullablePoint(x, y);
    }

    private NullablePoint(@Nullable final Integer x, @Nullable final Integer y) {
        this.x = x;
        this.y = y;
    }

    @Nullable
    public Integer getX() {
        return x;
    }

    @Nullable
    public Integer getY() {
        return y;
    }
}
