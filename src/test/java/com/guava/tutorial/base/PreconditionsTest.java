package com.guava.tutorial.base;

import org.junit.Test;

import com.google.common.base.Preconditions;

import com.guava.tutorial.NullablePoint;
import com.guava.tutorial.Point;

/**
 * @author  dpersa
 */
public class PreconditionsTest {

    private static final Point point = NullablePoint.from(null, 10);

    @Test(expected = NullPointerException.class)
    public void checkNotNullExample() {
        Preconditions.checkNotNull(point.getX());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkArgumentExample() {
        Preconditions.checkArgument(point.getY() == 12);
    }
}
