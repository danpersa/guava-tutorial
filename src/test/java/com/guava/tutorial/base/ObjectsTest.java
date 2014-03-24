package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Objects;

import com.guava.tutorial.NullablePoint;

/**
 * @author  dpersa
 */
public class ObjectsTest {

    @Test
    public void firstNonNull() {
        Integer a = Objects.firstNonNull(null, 3);
        Integer b = Objects.firstNonNull(1, 4);
        assertThat(a + b, is(4));
    }

    @Test
    public void testNeverNullWithoutGuava() {
        NullablePoint point = NullablePoint.from(null, 100);
        Integer defaultX = null; // suppose it comes from config file
        Integer x = point.getX() != null ? point.getX() : defaultX;
        assertThat(x, is(nullValue()));
    }

    @Test(expected = NullPointerException.class)
    public void testNeverNullWithGuava() {
        NullablePoint point = NullablePoint.from(null, 100);
        Integer defaultX = null; // suppose it comes from config file
        Integer x = Objects.firstNonNull(point.getX(), defaultX);
    }

}
