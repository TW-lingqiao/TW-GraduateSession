package com.adapter.service.example_2;

public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getRadius() {
        return Math.sqrt(Math.pow((width / 2), 2) * 2);
    }
}
