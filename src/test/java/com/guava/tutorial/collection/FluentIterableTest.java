package com.guava.tutorial.collection;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * @author  dpersa
 */
public class FluentIterableTest {

    @Test
    public void fluentIterableExample() {

        ImmutableList<Integer> numbers = ImmutableList.of(1, -1, 3, -3, 5);
        ImmutableList<String> strings =
            FluentIterable.from(numbers)                           //
                          .filter(new Predicate<Integer>() {
                                  public boolean apply(final Integer number) {
                                      return number > 0;
                                  }
                              })                                   //
                          .transform(Functions.toStringFunction()) //
                          .limit(10)                               //
                          .toList();
        assertThat(strings, is(ImmutableList.of("1", "3", "5")));
    }

}
