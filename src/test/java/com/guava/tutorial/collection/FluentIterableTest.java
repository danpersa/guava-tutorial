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
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author  dpersa
 */
public class FluentIterableTest {

    private static final Predicate<Integer> GREATER_THAN_ZERO_PREDICATE = //
        new Predicate<Integer>() {
            public boolean apply(final Integer number) {
                return number > 0;
            }
        };

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

        final List<String> limit = strings.subList(0, 2);

        assertThat(ImmutableList.copyOf(limit), //
            is(ImmutableList.of("1", "3")));
    }

    @Test
    public void iterableExample() {
        List<Integer> numbers = //
            Lists.newArrayList(1, -1, 3, null, -3, null, 5);

        final Iterable<Integer> notNull = //
            Iterables.filter(numbers, Predicates.notNull());

        final Iterable<Integer> greaterThanZero = //
            Iterables.filter(notNull, GREATER_THAN_ZERO_PREDICATE);

        final Iterable<String> strings = //
            Iterables.transform(greaterThanZero, Functions.toStringFunction());

        final Iterable<String> limit = Iterables.limit(strings, 2);

        assertThat(ImmutableList.copyOf(limit), //
            is(ImmutableList.of("1", "3")));
    }

    @Test
    public void iterableInlinedExample() {
        List<Integer> numbers = //
            Lists.newArrayList(1, -1, 3, null, -3, null, 5);

        final Iterable<String> strings = Iterables.transform(        //
                Iterables.filter(                                    //
                    Iterables.filter(numbers, Predicates.notNull()), //
                    GREATER_THAN_ZERO_PREDICATE),                    //
                Functions.toStringFunction());

        assertThat(ImmutableList.copyOf(Iterables.limit(strings, 2)), //
            is(ImmutableList.of("1", "3")));

    }

    @Test
    public void fluentIterableExample() {

        List<Integer> numbers =                                    //
            Lists.newArrayList(1, -1, 3, null, -3, null, 5);
        ImmutableList<String> strings =
            FluentIterable.from(numbers)                           //
                          .filter(Predicates.notNull())            //
                          .filter(GREATER_THAN_ZERO_PREDICATE)     //
                          .transform(Functions.toStringFunction()) //
                          .limit(2)                                //
                          .toList();
        assertThat(strings, is(ImmutableList.of("1", "3")));
    }
}
