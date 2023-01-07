// Project Euler Problem #5 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initial defines
        int i = 20;

        // I'm and idiot, please don't do this, be a better programmer than me.
        // But basically checks for all divisors at the same time if it is true from 1 to 20 and adds to sum only if true
        while (true){
            if (
                            (i % 1 == 0) &&
                            (i % 2 == 0) &&
                            (i % 3 == 0) &&
                            (i % 4 == 0) &&
                            (i % 5 == 0) &&
                            (i % 6 == 0) &&
                            (i % 7 == 0) &&
                            (i % 8 == 0) &&
                            (i % 9 == 0) &&
                            (i % 10 == 0) &&
                            (i % 11 == 0) &&
                            (i % 12 == 0) &&
                            (i % 13 == 0) &&
                            (i % 14 == 0) &&
                            (i % 15 == 0) &&
                            (i % 16 == 0) &&
                            (i % 17 == 0) &&
                            (i % 18 == 0) &&
                            (i % 19 == 0) &&
                            (i % 20 == 0)
            )
            {
                break;
            }
            i+=20;
        }

        System.out.println(i);
        // End of Times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
