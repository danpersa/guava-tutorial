package com.guava.tutorial.collection;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * @author  dpersa
 */
public class MultimapTest {

    public static final String PLAYER1 = "Dan";
    public static final String PLAYER2 = "Tina";

    @Test
    public void testMultimap() {
        final Multimap<String, Integer> pointsPerTryForPlayer = //
            ArrayListMultimap.create();
        pointsPerTryForPlayer.put(PLAYER1, 10);
        pointsPerTryForPlayer.put(PLAYER2, 11);
        pointsPerTryForPlayer.putAll(PLAYER1, ImmutableList.of(11, 12));

        assertThat(ImmutableList.copyOf(             //
                pointsPerTryForPlayer.get(PLAYER1)), //
            is(ImmutableList.of(10, 11, 12)));
    }
}