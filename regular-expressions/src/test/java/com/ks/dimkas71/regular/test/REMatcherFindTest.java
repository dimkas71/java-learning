package com.ks.dimkas71.regular.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class REMatcherFindTest {

    private String expression;
    private Double leftValue;
    private Double rightValue;

    private static Pattern pattern;

    @BeforeClass
    public static void setUp() {
        pattern = Pattern.compile("([-0-9]+,?)([0-9]+)");
    }

    public REMatcherFindTest(String expression, Double leftValue, Double rightValue) {

        this.expression = expression;
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"(44, 25)", 44d, 25d}
        });
    }

    @Test
    public void testFind() {
        Matcher matcher = pattern.matcher(expression);

        Double left = 0.0d;
        Double right = 0.0d;

        while (matcher.find()) {
            left = Double.valueOf(matcher.group(0));
            right = Double.valueOf(matcher.group(1));
            //break;
        }

        //assertThat(left, is(equalTo(leftValue)));
        assertThat(right, is(equalTo(rightValue)));

    }



}
