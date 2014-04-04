package com.guava.tutorial.collection;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author  dpersa
 */
public class FluentIterableTest {

    @Test
    public void fluentIterableExample() {

        List<Integer> numbers =                                    //
            Lists.newArrayList(1, -1, 3, null, -3, null, 5);
        ImmutableList<String> strings =
            FluentIterable.from(numbers)                           //
                          .filter(Predicates.notNull())            //
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

    @Test
    public void collectionTransformationWithoutGuavaExample() {

        List<Integer> numbers = //
            Lists.newArrayList(1, -1, 3, null, -3, null, 5);
        List<Integer> filteredNumbers = Lists.newArrayList();
        for (Integer number : numbers) {
            if (number != null && number > 0) {
                filteredNumbers.add(number);
            }
        }

        List<String> strings = Lists.newArrayList();
        for (Integer number : filteredNumbers) {
            strings.add(number.toString());
        }

        assertThat(ImmutableList.copyOf(strings), //
            is(ImmutableList.of("1", "3", "5")));
    }

}
