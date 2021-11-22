package com.strategy;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> list = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        list.add(arg);
    }

    public String statement() {
        double total = 0;
        int pts = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental r : list) {
            total += r.getAmount();
            pts += r.getFrequentRenterPoints();
            result.append(r.print());
        }

        result.append(footer(total, pts));
        return result.toString();
    }

    private String footer(double totalAmount, int pts) {
        return String.format("Amount owed is %s\nYou earned %d frequent renter points", totalAmount, pts);
    }
}
