package com.groupon;

import static com.groupon.Triangle.Type.*;

public class Triangle {
    private final int biggestSide;
    private final int midSide;
    private final int smallestSide;

    public Triangle(int side1, int side2, int side3) {
        this.biggestSide = max(side1, side2, side3);
        this.smallestSide = min(side1, side2, side3);
        this.midSide = side1 + side2 + side3 - (biggestSide + smallestSide);
    }

    public Type type() {
        if (biggestSide == midSide && biggestSide == smallestSide)
            return Equilateral;

        if (biggestSide == midSide || biggestSide == smallestSide || midSide == smallestSide)
            return Isosceles;

        if (Math.pow(biggestSide, 2) == Math.pow(midSide, 2) + Math.pow(smallestSide, 2))
            return Right;

        return Regular;
    }

    private int max(int side1, int side2, int side3) {
        return Math.max(side1, Math.max(side2, side3));
    }

    private int min(int side1, int side2, int side3) {
        return Math.min(side1, Math.min(side2, side3));
    }

    public enum Type {Isosceles, Right, Regular, Equilateral}
}
