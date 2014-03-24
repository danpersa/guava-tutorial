package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * @author  dpersa
 */
public class JoinerTest {

    @Test
    public void joinerExample() {
        assertThat(Joiner.on("-")    //
            .skipNulls()             //
            .join("abc", null, 123), //
            is("abc-123"));
    }
}
