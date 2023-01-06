// Project Euler Problem #16 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public final class Main {

    public static void main(String[] args) {
    // Init timer
    long startTime = System.nanoTime();

    // Declarations
    int power = 1000;
    BigInteger base = new BigInteger(String.valueOf(2));
    int sumOfAllFears = 0;

    // Get the Power Number into a string
    String resultAsString = String.valueOf(base.pow(power));

    // Loop through reach element of the string and sum it
        for (int i = 0; i < resultAsString.length(); i++){
           sumOfAllFears += Integer.parseInt(String.valueOf(resultAsString.charAt(i)));
    }

    // Print the Answer
        System.out.println(sumOfAllFears);

    // The end of times
    long endTime = System.nanoTime();
    long totalTime = (endTime - startTime) / 1000000;
    System.out.println(totalTime + "ms");
    }
}
