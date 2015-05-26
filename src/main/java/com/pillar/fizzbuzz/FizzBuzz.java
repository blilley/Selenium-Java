package com.pillar.fizzbuzz;

public class FizzBuzz
{
    public String process(Integer input) throws Exception {
        if(input < 1)
            throw new Exception("Input cannot be less than 1");

        StringBuilder output = new StringBuilder();

        if(input % 3 == 0)
            output.append("Fizz");
        if(input % 5 == 0)
            output.append("Buzz");

        return output.length() == 0 ? String.valueOf(input) : output.toString();
    }
}
