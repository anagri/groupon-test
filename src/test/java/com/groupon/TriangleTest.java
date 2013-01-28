package com.groupon;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void shouldReturnEquilateralTypeIfAllSidesEqual() {
        assertThat(new Triangle(1, 1, 1).type(), is(Triangle.Type.Equilateral));
    }

    @Test
    public void shouldReturnIsosclesIfTwoSidesEqual() {
        assertThat(new Triangle(1, 1, 2).type(), is(Triangle.Type.Isosceles));
        assertThat(new Triangle(1, 2, 1).type(), is(Triangle.Type.Isosceles));
        assertThat(new Triangle(2, 1, 1).type(), is(Triangle.Type.Isosceles));
    }
}
