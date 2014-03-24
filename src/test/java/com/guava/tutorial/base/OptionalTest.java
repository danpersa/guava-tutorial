package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * @author  dpersa
 */
public class OptionalTest {

    @Test
    public void optionalExample() {
        Optional<Integer> possible = Optional.of(3);
        assertThat(possible.isPresent(), is(true));
        assertThat(possible.get(), is(3));

        Integer nullValue = null;
        assertThat(Optional.fromNullable(nullValue).or(10), is(10));
    }
}
