package com.guava.tutorial.collection;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;

/**
 * @author  dpersa
 */
public class BiMapTest {

    @Test
    public void testBiMap() {

        BiMap<String, Integer> nameToNumberOfDonuts = //
            HashBiMap.create();
        nameToNumberOfDonuts.put("Dan", 2);
        nameToNumberOfDonuts.put("Alex", 5);

        final BiMap<Integer, String> numberOfDonutsToName = //
            nameToNumberOfDonuts.inverse();
        assertThat(numberOfDonutsToName.get(5), is("Alex"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBiMapFailure() {

        BiMap<String, Integer> nameToNumberOfDonuts = //
            HashBiMap.create();
        nameToNumberOfDonuts.put("Dan", 2);
        nameToNumberOfDonuts.put("Alex", 5);
        nameToNumberOfDonuts.forcePut("Sean", 5);

        assertThat(ImmutableSet.copyOf(nameToNumberOfDonuts.values()), //
            is(ImmutableSet.of(2, 5)));

        nameToNumberOfDonuts.put("John", 5); // throws IllegalArgumentException
    }
}
