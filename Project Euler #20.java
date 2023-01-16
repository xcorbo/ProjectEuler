// Project Euler Problem #20 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;

import java.math.BigInteger;

public final class Main {

    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int testNum = 100;
        BigInteger factorialResult = new BigInteger("1");
        int sumResult = 0;

        // Get Factorial result
        for (int i = 1; i <= testNum; i++){
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }

        // Make an array with the results and loop through it to sum
        char[] resultArr = factorialResult.toString().toCharArray();
        for (int i = 0; i < resultArr.length; i++){
            sumResult += Integer.parseInt(String.valueOf(resultArr[i]));
        }
        
        // Print Result
        System.out.println(sumResult);
        
        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
