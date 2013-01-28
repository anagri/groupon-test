package com.groupon;

import org.junit.Test;

import static com.groupon.Triangle.Type.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void shouldReturnEquilateralTypeIfAllSidesEqual() {
        assertThat(new Triangle(1, 1, 1).type(), is(Equilateral));
    }

    @Test
    public void shouldReturnIsoscelesIfTwoSidesEqual() {
        assertThat(new Triangle(1, 1, 2).type(), is(Isosceles));
        assertThat(new Triangle(1, 2, 1).type(), is(Isosceles));
        assertThat(new Triangle(2, 1, 1).type(), is(Isosceles));
    }

    @Test
    public void shouldReturnRightAngleIfSatisfiesPythagorasTheorem() {
        assertThat(new Triangle(3, 4, 5).type(), is(Right));
        assertThat(new Triangle(4, 5, 3).type(), is(Right));
        assertThat(new Triangle(5, 4, 3).type(), is(Right));
    }

    @Test
    public void shouldReturnRegularTypeIfNotOfTheKnownThreeTypes() {
        assertThat(new Triangle(1, 2, 3).type(), is(Regular));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTriangleConstructedWithSideAs0() {
        new Triangle(0, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTriangleConstructedWithSideAsNegative() {
        new Triangle(-1, 1, 1);
    }
}
