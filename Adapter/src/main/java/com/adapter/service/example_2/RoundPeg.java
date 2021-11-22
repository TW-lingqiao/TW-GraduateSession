package com.adapter.service.example_2;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoundPeg {
    private double radius;

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
