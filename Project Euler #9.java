// Project Euler Problem #9 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;

public final class Main {

    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1000;

        // Code
        for (int a = 1; a < limit; a++){
            for (int b = a + 1; b < limit; b++){
                int cSQ = (a * a) + (b * b);
                double c = Math.pow(cSQ, 0.5);

                if ( a + b + c == limit){
                    System.out.println(a * b * (int) c);
                }
            }
        }

        // Printing the Results
        
        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
