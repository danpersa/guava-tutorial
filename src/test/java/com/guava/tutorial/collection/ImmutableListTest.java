package com.guava.tutorial.collection;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author  dpersa
 */
public class ImmutableListTest {

    @Test
    public void immutableListExample() {
        ImmutableList<String> fruits = //
            ImmutableList.of("apple", "banana", "orange");
    }

}
