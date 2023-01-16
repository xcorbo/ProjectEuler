// Project Euler Problem #25 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;

import java.math.BigInteger;

public final class Main {

    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        BigInteger firstInt = BigInteger.ZERO;
        BigInteger secondInt = BigInteger.ONE;
        BigInteger thirdInt = BigInteger.ZERO;
        int searchNum = 1;
        int limit = 1000;

        // Spit out fibonacci and look for string length of limit when met, break loop.
        while (searchNum > 0){
            thirdInt = firstInt.add(secondInt);
            if (thirdInt.toString().length() == limit){
                int fNum = searchNum + 1;
                System.out.println("The F Number is:" + fNum);
                break;
            } else {
                firstInt = secondInt;
                secondInt = thirdInt;
                searchNum++;
            }
        }

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
