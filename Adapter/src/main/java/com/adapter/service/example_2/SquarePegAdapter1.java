package com.adapter.service.example_2;

public class SquarePegAdapter1 {
    public final RoundPeg roundPeg;

    public SquarePegAdapter1(SquarePeg squarePeg) {
        this.roundPeg = new RoundPeg(squarePeg.getRadius());
    }
}
