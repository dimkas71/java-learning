package com.ks.dimkas71.regular.test;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class REMatchesTest {

    private Pattern pattern;
    private Matcher matcher;

    private String input;
    private boolean expected;

    @NotNull
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"foofoo", true},
                {"bar", false},
                {"foofoofoo", true},
                {"foo foo  foo", true},
                {"  foo", true}

        });
    }

    public REMatchesTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testMatches() {

        pattern = Pattern.compile("[\\s+foo\\s+]+");
        matcher = pattern.matcher(input);
        assertThat(matcher.matches(), is(equalTo(expected)));



    }

}
