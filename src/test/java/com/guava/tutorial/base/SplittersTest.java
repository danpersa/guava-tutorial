package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.hasItems;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * @author  dpersa
 */
public class SplittersTest {

    @Test
    public void splitterExample() {
        assertThat(Splitter.on("-") //
            .trimResults()          //
            .omitEmptyStrings()     //
            .split("  abc - 123 "), //
            hasItems("abc", "123"));
    }
}
