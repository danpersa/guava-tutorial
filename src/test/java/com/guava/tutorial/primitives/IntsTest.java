package com.guava.tutorial.primitives;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.primitives.Ints;

/**
 * @author  dpersa
 */
public class IntsTest {

    @Test(expected = NullPointerException.class)
    public void tryParseNullTest() {
        Ints.tryParse(null);
    }

    @Test
    public void tryParseEmptyTest() {
        assertThat(Ints.tryParse(""), is(nullValue()));
    }

}
