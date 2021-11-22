package com.strategy;

public class Rental {

    private Movie movie;
    private int days;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.days = daysRented;
    }

    String print() {
        return String.format("\t%s\t%s\n", movie.getTitle(), getAmount());
    }

    int getFrequentRenterPoints() {
        return isEligibleForBonus() ? 2 : 1;
    }

    boolean isEligibleForBonus() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE) && days > 1;
    }

    double getAmount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (days > 2)
                    thisAmount += (days - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += days * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (days > 3)
                    thisAmount += (days - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}