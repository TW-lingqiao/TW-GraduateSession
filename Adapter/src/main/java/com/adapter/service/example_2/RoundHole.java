package com.adapter.service.example_2;

public class RoundHole {
    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }

    //重构，第一种解决的方式
    public boolean fits(SquarePeg peg){
        return this.getRadius() >= peg.getRadius();
    }
}
