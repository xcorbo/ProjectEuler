// Project Euler Problem #28 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1001;
        long sum = 1;
        int start = 1;
        int dif = 2;

        // Code
        for (int i = 3; i <= limit; i+=2){
            for (int j = 1; j < 5; j++){
                start += dif;
                sum += start;
            }
            dif += 2;
        }

        //  Printing the Results
        System.out.println(sum);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
