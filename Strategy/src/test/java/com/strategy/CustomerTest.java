package com.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {
	private static final String GOLD_PATH = "data/";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
	private Movie ran = new Movie("Ran", Movie.REGULAR);
	private Movie la = new Movie("LA Confidential", Movie.NEW_RELEASE);
	private Movie trek = new Movie("Star Trek 13.2", Movie.NEW_RELEASE);
	private Movie wallace = new Movie("Wallace and Gromit", Movie.CHILDRENS);

    @BeforeEach
    public void setUpData(){
       dinsdale.addRental(new Rental(python, 3));
       dinsdale.addRental(new Rental (ran, 1));
       dinsdale.addRental(new Rental (la, 2));
       dinsdale.addRental(new Rental (trek, 1));
       dinsdale.addRental(new Rental (wallace, 6));
   }

    @Test
    public void shouldOutputEmptyStatement() throws Exception {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty");
    }

    @Test
    public void shouldOutputStatement() throws Exception {
        verifyOutput(dinsdale.statement(), "output1");
    }

    @Test
    public void shouldOutputChangedStatement() throws Exception {
        la.setPriceCode(Movie.REGULAR);
        verifyOutput(dinsdale.statement(), "outputChange");
    }

    protected void verifyOutput(String actualValue, String fileName) throws IOException{
        String filePath = getClass().getClassLoader().getResource(GOLD_PATH + fileName).getPath();
        BufferedReader file = new BufferedReader (new FileReader (filePath));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals(actualStream.readLine(), thisFileLine, "in file: " + fileName);
        }
    }

}
