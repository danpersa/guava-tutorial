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

    @Test
    public void joinWithoutGuavaExample() {
        Object[] parts = {"abc", null, 123};
        StringBuilder join = new StringBuilder();
        for (Object part : parts) {
            if (part != null) {
                join.append(part);
                if (!part.equals(parts[parts.length - 1])) {
                    join.append("-");
                }
            }
        }

        assertThat(join.toString(), is("abc-123"));
    }
}
