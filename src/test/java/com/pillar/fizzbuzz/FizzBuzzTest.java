package com.pillar.fizzbuzz;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FizzBuzzTest
{
    @Test
    public void process_WhenNotDivisibleByFactors_ReturnsValue() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.process(1), is("1"));
        assertThat(fizzBuzz.process(2), is("2"));
    }

    @Test
    public void process_WhenDivisibleBy3_ReturnsFizz() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.process(3), is("Fizz"));
        assertThat(fizzBuzz.process(6), is("Fizz"));
        assertThat(fizzBuzz.process(9), is("Fizz"));
    }

    @Test
    public void process_WhenDivisibleBy5_ReturnsBuzz() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.process(5), is("Buzz"));
        assertThat(fizzBuzz.process(10), is("Buzz"));
        assertThat(fizzBuzz.process(20), is("Buzz"));
    }

    @Test
    public void process_WhenDivisibleBy3And5_ReturnsFizzBuzz() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.process(15), is("FizzBuzz"));
        assertThat(fizzBuzz.process(30), is("FizzBuzz"));
        assertThat(fizzBuzz.process(45), is("FizzBuzz"));
    }

}