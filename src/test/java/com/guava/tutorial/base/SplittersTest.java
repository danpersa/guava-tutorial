package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.hasItems;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * @author  dpersa
 */
public class SplittersTest {

    @Test
    public void splitterExample() {
        String sequence = "  abc - 123  - ";
        assertThat(Splitter.on("-") //
            .trimResults()      //
            .omitEmptyStrings() //
            .split(sequence),   //
            hasItems("abc", "123"));
    }

    @Test
    public void splitWithoutGuava() {
        String sequence = "  abc - 123 ";
        List<String> splitList = Lists.newArrayList();
        if (sequence.contains("-")) {
            String[] parts = sequence.split("-");
            for (String part : parts) {
                part = part.trim();
                if (!part.isEmpty()) {
                    splitList.add(part);
                }
            }
        } else {
            throw new IllegalArgumentException("String " + sequence + " does not contain -");
        }

        assertThat(splitList, hasItems("abc", "123"));
    }
}
