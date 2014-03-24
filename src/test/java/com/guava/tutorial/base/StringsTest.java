package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * @author  dpersa
 */
public class StringsTest {

    @Test
    public void nullInStrings() {
        String res = Strings.emptyToNull(""); // res will be null
        res = Strings.nullToEmpty(res);       // res will be ""

        boolean isIt = false;
        if (res == null || "".equals(res)) {
            isIt = true;
        }

        boolean isItWithG = Strings.isNullOrEmpty(res);
        assertThat(isIt, is(true));
        assertThat(isItWithG, is(true));
    }
}
