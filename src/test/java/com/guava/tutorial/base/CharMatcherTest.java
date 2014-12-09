package com.guava.tutorial.base;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * @author  dpersa
 */
public class CharMatcherTest {

    @Test
    public void charMatcherExample() {
        assertThat(                   //
            CharMatcher.anyOf("-=_")  //
            .removeFrom("_34-425=="), //
            is("34425"));
    }

    @Test
    public void gettingCharMatcherUsingPredefinedConstant() {
        CharMatcher whitespace = CharMatcher.WHITESPACE;
        CharMatcher ascii = CharMatcher.ASCII;
        CharMatcher any = CharMatcher.ANY;
    }

    @Test
    public void gettingCharMatcherUsingFactoryMethod() {
        CharMatcher.is('x');
        CharMatcher.isNot('_');
        CharMatcher.anyOf("aeiou");
        CharMatcher.anyOf("aeiou").precomputed();
        CharMatcher.inRange('a', 'z')                 //
                   .or(CharMatcher.inRange('A', 'Z')) //
                   .negate();

    }
}
