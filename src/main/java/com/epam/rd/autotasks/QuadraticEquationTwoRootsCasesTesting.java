package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;

    private String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, -5, 6, "3.0 2.0"},
                {1, 7, 10, "-2.0 -5.0"},
                {2, -3, -2, "2.0 -0.5"},
                {2, 3, -2, "0.5 -2.0"}
        });
    }

    @Test
    public void testTwoRootsCase() {
        String res = quadraticEquation.solve(a, b, c);

        List<Double> expectedRoots = Arrays.stream(expected.split(" "))
                .map(Double::parseDouble)
                .sorted()
                .collect(Collectors.toList());

        List<Double> resultRoots = new ArrayList<>();
        if (!res.equals("no roots")) {
            resultRoots = Arrays.stream(res.split(" "))
                    .map(Double::parseDouble)
                    .sorted()
                    .collect(Collectors.toList());
        }

        assertEquals(expectedRoots, resultRoots);
    }
}
